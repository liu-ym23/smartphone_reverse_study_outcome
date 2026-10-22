package kotlin.collections;

import androidx.datastore.preferences.protobuf.b1;
import fc.l;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.jvm.internal.g;
import mb.m;
import mb.q;
import mb.r;
import mb.v;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a extends q {
    public static <T> T A0(List<? extends T> list) {
        g.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(m.a0(list));
    }

    public static <T> T B0(List<? extends T> list) {
        g.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable C0(ArrayList arrayList) {
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

    public static ArrayList D0(Collection collection, Iterable elements) {
        g.f(collection, "<this>");
        g.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            q.g0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static ArrayList E0(Collection collection, Object obj) {
        g.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List F0(List list) {
        g.f(list, "<this>");
        if (list.size() <= 1) {
            return O0(list);
        }
        List listQ0 = Q0(list);
        Collections.reverse(listQ0);
        return listQ0;
    }

    public static <T> T G0(List<? extends T> list) {
        g.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T extends Comparable<? super T>> List<T> H0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listQ0 = Q0(iterable);
            if (((ArrayList) listQ0).size() > 1) {
                Collections.sort(listQ0);
            }
            return listQ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return O0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        g.f(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return b1.g(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> I0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        g.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listQ0 = Q0(iterable);
            q.k0(listQ0, comparator);
            return listQ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return O0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        b1.V(array, comparator);
        return b1.g(array);
    }

    public static List J0(int i10, List list) {
        g.f(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 == 0) {
            return EmptyList.f10001a;
        }
        if (i10 >= list.size()) {
            return O0(list);
        }
        if (i10 == 1) {
            return b1.P(s0(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return m.d0(arrayList);
    }

    public static List K0(int i10, List list) {
        g.f(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 == 0) {
            return EmptyList.f10001a;
        }
        int size = list.size();
        if (i10 >= size) {
            return O0(list);
        }
        if (i10 == 1) {
            return b1.P(A0(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final void L0(Iterable iterable, AbstractCollection abstractCollection) {
        g.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static HashSet M0(List list) {
        g.f(list, "<this>");
        HashSet hashSet = new HashSet(v.a0(m.Z(list, 12)));
        L0(list, hashSet);
        return hashSet;
    }

    public static int[] N0(Collection<Integer> collection) {
        g.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    public static <T> List<T> O0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m.d0(Q0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.f10001a;
        }
        if (size != 1) {
            return P0(collection);
        }
        return b1.P(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList P0(Collection collection) {
        g.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> List<T> Q0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return P0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        L0(iterable, arrayList);
        return arrayList;
    }

    public static <T> Set<T> R0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            L0(iterable, linkedHashSet);
            int size = linkedHashSet.size();
            return size != 0 ? size != 1 ? linkedHashSet : y.M(linkedHashSet.iterator().next()) : EmptySet.f10003a;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return EmptySet.f10003a;
        }
        if (size2 == 1) {
            return y.M(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(v.a0(collection.size()));
        L0(iterable, linkedHashSet2);
        return linkedHashSet2;
    }

    public static l l0(Iterable iterable) {
        g.f(iterable, "<this>");
        return new l(iterable, 2);
    }

    public static ArrayList m0(List list) {
        g.f(list, "<this>");
        if (!(list instanceof RandomAccess)) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            g.f(iterator, "iterator");
            Iterator itO = !iterator.hasNext() ? r.f10561a : a4.a.o(new SlidingWindowKt$windowedIterator$1(iterator, null));
            while (itO.hasNext()) {
                arrayList.add((List) itO.next());
            }
            return arrayList;
        }
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / 2) + (size % 2 == 0 ? 0 : 1));
        for (int i10 = 0; i10 >= 0 && i10 < size; i10 += 2) {
            int i11 = size - i10;
            if (2 <= i11) {
                i11 = 2;
            }
            ArrayList arrayList3 = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList3.add(list.get(i12 + i10));
            }
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }

    public static <T> boolean n0(Iterable<? extends T> iterable, T t8) {
        int iIndexOf;
        g.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t8);
        }
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                T next = it.next();
                if (i10 < 0) {
                    m.f0();
                    throw null;
                }
                if (g.b(t8, next)) {
                    iIndexOf = i10;
                    break;
                }
                i10++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(t8);
        }
        return iIndexOf >= 0;
    }

    public static List o0(ArrayList arrayList) {
        return O0(new LinkedHashSet(arrayList));
    }

    public static List p0(int i10, List list) {
        g.f(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 == 0) {
            return O0(list);
        }
        int size = list.size() - i10;
        if (size <= 0) {
            return EmptyList.f10001a;
        }
        if (size == 1) {
            return b1.P(A0(list));
        }
        ArrayList arrayList = new ArrayList(size);
        if (list instanceof RandomAccess) {
            int size2 = list.size();
            while (i10 < size2) {
                arrayList.add(list.get(i10));
                i10++;
            }
        } else {
            ListIterator listIterator = list.listIterator(i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static List q0(int i10, List list) {
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        int size = list.size() - i10;
        if (size < 0) {
            size = 0;
        }
        return J0(size, list);
    }

    public static ArrayList r0(List list) {
        g.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T s0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) t0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T t0(List<? extends T> list) {
        g.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T u0(Iterable<? extends T> iterable) {
        g.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T v0(List<? extends T> list) {
        g.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object w0(int i10, List list) {
        g.f(list, "<this>");
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    public static final void x0(Iterable iterable, StringBuilder sb2, CharSequence separator, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, zb.l lVar) {
        g.f(iterable, "<this>");
        g.f(separator, "separator");
        sb2.append(charSequence);
        int i10 = 0;
        for (Object obj : iterable) {
            i10++;
            if (i10 > 1) {
                sb2.append(separator);
            }
            b1.f(sb2, obj, lVar);
        }
        sb2.append(charSequence2);
    }

    public static /* synthetic */ void y0(List list, StringBuilder sb2, String str, zb.l lVar, int i10) {
        if ((i10 & 2) != 0) {
            str = ", ";
        }
        String str2 = str;
        if ((i10 & 64) != 0) {
            lVar = null;
        }
        x0(list, sb2, str2, "", "", "...", lVar);
    }

    public static String z0(Iterable iterable, String str, String str2, String str3, zb.l lVar, int i10) {
        if ((i10 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String prefix = (i10 & 2) != 0 ? "" : str2;
        String str5 = (i10 & 4) != 0 ? "" : str3;
        if ((i10 & 32) != 0) {
            lVar = null;
        }
        g.f(iterable, "<this>");
        g.f(prefix, "prefix");
        StringBuilder sb2 = new StringBuilder();
        x0(iterable, sb2, str4, prefix, str5, "...", lVar);
        return sb2.toString();
    }
}
