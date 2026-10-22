package b1;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import s1.v0;
import u1.c1;
import u1.g0;
import u1.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1811a = new int[2];

    public static final boolean A(int i, b.g gVar, q qVar, c1.c cVar) {
        q qVarH;
        m0.e eVar = new m0.e(new q[16]);
        if (!qVar.f15114c.f15126r) {
            r1.a.b("visitChildren called on an unattached node");
        }
        m0.e eVar2 = new m0.e(new w0.l[16]);
        w0.l lVar = qVar.f15114c;
        w0.l lVar2 = lVar.f15118j;
        if (lVar2 == null) {
            u1.f.b(eVar2, lVar);
        } else {
            eVar2.b(lVar2);
        }
        while (true) {
            int i3 = eVar2.f8160g;
            if (i3 == 0) {
                break;
            }
            w0.l lVarE = (w0.l) eVar2.k(i3 - 1);
            if ((lVarE.f15117h & 1024) == 0) {
                u1.f.b(eVar2, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f15116g & 1024) != 0) {
                        m0.e eVar3 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar2 = (q) lVarE;
                                if (qVar2.f15126r) {
                                    eVar.b(qVar2);
                                }
                            } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                int i10 = 0;
                                for (w0.l lVar3 = ((u1.m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                                    if ((lVar3.f15116g & 1024) != 0) {
                                        i10++;
                                        if (i10 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar3 == null) {
                                                eVar3 = new m0.e(new w0.l[16]);
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
                            lVarE = u1.f.e(eVar3);
                        }
                    } else {
                        lVarE = lVarE.f15118j;
                    }
                }
            }
        }
        while (eVar.f8160g != 0 && (qVarH = h(eVar, cVar, i)) != null) {
            if (qVarH.C0().f1830a) {
                return ((Boolean) gVar.invoke(qVarH)).booleanValue();
            }
            if (l(i, gVar, qVarH, cVar)) {
                return true;
            }
            eVar.j(qVarH);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fe, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0197 A[EDGE_INSN: B:157:0x0197->B:127:0x0197 BREAK  A[LOOP:5: B:89:0x012c->B:162:0x012c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012e  */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean B(b1.q r12, b1.q r13, int r14, b.g r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.B(b1.q, b1.q, int, b.g):boolean");
    }

    public static final Integer C(int i) {
        if (i == 5) {
            return 33;
        }
        if (i == 6) {
            return 130;
        }
        if (i == 3) {
            return 17;
        }
        if (i == 4) {
            return 66;
        }
        if (i == 1) {
            return 2;
        }
        return i == 2 ? 1 : null;
    }

    public static final c D(int i) {
        if (i == 1) {
            return c.a(2);
        }
        if (i == 2) {
            return c.a(1);
        }
        if (i == 17) {
            return c.a(3);
        }
        if (i == 33) {
            return c.a(5);
        }
        if (i == 66) {
            return c.a(4);
        }
        if (i != 130) {
            return null;
        }
        return c.a(6);
    }

    public static final Boolean E(int i, b.g gVar, q qVar, c1.c cVar) {
        int iOrdinal = qVar.D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN == null) {
                    od.f.e("ActiveParent must have a focusedChild");
                    return null;
                }
                int iOrdinal2 = qVarN.D0().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        Boolean boolE = E(i, gVar, qVarN, cVar);
                        if (!yb.k.a(boolE, Boolean.FALSE)) {
                            return boolE;
                        }
                        if (cVar == null) {
                            if (qVarN.D0() != p.f1845f) {
                                od.f.e("Searching for active node in inactive hierarchy");
                                return null;
                            }
                            q qVarG = g(qVarN);
                            if (qVarG == null) {
                                od.f.e("ActiveParent must have a focusedChild");
                                return null;
                            }
                            cVar = j(qVarG);
                        }
                        return Boolean.valueOf(l(i, gVar, qVar, cVar));
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            g5.f.a();
                            return null;
                        }
                        od.f.e("ActiveParent must have a focusedChild");
                        return null;
                    }
                }
                if (cVar == null) {
                    cVar = j(qVarN);
                }
                return Boolean.valueOf(l(i, gVar, qVar, cVar));
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return qVar.C0().f1830a ? (Boolean) gVar.invoke(qVar) : cVar == null ? Boolean.valueOf(i(qVar, i, gVar)) : Boolean.valueOf(A(i, gVar, qVar, cVar));
                }
                g5.f.a();
                return null;
            }
        }
        return Boolean.valueOf(i(qVar, i, gVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a(b1.q r7, b.g r8) {
        /*
            b1.p r0 = r7.D0()
            int r0 = r0.ordinal()
            if (r0 == 0) goto L82
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r4) goto L36
            if (r0 == r3) goto L82
            if (r0 != r1) goto L31
            boolean r0 = w(r7, r8)
            if (r0 != 0) goto L78
            b1.l r0 = r7.C0()
            boolean r0 = r0.f1830a
            if (r0 == 0) goto L2d
            java.lang.Object r7 = r8.invoke(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            goto L2e
        L2d:
            r7 = r2
        L2e:
            if (r7 == 0) goto L77
            goto L78
        L31:
            g5.f.a()
        L34:
            r7 = 0
            return r7
        L36:
            b1.q r0 = n(r7)
            java.lang.String r5 = "ActiveParent must have a focusedChild"
            if (r0 == 0) goto L7e
            b1.p r6 = r0.D0()
            int r6 = r6.ordinal()
            if (r6 == 0) goto L79
            if (r6 == r4) goto L56
            if (r6 == r3) goto L79
            if (r6 == r1) goto L52
            g5.f.a()
            goto L34
        L52:
            od.f.e(r5)
            goto L34
        L56:
            boolean r1 = a(r0, r8)
            if (r1 != 0) goto L78
            boolean r7 = m(r7, r0, r3, r8)
            if (r7 != 0) goto L78
            b1.l r7 = r0.C0()
            boolean r7 = r7.f1830a
            if (r7 == 0) goto L77
            java.lang.Object r7 = r8.invoke(r0)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L77
            goto L78
        L77:
            return r2
        L78:
            return r4
        L79:
            boolean r7 = m(r7, r0, r3, r8)
            return r7
        L7e:
            od.f.e(r5)
            goto L34
        L82:
            boolean r7 = w(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.a(b1.q, b.g):boolean");
    }

    public static final boolean b(c1.c cVar, c1.c cVar2, c1.c cVar3, int i) {
        float f5;
        float f10;
        boolean zC = c(i, cVar3, cVar);
        float f11 = cVar3.f2168b;
        float f12 = cVar3.f2170d;
        float f13 = cVar3.f2167a;
        float f14 = cVar3.f2169c;
        float f15 = cVar.f2170d;
        float f16 = cVar.f2168b;
        float f17 = cVar.f2169c;
        float f18 = cVar.f2167a;
        if (zC || !c(i, cVar2, cVar)) {
            return false;
        }
        if (i == 3) {
            if (f18 < f14) {
                return true;
            }
        } else if (i == 4) {
            if (f17 > f13) {
                return true;
            }
        } else if (i == 5) {
            if (f16 < f12) {
                return true;
            }
        } else {
            if (i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return false;
            }
            if (f15 > f11) {
                return true;
            }
        }
        if (i == 3 || i == 4) {
            return true;
        }
        if (i == 3) {
            f5 = f18 - cVar2.f2169c;
        } else if (i == 4) {
            f5 = cVar2.f2167a - f17;
        } else if (i == 5) {
            f5 = f16 - cVar2.f2170d;
        } else {
            if (i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return false;
            }
            f5 = cVar2.f2168b - f15;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (i == 3) {
            f10 = f18 - f13;
        } else if (i == 4) {
            f10 = f14 - f17;
        } else if (i == 5) {
            f10 = f16 - f11;
        } else {
            if (i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return false;
            }
            f10 = f12 - f15;
        }
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        return f5 < f10;
    }

    public static final boolean c(int i, c1.c cVar, c1.c cVar2) {
        if (i == 3 || i == 4) {
            return cVar.f2170d > cVar2.f2168b && cVar.f2168b < cVar2.f2170d;
        }
        if (i == 5 || i == 6) {
            return cVar.f2169c > cVar2.f2167a && cVar.f2167a < cVar2.f2169c;
        }
        od.f.e("This function should only be used for 2-D focus search");
        return false;
    }

    public static final c1.c d(View view, v1.t tVar) {
        int[] iArr = f1811a;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i3 = iArr[1];
        tVar.getLocationInWindow(iArr);
        float f5 = i - iArr[0];
        float f10 = i3 - iArr[1];
        return new c1.c(f5, f10, view.getWidth() + f5, view.getHeight() + f10);
    }

    public static final boolean e(q qVar, boolean z10) {
        int iOrdinal = qVar.D0().ordinal();
        if (iOrdinal == 0) {
            ((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f(null);
            qVar.B0(p.f1844c, p.f1847h);
            return true;
        }
        if (iOrdinal == 1) {
            q qVarN = n(qVar);
            if (!(qVarN != null ? e(qVarN, z10) : true)) {
                return false;
            }
            qVar.B0(p.f1845f, p.f1847h);
            return true;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return true;
            }
            g5.f.a();
            return false;
        }
        if (z10) {
            ((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f(null);
            qVar.B0(p.f1846g, p.f1847h);
        }
        return z10;
    }

    public static final void f(q qVar, m0.e eVar) {
        if (!qVar.f15114c.f15126r) {
            r1.a.b("visitChildren called on an unattached node");
        }
        m0.e eVar2 = new m0.e(new w0.l[16]);
        w0.l lVar = qVar.f15114c;
        w0.l lVar2 = lVar.f15118j;
        if (lVar2 == null) {
            u1.f.b(eVar2, lVar);
        } else {
            eVar2.b(lVar2);
        }
        while (true) {
            int i = eVar2.f8160g;
            if (i == 0) {
                return;
            }
            w0.l lVarE = (w0.l) eVar2.k(i - 1);
            if ((lVarE.f15117h & 1024) == 0) {
                u1.f.b(eVar2, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f15116g & 1024) != 0) {
                        m0.e eVar3 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar2 = (q) lVarE;
                                if (qVar2.f15126r && !u1.f.u(qVar2).S) {
                                    if (qVar2.C0().f1830a) {
                                        eVar.b(qVar2);
                                    } else {
                                        f(qVar2, eVar);
                                    }
                                }
                            } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                int i3 = 0;
                                for (w0.l lVar3 = ((u1.m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                                    if ((lVar3.f15116g & 1024) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar3 == null) {
                                                eVar3 = new m0.e(new w0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar3.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar3.b(lVar3);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            lVarE = u1.f.e(eVar3);
                        }
                    } else {
                        lVarE = lVarE.f15118j;
                    }
                }
            }
        }
    }

    public static final q g(q qVar) {
        q qVar2 = ((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f1825h;
        if (qVar2 == null || !qVar2.f15126r) {
            return null;
        }
        return qVar2;
    }

    public static final q h(m0.e eVar, c1.c cVar, int i) {
        c1.c cVarD;
        if (i == 3) {
            cVarD = cVar.d((cVar.f2169c - cVar.f2167a) + 1, 0.0f);
        } else if (i == 4) {
            cVarD = cVar.d(-((cVar.f2169c - cVar.f2167a) + 1), 0.0f);
        } else if (i == 5) {
            cVarD = cVar.d(0.0f, (cVar.f2170d - cVar.f2168b) + 1);
        } else {
            if (i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return null;
            }
            cVarD = cVar.d(0.0f, -((cVar.f2170d - cVar.f2168b) + 1));
        }
        Object[] objArr = eVar.f8158c;
        int i3 = eVar.f8160g;
        q qVar = null;
        for (int i10 = 0; i10 < i3; i10++) {
            q qVar2 = (q) objArr[i10];
            if (r(qVar2)) {
                c1.c cVarJ = j(qVar2);
                if (o(cVarJ, cVarD, cVar, i)) {
                    qVar = qVar2;
                    cVarD = cVarJ;
                }
            }
        }
        return qVar;
    }

    public static final boolean i(q qVar, int i, xb.l lVar) {
        c1.c cVar;
        m0.e eVar = new m0.e(new q[16]);
        f(qVar, eVar);
        int i3 = eVar.f8160g;
        if (i3 <= 1) {
            q qVar2 = (q) (i3 == 0 ? null : eVar.f8158c[0]);
            if (qVar2 != null) {
                return ((Boolean) lVar.invoke(qVar2)).booleanValue();
            }
        } else {
            if (i == 7) {
                i = 4;
            }
            if (i == 4 || i == 6) {
                c1.c cVarJ = j(qVar);
                float f5 = cVarJ.f2167a;
                float f10 = cVarJ.f2168b;
                cVar = new c1.c(f5, f10, f5, f10);
            } else {
                if (i != 3 && i != 5) {
                    od.f.e("This function should only be used for 2-D focus search");
                    return false;
                }
                c1.c cVarJ2 = j(qVar);
                float f11 = cVarJ2.f2169c;
                float f12 = cVarJ2.f2170d;
                cVar = new c1.c(f11, f12, f11, f12);
            }
            q qVarH = h(eVar, cVar, i);
            if (qVarH != null) {
                return ((Boolean) lVar.invoke(qVarH)).booleanValue();
            }
        }
        return false;
    }

    public static final c1.c j(q qVar) {
        g1 g1Var = qVar.f15120l;
        return g1Var != null ? v0.i(g1Var).g(g1Var, false) : c1.c.f2166e;
    }

    public static final boolean k(q qVar, b.g gVar) {
        int iOrdinal = qVar.D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN != null) {
                    return k(qVarN, gVar) || m(qVar, qVarN, 1, gVar);
                }
                od.f.e("ActiveParent must have a focusedChild");
                return false;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return qVar.C0().f1830a ? ((Boolean) gVar.invoke(qVar)).booleanValue() : x(qVar, gVar);
                }
                g5.f.a();
                return false;
            }
        }
        return x(qVar, gVar);
    }

    public static final boolean l(int i, b.g gVar, q qVar, c1.c cVar) {
        if (A(i, gVar, qVar, cVar)) {
            return true;
        }
        Boolean bool = (Boolean) z(qVar, i, new t(((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f1825h, qVar, cVar, i, gVar, 1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean m(q qVar, q qVar2, int i, b.g gVar) {
        if (B(qVar, qVar2, i, gVar)) {
            return true;
        }
        Boolean bool = (Boolean) z(qVar, i, new t(((i) ((v1.t) u1.f.v(qVar)).getFocusOwner()).f1825h, qVar, qVar2, i, gVar, 0));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0026, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final b1.q n(b1.q r8) {
        /*
            w0.l r0 = r8.f15114c
            boolean r0 = r0.f15126r
            r1 = 0
            if (r0 != 0) goto L9
            goto Laa
        L9:
            if (r0 != 0) goto L10
            java.lang.String r0 = "visitChildren called on an unattached node"
            r1.a.b(r0)
        L10:
            m0.e r0 = new m0.e
            r2 = 16
            w0.l[] r3 = new w0.l[r2]
            r0.<init>(r3)
            w0.l r8 = r8.f15114c
            w0.l r3 = r8.f15118j
            if (r3 != 0) goto L23
            u1.f.b(r0, r8)
            goto L26
        L23:
            r0.b(r3)
        L26:
            int r8 = r0.f8160g
            if (r8 == 0) goto Laa
            int r8 = r8 + (-1)
            java.lang.Object r8 = r0.k(r8)
            w0.l r8 = (w0.l) r8
            int r3 = r8.f15117h
            r3 = r3 & 1024(0x400, float:1.435E-42)
            if (r3 != 0) goto L3c
            u1.f.b(r0, r8)
            goto L26
        L3c:
            if (r8 == 0) goto L26
            int r3 = r8.f15116g
            r3 = r3 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto La7
            r3 = r1
        L45:
            if (r8 == 0) goto L26
            boolean r4 = r8 instanceof b1.q
            r5 = 1
            if (r4 == 0) goto L6c
            b1.q r8 = (b1.q) r8
            w0.l r4 = r8.f15114c
            boolean r4 = r4.f15126r
            if (r4 == 0) goto La2
            b1.p r4 = r8.D0()
            int r4 = r4.ordinal()
            if (r4 == 0) goto L6b
            if (r4 == r5) goto L6b
            r5 = 2
            if (r4 == r5) goto L6b
            r8 = 3
            if (r4 != r8) goto L67
            goto La2
        L67:
            g5.f.a()
            r8 = 0
        L6b:
            return r8
        L6c:
            int r4 = r8.f15116g
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto La2
            boolean r4 = r8 instanceof u1.m
            if (r4 == 0) goto La2
            r4 = r8
            u1.m r4 = (u1.m) r4
            w0.l r4 = r4.f13866t
            r6 = 0
        L7c:
            if (r4 == 0) goto L9f
            int r7 = r4.f15116g
            r7 = r7 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L9c
            int r6 = r6 + 1
            if (r6 != r5) goto L8a
            r8 = r4
            goto L9c
        L8a:
            if (r3 != 0) goto L93
            m0.e r3 = new m0.e
            w0.l[] r7 = new w0.l[r2]
            r3.<init>(r7)
        L93:
            if (r8 == 0) goto L99
            r3.b(r8)
            r8 = r1
        L99:
            r3.b(r4)
        L9c:
            w0.l r4 = r4.f15118j
            goto L7c
        L9f:
            if (r6 != r5) goto La2
            goto L45
        La2:
            w0.l r8 = u1.f.e(r3)
            goto L45
        La7:
            w0.l r8 = r8.f15118j
            goto L3c
        Laa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.n(b1.q):b1.q");
    }

    public static final boolean o(c1.c cVar, c1.c cVar2, c1.c cVar3, int i) {
        if (!p(i, cVar, cVar3)) {
            return false;
        }
        if (p(i, cVar2, cVar3) && !b(cVar3, cVar, cVar2, i)) {
            return !b(cVar3, cVar2, cVar, i) && q(i, cVar3, cVar) < q(i, cVar3, cVar2);
        }
        return true;
    }

    public static final boolean p(int i, c1.c cVar, c1.c cVar2) {
        float f5 = cVar.f2168b;
        float f10 = cVar.f2170d;
        float f11 = cVar.f2167a;
        float f12 = cVar.f2169c;
        if (i == 3) {
            float f13 = cVar2.f2169c;
            float f14 = cVar2.f2167a;
            return (f13 > f12 || f14 >= f12) && f14 > f11;
        }
        if (i == 4) {
            float f15 = cVar2.f2167a;
            float f16 = cVar2.f2169c;
            return (f15 < f11 || f16 <= f11) && f16 < f12;
        }
        if (i == 5) {
            float f17 = cVar2.f2170d;
            float f18 = cVar2.f2168b;
            return (f17 > f10 || f18 >= f10) && f18 > f5;
        }
        if (i != 6) {
            od.f.e("This function should only be used for 2-D focus search");
            return false;
        }
        float f19 = cVar2.f2168b;
        float f20 = cVar2.f2170d;
        return (f19 < f5 || f20 <= f5) && f20 < f10;
    }

    public static final long q(int i, c1.c cVar, c1.c cVar2) {
        float f5;
        float f10;
        float f11 = cVar2.f2168b;
        float f12 = cVar2.f2170d;
        float f13 = cVar2.f2167a;
        float f14 = cVar2.f2169c;
        if (i == 3) {
            f5 = cVar.f2167a - f14;
        } else if (i == 4) {
            f5 = f13 - cVar.f2169c;
        } else if (i == 5) {
            f5 = cVar.f2168b - f12;
        } else {
            if (i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return 0L;
            }
            f5 = f11 - cVar.f2170d;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        long j10 = (long) f5;
        if (i == 3 || i == 4) {
            float f15 = cVar.f2168b;
            float f16 = 2;
            f10 = (((cVar.f2170d - f15) / f16) + f15) - (((f12 - f11) / f16) + f11);
        } else {
            if (i != 5 && i != 6) {
                od.f.e("This function should only be used for 2-D focus search");
                return 0L;
            }
            float f17 = cVar.f2167a;
            float f18 = 2;
            f10 = (((cVar.f2169c - f17) / f18) + f17) - (((f14 - f13) / f18) + f13);
        }
        long j11 = (long) f10;
        return (j11 * j11) + (13 * j10 * j10);
    }

    public static final boolean r(q qVar) {
        g0 g0Var;
        g1 g1Var;
        g0 g0Var2;
        g1 g1Var2 = qVar.f15120l;
        return (g1Var2 == null || (g0Var = g1Var2.f13810s) == null || !g0Var.H() || (g1Var = qVar.f15120l) == null || (g0Var2 = g1Var.f13810s) == null || !g0Var2.G()) ? false : true;
    }

    public static final b s(q qVar, int i) {
        int iOrdinal = qVar.D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN == null) {
                    g5.f.s("ActiveParent with no focused child");
                    return null;
                }
                b bVarS = s(qVarN, i);
                b bVar = b.f1806c;
                b bVar2 = bVarS != bVar ? bVarS : null;
                if (bVar2 != null) {
                    return bVar2;
                }
                if (qVar.f1849t) {
                    return bVar;
                }
                qVar.f1849t = true;
                try {
                    l lVarC0 = qVar.C0();
                    a aVar = new a(i);
                    h focusOwner = ((v1.t) u1.f.v(qVar)).getFocusOwner();
                    q qVar2 = ((i) focusOwner).f1825h;
                    lVarC0.f1839k.invoke(aVar);
                    q qVar3 = ((i) focusOwner).f1825h;
                    if (!aVar.f1805b) {
                        return (qVar2 == qVar3 || qVar3 == null) ? bVar : n.f1842d == n.f1841c ? b.f1807f : b.f1808g;
                    }
                    n nVar = n.f1840b;
                    return b.f1807f;
                } finally {
                    qVar.f1849t = false;
                }
            }
            if (iOrdinal == 2) {
                return b.f1807f;
            }
            if (iOrdinal != 3) {
                g5.f.a();
                return null;
            }
        }
        return b.f1806c;
    }

    public static final b t(q qVar, int i) {
        if (!qVar.f1850u) {
            qVar.f1850u = true;
            try {
                l lVarC0 = qVar.C0();
                a aVar = new a(i);
                h focusOwner = ((v1.t) u1.f.v(qVar)).getFocusOwner();
                q qVar2 = ((i) focusOwner).f1825h;
                lVarC0.f1838j.invoke(aVar);
                q qVar3 = ((i) focusOwner).f1825h;
                if (aVar.f1805b) {
                    n nVar = n.f1840b;
                    return b.f1807f;
                }
                if (qVar2 != qVar3 && qVar3 != null) {
                    return n.f1842d == n.f1841c ? b.f1807f : b.f1808g;
                }
            } finally {
                qVar.f1850u = false;
            }
        }
        return b.f1806c;
    }

    public static final b u(q qVar, int i) {
        w0.l lVarE;
        c1 c1Var;
        int iOrdinal = qVar.D0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                q qVarN = n(qVar);
                if (qVarN != null) {
                    return s(qVarN, i);
                }
                g5.f.s("ActiveParent with no focused child");
                return null;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    g5.f.a();
                    return null;
                }
                if (!qVar.f15114c.f15126r) {
                    r1.a.b("visitAncestors called on an unattached node");
                }
                w0.l lVar = qVar.f15114c.i;
                g0 g0VarU = u1.f.u(qVar);
                loop0: while (true) {
                    if (g0VarU == null) {
                        lVarE = null;
                        break;
                    }
                    if ((g0VarU.H.f13746f.f15117h & 1024) != 0) {
                        while (lVar != null) {
                            if ((lVar.f15116g & 1024) != 0) {
                                lVarE = lVar;
                                m0.e eVar = null;
                                while (lVarE != null) {
                                    if (lVarE instanceof q) {
                                        break loop0;
                                    }
                                    if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                        int i3 = 0;
                                        for (w0.l lVar2 = ((u1.m) lVarE).f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
                                            if ((lVar2.f15116g & 1024) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    lVarE = lVar2;
                                                } else {
                                                    if (eVar == null) {
                                                        eVar = new m0.e(new w0.l[16]);
                                                    }
                                                    if (lVarE != null) {
                                                        eVar.b(lVarE);
                                                        lVarE = null;
                                                    }
                                                    eVar.b(lVar2);
                                                }
                                            }
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                    lVarE = u1.f.e(eVar);
                                }
                            }
                            lVar = lVar.i;
                        }
                    }
                    g0VarU = g0VarU.t();
                    lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
                }
                q qVar2 = (q) lVarE;
                if (qVar2 == null) {
                    return b.f1806c;
                }
                int iOrdinal2 = qVar2.D0().ordinal();
                if (iOrdinal2 == 0) {
                    return t(qVar2, i);
                }
                if (iOrdinal2 == 1) {
                    return u(qVar2, i);
                }
                if (iOrdinal2 == 2) {
                    return b.f1807f;
                }
                if (iOrdinal2 != 3) {
                    g5.f.a();
                    return null;
                }
                b bVarU = u(qVar2, i);
                b bVar = bVarU != b.f1806c ? bVarU : null;
                return bVar == null ? t(qVar2, i) : bVar;
            }
        }
        return b.f1806c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f8 A[ADDED_TO_REGION, LOOP:9: B:143:0x01f8->B:150:0x020a, LOOP_START, PHI: r12
      0x01f8: PHI (r12v3 int) = (r12v2 int), (r12v4 int) binds: [B:142:0x01f6, B:150:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0217  */
    /* JADX WARN: Type inference failed for: r4v32, types: [java.lang.Object, java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean v(b1.q r18) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.v(b1.q):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.Object[]] */
    public static final boolean w(q qVar, b.g gVar) {
        q[] qVarArr = new q[16];
        if (!qVar.f15114c.f15126r) {
            r1.a.b("visitChildren called on an unattached node");
        }
        m0.e eVar = new m0.e(new w0.l[16]);
        w0.l lVar = qVar.f15114c;
        w0.l lVar2 = lVar.f15118j;
        if (lVar2 == null) {
            u1.f.b(eVar, lVar);
        } else {
            eVar.b(lVar2);
        }
        int i = 0;
        while (true) {
            int i3 = eVar.f8160g;
            if (i3 == 0) {
                break;
            }
            w0.l lVarE = (w0.l) eVar.k(i3 - 1);
            if ((lVarE.f15117h & 1024) == 0) {
                u1.f.b(eVar, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f15116g & 1024) != 0) {
                        m0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar2 = (q) lVarE;
                                int i10 = i + 1;
                                if (qVarArr.length < i10) {
                                    int length = qVarArr.length;
                                    ?? r10 = new Object[Math.max(i10, length * 2)];
                                    System.arraycopy(qVarArr, 0, r10, 0, length);
                                    qVarArr = r10;
                                }
                                qVarArr[i] = qVar2;
                                i = i10;
                            } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                int i11 = 0;
                                for (w0.l lVar3 = ((u1.m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                                    if ((lVar3.f15116g & 1024) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar3);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            lVarE = u1.f.e(eVar2);
                        }
                    } else {
                        lVarE = lVarE.f15118j;
                    }
                }
            }
        }
        Arrays.sort(qVarArr, 0, i, r.f1852c);
        int i12 = i - 1;
        if (i12 < qVarArr.length) {
            while (i12 >= 0) {
                q qVar3 = qVarArr[i12];
                if (r(qVar3) && a(qVar3, gVar)) {
                    return true;
                }
                i12--;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, java.lang.Object[]] */
    public static final boolean x(q qVar, b.g gVar) {
        q[] qVarArr = new q[16];
        if (!qVar.f15114c.f15126r) {
            r1.a.b("visitChildren called on an unattached node");
        }
        m0.e eVar = new m0.e(new w0.l[16]);
        w0.l lVar = qVar.f15114c;
        w0.l lVar2 = lVar.f15118j;
        if (lVar2 == null) {
            u1.f.b(eVar, lVar);
        } else {
            eVar.b(lVar2);
        }
        int i = 0;
        while (true) {
            int i3 = eVar.f8160g;
            if (i3 == 0) {
                break;
            }
            w0.l lVarE = (w0.l) eVar.k(i3 - 1);
            if ((lVarE.f15117h & 1024) == 0) {
                u1.f.b(eVar, lVarE);
            } else {
                while (true) {
                    if (lVarE == null) {
                        break;
                    }
                    if ((lVarE.f15116g & 1024) != 0) {
                        m0.e eVar2 = null;
                        while (lVarE != null) {
                            if (lVarE instanceof q) {
                                q qVar2 = (q) lVarE;
                                int i10 = i + 1;
                                if (qVarArr.length < i10) {
                                    int length = qVarArr.length;
                                    ?? r10 = new Object[Math.max(i10, length * 2)];
                                    System.arraycopy(qVarArr, 0, r10, 0, length);
                                    qVarArr = r10;
                                }
                                qVarArr[i] = qVar2;
                                i = i10;
                            } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                int i11 = 0;
                                for (w0.l lVar3 = ((u1.m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                                    if ((lVar3.f15116g & 1024) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            lVarE = lVar3;
                                        } else {
                                            if (eVar2 == null) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (lVarE != null) {
                                                eVar2.b(lVarE);
                                                lVarE = null;
                                            }
                                            eVar2.b(lVar3);
                                        }
                                    }
                                }
                                if (i11 == 1) {
                                }
                            }
                            lVarE = u1.f.e(eVar2);
                        }
                    } else {
                        lVarE = lVarE.f15118j;
                    }
                }
            }
        }
        Arrays.sort(qVarArr, 0, i, r.f1852c);
        for (int i12 = 0; i12 < i; i12++) {
            q qVar3 = qVarArr[i12];
            if (r(qVar3) && k(qVar3, gVar)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean y(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !viewGroup.hasFocus()) {
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        if (view instanceof v1.t) {
            return ((v1.t) view).requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, java.util.Collection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object z(b1.q r10, int r11, xb.l r12) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.z(b1.q, int, xb.l):java.lang.Object");
    }
}
