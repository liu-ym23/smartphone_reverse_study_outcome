package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebpAnimatedWidget f152770a;

    public d(WebpAnimatedWidget r100) {
        this.f152770a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f152770a.f152758k = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
