package com.alipay.sdk.m.i0;

/* JADX INFO: loaded from: classes28.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25347c;

    public d(String r100, int r101) {
        this.f25345a = r100;
        this.f25346b = r101;
        this.f25347c = System.currentTimeMillis() + 86400000;
    }

    public String toString() {
        return "ValueData{value='" + this.f25345a + "', code=" + this.f25346b + ", expired=" + this.f25347c + '}';
    }
}
