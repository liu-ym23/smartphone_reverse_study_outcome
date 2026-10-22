package com.bytedance.android.shopping.store.home.view;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f184726a;

    public o(n r100) {
        this.f184726a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n r100 = this.f184726a;     // Catch: Throwable -> L7
        ViewGroup r101 = r100.f184723g;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.removeView(r100);     // Catch: Throwable -> L7
    L5:
        com.bytedance.android.ec.store.common.bubble.c r102 = ECBubbleControllerManager.f48207b.a(r100.f184721e);     // Catch: Throwable -> L7
        r102.d();     // Catch: Throwable -> L7
        com.bytedance.android.ec.store.common.bubble.c.e(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
