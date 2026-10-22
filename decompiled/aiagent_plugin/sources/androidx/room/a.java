package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AutoCloser.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f2607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f2608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Executor f2609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2610e;
    long f;
    androidx.sqlite.db.c g;
    final Runnable h;
    private androidx.sqlite.db.d i;
    private final Handler j;
    private boolean k;
    private final Runnable l;

    a(long r4, TimeUnit r6, Executor r7) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r7, Executor.class, "com.obric.aiagent.plugin");
        this.i = null;
        this.j = new Handler(Looper.getMainLooper());
        this.f2606a = null;
        this.f2607b = new Object();
        this.f2610e = 0;
        this.f = SystemClock.uptimeMillis();
        this.k = false;
        this.l = new AnonymousClass1(this);
        this.h = new AnonymousClass2(this);
        this.f2608c = r6.toMillis(r4);
        this.f2609d = r8;
    }

    public void a(androidx.sqlite.db.d r3) {
        androidx.sqlite.db.d r4 = (androidx.sqlite.db.d) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.d.class, "com.obric.aiagent.plugin");
        if (this.i == null) goto L6;
        a("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        return;
    L6:
        this.i = r4;
    }

    public <V> V a(androidx.a.a.c.a<androidx.sqlite.db.c, V> r3) {
        androidx.a.a.c.a r4 = (androidx.a.a.c.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.a.a.c.a.class, "com.obric.aiagent.plugin");
        V r5 = (V) r4.apply(a());
        b();
        return r5;
    L6:
        th = move-exception;
        b();
        throw th;
    }

    public androidx.sqlite.db.c a() {
        Object r0 = this.f2607b;
        monitor-enter(r0);
        this.j.removeCallbacks(this.l);     // Catch: Throwable -> L22
        this.f2610e++;     // Catch: Throwable -> L22
        if (this.k == true) goto L21;
        androidx.sqlite.db.c r1 = this.g;     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
    L13:
        androidx.sqlite.db.d r2 = this.i;     // Catch: Throwable -> L22
        if (r2 == null) goto L19;
        androidx.sqlite.db.c r3 = r2.b();     // Catch: Throwable -> L22
        this.g = r3;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r3;
    L19:
        throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");     // Catch: Throwable -> L22
    L9:
        if (r1.g() == false) goto L13;
        androidx.sqlite.db.c r4 = this.g;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r4;
    L21:
        throw new IllegalStateException("Attempting to open already closed database.");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void b() {
        Object r0 = this.f2607b;
        monitor-enter(r0);
        int r1 = this.f2610e;     // Catch: Throwable -> L17
        if (r1 <= 0) goto L16;
        int r2 = r1 - 1;     // Catch: Throwable -> L17
        this.f2610e = r2;     // Catch: Throwable -> L17
        if (r2 == 0) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (this.g != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L12:
        this.j.postDelayed(this.l, this.f2608c);     // Catch: Throwable -> L17
        goto L13
    L16:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public androidx.sqlite.db.c c() {
        Object r0 = this.f2607b;
        monitor-enter(r0);
        androidx.sqlite.db.c r1 = this.g;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void d() {
        Object r0 = this.f2607b;
        monitor-enter(r0);
        this.k = true;     // Catch: Throwable -> L11
        androidx.sqlite.db.c r1 = this.g;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L11
    L8:
        this.g = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean e() {
        return !this.k;
    }

    public void a(Runnable r3) {
        this.f2606a = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
