# phone_comm — 电话与短信

> 来源 App：`com.android.dialer`（电话）、`com.android.mms`（信息）

---

## 来自 com.android.dialer

```
ability.call method="dialer_call_to" params='{"number":"<要拨打的电话号码>"}'
```

给指定的号码拨打电话。可选参数：`isVideo`（是否视频通话，true 为视频通话）。

```
ability.call method="dialer_show_incall_screen" params='{}'
```

通话过程中，拉起通话界面。

```
ability.call method="dialer_accept_call" params='{}'
```

如果当前有来电，接听电话。

```
ability.call method="dialer_hangup_call" params='{}'
```

如果当前有来电，挂断来电；如果当前有通话，挂断当前通话。

```
ability.call method="dialer_call_back" params='{}'
```

回拨通话记录中最近一次通话的号码，如果没有通话记录，不做任何操作。

```
ability.call method="dialer_check_last_caller" params='{}'
```

查询通话记录中最近一次来电的号码，如果没有通话记录，返回空字符串。

```
ability.call method="dialer_show_dialpad" params='{}'
```

打开拨号盘，并填充输入的数字。可选参数：`number`（需要输入的拨号号码）。

```
ability.call method="dialer_settings_enable_power_button_ends_call" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭按电源键挂断电话功能。

```
ability.call method="dialer_settings_enable_incoming_flip_silent" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭来电翻转静音功能。

```
ability.call method="dialer_settings_vibrate_when_mocall_connected" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭接通时振动功能。

```
ability.call method="dialer_settings_open_auto_record_screen" params='{}'
```

打开通话录音设置界面。

```
ability.call method="dialer_settings_allow_viewing_medical_information" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭未解锁时直接查看医疗急救信息的功能。

```
ability.call method="dialer_settings_sos_auto_call" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭SOS紧急求助时自动报警的功能。

```
ability.call method="dialer_settings_sos_send_position" params='{"enable":"<是否开启，true为开启，false为关闭>"}'
```

开启或关闭SOS紧急求助时自动发送位置给警方功能。

```
ability.call method="dialer_call_contact" params='{"name":"<联系人姓名>"}'
```

给指定联系人拨打电话（支持模糊匹配）。可选参数：`isVideo`（是否视频通话）。

```
ability.call method="dialer_query_calllog" params='{}'
```

按日期或日期范围查询通话记录。可选参数：`date`；`startDate`；`endDate`；`name`（联系人名称，支持模糊匹配）；`limit`（默认80，最大300）。

```
ability.call method="dialer_query_calllog_of_contact" params='{"name":"<联系人姓名>"}'
```

查询某个联系人的通话记录。可选参数：`limit`。

```
ability.call method="dialer_query_calllog_by_type" params='{"callType":"<未接|拨入|拨出|语音留言|已搁置|已拦截>"}'
```

按通话类型查询通话记录。可选参数：`limit`。

```
ability.call method="dialer_query_calllog_by_number" params='{"number":"<联系人号码>"}'
```

按联系人号码查询通话记录。可选参数：`limit`。

```
ability.call method="dialer_query_calllog_this_morning" params='{}'
```

查询今天早上的通话记录。

```
ability.call method="dialer_query_calllog_this_afternoon" params='{}'
```

查询今天下午的通话记录。

```
ability.call method="dialer_query_calllog_tonight" params='{}'
```

查询今晚的通话记录。

```
ability.call method="dialer_query_calllog_today" params='{}'
```

查询今天的通话记录。

```
ability.call method="dialer_query_calllog_yesterday" params='{}'
```

查询昨天的通话记录。

```
ability.call method="dialer_query_calllog_day_before_yesterday" params='{}'
```

查询前天的通话记录。

```
ability.call method="dialer_query_call_duration_ranking" params='{}'
```

查看通话时长排行榜，按时长由长到短排序。可选参数：`name`（联系人姓名，模糊匹配）；`limit`（默认20）。

```
ability.call method="dialer_delete_calllog" params='{}'
```

按条件删除通话记录。可选参数：`date`；`startDate`；`endDate`；`name`（精确匹配）；`number`。

```
ability.call method="dialer_delete_calllog_by_contact_name" params='{"name":"<联系人姓名，精确匹配>"}'
```

按联系人姓名删除通话记录。

```
ability.call method="dialer_delete_calllog_by_number" params='{"number":"<联系人号码>"}'
```

按联系人号码删除通话记录。

```
ability.call method="dialer_delete_last_calllog" params='{}'
```

删除最近一次通话记录。

```
ability.call method="dialer_delete_calllog_today" params='{}'
```

删除今天的通话记录（00:00:00 到当前时刻）。

```
ability.call method="dialer_open_call_settings" params='{}'
```

打开电话设置界面。

```
ability.call method="dialer_open_sim_card_settings" params='{}'
```

打开SIM卡设置界面。

```
ability.call method="dialer_open_medical_emergency_information" params='{}'
```

打开医疗急救信息界面。

```
ability.call method="dialer_settings_sos_auto_help_emergency_contact" params='{"enable":"<true/false>"}'
```

开启或关闭SOS紧急求助时的自动求助紧急联系人开关。

```
ability.call method="dialer_settings_sos_dial_assist" params='{"enable":"<true/false>"}'
```

开启或关闭SOS紧急求助时的报警辅助开关。

---

## 来自 com.android.mms — 电话

```
ability.call method="tele_mobilenet_phone_numbers" params='{}'
```

获取手机号码。

```
ability.call method="tele_mobilenet_signal_strength" params='{}'
```

获取信号强度。

```
ability.call method="tele_mobilenet_data_enable" params='{"enable":"<开启或关闭移动数据，true为开启，false为关闭>"}'
```

开启或关闭移动数据。

---

## 来自 com.android.mms — 短信

```
ability.call method="sms_send" params='{"message":"<短信内容>"}'
```

给指定联系人或号码发送一条短信。可选参数：`phone_number`（收件人电话号码，与 `contact_name` 二选一）；`contact_name`（联系人姓名，与 `phone_number` 二选一）；`send_directly`（false 表示保存为草稿，默认直接发送）；`sim_slot`（SIM 卡槽，0 或 1）。

```
ability.call method="sms_search" params='{}'
```

搜索短信，支持按关键词、日期范围、联系人号码搜索。可选参数：`keyword`（搜索关键词）；`phone_number`（联系人电话号码）；`date_from`（起始日期，格式yyyy-MM-dd）；`date_to`（结束日期，格式yyyy-MM-dd）；`limit`（返回结果数量限制）。

```
ability.call method="sms_delete" params='{}'
```

删除短信，支持按短信ID、会话ID或电话号码删除。可选参数：`sms_id`（短信ID）；`thread_id`（会话ID）；`phone_number`（电话号码）。

```
ability.call method="sms_thread_delete" params='{}'
```

删除短信会话，删除整个对话会话及其包含的所有短信。可选参数：`thread_id`（会话ID）；`phone_number`（电话号码）；`contact_name`（联系人名称）；`delete_all`（是否删除所有会话）。

```
ability.call method="sms_forward" params='{"forward_to":"<转发目标电话号码>"}'
```

转发短信给其他联系人，支持按短信ID获取内容或直接提供消息内容。可选参数：`sms_id`（要转发的短信ID）；`message`（要转发的消息内容）。

```
ability.call method="sms_read_status" params='{"read":"<是否标记为已读，true=已读，false=未读>"}'
```

标记短信已读或未读状态，支持按短信ID、会话ID或电话号码操作。可选参数：`sms_id`（短信ID）；`thread_id`（会话ID）；`phone_number`（电话号码）。

```
ability.call method="sms_statistics" params='{}'
```

获取短信统计信息，包括收件箱、发件箱、草稿箱数量、未读数及会话数等。

```
ability.call method="sms_schedule_send" params='{"phone_number":"<收件人电话号码>","message":"<短信内容>"}'
```

设置定时发送短信，在指定时间自动发送短信。可选参数：`timestamp`（发送时间戳，毫秒）；`datetime`（发送时间，格式yyyy-MM-dd HH:mm或HH:mm）；`delay_minutes`（延迟分钟数）。

---

## 来自 com.android.mms — 短信草稿

```
ability.call method="sms_draft_save" params='{"message":"<草稿内容>"}'
```

保存短信草稿到草稿箱。可选参数：`phone_number`（收件人电话号码）；`thread_id`（会话ID）。

```
ability.call method="sms_draft_get" params='{}'
```

获取短信草稿，支持按草稿ID、电话号码、会话ID查询，或获取所有草稿。可选参数：`draft_id`（草稿ID）；`phone_number`（电话号码）；`thread_id`（会话ID）；`limit`（返回结果数量限制）。

```
ability.call method="sms_draft_delete" params='{}'
```

删除短信草稿，支持按草稿ID、电话号码、会话ID删除，或删除所有草稿。可选参数：`draft_id`（草稿ID）；`phone_number`（电话号码）；`thread_id`（会话ID）；`delete_all`（是否删除所有草稿）。

---

## 来自 com.android.mms — 短信扩展能力

```
ability.call method="sms_send_direct" params='{"phone":"<联系人或号码>"}'
```

给指定联系人或号码发送短信。可选参数：`sms`（短信内容）。

```
ability.call method="sms_query" params='{"call":"<短信号码>"}'
```

通过号码查询指定短信。可选参数：`sms`（相关的短信内容）。

```
ability.call method="sms_send_sound" params='{"enabled":"<是否启用>"}'
```

设置短信发送声音开关。

```
ability.call method="sms_notify_sound" params='{"sound_uri":"<通知声音URI，空字符串表示静音>"}'
```

设置短信通知声音。

```
ability.call method="sms_notify_vibration" params='{"enabled":"<是否启用>"}'
```

设置短信通知振动开关。

```
ability.call method="sms_auto_retrieve_mms" params='{"enabled":"<是否启用>"}'
```

设置自动下载彩信开关。可选参数：`sub_id`。

```
ability.call method="sms_delivery_reports" params='{"enabled":"<是否启用>","sub_id":"<订阅ID>"}'
```

设置短信送达报告开关。

```
ability.call method="sms_settings_intelligent_msg" params='{"enable":"<true/false>"}'
```

开启/关闭智能短信开关。

```
ability.call method="sms_settings_notif_detail" params='{"enable":"<true/false>"}'
```

开启/关闭短信的显示通知详情开关。

```
ability.call method="sms_settings_auto_retrieval" params='{"enable":"<true/false>","sim_id":"<1或2>"}'
```

开启/关闭漫游时彩信自动下载开关。

```
ability.call method="sms_settings_risk_url" params='{"enable":"<true/false>"}'
```

开启/关闭风险网址识别开关。

```
ability.call method="sms_settings_expired_veri" params='{"enable":"<true/false>"}'
```

开启/关闭自动删除验证码短信开关。

```
ability.call method="sms_settings_expired_pickup" params='{"enable":"<true/false>"}'
```

开启/关闭自动删除取件码短信开关。

```
ability.call method="sms_settings_delivery_reports" params='{"enable":"<true/false>","sim_id":"<1或2>"}'
```

开启/关闭短信送达报告开关（设置侧）。

```
ability.call method="sms_settings_quick_reply" params='{"content":"<快速回复内容>","index":"<第几条，从1开始>"}'
```

编辑快速回复内容。

```
ability.call method="sms_settings_center_num" params='{"number":"<号码>","sim_id":"<1或2>"}'
```

设置短信中心号码。

```
ability.call method="sms_settings_sim_messages" params='{"sim_id":"<1或2>"}'
```

获取SIM卡存储的短信列表。

```
ability.call method="sms_account_balance_inquiry" params='{"slot_index":"<0或1>"}'
```

查话费余额，通过发送短信查询本机话费。

```
ability.call method="sms_data_balance_inquiry" params='{"slot_index":"<0或1>"}'
```

查流量余额，通过发送短信查询本机数据流量。

```
ability.call method="sms_list_today_query" params='{}'
```

查询今天收/发的短信列表。

```
ability.call method="sms_list_yesterday_query" params='{}'
```

查询昨天的短信列表。

```
ability.call method="sms_list_day_before_yesterday_query" params='{}'
```

查询前天的短信列表。

```
ability.call method="sms_list_last_week_query" params='{}'
```

查询上周的短信列表。

```
ability.call method="sms_list_morning_query" params='{}'
```

查询今天上午的短信列表。

```
ability.call method="sms_list_afternoon_query" params='{}'
```

查询今天下午的短信列表。

```
ability.call method="sms_list_evening_query" params='{}'
```

查询今天晚上的短信列表。

```
ability.call method="sms_open_personal_list" params='{}'
```

打开个人短信列表页面。

```
ability.call method="sms_open_notice_list" params='{}'
```

打开通知短信列表页面。

```
ability.call method="sms_open_collected_list" params='{}'
```

打开收藏短信列表页面。

```
ability.call method="sms_open_settings_page" params='{}'
```

打开短信设置页面。
