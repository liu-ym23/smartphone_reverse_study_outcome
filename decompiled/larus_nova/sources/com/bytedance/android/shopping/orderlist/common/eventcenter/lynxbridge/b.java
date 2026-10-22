package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BridgetLynxComponent f179865a;

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public b(BridgetLynxComponent r100) {
        this.f179865a = r100;
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        BridgetLynxComponent r101 = this.f179865a;
        r101.f179856b = true;
        OrderCommonBusinessMonitor r102 = r101.b();
        if (r102 == null) goto L6;
        r102.g();
        return;
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        OrderCommonBusinessMonitor r102 = this.f179865a.b();
        if (r102 == null) goto L5;
        r102.f(r101);
    L5:
        OrderCommonErrorMonitorKt.b(null, "LYNX_BRIDGE_ERROR", "BridgetLynxComponent-createLiveComponent: onLoadFailed msg:" + r101);
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        OrderCommonErrorMonitorKt.b(null, "LYNX_BRIDGE_ERROR", "BridgetLynxComponent-createLiveComponent: receiveError msg:" + r102 + "  url:" + r101);
    }
}
