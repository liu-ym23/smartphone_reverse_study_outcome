package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecyclableWidget f65997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f65998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f65999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclableWidgetManager f66000d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f66000d.continueLoad(this.f65997a, this.f65998b, this.f65999c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(RecyclableWidgetManager r100, LiveRecyclableWidget r101, ViewGroup r102, View r103) {
        this.f66000d = r100;
        this.f65997a = r101;
        this.f65998b = r102;
        this.f65999c = r103;
    }
}
