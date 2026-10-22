package com.bytedance.apm.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: ThreadTimeItem.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5001e;
    public long f;
    public long g;
    public long h;

    public v(int r1, String r2, long r3) {
        this.f4997a = r1;
        this.f4998b = r2;
        this.f4999c = r3;
        this.f5000d = 0.0f;
    }

    public v(int r1, String r2, long r3, long r5, long r7) {
        this.f4997a = r1;
        this.f4998b = r2;
        this.f5001e = r3;
        this.f = r5;
        this.f4999c = r3 + r5;
        this.g = r7;
        long r4 = ((SystemClock.elapsedRealtime() * b.a(100)) / 1000) - r7;
        this.h = r4;
        this.f5000d = (this.f4999c * 1.0f) / r4;
    }

    public void a(long r1) {
        this.f4999c = r1;
    }
}
