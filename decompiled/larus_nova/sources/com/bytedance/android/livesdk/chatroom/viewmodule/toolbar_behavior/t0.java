package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LandscapeToolbarMoreBehavior f117369a;

    @Override // java.lang.Runnable
    public final void run() {
        LandscapeToolbarMoreBehavior r100 = this.f117369a;     // Catch: Throwable -> L6
        yo2.e r101 = r100.O;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.i(r100.M, 1, 0, com.bytedance.android.live.core.utils.s1.f(r100.P), com.bytedance.android.live.core.utils.s1.f(this.f117369a.Q));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public t0(LandscapeToolbarMoreBehavior r100) {
        this.f117369a = r100;
    }
}
