package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface LiveConfigSimplifySettingKeys {
    public static final String CAMERA_MECRPPHONE_EXPLAIN = "用于拍摄、直播、视频或语音通话等录音或通讯场景";
    public static final String CAMERA_PERMISSION_EXPLAIN = "用于拍照、录制视频、视频通话、直播、扫一扫及实名认证场景下的校验";
    public static final String CAMERA_STORADGE_EXPLAIN = "用于app写入/下载/保存/读取/修改、删除图片、视频、文件、崩溃日志等信息";
    public static final SettingKey<Boolean> LIVE_ALLOW_RESGITER_GECKO_RESOURCE = null;
    public static final SettingKey<String> LIVE_CERT_CAMERA_EXPLAIN = null;
    public static final SettingKey<Boolean> LIVE_CERT_ENABLE_SHOW_MASK = null;
    public static final SettingKey<String> LIVE_CERT_MICROPHONE_EXPLAIN = null;
    public static final SettingKey<String> LIVE_CERT_STORAGW_EXPLAIN = null;
    public static final SettingKey<Boolean> LIVE_ONLINE_EMOJI_ENABLE = null;
    public static final SettingKey<Integer> LIVE_PERFORMANCE_SAMPLE_RATE = null;
    public static final SettingKey<com.bytedance.android.livesdk.performance.r0> LIVE_PERFORMANCE_SETTING = null;
    public static final SettingKey<g91> LIVE_WEBVIEW_MONITOR_CONFIG = null;
    public static final SettingKey<PlayerInnerDrawerConfig> PLAYER_INNER_DRAW_CONFIG = null;
    public static final SettingKey<Boolean> ROOM_INJECT_FRAMEWORK_DEBUG = null;
    public static final SettingKey<Map<String, String>> SCHEMA_ENTRY = null;

    public class a extends TypeToken<Map<String, String>> {
        public a() {
        }
    }

    static {
        LIVE_WEBVIEW_MONITOR_CONFIG = new SettingKey("saas_webcast_monitor_config", "webview/lynx monitor 配置", new g91(), new g91());
        PLAYER_INNER_DRAW_CONFIG = new SettingKey("live_inner_draw_player_config", "内流播放器配置", new PlayerInnerDrawerConfig(), new PlayerInnerDrawerConfig());
        Boolean r100 = Boolean.TRUE;
        ROOM_INJECT_FRAMEWORK_DEBUG = new SettingKey("enable_room_inject_framework_debug", "local test controller环境检查", r100, r100);
        LIVE_CERT_ENABLE_SHOW_MASK = new SettingKey("live_cert_enable_show_mask", "是否展示mask", r100, r100);
        LIVE_CERT_CAMERA_EXPLAIN = new SettingKey("live_cert_camera_explain", "相机权限说明", CAMERA_PERMISSION_EXPLAIN, CAMERA_PERMISSION_EXPLAIN);
        LIVE_CERT_MICROPHONE_EXPLAIN = new SettingKey("live_cert_microphone_explain", "麦克风权限说明", CAMERA_MECRPPHONE_EXPLAIN, CAMERA_MECRPPHONE_EXPLAIN);
        LIVE_CERT_STORAGW_EXPLAIN = new SettingKey("live_cert_storagw_explain", "存储权限说明", CAMERA_STORADGE_EXPLAIN, CAMERA_STORADGE_EXPLAIN);
        SCHEMA_ENTRY = new SettingKey("schema_entry", new a().getType(), new HashMap());
        LIVE_ONLINE_EMOJI_ENABLE = new SettingKey("live_online_emoji_enable", "", r100, r100);
        LIVE_PERFORMANCE_SAMPLE_RATE = new SettingKey("live_performance_sample_rate", 300, "设置采样频率");
        LIVE_ALLOW_RESGITER_GECKO_RESOURCE = new SettingKey("live_allow_resgiter_gecko_resource", "是否注册直播gecko，通过冷启队列下载资源", r100, r100);
        LIVE_PERFORMANCE_SETTING = new SettingKey(LiveInitSettingKeys.LIVE_PERFORMANCE_SETTING, "直播性能监控的设置", new com.bytedance.android.livesdk.performance.r0(), new com.bytedance.android.livesdk.performance.r0());
    }
}
