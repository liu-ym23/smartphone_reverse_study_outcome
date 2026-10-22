package kotlin.reflect.jvm.internal.impl.types.checker;

import S7.n;
import X8.A;
import X8.AbstractC0272c;
import X8.C0273d;
import X8.C0276g;
import X8.H;
import X8.U;
import X8.v;
import X8.w;
import Y8.h;
import Y8.j;
import g9.l;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f5146a = new b();

    public static ArrayList a(AbstractCollection abstractCollection, n nVar) {
        ArrayList arrayList = new ArrayList(abstractCollection);
        Iterator it = arrayList.iterator();
        k.e(it, "iterator(...)");
        while (it.hasNext()) {
            A a3 = (A) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    A a4 = (A) it2.next();
                    if (a4 != a3) {
                        k.c(a4);
                        k.c(a3);
                        if (((Boolean) nVar.invoke(a4, a3)).booleanValue()) {
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
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [X8.H] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [X8.H, d9.d, java.lang.Object] */
    public final A b(ArrayList arrayList) {
        A aB;
        arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            A a3 = (A) it.next();
            if (a3.Q() instanceof v) {
                Collection collectionE = a3.Q().e();
                k.e(collectionE, "getSupertypes(...)");
                Collection<w> collection = collectionE;
                ArrayList arrayList3 = new ArrayList(D7.w.c0(collection, 10));
                for (w wVar : collection) {
                    k.c(wVar);
                    A aE = AbstractC0272c.E(wVar);
                    if (a3.W()) {
                        aE = aE.f0(true);
                    }
                    arrayList3.add(aE);
                }
                arrayList2.addAll(arrayList3);
            } else {
                arrayList2.add(a3);
            }
        }
        TypeIntersector$ResultNullability typeIntersector$ResultNullabilityA = TypeIntersector$ResultNullability.f5145a;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            typeIntersector$ResultNullabilityA = typeIntersector$ResultNullabilityA.a((U) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            A aF0 = (A) it3.next();
            if (typeIntersector$ResultNullabilityA == TypeIntersector$ResultNullability.d) {
                if (aF0 instanceof h) {
                    h hVar = (h) aF0;
                    k.f(hVar, "<this>");
                    aF0 = new h(hVar.b, hVar.c, hVar.d, hVar.e, hVar.f, true);
                }
                k.f(aF0, "<this>");
                A aO = C0273d.o(aF0, false);
                aF0 = (aO == null && (aO = AbstractC0272c.o(aF0)) == null) ? aF0.f0(false) : aO;
            }
            linkedHashSet.add(aF0);
        }
        ArrayList arrayList4 = new ArrayList(D7.w.c0(arrayList, 10));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((A) it4.next()).M());
        }
        Iterator it5 = arrayList4.iterator();
        if (!it5.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ?? next = it5.next();
        while (it5.hasNext()) {
            H other = (H) it5.next();
            next = (H) next;
            next.getClass();
            O2.a aVar = H.b;
            k.f(other, "other");
            if (!next.isEmpty() || !other.isEmpty()) {
                ArrayList arrayList5 = new ArrayList();
                Collection collectionValues = ((ConcurrentHashMap) aVar.b).values();
                k.e(collectionValues, "<get-values>(...)");
                Iterator it6 = collectionValues.iterator();
                while (it6.hasNext()) {
                    int iIntValue = ((Number) it6.next()).intValue();
                    C0276g c0276g = (C0276g) next.f4305a.get(iIntValue);
                    C0276g c0276g2 = (C0276g) other.f4305a.get(iIntValue);
                    C0276g c0276g3 = null;
                    if (c0276g != null) {
                        if (!k.b(c0276g2, c0276g)) {
                            c0276g = null;
                        }
                        c0276g3 = c0276g;
                    } else if (c0276g2 != null) {
                        if (!k.b(c0276g, c0276g2)) {
                            c0276g2 = null;
                        }
                        c0276g3 = c0276g2;
                    }
                    l.b(arrayList5, c0276g3);
                }
                next = O2.a.l(arrayList5);
            }
        }
        H h = (H) next;
        if (linkedHashSet.size() == 1) {
            aB = (A) D7.v.T0(linkedHashSet);
        } else {
            ArrayList arrayListA = a(linkedHashSet, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(2, this));
            arrayListA.isEmpty();
            A a4 = kotlin.reflect.jvm.internal.impl.resolve.constants.a.a(arrayListA);
            if (a4 != null) {
                aB = a4;
            } else {
                Y8.k.b.getClass();
                ArrayList arrayListA2 = a(arrayListA, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(2, j.b));
                arrayListA2.isEmpty();
                aB = arrayListA2.size() < 2 ? (A) D7.v.T0(arrayListA2) : new v(linkedHashSet).b();
            }
        }
        return aB.m0(h);
    }
}
