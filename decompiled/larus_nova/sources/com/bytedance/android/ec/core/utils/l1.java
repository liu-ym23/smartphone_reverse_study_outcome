package com.bytedance.android.ec.core.utils;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class l1 implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f45632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f45633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f45634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f45636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f45638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f45639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<a> f45640j;

    public interface a {
        void onFinish();

        void onStart();

        void onTick(long r100);
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f45635e = true;     // Catch: Throwable -> L7
        this.f45636f = false;     // Catch: Throwable -> L7
        this.f45637g = false;     // Catch: Throwable -> L7
        this.f45638h.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f45636f == false) goto L6;
        this.f45637g = true;     // Catch: Throwable -> L8
        this.f45638h.removeMessages(1);     // Catch: Throwable -> L8
        this.f45634d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f45637g == false) goto L6;
        this.f45637g = false;     // Catch: Throwable -> L8
        long r100 = SystemClock.elapsedRealtime() - this.f45634d;     // Catch: Throwable -> L8
        long r101 = this.f45632b;     // Catch: Throwable -> L8
        long r102 = r101 - (r100 % r101);     // Catch: Throwable -> L8
        WeakHandler r103 = this.f45638h;     // Catch: Throwable -> L8
        r103.sendMessageDelayed(r103.obtainMessage(1), r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void d() {
        monitor-enter(this);
        this.f45637g = false;     // Catch: Throwable -> L26
        this.f45635e = false;     // Catch: Throwable -> L26
        this.f45636f = true;     // Catch: Throwable -> L26
        if (this.f45631a > 0) goto L16;
        this.f45636f = false;     // Catch: Throwable -> L26
        a r100 = this.f45639i;     // Catch: Throwable -> L26
        if (r100 == null) goto L9;
        r100.onFinish();     // Catch: Throwable -> L26
    L9:
        Iterator r101 = ((ArrayList) this.f45640j).iterator();     // Catch: Throwable -> L26
    L11:
        if (r101.hasNext() == false) goto L14;
        ((a) r101.next()).onFinish();     // Catch: Throwable -> L26
        goto L11
    L14:
        monitor-exit(this);
        return;
    L16:
        a r102 = this.f45639i;     // Catch: Throwable -> L26
        if (r102 == null) goto L19;
        r102.onStart();     // Catch: Throwable -> L26
    L19:
        Iterator r103 = ((ArrayList) this.f45640j).iterator();     // Catch: Throwable -> L26
    L21:
        if (r103.hasNext() == false) goto L23;
        ((a) r103.next()).onStart();     // Catch: Throwable -> L26
        goto L21
    L23:
        this.f45633c = SystemClock.elapsedRealtime() + this.f45631a;     // Catch: Throwable -> L26
        WeakHandler r104 = this.f45638h;     // Catch: Throwable -> L26
        r104.sendMessage(r104.obtainMessage(1));     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this.f45635e == false) goto L6;
    L38:
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L6:
        if (this.f45637g == true) goto L38;
        long r101 = this.f45633c - SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
        long r102 = 0;
        if (r101 > 0) goto L17;
        this.f45636f = false;     // Catch: Throwable -> L40
        a r103 = this.f45639i;     // Catch: Throwable -> L40
        if (r103 == null) goto L13;
        r103.onFinish();     // Catch: Throwable -> L40
    L13:
        Iterator r104 = ((ArrayList) this.f45640j).iterator();     // Catch: Throwable -> L40
    L15:
        if (r104.hasNext() == false) goto L36;
        ((a) r104.next()).onFinish();     // Catch: Throwable -> L40
    L36:
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L17:
        long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
        a r106 = this.f45639i;     // Catch: Throwable -> L40
        if (r106 == null) goto L20;
        r106.onTick(r101);     // Catch: Throwable -> L40
    L20:
        Iterator r107 = ((ArrayList) this.f45640j).iterator();     // Catch: Throwable -> L40
    L22:
        if (r107.hasNext() == false) goto L24;
        ((a) r107.next()).onTick(r101);     // Catch: Throwable -> L40
        goto L22
    L24:
        long r108 = SystemClock.elapsedRealtime() - r105;     // Catch: Throwable -> L40
        long r109 = this.f45632b;     // Catch: Throwable -> L40
        if (r101 >= r109) goto L30;
        long r110 = r101 - r108;     // Catch: Throwable -> L40
        if (r110 < 0) goto L35;
        r102 = r110;
    L35:
        WeakHandler r111 = this.f45638h;     // Catch: Throwable -> L40
        r111.sendMessageDelayed(r111.obtainMessage(1), r102);     // Catch: Throwable -> L40
        goto L36
    L30:
        long r112 = r109 - r108;     // Catch: Throwable -> L40
    L32:
        if (r112 >= 0) goto L34;
        r112 = r112 + this.f45632b;     // Catch: Throwable -> L40
        goto L32
    L34:
        r102 = r112;
        goto L35
    }

    public l1(long r100, long r101, a r102) {
        this.f45635e = false;
        this.f45636f = false;
        this.f45637g = false;
        this.f45640j = new ArrayList();
        this.f45631a = r100;
        this.f45632b = r101;
        this.f45638h = new WeakHandler(Looper.getMainLooper(), this);
        this.f45639i = r102;
    }
}
