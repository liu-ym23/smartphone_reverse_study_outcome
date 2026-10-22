package com.bytedance.common.wschannel.e;

/* JADX INFO: compiled from: WsAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6952c;

    public e() {
        this(0);
    }

    public e(long r3) {
        this(r3, 0);
    }

    public e(long r1, long r3) {
        this.f6950a = r1;
        this.f6952c = r3;
        if (r3 <= 0) goto L6;
        this.f6951b = true;
        return;
    }

    public final long a() {
        return this.f6950a;
    }

    public final boolean b() {
        return this.f6951b;
    }

    public final long c() {
        return this.f6952c;
    }
}
