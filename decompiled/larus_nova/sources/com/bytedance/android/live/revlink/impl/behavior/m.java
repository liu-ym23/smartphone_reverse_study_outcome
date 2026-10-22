package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f92177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimatedDrawable2 f92178b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f92177a.f92181a.c();     // Catch: Throwable -> L6
        AnimatedDrawable2 r100 = this.f92178b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.start();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public m(n r100, AnimatedDrawable2 r101) {
        this.f92177a = r100;
        this.f92178b = r101;
    }
}
