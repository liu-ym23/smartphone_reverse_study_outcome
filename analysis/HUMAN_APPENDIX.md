# 附录：完整名单与规则数据

## 附录 A｜SLA本地快车道使用的数据

### A.1 启动SLA竞速门控条件

#### A.1.1 完整条件

门卫不做智能判断，四条硬条件全过才竞速，任一失败直接 proceed() 上云：

```
┌───┬────────────────────────────────────────────────┬──────────────────────────────┐
│ # │                 Conditions                     │            Reason            │
├───┼────────────────────────────────────────────────┼──────────────────────────────┤
│ 1 │ !bffExcluded(agentId)                          │ BFF agent operates on cloud  │
├───┼────────────────────────────────────────────────┼──────────────────────────────┤
│ 2 │ !(text.length > MAX_SLA_QUERY_CHARS /*=480*/ ) │ Not atomic (TOO long)        │
├───┼────────────────────────────────────────────────┼──────────────────────────────┤
│ 3 │ !hasVisibleAttachments                         │ No Visual channel            │
├───┼────────────────────────────────────────────────┼──────────────────────────────┤
│ 4 │ !text.isBlank()                                │ Denfensive Coding            │
└───┴────────────────────────────────────────────────┴──────────────────────────────┘
```

#### A.1.2 BFF排除名单

走BFF长连接通道的agent（云端驻留型）天生不能本地执行，它们的对话必须整段上云。这些agent包括且仅包括claude、codex、stepai、deepseek、doubao。

### A.2 SLA竞速中针对模型输出的门控

#### A.2.1 完整条件

端侧模型的输出不一定合法，也不一定能解决问题，因此可能被迫或主动将任务交给云端。

```
┌────┬──────────────────────────────────────────────────────┬──────────────────────────┬───────────────────────────────────┐
│ #  │ Condition (must PASS to reach the ledger)            │ On fail                  │ Reason                            │
├────┼──────────────────────────────────────────────────────┼──────────────────────────┼───────────────────────────────────┤
│ M1 │ !(fallback || function == null)                      │ 280001 → cloud           │ Model failed to recognize an      │
│    │                                                      │                          │ atomic action                     │
├────┼──────────────────────────────────────────────────────┼──────────────────────────┼───────────────────────────────────┤
│ M2 │ !slaUnsupported.contains(function)                   │ 280003 → cloud           │ Model self-flags a cloud-side     │
│    │  function ∉ {request_cloud_assist,                   │                          │ task (cloud / GUI) — on-device    │
│    │                request_gui_assist}                   │                          │ SLA must not intercept it         │
├────┼──────────────────────────────────────────────────────┼──────────────────────────┼───────────────────────────────────┤
│ M3 │ !locked || lockScreenAllowed.contains(function)      │ 280002 → cache decision, │ Lockscreen whitelist (58 items):  │
│    │  (58-item list)                                      │ unlock within 120s,      │ restricts on-device execution     │
│    │                                                      │ replay (ledger rechecked)│ while screen is locked            │
└────┴──────────────────────────────────────────────────────┴──────────────────────────┴───────────────────────────────────┘
```

#### A.2.2 完整函数词表

```
alarm_clock_add                         alarm_clock_get_current_time_by_city
alarm_clock_timer_add                   dialer_add_group
dialer_call_contact                     dialer_call_to
dialer_contacts_add                     evaluate_expression
get_current_location                    maps_weather
open_flash_light                        weatherInfo
phone_note_add                          phone_note_todo_add
request_cloud_assist                    request_gui_assist
settings_adjust_display_size            settings_adjust_font_size
settings_adjust_sound                   settings_choose_wifi
settings_config_hotspot                 settings_connect_wifi
settings_set_brightness                 settings_set_media_sound
settings_set_screen_off_time            settings_get_airplane_mode_state
settings_get_app_lock_state             settings_get_auto_brightness_state
settings_get_auto_rotation_state        settings_get_battery_saver_state
settings_get_bluetooth_state            settings_get_charging_notif_sound_state
settings_get_dark_mode_state            settings_get_data_state
settings_get_dialing_keypad_sound_state settings_get_hotspot_state
settings_get_liftToCheck_phone_state    settings_get_one_handed_mode_state
settings_get_screen_lock_sound_state    settings_get_screen_saver_state
settings_get_tapToCheck_phone_state     settings_get_touch_sound_state
settings_get_vibration_state            settings_get_wifi_state
sms_auto_retrieve_mms                   sms_delivery_reports
sms_notify_sound                        sms_notify_vibration
sms_query                               sms_schedule_send
sms_send                                sms_send_direct
sms_send_sound                          sms_settings_auto_retrieval
sms_settings_delivery_reports           sms_settings_expired_pickup
sms_settings_expired_veri               sms_settings_intelligent_msg
sms_settings_notif_detail               sms_settings_risk_url
```

其中request_cloud_assist和request_gui_assist属于强制回云函数，其余都属于锁屏允许的函数。

### A.3 SLA竞速中的台账门控

#### A.3.1 


### A.1 本地小模型函数词表

#### A.1.1 lockScreenAllowed锁屏白名单（58项）

```
alarm_clock_add, alarm_clock_get_current_time_by_city, alarm_clock_timer_add, dialer_add_group, dialer_call_contact, dialer_call_to, dialer_contacts_add, evaluate_expression, get_current_location, maps_weather, open_flash_light, weatherInfo, phone_note_add, phone_note_todo_add, settings_adjust_display_size, settings_adjust_font_size, settings_adjust_sound, settings_choose_wifi, settings_config_hotspot, settings_connect_wifi, settings_set_brightness, settings_set_media_sound, settings_set_screen_off_time, settings_get_airplane_mode_state, settings_get_app_lock_state, settings_get_auto_brightness_state, settings_get_auto_rotation_state, settings_get_battery_saver_state, settings_get_bluetooth_state, settings_get_charging_notif_sound_state, settings_get_dark_mode_state, settings_get_data_state, settings_get_dialing_keypad_sound_state, settings_get_hotspot_state, settings_get_liftToCheck_phone_state, settings_get_one_handed_mode_state, settings_get_screen_lock_sound_state, settings_get_screen_saver_state, settings_get_tapToCheck_phone_state, settings_get_touch_sound_state, settings_get_vibration_state, settings_get_wifi_state, sms_auto_retrieve_mms, sms_delivery_reports, sms_notify_sound, sms_notify_vibration, sms_query, sms_schedule_send, sms_send, sms_send_direct, sms_send_sound, sms_settings_auto_retrieval, sms_settings_delivery_reports, sms_settings_expired_pickup, sms_settings_expired_veri, sms_settings_intelligent_msg, sms_settings_notif_detail, sms_settings_risk_url
```

#### A.1.2 slaUnsupported（强制回云，2项）

```
request_cloud_assist, request_gui_assist
```

#### A.1.3 识别器词表（AIEngine SlaAbility，57 个函数）

与 D.2 差集：D.2 多出 `weatherInfo`、`settings_get_liftToCheck_phone_state`、`settings_get_tapToCheck_phone_state`（3 项仅在锁屏白名单/新版本中）；其余一致。即全量函数宇宙 ≈ 60 项（报告正文的「~65」为估算值）。