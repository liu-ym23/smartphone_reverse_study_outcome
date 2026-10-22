# Flow A — AiLauncher 文字输入发送入口链路（EditText → SendPipeline）

代码根：`analysis/decompiled/AiLauncher/sources/`
所有行号均指 jadx 反编译 Java。混淆名→真实名来自 Kotlin `@Metadata d2` 与内部日志字符串（`DIAG-WAKE-NOSEND`、`C0919o` 打点了 `submitTextMessage` / `addMessageCard` / `doSend` 等真实名，可直接对上）。

---

## 0. 一图流（主链路）

```
[EditText etInputBar / ImageView btnTextSend]   layout_input.xml, 由 BaseInputView inflate
        │ ① btnTextSend.setOnClickListener → BaseInputView.f7  (BaseInputView.java:7753-7759)
        │ ② etInputBar.setOnEditorActionListener → BaseInputView.C7 (IME action=4/Done) (7739-7747)
        ▼
BaseInputView.f7  「btnTextSend.click」 (BaseInputView.java:2208)
  - isSysReplying 且输入框空 → 走 stop 分支 (onStopClicked/cancelListener)
  - trim 文本；空且无图 → silent no-op
  - → Ac(content)
        ▼
BaseInputView.Ac  「submitTextMessage」 (3408)
  - 键盘处理三态：SYNC 立即 / DEFERRED 等键盘收起 (hideKeyboard+runAfterKeyboardHidden) / DELIVER-BEFORE-HIDE
  - → Bc(view, content) (1132)：o4 成功则清空 etInputBar
        ▼
BaseInputView.o4  「addMessageCard」 (9392)
  1. C4899a 命令拦截（本地指令直接消化）
  2. trace 通道切换：若上一轮 traceChannel=="voice" → 取 SlaVoiceBridge.q() 作为本轮 voiceRoundId (9398)
  3. 生成 trace_id（O6.x.INSTANCE.a()）
  4. AuthManager.O(checkAppAuth) 未登录直接 return (9421)
  5. 长度上限 20000 (9425)
  6. 表单校验 formController (9431)
  7. 禁言检查 getBanController().r(...) → 通过后回调 p4 (9474-9481)
  8. FloatingCard 悬浮卡拦截 interceptSend (9483)
        ▼
BaseInputView.p4  「addMessageCard$afterBan」 (2858)
  - onAiWakeMessageSent 回调（AI 唤醒来源时）
  - 图片未传完 (picAndFileReadyStatus!=-1) → awaitUploadReady 协程等待后继续
  - → q4
        ▼
BaseInputView.q4  「doSend」 (2940)
  - onSendRoundStarted(traceId, deferHalf) / onSendInitiated() 先通知宿主
  - ChatTracker.x(...) 埋点
  - sendMessageListener.onClicked(text, files, params)  ← 界面侧终点 (2985-2989)
  - 清空图片栏、收起表单
        ▼
【listener 实现 = AgentChatLayout$E.onClicked (y4.b$f)】 (AgentChatLayout.java:418-449)
  - n7(): 生成 PendingBubbleIds 并立刻插入本地用户气泡 DisplayMessage (5956)
  - o3(): 组 baseMeta {chat_from=direct, meta_message_id, trace_id, msg_source, active_file_id...} (6100)
  - useDeepThink = com.stepos.agentframework.util.E.e(...)（系统深思考开关）
  - new SendContext(message, images, params, ids, baseMeta, useDeepThink, agentId, slaAnchor=null)
  - SessionHandler.V3(sendContext)   (AgentChatLayout.java:445-448)
        ▼
SessionHandler.V3  「startSend(SendContext)」 (SessionHandler.java:1969)
  - 先 H3(sessionId,false)=markTopConversationRead (1313)
  - 有 preSendHook / unfinishedTaskCancel → SessionHandler$startSend$3 协程（先取消未完成任务）
  - 否则直接 G0(ctx) (1224)：sendPipeline.p(ctx)  ← 进入已掌握的 SendPipeline
```

IME 路径：`C7` (BaseInputView.java:1151) 处理 editorAction==4，同样 trim 后 `Ac(string2)`，与按钮点击完全汇合。

---

## 1. 聊天界面是谁

| 组件 | 文件 | 职责 |
|---|---|---|
| ChatActivity | `com/stepos/ailauncher/chat/activity/ChatActivity.java` (4817 行，继承 sheet.S，带 lockScreenMode 字段) | 主聊天宿主：装载 ChatFragment / ChatInputFragment / ChatPagerFragment（Amoo 侧栏） |
| ChatFragment | `chat/fragment/ChatFragment.java` (onViewCreated:1063) | 找到 `UnifiedChatHostView`(R$id.unifiedChatHost)，向 AgentConfig 要 SessionHandler 绑定为 boundHandler；lockScreenMode 时跳过 sessionId 恢复 |
| UnifiedChatHostView | `chat/view/UnifiedChatHostView.java` (chatLayout 字段:107) | 组合 `LauncherChatLayout`（消息列表区）与 ChatView |
| ChatView | `chat/view/ChatView.java` (3960 行) | `R$id.agentChatView`；bindChatResource 协程把 getInputView()（MainInputView）绑进 chatLayout |
| LauncherChatLayout | `chat/view/LauncherChatLayout.java:46` `extends AgentChatLayout` | 消息列表 + 输入组件挂载点 |
| AgentChatLayout | `agentframework/chatui/AgentChatLayout.java` (7105 行) | 框架层聊天布局；`m3()`=bindInputComponent (5704) → `a7()` (4753) 注册 E/F/G 三个回调（发送/取消/加载气泡） |
| BaseInputView | `chat/view/BaseInputView.java` (11000+ 行) | 输入框基类， implements y4.InterfaceC5940b；持有 etInputBar(EditText)、btnTextSend(ImageView)、chatInputImageAdapter、formController、banController、sessionHandler |
| MainInputView | `chat/view/MainInputView.java:17` `extends BaseInputView` | ChatView 的常驻输入条 |
| FloatInputView | `chat/view/FloatInputView.java` | ChatInputFragment 的悬浮输入条（ChatInputFragment.java:1190 同样走 launcherChatLayout.m3() 绑定） |
| HomeInputView | `chat/view/HomeInputView.java` | 桌面常驻输入条，onClicked 走 WakeService.L1(...) 唤醒流而非直接 V3 |
| InputLayout | `agentframework/chatui/InputLayout.java` | agentcore SDK 自带输入条（etMessage/btnSend），AgentChatActivity(demo) 用；AiLauncher 主链路不用它 |
| InputViewManager | `chat/manager/InputViewManager.java` (983,U()) | 把主输入 view 的各类 listener 广播复制到 dependent 输入 view（任务详情页等） |

绑定链：`ChatView.bindChatResource` (ChatView.java:3236 启动协程；`ChatView$bindChatResource$1.java:118-123`)：
`sessionHandler = AgentConfig.INSTANCE.a().n()` → `chatLayout.setAgentUiConfig(...)` → `chatLayout.m3(getInputView())` → `a7(): inputLayout.setOnSendMessageListener(new E())`。

---

## 2. SendContext 字段表（`chatcore/send/SendContext.java`，data class）

| 字段 | 类型 | 来源/含义 |
|---|---|---|
| text | String? | 用户文本（纯图可为 null） |
| images | List&lt;FileInfo&gt;? | 附件（图+文件，FileInfo 含 fileId/path/url/uri/silent/uploadState） |
| params | Map&lt;String,String&gt;? | 输入层带来的参数（含 trace_id、input_channel、msg_source=ai_wake 等） |
| ids | PendingBubbleIds（必填） | messageId/imageMessageId/fileMessageId，三个本地气泡 UUID |
| baseMeta | Map&lt;String,String&gt;（必填） | o3() 组的固定元数据：chat_from=direct、meta_message_id、meta_image_message_id、meta_file_message_id、msg_source、trace_id、active_file_id |
| useDeepThink | Boolean | 系统深思考开关（util.E.e 全局设置） |
| agentId | String? | `sessionHandler.R1()`(topConversation).getAgentId() |
| slaAnchor | SlaSessionAnchor? | 语音 SLA 轮锚点，文字直发时为 null |

构造点唯一：`AgentChatLayout$E.onClicked`（AgentChatLayout.java:442-446）。

## 2b. ChatMessage（`w4/ChatMessage.java`）关键字段

messageId, pairId(问答对), sessionId, requestSessionId, serverItemId, agentId, role(AgentRole), status(EReplyStatus), time, traceId, message:List&lt;AgentMessage&gt;, sources, suggestions, uiActions, isLike/isDisLike, sendFailed, errorCode/errorMessage, approvalRequestId, hint(ChatHintType), askUserConversation, variantGroupId/variantIndex/variantCount, viewSpliteId, processingStartAtMs/processingDurationMs。

## 2c. AgentMessage（`u4/AgentMessage.java`）

type(AgentMessageType: TEXT/IMAGE/FILE/TOOL…), content(m.TextMessage/ImageMessage/FileMessage), tools:List&lt;AgentTool&gt;, deepThinkText, hiddenInUi, hiddenToolExecuteView。

## 2d. AgentSession / AgentConversation（`chatcore/session/AgentSession.java`）

- AgentSession：config(SessionConfig)、conversationMap、topConversation、statusState(ESessionStatus)、events(Xa.o)、messageRepository(x4.f)、conversationTitleRepository、handler(SessionHandler 反向引用)、slaSessionMutex。
- AgentConversation（内部类, 108 行起）：agentId、`prefetch:SessionPrefetchStage`、`silentImages:SilentImageStage`（构造时即建, 136-146）、retiredSessionIds、offlineHoldLock；`B()`=getSessionId(229)；真实方法名（子协程类名可证）：sendMessage、roundChat、preProcessing、prefetch、silentImages、regenerate、switchVariant、awaitNetworkThenSend、ensureCanonicalSessionIdForSend、uplinkSessionId。

---

## 3. chatcore/intent 包：RobotManager / TaskDispatcher

- **TaskDispatcher**（`intent/TaskDispatcher.java`，单例）：连接 `com.stepos.ability` 服务的 ITaskListener.Stub（onTaskEvent/onToolCallEvent/onInfoRequested/onPackageConflict/onRequestRelaunch），维护 submittedGuiHistory(taskId→Pair&lt;j,GuiTaskConfig&gt;) 与 toolCallBackMap，负责把云端下发的 GUI 任务/工具调用派发到设备执行侧，并持久化孤儿 GUI 任务状态（TaskDispatcher$persistOrphanGuiTaskStatus$*）。
- **RobotManager**（`intent/RobotManager.java`，单例）：手机端"机器人"自动化执行器——B(startType,arguments,modelId,startMode,Surface,traceId,…) 启动 robot 任务、I(taskId,toolCallId,Surface) 投屏、handleAction 处理 TaskRobotAction、fullScreenGui 全屏 GUI 预览、saveRobotCaptureImageToFile 截图存档、sendActionData 回传动作数据。
- **文字发送场景是否参与：不参与。** 二者都在 send 之后的"任务执行/回传"阶段工作（SendPipeline commitToCloud → ABBffClient.send → 服务端下发 tool/task → TaskDispatcher/RobotManager 执行 → ChatRound/PushMessageCenter 回填 UI）。发送入口链路中不调用它们。

---

## 4. 语音 / 文字分叉点（SlaVoiceBridge 接入）

- 语音链路：长按 AI 键 → `BaseInputView.h9()` 进入录音 → ISpeechService ASR → `BaseInputView$asrCallback$1.e(finalAsr)`（`BaseInputView$asrCallback$1.java:158`）→ `g()`（同文件 59-93）：
  - **无附件时（纯语音）**：先 `SlaVoiceBridge.o(traceId)` 结算 SLA 语音轮，`traceChannel="text"`，`qa(str)` 把识别文案**回填输入框**等用户点发送（语音→键盘模式，不自动发）。
  - **有附件时**：`traceChannel="voice"`，记录 pendingVoiceDurationMs，**直接 `o4(str)` 自动发送**（addMessageCard）。
- 文字发送时（o4:9397-9400）：若上一通道是 voice，取 `SlaVoiceBridge.INSTANCE.q()`（activeVoiceRound 的 traceId）并写 `params[input_channel]=voice`，让这一轮文字发送与 SLA 语音竞速台账（LOCAL_WON/EXEC_FAILED/RESULT_PENDING/LEDGER_PENDING，`SlaVoiceBridge$VoiceSendBind`）对账；发完 `traceChannel` 复位 "text"。迟到 ASR 文案由 `h5()`（8530）回填。
- SlaVoiceBridge（`com/stepos/ailauncher/sla/SlaVoiceBridge.java`）：静态单例，管理 gateBinding(SlaGate)、activeVoiceRound、lateAsrRound、shownUserBubble；`x(ctx,pcm,traceId)` 喂 PCM、`m(...)` 绑定发送、`k(traceId,text)` 迟到回填。

---

## 5. 会话/消息存储

- **Room 数据库 `FwkDatabase`**（`chatcore/session/db/FwkDatabase.java`）：按 uid 分库 `agent_framework_<uid>.db`（MAIN_SESSION_ID="agent:main:main"，另有 feishu/wechat 渠道前缀）；表含 `chat_message`（索引 session_id+time+message_id、pair_id）、`task_result_artifact`、`conversation_title`、InterruptedRoundRow、SessionOpeningMessageRow 等，迁移 1→10。
- **加密：是。** `FwkDatabase.Companion.l(uid)`（341 行附近）：`ChatCoreSdk.d()` 提供 openHelper factory；AiLauncher 侧由 `GlobalApplication.S()`（GlobalApplication.java:1172-1177）注入 `storage/database/cipher/a` → `net.sqlcipher.database.SupportFactory(passphrase)`（a.java:92/116），passphrase 为**设备派生密钥**（C5156a.b(context)，deviceDerivedKey=true），带 PlainToCipherMigrator 明文→密文迁移；factory 返回 null 时抛 "refusing plaintext open"（fail-closed）。密钥不可用时删库重建（CipherKeyUnavailableException）。
  - 注意：各 Activity 里 `import net.sqlcipher.database.SQLiteDatabase` 只是 jadx 把 `FLAG_ACTIVITY_NEW_TASK` 常量折叠成 `SQLiteDatabase.CREATE_IF_NECESSARY`，不是真的用 sqlcipher API。
- 读写入口 `MessageManager`（loadHistory/saveMessages/deleteMessage/replaceMessage/setLikeStatus/runColdStartCleanup），SessionHandler 通过 FwkDatabase 访问；云端同步走 ABBffClient（syncHistory/createConversationSession/…）。

## 6. 三个发送阶段组件

| 组件 | 定义处 | 职责 | 何时介入 |
|---|---|---|---|
| PendingBubbleIds | `send/PendingBubbleIds.java`（send.d） | messageId/imageMessageId/fileMessageId 三 UUID，绑定"乐观上屏的本地用户气泡"与后续服务端消息 | 发送前由 AgentChatLayout.n7() 生成（E.onClicked 内），随 SendContext.ids 贯穿管线；AuditStage 拦截时用它回滚/标记气泡 |
| SessionPrefetchStage | `send/SessionPrefetchStage.java`（名 SESSION_PREFETCH，日志"会话预取"） | 预取/等待云端 session id（canonical sessionKey），deferred CompletableDeferred 可复用并发等待 | 每个 AgentConversation 持有一个（AgentSession.java:117-131）；管线发送前的会话就绪阶段（AgentConversation.prefetch/ensureCanonicalSessionIdForSend） |
| SilentImageStage | `send/SilentImageStage.java`（名 SILENT_IMAGE，日志"问屏上传"） | 等待 silent=true 的截图/图片（问屏静默采集）上传完成，返回 fileId 元数据 Map 合入本轮发送；超时 waitMs（config.silentUploadWaitMs） | AgentConversation.silentImages；携带静默截图的发送轮（BaseInputView.silentScreenshotFile / prepareSilentScreenshot） |

## 7. 锁屏聊天 vs 普通入口

- 入口：`ChatScene.LOCK_SCREEN`（`chat/activity/ChatScene.java:25`）→ `LockScreenChatActivity`（`chat/lockscreen/LockScreenChatActivity.java`，showWhenLocked/独立 task）。
- 内部：host=`C2670c`（lockscreen/C2670c.java）。`f()`：new C3016y（AgentSpace 页面宿主，内含 R$id.agentChatView 的 ChatView）+ FloatCardContainerView → setContentView → `d().setLockScreenMode(true)` → onPageCreate。**即锁屏复用同一套 ChatView/AgentChatLayout/BaseInputView/SessionHandler/V3 管线**。
- 差异点：
  1. `lockScreenMode=true` 传遍 ChatActivity/ChatFragment（ChatFragment.onViewCreated:1073-1075，锁屏下不做 sessionId 恢复、不读 savedInstanceState 会话）。
  2. 解锁交接：LockScreenUnlockActivity + KeyguardManager.dismissKeyguard（UnlockResult SUCCESS/CANCELLED/FAILED/TIMEOUT，60s 超时，unlockHandoffInProgress）。
  3. SCREEN_OFF 广播 → 直接 finish（c$c:198-207；ChatActivity:568 同样逻辑）。
  4. 会话动作经 `L(sessionAction, intent, savedState, sessionKey)` / `T(LockScreenChatAction)` 走 host.d().k0(action)。
  5. ChatActivity 自身也有 lockScreenMode（ChatActivity.java:166,1412,1646），同一 Activity 以锁屏 sheet 形态展示（LockScreenChatSheetActivity）。

## 8. 发送前的最后一道钩子（V3 内部）

- `SessionHandler.a3(owner, hook)`（2248）注册 preSendHook；AiLauncher 侧由 `ChatStopActions.registerPreSendCancel`（`chat/input/ChatStopActions.java:136`）注册 → 协程先 `cancelUnfinishedTasksAwait`（取消未完成旧任务）再继续发送。
- `unfinishedTaskCancel`（1626 setter）同类。二者都存在时 V3 走 `SessionHandler$startSend$3` 协程，否则 `G0` 直发 `sendPipeline.p(ctx)`（SessionHandler.java:1224-1229）。

---

## 附：本报告涉及文件（绝对路径前缀 = 代码根）

- UI：com/stepos/ailauncher/chat/view/BaseInputView.java（f7:2208, C7:1151, Ac:3408, Bc:1132, o4:9392, p4:2858, q4:2940）、MainInputView.java、FloatInputView.java、HomeInputView.java、ChatView.java、UnifiedChatHostView.java、LauncherChatLayout.java
- 框架：com/stepos/agentframework/chatui/AgentChatLayout.java（E:418-449, m3:5704, a7:4753, n7:5956, o3:6100）
- 核心：com/stepos/agentframework/chatcore/SessionHandler.java（V3:1969, G0:1224, H3:1313, R1:1617, a3:2248）、send/SendContext.java、send/PendingBubbleIds.java、send/SessionPrefetchStage.java、send/SilentImageStage.java
- 会话/存储：chatcore/session/AgentSession.java、MessageManager.java、db/FwkDatabase.java、w4/ChatMessage.java、u4/AgentMessage.java
- 语音：ailauncher/sla/SlaVoiceBridge.java、chat/view/BaseInputView$asrCallback$1.java
- 锁屏：ailauncher/chat/lockscreen/LockScreenChatActivity.java、C2670c.java、chat/activity/ChatScene.java
