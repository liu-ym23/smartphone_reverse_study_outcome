package com.bytedance.android.livesdk.livecommerce.intro.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f148540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f148541b;

    public g(Function1 r100, h r101) {
        this.f148540a = r100;
        this.f148541b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f148540a.invoke(this.f148541b.f148542a.f148534d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
