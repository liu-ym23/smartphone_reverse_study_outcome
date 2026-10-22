package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66040c;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager r100 = this.f66040c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r101 = this.f66038a;     // Catch: Throwable -> L4
        r100.continueLoad(r101, this.f66039b, r100.f65949f.e(r101.getLayoutId()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public w(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102) {
        this.f66040c = r100;
        this.f66038a = r101;
        this.f66039b = r102;
    }
}
