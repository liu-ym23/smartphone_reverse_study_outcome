package i1;

/* loaded from: classes.dex */
public final class v0 extends g1.s implements g1.o, a, x0 {
    public boolean D;
    public float H;
    public boolean I;
    public p7.k J;
    public boolean M;

    /* renamed from: k, reason: collision with root package name */
    public final i0 f4607k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4608l;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4611o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4612p;

    /* renamed from: s, reason: collision with root package name */
    public p7.k f4615s;

    /* renamed from: u, reason: collision with root package name */
    public Object f4617u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4618v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4619w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4620x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4621y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f4622z;

    /* renamed from: m, reason: collision with root package name */
    public int f4609m = Integer.MAX_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public int f4610n = Integer.MAX_VALUE;

    /* renamed from: q, reason: collision with root package name */
    public d0 f4613q = d0.f4435h;

    /* renamed from: r, reason: collision with root package name */
    public long f4614r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4616t = true;
    public final g0 A = new g0(this, 0);
    public final d0.e B = new d0.e(new v0[16]);
    public boolean C = true;
    public long E = d2.b.b(0, 0, 15);
    public final u0 F = new u0(this, 1);
    public final u0 G = new u0(this, 0);
    public long K = 0;
    public final u0 L = new u0(this, 2);

    public v0(i0 i0Var) {
        this.f4607k = i0Var;
    }

    @Override // i1.a
    public final g0 A() {
        return this.A;
    }

    @Override // i1.a
    public final void C() {
        f0.M(this.f4607k.f4493a, false, 7);
    }

    @Override // g1.s
    public final int E() {
        return this.f4607k.a().E();
    }

    @Override // g1.s
    public final int G() {
        return this.f4607k.a().G();
    }

    @Override // g1.s
    public final void M(long j2, float f10, p7.k kVar) throws Throwable {
        boolean z4;
        g1.r placementScope;
        i0 i0Var = this.f4607k;
        f0 f0Var = i0Var.f4493a;
        boolean z10 = true;
        try {
            this.f4619w = true;
            if (!d2.i.a(j2, this.f4614r) || this.M) {
                if (i0Var.f4502j || i0Var.f4501i || this.M) {
                    this.f4621y = true;
                    this.M = false;
                }
                T();
            }
            r0 r0Var = i0Var.f4508p;
            if (r0Var != null) {
                i0 i0Var2 = r0Var.f4567k;
                if (l.q(i0Var2.f4493a)) {
                    z4 = true;
                } else {
                    if (r0Var.f4577u == o0.f4555h) {
                        i0Var2.f4494b = true;
                    }
                    z4 = i0Var2.f4494b;
                }
                if (z4) {
                    d1 d1Var = i0Var.a().f4439v;
                    if (d1Var == null || (placementScope = d1Var.f4533q) == null) {
                        placementScope = ((j1.y) l.w(f0Var)).getPlacementScope();
                    }
                    r0 r0Var2 = i0Var.f4508p;
                    q7.k.b(r0Var2);
                    f0 f0VarN = f0Var.n();
                    if (f0VarN != null) {
                        f0VarN.I.f4499g = 0;
                    }
                    r0Var2.f4570n = Integer.MAX_VALUE;
                    g1.r.g(placementScope, r0Var2, (int) (j2 >> 32), (int) (4294967295L & j2));
                }
            }
            r0 r0Var3 = i0Var.f4508p;
            if (r0Var3 == null || r0Var3.f4572p) {
                z10 = false;
            }
            if (z10) {
                f1.a.b("Error: Placement happened before lookahead.");
            }
            Z(j2, kVar);
        } catch (Throwable th) {
            f0Var.P(th);
            throw null;
        }
    }

    public final void Q() {
        boolean z4 = this.f4618v;
        this.f4618v = true;
        f0 f0Var = this.f4607k.f4493a;
        a1 a1Var = f0Var.H;
        if (!z4) {
            ((r) a1Var.f4401g).M0();
            if (f0Var.k()) {
                f0.M(f0Var, true, 6);
            } else if (f0Var.I.f4496d) {
                f0.K(f0Var, true, 6);
            }
        }
        d1 d1Var = ((r) a1Var.f4401g).f4438u;
        for (d1 d1Var2 = (d1) a1Var.f4402h; !q7.k.a(d1Var2, d1Var) && d1Var2 != null; d1Var2 = d1Var2.f4438u) {
            if (d1Var2.M) {
                d1Var2.G0();
            }
        }
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            if (f0Var2.o() != Integer.MAX_VALUE) {
                f0Var2.I.f4507o.Q();
                f0.N(f0Var2);
            }
        }
    }

    public final void S() {
        if (this.f4618v) {
            this.f4618v = false;
            i0 i0Var = this.f4607k;
            a1 a1Var = i0Var.f4493a.H;
            d1 d1Var = ((r) a1Var.f4401g).f4438u;
            for (d1 d1Var2 = (d1) a1Var.f4402h; !q7.k.a(d1Var2, d1Var) && d1Var2 != null; d1Var2 = d1Var2.f4438u) {
                n0.l lVarB0 = d1Var2.B0(e1.g(1048576));
                if (lVarB0 != null && (lVarB0.f6797f.f6800i & 1048576) != 0) {
                    boolean zG = e1.g(1048576);
                    n0.l lVarZ0 = d1Var2.z0();
                    if (zG || (lVarZ0 = lVarZ0.f6801j) != null) {
                        for (n0.l lVarB02 = d1Var2.B0(zG); lVarB02 != null && (lVarB02.f6800i & 1048576) != 0; lVarB02 = lVarB02.f6802k) {
                            if ((lVarB02.f6799h & 1048576) != 0) {
                                n0.l lVarE = lVarB02;
                                d0.e eVar = null;
                                while (lVarE != null) {
                                    if ((lVarE.f6799h & 1048576) != 0 && (lVarE instanceof k)) {
                                        int i2 = 0;
                                        for (n0.l lVar = ((k) lVarE).f4514u; lVar != null; lVar = lVar.f6802k) {
                                            if ((lVar.f6799h & 1048576) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    lVarE = lVar;
                                                } else {
                                                    if (eVar == null) {
                                                        eVar = new d0.e(new n0.l[16]);
                                                    }
                                                    if (lVarE != null) {
                                                        eVar.b(lVarE);
                                                        lVarE = null;
                                                    }
                                                    eVar.b(lVar);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    lVarE = l.e(eVar);
                                }
                            }
                            if (lVarB02 != lVarZ0) {
                            }
                        }
                    }
                }
                d1Var2.S0();
            }
            d0.e eVarS = i0Var.f4493a.s();
            Object[] objArr = eVarS.f2749f;
            int i10 = eVarS.f2751h;
            for (int i11 = 0; i11 < i10; i11++) {
                ((f0) objArr[i11]).I.f4507o.S();
            }
        }
    }

    public final void T() {
        i0 i0Var = this.f4607k;
        if (i0Var.f4503k > 0) {
            d0.e eVarS = i0Var.f4493a.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                f0 f0Var = (f0) objArr[i10];
                i0 i0Var2 = f0Var.I;
                boolean z4 = i0Var2.f4501i;
                v0 v0Var = i0Var2.f4507o;
                if ((z4 || i0Var2.f4502j) && !v0Var.f4621y) {
                    f0Var.L(false);
                }
                v0Var.T();
            }
        }
    }

    public final void V() {
        this.I = true;
        i0 i0Var = this.f4607k;
        f0 f0VarN = i0Var.f4493a.n();
        float f10 = l().F;
        f0 f0Var = i0Var.f4493a;
        a1 a1Var = f0Var.H;
        d1 d1Var = (d1) a1Var.f4402h;
        r rVar = (r) a1Var.f4401g;
        while (d1Var != rVar) {
            q7.k.c(d1Var, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            x xVar = (x) d1Var;
            f10 += xVar.F;
            d1Var = xVar.f4438u;
        }
        if (f10 != this.H) {
            this.H = f10;
            if (f0VarN != null) {
                f0VarN.H();
            }
            if (f0VarN != null) {
                f0VarN.v();
            }
        }
        if (this.f4618v) {
            ((r) f0Var.H.f4401g).M0();
        } else {
            if (f0VarN != null) {
                f0VarN.v();
            }
            Q();
            if (this.f4608l && f0VarN != null) {
                f0VarN.L(false);
            }
        }
        if (f0VarN != null) {
            i0 i0Var2 = f0VarN.I;
            if (!this.f4608l && i0Var2.f4495c == b0.f4410h) {
                if (this.f4610n != Integer.MAX_VALUE) {
                    f1.a.b("Place was called on a node which was placed already");
                }
                int i2 = i0Var2.f4500h;
                this.f4610n = i2;
                i0Var2.f4500h = i2 + 1;
            }
        } else {
            this.f4610n = 0;
        }
        q();
    }

    public final void W(long j2) {
        i0 i0Var = this.f4607k;
        b0 b0Var = i0Var.f4495c;
        f0 f0Var = i0Var.f4493a;
        b0 b0Var2 = b0.f4412j;
        if (b0Var != b0Var2) {
            f1.a.b("layout state is not idle before measure starts");
        }
        this.E = j2;
        b0 b0Var3 = b0.f4408f;
        i0Var.f4495c = b0Var3;
        this.f4620x = false;
        m1 snapshotObserver = ((j1.y) l.w(f0Var)).getSnapshotObserver();
        snapshotObserver.a(f0Var, snapshotObserver.f4538c, this.F);
        if (i0Var.f4495c == b0Var3) {
            this.f4621y = true;
            this.f4622z = true;
            i0Var.f4495c = b0Var2;
        }
    }

    public final void Z(long j2, p7.k kVar) {
        i0 i0Var = this.f4607k;
        f0 f0Var = i0Var.f4493a;
        f0 f0Var2 = i0Var.f4493a;
        if (f0Var.P) {
            f1.a.a("place is called on a deactivated node");
        }
        i0Var.f4495c = b0.f4410h;
        this.f4614r = j2;
        this.f4615s = kVar;
        this.I = false;
        k1 k1VarW = l.w(f0Var2);
        if (this.f4621y || !this.f4618v) {
            this.A.f4483e = false;
            i0Var.f(false);
            this.J = kVar;
            this.K = j2;
            m1 snapshotObserver = ((j1.y) k1VarW).getSnapshotObserver();
            snapshotObserver.a(f0Var2, snapshotObserver.f4541f, this.L);
        } else {
            d1 d1VarA = i0Var.a();
            d1VarA.Q0(d2.i.c(j2, d1VarA.f3760j), 0.0f, kVar);
            V();
        }
        i0Var.f4495c = b0.f4412j;
        this.f4612p = true;
    }

    public final boolean a0(long j2) throws Throwable {
        i0 i0Var = this.f4607k;
        f0 f0Var = i0Var.f4493a;
        f0 f0Var2 = i0Var.f4493a;
        try {
            if (f0Var.P) {
                f1.a.a("measure is called on a deactivated node");
            }
            k1 k1VarW = l.w(f0Var2);
            f0 f0VarN = f0Var2.n();
            boolean z4 = true;
            f0Var2.G = f0Var2.G || (f0VarN != null && f0VarN.G);
            if (!f0Var2.k() && d2.a.b(this.f3759i, j2)) {
                ((j1.y) k1VarW).i(f0Var2, false);
                f0Var2.O();
                return false;
            }
            this.A.f4482d = false;
            d0.e eVarS = f0Var2.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                ((f0) objArr[i10]).I.f4507o.A.getClass();
            }
            this.f4611o = true;
            long j4 = i0Var.a().f3758h;
            P(j2);
            W(j2);
            if (d2.k.a(i0Var.a().f3758h, j4) && i0Var.a().f3756f == this.f3756f && i0Var.a().f3757g == this.f3757g) {
                z4 = false;
            }
            N((i0Var.a().f3757g & 4294967295L) | (i0Var.a().f3756f << 32));
            return z4;
        } catch (Throwable th) {
            f0Var.P(th);
            throw null;
        }
    }

    @Override // g1.o
    public final g1.s b(long j2) throws Throwable {
        d0 d0Var;
        i0 i0Var = this.f4607k;
        f0 f0Var = i0Var.f4493a;
        d0 d0Var2 = f0Var.E;
        d0 d0Var3 = d0.f4435h;
        if (d0Var2 == d0Var3) {
            f0Var.c();
        }
        if (l.q(i0Var.f4493a)) {
            r0 r0Var = i0Var.f4508p;
            q7.k.b(r0Var);
            r0Var.f4571o = d0Var3;
            r0Var.b(j2);
        }
        f0 f0Var2 = i0Var.f4493a;
        f0 f0VarN = f0Var2.n();
        if (f0VarN != null) {
            i0 i0Var2 = f0VarN.I;
            if (this.f4613q != d0Var3 && !f0Var2.G) {
                f1.a.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = i0Var2.f4495c.ordinal();
            if (iOrdinal == 0) {
                d0Var = d0.f4433f;
            } else {
                if (iOrdinal != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + i0Var2.f4495c);
                }
                d0Var = d0.f4434g;
            }
            this.f4613q = d0Var;
        } else {
            this.f4613q = d0Var3;
        }
        a0(j2);
        return this;
    }

    @Override // g1.s, g1.o
    public final Object g() {
        return this.f4617u;
    }

    @Override // i1.x0
    public final void i(boolean z4) {
        i0 i0Var = this.f4607k;
        if (z4 != i0Var.a().f4530n) {
            i0Var.a().f4530n = z4;
            this.M = true;
        }
    }

    @Override // i1.a
    public final void k(c1.w wVar) throws Throwable {
        d0.e eVarS = this.f4607k.f4493a.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            wVar.invoke(((f0) objArr[i10]).I.f4507o);
        }
    }

    @Override // i1.a
    public final r l() {
        return (r) this.f4607k.f4493a.H.f4401g;
    }

    @Override // i1.a
    public final a m() {
        i0 i0Var;
        f0 f0VarN = this.f4607k.f4493a.n();
        if (f0VarN == null || (i0Var = f0VarN.I) == null) {
            return null;
        }
        return i0Var.f4507o;
    }

    @Override // i1.a
    public final void q() {
        this.D = true;
        g0 g0Var = this.A;
        g0Var.h();
        boolean z4 = this.f4621y;
        i0 i0Var = this.f4607k;
        if (z4) {
            d0.e eVarS = i0Var.f4493a.s();
            Object[] objArr = eVarS.f2749f;
            int i2 = eVarS.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                f0 f0Var = (f0) objArr[i10];
                if (f0Var.k() && f0Var.l() == d0.f4433f && f0.I(f0Var)) {
                    f0.M(i0Var.f4493a, false, 7);
                }
            }
        }
        if (this.f4622z || (!l().f4532p && this.f4621y)) {
            this.f4621y = false;
            b0 b0Var = i0Var.f4495c;
            i0Var.f4495c = b0.f4410h;
            i0Var.g(false);
            f0 f0Var2 = i0Var.f4493a;
            m1 snapshotObserver = ((j1.y) l.w(f0Var2)).getSnapshotObserver();
            snapshotObserver.a(f0Var2, snapshotObserver.f4540e, this.G);
            i0Var.f4495c = b0Var;
            if (l().f4532p && i0Var.f4501i) {
                requestLayout();
            }
            this.f4622z = false;
        }
        if (g0Var.f4480b && g0Var.e()) {
            g0Var.g();
        }
        this.D = false;
    }

    @Override // i1.a
    public final void requestLayout() {
        this.f4607k.f4493a.L(false);
    }

    @Override // i1.a
    public final boolean u() {
        return this.f4618v;
    }
}
