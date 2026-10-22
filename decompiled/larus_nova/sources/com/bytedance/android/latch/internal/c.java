package com.bytedance.android.latch.internal;

import com.bytedance.android.latch.internal.perf.i;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f58292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f58294c;

    public c(a r100, String r101, i r102) {
        this.f58292a = r100;
        this.f58293b = r101;
        this.f58294c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f58292a.f58279f.b(this.f58293b, this.f58294c);     // Catch: Throwable -> L4
        a r100 = this.f58292a;     // Catch: Throwable -> L4
        r100.f58279f.c(r100.f58274a, this.f58293b, r100.f58280g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
