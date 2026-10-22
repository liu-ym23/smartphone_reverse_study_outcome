package com.bytedance.android.latch.internal.perf;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f58366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f58367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f58368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f58369d;

    public d(b r100, String r101, String r102, long r103) {
        this.f58366a = r100;
        this.f58367b = r101;
        this.f58368c = r102;
        this.f58369d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a r100 = b.a(this.f58366a, this.f58367b);     // Catch: Throwable -> L4
        String r101 = this.f58368c;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Throwable -> L4
        r100.f58352a = r101;     // Catch: Throwable -> L4
        r100.f58353b = this.f58369d;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
