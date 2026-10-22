package com.bytedance.android.livesdk.config;

import com.bytedance.android.gamecp.common.utils.LiveSdkInitHelper;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.PlayerMonitorConfig;
import com.bytedance.android.livesdkapi.model.PlayerShareConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface LiveSimplifySettingKeys {
    public static final SettingKey<List<String>> CJ_SCHEMA_RISK_INFO_HOSTS = null;
    public static final SettingKey<Boolean> DNS_OPT_FREE_FLOW_ENABLE = null;
    public static final SettingKey<Integer> DNS_OPT_METHOD = null;
    public static final SettingKey<b3> LIVE_DRAWER_ENTRANCE_REDESIGN = null;
    public static final SettingKey<Integer> LIVE_GIFT_PANEL_STYLE = null;
    public static final SettingKey<am2.v> LIVE_LOGSDK_CONFIG = null;
    public static final SettingKey<PlayerMonitorConfig> LIVE_PLAYER_MONITOR_LOG = null;
    public static final SettingKey<PlayerShareConfig> LIVE_PLAYER_SHARE_CONFIG = null;
    public static final SettingKey<String> LIVE_REDIRECT_CONFIG_URL = null;
    public static final SettingKey<c81> LIVE_SDK_INIT_DURATION_OPT = null;
    public static final SettingKey<String> WEBVIEW_MONITOR_SLARDAR_SWITCH_SET = null;

    static {
        WEBVIEW_MONITOR_SLARDAR_SWITCH_SET = new SettingKey("tt_live_saas_webview_monitor_config_slardar_android", "WebView监控Slardar开关", "", "");
        LIVE_DRAWER_ENTRANCE_REDESIGN = new SettingKey("live_drawer_entrance_redesign_config", b3.class, "直播入口引导改版", null, null);
        CJ_SCHEMA_RISK_INFO_HOSTS = new SettingKey(LiveInitSettingKeys.CJ_SCHEMA_RISK_INFO_HOSTS, "财经拼接risk_info支持的host", new ArrayList(), new ArrayList());
        LIVE_GIFT_PANEL_STYLE = new SettingKey(LiveInitSettingKeys.LIVE_GIFT_PANEL_STYLE, "礼物面板样式", 2, 2, new String[]{"0:- 线上对照", "1:- 仅tab上移", "2:- 仅tab上移+上下划", "3:- tab上移+上下划 + 下划时隐藏tab栏", "4:- 仅上下划", "5:- 上下划+ 下划时隐藏原下方tab栏"});
        LIVE_PLAYER_MONITOR_LOG = new SettingKey("live_player_monitor_log", "播放器端监控日志", new PlayerMonitorConfig(), new PlayerMonitorConfig());
        LIVE_REDIRECT_CONFIG_URL = new SettingKey("webcast_redirect_config_url", "redirect重定向规则接口", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/cdn/api/saas_scheme_config/api.roma.config.json", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/cdn/api/saas_scheme_config/api.roma.config.json");
        DNS_OPT_METHOD = new SettingKey("dns_opt_method", 0, "是否使用节点优选", new String[]{"0:老版本", "1:新版本"});
        DNS_OPT_FREE_FLOW_ENABLE = new SettingKey("dns_opt_free_flow_enable", Boolean.FALSE, "免流用户是否开启节点优选");
        LIVE_PLAYER_SHARE_CONFIG = new SettingKey("live_player_share_config", "播放器共享配置", new PlayerShareConfig(), new PlayerShareConfig());
        LIVE_LOGSDK_CONFIG = new SettingKey("live_logsdk_config", am2.v.class, "日志sdk开关配置", new am2.v(), am2.v.e());
        LIVE_SDK_INIT_DURATION_OPT = new SettingKey(LiveSdkInitHelper.LIVE_SDK_INIT_DURATION_OPT, "直播初始化耗时优化", new c81(), new c81(), true);
    }
}
