package com.bytedance.retrofit2.e;

import java.io.OutputStream;

/* JADX INFO: compiled from: AbsTypedOutput.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f9506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile String f9507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile String f9508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile int f9509d;

    public abstract f.b a(String r1, String r2, boolean r3);

    @Override // com.bytedance.retrofit2.e.j
    public String a() {
        return null;
    }

    @Override // com.bytedance.retrofit2.e.j
    public void a(OutputStream r1) {
    }

    @Override // com.bytedance.retrofit2.e.j
    public String b() {
        return null;
    }

    @Override // com.bytedance.retrofit2.e.j
    public long c() {
        return 0;
    }

    public abstract boolean e();

    public a() {
    }

    public boolean g() {
        return this.f9506a;
    }

    public String f() {
        return this.f9507b;
    }

    public String h() {
        return this.f9508c;
    }

    @Override // com.bytedance.retrofit2.e.j
    public String d() {
        return this.f9508c;
    }
}
