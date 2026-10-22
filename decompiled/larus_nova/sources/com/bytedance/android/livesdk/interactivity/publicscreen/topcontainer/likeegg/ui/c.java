package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggView f140005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.likeegg.a f140006b;

    public c(LikeEggView r100, com.bytedance.android.livesdk.chatroom.likeegg.a r101) {
        this.f140005a = r100;
        this.f140006b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LikeEggView r100 = this.f140005a;     // Catch: Throwable -> L6
        if (r100.f139993h != 2) goto L9;
        LikeEggView.d(r100, this.f140006b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
