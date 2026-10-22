package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtReporting.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private final String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21621e;
    private final String f;
    private final long g;
    private final long h;
    private final long i;
    private final Long j;
    private final Long k;
    private final Long l;
    private final Long m;
    private final long n;
    private final long o;
    private final long p;
    private final long q;
    private final long r;
    private final long s;
    private final long t;
    private final long u;
    private final long v;
    private final long w;
    private final long x;
    private final boolean y;
    private final boolean z;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, w.class) == true) goto L8;
        return false;
    L8:
        w r10 = (w) ZeusTransformUtils.preCheckCast(r9, w.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21617a, r10.f21617a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21618b, r10.f21618b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f21619c, r10.f21619c) == true) goto L18;
        return false;
    L18:
        if (this.f21620d == r10.f21620d) goto L21;
        return false;
    L21:
        if (this.f21621e == r10.f21621e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (this.o == r10.o) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (this.s == r10.s) goto L66;
        return false;
    L66:
        if (this.t == r10.t) goto L69;
        return false;
    L69:
        if (this.u == r10.u) goto L72;
        return false;
    L72:
        if (this.v == r10.v) goto L75;
        return false;
    L75:
        if (this.w == r10.w) goto L78;
        return false;
    L78:
        if (this.x == r10.x) goto L81;
        return false;
    L81:
        if (this.y == r10.y) goto L84;
        return false;
    L84:
        if (this.z == r10.z) goto L87;
        return false;
    L87:
        if (d.h.b.o.a(this.A, r10.A) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((this.f21617a.hashCode() * 31) + this.f21618b.hashCode()) * 31) + this.f21619c.hashCode()) * 31) + Integer.hashCode(this.f21620d)) * 31) + Integer.hashCode(this.f21621e)) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31;
        Long r1 = this.j;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.l;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.m;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((((((((((((((((((((((((((((r10 + r2) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + Long.hashCode(this.p)) * 31) + Long.hashCode(this.q)) * 31) + Long.hashCode(this.r)) * 31) + Long.hashCode(this.s)) * 31) + Long.hashCode(this.t)) * 31) + Long.hashCode(this.u)) * 31) + Long.hashCode(this.v)) * 31) + Long.hashCode(this.w)) * 31) + Long.hashCode(this.x)) * 31) + Boolean.hashCode(this.y)) * 31) + Boolean.hashCode(this.z)) * 31) + this.A.hashCode();
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("VirtDiagnosticsReport(backendType=").append(this.f21617a).append(", trigger=").append(this.f21618b).append(", batchId=").append(this.f21619c).append(", chunkIndex=").append(this.f21620d).append(", chunkCount=").append(this.f21621e).append(", sourceType=").append(this.f).append(", bytesRead=").append(this.g).append(", lineCount=").append(this.h).append(", malformedLineCount=").append(this.i).append(", firstTimestampMs=").append(this.j).append(", lastTimestampMs=").append(this.k).append(", firstMonotonicNs=");
        r0.append(this.l).append(", lastMonotonicNs=").append(this.m).append(", infoCount=").append(this.n).append(", warningCount=").append(this.o).append(", errorCount=").append(this.p).append(", runtimeEventCount=").append(this.q).append(", shellEventCount=").append(this.r).append(", processEventCount=").append(this.s).append(", fileEventCount=").append(this.t).append(", otherEventCount=").append(this.u).append(", failureEventCount=").append(this.v).append(", timeoutEventCount=").append(this.w);
        r0.append(", killEventCount=").append(this.x).append(", cursorReset=").append(this.y).append(", rotated=").append(this.z).append(", clearStatus=").append(this.A).append(')');
        return r0.toString();
    }

    public w(String r8, String r9, String r10, int r11, int r12, String r13, long r14, long r16, long r18, Long r20, Long r21, Long r22, Long r23, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, boolean r46, boolean r47, String r48) {
        d.h.b.o.e(r8, "backendType");
        d.h.b.o.e(r9, "trigger");
        d.h.b.o.e(r10, "batchId");
        d.h.b.o.e(r13, "sourceType");
        d.h.b.o.e(r48, "clearStatus");
        this.f21617a = r8;
        this.f21618b = r9;
        this.f21619c = r10;
        this.f21620d = r11;
        this.f21621e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r16;
        this.i = r18;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r26;
        this.p = r28;
        this.q = r30;
        this.r = r32;
        this.s = r34;
        this.t = r36;
        this.u = r38;
        this.v = r40;
        this.w = r42;
        this.x = r44;
        this.y = r46;
        this.z = r47;
        this.A = r48;
    }

    public /* synthetic */ w(String r46, String r47, String r48, int r49, int r50, String r51, long r52, long r54, long r56, Long r58, Long r59, Long r60, Long r61, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, boolean r84, boolean r85, String r86, int r87, d.h.b.h r88) {
        if ((r87 & 512) == 0) goto L5;
        Long r16 = null;
    L7:
        if ((r87 & 1024) == 0) goto L9;
        Long r17 = null;
    L11:
        if ((r87 & 2048) == 0) goto L13;
        Long r18 = null;
    L15:
        if ((r87 & 4096) == 0) goto L17;
        Long r19 = null;
    L19:
        if ((r87 & 8192) == 0) goto L21;
        long r20 = 0;
    L23:
        if ((r87 & 16384) == 0) goto L25;
        long r22 = 0;
    L27:
        if ((32768 & r87) == 0) goto L29;
        long r24 = 0;
    L31:
        if ((65536 & r87) == 0) goto L33;
        long r26 = 0;
    L35:
        if ((131072 & r87) == 0) goto L37;
        long r28 = 0;
    L39:
        if ((262144 & r87) == 0) goto L41;
        long r30 = 0;
    L43:
        if ((524288 & r87) == 0) goto L45;
        long r32 = 0;
    L47:
        if ((1048576 & r87) == 0) goto L49;
        long r34 = 0;
    L51:
        if ((2097152 & r87) == 0) goto L53;
        long r36 = 0;
    L55:
        if ((4194304 & r87) == 0) goto L57;
        long r38 = 0;
    L59:
        if ((8388608 & r87) == 0) goto L61;
        long r40 = 0;
    L63:
        if ((16777216 & r87) == 0) goto L65;
        boolean r42 = false;
    L67:
        if ((33554432 & r87) == 0) goto L69;
        boolean r43 = false;
    L71:
        if ((r87 & 67108864) == 0) goto L73;
        String r44 = "pending";
    L74:
        this(r46, r47, r48, r49, r50, r51, r52, r54, r56, r16, r17, r18, r19, r20, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r43, r44);
        return;
    L73:
        r44 = r86;
        goto L74
    L69:
        r43 = r85;
        goto L71
    L65:
        r42 = r84;
        goto L67
    L61:
        r40 = r82;
        goto L63
    L57:
        r38 = r80;
        goto L59
    L53:
        r36 = r78;
        goto L55
    L49:
        r34 = r76;
        goto L51
    L45:
        r32 = r74;
        goto L47
    L41:
        r30 = r72;
        goto L43
    L37:
        r28 = r70;
        goto L39
    L33:
        r26 = r68;
        goto L35
    L29:
        r24 = r66;
        goto L31
    L25:
        r22 = r64;
        goto L27
    L21:
        r20 = r62;
        goto L23
    L17:
        r19 = r61;
        goto L19
    L13:
        r18 = r60;
        goto L15
    L9:
        r17 = r59;
        goto L11
    L5:
        r16 = r58;
        goto L7
    }

    public final String a() {
        return this.f21617a;
    }

    public final String b() {
        return this.f21618b;
    }

    public final String c() {
        return this.f21619c;
    }

    public final int d() {
        return this.f21620d;
    }

    public final int e() {
        return this.f21621e;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final long i() {
        return this.i;
    }

    public final Long j() {
        return this.j;
    }

    public final Long k() {
        return this.k;
    }

    public final Long l() {
        return this.l;
    }

    public final Long m() {
        return this.m;
    }

    public final long n() {
        return this.n;
    }

    public final long o() {
        return this.o;
    }

    public final long p() {
        return this.p;
    }

    public final long q() {
        return this.q;
    }

    public final long r() {
        return this.r;
    }

    public final long s() {
        return this.s;
    }

    public final long t() {
        return this.t;
    }

    public final long u() {
        return this.u;
    }

    public final long v() {
        return this.v;
    }

    public final long w() {
        return this.w;
    }

    public final long x() {
        return this.x;
    }

    public final boolean y() {
        return this.y;
    }

    public final boolean z() {
        return this.z;
    }

    public final String A() {
        return this.A;
    }
}
