package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeatAnimationView f72466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i f72467b;

    public i(SeatAnimationView r100, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i r101) {
        this.f72466a = r100;
        this.f72467b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r100 = this.f72466a.f72414a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c(this.f72467b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
