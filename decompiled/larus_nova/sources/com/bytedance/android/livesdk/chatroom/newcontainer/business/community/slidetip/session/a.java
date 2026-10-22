package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomSlideTipsBusiness f107456a;

    public a(LiveRoomSlideTipsBusiness r100) {
        this.f107456a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveRoomSlideTipsBusiness r100 = this.f107456a;     // Catch: Throwable -> L10
        ls2.d r101 = r100.f107443b;     // Catch: Throwable -> L10
        ik1.d r102 = r100.f107444c;     // Catch: Throwable -> L10
        FrameLayout r103 = null;
        if (r102 == null) goto L5;
        ik1.h r104 = r102.f490241q;     // Catch: Throwable -> L10
    L6:
        if (r102 == null) goto L8;
        r103 = r102.f490234j;     // Catch: Throwable -> L10
    L8:
        h.a(r101, r104, r103);     // Catch: Throwable -> L10
        return;
    L5:
        r104 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
