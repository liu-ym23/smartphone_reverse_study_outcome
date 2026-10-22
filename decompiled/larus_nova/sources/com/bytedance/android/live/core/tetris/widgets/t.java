package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f66029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66030d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f66030d.continueLoad(this.f66027a, this.f66028b, this.f66029c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public t(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102, View r103) {
        this.f66030d = r100;
        this.f66027a = r101;
        this.f66028b = r102;
        this.f66029c = r103;
    }
}
