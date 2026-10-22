package com.bytedance.android.livesdk.interactivity.comment.audio;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.d f134835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f134836b;

    public d(c.d r100, byte[] r101) {
        this.f134835a = r100;
        this.f134836b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b r100 = this.f134835a.f134832a.f134829o;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c(this.f134836b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
