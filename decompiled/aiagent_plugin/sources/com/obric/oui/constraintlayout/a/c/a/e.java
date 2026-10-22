package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: DependencyGraph.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<m> f34685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.constraintlayout.a.c.f f34686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.oui.constraintlayout.a.c.f f34689e;
    private ArrayList<p> f;
    private ArrayList<m> g;
    private b.InterfaceC0938b h;
    private b.a i;

    public e(com.obric.oui.constraintlayout.a.c.f r2) {
        this.f34687c = true;
        this.f34688d = true;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.i = new b.a();
        this.f34685a = new ArrayList();
        this.f34686b = r2;
        this.f34689e = r2;
    }

    public void a(b.InterfaceC0938b r3) {
        this.h = (b.InterfaceC0938b) ZeusTransformUtils.wrapperContextForParams(r3, b.InterfaceC0938b.class, "com.obric.aiagent.plugin");
    }

    private int a(com.obric.oui.constraintlayout.a.c.f r8, int r9) {
        int r0 = this.f34685a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = Math.max(r1, ((m) ZeusTransformUtils.preCheckCast(this.f34685a.get(r3), m.class, "com.obric.aiagent.plugin")).a(r8, r9));
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }

    public boolean a(boolean r11) {
        boolean r0 = true;
        boolean r12 = r11 & true;
        if (this.f34687c == false) goto L5;
    L6:
        Iterator<com.obric.oui.constraintlayout.a.c.e> r1 = this.f34686b.aV.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        com.obric.oui.constraintlayout.a.c.e r4 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r4.z();
        r4.f34750b = false;
        r4.f.d();
        r4.g.d();
        goto L8
    L10:
        this.f34686b.z();
        this.f34686b.f34750b = false;
        this.f34686b.f.d();
        this.f34686b.g.d();
        this.f34688d = false;
    L12:
        if (a(this.f34689e) == false) goto L14;
        return false;
    L14:
        this.f34686b.o(0);
        this.f34686b.p(0);
        com.obric.oui.constraintlayout.a.c.e.a r2 = this.f34686b.x(0);
        com.obric.oui.constraintlayout.a.c.e.a r5 = this.f34686b.x(1);
        if (this.f34687c == false) goto L17;
        d();
    L17:
        int r6 = this.f34686b.D();
        int r7 = this.f34686b.E();
        this.f34686b.f.j.a(r6);
        this.f34686b.g.j.a(r7);
        a();
        if (r2 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L20;
    L21:
        if (r12 == false) goto L28;
        Iterator<p> r8 = this.f.iterator();
    L24:
        if (r8.hasNext() == false) goto L28;
        if (((p) ZeusTransformUtils.preCheckCast(r8.next(), p.class, "com.obric.aiagent.plugin")).a() == true) goto L24;
        r12 = false;
    L28:
        if (r12 == true) goto L30;
    L32:
        if (r12 == true) goto L34;
    L37:
        if (this.f34686b.L[0] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L39;
    L42:
        int r13 = this.f34686b.F() + r6;
        this.f34686b.f.k.a(r13);
        this.f34686b.f.g.a(r13 - r6);
        a();
        if (this.f34686b.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L45;
    L46:
        int r14 = this.f34686b.G() + r7;
        this.f34686b.g.k.a(r14);
        this.f34686b.g.g.a(r14 - r7);
    L47:
        a();
        boolean r15 = true;
    L48:
        Iterator<p> r9 = this.f.iterator();
    L50:
        if (r9.hasNext() == false) goto L57;
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9.next(), p.class, "com.obric.aiagent.plugin");
        if (r10.f34724d != this.f34686b) goto L56;
        if (r10.i == false) goto L50;
    L56:
        r10.e();
        goto L50
    L57:
        Iterator<p> r16 = this.f.iterator();
    L59:
        if (r16.hasNext() == false) goto L80;
        p r17 = (p) ZeusTransformUtils.preCheckCast(r16.next(), p.class, "com.obric.aiagent.plugin");
        if (r15 == true) goto L66;
        if (r17.f34724d == this.f34686b) goto L59;
    L66:
        if (r17.j.j == false) goto L67;
        if (r17.k.j == true) goto L74;
        if (ZeusTransformUtils.instanceOf(r17, j.class) == false) goto L67;
    L74:
        if (r17.g.j == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, c.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r17, j.class) == true) goto L59;
    L67:
        r0 = false;
    L80:
        this.f34686b.a(r2);
        this.f34686b.b(r5);
        return r0;
    L45:
        if (this.f34686b.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L47;
    L39:
        if (this.f34686b.L[0] == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L42;
        r15 = false;
        goto L48
    L34:
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L37;
        this.f34686b.b(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        com.obric.oui.constraintlayout.a.c.f r18 = this.f34686b;
        r18.r(a(r18, 1));
        this.f34686b.g.g.a(this.f34686b.G());
        goto L37
    L30:
        if (r2 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L32;
        this.f34686b.a(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        com.obric.oui.constraintlayout.a.c.f r19 = this.f34686b;
        r19.q(a(r19, 0));
        this.f34686b.f.g.a(this.f34686b.F());
        goto L32
    L20:
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L37;
    L5:
        if (this.f34688d == false) goto L12;
        goto L6
    }

    public boolean b(boolean r5) {
        if (this.f34687c == false) goto L10;
        Iterator<com.obric.oui.constraintlayout.a.c.e> r6 = this.f34686b.aV.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        com.obric.oui.constraintlayout.a.c.e r1 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        r1.z();
        r1.f34750b = false;
        r1.f.g.j = false;
        r1.f.i = false;
        r1.f.d();
        r1.g.g.j = false;
        r1.g.i = false;
        r1.g.d();
        goto L6
    L8:
        this.f34686b.z();
        this.f34686b.f34750b = false;
        this.f34686b.f.g.j = false;
        this.f34686b.f.i = false;
        this.f34686b.f.d();
        this.f34686b.g.g.j = false;
        this.f34686b.g.i = false;
        this.f34686b.g.d();
        d();
    L10:
        if (a(this.f34689e) == false) goto L12;
        return false;
    L12:
        this.f34686b.o(0);
        this.f34686b.p(0);
        this.f34686b.f.j.a(0);
        this.f34686b.g.j.a(0);
        return true;
    }

    public boolean a(boolean r11, int r12) {
        boolean r0 = true;
        boolean r13 = r11 & true;
        com.obric.oui.constraintlayout.a.c.e.a r1 = this.f34686b.x(0);
        com.obric.oui.constraintlayout.a.c.e.a r3 = this.f34686b.x(1);
        int r4 = this.f34686b.D();
        int r5 = this.f34686b.E();
        if (r13 == true) goto L5;
    L25:
        if (r12 != 0) goto L32;
        if (this.f34686b.L[0] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L29;
    L30:
        int r14 = this.f34686b.F() + r4;
        this.f34686b.f.k.a(r14);
        this.f34686b.f.g.a(r14 - r4);
    L38:
        boolean r15 = true;
    L39:
        a();
        Iterator<p> r6 = this.f.iterator();
    L41:
        if (r6.hasNext() == false) goto L51;
        p r7 = (p) ZeusTransformUtils.preCheckCast(r6.next(), p.class, "com.obric.aiagent.plugin");
        if (r7.h != r12) goto L41;
        if (r7.f34724d != this.f34686b) goto L50;
        if (r7.i == false) goto L41;
    L50:
        r7.e();
        goto L41
    L51:
        Iterator<p> r8 = this.f.iterator();
    L53:
        if (r8.hasNext() == false) goto L72;
        p r9 = (p) ZeusTransformUtils.preCheckCast(r8.next(), p.class, "com.obric.aiagent.plugin");
        if (r9.h != r12) goto L53;
        if (r15 == true) goto L62;
        if (r9.f34724d == this.f34686b) goto L53;
    L62:
        if (r9.j.j == false) goto L63;
        if (r9.k.j == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L53;
        if (r9.g.j == true) goto L53;
    L63:
        r0 = false;
    L72:
        this.f34686b.a(r1);
        this.f34686b.b(r3);
        return r0;
    L29:
        if (this.f34686b.L[0] == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L30;
    L36:
        r15 = false;
        goto L39
    L32:
        if (this.f34686b.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L34;
    L37:
        int r16 = this.f34686b.G() + r5;
        this.f34686b.g.k.a(r16);
        this.f34686b.g.g.a(r16 - r5);
        goto L38
    L34:
        if (this.f34686b.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L36;
    L5:
        if (r1 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L7;
    L8:
        Iterator<p> r10 = this.f.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        p r17 = (p) ZeusTransformUtils.preCheckCast(r10.next(), p.class, "com.obric.aiagent.plugin");
        if (r17.h != r12) goto L10;
        if (r17.a() == true) goto L10;
        r13 = false;
    L16:
        if (r12 != 0) goto L21;
        if (r13 == false) goto L25;
        if (r1 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L25;
        this.f34686b.a(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        com.obric.oui.constraintlayout.a.c.f r18 = this.f34686b;
        r18.q(a(r18, 0));
        this.f34686b.f.g.a(this.f34686b.F());
        goto L25
    L21:
        if (r13 == false) goto L25;
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L25;
        this.f34686b.b(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        com.obric.oui.constraintlayout.a.c.f r19 = this.f34686b;
        r19.r(a(r19, 1));
        this.f34686b.g.g.a(this.f34686b.G());
        goto L25
    L7:
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L25;
        goto L8
    }

    private void a(com.obric.oui.constraintlayout.a.c.e r2, com.obric.oui.constraintlayout.a.c.e.a r3, int r4, com.obric.oui.constraintlayout.a.c.e.a r5, int r6) {
        this.i.f34681d = r3;
        this.i.f34682e = r5;
        this.i.f = r4;
        this.i.g = r6;
        this.h.a(r2, this.i);
        r2.q(this.i.h);
        r2.r(this.i.i);
        r2.c(this.i.k);
        r2.u(this.i.j);
    }

    private boolean a(com.obric.oui.constraintlayout.a.c.f r13) {
        Iterator<com.obric.oui.constraintlayout.a.c.e> r0 = r13.aV.iterator();
    L4:
        if (r0.hasNext() == false) goto L161;
        com.obric.oui.constraintlayout.a.c.e r1 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.a.c.e.a r3 = r1.L[0];
        com.obric.oui.constraintlayout.a.c.e.a r4 = r1.L[1];
        if (r1.B() == 8) goto L7;
        if (r1.s >= 1.0f) goto L14;
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L14;
        r1.n = 2;
    L14:
        if (r1.v >= 1.0f) goto L19;
        if (r4 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L19;
        r1.o = 2;
    L19:
        if (r1.U() <= 0.0f) goto L45;
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L28;
        if (r4 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L25;
    L26:
        r1.n = 3;
        goto L45
    L25:
        if (r4 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L26;
    L28:
        if (r4 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L35;
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L32;
    L33:
        r1.o = 3;
        goto L45
    L32:
        if (r3 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L33;
    L35:
        if (r3 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L45;
        if (r4 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L45;
        if (r1.n != 0) goto L42;
        r1.n = 3;
    L42:
        if (r1.o != 0) goto L45;
        r1.o = 3;
    L45:
        if (r3 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L47;
    L53:
        com.obric.oui.constraintlayout.a.c.e.a r5 = r3;
        if (r4 == com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L56;
    L62:
        com.obric.oui.constraintlayout.a.c.e.a r8 = r4;
    L63:
        r1.f.f = r5;
        r1.f.f34723c = r1.n;
        r1.g.f = r8;
        r1.g.f34723c = r1.o;
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L70;
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L70;
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L70;
    L77:
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L104;
        if (r8 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L83;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L104;
    L83:
        if (r1.n == 3) goto L85;
        if (r1.n != 1) goto L92;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, r8, 0);
        r1.f.g.m = r1.F();
        goto L4
    L92:
        if (r1.n == 2) goto L94;
        if (r1.f34748J[0].f34739c == null) goto L102;
        if (r1.f34748J[1].f34739c != null) goto L104;
    L102:
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, r8, 0);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
        goto L4
    L94:
        if (r13.L[0] == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L97;
        if (r13.L[0] != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L104;
    L97:
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r1.s * r13.F()) + 0.5f), r8, r1.G());
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
        goto L4
    L85:
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L87;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0);
    L87:
        int r9 = r1.G();
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r9 * r1.P) + 0.5f), com.obric.oui.constraintlayout.a.c.e.a.f34756a, r9);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
    L104:
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L134;
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L110;
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L134;
    L110:
        if (r1.o == 3) goto L112;
        if (r1.o != 1) goto L122;
        a(r1, r5, 0, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0);
        r1.g.g.m = r1.G();
        goto L4
    L122:
        if (r1.o == 2) goto L124;
        if (r1.f34748J[2].f34739c == null) goto L132;
        if (r1.f34748J[3].f34739c != null) goto L134;
    L132:
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, r8, 0);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
        goto L4
    L124:
        if (r13.L[1] == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L127;
        if (r13.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L134;
    L127:
        float r2 = r1.v;
        a(r1, r5, r1.F(), com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r2 * r13.G()) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
        goto L4
    L112:
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L114;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0);
    L114:
        int r6 = r1.F();
        float r7 = r1.P;
        if (r1.V() != (-1)) goto L117;
        r7 = 1.0f / r7;
    L117:
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, r6, com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r6 * r7) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
    L134:
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L4;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L4;
        if (r1.n == 1) goto L151;
        if (r1.o == 1) goto L151;
        if (r1.o != 2) goto L4;
        if (r1.n != 2) goto L4;
        if (r13.L[0] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L4;
        if (r13.L[1] != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L4;
        float r10 = r1.s;
        float r11 = r1.v;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r10 * r13.F()) + 0.5f), com.obric.oui.constraintlayout.a.c.e.a.f34756a, (int) ((r11 * r13.G()) + 0.5f));
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
    L151:
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0, com.obric.oui.constraintlayout.a.c.e.a.f34757b, 0);
        r1.f.g.m = r1.F();
        r1.g.g.m = r1.G();
    L70:
        if (r8 == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L152;
        if (r8 == com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L152;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L77;
    L152:
        int r12 = r1.F();
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L155;
        int r14 = (r13.F() - r1.B.f34740d) - r1.D.f34740d;
        r5 = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
    L156:
        int r15 = r1.G();
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L159;
        int r16 = (r13.G() - r1.C.f34740d) - r1.E.f34740d;
        com.obric.oui.constraintlayout.a.c.e.a r17 = com.obric.oui.constraintlayout.a.c.e.a.f34756a;
    L160:
        a(r1, r5, r14, r17, r16);
        r1.f.g.a(r1.F());
        r1.g.g.a(r1.G());
        r1.f34750b = true;
        goto L4
    L159:
        r17 = r8;
        r16 = r15;
        goto L160
    L155:
        r14 = r12;
        goto L156
    L56:
        if (r1.o != 1) goto L62;
        if (r1.C.f34739c != null) goto L60;
    L61:
        r8 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        goto L63
    L60:
        if (r1.E.f34739c != null) goto L62;
    L47:
        if (r1.n != 1) goto L53;
        if (r1.B.f34739c != null) goto L51;
    L52:
        r3 = com.obric.oui.constraintlayout.a.c.e.a.f34757b;
        goto L53
    L51:
        if (r1.D.f34739c != null) goto L53;
    L7:
        r1.f34750b = true;
        goto L4
    L161:
        return false;
    }

    public void a() {
        Iterator<com.obric.oui.constraintlayout.a.c.e> r0 = this.f34686b.aV.iterator();
    L4:
        if (r0.hasNext() == false) goto L43;
        com.obric.oui.constraintlayout.a.c.e r1 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r1.f34750b == true) goto L4;
        boolean r3 = false;
        com.obric.oui.constraintlayout.a.c.e.a r8 = r1.L[0];
        com.obric.oui.constraintlayout.a.c.e.a r10 = r1.L[1];
        int r2 = r1.n;
        int r4 = r1.o;
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L11;
    L15:
        boolean r5 = true;
    L17:
        if (r10 != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L19;
    L21:
        r3 = true;
    L22:
        boolean r6 = r1.f.g.j;
        boolean r7 = r1.g.g.j;
        if (r6 == false) goto L26;
        if (r7 == false) goto L26;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, r1.f.g.g, com.obric.oui.constraintlayout.a.c.e.a.f34756a, r1.g.g.g);
        r1.f34750b = true;
    L39:
        if (r1.f34750b == false) goto L4;
        if (r1.g.f34711b == null) goto L4;
        r1.g.f34711b.a(r1.S());
    L26:
        if (r6 == false) goto L32;
        if (r3 == false) goto L32;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34756a, r1.f.g.g, com.obric.oui.constraintlayout.a.c.e.a.f34757b, r1.g.g.g);
        if (r10 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L31;
        r1.g.g.m = r1.G();
        goto L39
    L31:
        r1.g.g.a(r1.G());
        r1.f34750b = true;
    L32:
        if (r7 == false) goto L39;
        if (r5 == false) goto L39;
        a(r1, com.obric.oui.constraintlayout.a.c.e.a.f34757b, r1.f.g.g, com.obric.oui.constraintlayout.a.c.e.a.f34756a, r1.g.g.g);
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L37;
        r1.f.g.m = r1.F();
        goto L39
    L37:
        r1.f.g.a(r1.F());
        r1.f34750b = true;
        goto L39
    L19:
        if (r10 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L22;
        if (r4 != 1) goto L22;
    L11:
        if (r8 != com.obric.oui.constraintlayout.a.c.e.a.f34758c) goto L14;
        if (r2 == 1) goto L15;
    L14:
        r5 = false;
        goto L17
    }

    public void b() {
        this.f34687c = true;
    }

    public void c() {
        this.f34688d = true;
    }

    public void d() {
        a(this.f);
        this.f34685a.clear();
        m.f34705a = 0;
        a(this.f34686b.f, 0, this.f34685a);
        a(this.f34686b.g, 1, this.f34685a);
        this.f34687c = false;
    }

    public void a(ArrayList<p> r6) {
        r6.clear();
        this.f34689e.f.c();
        this.f34689e.g.c();
        r6.add(this.f34689e.f);
        r6.add(this.f34689e.g);
        Iterator<com.obric.oui.constraintlayout.a.c.e> r0 = this.f34689e.aV.iterator();
        HashSet r1 = null;
    L4:
        if (r0.hasNext() == false) goto L29;
        com.obric.oui.constraintlayout.a.c.e r2 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.a.c.h.class) == true) goto L7;
        if (r2.ac() == true) goto L11;
        r6.add(r2.f);
    L18:
        if (r2.ad() == true) goto L20;
        r6.add(r2.g);
    L27:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.a.c.j.class) == false) goto L4;
        r6.add(new k(r2));
        goto L4
    L20:
        if (r2.f34753e != null) goto L22;
        r2.f34753e = new c(r2, 1);
    L22:
        if (r1 != null) goto L24;
        r1 = new HashSet();
    L24:
        r1.add(r2.f34753e);
        goto L27
    L11:
        if (r2.f34752d != null) goto L13;
        r2.f34752d = new c(r2, 0);
    L13:
        if (r1 != null) goto L15;
        r1 = new HashSet();
    L15:
        r1.add(r2.f34752d);
        goto L18
    L7:
        r6.add(new j(r2));
        goto L4
    L29:
        if (r1 == null) goto L31;
        r6.addAll(r1);
    L31:
        Iterator<p> r3 = r6.iterator();
    L33:
        if (r3.hasNext() == false) goto L35;
        ((p) ZeusTransformUtils.preCheckCast(r3.next(), p.class, "com.obric.aiagent.plugin")).c();
        goto L33
    L35:
        Iterator<p> r7 = r6.iterator();
    L37:
        if (r7.hasNext() == false) goto L42;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r7.next(), p.class, "com.obric.aiagent.plugin");
        if (r4.f34724d == this.f34689e) goto L37;
        r4.f();
        goto L37
    }

    private void a(f r10, int r11, int r12, f r13, ArrayList<m> r14, m r15) {
        p r16 = r10.f34693d;
        if (r16.f34725e == null) goto L5;
        return;
    L5:
        if (r16 != this.f34686b.f) goto L7;
        return;
    L7:
        if (r16 == this.f34686b.g) goto L80;
        if (r15 != null) goto L11;
        r15 = new m(r16, r12);
        r14.add(r15);
    L11:
        r16.f34725e = r15;
        r15.a(r16);
        Iterator<d> r17 = r16.j.k.iterator();
    L13:
        if (r17.hasNext() == false) goto L17;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r17.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L13;
        a((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin"), r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator<d> r18 = r16.k.k.iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r18.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L19;
        a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin"), r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator<f> r8 = r16.j.l.iterator();
    L35:
        if (r8.hasNext() == false) goto L40;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r8.next(), f.class, "com.obric.aiagent.plugin");
        if (r2 != r13) goto L39;
        r15.f34707c = true;
    L39:
        a(r2, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator<f> r9 = r16.k.l.iterator();
    L42:
        if (r9.hasNext() == false) goto L47;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r9.next(), f.class, "com.obric.aiagent.plugin");
        if (r3 != r13) goto L46;
        r15.f34707c = true;
    L46:
        a(r3, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r16, n.class) == false) goto L79;
        Iterator<f> r19 = ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).f34710a.l.iterator();
    L52:
        if (r19.hasNext() == false) goto L81;
        a((f) ZeusTransformUtils.preCheckCast(r19.next(), f.class, "com.obric.aiagent.plugin"), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r16, n.class) == false) goto L33;
        Iterator<d> r20 = ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).f34710a.k.iterator();
    L29:
        if (r20.hasNext() == false) goto L33;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r20.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L29;
        a((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r11, 2, r13, r14, r15);
        goto L29
    }

    private void a(p r11, int r12, ArrayList<m> r13) {
        Iterator<d> r0 = r11.j.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, p.class) == false) goto L4;
        a(((p) ZeusTransformUtils.preCheckCast(r1, p.class, "com.obric.aiagent.plugin")).j, r12, 0, r11.k, r13, null);
        goto L4
    L7:
        a((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin"), r12, 0, r11.k, r13, null);
        goto L4
    L11:
        Iterator<d> r2 = r11.k.k.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L13;
        a(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin")).k, r12, 1, r11.j, r13, null);
        goto L13
    L16:
        a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"), r12, 1, r11.j, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator<d> r14 = ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin")).f34710a.k.iterator();
    L24:
        if (r14.hasNext() == false) goto L50;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r14.next(), d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L24;
        a((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"), r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }
}
