package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: BasicMeasure.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.obric.oui.constraintlayout.a.c.e> f34675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f34676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.constraintlayout.a.c.f f34677c;

    /* JADX INFO: compiled from: BasicMeasure.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f34678a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f34679b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f34680c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.obric.oui.constraintlayout.a.c.e.a f34681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.obric.oui.constraintlayout.a.c.e.a f34682e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;

        static {
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.a.c.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicMeasure.java */
    public interface InterfaceC0938b {
        void a();

        void a(com.obric.oui.constraintlayout.a.c.e r1, a r2);
    }

    public void a(com.obric.oui.constraintlayout.a.c.f r6) {
        this.f34675a.clear();
        int r0 = r6.aV.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        com.obric.oui.constraintlayout.a.c.e r2 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.aV.get(r1), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r2.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L7;
    L8:
        this.f34675a.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.ab() != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L9;
    L10:
        r6.b();
    }

    public b(com.obric.oui.constraintlayout.a.c.f r2) {
        this.f34675a = new ArrayList();
        this.f34676b = new a();
        this.f34677c = r2;
    }

    private void b(com.obric.oui.constraintlayout.a.c.f r12) {
        int r0 = r12.aV.size();
        boolean r1 = r12.b(64);
        InterfaceC0938b r2 = r12.g();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L70;
        com.obric.oui.constraintlayout.a.c.e r5 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r12.aV.get(r4), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.constraintlayout.a.c.h.class) == true) goto L69;
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L69;
        if (r5.p() == true) goto L69;
        if (r1 == true) goto L15;
    L23:
        com.obric.oui.constraintlayout.a.c.e.a r6 = r5.x(0);
        boolean r7 = true;
        com.obric.oui.constraintlayout.a.c.e.a r8 = r5.x(1);
        if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L26;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
    L63:
        r7 = r9;
    L64:
        if (r7 == true) goto L69;
        a(r2, r5, a.f34678a);
        if (r12.aB == null) goto L69;
        r12.aB.f34779c++;
        goto L69
    L35:
        if (r12.b(1) == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.constraintlayout.a.c.m.class) == true) goto L63;
        if (r6 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L48;
        if (r5.n != 0) goto L48;
        if (r8 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L48;
        if (r5.ac() == true) goto L48;
        r9 = true;
    L48:
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L57;
        if (r5.o != 0) goto L57;
        if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L57;
        if (r5.ac() == true) goto L57;
        r9 = true;
    L57:
        if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L61;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L63;
    L61:
        if (r5.P <= 0.0f) goto L63;
    L26:
        if (r5.n == 1) goto L32;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L32;
        if (r5.o == 1) goto L32;
        r9 = true;
        goto L33
    L15:
        if (r5.f == null) goto L23;
        if (r5.g == null) goto L23;
        if (r5.f.g.j == false) goto L23;
        if (r5.g.g.j == false) goto L23;
    L69:
        r4 = r4 + 1;
        goto L3
    L70:
        r2.a();
    }

    private void a(com.obric.oui.constraintlayout.a.c.f r5, String r6, int r7, int r8, int r9) {
        if (r5.aB == null) goto L5;
        long r0 = System.nanoTime();
    L6:
        int r10 = r5.H();
        int r2 = r5.I();
        r5.s(0);
        r5.t(0);
        r5.q(r8);
        r5.r(r9);
        r5.s(r10);
        r5.t(r2);
        this.f34677c.A(r7);
        this.f34677c.ah();
        if (r5.aB == null) goto L10;
        long r11 = System.nanoTime();
        r5.aB.M++;
        r5.aB.f34778b += r11 - r0;
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public long a(com.obric.oui.constraintlayout.a.c.f r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34) {
        b r0 = this;
        com.obric.oui.constraintlayout.a.c.f r1 = r25;
        InterfaceC0938b r5 = r25.g();
        int r6 = r1.aV.size();
        int r7 = r25.F();
        int r8 = r25.G();
        boolean r9 = com.obric.oui.constraintlayout.a.c.k.a(r26, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L45;
        int r13 = 0;
    L12:
        if (r13 >= r6) goto L45;
        com.obric.oui.constraintlayout.a.c.e r14 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r1.aV.get(r13), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r14.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L16;
        boolean r11 = true;
    L18:
        if (r14.ab() != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L20;
        boolean r10 = true;
    L21:
        if (r11 == false) goto L26;
        if (r10 == false) goto L26;
        if (r14.U() <= 0.0f) goto L26;
        boolean r12 = true;
    L28:
        if (r14.ac() == false) goto L32;
        if (r12 == false) goto L32;
    L30:
        r2 = false;
    L32:
        if (r14.ad() == false) goto L36;
        if (r12 == true) goto L30;
    L36:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.oui.constraintlayout.a.c.m.class) == true) goto L30;
        if (r14.ac() == true) goto L30;
        if (r14.ad() == true) goto L30;
        r13 = r13 + 1;
    L26:
        r12 = false;
        goto L28
    L20:
        r10 = false;
        goto L21
    L16:
        r11 = false;
    L45:
        if (r2 == false) goto L50;
        if (com.obric.oui.constraintlayout.a.d.o == null) goto L50;
        com.obric.oui.constraintlayout.a.d.o.f34781e++;
    L50:
        if (r29 != 1073741824) goto L52;
        if (r31 != 1073741824) goto L52;
    L53:
        boolean r15 = true;
    L55:
        boolean r3 = r2 & r15;
        if (r3 == false) goto L84;
        int r16 = Math.min(r25.r(), r30);
        int r17 = Math.min(r25.q(), r32);
        if (r29 == 1073741824) goto L60;
    L62:
        if (r31 == 1073741824) goto L64;
    L66:
        if (r29 != 1073741824) goto L69;
        if (r31 != 1073741824) goto L69;
        boolean r18 = r1.a(r9);
        int r19 = 2;
    L76:
        if (r18 == false) goto L85;
        if (r29 != 1073741824) goto L79;
        boolean r110 = true;
    L80:
        if (r31 != 1073741824) goto L82;
        boolean r4 = true;
    L83:
        r1.a(r110, r4);
        goto L85
    L82:
        r4 = false;
        goto L83
    L79:
        r110 = false;
    L85:
        long r20 = 0;
        if (r18 == false) goto L90;
        if (r19 != 2) goto L90;
        r25 = r1;
    L195:
        if (r25.aB != null) goto L197;
        return r20;
    L197:
        return System.nanoTime() - r20;
    L90:
        int r21 = r25.h();
        if (r6 <= 0) goto L94;
        b(r25);
    L94:
        if (r1.aB == null) goto L96;
        r20 = System.nanoTime();
    L96:
        a(r25);
        int r111 = r0.f34675a.size();
        if (r6 <= 0) goto L99;
        a(r25, "First pass", 0, r7, r8);
    L99:
        if (r111 > 0) goto L101;
        long r22 = r20;
        int r23 = r21;
    L193:
        r25.a(r23);
        r20 = r22;
        goto L195
    L101:
        if (r25.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L103;
        boolean r112 = true;
    L105:
        if (r25.ab() != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L107;
        boolean r24 = true;
    L108:
        int r113 = Math.max(r25.F(), r0.f34677c.H());
        int r114 = Math.max(r25.G(), r0.f34677c.I());
        int r115 = 0;
        boolean r116 = false;
    L109:
        if (r115 >= r111) goto L135;
        long r210 = r20;
        com.obric.oui.constraintlayout.a.c.e r35 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.f34675a.get(r115), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r35, com.obric.oui.constraintlayout.a.c.m.class) == true) goto L113;
        r3 = r3;
    L134:
        r115 = r115 + 1;
        r1 = r25;
        r21 = r21;
        r20 = r210;
        r8 = r8;
        r3 = r3;
        goto L109
    L113:
        int r36 = r35.F();
        int r37 = r35.G();
        boolean r38 = r116 | r0.a(r5, r35, a.f34679b);
        if (r1.aB == null) goto L117;
        r1.aB.f34780d++;
    L117:
        int r39 = r35.F();
        int r40 = r35.G();
        if (r39 == r36) goto L125;
        r35.q(r39);
        if (r112 == true) goto L122;
    L124:
        boolean r41 = true;
    L126:
        if (r40 == r37) goto L133;
        r35.r(r40);
        if (r24 == true) goto L130;
    L132:
        r41 = true;
        goto L133
    L130:
        if (r35.M() <= r114) goto L132;
        r114 = Math.max(r114, r35.M() + r35.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e).i());
    L133:
        r116 = r41 | ((com.obric.oui.constraintlayout.a.c.m) ZeusTransformUtils.preCheckCast(r35, com.obric.oui.constraintlayout.a.c.m.class, "com.obric.aiagent.plugin")).h();
        goto L134
    L122:
        if (r35.L() <= r113) goto L124;
        r113 = Math.max(r113, r35.L() + r35.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d).i());
        goto L124
    L125:
        r41 = r38;
        goto L126
    L135:
        boolean r211 = r3;
        r22 = r20;
        int r212 = r8;
        int r310 = r21;
        int r42 = 0;
        int r43 = 2;
    L136:
        if (r42 >= r43) goto L191;
        int r44 = 0;
    L138:
        if (r44 >= r111) goto L188;
        com.obric.oui.constraintlayout.a.c.e r45 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.f34675a.get(r44), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r45, com.obric.oui.constraintlayout.a.c.i.class) == false) goto L144;
        if (ZeusTransformUtils.instanceOf(r45, com.obric.oui.constraintlayout.a.c.m.class) == true) goto L144;
    L157:
        r42 = r42;
    L187:
        r44 = r44 + 1;
        r0 = this;
        r42 = r42;
    L144:
        if (ZeusTransformUtils.instanceOf(r45, com.obric.oui.constraintlayout.a.c.h.class) == true) goto L157;
        if (r45.B() == 8) goto L157;
        if (r211 == false) goto L156;
        if (r45.f.g.j == false) goto L156;
        if (r45.g.g.j == true) goto L157;
    L156:
        if (ZeusTransformUtils.instanceOf(r45, com.obric.oui.constraintlayout.a.c.m.class) == true) goto L157;
        int r46 = r45.F();
        int r47 = r45.G();
        int r117 = r45.S();
        int r118 = a.f34679b;
        if (r42 != 1) goto L161;
        r118 = a.f34680c;
    L161:
        boolean r48 = r116 | r0.a(r5, r45, r118);
        if (r25.aB == null) goto L165;
        r25.aB.f34780d++;
    L165:
        int r49 = r45.F();
        int r50 = r45.G();
        if (r49 == r46) goto L173;
        r45.q(r49);
        if (r112 == true) goto L170;
    L172:
        boolean r51 = true;
    L174:
        if (r50 == r47) goto L182;
        r45.r(r50);
        if (r24 == true) goto L178;
    L180:
        r51 = true;
        goto L182
    L178:
        if (r45.M() <= r114) goto L180;
        r114 = Math.max(r114, r45.M() + r45.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e).i());
    L182:
        if (r45.R() == true) goto L184;
    L186:
        r116 = r51;
        goto L187
    L184:
        if (r117 == r45.S()) goto L186;
        r116 = true;
        goto L187
    L170:
        if (r45.L() <= r113) goto L172;
        r113 = Math.max(r113, r45.L() + r45.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d).i());
        goto L172
    L173:
        r51 = r48;
        goto L174
    L188:
        int r119 = r42;
        if (r116 == false) goto L191;
        r42 = r119 + 1;
        a(r25, "intermediate pass", r42, r7, r212);
        r43 = 2;
        r116 = false;
        r0 = this;
    L191:
        r23 = r310;
        goto L193
    L107:
        r24 = false;
        goto L108
    L103:
        r112 = false;
    L69:
        boolean r120 = r1.g(r9);
        if (r29 != 1073741824) goto L72;
        r120 = r120 & r1.a(r9, 0);
        r19 = 1;
    L73:
        if (r31 != 1073741824) goto L75;
        r18 = r1.a(r9, 1) & r120;
        r19 = r19 + 1;
        goto L76
    L75:
        r18 = r120;
        goto L76
    L72:
        r19 = 0;
        goto L73
    L64:
        if (r25.G() == r17) goto L66;
        r1.r(r17);
        r25.b();
        goto L66
    L60:
        if (r25.F() == r16) goto L62;
        r1.q(r16);
        r25.b();
        goto L62
    L84:
        r18 = false;
        r19 = 0;
    L52:
        if (r9 == true) goto L53;
        r15 = false;
        goto L55
    L5:
        if (com.obric.oui.constraintlayout.a.c.k.a(r26, 64) == true) goto L8;
        r2 = false;
        goto L10
    }

    private boolean a(InterfaceC0938b r5, com.obric.oui.constraintlayout.a.c.e r6, int r7) {
        InterfaceC0938b r8 = (InterfaceC0938b) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0938b.class, "com.obric.aiagent.plugin");
        this.f34676b.f34681d = r6.aa();
        this.f34676b.f34682e = r6.ab();
        this.f34676b.f = r6.F();
        this.f34676b.g = r6.G();
        this.f34676b.l = false;
        this.f34676b.m = r7;
        if (this.f34676b.f34681d != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L5;
        boolean r9 = true;
    L7:
        if (this.f34676b.f34682e != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L9;
        boolean r0 = true;
    L11:
        if (r9 == true) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r0 == true) goto L18;
    L20:
        boolean r1 = false;
    L22:
        if (r10 == true) goto L24;
    L26:
        if (r1 == true) goto L28;
    L30:
        r8.a(r6, this.f34676b);
        r6.q(this.f34676b.h);
        r6.r(this.f34676b.i);
        r6.c(this.f34676b.k);
        r6.u(this.f34676b.j);
        this.f34676b.m = a.f34678a;
        return this.f34676b.l;
    L28:
        if (r6.p[1] != 4) goto L30;
        this.f34676b.f34682e = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
        goto L30
    L24:
        if (r6.p[0] != 4) goto L26;
        this.f34676b.f34681d = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
        goto L26
    L18:
        if (r6.P <= 0.0f) goto L20;
        r1 = true;
        goto L22
    L13:
        if (r6.P <= 0.0f) goto L15;
        r10 = true;
        goto L16
    L9:
        r0 = false;
        goto L11
    L5:
        r9 = false;
        goto L7
    }
}
