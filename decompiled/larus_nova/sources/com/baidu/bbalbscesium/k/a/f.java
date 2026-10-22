package com.baidu.bbalbscesium.k.a;

import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes39.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f30342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f30343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte[] f30344c;

    public f(b r100) {
        this.f30342a = r100;
        this.f30343b = r100.a();
    }

    public final int a() {
        return this.f30343b;
    }

    public abstract void a(boolean r100, String r101, byte[] r102, byte[] r103) throws InvalidKeyException;

    public abstract void a(byte[] r100, int r101, int r102, byte[] r103, int r104);

    public final b b() {
        return this.f30342a;
    }

    public void b(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        a(r100, r101, r102, r103, r104);
    }

    public abstract String c();

    public abstract void c(byte[] r100, int r101, int r102, byte[] r103, int r104);

    public void d(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        c(r100, r101, r102, r103, r104);
    }

    public final byte[] d() {
        return this.f30344c;
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
