package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a f140021b;

    public k(LikeEggView r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101) {
        this.f140020a = r100;
        this.f140021b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LikeEggView.d(this.f140020a, this.f140021b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
