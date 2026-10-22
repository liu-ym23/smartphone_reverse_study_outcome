package s0;

import a4.u;
import android.view.View;
import fi.iki.elonen.NanoHTTPD;
import i1.a1;
import i1.d1;
import i1.f0;
import i1.u1;
import j1.y;
import m4.u0;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9167a = new int[2];

    public static final b A(int i2) {
        if (i2 == 1) {
            return new b(2);
        }
        if (i2 == 2) {
            return new b(1);
        }
        if (i2 == 17) {
            return new b(3);
        }
        if (i2 == 33) {
            return new b(5);
        }
        if (i2 == 66) {
            return new b(4);
        }
        if (i2 != 130) {
            return null;
        }
        return new b(6);
    }

    public static final Boolean B(int i2, m.q qVar, q qVar2, t0.c cVar) {
        int iOrdinal = qVar2.n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar2);
                if (qVarN == null) {
                    throw new IllegalStateException("ActiveParent must have a focusedChild");
                }
                int iOrdinal2 = qVarN.n0().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        Boolean boolB = B(i2, qVar, qVarN, cVar);
                        if (!q7.k.a(boolB, Boolean.FALSE)) {
                            return boolB;
                        }
                        if (cVar == null) {
                            if (qVarN.n0() != p.f9194g) {
                                throw new IllegalStateException("Searching for active node in inactive hierarchy");
                            }
                            q qVarG = g(qVarN);
                            if (qVarG == null) {
                                throw new IllegalStateException("ActiveParent must have a focusedChild");
                            }
                            cVar = j(qVarG);
                        }
                        return Boolean.valueOf(l(i2, qVar, qVar2, cVar));
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            throw new u();
                        }
                        throw new IllegalStateException("ActiveParent must have a focusedChild");
                    }
                }
                if (cVar == null) {
                    cVar = j(qVarN);
                }
                return Boolean.valueOf(l(i2, qVar, qVar2, cVar));
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return qVar2.m0().f9178a ? (Boolean) qVar.invoke(qVar2) : cVar == null ? Boolean.valueOf(i(qVar2, i2, qVar)) : Boolean.valueOf(z(i2, qVar, qVar2, cVar));
                }
                throw new u();
            }
        }
        return Boolean.valueOf(i(qVar2, i2, qVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a(s0.q r7, m.q r8) {
        /*
            s0.p r0 = r7.n0()
            int r0 = r0.ordinal()
            if (r0 == 0) goto L89
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r4) goto L37
            if (r0 == r3) goto L89
            if (r0 != r1) goto L31
            boolean r0 = w(r7, r8)
            if (r0 != 0) goto L7d
            s0.k r0 = r7.m0()
            boolean r0 = r0.f9178a
            if (r0 == 0) goto L2d
            java.lang.Object r7 = r8.invoke(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            goto L2e
        L2d:
            r7 = r2
        L2e:
            if (r7 == 0) goto L7c
            goto L7d
        L31:
            a4.u r7 = new a4.u
            r7.<init>()
            throw r7
        L37:
            s0.q r0 = n(r7)
            java.lang.String r5 = "ActiveParent must have a focusedChild"
            if (r0 == 0) goto L83
            s0.p r6 = r0.n0()
            int r6 = r6.ordinal()
            if (r6 == 0) goto L7e
            if (r6 == r4) goto L5b
            if (r6 == r3) goto L7e
            if (r6 == r1) goto L55
            a4.u r7 = new a4.u
            r7.<init>()
            throw r7
        L55:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r5)
            throw r7
        L5b:
            boolean r1 = a(r0, r8)
            if (r1 != 0) goto L7d
            boolean r7 = m(r7, r0, r3, r8)
            if (r7 != 0) goto L7d
            s0.k r7 = r0.m0()
            boolean r7 = r7.f9178a
            if (r7 == 0) goto L7c
            java.lang.Object r7 = r8.invoke(r0)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7c
            goto L7d
        L7c:
            return r2
        L7d:
            return r4
        L7e:
            boolean r7 = m(r7, r0, r3, r8)
            return r7
        L83:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r5)
            throw r7
        L89:
            boolean r7 = w(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.e.a(s0.q, m.q):boolean");
    }

    public static final boolean b(t0.c cVar, t0.c cVar2, t0.c cVar3, int i2) {
        float f10;
        float f11;
        boolean zC = c(i2, cVar3, cVar);
        float f12 = cVar3.f9657b;
        float f13 = cVar3.f9659d;
        float f14 = cVar3.f9656a;
        float f15 = cVar3.f9658c;
        float f16 = cVar.f9659d;
        float f17 = cVar.f9657b;
        float f18 = cVar.f9658c;
        float f19 = cVar.f9656a;
        if (zC || !c(i2, cVar2, cVar)) {
            return false;
        }
        if (i2 == 3) {
            if (f19 < f15) {
                return true;
            }
        } else if (i2 == 4) {
            if (f18 > f14) {
                return true;
            }
        } else if (i2 == 5) {
            if (f17 < f13) {
                return true;
            }
        } else {
            if (i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            if (f16 > f12) {
                return true;
            }
        }
        if (i2 == 3 || i2 == 4) {
            return true;
        }
        if (i2 == 3) {
            f10 = f19 - cVar2.f9658c;
        } else if (i2 == 4) {
            f10 = cVar2.f9656a - f18;
        } else if (i2 == 5) {
            f10 = f17 - cVar2.f9659d;
        } else {
            if (i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            f10 = cVar2.f9657b - f16;
        }
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (i2 == 3) {
            f11 = f19 - f14;
        } else if (i2 == 4) {
            f11 = f15 - f18;
        } else if (i2 == 5) {
            f11 = f17 - f12;
        } else {
            if (i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            f11 = f13 - f16;
        }
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        return f10 < f11;
    }

    public static final boolean c(int i2, t0.c cVar, t0.c cVar2) {
        if (i2 == 3 || i2 == 4) {
            return cVar.f9659d > cVar2.f9657b && cVar.f9657b < cVar2.f9659d;
        }
        if (i2 == 5 || i2 == 6) {
            return cVar.f9658c > cVar2.f9656a && cVar.f9656a < cVar2.f9658c;
        }
        throw new IllegalStateException("This function should only be used for 2-D focus search");
    }

    public static final t0.c d(View view, y yVar) {
        int[] iArr = f9167a;
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i10 = iArr[1];
        yVar.getLocationInWindow(iArr);
        float f10 = i2 - iArr[0];
        float f11 = i10 - iArr[1];
        return new t0.c(f10, f11, view.getWidth() + f10, view.getHeight() + f11);
    }

    public static final boolean e(q qVar, boolean z4) {
        int iOrdinal = qVar.n0().ordinal();
        if (iOrdinal == 0) {
            ((u0) ((y) i1.l.v(qVar)).getFocusOwner()).m(null);
            qVar.l0(p.f9193f, p.f9196i);
            return true;
        }
        if (iOrdinal == 1) {
            q qVarN = n(qVar);
            if (!(qVarN != null ? e(qVarN, z4) : true)) {
                return false;
            }
            qVar.l0(p.f9194g, p.f9196i);
            return true;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return true;
            }
            throw new u();
        }
        if (z4) {
            ((u0) ((y) i1.l.v(qVar)).getFocusOwner()).m(null);
            qVar.l0(p.f9195h, p.f9196i);
        }
        return z4;
    }

    public static final void f(q qVar, d0.e eVar) {
        if (!qVar.f6797f.f6810s) {
            f1.a.b("visitChildren called on an unattached node");
        }
        d0.e eVar2 = new d0.e(new n0.l[16]);
        n0.l lVar = qVar.f6797f;
        n0.l lVar2 = lVar.f6802k;
        if (lVar2 == null) {
            i1.l.b(eVar2, lVar);
        } else {
            eVar2.b(lVar2);
        }
        while (true) {
            int i2 = eVar2.f2751h;
            if (i2 == 0) {
                return;
            }
            n0.l lVarE = (n0.l) eVar2.j(i2 - 1);
            if ((lVarE.f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 0) {
                i1.l.b(eVar2, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        d0.e eVar3 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar2 = (q) lVarE;
                                if (qVar2.f6810s && !i1.l.u(qVar2).P) {
                                    if (qVar2.m0().f9178a) {
                                        eVar.b(qVar2);
                                    } else {
                                        f(qVar2, eVar);
                                    }
                                }
                            } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                int i10 = 0;
                                for (n0.l lVar3 = ((i1.k) lVarE).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                                    if ((lVar3.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                        i10++;
                                        if (i10 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar3 == null) {
                                                eVar3 = new d0.e(new n0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar3.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar3.b(lVar3);
                                        }
                                    }
                                }
                                if (i10 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar3);
                        }
                    } else {
                        lVarE = lVarE.f6802k;
                    }
                }
            }
        }
    }

    public static final q g(q qVar) {
        q qVar2 = (q) ((u0) ((y) i1.l.v(qVar)).getFocusOwner()).f6348h;
        if (qVar2 == null || !qVar2.f6810s) {
            return null;
        }
        return qVar2;
    }

    public static final q h(d0.e eVar, t0.c cVar, int i2) {
        t0.c cVarD;
        if (i2 == 3) {
            cVarD = cVar.d((cVar.f9658c - cVar.f9656a) + 1, 0.0f);
        } else if (i2 == 4) {
            cVarD = cVar.d(-((cVar.f9658c - cVar.f9656a) + 1), 0.0f);
        } else if (i2 == 5) {
            cVarD = cVar.d(0.0f, (cVar.f9659d - cVar.f9657b) + 1);
        } else {
            if (i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            cVarD = cVar.d(0.0f, -((cVar.f9659d - cVar.f9657b) + 1));
        }
        Object[] objArr = eVar.f2749f;
        int i10 = eVar.f2751h;
        q qVar = null;
        for (int i11 = 0; i11 < i10; i11++) {
            q qVar2 = (q) objArr[i11];
            if (r(qVar2)) {
                t0.c cVarJ = j(qVar2);
                if (o(cVarJ, cVarD, cVar, i2)) {
                    qVar = qVar2;
                    cVarD = cVarJ;
                }
            }
        }
        return qVar;
    }

    public static final boolean i(q qVar, int i2, p7.k kVar) {
        t0.c cVar;
        d0.e eVar = new d0.e(new q[16]);
        f(qVar, eVar);
        int i10 = eVar.f2751h;
        if (i10 <= 1) {
            q qVar2 = (q) (i10 == 0 ? null : eVar.f2749f[0]);
            if (qVar2 != null) {
                return ((Boolean) kVar.invoke(qVar2)).booleanValue();
            }
        } else {
            if (i2 == 7) {
                i2 = 4;
            }
            if (i2 == 4 || i2 == 6) {
                t0.c cVarJ = j(qVar);
                float f10 = cVarJ.f9656a;
                float f11 = cVarJ.f9657b;
                cVar = new t0.c(f10, f11, f10, f11);
            } else {
                if (i2 != 3 && i2 != 5) {
                    throw new IllegalStateException("This function should only be used for 2-D focus search");
                }
                t0.c cVarJ2 = j(qVar);
                float f12 = cVarJ2.f9658c;
                float f13 = cVarJ2.f9659d;
                cVar = new t0.c(f12, f13, f12, f13);
            }
            q qVarH = h(eVar, cVar, i2);
            if (qVarH != null) {
                return ((Boolean) kVar.invoke(qVarH)).booleanValue();
            }
        }
        return false;
    }

    public static final t0.c j(q qVar) {
        d1 d1Var = qVar.f6804m;
        return d1Var != null ? ib.k.w(d1Var).B(d1Var, false) : t0.c.f9655e;
    }

    public static final boolean k(q qVar, m.q qVar2) {
        int iOrdinal = qVar.n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN != null) {
                    return k(qVarN, qVar2) || m(qVar, qVarN, 1, qVar2);
                }
                throw new IllegalStateException("ActiveParent must have a focusedChild");
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return qVar.m0().f9178a ? ((Boolean) qVar2.invoke(qVar)).booleanValue() : x(qVar, qVar2);
                }
                throw new u();
            }
        }
        return x(qVar, qVar2);
    }

    public static final boolean l(int i2, m.q qVar, q qVar2, t0.c cVar) {
        if (z(i2, qVar, qVar2, cVar)) {
            return true;
        }
        Object obj = ((u0) ((y) i1.l.v(qVar2)).getFocusOwner()).f6348h;
        y(qVar2);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fe, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x019d A[EDGE_INSN: B:160:0x019d->B:127:0x019d BREAK  A[LOOP:5: B:89:0x012e->B:165:0x012e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0130  */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m(s0.q r12, s0.q r13, int r14, m.q r15) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.e.m(s0.q, s0.q, int, m.q):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0026, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final s0.q n(s0.q r8) {
        /*
            n0.l r0 = r8.f6797f
            boolean r0 = r0.f6810s
            r1 = 0
            if (r0 != 0) goto L9
            goto Lac
        L9:
            if (r0 != 0) goto L10
            java.lang.String r0 = "visitChildren called on an unattached node"
            f1.a.b(r0)
        L10:
            d0.e r0 = new d0.e
            r2 = 16
            n0.l[] r3 = new n0.l[r2]
            r0.<init>(r3)
            n0.l r8 = r8.f6797f
            n0.l r3 = r8.f6802k
            if (r3 != 0) goto L23
            i1.l.b(r0, r8)
            goto L26
        L23:
            r0.b(r3)
        L26:
            int r8 = r0.f2751h
            if (r8 == 0) goto Lac
            int r8 = r8 + (-1)
            java.lang.Object r8 = r0.j(r8)
            n0.l r8 = (n0.l) r8
            int r3 = r8.f6800i
            r3 = r3 & 1024(0x400, float:1.435E-42)
            if (r3 != 0) goto L3c
            i1.l.b(r0, r8)
            goto L26
        L3c:
            if (r8 == 0) goto L26
            int r3 = r8.f6799h
            r3 = r3 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto La9
            r3 = r1
        L45:
            if (r8 == 0) goto L26
            boolean r4 = r8 instanceof s0.q
            r5 = 1
            if (r4 == 0) goto L6e
            s0.q r8 = (s0.q) r8
            n0.l r4 = r8.f6797f
            boolean r4 = r4.f6810s
            if (r4 == 0) goto La4
            s0.p r4 = r8.n0()
            int r4 = r4.ordinal()
            if (r4 == 0) goto L6d
            if (r4 == r5) goto L6d
            r5 = 2
            if (r4 == r5) goto L6d
            r8 = 3
            if (r4 != r8) goto L67
            goto La4
        L67:
            a4.u r8 = new a4.u
            r8.<init>()
            throw r8
        L6d:
            return r8
        L6e:
            int r4 = r8.f6799h
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto La4
            boolean r4 = r8 instanceof i1.k
            if (r4 == 0) goto La4
            r4 = r8
            i1.k r4 = (i1.k) r4
            n0.l r4 = r4.f4514u
            r6 = 0
        L7e:
            if (r4 == 0) goto La1
            int r7 = r4.f6799h
            r7 = r7 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L9e
            int r6 = r6 + 1
            if (r6 != r5) goto L8c
            r8 = r4
            goto L9e
        L8c:
            if (r3 != 0) goto L95
            d0.e r3 = new d0.e
            n0.l[] r7 = new n0.l[r2]
            r3.<init>(r7)
        L95:
            if (r8 == 0) goto L9b
            r3.b(r8)
            r8 = r1
        L9b:
            r3.b(r4)
        L9e:
            n0.l r4 = r4.f6802k
            goto L7e
        La1:
            if (r6 != r5) goto La4
            goto L45
        La4:
            n0.l r8 = i1.l.e(r3)
            goto L45
        La9:
            n0.l r8 = r8.f6802k
            goto L3c
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.e.n(s0.q):s0.q");
    }

    public static final boolean o(t0.c cVar, t0.c cVar2, t0.c cVar3, int i2) {
        if (!p(i2, cVar, cVar3)) {
            return false;
        }
        if (p(i2, cVar2, cVar3) && !b(cVar3, cVar, cVar2, i2)) {
            return !b(cVar3, cVar2, cVar, i2) && q(i2, cVar3, cVar) < q(i2, cVar3, cVar2);
        }
        return true;
    }

    public static final boolean p(int i2, t0.c cVar, t0.c cVar2) {
        float f10 = cVar.f9657b;
        float f11 = cVar.f9659d;
        float f12 = cVar.f9656a;
        float f13 = cVar.f9658c;
        if (i2 == 3) {
            float f14 = cVar2.f9658c;
            float f15 = cVar2.f9656a;
            return (f14 > f13 || f15 >= f13) && f15 > f12;
        }
        if (i2 == 4) {
            float f16 = cVar2.f9656a;
            float f17 = cVar2.f9658c;
            return (f16 < f12 || f17 <= f12) && f17 < f13;
        }
        if (i2 == 5) {
            float f18 = cVar2.f9659d;
            float f19 = cVar2.f9657b;
            return (f18 > f11 || f19 >= f11) && f19 > f10;
        }
        if (i2 != 6) {
            throw new IllegalStateException("This function should only be used for 2-D focus search");
        }
        float f20 = cVar2.f9657b;
        float f21 = cVar2.f9659d;
        return (f20 < f10 || f21 <= f10) && f21 < f11;
    }

    public static final long q(int i2, t0.c cVar, t0.c cVar2) {
        float f10;
        float f11;
        float f12 = cVar2.f9657b;
        float f13 = cVar2.f9659d;
        float f14 = cVar2.f9656a;
        float f15 = cVar2.f9658c;
        if (i2 == 3) {
            f10 = cVar.f9656a - f15;
        } else if (i2 == 4) {
            f10 = f14 - cVar.f9658c;
        } else if (i2 == 5) {
            f10 = cVar.f9657b - f13;
        } else {
            if (i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            f10 = f12 - cVar.f9659d;
        }
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        long j2 = (long) f10;
        if (i2 == 3 || i2 == 4) {
            float f16 = cVar.f9657b;
            float f17 = 2;
            f11 = (((cVar.f9659d - f16) / f17) + f16) - (((f13 - f12) / f17) + f12);
        } else {
            if (i2 != 5 && i2 != 6) {
                throw new IllegalStateException("This function should only be used for 2-D focus search");
            }
            float f18 = cVar.f9656a;
            float f19 = 2;
            f11 = (((cVar.f9658c - f18) / f19) + f18) - (((f15 - f14) / f19) + f14);
        }
        long j4 = (long) f11;
        return (j4 * j4) + (13 * j2 * j2);
    }

    public static final boolean r(q qVar) {
        f0 f0Var;
        d1 d1Var;
        f0 f0Var2;
        d1 d1Var2 = qVar.f6804m;
        return (d1Var2 == null || (f0Var = d1Var2.f4437t) == null || !f0Var.C() || (d1Var = qVar.f6804m) == null || (f0Var2 = d1Var.f4437t) == null || !f0Var2.B()) ? false : true;
    }

    public static final a s(q qVar) {
        int iOrdinal = qVar.n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN == null) {
                    throw new IllegalArgumentException("ActiveParent with no focused child");
                }
                a aVarS = s(qVarN);
                a aVar = a.f9162f;
                if (aVarS == aVar) {
                    aVarS = null;
                }
                if (aVarS != null) {
                    return aVarS;
                }
                if (qVar.f9199u) {
                    return aVar;
                }
                qVar.f9199u = true;
                try {
                    k kVarM0 = qVar.m0();
                    h focusOwner = ((y) i1.l.v(qVar)).getFocusOwner();
                    q qVar2 = (q) ((u0) focusOwner).f6348h;
                    kVarM0.f9188k.getClass();
                    q qVar3 = (q) ((u0) focusOwner).f6348h;
                    return (qVar2 == qVar3 || qVar3 == null) ? aVar : m.f9191d == m.f9190c ? a.f9163g : a.f9164h;
                } finally {
                    qVar.f9199u = false;
                }
            }
            if (iOrdinal == 2) {
                return a.f9163g;
            }
            if (iOrdinal != 3) {
                throw new u();
            }
        }
        return a.f9162f;
    }

    public static final a t(q qVar) {
        if (!qVar.f9200v) {
            qVar.f9200v = true;
            try {
                k kVarM0 = qVar.m0();
                h focusOwner = ((y) i1.l.v(qVar)).getFocusOwner();
                q qVar2 = (q) ((u0) focusOwner).f6348h;
                kVarM0.f9187j.getClass();
                q qVar3 = (q) ((u0) focusOwner).f6348h;
                if (qVar2 != qVar3 && qVar3 != null) {
                    return m.f9191d == m.f9190c ? a.f9163g : a.f9164h;
                }
            } finally {
                qVar.f9200v = false;
            }
        }
        return a.f9162f;
    }

    public static final a u(q qVar) {
        n0.l lVarE;
        a1 a1Var;
        int iOrdinal = qVar.n0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN != null) {
                    return s(qVarN);
                }
                throw new IllegalArgumentException("ActiveParent with no focused child");
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new u();
                }
                if (!qVar.f6797f.f6810s) {
                    f1.a.b("visitAncestors called on an unattached node");
                }
                n0.l lVar = qVar.f6797f.f6801j;
                f0 f0VarU = i1.l.u(qVar);
                loop0: while (true) {
                    if (f0VarU == null) {
                        lVarE = null;
                        break;
                    }
                    if ((((n0.l) f0VarU.H.f4404j).f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        while (lVar != null) {
                            if ((lVar.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                lVarE = lVar;
                                d0.e eVar = null;
                                while (lVarE != null) {
                                    if (lVarE instanceof q) {
                                        break loop0;
                                    }
                                    if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                        int i2 = 0;
                                        for (n0.l lVar2 = ((i1.k) lVarE).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                                            if ((lVar2.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    lVarE = lVar2;
                                                } else {
                                                    if (eVar == null) {
                                                        eVar = new d0.e(new n0.l[16]);
                                                    }
                                                    if (lVarE != null) {
                                                        eVar.b(lVarE);
                                                        lVarE = null;
                                                    }
                                                    eVar.b(lVar2);
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    lVarE = i1.l.e(eVar);
                                }
                            }
                            lVar = lVar.f6801j;
                        }
                    }
                    f0VarU = f0VarU.n();
                    lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
                }
                q qVar2 = (q) lVarE;
                if (qVar2 == null) {
                    return a.f9162f;
                }
                int iOrdinal2 = qVar2.n0().ordinal();
                if (iOrdinal2 == 0) {
                    return t(qVar2);
                }
                if (iOrdinal2 == 1) {
                    return u(qVar2);
                }
                if (iOrdinal2 == 2) {
                    return a.f9163g;
                }
                if (iOrdinal2 != 3) {
                    throw new u();
                }
                a aVarU = u(qVar2);
                a aVar = aVarU != a.f9162f ? aVarU : null;
                return aVar == null ? t(qVar2) : aVar;
            }
        }
        return a.f9162f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0208 A[ADDED_TO_REGION, LOOP:9: B:143:0x0208->B:150:0x021c, LOOP_START, PHI: r12
      0x0208: PHI (r12v3 int) = (r12v2 int), (r12v4 int) binds: [B:142:0x0206, B:150:0x021c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x022c  */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.lang.Object, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean v(s0.q r18) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.e.v(s0.q):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.Object[]] */
    public static final boolean w(q qVar, m.q qVar2) {
        q[] qVarArr = new q[16];
        if (!qVar.f6797f.f6810s) {
            f1.a.b("visitChildren called on an unattached node");
        }
        d0.e eVar = new d0.e(new n0.l[16]);
        n0.l lVar = qVar.f6797f;
        n0.l lVar2 = lVar.f6802k;
        if (lVar2 == null) {
            i1.l.b(eVar, lVar);
        } else {
            eVar.b(lVar2);
        }
        int i2 = 0;
        while (true) {
            int i10 = eVar.f2751h;
            if (i10 == 0) {
                break;
            }
            n0.l lVarE = (n0.l) eVar.j(i10 - 1);
            if ((lVarE.f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 0) {
                i1.l.b(eVar, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        d0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar3 = (q) lVarE;
                                int i11 = i2 + 1;
                                if (qVarArr.length < i11) {
                                    int length = qVarArr.length;
                                    ?? r10 = new Object[Math.max(i11, length * 2)];
                                    System.arraycopy(qVarArr, 0, r10, 0, length);
                                    qVarArr = r10;
                                }
                                qVarArr[i2] = qVar3;
                                i2 = i11;
                            } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                int i12 = 0;
                                for (n0.l lVar3 = ((i1.k) lVarE).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                                    if ((lVar3.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                        i12++;
                                        if (i12 == 1) {
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
                                }
                                if (i12 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar2);
                        }
                    } else {
                        lVarE = lVarE.f6802k;
                    }
                }
            }
        }
        d7.n.t0(qVarArr, r.f9202a, 0, i2);
        int i13 = i2 - 1;
        if (i13 < qVarArr.length) {
            while (i13 >= 0) {
                q qVar4 = qVarArr[i13];
                if (r(qVar4) && a(qVar4, qVar2)) {
                    return true;
                }
                i13--;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.Object[]] */
    public static final boolean x(q qVar, m.q qVar2) {
        q[] qVarArr = new q[16];
        if (!qVar.f6797f.f6810s) {
            f1.a.b("visitChildren called on an unattached node");
        }
        d0.e eVar = new d0.e(new n0.l[16]);
        n0.l lVar = qVar.f6797f;
        n0.l lVar2 = lVar.f6802k;
        if (lVar2 == null) {
            i1.l.b(eVar, lVar);
        } else {
            eVar.b(lVar2);
        }
        int i2 = 0;
        while (true) {
            int i10 = eVar.f2751h;
            if (i10 == 0) {
                break;
            }
            n0.l lVarE = (n0.l) eVar.j(i10 - 1);
            if ((lVarE.f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 0) {
                i1.l.b(eVar, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        d0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar3 = (q) lVarE;
                                int i11 = i2 + 1;
                                if (qVarArr.length < i11) {
                                    int length = qVarArr.length;
                                    ?? r10 = new Object[Math.max(i11, length * 2)];
                                    System.arraycopy(qVarArr, 0, r10, 0, length);
                                    qVarArr = r10;
                                }
                                qVarArr[i2] = qVar3;
                                i2 = i11;
                            } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                int i12 = 0;
                                for (n0.l lVar3 = ((i1.k) lVarE).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                                    if ((lVar3.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                        i12++;
                                        if (i12 == 1) {
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
                                }
                                if (i12 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar2);
                        }
                    } else {
                        lVarE = lVarE.f6802k;
                    }
                }
            }
        }
        d7.n.t0(qVarArr, r.f9202a, 0, i2);
        for (int i13 = 0; i13 < i2; i13++) {
            q qVar4 = qVarArr[i13];
            if (r(qVar4) && k(qVar4, qVar2)) {
                return true;
            }
        }
        return false;
    }

    public static final void y(q qVar) {
        n0.l lVar;
        a1 a1Var;
        if (!qVar.f6797f.f6810s) {
            f1.a.b("visitAncestors called on an unattached node");
        }
        n0.l lVar2 = qVar.f6797f.f6801j;
        f0 f0VarU = i1.l.u(qVar);
        loop0: while (true) {
            lVar = null;
            if (f0VarU == null) {
                break;
            }
            if ((((n0.l) f0VarU.H.f4404j).f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                while (lVar2 != null) {
                    if ((lVar2.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        n0.l lVarE = lVar2;
                        d0.e eVar = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                lVar = lVarE;
                                break loop0;
                            }
                            if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                int i2 = 0;
                                for (n0.l lVar3 = ((i1.k) lVarE).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                                    if ((lVar3.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar == null) {
                                                eVar = new d0.e(new n0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar.b(lVar3);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar);
                        }
                    }
                    lVar2 = lVar2.f6801j;
                }
            }
            f0VarU = f0VarU.n();
            lVar2 = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
        }
        q qVar2 = (q) lVar;
        if (qVar2 == null) {
            if (qVar.a(g1.e.f3720a) != null) {
                throw new ClassCastException();
            }
            return;
        }
        h1.f fVar = g1.e.f3720a;
        if (qVar2.a(fVar) != null) {
            throw new ClassCastException();
        }
        if (qVar.a(fVar) != null) {
            throw new ClassCastException();
        }
    }

    public static final boolean z(int i2, m.q qVar, q qVar2, t0.c cVar) {
        q qVarH;
        d0.e eVar = new d0.e(new q[16]);
        if (!qVar2.f6797f.f6810s) {
            f1.a.b("visitChildren called on an unattached node");
        }
        d0.e eVar2 = new d0.e(new n0.l[16]);
        n0.l lVar = qVar2.f6797f;
        n0.l lVar2 = lVar.f6802k;
        if (lVar2 == null) {
            i1.l.b(eVar2, lVar);
        } else {
            eVar2.b(lVar2);
        }
        while (true) {
            int i10 = eVar2.f2751h;
            if (i10 == 0) {
                break;
            }
            n0.l lVarE = (n0.l) eVar2.j(i10 - 1);
            if ((lVarE.f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) == 0) {
                i1.l.b(eVar2, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                        d0.e eVar3 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar3 = (q) lVarE;
                                if (qVar3.f6810s) {
                                    eVar.b(qVar3);
                                }
                            } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                int i11 = 0;
                                for (n0.l lVar3 = ((i1.k) lVarE).f4514u; lVar3 != null; lVar3 = lVar3.f6802k) {
                                    if ((lVar3.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar3 == null) {
                                                eVar3 = new d0.e(new n0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar3.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar3.b(lVar3);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            lVarE = i1.l.e(eVar3);
                        }
                    } else {
                        lVarE = lVarE.f6802k;
                    }
                }
            }
        }
        while (eVar.f2751h != 0 && (qVarH = h(eVar, cVar, i2)) != null) {
            if (qVarH.m0().f9178a) {
                return ((Boolean) qVar.invoke(qVarH)).booleanValue();
            }
            if (l(i2, qVar, qVarH, cVar)) {
                return true;
            }
            eVar.i(qVarH);
        }
        return false;
    }
}
