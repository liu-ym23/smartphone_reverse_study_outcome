# Flow E — 一轮任务结束后的收尾与审计数据流（finalize / audit）

逆向范围：`analysis/decompiled/{ability, AiLauncher, AgentBus, AgentSafetyCenter}/sources`，APK 备份在 `analysis/apks/`。
关键包：`ability` 内 `com.stepos.taskrobot.llmapi.stepfun(.trace)`、`stepai.aios.guiagent.*`、`com.stepos.agentframework.adapter.*`、`com.stepos.agentcache.sdk.*`。
反编译失败的 Coroutine 体（postExecution、chat、uploadStepScreenshot 等）已用 `jadx --fallback` 二次反编译核对（临时产物在 /tmp/trace_fallback，不作为引用源；引用行号以 decompiled 树为准，fallback 行号单独标注）。

---

## 0. 总览：一轮 GUI 任务从收尾到审计的时序

```
用户指令 → ZyqlStepService.chat() ──(每轮)──> BFF 网关 biz-gw.stepaos.com (protobuf ChatCompletionReq)
                       │  ↑ 每轮把本地截图先传 TOS 换 URL（SafeUploadHelper, JPEG q85）
                       │  ↑ 工具结果 = MessageRole.TOOL → Role.System 拼进下一轮 messages
任务 FINISH / cancel / release()
   │
   ├─ releaseDebugCompositor()                       (ZyqlGuiAgentTask.kt, fallback:1604/1703)
   ├─ upLoadLog(meta{appName, finalAction, lastActionMessage, experienceResult}) (fallback:1292/1604/1703)
   │     ├─ V1 GuiAgentTraceManager.postExecution     → 整棵 trace JSON uploadString → TOS
   │     └─ V2 GuiAgentTraceManagerV2.postExecution   → 见下
   │           1. fetchTraceSnapshot(taskId)          ← GuiTracerManager 内存树
   │           2. syncLlmTraceBuffer()                ← StepLLMClient 本地 LLM trace
   │           3. buildTraceRecordsWithUploadedScreenshots → 每步截图 uploadFile → TOS，
   │              截图文件名替换为 TOS objectKey
   │           4. toJsonWithParsedLlmExtra → 补 toolCallId/task_id/session_id/metadata
   │           5. deriveReportOutcome → success/statusCode(200|500)/logLevel/failureReason
   │           6. AgentCacheSdk.reportEvent(traceId,"gui_agent_call",common{msg_type=downlink,…},bizData=全量trace) → Binder → agentcache 应用
   │           7. z2.l.s → AgentCacheSdk.reportLog(traceId,"gui_agent_call",LogMessage(level,"trace_log",traceJson,failureReason)) → agentcache
   └─ 本地落盘：TaskEvidenceStore(filesDir/tasks/<taskId>/)、taskmemory Room、AiLauncher SQLCipher 聊天库
```

---

## 1. ToolResult 回传（结果如何回云端）

### 1.1 Agent 内循环：工具结果作为消息回流 LLM
- `ability/sources/com/stepos/taskrobot/llmapi/stepfun/ZyqlStepService.java`
  - `implements LlmService`（:52）。`chat(LlmChatBizRequest)`（:234，主体 jadx fallback :362-789）流程：
    1. 收集 messages 中所有本地图片（`MessageContent.Image` 的本地路径）与 `MessageContent.ImageBase64`；base64 图先解码落盘 `filesDir/upload_image_<ts>.jpg`，`Bitmap.CompressFormat.JPEG, quality 85`（fallback :557-559）。
    2. `SafeUploadHelper.getUrls(context, paths)`（`stepfun/util/SafeUploadHelper.java`）把图片全部上传对象存储，返回 URL 列表；本地路径→URL 映射替换进消息（fallback :649-650），耗时写入 `TaskStepEntity`（taskmemory）。
    3. `ZyqlLLMRequestBuilder` 组装 OpenAI 风格 `LLMRequest`（model/messages/temperature/topP 默认 0.01/maxTokens/frequencyPenalty）→ Gson JSON → 塞进 protobuf `com.zyql.protobuf.client_agent.ChatCompletionReq.setBody(json)`（fallback :729-734）。
    4. `chat(bytes, traceId, eventListener)`（:325-382）：构造 BFF 请求 `V4.l`（role=user, type=text），路由串 `"Gui|Invoke|ClientAgent|AgentCall"` Base64 后放入请求头字段（:349-359）；鉴权 `AuthTokenCache.getToken()/getUid()` → `ApiManager.updateAuth(AuthInfo(token, uid, "bearer"))`（:362-366）；`ApiManager.chat(ApiType.BFF, …)`（:380）发出。
  - **工具结果角色映射**：`transformRole()` `MessageRole.TOOL → Role.System`（:303-319）——工具结果不作为独立 tool 消息回传，而是折叠为 system 消息拼进下一轮请求；`MessageContent.ToolCalls` 直接 `NotImplementedError`（:180-182）。
  - 网络环境：`Settings.Secure "net_env"`（:273-277）。

### 1.2 云端工具协议（agentframework netcore）
- `ability/sources/com/stepos/agentframework/adapter/netcore/`：
  - `ToolResponse.java` = `{callId, ToolResult{ToolContent{content: List, isError}}}`——云侧 CallTool/CallBack（`BffConstant.Cmd`: Auth/Heartbeat/Invoke/Chat/CallBack/CallTool/…，`bff/BffConstant.java:15-32`）按 callId 对应结果。
  - `TOSUploadHelper.java`：netcore 侧文件上传（`com.zyql.common.utils.upload.UploadManager` + `UploadConfig`），失败抛错；用于 BFF 会话内文件/图片换 URL。
- BFF 传输层 `netcore/service/BffService.java:20-59` 全部方法挂 `@BaseUrl(key="bff_base_url_key")`；`ApiManager.java:1455-1456,2268` 将默认 base url（`M.a.X(context).j()`，系统设置下发）注册到该 key——**端点可远程配置**。网关域见 §6。

### 1.3 最终答案 vs 工具结果
- 最终答案 = 会话最后一条无工具调用的 assistant 输出；执行中经 `ZyqlGuiAgentTask.notifyProgressChanged(action, bitmap, bitmapId, message)`（类元数据 d2 列表）与 GuiTaskProgress 事件流回 AiLauncher。
- `ZyqlStepService$chat$4$1.java:92-99`：每轮 chat 回包记 `GuiActionRecord("llm_chat", …)`，`GuitaskreportManager.addLlmChatAction(taskId, content)` 保存 `lastLlmResponse`（`stepfun/GuitaskreportManager.java:48-66`）——该值即收尾上报里的 `lastActionMessage/output_text`。

---

## 2. GuiAgentTraceManagerV2（轨迹记录/上传/隐私）

包：`ability/sources/com/stepos/taskrobot/llmapi/stepfun/trace/`

### 2.1 记录什么
- 每步 `GuiTraceStep`（`stepai/aios/guiagent/tracer/remote/GuiTraceStep.java:12-42`）：`{stepId, stepIndex, actionType, state, title, message, updatedAt, screenshotFileName, llmTraceId, llmExtra, modelRequestExtra, source}` —— **每步有截图文件名 + 该步 LLM 请求/响应全文（RequestAndResponse JSON）**；坐标级动作细节在 `actionType/title/message` 与 `llmExtra` 中。
- 树：`GuiTraceTreeRecord{nodes[GuiTraceRecord{sessionId, steps[], state, lastResultSuccess, lastErrorMessage…}]}`；快照取自 `GuiTracerManager.getTaskTreeTrace(taskId)`（`GuiAgentTraceManagerV2.java:416-437`，运行时 `ua.C2052a.e`）。
- LLM trace 双缓存：`localLlmTraceCache`（进程内，`cacheLlmTrace` :934-939）+ `LlmTraceCache`（StepLLMClient 侧），finalize 前 `syncLlmTraceBuffer()`（:765-833）拉平。

### 2.2 存哪
- 截图：`TraceScreenshotStore`（`stepai/aios/guiagent/tracer/TraceScreenshotStore.java:56-90`）—— `cacheDir/gui_traces/<sessionId>/<fileName>`，persist(sessionId, stepId, base64)；提供 deleteSession/deleteScreenshot/clearAll。
- 任务证据文本：`TaskEvidenceStore.writeText` → `filesDir/tasks/<taskId>/<fileName>`（`stepfun/TaskEvidenceStore.java:21-42`）。
- 内存报告：`GuitaskreportManager.reports`（LinkedHashMap，动作 captureScreen/llm_chat/StepExecutionInfo + traceId/sjflTraceId + start/endTime，:17-158）。

### 2.3 传哪（两条 TOS 上传 + 两条 agentcache 上报）
- 上传器注册：`app/init/TaskRobotInit.java:154-157` `GuiAgentTraceManager(V2).registerUploader(UploadManager)`。
- `trace/UploadManager.java`（IUpload 实现）：`uploadFile/uploadContent/uploadString`。
- `trace/UploadManager2.java:268-319`：**火山引擎 TOS 对象存储** `TOSV2ClientBuilder().build(REGION, END_POINT, AK, SK)`：
  - `TraceParams.java:23-31`：`BUCKET_NAME="aos-edge-model-test"`，`END_POINT="tos-cn-shanghai.volces.com"`，`REGION="cn-shanghai"`，`OBJECT_KEY="trace_data/"`。
  - objectKey 规则：`trace_data/<yyyyMMdd>-<traceId>/<原文件名>`（UploadManager2.java:303-318 `uploadFile`）。
  - **AK/SK 硬编码加密存放**：`ACCESS_KEY_ENC/SECRET_KEY_ENC` 字节数组，AES-GCM(key=应用签名证书 SHA-256, IV=前 12 字节) 解密（`TraceParams.java:53-82`）——防重打包，但密文随 APK 分发，签名已知即可还原。
- V1 `stepai/aios/guiagent/tracer/remote/GuiAgentTraceManager$postExecution$2.java`（fallback :300-360）：整棵 trace JSON `uploader.uploadString(json, traceId, headers)` → TOS。
- V2 `postExecution`（`trace/GuiAgentTraceManagerV2$postExecution$2.java`，jadx 重解码 :87-371）：
  - `buildTraceRecordsWithUploadedScreenshots`（V2.java:324 + fallback :490-620）：sessionDir=`cacheDir/gui_traces/<sessionId>`，逐 node 逐 step `processStep` → `uploadStepScreenshot`。
  - `uploadStepScreenshot`（fallback :1712-1907）：文件名空→跳过；已是 `http(s)://` → 跳过（执行期已上传）；本地文件（无扩展名则改名加 `.jpg`）→ `uploader.uploadFile` → TOS，返回 objectKey 写回 step。
  - 汇报：`AgentCacheSdk.reportEvent(traceId, "gui_agent_call", commonFields, bizData, …, statusCode)`（postExecution$2 :236/:347，msg_type=**downlink**）+ `z2/l.java:547-563` `reportLog(..., LogMessage(level,"trace_log",traceJson,failureReason), statusCode)`。

### 2.4 隐私处理
- **截图确实上传**：两条路径——(a) 执行期每轮 LLM 请求图（base64→JPEG q85→SafeUploadHelper 换 URL 后发云端）；(b) 收尾期全量 step 截图原文件→TOS `aos-edge-model-test`。未见分辨率缩减（无降采样代码；q85 仅作用于 base64 转档路径）。
- base64 剥离：`sanitizeRequestBase64/sanitizeJsonBase64InPlace`（V2.java:708-757）——LLM 请求 trace 中**以 "base64" 结尾的字段值清空**后 才进 localLlmTraceCache/上报；已换成的 http URL 保留。
- 事件字段：`buildCommonFields`（:909-932）`{trace_id, session_id, msg_type, node_name="gui_agent_call", input_type/output_type="text", input_text={appName,task_name}, output_text=lastActionMessage}`；设备元数据仅 `app_package_name/device_model/sdk_int`（`GuiAgentTraceManagerV2Kt.java:14-27`）。

---

## 3. dashboard_days 写入方（AgentSafetyCenter）

<!-- PENDING-DASHBOARD -->

---

## 4. 会话历史本地存储（AiLauncher）

- **存储形态：Room + SQLCipher 加密，按登录 uid 分库**：`/data/data/<pkg>/databases/agent_framework_<uid>.db`（`AiLauncher/sources/com/stepos/agentframework/chatcore/session/db/FwkDatabase.java:25-31,397-399`；version 10，JournalMode.TRUNCATE :345）。
- 表（`FwkDatabase_Impl.java:109-134`）：`chat_message`（role/status/trace_id/pair_id/like/approval_request_id/ui_actions…）、`message_part`（message_id, part_index, part_type, payload_json；FK 级联删除）、`chat_message_variant`（重新生成快照）、`message_search_document`（搜索镜像）、`conversation_title`（含 delete_status 墓碑、is_temp_session）、agent_info/task_robot_info/task_session_link/session_pending_action/task_result_artifact。
- part_type 枚举（`AgentMessageType.java:11-29`）：TEXT/IMAGE/IMAGE_URL/VIDEO/AUDIO/FILE/FOLDER/TOOL/THINKING_TEXT/TASK/TASK_PLAN/TASK_UPDATE/WORK_ERROR/WORK_COMPLETE/TOOL_SHOW/TOOL_RESULT/UPDATE_RECOMMEND/MODERATION/INQUIRY ——**工具调用与工具结果、思考文本均落库**（Gson JSON）。
- **加密**：SQLCipher（`ailauncher/storage/database/cipher/a.java:70-120` SupportFactory，fail-closed 拒绝明文打开 :138-145）；32 字节口令存 MMKV `secure_key_storage`，Keystore `keystore_v1` 包裹（`q6/c.java`，解包失败 3 次封顶）；丢 key 则弃库。注册链：`GlobalApplication.java:950-954,1170-1179` → `ChatCoreSdk.java:120-134`。
- **一轮结束写库**：`MessageManager.saveMessages` → `x4/v.java:703-746`（`k(List<ChatMessage>)` 单事务：chat_message + parts + search projection + task link + pending approval）。
- **导出**：无聊天导出功能（仅任务产物下载 `ArtifactDownloadController`，走 task_result_artifact.cloud_path）。
- **删除入口**：侧栏 `ChatHistoryView.java:1525,1668-1715`（删除对话→`AgentSession.deleteConversation` :3343，本地墓碑+远端同步删除）；清空会话消息 `clearConversationMessages` :3011；单消息 `MessageManager.f()`；**全库清空** `MessageManager.e()` → `x4/v.java:435-449` 逐表 deleteAll；设置页"清空所有设置（对话、记忆、技能、apiKey 等）"。

---

## 5. 上报通道对照表

| 通道 | 数据 | 触发 | 频率/批量 | 开关 | 去向 |
|---|---|---|---|---|---|
| **agentcache**（LogEvent/LogRecord，Binder AIDL `ILogIngestService.cacheEvent/cacheLog`） | gui_agent_call uplink/downlink 事件（含全量 trace JSON、截图 TOS key、llmExtra）、trace_log 日志、AgentBus `agent_bus_toolcall`（chat.send/session.message 明文 input/output、工具调用、privacy-guard 结果） | 任务 start/upLoadLog 收尾；AgentBus 每条 chat/tool 帧 | 客户端仅内存 pending 队列（默认上限 5，丢旧）；agentcache 应用侧 WorkManager `agent_cache_periodic_upload`/`agent_cache_on_demand_upload` 周期冲网 | 无客户端开关（TaskRobotInit.java:152、AgentBus g3/b.java:148 启动即 init）；需权限 `com.stepos.agentcache.permission.WRITE_AGENT_CACHE` | com.stepos.agentcache 应用（APK 在 apks/agentcache.apk，未反编译入树）→ 云端（host 在该应用内） |
| **TOS 对象存储**（volcengine SDK） | step 截图 jpg、整棵 trace JSON、BFF 会话图片 | 收尾 postExecution；每轮 chat 前置换图 | 即时逐文件 | 无开关 | `tos-cn-shanghai.volces.com` bucket `aos-edge-model-test`，key `trace_data/<yyyyMMdd>-<traceId>/<file>`；AK/SK=APK 内 AES-GCM(签名SHA256) 密文 |
| **statsapp v3**（UXIP 埋点） | 设备标识(imei/imsi/oaid/android_id/mac/sn/umid)+经纬度+页面+事件参数（bootup、技能市场点击、chatview 页面等） | onPageStart/onEvent 等 | realtime 即时；neartime +10s；batch：满 50 条 / 30min / 充电 5min / 断网重连 30s；移动流量日配额 2MB；本地失败重试队列 300 | `Settings.System "stepos_data_collection"`（0=关，逐条检查，`StepOSUtils.java:181-190`）+ 开机向导 `device_provisioned` 门 + 远程配置逐事件开关（uxip-res.stepaos.com，6h 拉取） | 经 binder 到 `com.stepos.dataservice` → `https://uxip.stepaos.com/api/v3/event/{batch,realtime}`（MD5 签名 key `6KAIUyh8oTuWsB0JiE9`，AES key `3CB48439E16F4BB2`，body 加密，HTTP 495 密钥轮换） |
| **logreport/data-report**（taskrobot） | DataReportLogLevel(INFO/WARN/ERROR) 日志、trace_log | postExecution 产物 | 随事件 | 同 agentcache（就是 agentcache 通道的日志半边） | agentcache |
| **APM 崩溃**（旁路） | native crash/log | 崩溃 | 即时 | — | `apmplus.volces.com/monitor/collect/...`（ByteDance APMPlus） |

AgentBus 侧 data-report 细节：`AgentBus/config/DataReportConfig.java`（enabled 默认 true）→ `v4/k.java:530-553` 装 `z5/b.java` 拦截器 id=`"data-report.chat"`，匹配 `source==CHANNEL && type=="req" && method=="chat.send"` 与 `source==GATEWAY && method=="node.event" && event=="session.message"`；sink `z5/c.java` 事件名 `agent_bus_toolcall`，阶段含 cloud_send_plain / claw_downlink_complete / privacy_guard_end / tool_node_invoke_request|result / tool_exec_success|failed；上报实现 `s9/d.java:306-406` → AgentCacheSdk。

---

## 6. taskrobot 的 StepFun API 侧配置

- LLM 通道：`ZyqlStepService`（§1.1）—— BFF 网关（`ApiType.BFF`），base url 运行时由 `bff_base_url_key` 解析（`netcore/service/BffService.java:20-59`、`ApiManager.java:1455-1456`）。
- 已确认网关域（ability 内常量）：
  - `dictionary/DictionaryManager.java:23-24,77`：`https://biz-gw.stepaos.com/dictionary/`
  - `llmapi/stepfun/TrajectorySpeculationLabeler.java:64`：`https://biz-gw.stepaos.com/gui-agent-service/api/llm/chat/completions`（轨迹打标直连 chat completions）
  - `appwhitelist/remote/WhitelistApi.java:11`：`gui-agent-service/api/v1/whitelist`
  - `F1/a.java:48`：经验库 `https://biz-gw.stepaos.com/gui-agent-service/api/`
  - `e1/C1403b.java:117`：`https://biz-gw.stepaos.com/ability-service/`
  - AgentBus 网关备选：`biz-gw.t-stepos.com`、`biz-gw-in.zyql.com`（测试/内网入口）
- **API key 管理**：无静态 API key。`AuthTokenCache`（`stepfun/util/AuthTokenCache.java`）：token/uid 取自账号工具 `f6/C1438c`（系统账号），任务开始时 `refreshForTaskStart`（去重窗口 30min、超时 2s），以 `bearer` 注入 `ApiManager`；`getToken/getUid` 懒加载缓存（:52-94）。TOS 上传凭证则见 §2.3（签名绑定的 AES-GCM 密文 AK/SK）。
- 环境切换：`Settings.Secure "net_env"`（ZyqlStepService:273-277）。
- OkHttp 调优：`trace/LlmNetworkConfig.java`——REGULAR(connect15s/read30s/call60s) / STREAMING(read90s/call120s)，HTTP2+HTTP1.1，性能拦截器打点（:279-331）。

---

## 7. 一轮任务的生命周期终结

<!-- PENDING-LIFECYCLE -->

已确认部分（ZyqlGuiAgentTask，fallback 反编译）：
- FINISH 事件路径：`collectTaskEvents` 收到会话 FINISH → 日志 "[TRACE-DBG] about to call upLoadLog (FINISH)" → `upLoadLog(meta, action, lastMessage)`（fallback :1292）。
- release/cancel 路径：先 `releaseDebugCompositor()` 再 `upLoadLog(...)`（fallback :1604、:1703）。
- `upLoadLog`（fallback :3325-3623）：组 meta（appName/finalAction/lastActionMessage/experienceResult）→ V1 `GuiAgentTraceManager.postExecution` → V2 `GuiAgentTraceManagerV2.postExecution`（含 trace_id、subSessionId）；异常吞掉仅打 "upLoadLog error"——**上报失败不影响任务收尾**。
- 另有 `upLoadLogAgentCache(Map)`（fallback :3629+，类元数据确认存在）。
- 虚拟屏相关 API（类元数据）：`switchToVirtualDisplay`/`switchToMainDisplay`/`release(Boolean, String)`/`setOutputSurface`/`resolveOutputSize`/`handleTargetAppDied`。

---

## 8. 风险与取证要点

1. **截图全量上云**：每步截图 + 整棵轨迹 JSON（含 LLM 请求/响应全文）上传至测试命名的公共 bucket `aos-edge-model-test`（cn-shanghai），仅 base64 字段被清空，URL 不脱敏。
2. **TOS AK/SK 可还原**：AES-GCM 密文+签名 SHA-256 密钥随包分发，重签/已知签名即可解出凭据（TraceParams.decrypt 失败时返回空串并打日志）。
3. **agentcache 是明文遥测汇聚点**：chat.send/session.message 明文 input/output、privacy-guard 决策、工具调用全部经 Binder 汇入该应用再冲网；客户端无开关。
4. **statsapp 采集完整设备标识+位置**（imei/imsi/oaid/mac/sn/经纬度），主开关 `stepos_data_collection` 默认读取值为 0（关），但读取异常时返回 true。
5. 聊天库虽 SQLCipher 加密，但**密钥在 MMKV+Keystore，root/ Frido 下可随库取出**；task 证据（filesDir/tasks/）与 trace 截图（cache/gui_traces/）为明文文件。
