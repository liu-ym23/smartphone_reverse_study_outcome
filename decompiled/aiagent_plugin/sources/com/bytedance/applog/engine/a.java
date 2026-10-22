package com.bytedance.applog.engine;

import android.content.Context;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.common.utility.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseWorker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long[] f5600c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Engine f5601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f5602b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5604e;
    private boolean f;

    public abstract boolean b(int r1);

    public abstract boolean c();

    public abstract long d();

    public abstract long[] e();

    public abstract String f();

    public a(Engine r1) {
        this.f5601a = r1;
    }

    public a(Engine r1, long r2) {
        this(r1);
        this.f5604e = r2;
    }

    static {
        f5600c = new long[]{180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    }

    boolean a() {
        if (b().e() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f == true) goto L8;
        return false;
    }

    public com.bytedance.applog.c b() {
        return this.f5601a.getAppLog();
    }

    final long a(int r5) {
        long r0 = h();
        if (r0 <= System.currentTimeMillis()) goto L5;
        return r0;
    L5:
        return c(r5);
    }

    private long h() {
        long r0 = d();
        if (c() == false) goto L8;
        if (i.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5601a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L8;
        b().Z().e("checkWorkTime {} network not available", new Object[]{f()});
        this.f5601a.getAppLog().N().increaseStats(j.K);
    L14:
        return this.f5604e + r0;
    L8:
        if (this.f5602b == false) goto L10;
        this.f5604e = 0;
        this.f5602b = false;
        r0 = 0;
        goto L14
    L10:
        int r2 = this.f5603d;
        if (r2 <= 0) goto L14;
        r0 = d(r2 - 1);
        goto L14
    }

    private synchronized long c(int r6) {
        monitor-enter(this);
        boolean r7 = b(r6);     // Catch: Throwable -> L13
        this.f5604e = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r7 == false) goto L8;
        this.f5603d = 0;     // Catch: Throwable -> L11
    L9:
        b().Z().d(f() + " worked: {}", new Object[]{Boolean.valueOf(r7)});     // Catch: Throwable -> L11
    L16:
        long r0 = h();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        this.f5603d++;     // Catch: Throwable -> L11
        goto L9
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        b().Z().a("work failed", th, new Object[0]);     // Catch: Throwable -> L19
        this.f5604e = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f5603d++;     // Catch: Throwable -> L11
        b().Z().d(f() + " worked: {}", new Object[]{false});     // Catch: Throwable -> L11
        goto L16
    L19:
        th = move-exception;
        this.f5604e = System.currentTimeMillis();     // Catch: Throwable -> L11
        this.f5603d++;     // Catch: Throwable -> L11
        b().Z().d(f() + " worked: {}", new Object[]{false});     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    }

    private long d(int r2) {
        long[] r1 = e();
        return r1[r2 % r1.length];
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T extends a> T g() {
        this.f5602b = true;
        return this;
    }
}
