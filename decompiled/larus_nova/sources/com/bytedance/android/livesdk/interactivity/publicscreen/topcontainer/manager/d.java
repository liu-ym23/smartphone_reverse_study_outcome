package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f140059a;

    public d(c r100) {
        this.f140059a = r100;
    }

    public final void a() {
        if (((ArrayList) this.f140059a.f140054a).isEmpty() == false) goto L6;
        ALogger.e("LikeEggManager", "waitingMsgRunnable run, but waitingMsgList is empty");
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.likeegg.a r100 = (com.bytedance.android.livesdk.chatroom.likeegg.a) ListProtector.remove(this.f140059a.f140054a, 0);
        this.f140059a.getClass();
        GuideTray r101 = GuideTray.HotMsgGather;
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
