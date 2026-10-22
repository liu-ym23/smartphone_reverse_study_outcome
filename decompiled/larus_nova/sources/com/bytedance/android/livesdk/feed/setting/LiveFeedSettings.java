package com.bytedance.android.livesdk.feed.setting;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public interface LiveFeedSettings {
    public static final SettingKey<Integer> AUDIENCE_PING_INTERVAL = null;
    public static final SettingKey<Float> DEFAULT_DURATION_SHOW_PREVIEW_TIP = null;
    public static final SettingKey<Integer> DOUYIN_LIVE_FEED_TOP_HINT = null;
    public static final SettingKey<Boolean> DRAWER_MULTI_TAB_USE_RECOMMEND_INNER_URL = null;
    public static final SettingKey<Integer> DRAWER_REFRESH_TIME_OUT = null;
    public static final SettingKey<Integer> FEED_LIVE_BANNER_POSITION = null;
    public static final SettingKey<Integer> FEED_PRELOAD = null;
    public static final SettingKey<Integer> LIVE_DRAWER_OPEN_LIVE = null;
    public static final SettingKey<Integer> LIVE_DRAWER_START_LIVE_BTN = null;
    public static final SettingKey<Integer> LIVE_DRAWER_START_LIVE_BTN_ANIM = null;
    public static final SettingKey<Integer> LIVE_FEED_SHOW_NEARBY_GSP_DIALOG = null;
    public static final SettingKey<Integer> MAIN_REFRESH_TIME_OUT = null;
    public static final SettingKey<Boolean> REFRESH_SHOW_SANDBOX_ROOM = null;
    public static final SettingKey<Integer> START_LIVE_ICON_POSITION = null;
    public static final int SWIPE_ROOM_DISABLE_FOLLOW_MASK = 2;
    public static final int SWIPE_ROOM_DISABLE_LIVE_MASK = 1;
    public static final SettingKey<Boolean> VIDEO_PRELOAD_AFTER_COVER = null;

    static {
        DEFAULT_DURATION_SHOW_PREVIEW_TIP = new SettingKey("default_duration_show_preview_tip", Float.valueOf(7.0f), "移动网络播流提示间隔时长(单位：天)");
        FEED_LIVE_BANNER_POSITION = new SettingKey("feed_live_banner_position", 0, "直播 Feed Banner 的位置", new String[]{"0:顶部", "1:中间"});
        MAIN_REFRESH_TIME_OUT = new SettingKey("back_refresh_timeout", 1800000);
        DRAWER_REFRESH_TIME_OUT = new SettingKey("live_feed_appear_refresh_interval", 1800, "直播抽屉多TAB自动刷新间隔");
        Boolean r100 = Boolean.FALSE;
        DRAWER_MULTI_TAB_USE_RECOMMEND_INNER_URL = new SettingKey("live_multi_tab_use_recommend_inner_url", r100, "直播抽屉多TAB使用推荐内流");
        FEED_PRELOAD = new SettingKey("feed_preload", 4);
        VIDEO_PRELOAD_AFTER_COVER = new SettingKey("video_preload_after_cover", r100, "封面显示后再预加载视频");
        AUDIENCE_PING_INTERVAL = new SettingKey("audience_ping_interval", 600, "观众ping间隔");
        REFRESH_SHOW_SANDBOX_ROOM = new SettingKey("refresh_show_sand_box_room", r100, "下拉刷新展示测试房间");
        DOUYIN_LIVE_FEED_TOP_HINT = new SettingKey("live_squre_sky_window_info", 0, "抖音直播广场天窗关注文案AB");
        START_LIVE_ICON_POSITION = new SettingKey("live_feed_tab_entrance_enabled", 0, "直播开播按钮展示位置", new String[]{"0:不展示", "1:展示在左下角", "2:展示在中间下方", "3:展示在右下角"});
        LIVE_FEED_SHOW_NEARBY_GSP_DIALOG = new SettingKey("live_show_gps_guide_for_feed_nearby", 1, "是否在进入直播附近tab的时候弹请求权限的弹窗", new String[]{"0:不展示", "1:展示"});
        LIVE_DRAWER_START_LIVE_BTN_ANIM = new SettingKey("live_drawer_start_live_btn_anim", 0, "直播广场开播按钮滑动");
        LIVE_DRAWER_START_LIVE_BTN = new SettingKey("live_drawer_start_live_btn", 0, "直播广场开播按钮", new String[]{"0:不展示", "1:大按钮", "2:小按钮"});
        LIVE_DRAWER_OPEN_LIVE = new SettingKey("live_drawer_open_live", 0, "直播抽屉开播按钮", new String[]{"0:不展示开播按钮  1:展示开播按钮"});
    }
}
