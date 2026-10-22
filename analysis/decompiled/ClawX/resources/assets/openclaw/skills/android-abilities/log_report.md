# log_report — 设备日志抓取

> 来源 App：系统日志服务
>
> ⚠️ **重要背景**：手机开机后系统会**默认自动开始抓取通用日志（generic）**。这意味着大多数情况下日志已经在持续录制中。

---

## ⚠️ 核心行为规则（必须严格遵守）

### 规则1：开始录制前先调用，遇到冲突只问一个问题

用户请求抓日志时，**必须先调用 `start_record_log`**，根据返回结果决定后续动作：

| 返回结果 | 含义 | AI 动作 |
|----------|------|---------|
| 成功 | 开始录制成功 | 告知用户已开始录制 |
| `"Log recording already in progress"` | 当前正在录制中 | 告知用户正在抓日志，**只问一个问题：是否需要停止当前录制** |

**收到 `"Log recording already in progress"` 时，AI 只能问这一个问题，不得追问其他内容：**
> 「当前正在录制日志中。是否需要停止当前录制？」

### 规则2：不支持定时任务

**禁止**设置任何定时任务、自动停止计划或倒计时逻辑。录制的停止完全由用户主动触发。

### 规则3：stop 之后不要再触发 start

调用 `stop_record_log` 停止录制后，**系统会自动重新开始抓取日志**（通用类型）。
**AI 不得在 stop 之后再次调用 `start_record_log`**，否则会造成重复触发。

---

## 开始录制日志

```
ability.call method="start_record_log" params='{"type":"generic"}'
```

用户请求抓日志时，默认使用通用类型（`generic`）开始录制。

### 参数说明

| 参数 | 类型 | 必填 | 说明 |
|------|------|------|------|
| type | string | 是 | 日志类型，见下方类型表，默认使用 `generic` |

### 日志类型参数说明

| type 值       | 名称       | 说明                       |
|---------------|------------|----------------------------|
| generic       | 通用       | 手机通用 Android log（默认）|
| snapshot      | 系统快照   | 采集刚刚产生的日志         |
| jankhot       | 卡顿发热   | 卡顿发热问题日志           |
| modem         | 通讯       | 通讯相关日志               |
| wifi          | WiFi       | 无线网络日志               |
| bluetooth     | 蓝牙       | 蓝牙信息日志               |
| audio         | 音频       | 音频日志                   |
| launcher      | 桌面       | 桌面应用日志               |
| location      | 定位       | GPS定位日志                |
| charge        | 充电       | 充电相关日志               |
| videolog      | 视频       | 视频日志                   |

---

## 停止录制

```
ability.call method="stop_record_log" params='{}'
```

停止当前正在进行的日志录制。调用后系统会**自动重新开始录制通用日志（generic）**，无需手动再次触发。

### 使用场景

- 用户已复现完问题，需要停止录制保存日志
- 用户主动要求停止当前录制
- 收到 `"Log recording already in progress"` 且用户确认需要停止时

---

## ⚠️ 调用前必做：获取节点 ID

**禁止使用 `node="auto"`**，否则报 `"node required"` 错误。
调用前必须先通过 `nodes action="status"` 获取可用节点的完整 ID。

---

## 调用示例

**开始录制通用日志：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=30000 invokeParamsJson='{"method":"start_record_log","params":{"type":"generic"}}'
```

**停止录制：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=30000 invokeParamsJson='{"method":"stop_record_log","params":{}}'
```

**开始录制卡顿发热日志：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=30000 invokeParamsJson='{"method":"start_record_log","params":{"type":"jankhot"}}'
```

**开始录制 WiFi 日志：**
```
nodes action="invoke" node="<节点ID>" invokeCommand="ability.call" invokeTimeoutMs=30000 invokeParamsJson='{"method":"start_record_log","params":{"type":"wifi"}}'
```

---

## 标准交互流程

### 流程1：用户请求抓日志 → 当前无录制

```
用户：帮我抓一下日志
→ 调用 start_record_log(type="generic")
→ 返回成功
→ 提示用户：「已开始录制通用日志，请复现问题后告知我，我来停止录制。」
```

### 流程2：用户请求抓日志 → 当前已在录制中

```
用户：帮我抓一下日志
→ 调用 start_record_log(type="generic")
→ 返回 "Log recording already in progress"
→ 告知用户：「当前正在录制日志中。是否需要停止当前录制？」
  ├─ 用户说「是」→ 调用 stop_record_log()，提示「已停止录制，系统会自动重新开始抓取日志。」
  └─ 用户说「否」→ 不做任何操作，告知用户继续录制中
```

### 流程3：用户主动停止录制

```
用户：可以停止录制了
→ 调用 stop_record_log()
→ 提示用户：「已停止录制，日志已保存。系统会自动重新开始抓取日志。」
（不再调用 start_record_log，系统自动重启录制）
```

### 流程4：用户反馈特定问题，需要抓专项日志

```
用户：手机 WiFi 老是断，帮我抓 WiFi 日志
→ 调用 start_record_log(type="wifi")
→ 如返回成功：提示用户「已开始录制 WiFi 日志，请复现问题后告知我停止。」
→ 如返回 "Log recording already in progress"：
   告知：「当前正在录制日志中。是否需要停止当前录制？」
   └─ 用户确认后：调用 stop_record_log()，再调用 start_record_log(type="wifi")
```

---

## 日志类型选择指南

| 用户问题描述 | 推荐 type |
|-------------|-----------|
| 手机卡顿、发热、掉帧 | jankhot |
| 耗电快、续航差、发热严重 | jankhot |
| WiFi 连不上、断连、速度慢 | wifi |
| 蓝牙配对失败、断开、音质差 | bluetooth |
| 打电话、信号差、通话质量 | modem |
| 充电慢、充不进电、电池异常 | charge |
| 定位不准、GPS 问题 | location |
| 声音问题、音频异常 | audio |
| 桌面崩溃、图标消失 | launcher |
| 视频播放问题 | videolog |
| 不确定 / 通用调试 | generic |
| 快速抓取当前状态 | snapshot |

---

## 功耗与充电场景对比

> ⚠️ **功耗 vs 充电场景区分**
> - **功耗场景（jankhot）**：手机耗电快、待机掉电、续航变短、某个应用特别耗电、发热严重
> - **充电场景（charge）**：充电慢、充不进电、充电发热、电池健康异常
>
> 两者是**完全不同的问题类型**，使用不同的日志类型！

| 对比项 | 功耗场景 (jankhot) | 充电场景 (charge) |
|--------|-------------------|-------------------|
| **典型用户描述** | 耗电快、待机掉电、续航差、某应用耗电、发热 | 充电慢、充不进电、充电发热、电池异常 |
| **日志类型** | `jankhot` | `charge` |
| **录制期间** | **不要充电**，正常使用 | **必须充电**，保持充电状态 |

### 常见误判场景

| 用户说法 | 正确类型 | 说明 |
|----------|----------|------|
| 「手机耗电快」 | jankhot | 功耗问题，不是充电问题 |
| 「电池不耐用」 | jankhot | 续航问题，属于功耗范畴 |
| 「待机掉电严重」 | jankhot | 待机功耗问题 |
| 「某个应用特别费电」 | jankhot | 应用功耗问题 |
| 「手机发烫」 | jankhot | 发热问题，属于功耗范畴 |
| 「充电太慢了」 | charge | 充电速度问题 |
| 「充不进去电」 | charge | 充电功能问题 |
| 「充电的时候特别烫」 | charge | 充电发热问题 |
| 「电池健康度下降」 | charge | 电池状态问题 |

---

## 常见错误

| 错误 | 原因 | 解决 |
|------|------|------|
| `node required` | 用了 `node="auto"` 或没传 node | 先调 `nodes action="status"` 获取具体节点 ID |
| `ABILITY_NOT_FOUND` | 方法名不存在 | 用 `ability.list` 检查可用方法 |
| `invalid type` | 日志类型不支持 | 参考日志类型参数表 |
| `no active recording` | 没有正在进行的录制 | 先调用 `start_record_log` 开始录制 |
| `Log recording already in progress` | 当前已有录制在进行 | 告知用户正在录制，只问是否需要停止 |
