package h9;

import b0.w0;
import d7.r;
import f8.n;
import f8.o;
import f8.q0;
import f8.t;
import i8.g0;
import i8.i0;
import i8.k0;
import i8.r0;
import i8.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;
import v9.l0;
import v9.v;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final List f4242b = r.m1(ServiceLoader.load(g.class, g.class.getClassLoader()));

    /* renamed from: c, reason: collision with root package name */
    public static final l f4243c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f4244d;

    /* renamed from: a, reason: collision with root package name */
    public final w9.d f4245a;

    static {
        d dVar = new d();
        f4244d = dVar;
        f4243c = new l(dVar);
    }

    public l(w9.d dVar) {
        if (dVar != null) {
            this.f4245a = dVar;
        } else {
            a(5);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r25) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.l.a(int):void");
    }

    public static boolean b(v vVar, v vVar2, l0 l0Var) {
        if (vVar == null) {
            a(46);
            throw null;
        }
        if (vVar2 == null) {
            a(47);
            throw null;
        }
        if (v9.c.i(vVar) && v9.c.i(vVar2)) {
            return true;
        }
        return v9.d.g(l0Var, vVar.H0(), vVar2.H0());
    }

    public static void c(f8.c cVar, LinkedHashSet linkedHashSet) {
        if (cVar == null) {
            a(17);
            throw null;
        }
        if (cVar.getKind() != 2) {
            linkedHashSet.add(cVar);
            return;
        }
        if (cVar.r().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + cVar);
        }
        Iterator it = cVar.r().iterator();
        while (it.hasNext()) {
            c((f8.c) it.next(), linkedHashSet);
        }
    }

    public static ArrayList d(f8.b bVar) {
        i8.v vVarI = bVar.I();
        ArrayList arrayList = new ArrayList();
        if (vVarI != null) {
            arrayList.add(vVarI.getType());
        }
        Iterator it = bVar.x0().iterator();
        while (it.hasNext()) {
            arrayList.add(((r0) it.next()).getType());
        }
        return arrayList;
    }

    public static void e(Collection collection, f8.e eVar, m mVar) {
        if (collection == null) {
            a(85);
            throw null;
        }
        if (eVar == null) {
            a(86);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (true) {
            boolean z4 = false;
            int i2 = 1;
            if (!it.hasNext()) {
                boolean zIsEmpty = arrayList.isEmpty();
                if (!zIsEmpty) {
                    collection = arrayList;
                }
                Iterator it2 = collection.iterator();
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    if (it2.hasNext()) {
                        f8.c cVar = (f8.c) it2.next();
                        int iD = n.f.d(cVar.i());
                        if (iD == 0) {
                            break;
                        }
                        if (iD == 1) {
                            throw new IllegalStateException("Member cannot have SEALED modality: " + cVar);
                        }
                        if (iD == 2) {
                            z10 = true;
                        } else if (iD == 3) {
                            z11 = true;
                        }
                    } else {
                        if (eVar.Z() && eVar.i() != 4 && eVar.i() != 2) {
                            z4 = true;
                        }
                        if (z10 && !z11) {
                            i2 = 3;
                        } else if (z10 || !z11) {
                            HashSet<f8.c> hashSet = new HashSet();
                            for (f8.c cVar2 : collection) {
                                if (cVar2 == null) {
                                    a(15);
                                    throw null;
                                }
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                c(cVar2, linkedHashSet);
                                hashSet.addAll(linkedHashSet);
                            }
                            if (!hashSet.isEmpty() && l9.d.j((f8.j) hashSet.iterator().next()).s0(w9.h.f10934a) != null) {
                                throw new ClassCastException();
                            }
                            if (hashSet.size() > 1) {
                                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                Iterator it3 = hashSet.iterator();
                                while (it3.hasNext()) {
                                    Object next = it3.next();
                                    Iterator it4 = linkedHashSet2.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            linkedHashSet2.add(next);
                                            break;
                                        }
                                        f8.b bVar = (f8.b) next;
                                        f8.b bVar2 = (f8.b) it4.next();
                                        if (!q(bVar, bVar2)) {
                                            if (q(bVar2, bVar)) {
                                                break;
                                            }
                                        } else {
                                            it4.remove();
                                        }
                                    }
                                }
                                hashSet = linkedHashSet2;
                            }
                            int i10 = eVar.i();
                            if (i10 == 0) {
                                a(94);
                                throw null;
                            }
                            i2 = 4;
                            for (f8.c cVar3 : hashSet) {
                                int i11 = (z4 && cVar3.i() == 4) ? i10 : cVar3.i();
                                if (n.f.a(i11, i2) < 0) {
                                    i2 = i11;
                                }
                            }
                            if (i2 == 0) {
                                a(95);
                                throw null;
                            }
                        } else {
                            i2 = z4 ? eVar.i() : 4;
                            if (i2 == 0) {
                                a(92);
                                throw null;
                            }
                        }
                    }
                }
                f8.c cVarY = ((f8.c) s(collection, new j(0))).Y(eVar, i2, zIsEmpty ? o.f3495h : o.f3494g);
                mVar.p(cVarY, collection);
                mVar.b(cVarY);
                return;
            }
            Object next2 = it.next();
            f8.c cVar4 = (f8.c) next2;
            if (!o.e(cVar4.c())) {
                if (cVar4 == null) {
                    o.a(2);
                    throw null;
                }
                if (eVar == null) {
                    o.a(3);
                    throw null;
                }
                if (o.c(o.f3499l, cVar4, eVar) == null) {
                    z4 = true;
                }
            }
            if (z4) {
                arrayList.add(next2);
            }
        }
    }

    public static ArrayList g(Object obj, LinkedList linkedList, p7.k kVar, p7.k kVar2) {
        if (obj == null) {
            a(99);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        f8.b bVar = (f8.b) kVar.invoke(obj);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            f8.b bVar2 = (f8.b) kVar.invoke(next);
            if (obj == next) {
                it.remove();
            } else {
                int iJ = j(bVar, bVar2);
                if (iJ == 1) {
                    arrayList.add(next);
                    it.remove();
                } else if (iJ == 3) {
                    kVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static k i(f8.b bVar, f8.b bVar2) {
        boolean z4;
        if (bVar == null) {
            a(40);
            throw null;
        }
        if (bVar2 == null) {
            a(41);
            throw null;
        }
        boolean z10 = bVar instanceof t;
        if ((z10 && !(bVar2 instanceof t)) || (((z4 = bVar instanceof f8.l0)) && !(bVar2 instanceof f8.l0))) {
            return k.d("Member kind mismatch");
        }
        if (!z10 && !z4) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + bVar);
        }
        if (!bVar.getName().equals(bVar2.getName())) {
            return k.d("Name mismatch");
        }
        k kVarD = (bVar.I() == null) != (bVar2.I() == null) ? k.d("Receiver presence mismatch") : bVar.x0().size() != bVar2.x0().size() ? k.d("Value parameter number mismatch") : null;
        if (kVarD != null) {
            return kVarD;
        }
        return null;
    }

    public static int j(f8.b bVar, f8.b bVar2) {
        l lVar = f4243c;
        int iC = lVar.l(bVar2, bVar, null).c();
        int iC2 = lVar.m(bVar, bVar2, null, false).c();
        if (iC == 1 && iC2 == 1) {
            return 1;
        }
        return (iC == 3 || iC2 == 3) ? 3 : 2;
    }

    public static boolean k(f8.b bVar, f8.b bVar2) {
        if (bVar == null) {
            a(67);
            throw null;
        }
        if (bVar2 == null) {
            a(68);
            throw null;
        }
        v vVarF = bVar.f();
        v vVarF2 = bVar2.f();
        if (!p(bVar, bVar2)) {
            return false;
        }
        l0 l0VarF = f4243c.f(bVar.getTypeParameters(), bVar2.getTypeParameters());
        if (bVar instanceof t) {
            return o(bVar, vVarF, bVar2, vVarF2, l0VarF);
        }
        if (!(bVar instanceof f8.l0)) {
            throw new IllegalArgumentException("Unexpected callable: " + bVar.getClass());
        }
        f8.l0 l0Var = (f8.l0) bVar;
        f8.l0 l0Var2 = (f8.l0) bVar2;
        k0 k0VarG = l0Var.g();
        k0 k0VarG2 = l0Var2.g();
        if ((k0VarG == null || k0VarG2 == null) ? true : p(k0VarG, k0VarG2)) {
            return (l0Var.F() && l0Var2.F()) ? v9.d.g(l0VarF, vVarF.H0(), vVarF2.H0()) : (l0Var.F() || !l0Var2.F()) && o(bVar, vVarF, bVar2, vVarF2, l0VarF);
        }
        return false;
    }

    public static boolean o(f8.b bVar, v vVar, f8.b bVar2, v vVar2, l0 l0Var) {
        if (bVar == null) {
            a(73);
            throw null;
        }
        if (vVar == null) {
            a(74);
            throw null;
        }
        if (bVar2 == null) {
            a(75);
            throw null;
        }
        if (vVar2 != null) {
            return v9.d.n(v9.d.f10541a, l0Var, vVar.H0(), vVar2.H0());
        }
        a(76);
        throw null;
    }

    public static boolean p(f8.b bVar, f8.b bVar2) {
        if (bVar == null) {
            a(69);
            throw null;
        }
        if (bVar2 != null) {
            Integer numB = o.b(bVar.c(), bVar2.c());
            return numB == null || numB.intValue() >= 0;
        }
        a(70);
        throw null;
    }

    public static boolean q(f8.b bVar, f8.b bVar2) {
        if (bVar == null) {
            a(13);
            throw null;
        }
        if (bVar2 == null) {
            a(14);
            throw null;
        }
        boolean zEquals = bVar.equals(bVar2);
        d dVar = d.f4235a;
        if (!zEquals && dVar.c(bVar.a(), bVar2.a(), false)) {
            return true;
        }
        f8.b bVarA = bVar2.a();
        int i2 = f.f4236a;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f.b(bVar.a(), linkedHashSet);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (dVar.c(bVarA, (f8.b) it.next(), false)) {
                return true;
            }
        }
        return false;
    }

    public static void r(f8.c cVar, p7.k kVar) {
        n nVar;
        n nVarF;
        n nVar2;
        if (cVar == null) {
            a(107);
            throw null;
        }
        for (f8.c cVar2 : cVar.r()) {
            if (cVar2.c() == o.f3494g) {
                r(cVar2, kVar);
            }
        }
        if (cVar.c() != o.f3494g) {
            return;
        }
        Collection<f8.c> collectionR = cVar.r();
        if (collectionR == null) {
            a(109);
            throw null;
        }
        if (collectionR.isEmpty()) {
            nVarF = o.f3497j;
        } else {
            Iterator it = collectionR.iterator();
            loop3: while (true) {
                nVar = null;
                while (it.hasNext()) {
                    n nVarC = ((f8.c) it.next()).c();
                    if (nVar != null) {
                        Integer numB = o.b(nVarC, nVar);
                        if (numB == null) {
                            break;
                        } else if (numB.intValue() > 0) {
                        }
                    }
                    nVar = nVarC;
                }
            }
            if (nVar == null) {
                nVarF = null;
                break;
            }
            Iterator it2 = collectionR.iterator();
            while (it2.hasNext()) {
                Integer numB2 = o.b(nVar, ((f8.c) it2.next()).c());
                if (numB2 == null || numB2.intValue() < 0) {
                    nVarF = null;
                    break;
                }
            }
            nVarF = nVar;
        }
        if (nVarF == null) {
            nVarF = null;
            break;
        }
        if (cVar.getKind() == 2) {
            for (f8.c cVar3 : collectionR) {
                if (cVar3.i() != 4 && !cVar3.c().equals(nVarF)) {
                    nVarF = null;
                    break;
                }
            }
        } else {
            nVarF = o.f(nVarF.f3485a.c());
        }
        if (nVarF == null) {
            if (kVar != null) {
                kVar.invoke(cVar);
            }
            nVar2 = o.f3492e;
        } else {
            nVar2 = nVarF;
        }
        if (cVar instanceof i0) {
            i0 i0Var = (i0) cVar;
            if (nVar2 == null) {
                i0.R(20);
                throw null;
            }
            i0Var.f4799o = nVar2;
            Iterator it3 = ((f8.l0) cVar).t().iterator();
            while (it3.hasNext()) {
                r((f8.k0) it3.next(), nVarF == null ? null : kVar);
            }
            return;
        }
        if (cVar instanceof u) {
            u uVar = (u) cVar;
            if (nVar2 != null) {
                uVar.f4880q = nVar2;
                return;
            } else {
                u.R(10);
                throw null;
            }
        }
        g0 g0Var = (g0) cVar;
        g0Var.f4776p = nVar2;
        if (nVar2 != g0Var.G0().c()) {
            g0Var.f4770j = false;
        }
    }

    public static Object s(Collection collection, p7.k kVar) {
        Object next;
        if (collection.size() == 1) {
            Object objM0 = r.M0(collection);
            if (objM0 != null) {
                return objM0;
            }
            a(80);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(d7.t.A0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(kVar.invoke(it.next()));
        }
        Object objM02 = r.M0(collection);
        f8.b bVar = (f8.b) kVar.invoke(objM02);
        for (Object obj : collection) {
            f8.b bVar2 = (f8.b) kVar.invoke(obj);
            if (bVar2 == null) {
                a(71);
                throw null;
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    arrayList.add(obj);
                    break;
                }
                if (!k(bVar2, (f8.b) it2.next())) {
                    break;
                }
            }
            if (k(bVar2, bVar) && !k(bVar, bVar2)) {
                objM02 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objM02 != null) {
                return objM02;
            }
            a(81);
            throw null;
        }
        if (arrayList.size() == 1) {
            Object objM03 = r.M0(arrayList);
            if (objM03 != null) {
                return objM03;
            }
            a(82);
            throw null;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            if (!v9.c.j(((f8.b) kVar.invoke(next)).f())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        Object objM04 = r.M0(arrayList);
        if (objM04 != null) {
            return objM04;
        }
        a(84);
        throw null;
    }

    public final l0 f(List list, List list2) {
        w9.f fVar = w9.f.f10931f;
        if (list == null) {
            a(42);
            throw null;
        }
        if (list2 == null) {
            a(43);
            throw null;
        }
        boolean zIsEmpty = list.isEmpty();
        w9.g gVar = w9.g.f10933a;
        w9.d dVar = this.f4245a;
        if (zIsEmpty) {
            return new l0(true, true, new q6.b((HashMap) null, dVar), fVar, gVar);
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            map.put(((q0) list.get(i2)).h(), ((q0) list2.get(i2)).h());
        }
        return new l0(true, true, new q6.b(map, dVar), fVar, gVar);
    }

    public final void h(e9.f fVar, Collection collection, Collection collection2, f8.e eVar, m mVar) {
        Integer numB;
        if (fVar == null) {
            a(52);
            throw null;
        }
        if (collection == null) {
            a(53);
            throw null;
        }
        if (collection2 == null) {
            a(54);
            throw null;
        }
        if (eVar == null) {
            a(55);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            f8.c cVar = (f8.c) it.next();
            if (cVar == null) {
                a(59);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            ea.h hVar = new ea.h();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                f8.c cVar2 = (f8.c) it2.next();
                int iC = l(cVar2, cVar, eVar).c();
                boolean z4 = !o.e(cVar2.c()) && o.c(o.f3499l, cVar2, cVar) == null;
                int iD = n.f.d(iC);
                if (iD == 0) {
                    if (z4) {
                        hVar.add(cVar2);
                    }
                    arrayList.add(cVar2);
                } else if (iD == 2) {
                    if (z4) {
                        mVar.d(cVar2, cVar);
                    }
                    arrayList.add(cVar2);
                }
            }
            mVar.p(cVar, hVar);
            linkedHashSet.removeAll(arrayList);
        }
        if (linkedHashSet.size() >= 2) {
            f8.j jVarP = ((f8.c) linkedHashSet.iterator().next()).p();
            if (!linkedHashSet.isEmpty()) {
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    if (((f8.c) it3.next()).p() != jVarP) {
                        LinkedList<f8.c> linkedList = new LinkedList(linkedHashSet);
                        while (!linkedList.isEmpty()) {
                            linkedList.isEmpty();
                            f8.c cVar3 = null;
                            for (f8.c cVar4 : linkedList) {
                                if (cVar3 == null || ((numB = o.b(cVar3.c(), cVar4.c())) != null && numB.intValue() < 0)) {
                                    cVar3 = cVar4;
                                }
                            }
                            q7.k.b(cVar3);
                            e(g(cVar3, linkedList, new j(1), new w0(1, mVar, cVar3)), eVar, mVar);
                        }
                        return;
                    }
                }
            }
        }
        Iterator it4 = linkedHashSet.iterator();
        while (it4.hasNext()) {
            e(Collections.singleton((f8.c) it4.next()), eVar, mVar);
        }
    }

    public final k l(f8.b bVar, f8.b bVar2, f8.e eVar) {
        if (bVar == null) {
            a(19);
            throw null;
        }
        if (bVar2 != null) {
            return m(bVar, bVar2, eVar, false);
        }
        a(20);
        throw null;
    }

    public final k m(f8.b bVar, f8.b bVar2, f8.e eVar, boolean z4) {
        if (bVar == null) {
            a(22);
            throw null;
        }
        if (bVar2 == null) {
            a(23);
            throw null;
        }
        k kVarN = n(bVar, bVar2, z4);
        boolean z10 = kVarN.c() == 1;
        List<g> list = f4242b;
        for (g gVar : list) {
            if (gVar.b() != 1 && (!z10 || gVar.b() != 2)) {
                int iD = n.f.d(gVar.a(bVar, bVar2, eVar));
                if (iD == 0) {
                    z10 = true;
                } else {
                    if (iD == 1) {
                        return k.b("External condition failed");
                    }
                    if (iD == 2) {
                        return k.d("External condition");
                    }
                }
            }
        }
        if (!z10) {
            return kVarN;
        }
        for (g gVar2 : list) {
            if (gVar2.b() == 1) {
                int iD2 = n.f.d(gVar2.a(bVar, bVar2, eVar));
                if (iD2 == 0) {
                    throw new IllegalStateException("Contract violation in " + gVar2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (iD2 == 1) {
                    return k.b("External condition failed");
                }
                if (iD2 == 2) {
                    return k.d("External condition");
                }
            }
        }
        k kVar = k.f4240b;
        if (kVar != null) {
            return kVar;
        }
        k.a(0);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        r10.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h9.k n(f8.b r13, f8.b r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.l.n(f8.b, f8.b, boolean):h9.k");
    }
}
