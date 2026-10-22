package d7;

import b0.a2;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class r extends x {
    public static final int F0(int i2, List list) {
        if (i2 >= 0 && i2 <= s.t0(list)) {
            return s.t0(list) - i2;
        }
        StringBuilder sbN = a1.a.n(i2, "Element index ", " must be in range [");
        sbN.append(new v7.d(0, s.t0(list), 1));
        sbN.append("].");
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    public static final int G0(int i2, List list) {
        if (i2 >= 0 && i2 <= list.size()) {
            return list.size() - i2;
        }
        StringBuilder sbN = a1.a.n(i2, "Position index ", " must be in range [");
        sbN.append(new v7.d(0, list.size(), 1));
        sbN.append("].");
        throw new IndexOutOfBoundsException(sbN.toString());
    }

    public static q H0(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        return new q(1, iterable);
    }

    public static boolean I0(Iterable iterable, Object obj) {
        int iIndexOf;
        q7.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    s.z0();
                    throw null;
                }
                if (q7.k.a(obj, next)) {
                    iIndexOf = i2;
                    break;
                }
                i2++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static List J0(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        return m1(p1(iterable));
    }

    public static List K0(Iterable iterable, int i2) {
        ArrayList arrayList;
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 == 0) {
            return m1(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i2;
            if (size <= 0) {
                return z.f2978f;
            }
            if (size == 1) {
                return a.a.S(V0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i2 < size2) {
                        arrayList.add(list.get(i2));
                        i2++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i10 = 0;
        for (Object obj : iterable) {
            if (i10 >= i2) {
                arrayList.add(obj);
            } else {
                i10++;
            }
        }
        return s.y0(arrayList);
    }

    public static List L0(List list) {
        q7.k.e(list, "<this>");
        int size = list.size() - 1;
        if (size < 0) {
            size = 0;
        }
        return k1(list, size);
    }

    public static Object M0(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return N0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object N0(List list) {
        q7.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object O0(Iterable iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object P0(List list) {
        q7.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object Q0(int i2, List list) {
        q7.k.e(list, "<this>");
        if (i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    public static Set R0(Iterable iterable, Iterable iterable2) {
        q7.k.e(iterable, "<this>");
        q7.k.e(iterable2, "other");
        Set setP1 = p1(iterable);
        setP1.retainAll(iterable2 instanceof Collection ? (Collection) iterable2 : m1(iterable2));
        return setP1;
    }

    public static final void S0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, p7.k kVar) throws IOException {
        q7.k.e(iterable, "<this>");
        q7.k.e(appendable, "buffer");
        q7.k.e(charSequence2, "prefix");
        q7.k.e(charSequence3, "postfix");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            ib.k.f(appendable, obj, kVar);
        }
        appendable.append(charSequence3);
    }

    public static /* synthetic */ void T0(Iterable iterable, StringBuilder sb2, String str, String str2, String str3, p7.k kVar, int i2) throws IOException {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        if ((i2 & 64) != 0) {
            kVar = null;
        }
        S0(iterable, sb2, str, str2, str3, "...", kVar);
    }

    public static String U0(Iterable iterable, String str, String str2, String str3, p7.k kVar, int i2) throws IOException {
        if ((i2 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i2 & 2) != 0 ? "" : str2;
        String str6 = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            kVar = null;
        }
        q7.k.e(iterable, "<this>");
        q7.k.e(str5, "prefix");
        StringBuilder sb2 = new StringBuilder();
        S0(iterable, sb2, str4, str5, str6, "...", kVar);
        return sb2.toString();
    }

    public static Object V0(Iterable iterable) {
        if (iterable instanceof List) {
            return W0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object W0(List list) {
        q7.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(s.t0(list));
    }

    public static Object X0(List list) {
        q7.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable Y0(Iterable iterable) {
        Iterator it = iterable.iterator();
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

    public static ArrayList Z0(Iterable iterable, Object obj) {
        q7.k.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList(t.A0(iterable, 10));
        boolean z4 = false;
        for (Object obj2 : iterable) {
            boolean z10 = true;
            if (!z4 && q7.k.a(obj2, obj)) {
                z4 = true;
                z10 = false;
            }
            if (z10) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static ArrayList a1(Iterable iterable, Iterable iterable2) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return c1((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        x.D0(arrayList, iterable);
        x.D0(arrayList, iterable2);
        return arrayList;
    }

    public static ArrayList b1(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            return d1((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        x.D0(arrayList, iterable);
        arrayList.add(obj);
        return arrayList;
    }

    public static ArrayList c1(Collection collection, Iterable iterable) {
        q7.k.e(collection, "<this>");
        q7.k.e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            x.D0(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList d1(Collection collection, Object obj) {
        q7.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object e1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return f1((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static Object f1(List list) {
        q7.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object g1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static Object h1(List list) {
        q7.k.e(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List i1(List list) {
        q7.k.e(list, "<this>");
        if (list.size() <= 1) {
            return m1(list);
        }
        Object[] array = list.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        q7.k.e(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return n.S(array);
    }

    public static List j1(Iterable iterable, Comparator comparator) {
        q7.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listO1 = o1(iterable);
            w.C0(listO1, comparator);
            return listO1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return m1(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        n.s0(array, comparator);
        return n.S(array);
    }

    public static List k1(Iterable iterable, int i2) {
        q7.k.e(iterable, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 == 0) {
            return z.f2978f;
        }
        if (iterable instanceof Collection) {
            if (i2 >= ((Collection) iterable).size()) {
                return m1(iterable);
            }
            if (i2 == 1) {
                return a.a.S(M0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i10++;
            if (i10 == i2) {
                break;
            }
        }
        return s.y0(arrayList);
    }

    public static final void l1(Iterable iterable, AbstractCollection abstractCollection) {
        q7.k.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List m1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return s.y0(o1(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z.f2978f;
        }
        if (size != 1) {
            return n1(collection);
        }
        return a.a.S(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList n1(Collection collection) {
        q7.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List o1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return n1((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        l1(iterable, arrayList);
        return arrayList;
    }

    public static Set p1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        l1(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set q1(Iterable iterable) {
        q7.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size == 1) {
                    return ib.k.S(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(collection.size()));
                l1(iterable, linkedHashSet);
                return linkedHashSet;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            l1(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                return size2 != 1 ? linkedHashSet2 : ib.k.S(linkedHashSet2.iterator().next());
            }
        }
        return b0.f2947f;
    }

    public static p r1(List list) {
        q7.k.e(list, "<this>");
        return new p(1, new a2(4, list));
    }

    public static ArrayList s1(List list, List list2) {
        q7.k.e(list, "<this>");
        q7.k.e(list2, "other");
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t.A0(list, 10), t.A0(list2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new c7.j(it.next(), it2.next()));
        }
        return arrayList;
    }
}
