package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66020c;

    @Override // java.lang.Runnable
    public final void run() {
        WidgetPerfManager.getInstance().onPerfEnd(this.f66018a, WidgetCostModule.TYPE_INFLATE);     // Catch: Throwable -> L4
        this.f66020c.onLoadSuccessByAsync(this.f66018a);     // Catch: Throwable -> L4
        RecyclableWidgetManager r100 = this.f66020c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r101 = this.f66018a;     // Catch: Throwable -> L4
        r100.continueLoad(r101, this.f66019b, r101.contentView);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102) {
        this.f66020c = r100;
        this.f66018a = r101;
        this.f66019b = r102;
    }
}
