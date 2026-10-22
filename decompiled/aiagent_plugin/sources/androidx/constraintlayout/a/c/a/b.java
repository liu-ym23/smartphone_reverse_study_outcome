package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: BasicMeasure.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<androidx.constraintlayout.a.c.e> f694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.constraintlayout.a.c.f f696c;

    /* JADX INFO: compiled from: BasicMeasure.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f697a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f698b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f699c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.a.c.e.a f700d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.constraintlayout.a.c.e.a f701e;
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

    /* JADX INFO: renamed from: androidx.constraintlayout.a.c.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicMeasure.java */
    public interface InterfaceC0012b {
        void a();

        void a(androidx.constraintlayout.a.c.e r1, a r2);
    }

    public void a(androidx.constraintlayout.a.c.f r6) {
        this.f694a.clear();
        int r0 = r6.aU.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        androidx.constraintlayout.a.c.e r2 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.aU.get(r1), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r2.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L7;
    L8:
        this.f694a.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L9;
    L10:
        r6.b();
    }

    public b(androidx.constraintlayout.a.c.f r2) {
        this.f694a = new ArrayList();
        this.f695b = new a();
        this.f696c = r2;
    }

    private void b(androidx.constraintlayout.a.c.f r12) {
        int r0 = r12.aU.size();
        boolean r1 = r12.b(64);
        InterfaceC0012b r2 = r12.g();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L70;
        androidx.constraintlayout.a.c.e r5 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r12.aU.get(r4), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, androidx.constraintlayout.a.c.h.class) == true) goto L69;
        if (ZeusTransformUtils.instanceOf(r5, androidx.constraintlayout.a.c.a.class) == true) goto L69;
        if (r5.p() == true) goto L69;
        if (r1 == true) goto L15;
    L23:
        androidx.constraintlayout.a.c.e.a r6 = r5.x(0);
        boolean r7 = true;
        androidx.constraintlayout.a.c.e.a r8 = r5.x(1);
        if (r6 == androidx.constraintlayout.a.c.e.a.f777c) goto L26;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
    L63:
        r7 = r9;
    L64:
        if (r7 == true) goto L69;
        a(r2, r5, a.f697a);
        if (r12.aA == null) goto L69;
        r12.aA.f795a++;
        goto L69
    L35:
        if (r12.b(1) == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r5, androidx.constraintlayout.a.c.m.class) == true) goto L63;
        if (r6 != androidx.constraintlayout.a.c.e.a.f777c) goto L48;
        if (r5.n != 0) goto L48;
        if (r8 == androidx.constraintlayout.a.c.e.a.f777c) goto L48;
        if (r5.ac() == true) goto L48;
        r9 = true;
    L48:
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L57;
        if (r5.o != 0) goto L57;
        if (r6 == androidx.constraintlayout.a.c.e.a.f777c) goto L57;
        if (r5.ac() == true) goto L57;
        r9 = true;
    L57:
        if (r6 == androidx.constraintlayout.a.c.e.a.f777c) goto L61;
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L63;
    L61:
        if (r5.O <= 0.0f) goto L63;
    L26:
        if (r5.n == 1) goto L32;
        if (r8 != androidx.constraintlayout.a.c.e.a.f777c) goto L32;
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

    private void a(androidx.constraintlayout.a.c.f r3, String r4, int r5, int r6, int r7) {
        int r8 = r3.H();
        int r0 = r3.I();
        r3.s(0);
        r3.t(0);
        r3.q(r6);
        r3.r(r7);
        r3.s(r8);
        r3.t(r0);
        this.f696c.A(r5);
        this.f696c.ah();
    }

    public long a(androidx.constraintlayout.a.c.f r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        b r0 = this;
        androidx.constraintlayout.a.c.f r1 = r24;
        InterfaceC0012b r5 = r24.g();
        int r6 = r1.aU.size();
        int r7 = r24.F();
        int r8 = r24.G();
        boolean r9 = androidx.constraintlayout.a.c.k.a(r25, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L45;
        int r13 = 0;
    L12:
        if (r13 >= r6) goto L45;
        androidx.constraintlayout.a.c.e r14 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r1.aU.get(r13), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r14.aa() != androidx.constraintlayout.a.c.e.a.f777c) goto L16;
        boolean r11 = true;
    L18:
        if (r14.ab() != androidx.constraintlayout.a.c.e.a.f777c) goto L20;
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
        if (ZeusTransformUtils.instanceOf(r14, androidx.constraintlayout.a.c.m.class) == true) goto L30;
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
        if (androidx.constraintlayout.a.d.o == null) goto L50;
        androidx.constraintlayout.a.d.o.f797c++;
    L50:
        if (r28 != 1073741824) goto L52;
        if (r30 != 1073741824) goto L52;
    L53:
        boolean r15 = true;
    L55:
        boolean r3 = r2 & r15;
        int r16 = 2;
        if (r3 == false) goto L84;
        int r17 = Math.min(r24.r(), r29);
        int r18 = Math.min(r24.q(), r31);
        if (r28 == 1073741824) goto L60;
    L62:
        if (r30 == 1073741824) goto L64;
    L66:
        if (r28 != 1073741824) goto L69;
        if (r30 != 1073741824) goto L69;
        boolean r19 = r1.a(r9);
        int r110 = 2;
    L76:
        if (r19 == false) goto L85;
        if (r28 != 1073741824) goto L79;
        boolean r111 = true;
    L80:
        if (r30 != 1073741824) goto L82;
        boolean r4 = true;
    L83:
        r1.a(r111, r4);
        goto L85
    L82:
        r4 = false;
        goto L83
    L79:
        r111 = false;
    L85:
        if (r19 == false) goto L87;
        if (r110 != 2) goto L87;
        return 0;
    L87:
        int r20 = r24.h();
        if (r6 <= 0) goto L90;
        b(r24);
    L90:
        a(r24);
        int r21 = r0.f694a.size();
        if (r6 <= 0) goto L93;
        a(r24, "First pass", 0, r7, r8);
    L93:
        if (r21 > 0) goto L95;
        r24 = r1;
        int r22 = r20;
    L185:
        r24.a(r22);
        return 0;
    L95:
        if (r24.aa() != androidx.constraintlayout.a.c.e.a.f776b) goto L97;
        boolean r112 = true;
    L99:
        if (r24.ab() != androidx.constraintlayout.a.c.e.a.f776b) goto L101;
        boolean r23 = true;
    L102:
        int r34 = Math.max(r24.F(), r0.f696c.H());
        int r113 = Math.max(r24.G(), r0.f696c.I());
        int r114 = 0;
        boolean r115 = false;
    L103:
        if (r114 >= r21) goto L128;
        int r35 = r20;
        androidx.constraintlayout.a.c.e r36 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.f694a.get(r114), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r36, androidx.constraintlayout.a.c.m.class) == true) goto L107;
        r3 = r3;
    L127:
        r114 = r114 + 1;
        r1 = r24;
        r20 = r35;
        r8 = r8;
        r7 = r7;
        r3 = r3;
        r16 = 2;
        goto L103
    L107:
        int r116 = r36.F();
        int r37 = r36.G();
        boolean r38 = r0.a(r5, r36, a.f698b) | r115;
        if (r1.aA == null) goto L111;
        r1.aA.f796b++;
    L111:
        int r39 = r36.F();
        int r40 = r36.G();
        if (r39 == r116) goto L119;
        r36.q(r39);
        if (r112 == true) goto L116;
    L118:
        r38 = true;
        goto L119
    L116:
        if (r36.L() <= r34) goto L118;
        r34 = Math.max(r34, r36.L() + r36.a(androidx.constraintlayout.a.c.d.a.f765d).i());
    L119:
        if (r40 == r37) goto L126;
        r36.r(r40);
        if (r23 == true) goto L123;
    L125:
        r38 = true;
        goto L126
    L123:
        if (r36.M() <= r113) goto L125;
        r113 = Math.max(r113, r36.M() + r36.a(androidx.constraintlayout.a.c.d.a.f766e).i());
    L126:
        r115 = r38 | ((androidx.constraintlayout.a.c.m) ZeusTransformUtils.preCheckCast(r36, androidx.constraintlayout.a.c.m.class, "com.obric.aiagent.plugin")).h();
        goto L127
    L128:
        boolean r210 = r3;
        int r310 = r20;
        int r211 = r7;
        int r117 = r8;
        int r41 = r16;
        int r42 = 0;
    L129:
        if (r42 >= r41) goto L183;
        int r43 = 0;
    L131:
        if (r43 >= r21) goto L179;
        androidx.constraintlayout.a.c.e r44 = (androidx.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.f694a.get(r43), androidx.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r44, androidx.constraintlayout.a.c.i.class) == false) goto L137;
        if (ZeusTransformUtils.instanceOf(r44, androidx.constraintlayout.a.c.m.class) == true) goto L137;
    L150:
        r21 = r21;
        r5 = r5;
        boolean r45 = r115;
    L178:
        r43 = r43 + 1;
        r0 = this;
        r115 = r45;
        r5 = r5;
        r21 = r21;
    L137:
        if (ZeusTransformUtils.instanceOf(r44, androidx.constraintlayout.a.c.h.class) == true) goto L150;
        if (r44.B() == 8) goto L150;
        if (r210 == false) goto L149;
        if (r44.f.g.j == false) goto L149;
        if (r44.g.g.j == true) goto L150;
    L149:
        if (ZeusTransformUtils.instanceOf(r44, androidx.constraintlayout.a.c.m.class) == true) goto L150;
        int r46 = r44.F();
        int r118 = r44.G();
        int r119 = r44.S();
        int r120 = a.f698b;
        if (r42 != 1) goto L154;
        r120 = a.f699c;
    L154:
        r45 = r0.a(r5, r44, r120) | r115;
        if (r24.aA == null) goto L158;
        r24.aA.f796b++;
    L158:
        int r47 = r44.F();
        int r48 = r44.G();
        if (r47 == r46) goto L166;
        r44.q(r47);
        if (r112 == true) goto L163;
    L165:
        r45 = true;
        goto L166
    L163:
        if (r44.L() <= r34) goto L165;
        r34 = Math.max(r34, r44.L() + r44.a(androidx.constraintlayout.a.c.d.a.f765d).i());
    L166:
        if (r48 == r118) goto L174;
        r44.r(r48);
        if (r23 == true) goto L170;
    L172:
        r45 = true;
        goto L174
    L170:
        if (r44.M() <= r113) goto L172;
        r113 = Math.max(r113, r44.M() + r44.a(androidx.constraintlayout.a.c.d.a.f766e).i());
    L174:
        if (r44.R() == false) goto L178;
        if (r119 == r44.S()) goto L178;
        r45 = true;
        goto L178
    L179:
        int r212 = r21;
        InterfaceC0012b r121 = r5;
        if (r115 == false) goto L183;
        r42 = r42 + 1;
        a(r24, "intermediate pass", r42, r211, r117);
        r0 = this;
        r5 = r121;
        r21 = r212;
        r41 = 2;
        r115 = false;
    L183:
        r22 = r310;
        goto L185
    L101:
        r23 = false;
        goto L102
    L97:
        r112 = false;
    L69:
        boolean r122 = r1.g(r9);
        if (r28 != 1073741824) goto L72;
        r122 = r122 & r1.a(r9, 0);
        r110 = 1;
    L73:
        if (r30 != 1073741824) goto L75;
        r19 = r1.a(r9, 1) & r122;
        r110 = r110 + 1;
        goto L76
    L75:
        r19 = r122;
        goto L76
    L72:
        r110 = 0;
        goto L73
    L64:
        if (r24.G() == r18) goto L66;
        r1.r(r18);
        r24.b();
        goto L66
    L60:
        if (r24.F() == r17) goto L62;
        r1.q(r17);
        r24.b();
        goto L62
    L84:
        r19 = false;
        r110 = 0;
    L52:
        if (r9 == true) goto L53;
        r15 = false;
        goto L55
    L5:
        if (androidx.constraintlayout.a.c.k.a(r25, 64) == true) goto L8;
        r2 = false;
        goto L10
    }

    private boolean a(InterfaceC0012b r5, androidx.constraintlayout.a.c.e r6, int r7) {
        InterfaceC0012b r8 = (InterfaceC0012b) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0012b.class, "com.obric.aiagent.plugin");
        this.f695b.f700d = r6.aa();
        this.f695b.f701e = r6.ab();
        this.f695b.f = r6.F();
        this.f695b.g = r6.G();
        this.f695b.l = false;
        this.f695b.m = r7;
        if (this.f695b.f700d != androidx.constraintlayout.a.c.e.a.f777c) goto L5;
        boolean r9 = true;
    L7:
        if (this.f695b.f701e != androidx.constraintlayout.a.c.e.a.f777c) goto L9;
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
        r8.a(r6, this.f695b);
        r6.q(this.f695b.h);
        r6.r(this.f695b.i);
        r6.c(this.f695b.k);
        r6.u(this.f695b.j);
        this.f695b.m = a.f697a;
        return this.f695b.l;
    L28:
        if (r6.p[1] != 4) goto L30;
        this.f695b.f701e = androidx.constraintlayout.a.c.e.a.f775a;
        goto L30
    L24:
        if (r6.p[0] != 4) goto L26;
        this.f695b.f700d = androidx.constraintlayout.a.c.e.a.f775a;
        goto L26
    L18:
        if (r6.O <= 0.0f) goto L20;
        r1 = true;
        goto L22
    L13:
        if (r6.O <= 0.0f) goto L15;
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
