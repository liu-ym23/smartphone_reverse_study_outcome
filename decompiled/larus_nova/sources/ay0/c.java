package ay0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f16667b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f16668c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f16669d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f16670e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f16671f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V1", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V1()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V2", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V2()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V3", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V3()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_SEND_GIFT_REDEEM_OPT", "getLIVE_SEND_GIFT_REDEEM_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_SEND_GIFT_JSB_API_REVERT_OPT", "getLIVE_SEND_GIFT_JSB_API_REVERT_OPT()Z", 1))};
        f16666a = r100;
        Class r101 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v1", 0, r101, false);
        f16667b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v2", 0, r101, false);
        f16668c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v3", 0, r101, false);
        f16669d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        Boolean r105 = Boolean.FALSE;
        Class r106 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_redeem_opt", r105, r106, false);
        f16670e = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_jsb_api_revert_opt", r105, r106, false);
        f16671f = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[4]);
    }

    public static final int a() {
        return ((Number) f16667b.getValue(null, f16666a[0])).intValue();
    }

    public static final int b() {
        return ((Number) f16668c.getValue(null, f16666a[1])).intValue();
    }

    public static final int c() {
        return ((Number) f16669d.getValue(null, f16666a[2])).intValue();
    }

    public static final boolean d() {
        return ((Boolean) f16671f.getValue(null, f16666a[4])).booleanValue();
    }
}
