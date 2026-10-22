package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public g0 f13945a;

    /* renamed from: b, reason: collision with root package name */
    public p5.m f13946b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13947c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13948d;

    /* renamed from: e, reason: collision with root package name */
    public p5.c f13949e;

    /* renamed from: f, reason: collision with root package name */
    public m0.e f13950f;

    /* renamed from: g, reason: collision with root package name */
    public long f13951g;

    /* renamed from: h, reason: collision with root package name */
    public m0.e f13952h;
    public o2.a i;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(u1.g0 r5, o2.a r6) throws java.lang.Throwable {
        /*
            u1.g0 r0 = r5.f13794k
            u1.k0 r1 = r5.I
            r2 = 0
            if (r0 != 0) goto L8
            return r2
        L8:
            if (r6 == 0) goto L1a
            if (r0 == 0) goto L18
            u1.t0 r0 = r1.f13858q
            r0.getClass()
            long r3 = r6.f9108a
            boolean r6 = r0.h0(r3)
            goto L2f
        L18:
            r6 = r2
            goto L2f
        L1a:
            u1.t0 r6 = r1.f13858q
            if (r6 == 0) goto L21
            o2.a r1 = r6.f13929r
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L18
            if (r0 == 0) goto L18
            r6.getClass()
            long r0 = r1.f9108a
            boolean r6 = r6.h0(r0)
        L2f:
            u1.g0 r0 = r5.t()
            if (r6 == 0) goto L57
            if (r0 == 0) goto L57
            u1.g0 r1 = r0.f13794k
            r3 = 3
            if (r1 != 0) goto L40
            u1.g0.V(r0, r2, r3)
            return r6
        L40:
            u1.e0 r1 = r5.s()
            u1.e0 r4 = u1.e0.f13765c
            if (r1 != r4) goto L4c
            u1.g0.T(r0, r2, r3)
            return r6
        L4c:
            u1.e0 r5 = r5.s()
            u1.e0 r1 = u1.e0.f13766f
            if (r5 != r1) goto L57
            r0.S(r2)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.v0.b(u1.g0, o2.a):boolean");
    }

    public static boolean c(g0 g0Var, o2.a aVar) {
        boolean zN = aVar != null ? g0Var.N(aVar) : g0.O(g0Var);
        g0 g0VarT = g0Var.t();
        if (zN && g0VarT != null) {
            if (g0Var.r() == e0.f13765c) {
                g0.V(g0VarT, false, 3);
                return zN;
            }
            if (g0Var.r() == e0.f13766f) {
                g0VarT.U(false);
            }
        }
        return zN;
    }

    public static boolean h(g0 g0Var) {
        t0 t0Var;
        h0 h0Var;
        if (g0Var.I.f13847e) {
            return (g0Var.s() == e0.f13767g && ((t0Var = g0Var.I.f13858q) == null || (h0Var = t0Var.f13933v) == null || !h0Var.e())) ? false : true;
        }
        return false;
    }

    public static boolean i(g0 g0Var) {
        if (!g0Var.q()) {
            return false;
        }
        do {
            if (g0Var.r() == e0.f13767g && !g0Var.I.f13857p.B.e()) {
                g0 g0VarT = g0Var.t();
                if ((g0VarT != null ? g0VarT.I.f13846d : null) != c0.f13736c) {
                    return false;
                }
            }
            g0Var = g0Var.t();
            if (g0Var == null) {
                return false;
            }
        } while (!g0Var.H());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r7) {
        /*
            r6 = this;
            p5.c r0 = r6.f13949e
            r1 = 1
            if (r7 == 0) goto L17
            u1.g0 r6 = r6.f13945a
            java.lang.Object r7 = r0.f9717f
            m0.e r7 = (m0.e) r7
            int r2 = r6.R
            if (r2 <= 0) goto L17
            r7.g()
            r7.b(r6)
            r6.Q = r1
        L17:
            java.lang.Object r6 = r0.f9717f
            m0.e r6 = (m0.e) r6
            int r7 = r6.f8160g
            if (r7 == 0) goto L62
            u1.k1 r2 = u1.k1.f13859f
            java.lang.Object[] r3 = r6.f8158c
            r4 = 0
            java.util.Arrays.sort(r3, r4, r7, r2)
            int r7 = r6.f8160g
            java.lang.Object r2 = r0.f9718g
            u1.g0[] r2 = (u1.g0[]) r2
            if (r2 == 0) goto L32
            int r3 = r2.length
            if (r3 >= r7) goto L3a
        L32:
            r2 = 16
            int r2 = java.lang.Math.max(r2, r7)
            u1.g0[] r2 = new u1.g0[r2]
        L3a:
            r3 = 0
            r0.f9718g = r3
        L3d:
            if (r4 >= r7) goto L48
            java.lang.Object[] r5 = r6.f8158c
            r5 = r5[r4]
            r2[r4] = r5
            int r4 = r4 + 1
            goto L3d
        L48:
            r6.g()
            int r7 = r7 - r1
        L4c:
            r6 = -1
            if (r6 >= r7) goto L60
            r6 = r2[r7]
            r6.getClass()
            boolean r1 = r6.Q
            if (r1 == 0) goto L5b
            p5.c.i(r6)
        L5b:
            r2[r7] = r3
            int r7 = r7 + (-1)
            goto L4c
        L60:
            r0.f9718g = r2
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.v0.a(boolean):void");
    }

    public final void d() {
        m0.e eVar = this.f13952h;
        int i = eVar.f8160g;
        if (i != 0) {
            Object[] objArr = eVar.f8158c;
            for (int i3 = 0; i3 < i; i3++) {
                u0 u0Var = (u0) objArr[i3];
                if (u0Var.f13942a.G()) {
                    boolean z10 = u0Var.f13943b;
                    g0 g0Var = u0Var.f13942a;
                    boolean z11 = u0Var.f13944c;
                    if (z10) {
                        g0.T(g0Var, z11, 2);
                    } else {
                        g0.V(g0Var, z11, 2);
                    }
                }
            }
            eVar.g();
        }
    }

    public final void e(g0 g0Var) {
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (yb.k.a(g0Var2.I(), Boolean.TRUE) && !g0Var2.S) {
                if (this.f13946b.u(g0Var2)) {
                    g0Var2.J();
                }
                e(g0Var2);
            }
        }
    }

    public final void f(g0 g0Var, boolean z10) {
        if (!this.f13947c) {
            r1.a.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z10 ? g0Var.I.f13847e : g0Var.q()) {
            r1.a.a("node not yet measured");
        }
        g(g0Var, z10);
    }

    public final void g(g0 g0Var, boolean z10) {
        t0 t0Var;
        h0 h0Var;
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if ((!z10 && (g0Var2.r() == e0.f13765c || g0Var2.I.f13857p.B.e())) || (z10 && (g0Var2.s() == e0.f13765c || ((t0Var = g0Var2.I.f13858q) != null && (h0Var = t0Var.f13933v) != null && h0Var.e())))) {
                boolean zQ = f.q(g0Var2);
                k0 k0Var = g0Var2.I;
                if (zQ && !z10) {
                    if (k0Var.f13847e && this.f13946b.u(g0Var2)) {
                        m(g0Var2, true, false);
                    } else {
                        f(g0Var2, true);
                    }
                }
                if (z10 ? k0Var.f13847e : g0Var2.q()) {
                    m(g0Var2, z10, false);
                }
                if (!(z10 ? k0Var.f13847e : g0Var2.q())) {
                    g(g0Var2, z10);
                }
            }
        }
        if (z10 ? g0Var.I.f13847e : g0Var.q()) {
            m(g0Var, z10, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final boolean j(v1.s sVar) {
        boolean z10;
        w0.l lVar;
        w0.l lVarE;
        boolean z11;
        g0 g0Var;
        boolean z12;
        p5.m mVar = this.f13946b;
        g0 g0Var2 = this.f13945a;
        if (!g0Var2.G()) {
            r1.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!g0Var2.H()) {
            r1.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f13947c) {
            r1.a.a("performMeasureAndLayout called during measure layout");
        }
        boolean z13 = false;
        if (this.i != null) {
            this.f13947c = true;
            this.f13948d = true;
            try {
                boolean zG = mVar.G();
                sa.c cVar = (sa.c) mVar.f9741f;
                if (zG) {
                    z10 = false;
                    while (true) {
                        sa.c cVar2 = (sa.c) mVar.f9743h;
                        sa.c cVar3 = (sa.c) mVar.f9742g;
                        if (!((w1) cVar.f12170f).isEmpty()) {
                            g0Var = (g0) ((w1) cVar.f12170f).first();
                            cVar.i(g0Var);
                            z12 = g0Var.f13794k != null;
                            z11 = false;
                        } else if (!((w1) cVar3.f12170f).isEmpty()) {
                            g0Var = (g0) ((w1) cVar3.f12170f).first();
                            cVar3.i(g0Var);
                            z12 = g0Var.f13794k != null;
                            z11 = true;
                        } else {
                            if (((w1) cVar2.f12170f).isEmpty()) {
                                break;
                            }
                            g0 g0Var3 = (g0) ((w1) cVar2.f12170f).first();
                            cVar2.i(g0Var3);
                            z11 = true;
                            g0Var = g0Var3;
                            z12 = false;
                        }
                        boolean zM = m(g0Var, z12, z11);
                        if (!z11) {
                            if (g0Var.I.f13848f) {
                                mVar.p(g0Var, t.f13918f);
                            }
                            if (g0Var.p()) {
                                mVar.p(g0Var, t.f13920h);
                            }
                        }
                        if (g0Var == g0Var2 && zM) {
                            z10 = true;
                        }
                    }
                    if (sVar != null) {
                        sVar.invoke();
                    }
                } else {
                    z10 = false;
                }
            } finally {
            }
        } else {
            z10 = false;
        }
        m0.e eVar = this.f13950f;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        int i3 = 0;
        while (i3 < i) {
            c1 c1Var = ((g0) objArr[i3]).H;
            s sVar2 = c1Var.f13743c;
            boolean zG2 = h1.g(128);
            if (zG2) {
                lVar = sVar2.R;
            } else {
                lVar = sVar2.R.i;
                if (lVar == null) {
                }
                i3++;
                z13 = false;
            }
            d1.g0 g0Var4 = g1.N;
            w0.l lVarJ0 = sVar2.J0(zG2);
            while (lVarJ0 != null && (lVarJ0.f15117h & 128) != 0) {
                if ((lVarJ0.f15116g & 128) != 0) {
                    m mVar2 = lVarJ0;
                    m0.e eVar2 = null;
                    while (mVar2 != 0) {
                        if (mVar2 instanceof v) {
                            ((v) mVar2).Z(c1Var.f13743c);
                        } else {
                            if ((mVar2.f15116g & 128) != 0 && (mVar2 instanceof m)) {
                                w0.l lVar2 = mVar2.f13866t;
                                ?? r15 = z13;
                                lVarE = mVar2;
                                eVar2 = eVar2;
                                while (lVar2 != null) {
                                    if ((lVar2.f15116g & 128) != 0) {
                                        r15++;
                                        eVar2 = eVar2;
                                        if (r15 == 1) {
                                            lVarE = lVar2;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar2);
                                        }
                                    }
                                    lVar2 = lVar2.f15118j;
                                    lVarE = lVarE;
                                    eVar2 = eVar2;
                                    r15 = r15;
                                }
                                if (r15 == 1) {
                                }
                            }
                            z13 = false;
                            mVar2 = lVarE;
                            eVar2 = eVar2;
                        }
                        lVarE = f.e(eVar2);
                        z13 = false;
                        mVar2 = lVarE;
                        eVar2 = eVar2;
                    }
                }
                if (lVarJ0 != lVar) {
                    lVarJ0 = lVarJ0.f15118j;
                    z13 = false;
                }
            }
            i3++;
            z13 = false;
        }
        eVar.g();
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, u1.g0] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void k(g0 g0Var, long j10) {
        w0.l lVar;
        g0 g0Var2 = this.f13945a;
        if (g0Var.S) {
            return;
        }
        if (g0Var.equals(g0Var2)) {
            r1.a.a("measureAndLayout called on root");
        }
        if (!g0Var2.G()) {
            r1.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!g0Var2.H()) {
            r1.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f13947c) {
            r1.a.a("performMeasureAndLayout called during measure layout");
        }
        if (this.i != null) {
            this.f13947c = true;
            this.f13948d = false;
            try {
                p5.m mVar = this.f13946b;
                ((sa.c) mVar.f9741f).i(g0Var);
                ((sa.c) mVar.f9742g).i(g0Var);
                ((sa.c) mVar.f9743h).i(g0Var);
                if ((b(g0Var, o2.a.a(j10)) || g0Var.I.f13848f) && yb.k.a(g0Var.I(), Boolean.TRUE)) {
                    g0Var.J();
                }
                e(g0Var);
                c(g0Var, o2.a.a(j10));
                if (g0Var.p() && g0Var.H()) {
                    g0Var.R();
                    p5.c cVar = this.f13949e;
                    cVar.getClass();
                    if (g0Var.R > 0) {
                        ((m0.e) cVar.f9717f).b(g0Var);
                        g0Var.Q = true;
                    }
                }
                d();
            } finally {
            }
        }
        m0.e eVar = this.f13950f;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            c1 c1Var = ((g0) objArr[i3]).H;
            s sVar = c1Var.f13743c;
            boolean zG = h1.g(128);
            if (zG) {
                lVar = sVar.R;
            } else {
                lVar = sVar.R.i;
                if (lVar == null) {
                }
            }
            d1.g0 g0Var3 = g1.N;
            for (w0.l lVarJ0 = sVar.J0(zG); lVarJ0 != null && (lVarJ0.f15117h & 128) != 0; lVarJ0 = lVarJ0.f15118j) {
                if ((lVarJ0.f15116g & 128) != 0) {
                    m mVarE = lVarJ0;
                    ?? eVar2 = 0;
                    while (mVarE != 0) {
                        if (mVarE instanceof v) {
                            ((v) mVarE).Z(c1Var.f13743c);
                        } else if ((mVarE.f15116g & 128) != 0 && (mVarE instanceof m)) {
                            w0.l lVar2 = mVarE.f13866t;
                            int i10 = 0;
                            mVarE = mVarE;
                            eVar2 = eVar2;
                            while (lVar2 != null) {
                                if ((lVar2.f15116g & 128) != 0) {
                                    i10++;
                                    eVar2 = eVar2;
                                    if (i10 == 1) {
                                        mVarE = lVar2;
                                    } else {
                                        if (eVar2 == 0) {
                                            eVar2 = new m0.e(new w0.l[16]);
                                        }
                                        if (mVarE != 0) {
                                            eVar2.b(mVarE);
                                            mVarE = 0;
                                        }
                                        eVar2.b(lVar2);
                                    }
                                }
                                lVar2 = lVar2.f15118j;
                                mVarE = mVarE;
                                eVar2 = eVar2;
                            }
                            if (i10 == 1) {
                            }
                        }
                        mVarE = f.e(eVar2);
                    }
                }
                if (lVarJ0 != lVar) {
                }
            }
        }
        eVar.g();
    }

    public final void l() {
        g0 g0Var = this.f13945a;
        p5.m mVar = this.f13946b;
        if (mVar.G()) {
            if (!g0Var.G()) {
                r1.a.a("performMeasureAndLayout called with unattached root");
            }
            if (!g0Var.H()) {
                r1.a.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.f13947c) {
                r1.a.a("performMeasureAndLayout called during measure layout");
            }
            if (this.i != null) {
                this.f13947c = true;
                this.f13948d = false;
                try {
                    if (!((w1) ((sa.c) mVar.f9743h).f12170f).isEmpty() && !((w1) ((sa.c) mVar.f9741f).f12170f).isEmpty()) {
                        if (g0Var.f13794k != null) {
                            o(g0Var, true);
                        } else {
                            n(g0Var);
                        }
                    }
                    o(g0Var, false);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        this.f13947c = false;
                        this.f13948d = false;
                    }
                }
            }
        }
    }

    public final boolean m(g0 g0Var, boolean z10, boolean z11) {
        o2.a aVar;
        boolean zB;
        s1.n0 placementScope;
        s sVar;
        g0 g0VarT;
        t0 t0Var;
        h0 h0Var;
        g0 g0Var2 = this.f13945a;
        boolean z12 = g0Var.S;
        k0 k0Var = g0Var.I;
        if (z12 || (!g0Var.H() && !k0Var.f13857p.f13970x && !i(g0Var) && !yb.k.a(g0Var.I(), Boolean.TRUE) && !h(g0Var) && !k0Var.f13857p.B.e() && ((t0Var = k0Var.f13858q) == null || (h0Var = t0Var.f13933v) == null || !h0Var.e()))) {
            return false;
        }
        if (g0Var == g0Var2) {
            aVar = this.i;
            aVar.getClass();
        } else {
            aVar = null;
        }
        if (z10) {
            zB = k0Var.f13847e ? b(g0Var, aVar) : false;
            if (z11 && ((zB || k0Var.f13848f) && yb.k.a(g0Var.I(), Boolean.TRUE))) {
                g0Var.J();
            }
        } else {
            boolean zC = g0Var.q() ? c(g0Var, aVar) : false;
            if (z11 && g0Var.p() && (g0Var == g0Var2 || ((g0VarT = g0Var.t()) != null && g0VarT.H() && k0Var.f13857p.f13970x))) {
                if (g0Var == g0Var2) {
                    if (g0Var.E == e0.f13767g) {
                        g0Var.f();
                    }
                    g0 g0VarT2 = g0Var.t();
                    if (g0VarT2 == null || (sVar = g0VarT2.H.f13743c) == null || (placementScope = sVar.f13883p) == null) {
                        placementScope = ((v1.t) j0.a(g0Var)).getPlacementScope();
                    }
                    s1.n0.l(placementScope, k0Var.f13857p, 0, 0);
                } else {
                    g0Var.R();
                }
                p5.c cVar = this.f13949e;
                cVar.getClass();
                if (g0Var.R > 0) {
                    ((m0.e) cVar.f9717f).b(g0Var);
                    g0Var.Q = true;
                }
                ((v1.t) j0.a(g0Var)).getRectManager().d(g0Var);
            }
            zB = zC;
        }
        d();
        return zB;
    }

    public final void n(g0 g0Var) throws Throwable {
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            g0 g0Var2 = (g0) objArr[i3];
            if (g0Var2.r() == e0.f13765c || g0Var2.I.f13857p.B.e()) {
                if (f.q(g0Var2)) {
                    o(g0Var2, true);
                } else {
                    n(g0Var2);
                }
            }
        }
    }

    public final void o(g0 g0Var, boolean z10) throws Throwable {
        o2.a aVar;
        if (g0Var.S) {
            return;
        }
        if (g0Var == this.f13945a) {
            aVar = this.i;
            aVar.getClass();
        } else {
            aVar = null;
        }
        if (z10) {
            b(g0Var, aVar);
        } else {
            c(g0Var, aVar);
        }
    }

    public final boolean p(g0 g0Var, boolean z10) {
        int iOrdinal = g0Var.I.f13846d.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                this.f13952h.b(new u0(g0Var, false, z10));
            } else {
                if (iOrdinal != 4) {
                    g5.f.a();
                    return false;
                }
                if (!g0Var.q() || z10) {
                    g0Var.I.f13857p.f13971y = true;
                    if (!g0Var.S && (g0Var.H() || i(g0Var))) {
                        g0 g0VarT = g0Var.t();
                        if (g0VarT == null || !g0VarT.q()) {
                            this.f13946b.p(g0Var, t.f13919g);
                        }
                        if (!this.f13948d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void q(long j10) {
        g0 g0Var = this.f13945a;
        o2.a aVar = this.i;
        if (aVar == null ? false : o2.a.c(aVar.f9108a, j10)) {
            return;
        }
        if (this.f13947c) {
            r1.a.a("updateRootConstraints called while measuring");
        }
        this.i = o2.a.a(j10);
        g0 g0Var2 = g0Var.f13794k;
        k0 k0Var = g0Var.I;
        if (g0Var2 != null) {
            k0Var.f13847e = true;
        }
        k0Var.f13857p.f13971y = true;
        this.f13946b.p(g0Var, g0Var2 != null ? t.f13917c : t.f13919g);
    }
}
