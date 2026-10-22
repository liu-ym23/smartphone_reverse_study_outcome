package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.basecomponents.session;

import com.bytedance.android.livesdk.utils.w3;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ls2.d f107207a;

    public a(ls2.d r100) {
        this.f107207a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w3.a(70, this.f107207a.f510523l);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
