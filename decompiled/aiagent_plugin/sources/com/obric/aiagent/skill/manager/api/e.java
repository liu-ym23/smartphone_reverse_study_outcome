package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19253e;
    private final String f;
    private final aq g;
    private final a h;
    private final aj i;
    private final int j;
    private final String k;
    private final boolean l;
    private final boolean m;
    private final Long n;
    private final Long o;
    private final Long p;
    private final String q;

    public e() {
        this(null, null, null, null, null, null, null, null, null, 0, null, false, false, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ e a(e r17, String r18, String r19, String r20, String r21, String r22, String r23, aq r24, a r25, aj r26, int r27, String r28, boolean r29, boolean r30, Long r31, Long r32, Long r33, String r34, int r35, Object r36) {
        aq r2 = (aq) ZeusTransformUtils.wrapperContextForParams(r24, aq.class, "com.obric.aiagent.plugin");
        aj r3 = (aj) ZeusTransformUtils.wrapperContextForParams(r26, aj.class, "com.obric.aiagent.plugin");
        if ((r35 & 1) == 0) goto L5;
        String r4 = r17.f19249a;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r5 = r17.f19250b;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r6 = r17.f19251c;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r7 = r17.f19252d;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r8 = r17.f19253e;
    L23:
        if ((r35 & 32) == 0) goto L25;
        String r9 = r17.f;
    L27:
        if ((r35 & 64) == 0) goto L30;
        r2 = r17.g;
    L30:
        if ((r35 & 128) == 0) goto L32;
        a r10 = r17.h;
    L34:
        if ((r35 & 256) == 0) goto L37;
        r3 = r17.i;
    L37:
        if ((r35 & 512) == 0) goto L39;
        int r11 = r17.j;
    L41:
        if ((r35 & 1024) == 0) goto L43;
        String r12 = r17.k;
    L45:
        if ((r35 & 2048) == 0) goto L47;
        boolean r13 = r17.l;
    L49:
        if ((r35 & 4096) == 0) goto L51;
        boolean r14 = r17.m;
    L53:
        if ((r35 & 8192) == 0) goto L55;
        Long r15 = r17.n;
    L56:
        Long r37 = r15;
        if ((r35 & 16384) == 0) goto L59;
        Long r16 = r17.o;
    L60:
        Long r38 = r16;
        if ((r35 & 32768) == 0) goto L63;
        Long r110 = r17.p;
    L65:
        if ((r35 & 65536) == 0) goto L67;
        String r1 = r17.q;
    L69:
        return r17.a(r4, r5, r6, r7, r8, r9, r2, r10, r3, r11, r12, r13, r14, r37, r38, r110, r1);
    L67:
        r1 = r34;
        goto L69
    L63:
        r110 = r33;
        goto L65
    L59:
        r16 = r32;
        goto L60
    L55:
        r15 = r31;
        goto L56
    L51:
        r14 = r30;
        goto L53
    L47:
        r13 = r29;
        goto L49
    L43:
        r12 = r28;
        goto L45
    L39:
        r11 = r27;
        goto L41
    L32:
        r10 = r25;
        goto L34
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public final e a(String r21, String r22, String r23, String r24, String r25, String r26, aq r27, a r28, aj r29, int r30, String r31, boolean r32, boolean r33, Long r34, Long r35, Long r36, String r37) {
        aq r7 = (aq) ZeusTransformUtils.wrapperContextForParams(r27, aq.class, "com.obric.aiagent.plugin");
        aj r0 = (aj) ZeusTransformUtils.wrapperContextForParams(r29, aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r21, "slug");
        d.h.b.o.e(r22, "displayName");
        d.h.b.o.e(r23, "description");
        d.h.b.o.e(r24, "shortDescription");
        d.h.b.o.e(r25, "storeDescription");
        d.h.b.o.e(r26, "coverUrl");
        d.h.b.o.e(r0, "security");
        d.h.b.o.e(r31, "skillMdContent");
        d.h.b.o.e(r37, "toolSchema");
        return new e(r21, r22, r23, r24, r25, r26, r7, r28, r0, r30, r31, r32, r33, r34, r35, r36, r37);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19249a, r6.f19249a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19250b, r6.f19250b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19251c, r6.f19251c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19252d, r6.f19252d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19253e, r6.f19253e) == true) goto L24;
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
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (d.h.b.o.a(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (d.h.b.o.a(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (d.h.b.o.a(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (d.h.b.o.a(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f19249a.hashCode() * 31) + this.f19250b.hashCode()) * 31) + this.f19251c.hashCode()) * 31) + this.f19252d.hashCode()) * 31) + this.f19253e.hashCode()) * 31) + this.f.hashCode()) * 31;
        aq r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        a r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((((r4 + r6) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31;
        Long r8 = this.n;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.o;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.p;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + this.q.hashCode();
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
        r0.append("Skill(slug=").append(this.f19249a).append(", displayName=").append(this.f19250b).append(", description=").append(this.f19251c).append(", shortDescription=").append(this.f19252d).append(", storeDescription=").append(this.f19253e).append(", coverUrl=").append(this.f).append(", source=").append(this.g).append(", appFunctionInfo=").append(this.h).append(", security=").append(this.i).append(", version=").append(this.j).append(", skillMdContent=").append(this.k).append(", enabled=");
        r0.append(this.l).append(", removable=").append(this.m).append(", createdAt=").append(this.n).append(", lastUsedAt=").append(this.o).append(", lastUpdatedAt=").append(this.p).append(", toolSchema=").append(this.q).append(')');
        return r0.toString();
    }

    public e(String r14, String r15, String r16, String r17, String r18, String r19, aq r20, a r21, aj r22, int r23, String r24, boolean r25, boolean r26, Long r27, Long r28, Long r29, String r30) {
        aq r9 = (aq) ZeusTransformUtils.wrapperContextForParams(r20, aq.class, "com.obric.aiagent.plugin");
        aj r10 = (aj) ZeusTransformUtils.wrapperContextForParams(r22, aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "slug");
        d.h.b.o.e(r15, "displayName");
        d.h.b.o.e(r16, "description");
        d.h.b.o.e(r17, "shortDescription");
        d.h.b.o.e(r18, "storeDescription");
        d.h.b.o.e(r19, "coverUrl");
        d.h.b.o.e(r10, "security");
        d.h.b.o.e(r24, "skillMdContent");
        d.h.b.o.e(r30, "toolSchema");
        this.f19249a = r14;
        this.f19250b = r15;
        this.f19251c = r16;
        this.f19252d = r17;
        this.f19253e = r18;
        this.f = r19;
        this.g = r9;
        this.h = r21;
        this.i = r10;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r30;
    }

    public final String a() {
        return this.f19249a;
    }

    public final String b() {
        return this.f19250b;
    }

    public final String c() {
        return this.f19251c;
    }

    public final String d() {
        return this.f19252d;
    }

    public final String e() {
        return this.f19253e;
    }

    public final String f() {
        return this.f;
    }

    public final aq g() {
        return this.g;
    }

    public final a h() {
        return this.h;
    }

    public /* synthetic */ e(String r19, String r20, String r21, String r22, String r23, String r24, aq r25, a r26, aj r27, int r28, String r29, boolean r30, boolean r31, Long r32, Long r33, Long r34, String r35, int r36, d.h.b.h r37) {
        aq r1 = (aq) ZeusTransformUtils.wrapperContextForParams(r25, aq.class, "com.obric.aiagent.plugin");
        aj r3 = (aj) ZeusTransformUtils.wrapperContextForParams(r27, aj.class, "com.obric.aiagent.plugin");
        if ((r36 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r36 & 64) == 0) goto L30;
        r1 = null;
    L30:
        if ((r36 & 128) == 0) goto L32;
        a r11 = null;
    L34:
        if ((r36 & 256) == 0) goto L36;
        r3 = (aj) ZeusTransformUtils.preCheckCast(aj.c.f19187a, aj.class, "com.obric.aiagent.plugin");
    L36:
        boolean r13 = true;
        if ((r36 & 512) == 0) goto L39;
        int r2 = 1;
    L41:
        if ((r36 & 1024) == 0) goto L43;
        String r14 = "";
    L45:
        if ((r36 & 2048) == 0) goto L47;
        boolean r15 = false;
    L49:
        if ((r36 & 4096) != 0) goto L53;
        r13 = r31;
    L53:
        if ((r36 & 8192) == 0) goto L55;
        Long r12 = null;
    L57:
        if ((r36 & 16384) == 0) goto L59;
        Long r5 = null;
    L61:
        if ((r36 & 32768) == 0) goto L63;
        Long r16 = null;
    L65:
        if ((r36 & 65536) == 0) goto L67;
        String r0 = "";
    L68:
        this(r4, r6, r7, r8, r9, r10, r1, r11, r3, r2, r14, r15, r13, r12, r5, r16, r0);
        return;
    L67:
        r0 = r35;
        goto L68
    L63:
        r16 = r34;
        goto L65
    L59:
        r5 = r33;
        goto L61
    L55:
        r12 = r32;
        goto L57
    L47:
        r15 = r30;
        goto L49
    L43:
        r14 = r29;
        goto L45
    L39:
        r2 = r28;
        goto L41
    L32:
        r11 = r26;
        goto L34
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public final aj i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }

    public final boolean m() {
        return this.m;
    }

    public final Long n() {
        return this.n;
    }

    public final Long o() {
        return this.o;
    }

    public final Long p() {
        return this.p;
    }

    public final String q() {
        return this.q;
    }
}
