package w9;

import d7.x;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import v9.i0;
import v9.m0;
import v9.v;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f10959a = new u();

    public static ArrayList a(AbstractCollection abstractCollection, p7.n nVar) {
        ArrayList arrayList = new ArrayList(abstractCollection);
        Iterator it = arrayList.iterator();
        q7.k.d(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    z zVar2 = (z) it2.next();
                    if (zVar2 != zVar) {
                        q7.k.d(zVar2, "lower");
                        q7.k.d(zVar, "upper");
                        if (((Boolean) nVar.invoke(zVar2, zVar)).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [v9.i0] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [ba.d, java.lang.Object, v9.i0] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v19, types: [v9.z] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, v9.v, v9.z] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final z b(ArrayList arrayList) {
        z zVar;
        z zVarE;
        arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            z zVar2 = (z) it.next();
            if (zVar2.E0() instanceof v9.u) {
                Collection collectionD = zVar2.E0().d();
                q7.k.d(collectionD, "type.constructor.supertypes");
                Collection<v> collection = collectionD;
                ArrayList arrayList3 = new ArrayList(d7.t.A0(collection, 10));
                for (v vVar : collection) {
                    q7.k.d(vVar, "it");
                    z zVarX = v9.c.x(vVar);
                    if (zVar2.F0()) {
                        zVarX = zVarX.I0(true);
                    }
                    arrayList3.add(zVarX);
                }
                arrayList2.addAll(arrayList3);
            } else {
                arrayList2.add(zVar2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        s sVarA = s.f10953f;
        while (it2.hasNext()) {
            sVarA = sVarA.a((z0) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            z zVarI0 = (z) it3.next();
            if (sVarA == s.f10956i) {
                if (zVarI0 instanceof i) {
                    i iVar = (i) zVarI0;
                    zVarI0 = new i(iVar.f10935g, iVar.f10936h, iVar.f10937i, iVar.f10938j, iVar.f10939k, true);
                }
                q7.k.e(zVarI0, "<this>");
                z zVarP = v9.d.p(zVarI0, false);
                zVarI0 = (zVarP == null && (zVarP = v9.c.m(zVarI0)) == null) ? zVarI0.I0(false) : zVarP;
            }
            linkedHashSet.add(zVarI0);
        }
        ArrayList arrayList4 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((z) it4.next()).D0());
        }
        Iterator it5 = arrayList4.iterator();
        if (!it5.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ?? next = it5.next();
        while (true) {
            zVar = null;
            if (!it5.hasNext()) {
                break;
            }
            i0 i0Var = (i0) it5.next();
            next = (i0) next;
            next.getClass();
            nb.f fVar = i0.f10557g;
            q7.k.e(i0Var, "other");
            if (!next.isEmpty() || !i0Var.isEmpty()) {
                ArrayList arrayList5 = new ArrayList();
                Collection collectionValues = ((ConcurrentHashMap) fVar.f6947g).values();
                q7.k.d(collectionValues, "idPerType.values");
                Iterator it6 = collectionValues.iterator();
                while (it6.hasNext()) {
                    int iIntValue = ((Number) it6.next()).intValue();
                    v9.g gVar = (v9.g) next.f1594f.get(iIntValue);
                    v9.g gVar2 = (v9.g) i0Var.f1594f.get(iIntValue);
                    if (gVar != null) {
                        if (!q7.k.a(gVar2, gVar)) {
                            gVar = null;
                        }
                        gVar2 = gVar;
                    } else if (gVar2 == null || !q7.k.a(gVar, gVar2)) {
                        gVar2 = null;
                    }
                    ea.k.a(arrayList5, gVar2);
                }
                next = nb.f.q(arrayList5);
            }
        }
        i0 i0Var2 = (i0) next;
        if (linkedHashSet.size() == 1) {
            zVarE = (z) d7.r.e1(linkedHashSet);
        } else {
            ArrayList arrayListA = a(linkedHashSet, new t(2, 0, this));
            arrayListA.isEmpty();
            if (!arrayListA.isEmpty()) {
                Iterator it7 = arrayListA.iterator();
                if (!it7.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                z next2 = it7.next();
                while (it7.hasNext()) {
                    z zVar3 = (z) it7.next();
                    next2 = next2;
                    if (next2 != 0 && zVar3 != null) {
                        m0 m0VarE0 = next2.E0();
                        m0 m0VarE02 = zVar3.E0();
                        boolean z4 = m0VarE0 instanceof j9.n;
                        if (z4 && (m0VarE02 instanceof j9.n)) {
                            Set set = ((j9.n) m0VarE0).f5413a;
                            Set set2 = ((j9.n) m0VarE02).f5413a;
                            q7.k.e(set, "<this>");
                            q7.k.e(set2, "other");
                            Set setP1 = d7.r.p1(set);
                            x.D0(setP1, set2);
                            j9.n nVar = new j9.n(setP1);
                            i0.f10557g.getClass();
                            i0 i0Var3 = i0.f10558h;
                            q7.k.e(i0Var3, "attributes");
                            next2 = v9.d.s(d7.z.f2978f, x9.i.a(2, true, "unknown integer literal type"), i0Var3, nVar, false);
                        } else if (z4) {
                            if (((j9.n) m0VarE0).f5413a.contains(zVar3)) {
                                next2 = zVar3;
                            }
                        } else if (!(m0VarE02 instanceof j9.n) || !((j9.n) m0VarE02).f5413a.contains(next2)) {
                        }
                    }
                    next2 = 0;
                }
                zVar = next2;
            }
            if (zVar != null) {
                zVarE = zVar;
            } else {
                l.f10948b.getClass();
                ArrayList arrayListA2 = a(arrayListA, new t(2, 1, k.f10947b));
                arrayListA2.isEmpty();
                zVarE = arrayListA2.size() < 2 ? (z) d7.r.e1(arrayListA2) : new v9.u(linkedHashSet).e();
            }
        }
        return zVarE.K0(i0Var2);
    }
}
