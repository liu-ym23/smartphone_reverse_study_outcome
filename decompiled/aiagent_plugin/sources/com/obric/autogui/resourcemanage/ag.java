package com.obric.autogui.resourcemanage;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceInternals.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f30606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f30607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f30608e;
    private final String f;
    private long g;
    private long h;
    private String i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private Boolean n;
    private long o;
    private Boolean p;
    private long q;
    private Boolean r;
    private int s;
    private Boolean t;
    private long u;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ag.class) == true) goto L8;
        return false;
    L8:
        ag r6 = (ag) ZeusTransformUtils.preCheckCast(r5, ag.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30604a, r6.f30604a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f30605b, r6.f30605b) == true) goto L15;
        return false;
    L15:
        if (this.f30606c == r6.f30606c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f30607d, r6.f30607d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f30608e, r6.f30608e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f30604a.hashCode() * 31) + this.f30605b.hashCode()) * 31) + Integer.hashCode(this.f30606c)) * 31) + this.f30607d.hashCode()) * 31) + this.f30608e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ZeusDownloadMetrics(uniqueKey=" + this.f30604a + ", pkg=" + this.f30605b + ", versionCode=" + this.f30606c + ", md5=" + this.f30607d + ", resourceKey=" + this.f30608e + ", scene=" + this.f + ')';
    }

    public ag(String r2, String r3, int r4, String r5, String r6, String r7) {
        d.h.b.o.e(r2, "uniqueKey");
        d.h.b.o.e(r3, "pkg");
        d.h.b.o.e(r5, "md5");
        d.h.b.o.e(r6, "resourceKey");
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SCENE);
        this.f30604a = r2;
        this.f30605b = r3;
        this.f30606c = r4;
        this.f30607d = r5;
        this.f30608e = r6;
        this.f = r7;
        this.h = -1;
        this.l = -1;
        this.m = -1;
        this.o = -1;
        this.q = -1;
    }

    public final String a() {
        return this.f30605b;
    }

    public final int b() {
        return this.f30606c;
    }

    public final String c() {
        return this.f30607d;
    }

    public final String d() {
        return this.f30608e;
    }

    public final String e() {
        return this.f;
    }

    public final void a(long r1) {
        this.g = r1;
    }

    public final long f() {
        return this.g;
    }

    public final void b(long r1) {
        this.h = r1;
    }

    public final long g() {
        return this.h;
    }

    public final void a(String r1) {
        this.i = r1;
    }

    public final String h() {
        return this.i;
    }

    public final void a(boolean r1) {
        this.j = r1;
    }

    public final boolean i() {
        return this.j;
    }

    public final void c(long r1) {
        this.k = r1;
    }

    public final long j() {
        return this.k;
    }

    public final void d(long r1) {
        this.l = r1;
    }

    public final long k() {
        return this.l;
    }

    public final void e(long r1) {
        this.m = r1;
    }

    public final long l() {
        return this.m;
    }

    public final void a(Boolean r1) {
        this.n = r1;
    }

    public final Boolean m() {
        return this.n;
    }

    public final void f(long r1) {
        this.o = r1;
    }

    public final long n() {
        return this.o;
    }

    public final void b(Boolean r1) {
        this.p = r1;
    }

    public final Boolean o() {
        return this.p;
    }

    public final void g(long r1) {
        this.q = r1;
    }

    public final long p() {
        return this.q;
    }

    public final void c(Boolean r1) {
        this.r = r1;
    }

    public final Boolean q() {
        return this.r;
    }

    public final void a(int r1) {
        this.s = r1;
    }

    public final int r() {
        return this.s;
    }

    public final void d(Boolean r1) {
        this.t = r1;
    }

    public final Boolean s() {
        return this.t;
    }

    public final void h(long r1) {
        this.u = r1;
    }

    public final long t() {
        return this.u;
    }
}
