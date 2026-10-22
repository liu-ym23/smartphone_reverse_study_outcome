package D7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public abstract class A extends z {
    public static void e0(Iterable elements, Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void f0(Collection collection, i9.i elements) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void g0(Collection collection, Object[] elements) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        collection.addAll(q.L(elements));
    }

    public static final Collection h0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : v.f1(iterable);
    }

    public static final boolean i0(Iterable iterable, S7.k kVar, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (((Boolean) kVar.invoke(it.next())).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static void j0(Iterable iterable, S7.k predicate) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(predicate, "predicate");
        i0(iterable, predicate, true);
    }

    public static void k0(Iterable elements, Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        collection.removeAll(h0(elements));
    }

    public static void l0(Collection collection, i9.i elements) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        List listO0 = kotlin.sequences.a.o0(elements);
        if (listO0.isEmpty()) {
            return;
        }
        collection.removeAll(listO0);
    }

    public static void m0(Collection collection, Object[] elements) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        collection.removeAll(q.L(elements));
    }

    public static boolean n0(S7.k predicate, List list) {
        int i;
        kotlin.jvm.internal.k.f(list, "<this>");
        kotlin.jvm.internal.k.f(predicate, "predicate");
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof T7.a) && !(list instanceof T7.b)) {
                kotlin.jvm.internal.p.j(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            try {
                return i0(list, predicate, true);
            } catch (ClassCastException e) {
                kotlin.jvm.internal.k.k(e, kotlin.jvm.internal.p.class.getName());
                throw e;
            }
        }
        int iH = H4.o.H(list);
        if (iH >= 0) {
            int i6 = 0;
            i = 0;
            while (true) {
                Object obj = list.get(i6);
                if (!((Boolean) predicate.invoke(obj)).booleanValue()) {
                    if (i != i6) {
                        list.set(i, obj);
                    }
                    i++;
                }
                if (i6 == iH) {
                    break;
                }
                i6++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int iH2 = H4.o.H(list);
        if (i <= iH2) {
            while (true) {
                list.remove(iH2);
                if (iH2 == i) {
                    break;
                }
                iH2--;
            }
        }
        return true;
    }

    public static Object o0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(H4.o.H(list));
    }
}
