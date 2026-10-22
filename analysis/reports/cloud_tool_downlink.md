# StepOS 云端智能体"工具调用下行 → 端侧执行"完整链路逆向报告

- 分析对象：
  - AiLauncher 反编译源：`/home/liu-ym23/Projects/AgenticSmartphoneSafety/STEPX_Neo/0_BasicObservation/1_ReverseEngineering/analysis/decompiled/AiLauncher/sources/com/stepos/`（下称 `AIL/`）
  - ability 反编译源：`.../decompiled/ability/sources/com/stepos/`（下称 `AB/`）
  - 辅助证据（同仓已有反编译）：`.../decompiled/AgentBus/`（下称 `AGB/`）、`.../decompiled/ClawX/`（下称 `CLX/`）
- 混淆说明：R8 混淆但保留 Kotlin `@Metadata`，报告中类名/方法名以反编译产物为准，注明"方法体未反编译"处为 jadx dump 失败（语义已从伴生 lambda 类/调用点恢复）。

---

## 0. 全链路总览（一张图）

```
┌─────────────┐  ①chat.send   ┌──────────────┐ ②WS/zeroclaw  ┌────────────────────┐
│ AiLauncher  │ ────────────▶ │  AgentBus    │ ─────────────▶ │ OpenClaw Gateway    │
│ AgentFrame  │  LocalSocket  │ (system uid  │  (chroot内     │ (ClawX, Node.js,    │
│ work 上行   │  @agentbus    │  系统总线)    │  18789/zeroclaw│  biz-gw.stepos.com) │
└─────────────┘               └──────────────┘               └─────────┬──────────┘
      ▲                              ▲                                 │ 云脑 LLM 决策
      │ ④下行 session.message /      │ ③node.invoke.request           ▼
      │   ToolCall 流                │   {command:"ability.call"}  ┌────────────────┐
      │                              │                            │ LLM 调 nodes 工具│
      │                              │                            │ invokeCommand=  │
      │                              │                            │ "ability.call"  │
      │                              │                            └────────────────┘
      │                              │
      │   ⑤ node.invoke.request 路由到 NODE 角色连接（ability）
      │                              │
┌─────┴──────────────────────────────┴──────────────┐
│ ability (system uid)                              │
│ AbilityAgentBusNodeAgentBusBinding.handleInvoke   │
│  → AbilityCallExecutor.execute (parseArgs: method │
│    =mdi_click/gui_agent, toolCallId, traceId…)    │
│  → AgentServiceClient.submitToolTask/submitGuiTask│
│  → (AIDL) AgentService → TaskRobot → InputManager │
│  ← ITaskListener.onTaskEvent                      │
│  → node.invoke.result → AgentBus → 网关 → 云       │
└───────────────────────────────────────────────────┘
```

跳数（云端下发 mdi_click 到注入事件）共 **7 跳**：
云脑 LLM →(1) OpenClaw 网关 `nodes` 工具 →(2) node.invoke.request（zeroclaw Binder / 网关 WS）→ AgentBus 路由器 →(3) LocalSocket `@agentbus` → ability `AbilityAgentBusNodeAgentBusBinding` →(4) AbilityCallExecutor →(5) AgentServiceClient AIDL `submitToolTask` →(6) TaskRobot 任务管理器/工具路由 →(7) InputManager.injectInputEvent 反射注入。回传同路反向 +1 跳（node.invoke.result）。

---

## 1. 上行消息格式与两个 Client 的端点/协议

### 1.1 发送管线（AiLauncher 内部）

`SessionHandler.s3()`（`AIL/agentframework/chatcore/SessionHandler.java:3327`，日志名 `requestForAnchoredSend`）做最后一跳组装：

1. 取 `AgentSession.j2(anchor)` 得到目标 `AgentConversation`；
2. `agentConversationJ2.d(messages, deepThinking, meta, null)`（`SessionHandler.java:3359`）→ 协程进入 `AgentSession$AgentConversation$sendMessage$1` → `j0(...)`（`AIL/agentframework/chatcore/session/AgentSession.java:516-583`）；
3. 图片先经 `SessionHandler.x3()`（`SessionHandler.java:3781`，静默图片上传 SilentImageStage）；
4. 最终 `ApiManager.q(ApiType, C0918n, h, cont)`（`AIL/agentframework/adapter/ApiManager.java:2029`，即 `chat()`）：前置检查 `v()`（已 init）/`x()`（有网络）→ `clientMap.get(type).E(request, listener)`。

`C0918n`（ChatRequestInfo，`AIL/sources/kotlin/C0918n.java`）字段：`contentParts(List<ChatAttachment>/content)`、`role`、`conversationId`、`contentType`、`transferState`、`stream`、`extra`、`_id`、`uid`、`customVariables`、`token`、`thinking`(深度思考)、`chatId`(=originMessageId，工具回传时用)、`toolOutputs(HashMap<toolCallId,String>)`、`meta`、`guiAgentModelName`、`traceId`、`messageId`、`attachments`。**注意：请求里没有本地 tools 定义列表**——工具清单全部在网关/云端侧（见 §7.2）。

`SendPipeline`（`AIL/agentframework/chatcore/send/SendPipeline.java`）是 s3 之前的闸门：`p(rawCtx)` → `AuditStage.f()`（内容安审，空文本/未启用跳过，`:178`）→ SLA 竞速 `slaArbiter.d(rawCtx)`（`:309-316`，见 §6）→ `f(send)` → `g(ctx)`＝`commitToCloud`（`:188`，调 `handler.x3()` 上传图片后 `handler.s3()`）。防重复上云：`b.a()` outcomeClaimed CAS。

### 1.2 OpenClawCoreAgentClient（ApiType.OPENCLAW）——经第三方 AgentFront APK 的 AIDL

文件：`AIL/agentframework/adapter/openclaw/OpenClawCoreAgentClient.java`

- **协议：不是 AiLauncher 直连云**。`chat()` → `E()`（`:491`）→ 协程 `A0(request, listener, client)`（`:405`）→ `AgentFrontClient.i0(Message, callback)`。
- `AgentFrontClient`（`AIL/sources/com/zyql/agentfront/sdk/client/AgentFrontClient.java`）是 **AIDL 客户端**：
  - 目标 Service：`com.zyql.agentfront` 包 `com.zyql.agentfront.service.MessageBridgeService`（`AgentFrontClient.java:492`，`b0()` startService），bind action `com.zyql.agentfront.BIND_MESSAGE_BRIDGE`（`:626`）。
  - AIDL `IMessageBridge`（`AIL/sources/com/zyql/agentfront/IMessageBridge.java`，DESCRIPTOR `com.zyql.agentfront.IMessageBridge`）：`sendMessage(Message)→String`、`submitToolResult(ToolResultRequest)`、`submitToolResults(Batch…)`、`cancelMessage`、`manageSession`(clear/rename)、`syncHistory`、`pauseTask`/`resumeTask`、`queryAbilityMetasByReq`、`registerListener(IMessageListener,"business",pkg)`。
  - **真正与云端的 WS/SSE 连接在 com.zyql.agentfront 独立 APK 内**（不在本次两个反编译范围），AiLauncher 只见到 AIDL。
- **上行 Message**（`OpenClawCoreAgentClient.w0()`，`:909-951`）：
  ```json
  {"messageId":"<时间戳>", "conversationId":"...", "role":"user", "channel":"normal",
   "type":"text|multi|image|audio|video|file",
   "content":[{"type":"text","text":"…"}|{"type":"image","uri":"…","url":"…"}…],
   "traceId":"…", "sourcePackage":"com.stepos.ailauncher"}
  ```
- **工具结果回传**：`G0()/J0()`（`:550/:631`）——遍历 `request.s()`(toolOutputs)，逐条 `client.o0(new ToolCallRequest(toolCallId, toolName, resultJson, …, traceId))` → AIDL `submitToolResult`。
- 断线缓存：`pendingQueue` + `onConnected → H0()` 重发（`:574`）；取消：`CancelMessageRequest`（`:107`）。

### 1.3 AgentBusCoreAgentClient（ApiType.AGENTBUS）——LocalSocket JSON 帧到系统总线

文件：`AIL/agentframework/adapter/agentbus/AgentBusCoreAgentClient.java`（3768 行；`E()`=chat 主体 `:901`、`c1()`=建 binding `:2196`，两者 jadx dump 失败，语义由 `chat$sendOnce$2/4`、`withBinding$2` 等伴生类恢复）。

- **传输**：`ClawChannelAgentBusBinding`（同目录 `ClawChannelAgentBusBinding.java`）包装 `AgentBusBindingBase`（`AIL/agentframework/../com/stepos/agentbus/generated/AgentBusBindingBase.java`）：
  - **Android LocalSocket（Unix 抽象命名空间），socketName = `"agentbus"`**（构造参数 `C1963x.AGENT_TYPE_AGENTBUS`＝"agentbus"，`ClawChannelAgentBusBinding.java` 构造器；`chatcore/session/C1963x.java:10`）；
  - 角色 `role="channel"`、reqIdPrefix `"as-"`、displayName "AgentFramework"、重连 1000ms、协议 min/max 3/3、`idleTimeoutMs=0`（构造器实参）；
  - 帧为 JSON 文本帧（`DataOutputStream` 写 + `eb/k` 读循环），见 `AgentBusBindingBase$connectAndServe$idleJob$1.java`（LocalSocket import）与 `writeFrame$1`。
- **上行 chat 帧**：`ChatApi.i(sessionId, Message)` → `ClawChannelAgentBusBinding.M()`（`:940`，dump 失败）→ 总线方法 **`chat.send`**（AgentBus 侧 `AGB/sources/v4/k.java:448` 把 `chat.send/chat.stream/tick` 列为通道方法；REST 调试面同款帧 `AGB/sources/u5/s.java:172`：`{"type":"req","id":"as-…","method":"chat.send","params":{"sessionId":…,"text":…,"idempotencyKey":"ik-…"}}`）。
- **a4.Message**（`AIL/sources/a4/Message.java`）字段：`role(Role user/assistant)`、`content(String)`、`attachments(List<Attachment>)`、`toolCalls(List<ToolCall>)`、`replyTo`、`metadata(Map)`、`delta`（流式增量）。工具结果也走 chat 消息（`chat$sendOnce$2` 的 `$toolMessage`，ToolCall 内嵌 status/result）。
- AgentBus 系统应用（`com.stepos.agentbus`，system uid）把 channel 的 `chat.send` 送往 OpenClaw 网关（chroot 内 Node.js，gateway 18789 loopback，`CLX/resources/assets/openclaw/openclaw.json`），网关再上云（biz-gw，见 §7.1）。AiLauncher 与网关之间**无直接 socket**，一切经 AgentBus。

### 1.4 两个 Client 对照表

| | OPENCLAW | AGENTBUS |
|---|---|---|
| 端点 | AIDL→`com.zyql.agentfront` APK（云端连接在该 APK 内） | LocalSocket `@agentbus` → AgentBus 系统应用 → OpenClaw 网关(127.0.0.1:18789) → 云 |
| 协议 | Binder(AIDL) + AgentFront 内部 WS | Unix domain socket JSON 帧（req/res/event） |
| 上行方法 | `IMessageBridge.sendMessage(Message)` | `chat.send` req 帧 |
| 工具结果 | `submitToolResult(ToolResultRequest)` | chat 消息内 `toolCalls[{id,name,arguments,status,result}]` |
| 下行工具调用 | `Message(type="tool_call", toolCall/toolCalls, isActive)` → `j.b(ToolCallRequest)` | `a4.Message.toolCalls` → `q` 映射为 `C0917m(answerType="function_call"/"tool_response")` |

---

## 2. 下行事件流：云端响应如何回到 AiLauncher

### 2.1 AGENTBUS 路径（现行主路）

1. 网关/云 → AgentBus（zeroclaw Binder 或网关 WS）→ 路由回 channel 连接；
2. `AgentBusBindingBase` 读循环 → `dispatchIncoming` → `ClawChannelAgentBusBinding` 的 `incomingMessages: Xa.j<Pair<String,Message>>`（构造器）；
3. `ChatApi.onMessage` job（`ClawChannelAgentBusBinding.java:187` 起）→ AiLauncher `AgentBusCoreAgentClient` 的 **`onIncomingMessage` → `U0(sessionId, message)`**（`AgentBusCoreAgentClient$onIncomingMessage$2.java:48`；`U0` 本体 `:1759`，3725 指令 dump 失败）；
4. `U0` 按 `message.metadata.runId` 找在途会话：`j1()`（`:2794`）匹配 `activeChats` → 流式 `delta` 聚合（ActiveChat.streamAccumulator）→ `listener.g(request, C0917m)`（token 级增量）；
5. 无在途会话 → **`g2(sessionId, message)`＝handlePushMessage**（`:2574`）：用映射器 `q`（`AIL/agentframework/adapter/agentbus/q.java`）把 `a4.Message` 转成一条或多条 `C0917m`：
   - `q.h/K/L()`：ToolCall → `answerType="function_call"`、`FunctionCall(name, arguments(id), resultJson)`（`q.java:185-201 D()`）；
   - 已执行完的工具 → `"tool_response"`；
   - `decision/presetText/riskLevel` → `"moderation"`（`q.E()`，`:204`，"内容已被审核拦截"）；
   - 推给 `pushMessageListener`（netcore `t` 接口：`a()` 普通 / `b()` function_call|tool_response，`AgentBusCoreAgentClient.java:2653-2657`）→ `PushMessageCenter`（`AIL/chatcore/session/PushMessageCenter.java`，AGENTBUS/OPENCLAW 双分支 `:86-90`）。
6. 任务事件：`startTaskEventsCollector` → `K1(StepClawEvent)` → `W0(TaskEventPayload)`（`:1787`）→ `ApiManager` B 类监听器 → `TaskIngress`（`AIL/chatcore/session/TaskIngress.java:192` attach AGENTBUS TaskEventListener）。

**工具调用到达端侧的形态（AGENTBUS）**：`C0917m{answerType="function_call", functionCall=FunctionCall{name="…", arguments=…, toolCallId}, replyTo=originMessageId, traceId}` —— AiLauncher 侧把它当"聊天消息"消费；真正执行要看下游（见 §3：**mdi 类工具根本不经过 AiLauncher**，由网关直接发给 ability 节点）。

### 2.2 OPENCLAW 路径

`AgentFrontClient.dispatchMessage(Message)`（`AgentFrontClient.java:346-470`）：
- `type="tool_call"` 且 `toolCall/toolCalls` 非空：
  - `isActive=true`（主动推送）→ `pushMessageListener.c(ToolCallRequest)`（`:411`）→ `OpenClawCoreAgentClient$g.c()` → `F0()`（`OpenClawCoreAgentClient.java:496-548`）组装 `C0917m("tool_call", FunctionCall)` → `t.b(msg, OPENCLAW)`；
  - `isActive=false`（对在途请求的应答）→ 按 `originMessageId` 查 `callbackMap` → `j.b(ToolCallRequest)` → `OpenClawCoreAgentClient$e.b()`（`:262-284`）→ `listener.g(request, C0917m(tool_call))`。
- 普通 token 流：`j.d(Message)`（`:297`，dump 失败）→ `listener.g(...)` 增量；`isFinish` 时移除 callback。

事件分发器小结：**AGENTBUS 的分发器 = AgentBusCoreAgentClient.U0/g2 + q 映射器；OPENCLAW 的分发器 = AgentFrontClient.dispatchMessage（回调表+推送双路）**。流式 token 两条路都有（`delta` / MessageContent.text 聚合）。

---

## 3. mdi_* 工具调用链（重点）

### 3.1 云端如何"决定调用"

网关提示词里的工具是 **`nodes`**（"Invoke phone capabilities (ability.call via invokeParamsJson)"，`AGB/sources/m4/q0.java:33` 工具清单；skill 文档 `CLX/resources/assets/openclaw/skills/android-abilities/*.md`）。云端 LLM 输出形如（`CLX/.../skills/android-abilities/gui_agent.md`）：

```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=600000
     invokeParamsJson='{"method":"gui_agent","params":{"app_name":"小红书","task":"…"}}'
```

mdi_* 与 gui_agent、file_safe_delete 等都是 `invokeParamsJson.method` 的取值。

### 3.2 网关侧闸门（唯一的策略拦截点）

- `openclaw.json`（`CLX/resources/assets/openclaw/openclaw.json`）：`gateway.nodes.allowCommands = ["ability.call","agent.call","stepclaw.exec"]`、`gateway.bind=loopback`、`gateway.port=18789`、`gateway.auth.mode=token`、LLM 走 `http://127.0.0.1:18791/v1`（stepos 签名代理）。
- `stepclaw-intercept` 扩展（`CLX/.../extensions/stepclaw-intercept/index.js:641-705`）挂 `before_tool_call` 钩子：外部 hook 可 `{block:true}` 拒绝；对 `nodes` 工具把 `sessionKey/runId/_runId` 注入 `invokeParamsJson`（供端侧审计关联）。
- **注意：allowCommands 只约束 invokeCommand（ability.call 这一层），不约束 method（mdi_click/任意 ability 方法）**——方法级白名单在 ability 侧（见下）。

### 3.3 网关 → AgentBus：node.invoke.request

- 帧构造 `AGB/sources/q5/r.java:a()`：
  ```json
  {"type":"event","event":"node.invoke.request",
   "payload":{"id":"<invocationId>","nodeId":"<节点>","command":"ability.call",
              "params":{…invokeParams…},"timeoutMs":600000}}
  ```
- 到达 AgentBus 的两条腿：
  1. **云 WS**：`AGB/sources/a6/q.java:105` —— sessionRole `operator`/`node` 且 event=`node.invoke.request` → 帧注入路由器；
  2. **本地网关**：AgentBus 以 AIDL 客户端 bind `com.stepos.stepclaw` 的 `IZeroClawService`（`AGB/sources/t4/g.java:73-76`，action=DESCRIPTOR），zeroclaw `onEvent(Message)` 帧（JSON-RPC 风格 `n7/a.java`）。
- 路由分发 `AGB/sources/la/g.java`（Dispatcher，`:185` 处理 node.invoke.request；异常回 `node.invoke.result{ok:false,error{code:"STEPCLAW_TRANSPORT_ERROR"}}`）；NODE 连接处理 `AGB/sources/u5/t.java:150`。

### 3.4 AgentBus → ability（谁 binds 谁）

**ability 是 LocalSocket 客户端（NODE 角色），AgentBus 是 LocalServerSocket 服务端**——不存在 binder bind；hello 握手用内核 peer credentials+签名信任校验（见 `AGB` 报告 §7）。

ability 侧（`AB/ability/agentbusclient/`）：
- `AbilityAgentBusNodeAgentBusBinding` 构造器（`:399`）：`new AgentBusBindingBase("agentbus", …, "Ability AgentBus bridge", ApexSDK.VERSION, "node", "n-", 1000L, 3, 3, dispatchFrame, clientExtra, connectParams, 0L)` —— socket 名同样 `"agentbus"`，role=`"node"`，reqIdPrefix `"n-"`。
- `registerInvokeHandlers()`（`:843`）：`tools.register("ability.call", handler1)`、`tools.register("ability.list", handler2)`（常量 `AbilityAgentBusNodeKt.java`：`ABILITY_CALL_COMMAND="ability.call"`、`ABILITY_LIST_COMMAND="ability.list"`）；注册时 `updateCaps` 上报能力（tools.changed 事件让网关 `nodes action="status"` 可见）。
- `handleInvokeRequest(JSONObject)`（metadata 可见 `handleInvokeRequest$1`：并发上限触发回 `STEPCLAW_RATE_LIMITED "node max concurrent invokes (0) reached"`——上限值为 0，即**信号量未配置时全拒**，运行时由 DI 注入实际值）；取消帧 `stepclaw.invoke.cancel`（`u5/s.java:457` REST 同款）。

### 3.5 ability 内部执行（AbilityCallExecutor）

`AB/ability/agentbusclient/AbilityCallExecutor.java`：
- `execute(map)`（`:806`）→ `parseArgs()`（`:725`，dump 失败）得 `ParsedCall{method, paramsJson, toolCallId, toolId, traceId, sessionId, timeoutMs}`（字段从 `readTraceId()` 与 `registerInvokeHandlers$1` 可证：params 里 `invokeParamsJson/toolId/toolCallId/traceId/sessionId/timeoutMs`，traceId 兜底取 `params._meta.trace.traceId`）；
- 缺 method → `INVALID_REQUEST "missing method in ability.call params"`；
- `awaitToolTaskResult()`（`:501`）：
  - 注册 `ITaskListener.Stub`（`:509`，回调含 `onTaskEvent/onInfoRequested/onInfoDismissed/onToolCallEvent/onExplainUpdated/onPackageConflict/onRequestRelaunch`）；
  - Bundle 注入：`KEY_CALL_SOURCE="CLOUD"`、`KEY_TRACE_ID`、`"session_id"`、`KEY_TOOL_ID`、`KEY_TIMEOUT_MS`（`:635-651`）；
  - **路由二分**（`:652-671`）：`toolId=="0" || method=="gui_agent"` → `AgentServiceClient.submitGuiTask(new g(toolCallId, paramsJson, new f(toolCallId, bundle)))`；否则 → `submitToolTask(new h(method, toolCallId, paramsJson, toolId, f(toolCallId, bundle)))`；
  - TaskStatus==13 → `PendingAuthParser.parse(...)` → `PendingAuth` + `publishResume()`（授权挂起，见 §5/§6 交接）；
  - 终态：`TERMINAL_STATUSES = TaskStatus.e`；成功取 bundle `message`/`KEY_TOOL_CALL_RESPONSE` 解析 `ToolTaskResponse{success,content,errorCode,errorMessage}` → `toAgentBusPayload() = {ok:true, content:…}/{ok:false, errorCode, errorMessage}`（`:373-394`）。
- 超时：`DEFAULT_TIMEOUT_MS=600000`（`:63`），超时错误码 `STEPCLAW_INVOKE_TIMEOUT`；通用失败 `ABILITY_CALL_FAILED`；`GUI_AGENT_METHOD="gui_agent"`、`GUI_TOOL_ID="0"`（`:64-65`）。
- 结果经 `sendInvokeOk/sendInvokeError`（`AbilityAgentBusNodeAgentBusBinding`）→ `node.invoke.result` req 帧 → AgentBus → 网关 → 云（遥测 `agent_bus_toolcall/tool_node_invoke_result`，`AGB/sources/z5/c.java:70-85`）。

**回答"经过 OpenClaw gateway 的 ability.call 吗？还是 AiLauncher 直接转发？"**：mdi 调用**完全不经过 AiLauncher**。链路是 云→网关(nodes 工具)→AgentBus→(LocalSocket)→ability 节点，AiLauncher 只收到结果型的 chat 流。AiLauncher 对 `function_call` 的处理仅限自己注册的通道工具（如风险卡，见 §4）。这是"云端可绕过前端直接驱动 system-uid 执行器"的关键结构事实。

【ability 端 AgentService AIDL 服务端、TaskRobot mdi handler 注册表、GuiTaskExecutor 循环细节 → 见 §5/§6，由后台深挖 agent 补全】

---

## 4. 风险卡调用链（assistant_show_risk_statement）

- 工具名常量：`AIL/ailauncher/agent/ability/VoiceAbilityService.java:95` `TOOL_SHOW_RISK_STATEMENT = "assistant_show_risk_statement"`；入口日志 `:434`（打印 sessionId/toolCallId/metaKeys/timeoutMs/argLevel/argTitle/argDescription/argTags，参数含 `level/title/description/tags`）。
- 该工具注册在 AiLauncher 的 MCP 体系（`AIL/mcp/`），由网关 MCP client 调用。
【MCP 服务发现/binder 细节、弹卡 UI、用户选择回传（MCP tool result vs submitPermissionAuthResult）→ 由后台深挖 agent 补全】

---

## 5. GUI 任务链（GuiTaskConfig / GuiTaskExecutor）

- 已确认：云端 gui_agent 走 §3.5 的 `submitGuiTask`（toolId="0"）分支；`invokeTimeoutMs=600000` 由云端提示词强制要求（gui_agent.md）。
【GuiTaskConfig 字段、Surface 传递、GuiTaskExecutor 截图→云端→动作循环组件 → 由后台深挖 agent 补全】

---

## 6. SLA 快车道判定调用链

- 已确认入口：`SendPipeline.p()`（`SendPipeline.java:309-317`）：`slaArbiter.d(rawCtx)` 为真 → `SlaGate`"进入竞速拦截"（`C0919o.b(SlaGate.TAG,"进入竞速拦截")`，SlaGate 位于 `AIL/ailauncher/sla/SlaGate.java`）→ `slaArbiter.e(ctx, callback c)`；本地先完成则 `onLocalHandled`（`SendPipeline.java:117`）claim 终态、`q3()` 上报，云端慢到则丢弃（"框架·重复终态丢弃"）。
【SlaGate→AgentServiceClient.checkSlaPermission 组装、ability o4/d 判定、台账 fail-open → 由后台深挖 agent 补全】

---

## 7. 名单/常量总清单

### 7.1 端点与传输
| 常量 | 值 | 出处 |
|---|---|---|
| AgentBus LocalSocket | `agentbus`（server: `LocalServerSocket`，最多 64 连接） | `AGB` 报告 §1.2、`AGB/sources/c6/h.java:117` |
| AgentBus REST（调试，默认 disabled） | `127.0.0.1:18801`（`/v1/channels/{id}/chat|events|cancel`、`/v1/nodes/{id}/invokes…`） | `AGB/sources/u5/s.java:40-52`、`u5/m.java:17` |
| AgentBus BlobServer | `127.0.0.1:18800`，PUT≤32MB，缓存 100MB | `AGB/sources/f5/e.java:13` |
| Edge 钩子 | `127.0.0.1:18080`，connect 超时 5000ms | `AGB/.../config/EdgeConfig.java:118` |
| OpenClaw 网关 | loopback:18789，auth=token，bind=loopback | `CLX/.../openclaw.json` |
| LLM 供应商代理 | `http://127.0.0.1:18791/v1`（openai-completions，stepos-model-auto） | 同上 |
| biz-gw（云） | prod `https://biz-gw.stepaos.com/`，dev/test `https://biz-gw.t-stepos.com/`，stg `https://biz-gw-in.zyql.com/` | `AGB/.../config/PushConfigKt.java:15` |
| 云 WS 占位默认 | `wss://cloud.stepclaw.example/ws`（实际由配置下发） | `AGB/.../config/CloudConfig.java:141` |
| AgentFront AIDL | `com.zyql.agentfront/.service.MessageBridgeService`，action `com.zyql.agentfront.BIND_MESSAGE_BRIDGE` | `AIL/.../AgentFrontClient.java:492,626` |

### 7.2 命令/工具白名单
| 名单 | 值 | 出处 |
|---|---|---|
| 网关 nodes.allowCommands | `ability.call`, `agent.call`, `stepclaw.exec` | `CLX/.../openclaw.json` |
| AgentBus OpenClawCloudUpstream.nodeCommands 默认 | `system.run`, `system.which`, `stepclaw.exec`, `agent.call`, `ability.call` | `AGB/.../config/OpenClawCloudUpstream.java:379` |
| nodeCaps 默认 | `["system"]`；operatorScopes `operator.read/write/admin`；clientId `openclaw-android`；deviceKey `openclaw_cloud_device_key.bin` | 同上 |
| 静态路由 | `agent.delegate`(100)、`skills.*`(90)、`memory.*`→钉死 stepclaw(90) | `AGB/sources/v4/k.java:223` |
| tools/allow（网关） | `group:fs, group:runtime, group:openclaw, group:plugins, task-bridge`；deny `web_search, browser`；subagents 追加 `nodes` | `CLX/.../openclaw.json` |
| ability 节点命令 | `ability.call` / `ability.list` | `AB/.../AbilityAgentBusNodeKt.java` |
| 能力调用来源标记 | `KEY_CALL_SOURCE="CLOUD"` | `AB/.../AbilityCallExecutor.java:636` |

### 7.3 超时/重试/开关（AiLauncher AgentBusCoreAgentClient 常量，`AgentBusCoreAgentClient.java:77-105`）
`ACK_TIMEOUT_MS=125000`、`CLOUD_READY_TIMEOUT_MS=120000`、`CONNECT_TIMEOUT_MS=10000`、`STEP_TERMINAL_GRACE_MS=120000`、`DISCONNECT_TERMINAL_GRACE_MS=20000`、`EMPTY_TERMINAL_GRACE_MS=15000`、`POST_ABORT_ACK_GRACE_MS=8000`、`POST_ABORT_RETRY_WINDOW_MS=15000`、`SEND_CONFLICT_RETRY_DELAY_MS=400`、`SEND_UNAVAILABLE_RETRY_DELAY_MS=600`、`DELETE_SESSION_ATTEMPTS=3`/`DELETE_SESSION_RETRY_DELAY_MS=400`、`HOT_SESSION_ACQUIRE_TIMEOUT_MS=1200`（重试 1 次）、`RECENT_DELETE_CORRELATE_MS=600000`、容量：`COMPLETED_OUTBOUND_ID_CAP=500`、`RECENT_ABORT_CAP=32`、`RECENT_DELETE_CAP=64`、`ANCHOR_CAP=16`、`OPENCLAW_UNAVAILABLE=5`、`ERROR_CODE_NO_NETWORK=-100`、流名 `UI_STREAM="ui"`、事件 `stepclaw.session.update` / `stepclaw.reference`。
OpenClaw client：重连 1000ms（绑定基类）；`DELETE_SESSION_ATTEMPTS=3`/400ms（`OpenClawCoreAgentClient.java:66-67`）。
ability：`DEFAULT_TIMEOUT_MS=600000`、`GUI_TOOL_ID="0"`、错误码 `STEPCLAW_INVOKE_TIMEOUT`/`ABILITY_CALL_FAILED`/`INVALID_REQUEST`/`STEPCLAW_RATE_LIMITED`/`STEPCLAW_TRANSPORT_ERROR`。
AgentBus binding 基类：reconnectDelay=1000ms、protocol 3..3、默认远端超时 30s（BffApi.d 默认 30000）。

【AppWhitelistEngine 云同步 key、SLA/rules_version、tool_allow 清单 → 由后台深挖 agent 补全】

---

## 8. 安全观察（基于已确认部分）

1. **下行工具调用无端侧强制权限检查点（已证实的结构事实）**：`ability.call` → `AbilityCallExecutor.execute` 全程只做参数解析与超时，没有任何对 `method` 的授权判定；`KEY_CALL_SOURCE="CLOUD"` 只是标记不校验。策略只在两处：网关 `nodes.allowCommands`（命令级，不含 method 级）与 stepclaw-intercept `before_tool_call`（都在 chroot 网关内，云端/网关被攻破即全失守）。
2. **AiLauncher 被绕过**：mdi 执行链 0 跳经过 AiLauncher，前端可见性完全依赖云端自愿展示（风险卡同样是"云端自愿调用"的 MCP 工具）。
3. 网关 auth token 为 `stepclaw-dev-placeholder-v1`（占位 token，`openclaw.json`），LLM 明文 HTTP 到 18791。
4. AgentBus REST/Blob/Edge 全部 127.0.0.1，但同机任意 uid 可尝试连接（hello 阶段签名校验拦第三方）。
5. 节点并发限制 `STEPCLAW_RATE_LIMITED` 的上限值来自 DI 注入的信号量（反编译里默认提示 0），需运行时确认。

（待补： PendingAuth/ResumeSender 授权闭环是否存在可绕过路径、SlaGate 竞速副作用、MCP 服务注册面——见 §4-§6 待整合小节）

---

## 附：与方法论相关的可信度说明

- 标"dump 失败/未反编译"的方法：`AgentBusCoreAgentClient.E/U0/c1`、`ClawChannelAgentBusBinding.M/ChatApi.c`、`OpenClawCoreAgentClient.B0/D0/e.d`、`AbilityCallExecutor.parseArgs/publishResume`、`t5/f.b`。其语义均从伴生协程类、调用点与常量恢复，结论可信但行级细节以 smali 为准。
