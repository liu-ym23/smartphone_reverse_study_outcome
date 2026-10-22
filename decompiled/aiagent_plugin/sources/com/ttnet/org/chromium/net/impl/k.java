package com.ttnet.org.chromium.net.impl;

import java.util.Date;

/* JADX INFO: compiled from: CronetMetrics.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends com.ttnet.org.chromium.net.w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38146a = true;
    private Integer A;
    private String B;
    private boolean C;
    private boolean D;
    private int E;
    private String F;
    private long G;
    private long H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private long f38147J;
    private long K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f38149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f38150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f38151e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final long l;
    private final long m;
    private final long n;
    private final boolean o;
    private final Long p;
    private final Long q;
    private final Long r;
    private final Long s;
    private final String t;
    private final Long u;
    private final Long v;
    private final String w;
    private final String x;
    private Long y;
    private Long z;

    static {
    }

    private static boolean a(long r3, long r5) {
        if (r5 < r3) goto L7;
        if (r3 == (-1)) goto L7;
    L8:
        return true;
    L7:
        if (r5 == (-1)) goto L8;
        return false;
    }

    private static Date a(long r2) {
        if (r2 != (-1)) goto L5;
        return null;
    L5:
        return new Date(r2);
    }

    public k(long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, boolean r40, long r41, long r43, String r45, long r46, long r48, String r50, String r51, long r52, long r54, int r56, String r57, boolean r58, boolean r59, int r60) {
        this.G = 0;
        this.H = -1;
        this.I = -1;
        this.f38147J = -1;
        this.K = -1;
        boolean r11 = f38146a;
        if (r11 == false) goto L5;
    L9:
        if (r11 == false) goto L11;
    L15:
        if (r11 == false) goto L17;
    L21:
        if (r11 == false) goto L23;
    L27:
        if (r11 == false) goto L29;
    L33:
        if (r11 == false) goto L35;
    L39:
        this.f38148b = r14;
        this.f38149c = r16;
        this.f38150d = r18;
        this.f38151e = r20;
        this.f = r22;
        this.g = r24;
        this.h = r26;
        this.i = r28;
        this.j = r30;
        this.k = r32;
        this.l = r34;
        this.m = r36;
        this.n = r38;
        this.o = r40;
        this.r = Long.valueOf(r41);
        this.s = Long.valueOf(r43);
        this.y = Long.valueOf(r52);
        this.z = Long.valueOf(r54);
        this.A = Integer.valueOf(r56);
        this.B = r57;
        this.C = r58;
        this.D = r59;
        this.E = r60;
        this.t = r45;
        this.u = Long.valueOf(r46);
        this.v = Long.valueOf(r48);
        if (r36 != (-1)) goto L42;
    L44:
        this.p = null;
    L46:
        if (r14 != (-1)) goto L48;
    L50:
        this.q = null;
    L51:
        this.w = r50;
        this.x = r51;
        return;
    L48:
        if (r38 == (-1)) goto L50;
        this.q = Long.valueOf(r38 - r14);
        goto L51
    L42:
        if (r30 == (-1)) goto L44;
        this.p = Long.valueOf(r36 - r30);
        goto L46
    L35:
        if (r38 >= r36) goto L39;
        throw new AssertionError();
    L29:
        if (a(r32, r34) == true) goto L33;
        throw new AssertionError();
    L23:
        if (a(r28, r30) == true) goto L27;
        throw new AssertionError();
    L17:
        if (a(r24, r26) == true) goto L21;
        throw new AssertionError();
    L11:
        if (a(r20, r22) == true) goto L15;
        throw new AssertionError();
    L5:
        if (a(r16, r18) == true) goto L9;
        throw new AssertionError();
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date a() {
        return a(this.f38148b);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date b() {
        return a(this.f38149c);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date c() {
        return a(this.f38150d);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date d() {
        return a(this.f38151e);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date e() {
        return a(this.f);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date f() {
        return a(this.g);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date g() {
        return a(this.h);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date h() {
        return a(this.i);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date i() {
        return a(this.j);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date j() {
        return a(this.k);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date k() {
        return a(this.l);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date l() {
        return a(this.m);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Date m() {
        return a(this.n);
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public boolean n() {
        return this.o;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long o() {
        return this.p;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long p() {
        return this.q;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long q() {
        return this.r;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public String r() {
        return this.t;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long s() {
        return this.u;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long t() {
        return this.v;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public String u() {
        return this.w;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public String v() {
        return this.x;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long w() {
        return this.y;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long x() {
        return this.z;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Integer y() {
        return this.A;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public String z() {
        return this.B;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public boolean A() {
        return this.C;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public boolean B() {
        return this.D;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public int C() {
        return this.E;
    }

    public void a(String r1) {
        this.F = r1;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public String D() {
        return this.F;
    }

    public void a(long r1, long r3, long r5, long r7, long r9) {
        this.G = r1;
        this.H = r3;
        this.I = r5;
        this.f38147J = r7;
        this.K = r9;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public long E() {
        return this.G;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public long F() {
        return this.f38147J;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public long G() {
        return this.K;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public long H() {
        return this.H;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public long I() {
        return this.I;
    }

    @Override // com.ttnet.org.chromium.net.w.b
    public Long J() {
        return this.s;
    }
}
