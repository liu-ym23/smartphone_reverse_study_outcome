# 附录：完整名单与规则数据 / Appendix: Complete Lists & Rule Data

> 本附录是 REPORT.md 各结论的**完整枚举数据**，所有名单逐项列出，不再省略。

> 数据来源：① 设备实测（content call，2026-10-20，rules_version=344978）；② APK 内置资源（res/raw、assets）；③ 反编译源码常量。每节标注来源。

> 表头采用中英双语；内容为技术标识符（原名保留）。

---

## 附录 A｜权限组模型（22 组，实测值）

来源：`content call content://com.stepos.agentsafetycenter.permission --method getSnapshot`（live_permission_snapshot.txt）

模式语义：allow=静默放行｜ask_always=每次询问｜ask_on_sensitive=敏感场景询问｜off=禁用

| # | 权限组 Group | 当前模式 Current | 可选模式 Available |
|---|---|---|---|
| 1 | `assistant.voice` | **allow** | allow, ask_always |
| 2 | `screen.understanding` | **ask_always** | allow, ask_always |
| 3 | `location` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 4 | `system.settings` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 5 | `contact` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 6 | `phone.calllog` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 7 | `message.notification` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 8 | `calendar.todo` | **allow** | allow, ask_always |
| 9 | `media.gallery` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 10 | `audio` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 11 | `note.document` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 12 | `file.workspace` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 13 | `app.clipboard` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 14 | `thirdparty.service` | **allow** | allow, ask_always |
| 15 | `thirdparty.order` | **ask_always** | allow, ask_always |
| 16 | `app.manage` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 17 | `network.web` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 18 | `automation.schedule` | **allow** | allow, ask_always |
| 19 | `agent.session` | **allow** | allow, ask_always |
| 20 | `sandbox.shell` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |
| 21 | `device.remote` | **ask_always** | allow, ask_always |
| 22 | `gateway.admin` | **ask_on_sensitive** | allow, ask_on_sensitive, ask_always |

共 22 组。第三方 App 的组（thirdparty.service/thirdparty.order）当前 allow/ask_always。

---

## 附录 B｜Ledger 台账规则（rules_version=344978）

### B.1 command_tools（OpenClaw 命令通道工具，6 项）

- `ability`
- `bash`
- `exec`
- `invoke_android_ability_cli_exec`
- `nodes`
- `shell`

### B.2 tool_allow（免确认白名单，10 项）

调用这些工具不触发授权卡：

- `agents_list`
- `ask_user`
- `chat_history`
- `commands_list`
- `get_android_ability`
- `gui_agent`
- `health`
- `models_authstatus`
- `models_list`
- `sessions_list`

> ⚠️ 注意 `gui_agent`（GUI 自动化总开关）在此清单中——意味着「把屏幕交给 GUI 机器人」本身不询问，询问发生在后续具体敏感工具上。


### B.3 tool_scope（工具名→权限范围别名，5 项）

| 工具名 Tool | 映射权限范围 Mapped scope |
|---|---|
| `process` | `sandbox.process.manage` |
| `task_create` | `task.plan.update` |
| `task_result_submit` | `task.plan.update` |
| `todo_write` | `task.plan.update` |
| `web_search` | `web.search` |

### B.4 完整工具→权限组/数据级别映射（119 项，按组排列）

| 权限组 Group | 工具 Tool | 级别 Level |
|---|---|---|
| `agent.session` | `agent.registry.read` | D1 |
| `agent.session` | `agent.workflow.yield` | D1 |
| `agent.session` | `agent.delegate.manage` | D2 |
| `agent.session` | `agent.delegate.spawn` | D2 |
| `agent.session` | `session.history.read` | D2 |
| `agent.session` | `session.list.read` | D2 |
| `agent.session` | `session.status.read` | D2 |
| `agent.session` | `task.plan.update` | D2 |
| `app.clipboard` | `clipboard.read` | D3 |
| `app.manage` | `app.open` | D1 |
| `app.manage` | `app.permission.read` | D1 |
| `app.manage` | `app.manage` | D2 |
| `app.manage` | `app.install_status.read` | D3 |
| `app.manage` | `app.uninstall` | D4 |
| `assistant.voice` | `media.tts.generate` | D2 |
| `audio` | `audio.read` | D2 |
| `audio` | `audio.record` | D3 |
| `audio` | `audio.delete` | D4 |
| `automation.schedule` | `alarm.delete` | D1 |
| `automation.schedule` | `alarm.read` | D1 |
| `automation.schedule` | `alarm.write` | D1 |
| `automation.schedule` | `automation.schedule.manage` | D1 |
| `calendar.todo` | `calendar.delete` | D2 |
| `calendar.todo` | `calendar.open` | D2 |
| `calendar.todo` | `calendar.read` | D2 |
| `calendar.todo` | `calendar.write` | D2 |
| `calendar.todo` | `todo.read` | D2 |
| `calendar.todo` | `todo.write` | D2 |
| `contact` | `contact.read` | D3 |
| `contact` | `contact.write` | D3 |
| `contact` | `contact.delete` | D4 |
| `device.remote` | `remote.device.control` | D4 |
| `file.workspace` | `file.read` | D2 |
| `file.workspace` | `workspace.archive.process` | D2 |
| `file.workspace` | `workspace.dir.list` | D2 |
| `file.workspace` | `workspace.file.find` | D2 |
| `file.workspace` | `workspace.file.read` | D2 |
| `file.workspace` | `workspace.file.search` | D2 |
| `file.workspace` | `workspace.patch.apply` | D2 |
| `file.workspace` | `file.write` | D3 |
| `file.workspace` | `workspace.file.edit` | D3 |
| `file.workspace` | `workspace.file.write` | D3 |
| `file.workspace` | `file.delete` | D4 |
| `file.workspace` | `workspace.file.delete` | D4 |
| `gateway.admin` | `agent.runtime.internal` | D2 |
| `gateway.admin` | `system.gateway.manage` | D2 |
| `gateway.admin` | `system.account.filesystem.admin` | D4 |
| `gateway.admin` | `system.network.firewall.modify` | D4 |
| `gateway.admin` | `system.security.modify` | D4 |
| `location` | `maps.navigation` | D1 |
| `location` | `maps.search` | D1 |
| `location` | `location.read` | D3 |
| `media.gallery` | `media.image.analyze` | D2 |
| `media.gallery` | `media.image.generate` | D2 |
| `media.gallery` | `media.music.generate` | D2 |
| `media.gallery` | `media.video.generate` | D2 |
| `media.gallery` | `media.open` | D3 |
| `media.gallery` | `media.read` | D3 |
| `media.gallery` | `media.write` | D3 |
| `media.gallery` | `media.delete` | D4 |
| `message.notification` | `message.draft.write` | D1 |
| `message.notification` | `message.open` | D1 |
| `message.notification` | `message.setting.write` | D1 |
| `message.notification` | `session.message.send` | D2 |
| `message.notification` | `external.message.send` | D3 |
| `message.notification` | `message.read` | D3 |
| `message.notification` | `message.send` | D3 |
| `message.notification` | `notification.read` | D3 |
| `message.notification` | `message.delete` | D4 |
| `network.web` | `web.fetch` | D0 |
| `network.web` | `web.search` | D0 |
| `network.web` | `network.access` | D1 |
| `network.web` | `data.external.upload` | D2 |
| `network.web` | `network.access.transfer` | D4 |
| `note.document` | `document.pdf.analyze` | D2 |
| `note.document` | `note.read` | D2 |
| `note.document` | `note.write` | D2 |
| `note.document` | `note.delete` | D4 |
| `phone.calllog` | `phone.open` | D1 |
| `phone.calllog` | `phone.setting` | D1 |
| `phone.calllog` | `calllog.delete` | D3 |
| `phone.calllog` | `calllog.read` | D3 |
| `phone.calllog` | `phone.call` | D3 |
| `sandbox.shell` | `command.read.task_workspace` | D1 |
| `sandbox.shell` | `sandbox.process.control` | D1 |
| `sandbox.shell` | `sandbox.build.execute` | D2 |
| `sandbox.shell` | `sandbox.command.compose` | D2 |
| `sandbox.shell` | `plugin.package.install` | D3 |
| `sandbox.shell` | `sandbox.command.execute` | D3 |
| `sandbox.shell` | `sandbox.process.manage` | D3 |
| `screen.understanding` | `screen.capture` | D3 |
| `screen.understanding` | `ui.canvas.control` | D3 |
| `screen.understanding` | `device.automation` | D4 |
| `system.settings` | `calculator.compute` | D0 |
| `system.settings` | `common.read` | D1 |
| `system.settings` | `device.biometric_capability.read` | D1 |
| `system.settings` | `network.setting.open` | D1 |
| `system.settings` | `network.setting.write` | D1 |
| `system.settings` | `sandbox.env.access` | D1 |
| `system.settings` | `sandbox.process.read` | D1 |
| `system.settings` | `security.open` | D1 |
| `system.settings` | `security.status.read` | D1 |
| `system.settings` | `system.locale.timezone.process` | D1 |
| `system.settings` | `system.setting.open` | D1 |
| `system.settings` | `system.setting.write` | D1 |
| `system.settings` | `system.status.read` | D1 |
| `system.settings` | `system.time.read_write` | D1 |
| `system.settings` | `system.ui.open` | D1 |
| `system.settings` | `terminal.display.control` | D1 |
| `system.settings` | `feedback.submit` | D2 |
| `system.settings` | `system.log` | D2 |
| `system.settings` | `safebox.security` | D3 |
| `system.settings` | `security.setting.write` | D3 |
| `system.settings` | `identity.read` | D4 |
| `system.settings` | `payment.security_control` | D4 |
| `system.settings` | `permission.global_toggle` | D4 |
| `system.settings` | `secret.crypto.key.access` | D4 |
| `thirdparty.order` | `thirdparty.order.manage` | D4 |
| `thirdparty.service` | `thirdparty.service.read` | D2 |

### B.5 数据分级索引（D0–D4）


**D0（3 项）**：

`calculator.compute`, `web.fetch`, `web.search`

**D1（33 项）**：

`agent.registry.read`, `agent.workflow.yield`, `alarm.delete`, `alarm.read`, `alarm.write`, `app.open`, `app.permission.read`, `automation.schedule.manage`, `command.read.task_workspace`, `common.read`, `device.biometric_capability.read`, `maps.navigation`, `maps.search`, `message.draft.write`, `message.open`, `message.setting.write`, `network.access`, `network.setting.open`, `network.setting.write`, `phone.open`, `phone.setting`, `sandbox.env.access`, `sandbox.process.control`, `sandbox.process.read`, `security.open`, `security.status.read`, `system.locale.timezone.process`, `system.setting.open`, `system.setting.write`, `system.status.read`, `system.time.read_write`, `system.ui.open`, `terminal.display.control`

**D2（38 项）**：

`agent.delegate.manage`, `agent.delegate.spawn`, `agent.runtime.internal`, `app.manage`, `audio.read`, `calendar.delete`, `calendar.open`, `calendar.read`, `calendar.write`, `data.external.upload`, `document.pdf.analyze`, `feedback.submit`, `file.read`, `media.image.analyze`, `media.image.generate`, `media.music.generate`, `media.tts.generate`, `media.video.generate`, `note.read`, `note.write`, `sandbox.build.execute`, `sandbox.command.compose`, `session.history.read`, `session.list.read`, `session.message.send`, `session.status.read`, `system.gateway.manage`, `system.log`, `task.plan.update`, `thirdparty.service.read`, `todo.read`, `todo.write`, `workspace.archive.process`, `workspace.dir.list`, `workspace.file.find`, `workspace.file.read`, `workspace.file.search`, `workspace.patch.apply`

**D3（26 项）**：

`app.install_status.read`, `audio.record`, `calllog.delete`, `calllog.read`, `clipboard.read`, `contact.read`, `contact.write`, `external.message.send`, `file.write`, `location.read`, `media.open`, `media.read`, `media.write`, `message.read`, `message.send`, `notification.read`, `phone.call`, `plugin.package.install`, `safebox.security`, `sandbox.command.execute`, `sandbox.process.manage`, `screen.capture`, `security.setting.write`, `ui.canvas.control`, `workspace.file.edit`, `workspace.file.write`

**D4（19 项）**：

`app.uninstall`, `audio.delete`, `contact.delete`, `device.automation`, `file.delete`, `identity.read`, `media.delete`, `message.delete`, `network.access.transfer`, `note.delete`, `payment.security_control`, `permission.global_toggle`, `remote.device.control`, `secret.crypto.key.access`, `system.account.filesystem.admin`, `system.network.firewall.modify`, `system.security.modify`, `thirdparty.order.manage`, `workspace.file.delete`


---

## 附录 C｜MCP 工具面

### C.1 全系统 MCP 服务器（15 个）

详见 REPORT.md §2.7（TOOLS_SERVICE intent resolver 实测）。

### C.2 ability 的 19 个 mdi_* 工具（完整参数表）

来源：`ability/resources/res/raw/mcp_tools.json`；全部 timeout=60s

| 工具 Tool | 参数 Parameters | 必填 Required | 功能 Function |
|---|---|---|---|
| `mdi_task_create` | taskName, reuse | — | 创建虚拟屏任务环境 Create virtual-display task env |
| `mdi_task_finish` | taskName, ignoreActions | — | 结束任务环境 Finish task env |
| `mdi_open_app` | packageName, taskName | packageName | 虚拟屏启动应用 Launch app on virtual display |
| `mdi_move_app` | packageName, toDisplayId, toTop, taskName | packageName, toDisplayId | 跨屏搬移应用 Move app across displays |
| `mdi_top_app` | displayId, taskName | — | 查栈顶应用 Query top app |
| `mdi_click` | x, y, contentDesc, text, durationMs, taskName | — | 点击（可按 text/desc 定位）Click (locate by text/desc) |
| `mdi_tap` | x, y, contentDesc, text, durationMs, taskName | — | 点击（同 click）Tap (same as click) |
| `mdi_long_click` | x, y, durationMs, taskName | x, y | 长按 Long press |
| `mdi_swipe` | startX, startY, endX, endY, durationMs, steps, taskName | startX, startY, endX, endY | 滑动 Swipe |
| `mdi_fling` | startX, startY, velocityX, velocityY, durationMs, taskName | startX, startY, velocityX, velocityY | 甩动 Fling |
| `mdi_scale` | centerX, centerY, startDistance, endDistance, durationMs, taskName | centerX, centerY, startDistance, endDistance | 双指缩放 Pinch scale |
| `mdi_set_text` | content, x, y, taskName | content, x, y | 输入文本 Set text |
| `mdi_key_event` | keyCode, taskName | keyCode | 按键 Key event |
| `mdi_back` | taskName | — | 返回 Back |
| `mdi_home` | taskName | — | 回主屏 Home |
| `mdi_wait` | durationMs, taskName | — | 等待 Wait |
| `mdi_capture` | targetPackageName, taskName | — | 截图（base64）Screenshot |
| `mdi_snapshot` | packageName, timeoutMs, taskName | — | UI 视图树快照 UI view-tree snapshot |
| `mdi_ime_enable` | enable, taskName | — | 虚拟屏输入法开关 Toggle IME ownership |

### C.3 AgentSafetyCenter 的 2 个工具

- `file_safe_delete`（path/paths, recursive, truth_id——回收站+云端较真）
- `file_restore`（path/paths, recursive）

### C.4 AiLauncher VoiceAbilityService 的 4 个工具

- `assistant_show_risk_statement`（风险卡 Risk card）
- `assistant_change_voice_id` / `assistant_get_voice_list`（语音 Voice）
- `ailauncher_load_tripartite_common_card`（三方卡片 Tripartite card）

---

## 附录 D｜SLA 本地快车道函数词表

来源：AiLauncher `sla/v.java`（lockScreenAllowed/slaUnsupported）+ AIEngine `SlaAbility.java`（识别词表）

### D.1 门控逻辑（v.java 还原）

```java
Verdict a(String function, boolean fallback, boolean locked) {
    if (fallback || function == null) return Verdict(false, 280001, "no valid action recognized");
    if (slaUnsupported.contains(function)) return Verdict(false, 280003, "not supported by on-device SLA");
    if (!locked || lockScreenAllowed.contains(function)) return Verdict(true, 0, null);  // ← 未锁屏时任何函数都过此门
    return Verdict(false, 280002, "screen locked, not in lockscreen whitelist");
}
// isKeyguardLocked() 抛异常 → 按【未锁屏】处理（fail-open，v.java b()）
```

**要点**：①未锁屏时此门不拦任何函数（真正限制是识别器词表）；②锁屏时仅 58 项白名单可执行；③**锁屏白名单包含 `sms_send`/`sms_send_direct`（锁屏可发短信）**；④`isKeyguardLocked` 异常时按未锁处理。

### D.2 lockScreenAllowed 锁屏白名单（58 项，精确）

```
alarm_clock_add, alarm_clock_get_current_time_by_city, alarm_clock_timer_add, dialer_add_group, dialer_call_contact, dialer_call_to, dialer_contacts_add, evaluate_expression, get_current_location, maps_weather, open_flash_light, weatherInfo, phone_note_add, phone_note_todo_add, settings_adjust_display_size, settings_adjust_font_size, settings_adjust_sound, settings_choose_wifi, settings_config_hotspot, settings_connect_wifi, settings_set_brightness, settings_set_media_sound, settings_set_screen_off_time, settings_get_airplane_mode_state, settings_get_app_lock_state, settings_get_auto_brightness_state, settings_get_auto_rotation_state, settings_get_battery_saver_state, settings_get_bluetooth_state, settings_get_charging_notif_sound_state, settings_get_dark_mode_state, settings_get_data_state, settings_get_dialing_keypad_sound_state, settings_get_hotspot_state, settings_get_liftToCheck_phone_state, settings_get_one_handed_mode_state, settings_get_screen_lock_sound_state, settings_get_screen_saver_state, settings_get_tapToCheck_phone_state, settings_get_touch_sound_state, settings_get_vibration_state, settings_get_wifi_state, sms_auto_retrieve_mms, sms_delivery_reports, sms_notify_sound, sms_notify_vibration, sms_query, sms_schedule_send, sms_send, sms_send_direct, sms_send_sound, sms_settings_auto_retrieval, sms_settings_delivery_reports, sms_settings_expired_pickup, sms_settings_expired_veri, sms_settings_intelligent_msg, sms_settings_notif_detail, sms_settings_risk_url
```

### D.3 slaUnsupported（强制回云，2 项）

```
request_cloud_assist, request_gui_assist
```

### D.4 识别器词表（AIEngine SlaAbility，57 个函数）

与 D.2 差集：D.2 多出 `weatherInfo`、`settings_get_liftToCheck_phone_state`、`settings_get_tapToCheck_phone_state`（3 项仅在锁屏白名单/新版本中）；其余一致。即全量函数宇宙 ≈ 60 项（报告正文的「~65」为估算值）。

---

## 附录 E｜OpenClaw stepclaw-exec 名单（chroot 内命令执行）

来源：ClawX `resources/assets/openclaw/extensions/stepclaw-exec/index.js`（详见 reports/clawx_sprite_sandbox.md §2.3）

### E.1 argv[0] 白名单（16 命令）

```python, python3, node, sh, bash, echo, cat, ls, pwd, whoami, uname, env, which, head, tail, wc```

（绝对路径仅允许 `/usr`、`/bin`、`/sbin` 前缀）

### E.2 硬编码拒绝子串（不可配置关闭）

```rm -rf, mkfs, dd if=/, dd of=, curl|sh 系列, sudo , eval $(, bash -i >& /dev/tcp/, chmod 777 , /etc/shadow, /proc/self/mem```
（另有可配置 denyPatterns）

### E.3 cwd 白名单（5 项，禁 `..`）

```/, /tmp, /root, /root/.openclaw, /var/log/openclaw```

### E.4 env 黑名单（10 项）

```LD_PRELOAD, LD_LIBRARY_PATH, PATH, HOME, USER, LOGNAME, SHELL, NODE_OPTIONS, PYTHONSTARTUP```

### E.5 Java 侧 before_tool_call 拦截（默认放行，仅拦以下）

6 组正则：`rm` / `find -delete` / `find -exec rm` / `|xargs rm` / `cd+rm` / `cd+find -delete` 作用于 `/sdcard` 或 `/storage/emulated/0` → block；**其余工具默认 allow**（memory 文件读写特判放行，cron 交 android-node）

### E.6 资源限制

超时 100ms–60s（默认 10s）；read ≤2MB/2000 行；write ≤8MB（E_TOO_LARGE）

---

## 附录 F｜AppWhitelistEngine 默认名单（APK 内置，云端可更新）

### F.1 default_whitelist.json —— 允许 + 重定向组

**允许的 App（4）**：`阶跃AI`、`悦动浏览器`、`勇士游戏盒子`、`996传奇社区`

**重定向组 → `阶跃AI`（29 个）**：
`豆包`、`Kimi`、`文心一言`、`通义千问`、`腾讯元宝`、`智谱清言`、`DeepSeek`、`讯飞星火`、`百小应`、`海螺AI`、`天工AI`、`万知`、`商汤日日新`、`秘塔AI搜索`、`华为小艺`、`vivo蓝心小V`、`OPPO小布助手`、`小米超级小爱`、`荣耀YOYO助手`、`360智脑`、`即梦AI`、`猫箱`、`扣子`、`知乎直答`、`出门问问`、`网易有道子曰`、`面壁智能CPM`、`星野`、`澜舟科技`

**重定向组 → `悦动浏览器`（4 个）**：
`UC浏览器`、`QQ浏览器`、`百度浏览器`、`360浏览器`

### F.2 whitelist_default.json —— 状态与推荐（version=0，TTL 3600s）

| 应用 App | 允许 Enabled | 推荐 Recommendations |
|---|---|---|
| `快手` | ✅ | — |
| `B站` | ✅ | — |
| `微信` | ✅ | — |
| `高德地图` | ✅ | — |
| `支付宝` | ✅ | — |
| `抖音` | ❌ | 快手, B站 |
| `百度地图` | ❌ | 高德地图 |
| `QQ` | ❌ | 微信 |

> 语义：enabled=false 的 App 触发 REDIRECT（按 recommendations 换 App）或 FAILED；名单由云端同步。

---

## 附录 G｜签名与证书

### G.1 agent_service_known_certs（ACCESS_AGENT_SERVICE 证书锁定，ability/res/values/arrays.xml）

```
88468c5cf43c68db866e8cf2389eeaa68ed2b5eab3eb7edd5ff4be1106979dbe
306a02cceadd3b4e1d8e9e2f67487459d1c71087f5d2a11c0285077a9e1b82ce
```

### G.2 平台签名信任规则（AIEngine SignatureUtils 还原）

trusted ⟺ 目标包是 system/privileged（flags & 0x81）∨ 与校验方同签名（checkSignatures==0）；uid<10000 直通（PermissionGuard）

---

## 附录 H｜网络端点与内置密钥（AgentBus 常量）

来源：reports/agentbus.md §8（s1/u.java、n7/a.java 等还原）

| 项 Item | 值 Value |
|---|---|
| LocalSocket | `agentbus`（抽象命名空间，max 64 conns） |
| REST API | `127.0.0.1:18801`（默认关） |
| BlobServer | `127.0.0.1:18800`（cache 100MB，PUT≤32MB，无逐请求鉴权） |
| OpenClaw 本地网关 | `127.0.0.1:18789` |
| OpenClaw 云 prod | `claw-connection-socket-mtls.stepaos.com:443/ws/device`（mTLS），api `https://biz-gw.stepos.com` |
| OpenClaw 云 test | `claw-node-connection-socket.stepos.com:443/ws/device`，api `https://biz-gw.t-stepos.com` |
| BFF WS | `wss://otter-connection.stepaos.com/ws`（prod）/ `wss://test-otter-connection.t-stepos.com/ws`（test） |
| key-center | `https://biz-gw.stepos.com/key-center` |
| 推送网关 | `biz-gw.stepos.com`（prod）/ `biz-gw-in.zyql.com`（stg）/ `biz-gw.t-stepos.com`（test） |
| chroot rootfs | `/mnt/openclaw/rootfs` |
| 环境切换 | `Settings.Secure("net_env")` ∈ {test, stg, dev, 其他=prod} |
| ⚠️ appId/secret (prod) | `7f1285a1cce243508c58e3a4c0fa4ae2` / `bt6bI9U7wKl8FwT6tJ3u`（硬编码） |
| ⚠️ appId/secret (test) | `9fb1602ed92541a7bdabd0ce66cd45ce` / `9pv65zQUtnH2huYnRPCE`（硬编码） |

---

## 附录 I｜SLA 权限引擎 denyReason 枚举（ability o4/d.java）

| denyReason | 语义 Meaning |
|---|---|
| `redline` | 红线操作（绝对拒绝）Redline, absolute deny |
| `mode` | 权限组模式不允许 Mode disallows |
| `unknownFunction` | 未知函数（fail-closed）Unknown function |
| `scopeMissing` | 工具无权限范围映射 No scope mapping |
| `noSnapshot` | 无权限快照可用 No snapshot |
| `stale` | 快照过期 Stale snapshot |

> fail-closed 语义：以上任一命中即拒绝；台账不可用本身不在此列（AiLauncher 侧 offlineLedgerBypass 会放行非 redline 项——见 REPORT.md 薄弱点 #2）。
