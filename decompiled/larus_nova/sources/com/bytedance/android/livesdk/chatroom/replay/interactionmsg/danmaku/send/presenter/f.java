package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputDanmuTextPresenter f109134a;

    public f(InputDanmuTextPresenter r100) {
        this.f109134a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InputDanmuTextPresenter.n(this.f109134a).requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
