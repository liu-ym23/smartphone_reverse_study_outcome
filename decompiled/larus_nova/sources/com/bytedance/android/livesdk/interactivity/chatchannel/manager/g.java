package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelAnimManager f134302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatChannelAnimManager.b f134303b;

    public g(ChatChannelAnimManager r100, ChatChannelAnimManager.b r101) {
        this.f134302a = r100;
        this.f134303b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatChannelAnimManager.b(this.f134302a, this.f134303b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
