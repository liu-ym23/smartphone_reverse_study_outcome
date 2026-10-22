package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: compiled from: AbsMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f8950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f8951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile boolean f8953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.bytedance.monitor.a.b.d f8954e;

    Pair<String, ?> a(long r1, long r3) {
        return null;
    }

    public abstract void b(int r1);

    Pair<String, ?> c() {
        return null;
    }

    public b(int r3, String r4) {
        this.f8951b = 0;
        this.f8952c = 1;
        this.f8953d = false;
        this.f8950a = r4;
        this.f8952c = r3;
        k.a().a(this);
        this.f8954e = com.bytedance.monitor.a.b.c.a();
    }

    void a() {
        if (this.f8951b < 0) goto L7;
        this.f8951b = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    void b() {
        this.f8951b = 1;
    }

    public final void a(final int r2) {
        com.bytedance.monitor.a.b.e r3 = com.bytedance.monitor.a.b.c.a("refreshConfig", new AnonymousClass1(this, r2));
        com.bytedance.monitor.a.b.d r1 = this.f8954e;
        if (r1 == null) goto L6;
        r1.a(r3);
        return;
    }
}
