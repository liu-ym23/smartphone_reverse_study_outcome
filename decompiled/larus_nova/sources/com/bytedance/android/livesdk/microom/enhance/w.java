package com.bytedance.android.livesdk.microom.enhance;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalRoomMicListWidget f153890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f153891b;

    public w(NormalRoomMicListWidget r100, long r101) {
        this.f153890a = r100;
        this.f153891b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NormalRoomMicListWidget r100 = this.f153890a;     // Catch: Throwable -> L4
        int r101 = (int) this.f153891b;     // Catch: Throwable -> L4
        r100.zq(r101, r101, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
