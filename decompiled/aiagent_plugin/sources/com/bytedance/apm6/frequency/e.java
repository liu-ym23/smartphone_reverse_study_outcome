package com.bytedance.apm6.frequency;

/* JADX INFO: compiled from: RecordItem.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5370e;

    public e() {
        this.f5370e = false;
    }

    public e(String r2, long r3) {
        this.f5370e = false;
        this.f5366a = r2;
        this.f5367b = r3;
    }

    public String a() {
        return this.f5366a;
    }

    public long b() {
        return this.f5367b;
    }

    public String c() {
        return this.f5368c;
    }

    public String d() {
        return this.f5369d;
    }

    public void a(boolean r1) {
        this.f5370e = r1;
    }
}
