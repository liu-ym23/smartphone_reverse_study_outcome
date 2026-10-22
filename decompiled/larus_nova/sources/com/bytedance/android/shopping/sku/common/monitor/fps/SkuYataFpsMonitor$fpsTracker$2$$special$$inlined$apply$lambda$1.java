package com.bytedance.android.shopping.sku.common.monitor.fps;

import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SkuYataFpsMonitor$fpsTracker$2 f182763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f182764b;

    public SkuYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(SkuYataFpsMonitor$fpsTracker$2 r100, String r101) {
        this.f182763a = r100;
        this.f182764b = r101;
    }

    @Override // et3.c.d
    public final void fpsCallBack(final double r100) {
        SkuRunCatchExtKt.a(this.f182763a.this$0.f182761c.getMonitorId(), "SkuYataFpsMonitor", new AnonymousClass1(this, r100));
    }
}
