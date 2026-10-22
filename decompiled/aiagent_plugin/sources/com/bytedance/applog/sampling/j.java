package com.bytedance.applog.sampling;

/* JADX INFO: compiled from: SamplingUser.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5985e;

    public j(String r1, String r2) {
        this.f5981a = r1;
        this.f5982b = r2;
    }

    public j(String r1, String r2, String r3) {
        this(r1, r2);
        this.f5985e = r3;
    }

    public void a(String r1) {
        this.f5983c = r1;
    }

    public void b(String r1) {
        this.f5984d = r1;
    }

    @Override // com.bytedance.applog.sampling.b
    public String a() {
        return this.f5981a;
    }

    @Override // com.bytedance.applog.sampling.b
    public String b() {
        return this.f5982b;
    }

    @Override // com.bytedance.applog.sampling.b
    public String c() {
        return this.f5983c;
    }

    @Override // com.bytedance.applog.sampling.b
    public String d() {
        return this.f5984d;
    }
}
