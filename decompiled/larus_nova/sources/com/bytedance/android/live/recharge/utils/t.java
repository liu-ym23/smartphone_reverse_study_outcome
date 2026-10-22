package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig;
import com.bytedance.android.live.recharge.config.DynamicRechargePanelConfig;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f90505b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f90506c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f90507d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f90508e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f90509f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f90510g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f90511h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f90512i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f90513j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f90514k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f90515l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f90516m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f90517n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f90518o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f90519p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f90520q = null;

    public static final CustomRechargeOneStepConfig a() {
        return (CustomRechargeOneStepConfig) f90516m.getValue(null, f90504a[11]);
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_DYNAMIC_CONFIG", "getLIVE_RECHARGE_DYNAMIC_CONFIG()Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_NOTICE_TIME", "getLIVE_RECHARGE_PK_MSG_NOTICE_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_NOTICE_SWITCH", "getLIVE_RECHARGE_PK_MSG_NOTICE_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_MSG_LEFT_TIME", "getLIVE_RECHARGE_PK_MSG_LEFT_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_DIAMOND_LIMIT", "getLIVE_RECHARGE_PK_DIAMOND_LIMIT()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_NO_PASSWORD_SWITCH", "getLIVE_RECHARGE_PK_NO_PASSWORD_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_DIAMOND_UPPER_LIMIT", "getLIVE_RECHARGE_PK_DIAMOND_UPPER_LIMIT()J", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_AUTO_SEND_GIFT_NEW", "getLIVE_RECHARGE_PK_AUTO_SEND_GIFT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_FANSCLUB_NO_PASSWORD_CONFIG", "getLIVE_RECHARGE_FANSCLUB_NO_PASSWORD_CONFIG()Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_SUPPORT_ONE_STEP_PAY", "getLIVE_RECHARGE_SUPPORT_ONE_STEP_PAY()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_API_CHECKER_ENABLE", "getLIVE_RECHARGE_API_CHECKER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_CUSTOM_RECHARGE_ONE_STEP_CONFIG", "getLIVE_CUSTOM_RECHARGE_ONE_STEP_CONFIG()Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_RECHARGE_PK_NO_PASSWD_MOCK", "getLIVE_RECHARGE_PK_NO_PASSWD_MOCK()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_DYLITE_COUPON_WITHOUT_COMBINED_PAY", "getLIVE_DYLITE_COUPON_WITHOUT_COMBINED_PAY()Z", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_GEM_EXCHANGE_COUPON_CONFIG", "getLIVE_GEM_EXCHANGE_COUPON_CONFIG()Lcom/bytedance/android/live/recharge/config/GemExchangeCouponConfig;", 1)), Reflection.property0(new PropertyReference0Impl(t.class, "LIVE_DYNAMIC_RECHARGE_PANEL_CONFIG", "getLIVE_DYNAMIC_RECHARGE_PANEL_CONFIG()Lcom/bytedance/android/live/recharge/config/DynamicRechargePanelConfig;", 1))};
        f90504a = r100;
        RechargePanelDynamicConfig.f89996f.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_dynamic_config", (RechargePanelDynamicConfig) RechargePanelDynamicConfig.Companion.f89997a.getValue(), RechargePanelDynamicConfig.class, false);
        f90505b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r110 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_notice_time", 120L, r110, false);
        f90506c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_notice_switch", r103, r111, false);
        f90507d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_msg_left_time", 20L, r110, false);
        f90508e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_diamond_limit", 1L, r110, false);
        f90509f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_no_password_switch", r103, r111, false);
        f90510g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_diamond_upper_limit", 5000L, r110, false);
        f90511h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_auto_send_gift_new", r103, r111, false);
        f90512i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        NoPasswordFansConfig.f89992e.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fansclub_no_password_config", (NoPasswordFansConfig) NoPasswordFansConfig.Companion.f89993a.getValue(), NoPasswordFansConfig.class, false);
        f90513j = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[8]);
        Boolean r113 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_support_one_step_pay", r113, r111, false);
        f90514k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_api_checker_enable", r103, r111, false);
        f90515l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        CustomRechargeOneStepConfig.f89671b.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_custom_recharge_one_step_config", (CustomRechargeOneStepConfig) CustomRechargeOneStepConfig.Companion.f89672a.getValue(), CustomRechargeOneStepConfig.class, false);
        f90516m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_pk_no_passwd_mock", r113, r111, false);
        f90517n = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dylite_coupon_without_combined_pay_new", r113, r111, false);
        f90518o = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[13]);
        GemExchangeCouponConfig.f89677d.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gem_exchange_coupon_config", (GemExchangeCouponConfig) GemExchangeCouponConfig.Companion.f89678a.getValue(), GemExchangeCouponConfig.class, false);
        f90519p = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[14]);
        DynamicRechargePanelConfig.f89674c.getClass();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dynamic_recharge_panel_config", (DynamicRechargePanelConfig) DynamicRechargePanelConfig.Companion.f89675a.getValue(), DynamicRechargePanelConfig.class, false);
        f90520q = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[15]);
    }
}
