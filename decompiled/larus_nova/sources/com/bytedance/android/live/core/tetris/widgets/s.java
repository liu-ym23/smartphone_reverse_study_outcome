package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66026c;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager r100 = this.f66026c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r101 = this.f66024a;     // Catch: Throwable -> L4
        r100.continueLoad(r101, this.f66025b, r101.getLayoutView());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public s(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102) {
        this.f66026c = r100;
        this.f66024a = r101;
        this.f66025b = r102;
    }
}
