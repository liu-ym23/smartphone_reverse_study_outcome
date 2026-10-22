package com.bytedance.android.live.profit.player;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f88360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f88361c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f88362d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f88363e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(r.class, "PlayerLynxSchema", "getPlayerLynxSchema()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "PlayerDestroyDelay", "getPlayerDestroyDelay()J", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "LIVE_LYNX_ALPHA_PLAYER_USE_ANNIEX", "getLIVE_LYNX_ALPHA_PLAYER_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "LIVE_LYNX_CANVAS_TT_PLAYER_ENABLE", "getLIVE_LYNX_CANVAS_TT_PLAYER_ENABLE()Z", 1))};
        f88359a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alphaplayer_schema", "", String.class, false);
        f88360b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alphaplayer_destroy_delay", 0L, Long.TYPE, false);
        f88361c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        Class r104 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alpha_player_use_anniex", r103, r104, false);
        f88362d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_canvas_tt_player_enable", r103, r104, false);
        f88363e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
    }

    public static final long a() {
        return ((Number) f88361c.getValue(null, f88359a[1])).longValue();
    }
}
