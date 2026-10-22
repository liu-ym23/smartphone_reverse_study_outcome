package com.bytedance.android.gamecp.common.setting;

import com.bytedance.android.gamecp.common.setting.config.NetworkApmSetting;
import com.bytedance.android.gamecp.common.setting.config.l0;
import com.bytedance.android.gamecp.common.setting.config.n;
import com.bytedance.android.gamecp.common.setting.config.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes44.dex */
public interface LiveConfigSettingKeys {
    public static final SettingKey<String> DOUYIN_COMMON_CERTIFICATION_URL = null;
    public static final SettingKey<ArrayList<String>> LIVESDK_OPEN_PLATFORM_SHADER_REVERSE = null;
    public static final SettingKey<n> LIVE_GMCP_CG_ANNOUNCEMENT_LYNX_CONFIG = null;
    public static final SettingKey<v0> LIVE_GMCP_FEED_DIRECT_PLAY_CLOUD_GAME_CONFIG = null;
    public static final SettingKey<l0> LIVE_GMCP_XPLAY_GAME_ENABLE_TRACE = null;
    public static final SettingKey<Boolean> LIVE_GMCP_XPLAY_LISTENER_REFACTOR = null;
    public static final SettingKey<NetworkApmSetting> LIVE_NETWORK_APM_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_NETWORK_REQUEST_TEST_FORCE_JSON = null;
    public static final SettingKey<Boolean> LIVE_POPUP_STRATEGY_SETTING_ENABLE = null;

    static {
        Boolean r100 = Boolean.TRUE;
        LIVE_POPUP_STRATEGY_SETTING_ENABLE = new SettingKey("live_popup_strategy_setting_enable", "直播气泡管理策略添加功能开关", r100, r100, new String[]{"true:开启", "false:关闭"});
        LIVESDK_OPEN_PLATFORM_SHADER_REVERSE = new SettingKey("livesdk_open_platform_shader_reverse", "shader适配", new ArrayList(), new ArrayList());
        Boolean r101 = Boolean.FALSE;
        LIVE_NETWORK_REQUEST_TEST_FORCE_JSON = new SettingKey("live_network_request_test_force_json", "强制 gift/list 使用 json", r101, r101);
        LIVE_NETWORK_APM_CONFIG = new SettingKey("live_network_apm_config", NetworkApmSetting.class, "网络APM开关配置", new NetworkApmSetting(), new NetworkApmSetting());
        DOUYIN_COMMON_CERTIFICATION_URL = new SettingKey("douyin_common_certification_url", "抖音通用实名认证url", "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?enter_from=recharge&hide_nav_bar=1&__live_platform__=webcast", "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?enter_from=recharge&hide_nav_bar=1&__live_platform__=webcast");
        LIVE_GMCP_XPLAY_GAME_ENABLE_TRACE = new SettingKey("gcp_xplay_trace_config", "即玩场景trace配置", new l0(), new l0());
        LIVE_GMCP_FEED_DIRECT_PLAY_CLOUD_GAME_CONFIG = new SettingKey("live_feed_direct_play_cloud_game_config", "直玩容器屏幕配置", new v0(), new v0());
        LIVE_GMCP_CG_ANNOUNCEMENT_LYNX_CONFIG = new SettingKey("gmcp_cg_announcement_lynx_config", "云游戏公告配置", new n(), new n());
        LIVE_GMCP_XPLAY_LISTENER_REFACTOR = new SettingKey("gmcp_xplay_listener_refactor", "xplay listener重构开关", r101, r101);
    }
}
