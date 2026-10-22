package com.bytedance.android.shopping.orderlist.common.monitor.business;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import gg3.d;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonBusinessMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f179885h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f179886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f179887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f179888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f179889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f179890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f179891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> f179892g;

    public static final class a {
    }

    static {
    }

    public final void e() {
        c("load_gul_success", new OrderCommonBusinessMonitor$onGULLoadSuccess$1(this));
    }

    public final void g() {
        c("load_lynx_bridge_success", new OrderCommonBusinessMonitor$onLynxBridgeLoadSuccess$1(this));
    }

    public final void l() {
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-onUpScreenFinishNotFastMode", new OrderCommonBusinessMonitor$onUpScreenFinishNotFastMode$1(this));
    }

    public OrderCommonBusinessMonitor(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f179892g = r100;
        this.f179891f = new LinkedHashMap();
    }

    public final void b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionArea");
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-addActionInterceptInfo", new OrderCommonBusinessMonitor$addActionInterceptInfo$1(this, r100));
    }

    public final void d(final String r100) {
        c("load_gul_fail", new OrderCommonBusinessMonitor$onGULLoadFail$1(r100));
    }

    public final void f(final String r100) {
        c("load_lynx_bridge_fail", new OrderCommonBusinessMonitor$onLynxBridgeLoadFailed$1(r100));
    }

    public final void j(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-onRequestStartNotFastMode", new OrderCommonBusinessMonitor$onRequestStartNotFastMode$1(this, r100));
    }

    public final void k(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "silentRequestState");
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-onSilentRequestAllEnd", new OrderCommonBusinessMonitor$onSilentRequestAllEnd$1(this, r100));
    }

    public final void n(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        this.f179887b = System.currentTimeMillis();
        c("use_bridge_start", new OrderCommonBusinessMonitor$useBridgeStart$1(r100));
    }

    public static final void a(OrderCommonBusinessMonitor r100, Map r101) {
        if ((!r100.f179891f.isEmpty()) == false) goto L6;
        r101.putAll(r100.f179891f);
        ((LinkedHashMap) r100.f179891f).clear();
        return;
    }

    public final void c(final String r100, final Function0<? extends Map<String, ? extends Object>> r101) {
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-logForBusiness", new OrderCommonBusinessMonitor$logForBusiness$1(this, r101, r100));
    }

    public final void i(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-onRequestEndNotFastMode", new OrderCommonBusinessMonitor$onRequestEndNotFastMode$1(this, r101, r100));
    }

    public final void m(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        c("use_bridge_end", new OrderCommonBusinessMonitor$useBridgeEnd$1(this, r100, r101));
    }

    public final void h(final String r100, final boolean r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "requestType");
        OrderCommonErrorMonitorKt.c(this.f179892g.get(), "OrderCommonBusinessMonitor-onPageFinish", new OrderCommonBusinessMonitor$onPageFinish$1(this, r100, r101, r102));
    }
}
