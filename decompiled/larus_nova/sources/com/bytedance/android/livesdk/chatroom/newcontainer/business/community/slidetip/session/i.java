package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ls2.d f107476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik1.d f107477b;

    @Override // java.lang.Runnable
    public final void run() {
        ls2.d r100 = this.f107476a;     // Catch: Throwable -> L4
        ik1.d r101 = this.f107477b;     // Catch: Throwable -> L4
        h.b(r100, r101.f490241q, r101.f490234j);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(ls2.d r100, ik1.d r101) {
        this.f107476a = r100;
        this.f107477b = r101;
    }
}
