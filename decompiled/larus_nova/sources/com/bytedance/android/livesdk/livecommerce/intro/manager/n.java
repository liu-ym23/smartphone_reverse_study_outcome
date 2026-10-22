package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.controller.b f148420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uh2.a f148421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f148422c;

    public n(com.bytedance.android.livesdk.livecommerce.intro.controller.b r100, uh2.a r101, boolean r102) {
        this.f148420a = r100;
        this.f148421b = r101;
        this.f148422c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this.f148420a, null, null, false, this.f148422c, 7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
