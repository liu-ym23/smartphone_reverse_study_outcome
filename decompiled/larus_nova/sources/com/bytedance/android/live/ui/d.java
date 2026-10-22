package com.bytedance.android.live.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f102076a;

    public d(c r100) {
        this.f102076a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o r100 = this.f102076a.f102069q;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
        r100.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
