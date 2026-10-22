package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.b f115830a;

    public e(d.b r100) {
        this.f115830a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f115830a.f115829a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
