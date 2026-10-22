# StepOS AiLauncher SLA（端侧快车道）本地执行链路完整分析报告

> 分析对象：
> - AiLauncher 反编译源：`analysis/decompiled/AiLauncher/sources/com/stepos/ailauncher/sla/`（下称 `sla/`）及 `chat/view/sla/`
> - AIEngine 反编译源：`analysis/decompiled/AIEngine/sources/com/stepos/core/ability/sla/`
> - ability（CommonAbility.apk）交叉验证：`analysis/decompiled/ability/sources/com/stepos/ability/`
> - 关键方法体（旧 jadx 输出 "Method dump skipped"）已用 jadx 1.5.3 `--show-bad-code` 重反编译 `apks/AiLauncher.apk` 恢复（临时产物 `/tmp/sla_jadx/`，下文引用时标注）。
>
> 已知结论（不再重验）：SlaGate 竞速 bufferMs=1000ms、Winner 状态机、q0 胜出后 awaitLedger、offlineLedgerBypass 在 `sla/u.java`（C3474c）；`sla/v.java` lockScreenAllowed 58 项白名单。

---

## 0. 全链路总览（文本输入 → 本地执行 → 聊天 UI）

```
用户输入(文本)
  └─ SendPipeline.slaArbiter (chatcore/send/j 接口) ── d() 判定是否竞速
       └─ e(ctx, cb) 启动竞速
            ├─ [cloud-first 在线直上云] P0(): C3474c.cloudFirstWhenOnline && 在网 → cb.a(ctx) 放行
            ├─ [voice] SlaVoiceBridge.m() 匹配语音先发的 Race（gate.B 已建）
            └─ [text] gate.N(text, traceId, proceed) ── SlaGate.Race(gate, proceed, sessionId, traceId, localDispatch=C3474c.c())
                 ├─ Race.startTimer: bufferMs=1000ms 内云端先回 → BACKEND 胜出
                 └─ starter → SlaRouter.I() ──DeepBinder──> AIEngine ISla.recognize(token, SlaInput.text, args{session_id,trace_id,task_priority=2,executeAtomic=false}, listener)
                      └─ AIEngine SlaAbility: 端侧模型推理，输出原始文法 "<func>\nkey:value..."
                           └─ (executeAtomic=false → 不在 AIEngine 侧执行) listener.onSlaOutput(raw)
                 └─ Race.listener.onSlaOutput(raw)  [sla/ SlaGate$Race$listener$1]
                      ├─ x.b(raw) 解析多动作 → v.a(function,fallback,locked) 逐个 verdict
                      │    ├─ 锁屏&&非白名单(280002) → winner=SLA, gate.E() 缓存 decision, callbacks.h() → 调起解锁界面等待重放
                      │    ├─ 全部不可执行 → Race.S(code) → BACKEND 胜出放行云端
                      │    └─ 有可执行 → Race.q0(decision,count,awaitLedger=true) SLA 胜出（吞掉原发送）
                      └─ launch onSlaOutput$5: gate.F(functions) 台账预检(AgentServiceClient.L → AgentSafetyCenter)
                           ├─ 台账拒绝 → Race.h0() routeToBackend 回云
                           ├─ 台账不可用&&离线&&无红线 → ledgerBypass 放行本地执行
                           └─ 逐动作 SlaAtomicDispatcher.k(function,text,params,extras,traceId,toolCallId)
                                ├─ t.INSTANCE.c() INSTALL_GUARD: appstore_install_app 已装 → 伪造成功结果
                                └─ AgentServiceClient.h0(ToolTask) ──Binder──> com.stepos.ability AgentService.submitTask
                                     └─ TaskScheduler → ToolTaskExecutor → CallToolImpl → 4 handler 之一
                                          appFunctions / jetpackAppFunctions → android.app.appfunctions.AppFunctionManager.executeAppFunction
                                          （目标系统应用 Settings/Mms/Dialer/Clock 注册的 AppFunction 真正执行）
                                └─ ITaskListener.onTaskEvent(task) 回调 → CompletableFuture 完成 → DispatchResult
                      └─ Race.R(Race.N(outcomes)) 聚合 SlaResult → callbacks.f(traceId,query,result,routeToBackend)
                           └─ SlaChatController.f(): resultJson → display_text/appUI 卡片 → u0() 写 ChatMessage 渲染
                                └─ k.b(ctx, LocalExecResult(replyText, slaScene, replyMessageId)) 通知 SendPipeline 本轮被本地执行消费
```

---

## 1. SlaChatController —— SendPipeline 的 slaArbiter（j 接口实现）

文件：`chat/view/sla/SlaChatController.java`（105KB；`class SlaChatController implements SlaGate.d, com.stepos.agentframework.chatcore.send.j`）
j 接口：`sources/com/stepos/agentframework/chatcore/send/j.java`（`boolean d(SendContext) / void e(SendContext, k)`）

### 1.1 d(ctx) —— 是否参与竞速（精确条件，已从 /tmp/sla_jadx 恢复）

```kotlin
// SlaChatController.java L1577（重反编译恢复）
override fun d(ctx: SendContext): Boolean {
    if (ctx.agentId != null && bff.j.b(ctx.agentId)) return false   // (1) agentId 命中 agentbus bff 排除名单（外部 agent 等）
    val text = ctx.text ?: ""
    if (text.length > 480) { log "shouldArbitrate skip: textLen>480"; return false }  // (2) MAX_SLA_QUERY_CHARS=480
    val files = ctx.f()                                              // 用户附件
    if (files.any { !it.silent }) { log "skip: user upload size=${files.size}"; return false }  // (3) 有非静默附件
    return text.isNotEmpty()                                         // (4) 纯文本非空
}
```

**注意：d() 里没有任何 SLA 总开关判断。** 总开关（feature flag + 模型可用性）在 `gate.N()` 内部做（见下），d() 只做"这轮消息形态适不适合竞速"的粗筛：排除特定 agentId、>480 字、带附件。会话状态（新会话/旧会话）不在 d() 判断——会话准备（`ensureSessionForSla`/`startSessionPrepare`/`awaitSessionPrepared`）在 e() 之后异步进行。

### 1.2 e(ctx, cb) —— 启动竞速（如何调 gate.N()/B()）

```kotlin
// SlaChatController.java L1631（恢复）
override fun e(ctx: SendContext, cb: k) {
    pendingArbitrateCtx = ctx; pendingArbitrateCb = cb
    Y0(K.R1(text, 50), ctx.slaAnchor)                 // 结算会话锚点
    sessionHandler.H3(d0(), false)
    pendingUserMessageId = ctx.ids.messageId
    val voice = p.a(ctx.d(), ctx.g())                 // meta 标记是否语音轮
    val traceId = ctx.d()["trace_id"]?.takeIf{it.isNotEmpty()} ?: gate.M()   // gate.M()=traceIdFactory 生成
    val ctx2 = ctx.copy(meta = ctx.d() + ("trace_id" to traceId))
    if (P0()) {                                       // cloudFirstWhenOnline 且在网
        cloudFirstPending = CloudFirstPending(ctx2, text.trim(), messageId, traceId)
        T0(a.Expand(traceId,"cloudFirst",true)); W0(true)
        pendingArbitrateCtx=null; pendingArbitrateCb=null
        cb.a(ctx2); return                            // 直接放行云端，不竞速
    }
    val routeToBackend = { R(traceId, cb, ctx2) }     // 放行云端的闭包
    if (voice) {
        SlaVoiceBridge.C(traceId, messageId)          // 语音桥登记
        when (SlaVoiceBridge.m(traceId, text, routeToBackend, ::S /*settled*/, ::T /*failed*/)) {
            NO_MATCH_ROUND -> routeToBackend()        // 无匹配语音轮 → 放行
            /* 其余分支：桥上的 Race 属于同一 gate 则什么都不做（等 Race 结果），否则走 b0()/t0() 兜底 */
        }
    } else {
        E5.b.a(traceId, "text_sla.start", "文本SLA调用开始")
        gate.N(text, traceId, routeToBackend)         // ★ 文本路径：SlaGate.N = onTextSend 开一场 Race
    }
    if (pendingArbitrateCb != null) V(15000L)         // armSendTimeout 15s（SEND_TIMEOUT_MS）
}
```

- **gate.N(query, traceId, proceed)**（SlaGate.java L1731，恢复）：
```kotlin
fun N(query: String, traceId: String, proceed: () -> Unit) {           // onTextSend
    if (query.isBlank() || !SlaRouter.INSTANCE.v(context)) {           // ★ 总开关在这里：
        log "pass-through (blank/unavailable) -> 走原通路"             //   C3474c.enabled && AlgorithmClients.getSla().isSupported()
        E5.a.a("[SLA][traceId=$traceId] bypass channel=text reason=...")//   不满足则 proceed() 直接放行云端
        proceed(); return
    }
    T()                                              // 清理在途竞速
    if (Companion.d()) Companion.c()                 // 清除过期 lockMiss 缓存（新一轮顶替）
    val sessionId = H()                              // sessionIdProvider
    G.INSTANCE.g(sessionId, traceId, "text", L()/*online/offline*/, K()/*locked*/, G(sessionId)/*round+1*/, C3475d.b()/*entrySource*/)  // sla_start 埋点
    val localDispatch = C3474c.INSTANCE.c()          // ★ localDispatch 默认 true
    val race = Race(this, proceed, sessionId, traceId, localDispatch)
    race.J(query)                                     // 绑定 query
    race.j0 { listener -> SlaRouter.I(context, query, sessionId, traceId, listener, localDispatch) }  // starter
}
```
- **gate.B(traceId, audioStart)**（SlaGate.java L1467，恢复）＝ `beginVoiceRace`：同样先查 `SlaRouter.v()`，然后 `Race(gate, proceed=null, sessionId, traceId, localDispatch)`（语音轮 proceed 为空、query 待 ASR 绑定），starter 调 `audioStart(listener, localDispatch, query)`（由 SlaVoiceBridge 提供，走 `SlaRouter.H(context, pcm, ...)` 音频识别），返回 `SlaGate.e` 句柄给语音桥。SlaChatController.e() 的语音分支不直接调 B()——B() 在语音识别起点（SlaVoiceBridge.java L676/L730）被调用，e() 通过 `SlaVoiceBridge.m()` 把"文本发送轮"嫁接到已存在的语音 Race 上，实现 ASR 与竞速并行。

---

## 2. SlaRouter —— 连接 AIEngine 识别器

文件：`sla/SlaRouter.java`

### 2.1 IPC：DeepBinder（非裸 Binder/ContentProvider 直调）

```kotlin
// AlgorithmClient.java L58
val DEEP_BINDER = ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider")
```
AiLauncher → AIEngine 的算法调用走 **StepOS DeepBinder 框架**（`com.stepos.deepbinder.client.DeepBinderClient` + `com.stepos.core.deepbinder.IAIEngineDeepBinderService`，见 `sources/com/stepos/aiengine/client/AbilityServiceClient.java`）。`AlgorithmClients.INSTANCE.getSla()` 返回 `AlgorithmClient<ISla>`；`loadAlgorithm(context)` 通过 DeepBinder 取得 AIEngine 进程内 `SlaAbility` 的 **ISla binder 代理**。

### 2.2 ISla 接口与 recognize 输入输出

`sources/com/stepos/aiengine/algorithm/sla/ISla.java`：
```kotlin
interface ISla {
    fun recognize(token: AlgorithmToken, input: SlaInput, args: Bundle?, listener: SlaListener): Int   // 0=受理
    fun recognize(token: AlgorithmToken, audio: SlaAudioInput, listener: SlaListener): Int
    fun cancel(identity: Long): Boolean
}
```
SlaRouter.G()（核心，SlaRouter.java L278）：
```kotlin
fun G(context, input: SlaInput, sessionId, traceId, listener, localDispatch): SlaRouter.a? {
    if (!n(context)) return null                     // AIEngine 未就绪（无 CTA 权限/增强服务被关）→ 放弃
    val sla = AlgorithmClient.loadAlgorithm$default(AlgorithmClients.getSla(), context) ?: return null
    J(context)                                       // 缓存 modelVersion (IAlgorithmProperties.CURRENT_MODEL)
    val token = AlgorithmToken.submit()
    Bundle().apply {
        putString("session_id", sessionId); putString("trace_id", traceId)
        putInt("task_priority", 2)                   // TASK_PRIORITY=2
        if (localDispatch) putBoolean("executeAtomic", false)   // ★ KEY_EXECUTE_ATOMIC：通知 AIEngine 只识别不执行
    }.let { iSla.recognize(token, input, it, listener) }        // 返回 0 → 包装为 SlaRouter.a(sla, identity) 可 cancel
}
// I(text)/H(pcm) 分别封装 SlaInput.text(text) / SlaInput.audioFromBytes(pcm)
```

### 2.3 SlaDecision 结构（Parcelable，AIEngine→Launcher 回传）

`SlaDecision(function: String?, text: String, params: Map<String,String>, priority: String?, confidence: Float, alternatives: List<SlaAlternative>, rejectReason: SlaRejectReason?)`；`SlaRejectReason ∈ {OUT_OF_DOMAIN, LOW_CONFIDENCE, NO_MATCH, TIMEOUT}`。识别输出文法（AIEngine `SlaAbility.parseDecisionText` 与 Launcher `sla/x.java` 同构）：`<function>\nkey:value\nkey:value`（`<`…`>` 内为函数名，其余行按首个 `:` 切 k-v；无 `<...>` → OUT_OF_DOMAIN）。

### 2.4 其他要点
- `v(context)`：`C3474c.b() && AlgorithmClients.getSla().isSupported(context)` —— SLA 可用性总开关。
- `S(context)` warmUp：feature flag 开 && 距上次 ≥5000ms（WARM_UP_MIN_INTERVAL_MS）且 CAS 成功 → 协程 `SlaRouter$warmUp$1`：`isSupported → loadAlgorithm（预载模型）→ J()（读 modelVersion）`。
- 引导修复：`n()→t()→u()`（CTA 权限 + `OtaServiceClient.queryPrecheckEnv()` 的 envError==5022=GATE_ERROR_SERVICE_DISABLED 判增强服务被关），弹 `ConfirmUiRequest(serviceDisabled)`/跳 `com.stepos.aiengine.settings.EnhancedServiceRedirectActivity` 或 `com.android.settings.SubSettings + StepOSEnhancedServiceFragment`。
- 错误码：`SLA_NO_VALID_ACTION=280001, SLA_SCREEN_LOCKED=280002`。

---

## 3. SlaAtomicDispatcher —— 本地执行核心（重点）

文件：`sla/SlaAtomicDispatcher.java`（单例 `INSTANCE`；EXECUTOR_ID=`"stepos-ability"`；TIMEOUT_MS=30000；LATE_RETENTION_MS=60000；权限 `com.stepos.ability.permission.ACCESS_AGENT_SERVICE`）

### 3.1 结论先行：**没有任何 per-function switch/映射表**

Dispatcher 对 58/60 个白名单函数**完全一视同仁**：把 `function` 名 + `params` JSON 原样作为"ToolTask"提交给 ability 进程的 AgentService，由 ability 侧按名字解析执行。唯一的本地分支是 `t.java` 的"已安装应用拦截守卫"（仅 `appstore_install_app`）。

### 3.2 k() 完整逻辑（从 /tmp/sla_jadx/SlaAtomicDispatcher.java L279 恢复）

```kotlin
fun k(function: String, text: String, params: Map<String,String>,
      extras: Map<String,String>?, traceId: String, toolCallId: String): DispatchResult {
    val t0 = SystemClock.elapsedRealtime()
    // ① 权限检查（fail-open！见 §3.5 安全问题）
    if (!n()) return DispatchResult(UNAVAILABLE, 230001, "missing permission ACCESS_AGENT_SERVICE")  // → 上层转云端
    // ② 本地拦截守卫（仅 appstore_install_app 已安装时短路）
    t.INSTANCE.c(function, params, toolCallId, t0)?.let { return it }
    // ③ 初始化并注册 ITaskListener
    if (!m()) return DispatchResult(UNAVAILABLE, 100007, "AgentServiceClient not initialized")
    // ④ 提交 ToolTask
    val paramsJson = u(params)                       // Map → JSONObject.toString()
    val future = CompletableFuture<DispatchResult>()
    pending[toolCallId] = future; v(toolCallId)      // 60s 后清理 late-arrival
    AgentServiceClient.f22085a.h0(sdk.t(             // com.stepos.ability.sdk.client.t = ToolTask 配置
        name       = function,                       // ★ 函数名原样透传
        toolcallId = toolCallId,                     // "sla-"+UUID.randomUUID()（s() 生成）
        params     = paramsJson,                     // ★ 参数 JSON 原样透传
        abilityId  = null,
        str2       = null,
        commonConfig = CommonConfig(
            taskId  = toolCallId,
            taskUiInfo = TaskUiInfo("SLA: $function", "AIEngine SLA dispatch", text),  // 通知/浮层 UI 文案
            priority = 2, condition = null,
            extra = g(extras, traceId)               // Bundle{handle_input_schema=true, trace_id?, session_id?}
        )))
    // ⑤ 阻塞等待结果（结果由 taskListener.onTaskEvent 异步 complete future）
    return try {
        future.get(30_000, MILLISECONDS).copy(elapsedMs = now-t0)      // TIMEOUT_MS=30000
    } catch (e: TimeoutException) {
        DispatchResult(FAILED, -101, "atomic dispatch timeout after 30000ms")   // 迟到结果 60s 内到达仅记日志
    } catch (e: Throwable) { DispatchResult(FAILED, 100000, e.message) }
}
```

结果回调（同文件 taskListener，`ITaskListener.Stub`）：
```kotlin
onTaskEvent(task: Task) {                       // Binder 回调（ability → launcher）
    if (task.taskId !in pending) return
    val dr = r(task)                            // COMPLETED→SUCCESS(resultJson=h(task)), FAILED→220001, CANCELLED/REMOVED→-100
    if (pending[task.taskId]?.complete(dr) == true) pending.remove(task.taskId)
}
onToolCallEvent(event) { /* 仅缓存序列化后的 ToolCallEvent 供 resultJson 汇总 */ }
// h(task) = {"task": <反射序列化 Task 全字段>, "toolCallEvents":[...]}  —— t(obj) 用反射逐字段转 JSON
```

### 3.3 AgentServiceClient 侧（launcher 打包的 ability SDK）

`/tmp/sla_jadx/sources/com/stepos/ability/sdk/client/AgentServiceClient.java`：
- 绑定：`Intent("com.stepos.ability.BIND_AGENT_SERVICE").setComponent(ComponentName("com.stepos.ability","com.stepos.ability.service.AgentService"))`，startService+bindService，4s 绑定超时，拿 `IAgentServiceManager` binder。
- `h0(toolTask)` → `i0(toolTask, bound)`：
  - `name=="add_task"/"update_task"` 走任务卡片特例（OriginalTaskConfig 解析）；
  - 否则 "branch2 normal tool"：`u.a(toolTask, context)` 把 ToolTask 转 `TaskConfig(taskId, ..., priority=2, abilityId, name=function, taskUiInfo, params=paramsJson, extra=Bundle, callerPackage=launcher)` → `V(taskConfig)` → **`IAgentServiceManager.submitTask(taskConfig)`**（Binder IPC）。

### 3.4 ability 侧如何真正执行（逐类函数的答案）

交叉验证 `analysis/decompiled/ability/sources/com/stepos/ability/`：
```
AgentService$binder$1.submitTask → InternalTask → ITaskScheduler.schedule（task/scheduler/a.java，并发=min(ncpu*4,32)）
  → ToolTaskExecutor（task/executor/ToolTaskExecutor*.java；DI 注入 ICallTool/IAbilityManager/ISlaPermissionManager）
    → CallToolImpl.call(CallToolRequest)（calltool/CallToolImpl.java）
       四个 handler 按名/extra 选择（calltool/handler/）：
       ① appFunctionsCallToolHandler  → DirectAppFunctions（appfunctions/DirectAppFunctions.java）
       ② jetpackAppFunctionsCallToolHandler → JetpackAppFunctions（androidx.appfunctions SDK）
       ③ mcpCallToolHandler  ④ cloudCallToolHandler
```
`DirectAppFunctions` 通过 **Android AppFunctions 框架**执行：
- `scan(context, targetPackage)`：用 AppSearch `GlobalSearchSession` 枚举目标包注册的 AppFunction（`app_functions`/`app_functions_runtime` schema）；
- `encodeToolName(pkg, functionId)` + `identifierCamelToSnake`：把 `包名+函数ID` 编成 SLA 模型使用的蛇形工具名（`settings_get_bluetooth_state` 等）并建索引；
- `execute(context, entry, args)`：`buildParamsDocument`（按 schema 把参数 Map 转 GenericDocument）→ **`AppFunctionManager.executeAppFunction(ExecuteAppFunctionRequest)`** → 目标系统应用（设置/信息/电话/时钟）进程内实现真正执行；返回 GenericDocument → `documentToJson` → content/display_text/meta。
- 提交时 `extra["handle_input_schema"]=true`（`commoninternal/Key.KEY_HANDLE_INPUT_SCHEMA`）：要求 ability 侧按函数 schema 校验/矫正入参。

**逐类回答：**
| 函数族 | 执行路径 |
|---|---|
| `settings_get_*` / `settings_set_*` / `settings_adjust_*` / `settings_connect_wifi` 等 | ❌ 不在 AiLauncher 调 Settings API；统一 submitTask → ability → AppFunctions → **设置应用**注册的 AppFunction（最终在 Settings 进程内调 Settings.Global/System 等） |
| `sms_send` / `sms_send_direct` / `sms_query` / `sms_settings_*` 等 | ❌ 不用 SmsManager/_com.android.mms_ MCP；同上链路到**信息应用**的 AppFunction（Mms 进程内执行发送/查询） |
| `dialer_call_to` / `dialer_call_contact` / `dialer_contacts_add` | 同上，到**拨号/联系人应用**的 AppFunction（CallToolImpl 的 calltool 是云函数调用器，与拨号无关） |
| `alarm_clock_*` | 同上，到**时钟应用**的 AppFunction |
| 全部 | **是——统一经 ability 的 AgentServiceClient→AgentService(Binder)**；名字即路由键，AiLauncher 不维护函数→动作映射表（显示用标签在 `resources/assets/tool_name_map.json`，598 项，纯 UI 资源） |

（旁证：ClawX `resources/assets/openclaw/skills/android-abilities/system_settings.md`、`phone_comm.md` 用 `ability.call method="settings_..."` 同一套工具名；AgentSafetyCenter `assets/ledger/seed_rules.json` 种子规则含同名函数。）

### 3.5 AIEngine 侧的孪生执行路径（localDispatch=false 时）

AIEngine `SlaAbility.dispatchAtomic`（AIEngine/.../sla/SlaAbility.java L525）：`AtomicSdkClientFactory.get().dispatch(AtomicDispatchRequest(function,text,params,priority,extras))`。`AtomicSdkClientReal`（core/common/atomic/）与 Launcher 的 SlaAtomicDispatcher 是**同构孪生**：同样 `com.stepos.ability.sdk.client`（AIEngine 构建里混淆为 d/f/e）、`handle_input_schema=true`、TaskUiInfo("SLA: ...", "AIEngine SLA dispatch")、30s 超时、60s 迟到保留、EXECUTOR_ID="stepos-ability"。即两条路殊途同归于同一个 AgentService。`executeAtomicFrom(input)` 读 args 的 `"sla.executeAtomic"`（默认 true）；SlaChatController 的 localDispatch=true 路径把它置 false，让 AIEngine 只识别（`SlaResultBuilder.buildSlaOutputPhase`：`{"version":..,"phase":"sla_output","slaOutput":rawText,...}`）并通过 `onSlaOutput(raw)` 把**原始模型输出**交回 Launcher 解析执行。

### 3.6 t.java —— SlaInstalledAppGuard（唯一的本地"假执行"）

`sla/t.java`：`installFunctions = {"appstore_install_app"}`；`f(params)` 先按 `packageName/package_name/pkg` 再按 `appName/app_name/name` 查 PackageManager（含 MAIN/LAUNCHER 枚举模糊匹配，去标点小写比较）；命中已安装 → **不派发**，直接合成 DispatchResult(SUCCESS, resultJson=`{"task":{...,"bundle":{"tool_call_response":"{\"content\":\"「X」已安装，无需重复安装\",\"meta\":{\"display_text\":...,\"already_installed\":true,\"source\":\"SlaInstalledAppGuard\"}}"}},"toolCallEvents":[...]}`)。聊天 UI 对此与真实执行无法区分（信任 resultJson）。

---

## 4. SlaExecution / SlaResult / LocalExecResult 数据结构

| 结构 | 字段 | 位置 |
|---|---|---|
| `SlaDecision` | function?, text, params: Map<String,String>, priority?, confidence: Float, alternatives: List<SlaAlternative>, rejectReason? | `aiengine/algorithm/sla/SlaDecision.java`（Parcelable） |
| `SlaExecution` | dispatched: Boolean, executor: String("stepos-ability"), status ∈ {DISPATCHED,SUCCESS,FAILED,UNAVAILABLE,NOT_DISPATCHED}, errorCode: Int, errorMsg?, resultJson: String?, elapsedMs: Long | `aiengine/algorithm/sla/SlaExecution.java` |
| `SlaResult` | decision, execution, asrText, totalElapsedMs, modelInferMs, rawJson（聚合诊断 JSON，见下） | `aiengine/algorithm/sla/SlaResult.java` |
| `DispatchResult`（dispatcher 内部） | executor, status ∈ {SUCCESS,FAILED,UNAVAILABLE,NOT_DISPATCHED}, errorCode(错误码见下), errorMsg, resultJson, elapsedMs | `sla/SlaAtomicDispatcher.java` 内部类 |
| `LocalExecResult` | replyText: String, slaScene: Int=-1, replyMessageId: String? | `agentframework/chatcore/send/LocalExecResult.java` —— SendPipeline 回调 `k.b(ctx, LocalExecResult)`，表示"本轮发送被本地执行消费" |

错误码表：`-100` CANCELLED、`-101` TIMEOUT(30s)、`100000` UNKNOWN、`100007` NOT_INITIALIZED、`220001` INFERENCE_FAILED(task failed)、`230001` IPC_NOT_CONNECTED、`280001/280002/280003` SLA_NO_VALID_ACTION/SCREEN_LOCKED/UNSUPPORTED、`20004`（"codeString=20004"=无原子能力，Launcher 特判 C0() 直接回云不上屏）。

**返回给聊天 UI 的是什么**：`SlaResult.execution.resultJson`（ability 返回的 `{"content":..., "meta":{"display_text":..., "appUI":..., "sla_scene":..., ...}}`，多动作时为聚合 actions JSON）。SlaChatController.f()（onSlaResult，恢复于 /tmp/sla_jadx L1756）解析后渲染：
```kotlin
fun f(traceId, query, result, routeToBackend) {           // SlaGate.d 回调
    if (status != SUCCESS && status != DISPATCHED) {      // 失败
        if (C0(result)) /* resultJson 含 "codeString=20004" 无原子能力 */ { U0(...routeToBackend) }  // 静默回云
        else { /* onSlaResult$3: appendTranscript(失败) 后放行云端 */ }
        return
    }
    val actions = h0(result.execution.resultJson)          // 拆出每个动作的 result JSON
    val replyText = actions.joinToString("\n") { k0(it) }  // meta.display_text → content → 缺省"已执行"
    val appUiTools = actions.mapNotNull { i0(it) }         // meta.appUI → Gson(ToolAppUI) → AppUIData → AgentTool（卡片！）
    val scene = actions.map { l0(it) /* meta.sla_scene */ }.firstOrNull{...} ?: -1    // SLA_SCENE_CLOSE_HOST=2
    val displayQuery = w.d(context, j0(result))            // sla_offline_user_copy.json 模板渲染用户可读 query
    // onSlaResult$1: u0() 渲染 + Z() 转录;  onSlaResult$2: reportTranscript
}
fun u0(query, replyText, scene, appUiTools, anchor, reuseUserMessageId, userTime) {
    val user = ChatMessage(role=USER, query); val bot = ChatMessage(role=ASSISTANT, replyText, tools=appUiTools)
    C1939k0.k(listOf(user, bot))                          // 落库
    chatView?.r(user); chatView?.r(bot) ?: Toast(replyText)   // 无 chatView（锁屏等）用 Toast
    D0(replyText, scene)
    // 同时 k.b(ctx, LocalExecResult(replyText, scene, replyMessageId="sla-assistant-"+...))
}
```
即：**文本气泡（display_text/已执行）+ 可选 appUI 卡片（AgentTool/AppUIData）**；`SLA_ASSISTANT_MESSAGE_ID_PREFIX="sla-assistant-"`。

---

## 5. 锁屏重放（cachedDecisionForUnlock 写入/重放时机）

写入（`SlaGate.E`，SlaGate.java L1515 恢复）：
```kotlin
fun E(decision, traceId, sessionId, query, proceed) {     // cacheForUnlock
    synchronized(unlockCacheLock) {
        cachedDecisionForUnlock = decision; cachedTraceIdForUnlock = traceId
        cachedSessionIdForUnlock = sessionId; cachedQueryForUnlock = query; cachedProceedForUnlock = proceed
    }
}
```
- **唯一写入口**：`Race$listener$1.onSlaOutput` 中 `v.a()` 判定 `errorCode==280002(SLA_SCREEN_LOCKED)` 且 function 非空时：`winner PENDING→SLA`（抢先胜出、取消竞速计时器）→ `race.Q("lock decision already terminal")` 取消 SDK 会话 → **`gate.E(decision, traceId, sessionId, query, proceed)`** → `race.c0 { callbacks.h(traceId, query, decision) }` 回调 UI。
- UI 侧 `SlaChatController.h()`：取消 15s 发送超时 → `U()`（armLockMissWaitTimeout，**LOCK_MISS_WAIT_MS=120000**）→ `O.INSTANCE.c(context, gate)` 调起 `LockScreenUnlockActivity`（`chat/lockscreen/O.java`，requestId="sla_replay_N"，同时 dismiss WakeDialog 让焦）。
- **重放**：解锁结果 SUCCESS/ALREADY_UNLOCKED → `gate.Q()`（replayCachedDecision）；CANCELLED/FAILED/TIMEOUT → `gate.I()`（dropCachedDecision，abandon）。另有 `SlaGate.N()` 每轮新竞速开始时 `Companion.c()` 清缓存（新轮顶替）。
- `Q()` 内部：无缓存跳过；缓存无 decision → `P()`（releaseCachedProceedToCloudOrAbandon：回云或放弃）；有 decision 无 function → 同 P()；否则协程 `replayCachedDecision$2` → **`R(decision,...)`（replayCachedDecisionAfterLedger）：先 `F(listOf(function))` 重走台账预检（250ms 重试一次）**，通过后重新 `SlaAtomicDispatcher.k()` 执行 → `callbacks.f(...)` 正常上屏；台账拒绝 → `P(proceed,..., "ledgerDeny")`。**即重放不跳过台账检查**（与首跑一致），且被缓存的 `proceed`（放行云端闭包）一直被持有到重放/放弃。

---

## 6. SlaVoiceBridge 与文本路径的关系（一句话）

SlaVoiceBridge 让"语音轮"在 ASR 出字前就通过 `gate.B()` 先行开一场 query 未绑定的 Race（与 ASR 并行竞速），待 `SlaChatController.e()` 收到带语音 meta 的 SendContext 时用 `m()` 把该文本嫁接回同一场 Race（`race.K(text)` 绑定 query 后配信结果），并管理 CHAT/VOICE_ONLY 两优先级的 gate 绑定抢占（`sla/N.java`），本质是同一 SlaGate 竞速机制的语音加速入口。

---

## 7. sla/ 其他文件：名单、常量、开关

| 文件 | 内容 |
|---|---|
| `sla/C3474c.java`（sla flags） | **运行时开关（volatile 静态，默认值）**：`enabled=true`（总开关，SlaRouter.v/warmUp/gate.N/B 都先查）、`localDispatch=true`（Launcher 本地派发 vs AIEngine 派发）、`cloudFirstWhenOnline=false`（在网直上云）、`offlineLedgerBypass=true`（离线台账绕过）。带 setter，可被远程配置/调试改写 |
| `sla/v.java` | 58 项 `lockScreenAllowed` 白名单 + `slaUnsupported={request_cloud_assist, request_gui_assist}`；错误码 280001/280002/280003；`a(function,fallback,locked): Verdict`（fallback→280001；unsupported→280003；locked&&!whitelist→280002；否则 canExecute） |
| `sla/u.java` | 台账绕过规则：`bypass = enabled && localDispatch && offlineLedgerBypass && 离线 && 无红线函数 && (verdict==2 || denyReason∈{5,6,7})`；`d()=enabled&&localDispatch`（台账检查抛异常时是否放行） |
| `sla/x.java` | 模型输出解析器：`a(raw)/b(raw)`（单/多动作），文法 `<func>\nkey:value`；Parsed(function,text,params,fallback,rejectReason) |
| `sla/w.java` | 离线用户文案：读 `resources/assets/sla_offline_user_copy.json`（function→中文模板，如 alarm_clock_add→"设置闹钟"），`d()` 用 params 填模板生成 displayQuery；`a(context)` 惰性加载 |
| `sla/G.java` | SLA 埋点：sla_start / sla_judge_result(hit|fallback_openclaw) / sla_execute_start / sla_execute_result(success|fail) / sla_feedback_show；LOCK_LOCKED/UNLOCKED、NETWORK_ONLINE/OFFLINE、冷启动标记 |
| `sla/C3475d.java` | 入口来源 source 枚举：voice_wakeup/home_inputbar/lockscreen_shortcut/ai_key_click/headset_control/share_agent/agent_space/external_agent/agent_market/sidebar_*/ask_ai_entry/gui_agent（埋点用，默认 home_inputbar） |
| `sla/N.java` | GateBindPriority 抢占规则（CHAT 绑定可被 VOICE_ONLY 新 owner 抢占） |
| `sla/t.java` | SlaInstalledAppGuard（见 §3.6） |
| SlaGate 常量 | `bufferMs=1000`（竞速窗口）、`EXECUTION_TIMEOUT_BASE_MS=31000`（winSla 后按动作数×31s 重置计时）、`LATE_ASR_GRACE_MS=600`（SLA 胜出但 ASR 未回时等 600ms 再配空串）、`LEDGER_CHECK_RETRY_MS=250` |
| SlaChatController 常量 | `MAX_SLA_QUERY_CHARS=480`、`SEND_TIMEOUT_MS=15000`（+SLACK 2000）、`LOCK_MISS_WAIT_MS=120000`、`SLA_ASSISTANT_MESSAGE_ID_PREFIX="sla-assistant-"`、`SLA_SCENE_CLOSE_HOST=2`、`NO_ATOMIC_ABILITY_CODE="codeString=20004"` |
| SlaRouter 常量 | `WARM_UP_MIN_INTERVAL_MS=5000`、`CTA_DIALOG_DEBOUNCE_MS=1500`、`TASK_PRIORITY=2`、`GATE_ERROR_SERVICE_DISABLED=5022`、增强服务跳转组件名等 |
| SlaAtomicDispatcher 常量 | `TIMEOUT_MS=30000`、`LATE_RETENTION_MS=60000`、权限串（见 §3） |

---

## 8. 总结（≤8 句）

1. SLA 本地执行 = `SlaChatController.e()`→`SlaGate.N()` 开 Race（1000ms 竞速窗口）→DeepBinder 调 AIEngine `ISla.recognize(executeAtomic=false)` 只识别→`onSlaOutput` 原始文法回 Launcher，由 `Race$listener$1` 用 x/v 解析裁决、q0 胜出后走台账预检，再逐动作 `SlaAtomicDispatcher.k()` 执行。
2. **函数如何真正执行**：SlaAtomicDispatcher 对全部白名单函数无差别地把 `function` 名+params JSON 包成 ToolTask，经 `AgentServiceClient.h0()`→Binder `IAgentServiceManager.submitTask` 提交 com.stepos.ability 的 AgentService；ability 侧 TaskScheduler→ToolTaskExecutor→CallToolImpl→AppFunctions/JetpackAppFunctions handler→`android.app.appfunctions.AppFunctionManager.executeAppFunction`，由设置/信息/拨号/时钟等系统应用注册的 AppFunction 在各自进程内完成真正的 Settings/短信/拨号/闹钟操作——AiLauncher 与 AIEngine 内均无任何 Settings API/SmsManager 直接调用。
3. 执行结果（含 content/display_text/appUI/sla_scene 的 resultJson）由 `ITaskListener.onTaskEvent` Binder 回调完成 Future，30s 超时、60s 迟到保留，最终在聊天 UI 渲染为"已执行"式文本气泡+可选 appUI 卡片，并用 `LocalExecResult` 告知 SendPipeline 本轮已被本地消费。
4. **新安全问题 A（权限 fail-open）**：`SlaAtomicDispatcher.p()` 若发现 `com.stepos.ability.permission.ACCESS_AGENT_SERVICE` 未被任何包声明（旧版 ability），即"按有权限放行"——Binder 保护降级为无保护，恶意 app 可在老版本上直接 bind AgentService 伪造 ToolTask。
5. **新安全问题 B（名字即权限）**：Launcher 侧对 function 名的唯一校验是 `v.a()` 的 fallback/黑名单/锁屏白名单三查——解锁状态下任意非黑名单函数名都会被派发，安全完全依赖 ability 侧工具注册表与台账（`checkSlaPermission`）兜底。
6. **新安全问题 C（离线台账绕过默认开）**：`offlineLedgerBypass=true` 且 `u.b()` 规则下（离线、无红线、verdict==2 或 denyReason∈{5,6,7}）预检失败的函数照常本地执行——断网即策略降级窗口。
7. **新安全问题 D（伪造成功结果）**：`t.java` INSTALL_GUARD 对 `appstore_install_app` 本地合成与真实执行同构的 SUCCESS resultJson（source=SlaInstalledAppGuard），UI 无真伪校验；同理 UI 完全信任 ability 回传的 display_text/appUI，若 AgentService 结果被伪造可向聊天注入任意文案/卡片。
8. 锁屏场景：白名单外函数触发 lockMiss→`gate.E()` 进程内缓存 decision+proceed→拉起解锁界面（120s 等待），解锁成功 `gate.Q()` **重走台账预检后**重新派发执行，失败/超时则 `gate.I()` 丢弃并放弃/回云——重放路径本身没有跳过安全检查。
