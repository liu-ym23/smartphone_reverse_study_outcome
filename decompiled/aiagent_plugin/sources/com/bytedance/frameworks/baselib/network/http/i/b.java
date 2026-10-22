package com.bytedance.frameworks.baselib.network.http.i;

/* JADX INFO: compiled from: AsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8369d;

    public b() {
        this(0);
    }

    public b(long r7) {
        this(r7, 0, "");
    }

    public b(long r7, String r9) {
        this(r7, 0, r9);
    }

    public b(long r1, long r3, String r5) {
        this.f8366a = r1;
        this.f8368c = r3;
        this.f8369d = r5;
        if (r3 <= 0) goto L6;
        this.f8367b = true;
        return;
    }

    public final long a() {
        return this.f8366a;
    }

    public final boolean b() {
        return this.f8367b;
    }

    public final long c() {
        return this.f8368c;
    }

    public final String d() {
        return this.f8369d;
    }
}
