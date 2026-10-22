package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayMessageHandlePopup f109017a;

    public k(ReplayMessageHandlePopup r100) {
        this.f109017a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f109017a.f108974o.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
