package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.basecomponents.session;

import com.bytedance.android.livesdk.utils.k3;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f107212a = null;

    static {
        f107212a = new f();
    }

    public f() {
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
