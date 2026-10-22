package com.bytedance.android.livesdk.player.setting;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.NewPlayerTrafficMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerApplogConfig;
import com.bytedance.android.livesdkapi.model.PlayerBlackScreenMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerConfig;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderConfig;
import com.bytedance.android.livesdkapi.model.PlayerFeatureConfig;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.model.PlayerMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.model.PlayerShareConfig;
import com.bytedance.android.livesdkapi.model.PlayerSpmLoggerConfig;
import com.bytedance.android.livesdkapi.model.PlayerTraceMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerTrafficMonitorConfig;

/* JADX INFO: loaded from: classes11.dex */
public interface LivePlayerConfigSettings {
    public static final SettingKey<Boolean> DNS_OPT_FREE_FLOW_ENABLE = null;
    public static final SettingKey<Integer> DNS_OPT_METHOD = null;
    public static final SettingKey<Boolean> ENABLE_LIVE_HTTPK_DEGRADE = null;
    public static final SettingKey<Integer> LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE = null;
    public static final SettingKey<Integer> LIVE_HARDWARD_DECODE_H264_ENABLE = null;
    public static final SettingKey<Boolean> LIVE_NET_ADAPTIVE_ENABLE = null;
    public static final SettingKey<Float> LIVE_NET_ADAPTIVE_HURRY_SPEED = null;
    public static final SettingKey<Integer> LIVE_NET_ADAPTIVE_HURRY_TIME = null;
    public static final SettingKey<Float> LIVE_NET_ADAPTIVE_SLOW_SPEED = null;
    public static final SettingKey<Integer> LIVE_NET_ADAPTIVE_SLOW_TIME = null;
    public static final SettingKey<PlayerApplogConfig> LIVE_PLAYER_APPLOG_CONFIG = null;
    public static final SettingKey<PlayerBlackScreenMonitorConfig> LIVE_PLAYER_BLACK_SCREEN_MONITOR_CONFIG = null;
    public static final SettingKey<PlayerExtraRenderConfig> LIVE_PLAYER_EXTRA_RENDER_CONFIG = null;
    public static final SettingKey<PlayerFeatureConfig> LIVE_PLAYER_FEATURE_CONFIG = null;
    public static final SettingKey<PlayerMonitorConfig> LIVE_PLAYER_MONITOR_LOG = null;
    public static final SettingKey<PlayerOptimizeConfig> LIVE_PLAYER_OPTIMIZE_CONFIG = null;
    public static final SettingKey<PlayerShareConfig> LIVE_PLAYER_SHARE_CONFIG = null;
    public static final SettingKey<PlayerTraceMonitorConfig> LIVE_PLAYER_TRACE_MONITOR_CONFIG = null;
    public static final SettingKey<PlayerTrafficMonitorConfig> LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG = null;
    public static final SettingKey<NewPlayerTrafficMonitorConfig> LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG_NEW = null;
    public static final SettingKey<Integer> LIVE_SDK_FAST_OPEN_DISABLE = null;
    public static final SettingKey<Integer> LIVE_SDK_NTP_ENABLE = null;
    public static final SettingKey<Boolean> LIVE_SDK_TFO_PRECONNECT_ENABLE = null;
    public static final SettingKey<PlayerConfig> PLAYER_CONFIG = null;
    public static final SettingKey<PlayerModularizationConfig> PLAYER_MODULARIZATION_CONFIG = null;
    public static final SettingKey<PlayerSpmLoggerConfig> PLAYER_SPM_LOGGER = null;

    static {
        LIVE_PLAYER_OPTIMIZE_CONFIG = new SettingKey("live_player_optimize_config", "播放器性能优化配置", new PlayerOptimizeConfig(), new PlayerOptimizeConfig());
        LIVE_PLAYER_BLACK_SCREEN_MONITOR_CONFIG = new SettingKey("live_player_black_screen_monitor_config", "播放器黑屏检测", new PlayerBlackScreenMonitorConfig(), new PlayerBlackScreenMonitorConfig());
        LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG = new SettingKey("live_player_traffic_monitor_config", "播放器耗流检测", new PlayerTrafficMonitorConfig(), new PlayerTrafficMonitorConfig());
        LIVE_PLAYER_FEATURE_CONFIG = new SettingKey("live_player_feature_config", "播放器feature配置", new PlayerFeatureConfig(), new PlayerFeatureConfig());
        LIVE_PLAYER_MONITOR_LOG = new SettingKey("live_player_monitor_log", "播放器端监控日志", new PlayerMonitorConfig(), new PlayerMonitorConfig());
        PLAYER_CONFIG = new SettingKey("live_player_config", "播放器配置", new PlayerConfig(), new PlayerConfig());
        PLAYER_MODULARIZATION_CONFIG = new SettingKey("live_player_modularization_config", "播放器组件化配置", new PlayerModularizationConfig(true, true), new PlayerModularizationConfig(true, true));
        LIVE_PLAYER_SHARE_CONFIG = new SettingKey("live_player_share_config", "播放器共享配置", new PlayerShareConfig(), new PlayerShareConfig());
        PLAYER_SPM_LOGGER = new SettingKey("live_spm_player_logger_config", "播放器spm日志配置", new PlayerSpmLoggerConfig(), new PlayerSpmLoggerConfig());
        DNS_OPT_METHOD = new SettingKey("dns_opt_method", 0, "是否使用节点优选", new String[]{"0:老版本", "1:新版本"});
        Boolean r100 = Boolean.FALSE;
        DNS_OPT_FREE_FLOW_ENABLE = new SettingKey("dns_opt_free_flow_enable", r100, "免流用户是否开启节点优选");
        LIVE_NET_ADAPTIVE_ENABLE = new SettingKey("live_net_adaptive_enable", r100, "是否开启网络自适应", new String[]{"true:开启", "false:不开启"});
        Float r101 = Float.valueOf(1.0f);
        LIVE_NET_ADAPTIVE_HURRY_SPEED = new SettingKey("live_net_adaptive_hurry_speed", r101, "网络自适应追帧速度");
        LIVE_NET_ADAPTIVE_HURRY_TIME = new SettingKey("live_net_adaptive_hurry_time", 2000, "开始追帧缓存阈值");
        LIVE_NET_ADAPTIVE_SLOW_SPEED = new SettingKey("live_net_adaptive_slow_speed", r101, "慢放速度");
        LIVE_NET_ADAPTIVE_SLOW_TIME = new SettingKey("live_net_adaptive_slow_time", 0, "慢放阈值");
        LIVE_HARDWARD_DECODE_H264_ENABLE = new SettingKey("live_hardware_decode_h264_enable", 0, "264硬解开关", new String[]{"1:打开", "0:关闭"});
        LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE = new SettingKey("live_hardware_decode_bytevc1_enable", 0, "bytevc1硬解开关", new String[]{"1:打开", "0:关闭"});
        LIVE_SDK_NTP_ENABLE = new SettingKey("live_sdk_ntp_enable", "是否开启拉流NTP", 0, 0);
        LIVE_SDK_FAST_OPEN_DISABLE = new SettingKey("live_sdk_fast_open_disable", "是否关闭拉流首帧优化", 0, 0);
        ENABLE_LIVE_HTTPK_DEGRADE = new SettingKey("live_httpk_degrade_enabled", "是否打开httpk降级开关", r100, r100);
        LIVE_SDK_TFO_PRECONNECT_ENABLE = new SettingKey("live_sdk_tfo_preconnect_enable", "是否打开节点优选tcp fast open预连接", r100, r100);
        LIVE_PLAYER_EXTRA_RENDER_CONFIG = new SettingKey("live_player_extra_render_config", "播放器副画面配置", new PlayerExtraRenderConfig(), new PlayerExtraRenderConfig());
        LIVE_PLAYER_APPLOG_CONFIG = new SettingKey("live_player_applog_config", "播放器applog配置", new PlayerApplogConfig(), new PlayerApplogConfig());
        LIVE_PLAYER_TRACE_MONITOR_CONFIG = new SettingKey("live_player_trace_monitor_config", "播放器Trace监控", new PlayerTraceMonitorConfig(), new PlayerTraceMonitorConfig());
        LIVE_PLAYER_TRAFFIC_MONITOR_CONFIG_NEW = new SettingKey("live_player_traffic_monitor_config_new", "播放器耗流检测,新处理", new NewPlayerTrafficMonitorConfig(), new NewPlayerTrafficMonitorConfig());
    }
}
