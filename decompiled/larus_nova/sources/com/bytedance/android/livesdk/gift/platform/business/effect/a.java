package com.bytedance.android.livesdk.gift.platform.business.effect;

import com.bytedance.android.livesdk.gift.configmodel.GiftVolumeAdjustConfig;
import com.bytedance.android.livesdk.gift.configmodel.b0;
import com.bytedance.android.livesdk.gift.configmodel.g1;
import com.bytedance.android.livesdk.gift.configmodel.p1;
import com.bytedance.android.livesdk.gift.configmodel.q1;
import com.bytedance.android.livesdk.gift.configmodel.q2;
import com.bytedance.android.livesdk.gift.configmodel.s;
import com.bytedance.android.livesdkapi.model.GiftPlayerAutoReleaseSwitch;
import com.bytedance.android.livesdkapi.model.LynxAlphaPlayerAutoReleaseSwitch;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ReadOnlyProperty f129043J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final ReadOnlyProperty N = null;
    public static final ReadOnlyProperty O = null;
    public static final ReadOnlyProperty P = null;
    public static final ReadOnlyProperty Q = null;
    public static final ReadOnlyProperty R = null;
    public static final ReadOnlyProperty S = null;
    public static final ReadOnlyProperty T = null;
    public static final ReadOnlyProperty U = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129045b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129046c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f129047d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f129048e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f129049f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f129050g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f129051h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f129052i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f129053j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f129054k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f129055l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f129056m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f129057n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f129058o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f129059p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f129060q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f129061r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f129062s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f129063t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f129064u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f129065v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f129066w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f129067x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f129068y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f129069z = null;

    public static final boolean a() {
        return ((Boolean) U.getValue(null, f129044a[45])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) S.getValue(null, f129044a[43])).booleanValue();
    }

    public static final Map<String, g1> c() {
        return (Map) N.getValue(null, f129044a[38]);
    }

    public static final s d() {
        return (s) f129060q.getValue(null, f129044a[15]);
    }

    public static final b0 e() {
        return (b0) G.getValue(null, f129044a[31]);
    }

    public static final boolean f() {
        return ((Boolean) f129068y.getValue(null, f129044a[23])).booleanValue();
    }

    public static final int g() {
        return ((Number) f129047d.getValue(null, f129044a[2])).intValue();
    }

    public static final int h() {
        return ((Number) f129045b.getValue(null, f129044a[0])).intValue();
    }

    public static final q2 i() {
        return (q2) f129049f.getValue(null, f129044a[4]);
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_TTPLAYER_USE_HARDCORE", "getLIVE_GIFT_TTPLAYER_USE_HARDCORE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_USE_TEXTURE_RENDER", "getLIVE_GIFT_USE_TEXTURE_RENDER()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_USE_TYPE", "getLIVE_GIFT_PLAYER_USE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_DOWNLOAD_POLICY", "getLIVE_GIFT_DOWNLOAD_POLICY()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_SUPER_RESOLUTION_720_CONFIG", "getLIVE_SUPER_RESOLUTION_720_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/SuperResolution720Config;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SR_CONFIG_ALG_TYPE", "getLIVE_GIFT_SR_CONFIG_ALG_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SOUND_VOLUME_DYNAMIC_ADJUST", "getLIVE_GIFT_SOUND_VOLUME_DYNAMIC_ADJUST()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SOUND_VOLUME_ADJUST_CONFIGS", "getLIVE_GIFT_SOUND_VOLUME_ADJUST_CONFIGS()Lcom/bytedance/android/livesdk/gift/configmodel/GiftVolumeAdjustConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_V8_ENABLE", "getLIVE_GIFT_LYNX_V8_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_V8_FORCE_ENABLE", "getLIVE_GIFT_LYNX_V8_FORCE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TRAY_EFFECT_MESSAGE_QUEUE", "getLIVE_TRAY_EFFECT_MESSAGE_QUEUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LOCAL_HOST_GIFT_NEED_FILTER_TEST_ASSET", "getLIVE_LOCAL_HOST_GIFT_NEED_FILTER_TEST_ASSET()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_VS_VERTICAL_OPEN_EFFECT", "getLIVE_VS_VERTICAL_OPEN_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_QUEUE_SWITCH_CONSUME_OPTIMIZE", "getLIVE_GIFT_QUEUE_SWITCH_CONSUME_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_SHOW_TOUCH_LISTENER", "getLIVE_GIFT_EFFECT_SHOW_TOUCH_LISTENER()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ASSET_PRE_DOWNLOAD", "getLIVE_GIFT_ASSET_PRE_DOWNLOAD()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAssetPreDownloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_DIALOG_ENABLE", "getLIVE_GIFT_DIALOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_RESOURCE_DELETE_THRESHOLD", "getLIVE_GIFT_RESOURCE_DELETE_THRESHOLD()J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "USE_TEXTURERENDER_CATCH", "getUSE_TEXTURERENDER_CATCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_OFFLINE_ENTER_ROOM_TIME_OPTIMIZE", "getLIVE_OFFLINE_ENTER_ROOM_TIME_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_REMOVE_CONTEXT_JUDGEMENT", "getLIVE_REMOVE_CONTEXT_JUDGEMENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_AUTO_RELEASE_SWITCH", "getLIVE_GIFT_PLAYER_AUTO_RELEASE_SWITCH()Lcom/bytedance/android/livesdkapi/model/GiftPlayerAutoReleaseSwitch;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_COVER_OPT_ENABLE", "getLIVE_TOOLBAR_COVER_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_FLY_DIALOG_DELAY_START", "getLIVE_GIFT_FLY_DIALOG_DELAY_START()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_FLY_DIALOG_XIAOMI_SETTING", "getLIVE_FLY_DIALOG_XIAOMI_SETTING()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_ALPHA_PLAYER_AUTO_RELEASE_SWITCH", "getLIVE_LYNX_ALPHA_PLAYER_AUTO_RELEASE_SWITCH()Lcom/bytedance/android/livesdkapi/model/LynxAlphaPlayerAutoReleaseSwitch;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DISABLE_OLD_CONTAINER_GESTURE_GIFT", "getLIVE_DISABLE_OLD_CONTAINER_GESTURE_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "NEW_STICKER_MP4_ASSET_IDS", "getNEW_STICKER_MP4_ASSET_IDS()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_ENABLE_ELEMENT_CLICK", "getLIVE_GIFT_PLAYER_ENABLE_ELEMENT_CLICK()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_GL_OPTIMIZE", "getLIVE_GIFT_GL_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "live_ds_allow_enter_gift_animation", "getLive_ds_allow_enter_gift_animation()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PERFORMANCE_OPT_CONFIG", "getLIVE_GIFT_EFFECT_PERFORMANCE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftEffectPerfOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PLAY_METRICS_ENABLE", "getLIVE_GIFT_EFFECT_PLAY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_MEMORY_METRICS_ENABLE", "getLIVE_GIFT_EFFECT_MEMORY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_EFFECT_PLAY_METRICS_ENABLE", "getLIVE_GIFT_LYNX_EFFECT_PLAY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_UI_CANVAS_MONITOR_CONFIG", "getLIVE_LYNX_UI_CANVAS_MONITOR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LynxCanvasMonitorConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_GIFT_LOAD_OPT_CONFIG", "getLIVE_LYNX_GIFT_LOAD_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LynxGiftLoadOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PLAYER_DASP_ENABLE", "getLIVE_GIFT_EFFECT_PLAYER_DASP_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ASSETS_LRU_CLEAN_CONFIG", "getLIVE_GIFT_ASSETS_LRU_CLEAN_CONFIG()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFTS_NOT_USE_REQUIRED_ASSETS", "getLIVE_GIFTS_NOT_USE_REQUIRED_ASSETS()[J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_MP4__MASK_FIX_SPECIAL_TEXT_SYMBOL_HEIGHT", "getLIVE_GIFT_MP4__MASK_FIX_SPECIAL_TEXT_SYMBOL_HEIGHT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ISSUE_REPORT_GIFT_INFO", "getLIVE_GIFT_ISSUE_REPORT_GIFT_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_LYNX_INFO_WIDGET_OPTIMIZE", "getLIVE_GIFT_EFFECT_LYNX_INFO_WIDGET_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT", "getLIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT_NEW", "getLIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "ENABLE_GIFT_ASSET_MESSAGE_FOR_LYNX", "getENABLE_GIFT_ASSET_MESSAGE_FOR_LYNX()Z", 1))};
        f129044a = r100;
        Class r110 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_ttplayer_use_hardcore", 0, r110, false);
        f129045b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r111 = Boolean.FALSE;
        Class r112 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_use_texture_render", r111, r112, false);
        f129046c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_player_user_type", 4, r110, false);
        f129047d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_download_optimize", 0, r110, false);
        f129048e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_720p_super_resolution_config", new q2(0), q2.class, false);
        f129049f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sr_config_alg_type", 4, r110, false);
        f129050g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        Boolean r107 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sound_volume_dynamic_adjust", r107, r112, false);
        f129051h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sound_volume_adjust_configs", new GiftVolumeAdjustConfig(0, 0, 0, 0, 0.0f, 0.0f, 63, null), GiftVolumeAdjustConfig.class, false);
        f129052i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_v8_enable", r111, r112, false);
        f129053j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_v8_force_enable", r111, r112, false);
        f129054k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_tray_effect_message_queue", r107, r112, false);
        f129055l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_local_host_gift_need_filter_test_asset", r107, r112, false);
        f129056m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vs_vertical_open_effect", r107, r112, false);
        f129057n = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_queue_switch_consume_optimize", r107, r112, false);
        f129058o = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_show_touch_listener", r111, r112, false);
        f129059p = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_assets_pre_download", new s(), s.class, false);
        f129060q = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_dialog_enable", r107, r112, false);
        f129061r = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_delete_size_threshold", -1L, Long.TYPE, false);
        f129062s = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("use_texturerender_catch", r107, r112, false);
        f129063t = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_offline_enter_room_time_optimize", r111, r112, false);
        f129064u = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_remove_context_judgement", r111, r112, false);
        f129065v = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_player_auto_release_switch", new GiftPlayerAutoReleaseSwitch(), GiftPlayerAutoReleaseSwitch.class, false);
        f129066w = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_cover_optimize", r111, r112, false);
        f129067x = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fly_dialog_delay_start", r107, r112, false);
        f129068y = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fly_dialog_xiaomi_setting", r107, r112, false);
        f129069z = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("lynx_alpha_player_auto_release_switch", new LynxAlphaPlayerAutoReleaseSwitch(), LynxAlphaPlayerAutoReleaseSwitch.class, false);
        A = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_old_container_gesture_gift", r107, r112, false);
        B = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("new_sticker_mp4_asset_ids", new HashMap(), nn3.a.f519641j, false);
        C = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_player_enable_element_click", r107, r112, false);
        D = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_gl_optimize", r111, r112, false);
        E = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ds_allow_enter_gift_animation", r107, r112, false);
        F = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_performance_opt_config", new b0(), b0.class, false);
        G = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_play_metrics_enable", r111, r112, false);
        H = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_memory_metrics_enable", r107, r112, false);
        I = UltraSettingsManager.a().a(r138.f271017a, r138.f271018b, r138.getType(), r138.f271020d, r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_effect_play_metrics_enable", r111, r112, false);
        f129043J = UltraSettingsManager.a().a(r139.f271017a, r139.f271018b, r139.getType(), r139.f271020d, r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_ui_canvas_monitor_config", new p1(), p1.class, false);
        K = UltraSettingsManager.a().a(r140.f271017a, r140.f271018b, r140.getType(), r140.f271020d, r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r141 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_gift_load_opt_config", new q1(), q1.class, false);
        L = UltraSettingsManager.a().a(r141.f271017a, r141.f271018b, r141.getType(), r141.f271020d, r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r142 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_player_dasp_enable", r107, r112, false);
        M = UltraSettingsManager.a().a(r142.f271017a, r142.f271018b, r142.getType(), r142.f271020d, r100[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r143 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_assets_lru_clean_config", new HashMap(), nn3.a.f519640i, false);
        N = UltraSettingsManager.a().a(r143.f271017a, r143.f271018b, r143.getType(), r143.f271020d, r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r144 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gifts_not_use_required_assets", new long[0], long[].class, false);
        O = UltraSettingsManager.a().a(r144.f271017a, r144.f271018b, r144.getType(), r144.f271020d, r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r145 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_mp4_mask_fix_special_text_symbol_height", r107, r112, false);
        P = UltraSettingsManager.a().a(r145.f271017a, r145.f271018b, r145.getType(), r145.f271020d, r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_issue_report_gift_info", r107, r112, false);
        Q = UltraSettingsManager.a().a(r146.f271017a, r146.f271018b, r146.getType(), r146.f271020d, r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_lynx_info_widget_optimize", r107, r112, false);
        R = UltraSettingsManager.a().a(r147.f271017a, r147.f271018b, r147.getType(), r147.f271020d, r100[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r148 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_download_gift_asset_jsb_opt", r107, r112, false);
        S = UltraSettingsManager.a().a(r148.f271017a, r148.f271018b, r148.getType(), r148.f271020d, r100[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r149 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_download_gift_asset_jsb_opt_new", r111, r112, false);
        T = UltraSettingsManager.a().a(r149.f271017a, r149.f271018b, r149.getType(), r149.f271020d, r100[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_gift_asset_message_for_lynx", r111, r112, false);
        U = UltraSettingsManager.a().a(r150.f271017a, r150.f271018b, r150.getType(), r150.f271020d, r100[45]);
    }
}
