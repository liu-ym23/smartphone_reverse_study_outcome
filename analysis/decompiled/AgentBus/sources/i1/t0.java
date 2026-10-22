package i1;

/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f4595a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4597c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4598d;

    /* renamed from: i, reason: collision with root package name */
    public d2.a f4603i;

    /* renamed from: b, reason: collision with root package name */
    public final i5.l f4596b = new i5.l(12);

    /* renamed from: e, reason: collision with root package name */
    public final q6.b f4599e = new q6.b(12);

    /* renamed from: f, reason: collision with root package name */
    public final d0.e f4600f = new d0.e(new f0[16]);

    /* renamed from: g, reason: collision with root package name */
    public final long f4601g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final d0.e f4602h = new d0.e(new s0[16]);

    public t0(f0 f0Var) {
        this.f4595a = f0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(i1.f0 r5, d2.a r6) throws java.lang.Throwable {
        /*
            i1.f0 r0 = r5.f4458l
            i1.i0 r1 = r5.I
            r2 = 0
            if (r0 != 0) goto L8
            return r2
        L8:
            if (r6 == 0) goto L1a
            if (r0 == 0) goto L18
            i1.r0 r0 = r1.f4508p
            q7.k.b(r0)
            long r3 = r6.f2778a
            boolean r6 = r0.Z(r3)
            goto L2f
        L18:
            r6 = r2
            goto L2f
        L1a:
            i1.r0 r6 = r1.f4508p
            if (r6 == 0) goto L21
            d2.a r1 = r6.f4574r
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L18
            if (r0 == 0) goto L18
            q7.k.b(r6)
            long r0 = r1.f2778a
            boolean r6 = r6.Z(r0)
        L2f:
            i1.f0 r0 = r5.n()
            if (r6 == 0) goto L57
            if (r0 == 0) goto L57
            i1.f0 r1 = r0.f4458l
            r3 = 3
            if (r1 != 0) goto L40
            i1.f0.M(r0, r2, r3)
            return r6
        L40:
            i1.d0 r1 = r5.m()
            i1.d0 r4 = i1.d0.f4433f
            if (r1 != r4) goto L4c
            i1.f0.K(r0, r2, r3)
            return r6
        L4c:
            i1.d0 r5 = r5.m()
            i1.d0 r1 = i1.d0.f4434g
            if (r5 != r1) goto L57
            r0.J(r2)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.t0.b(i1.f0, d2.a):boolean");
    }

    public static boolean c(f0 f0Var, d2.a aVar) throws Throwable {
        boolean zI;
        if (aVar != null) {
            if (f0Var.E == d0.f4435h) {
                f0Var.c();
            }
            zI = f0Var.I.f4507o.a0(aVar.f2778a);
        } else {
            zI = f0.I(f0Var);
        }
        f0 f0VarN = f0Var.n();
        if (zI && f0VarN != null) {
            if (f0Var.l() == d0.f4433f) {
                f0.M(f0VarN, false, 3);
                return zI;
            }
            if (f0Var.l() == d0.f4434g) {
                f0VarN.L(false);
            }
        }
        return zI;
    }

    public static boolean f(f0 f0Var) {
        r0 r0Var;
        g0 g0Var;
        if (f0Var.I.f4496d) {
            return (f0Var.m() == d0.f4435h && ((r0Var = f0Var.I.f4508p) == null || (g0Var = r0Var.f4578v) == null || !g0Var.e())) ? false : true;
        }
        return false;
    }

    public static boolean g(f0 f0Var) {
        if (!f0Var.k()) {
            return false;
        }
        do {
            if (f0Var.l() == d0.f4435h && !f0Var.I.f4507o.A.e()) {
                f0 f0VarN = f0Var.n();
                if ((f0VarN != null ? f0VarN.I.f4495c : null) != b0.f4408f) {
                    return false;
                }
            }
            f0Var = f0Var.n();
            if (f0Var == null) {
                return false;
            }
        } while (!f0Var.C());
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
            r0 = 1
            q6.b r1 = r6.f4599e
            if (r7 == 0) goto L17
            java.lang.Object r7 = r1.f8788h
            d0.e r7 = (d0.e) r7
            i1.f0 r6 = r6.f4595a
            int r2 = r6.O
            if (r2 <= 0) goto L17
            r7.g()
            r7.b(r6)
            r6.N = r0
        L17:
            java.lang.Object r6 = r1.f8788h
            d0.e r6 = (d0.e) r6
            int r7 = r6.f2751h
            if (r7 == 0) goto L62
            i1.h1 r2 = i1.h1.f4491b
            java.lang.Object[] r3 = r6.f2749f
            r4 = 0
            d7.n.t0(r3, r2, r4, r7)
            int r7 = r6.f2751h
            java.lang.Object r2 = r1.f8787g
            i1.f0[] r2 = (i1.f0[]) r2
            if (r2 == 0) goto L32
            int r3 = r2.length
            if (r3 >= r7) goto L3a
        L32:
            r2 = 16
            int r2 = java.lang.Math.max(r2, r7)
            i1.f0[] r2 = new i1.f0[r2]
        L3a:
            r3 = 0
            r1.f8787g = r3
        L3d:
            if (r4 >= r7) goto L48
            java.lang.Object[] r5 = r6.f2749f
            r5 = r5[r4]
            r2[r4] = r5
            int r4 = r4 + 1
            goto L3d
        L48:
            r6.g()
            int r7 = r7 - r0
        L4c:
            r6 = -1
            if (r6 >= r7) goto L60
            r6 = r2[r7]
            q7.k.b(r6)
            boolean r0 = r6.N
            if (r0 == 0) goto L5b
            q6.b.C0(r6)
        L5b:
            r2[r7] = r3
            int r7 = r7 + (-1)
            goto L4c
        L60:
            r1.f8787g = r2
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.t0.a(boolean):void");
    }

    public final void d(f0 f0Var, boolean z4) {
        if (!this.f4597c) {
            f1.a.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (z4 ? f0Var.I.f4496d : f0Var.k()) {
            f1.a.a("node not yet measured");
        }
        e(f0Var, z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(i1.f0 r11, boolean r12) {
        /*
            r10 = this;
            d0.e r0 = r11.s()
            java.lang.Object[] r1 = r0.f2749f
            int r0 = r0.f2751h
            r2 = 0
            r3 = r2
        La:
            if (r3 >= r0) goto La7
            r4 = r1[r3]
            i1.f0 r4 = (i1.f0) r4
            r5 = 1
            if (r12 != 0) goto L28
            i1.d0 r6 = r4.l()
            i1.d0 r7 = i1.d0.f4433f
            if (r6 == r7) goto L42
            i1.i0 r6 = r4.I
            i1.v0 r6 = r6.f4507o
            i1.g0 r6 = r6.A
            boolean r6 = r6.e()
            if (r6 == 0) goto L28
            goto L42
        L28:
            if (r12 == 0) goto La3
            i1.d0 r6 = r4.m()
            i1.d0 r7 = i1.d0.f4433f
            if (r6 == r7) goto L42
            i1.i0 r6 = r4.I
            i1.r0 r6 = r6.f4508p
            if (r6 == 0) goto La3
            i1.g0 r6 = r6.f4578v
            if (r6 == 0) goto La3
            boolean r6 = r6.e()
            if (r6 != r5) goto La3
        L42:
            boolean r6 = i1.l.q(r4)
            i1.i0 r7 = r4.I
            if (r6 == 0) goto L87
            if (r12 != 0) goto L87
            boolean r6 = r7.f4496d
            if (r6 == 0) goto L84
            i5.l r6 = r10.f4596b
            r6.getClass()
            i1.f0 r8 = r4.f4458l
            if (r8 != 0) goto L5b
            r8 = r5
            goto L5c
        L5b:
            r8 = r2
        L5c:
            java.lang.Object r9 = r6.f4687g
            a7.d r9 = (a7.d) r9
            java.lang.Object r9 = r9.f411g
            i1.t1 r9 = (i1.t1) r9
            boolean r9 = r9.contains(r4)
            if (r9 != 0) goto L7b
            java.lang.Object r6 = r6.f4688h
            a7.d r6 = (a7.d) r6
            java.lang.Object r6 = r6.f411g
            i1.t1 r6 = (i1.t1) r6
            boolean r6 = r6.contains(r4)
            if (r6 == 0) goto L79
            goto L7b
        L79:
            r6 = r2
            goto L7c
        L7b:
            r6 = r5
        L7c:
            if (r8 != 0) goto L84
            if (r6 == 0) goto L84
            r10.j(r4, r5, r2)
            goto L87
        L84:
            r10.d(r4, r5)
        L87:
            if (r12 == 0) goto L8c
            boolean r5 = r7.f4496d
            goto L90
        L8c:
            boolean r5 = r4.k()
        L90:
            if (r5 == 0) goto L95
            r10.j(r4, r12, r2)
        L95:
            if (r12 == 0) goto L9a
            boolean r5 = r7.f4496d
            goto L9e
        L9a:
            boolean r5 = r4.k()
        L9e:
            if (r5 != 0) goto La3
            r10.e(r4, r12)
        La3:
            int r3 = r3 + 1
            goto La
        La7:
            if (r12 == 0) goto Lae
            i1.i0 r0 = r11.I
            boolean r0 = r0.f4496d
            goto Lb2
        Lae:
            boolean r0 = r11.k()
        Lb2:
            if (r0 == 0) goto Lb7
            r10.j(r11, r12, r2)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.t0.e(i1.f0, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final boolean h(j1.w wVar) {
        boolean z4;
        n0.l lVar;
        n0.l lVarE;
        boolean z10;
        f0 f0Var;
        boolean z11;
        i5.l lVar2 = this.f4596b;
        f0 f0Var2 = this.f4595a;
        if (!f0Var2.B()) {
            f1.a.a("performMeasureAndLayout called with unattached root");
        }
        if (!f0Var2.C()) {
            f1.a.a("performMeasureAndLayout called with unplaced root");
        }
        if (this.f4597c) {
            f1.a.a("performMeasureAndLayout called during measure layout");
        }
        boolean z12 = false;
        if (this.f4603i != null) {
            this.f4597c = true;
            this.f4598d = true;
            try {
                boolean zF = lVar2.F();
                a7.d dVar = (a7.d) lVar2.f4687g;
                if (zF) {
                    z4 = false;
                    while (true) {
                        a7.d dVar2 = (a7.d) lVar2.f4689i;
                        a7.d dVar3 = (a7.d) lVar2.f4688h;
                        if (!((t1) dVar.f411g).isEmpty()) {
                            f0Var = (f0) ((t1) dVar.f411g).first();
                            dVar.D(f0Var);
                            z11 = f0Var.f4458l != null;
                            z10 = false;
                        } else if (!((t1) dVar3.f411g).isEmpty()) {
                            f0Var = (f0) ((t1) dVar3.f411g).first();
                            dVar3.D(f0Var);
                            z11 = f0Var.f4458l != null;
                            z10 = true;
                        } else {
                            if (((t1) dVar2.f411g).isEmpty()) {
                                break;
                            }
                            f0 f0Var3 = (f0) ((t1) dVar2.f411g).first();
                            dVar2.D(f0Var3);
                            z10 = true;
                            f0Var = f0Var3;
                            z11 = false;
                        }
                        boolean zJ = j(f0Var, z11, z10);
                        if (!z10) {
                            if (f0Var.I.f4497e) {
                                lVar2.k(f0Var, s.f4584g);
                            }
                            if (f0Var.j()) {
                                lVar2.k(f0Var, s.f4586i);
                            }
                        }
                        if (f0Var == f0Var2 && zJ) {
                            z4 = true;
                        }
                    }
                    if (wVar != null) {
                        wVar.c();
                    }
                } else {
                    z4 = false;
                }
            } finally {
            }
        } else {
            z4 = false;
        }
        d0.e eVar = this.f4600f;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        int i10 = 0;
        while (i10 < i2) {
            a1 a1Var = ((f0) objArr[i10]).H;
            r rVar = (r) a1Var.f4401g;
            boolean zG = e1.g(128);
            if (zG) {
                lVar = rVar.S;
            } else {
                lVar = rVar.S.f6801j;
                if (lVar == null) {
                }
                i10++;
                z12 = false;
            }
            u0.a0 a0Var = d1.O;
            n0.l lVarB0 = rVar.B0(zG);
            while (lVarB0 != null && (lVarB0.f6800i & 128) != 0) {
                if ((lVarB0.f6799h & 128) != 0) {
                    k kVar = lVarB0;
                    d0.e eVar2 = null;
                    while (kVar != 0) {
                        if (kVar instanceof u) {
                            ((u) kVar).l((r) a1Var.f4401g);
                        } else {
                            if ((kVar.f6799h & 128) != 0 && (kVar instanceof k)) {
                                n0.l lVar3 = kVar.f4514u;
                                ?? r15 = z12;
                                lVarE = kVar;
                                eVar2 = eVar2;
                                while (lVar3 != null) {
                                    if ((lVar3.f6799h & 128) != 0) {
                                        r15++;
                                        eVar2 = eVar2;
                                        if (r15 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new d0.e(new n0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar3);
                                        }
                                    }
                                    lVar3 = lVar3.f6802k;
                                    lVarE = lVarE;
                                    eVar2 = eVar2;
                                    r15 = r15;
                                }
                                if (r15 == 1) {
                                }
                            }
                            z12 = false;
                            kVar = lVarE;
                            eVar2 = eVar2;
                        }
                        lVarE = l.e(eVar2);
                        z12 = false;
                        kVar = lVarE;
                        eVar2 = eVar2;
                    }
                }
                if (lVarB0 != lVar) {
                    lVarB0 = lVarB0.f6802k;
                    z12 = false;
                }
            }
            i10++;
            z12 = false;
        }
        eVar.g();
        return z4;
    }

    public final void i() {
        i5.l lVar = this.f4596b;
        if (lVar.F()) {
            f0 f0Var = this.f4595a;
            if (!f0Var.B()) {
                f1.a.a("performMeasureAndLayout called with unattached root");
            }
            if (!f0Var.C()) {
                f1.a.a("performMeasureAndLayout called with unplaced root");
            }
            if (this.f4597c) {
                f1.a.a("performMeasureAndLayout called during measure layout");
            }
            if (this.f4603i != null) {
                this.f4597c = true;
                this.f4598d = false;
                try {
                    if (!((t1) ((a7.d) lVar.f4689i).f411g).isEmpty() && !((t1) ((a7.d) lVar.f4687g).f411g).isEmpty()) {
                        if (f0Var.f4458l != null) {
                            l(f0Var, true);
                        } else {
                            k(f0Var);
                        }
                    }
                    l(f0Var, false);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                        this.f4597c = false;
                        this.f4598d = false;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j(f0 f0Var, boolean z4, boolean z10) {
        d2.a aVar;
        boolean zC;
        f0 f0VarN;
        g1.r placementScope;
        r rVar;
        f0 f0VarN2;
        f0 f0VarN3;
        r0 r0Var;
        g0 g0Var;
        boolean z11 = f0Var.P;
        i0 i0Var = f0Var.I;
        boolean z12 = false;
        Object[] objArr = 0;
        if (z11 || (!f0Var.C() && !i0Var.f4507o.f4619w && !g(f0Var) && !q7.k.a(f0Var.D(), Boolean.TRUE) && !f(f0Var) && !i0Var.f4507o.A.e() && ((r0Var = i0Var.f4508p) == null || (g0Var = r0Var.f4578v) == null || !g0Var.e()))) {
            return false;
        }
        f0 f0Var2 = this.f4595a;
        if (f0Var == f0Var2) {
            aVar = this.f4603i;
            q7.k.b(aVar);
        } else {
            aVar = null;
        }
        if (z4) {
            zC = i0Var.f4496d ? b(f0Var, aVar) : false;
            if (z10 && ((zC || i0Var.f4497e) && q7.k.a(f0Var.D(), Boolean.TRUE))) {
                if (f0Var.E == d0.f4435h) {
                    f0Var.d();
                }
                r0 r0Var2 = i0Var.f4508p;
                q7.k.b(r0Var2);
                try {
                    r0Var2.f4568l = true;
                    if (!r0Var2.f4572p) {
                        f1.a.b("replace() called on item that was not placed");
                    }
                    r0Var2.B = false;
                    boolean zU = r0Var2.u();
                    r0Var2.W(r0Var2.f4575s, r0Var2.f4576t);
                    if (zU && !r0Var2.B && (f0VarN3 = r0Var2.f4567k.f4493a.n()) != null) {
                        f0VarN3.J(false);
                    }
                    r0Var2.f4568l = false;
                } catch (Throwable th) {
                    r0Var2.f4568l = false;
                    throw th;
                }
            }
        } else {
            zC = f0Var.k() ? c(f0Var, aVar) : false;
            if (z10 && f0Var.j() && (f0Var == f0Var2 || ((f0VarN2 = f0Var.n()) != null && f0VarN2.C() && i0Var.f4507o.f4619w))) {
                if (f0Var == f0Var2) {
                    if (f0Var.E == d0.f4435h) {
                        f0Var.d();
                    }
                    f0 f0VarN4 = f0Var.n();
                    if (f0VarN4 == null || (rVar = (r) f0VarN4.H.f4401g) == null || (placementScope = rVar.f4533q) == null) {
                        placementScope = ((j1.y) l.w(f0Var)).getPlacementScope();
                    }
                    g1.r.i(placementScope, i0Var.f4507o, 0, 0);
                } else {
                    if (f0Var.E == d0.f4435h) {
                        f0Var.d();
                    }
                    v0 v0Var = i0Var.f4507o;
                    i0 i0Var2 = v0Var.f4607k;
                    try {
                        v0Var.f4608l = true;
                        if (!v0Var.f4612p) {
                            f1.a.b("replace called on unplaced item");
                        }
                        boolean z13 = v0Var.f4618v;
                        v0Var.Z(v0Var.f4614r, v0Var.f4615s);
                        if (z13 && !v0Var.I && (f0VarN = i0Var2.f4493a.n()) != null) {
                            f0VarN.L(false);
                        }
                    } finally {
                    }
                }
                q6.b bVar = this.f4599e;
                bVar.getClass();
                if (f0Var.O > 0) {
                    ((d0.e) bVar.f8788h).b(f0Var);
                    f0Var.N = true;
                }
                ((j1.y) l.w(f0Var)).getRectManager().e(f0Var);
            }
        }
        d0.e eVar = this.f4602h;
        int i2 = eVar.f2751h;
        if (i2 != 0) {
            Object[] objArr2 = eVar.f2749f;
            for (int i10 = 0; i10 < i2; i10++) {
                s0 s0Var = (s0) objArr2[i10];
                f0 f0Var3 = s0Var.f4588a;
                boolean z14 = s0Var.f4590c;
                f0 f0Var4 = s0Var.f4588a;
                if (f0Var3.B()) {
                    if (s0Var.f4589b) {
                        f0.K(f0Var4, z14, 2);
                    } else {
                        f0.M(f0Var4, z14, 2);
                    }
                }
            }
            eVar.g();
        }
        return zC;
    }

    public final void k(f0 f0Var) throws Throwable {
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            f0 f0Var2 = (f0) objArr[i10];
            if (f0Var2.l() == d0.f4433f || f0Var2.I.f4507o.A.e()) {
                if (l.q(f0Var2)) {
                    l(f0Var2, true);
                } else {
                    k(f0Var2);
                }
            }
        }
    }

    public final void l(f0 f0Var, boolean z4) throws Throwable {
        d2.a aVar;
        if (f0Var.P) {
            return;
        }
        if (f0Var == this.f4595a) {
            aVar = this.f4603i;
            q7.k.b(aVar);
        } else {
            aVar = null;
        }
        if (z4) {
            b(f0Var, aVar);
        } else {
            c(f0Var, aVar);
        }
    }

    public final boolean m(f0 f0Var, boolean z4) {
        int iOrdinal = f0Var.I.f4495c.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 || iOrdinal == 3) {
                this.f4602h.b(new s0(f0Var, false, z4));
            } else {
                if (iOrdinal != 4) {
                    throw new a4.u();
                }
                if (!f0Var.k() || z4) {
                    f0Var.I.f4507o.f4620x = true;
                    if (!f0Var.P && (f0Var.C() || g(f0Var))) {
                        f0 f0VarN = f0Var.n();
                        if (f0VarN == null || !f0VarN.k()) {
                            this.f4596b.k(f0Var, s.f4585h);
                        }
                        if (!this.f4598d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void n(long j2) {
        d2.a aVar = this.f4603i;
        if (aVar == null ? false : d2.a.b(aVar.f2778a, j2)) {
            return;
        }
        if (this.f4597c) {
            f1.a.a("updateRootConstraints called while measuring");
        }
        this.f4603i = new d2.a(j2);
        f0 f0Var = this.f4595a;
        f0 f0Var2 = f0Var.f4458l;
        i0 i0Var = f0Var.I;
        if (f0Var2 != null) {
            i0Var.f4496d = true;
        }
        i0Var.f4507o.f4620x = true;
        this.f4596b.k(f0Var, f0Var2 != null ? s.f4583f : s.f4585h);
    }
}
