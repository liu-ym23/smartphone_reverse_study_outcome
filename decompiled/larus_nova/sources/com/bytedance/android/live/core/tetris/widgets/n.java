package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66009b;

    @Override // java.lang.Runnable
    public final void run() {
        WidgetPerfManager.getInstance().onPerfEnd(this.f66008a, WidgetCostModule.TYPE_INFLATE);     // Catch: Throwable -> L6
        this.f66009b.onLoadSuccessByAsync(this.f66008a);     // Catch: Throwable -> L6
        LiveRecyclableWidget r100 = this.f66008a;     // Catch: Throwable -> L6
        if (r100.dataCenter == null) goto L9;
        this.f66009b.continueLoad(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public n(RecyclableWidgetManager r100, LiveRecyclableWidget r101) {
        this.f66009b = r100;
        this.f66008a = r101;
    }
}
