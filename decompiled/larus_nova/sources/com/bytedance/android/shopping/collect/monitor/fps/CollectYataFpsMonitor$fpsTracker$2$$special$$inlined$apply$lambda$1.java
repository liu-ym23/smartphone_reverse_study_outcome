package com.bytedance.android.shopping.collect.monitor.fps;

import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class CollectYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CollectYataFpsMonitor$fpsTracker$2 f172248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f172249b;

    public CollectYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(CollectYataFpsMonitor$fpsTracker$2 r100, String r101) {
        this.f172248a = r100;
        this.f172249b = r101;
    }

    @Override // et3.c.d
    public final void fpsCallBack(final double r100) {
        CollectRunCatchExtKt.a(this.f172248a.this$0.f172246c.getMonitorId(), "CollectYataFpsMonitor", new AnonymousClass1(this, r100));
    }
}
