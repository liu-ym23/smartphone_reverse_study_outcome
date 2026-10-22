package kb;

import java.lang.invoke.VarHandle;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class l extends q {
    public static String B0(Iterable iterable, String str, String str2, String str3, xb.l lVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            lVar = null;
        }
        iterable.getClass();
        StringBuilder sb2 = new StringBuilder();
        z0(iterable, sb2, str4, str5, str6, "...", lVar);
        return sb2.toString();
    }

    public static Object C0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        g5.f.m("List is empty.");
        return null;
    }

    public static Object D0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable E0(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList F0(Collection collection, List list) {
        collection.getClass();
        list.getClass();
        ArrayList arrayList = new ArrayList(list.size() + collection.size());
        arrayList.addAll(collection);
        arrayList.addAll(list);
        return arrayList;
    }

    public static ArrayList G0(List list, Object obj) {
        list.getClass();
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(obj);
        return arrayList;
    }

    public static List H0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listM0 = M0(iterable);
            p.n0(listM0);
            return listM0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return L0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List I0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List listM0 = M0(iterable);
            p.o0(comparator, listM0);
            return listM0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return L0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        listAsList.getClass();
        return listAsList;
    }

    public static List J0(Iterable iterable, int i) {
        iterable.getClass();
        if (i < 0) {
            od.f.c(k0.a.k(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return s.f7404c;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return L0(iterable);
            }
            if (i == 1) {
                return ac.a.E(v0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i) {
                break;
            }
        }
        return ac.a.L(arrayList);
    }

    public static final void K0(Iterable iterable, AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List L0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return ac.a.L(M0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return s.f7404c;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return ac.a.E(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List M0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        K0(iterable, arrayList);
        return arrayList;
    }

    public static Set N0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        K0(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set O0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return h5.t.P(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(x.L(collection.size()));
                K0(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            K0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : h5.t.P(linkedHashSet2.iterator().next());
            }
        }
        return u.f7406c;
    }

    public static ArrayList P0(AbstractList abstractList, List list) {
        abstractList.getClass();
        list.getClass();
        Iterator it = abstractList.iterator();
        Iterator it2 = list.iterator();
        ArrayList arrayList = new ArrayList(Math.min(m.m0(abstractList, 10), m.m0(list, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new jb.g(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static gc.n r0(Iterable iterable) {
        iterable.getClass();
        gc.n nVar = new gc.n(3);
        nVar.f4705b = iterable;
        VarHandle.storeStoreFence();
        return nVar;
    }

    public static boolean s0(Iterable iterable, Object obj) {
        int iIndexOf;
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    ac.a.a0();
                    throw null;
                }
                if (yb.k.a(obj, next)) {
                    iIndexOf = i;
                    break;
                }
                i++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static List t0(List list) {
        list.getClass();
        return L0(N0(list));
    }

    public static List u0(int i, List list) {
        list.getClass();
        if (i < 0) {
            od.f.c(k0.a.k(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return L0(list);
        }
        int size = list.size() - i;
        if (size <= 0) {
            return s.f7404c;
        }
        if (size == 1) {
            return ac.a.E(C0(list));
        }
        ArrayList arrayList = new ArrayList(size);
        if (list instanceof RandomAccess) {
            int size2 = list.size();
            while (i < size2) {
                arrayList.add(list.get(i));
                i++;
            }
        } else {
            ListIterator listIterator = list.listIterator(i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static Object v0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return w0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        g5.f.m("Collection is empty.");
        return null;
    }

    public static Object w0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        g5.f.m("List is empty.");
        return null;
    }

    public static Object x0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object y0(int i, List list) {
        list.getClass();
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final void z0(Iterable iterable, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, xb.l lVar) {
        iterable.getClass();
        sb2.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb2.append(charSequence);
            }
            id.c.e(sb2, obj, lVar);
        }
        sb2.append(charSequence3);
    }
}
