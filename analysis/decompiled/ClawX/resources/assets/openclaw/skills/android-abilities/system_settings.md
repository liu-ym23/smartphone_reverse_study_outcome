# system_settings — 系统设置

> 来源 App：`com.android.settings`（设置）

---

## 一、直接开关与数值设置

### 网络与连接

```
ability.call method="settings_wifi_switch" params='{"openState":"<打开或关闭WIFI，true为打开，false为关闭>"}'
```

打开或关闭WIFI。

```
ability.call method="settings_bluetooth_switch" params='{"openState":"<打开或关闭蓝牙，true为打开，false为关闭>"}'
```

打开或关闭蓝牙。

```
ability.call method="settings_hotspot_switch" params='{"openState":"<开启或关闭热点，true为开启，false为关闭>"}'
```

开启或关闭热点。

```
ability.call method="settings_airplane_mode_switch" params='{"openState":"<打开或关闭飞行模式，true为打开，false为关闭>"}'
```

打开或关闭飞行模式。

```
ability.call method="settings_data_switch" params='{"openState":"<打开或关闭数据网络，true为打开，false为关闭>"}'
```

打开或关闭数据网络。

```
ability.call method="settings_connect_wifi" params='{"ssid":"<WIFI名称>","password":"<WIFI密码>"}'
```

连接一个新的WIFI，需要提供对应的名称和密码。

```
ability.call method="settings_choose_wifi" params='{"newValue":"<要切换到的WIFI名称>"}'
```

切换到一个已保存的WIFI。

```
ability.call method="settings_forget_wifi" params='{"newValue":"<要删除/忘记的WIFI名称>"}'
```

删除/忘记已保存的WIFI。

```
ability.call method="settings_config_hotspot" params='{"ssid":"<热点名称>","password":"<热点密码>"}'
```

开启热点并设置热点名称和密码（密码长度需大于8位）。

```
ability.call method="settings_open_wifi_details_activity" params='{"openState":"<true为打开WIFI详情页>"}'
```

打开当前连接的WIFI详情页面，可查看技术标准、IP地址、MAC地址等详情。

### 显示与亮度

```
ability.call method="settings_set_brightness" params='{"newValue":"<亮度数值，1-100的百分比比例>"}'
```

调整屏幕亮度到指定数值。

```
ability.call method="settings_adjust_brightness" params='{"openState":"<调亮为true，调暗为false>"}'
```

相对调整屏幕亮度（调亮一些或调暗一些）。

```
ability.call method="settings_auto_brightness_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭自动亮度调节。

```
ability.call method="settings_auto_rotation_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭屏幕自动旋转。

```
ability.call method="settings_dark_mode_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭系统深色模式。

```
ability.call method="settings_screen_saver_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭屏保开关。

```
ability.call method="settings_set_screen_off_time" params='{"newValue":"<息屏时间，单位秒>"}'
```

调整自动锁屏时间（15秒、30秒、1分钟等，单位为秒）。

```
ability.call method="settings_adjust_screen_off_time" params='{"openState":"<延长为true，缩短为false>"}'
```

延长或缩短自动锁屏时间。

### 音量与声音

```
ability.call method="settings_set_media_sound" params='{"newValue":"<媒体音量百分比>"}'
```

调整媒体音量到指定百分比。

```
ability.call method="settings_adjust_sound" params='{"openState":"<增大为true，减小为false>"}'
```

增大或减小媒体音量。

```
ability.call method="settings_vibration_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭系统震动。

```
ability.call method="settings_disturb_mode_switch" params='{"openState":"<开启为true，关闭为false>"}'
```

开启或关闭系统勿扰模式。

```
ability.call method="settings_dialing_keypad_sound_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭拨号键盘提示音。

```
ability.call method="settings_screen_lock_sound_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭屏幕锁定提示音。

```
ability.call method="settings_charging_notif_sound_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭充电提示音和振动。

```
ability.call method="settings_touch_sound_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭点按和点击提示音。

### 字体与显示大小

```
ability.call method="settings_adjust_font_size" params='{"openState":"<调大为true，调小为false>"}'
```

将字体调大一些或调小一些。

```
ability.call method="settings_adjust_display_size" params='{"openState":"<调大为true，调小为false>"}'
```

将界面显示调大一些或调小一些。

### 省电与电池

```
ability.call method="settings_battery_saver_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭省电模式。

```
ability.call method="settings_battery_percentage_switch" params='{"openState":"<显示为true，隐藏为false>"}'
```

显示或隐藏电池电量百分比。

### 交互与手势

```
ability.call method="settings_one_handed_mode_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭单手模式。

```
ability.call method="settings_tapToCheck_phone_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭"点按手机即显示"（点击屏幕亮屏）。

```
ability.call method="settings_liftToCheck_phone_switch" params='{"openState":"<打开为true，关闭为false>"}'
```

打开或关闭拿起手机即显示（抬起亮屏）功能。

```
ability.call method="settings_adjust_navigation_mode" params='{"openState":"<手势导航为true，按键导航为false>"}'
```

切换系统导航模式，支持手势导航和三键（按键）导航之间的切换。

```
ability.call method="settings_adjust_system_language" params='{"newValue":"<系统语言代码，如CHINESE、ENGLISH等>"}'
```

切换系统语言，支持中文、英语、法语、德语、意大利语、日语、韩语等。

---

## 二、页面跳转类

### 设置主页

```
ability.call method="settings_open_settings_homepage_activity" params='{}'
```

打开设置主页面。

```
ability.call method="settings_open_settings_system_dashboard_activity" params='{}'
```

打开系统设置界面，提供语言、手势、日期和时间、备份、用户、重置选项等菜单。

```
ability.call method="settings_open_settings_device_info_settings_activity" params='{}'
```

打开/进入关于本机界面。该界面展示了手机型号，系统版本号以及设备标识符：ip地址，mac地址
```
ability.call method="settings_open_sub_settings_reset_dashboard_activity" params='{}'
```

打开重置选项界面，包括重置移动网络、蓝牙和WLAN、应用偏好设置、恢复出厂设置等选项。

### 网络类页面

```
ability.call method="settings_open_settings_network_dashboard_activity" params='{}'
```

打开设置的网络页面，可访问WIFI、热点、SIM卡、VPN、DNS等功能。

```
ability.call method="settings_open_settings_network_provider_settings_activity" params='{}'
```

打开设置的WIFI页面，包含WIFI网络搜索、添加、连接、已保存网络等入口。

```
ability.call method="settings_open_settings_configure_wifi_settings_activity" params='{}'
```

打开WIFI偏好设置页面，包含自动打开WIFI控制、公共网络提醒、证书安装等功能。

```
ability.call method="settings_open_settings_saved_access_points_settings_activity" params='{}'
```

打开已保存WIFI页面，可进行取消保存、断开连接、分享、查看详情等操作。

```
ability.call method="settings_open_settings_mobile_network_list_activity" params='{}'
```

打开SIM卡管理页面，包含双卡数据切换、数据流量开关控制等功能。

```
ability.call method="settings_open_settings_reset_mobile_network_settings_activity" params='{}'
```

打开数据网络重置页面（仅展示，不直接重置）。

```
ability.call method="settings_open_settings_tether_settings_activity" params='{}'
```

打开热点/网络共享页面，供用户手动开关热点。

```
ability.call method="settings_open_settings_wifi_p_2_p_settings_activity" params='{}'
```

打开P2P连接页面，可查看搜索到的支持P2P的设备并发起连接。

```
ability.call method="settings_open_settings_vpn_settings_activity" params='{}'
```

打开VPN连接页面，可对VPN进行添加/配置。

```
ability.call method="settings_open_settings_data_saver_summary_activity" params='{}'
```

打开省流模式页面，可配置不限制移动数据用量的应用及手动开关省流模式。

```
ability.call method="settings_open_settings_wifi_display_settings_activity" params='{}'
```

打开投屏设置界面，可搜索附近可投屏的设备。

### 已连接设备页面

```
ability.call method="settings_open_settings_connected_device_dashboard_activity" params='{}'
```

打开已连接设备页面，展示已连接的蓝牙、USB相关功能。

```
ability.call method="settings_open_settings_blue_tooth_pairing_activity" params='{}'
```

打开蓝牙页面，供用户连接/配置蓝牙。

```
ability.call method="settings_open_settings_nfc_settings_activity" params='{}'
```

打开NFC设置页面，可进行NFC功能的设置。

```
ability.call method="settings_open_settings_advanced_connected_device_activity" params='{}'
```

打开连接偏好设置页面，供用户对蓝牙、NFC、投屏、打印、超带宽功能的偏好进行设置。

```
ability.call method="settings_open_settings_usb_details_activity" params='{}'
```

打开USB详情页面，提供USB偏好设置。

```
ability.call method="settings_open_settings_print_settings_activity" params='{}'
```

打开打印页面，可选择默认打印服务或其他已安装的打印服务。

### 显示类页面

```
ability.call method="settings_open_settings_screen_timeout_activity" params='{}'
```

打开自动锁屏界面（仅展示，不直接调整时间）。

```
ability.call method="settings_open_settings_text_reading_settings_activity" params='{}'
```

打开显示大小和文字大小调整界面，还提供粗体文字和高对比度文字开关。

```
ability.call method="settings_open_settings_color_contrast_activity" params='{}'
```

打开颜色对比度调整界面，还提供高对比度文字开关。

```
ability.call method="settings_open_sub_settings_color_mode_preference_activity" params='{}'
```

打开颜色设置界面，提供颜色自然色和自适应的切换功能。

```
ability.call method="settings_open_settings_dream_settings_activity" params='{}'
```

打开屏保界面（仅展示，不直接打开或关闭屏保）。

```
ability.call method="settings_open_settings_wallpaper_settings_activity" params='{}'
```

打开壁纸界面，可通过不同壁纸来源进行壁纸设置。

```
ability.call method="settings_open_settings_lock_screen_settings_activity" params='{}'
```

打开锁屏界面，可调整锁屏显示的通知内容、显示文字及动态时钟等。

### 声音与通知页面

```
ability.call method="settings_open_settings_sound_settings_activity" params='{}'
```

打开音量管理页面，包含音量、振动、勿扰模式及手机铃声等设置项。

```
ability.call method="settings_open_settings_notification_assistant_settings_activity" params='{}'
```

打开通知管理页面，可显示历史通知及通知常规设置项。

```
ability.call method="settings_open_settings_zen_mode_settings_activity" params='{}'
```

打开勿扰模式管理页面，可配置排除在外的联系人、应用、时间段等。

### 安全与锁屏页面

```
ability.call method="settings_open_settings_fingerprint_settings_activity" params='{}'
```

打开锁屏密码设置页面，包含滑动、图案、PIN码、密码等锁屏方式选择。

### 键盘与语言页面

```
ability.call method="settings_open_settings_keyboard_settings_activity" params='{}'
```

打开键盘管理页面，包含键盘切换入口、个人字典配置、指针速度调整等功能。

```
ability.call method="settings_open_settings_date_time_settings_activity" params='{}'
```

打开语言设置界面（仅展示，不直接调整系统语言）。

```
ability.call method="settings_open_settings_locale_picker_activity" params='{}'
```

打开语言设置界面（仅展示，不直接调整系统语言）。

```
ability.call method="settings_open_settings_measurement_system_settings_activity" params='{}'
```

打开导航模式设置界面，提供手势导航和"三按钮"导航的切换。

### 应用与存储页面

```
ability.call method="settings_open_manage_applications" params='{}'
```

打开所有应用页面，展示所有已安装的应用。

```
ability.call method="settings_open_settings_app_dashboard_activity" params='{}'
```

打开应用管理页面，可查看最近使用和已安装的应用，也是默认应用设置的入口。

```
ability.call method="settings_open_settings_storage_dashboard_activity" params='{}'
```

打开存储空间界面，展示存储空间使用量及存储空间管理。

### 电池页面

```
ability.call method="settings_open_settings_power_usage_summary_activity" params='{}'
```

打开电池界面，展示电池使用信息及电池电量相关开关设置。

```
ability.call method="settings_open_sub_settings_power_usage_advanced_activity" params='{}'
```

打开电池使用情况界面，展示电池充满电使用时间、应用耗电量等信息。

### 手势与辅助页面

```
ability.call method="settings_open_sub_settings_gesture_settings_activity" params='{}'
```

打开手势界面，包含快速打开相机、导航模式、单手模式、点按/拿起手机即显示等功能。

---

## 三、设备能力查询

> 来源 App：`com.stepos.common.ability.proxy`

```
ability.call method="common_ability_has_fingerprint" params='{}'
```

获取当前手机是否支持指纹识别。

```
ability.call method="common_ability_has_face_rec" params='{}'
```

获取当前手机是否支持人脸识别。

```
ability.call method="common_ability_get_app_permissions" params='{}'
```

通过packageName获取应用非普通权限使用详情。

```
ability.call method="common_ability_check_app_permission" params='{"permissionName":"<要检查的应用权限名称>"}'
```

通过packageName和指定的permission字段，检查应用是否获取指定的permission。

---

## 四、状态查询类

> 来源 App：`com.android.settings`

```
ability.call method="settings_get_battery_percentage_state" params='{}'
```

获取电池电量百分比是否开启的状态。

```
ability.call method="settings_get_wifi_state" params='{}'
```

获取WIFI的开关状态。

```
ability.call method="settings_get_bluetooth_state" params='{}'
```

获取蓝牙的开关状态。

```
ability.call method="settings_get_hotspot_state" params='{}'
```

获取热点的开关状态。

```
ability.call method="settings_get_airplane_mode_state" params='{}'
```

获取飞行模式的开关状态。

```
ability.call method="settings_get_data_state" params='{}'
```

获取数据网络的开关状态。

```
ability.call method="settings_get_vibration_state" params='{}'
```

获取系统震动的开关状态。

```
ability.call method="settings_get_dark_mode_state" params='{}'
```

获取深色模式的开关状态。

```
ability.call method="settings_get_dialing_keypad_sound_state" params='{}'
```

获取拨号键的提示音的开关状态。

```
ability.call method="settings_get_screen_lock_sound_state" params='{}'
```

获取屏幕锁定提示音的开关状态。

```
ability.call method="settings_get_charging_notif_sound_state" params='{}'
```

获取充电提示音和振动的开关状态。

```
ability.call method="settings_get_touch_sound_state" params='{}'
```

获取点按和点击提示音的开关状态。

```
ability.call method="settings_get_auto_brightness_state" params='{}'
```

获取自动亮度调节的开关状态。

```
ability.call method="settings_get_auto_rotation_state" params='{}'
```

获取屏幕自动旋转的开关状态。

```
ability.call method="settings_get_screen_saver_state" params='{}'
```

获取屏保的开关状态。

```
ability.call method="settings_get_one_handed_mode_state" params='{}'
```

获取"单手模式"的开关状态。

```
ability.call method="settings_get_tapToCheck_phone_state" params='{}'
```

获取"点按手机即显示"的开关状态。

```
ability.call method="settings_get_liftToCheck_phone_state" params='{}'
```

获取"捂起手机即显示"的开关状态。

```
ability.call method="settings_get_battery_saver_state" params='{}'
```

获取"省电模式"的开关状态。

```
ability.call method="settings_get_app_lock_state" params='{}'
```

获取"应用锁"的开关状态。

```
ability.call method="settings_app_lock_config_switch" params='{"openState":"<true打开/false关闭>","password":"<解锁密码>"}'
```

打开/关闭应用锁，需要提供密码。

---

## 五、安全与权限

> 来源 App：`com.android.permissioncontroller`

```
ability.call method="security_permissioncontroller_global_location" params='{"enable":"<true/false>"}'
```

开启/关闭 全局位置信息权限。

```
ability.call method="security_permissioncontroller_global_microphone" params='{"enable":"<true/false>"}'
```

开启/关闭 全局麦克风权限。

```
ability.call method="security_permissioncontroller_global_camera" params='{"enable":"<true/false>"}'
```

开启/关闭 全局摄像头权限。

---

## 六、手机管家

> 来源 App：`com.stepos.safe`

```
ability.call method="security_center_open_main" params='{}'
```

打开手机管家应用。

```
ability.call method="security_center_power_saving_enable" params='{"enable":"<true/false>"}'
```

开启/关闭 省电模式（手机管家）。

```
ability.call method="security_manager_open_harassment_interception" params='{}'
```

打开骚扰拦截页面。

```
ability.call method="security_manager_into_virus_page" params='{}'
```

打开病毒查杀页面。

```
ability.call method="security_center_network_pay_enable" params='{"enable":"<true/false>"}'
```

开启/关闭 移动网络安全支付。

```
ability.call method="security_center_pay_enable" params='{"enable":"<true/false>"}'
```

开启/关闭 隐私支付保护。

```
ability.call method="security_center_usb_install_enable" params='{"enable":"<true/false>"}'
```

开启/关闭 USB安装管控。

```
ability.call method="security_center_enable_function" params='{"enable":"<true/false>"}'
```

开启/关闭 手机管家功能。

---

## 七、私密保险箱

> 来源 App：`com.stepos.safebox`

```
ability.call method="security_safebox_auto_fill" params='{"enable":"<true/false>"}'
```

开启/关闭 私密保险箱中的自动填写。

```
ability.call method="security_safebox_open" params='{}'
```

打开设置-安全-私密保险箱。

---

## 八、安全服务

> 来源 App：`com.stepos.secureservice`

```
ability.call method="security_service_open_oaid_settings" params='{}'
```

打开OAID设置页。

```
ability.call method="security_service_get_uuid" params='{}'
```

获取手机UUID。

---

## 九、系统界面

> 来源 App：`com.android.systemui`

```
ability.call method="open_flash_light" params='{"openState":"<true开/false关>"}'
```

开关手电筒。

```
ability.call method="query_notification_info" params='{"keyword":"<人名或应用名称>"}'
```

筛选/查询系统的通知内容，如"帮我查一下'微信'发来了什么消息"。

---

## 十、截屏与录屏

> 来源 App：`com.stepos.systemuiex`

```
ability.call method="screen_capture_record" params='{}'
```

录制设备屏幕视频（录屏）。

```
ability.call method="screen_capture_screenshot" params='{}'
```

截取当前设备屏幕内容（截屏）。
