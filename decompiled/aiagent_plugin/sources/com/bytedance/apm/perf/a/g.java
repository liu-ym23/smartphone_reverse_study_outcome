package com.bytedance.apm.perf.a;

import android.os.Build;

/* JADX INFO: compiled from: TrafficStatisticWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f4783a;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.a.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrafficStatisticWrapper.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: TrafficStatisticWrapper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f4784a;

        static /* synthetic */ g a() {
            return f4784a;
        }

        static {
            f4784a = new g(null);
        }
    }

    /* synthetic */ g(AnonymousClass1 r1) {
        this();
    }

    private g() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.f4783a = new d();
    L6:
        this.f4783a.a();
        return;
    L5:
        this.f4783a = new e();
        goto L6
    }

    public static g a() {
        return a.a();
    }

    public long b() {
        return this.f4783a.b();
    }

    public long c() {
        return this.f4783a.c();
    }

    public long d() {
        return this.f4783a.d();
    }

    public long e() {
        return this.f4783a.e();
    }

    public long f() {
        return this.f4783a.f();
    }

    public long g() {
        return this.f4783a.g();
    }

    public long h() {
        return this.f4783a.h();
    }

    public long i() {
        return this.f4783a.i();
    }

    public long j() {
        return this.f4783a.j();
    }

    public long k() {
        return this.f4783a.k();
    }

    public long l() {
        return this.f4783a.l();
    }

    void a(boolean r1) {
        this.f4783a.a(r1);
    }
}
