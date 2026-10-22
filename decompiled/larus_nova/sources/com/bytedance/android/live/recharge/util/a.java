package com.bytedance.android.live.recharge.util;

import com.bytedance.android.live.revenue.common.HybridPropertyUtilsKt;
import com.bytedance.android.live.revenue.common.m;
import com.bytedance.android.live.revenue.common.w0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f90415b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f90416c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f90417d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f90418e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f90419f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f90420g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f90421h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f90422i = null;

    static {
        f90414a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "CASH_EXCHANGE_GIFT_SEND_AUTO", "getCASH_EXCHANGE_GIFT_SEND_AUTO()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "INCOME_BALANCE_VISIBLE_AUTHORITY", "getINCOME_BALANCE_VISIBLE_AUTHORITY()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "TOOLBAR_TREASURE_BOX_COUNT_DOWN", "getTOOLBAR_TREASURE_BOX_COUNT_DOWN()Ljava/util/Map;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_INCENTIVE_EXCHANGE_DIAMOND_OPT_CACHE", "getLIVE_INCENTIVE_EXCHANGE_DIAMOND_OPT_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_FANSCLUB_BASE_DATA_CACHE", "getLIVE_FANSCLUB_BASE_DATA_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_TASK_LIST_DATA_CACHE", "getLIVE_TASK_LIST_DATA_CACHE()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_TASK_CENTER_DATA_CACHE", "getLIVE_TASK_CENTER_DATA_CACHE()Ljava/lang/String;", 0))};
        f90422i = new a();
        Intrinsics.checkNotNullParameter("cash_exchange_gift_send_auto", "key");
        Boolean r100 = Boolean.FALSE;
        w0<Boolean> r101 = HybridPropertyUtilsKt.f90804c;
        f90415b = new m("cash_exchange_gift_send_auto", r100, r101);
        Intrinsics.checkNotNullParameter("income_balance_visible_authority", "key");
        f90416c = new m("income_balance_visible_authority", r100, r101);
        f90417d = HybridPropertyUtilsKt.c("webcast.excitation.douyin.daily_box_task.storage_key_v2", new LinkedHashMap());
        f90418e = HybridPropertyUtilsKt.b("live_incentive_exchange_diamond_opt_cache", "0_0");
        f90419f = HybridPropertyUtilsKt.b("live_fansclub_base_data_cache", "");
        f90420g = HybridPropertyUtilsKt.b("live_task_list_data_cache", "");
        f90421h = HybridPropertyUtilsKt.b("live_task_center_data_cache_v2", "");
    }

    public a() {
    }

    public final Map<String, String> a() {
        return (Map) f90417d.getValue(this, f90414a[2]);
    }
}
