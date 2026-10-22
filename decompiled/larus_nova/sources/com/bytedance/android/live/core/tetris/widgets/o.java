package com.bytedance.android.live.core.tetris.widgets;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66011b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f66011b.continueLoad(this.f66010a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(RecyclableWidgetManager r100, LiveRecyclableWidget r101) {
        this.f66011b = r100;
        this.f66010a = r101;
    }
}
