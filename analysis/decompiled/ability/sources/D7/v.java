package D7;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

/* loaded from: classes3.dex */
public abstract class v extends A {
    public static Object A0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object B0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
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

    public static Object C0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object D0(int i, List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static int E0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            if (kotlin.jvm.internal.k.b(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Set F0(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        Set setI1 = i1(iterable);
        setI1.retainAll(A.h0(other));
        return setI1;
    }

    public static final void G0(Iterable iterable, Appendable buffer, CharSequence charSequence, CharSequence prefix, CharSequence postfix, CharSequence charSequence2, S7.k kVar) throws IOException {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(buffer, "buffer");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        buffer.append(prefix);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                buffer.append(charSequence);
            }
            com.stepos.statsrpk.d.h(buffer, obj, kVar);
        }
        buffer.append(postfix);
    }

    public static /* synthetic */ void H0(Iterable iterable, StringBuilder sb, String str, String str2, String str3, S7.k kVar, int i) throws IOException {
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        if ((i & 64) != 0) {
            kVar = null;
        }
        G0(iterable, sb, str, str2, str3, "...", kVar);
    }

    public static String I0(Iterable iterable, String str, String str2, String str3, S7.k kVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String prefix = (i & 2) != 0 ? "" : str2;
        String str5 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            kVar = null;
        }
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        StringBuilder sb = new StringBuilder();
        G0(iterable, sb, str4, prefix, str5, "...", kVar);
        return sb.toString();
    }

    public static Object J0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof List) {
            return K0((List) iterable);
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

    public static Object K0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(H4.o.H(list));
    }

    public static Object L0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable M0(ArrayList arrayList) {
        kotlin.jvm.internal.k.f(arrayList, "<this>");
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList N0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
        boolean z10 = false;
        for (Object obj2 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.k.b(obj2, obj)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static ArrayList O0(Iterable iterable, Iterable elements) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        if (iterable instanceof Collection) {
            return Q0(elements, (Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        A.e0(iterable, arrayList);
        A.e0(elements, arrayList);
        return arrayList;
    }

    public static ArrayList P0(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            return R0((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        A.e0(iterable, arrayList);
        arrayList.add(obj);
        return arrayList;
    }

    public static ArrayList Q0(Iterable elements, Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        kotlin.jvm.internal.k.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            A.e0(elements, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList R0(Collection collection, Object obj) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List S0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if ((list instanceof Collection) && list.size() <= 1) {
            return f1(list);
        }
        List listH1 = h1(list);
        Collections.reverse(listH1);
        return listH1;
    }

    public static Object T0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof List) {
            return U0((List) iterable);
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

    public static Object U0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object V0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
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

    public static Object W0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List X0(Y7.f indices, List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        kotlin.jvm.internal.k.f(indices, "indices");
        return indices.isEmpty() ? EmptyList.f4893a : f1(list.subList(indices.f1569a, indices.b + 1));
    }

    public static List Y0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listH1 = h1(iterable);
            if (((ArrayList) listH1).size() > 1) {
                Collections.sort(listH1);
            }
            return listH1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return f1(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        kotlin.jvm.internal.k.f(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return q.L(array);
    }

    public static List Z0(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listH1 = h1(iterable);
            z.d0(comparator, listH1);
            return listH1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return f1(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        q.C0(array, comparator);
        return q.L(array);
    }

    public static List a1(Iterable iterable, int i) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return EmptyList.f4893a;
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return f1(iterable);
            }
            if (i == 1) {
                return H4.o.M(z0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i) {
                break;
            }
        }
        return H4.o.R(arrayList);
    }

    public static List b1(int i, List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return EmptyList.f4893a;
        }
        int size = list.size();
        if (i >= size) {
            return f1(list);
        }
        if (i == 1) {
            return H4.o.M(K0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i6 = size - i; i6 < size; i6++) {
                arrayList.add(list.get(i6));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final void c1(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static float[] d1(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        float[] fArr = new float[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = ((Number) it.next()).floatValue();
            i++;
        }
        return fArr;
    }

    public static int[] e1(Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List f1(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return H4.o.R(h1(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.f4893a;
        }
        if (size != 1) {
            return g1(collection);
        }
        return H4.o.M(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList g1(Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List h1(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return g1((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        c1(iterable, arrayList);
        return arrayList;
    }

    public static Set i1(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c1(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set j1(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            c1(iterable, linkedHashSet);
            int size = linkedHashSet.size();
            return size != 0 ? size != 1 ? linkedHashSet : N.Q(linkedHashSet.iterator().next()) : EmptySet.f4895a;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return EmptySet.f4895a;
        }
        if (size2 == 1) {
            return N.Q(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(kotlin.collections.a.P(collection.size()));
        c1(iterable, linkedHashSet2);
        return linkedHashSet2;
    }

    public static Set k1(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        Set setI1 = i1(iterable);
        A.e0(other, setI1);
        return setI1;
    }

    public static s l1(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return new s(new D6.i(iterable, 2), 5);
    }

    public static ArrayList m1(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(w.c0(iterable, 10), w.c0(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new Pair(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final int p0(int i, List list) {
        if (i >= 0 && i <= H4.o.H(list)) {
            return H4.o.H(list) - i;
        }
        StringBuilder sbU = B7.a.u(i, "Element index ", " must be in range [");
        sbU.append(new Y7.f(0, H4.o.H(list), 1));
        sbU.append("].");
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public static final int q0(int i, List list) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        StringBuilder sbU = B7.a.u(i, "Position index ", " must be in range [");
        sbU.append(new Y7.f(0, list.size(), 1));
        sbU.append("].");
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public static K r0(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        return new K(list);
    }

    public static t s0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return new t(iterable, 1);
    }

    public static ArrayList t0(Iterable iterable, int i) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        kotlin.collections.b.a(i, i);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = kotlin.collections.b.b(iterable.iterator(), i, i, true, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i) + (size % i == 0 ? 0 : 1));
        int i6 = 0;
        while (i6 >= 0 && i6 < size) {
            int i10 = size - i6;
            if (i <= i10) {
                i10 = i;
            }
            ArrayList arrayList3 = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList3.add(list.get(i11 + i6));
            }
            arrayList2.add(arrayList3);
            i6 += i;
        }
        return arrayList2;
    }

    public static boolean u0(Iterable iterable, Object obj) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : E0(iterable, obj) >= 0;
    }

    public static List v0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        return f1(i1(iterable));
    }

    public static List w0(Iterable iterable, int i) {
        ArrayList arrayList;
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return f1(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i;
            if (size <= 0) {
                return EmptyList.f4893a;
            }
            if (size == 1) {
                return H4.o.M(J0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i < size2) {
                        arrayList.add(list.get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i6 = 0;
        for (Object obj : iterable) {
            if (i6 >= i) {
                arrayList.add(obj);
            } else {
                i6++;
            }
        }
        return H4.o.R(arrayList);
    }

    public static List x0(int i, List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
        }
        List list2 = list;
        int size = list.size() - i;
        if (size < 0) {
            size = 0;
        }
        return a1(list2, size);
    }

    public static Object y0(int i, Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        boolean z10 = collection instanceof List;
        if (z10) {
            return ((List) collection).get(i);
        }
        D6.d dVar = new D6.d(i, 1);
        if (z10) {
            List list = (List) collection;
            if (i >= 0 && i < list.size()) {
                return list.get(i);
            }
            dVar.invoke(Integer.valueOf(i));
            throw null;
        }
        if (i < 0) {
            dVar.invoke(Integer.valueOf(i));
            throw null;
        }
        int i6 = 0;
        for (Object obj : collection) {
            int i10 = i6 + 1;
            if (i == i6) {
                return obj;
            }
            i6 = i10;
        }
        dVar.invoke(Integer.valueOf(i));
        throw null;
    }

    public static Object z0(Iterable iterable) {
        kotlin.jvm.internal.k.f(iterable, "<this>");
        if (iterable instanceof List) {
            return A0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }
}
