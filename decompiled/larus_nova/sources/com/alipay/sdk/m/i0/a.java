package com.alipay.sdk.m.i0;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25340d;

    public a(String r100) {
        this.f25339c = r100;
    }

    public void a(int r100) {
        this.f25340d = r100;
    }

    public void a(long r100) {
        this.f25337a = r100;
    }

    public void a(String r100) {
        this.f25338b = r100;
    }

    public boolean a() {
        if (this.f25337a <= System.currentTimeMillis()) goto L6;
        return true;
    L6:
        return false;
    }

    public void b() {
        this.f25337a = 0;
    }
}
