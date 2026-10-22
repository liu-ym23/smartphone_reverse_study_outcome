package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f112918a;

    public k(long r100) {
        this.f112918a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILinkServiceExternal r100 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.updateLoad0Ts(this.f112918a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
