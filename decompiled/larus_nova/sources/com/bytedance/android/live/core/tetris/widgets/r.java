package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66023c;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager r100 = this.f66023c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r101 = this.f66021a;     // Catch: Throwable -> L4
        r100.continueLoad(r101, this.f66022b, r101.contentView);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102) {
        this.f66023c = r100;
        this.f66021a = r101;
        this.f66022b = r102;
    }
}
