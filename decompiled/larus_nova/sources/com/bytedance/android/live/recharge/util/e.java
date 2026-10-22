package com.bytedance.android.live.recharge.util;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f90426b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f90427c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f90428d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f90429e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CASH_EXCHANGE_NEW_STYLE", "getLIVE_CASH_EXCHANGE_NEW_STYLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CASH_EXCHANGE_REBATE_TYPE", "getLIVE_CASH_EXCHANGE_REBATE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_TRIAL_DIAMOND_EXCHANGE", "getLIVE_TRIAL_DIAMOND_EXCHANGE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LITE_WEALTH_SCHEME", "getLIVE_LITE_WEALTH_SCHEME()Ljava/lang/String;", 1))};
        f90425a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cash_exchange_new_style", Boolean.FALSE, Boolean.TYPE, false);
        f90426b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r102 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redeem_rebate_type", 0, r102, false);
        f90427c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        KmpEnv r104 = KmpEnv.f255139a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_trial_diamond_exchange", Integer.valueOf(KmpEnv.b() ? 1 : 0), r102, false);
        f90428d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lite_wealth_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fasset_panel%2Ftemplate.js%3FenterFrom%3Dgift_entrance&initialProps=%5B%22setting%3Alive_incentive_box_with_anniex%3Alive_incentive_box_can_click%22%5D", String.class, false);
        f90429e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
    }

    public static final int a() {
        return ((Number) f90428d.getValue(null, f90425a[2])).intValue();
    }
}
