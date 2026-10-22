package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.livesdk.livecommerce.event.f1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomContextController f152338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f152339b;

    public j(RoomContextController r100, Map r101) {
        this.f152338a = r100;
        this.f152339b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f1 r100 = new f1(this.f152338a);     // Catch: Throwable -> L4
        r100.m(this.f152339b);     // Catch: Throwable -> L4
        r100.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
