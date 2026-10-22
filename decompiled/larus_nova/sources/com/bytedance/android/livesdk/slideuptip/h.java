package com.bytedance.android.livesdk.slideuptip;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlideTaskWidget f158412a;

    public h(SlideTaskWidget r100) {
        this.f158412a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SlideTaskWidget r100 = this.f158412a;     // Catch: Throwable -> L4
        int r101 = SlideTaskWidget.f158384i;     // Catch: Throwable -> L4
        r100.xq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
