package org.c.a.j;

/* JADX INFO: compiled from: SimpleKey.java */
/* JADX INFO: loaded from: classes5.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f40494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f40495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f40496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f40497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f40498e;
    private org.c.a.c.a f;

    public e(int r1, boolean r2, int r3, int r4, int r5, org.c.a.c.a r6) {
        this.f40494a = r1;
        this.f40495b = r2;
        this.f40496c = r3;
        this.f40497d = r4;
        this.f40498e = r5;
        this.f = r6;
    }

    public int a() {
        return this.f40494a;
    }

    public int b() {
        return this.f40498e;
    }

    public org.c.a.c.a c() {
        return this.f;
    }

    public int d() {
        return this.f40496c;
    }

    public int e() {
        return this.f40497d;
    }

    public boolean f() {
        return this.f40495b;
    }

    public String toString() {
        return "SimpleKey - tokenNumber=" + this.f40494a + " required=" + this.f40495b + " index=" + this.f40496c + " line=" + this.f40497d + " column=" + this.f40498e;
    }
}
