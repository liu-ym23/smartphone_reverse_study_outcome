# 文本提示词全流程逆向分析：用户在 Amoo 前端发送一条文字

> 项目：STEPX_Neo / 1_ReverseEngineering | 日期：2026-10-21
> 方法：jadx 1.5.3 静态反编译（含 --show-bad-code 二次恢复跳过的方法体）+ 设备实测交叉验证
> 源码根：`analysis/decompiled/AiLauncher`（前端/管线）、`analysis/decompiled/ability`（执行中枢）、`analysis/decompiled/AIEngine`（端侧识别器）、`analysis/decompiled/ClawX`（网关宿主）
> 本文档是三个并行深挖（上行管线/SLA 本地执行/云端下行链）的合成总报告

---

## 0. 端到端总览

```
【阶段一 UI】ChatActivity → UnifiedChatHostView → AgentChatLayout
      │ 输入框回调 E.a(message) → 构造 SendContext + PendingBubbleIds(用户气泡先上屏)
      ▼
【阶段二 上行管线】SessionHandler.V3 → G0 → SendPipeline.p()
      ├─① AuditStage.f()      内容审核【云API，异步，只挡云路径，fail-closed】
      ├─② U3()                会话key预取(SessionPrefetchStage) + 静默图片
      └─③ slaArbiter.d() 粗筛(4条) ?
             ├─ 否 → f() → commit$2(等审核) → g() commitToCloud ──► 【阶段四B 云路径】
             └─ 是 → SlaGate.Race 1000ms 竞速 ──► 【阶段三A SLA 本地快车道】
                                                └─ 超时/失败 → 回到 commit 路径

【阶段三A SLA 快车道】（本地赢，消息永不上云）
   SlaRouter ──DeepBinder──► AIEngine ISla.recognize（端侧小模型, 文法"<func>\nkey:value"）
   → SlaDecision{function,params,confidence}
   → v.java 门（slaUnsupported 2 项 / 锁屏白名单 58 项）
   → checkSlaPermissionV1 ──Binder──► ability SLA 引擎查 AgentSafetyCenter 台账（fail-closed 6 拒因）
        └─ 断网+台账不可用+非redline → offlineLedgerBypass fail-open 放行
   → SlaAtomicDispatcher → ToolTask ──Binder──► ability AgentService
        → TaskScheduler → ToolTaskExecutor → CallToolImpl(4类handler)
        → AppFunctionManager.executeAppFunction ──► 系统 App（设置/拨号/时钟）真正执行
   → SlaResult{content, meta.display_text, appUI} → 气泡+卡片 → LocalExecResult → 回 SendPipeline

【阶段四B 云路径】（兜底/复杂任务）
   g() commitToCloud: x3(静默图片) → s3(requestForAnchoredSend)
   → 双通道二选一:
      AGENTBUS(现行主路): LocalSocket "agentbus" JSON 帧 chat.send → AgentBus(system) → chroot 网关(18789) → 云 biz-gw.stepaos.com
      OPENCLAW(备路):  AgentFrontClient AIDL → 第三方 APK com.zyql.agentfront MessageBridgeService → WS 上云
   云端大脑（StepFun LLM + 云端 OpenClaw 编排）规划……
   ▼
【阶段五 下行】云下发:
   ├─ 流式文本 delta → 聊天气泡逐字渲染
   ├─ 工具调用（mdi_*/gui_agent）: 云→网关nodes工具→AgentBus→ability 共7跳【AiLauncher 0参与】
   │    → AgentServiceClient.submitToolTask(KEY_CALL_SOURCE="CLOUD") → TaskRobot → 虚拟屏注入
   │    （下行链路无端侧权限检查点；唯一策略=网关 allowCommands 命令级白名单）
   ├─ 风险卡: 云端"自愿"调 assistant_show_risk_statement(AiLauncher MCP) → 弹卡 → 选择回云
   └─ PendingAuth(status=13) → ResumeSender 待授权恢复闭环
   ▼
【阶段六 后置审核】T0(ChatMessage 完成) → SafeHintClient(云API, user_input+model_output → is_risky)
   → risky=true: 清空已展示回复+RISK标记（fail-open: 失败=放行）
```

---

## 1. 阶段一：UI 入口与消息构造

### 1.1 组件

| 组件 | 路径 | 职责 |
|---|---|---|
| ChatActivity / AgentChatActivity | `ailauncher/chat/` | Amoo 聊天宿主 |
| UnifiedChatHostView | `ailauncher/chat/view/UnifiedChatHostView.java` | 统一聊天容器 |
| **AgentChatLayout** | `agentframework/chatui/AgentChatLayout.java` | 框架级聊天布局（消息列表+输入框），持有 SessionHandler |
| InterfaceC5940b | `agentframework/chatui/` | 输入栏回调接口（文本/图片/参数） |
| **SessionHandler** | `agentframework/chatcore/SessionHandler.java`（3956 行） | 会话中枢：轮次管理、发送、响应分发、审核回滚 |

### 1.2 发送入口（AgentChatLayout.E.a，:423）

```kotlin
// AgentChatLayout.java:423  输入框点击发送回调
fun onSendClicked(message: String, images: List<FileInfo>, params: Map<String,String>) {
    val text = message.trim()
    val suppressBubble = suppressImmediateUserBubble?.invoke() ?: false
    val pendingBubbles = n7(text, images, showBubble = !suppressBubble)  // 用户气泡立即上屏
    val extraParams = o3(pendingBubbles, params)
    val useDeepThink = E.INSTANCE.a(context, ...)
    val agentId = handler.R1()?.agentId
    val ctx = SendContext(message, images, params, pendingBubbles, extraParams, useDeepThink, agentId)
    handler.V3(ctx)
}
```

**SendContext**（`chatcore/send/SendContext.java`）字段：text、images、params、**PendingBubbleIds**（messageId/imageMessageId/fileMessageId——三个气泡的本地占位 id）、extras、useDeepThink、agentId、slaAnchor。

### 1.3 V3 → G0（SessionHandler）

`V3(ctx)`（:1974）：
1. `H3(topConversation.B())` —— 若上一轮未完成，先收尾
2. 有 preSendHook / unfinishedTaskCancel 钩子则先走钩子（宿主可注入前置逻辑），否则直接 `G0(ctx)`
`G0(ctx)`（:1223）：处理正在进行的会话后 → `sendPipeline.p(ctx)`

`p()` 里还调 `handler.U3(ctx)`（:1698 区段）——**不是**入历史，而是：
- **SessionPrefetchStage**（`send/SessionPrefetchStage.java`）：新会话"领 key"（向云端预取 canonical session id，为正式发送省一个 RTT）；已有 key 或预取中则跳过
- `SilentImages.h(ctx)`：静默图片（无气泡的附图）预处理

---

## 2. 阶段二：SendPipeline 上行三步（`send/SendPipeline.java`，320 行）

### 2.1 主入口 p() 与防双发

```kotlin
fun p(rawCtx: SendContext) {
    val send = B(ctx, auditStage)            // inflight 条目
    inflight.add(send)
    send.audit.f(ctx)                         // ① 审核异步启动
    handler.U3(ctx)                           // ② 预取/静默图片
    if (slaArbiter == null || !slaArbiter.d(ctx)) {
        log("框架·无SLA直接放行"); f(send)     // ③ 无竞速→直接 commit
    } else {
        log(SlaGate.TAG, "进入竞速拦截")
        send.slaRacing = true
        slaArbiter.e(ctx, raceCallback)       // ④ 启动 SLA 竞速
    }
}
```

**B（inflight 条目）** 持有 `outcomeClaimed: AtomicBoolean`——一轮只允许一个终态：本地赢了后云端结果被丢弃（`"onLocalHandled 忽略: 本轮终态已落(已上云)"`），反之亦然。`m()`（detach）取消未提交的发送。

### 2.2 第①步 AuditStage：云端内容审核（出口管制，fail-closed）

| 项 | 值 | 出处 |
|---|---|---|
| 端点 | `POST cloud-risk-audit/api/v1/inner/risk-audit/rich-text` | `chatcore/audit/h.java` |
| base URL | 云控注入（key=`audit_base_url_key`，HttpManager） | `chatcore/audit/k.java:95` |
| 请求 | userId/text/messageId | AuditRequest |
| 业务标识 | `bizType="clawphone"` | k.java |
| 审核方式 | **纯机审** `onlyMachineAudit=true` | k.java |
| 超时 | 20s（AUDIT_TIMEOUT_MS） | ContentAuditClient |
| 启用条件 | 审核器已配置 **且** 文本非空；空文本→`"安审跳过(未启用/空文本)→直接上云"` | AuditStage.e() |

结果密封类 `g`：`c="PASS"`、`a="BLOCK"`、`Error(code,msg)`；**`Error → BLOCK`**（`g.a()`）——审核失败/超时=拦截，消息不出端（fail-closed）。

命中 BLOCK 后（SessionHandler:1715 `T1`）：
- `RunBlockedEvent`，场景 `SCENE_RUN_BLOCKED` / `SCENE_PRIVACY_BLOCKED`，给用户预置文案（audit_block_reply 等字符串资源）
- **finalizeAfterAuditRevert**（:985）：把 PendingBubbleIds 对应的气泡记录从 FwkDatabase 删除——被拦消息在本地痕迹清空
- `RecentModerationKeySet` 去重（同内容不重复弹）
- `RevertedSessionGuard` 保证会话状态一致性

### 2.3 第③前置：SLA 仲裁器粗筛（SlaChatController，`ailauncher/chat/view/sla/`）

slaArbiter 即 SlaChatController（实现 `chatcore/send/j` 接口）。`d()` 四条粗筛（全部通过才竞速）：

1. agentId 不在 **bff 排除名单**（**硬编码枚举** `ExternalAgent{claude, codex, stepai, deepseek, doubao}`，`adapter/agentbus/bff/ExternalAgent.java`；匹配=trim+lowercase 精确等值，无云端下发/运行时更新）——外部 AI 助手接入的会话永远不走本地快车道
2. **文本长度 ≤ 480 字**（`MAX_SLA_QUERY_CHARS=480`，SlaChatController.java:87；超长日志 `" > 480"`）
3. 无非静默附件（有图不竞速）
4. 文本非空

`e()`：若 `cloudFirstWhenOnline=true 且在线` → 直接上云不竞速（默认 false）；否则文本路径 `gate.N(text, traceId, proceed)`（N 内部再查总开关 `C3474c.enabled && SlaRouter.isSupported()`）。语音路径经 SlaVoiceBridge 嫁接到 `gate.B()` 预开的语音 Race（同一机制）。

---

## 3. 阶段三A：SLA 快车道（本地赢）

### 3.1 竞速机制（SlaGate.Race，`ailauncher/sla/SlaGate.java` 1812 行）

- 窗口 **bufferMs=1000ms**（默认值 1000L，synthetic 构造器 :1809）
- `Winner ∈ {PENDING, SLA, BACKEND, CANCELLED}`，`winner.compareAndSet` 抢占
- SLA 窗口内出决策 → `q0()`："**SLA 胜出 -> 吞掉原发送**"（消息永不上云），取消 timer，启动**执行预算 = actionCount × 31000ms**
- 1000ms 到点 → `startTimer$1`："buffer 超时 -> 走原通路" → TIMEOUT(-1001) → 回调上云
- 语音特例：SLA 赢但 ASR 文案未到 → `LATE_ASR_GRACE_MS=600ms` 宽限，再无 → 放弃（cancelledAfterSlaWon）→ 云
- 执行超时 → EXECUTION_TIMEOUT(-1004)

### 3.2 端侧识别器：SlaRouter → DeepBinder → AIEngine

- IPC 框架：**StepOS DeepBinder**（`ComponentName("com.stepos.aiengine", ".deepbinder.AIEngineDeepBinderProvider")`）
- 接口：`ISla.recognize(token, SlaInput, args{session_id, trace_id, task_priority=2, executeAtomic=false}, listener)`
- **模型输出文法**：`"<func>\nkey:value"` 行式文本，AIEngine 侧 SlaAbility 解析为
  **SlaDecision{function, text, params, priority, confidence, alternatives, rejectReason}**
- 词表 ≈60 项（与附录 D 一致）

### 3.3 v.java 门（safety gate，106 行）

```java
Verdict a(function, fallback, locked) {
    if (fallback || function==null) return Verdict(false, 280001, "no valid action");
    if (slaUnsupported.contains(function)) return Verdict(false, 280003, "not supported");  // 仅2项: request_cloud_assist/request_gui_assist
    if (!locked || lockScreenAllowed.contains(function)) return Verdict(true, 0, null);      // ★未锁屏不拦任何函数
    return Verdict(false, 280002, "screen locked, not in whitelist");
}
// isKeyguardLocked() 异常 → 按未锁处理（fail-open，v.java b()）
```

**锁屏白名单 58 项**（含 `sms_send`/`sms_send_direct`——锁屏可发短信）、slaUnsupported 2 项——完整清单见 APPENDIX.md D.2/D.3。

锁屏重放：verdict=280002 → gate.E() 缓存 decision+proceed → UI 调 LockScreenUnlockActivity（**120s** 等待）→ 解锁成功 gate.Q() 重放（先 `replayCachedDecisionAfterLedger` 重走台账预检再派发）→ 超时 gate.I() 丢弃。

### 3.4 台账权限检查（checkSlaPermissionV1 → ability SLA 引擎）

- 调用：SlaGate → `AgentServiceClient.checkSlaPermission(functions)` → Binder `IAgentServiceManager.checkSlaPermissionV1`（TRANSACTION 26）→ ability 侧 SLA 引擎（`ability/o4/d.java`）
- 数据源：AgentSafetyCenter 三个 content provider（ledger/permission/snapshot）
- **fail-closed**：denyReason ∈ {redline, mode, unknownFunction, scopeMissing, noSnapshot, stale} 任一即拒（附录 I）
- **offlineLedgerBypass（fail-open）**：`sla/u.java` + `C3474c.java`——
  `enabled(默认true) && localDispatch(默认true) && offlineLedgerBypass(默认true) && 断网 && !anyRedline && (verdict==2 || denyReason∈{5,6,7})` → **跳过台账直接执行**。网络状态读取异常按在线处理（不放行）。
- 台账查询异常路径补充（onSlaOutput$5 还原）：查询抛异常 → 回云端；但若 `enabled&&localDispatch` 开启 → **放行本地执行**（又一处 fail-open）；解锁重放前同样先查台账（replayLedgerBypass 旁路同样适用）
- **C3474c 四开关的 setter 无任何调用者**——是编译期固定默认值，非云控/Settings 可变（意味着 offlineLedgerBypass 无法被远程关闭，也未被远程开启过）

### 3.5 真正的执行：SlaAtomicDispatcher → AppFunctionManager（重要更正）

**没有函数→动作映射表**。58 个白名单函数统一走能力通道：

```
SlaAtomicDispatcher（构造 ToolTask{function, paramsJson, handle_input_schema=true, TaskUiInfo="SLA: xxx"}）
 → AgentServiceClient.h0() → Binder submitTask
 → ability AgentService → TaskScheduler → ToolTaskExecutor → CallToolImpl
    （4 类 handler: appFunctions / jetpackAppFunctions / mcp / cloud）
 → DirectAppFunctions → android.app.appfunctions.AppFunctionManager.executeAppFunction
 → 系统 App（设置/拨号/时钟等）暴露的 AppFunction 真正执行
```

即 SLA 的 `settings_set_brightness`、`dialer_call_to`、`alarm_clock_add` 等是 **Android 16 AppFunction API** 的调用，由目标系统应用执行——不是 SmsManager/Settings 直调，也不是 com.android.mms 的 MCP。

**唯一本地特判**：`sla/t.java` 的 **INSTALL_GUARD**——`appstore_install_app` 若已安装则**合成与真实执行同构的 SUCCESS resultJson**（UI 信任 display_text/appUI，无真伪校验）。

### 3.6 结果回填

`SlaResult.execution.resultJson{content, meta{display_text, appUI, sla_scene}}` → 文本气泡（兜底文案"已执行"）+ appUI 卡片（AgentTool）→ `LocalExecResult{replyText, slaScene, replyMessageId}` → SendPipeline 回调 b（onLocalHandled）→ audit.c() 取消审核 → inflight 移除。**本轮结束，云端零参与。**

错误码体系：-100/-101（竞速）、100000/100007（ability 层）、220001（语音）、230001（安装守卫）、280001-280003（v.java 门）、20004（其他）。

---

## 4. 阶段四B：云路径（兜底）

### 4.1 commit 链

`f(send)` →（audit.e(ctx)? → `commit$2`：await 审核结果，BLOCK 则拦 → 否则）→ `g(ctx)` commitToCloud：
1. `sendUiBridge.A(ctx)` UI 切发送中
2. `handler.x3(fileInfos, anchor)` = **resolveSilentImages**（静默图片上传/解析）
3. `handler.s3(messages, deepThinking, meta, anchor)` = **requestForAnchoredSend**（:3327）——解析/预取 sessionId、meta 序列化 JSON、`b1()` 清理 stopGuard → `ApiManager.q(chat)`（:2029）→ client.E()

### 4.2 上行双通道

| 通道 | 链路 | 现状 |
|---|---|---|
| **AGENTBUS**（现行主路） | `AgentBusCoreAgentClient` → `ClawChannelAgentBusBinding` → **LocalSocket 抽象命名空间 "agentbus"**（role=channel, reqId 前缀 `as-`），JSON 帧 `{"type":"req","id":"as-…","method":"chat.send","params":{sessionId,text,idempotencyKey}}`，载荷 a4.Message{role,content,attachments,toolCalls[],replyTo,metadata,delta} → AgentBus(system) → chroot 网关 127.0.0.1:18789 → 云 | 主路 |
| **OPENCLAW**（备路） | `OpenClawCoreAgentClient` → `AgentFrontClient`(AIDL) → 第三方 APK `com.zyql.agentfront/.service.MessageBridgeService`（action BIND_MESSAGE_BRIDGE；IMessageBridge: sendMessage/submitToolResult/cancelMessage/manageSession/syncHistory/pause/resume/queryAbilityMetas）→ 其内部 WS 上云 | 本机未装该 APK（queries 声明了但 pm list 无）——**备路实际不可用** |

请求体 `C0918n`(ChatRequestInfo)：contentParts/role/conversationId/stream/thinking/**toolOutputs{toolCallId→result}**（工具结果回传字段）/meta/traceId/guiAgentModelName。**本地不上行 tools 定义——工具清单全在网关侧。**

### 4.3 下行事件（AiLauncher 视角）

- 流式 delta → 按 metadata.runId 找 activeChats 逐字渲染
- 无在途会话 → `g2()` push 路径 → 映射为 `C0917m{answerType="function_call"/"tool_response"/"moderation", FunctionCall, replyTo, traceId}` → PushMessageCenter

---

## 5. 阶段五：云端下行工具执行（mdi_* / gui_agent 七跳链）

**云端 LLM 调用网关 `nodes` 工具**（ClawX skills/android-abilities/*.md 文档）：

```
invokeCommand="ability.call"  invokeTimeoutMs=600000
invokeParamsJson='{"method":"mdi_click|gui_agent","params":{…}}'
```

完整七跳（**AiLauncher 全程 0 参与**）：

| 跳 | 通道 | 组件 |
|---|---|---|
| ① | 云 | StepFun LLM 决定调 nodes 工具 |
| ② | 网关内 | OpenClaw 网关 `nodes` 工具（allowCommands 白名单）+ stepclaw-intercept `before_tool_call` 钩子（注入 sessionKey/runId） |
| ③ | Binder 或云 WS | `node.invoke.request{id,nodeId,command:"ability.call",params,timeoutMs}` 经 **zeroclaw Binder**（AgentBus 为 client，bind com.stepos.stepclaw）或云 WS 下发 |
| ④ | LocalSocket | AgentBus 路由 → `@agentbus` → ability 的 `AbilityAgentBusNodeAgentBusBinding`（ability 以 role="node" 注册 `"ability.call"`/`"ability.list"` 两命令） |
| ⑤ | 进程内 | `AbilityCallExecutor.execute` → parseArgs{method, paramsJson, toolCallId, toolId, traceId, sessionId, timeoutMs} |
| ⑥ | Binder | `AgentServiceClient.submitToolTask/submitGuiTask`（toolId=="0"或method=="gui_agent"；**Bundle KEY_CALL_SOURCE="CLOUD" 仅标记**） |
| ⑦ | 进程内 | TaskRobot → 虚拟屏 → InputManager.injectInputEvent 注入 |

结果：ITaskListener.onTaskEvent → ToolTaskResponse{ok, content|errorCode} → `node.invoke.result` 原路回云。

**安全结论（下行）**：
- AbilityCallExecutor 只做参数解析+超时（DEFAULT_TIMEOUT_MS=600000，超时码 STEPCLAW_INVOKE_TIMEOUT），**无权限/确认检查**
- **下行链路无端侧强制检查点**；唯一策略在网关：`allowCommands=[ability.call, agent.call, stepclaw.exec]`——**只约束 invokeCommand，不约束 method**（mdi_click 等），方法级控制缺位
- 网关 auth token 为 dev 占位值 **`stepclaw-dev-placeholder-v1`**（`ClawX/config/GatewayAuthConstants.java:14`）
- LLM 代理 18791 为**明文 HTTP**（loopback）

### 风险卡完整闭环（已补全）

**MCP 基础设施**：StepOS MCP 走 **AIDL Binder**（`IMCPBinderService`: register/unregister/request(sessionId, jsonRpc)——request 载荷是完整 MCP JSON-RPC 报文；响应经 `IMCPBinderCallback.onSuccess` 回传）。发现 = PackageManager 按 `TOOLS_SERVICE` action 扫服务 + 读 `mcp.tools` meta-data 资源。AiLauncher 内的 `AndroidClientTransport` 是死代码——**AiLauncher 自己不做 MCP client**。

**双重调用方校验**（比 manifest 权限更严）：VoiceAbilityService 的 binder 被 `C5/a.java` 包装，**每次 transact** 经 CallerVerifier（`C5/d.java`）：拒绝跨用户；仅放行 self/system(1000)/root(0)/平台签名 uid。

**调用链**（`assistant_show_risk_statement` → `F()` → `H()`）：
- 前置短路：会话任务全终态→直接 Cancelled；unlock 场景已解锁→ALREADY_UNLOCKED
- 参数：title/description 必填；tags→按钮（reject=「拒绝」/allow_once=「仅此允许」/always_allow=「总是允许」）；level 缺省 medium；timeoutMs 缺省 **600000ms，钳制 [30s, 30min]**
- **三种宿主分发**：①sessionId 非空→RiskCardHandoffCoordinator（聊天内联卡/实况卡，重试 250ms×8）②聊天在前台→RiskStatementFloatCard（WindowManager 悬浮卡）③否则→静默实况通知（渠道 risk_statement_live_silent，**4h** 有效期），按钮经 `RiskStatementActionReceiver(ACTION_USER_CHOICE)` 广播回传
- unlock 场景需解锁→KeyguardUnlockActivity（**60s** 超时，SUCCESS/ALREADY_UNLOCKED/CANCELLED/TIMEOUT/FAILED 五态）
- **回传 = MCP tool result**：`{"trace_id":…, "choice":"ALLOW_ONCE"|"ALWAYS_ALLOW"|"REJECT", …}`（取消/超时→isError=true "user cancelled"）；**"总是允许"的持久化不在端侧此流程**——由云端/AgentSafetyCenter 台账维护
- **AiLauncher 内不存在 submitPermissionAuthResult**（grep 0 命中）——云路径授权恢复走 ResumeSender("stepclaw.approvals.resolve")，不经 ability 的那个 binder 方法

### GUI 任务与待授权闭环（ability 服务端实证补全）

- **GuiTaskConfig**{toolCallId, params, surface=null, guiTaskType=2, startMode=0, modelName} 经 `submitGuiTask` → taskType=1(GUI) → GuiTaskExecutor（纯代理层）→ 绑定 `ITaskRobotManger.startTaskV1(modelId, …)` → SystemSdkBridge → ZyqlGuiAgentTask（3821 行主循环）→ MDI 虚拟屏任务
- **模型目录**（`stepai/aios/guiagent/llm/cell/config/ModelCatalog.java`）：共 9+ 个模型——step3p7-mtp3-…-aos-prod（**ability 侧 DEFAULT_MODEL_ID 兜底**）、doubao-1.5-ui-tars、doubao-seed-1-8、google/gemini-2.5-pro、autoglm-phone、glm-4.6v、MiMo-VL-7B-RL、uiagentmeituan-12071133、local-vlm（端侧）。**默认值分两层**：AiLauncher `RobotManager.B()` 缺省传 **doubao-1.5-ui-tars**（聊天内 taskrobot 卡片）；云端消息的 AppUI 卡片可带 `guiAgentModelName` 覆盖；ability ModelCatalog 的兜底默认是 step3p7-mtp3。另注：AiLauncher 下行 tool_call 分支**纯呈现/落库，无本地执行**；GUI 任务不经 tool_call，走 AppUI/taskrobot 卡片 → RobotAppUIHostView.O() → RobotManager.B()
- LLM 端点：`https://biz-gw.stepaos.com/gui-agent-service/api/llm/chat/completions`
- 超时体系（TaskTimeouts）：TASK_EXECUTION=1220000ms、LLM_TAKEOVER=60000ms×2 次、TAKEOVER_IDLE=300000ms、注入经验=15000ms 等
- **TaskStatus 全表**（ability/common/TaskStatus.java）：0 CREATED→13 WAITING_USER_AUTH，终态集 {4 COMPLETED, 5 FAILED, 6 CANCELLED, 7 REMOVED}；GUI 任务被取消（6+taskType=1）也算成功终态
- **PendingAuth 完整协议**（agentbusclient/）：工具 handler 返回含 `approval_request` 的结果 → 任务置 13 挂起 → **ability.call 立即把授权请求 JSON 作为本次调用结果回云**（云端渲染授权卡）→ 用户决定后走 `ResumeSender`，method=**"stepclaw.approvals.resolve"**（4 次重试/60s 超时），携带 `execution_grant{token, idempotency_key}`、decision∈{"allow-once","deny"} → 恢复或终止挂起任务
- **⚠️ submitPermissionAuthResult 无属主校验**（AgentService binder L334-344 仅 enforceAccessPermission）：**任何持 ACCESS_AGENT_SERVICE 的进程可对任意 toolCallId 提交授权结果**——授权卡"代答"面（此前为测试假设，现已证实）
- **SLA 咨询式定论**（调用点普查）：全库 `checkSlaPermission` 仅 3 处调用（binder 查询入口/SDK 客户端/实现自身）——**ToolTaskExecutor→CallToolImpl→McpCallToolHandler→mdisdk 执行路径上零调用**，SLA 在 ability 内是查询式门控，非执行时强制
- AppWhitelistEngine：ALLOWED=0/REDIRECT=1/FAILED=2；数据源=assets whitelist_default.json + 磁盘缓存，**当前无真实云端同步源**（MockWhitelistRemoteSource）

---

## 6. 阶段六：响应渲染与后置审核（SafeHint）

`SessionHandler.T0(ChatMessage)`（回复完成）：
1. 聚合该回复全部 TEXT 片段；`safeHintCheckedMessageIds` 按 messageId 去重
2. `SafeHintClient.isRisky(user_input, model_output)` → `POST safe-hint-service/v1/safety_hint`（云控 base URL key=`safe_hint_base_url_key`）→ `{is_risky: Boolean}`
3. risky=true → 消息打 `ChatHintType.RISK` + **逐条清空已展示内容**（`content.i("")`）+ 刷新 UI
4. **fail-open**：异常/HTTP 失败/is_risky 缺失 → false → 内容照常展示

---

## 7. 本流程涉及的全部名单/常量速查

| 名单/常量 | 值 | 位置 | 完整版 |
|---|---|---|---|
| SLA 粗筛文本上限 | 480 字 | SlaChatController.java:87 | 本文 §2.3 |
| bff 排除名单 | claude / codex / stepai / deepseek / doubao（硬编码枚举 ExternalAgent，非云端下发） | adapter/agentbus/bff/ExternalAgent.java | 本文 §2.3 |
| SLA 竞速窗口 | 1000ms | SlaGate 默认参 | 本文 §3.1 |
| 执行预算 | 31s × actionCount | EXECUTION_TIMEOUT_BASE_MS | 本文 §3.1 |
| ASR 宽限 | 600ms | LATE_ASR_GRACE_MS | 本文 §3.1 |
| 锁屏等待 | 120s | LockScreenUnlockActivity | 本文 §3.3 |
| SLA 词表 | ≈60 函数 | SlaAbility + v.java | **APPENDIX.md D** |
| 锁屏白名单 | 58 项（含 sms_send） | sla/v.java | **APPENDIX.md D.2** |
| slaUnsupported | 2 项 | sla/v.java | APPENDIX.md D.3 |
| C3474c 四开关 | enabled/localDispatch/cloudFirstWhenOnline/offlineLedgerBypass = T/T/F/T | sla/C3474c.java | 本文 §3.4 |
| denyReason 6 种 | redline/mode/unknownFunction/scopeMissing/noSnapshot/stale | ability o4/d.java | APPENDIX.md I |
| CallToolImpl 4 类 | appFunctions/jetpackAppFunctions/mcp/cloud | ability TaskExecutor | 本文 §3.5 |
| 错误码 | -1004/-1001/280001-3/… | SlaGate/v.java | 本文 §3.6 |
| 审核端点 | cloud-risk-audit/...（20s，bizType=clawphone，纯机审） | audit/h.java k.java | 本文 §2.2 |
| SafeHint 端点 | safe-hint-service/v1/safety_hint | safehint/d.java | 本文 §6 |
| 网关 allowCommands | [ability.call, agent.call, stepclaw.exec] | ClawX skills | 本文 §5 |
| 网关 nodeCommands | [system.run, system.which, stepclaw.exec, agent.call, ability.call] | OpenClawCloudUpstream | cloud_tool_downlink.md §7 |
| 网关 token | stepclaw-dev-placeholder-v1（dev 占位！） | GatewayAuthConstants.java:14 | 本文 §5 |
| AgentBus 超时 | ACK 125s / CLOUD_READY 120s / CONNECT 10s / STEP_TERMINAL_GRACE 120s | AgentBusCoreAgentClient:77-105 | cloud_tool_downlink.md §7 |
| GUI 工具 | invokeTimeoutMs=600000, GUI_TOOL_ID="0" | AbilityCallExecutor | 本文 §5 |
| KEY_CALL_SOURCE | "CLOUD"（仅标记，不校验） | AbilityCallExecutor | 本文 §5 |

## 8. 安全检查点全景（一条文字的全生命周期）

| 检查点 | 位置 | 强制性 | 失败策略 |
|---|---|---|---|
| 内容审核 | 出端前（仅云路径） | 强制（文本非空时） | **fail-closed** |
| SLA 粗筛 | 竞速入口 | 决定路径 | — |
| v.java 锁屏门 | SLA 派发前 | 仅锁屏时生效 | 锁屏 fail-open（异常按未锁） |
| 台账权限 | SLA 派发前（仅本地路径） | 咨询式（判定强制，遵守在调用方） | **fail-open**（offlineLedgerBypass） |
| 网关 allowCommands | 下行 invokeCommand 级 | 命令级强制，**方法级缺位** | fail-closed（白名单外拒绝） |
| 网关 before_tool_call | 下行 | 仅拦 /sdcard 删除类 | 默认放行 |
| **下行端侧权限** | **无** | — | **缺位（核心发现）** |
| 风险卡 | 云端自愿调用 | 非强制 | 缺位 |
| SafeHint 输出回扫 | 回复完成后 | 后置 | **fail-open** |

## 9. 本次新增安全问题汇总

1. **下行工具链无端侧权限检查点**（七跳直达注入；KEY_CALL_SOURCE="CLOUD" 仅标记）——REPORT.md 薄弱点 #1 的实证强化
2. **allowCommands 只管命令不管方法**：ability.call 白名单内可调任意 method（mdi_click/gui_agent/...），方法级控制缺位
3. **网关 auth token 为 dev 占位值** `stepclaw-dev-placeholder-v1`；LLM 代理 18791 明文 HTTP
4. **SlaAtomicDispatcher 权限检查 fail-open**：ACCESS_AGENT_SERVICE 未声明即放行（旧版 ability Binder 无保护）
5. **"名字即权限"**：解锁态任意函数名可派发，仅靠 ability 注册表+台账兜底
6. **INSTALL_GUARD 合成假成功**：appstore_install_app 已装时返回与真实执行同构的 SUCCESS，UI 无真伪校验
7. 锁屏白名单含 sms_send/sms_send_direct（锁屏可发短信）+ isKeyguardLocked 异常按未锁处理
