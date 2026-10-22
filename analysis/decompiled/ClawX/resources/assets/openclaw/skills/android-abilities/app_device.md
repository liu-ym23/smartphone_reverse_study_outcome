# app_device — 应用与设备

> 来源 App：`com.stepos.common.ability.proxy`（通用原子能力）、`com.stepos.aicopilot`（手机助手）、`com.android.calendar`（日历）

---

## 一、打开应用

```
ability.call method="open_app_by_name" params='{"appName":"<应用显示名称>"}'
```

通过应用显示名称打开应用。可选参数：`className`（特定Activity类名）。

```
ability.call method="open_app_by_package" params='{"package":"<应用包名>"}'
```

通过应用包名打开应用。可选参数：`className`（特定Activity类名）。

---

## 用系统浏览器打开链接（StepClaw 内置）

不经过第三方 ability 包，由 StepClaw 节点在本地执行 `Intent.ACTION_VIEW`；**仅允许 `http` / `https`**。

```
ability.call method="app.openUrl" params='{"url":"https://..."}'
```

对应 `nodes`：`invokeCommand="ability.call"`，`invokeParamsJson` 为 `{"method":"app.openUrl","params":{"url":"<完整 URL>"}}`（JSON 内注意转义）。

---

```
ability.call method="check_app_installed_by_package" params='{}'
```

通过packageName检查应用是否已安装。

```
ability.call method="check_app_installed_by_name" params='{"appName":"<应用显示名称>"}'
```

通过appName检查应用是否已安装。

```
ability.call method="show_widget_by_package_class" params='{"package":"<应用包名>","className":"<Widget完整类名>"}'
```

随机显示一个Widget，也可以通过指定package和className显示特定Widget。

---

## 二、音乐播放

```
ability.call method="common_ability_play_music" params='{"songName":"<歌曲名称>"}'
```

播放音乐，展示音乐小组件。

```
ability.call method="aicopilot_play_music" params='{"keyword":"<音乐标题关键字>"}'
```

获取播放音乐的widget。

---

## 三、日历事件

> **路由规则**：用户说"提醒我…"且**明确提到了具体时间**（如"明天下午两点"、"周五上午十点"），才写入日历。若用户**未提及具体时间**（如"记一下要买牛奶"），应路由到 `file_memory` 类目写笔记/待办，不写日历。

```
ability.call method="calendar_add_event" params='{"title":"开会","description":"","location":"","start_time":"2026-03-22 14:00:00","end_time":"2026-03-22 15:00:00","reminder_offset":3}'
```

在用户日历中新增一个日程事件。参数说明：

| 参数 | 必填 | 类型 | 说明 | 默认值 |
|------|------|------|------|--------|
| `title` | **是** | string | 日程标题 | — |
| `start_time` | **是** | string | 开始时间，格式 `YYYY-MM-DD HH:mm:ss`（注意是下划线，不是驼峰） | — |
| `end_time` | **是** | string | 结束时间，格式 `YYYY-MM-DD HH:mm:ss`，用户未指定时默认为 start_time + 1小时 | start_time + 1h |
| `description` | 否 | string | 日程描述，用户未说明时传空字符串 `""` | `""` |
| `location` | 否 | string | 地点，用户未说明时传空字符串 `""` | `""` |
| `reminder_offset` | 否 | number | 提醒间隔：0=不提醒，1=5分钟，2=10分钟，3=30分钟，4=1小时，5=2小时，6=1天，7=1周 | `3`（30分钟） |

**注意**：`start_time`、`end_time` 字段名是**下划线**格式，不要用驼峰（`startTime` ✗）。时间格式必须是 `YYYY-MM-DD HH:mm:ss`，不要用 ISO 8601（`T` 分隔符 ✗）。

```
ability.call method="calendar_query_event" params='{"start_time":"<开始时间，格式YYYY-MM-DD HH:mm:ss>","end_time":"<结束时间，格式YYYY-MM-DD HH:mm:ss>"}'
```

在用户日历中根据开始时间和结束时间查询日程。

```
ability.call method="calendar_add_special_event" params='{}'
```

在用户日历中新增一个特殊事件（生日、纪念日、倒数日）。可选参数：`type`（事件类型，1=生日，2=纪念日，3=倒数日）；`title`（事件标题）；`description`（描述）；`date_time`（时间，格式YYYY-MM-DD HH:mm:ss）；`reminder_day`（提醒时间类型）；`reminder_time`（提醒具体时间，格式HH:mm）。

```
ability.call method="calendar_delete_event" params='{"title":"<日程标题>","description":"<日程描述>","location":"<日程地点>","start_time":"<开始时间，格式YYYY-MM-DD HH:mm:ss>","end_time":"<结束时间，格式YYYY-MM-DD HH:mm:ss>"}'
```

在用户日历中根据事件的时间等字段进行删除事件。

```
ability.call method="calendar_edit_event" params='{"start_time":"<要编辑事件的开始时间，格式YYYY-MM-DD HH:mm:ss>","end_time":"<要编辑事件的结束时间，格式YYYY-MM-DD HH:mm:ss>"}'
```

在用户日历中编辑一个日程事件，仅支持修改时间或标题（不能同时修改）。可选参数：`title`（日程标题，用于精确匹配）；`new_title`（新的标题）；`new_start_time`（新的开始时间）；`new_end_time`（新的结束时间）。

```
ability.call method="calendar_edit_special_event" params='{"type":"<事件类型，1=生日，2=纪念日，3=倒数日>","title":"<待编辑事件的原标题>","date_time":"<待编辑事件的原时间，格式YYYY-MM-DD HH:mm:ss>"}'
```

在用户日历中编辑一个特殊事件（生日/纪念日/倒数日），支持修改时间、标题或提醒设置。可选参数：`new_title`（新标题）；`new_date_time`（新日期时间）；`new_reminder_day`（新提醒时间类型）；`new_reminder_time`（新提醒具体时间，格式HH:mm）。

```
ability.call method="calendar_delete_special_event" params='{"start_time":"<开始时间，格式YYYY-MM-DD HH:mm:ss>","end_time":"<结束时间，格式YYYY-MM-DD HH:mm:ss>","event_types":"<事件类型列表，1=生日，2=纪念日，3=倒数日>"}'
```

在用户日历中删除特殊事件（生日、纪念日、倒数日）。

```
ability.call method="calendar_open_new_edit_event_activity" params='{}'
```

打开添加日程页面（仅打开，不新增内容）。

```
ability.call method="calendar_open_almanac_detail_activity" params='{}'
```

打开黄历详情页面。

```
ability.call method="calendar_open_horoscope_detail_activity" params='{}'
```

打开星座详情页面。

```
ability.call method="calendar_open_general_settings" params='{}'
```

打开日历设置页面。

```
ability.call method="calendar_query_special_event" params='{"start_time":"<YYYY-MM-DD HH:mm:ss>","end_time":"<YYYY-MM-DD HH:mm:ss>","event_types":"<事件类型列表，1=生日，2=纪念日，3=倒数日>"}'
```

查询特殊事件（生日/纪念日/倒数日）。

---

## 五、设备信息查询

> 来源 App：`com.stepos.common.ability.proxy`

```
ability.call method="common_ability_get_screen_size" params='{}'
```

获取当前手机屏幕尺寸。

```
ability.call method="common_ability_get_app_versioncode" params='{"packageName":"<应用包名>"}'
```

通过packageName获取应用的versionCode。

---

## 六、应用管理

> 来源 App：`com.android.packageinstaller`

```
ability.call method="security_packageinstaller_uninstall" params='{"appLabel":"<应用名称>"}'
```

卸载指定应用。

---

## 七、计算器

> 来源 App：`com.stepos.stepos.calculator`

```
ability.call method="evaluate_expression" params='{"expression":"<算式，如2+3*4、sin(30)、sqrt(2)"}'
```

根据数学表达式字符串计算结果，三角函数默认角度制。可选参数：`use_radians`（为true时用弧度计算，默认false）。

---

## 八、录音机

> 来源 App：`com.android.soundrecorder`

```
ability.call method="recorder_open_recording" params='{"params":"录音"}'
```

打开录音机并开始录音。

```
ability.call method="recorder_open_search" params='{"params":"搜索"}'
```

打开录音机搜索页面。

```
ability.call method="recorder_open_edit_by_position" params='{"index_record":"<录音位置>"}'
```

打开录音机编辑第N个录音。

```
ability.call method="recorder_open_edit_by_name" params='{"record_name":"<录音名称>"}'
```

打开录音机编辑命名为X的录音。

```
ability.call method="recorder_delete_file_by_position" params='{"index_record":"<删除位置>"}'
```

打开录音机删除第N个录音。

```
ability.call method="recorder_delete_file_by_name" params='{"record_name":"<录音名称>"}'
```

打开录音机删除命名为X的录音。

```
ability.call method="recorder_open_recoginition_by_position" params='{"index_record":"<录音位置>"}'
```

打开录音机转写第N个录音。

```
ability.call method="recorder_open_recoginition_by_name" params='{"record_name":"<录音名称>"}'
```

打开录音机转写命名为X的录音。

---

## 九、工具箱

> 来源 App：`com.stepos.stepos.toolbox`

```
ability.call method="toolbox_open_magnifier_activity" params='{}'
```

打开工具箱放大镜页面。

```
ability.call method="toolbox_open_compass_activity" params='{}'
```

打开工具箱指南针页面。

```
ability.call method="toolbox_open_mirror_new_activity" params='{}'
```

打开工具箱镜子页面。

```
ability.call method="toolbox_open_decibel_activity" params='{}'
```

打开工具箱分贝仪页面，查看当前分贝数值。

```
ability.call method="open_tool_sos" params='{}'
```

打开工具箱里的SOS闪烁灯功能。

```
ability.call method="get_current_decibel" params='{}'
```

获取当前分贝值。

---

## 十、反馈

> 来源 App：`com.stepos.feedback`

```
ability.call method="feedback_submit_question" params='{"content":"<问题描述>"}'
```

提交用户问题反馈到帮助与反馈系统。系统会自动收集设备信息（机型、系统版本等）并上传。可选参数：`categoryId`（问题分类ID，默认100通用反馈）；`contact`（联系方式，手机号或邮箱）。

---

## 十一、渲染工具

> 来源：`data_content_provider`

```
ability.call method="renderTemplate" params='{"type":"<模板页面，如摄影攻略:shoot_guide_detail>"}'
```

UI模板渲染。可选参数：`structuredContent`（业务侧的对象数据）。
