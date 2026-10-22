package v9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10541a = new d();

    public static final boolean b(w9.c cVar, y9.j jVar) {
        if (cVar.y(jVar)) {
            return true;
        }
        if (!(jVar instanceof y9.d)) {
            return false;
        }
        y9.l lVarT0 = cVar.t0(cVar.b((y9.d) jVar));
        return !cVar.R(lVarT0) && cVar.y(cVar.l0(cVar.Z(lVarT0)));
    }

    public static final boolean c(w9.c cVar, l0 l0Var, y9.j jVar, y9.j jVar2, boolean z4) {
        Collection<y9.h> collectionK = cVar.K(jVar);
        if ((collectionK instanceof Collection) && collectionK.isEmpty()) {
            return false;
        }
        for (y9.h hVar : collectionK) {
            if (q7.k.a(cVar.W(hVar), cVar.o(jVar2))) {
                return true;
            }
            if (z4 && n(f10541a, l0Var, jVar2, hVar)) {
                return true;
            }
        }
        return false;
    }

    public static List d(l0 l0Var, y9.j jVar, y9.m mVar) {
        k0 k0VarH;
        j0 j0Var = j0.f10560c;
        w9.c cVar = l0Var.f10568c;
        cVar.c0(jVar, mVar);
        if (cVar.k(mVar) || !cVar.d0(jVar)) {
            if (!cVar.v(mVar)) {
                ea.f fVar = new ea.f();
                l0Var.b();
                ArrayDeque arrayDeque = l0Var.f10572g;
                q7.k.b(arrayDeque);
                ea.h hVar = l0Var.f10573h;
                q7.k.b(hVar);
                arrayDeque.push(jVar);
                while (!arrayDeque.isEmpty()) {
                    if (hVar.f3239g > 1000) {
                        StringBuilder sbQ = m.x.q("Too many supertypes for type: ", jVar, ". Supertypes = ");
                        sbQ.append(d7.r.U0(hVar, null, null, null, null, 63));
                        throw new IllegalStateException(sbQ.toString().toString());
                    }
                    y9.j jVar2 = (y9.j) arrayDeque.pop();
                    q7.k.d(jVar2, "current");
                    if (hVar.add(jVar2)) {
                        y9.j jVarM = cVar.m(jVar2);
                        if (jVarM == null) {
                            jVarM = jVar2;
                        }
                        if (cVar.i0(cVar.o(jVarM), mVar)) {
                            fVar.add(jVarM);
                            k0VarH = j0Var;
                        } else {
                            k0VarH = cVar.c(jVarM) == 0 ? j0.f10559b : cVar.H(jVarM);
                        }
                        if (q7.k.a(k0VarH, j0Var)) {
                            k0VarH = null;
                        }
                        if (k0VarH != null) {
                            Iterator it = cVar.G(cVar.o(jVar2)).iterator();
                            while (it.hasNext()) {
                                arrayDeque.add(k0VarH.a(l0Var, (y9.h) it.next()));
                            }
                        }
                    }
                }
                l0Var.a();
                return fVar;
            }
            if (cVar.i0(cVar.o(jVar), mVar)) {
                y9.j jVarM2 = cVar.m(jVar);
                if (jVarM2 != null) {
                    jVar = jVarM2;
                }
                return a.a.S(jVar);
            }
        }
        return d7.z.f2978f;
    }

    public static List e(l0 l0Var, y9.j jVar, y9.m mVar) {
        int i2;
        List listD = d(l0Var, jVar, mVar);
        w9.c cVar = l0Var.f10568c;
        if (listD.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                y9.k kVarI = cVar.i((y9.j) obj);
                int iS = cVar.S(kVarI);
                while (true) {
                    if (i2 >= iS) {
                        arrayList.add(obj);
                        break;
                    }
                    i2 = cVar.m0(cVar.Z(cVar.v0(kVarI, i2))) == null ? i2 + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return listD;
    }

    public static boolean g(l0 l0Var, y9.h hVar, y9.h hVar2) {
        q7.k.e(hVar, "a");
        q7.k.e(hVar2, "b");
        w9.c cVar = l0Var.f10568c;
        if (hVar == hVar2) {
            return true;
        }
        if (l(cVar, hVar) && l(cVar, hVar2)) {
            z0 z0VarC = l0Var.c(l0Var.d(hVar));
            z0 z0VarC2 = l0Var.c(l0Var.d(hVar2));
            y9.j jVarP = cVar.P(z0VarC);
            if (!cVar.i0(cVar.W(z0VarC), cVar.W(z0VarC2))) {
                return false;
            }
            if (cVar.c(jVarP) == 0) {
                return cVar.Q(z0VarC) || cVar.Q(z0VarC2) || cVar.f0(jVarP) == cVar.f0(cVar.P(z0VarC2));
            }
        }
        d dVar = f10541a;
        return n(dVar, l0Var, hVar, hVar2) && n(dVar, l0Var, hVar2, hVar);
    }

    public static final z0 j(z zVar, z zVar2) {
        q7.k.e(zVar, "lowerBound");
        q7.k.e(zVar2, "upperBound");
        return zVar.equals(zVar2) ? zVar : new q(zVar, zVar2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return r6.b0(r6.W(r7), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y9.n k(w9.c r6, y9.h r7, y9.h r8) {
        /*
            int r0 = r6.c(r7)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L66
            y9.l r4 = r6.V(r7, r2)
            boolean r5 = r6.R(r4)
            if (r5 != 0) goto L14
            r3 = r4
        L14:
            if (r3 == 0) goto L63
            y9.h r3 = r6.Z(r3)
            if (r3 != 0) goto L1d
            goto L63
        L1d:
            y9.j r4 = r6.P(r3)
            y9.j r4 = r6.B(r4)
            boolean r4 = r6.u0(r4)
            if (r4 == 0) goto L3b
            y9.j r4 = r6.P(r8)
            y9.j r4 = r6.B(r4)
            boolean r4 = r6.u0(r4)
            if (r4 == 0) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = r1
        L3c:
            boolean r5 = r3.equals(r8)
            if (r5 != 0) goto L5a
            if (r4 == 0) goto L53
            y9.m r4 = r6.W(r3)
            y9.m r5 = r6.W(r8)
            boolean r4 = q7.k.a(r4, r5)
            if (r4 == 0) goto L53
            goto L5a
        L53:
            y9.n r3 = k(r6, r3, r8)
            if (r3 == 0) goto L63
            return r3
        L5a:
            y9.m r7 = r6.W(r7)
            y9.n r6 = r6.b0(r7, r2)
            return r6
        L63:
            int r2 = r2 + 1
            goto L6
        L66:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.d.k(w9.c, y9.h, y9.h):y9.n");
    }

    public static boolean l(w9.c cVar, y9.h hVar) {
        if (!cVar.D(cVar.W(hVar))) {
            return false;
        }
        cVar.g(hVar);
        return (cVar.F(hVar) || cVar.p0(hVar) || !q7.k.a(cVar.o(cVar.P(hVar)), cVar.o(cVar.l0(hVar)))) ? false : true;
    }

    public static boolean m(l0 l0Var, y9.k kVar, y9.j jVar) {
        boolean zN;
        q7.k.e(kVar, "capturedSubArguments");
        w9.c cVar = l0Var.f10568c;
        y9.m mVarO = cVar.o(jVar);
        int iS = cVar.S(kVar);
        int iD = cVar.d(mVarO);
        if (iS == iD && iS == cVar.c(jVar)) {
            for (int i2 = 0; i2 < iD; i2++) {
                y9.l lVarV = cVar.V(jVar, i2);
                if (!cVar.R(lVarV)) {
                    y9.h hVarZ = cVar.Z(lVarV);
                    y9.l lVarV0 = cVar.v0(kVar, i2);
                    cVar.l(lVarV0);
                    y9.h hVarZ2 = cVar.Z(lVarV0);
                    y9.p pVarX = cVar.X(cVar.b0(mVarO, i2));
                    y9.p pVarL = cVar.l(lVarV);
                    q7.k.e(pVarX, "declared");
                    q7.k.e(pVarL, "useSite");
                    y9.p pVar = y9.p.INV;
                    if (pVarX == pVar) {
                        pVarX = pVarL;
                    } else if (pVarL != pVar && pVarX != pVarL) {
                        pVarX = null;
                    }
                    if (pVarX == null) {
                        return l0Var.f10566a;
                    }
                    if (pVarX == pVar) {
                        o(cVar, hVarZ2, hVarZ);
                        o(cVar, hVarZ, hVarZ2);
                    }
                    int i10 = l0Var.f10571f;
                    if (i10 > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + hVarZ2).toString());
                    }
                    l0Var.f10571f = i10 + 1;
                    int iOrdinal = pVarX.ordinal();
                    d dVar = f10541a;
                    if (iOrdinal == 0) {
                        zN = n(dVar, l0Var, hVarZ, hVarZ2);
                    } else if (iOrdinal == 1) {
                        zN = n(dVar, l0Var, hVarZ2, hVarZ);
                    } else {
                        if (iOrdinal != 2) {
                            throw new a4.u();
                        }
                        zN = g(l0Var, hVarZ2, hVarZ);
                    }
                    l0Var.f10571f--;
                    if (!zN) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0326 A[EDGE_INSN: B:388:0x0326->B:206:0x0326 BREAK  A[LOOP:11: B:196:0x0303->B:390:0x0303]] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(v9.d r25, v9.l0 r26, y9.h r27, y9.h r28) {
        /*
            Method dump skipped, instructions count: 1516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.d.n(v9.d, v9.l0, y9.h, y9.h):boolean");
    }

    public static void o(w9.c cVar, y9.h hVar, y9.h hVar2) {
        y9.j jVarE = cVar.e(hVar);
        if (jVarE instanceof y9.d) {
            y9.d dVar = (y9.d) jVarE;
            if (!cVar.z(dVar) && cVar.R(cVar.t0(cVar.b(dVar))) && cVar.h0(dVar) == y9.b.f11723f) {
                cVar.W(hVar2);
            }
        }
    }

    public static l p(z0 z0Var, boolean z4) {
        boolean zE;
        q7.k.e(z0Var, "type");
        if (z0Var instanceof l) {
            return (l) z0Var;
        }
        z0Var.E0();
        if ((z0Var.E0().c() instanceof f8.q0) || (z0Var instanceof w9.i)) {
            f8.g gVarC = z0Var.E0().c();
            i8.p0 p0Var = gVarC instanceof i8.p0 ? (i8.p0) gVarC : null;
            zE = true;
            if (p0Var == null || p0Var.f4835q) {
                zE = (z4 && (z0Var.E0().c() instanceof f8.q0)) ? x0.e(z0Var) : true ^ c.f(w9.a.newTypeCheckerState(w9.f.f10932g, false, true), c.k(z0Var), j0.f10559b);
            }
        } else {
            zE = false;
        }
        if (!zE) {
            return null;
        }
        if (z0Var instanceof p) {
            p pVar = (p) z0Var;
            q7.k.a(pVar.f10580g.E0(), pVar.f10581h.E0());
        }
        return new l(c.k(z0Var).I0(false), z4);
    }

    public static final z q(i0 i0Var, f8.e eVar, List list) {
        q7.k.e(i0Var, "attributes");
        q7.k.e(eVar, "descriptor");
        q7.k.e(list, "arguments");
        m0 m0VarH = eVar.h();
        q7.k.d(m0VarH, "descriptor.typeConstructor");
        return r(list, i0Var, m0VarH, false);
    }

    public static z r(List list, i0 i0Var, m0 m0Var, boolean z4) {
        o9.n nVarG;
        i8.z zVar;
        o9.n nVarR;
        o9.n nVar;
        o9.n nVarT;
        q7.k.e(i0Var, "attributes");
        q7.k.e(m0Var, "constructor");
        q7.k.e(list, "arguments");
        if (i0Var.isEmpty() && list.isEmpty() && !z4 && m0Var.c() != null) {
            f8.g gVarC = m0Var.c();
            q7.k.b(gVarC);
            z zVarK = gVarC.k();
            q7.k.d(zVarK, "constructor.declarationDescriptor!!.defaultType");
            return zVarK;
        }
        f8.g gVarC2 = m0Var.c();
        if (gVarC2 instanceof f8.q0) {
            nVarG = ((f8.q0) gVarC2).k().v0();
        } else {
            if (gVarC2 instanceof f8.e) {
                l9.d.i(l9.d.j(gVarC2));
                boolean zIsEmpty = list.isEmpty();
                w9.g gVar = w9.g.f10933a;
                if (zIsEmpty) {
                    f8.e eVar = (f8.e) gVarC2;
                    zVar = eVar instanceof i8.z ? (i8.z) eVar : null;
                    if (zVar == null || (nVarT = zVar.T(gVar)) == null) {
                        nVarG = eVar.p0();
                        q7.k.d(nVarG, "this.unsubstitutedMemberScope");
                    } else {
                        nVar = nVarT;
                    }
                } else {
                    f8.e eVar2 = (f8.e) gVarC2;
                    s0 s0VarF = n0.f10575b.f(m0Var, list);
                    zVar = eVar2 instanceof i8.z ? (i8.z) eVar2 : null;
                    if (zVar == null || (nVarR = zVar.R(s0VarF, gVar)) == null) {
                        nVarG = eVar2.X(s0VarF);
                        q7.k.d(nVarG, "this.getMemberScope(\n   …ubstitution\n            )");
                    } else {
                        nVar = nVarR;
                    }
                }
                return t(i0Var, m0Var, list, z4, nVar, new w(list, i0Var, m0Var, z4));
            }
            if (gVarC2 instanceof t9.s) {
                String str = ((t9.s) gVarC2).getName().f3197f;
                q7.k.d(str, "descriptor.name.toString()");
                nVarG = x9.i.a(4, true, str);
            } else {
                if (!(m0Var instanceof u)) {
                    throw new IllegalStateException("Unsupported classifier: " + gVarC2 + " for constructor: " + m0Var);
                }
                nVarG = n7.o.g("member scope for intersection type", ((u) m0Var).f10592b);
            }
        }
        nVar = nVarG;
        return t(i0Var, m0Var, list, z4, nVar, new w(list, i0Var, m0Var, z4));
    }

    public static final z s(List list, o9.n nVar, i0 i0Var, m0 m0Var, boolean z4) {
        q7.k.e(i0Var, "attributes");
        q7.k.e(m0Var, "constructor");
        q7.k.e(list, "arguments");
        q7.k.e(nVar, "memberScope");
        a0 a0Var = new a0(m0Var, list, z4, nVar, new w(list, nVar, i0Var, m0Var, z4));
        return i0Var.isEmpty() ? a0Var : new b0(a0Var, i0Var);
    }

    public static final z t(i0 i0Var, m0 m0Var, List list, boolean z4, o9.n nVar, p7.k kVar) {
        q7.k.e(i0Var, "attributes");
        q7.k.e(m0Var, "constructor");
        q7.k.e(list, "arguments");
        q7.k.e(nVar, "memberScope");
        a0 a0Var = new a0(m0Var, list, z4, nVar, kVar);
        return i0Var.isEmpty() ? a0Var : new b0(a0Var, i0Var);
    }

    public void a(g8.j jVar, g8.j jVar2) {
        HashSet hashSet = new HashSet();
        Iterator it = jVar.iterator();
        while (it.hasNext()) {
            hashSet.add(((g8.c) it.next()).a());
        }
        Iterator it2 = jVar2.iterator();
        while (it2.hasNext()) {
            hashSet.contains(((g8.c) it2.next()).a());
        }
    }

    public s0 f(m0 m0Var, List list) {
        q7.k.e(m0Var, "typeConstructor");
        q7.k.e(list, "arguments");
        List parameters = m0Var.getParameters();
        q7.k.d(parameters, "typeConstructor.parameters");
        f8.q0 q0Var = (f8.q0) d7.r.X0(parameters);
        if (q0Var == null || !q0Var.M()) {
            return new s((f8.q0[]) parameters.toArray(new f8.q0[0]), (p0[]) list.toArray(new p0[0]), false);
        }
        List parameters2 = m0Var.getParameters();
        q7.k.d(parameters2, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(d7.t.A0(parameters2, 10));
        Iterator it = parameters2.iterator();
        while (it.hasNext()) {
            arrayList.add(((f8.q0) it.next()).h());
        }
        return new f0(1, d7.e0.Z(d7.r.s1(arrayList, list)));
    }

    public z h(i5.f fVar, i0 i0Var, boolean z4, int i2, boolean z10) {
        i0 i0VarQ;
        t9.s sVar = (t9.s) fVar.f4654h;
        p0 p0VarI = i(new q0(1, sVar.I0()), fVar, null, i2);
        v vVarB = p0VarI.b();
        q7.k.d(vVarB, "expandedProjection.type");
        z zVarB = c.b(vVarB);
        if (c.i(zVarB)) {
            return zVarB;
        }
        p0VarI.a();
        a(zVarB.getAnnotations(), h.a(i0Var));
        if (!c.i(zVarB)) {
            if (c.i(zVarB)) {
                i0VarQ = zVarB.D0();
            } else {
                i0 i0VarD0 = zVarB.D0();
                nb.f fVar2 = i0.f10557g;
                q7.k.e(i0VarD0, "other");
                if (i0Var.isEmpty() && i0VarD0.isEmpty()) {
                    i0VarQ = i0Var;
                } else {
                    ArrayList arrayList = new ArrayList();
                    Collection collectionValues = ((ConcurrentHashMap) fVar2.f6947g).values();
                    q7.k.d(collectionValues, "idPerType.values");
                    Iterator it = collectionValues.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        g gVar = (g) i0Var.f1594f.get(iIntValue);
                        g gVar2 = (g) i0VarD0.f1594f.get(iIntValue);
                        if (gVar != null) {
                            if (gVar2 != null) {
                                gVar = new g(w7.e0.i(gVar.f10551a, gVar2.f10551a));
                            }
                            gVar2 = gVar;
                        } else if (gVar2 == null) {
                            gVar2 = null;
                        } else if (gVar != null) {
                            gVar2 = new g(w7.e0.i(gVar2.f10551a, gVar.f10551a));
                        }
                        ea.k.a(arrayList, gVar2);
                    }
                    i0VarQ = nb.f.q(arrayList);
                }
            }
            zVarB = c.p(zVarB, null, i0VarQ, 1);
        }
        z zVarI = x0.i(zVarB, z4);
        if (!z10) {
            return zVarI;
        }
        i8.e eVar = sVar.f9844l;
        q7.k.d(eVar, "descriptor.typeConstructor");
        return c.y(zVarI, s((List) fVar.f4655i, o9.m.f7933b, i0Var, eVar, z4));
    }

    public p0 i(p0 p0Var, i5.f fVar, f8.q0 q0Var, int i2) {
        int iA0;
        t9.s sVar = (t9.s) fVar.f4654h;
        if (i2 > 100) {
            throw new AssertionError("Too deep recursion while expanding type alias " + sVar.getName());
        }
        if (p0Var.c()) {
            q7.k.b(q0Var);
            return x0.j(q0Var);
        }
        v vVarB = p0Var.b();
        q7.k.d(vVarB, "underlyingProjection.type");
        m0 m0VarE0 = vVarB.E0();
        q7.k.e(m0VarE0, "constructor");
        f8.g gVarC = m0VarE0.c();
        p0 p0Var2 = gVarC instanceof f8.q0 ? (p0) ((Map) fVar.f4656j).get(gVarC) : null;
        if (p0Var2 == null) {
            z zVarB = c.b(p0Var.b().H0());
            if (!c.i(zVarB) && x0.c(zVarB, z9.a.f12492i, null)) {
                m0 m0VarE02 = zVarB.E0();
                f8.g gVarC2 = m0VarE02.c();
                m0VarE02.getParameters().size();
                zVarB.C0().size();
                if (!(gVarC2 instanceof f8.q0)) {
                    int i10 = 0;
                    if (!(gVarC2 instanceof t9.s)) {
                        z zVarU = u(zVarB, fVar, i2);
                        v0.d(zVarU);
                        for (Object obj : zVarU.C0()) {
                            int i11 = i10 + 1;
                            if (i10 < 0) {
                                d7.s.z0();
                                throw null;
                            }
                            p0 p0Var3 = (p0) obj;
                            if (!p0Var3.c()) {
                                v vVarB2 = p0Var3.b();
                                q7.k.d(vVarB2, "substitutedArgument.type");
                                if (!x0.c(vVarB2, z9.a.f12491h, null)) {
                                }
                            }
                            i10 = i11;
                        }
                        return new q0(p0Var.a(), zVarU);
                    }
                    t9.s sVar2 = (t9.s) gVarC2;
                    if (fVar.L(sVar2)) {
                        String str = sVar2.getName().f3197f;
                        q7.k.d(str, "typeDescriptor.name.toString()");
                        return new q0(1, x9.i.c(x9.h.f11305k, str));
                    }
                    List listC0 = zVarB.C0();
                    ArrayList arrayList = new ArrayList(d7.t.A0(listC0, 10));
                    for (Object obj2 : listC0) {
                        int i12 = i10 + 1;
                        if (i10 < 0) {
                            d7.s.z0();
                            throw null;
                        }
                        arrayList.add(i((p0) obj2, fVar, (f8.q0) m0VarE02.getParameters().get(i10), i2 + 1));
                        i10 = i12;
                    }
                    List parameters = sVar2.f9844l.getParameters();
                    ArrayList arrayList2 = new ArrayList(d7.t.A0(parameters, 10));
                    Iterator it = parameters.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((f8.q0) it.next()).a());
                    }
                    return new q0(p0Var.a(), c.y(h(new i5.f(fVar, sVar2, arrayList, d7.e0.Z(d7.r.s1(arrayList2, arrayList)), 22), zVarB.D0(), zVarB.F0(), i2 + 1, false), u(zVarB, fVar, i2)));
                }
            }
            return p0Var;
        }
        if (p0Var2.c()) {
            q7.k.b(q0Var);
            return x0.j(q0Var);
        }
        z0 z0VarH0 = p0Var2.b().H0();
        int iA = p0Var2.a();
        m.x.y(iA, "argument.projectionKind");
        int iA2 = p0Var.a();
        m.x.y(iA2, "underlyingProjection.projectionKind");
        if (iA2 != iA && iA2 != 1 && iA == 1) {
            iA = iA2;
        }
        if (q0Var == null || (iA0 = q0Var.a0()) == 0) {
            iA0 = 1;
        }
        if (iA0 != iA && iA0 != 1 && iA == 1) {
            iA = 1;
        }
        a(vVarB.getAnnotations(), z0VarH0.getAnnotations());
        z zVarI = x0.i(c.b(z0VarH0), vVarB.F0());
        i0 i0VarD0 = vVarB.D0();
        if (!c.i(zVarI)) {
            if (c.i(zVarI)) {
                i0VarD0 = zVarI.D0();
            } else {
                i0 i0VarD02 = zVarI.D0();
                i0VarD0.getClass();
                nb.f fVar2 = i0.f10557g;
                q7.k.e(i0VarD02, "other");
                if (!i0VarD0.isEmpty() || !i0VarD02.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList();
                    Collection collectionValues = ((ConcurrentHashMap) fVar2.f6947g).values();
                    q7.k.d(collectionValues, "idPerType.values");
                    Iterator it2 = collectionValues.iterator();
                    while (it2.hasNext()) {
                        int iIntValue = ((Number) it2.next()).intValue();
                        g gVar = (g) i0VarD0.f1594f.get(iIntValue);
                        g gVar2 = (g) i0VarD02.f1594f.get(iIntValue);
                        if (gVar != null) {
                            if (gVar2 != null) {
                                gVar = new g(w7.e0.i(gVar.f10551a, gVar2.f10551a));
                            }
                            gVar2 = gVar;
                        } else if (gVar2 == null) {
                            gVar2 = null;
                        } else if (gVar != null) {
                            gVar2 = new g(w7.e0.i(gVar2.f10551a, gVar.f10551a));
                        }
                        ea.k.a(arrayList3, gVar2);
                    }
                    i0VarD0 = nb.f.q(arrayList3);
                }
            }
            zVarI = c.p(zVarI, null, i0VarD0, 1);
        }
        return new q0(iA, zVarI);
    }

    public z u(z zVar, i5.f fVar, int i2) {
        m0 m0VarE0 = zVar.E0();
        List listC0 = zVar.C0();
        ArrayList arrayList = new ArrayList(d7.t.A0(listC0, 10));
        int i10 = 0;
        for (Object obj : listC0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                d7.s.z0();
                throw null;
            }
            p0 p0Var = (p0) obj;
            p0 p0VarI = i(p0Var, fVar, (f8.q0) m0VarE0.getParameters().get(i10), i2 + 1);
            if (!p0VarI.c()) {
                p0VarI = new q0(p0VarI.a(), x0.h(p0VarI.b(), p0Var.b().F0()));
            }
            arrayList.add(p0VarI);
            i10 = i11;
        }
        return c.p(zVar, arrayList, null, 2);
    }
}
