package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import et3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderCommonFpsMonitor$fpsTracker$2 f179918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f179919b;

    public OrderCommonFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(OrderCommonFpsMonitor$fpsTracker$2 r100, String r101) {
        this.f179918a = r100;
        this.f179919b = r101;
    }

    @Override // et3.c.d
    public final void fpsCallBack(final double r100) {
        OrderCommonErrorMonitorKt.c(null, "OrderCommonFpsMonitor-fpsTracker", new AnonymousClass1(this, r100));
    }
}
