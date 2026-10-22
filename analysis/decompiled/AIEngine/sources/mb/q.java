package mb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class q extends p {
    public static void g0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.g.f(collection, "<this>");
        kotlin.jvm.internal.g.f(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static final boolean h0(Iterable iterable, zb.l lVar) {
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue()) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean i0(List list, zb.l lVar) {
        int i10;
        kotlin.jvm.internal.g.f(list, "<this>");
        if (!(list instanceof RandomAccess)) {
            if (!(list instanceof ac.a) || (list instanceof ac.b)) {
                return h0(list, lVar);
            }
            kotlin.jvm.internal.k.e(list, "kotlin.collections.MutableIterable");
            throw null;
        }
        int iA0 = m.a0(list);
        if (iA0 >= 0) {
            int i11 = 0;
            i10 = 0;
            while (true) {
                Object obj = list.get(i11);
                if (!((Boolean) lVar.invoke(obj)).booleanValue()) {
                    if (i10 != i11) {
                        list.set(i10, obj);
                    }
                    i10++;
                }
                if (i11 == iA0) {
                    break;
                }
                i11++;
            }
        } else {
            i10 = 0;
        }
        if (i10 >= list.size()) {
            return false;
        }
        int iA02 = m.a0(list);
        if (i10 <= iA02) {
            while (true) {
                list.remove(iA02);
                if (iA02 == i10) {
                    break;
                }
                iA02--;
            }
        }
        return true;
    }

    public static Object j0(ArrayList arrayList) {
        kotlin.jvm.internal.g.f(arrayList, "<this>");
        if (arrayList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return arrayList.remove(m.a0(arrayList));
    }

    public static void k0(List list, Comparator comparator) {
        kotlin.jvm.internal.g.f(list, "<this>");
        kotlin.jvm.internal.g.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
