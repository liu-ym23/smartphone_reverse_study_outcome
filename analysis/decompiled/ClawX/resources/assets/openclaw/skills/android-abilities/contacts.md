# contacts — 联系人与黑名单

> 来源 App：`com.android.dialer`（电话）、`com.android.mms`（信息）

---

## 来自 com.android.dialer — 联系人

```
ability.call method="dialer_contacts_add" params='{"number":"<联系人号码>"}'
```

添加联系人，需要提供号码，还可选填名称、邮箱、公司、职位、备注、地址等信息。可选参数：`name`（名称）；`email`（邮箱）；`company`（公司）；`title`（职位）；`note`（备注）；`address`（地址）。

```
ability.call method="dialer_contacts_update" params='{}'
```

修改联系人的信息。可选参数：`number`（号码）；`name`（名字）；`email`（邮箱）；`company`（公司）；`title`（职位）；`note`（备注）；`address`（地址）。

```
ability.call method="dialer_contacts_query" params='{}'
```

查询联系人，可以通过号码、名称等信息查询。可选参数：`number`（通过号码查询）；`name`（通过名称查询）；`limit`（查询结果数量限制）。

```
ability.call method="dialer_contacts_delete" params='{}'
```

删除联系人，支持按号码、姓名、公司、地址匹配删除。可选参数：`number`（基于号码删除）；`name`（基于姓名删除）；`company`（基于公司删除）；`address`（基于地址删除）。

```
ability.call method="dialer_contacts_delete_one" params='{"number":"<要删除联系人的电话号码>"}'
```

删除指定号码对应的单个联系人。

```
ability.call method="dialer_open_contacts_editor" params='{}'
```

打开联系人编辑界面。可选参数：`number`（号码）；`name`（名字）。

```
ability.call method="dialer_add_group" params='{"title":"<联系人群组名>"}'
```

添加联系人群组，需要提供群组名。

```
ability.call method="dialer_contacts_set_starred" params='{"starred":"<true收藏/false取消>"}'
```

收藏或取消收藏联系人。可选参数：`number`（号码，优先级高）；`name`（姓名，模糊匹配，多个联系人时需提供number）。

```
ability.call method="dialer_contacts_copy_number" params='{"name":"<联系人姓名，支持模糊匹配>"}'
```

复制指定联系人的手机号码到系统剪贴板。

```
ability.call method="dialer_open_my_business_card" params='{}'
```

打开我的名片（本地个人档案）。

---

## 来自 com.android.dialer — 黑名单

```
ability.call method="dialer_open_blocked_number_list" params='{}'
```

打开黑名单管理界面。

```
ability.call method="dialer_add_number_to_blocked_list" params='{"number":"<要加入黑名单的电话号码>"}'
```

将指定的号码加入黑名单数据库。

```
ability.call method="dialer_delete_number_from_blocked_list" params='{"number":"<要从黑名单移除的电话号码>"}'
```

从黑名单数据库移除指定的号码。

```
ability.call method="dialer_query_blocked_number" params='{"number":"<要查询是否在黑名单中的电话号码>"}'
```

查询指定的号码是否在黑名单中。

---

## 来自 com.android.mms — 联系人

```
ability.call method="tele_contacts_query" params='{}'
```

查询联系人。可选参数：`number`（通过号码查询）；`name`（通过名称查询）；`limit`（查询结果数量限制）。

```
ability.call method="tele_contacts_delete" params='{}'
```

删除联系人，支持按号码、姓名、公司、地址匹配删除。可选参数：`number`（基于号码删除）；`name`（基于姓名删除）；`company`（基于公司删除）；`address`（基于地址删除）。

```
ability.call method="tele_contacts_delete_one" params='{"number":"<要删除联系人的电话号码>"}'
```

删除指定号码对应的单个联系人。

---

## 来自 com.android.mms — 黑名单

```
ability.call method="tele_blocked_add_number" params='{"number":"<要添加到黑名单的号码>"}'
```

添加号码黑名单。

```
ability.call method="tele_blocked_delete_number" params='{"number":"<要从黑名单删除的号码>"}'
```

删除黑名单号码。

```
ability.call method="tele_blocked_query_number" params='{"number":"<要查询是否为黑名单的号码>"}'
```

查询某号码是否为黑名单号码。

```
ability.call method="tele_blocked_open_blocked_number" params='{}'
```

打开黑名单管理界面。

```
ability.call method="tele_dialer_add_last_call_number_to_blocked_list" params='{}'
```

将最近一次通话记录号码加入黑名单。
