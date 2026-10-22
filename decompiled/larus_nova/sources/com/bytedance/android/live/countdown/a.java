package com.bytedance.android.live.countdown;

import android.os.SystemClock;
import com.bytedance.android.live.revenue.common.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f66601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f66602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f66603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f66604d;

    /* JADX INFO: renamed from: com.bytedance.android.live.countdown.a$a, reason: collision with other inner class name */
    public static final class C1101a {
    }

    static {
    }

    public abstract void b();

    public abstract void c(long r100);

    public final synchronized void d() {
        monitor-enter(this);
        this.f66602b = false;     // Catch: Throwable -> L12
        if (this.f66603c > 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        Intrinsics.checkNotNullParameter(i97.a.f488802a, "$this$elapsedRealtime");     // Catch: Throwable -> L12
        this.f66601a = SystemClock.elapsedRealtime() + this.f66603c;     // Catch: Throwable -> L12
        p0.a(0, false, true, new CountDownTimer$start$1(this), 3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public a(long r100) {
        this.f66603c = r100;
        this.f66604d = 1000;
    }

    public static final void a(final a r110) {
        if (r110.f66602b == true) goto L23;
        long r100 = r110.f66601a;
        i97.a r101 = i97.a.f488802a;
        Intrinsics.checkNotNullParameter(r101, "$this$elapsedRealtime");
        long r102 = r100 - SystemClock.elapsedRealtime();
        if (r102 > 0) goto L8;
        r110.b();
        return;
    L8:
        Intrinsics.checkNotNullParameter(r101, "$this$elapsedRealtime");
        long r103 = SystemClock.elapsedRealtime();
        r110.c(r102);
        Intrinsics.checkNotNullParameter(r101, "$this$elapsedRealtime");
        long r104 = SystemClock.elapsedRealtime() - r103;
        long r105 = r110.f66604d;
        if (r102 >= r105) goto L14;
        long r106 = r102 - r104;
        if (r106 >= 0) goto L13;
        long r107 = 0;
    L19:
        p0.a(r107, false, true, new CountDownTimer$checkTime$1(r110), 2);
        return;
    L13:
        r107 = r106;
        goto L19
    L14:
        long r108 = r105 - r104;
    L16:
        if (r108 >= 0) goto L18;
        r108 = r108 + r110.f66604d;
        goto L16
    L18:
        r107 = r108;
        goto L19
    }
}
