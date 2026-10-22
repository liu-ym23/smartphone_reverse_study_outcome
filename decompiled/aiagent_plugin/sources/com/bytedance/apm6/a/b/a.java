package com.bytedance.apm6.a.b;

/* JADX INFO: compiled from: MemoryConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5031e;
    private boolean f;

    public a(long r3, double r5, boolean r7, boolean r8, boolean r9, boolean r10) {
        if (r3 > 0) goto L5;
        this.f5027a = 120;
    L6:
        this.f5028b = r5;
        this.f = r10;
        this.f5029c = r7;
        this.f5030d = r8;
        this.f5031e = r9;
        return;
    L5:
        this.f5027a = r3;
        goto L6
    }

    public boolean a() {
        return this.f;
    }

    public double b() {
        double r0 = this.f5028b;
        if (r0 <= 0.5d) goto L5;
        return r0;
    L5:
        return 0.8d;
    }

    public long c() {
        return this.f5027a;
    }

    public boolean d() {
        return this.f5029c;
    }

    public boolean e() {
        return this.f5030d;
    }

    public boolean f() {
        return this.f5031e;
    }

    public void a(boolean r1) {
        this.f5030d = r1;
    }

    public void b(boolean r1) {
        this.f5029c = r1;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.f5027a + ", memoryTopCheckThreshold=" + this.f5028b + ", isStopWhenBackground=" + this.f5029c + ", isRealTimeMemEnable=" + this.f5030d + ", isUploadEnable=" + this.f5031e + ", isApm6SampleEnable=" + this.f + '}';
    }
}
