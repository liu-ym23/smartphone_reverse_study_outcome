package com.bytedance.android.gamecp.live_impl.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f58099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PromoteCardLoadOptV2 f58100b;

    public q(Function1 r100, PromoteCardLoadOptV2 r101) {
        this.f58099a = r100;
        this.f58100b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f58099a.invoke(this.f58100b.f58069e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
