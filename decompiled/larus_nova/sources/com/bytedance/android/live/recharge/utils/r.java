package com.bytedance.android.live.recharge.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90496b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90497c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90498d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90499e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90500f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90501g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f90502h = null;

    /* JADX WARN: Multi-variable type inference failed */
    public static final int a() {
        return ((Number) f90497c.getValue(null, f90495a[1])).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean b() {
        return ((Boolean) f90501g.getValue(null, f90495a[6])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int c() {
        return ((Number) f90500f.getValue(null, f90495a[5])).intValue();
    }

    public static final void d(HashMap<String, Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        f90502h.setValue(null, f90495a[7], r100);
    }

    static {
        f90495a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_FREQUENCY_CONTROL", "getCASH_EXCHANGE_FREQUENCY_CONTROL()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_GIFT_SEND_SHOWN_NUMBER", "getCASH_EXCHANGE_GIFT_SEND_SHOWN_NUMBER()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "ROOM_WALLET_INFO_REQUEST_TIME_UID", "getROOM_WALLET_INFO_REQUEST_TIME_UID()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "CASH_EXCHANGE_TOOLBAR_POPUP_SHOWN", "getCASH_EXCHANGE_TOOLBAR_POPUP_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "RECHARGE_PANEL_REAL_HEIGHT", "getRECHARGE_PANEL_REAL_HEIGHT()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "EXCHANGE_DIAMONDS_FOR_SEND_GIFTS_SUCCESS_TIMES", "getEXCHANGE_DIAMONDS_FOR_SEND_GIFTS_SUCCESS_TIMES()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "EXCHANGE_DIAMONDS_DIALOG_NO_MORE_REMIND", "getEXCHANGE_DIAMONDS_DIALOG_NO_MORE_REMIND()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(r.class, "LIVE_INCENTIVE_EXCHANGE_DIAMOND_CACHE", "getLIVE_INCENTIVE_EXCHANGE_DIAMOND_CACHE()Ljava/util/HashMap;", 1))};
        f90496b = SpongePreferenceManager.a().a("cash_exchange_frequency_control", MapsKt.emptyMap(), tl3.a.f546616c);
        com.bytedance.tools.kcp.spongepreference.runtime.b r100 = SpongePreferenceManager.a();
        Class r101 = Integer.TYPE;
        f90497c = r100.a("cash_exchange_gift_send_shown_number", 0, r101);
        f90498d = SpongePreferenceManager.a().a("room_wallet_info_request_time_uid", new HashMap(), tl3.a.f546617d);
        com.bytedance.tools.kcp.spongepreference.runtime.b r102 = SpongePreferenceManager.a();
        Boolean r103 = Boolean.FALSE;
        Class r104 = Boolean.TYPE;
        r102.a("cash_exchange_toolbar_popup_shown", r103, r104);
        f90499e = SpongePreferenceManager.a().a("recharge_panel_real_height", 0, r101);
        f90500f = SpongePreferenceManager.a().a("exchange_diamonds_for_send_gifts_success_times", 0, r101);
        f90501g = SpongePreferenceManager.a().a("exchange_diamonds_dialog_no_more_remind", r103, r104);
        f90502h = SpongePreferenceManager.a().a("live_incentive_exchange_diamond_cache", new HashMap(), tl3.a.f546618e);
    }
}
