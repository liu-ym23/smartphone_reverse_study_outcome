package com.bytedance.android.livesdk.chatroom.room;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f110642a;

    public final void a() {
        if (this.f110642a.f110781h == false) goto L5;
        long r100 = SystemClock.elapsedRealtime();
        b1 r101 = this.f110642a;
        long r102 = 60000 - (((r100 - r101.f110785l) - r101.f110784k) % 60000);
        r101.f110781h = false;
    L6:
        this.f110642a.f110774a.postDelayed(this, r102);
        b1 r103 = this.f110642a;
        if (r103.f110783j == false) goto L9;
    L13:
        r103.f110783j = false;
        return;
    L9:
        if (r102 != 60000) goto L13;
        r103.f110779f.c("watch_onemin", null, new Object[0]);
        com.bytedance.android.livesdk.log.w.a(2);
        return;
    L5:
        r102 = 60000;
        goto L6
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

    public a1(b1 r100) {
        this.f110642a = r100;
    }
}
