package com.bytedance.android.livesdk.microom.enhance;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalRoomMicListWidget f153882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f153883b;

    public p(NormalRoomMicListWidget r100) {
        this.f153882a = r100;
        this.f153883b = 60;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NormalRoomMicListWidget r100 = this.f153882a;     // Catch: Throwable -> L4
        int r101 = this.f153883b;     // Catch: Throwable -> L4
        r100.zq(r101, r101, true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
