package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdk.gift.configmodel.i2;
import com.bytedance.android.livesdk.gift.configmodel.z1;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f130521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f130522b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f130523c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f130524d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f130525e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f130526f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f130527g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f130528h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f130529i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f130530j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f130531k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f130532l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f130533m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f130534n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f130535o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f130536p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f130537q = null;

    public static final int a() {
        return ((Number) f130526f.getValue(null, f130521a[3])).intValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_VBOOST_OPT", "getLIVE_VBOOST_OPT()Lcom/bytedance/android/livesdk/config/VBoostConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ANCHOR_GIFT_ANIMATION_SWITCH", "getLIVE_ANCHOR_GIFT_ANIMATION_SWITCH()Lcom/bytedance/android/livesdk/gift/configmodel/RevAnchorGiftSwitchConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE", "getLIVE_GIFT_MULTIPLE_SEND_OPTIMIZE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ROOM_CHARGE_TYPE", "getLIVE_ROOM_CHARGE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "MATCH_ROOM_TOOLBAR_CONFIG", "getMATCH_ROOM_TOOLBAR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevMatchRoomGiftToolbarConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_INCENTIVES_EXPERIMENT_ENABLE", "getLIVE_INCENTIVES_EXPERIMENT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_PAYMENT_PANEL_DARK_MODE", "getLIVE_PAYMENT_PANEL_DARK_MODE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "GIFT_MESSAGE_NEW_STRUCT", "getGIFT_MESSAGE_NEW_STRUCT()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ENABLE_SUBSCRIBE_OPEN_EFFECT", "getLIVE_ENABLE_SUBSCRIBE_OPEN_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_CLEAR_SCREEN_OPTIMIZE_ENABLE", "getLIVE_CLEAR_SCREEN_OPTIMIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_LANDSCAPE_OPT_CONFIG", "getLIVE_LANDSCAPE_OPT_CONFIG()Lcom/bytedance/android/livesdk/config/LiveLandscapeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GROUP_COMPONENT_CLOSE_SIMPLE_MODE_BY_TYPE", "getLIVE_GROUP_COMPONENT_CLOSE_SIMPLE_MODE_BY_TYPE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_LANDSCAPE_LOG_ENABLE", "getLIVE_LANDSCAPE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GROUP_CONTAINER_SUPPORT_LANDSCAPE", "getLIVE_GROUP_CONTAINER_SUPPORT_LANDSCAPE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GIFT_ENABLE_ON_LEAVE_ROOM_MEMORY_CACHE_RELEASE", "getLIVE_GIFT_ENABLE_ON_LEAVE_ROOM_MEMORY_CACHE_RELEASE()Z", 1))};
        f130521a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vboost_opt", new ti1(), ti1.class, false);
        f130522b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_gift_animation_switch", new z1(), z1.class, false);
        f130523c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Class r110 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_multiple_send_optimize", 7, r110, false);
        f130524d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        f130525e = 1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_room_charge_type", 1, r110, false);
        f130526f = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        i2 r105 = new i2();
        r105.a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("match_room_toolbar_config", r105, i2.class, false);
        f130527g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        Boolean r107 = Boolean.FALSE;
        Class r108 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentives_experiment_enable", r107, r108, false);
        f130528h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_payment_panel_dark_mode", 0, r110, false);
        f130529i = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[6]);
        Boolean r112 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_message_new_struct", r112, r108, false);
        f130530j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_subscribe_open_effect", r107, r108, false);
        f130531k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_clear_screen_optimize", r107, r108, false);
        f130532l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_opt_config", new d51(), d51.class, false);
        f130533m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_component_close_simple_mode_by_type", r112, r108, false);
        f130534n = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_log_enable", r112, r108, false);
        f130535o = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_container_support_landscape", r112, r108, false);
        f130536p = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_leave_room_memory_cache_release", r107, r108, false);
        f130537q = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[14]);
    }
}
