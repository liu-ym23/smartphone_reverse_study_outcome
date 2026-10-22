package com.bytedance.apm6.cpu.b;

/* JADX INFO: compiled from: CpuConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5227e;
    private long f;
    private long g;

    public a() {
        this.f5223a = false;
        this.f5224b = false;
        this.f5225c = 120;
        this.f5226d = 600;
        this.f5227e = 1200;
        this.f = 120;
        this.g = 600;
    }

    public long a() {
        return this.f5225c * 1000;
    }

    public void a(long r1) {
        this.f5225c = r1;
    }

    public long b() {
        return this.f5226d * 1000;
    }

    public void b(long r1) {
        this.f5226d = r1;
    }

    public long c() {
        return this.f5227e * 1000;
    }

    public void c(long r1) {
        this.f5227e = r1;
    }

    public boolean d() {
        return this.f5223a;
    }

    public void a(boolean r1) {
        this.f5223a = r1;
    }

    public long e() {
        return this.g * 1000;
    }

    public void d(long r1) {
        this.g = r1;
    }

    public long f() {
        return this.f * 1000;
    }

    public void e(long r1) {
        this.f = r1;
    }

    public boolean g() {
        return this.f5224b;
    }

    public void b(boolean r1) {
        this.f5224b = r1;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.f5223a + ", mCollectAllProcess=" + this.f5224b + ", mFrontCollectInterval=" + this.f5225c + ", mBackCollectInterval=" + this.f5226d + ", mMonitorInterval=" + this.f5227e + ", mFrontThreadCollectInterval=" + this.f + ", mBackThreadCollectInterval=" + this.g + '}';
    }
}
