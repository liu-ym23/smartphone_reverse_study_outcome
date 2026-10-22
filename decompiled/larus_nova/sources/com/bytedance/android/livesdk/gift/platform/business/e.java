package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.k1;
import com.bytedance.android.livesdk.gift.configmodel.o1;
import com.bytedance.android.livesdk.gift.configmodel.v2;
import com.bytedance.android.livesdk.gift.configmodel.w;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129016b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129017c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f129018d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f129019e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f129020f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f129021g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f129022h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f129023i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f129024j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f129025k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f129026l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f129027m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f129028n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f129029o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f129030p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f129031q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f129032r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f129033s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f129034t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f129035u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f129036v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f129037w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f129038x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f129039y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f129040z = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_QUEUE_LENGTH", "getLIVE_GIFT_TRAY_QUEUE_LENGTH()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_DURATION_OPT", "getLIVE_GIFT_TRAY_DURATION_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_JANK_OPT_CONFIG", "getLIVE_GIFT_TRAY_JANK_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/config_model/GiftTrayJankOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_SMALL_GIFT_VIEW_SINGLE_CHANNRL", "getLIVE_SMALL_GIFT_VIEW_SINGLE_CHANNRL()Lcom/bytedance/android/livesdk/gift/configmodel/LiveTraySingleChannelConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "TRAY_QUEUE_OPTIMIZE_AND_ANIMATION_NEW", "getTRAY_QUEUE_OPTIMIZE_AND_ANIMATION_NEW()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_MSG_CONSUME_TIMEOUT_MS", "getLIVE_GIFT_MSG_CONSUME_TIMEOUT_MS()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_DURATION_OPT_DEBUG", "getLIVE_GIFT_TRAY_DURATION_OPT_DEBUG()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_HIGH_LAYER_MUTIL_LIVE_SCENE", "getLIVE_GIFT_TRAY_HIGH_LAYER_MUTIL_LIVE_SCENE()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_ENABLE_HIGH_LAYER_AUDIENCE", "getLIVE_GIFT_TRAY_ENABLE_HIGH_LAYER_AUDIENCE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_ENABLE_HIGH_LAYER_ANCHOR", "getLIVE_GIFT_TRAY_ENABLE_HIGH_LAYER_ANCHOR()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_EFFECT_HIGH_LAYER_SWITCH", "getLIVE_GIFT_TRAY_EFFECT_HIGH_LAYER_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_OPTIMIZE_DURATION", "getLIVE_GIFT_TRAY_OPTIMIZE_DURATION()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_OPTIMIZE_V2", "getLIVE_GIFT_TRAY_OPTIMIZE_V2()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_BASE_IMAGE_CONFIG", "getLIVE_GIFT_TRAY_BASE_IMAGE_CONFIG()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_ANIMATION_DEGRADE", "getLIVE_GIFT_TRAY_ANIMATION_DEGRADE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_NEW_TRAY_STYLE_ENABLE", "getLIVE_GIFT_NEW_TRAY_STYLE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "GIFT_TRAY_HAS_UNIFORM_BACKGROUND_COLOR", "getGIFT_TRAY_HAS_UNIFORM_BACKGROUND_COLOR()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_DIALOG_LEVEL_FIX", "getLIVE_GIFT_TRAY_DIALOG_LEVEL_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_QUEUE_CONFIG", "getLIVE_GIFT_QUEUE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftQueueConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_PRE_EFFECT_FILTER", "getLIVE_GIFT_TRAY_PRE_EFFECT_FILTER()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_POST_EFFECT_FILTER", "getLIVE_GIFT_TRAY_POST_EFFECT_FILTER()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_SLIDE_RATE_CONFIG", "getLIVE_GIFT_TRAY_SLIDE_RATE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/TraySlideRateConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_COMBO_OPT", "getLIVE_GIFT_COMBO_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "NOTIFICATION_GIFT_VIEW_BASE_USER_COUNT", "getNOTIFICATION_GIFT_VIEW_BASE_USER_COUNT()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "NOTIFICATION_GIFT_VIEW_DURATION", "getNOTIFICATION_GIFT_VIEW_DURATION()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "GIFT_SERIES_ICON_LOOP", "getGIFT_SERIES_ICON_LOOP()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_REVENUE_INTERACT_TRAY_ENABLE", "getLIVE_GIFT_REVENUE_INTERACT_TRAY_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_CROSS_ROOM_TRAY_QUEUE_LENGTH", "getLIVE_GIFT_CROSS_ROOM_TRAY_QUEUE_LENGTH()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_BIG_GIFT_TRAY_COMBO_COUNT_SHOW_LIMIT", "getLIVE_BIG_GIFT_TRAY_COMBO_COUNT_SHOW_LIMIT()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_ADJUST_SCENE", "getLIVE_GIFT_TRAY_ADJUST_SCENE()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_ENABLE_DELETE_MESSAGE_BY_REVERSE_ORDER", "getLIVE_GIFT_TRAY_ENABLE_DELETE_MESSAGE_BY_REVERSE_ORDER()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_VISION_DEGRADE_V2_CONFIG", "getLIVE_VISION_DEGRADE_V2_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_GIFT_TRAY_MESSAGE_UNIQUE_KEY_OPT", "getLIVE_GIFT_TRAY_MESSAGE_UNIQUE_KEY_OPT()Z", 1))};
        f129015a = r100;
        Class r110 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_queue_length", 500, r110, false);
        f129016b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r111 = Boolean.FALSE;
        Class r112 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_duration_opt", r111, r112, false);
        f129017c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_jank_opt_config", new fy1.a(), fy1.a.class, false);
        f129018d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_small_gift_view_single_channel", new o1(), o1.class, false);
        f129019e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("tray_queue_optimize_and_new_animation_new", 0, r110, false);
        f129020f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_msg_consume_timeout_ms", 30, r110, false);
        f129021g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_duration_opt_debug", r111, r112, false);
        f129022h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_high_layer_multi_live_scene", CollectionsKt.arrayListOf(new Integer[]{5, 12}), nn3.a.f519638g, false);
        f129023i = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_enable_high_layer", r111, r112, false);
        f129024j = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[8]);
        Boolean r113 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_enable_high_layer_anchor", r113, r112, false);
        f129025k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_effect_high_layer_switch", r113, r112, false);
        f129026l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_optimize_duration", r111, r112, false);
        f129027m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_optimize_v2", r113, r112, false);
        f129028n = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_base_img_config", null, nn3.a.f519642k, false);
        f129029o = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_animation_degrade", 0, r110, false);
        f129030p = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_tray_new_named_style", r111, r112, false);
        f129031q = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_tray_has_uniform_background_color", r111, r112, false);
        f129032r = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_dialog_level_fix", r113, r112, false);
        f129033s = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_queue_config", new k1(), k1.class, false);
        f129034t = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_pre_effect_filter", CollectionsKt.emptyList(), nn3.a.f519632a, false);
        f129035u = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_post_effect_filter", CollectionsKt.emptyList(), nn3.a.f519635d, false);
        f129036v = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_slide_rate_config", new v2(), v2.class, false);
        f129037w = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_combo_opt", r113, r112, false);
        f129038x = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("notification_gift_view_base_user_count", new LinkedHashMap(), nn3.a.f519644m, false);
        f129039y = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("notification_gift_view_duration", new LinkedHashMap(), nn3.a.f519636e, false);
        f129040z = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_series_icon_loop", r113, r112, false);
        A = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_revenue_interact_tray_enable", r111, r112, false);
        B = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_cross_room_tray_queue_length", 20, r110, false);
        C = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_tray_combo_count_show_limit", 99, r110, false);
        D = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_adjust_scene", CollectionsKt.arrayListOf(new Integer[]{5}), nn3.a.f519639h, false);
        E = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_enable_delete_message_by_reverse_order", r111, r112, false);
        F = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vision_degrade_v2_config", new w(), w.class, false);
        G = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_message_unique_key_opt", r113, r112, false);
        H = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[32]);
    }
}
