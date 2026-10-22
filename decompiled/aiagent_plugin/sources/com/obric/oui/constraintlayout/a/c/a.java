package com.obric.oui.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: Barrier.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f34674a;
    private int aB;
    private boolean aC;
    private int aD;

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean a() {
        return true;
    }

    public a() {
        this.aB = 0;
        this.aC = true;
        this.aD = 0;
        this.f34674a = false;
    }

    public int b() {
        return this.aB;
    }

    public void a(int r1) {
        this.aB = r1;
    }

    public void a(boolean r1) {
        this.aC = r1;
    }

    public boolean c() {
        return this.aC;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean d() {
        return this.f34674a;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public boolean e() {
        return this.f34674a;
    }

    @Override // com.obric.oui.constraintlayout.a.c.j, com.obric.oui.constraintlayout.a.c.e
    public void a(e r2, HashMap<e, e> r3) {
        super.a(r2, r3);
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        this.aB = r4.aB;
        this.aC = r4.aC;
        this.aD = r4.aD;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public String toString() {
        String r0 = "[Barrier] " + C() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L10;
        e r2 = this.az[r1];
        if (r1 <= 0) goto L8;
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.C();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }

    public void f() {
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L21;
        e r2 = this.az[r1];
        if (this.aC == false) goto L8;
    L10:
        int r3 = this.aB;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L17;
    L18:
        r2.a(1, true);
    L20:
        r1 = r1 + 1;
        goto L4
    L17:
        if (r3 != 3) goto L20;
    L19:
        r2.a(0, true);
        goto L20
    L8:
        if (r2.a() == true) goto L10;
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void a(com.obric.oui.constraintlayout.a.d r13, boolean r14) {
        this.f34748J[0] = this.B;
        this.f34748J[2] = this.C;
        this.f34748J[1] = this.D;
        this.f34748J[3] = this.E;
        int r15 = 0;
    L4:
        if (r15 >= this.f34748J.length) goto L6;
        this.f34748J[r15].f = r13.a(this.f34748J[r15]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = this.aB;
        if (r16 >= 0) goto L9;
        return;
    L9:
        if (r16 >= 4) goto L130;
        d r17 = this.f34748J[this.aB];
        if (this.f34674a == true) goto L14;
        i();
    L14:
        if (this.f34674a == false) goto L24;
        this.f34674a = false;
        int r18 = this.aB;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L22;
        if (r18 == 2) goto L21;
        if (r18 == 3) goto L21;
        return;
    L21:
        r13.a(this.C.f, this.S);
        r13.a(this.E.f, this.S);
        return;
    L22:
        r13.a(this.B.f, this.R);
        r13.a(this.D.f, this.R);
        return;
    L24:
        int r5 = 0;
    L26:
        if (r5 >= this.aA) goto L53;
        e r6 = this.az[r5];
        if (this.aC == false) goto L30;
    L32:
        int r7 = this.aB;
        if (r7 == 0) goto L36;
        if (r7 == 1) goto L36;
    L42:
        int r8 = this.aB;
        if (r8 == 2) goto L46;
        if (r8 == 3) goto L46;
    L52:
        r5 = r5 + 1;
    L46:
        if (r6.ab() != e.a.f34758c) goto L52;
        if (r6.C.f34739c == null) goto L52;
        if (r6.E.f34739c == null) goto L52;
    L41:
        boolean r9 = true;
    L55:
        if (this.B.c() == false) goto L57;
    L60:
        boolean r10 = true;
    L62:
        if (this.C.c() == false) goto L64;
    L67:
        boolean r11 = true;
    L68:
        if (r9 == true) goto L79;
        int r12 = this.aB;
        if (r12 != 0) goto L72;
        if (r10 == false) goto L72;
    L78:
        boolean r19 = true;
    L80:
        int r20 = 5;
        if (r19 == true) goto L83;
        r20 = 4;
    L83:
        int r21 = 0;
    L85:
        if (r21 >= this.aA) goto L105;
        e r22 = this.az[r21];
        if (this.aC == false) goto L89;
    L91:
        com.obric.oui.constraintlayout.a.h r23 = r13.a(r22.f34748J[this.aB]);
        r22.f34748J[this.aB].f = r23;
        if (r22.f34748J[this.aB].f34739c != null) goto L94;
    L96:
        int r24 = 0;
    L97:
        int r110 = this.aB;
        if (r110 == 0) goto L102;
        if (r110 == 2) goto L102;
        r13.a(r17.f, r23, this.aD + r24, r9);
    L103:
        r13.c(r17.f, r23, this.aD + r24, r20);
    L104:
        r21 = r21 + 1;
    L102:
        r13.b(r17.f, r23, this.aD - r24, r9);
        goto L103
    L94:
        if (r22.f34748J[this.aB].f34739c.f34737a != this) goto L96;
        r24 = r22.f34748J[this.aB].f34740d + 0;
        goto L97
    L89:
        if (r22.a() == true) goto L91;
    L105:
        int r111 = this.aB;
        if (r111 != 0) goto L108;
        r13.c(this.D.f, this.B.f, 0, 8);
        r13.c(this.B.f, this.M.D.f, 0, 4);
        r13.c(this.B.f, this.M.B.f, 0, 0);
        return;
    L108:
        if (r111 != 1) goto L110;
        r13.c(this.B.f, this.D.f, 0, 8);
        r13.c(this.B.f, this.M.B.f, 0, 4);
        r13.c(this.B.f, this.M.D.f, 0, 0);
        return;
    L110:
        if (r111 != 2) goto L112;
        r13.c(this.E.f, this.C.f, 0, 8);
        r13.c(this.C.f, this.M.E.f, 0, 4);
        r13.c(this.C.f, this.M.C.f, 0, 0);
        return;
    L112:
        if (r111 != 3) goto L134;
        r13.c(this.C.f, this.E.f, 0, 8);
        r13.c(this.C.f, this.M.C.f, 0, 4);
        r13.c(this.C.f, this.M.E.f, 0, 0);
        return;
    L134:
        return;
    L72:
        if (r12 != 2) goto L74;
        if (r11 == true) goto L78;
    L74:
        if (r12 != 1) goto L76;
        if (r10 == true) goto L78;
    L76:
        if (r12 != 3) goto L79;
        if (r11 == true) goto L78;
    L79:
        r19 = false;
        goto L80
    L64:
        if (this.E.c() == true) goto L67;
        r11 = false;
        goto L68
    L57:
        if (this.D.c() == true) goto L60;
        r10 = false;
    L36:
        if (r6.aa() != e.a.f34758c) goto L42;
        if (r6.B.f34739c == null) goto L42;
        if (r6.D.f34739c == null) goto L42;
    L30:
        if (r6.a() == true) goto L32;
    L53:
        r9 = false;
        goto L55
    }

    public void b(int r1) {
        this.aD = r1;
    }

    public int g() {
        return this.aD;
    }

    public int h() {
        int r2 = this.aB;
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        return 0;
    L7:
        if (r2 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r2 == 3) goto L12;
        return -1;
    }

    public boolean i() {
        int r0 = 0;
        int r2 = 0;
        boolean r3 = true;
    L4:
        if (r2 >= this.aA) goto L23;
        e r4 = this.az[r2];
        if (this.aC == false) goto L8;
    L10:
        int r7 = this.aB;
        if (r7 == 0) goto L14;
        if (r7 == 1) goto L14;
    L16:
        int r8 = this.aB;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
    L22:
        r2 = r2 + 1;
    L20:
        if (r4.e() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r4.d() == true) goto L16;
    L8:
        if (r4.a() == true) goto L10;
    L23:
        if (r3 == true) goto L25;
    L63:
        return false;
    L25:
        if (this.aA <= 0) goto L63;
        int r5 = 0;
        boolean r6 = false;
    L28:
        if (r0 >= this.aA) goto L55;
        e r9 = this.az[r0];
        if (this.aC == false) goto L32;
    L34:
        if (r6 == true) goto L45;
        int r10 = this.aB;
        if (r10 != 0) goto L38;
        r5 = r9.a(d.a.f34744b).d();
    L44:
        r6 = true;
        goto L45
    L38:
        if (r10 != 1) goto L40;
        r5 = r9.a(d.a.f34746d).d();
        goto L44
    L40:
        if (r10 != 2) goto L42;
        r5 = r9.a(d.a.f34745c).d();
        goto L44
    L42:
        if (r10 != 3) goto L44;
        r5 = r9.a(d.a.f34747e).d();
    L45:
        int r11 = this.aB;
        if (r11 != 0) goto L48;
        r5 = Math.min(r5, r9.a(d.a.f34744b).d());
    L54:
        r0 = r0 + 1;
        goto L28
    L48:
        if (r11 != 1) goto L50;
        r5 = Math.max(r5, r9.a(d.a.f34746d).d());
        goto L54
    L50:
        if (r11 != 2) goto L52;
        r5 = Math.min(r5, r9.a(d.a.f34745c).d());
        goto L54
    L52:
        if (r11 != 3) goto L54;
        r5 = Math.max(r5, r9.a(d.a.f34747e).d());
        goto L54
    L32:
        if (r9.a() == true) goto L34;
    L55:
        int r12 = r5 + this.aD;
        int r1 = this.aB;
        if (r1 == 0) goto L60;
        if (r1 == 1) goto L60;
        b(r12, r12);
    L61:
        this.f34674a = true;
        return true;
    L60:
        a(r12, r12);
        goto L61
    }
}
