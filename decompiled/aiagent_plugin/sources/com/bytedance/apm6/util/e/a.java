package com.bytedance.apm6.util.e;

/* JADX INFO: compiled from: AsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5465c;

    public a() {
        this(0);
    }

    public a(long r3) {
        this(r3, 0);
    }

    public a(long r1, long r3) {
        this.f5463a = r1;
        this.f5465c = r3;
        if (r3 <= 0) goto L6;
        this.f5464b = true;
        return;
    }

    public long a() {
        return this.f5463a;
    }

    public final boolean b() {
        return this.f5464b;
    }

    public final long c() {
        return this.f5465c;
    }

    public void a(long r1, long r3) {
        this.f5463a = r1;
        this.f5465c = r3;
        if (r3 <= 0) goto L6;
        this.f5464b = true;
        return;
    }
}
