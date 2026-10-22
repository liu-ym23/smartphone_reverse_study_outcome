package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129545c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f129546d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f129547e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f129548f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_GAME_EFFECT_SERVICE_URL", "getLIVE_REVENUE_GAME_EFFECT_SERVICE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_SERVICE_DELAY_TIME", "getLIVE_REVENUE_EFFECT_SERVICE_DELAY_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_FALLBACK", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_FALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE_LAYOUT_CHANGE_EVENT", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE_LAYOUT_CHANGE_EVENT()Z", 1))};
        f129543a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_preview_effect_service_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Ftemplate_douyin%2Fpages%2Feffect_service_load_page%2Ftemplate.js&preview=1", String.class, false);
        f129544b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_revenue_service_delay_time", 200L, Long.TYPE, false);
        f129545c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.TRUE;
        Class r104 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_enable", r103, r104, false);
        f129546d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_fallback", Boolean.FALSE, r104, false);
        f129547e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_enable_layout_change_event", r103, r104, false);
        f129548f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
    }
}
