package com.bytedance.android.gamecp.live_impl.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f58093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PromoteCardLoadOpt f58094b;

    public o(Function3 r100, PromoteCardLoadOpt r101) {
        this.f58093a = r100;
        this.f58094b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f58093a.invoke(null, Boolean.FALSE, new Pair(Long.valueOf(this.f58094b.f58062f), Long.valueOf(this.f58094b.f58063g)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
