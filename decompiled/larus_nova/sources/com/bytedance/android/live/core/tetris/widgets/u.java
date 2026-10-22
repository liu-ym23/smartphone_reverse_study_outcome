package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f66031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f66032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f66033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66034d;

    @Override // java.lang.Runnable
    public final void run() {
        RecyclableWidgetManager.U90(this.f66034d, this.f66031a, this.f66032b, this.f66033c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102, View r103) {
        this.f66034d = r100;
        this.f66031a = r101;
        this.f66032b = r102;
        this.f66033c = r103;
    }
}
