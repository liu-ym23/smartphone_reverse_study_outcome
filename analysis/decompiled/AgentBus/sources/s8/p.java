package s8;

import d7.i0;
import i8.j0;
import i8.k0;
import i8.l0;
import i8.r0;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v9.x0;
import v9.z0;

/* loaded from: classes.dex */
public final class p extends a0 {

    /* renamed from: n, reason: collision with root package name */
    public final f8.e f9588n;

    /* renamed from: o, reason: collision with root package name */
    public final l8.o f9589o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f9590p;

    /* renamed from: q, reason: collision with root package name */
    public final u9.i f9591q;

    /* renamed from: r, reason: collision with root package name */
    public final u9.i f9592r;

    /* renamed from: s, reason: collision with root package name */
    public final u9.i f9593s;

    /* renamed from: t, reason: collision with root package name */
    public final u9.i f9594t;

    /* renamed from: u, reason: collision with root package name */
    public final b0.e f9595u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(a3.b bVar, f8.e eVar, l8.o oVar, boolean z4, p pVar) {
        super(bVar, pVar);
        q7.k.e(bVar, "c");
        q7.k.e(oVar, "jClass");
        this.f9588n = eVar;
        this.f9589o = oVar;
        this.f9590p = z4;
        u9.n nVar = ((r8.a) bVar.f162f).f9002a;
        n nVar2 = new n(this, bVar);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f9591q = new u9.i(kVar, nVar2);
        o oVar2 = new o(this, 1);
        u9.k kVar2 = (u9.k) nVar;
        kVar2.getClass();
        this.f9592r = new u9.i(kVar2, oVar2);
        n nVar3 = new n(bVar, this);
        u9.k kVar3 = (u9.k) nVar;
        kVar3.getClass();
        this.f9593s = new u9.i(kVar3, nVar3);
        o oVar3 = new o(this, 0);
        u9.k kVar4 = (u9.k) nVar;
        kVar4.getClass();
        this.f9594t = new u9.i(kVar4, oVar3);
        this.f9595u = ((u9.k) nVar).c(new g1.y(22, this, bVar));
    }

    public static l0 C(l0 l0Var, f8.t tVar, AbstractCollection abstractCollection) {
        if (abstractCollection.isEmpty()) {
            return l0Var;
        }
        Iterator it = abstractCollection.iterator();
        while (it.hasNext()) {
            l0 l0Var2 = (l0) it.next();
            if (!l0Var.equals(l0Var2) && l0Var2.G == null && F(l0Var2, tVar)) {
                f8.t tVarBuild = l0Var.o0().m().build();
                q7.k.b(tVarBuild);
                return (l0) tVarBuild;
            }
        }
        return l0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i8.l0 D(i8.l0 r5) {
        /*
            java.util.List r0 = r5.x0()
            java.lang.String r1 = "valueParameters"
            q7.k.d(r0, r1)
            java.lang.Object r0 = d7.r.X0(r0)
            i8.r0 r0 = (i8.r0) r0
            r2 = 0
            if (r0 == 0) goto L7d
            r3 = r0
            i8.s0 r3 = (i8.s0) r3
            v9.v r3 = r3.getType()
            v9.m0 r3 = r3.E0()
            f8.g r3 = r3.c()
            if (r3 == 0) goto L36
            e9.e r3 = l9.d.h(r3)
            boolean r4 = r3.d()
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r3 = r2
        L2f:
            if (r3 == 0) goto L36
            e9.c r3 = r3.g()
            goto L37
        L36:
            r3 = r2
        L37:
            e9.c r4 = c8.n.f2061f
            boolean r3 = q7.k.a(r3, r4)
            if (r3 == 0) goto L40
            goto L41
        L40:
            r0 = r2
        L41:
            if (r0 != 0) goto L44
            goto L7d
        L44:
            f8.s r2 = r5.o0()
            java.util.List r5 = r5.x0()
            q7.k.d(r5, r1)
            java.util.List r5 = d7.r.L0(r5)
            f8.s r5 = r2.d(r5)
            i8.s0 r0 = (i8.s0) r0
            v9.v r0 = r0.getType()
            java.util.List r0 = r0.C0()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            v9.p0 r0 = (v9.p0) r0
            v9.v r0 = r0.b()
            f8.s r5 = r5.w(r0)
            f8.t r5 = r5.build()
            i8.l0 r5 = (i8.l0) r5
            if (r5 != 0) goto L79
            return r5
        L79:
            r0 = 1
            r5.f4889z = r0
            return r5
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.p.D(i8.l0):i8.l0");
    }

    public static boolean F(f8.t tVar, f8.t tVar2) {
        int iC = h9.l.f4243c.n(tVar2, tVar, true).c();
        m.x.y(iC, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return iC == 1 && !n7.m.n(tVar2, tVar);
    }

    public static boolean G(l0 l0Var, l0 l0Var2) {
        int i2 = o8.d.f7798l;
        q7.k.e(l0Var, "<this>");
        if (q7.k.a(l0Var.getName().b(), "removeAt") && q7.k.a(nb.i.n(l0Var), o8.f0.f7820g.f7797b)) {
            l0Var2 = l0Var2.a();
        }
        q7.k.d(l0Var2, "if (superDescriptor.isRe…iginal else subDescriptor");
        return F(l0Var2, l0Var);
    }

    public static l0 H(f8.l0 l0Var, String str, p7.k kVar) {
        l0 l0Var2;
        Iterator it = ((Iterable) kVar.invoke(e9.f.e(str))).iterator();
        do {
            l0Var2 = null;
            if (!it.hasNext()) {
                break;
            }
            l0 l0Var3 = (l0) it.next();
            if (l0Var3.x0().size() == 0) {
                w9.m mVar = w9.e.f10930a;
                v9.v vVar = l0Var3.f4875l;
                if (vVar == null ? false : mVar.b(vVar, l0Var.getType())) {
                    l0Var2 = l0Var3;
                }
            }
        } while (l0Var2 == null);
        return l0Var2;
    }

    public static l0 J(f8.l0 l0Var, p7.k kVar) {
        l0 l0Var2;
        v9.v vVar;
        String strB = l0Var.getName().b();
        q7.k.d(strB, "name.asString()");
        Iterator it = ((Iterable) kVar.invoke(e9.f.e(o8.w.b(strB)))).iterator();
        do {
            l0Var2 = null;
            if (!it.hasNext()) {
                break;
            }
            l0 l0Var3 = (l0) it.next();
            if (l0Var3.x0().size() == 1 && (vVar = l0Var3.f4875l) != null) {
                e9.f fVar = c8.h.f1999e;
                if (c8.h.D(vVar, c8.m.f2033d)) {
                    w9.m mVar = w9.e.f10930a;
                    List listX0 = l0Var3.x0();
                    q7.k.d(listX0, "descriptor.valueParameters");
                    if (mVar.a(((r0) d7.r.f1(listX0)).getType(), l0Var.getType())) {
                        l0Var2 = l0Var3;
                    }
                }
            }
        } while (l0Var2 == null);
        return l0Var2;
    }

    public static boolean M(l0 l0Var, f8.t tVar) {
        String strM = nb.i.m(l0Var, 2);
        f8.t tVarA = tVar.a();
        q7.k.d(tVarA, "builtinWithErasedParameters.original");
        return strM.equals(nb.i.m(tVarA, 2)) && !F(l0Var, tVar);
    }

    public static final ArrayList v(p pVar, e9.f fVar) {
        Collection collectionB = ((c) pVar.f9521e.c()).b(fVar);
        ArrayList arrayList = new ArrayList(d7.t.A0(collectionB, 10));
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            arrayList.add(pVar.t((l8.x) it.next()));
        }
        return arrayList;
    }

    public static final ArrayList w(p pVar, e9.f fVar) {
        LinkedHashSet linkedHashSetK = pVar.K(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetK) {
            l0 l0Var = (l0) obj;
            q7.k.e(l0Var, "<this>");
            if (nb.i.z(l0Var) == null && o8.f.a(l0Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void A(Set set, AbstractCollection abstractCollection, ea.h hVar, p7.k kVar) {
        l0 l0VarJ;
        k0 k0VarM;
        q8.d dVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f8.l0 l0Var = (f8.l0) it.next();
            if (E(l0Var, kVar)) {
                l0 l0VarI = I(l0Var, kVar);
                q7.k.b(l0VarI);
                if (l0Var.F()) {
                    l0VarJ = J(l0Var, kVar);
                    q7.k.b(l0VarJ);
                } else {
                    l0VarJ = null;
                }
                if (l0VarJ != null) {
                    l0VarJ.i();
                    l0VarI.i();
                }
                f8.e eVar = this.f9588n;
                q7.k.e(eVar, "ownerDescriptor");
                q8.d dVar2 = new q8.d(eVar, g8.h.f3888a, l0VarI.i(), l0VarI.c(), l0VarJ != null, l0Var.getName(), l0VarI.q(), null, 1, false, null);
                v9.v vVar = l0VarI.f4875l;
                q7.k.b(vVar);
                i8.v vVarP = p();
                d7.z zVar = d7.z.f2978f;
                dVar2.N0(vVar, zVar, vVarP, null, zVar);
                j0 j0VarL = h9.m.l(dVar2, l0VarI.getAnnotations(), false, l0VarI.q());
                j0VarL.f4777q = l0VarI;
                j0VarL.J0(dVar2.getType());
                if (l0VarJ != null) {
                    List listX0 = l0VarJ.x0();
                    q7.k.d(listX0, "setterMethod.valueParameters");
                    r0 r0Var = (r0) d7.r.P0(listX0);
                    if (r0Var == null) {
                        throw new AssertionError("No parameter found for " + l0VarJ);
                    }
                    k0VarM = h9.m.m(dVar2, l0VarJ.getAnnotations(), r0Var.getAnnotations(), false, l0VarJ.c(), l0VarJ.q());
                    k0VarM.f4777q = l0VarJ;
                } else {
                    k0VarM = null;
                }
                dVar2.K0(j0VarL, k0VarM, null, null);
                dVar = dVar2;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                abstractCollection.add(dVar);
                if (hVar != null) {
                    hVar.add(l0Var);
                    return;
                }
                return;
            }
        }
    }

    public final Collection B() {
        boolean z4 = this.f9590p;
        f8.e eVar = this.f9588n;
        if (z4) {
            Collection collectionD = eVar.h().d();
            q7.k.d(collectionD, "ownerDescriptor.typeConstructor.supertypes");
            return collectionD;
        }
        ((w9.m) ((r8.a) this.f9518b.f162f).f9022u).getClass();
        q7.k.e(eVar, "classDescriptor");
        Collection collectionD2 = eVar.h().d();
        q7.k.d(collectionD2, "classDescriptor.typeConstructor.supertypes");
        return collectionD2;
    }

    public final boolean E(f8.l0 l0Var, p7.k kVar) {
        if (nb.i.E(l0Var)) {
            return false;
        }
        l0 l0VarI = I(l0Var, kVar);
        l0 l0VarJ = J(l0Var, kVar);
        if (l0VarI == null) {
            return false;
        }
        if (l0Var.F()) {
            return l0VarJ != null && l0VarJ.i() == l0VarI.i();
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    public final l0 I(f8.l0 l0Var, p7.k kVar) {
        e9.f fVar;
        j0 j0VarB = l0Var.b();
        String strB = null;
        j0 j0Var = j0VarB != null ? (j0) nb.i.z(j0VarB) : null;
        if (j0Var != null) {
            c8.h.z(j0Var);
            f8.c cVarB = l9.d.b(l9.d.k(j0Var), o8.e.f7801j);
            if (cVarB != null && (fVar = (e9.f) o8.g.f7825a.get(l9.d.g(cVarB))) != null) {
                strB = fVar.b();
            }
        }
        if (strB != null && !nb.i.D(this.f9588n, j0Var)) {
            return H(l0Var, strB, kVar);
        }
        String strB2 = l0Var.getName().b();
        q7.k.d(strB2, "name.asString()");
        return H(l0Var, o8.w.a(strB2), kVar);
    }

    public final LinkedHashSet K(e9.f fVar) {
        Collection collectionB = B();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            d7.x.D0(linkedHashSet, ((v9.v) it.next()).v0().f(fVar, n8.c.f6881j));
        }
        return linkedHashSet;
    }

    public final Set L(e9.f fVar) {
        Collection collectionB = B();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            Collection collectionA = ((v9.v) it.next()).v0().a(fVar, n8.c.f6881j);
            ArrayList arrayList2 = new ArrayList(d7.t.A0(collectionA, 10));
            Iterator it2 = collectionA.iterator();
            while (it2.hasNext()) {
                arrayList2.add((f8.l0) it2.next());
            }
            d7.x.D0(arrayList, arrayList2);
        }
        return d7.r.q1(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cc A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean N(i8.l0 r9) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.p.N(i8.l0):boolean");
    }

    public final void O(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        q7.k.e(((r8.a) this.f9518b.f162f).f9015n, "<this>");
        q7.k.e(this.f9588n, "scopeOwner");
    }

    @Override // s8.a0, o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        O(fVar, cVar);
        return super.a(fVar, cVar);
    }

    @Override // o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        b0.e eVar;
        f8.e eVar2;
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        O(fVar, aVar);
        p pVar = (p) this.f9519c;
        return (pVar == null || (eVar = pVar.f9595u) == null || (eVar2 = (f8.e) eVar.invoke(fVar)) == null) ? (f8.g) this.f9595u.invoke(fVar) : eVar2;
    }

    @Override // s8.a0, o9.o, o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        O(fVar, aVar);
        return super.f(fVar, aVar);
    }

    @Override // s8.a0
    public final Set h(o9.f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        return i0.Y((Set) this.f9592r.c(), ((Map) this.f9594t.c()).keySet());
    }

    @Override // s8.a0
    public final Set i(o9.f fVar, o9.k kVar) {
        q7.k.e(fVar, "kindFilter");
        f8.e eVar = this.f9588n;
        Collection collectionD = eVar.h().d();
        q7.k.d(collectionD, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            d7.x.D0(linkedHashSet, ((v9.v) it.next()).v0().c());
        }
        u9.i iVar = this.f9521e;
        linkedHashSet.addAll(((c) iVar.c()).a());
        linkedHashSet.addAll(((c) iVar.c()).c());
        linkedHashSet.addAll(h(fVar, kVar));
        a3.b bVar = this.f9518b;
        ((m9.a) ((r8.a) bVar.f162f).f9025x).getClass();
        q7.k.e(bVar, "_context_receiver_0");
        q7.k.e(eVar, "thisDescriptor");
        linkedHashSet.addAll(new ArrayList());
        return linkedHashSet;
    }

    @Override // s8.a0
    public final void j(e9.f fVar, ArrayList arrayList) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        q7.k.e(fVar, "name");
        boolean zF = this.f9589o.f();
        f8.e eVar = this.f9588n;
        a3.b bVar = this.f9518b;
        if (zF) {
            u9.i iVar = this.f9521e;
            if (((c) iVar.c()).f(fVar) != null) {
                if (arrayList.isEmpty()) {
                    l8.a0 a0VarF = ((c) iVar.c()).f(fVar);
                    q7.k.b(a0VarF);
                    r8.d dVarX = n7.o.x(bVar, a0VarF);
                    r8.a aVar = (r8.a) bVar.f162f;
                    q8.e eVarV0 = q8.e.V0(eVar, dVarX, a0VarF.c(), aVar.f9011j.c(a0VarF), true);
                    v9.v vVarR = ((i5.l) bVar.f166j).R(a0VarF.f(), n7.b.x(2, false, null, 6));
                    i8.v vVarP = p();
                    f8.n nVar = f8.o.f3492e;
                    d7.z zVar = d7.z.f2978f;
                    eVarV0.U0(null, vVarP, zVar, zVar, zVar, vVarR, 3, nVar, null);
                    eVarV0.I = 1;
                    aVar.f9008g.getClass();
                    arrayList.add(eVarV0);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((l0) it.next()).x0().isEmpty()) {
                            break;
                        }
                    }
                    l8.a0 a0VarF2 = ((c) iVar.c()).f(fVar);
                    q7.k.b(a0VarF2);
                    r8.d dVarX2 = n7.o.x(bVar, a0VarF2);
                    r8.a aVar2 = (r8.a) bVar.f162f;
                    q8.e eVarV02 = q8.e.V0(eVar, dVarX2, a0VarF2.c(), aVar2.f9011j.c(a0VarF2), true);
                    v9.v vVarR2 = ((i5.l) bVar.f166j).R(a0VarF2.f(), n7.b.x(2, false, null, 6));
                    i8.v vVarP2 = p();
                    f8.n nVar2 = f8.o.f3492e;
                    d7.z zVar2 = d7.z.f2978f;
                    eVarV02.U0(null, vVarP2, zVar2, zVar2, zVar2, vVarR2, 3, nVar2, null);
                    eVarV02.I = 1;
                    aVar2.f9008g.getClass();
                    arrayList.add(eVarV02);
                }
            }
        }
        ((m9.a) ((r8.a) bVar.f162f).f9025x).getClass();
        q7.k.e(bVar, "_context_receiver_0");
        q7.k.e(eVar, "thisDescriptor");
        q7.k.e(fVar, "name");
    }

    @Override // s8.a0
    public final c k() {
        return new a(this.f9589o, k.f9574h);
    }

    @Override // s8.a0
    public final void m(LinkedHashSet linkedHashSet, e9.f fVar) {
        q7.k.e(fVar, "name");
        LinkedHashSet linkedHashSetK = K(fVar);
        ArrayList arrayList = o8.f0.f7814a;
        if (!o8.f0.f7823j.contains(fVar)) {
            int i2 = o8.f.f7813l;
            if (!o8.f.b(fVar)) {
                if (!linkedHashSetK.isEmpty()) {
                    Iterator it = linkedHashSetK.iterator();
                    while (it.hasNext()) {
                        if (((f8.t) it.next()).o()) {
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : linkedHashSetK) {
                    if (N((l0) obj)) {
                        arrayList2.add(obj);
                    }
                }
                y(linkedHashSet, fVar, arrayList2, false);
                return;
            }
        }
        ea.h hVar = new ea.h();
        LinkedHashSet linkedHashSetH = nb.i.H(fVar, linkedHashSetK, d7.z.f2978f, this.f9588n, r9.l.f9079a, ((w9.m) ((r8.a) this.f9518b.f162f).f9022u).f10950d);
        z(fVar, linkedHashSet, linkedHashSetH, linkedHashSet, new l(1, 0, this));
        z(fVar, linkedHashSet, linkedHashSetH, hVar, new l(1, 1, this));
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : linkedHashSetK) {
            if (N((l0) obj2)) {
                arrayList3.add(obj2);
            }
        }
        y(linkedHashSet, fVar, d7.r.c1(arrayList3, hVar), true);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [c7.f, java.lang.Object] */
    @Override // s8.a0
    public final void n(e9.f fVar, ArrayList arrayList) {
        Set setQ1;
        l8.x xVar;
        q7.k.e(fVar, "name");
        boolean zIsAnnotation = this.f9589o.f5878a.isAnnotation();
        a3.b bVar = this.f9518b;
        if (zIsAnnotation && (xVar = (l8.x) d7.r.g1(((c) this.f9521e.c()).b(fVar))) != null) {
            q8.f fVarO0 = q8.f.O0(this.f9588n, n7.o.x(bVar, xVar), n7.a.B(xVar.e()), false, xVar.c(), ((r8.a) bVar.f162f).f9011j.c(xVar), false);
            j0 j0VarF = h9.m.f(fVarO0, g8.h.f3888a);
            fVarO0.K0(j0VarF, null, null, null);
            q7.k.e(bVar, "<this>");
            v9.v vVarL = a0.l(xVar, new a3.b((r8.a) bVar.f162f, new g3.e(bVar, fVarO0, xVar, 0), bVar.f164h));
            i8.v vVarP = p();
            d7.z zVar = d7.z.f2978f;
            fVarO0.N0(vVarL, zVar, vVarP, null, zVar);
            j0VarF.f4813r = vVarL;
            arrayList.add(fVarO0);
        }
        Set setL = L(fVar);
        if (setL.isEmpty()) {
            return;
        }
        ea.h hVar = new ea.h();
        ea.h hVar2 = new ea.h();
        A(setL, arrayList, hVar, new m(this, 0));
        if (hVar.isEmpty()) {
            setQ1 = d7.r.q1(setL);
        } else if (hVar instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object obj : setL) {
                if (!hVar.contains(obj)) {
                    linkedHashSet.add(obj);
                }
            }
            setQ1 = linkedHashSet;
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(setL);
            linkedHashSet2.removeAll(hVar);
            setQ1 = linkedHashSet2;
        }
        A(setQ1, hVar2, null, new m(this, 1));
        LinkedHashSet linkedHashSetY = i0.Y(setL, hVar2);
        r8.a aVar = (r8.a) bVar.f162f;
        arrayList.addAll(nb.i.H(fVar, linkedHashSetY, arrayList, this.f9588n, aVar.f9007f, ((w9.m) aVar.f9022u).f10950d));
    }

    @Override // s8.a0
    public final Set o(o9.f fVar) {
        q7.k.e(fVar, "kindFilter");
        if (this.f9589o.f5878a.isAnnotation()) {
            return c();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((c) this.f9521e.c()).d());
        Collection collectionD = this.f9588n.h().d();
        q7.k.d(collectionD, "ownerDescriptor.typeConstructor.supertypes");
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            d7.x.D0(linkedHashSet, ((v9.v) it.next()).v0().d());
        }
        return linkedHashSet;
    }

    @Override // s8.a0
    public final i8.v p() {
        f8.e eVar = this.f9588n;
        if (eVar != null) {
            int i2 = h9.f.f4236a;
            return eVar.B0();
        }
        h9.f.a(0);
        throw null;
    }

    @Override // s8.a0
    public final f8.j q() {
        return this.f9588n;
    }

    @Override // s8.a0
    public final boolean r(q8.e eVar) {
        if (this.f9589o.f5878a.isAnnotation()) {
            return false;
        }
        return N(eVar);
    }

    @Override // s8.a0
    public final x s(l8.x xVar, ArrayList arrayList, v9.v vVar, List list) {
        q7.k.e(xVar, "method");
        ((r8.a) this.f9518b.f162f).f9006e.getClass();
        if (this.f9588n != null) {
            List list2 = Collections.EMPTY_LIST;
            if (list2 != null) {
                return new x(vVar, list, arrayList, list2);
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"));
        }
        Object[] objArr = new Object[3];
        switch (1) {
            case 1:
                objArr[0] = "owner";
                break;
            case 2:
                objArr[0] = "returnType";
                break;
            case 3:
                objArr[0] = "valueParameters";
                break;
            case 4:
                objArr[0] = "typeParameters";
                break;
            case 5:
                objArr[0] = "descriptor";
                break;
            case 6:
                objArr[0] = "signatureErrors";
                break;
            default:
                objArr[0] = "method";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
        objArr[2] = "resolvePropagatedSignature";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // s8.a0
    public final String toString() {
        return "Lazy Java member scope for " + this.f9589o.c();
    }

    public final void x(ArrayList arrayList, q8.b bVar, int i2, l8.x xVar, v9.v vVar, v9.v vVar2) {
        v8.a tVar;
        e9.f fVarC = xVar.c();
        if (vVar == null) {
            x0.a(2);
            throw null;
        }
        z0 z0VarG = x0.g(vVar, false);
        Object defaultValue = xVar.f5886a.getDefaultValue();
        if (defaultValue != null) {
            Class<?> cls = defaultValue.getClass();
            List list = l8.d.f5857a;
            tVar = Enum.class.isAssignableFrom(cls) ? new l8.t(null, (Enum) defaultValue) : defaultValue instanceof Annotation ? new l8.g(null, (Annotation) defaultValue) : defaultValue instanceof Object[] ? new l8.h(null, (Object[]) defaultValue) : defaultValue instanceof Class ? new l8.p(null, (Class) defaultValue) : new l8.v(null, defaultValue);
        } else {
            tVar = null;
        }
        arrayList.add(new r0(bVar, null, i2, g8.h.f3888a, fVarC, z0VarG, tVar != null, false, false, vVar2 != null ? x0.g(vVar2, false) : null, ((r8.a) this.f9518b.f162f).f9011j.c(xVar)));
    }

    public final void y(LinkedHashSet linkedHashSet, e9.f fVar, ArrayList arrayList, boolean z4) {
        r8.a aVar = (r8.a) this.f9518b.f162f;
        LinkedHashSet<l0> linkedHashSetH = nb.i.H(fVar, arrayList, linkedHashSet, this.f9588n, aVar.f9007f, ((w9.m) aVar.f9022u).f10950d);
        if (!z4) {
            linkedHashSet.addAll(linkedHashSetH);
            return;
        }
        ArrayList arrayListC1 = d7.r.c1(linkedHashSet, linkedHashSetH);
        ArrayList arrayList2 = new ArrayList(d7.t.A0(linkedHashSetH, 10));
        for (l0 l0VarC : linkedHashSetH) {
            l0 l0Var = (l0) nb.i.A(l0VarC);
            if (l0Var != null) {
                l0VarC = C(l0VarC, l0Var, arrayListC1);
            }
            arrayList2.add(l0VarC);
        }
        linkedHashSet.addAll(arrayList2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(e9.f r9, java.util.LinkedHashSet r10, java.util.LinkedHashSet r11, java.util.AbstractSet r12, p7.k r13) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.p.z(e9.f, java.util.LinkedHashSet, java.util.LinkedHashSet, java.util.AbstractSet, p7.k):void");
    }
}
