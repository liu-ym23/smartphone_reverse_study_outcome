package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.utils.k;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f153216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f153217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q83.a f153218d;

    public final synchronized void a() {
        monitor-enter(this);
        this.f153215a = true;     // Catch: Throwable -> L7
        this.f153216b = false;     // Catch: Throwable -> L7
        this.f153217c.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f153216b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        this.f153215a = false;     // Catch: Throwable -> L7
        this.f153216b = true;     // Catch: Throwable -> L7
        e r100 = this.f153217c;     // Catch: Throwable -> L7
        r100.sendMessage(r100.obtainMessage(1));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public c(q83.a r100) {
        this.f153215a = false;
        this.f153216b = false;
        this.f153217c = new e(Looper.getMainLooper(), this);
        this.f153218d = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.countdown.e.a
    public final void handleMsg(Message r100) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f153215a == true) goto L15;
        Handler r101 = k.f153092a;     // Catch: Throwable -> L17
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        q83.a r103 = this.f153218d;     // Catch: Throwable -> L17
        if (r103 == null) goto L8;
        r103.onTick(r102);     // Catch: Throwable -> L17
    L8:
        long r104 = 1000 - (SystemClock.elapsedRealtime() - r102);     // Catch: Throwable -> L17
    L10:
        if (r104 >= 0) goto L12;
        r104 = r104 + 1000;     // Catch: Throwable -> L17
        goto L10
    L12:
        e r105 = this.f153217c;     // Catch: Throwable -> L17
        r105.sendMessageDelayed(r105.obtainMessage(1), r104);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    }
}
