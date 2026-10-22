package com.obric.oui.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;

/* JADX INFO: compiled from: VirtualLayout.java */
/* JADX INFO: loaded from: classes4.dex */
public class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.obric.oui.constraintlayout.a.c.a.b.a f34770a;
    com.obric.oui.constraintlayout.a.c.a.b.InterfaceC0938b aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private boolean aK;
    private int aL;
    private int aM;

    public void b(int r1, int r2, int r3, int r4) {
    }

    public m() {
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0;
        this.aG = 0;
        this.aH = 0;
        this.aI = 0;
        this.aJ = 0;
        this.aK = false;
        this.aL = 0;
        this.aM = 0;
        this.f34770a = new com.obric.oui.constraintlayout.a.c.a.b.a();
        this.aB = null;
    }

    public void M(int r1) {
        this.aE = r1;
        this.aC = r1;
        this.aF = r1;
        this.aD = r1;
        this.aG = r1;
        this.aH = r1;
    }

    public void N(int r1) {
        this.aG = r1;
        this.aI = r1;
        this.aJ = r1;
    }

    public void O(int r1) {
        this.aH = r1;
    }

    public void P(int r1) {
        this.aE = r1;
        this.aI = r1;
    }

    public void a(boolean r3) {
        int r0 = this.aG;
        if (r0 <= 0) goto L5;
    L6:
        if (r3 == false) goto L8;
        this.aI = this.aH;
        this.aJ = r0;
        return;
    L8:
        this.aI = r0;
        this.aJ = this.aH;
        return;
    L5:
        if (this.aH > 0) goto L6;
    }

    public void Q(int r1) {
        this.aC = r1;
    }

    public void R(int r1) {
        this.aF = r1;
        this.aJ = r1;
    }

    public void S(int r1) {
        this.aD = r1;
    }

    public int b() {
        return this.aC;
    }

    public int c() {
        return this.aD;
    }

    public int f() {
        return this.aI;
    }

    public int g() {
        return this.aJ;
    }

    public void g(boolean r1) {
        this.aK = r1;
    }

    public boolean h() {
        return this.aK;
    }

    @Override // com.obric.oui.constraintlayout.a.c.j, com.obric.oui.constraintlayout.a.c.i
    public void a(f r1) {
        i();
    }

    public void i() {
        int r0 = 0;
    L4:
        if (r0 >= this.aA) goto L9;
        e r1 = this.az[r0];
        if (r1 == null) goto L8;
        r1.b(true);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public int af() {
        return this.aL;
    }

    public int ag() {
        return this.aM;
    }

    public void h(int r1, int r2) {
        this.aL = r1;
        this.aM = r2;
    }

    public boolean ah() {
        if (this.M == null) goto L5;
        com.obric.oui.constraintlayout.a.c.a.b.InterfaceC0938b r0 = ((f) ZeusTransformUtils.preCheckCast(this.M, f.class, "com.obric.aiagent.plugin")).g();
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        int r2 = 0;
    L10:
        boolean r4 = true;
        if (r2 >= this.aA) goto L38;
        e r3 = this.az[r2];
        if (r3 == null) goto L37;
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L37;
        e.a r5 = r3.x(0);
        e.a r6 = r3.x(1);
        if (r5 == e.a.f34758c) goto L21;
    L27:
        r4 = false;
    L28:
        if (r4 == true) goto L37;
        if (r5 != e.a.f34758c) goto L34;
        r5 = e.a.f34757b;
    L34:
        if (r6 != e.a.f34758c) goto L36;
        r6 = e.a.f34757b;
    L36:
        this.f34770a.f34681d = r5;
        this.f34770a.f34682e = r6;
        this.f34770a.f = r3.F();
        this.f34770a.g = r3.G();
        r0.a(r3, this.f34770a);
        r3.q(this.f34770a.h);
        r3.r(this.f34770a.i);
        r3.u(this.f34770a.j);
        goto L37
    L21:
        if (r3.n == 1) goto L27;
        if (r6 != e.a.f34758c) goto L27;
        if (r3.o == 1) goto L27;
    L37:
        r2 = r2 + 1;
        goto L10
    L38:
        return true;
    L5:
        r0 = null;
        goto L7
    }

    public void a(e r4, e.a r5, int r6, e.a r7, int r8) {
    L3:
        if (this.aB != null) goto L7;
        if (A() == null) goto L7;
        this.aB = ((f) ZeusTransformUtils.preCheckCast(A(), f.class, "com.obric.aiagent.plugin")).g();
    L7:
        this.f34770a.f34681d = r5;
        this.f34770a.f34682e = r7;
        this.f34770a.f = r6;
        this.f34770a.g = r8;
        this.aB.a(r4, this.f34770a);
        r4.q(this.f34770a.h);
        r4.r(this.f34770a.i);
        r4.c(this.f34770a.k);
        r4.u(this.f34770a.j);
    }

    public boolean a(HashSet<e> r4) {
        int r1 = 0;
    L4:
        if (r1 >= this.aA) goto L10;
        if (r4.contains(this.az[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
