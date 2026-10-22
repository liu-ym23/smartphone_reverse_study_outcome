package com.bytedance.android.livesdk.interactivity.service.messagelist;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListScrollManager f140890a;

    public i(MessageListScrollManager r100) {
        this.f140890a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageListScrollManager r100 = this.f140890a;     // Catch: Throwable -> L4
        r100.f140865d.scrollToPosition(r100.f140863b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
