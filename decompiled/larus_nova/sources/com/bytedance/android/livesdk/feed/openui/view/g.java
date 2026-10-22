package com.bytedance.android.livesdk.feed.openui.view;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f124274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f124275b;

    public g(h r100, ViewGroup.LayoutParams r101) {
        this.f124274a = r100;
        this.f124275b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleLiveView.b(this.f124274a.f124276a, true, this.f124275b.width);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
