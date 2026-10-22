# scheduled_tasks — 定时任务、网关与时钟

> 本类目是 **定时 / cron / 网关 / 系统时钟**
>
> ⚠️ 主要工具（`cron`、`gateway`）为云侧 OpenClaw 能力
> 端侧定时短信能力（`tele_sms_schedule_send`）已归入 `phone_comm`

---

## 云侧工具参考

```
ability.call method="cron create" params='{"expression":"<cron表达式>","prompt":"<定时执行的提示词>"}'
```

创建定时任务，设置 cron 表达式和要执行的 prompt。

```
ability.call method="cron list" params='{}'
```

查看所有已创建的定时任务。

```
ability.call method="cron delete" params='{"id":"<任务ID>"}'
```

删除指定的定时任务。

```
ability.call method="gateway" params='{"action":"<操作类型>"}'
```

Agent 网关管理。

---

## 端侧工具

> 来源 App：`com.android.alarmclock`

```
ability.call method="alarm_clock_get_current_time_zone" params='{}'
```

获取当前时间、位置和时区。

```
ability.call method="alarm_clock_add" params='{"hour":"<闹钟小时，0-23>","minute":"<闹钟分钟，0-59>"}'
```

创建新闹钟。可选参数：`vibrate`（是否震动）；`repeatDays`（重复天数，0=一次，1=每天，2=周一到周五）。

```
ability.call method="alarm_clock_delete" params='{"hour":"<要删除闹钟的小时，0-23>","minute":"<要删除闹钟的分钟，0-59>"}'
```

按时间删除已有闹钟。

```
ability.call method="alarm_clock_disable" params='{}'
```

禁用所有闹钟。

```
ability.call method="alarm_clock_get_enable" params='{}'
```

获取所有已启用的闹钟。

```
ability.call method="alarm_clock_delete_all" params='{}'
```

永久删除所有闹钟，不可撤销。

```
ability.call method="alarm_clock_snooze" params='{}'
```

暂停所有正在响铃的闹钟（使用各闹钟已配置的贪睡时长）。

```
ability.call method="alarm_clock_get_current_time_by_city" params='{"city":"<世界时钟城市ID、本地化或英文城市名、或时区字符串>"}'
```

从世界时钟列表中获取指定城市的当前时间。

```
ability.call method="alarm_clock_timer_add" params='{"seconds":"<倒计时秒数，1-86400>"}'
```

启动一个新的倒计时计时器。可选参数：`label`（计时器标签）。

---

## 云侧工具扩展

```
ability.call method="get-current-time" params='{}'
```

获取当前时间（含星期），必须在需要日期/时间信息时调用此工具，不可依赖训练数据中的日期认知。可选参数：`timeZone`（IANA时区名，如 `Asia/Shanghai`，默认 `Asia/Shanghai`）。
