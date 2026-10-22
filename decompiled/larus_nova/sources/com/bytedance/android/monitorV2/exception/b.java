package com.bytedance.android.monitorV2.exception;

import com.bytedance.android.monitorV2.util.f;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f163030a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f163030a.run();     // Catch: Throwable -> L4 Exception -> L6
    L13:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L6:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L4
        goto L13
    }

    public b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "realRunnable");
        this.f163030a = r100;
    }
}
