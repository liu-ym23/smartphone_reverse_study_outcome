package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f123253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f123254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f123255d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f123254c.a(this.f123253b);     // Catch: Throwable -> L4
        this.f123255d.a(this.f123252a, this.f123253b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(String r100, long r101, j r102, k r103) {
        Intrinsics.checkNotNullParameter(r100, "runnableName");
        Intrinsics.checkNotNullParameter(r102, "runnable");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f123252a = r100;
        this.f123253b = r101;
        this.f123254c = r102;
        this.f123255d = r103;
    }
}
