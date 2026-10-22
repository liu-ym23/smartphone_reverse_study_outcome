# StepOS AgentBus (com.stepos.agentbus) 逆向分析报告

- 分析对象：`/home/liu-ym23/Projects/AgenticSmartphoneSafety/STEPX_Neo/0_BasicObservation/1_ReverseEngineering/analysis/decompiled/AgentBus/`（jadx 反编译输出）
- APK 版本：`1.0.26_20260925_135026`（versionCode 100026，compileSdk 36 / Android 16）
- 代码混淆：R8 重命名（`v4.k`、`i5.f`、`n7.a` 等顶层短包名），但 `com.stepos.*` 包名与 Kotlin `@Metadata` 保留，可据此恢复大量语义。
- 下文所有路径均相对于 `.../analysis/decompiled/AgentBus/`，`sources/` 为 Java 源码，`resources/` 为资源。

## 0. 一句话架构

AgentBus 是运行在 **system UID** 下的系统级"智能体消息总线 + 编排器"：对下通过 **Unix 抽象命名空间 LocalSocket（名为 `agentbus`）** 接入本机各 App 内的智能体（BFF peer / node），对上通过 **OpenClaw 云桥（mTLS WebSocket）**、**BFF otter 云长连接（wss）**、**zeroclaw Binder 通道（com.stepos.stepclaw）** 连接云端编排与本地网关，中间做路由（`agent.delegate`/`skills.*`/`memory.*`）、限流、去重、离线队列、隐私拦截与数据上报。

---

## 1. AndroidManifest：组件、接口与"谁能连上总线"

文件：`resources/AndroidManifest.xml`

### 1.1 进程身份（最重要的边界）

```xml
<manifest ... android:sharedUserId="android.uid.system"
    package="com.stepos.agentbus">
```

AgentBus **以 system UID 运行**（platform 签名 + sharedUserId）。它扫描的所有设备包、读写的 `Settings.Secure`、`/mnt/openclaw/rootfs` 等均以此权限进行。

### 1.2 组件清单与 exported 状态

| 组件 | 类型 | exported | 守卫 |
|---|---|---|---|
| `com.stepos.agentbus.platform.StartupActivity` | Activity | false | — |
| `com.stepos.agentbus.platform.diagnostic.DiagnosticActivity` | Activity | false | — |
| `com.stepos.agentbus.platform.AgentBusService` | Service | **false** | — |
| `com.stepos.agentbus.platform.PackageReplacedReceiver` | Receiver | false | — |
| `com.stepos.agentbus.platform.AliveReceiver` | Receiver | **true** | 需持有 `com.stepos.permission.RECEIVE_KEEP_ALIVE`（action `com.stepos.agentbus.KEEP_ALIVE`，实现仅打一行日志，见 `sources/com/stepos/agentbus/platform/AliveReceiver.java`） |
| `com.stepos.agentbus.push.PushReceiver` | Receiver | **true** | 需持有 `com.stepos.cloud.push.permission.MESSAGE`（action `com.stepos.push.intent.MESSAGE` + category `com.stepos.agentbus`） |
| `com.stepos.probe.ProbeInitProvider` | Provider | false | authority `com.stepos.agentbus.probe-init` |
| `androidx.startup.InitializationProvider` / `MultiInstanceInvalidationService` / `ProfileInstallReceiver` | — | false/受 DUMP 权限 | AndroidX 标准组件 |

*English version:*

| Component | Type | exported | Guard |
|---|---|---|---|
| `com.stepos.agentbus.platform.StartupActivity` | Activity | false | — |
| `com.stepos.agentbus.platform.diagnostic.DiagnosticActivity` | Activity | false | — |
| `com.stepos.agentbus.platform.AgentBusService` | Service | **false** | — |
| `com.stepos.agentbus.platform.PackageReplacedReceiver` | Receiver | false | — |
| `com.stepos.agentbus.platform.AliveReceiver` | Receiver | **true** | Must hold `com.stepos.permission.RECEIVE_KEEP_ALIVE` (action `com.stepos.agentbus.KEEP_ALIVE`; the implementation only logs a single line, see `sources/com/stepos/agentbus/platform/AliveReceiver.java`) |
| `com.stepos.agentbus.push.PushReceiver` | Receiver | **true** | Must hold `com.stepos.cloud.push.permission.MESSAGE` (action `com.stepos.push.intent.MESSAGE` + category `com.stepos.agentbus`) |
| `com.stepos.probe.ProbeInitProvider` | Provider | false | authority `com.stepos.agentbus.probe-init` |
| `androidx.startup.InitializationProvider` / `MultiInstanceInvalidationService` / `ProfileInstallReceiver` | — | false/guarded by DUMP permission | Standard AndroidX components |

**关键点：`AgentBusService` 的 `onBind()` 返回的是一个空壳 Binder**（`sources/u5/d.java`，类体只有 `extends Binder` + 持有 service 引用，无 `onTransact`）。也就是说 **AgentBus 不通过 exported Binder Service 对外提供服务**——真正的接入面是：

1. **LocalSocket**（`LocalServerSocket("agentbus")`，抽象命名空间，见 `sources/c6/h.java:117-119`，socket 名默认 `"agentbus"`、最大 64 连接，见 `sources/com/stepos/agentbus/config/LocalSocketConfig.java:77`）；
2. **REST API**（NanoHTTPD，**仅绑定 127.0.0.1:18801**，默认 **disabled**，见 `sources/u5/m.java:17`、`sources/com/stepos/agentbus/config/RestApiConfig.java:74`）；
3. **BlobServer**（NanoHTTPD，**仅绑定 127.0.0.1:18800**，缓存目录 `cacheDir/blobs`，100MB，单次 PUT 上限 32MB，见 `sources/f5/e.java:13`、`sources/com/stepos/agentbus/config/BlobServerConfig.java:87`）；
4. **定向广播** `com.stepos.agentbus.ACTION_BFF_WAKE`（`setPackage(target)`，携带 `source=agentbus` + `traceId`，见 `sources/i5/f.java:899-907`）；
5. 出站：BFF WebSocket、OpenClaw 云 WebSocket、对 `com.stepos.stepclaw` 的 `bindService`、对 `com.stepos.agentcache` 的 `bindService`、对 `com.stepos.pushservice` 的 startService（push 埋点）。

### 1.3 自定义权限

- 声明：`com.stepos.agentbus.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`（signature，AndroidX 自动生成）。
- 引用（由其他系统组件声明）：`com.stepos.zeroclaw.permission.ZEROCLAW_IPC`（zeroclaw 服务端守卫）、`com.stepos.agentcache.permission.WRITE_AGENT_CACHE`（agentcache 服务端守卫）、`com.stepos.permission.RECEIVE_KEEP_ALIVE`、`com.stepos.permission.PUSH`、`com.stepos.cloud.push.permission.MESSAGE`。
- `<queries>`：`com.stepos.stepclaw`、`com.stepos.pushservice`（包可见性）。
- 网络安全配置（`resources/res/xml/network_security_config.xml`）：仅允许 `127.0.0.1`/`localhost` 明文流量，其余默认 TLS。

### 1.4 Binder/AIDL 接口（手写，无 .aidl 文件）

| 接口 | 位置 | 角色 |
|---|---|---|
| `com.stepos.zeroclaw.ipc.IZeroClawService` | `sources/com/stepos/zeroclaw/ipc/IZeroClawService.java` | `sendFrame(Message)→Reply`、`registerCallback/unregisterCallback(IZeroClawCallback)`、`getVersionCode/Name`、`getHealthState`。AgentBus 是**客户端**，绑定 `com.stepos.stepclaw`（`sources/t4/g.java:73-76`，action = DESCRIPTOR） |
| `com.stepos.zeroclaw.ipc.IZeroClawCallback` | 同目录 | `onAsyncReply(int, Reply)`、`onEvent(Message)` |
| `com.stepos.agentcache.ipc.ILogIngestService` | `sources/com/stepos/agentcache/ipc/ILogIngestService.java` | `cacheEvent(s)/cacheLog(s)`；AgentBus 是**客户端**（见 §5） |

*English version:*

| Interface | Location | Role |
|---|---|---|
| `com.stepos.zeroclaw.ipc.IZeroClawService` | `sources/com/stepos/zeroclaw/ipc/IZeroClawService.java` | `sendFrame(Message)→Reply`, `registerCallback/unregisterCallback(IZeroClawCallback)`, `getVersionCode/Name`, `getHealthState`. AgentBus is the **client** here, binding `com.stepos.stepclaw` (`sources/t4/g.java:73-76`, action = DESCRIPTOR) |
| `com.stepos.zeroclaw.ipc.IZeroClawCallback` | Same directory | `onAsyncReply(int, Reply)`, `onEvent(Message)` |
| `com.stepos.agentcache.ipc.ILogIngestService` | `sources/com/stepos/agentcache/ipc/ILogIngestService.java` | `cacheEvent(s)/cacheLog(s)`; AgentBus is the **client** (see §5) |

### 1.5 谁能连上总线（结论）

- **任意第三方 App 不能直接 bind AgentBusService**（exported=false；即便同签名不同 UID 也不行，未导出组件仅同 UID/system 可访问）。
- 第三方 App 若想上总线，必须走 **LocalSocket `@agentbus`**，需通过握手认证：**内核 peer credentials（UID）+ 声明的 packageName 与该 UID 匹配 + 该 UID 属于"签名信任集"**（详见 §7）。实践中即：只有与 AgentBus 同平台签名的 StepOS 系统应用（或共享 system UID 的应用）能接入；普通签名 App 会在 hello 阶段收到 `STEPCLAW_AUTH_DENIED`。
- 云端/网关侧通过 mTLS/token 认证（§4、§6）。

---

## 2. 消息模型：总线上流转什么

### 2.1 内部帧：JSON 文本帧（Moshi）

编解码器 `sources/c5/d.java`：帧 = `Map<String,Object>`，**必有 `"type"` 字段**。帧对象 `c5.b(type, map)`（`sources/c5/b.java`），访问器对应 `id`/`method`/`params`/`source`/`error` 等键。

- 帧类型常量：`"req"`、`"res"`、`"event"`（见 `sources/o4/u.java` 等多处）、握手 `"hello"` / 拒绝 `"hello-error"`（`sources/v4/p.java:238-250`，`{type:"hello-error", id, ok:false, error:{code:"STEPCLAW_AUTH_DENIED", message}}`）。
- 方法/事件名（实测出现）：
  - 业务方法：`chat.send`、`chat.stream`、`tick`（`sources/v4/k.java:448`）；`agent.call`（REST debug 调用）；`agent.delegate`、`skills.*`、`memory.*`（静态路由表，`sources/v4/k.java:223`：`d0("agent.delegate",null,100)`、`d0("skills.*",null,90)`、`d0("memory.*","stepclaw",90)`——`memory.*` 被**钉死路由到 stepclaw**）。
  - 网关侧：`node.event`（payload `session.message`）、`node.invoke.result`、`node.caps-update`（`sources/s5/e.java`）。
  - zeroclaw 帧格式（JSON-RPC 风格，`sources/n7/a.java:51-66`）：`{"type":"request","id":"zc-<nanoTime>","method":...,"params":{...}}`。
  - stepclaw 系统事件（`sources/v4/k.java:56`）：`stepclaw.status.change`、`stepclaw.bypass.engaged/recovered`、`stepclaw.config.update`、`stepclaw.metrics.snapshot`、`stepclaw.skills.changed`、`stepclaw.tools.changed`、`stepclaw.config.model.changed`、`stepclaw.files.changed`、`stepclaw.cronjobs.changed`、`stepclaw.channels.changed`、`stepclaw.gateway.changed`。
  - LLM 会话事件（`sources/o4/u.java`，OpenClawAdapter）：`agent_bus_toolcall`、`llm_tool_result`（携带 `toolCallId/toolName/args/error`）、会话消息 role=`user/assistant`、`sessionKey/runId/spawnedBy` 等元数据。
- 连接模型：`sources/d5/e.java`（连接接口：`getId/getClientId/role/state/send`），角色枚举 `d5.m` = **{NODE, CHANNEL, CONSOLE, GATEWAY}**，层级 `d5.t` = **{CLOUD, EDGE}**。路由决策含在线稳定窗口与降级控制器（`sources/o5/e.java` DegradationController，`sources/v4/k.java:599` RouterConfig.onlineStableWindowMs）。
- 离线队列：Room 数据库 `agentbus_offline_queue.db`，表 `offline_frame`、`offline_frame_tombstone`（`sources/com/stepos/agentbus/domain/queue/OfflineQueueDatabase_Impl.java`），按 `offlineFrameTTL` 重放。
- 基准/轨迹：benchmark 记录器把帧写到 `/sdcard/Documents/clawbench/<sessionKey>/agentbus.txt`（`AgentBusService.dump()` 的 `bench on` 命令，`sources/com/stepos/agentbus/platform/AgentBusService.java:145-162`；`sources/v4/k.java:566`）。

### 2.2 云端信道：protobuf（MessageLite）

`sources/com/stepos/protobuf/connection/`（`l4/`、`b7/` 等混淆包为实现）：

- `Head`：`msgId`、`module`、`command`（字符串）、`frameType`、`msgType`（int）、`meta`（map<string,string>）。
- `StreamMsg`：`head` + `body`（bytes，任意嵌套消息）。
- `Tool`：`id/name/description/version/parameters(map)`；
- `ToolCall`：`callId` + `tool` + `params`（`ToolCallParams.params` 为**字符串**，实为 JSON）+ `result`（`ToolCallResult.result` 字符串）。
- 云推送到达时会用 Head.meta 里的 `Zyql_SessionId / Zyql_TraceId / Zyql_ToolCallId` 与 `packageName` 解出 ToolCall 并注入总线（`sources/com/stepos/agentbus/push/PushReceiver.java:28-74`）。

### 2.3 BFF protobuf

`sources/com/stepos/agentbus/agents/bff/proto/`：

- `StreamMsg{head,body}`、`Head` 字段与 connection 包相同；
- `AuthBindReq`：`uid, token, tokenType, device, did, product, platform, appVersion, channel, reserved(map)`；
- `AuthBindResp`：`code, conn, uid, logined, new, error`；
- `HeartbeatReq`（空）/ `HeartbeatResp{interval}`；
- `ErrorResp{code, reason}`。

### 2.4 拦截器管道（编排核心）

容器把若干 `s5.d`（InvokeInterceptor）挂在发送链上（`sources/v4/k.java:535-554`）：

1. `sources/v4/l.java`（基础）；
2. `sources/s5/e.java` `openclaw.invoke-interceptor`：处理 `node.caps-update` / `node.invoke.result` / `stepclaw.caps.update`，维护能力注册表（capabilityRegistry，含 `added/removed` 工具差异）；
3. `sources/t5/f.java` `privacy-guard`：拦截 `chat.send`，结合息屏状态（`i5.l` ScreenStateMonitor）与 sessionId 做隐私控制（PrivacyConfig.enabled）；
4. `sources/z5/b.java` `data-report.chat`：**捕获 CHANNEL 的 `req/chat.send` 与 GATEWAY 的 `node.event/session.message` 并上报**（DataReportConfig.enabled）；
5. vendor 适配器（`gateway.vendor == "openclaw"` 时注册 `s5.e` + `nb.f`，`sources/v4/k.java:546-551`）。

调用关联由 `sources/h5/g.java` InvocationMapper（upstreamId/downstreamId/upstreamConnId/downstreamConnId，带 TTL 与 maxEntries）完成，去重由 `h5.b`（windowTtlMs/maxEntries）完成。

---

## 3. agents/bff：是什么 + 全部"agent 类型"

**BFF 在此语境中是 "Backend-For-Frontend" 云长连接桥**，不是云端编排器本身；同时它也承担"唤醒本机各 App 内 peer agent"的职责：

- 云侧：`sources/x4/i.java` BffGatewayClient——OkHttp WebSocket 连接 `wss://otter-connection.stepaos.com/ws`（prod）/ `wss://test-otter-connection.t-stepos.com/ws`（test）（`sources/s1/u.java:197-199`）。连接后发送 protobuf `AuthBindReq`（token 来自账户系统，见 §7），心跳 `HeartbeatReq/Resp(interval)`；息屏且无上行数据时断开（`skip connect: screen off and no pending uplink`）、空闲断连 `idleDisconnectMs=900000`、`screenOffIdleMs=30000`、重连 2s→60s 指数退避（`BffBridgeConfig` 默认值，`sources/com/stepos/agentbus/config/BffBridgeConfig.java:146`）。
- 端侧 peer：`sources/i5/f.java` **AndroidPeerLauncher**——BFF 云端下发"需要某 App 内 agent"时，向该 App 发送定向广播 `com.stepos.agentbus.ACTION_BFF_WAKE`（`setPackage(pkg)`，extras：`source=agentbus`、`traceId`），并带**每包唤醒限流**（`bff wake throttled for package=...`）。peer App 被唤醒后自行连上 LocalSocket 总线并注册能力。
- 下行分发：`i5.f.V()`（`sources/i5/f.java:834-919`）按三种路由语义选择目标包：定向（订阅包列表 `p5.k`）、默认路由（`p5.j`，取已注册 peer 的包名）、按 agentId 广播（`p5.l`，匹配 `sVar.f8485b`）。

**"agent 类型"的完整枚举**（代码中以连接 role/tier + client 表达，无中心化 agent 类型注册表）：

1. **role 维度**（`d5.m`）：`NODE`（本机节点，如 stepclaw 网关节点）、`CHANNEL`（业务信道/App 内 peer）、`CONSOLE`（控制台/调试）、`GATEWAY`（网关，如 zeroclaw）。
2. **tier 维度**（`d5.t`）：`CLOUD`（云端链路）、`EDGE`（边缘/本机）。
3. **具体连接实例**（容器装配，`sources/v4/k.java` + `sources/s1/u.java:200`）：
   - `zeroclaw`（`sources/s4/b.java`）：id="zeroclaw"，role=GATEWAY，tier=CLOUD——经 Binder 连 `com.stepos.stepclaw`；
   - OpenClaw 云桥（`q5.q` 主编排循环 + `o4.u` OpenClawAdapter）：tier=CLOUD，`claw-connection-socket-mtls.stepaos.com:443/ws/device`（prod，mTLS）/ `claw-node-connection-socket.stepos.com:443/ws/device`（test）；
   - OpenClaw 本地网关 upstream：`127.0.0.1:18789`（`OpenClawGatewayUpstream`，`sources/s1/u.java:182`）；
   - BFF 桥（`x4/i` + `i5/f` AndroidPeerLauncher）：App 内 peer agents（clientId=包名）；
   - 两个离线转发器 `p5.h`："GATEWAY"（d5.m.GATEWAY→CLOUD）与 "CHANNEL"（d5.m.CHANNEL→null/本机）（`sources/v4/k.java:600-601`）；
   - LocalSocket 接入的本机 NODE 客户端；
   - Edge 连接（`EdgeConfig host/port`，`sources/com/stepos/agentbus/config/EdgeConfig.java`）。
4. **能力（capability）而非类型**：peer 通过 `node.caps-update`/`stepclaw.caps.update` 上报工具/技能集（`added/removed`），云端用 `agent.delegate` 按方法名路由（优先级 `agent.delegate`100 > `skills.*`90 == `memory.*`90-固定 stepclaw）。OpenClaw 节点自身的资源布局见 `sources/m4/u0.java`：`root/.openclaw/{openclaw.json, agents/main/agent/{SOUL.md,IDENTITY.md,MEMORY.md,USER.md,TOOLS.md,AGENTS.md,auth-profiles.json,models.json}, skills/, workspace/, cron/jobs.json, extensions}`，默认 rootfs `/mnt/openclaw/rootfs`（`ResourceConfig("openclaw","/mnt/openclaw/rootfs")`）。

---

## 4. zeroclaw 是什么

`com.stepos.zeroclaw` 是 AgentBus 与 **`com.stepos.stepclaw`（StepClaw，本机智能体运行时/网关 App）** 之间的进程间通道协议，名字含义可理解为"零延迟爪桥"（与 stepclaw 配对的产品命名）：

- 接口：`IZeroClawService.sendFrame(Message):Reply`，`Message/Reply` 都只是 `Parcelable` 包一个 **`frameJson` 字符串**（`sources/com/stepos/zeroclaw/ipc/Message.java`、`Reply.java`）——即 JSON 帧直接跨进程透传；异步回执与事件经 `IZeroClawCallback.onAsyncReply/onEvent`。
- 客户端 `sources/t4/g.java`（ZeroClawConn）：`bindService(Intent(IZeroClawService.DESCRIPTOR).setPackage("com.stepos.stepclaw"))`，连接态 StateFlow + 断线重连协程；连接包装 `sources/s4/b.java` 将其注册为总线上的 **GATEWAY/CLOUD 连接（id="zeroclaw"）**，`acceptsBusinessRpc=true`。
- 服务端权限：manifest 中申请 `com.stepos.zeroclaw.permission.ZEROCLAW_IPC`——说明 stepclaw 侧的 service 用该（一般是 signature）权限保护，只有授权 App 能调用。
- 运行时诊断（`AgentBusService.dump "status"`）会打印 `gateway vendor`（openclaw）与 cloud bridge 状态；`a3/b.java` 中出现 `ZeroClawGatewayVendor` 指标。stepclaw 自身不在本 APK 内。

**定位：zeroclaw = 设备内"第二网关"高速通道**，让 AgentBus 无需经 TCP 即可把 JSON 帧交给 stepclaw 进程处理（stepclaw 再对接 OpenClaw 云/本地 18789 端口网关），属于智能体编排的内环。

---

## 5. agentcache：缓存什么、跨应用共享什么

`com.stepos.agentcache` 是**遥测/日志的跨应用汇聚缓存 SDK**（服务端在独立 App `com.stepos.agentcache` 中，不在本 APK）：

- 服务契约（`sources/com/stepos/agentcache/core/ServiceContract.java`）：绑定 `action = com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE`、`package = com.stepos.agentcache`，**调用方需持有 `com.stepos.agentcache.permission.WRITE_AGENT_CACHE`**（AgentBus manifest 已申请）。后台任务名：`agent_cache_periodic_upload` / `agent_cache_on_demand_upload`（WorkManager 周期/按需上传云端）。
- 数据结构（`sources/com/stepos/agentcache/ipc/LogEventParcel.java`）：
  `traceId, nodeName, eventTime, timestamp, statusCode, appName, appVersion, commonFieldsJson, bizDataJson`——**以 traceId 为主线**的业务事件（bizDataJson 为业务 JSON 载荷）；另有 `LogRecordParcel` 文本日志（level/message）。
- 客户端（`sources/com/stepos/agentcache/sdk/internal/LogSdkClient.java`）与门面 `AgentCacheSdk`（`sdk/api/AgentCacheSdk.java`，配置 `servicePackageName/maxPendingEvents/enableDebugLog`），ID 用 ULID（`sdk/utils/ULID.java`）。
- **谁在喂数据**：`sources/z5/b.java`（data-report.chat）在 `DataReport.enabled` 时把 **`chat.send`（用户聊天输入）与 `session.message`（LLM 会话消息）** 交给 DataReportCoordinator（`z5.c`）→ agentcache → 云端上传；另 `sources/n7/a.java:695-719`（UsageStatsUtils）向 `com.stepos.pushservice` 发 `PUSH_TRACKER_SERVICE` 埋点（en/ti/ts/pn/pv=5.0.7/nm/si/di）。
- **跨应用共享面**：任何集成了该 SDK 且持有 WRITE_AGENT_CACHE 权限的 App 都可写入同一缓存服务；数据以 `appName/appVersion/nodeName` 区分来源、`traceId` 串联跨 App 链路。对 AgentBus 而言，这意味着**总线上的会话内容可离开总线进入共享遥测管道**——隐私边界取决于 agentcache App 侧的权限保护级别与云端策略。

---

## 6. cloud/securedata：传输保护方案

SDK：`com.stepos.cloud.securedata`（`sources/com/stepos/cloud/securedata/StepOSCloudSecureDataSdk.java`），配套密钥中心（key-center）。

### 6.1 流程

1. `init(context, SdkConfig{appId, deviceId})` → `n7.a.x()`（`sources/n7/a.java:729-765`）读取 `Settings.Secure("net_env")` 选择环境：`TEST→t-stepos.com`、`PROD→stepos.com`，密钥中心 `https://biz-gw.<domain>/key-center`；同时构造 appId/secret 对（`y6.a`，secret 见 §8 硬编码）。
2. `getPublicKey()`：从 DataStore 缓存（`w6.j` publicKeyStore）或网络取服务端 RSA 公钥（PublicKeyRequest/Response）。
3. `exchangeSessionKey()`（`w6.x.b/e`）：设备生成 **32 字节随机 `deviceSk`（AES-256 会话密钥）**，用服务端公钥 **RSA-OAEP(SHA-256, MGF1-SHA256)** 包裹得 `encryptedAesKey`（会话对象 `w6.y` SecureSession：appId/deviceId/deviceSk/encryptedAesKey/idKey），POST 到 key-center 换回 `idKey`（8 字节服务端 key id）。
4. `encrypt/decrypt`（`x6/a.java`）：
   - 密文布局：`'Z''Y'` 魔数(2B) + `idKey`(8B 大端) + **12B IV** + AES-GCM(ct||tag128)（`x6.a.d/e/c`，`Cipher "AES/GCM/NoPadding"`，`GCMParameterSpec(128, iv)`）；
   - 解密时校验魔数、长度 ≥22、**idKey 必须匹配当前会话**（防跨密钥重放，`keyId mismatch expected=... got=...`）；
   - `deviceSk` 仅存内存（`w6.a` 单例，`Arrays.copyOf` 返回副本），密文/明文日志经 `SecureDataLogSanitizer` 只输出 64 字符预览（可开关 fullLogValues）。
5. 网关时间同步（`internal/gateway/GatewayTimeApiResponse`）与 HTTPS 传输（`http/SecureDataHttpClient.java`）。

### 6.2 其他相关加密

- 云长连接（prod）`mtlsRequired=true` + `mtlsClientCertAlias` + `mtlsFallbackEndpoint`（`OpenClawCloudUpstream` 字段，`sources/com/stepos/agentbus/config/OpenClawCloudUpstream.java`）。
- 本地 trace/audit 日志（`filesDir/logs`，traceLog/auditLog 分文件，容量/保留期可配）用 `h4/e.java` 的 AES-GCM 计数器 IV 流加密。
- `i5/l.java` 中出现的 `AES/ECB/NoPadding` 是 **Tink AES-CMAC 实现**（jadx 类合并所致），用于消息认证，不是数据加密缺陷。
- 推送/REST 明文仅限 127.0.0.1（network_security_config）。

---

## 7. 身份认证：总线如何鉴别接入方 + 薄弱点

### 7.1 LocalSocket 接入认证（核心机制）

实现于 `sources/v4/p.java`（`a()` 连接处理，jadx 反编译不完整但控制流字符串完整保留）与容器构造 `sources/v4/k.java:262-312`：

1. **签名信任集（SignatureTrust）**：容器初始化时读取自身签名，遍历**所有已安装包**，把与自身签名集合一致（逐证书 SHA-256 比对，`d7.n.n0(bytes,"",s1.u(8),30)`）的包的 UID 加入 `LinkedHashSet`（含自身 UID）；日志 `"SignatureTrust: discovered N trusted uids ... matches=pkg#uid,..."`；失败回退 `"cannot read own signatures, falling back to myUid only"`。该集合作为 authenticator（`a7.d(14, setS)`）传入 LocalSocket 服务端 `v4.p`。
2. **握手**：客户端连上 `@agentbus` 后发 hello（含自报 packageName）。服务端依次校验：
   - `"missing peer credentials"`——从 `LocalSocket` 取**内核级 peer UID**（等价 SO_PEERCRED，不可伪造）；
   - `"packageName mismatch for peer uid"`——自报包名经 `PackageManager.getPackageUid` 必须映射到同一 UID（防冒名）；
   - UID ∈ 签名信任集（authenticator）。
   任一失败 → 回 `hello-error {code:"STEPCLAW_AUTH_DENIED"}` 并关闭（`v4/p.b()`）。
3. 之后连接进入连接池（`d5.l`），peer 可注册 capability、收发 JSON 帧；第三方专用限流 `RateLimitConfig.thirdparty(reqPerSec, burst)`。

### 7.2 云端/服务间认证

- **BFF otter 云**：OAuth 账户 token——`sources/v5/c.java`（MzAccountToken）监听 `AccountManager`（账户类型 `com.stepos.account`，`sources/com/stepos/account/oauth/OAuthConstants.java:6`），取 access_token 填入 `AuthBindReq.token`；`logined/uid` 由 AuthBindResp 确认。支持 `DebugAccountConfig{enabled, debugAccountToken}`（**debug 模式直接返回静态 token**，`v5/c.a():96-101`；当前工厂默认 disabled，`sources/s1/u.java:200` 传 `DebugAccountConfig(false,null)`）。
- **OpenClaw 云桥**：appId+secret（challenge 三元组 `challengeApiBaseUrl/challengeAppId/challengeAuthToken/challengeGatewayAppId/challengeGatewaySecret`）+ 设备密钥文件 `deviceKeyFile` + `bootstrapToken` + **mTLS 客户端证书**（prod 强制）。
- **REST /v1**：`gateway.auth.token` 不可用时返回 `NO_GATEWAY_TOKEN ... ensure stepclaw gateway is up`（`sources/u5/s.java:225,346`），说明云调用 token 由 stepclaw 网关签发。
- **pushservice**：签名权限 `com.stepos.cloud.push.permission.MESSAGE` 保护 PushReceiver。

### 7.3 薄弱点与风险清单（按严重度）

1. **硬编码云端凭证（高）**：`sources/s1/u.java:184` 与 `sources/n7/a.java:757-763` 内嵌 prod/test 的 appId+secret（challengeAppId/challengeGatewaySecret/key-center secret），任何人解包即可获得，可被用于伪造设备侧客户端调用 biz-gw（除非云端有额外设备绑定）。
2. **localhost 服务无逐请求鉴权（中）**：REST(18801) 与 BlobServer(18800) 只绑 127.0.0.1、无 token——**设备上任意 App 均可访问**。REST 默认 disabled 缓解了前者，但 **BlobServer 默认常驻**：任意 App 可 PUT（≤32MB）填满 system 应用的 cacheDir（DoS/污染），亦可尝试 GET 已缓存 blob（跨应用数据读取面）。REST 若被配置打开，`/v1/admin/debug/system-run`、`/v1/admin/debug/agent-call`、`/v1/channels/*/chat` 即对全设备 App 开放（能借总线身份发起 agent 调用）。
3. **信任粒度粗（中）**：LocalSocket 认证只看"同平台签名 UID"，不区分包的细分授权——任何 platform 签名 App 一旦接入即拥有完整 agent 委派/工具调用权（`agent.delegate` 等无 per-app ACL；仅 `memory.*` 钉到 stepclaw、thirdparty 限流）。且信任集**只在容器构造时扫描一次**，之后新装的同签名包需等进程重启才被信任（反之卸载不即时剔除）。
4. **ACTION_BFF_WAKE 可被伪造（低-中）**：该广播无发送方权限校验（接收方在 peer App 内），任意 App 可向 peer App 发此 action 触发其 agent 链路启动（消费电量/触发上行）。影响取决于 peer 侧实现。
5. **benchmark/诊断落盘（低-中）**：`dump` 接口可开启把帧写入 `/sdcard/Documents/clawbench/`（外部存储，需 shell/root 触发 dumpsys，但文件本身可能被具备媒体权限的 App 读取），帧内含会话内容。
6. **隐私链路（关注）**：`data-report.chat` 会把 `chat.send` 与 `session.message`（即用户输入与模型输出）送入 agentcache 共享管道并上传（有 `PrivacyConfig`/`DataReportConfig` 开关，工厂默认值未显式开——`950255` 掩码下 dataReport/privacy 均取默认 false，但云控可下发配置）。
7. **离线队列明文（低）**：`agentbus_offline_queue.db`（Room/WAL）明文存帧（含会话），位于 system UID 私有目录，风险有限但取证敏感。
8. **认证实现的实现级细节无法完全核对**：`v4.p.a()` 与 `w6.x.a()`（RSA 包裹段）jadx 反编译失败，结论基于保留的字符串/调用链/字段；如需逐行验证建议对这两个方法做 smali 级复查。

---

## 8. 关键常量与端点速查

| 项 | 值 | 出处 |
|---|---|---|
| LocalSocket 名 | `agentbus`（max 64 conns） | `config/LocalSocketConfig.java:77` |
| REST API | `127.0.0.1:18801`（默认关） | `config/RestApiConfig.java:74`、`u5/m.java:17` |
| BlobServer | `127.0.0.1:18800`，cache 100MB，PUT≤32MB | `config/BlobServerConfig.java:87`、`f5/e.java:13` |
| OpenClaw 本地网关 | `127.0.0.1:18789` | `s1/u.java:182` |
| OpenClaw 云（prod） | `claw-connection-socket-mtls.stepaos.com:443/ws/device`，mTLS=on，api `https://biz-gw.stepaos.com`，appId `7f1285a1cce243508c58e3a4c0fa4ae2`，secret `bt6bI9U7wKl8FwT6tJ3u` | `s1/u.java:184` |
| OpenClaw 云（test） | `claw-node-connection-socket.stepos.com:443/ws/device`，api `https://biz-gw.t-stepos.com`，appId `9fb1602ed92541a7bdabd0ce66cd45ce`，secret `9pv65zQUtnH2huYnRPCE` | `s1/u.java:184` |
| BFF WS（prod/test） | `wss://otter-connection.stepaos.com/ws` / `wss://test-otter-connection.t-stepos.com/ws` | `s1/u.java:198` |
| 推送网关 | `https://biz-gw.stepaos.com/`（prod）、`biz-gw-in.zyql.com`（stg）、`biz-gw.t-stepos.com`（test/dev） | `config/PushConfigKt.java:15` |
| key-center | `https://biz-gw.stepos.com/key-center`（secret 同上） | `n7/a.java:753-763` |
| 账户类型 | `com.stepos.account` | `OAuthConstants.java:6` |
| rootfs | `/mnt/openclaw/rootfs` | `s1/u.java:200` |
| 基准输出 | `/sdcard/Documents/clawbench/<sessionKey>/agentbus.txt` | `AgentBusService.java:157` |
| 环境切换 | `Settings.Secure("net_env")` ∈ {test, stg, dev, 其他=prod} | `n7/a.java:734`、`u5/f.java` |

*English version:*

| Item | Value | Source |
|---|---|---|
| LocalSocket name | `agentbus` (max 64 conns) | `config/LocalSocketConfig.java:77` |
| REST API | `127.0.0.1:18801` (off by default) | `config/RestApiConfig.java:74`, `u5/m.java:17` |
| BlobServer | `127.0.0.1:18800`, cache 100MB, PUT≤32MB | `config/BlobServerConfig.java:87`, `f5/e.java:13` |
| OpenClaw local gateway | `127.0.0.1:18789` | `s1/u.java:182` |
| OpenClaw cloud (prod) | `claw-connection-socket-mtls.stepaos.com:443/ws/device`, mTLS=on, api `https://biz-gw.stepaos.com`, appId `7f1285a1cce243508c58e3a4c0fa4ae2`, secret `bt6bI9U7wKl8FwT6tJ3u` | `s1/u.java:184` |
| OpenClaw cloud (test) | `claw-node-connection-socket.stepos.com:443/ws/device`, api `https://biz-gw.t-stepos.com`, appId `9fb1602ed92541a7bdabd0ce66cd45ce`, secret `9pv65zQUtnH2huYnRPCE` | `s1/u.java:184` |
| BFF WS (prod/test) | `wss://otter-connection.stepaos.com/ws` / `wss://test-otter-connection.t-stepos.com/ws` | `s1/u.java:198` |
| Push gateway | `https://biz-gw.stepaos.com/` (prod), `biz-gw-in.zyql.com` (stg), `biz-gw.t-stepos.com` (test/dev) | `config/PushConfigKt.java:15` |
| key-center | `https://biz-gw.stepaos.com/key-center` (secret as above) | `n7/a.java:753-763` |
| Account type | `com.stepos.account` | `OAuthConstants.java:6` |
| rootfs | `/mnt/openclaw/rootfs` | `s1/u.java:200` |
| Benchmark output | `/sdcard/Documents/clawbench/<sessionKey>/agentbus.txt` | `AgentBusService.java:157` |
| Environment switching | `Settings.Secure("net_env")` ∈ {test, stg, dev, others=prod} | `n7/a.java:734`, `u5/f.java` |

## 9. 主要文件索引

- 平台层：`sources/com/stepos/agentbus/platform/{AgentBusApp,AgentBusService,AliveReceiver,PackageReplacedReceiver,StartupActivity,diagnostic/DiagnosticActivity}.java`、`push/PushReceiver.java`
- 配置：`sources/com/stepos/agentbus/config/*.java`（20 个配置段；工厂 `sources/s1/u.java`）
- 容器/路由：`sources/v4/k.java`（DI+SignatureTrust）、`v4/p.java`（LocalSocket 认证）、`c6/h.java`（LocalServerSocket）、`q5/q.java`（编排循环）、`o5/e.java`（降级）、`h5/g.java`（invocation 映射）
- 连接：`d5/{e,m,t}.java`、`s4/b.java`+`t4/g.java`（zeroclaw）、`x4/i.java`（BFF WS 客户端）、`i5/f.java`（AndroidPeerLauncher）
- 拦截器：`s5/e.java`（caps）、`t5/f.java`（privacy-guard）、`z5/b.java`（data-report.chat）
- 云适配：`o4/u.java`（OpenClawAdapter）、`m4/u0.java`（OpenClaw rootfs 资源）
- protobuf：`sources/com/stepos/protobuf/connection/*.java`、`sources/com/stepos/agentbus/agents/bff/proto/*.java`
- zeroclaw IPC：`sources/com/stepos/zeroclaw/ipc/*.java`
- agentcache：`sources/com/stepos/agentcache/**`
- securedata：`sources/com/stepos/cloud/securedata/**` + 混淆实现 `sources/w6/*.java`、`sources/x6/{a,b}.java`
- 遥测：`sources/com/stepos/probe/*`（PerfettoSink、PowerCollector、SysfsProbe、clawbench_probe 埋点）
