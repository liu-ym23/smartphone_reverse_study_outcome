package com.bytedance.android.ec.core.imagex.opt;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f44852a;

    public g(Function1 r100) {
        this.f44852a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44852a.invoke(Boolean.TRUE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
