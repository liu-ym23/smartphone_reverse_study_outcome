package com.bytedance.android.live.core.tetris.widgets;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66037c;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager r100 = this.f66037c;     // Catch: Throwable -> L4
        LiveRecyclableWidget r101 = this.f66035a;     // Catch: Throwable -> L4
        RecyclableWidgetManager.U90(r100, r101, this.f66036b, r101.contentView);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102) {
        this.f66037c = r100;
        this.f66035a = r101;
        this.f66036b = r102;
    }
}
