package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillMetadataStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19740e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final int o;
    private final boolean p;
    private final boolean q;
    private final Long r;
    private final Long s;
    private final Long t;
    private final hk u;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, de.class) == true) goto L8;
        return false;
    L8:
        de r6 = (de) ZeusTransformUtils.preCheckCast(r5, de.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19736a, r6.f19736a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19737b, r6.f19737b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19738c, r6.f19738c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19739d, r6.f19739d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19740e, r6.f19740e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (d.h.b.o.a(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (d.h.b.o.a(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (d.h.b.o.a(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (d.h.b.o.a(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (d.h.b.o.a(this.u, r6.u) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f19736a.hashCode() * 31) + this.f19737b.hashCode()) * 31) + this.f19738c.hashCode()) * 31) + this.f19739d.hashCode()) * 31) + this.f19740e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.k;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.l;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.m;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.n;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (((((((r22 + r24) * 31) + Integer.hashCode(this.o)) * 31) + Boolean.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31;
        Long r26 = this.r;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Long r29 = this.s;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        Long r32 = this.t;
        if (r32 == null) goto L47;
        r2 = r32.hashCode();
    L47:
        return ((r31 + r2) * 31) + this.u.hashCode();
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        r0.append("SkillMetadataEntity(slug=").append(this.f19736a).append(", displayName=").append(this.f19737b).append(", shortDescription=").append(this.f19738c).append(", storeDescription=").append(this.f19739d).append(", coverUrl=").append(this.f19740e).append(", sourceType=").append(this.f).append(", sourceChannel=").append(this.g).append(", sourceImportKind=").append(this.h).append(", sourceId=").append(this.i).append(", sourceName=").append(this.j).append(", sourceIconUrl=").append(this.k).append(", sourceAttributionName=");
        r0.append(this.l).append(", appFunctionPackageName=").append(this.m).append(", appFunctionContentFingerprint=").append(this.n).append(", version=").append(this.o).append(", enabled=").append(this.p).append(", removable=").append(this.q).append(", createdAt=").append(this.r).append(", lastUsedAt=").append(this.s).append(", lastUpdatedAt=").append(this.t).append(", scan=").append(this.u).append(')');
        return r0.toString();
    }

    public de(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, boolean r25, boolean r26, Long r27, Long r28, Long r29, hk r30) {
        d.h.b.o.e(r10, "slug");
        d.h.b.o.e(r11, "displayName");
        d.h.b.o.e(r12, "shortDescription");
        d.h.b.o.e(r13, "storeDescription");
        d.h.b.o.e(r14, "coverUrl");
        d.h.b.o.e(r15, "sourceType");
        d.h.b.o.e(r30, "scan");
        this.f19736a = r10;
        this.f19737b = r11;
        this.f19738c = r12;
        this.f19739d = r13;
        this.f19740e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
        this.q = r26;
        this.r = r27;
        this.s = r28;
        this.t = r29;
        this.u = r30;
    }

    public final String a() {
        return this.f19736a;
    }

    public final String b() {
        return this.f19737b;
    }

    public final String c() {
        return this.f19738c;
    }

    public final String d() {
        return this.f19739d;
    }

    public final String e() {
        return this.f19740e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public final int o() {
        return this.o;
    }

    public final boolean p() {
        return this.p;
    }

    public final boolean q() {
        return this.q;
    }

    public final Long r() {
        return this.r;
    }

    public final Long s() {
        return this.s;
    }

    public final Long t() {
        return this.t;
    }

    public final hk u() {
        return this.u;
    }

    public /* synthetic */ de(String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38, boolean r39, boolean r40, Long r41, Long r42, Long r43, hk r44, int r45, d.h.b.h r46) {
        if ((r45 & 1048576) == 0) goto L5;
        hk r22 = hk.f20115a.a();
    L6:
        this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r22);
        return;
    L5:
        r22 = r44;
        goto L6
    }
}
