package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.basecomponents.session;

import com.bytedance.android.livesdk.utils.k3;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f107208a = null;

    static {
        f107208a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        k3.a(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
