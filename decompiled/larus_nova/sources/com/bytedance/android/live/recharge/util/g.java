package com.bytedance.android.live.recharge.util;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90430a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f90431b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f90432c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f90433d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f90434e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f90435f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f90436g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f90437h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f90438i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f90439j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f90440k = null;

    public static final f a() {
        return (f) f90431b.getValue(null, f90430a[0]);
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_WALLET_OPEN_CJ_COUNTER_OPT_CONFIG", "getLIVE_WALLET_OPEN_CJ_COUNTER_OPT_CONFIG()Lcom/bytedance/android/live/recharge/util/RechargeCounterOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_RECOMMEND_DIALOG_URL", "getLIVE_RECHARGE_RECOMMEND_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "H5_DIALOG_EXCHANGE", "getH5_DIALOG_EXCHANGE()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_DISABLE_OLD_CONTAINER_RECHARGE", "getLIVE_DISABLE_OLD_CONTAINER_RECHARGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "RECHARGE_PANEL_ADAPT_FOLD_SCREEN", "getRECHARGE_PANEL_ADAPT_FOLD_SCREEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_DIAMOND_NOTICE_CONFIG", "getLIVE_DIAMOND_NOTICE_CONFIG()Lcom/bytedance/android/live/recharge/model/RechargeNoticeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_COUPON_LIST_SCHEMA", "getLIVE_COUPON_LIST_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_FAIL_SERVER_EXCEPTION_CODE_LIST", "getLIVE_RECHARGE_FAIL_SERVER_EXCEPTION_CODE_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_SECURITY_CONFIRM_RETRY_BEHAVIOR", "getLIVE_RECHARGE_SECURITY_CONFIRM_RETRY_BEHAVIOR()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_RECHARGE_FIX_CJ_COMPONENT_HEIGHT", "getLIVE_RECHARGE_FIX_CJ_COMPONENT_HEIGHT()Z", 1))};
        f90430a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_open_cj_counter_opt", new f(0), f.class, false);
        f90431b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        String r110 = "";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_recommend_dialog_url", "", String.class, false);
        f90432c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        KmpEnv r111 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L5;
        r110 = "sslocal://webcast_webview?type=popup&gravity=bottom&height=260&status_bar_color=white&url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fwallet%2Fincome_2_diamond%2Findex.html%3Fhalf_screen%3D1%26request_page%3Dlive_detail";
    L5:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("h5_dialog_exchange", r110, String.class, false);
        f90433d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Boolean r104 = Boolean.TRUE;
        Class r112 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_old_container_recharge", r104, r112, false);
        f90434e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_adapt_fold_screen", r104, r112, false);
        f90435f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_diamond_notice_config", new com.bytedance.android.live.recharge.model.e(), com.bytedance.android.live.recharge.model.e.class, false);
        f90436g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_coupon_list_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_wallet_douyin%2Fpages%2Fcoupon_list%2Ftemplate.js&type=popup&gravity=bottom&rate_height=480", String.class, false);
        f90437h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fail_server_exception_code_list", CollectionsKt.listOf(4005198), wn3.a.f560464b, false);
        f90438i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_security_confirm_retry_behavior", 1, Integer.TYPE, false);
        f90439j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_fix_cj_component_height", r104, r112, false);
        f90440k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
    }
}
