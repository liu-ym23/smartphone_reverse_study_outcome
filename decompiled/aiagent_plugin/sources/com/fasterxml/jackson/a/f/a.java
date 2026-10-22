package com.fasterxml.jackson.a.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ByteQuadsCanonicalizer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f12045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicReference<C0266a> f12046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f12047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f12048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12049e;
    protected int[] f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected boolean l;

    /* JADX INFO: renamed from: com.fasterxml.jackson.a.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteQuadsCanonicalizer.java */
    private static final class C0266a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f12053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String[] f12054e;
        public final int f;
        public final int g;

        public C0266a(int r1, int r2, int r3, int[] r4, String[] r5, int r6, int r7) {
            this.f12050a = r1;
            this.f12051b = r2;
            this.f12052c = r3;
            this.f12053d = r4;
            this.f12054e = r5;
            this.f = r6;
            this.g = r7;
        }

        public static C0266a a(int r9) {
            int r7 = r9 << 3;
            return new C0266a(r9, 0, a.b(r9), new int[r7], new String[r9 << 1], r7 - r9, r7);
        }
    }

    static int b(int r1) {
        int r2 = r1 >> 2;
        if (r2 >= 64) goto L7;
        return 4;
    L7:
        if (r2 > 256) goto L11;
        return 5;
    L11:
        if (r2 > 1024) goto L14;
        return 6;
    L14:
        return 7;
    }

    private a(int r3, int r4) {
        this.f12045a = null;
        this.j = 0;
        this.l = true;
        this.f12047c = r4;
        this.f12048d = false;
        this.f12049e = true;
        int r5 = 16;
        if (r3 >= 16) goto L6;
    L4:
        r3 = r5;
    L9:
        this.f12046b = new AtomicReference(C0266a.a(r3));
        return;
    L6:
        if (((r3 - 1) & r3) == 0) goto L9;
    L7:
        if (r5 >= r3) goto L4;
        r5 = r5 + r5;
        goto L7
    }

    public static a a() {
        long r0 = System.currentTimeMillis();
        return a((((int) r0) + ((int) (r0 >>> 32))) | 1);
    }

    public static a a(int r2) {
        return new a(64, r2);
    }

    public int b() {
        int r0 = this.h;
        int r1 = 0;
        int r2 = 3;
    L3:
        if (r2 >= r0) goto L8;
        if (this.f[r2] == 0) goto L7;
        r1 = r1 + 1;
    L7:
        r2 = r2 + 4;
        goto L3
    L8:
        return r1;
    }

    public int c() {
        int r0 = this.h + 3;
        int r1 = this.i;
        int r2 = 0;
    L3:
        if (r0 >= r1) goto L8;
        if (this.f[r0] == 0) goto L7;
        r2 = r2 + 1;
    L7:
        r0 = r0 + 4;
        goto L3
    L8:
        return r2;
    }

    public int d() {
        int r0 = this.i + 3;
        int r1 = this.g + r0;
        int r2 = 0;
    L3:
        if (r0 >= r1) goto L8;
        if (this.f[r0] == 0) goto L7;
        r2 = r2 + 1;
    L7:
        r0 = r0 + 4;
        goto L3
    L8:
        return r2;
    }

    public int e() {
        return (this.k - g()) >> 2;
    }

    public int f() {
        int r1 = 3;
        int r0 = this.g << 3;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (this.f[r1] == 0) goto L7;
        r2 = r2 + 1;
    L7:
        r1 = r1 + 4;
        goto L3
    L8:
        return r2;
    }

    public String toString() {
        int r0 = b();
        int r1 = c();
        int r2 = d();
        int r3 = e();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{getClass().getName(), Integer.valueOf(this.j), Integer.valueOf(this.g), Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(((r0 + r1) + r2) + r3), Integer.valueOf(f())});
    }

    private final int g() {
        int r1 = this.g;
        return (r1 << 3) - r1;
    }
}
