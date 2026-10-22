package com.bytedance.android.latch.internal.perf;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f58363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f58365c;

    public c(b r100, String r101, long r102) {
        this.f58363a = r100;
        this.f58364b = r101;
        this.f58365c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a r100 = b.a(this.f58363a, this.f58364b);     // Catch: Throwable -> L4
        r100.f58354c = this.f58365c;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
