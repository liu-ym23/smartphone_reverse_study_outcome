package i1;

import b0.c2;
import b0.c3;
import fi.iki.elonen.NanoHTTPD;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 implements l1, h {
    public static final a0 Q = new a0();
    public static final z R = new z();
    public static final b0.q S = new b0.q(1);
    public d2.c A;
    public d2.l B;
    public j1.y1 C;
    public b0.b0 D;
    public d0 E;
    public d0 F;
    public boolean G;
    public final a1 H;
    public final i0 I;
    public d1 J;
    public boolean K;
    public n0.m L;
    public n0.m M;
    public boolean N;
    public int O;
    public boolean P;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4452f;

    /* renamed from: g, reason: collision with root package name */
    public int f4453g;

    /* renamed from: h, reason: collision with root package name */
    public long f4454h;

    /* renamed from: i, reason: collision with root package name */
    public long f4455i;

    /* renamed from: j, reason: collision with root package name */
    public long f4456j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4457k;

    /* renamed from: l, reason: collision with root package name */
    public f0 f4458l;

    /* renamed from: m, reason: collision with root package name */
    public int f4459m;

    /* renamed from: n, reason: collision with root package name */
    public final q6.b f4460n;

    /* renamed from: o, reason: collision with root package name */
    public d0.e f4461o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4462p;

    /* renamed from: q, reason: collision with root package name */
    public f0 f4463q;

    /* renamed from: r, reason: collision with root package name */
    public k1 f4464r;

    /* renamed from: s, reason: collision with root package name */
    public int f4465s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4466t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4467u;

    /* renamed from: v, reason: collision with root package name */
    public p1.i f4468v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4469w;

    /* renamed from: x, reason: collision with root package name */
    public final d0.e f4470x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4471y;

    /* renamed from: z, reason: collision with root package name */
    public g1.p f4472z;

    public f0(int i2) {
        this((i2 & 1) == 0, p1.j.f8308a.addAndGet(1));
    }

    public static boolean I(f0 f0Var) {
        v0 v0Var = f0Var.I.f4507o;
        d2.a aVar = v0Var.f4611o ? new d2.a(v0Var.f3759i) : null;
        if (aVar == null) {
            f0Var.getClass();
            return false;
        }
        if (f0Var.E == d0.f4435h) {
            f0Var.c();
        }
        return f0Var.I.f4507o.a0(aVar.f2778a);
    }

    public static void K(f0 f0Var, boolean z4, int i2) {
        f0 f0VarN;
        if ((i2 & 1) != 0) {
            z4 = false;
        }
        boolean z10 = (i2 & 4) != 0;
        if (f0Var.f4458l == null) {
            f1.a.b("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        k1 k1Var = f0Var.f4464r;
        if (k1Var == null || f0Var.f4466t || f0Var.f4452f) {
            return;
        }
        ((j1.y) k1Var).u(f0Var, true, z4);
        if (z10) {
            r0 r0Var = f0Var.I.f4508p;
            q7.k.b(r0Var);
            i0 i0Var = r0Var.f4567k;
            f0 f0VarN2 = i0Var.f4493a.n();
            d0 d0Var = i0Var.f4493a.E;
            if (f0VarN2 == null || d0Var == d0.f4435h) {
                return;
            }
            while (f0VarN2.E == d0Var && (f0VarN = f0VarN2.n()) != null) {
                f0VarN2 = f0VarN;
            }
            int iOrdinal = d0Var.ordinal();
            if (iOrdinal == 0) {
                if (f0VarN2.f4458l != null) {
                    K(f0VarN2, z4, 6);
                    return;
                } else {
                    M(f0VarN2, z4, 6);
                    return;
                }
            }
            if (iOrdinal != 1) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            if (f0VarN2.f4458l != null) {
                f0VarN2.J(z4);
            } else {
                f0VarN2.L(z4);
            }
        }
    }

    public static void M(f0 f0Var, boolean z4, int i2) {
        k1 k1Var;
        f0 f0VarN;
        if ((i2 & 1) != 0) {
            z4 = false;
        }
        boolean z10 = (i2 & 4) != 0;
        if (f0Var.f4466t || f0Var.f4452f || (k1Var = f0Var.f4464r) == null) {
            return;
        }
        ((j1.y) k1Var).u(f0Var, false, z4);
        if (z10) {
            i0 i0Var = f0Var.I.f4507o.f4607k;
            f0 f0VarN2 = i0Var.f4493a.n();
            d0 d0Var = i0Var.f4493a.E;
            if (f0VarN2 == null || d0Var == d0.f4435h) {
                return;
            }
            while (f0VarN2.E == d0Var && (f0VarN = f0VarN2.n()) != null) {
                f0VarN2 = f0VarN;
            }
            int iOrdinal = d0Var.ordinal();
            if (iOrdinal == 0) {
                M(f0VarN2, z4, 6);
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent");
                }
                f0VarN2.L(z4);
            }
        }
    }

    public static void N(f0 f0Var) {
        i0 i0Var = f0Var.I;
        if (e0.$EnumSwitchMapping$0[i0Var.f4495c.ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + i0Var.f4495c);
        }
        if (i0Var.f4496d) {
            K(f0Var, true, 6);
            return;
        }
        if (i0Var.f4497e) {
            f0Var.J(true);
        }
        if (f0Var.k()) {
            M(f0Var, true, 6);
        } else if (f0Var.j()) {
            f0Var.L(true);
        }
    }

    private final String h(f0 f0Var) {
        StringBuilder sb2 = new StringBuilder("Cannot insert ");
        sb2.append(f0Var);
        sb2.append(" because it already has a parent or an owner. This tree: ");
        sb2.append(e(0));
        sb2.append(" Other tree: ");
        f0 f0Var2 = f0Var.f4463q;
        sb2.append(f0Var2 != null ? f0Var2.e(0) : null);
        return sb2.toString();
    }

    public final void A() {
        f0 f0Var;
        if (this.f4459m > 0) {
            this.f4462p = true;
        }
        if (!this.f4452f || (f0Var = this.f4463q) == null) {
            return;
        }
        f0Var.A();
    }

    public final boolean B() {
        return this.f4464r != null;
    }

    public final boolean C() {
        return this.I.f4507o.f4618v;
    }

    public final Boolean D() {
        r0 r0Var = this.I.f4508p;
        if (r0Var != null) {
            return Boolean.valueOf(r0Var.u());
        }
        return null;
    }

    public final void E(f0 f0Var) {
        if (f0Var.I.f4503k > 0) {
            this.I.d(r0.f4503k - 1);
        }
        if (this.f4464r != null) {
            f0Var.f();
        }
        f0Var.f4463q = null;
        if (f0Var.O > 0) {
            R(this.O - 1);
        }
        ((d1) f0Var.H.f4402h).f4439v = null;
        if (f0Var.f4452f) {
            this.f4459m--;
            d0.e eVar = (d0.e) f0Var.f4460n.f8788h;
            Object[] objArr = eVar.f2749f;
            int i2 = eVar.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                ((d1) ((f0) objArr[i10]).H.f4402h).f4439v = null;
            }
        }
        A();
        H();
    }

    public final void F() {
        this.f4457k = true;
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((f0) objArr[i10]).y();
        }
    }

    public final void G() {
        this.P = true;
        n0.l lVar = (u1) this.H.f4403i;
        for (n0.l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.f6801j) {
            if (lVar2.f6810s) {
                lVar2.g0();
            }
        }
        for (n0.l lVar3 = lVar; lVar3 != null; lVar3 = lVar3.f6801j) {
            if (lVar3.f6810s) {
                lVar3.i0();
            }
        }
        while (lVar != null) {
            if (lVar.f6810s) {
                lVar.c0();
            }
            lVar = lVar.f6801j;
        }
        if (B()) {
            this.f4468v = null;
            this.f4467u = false;
        }
        k1 k1Var = this.f4464r;
        if (k1Var != null) {
            j1.y yVar = (j1.y) k1Var;
            yVar.getRectManager().j(this);
            o0.b bVar = yVar.J;
            if (bVar == null || !bVar.f7178g.e(this.f4453g)) {
                return;
            }
            bVar.f7172a.w(bVar.f7174c, this.f4453g, false);
        }
    }

    public final void H() {
        if (!this.f4452f) {
            this.f4471y = true;
            return;
        }
        f0 f0VarN = n();
        if (f0VarN != null) {
            f0VarN.H();
        }
    }

    public final void J(boolean z4) {
        k1 k1Var;
        if (this.f4452f || (k1Var = this.f4464r) == null) {
            return;
        }
        ((j1.y) k1Var).v(this, true, z4);
    }

    public final void L(boolean z4) {
        k1 k1Var;
        if (this.f4452f || (k1Var = this.f4464r) == null) {
            return;
        }
        ((j1.y) k1Var).v(this, false, z4);
    }

    public final void O() {
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var = (f0) objArr[i10];
            d0 d0Var = f0Var.F;
            f0Var.E = d0Var;
            if (d0Var != d0.f4435h) {
                f0Var.O();
            }
        }
    }

    public final void P(Throwable th) throws Throwable {
        b0.b0 b0Var = this.D;
        c3 c3Var = m0.d.f6125a;
        j0.h hVar = (j0.h) b0Var;
        hVar.getClass();
        m0.c cVar = (m0.c) b0.b.o(hVar, c3Var);
        if (cVar == null) {
            throw th;
        }
        s7.a.m0(th, new c2(2, cVar, this));
        throw th;
    }

    public final void Q(d2.c cVar) {
        if (q7.k.a(this.A, cVar)) {
            return;
        }
        this.A = cVar;
        x();
        f0 f0VarN = n();
        if (f0VarN != null) {
            f0VarN.v();
        }
        w();
        for (n0.l lVar = (n0.l) this.H.f4404j; lVar != null; lVar = lVar.f6802k) {
            lVar.b();
        }
    }

    public final void R(int i2) {
        f0 f0VarN;
        f0 f0VarN2;
        int i10 = this.O;
        if (i10 != i2) {
            if (i2 > 0 && i10 == 0 && (f0VarN2 = n()) != null) {
                f0VarN2.R(f0VarN2.O + 1);
            }
            if (i2 == 0 && this.O > 0 && (f0VarN = n()) != null) {
                f0VarN.R(f0VarN.O - 1);
            }
            this.O = i2;
        }
    }

    public final void S(f0 f0Var) {
        if (q7.k.a(f0Var, this.f4458l)) {
            return;
        }
        this.f4458l = f0Var;
        i0 i0Var = this.I;
        if (f0Var != null) {
            if (i0Var.f4508p == null) {
                i0Var.f4508p = new r0(i0Var);
            }
            a1 a1Var = this.H;
            d1 d1Var = ((r) a1Var.f4401g).f4438u;
            for (d1 d1Var2 = (d1) a1Var.f4402h; !q7.k.a(d1Var2, d1Var) && d1Var2 != null; d1Var2 = d1Var2.f4438u) {
                d1Var2.u0();
            }
        } else {
            i0Var.f4508p = null;
            i0Var.f4497e = false;
            i0Var.f4496d = false;
        }
        x();
    }

    public final void T(n0.m mVar) {
        if (this.f4452f && this.L != n0.j.f6796a) {
            f1.a.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (this.P) {
            f1.a.a("modifier is updated when deactivated");
        }
        if (!B()) {
            this.M = mVar;
            return;
        }
        a(mVar);
        if (this.f4467u) {
            z();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final void U(j1.y1 y1Var) {
        if (q7.k.a(this.C, y1Var)) {
            return;
        }
        this.C = y1Var;
        n0.l lVar = (n0.l) this.H.f4404j;
        if ((lVar.f6800i & 16) != 0) {
            while (lVar != null) {
                if ((lVar.f6799h & 16) != 0) {
                    k kVarE = lVar;
                    ?? eVar = 0;
                    while (kVarE != 0) {
                        if (kVarE instanceof p1) {
                            ((p1) kVarE).I();
                        } else if ((kVarE.f6799h & 16) != 0 && (kVarE instanceof k)) {
                            n0.l lVar2 = kVarE.f4514u;
                            int i2 = 0;
                            kVarE = kVarE;
                            eVar = eVar;
                            while (lVar2 != null) {
                                if ((lVar2.f6799h & 16) != 0) {
                                    i2++;
                                    eVar = eVar;
                                    if (i2 == 1) {
                                        kVarE = lVar2;
                                    } else {
                                        if (eVar == 0) {
                                            eVar = new d0.e(new n0.l[16]);
                                        }
                                        if (kVarE != 0) {
                                            eVar.b(kVarE);
                                            kVarE = 0;
                                        }
                                        eVar.b(lVar2);
                                    }
                                }
                                lVar2 = lVar2.f6802k;
                                kVarE = kVarE;
                                eVar = eVar;
                            }
                            if (i2 == 1) {
                            }
                        }
                        kVarE = l.e(eVar);
                    }
                }
                if ((lVar.f6800i & 16) == 0) {
                    return;
                } else {
                    lVar = lVar.f6802k;
                }
            }
        }
    }

    public final void V() {
        if (this.f4459m <= 0 || !this.f4462p) {
            return;
        }
        this.f4462p = false;
        d0.e eVar = this.f4461o;
        if (eVar == null) {
            eVar = new d0.e(new f0[16]);
            this.f4461o = eVar;
        }
        eVar.g();
        d0.e eVar2 = (d0.e) this.f4460n.f8788h;
        Object[] objArr = eVar2.f2749f;
        int i2 = eVar2.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var = (f0) objArr[i10];
            if (f0Var.f4452f) {
                eVar.c(eVar.f2751h, f0Var.s());
            } else {
                eVar.b(f0Var);
            }
        }
        i0 i0Var = this.I;
        i0Var.f4507o.C = true;
        r0 r0Var = i0Var.f4508p;
        if (r0Var != null) {
            r0Var.f4580x = true;
        }
    }

    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v3, types: [i1.d1, n0.l] */
    public final void a(n0.m mVar) {
        ?? r72;
        a1 a1Var;
        z0 z0Var;
        d0.e eVar;
        boolean z4;
        boolean z10;
        boolean z11;
        d0.e eVar2;
        boolean z12;
        c1.w wVar;
        a1 a1Var2 = this.H;
        boolean zH = a1Var2.h(16);
        n0.l lVar = (u1) a1Var2.f4403i;
        boolean zH2 = a1Var2.h(NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        this.L = mVar;
        r rVar = (r) a1Var2.f4401g;
        f0 f0Var = (f0) a1Var2.f4399e;
        n0.l lVar2 = (n0.l) a1Var2.f4404j;
        z0 z0Var2 = (z0) a1Var2.f4400f;
        if (lVar2 == z0Var2) {
            f1.a.b("padChain called on already padded chain");
        }
        n0.l lVar3 = (n0.l) a1Var2.f4404j;
        lVar3.f6801j = z0Var2;
        z0Var2.f6802k = lVar3;
        d0.e eVar3 = a1Var2.f4396b;
        int i2 = eVar3 != null ? eVar3.f2751h : 0;
        d0.e eVar4 = a1Var2.f4397c;
        if (eVar4 == null) {
            eVar4 = new d0.e(new n0.k[16]);
        }
        d0.e eVar5 = a1Var2.f4398d;
        eVar5.b(mVar);
        c1.w wVar2 = null;
        while (true) {
            int i10 = eVar5.f2751h;
            if (i10 == 0) {
                break;
            }
            n0.m mVar2 = (n0.m) eVar5.j(i10 - 1);
            if (mVar2 instanceof n0.g) {
                n0.g gVar = (n0.g) mVar2;
                eVar5.b(gVar.f6793b);
                eVar5.b(gVar.f6792a);
            } else if (mVar2 instanceof n0.k) {
                eVar4.b(mVar2);
            } else {
                if (wVar2 == null) {
                    wVar = new c1.w(4, eVar4);
                    wVar2 = wVar;
                } else {
                    wVar = wVar2;
                }
                mVar2.b(wVar);
            }
        }
        int i11 = eVar4.f2751h;
        if (i11 == i2) {
            n0.l lVar4 = z0Var2.f6802k;
            int i12 = 0;
            while (lVar4 != null && i12 < i2) {
                if (eVar3 == null) {
                    throw m.x.i("expected prior modifier list to be non-empty");
                }
                n0.k kVar = (n0.k) eVar3.f2749f[i12];
                n0.k kVar2 = (n0.k) eVar4.f2749f[i12];
                if (q7.k.a(kVar, kVar2)) {
                    eVar2 = eVar3;
                    z12 = 2;
                } else {
                    eVar2 = eVar3;
                    z12 = kVar.getClass() == kVar2.getClass();
                }
                if (!z12) {
                    lVar4 = lVar4.f6801j;
                    break;
                }
                if (z12) {
                    a1.m(kVar, kVar2, lVar4);
                }
                lVar4 = lVar4.f6802k;
                i12++;
                eVar3 = eVar2;
            }
            eVar2 = eVar3;
            if (i12 >= i2) {
                a1Var2 = a1Var2;
                eVar3 = eVar2;
                z10 = false;
                a1Var = a1Var2;
                z0Var = z0Var2;
                eVar = eVar4;
                z4 = false;
                r72 = z10;
            } else {
                if (eVar2 == null) {
                    throw m.x.i("expected prior modifier list to be non-empty");
                }
                if (lVar4 == null) {
                    throw m.x.i("structuralUpdate requires a non-null tail");
                }
                boolean z13 = f0Var.M != null;
                n0.l lVar5 = lVar4;
                a1Var = a1Var2;
                eVar = eVar4;
                eVar3 = eVar2;
                z11 = false;
                a1Var.k(i12, eVar3, eVar, lVar5, !z13);
                z0Var = z0Var2;
                z4 = true;
                r72 = z11;
            }
        } else {
            r72 = 0;
            z11 = false;
            z10 = false;
            n0.m mVar3 = f0Var.M;
            if (mVar3 != null && i2 == 0) {
                n0.l lVarC = z0Var2;
                for (int i13 = 0; i13 < eVar4.f2751h; i13++) {
                    lVarC = a1.c((n0.k) eVar4.f2749f[i13], lVarC);
                }
                int i14 = 0;
                for (n0.l lVar6 = lVar.f6801j; lVar6 != null && lVar6 != z0Var2; lVar6 = lVar6.f6801j) {
                    i14 |= lVar6.f6799h;
                    lVar6.f6800i = i14;
                }
                a1Var = a1Var2;
                z0Var = z0Var2;
                eVar = eVar4;
                z4 = true;
                r72 = z11;
            } else if (i11 != 0) {
                if (eVar3 == null) {
                    eVar3 = new d0.e(new n0.k[16]);
                }
                a1Var = a1Var2;
                z0Var = z0Var2;
                eVar = eVar4;
                a1Var.k(0, eVar3, eVar, z0Var, !(mVar3 != null));
                z4 = true;
            } else {
                if (eVar3 == null) {
                    throw m.x.i("expected prior modifier list to be non-empty");
                }
                n0.l lVar7 = z0Var2.f6802k;
                for (int i15 = 0; lVar7 != null && i15 < eVar3.f2751h; i15++) {
                    lVar7 = a1.d(lVar7).f6802k;
                }
                f0 f0VarN = f0Var.n();
                rVar.f4439v = f0VarN != null ? (r) f0VarN.H.f4401g : null;
                a1Var2.f4402h = rVar;
                a1Var = a1Var2;
                z0Var = z0Var2;
                eVar = eVar4;
                z4 = false;
                r72 = z10;
            }
        }
        a1Var.f4396b = eVar;
        if (eVar3 != null) {
            eVar3.g();
        } else {
            eVar3 = r72;
        }
        a1Var.f4397c = eVar3;
        n0.l lVar8 = z0Var.f6802k;
        if (lVar8 != null) {
            lVar = lVar8;
        }
        lVar.f6801j = r72;
        z0Var.f6802k = r72;
        z0Var.f6800i = -1;
        z0Var.f6804m = r72;
        if (lVar == z0Var) {
            f1.a.b("trimChain did not update the head");
        }
        a1Var.f4404j = lVar;
        if (z4) {
            a1Var.l();
        }
        boolean zH3 = a1Var.h(16);
        boolean zH4 = a1Var.h(NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        this.I.j();
        if (this.f4458l == null && a1Var.h(512)) {
            S(this);
        }
        if (zH == zH3 && zH2 == zH4) {
            return;
        }
        q1.a rectManager = ((j1.y) l.w(this)).getRectManager();
        rectManager.getClass();
        if (B()) {
            ab.x xVar = rectManager.f8625a;
            int i16 = this.f4453g & 67108863;
            long[] jArr = (long[]) xVar.f669c;
            int i17 = xVar.f668b;
            for (int i18 = 0; i18 < jArr.length - 2 && i18 < i17; i18 += 3) {
                int i19 = i18 + 2;
                long j2 = jArr[i19];
                if ((((int) j2) & 67108863) == i16) {
                    jArr[i19] = (4611686018427387903L & j2) | ((zH4 ? 1L : 0L) * 4611686018427387904L) | ((zH3 ? 1L : 0L) * Long.MIN_VALUE);
                    return;
                }
            }
        }
    }

    public final void b(k1 k1Var) {
        f0 f0Var;
        p1.i iVarQ;
        if (this.f4464r != null) {
            f1.a.b("Cannot attach " + this + " as it already is attached.  Tree: " + e(0));
        }
        f0 f0Var2 = this.f4463q;
        if (f0Var2 != null && !q7.k.a(f0Var2.f4464r, k1Var)) {
            StringBuilder sb2 = new StringBuilder("Attaching to a different owner(");
            sb2.append(k1Var);
            sb2.append(") than the parent's owner(");
            f0 f0VarN = n();
            sb2.append(f0VarN != null ? f0VarN.f4464r : null);
            sb2.append("). This tree: ");
            sb2.append(e(0));
            sb2.append(" Parent tree: ");
            f0 f0Var3 = this.f4463q;
            sb2.append(f0Var3 != null ? f0Var3.e(0) : null);
            f1.a.b(sb2.toString());
        }
        f0 f0VarN2 = n();
        i0 i0Var = this.I;
        if (f0VarN2 == null) {
            i0Var.f4507o.f4618v = true;
            r0 r0Var = i0Var.f4508p;
            if (r0Var != null) {
                r0Var.f4577u = o0.f4553f;
            }
        }
        a1 a1Var = this.H;
        ((d1) a1Var.f4402h).f4439v = f0VarN2 != null ? (r) f0VarN2.H.f4401g : null;
        this.f4464r = k1Var;
        this.f4465s = (f0VarN2 != null ? f0VarN2.f4465s : -1) + 1;
        n0.m mVar = this.M;
        if (mVar != null) {
            a(mVar);
        }
        this.M = null;
        j1.y yVar = (j1.y) k1Var;
        yVar.getLayoutNodes().g(this.f4453g, this);
        f0 f0Var4 = this.f4463q;
        if (f0Var4 == null || (f0Var = f0Var4.f4458l) == null) {
            f0Var = this.f4458l;
        }
        S(f0Var);
        if (this.f4458l == null && a1Var.h(512)) {
            S(this);
        }
        if (!this.P) {
            for (n0.l lVar = (n0.l) a1Var.f4404j; lVar != null; lVar = lVar.f6802k) {
                lVar.b0();
            }
        }
        d0.e eVar = (d0.e) this.f4460n.f8788h;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((f0) objArr[i10]).b(k1Var);
        }
        if (!this.P) {
            a1Var.j();
        }
        x();
        if (f0VarN2 != null) {
            f0VarN2.x();
        }
        i0Var.j();
        if (!this.P && a1Var.h(8)) {
            z();
        }
        o0.b bVar = yVar.J;
        if (bVar == null || (iVarQ = q()) == null || !iVarQ.f8304f.b(p1.s.f8360q)) {
            return;
        }
        bVar.f7178g.a(this.f4453g);
        bVar.f7172a.w(bVar.f7174c, this.f4453g, true);
    }

    public final void c() {
        this.F = this.E;
        this.E = d0.f4435h;
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var = (f0) objArr[i10];
            if (f0Var.E != d0.f4435h) {
                f0Var.c();
            }
        }
    }

    public final void d() {
        this.F = this.E;
        this.E = d0.f4435h;
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var = (f0) objArr[i10];
            if (f0Var.E == d0.f4434g) {
                f0Var.d();
            }
        }
    }

    public final String e(int i2) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < i2; i10++) {
            sb2.append("  ");
        }
        sb2.append("|-");
        sb2.append(toString());
        sb2.append('\n');
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i11 = eVarS.f2751h;
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append(((f0) objArr[i12]).e(i2 + 1));
        }
        String string = sb2.toString();
        if (i2 != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final void f() {
        g0 g0Var;
        k1 k1Var = this.f4464r;
        if (k1Var == null) {
            StringBuilder sb2 = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            f0 f0VarN = n();
            sb2.append(f0VarN != null ? f0VarN.e(0) : null);
            f1.a.c(sb2.toString());
            throw new a4.u();
        }
        f0 f0VarN2 = n();
        i0 i0Var = this.I;
        if (f0VarN2 != null) {
            f0VarN2.v();
            f0VarN2.x();
            v0 v0Var = i0Var.f4507o;
            d0 d0Var = d0.f4435h;
            v0Var.f4613q = d0Var;
            r0 r0Var = i0Var.f4508p;
            if (r0Var != null) {
                r0Var.f4571o = d0Var;
            }
        }
        g0 g0Var2 = i0Var.f4507o.A;
        g0Var2.f4480b = true;
        g0Var2.f4481c = false;
        g0Var2.f4482d = false;
        g0Var2.f4483e = false;
        g0Var2.f4484f = null;
        r0 r0Var2 = i0Var.f4508p;
        if (r0Var2 != null && (g0Var = r0Var2.f4578v) != null) {
            g0Var.f4480b = true;
            g0Var.f4481c = false;
            g0Var.f4482d = false;
            g0Var.f4483e = false;
            g0Var.f4484f = null;
        }
        a1 a1Var = this.H;
        n0.l lVar = (u1) a1Var.f4403i;
        d1 d1Var = ((r) a1Var.f4401g).f4438u;
        for (d1 d1Var2 = (d1) a1Var.f4402h; !q7.k.a(d1Var2, d1Var) && d1Var2 != null; d1Var2 = d1Var2.f4438u) {
            d1Var2.S0();
        }
        for (n0.l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.f6801j) {
            if (lVar2.f6810s) {
                lVar2.i0();
            }
        }
        this.f4466t = true;
        d0.e eVar = (d0.e) this.f4460n.f8788h;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((f0) objArr[i10]).f();
        }
        this.f4466t = false;
        while (lVar != null) {
            if (lVar.f6810s) {
                lVar.c0();
            }
            lVar = lVar.f6801j;
        }
        j1.y yVar = (j1.y) k1Var;
        yVar.getLayoutNodes().f(this.f4453g);
        t0 t0Var = yVar.R;
        i5.l lVar3 = t0Var.f4596b;
        ((a7.d) lVar3.f4687g).D(this);
        ((a7.d) lVar3.f4688h).D(this);
        ((a7.d) lVar3.f4689i).D(this);
        ((d0.e) t0Var.f4599e.f8788h).i(this);
        yVar.K = true;
        yVar.getRectManager().j(this);
        o0.b bVar = yVar.J;
        if (bVar != null && bVar.f7178g.e(this.f4453g)) {
            bVar.f7172a.w(bVar.f7174c, this.f4453g, false);
        }
        this.f4464r = null;
        this.f4454h = 9223372034707292159L;
        S(null);
        this.f4465s = 0;
        v0 v0Var2 = i0Var.f4507o;
        v0Var2.f4610n = Integer.MAX_VALUE;
        v0Var2.f4609m = Integer.MAX_VALUE;
        v0Var2.f4618v = false;
        r0 r0Var3 = i0Var.f4508p;
        if (r0Var3 != null) {
            r0Var3.f4570n = Integer.MAX_VALUE;
            r0Var3.f4569m = Integer.MAX_VALUE;
            r0Var3.f4577u = o0.f4555h;
        }
        if (a1Var.h(8)) {
            p1.i iVar = this.f4468v;
            this.f4468v = null;
            this.f4467u = false;
            yVar.getSemanticsOwner().b(this, iVar);
            yVar.w();
        }
    }

    public final void g(u0.l lVar, x0.b bVar) {
        try {
            ((d1) this.H.f4402h).s0(lVar, bVar);
        } catch (Throwable th) {
            P(th);
            throw null;
        }
    }

    public final List i() {
        return s().f();
    }

    public final boolean j() {
        return this.I.f4507o.f4621y;
    }

    public final boolean k() {
        return this.I.f4507o.f4620x;
    }

    public final d0 l() {
        return this.I.f4507o.f4613q;
    }

    public final d0 m() {
        d0 d0Var;
        r0 r0Var = this.I.f4508p;
        return (r0Var == null || (d0Var = r0Var.f4571o) == null) ? d0.f4435h : d0Var;
    }

    public final f0 n() {
        f0 f0Var = this.f4463q;
        while (f0Var != null && f0Var.f4452f) {
            f0Var = f0Var.f4463q;
        }
        return f0Var;
    }

    public final int o() {
        return this.I.f4507o.f4610n;
    }

    @Override // i1.l1
    public final boolean p() {
        return B();
    }

    public final p1.i q() {
        if (B() && !this.P && this.H.h(8)) {
            return this.f4468v;
        }
        return null;
    }

    public final d0.e r() {
        boolean z4 = this.f4471y;
        d0.e eVar = this.f4470x;
        if (z4) {
            eVar.g();
            eVar.c(eVar.f2751h, s());
            d7.n.t0(eVar.f2749f, S, 0, eVar.f2751h);
            this.f4471y = false;
        }
        return eVar;
    }

    public final d0.e s() {
        V();
        if (this.f4459m == 0) {
            return (d0.e) this.f4460n.f8788h;
        }
        d0.e eVar = this.f4461o;
        q7.k.b(eVar);
        return eVar;
    }

    public final void t(long j2, p pVar, int i2, boolean z4) {
        a1 a1Var = this.H;
        d1 d1Var = (d1) a1Var.f4402h;
        u0.a0 a0Var = d1.O;
        ((d1) a1Var.f4402h).E0(d1.Q, d1Var.w0(j2), pVar, i2, z4);
    }

    public final String toString() {
        return j1.k0.s(this) + " children: " + ((d0.b) i()).f2743f.f2751h + " measurePolicy: " + this.f4472z + " deactivated: " + this.P;
    }

    public final void u(int i2, f0 f0Var) {
        if (f0Var.f4463q != null && f0Var.f4464r != null) {
            f1.a.b(h(f0Var));
        }
        f0Var.f4463q = this;
        q6.b bVar = this.f4460n;
        ((d0.e) bVar.f8788h).a(i2, f0Var);
        ((a8.c) bVar.f8787g).c();
        H();
        if (f0Var.f4452f) {
            this.f4459m++;
        }
        A();
        k1 k1Var = this.f4464r;
        if (k1Var != null) {
            f0Var.b(k1Var);
        }
        if (f0Var.I.f4503k > 0) {
            i0 i0Var = this.I;
            i0Var.d(i0Var.f4503k + 1);
        }
        if (f0Var.O > 0) {
            R(this.O + 1);
        }
    }

    public final void v() {
        if (this.K) {
            a1 a1Var = this.H;
            d1 d1Var = (r) a1Var.f4401g;
            d1 d1Var2 = ((d1) a1Var.f4402h).f4439v;
            this.J = null;
            while (true) {
                if (q7.k.a(d1Var, d1Var2)) {
                    break;
                }
                if ((d1Var != null ? d1Var.N : null) != null) {
                    this.J = d1Var;
                    break;
                }
                d1Var = d1Var != null ? d1Var.f4439v : null;
            }
        }
        d1 d1Var3 = this.J;
        if (d1Var3 != null && d1Var3.N == null) {
            throw m.x.i("layer was not set");
        }
        if (d1Var3 != null) {
            d1Var3.G0();
            return;
        }
        f0 f0VarN = n();
        if (f0VarN != null) {
            f0VarN.v();
        }
    }

    public final void w() {
        a1 a1Var = this.H;
        d1 d1Var = (d1) a1Var.f4402h;
        r rVar = (r) a1Var.f4401g;
        while (d1Var != rVar) {
            q7.k.c(d1Var, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            x xVar = (x) d1Var;
            j1 j1Var = xVar.N;
            if (j1Var != null) {
                j1Var.invalidate();
            }
            d1Var = xVar.f4438u;
        }
        j1 j1Var2 = ((r) a1Var.f4401g).N;
        if (j1Var2 != null) {
            j1Var2.invalidate();
        }
    }

    public final void x() {
        if (this.f4452f) {
            f0 f0VarN = n();
            if (f0VarN != null) {
                f0VarN.x();
                return;
            }
            return;
        }
        if (this.f4458l != null) {
            K(this, false, 7);
        } else {
            M(this, false, 7);
        }
    }

    public final void y() {
        if (d2.i.a(this.f4454h, 9223372034707292159L)) {
            return;
        }
        this.f4454h = 9223372034707292159L;
        d0.e eVarS = s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((f0) objArr[i10]).y();
        }
    }

    public final void z() {
        if (this.f4469w) {
            return;
        }
        if (((z0) this.H.f4400f).f6802k != null || this.M != null) {
            this.f4467u = true;
            return;
        }
        p1.i iVar = this.f4468v;
        this.f4469w = true;
        q7.v vVar = new q7.v();
        vVar.f8820f = new p1.i();
        m1 snapshotObserver = ((j1.y) l.w(this)).getSnapshotObserver();
        snapshotObserver.a(this, snapshotObserver.f4539d, new a8.e(6, this, vVar));
        this.f4469w = false;
        this.f4468v = (p1.i) vVar.f8820f;
        this.f4467u = false;
        j1.y yVar = (j1.y) l.w(this);
        yVar.getSemanticsOwner().b(this, iVar);
        yVar.w();
    }

    public f0(boolean z4, int i2) {
        this.f4452f = z4;
        this.f4453g = i2;
        this.f4454h = 9223372034707292159L;
        this.f4455i = 0L;
        this.f4456j = 9223372034707292159L;
        this.f4457k = true;
        this.f4460n = new q6.b(11, new d0.e(new f0[16]), new a8.c(10, this));
        this.f4470x = new d0.e(new f0[16]);
        this.f4471y = true;
        this.f4472z = Q;
        this.A = l.f4520b;
        this.B = d2.l.f2793f;
        this.C = R;
        b0.b0.f1106a.getClass();
        this.D = b0.a0.f1098b;
        d0 d0Var = d0.f4435h;
        this.E = d0Var;
        this.F = d0Var;
        this.H = new a1(this);
        this.I = new i0(this);
        this.K = true;
        this.L = n0.j.f6796a;
    }
}
