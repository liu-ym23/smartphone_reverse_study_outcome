package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129742c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(v.class, "liveRechargeCheckOpt", "getLiveRechargeCheckOpt()Z", 1)), Reflection.property0(new PropertyReference0Impl(v.class, "LIVE_RECHARGE_NO_BALANCE_OPT", "getLIVE_RECHARGE_NO_BALANCE_OPT()I", 1))};
        f129740a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_check_opt", Boolean.FALSE, Boolean.TYPE, false);
        f129741b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_no_balanace_opt", 0, Integer.TYPE, false);
        f129742c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }
}
