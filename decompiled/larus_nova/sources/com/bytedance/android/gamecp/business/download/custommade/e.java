package com.bytedance.android.gamecp.business.download.custommade;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f52656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f52657b;

    public e(d r100, long r101) {
        this.f52656a = r100;
        this.f52657b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = this.f52656a.f52649f - (SystemClock.elapsedRealtime() - this.f52657b);     // Catch: Throwable -> L7
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        d r101 = this.f52656a;     // Catch: Throwable -> L7
        d.a(r101, r101.f52653j.getHeight(), r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
