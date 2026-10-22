# file_memory — 文件与记忆

> 来源 App：`com.stepos.common.ability.proxy`（通用原子能力）、`com.stepos.notepaper`（笔记）

---

## 一、文件上传与剪贴板

```
ability.call method="batch_file_upload" params='{"files":"<要上传的文件URI列表>"}'
```

执行文件上传。

```
ability.call method="batch_file_upload_return_all" params='{"files":"<要上传的文件URI列表>"}'
```

执行文件上传，返回所有结果。

```
ability.call method="batch_file_upload_all_progress" params='{"files":"<要上传的文件URI列表>"}'
```

执行文件上传，并返回实时进度。

```
ability.call method="common_ability_clipboard_text" params='{}'
```

获取粘贴板文本内容。

---

## 二、笔记管理

```
ability.call method="phone_note_add" params='{"content":"<笔记的内容>"}'
```

在笔记应用中添加一个新的笔记。可选参数：`title`（笔记的标题）。

```
ability.call method="phone_note_access" params='{"keyword":"<搜索笔记的关键词>"}'
```

根据关键词和最近的时间范围访问和搜索笔记应用中的笔记。可选参数：`time_limit`（筛选笔记的最近天数限制，1=最近一条，2=今天，3=近三天，4=近七天）。

```
ability.call method="phone_note_edit" params='{"content":"<向笔记中追加的新内容>"}'
```

通过标题查找指定笔记，并向其内容末尾追加新的文字内容。可选参数：`title`（待编辑笔记的标题）。

```
ability.call method="phone_note_remind_sub" params='{}'
```

访问和查询已设置提醒信息的笔记。可选参数：`keyword`（在有提醒的笔记中搜索的关键词）。

---

## 三、待办事项管理

```
ability.call method="phone_note_todo_add" params='{"content":"<待办事项的详细描述或正文内容>"}'
```

在笔记应用中添加一条新的待办事项（Todo），支持设置标题、正文、提醒时间和地点，并支持子任务。可选参数：`title`（简短标题）；`time`（待办时间，格式yyyy-MM-dd HH:mm）；`location`（关联地点）；`subtasks`（子任务列表，多个用逗号分隔）；`keyword`（分类关键字）。

```
ability.call method="phone_note_todo_complete" params='{"title":"<待办事项的标题>"}'
```

通过标题将最近一条匹配到的待办事项标记为已完成。

```
ability.call method="phone_note_todo_access" params='{"keyword":"<搜索待办事项的关键词>"}'
```

从笔记应用中根据关键词和最近的时间范围访问和查询待办事项。可选参数：`time_limit`（待办截止时间类型，0=进行中，1=最近一条，2=今天，3=后三天，4=后七天）。

---

## 四、文件管理

> 来源 App：`com.stepos.filemanager`

安全删除与恢复属于动态注册原子能力。执行前优先用 `ability.list` 查询：

```
nodes action=invoke node="<节点ID>" invokeCommand="ability.list" invokeParamsJson='{"query":"安全删除文件到回收站"}'
```

或：

```
nodes action=invoke node="<节点ID>" invokeCommand="ability.list" invokeParamsJson='{"query":"从回收站按原始路径恢复文件"}'
```

若返回 `file_safe_delete` / `file_restore`，必须复制返回的 `method` 原样调用 `ability.call`。如果本文件已明确列出 method，也可以直接调用，但禁止使用 `rm`、shell 删除或覆盖恢复目标。

```
ability.call method="file_safe_delete" params='{"path":"<外部存储文件或目录原始路径>","recursive":true}'
```

安全删除文件或目录到可恢复回收站。删除手机外部存储文件时优先使用此能力，禁止用 `rm` 或 shell 删除替代。

```
ability.call method="file_restore" params='{"path":"<删除前的外部存储原始路径>","recursive":true}'
```

按原始路径从回收站恢复文件或目录。目标路径已存在时不会覆盖。

```
ability.call method="file_path_get" params='{"file_uri":"<文件URI>"}'
```

获取文件路径URI。

```
ability.call method="file_size_get" params='{"file_uri":"<文件URI>"}'
```

获取文件大小。

```
ability.call method="file_create_time_get" params='{"file_uri":"<文件URI>"}'
```

获取文件创建时间。

```
ability.call method="file_update_time_get" params='{"file_uri":"<文件URI>"}'
```

获取文件更新时间。

```
ability.call method="file_detail_get" params='{"file_uri":"<文件URI>"}'
```

获取文件详细信息。

```
ability.call method="folder_create" params='{"folderName":"<文件夹名称>"}'
```

创建文件夹。

```
ability.call method="file_create" params='{"fileName":"<文件名称>","folderName":"<所在文件夹名>"}'
```

创建文件。

```
ability.call method="file_search" params='{"keywords":"<搜索关键词>"}'
```

文件搜索。

```
ability.call method="file_apk_list" params='{}'
```

查询APK文件列表。

```
ability.call method="file_compress_list" params='{}'
```

查询压缩类文件列表。

```
ability.call method="file_document_list" params='{}'
```

查询文档类文件列表。

```
ability.call method="file_voice_list" params='{}'
```

查询音频类文件列表。

```
ability.call method="file_video_list" params='{}'
```

查询视频类文件列表。

```
ability.call method="file_download_list" params='{}'
```

查询下载文件列表。

```
ability.call method="file_weixin_list" params='{}'
```

微信类文件列表。

```
ability.call method="file_browser_list" params='{}'
```

查询浏览器缓存文件列表。

```
ability.call method="file_bluetooth_list" params='{}'
```

查询蓝牙传输文件列表。

```
ability.call method="file_move" params='{"srcPath":"<源文件路径>","desPath":"<目标路径>"}'
```

文件移动。
