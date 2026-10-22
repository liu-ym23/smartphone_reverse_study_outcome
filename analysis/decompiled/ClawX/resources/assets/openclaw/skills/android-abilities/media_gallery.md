# media_gallery — 相册与媒体编辑

> 来源 App：`com.stepos.media.gallery`（图库）

---

## 一、媒体获取与搜索

```
ability.call method="gallery_get_latest_media" params='{}'
```

获取本地设备中最新创建的媒体文件（图片或视频）的完整路径。可选参数：`mediaType`（媒体资源类型，可选值：video 或 image，默认 image）。

```
ability.call method="gallery_get_media_by_time_range" params='{"startTime":"<开始时间，格式YYYY-MM-DD HH:mm:ss>","endTime":"<结束时间，格式YYYY-MM-DD HH:mm:ss>"}'
```

按时间范围查询视频或图片。注意：必须先获取当前系统时间后再调用，严禁使用硬编码日期。可选参数：`mediaType`（媒体类型：video 或 image，默认 image）。

```
ability.call method="gallery_intelligent_search" params='{"search_content":"<搜索内容>"}'
```

对本地相册的媒体资源进行语义智能搜索。可选参数：`countLimit`（搜索数量）。

```
ability.call method="gallery_get_photo_info" params='{"path":"<图片文件路径>"}'
```

获取照片详细信息，包括宽高、文件大小、文件名、拍摄时间、相机型号、焦距、ISO、光圈、快门速度、GPS 信息等。

```
ability.call method="gallery_get_video_info" params='{"path":"<视频文件路径>"}'
```

获取视频详细信息，包括宽高、文件大小、文件名、时长（毫秒）、码率、音频采样率等。

---

## 二、图片编辑 — 添加元素

```
ability.call method="gallery_add_picture_text" params='{"path":"<图片的文件路径>","value":"<需要添加到图片上的文字内容>"}'
```

在图片上添加文字，系统会自动读取图片真实宽高并根据位置描述自动计算坐标。可选参数：`position`（文字位置，如 top-left、center、bottom-right 等）；`color`（文字颜色）；`size`（字体大小，建议14-60，默认40）；`faceType`（字体样式，bold 或 default）；`rotation`（旋转角度）。

```
ability.call method="gallery_add_picture_watermark" params='{"path":"<图片路径>"}'
```

图片水印编辑。可选参数：`width`（宽）；`height`（高）；`value`（水印文案）；`color`（hex颜色）；`size`（字体大小）；`position`（水印位置）；`rotation`（角度）。

```
ability.call method="gallery_add_picture_mosaic" params='{"path":"<图片的文件路径>","regions":"<马赛克区域列表>"}'
```

在图片指定位置添加马赛克效果，支持单区域或多区域打码。可选参数：`blockSize`（马赛克块大小，建议10-50，默认20）；`type`（马赛克类型：block 或 image）。

```
ability.call method="gallery_add_picture_filter" params='{"path":"<图片的文件路径>","filterType":"<滤镜类型>"}'
```

给图片添加滤镜效果，支持 brightness、contrast、documentary、duotone、fillLight、fisheye、tint 等类型。可选参数：`width`（宽）；`height`（高）。

---

## 三、图片编辑 — 图像调整

```
ability.call method="gallery_edit_picture_brightness" params='{"path":"<图片路径>","brightness":"<亮度值，范围-255~255>"}'
```

图片亮度编辑。可选参数：`width`（宽）；`height`（高）。

```
ability.call method="gallery_edit_picture_saturation" params='{"path":"<图片路径>","saturation":"<饱和度因子，0.0-2.0，1.0为原始>"}'
```

图片饱和度编辑。可选参数：`width`（宽）；`height`（高）。

```
ability.call method="gallery_edit_picture_temperature" params='{"path":"<图片路径>","temperature":"<色温值，范围-100到100>"}'
```

图片色温值编辑，负值偏冷色调，正值偏暖色调。可选参数：`width`（宽）；`height`（高）。

```
ability.call method="gallery_edit_picture_sharpen" params='{"path":"<图片完整文件路径>","sharpen":"<锐化强度，0.0-1.0>"}'
```

图片锐化强度编辑，path 必须是具体的图片文件完整路径。可选参数：`width`（宽）；`height`（高）。

```
ability.call method="gallery_reduce_picture_resolution" params='{"path":"<图片路径>","reduceResolution":"<降低分辨率比率，0.0~1.0>"}'
```

降低图片分辨率（仅支持降低，不支持提高）。可选参数：`width`（宽）；`height`（高）。

---

## 四、图片编辑 — 裁剪与变换

```
ability.call method="gallery_edit_picture_aspect_ratio" params='{"path":"<图片路径>"}'
```

按照指定宽高比对图片进行中心裁剪，仅支持 1:1/4:3/16:9/3:4/9:16 这些比例。可选参数：`width`（宽）；`height`（高）；`aspectRatio`（长宽比例）。

```
ability.call method="gallery_edit_picture_degree" params='{"path":"<图片路径>"}'
```

对图片进行旋转操作，旋转角度仅支持 90/180/270 度顺时针方向。可选参数：`degrees`（旋转角度）；`width`（宽）；`height`（高）。

```
ability.call method="gallery_edit_picture_flip" params='{"path":"<图片的文件路径>"}'
```

对图片进行翻转操作，支持水平翻转（左右镜像）和垂直翻转（上下镜像）。可选参数：`direction`（翻转方向：horizontal 或 vertical）。

```
ability.call method="gallery_edit_picture_paint" params='{"path":"<图片路径>"}'
```

图片画笔编辑。可选参数：`width`（宽）；`height`（高）；`paintPath`（绘制路径）；`size`（画笔粗度）；`color`（颜色）。

```
ability.call method="gallery_open_picture_editor" params='{"path":"<图片路径>"}'
```

打开图片编辑页面。

```
ability.call method="gallery_ai_extend_image" params='{"path":"<图片路径>"}'
```

打开图片编辑页并直接进入 AI 扩图能力。支持传入本地图片文件路径，也支持 `file://` 与 `content://` URI。

---

## 五、视频处理

```
ability.call method="gallery_open_video_editor" params='{"path":"<视频文件路径>"}'
```

打开视频编辑页面。

```
ability.call method="gallery_open_video_player" params='{"path":"<视频路径>"}'
```

打开视频播放器。

```
ability.call method="gallery_video_editor_start" params='{"medias":"<视频编辑需要的素材路径列表>"}'
```

启动视频编辑器卡片。

```
ability.call method="gallery_video_clip_arrangement" params='{"medias":"<自动生成视频剪辑草稿需要的素材路径列表>"}'
```

将相册的图片或视频自动生成视频剪辑草稿。优先不传 `medias` 参数，由用户在相册中主动选择素材；禁止默认或自动使用“最近素材”发起剪辑。

```
ability.call method="gallery_create_highlight_task" params='{}'
```

创建高光LivePhoto生成任务卡片，用户点击按钮后选择视频，AI分析并生成LivePhoto文件。

```
ability.call method="gallery_create_voiceover_task" params='{}'
```

创建口播创作任务卡片。该能力固定使用空参数调用（`params='{}'`），由用户在相册中主动选择素材后再开始分析与生成；禁止默认或自动使用“最近素材”发起口播剪辑。

---

## 六、相册管理

```
ability.call method="gallery_create_album" params='{"albumName":"<相册名称>"}'
```

新建相册。

```
ability.call method="gallery_delete_album" params='{"albumName":"<相册名称>"}'
```

删除相册。

```
ability.call method="gallery_copy_files_to_album" params='{"albumName":"<相册名称>","filePaths":["<文件路径1>","<文件路径2>"]}'
```

拷贝图片到相册。

```
ability.call method="gallery_delete_media_files" params='{"filePaths":"<要删除的媒体文件路径列表>"}'
```

将媒体文件移动到回收站（非永久删除），支持批量清理媒体文件。

```
ability.call method="gallery_move_media_to_album" params='{"filePath":"<媒体文件路径>","albumName":"<目标相册名称>"}'
```

移动图片到相册。将指定的图片或视频移动到目标相册，如果目标相册不存在则先创建相册。

```
ability.call method="gallery_hide_album" params='{"albumName":"<相册名称>"}'
```

隐藏相册。将相册中的所有图片和视频隐藏，同时相册本身也从相册列表中隐藏。

```
ability.call method="gallery_set_album_cover" params='{"albumName":"<相册名称>","coverFilePath":"<封面图片路径>"}'
```

设置相册封面。将指定的图片设置为相册的封面图片。

```
ability.call method="gallery_rename_media" params='{"path":"<媒体文件路径>","newName":"<新文件名>"}'
```

重命名媒体文件。将指定的图片或视频文件重命名为新的名称。`newName` 可不带扩展名，系统会自动保留原文件扩展名。

```
ability.call method="gallery_copy_media" params='{"sourcePath":"<源文件路径>","destinationPath":"<目标文件路径>"}'
```

复制媒体文件到指定位置。

```
ability.call method="gallery_move_to_folder" params='{"path":"<源文件路径>","folderPath":"<目标文件夹路径>"}'
```

移动媒体文件到指定文件夹。

```
ability.call method="gallery_hide_media" params='{"path":"<媒体文件路径>"}'
```

隐藏媒体文件，从相册中移除但不删除。

```
ability.call method="gallery_unhide_media" params='{"path":"<媒体文件路径>"}'
```

取消媒体文件隐藏，恢复显示到相册中。

```
ability.call method="gallery_share_media" params='{"path":"<媒体文件路径>"}'
```

分享媒体文件，弹出系统分享对话框。

```
ability.call method="gallery_favorite_media" params='{"path":"<媒体文件路径>","isFavorite":"<是否收藏，true 或 false>"}'
```

收藏或取消收藏媒体文件。

```
ability.call method="gallery_compress_media" params='{"path":"<媒体文件路径>","quality":"<压缩质量，1-100，默认值需根据实际情况设定>"}'
```

压缩媒体文件，支持图片和视频压缩。压缩后的文件保存在系统图片目录的 compressed 文件夹下，返回压缩后的文件路径。

```
ability.call method="gallery_set_wallpaper" params='{"path":"<图片文件路径>"}'
```

将指定路径的图片设置为手机壁纸。

---

## 七、视频任务卡片更新（Agent 内部调用）

```
ability.call method="gallery_update_intent_understand_card" params='{"taskRequestBody":"<JSON字符串，与视频剪辑Agent约定的数据结构>"}'
```

更新意图理解任务卡片内容（包含思考过程、意图理解内容）。

```
ability.call method="gallery_update_material_analysis_card" params='{"taskRequestBody":"<JSON字符串，与视频剪辑Agent约定的数据结构>"}'
```

更新素材分析任务卡片内容（包含思考过程、分析进度、分析结果、高光提取内容）。

```
ability.call method="gallery_update_story_construct_card" params='{"taskRequestBody":"<JSON字符串，与视频剪辑Agent约定的数据结构>"}'
```

更新故事构造任务卡片内容（包含思考过程、故事结构）。

```
ability.call method="gallery_update_video_output_card" params='{"taskRequestBody":"<JSON字符串，与视频剪辑Agent约定的数据结构>"}'
```

更新视频输出任务卡片内容（包含思考过程、视频草稿工程文件列表）。

```
ability.call method="gallery_create_auto_edit_video_task" params='{"mediaPaths": "<本地图片或视频的完整路径列表；不传或空数组表示由用户在任务卡片中选择素材>"}'
```

视频自动剪辑（AI 剪辑）优先不传 `mediaPaths` 参数，或传空数组，由用户在任务卡片中主动选择素材；禁止默认或自动使用“最近素材”直接发起剪辑。

---

## 八、资源与模版获取

```
ability.call method="gallery_get_sticker_columns" params='{}'
```

获取相册中贴纸类目。可选参数：`countLimit`（类目最大获取数量）。

```
ability.call method="gallery_get_stickers" params='{"columnIds":"<要查询的指定的贴纸类目ID的列表>"}'
```

获取相册中指定类目的贴纸列表，支持查询多个类目。可选参数：`countLimit`（贴纸最大获取数量）。

```
ability.call method="gallery_get_local_stickers" params='{}'
```

获取相册本地的贴纸列表，该贴纸是从抠图中添加的。可选参数：`countLimit`（贴纸最大获取数量）。

```
ability.call method="gallery_get_style_templates" params='{}'
```

获取风格转换的模版列表。可选参数：`countLimit`（模版最大获取数量）。