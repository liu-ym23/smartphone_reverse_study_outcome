package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HorizontalWidgetRun.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f34703a;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.c.a.l$1, reason: invalid class name */
    /* JADX INFO: compiled from: HorizontalWidgetRun.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34704a = null;

        static {
            int[] r0 = new int[p.a.values().length];
            f34704a = r0;
            r0[p.a.f34728b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f34704a[p.a.f34729c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f34704a[p.a.f34730d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f34703a = new int[2];
    }

    public l(com.obric.oui.constraintlayout.a.c.e r2) {
        super(r2);
        f r3 = this.j;
        r3.f34694e = f.a.f34698d;
        f r4 = this.k;
        r4.f34694e = f.a.f34699e;
        this.h = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.f34724d.C();
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void c() {
        this.f34725e = null;
        this.j.a();
        this.k.a();
        this.g.a();
        this.i = false;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void d() {
        this.i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.g.j = false;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    boolean a() {
        if (this.f == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L5;
        return true;
    L5:
        if (this.f34724d.n != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    void f() {
        if (this.f34724d.f34750b == false) goto L6;
        this.g.a(this.f34724d.F());
    L6:
        if (this.g.j == true) goto L23;
        this.f = this.f34724d.aa();
        if (this.f == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L33;
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L20;
        com.obric.oui.constraintlayout.a.c.e r0 = this.f34724d.A();
        if (r0 == null) goto L20;
        if (r0.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L16;
    L17:
        int r1 = (r0.F() - this.f34724d.B.i()) - this.f34724d.D.i();
        a(this.j, r0.f.j, this.f34724d.B.i());
        a(this.k, r0.f.k, -this.f34724d.D.i());
        this.g.a(r1);
        return;
    L16:
        if (r0.aa() == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L17;
    L20:
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L33;
        this.g.a(this.f34724d.F());
    L33:
        if (this.g.j == false) goto L68;
        if (this.f34724d.f34750b == false) goto L68;
        if (this.f34724d.f34748J[0].f34739c == null) goto L51;
        if (this.f34724d.f34748J[1].f34739c == null) goto L51;
        if (this.f34724d.ac() == false) goto L43;
        f r2 = this.j;
        r2.f = this.f34724d.f34748J[0].i();
        f r3 = this.k;
        r3.f = -this.f34724d.f34748J[1].i();
        return;
    L43:
        f r4 = a(this.f34724d.f34748J[0]);
        if (r4 == null) goto L46;
        a(this.j, r4, this.f34724d.f34748J[0].i());
    L46:
        f r5 = a(this.f34724d.f34748J[1]);
        if (r5 == null) goto L49;
        a(this.k, r5, -this.f34724d.f34748J[1].i());
    L49:
        this.j.f34691b = true;
        this.k.f34691b = true;
        return;
    L51:
        if (this.f34724d.f34748J[0].f34739c == null) goto L56;
        f r6 = a(this.f34724d.f34748J[0]);
        if (r6 == null) goto L119;
        a(this.j, r6, this.f34724d.f34748J[0].i());
        a(this.k, this.j, this.g.g);
        return;
    L119:
        return;
    L56:
        if (this.f34724d.f34748J[1].f34739c == null) goto L61;
        f r7 = a(this.f34724d.f34748J[1]);
        if (r7 == null) goto L121;
        a(this.k, r7, -this.f34724d.f34748J[1].i());
        a(this.j, this.k, -this.g.g);
        return;
    L121:
        return;
    L61:
        if (ZeusTransformUtils.instanceOf(this.f34724d, com.obric.oui.constraintlayout.a.c.i.class) == false) goto L63;
        return;
    L63:
        if (this.f34724d.A() != null) goto L65;
        return;
    L65:
        if (this.f34724d.a(com.obric.oui.constraintlayout.a.c.d.a.g).f34739c != null) goto L125;
        f r8 = this.f34724d.A().f.j;
        a(this.j, r8, this.f34724d.D());
        a(this.k, this.j, this.g.g);
        return;
    L125:
        return;
    L68:
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L89;
        int r9 = this.f34724d.n;
        if (r9 != 2) goto L72;
        com.obric.oui.constraintlayout.a.c.e r10 = this.f34724d.A();
        if (r10 == null) goto L89;
        g r11 = r10.g.g;
        this.g.l.add(r11);
        r11.k.add(this.g);
        this.g.f34691b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        goto L89
    L72:
        if (r9 != 3) goto L89;
        if (this.f34724d.o != 3) goto L83;
        this.j.f34690a = this;
        this.k.f34690a = this;
        this.f34724d.g.j.f34690a = this;
        this.f34724d.g.k.f34690a = this;
        this.g.f34690a = this;
        if (this.f34724d.ad() == false) goto L80;
        this.g.l.add(this.f34724d.g.g);
        this.f34724d.g.g.k.add(this.g);
        this.f34724d.g.g.f34690a = this;
        this.g.l.add(this.f34724d.g.j);
        this.g.l.add(this.f34724d.g.k);
        this.f34724d.g.j.k.add(this.g);
        this.f34724d.g.k.k.add(this.g);
        goto L89
    L80:
        if (this.f34724d.ac() == false) goto L82;
        this.f34724d.g.g.l.add(this.g);
        this.g.k.add(this.f34724d.g.g);
        goto L89
    L82:
        this.f34724d.g.g.l.add(this.g);
        goto L89
    L83:
        g r12 = this.f34724d.g.g;
        this.g.l.add(r12);
        r12.k.add(this.g);
        this.f34724d.g.j.k.add(this.g);
        this.f34724d.g.k.k.add(this.g);
        this.g.f34691b = true;
        this.g.k.add(this.j);
        this.g.k.add(this.k);
        this.j.l.add(this.g);
        this.k.l.add(this.g);
    L89:
        if (this.f34724d.f34748J[0].f34739c == null) goto L102;
        if (this.f34724d.f34748J[1].f34739c == null) goto L102;
        if (this.f34724d.ac() == false) goto L95;
        f r13 = this.j;
        r13.f = this.f34724d.f34748J[0].i();
        f r14 = this.k;
        r14.f = -this.f34724d.f34748J[1].i();
        return;
    L95:
        f r15 = a(this.f34724d.f34748J[0]);
        f r16 = a(this.f34724d.f34748J[1]);
        if (r15 == null) goto L98;
        r15.a(this);
    L98:
        if (r16 == null) goto L100;
        r16.a(this);
    L100:
        this.l = p.a.f34730d;
        return;
    L102:
        if (this.f34724d.f34748J[0].f34739c == null) goto L107;
        f r17 = a(this.f34724d.f34748J[0]);
        if (r17 == null) goto L129;
        a(this.j, r17, this.f34724d.f34748J[0].i());
        a(this.k, this.j, 1, this.g);
        return;
    L129:
        return;
    L107:
        if (this.f34724d.f34748J[1].f34739c == null) goto L112;
        f r18 = a(this.f34724d.f34748J[1]);
        if (r18 == null) goto L131;
        a(this.k, r18, -this.f34724d.f34748J[1].i());
        a(this.j, this.k, -1, this.g);
        return;
    L131:
        return;
    L112:
        if (ZeusTransformUtils.instanceOf(this.f34724d, com.obric.oui.constraintlayout.a.c.i.class) == false) goto L114;
        return;
    L114:
        if (this.f34724d.A() == null) goto L134;
        f r19 = this.f34724d.A().f.j;
        a(this.j, r19, this.f34724d.D());
        a(this.k, this.j, 1, this.g);
        return;
    L134:
        return;
    L23:
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L33;
        com.obric.oui.constraintlayout.a.c.e r20 = this.f34724d.A();
        if (r20 == null) goto L33;
        if (r20.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L29;
    L30:
        a(this.j, r20.f.j, this.f34724d.B.i());
        a(this.k, r20.f.k, -this.f34724d.D.i());
        return;
    L29:
        if (r20.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L33;
        goto L30
    }

    private void a(int[] r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        int r9 = r4 - r3;
        int r10 = r6 - r5;
        if (r8 == (-1)) goto L9;
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L22;
        r2[0] = r9;
        r2[1] = (int) ((r9 * r7) + 0.5f);
        return;
    L22:
        return;
    L8:
        r2[0] = (int) ((r10 * r7) + 0.5f);
        r2[1] = r10;
        return;
    L9:
        int r1 = (int) ((r10 * r7) + 0.5f);
        int r11 = (int) ((r9 / r7) + 0.5f);
        if (r1 > r9) goto L13;
        if (r10 > r10) goto L13;
        r2[0] = r1;
        r2[1] = r10;
        return;
    L13:
        if (r9 > r9) goto L20;
        if (r11 > r10) goto L21;
        r2[0] = r9;
        r2[1] = r11;
        return;
    L21:
        return;
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p, com.obric.oui.constraintlayout.a.c.a.d
    public void update(d r18) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r18, d.class, "com.obric.aiagent.plugin");
        int r1 = AnonymousClass1.f34704a[this.l.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L9;
        if (r1 != 3) goto L12;
        a(r0, this.f34724d.B, this.f34724d.D, 0);
        return;
    L12:
        if (this.g.j == true) goto L137;
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L137;
        int r2 = this.f34724d.n;
        if (r2 == 2) goto L131;
        if (r2 != 3) goto L137;
        if (this.f34724d.o != 0) goto L22;
    L35:
        f r13 = this.f34724d.g.j;
        f r14 = this.f34724d.g.k;
        if (this.f34724d.B.f34739c == null) goto L38;
        boolean r3 = true;
    L40:
        if (this.f34724d.C.f34739c == null) goto L42;
        boolean r4 = true;
    L44:
        if (this.f34724d.D.f34739c == null) goto L46;
        boolean r5 = true;
    L48:
        if (this.f34724d.E.f34739c == null) goto L50;
        boolean r6 = true;
    L51:
        int r15 = this.f34724d.V();
        if (r3 == false) goto L89;
        if (r4 == false) goto L89;
        if (r5 == false) goto L89;
        if (r6 == false) goto L89;
        float r16 = this.f34724d.U();
        if (r13.j == false) goto L68;
        if (r14.j == false) goto L68;
        if (this.j.f34692c == true) goto L63;
        return;
    L63:
        if (this.k.f34692c == false) goto L181;
        a(f34703a, ((f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin")).g + this.j.f, ((f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin")).g - this.k.f, r13.g + r13.f, r14.g - r14.f, r16, r15);
        this.g.a(f34703a[0]);
        this.f34724d.g.g.a(f34703a[1]);
        return;
    L181:
        return;
    L68:
        if (this.j.j == false) goto L79;
        if (this.k.j == false) goto L79;
        if (r13.f34692c == true) goto L74;
        return;
    L74:
        if (r14.f34692c == false) goto L182;
        a(f34703a, this.j.g + this.j.f, this.k.g - this.k.f, ((f) ZeusTransformUtils.preCheckCast(r13.l.get(0), f.class, "com.obric.aiagent.plugin")).g + r13.f, ((f) ZeusTransformUtils.preCheckCast(r14.l.get(0), f.class, "com.obric.aiagent.plugin")).g - r14.f, r16, r15);
        this.g.a(f34703a[0]);
        this.f34724d.g.g.a(f34703a[1]);
        goto L79
    L182:
        return;
    L79:
        if (this.j.f34692c == true) goto L81;
        return;
    L81:
        if (this.k.f34692c == true) goto L83;
        return;
    L83:
        if (r13.f34692c == true) goto L85;
        return;
    L85:
        if (r14.f34692c == false) goto L185;
        a(f34703a, ((f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin")).g + this.j.f, ((f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin")).g - this.k.f, ((f) ZeusTransformUtils.preCheckCast(r13.l.get(0), f.class, "com.obric.aiagent.plugin")).g + r13.f, ((f) ZeusTransformUtils.preCheckCast(r14.l.get(0), f.class, "com.obric.aiagent.plugin")).g - r14.f, r16, r15);
        this.g.a(f34703a[0]);
        this.f34724d.g.g.a(f34703a[1]);
        goto L137
    L185:
        return;
    L89:
        if (r3 == false) goto L110;
        if (r5 == false) goto L110;
        if (this.j.f34692c == true) goto L94;
        return;
    L94:
        if (this.k.f34692c == false) goto L186;
        float r7 = this.f34724d.U();
        int r8 = ((f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin")).g + this.j.f;
        int r9 = ((f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin")).g - this.k.f;
        if (r15 == (-1)) goto L105;
        if (r15 == 0) goto L105;
        if (r15 != 1) goto L137;
        int r10 = a(r9 - r8, 0);
        int r11 = (int) ((r10 / r7) + 0.5f);
        int r12 = a(r11, 1);
        if (r11 == r12) goto L104;
        r10 = (int) ((r12 * r7) + 0.5f);
    L104:
        this.g.a(r10);
        this.f34724d.g.g.a(r12);
    L105:
        int r17 = a(r9 - r8, 0);
        int r19 = (int) ((r17 * r7) + 0.5f);
        int r20 = a(r19, 1);
        if (r19 == r20) goto L108;
        r17 = (int) ((r20 / r7) + 0.5f);
    L108:
        this.g.a(r17);
        this.f34724d.g.g.a(r20);
        goto L137
    L186:
        return;
    L110:
        if (r4 == false) goto L137;
        if (r6 == false) goto L137;
        if (r13.f34692c == true) goto L115;
        return;
    L115:
        if (r14.f34692c == false) goto L187;
        float r21 = this.f34724d.U();
        int r22 = ((f) ZeusTransformUtils.preCheckCast(r13.l.get(0), f.class, "com.obric.aiagent.plugin")).g + r13.f;
        int r23 = ((f) ZeusTransformUtils.preCheckCast(r14.l.get(0), f.class, "com.obric.aiagent.plugin")).g - r14.f;
        if (r15 == (-1)) goto L126;
        if (r15 == 0) goto L122;
        if (r15 == 1) goto L126;
    L122:
        int r24 = a(r23 - r22, 1);
        int r25 = (int) ((r24 * r21) + 0.5f);
        int r26 = a(r25, 0);
        if (r25 == r26) goto L125;
        r24 = (int) ((r26 / r21) + 0.5f);
    L125:
        this.g.a(r26);
        this.f34724d.g.g.a(r24);
    L126:
        int r27 = a(r23 - r22, 1);
        int r28 = (int) ((r27 / r21) + 0.5f);
        int r29 = a(r28, 0);
        if (r28 == r29) goto L129;
        r27 = (int) ((r29 * r21) + 0.5f);
    L129:
        this.g.a(r29);
        this.f34724d.g.g.a(r27);
        goto L137
    L187:
        return;
    L50:
        r6 = false;
        goto L51
    L46:
        r5 = false;
        goto L48
    L42:
        r4 = false;
        goto L44
    L38:
        r3 = false;
        goto L40
    L22:
        if (this.f34724d.o == 3) goto L35;
        int r30 = this.f34724d.V();
        if (r30 == (-1)) goto L31;
        if (r30 == 0) goto L30;
        if (r30 == 1) goto L29;
        int r31 = 0;
    L34:
        this.g.a(r31);
        goto L137
    L29:
        float r32 = this.f34724d.g.g.g;
        float r33 = this.f34724d.U();
    L32:
        float r34 = r32 * r33;
    L33:
        r31 = (int) (r34 + 0.5f);
        goto L34
    L30:
        r34 = this.f34724d.g.g.g / this.f34724d.U();
        goto L33
    L31:
        r32 = this.f34724d.g.g.g;
        r33 = this.f34724d.U();
        goto L32
    L131:
        com.obric.oui.constraintlayout.a.c.e r35 = this.f34724d.A();
        if (r35 == null) goto L137;
        if (r35.f.g.j == false) goto L137;
        this.g.a((int) ((r35.f.g.g * this.f34724d.s) + 0.5f));
    L137:
        if (this.j.f34692c == true) goto L139;
        return;
    L139:
        if (this.k.f34692c == true) goto L142;
        return;
    L142:
        if (this.j.j == false) goto L149;
        if (this.k.j == false) goto L149;
        if (this.g.j == false) goto L149;
        return;
    L149:
        if (this.g.j == true) goto L159;
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L159;
        if (this.f34724d.n != 0) goto L159;
        if (this.f34724d.ac() == true) goto L159;
        f r36 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r37 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r38 = r36.g + this.j.f;
        int r39 = r37.g + this.k.f;
        this.j.a(r38);
        this.k.a(r39);
        this.g.a(r39 - r38);
        return;
    L159:
        if (this.g.j == true) goto L173;
        if (this.f != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L173;
        if (this.f34723c != 1) goto L173;
        if (this.j.l.size() <= 0) goto L173;
        if (this.k.l.size() <= 0) goto L173;
        f r40 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r41 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r42 = Math.min((r41.g + this.k.f) - (r40.g + this.j.f), this.g.m);
        int r43 = this.f34724d.r;
        int r44 = Math.max(this.f34724d.q, r42);
        if (r43 <= 0) goto L171;
        r44 = Math.min(r43, r44);
    L171:
        this.g.a(r44);
    L173:
        if (this.g.j == true) goto L175;
        return;
    L175:
        f r45 = (f) ZeusTransformUtils.preCheckCast(this.j.l.get(0), f.class, "com.obric.aiagent.plugin");
        f r46 = (f) ZeusTransformUtils.preCheckCast(this.k.l.get(0), f.class, "com.obric.aiagent.plugin");
        int r47 = r45.g + this.j.f;
        int r48 = r46.g + this.k.f;
        float r49 = this.f34724d.P();
        if (r45 != r46) goto L178;
        r47 = r45.g;
        r48 = r46.g;
        r49 = 0.5f;
    L178:
        this.j.a((int) ((r47 + 0.5f) + (((r48 - r47) - this.g.g) * r49)));
        this.k.a(this.j.g + this.g.g);
        return;
    L9:
        b(r0);
        goto L12
    L10:
        a(r0);
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.a.c.a.p
    public void e() {
        if (this.j.j == false) goto L6;
        this.f34724d.o(this.j.g);
        return;
    }
}
