package com.bytedance.apm6.fd.a;

/* JADX INFO: compiled from: FdConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5328c;

    public a(long r1, long r3, boolean r5) {
        this.f5326a = r1;
        this.f5327b = r3;
        this.f5328c = r5;
    }

    public long a() {
        return this.f5326a;
    }

    public long b() {
        return this.f5327b;
    }

    public boolean c() {
        return this.f5328c;
    }

    public String toString() {
        return "FdConfig{fdCountThreshold=" + this.f5326a + ", collectIntervalMs=" + this.f5327b + ", isSampled=" + this.f5328c + '}';
    }
}
