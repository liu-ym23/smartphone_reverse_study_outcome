package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractionWidgetsPosContext f112935a;

    public r(InteractionWidgetsPosContext r100) {
        this.f112935a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f112935a.share();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
