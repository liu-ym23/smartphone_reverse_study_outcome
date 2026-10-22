package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtReporting.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f21610e;
    private final Integer f;
    private final String g;
    private final boolean h;
    private final String i;
    private final String j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final long n;
    private final long o;
    private final long p;
    private final long q;
    private final long r;
    private final long s;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, t.class) == true) goto L8;
        return false;
    L8:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r9, t.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21606a, r10.f21606a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21607b, r10.f21607b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f21608c, r10.f21608c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f21609d, r10.f21609d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f21610e, r10.f21610e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L48;
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
        if (this.s == r10.s) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        int r0 = this.f21606a.hashCode() * 31;
        String r1 = this.f21607b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.f21608c.hashCode()) * 31;
        String r5 = this.f21609d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.f21610e.hashCode()) * 31;
        Integer r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((((((((((((((((((((((((r10 + r2) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + Integer.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + Long.hashCode(this.n)) * 31) + Long.hashCode(this.o)) * 31) + Long.hashCode(this.p)) * 31) + Long.hashCode(this.q)) * 31) + Long.hashCode(this.r)) * 31) + Long.hashCode(this.s);
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
        r0.append("ShellReport(shellType=").append(this.f21606a).append(", scene=").append(this.f21607b).append(", backendType=").append(this.f21608c).append(", executionId=").append(this.f21609d).append(", result=").append(this.f21610e).append(", exitCode=").append(this.f).append(", returnReason=").append(this.g).append(", enteredShell=").append(this.h).append(", primaryCommand=").append(this.i).append(", commandFamily=").append(this.j).append(", commandCount=").append(this.k).append(", completed=");
        r0.append(this.l).append(", killed=").append(this.m).append(", durationMs=").append(this.n).append(", preprocessDurationMs=").append(this.o).append(", backendDurationMs=").append(this.p).append(", outputDurationMs=").append(this.q).append(", stdoutChars=").append(this.r).append(", stderrChars=").append(this.s).append(')');
        return r0.toString();
    }

    public t(String r8, String r9, String r10, String r11, String r12, Integer r13, String r14, boolean r15, String r16, String r17, int r18, boolean r19, boolean r20, long r21, long r23, long r25, long r27, long r29, long r31) {
        d.h.b.o.e(r8, "shellType");
        d.h.b.o.e(r10, "backendType");
        d.h.b.o.e(r12, "result");
        d.h.b.o.e(r16, "primaryCommand");
        d.h.b.o.e(r17, "commandFamily");
        this.f21606a = r8;
        this.f21607b = r9;
        this.f21608c = r10;
        this.f21609d = r11;
        this.f21610e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r23;
        this.p = r25;
        this.q = r27;
        this.r = r29;
        this.s = r31;
    }

    public /* synthetic */ t(String r30, String r31, String r32, String r33, String r34, Integer r35, String r36, boolean r37, String r38, String r39, int r40, boolean r41, boolean r42, long r43, long r45, long r47, long r49, long r51, long r53, int r55, d.h.b.h r56) {
        if ((r55 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r55 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r55 & 32) == 0) goto L13;
        Integer r9 = null;
    L15:
        if ((r55 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r55 & 128) == 0) goto L21;
        boolean r11 = true;
    L23:
        if ((r55 & 256) == 0) goto L25;
        String r12 = "other";
    L27:
        if ((r55 & 512) == 0) goto L29;
        String r13 = "other";
    L31:
        if ((r55 & 1024) == 0) goto L33;
        int r14 = 0;
    L35:
        if ((131072 & r55) == 0) goto L37;
        long r25 = 0;
    L39:
        if ((r55 & 262144) == 0) goto L41;
        long r27 = 0;
    L42:
        this(r30, r5, r32, r7, r34, r9, r10, r11, r12, r13, r14, r41, r42, r43, r45, r47, r49, r25, r27);
        return;
    L41:
        r27 = r53;
        goto L42
    L37:
        r25 = r51;
        goto L39
    L33:
        r14 = r40;
        goto L35
    L29:
        r13 = r39;
        goto L31
    L25:
        r12 = r38;
        goto L27
    L21:
        r11 = r37;
        goto L23
    L17:
        r10 = r36;
        goto L19
    L13:
        r9 = r35;
        goto L15
    L9:
        r7 = r33;
        goto L11
    L5:
        r5 = r31;
        goto L7
    }

    public final String a() {
        return this.f21606a;
    }

    public final String b() {
        return this.f21607b;
    }

    public final String c() {
        return this.f21608c;
    }

    public final String d() {
        return this.f21609d;
    }

    public final String e() {
        return this.f21610e;
    }

    public final Integer f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }

    public final boolean m() {
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
}
