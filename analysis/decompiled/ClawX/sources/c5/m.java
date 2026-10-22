package c5;

import com.stepos.stepclaw.SecurePrefs;
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
import kotlin.jvm.internal.d0;

/* loaded from: classes.dex */
public abstract class m extends q {
    public static String A0(Iterable iterable, String str, String str2, String str3, p5.l lVar, int i8) {
        if ((i8 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String prefix = (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2;
        String str5 = (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3;
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.p.e(iterable, "<this>");
        kotlin.jvm.internal.p.e(prefix, "prefix");
        StringBuilder sb = new StringBuilder();
        y0(iterable, sb, str4, prefix, str5, "...", lVar);
        return sb.toString();
    }

    public static Object B0(List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(n.j0(list));
    }

    public static Object C0(List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable D0(ArrayList arrayList) {
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

    public static ArrayList E0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.p.e(collection, "<this>");
        kotlin.jvm.internal.p.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            p0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList F0(u5.c cVar, u5.c cVar2) {
        if (cVar instanceof Collection) {
            return E0((Collection) cVar, cVar2);
        }
        ArrayList arrayList = new ArrayList();
        p0(arrayList, cVar);
        p0(arrayList, cVar2);
        return arrayList;
    }

    public static void G0(List list, p5.l lVar) {
        int iJ0;
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof q5.a) && !(list instanceof q5.b)) {
                d0.d(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) lVar.invoke(it.next())).booleanValue()) {
                    it.remove();
                }
            }
            return;
        }
        int iJ02 = n.j0(list);
        int i8 = 0;
        if (iJ02 >= 0) {
            int i9 = 0;
            while (true) {
                Object obj = list.get(i8);
                if (!((Boolean) lVar.invoke(obj)).booleanValue()) {
                    if (i9 != i8) {
                        list.set(i9, obj);
                    }
                    i9++;
                }
                if (i8 == iJ02) {
                    break;
                } else {
                    i8++;
                }
            }
            i8 = i9;
        }
        if (i8 >= list.size() || i8 > (iJ0 = n.j0(list))) {
            return;
        }
        while (true) {
            list.remove(iJ0);
            if (iJ0 == i8) {
                return;
            } else {
                iJ0--;
            }
        }
    }

    public static List H0(ArrayList arrayList) {
        kotlin.jvm.internal.p.e(arrayList, "<this>");
        if (arrayList.size() <= 1) {
            return N0(arrayList);
        }
        List listP0 = P0(arrayList);
        Collections.reverse(listP0);
        return listP0;
    }

    public static List I0(List list) {
        if (list.size() <= 1) {
            return N0(list);
        }
        Object[] array = list.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        kotlin.jvm.internal.p.e(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return l.S(array);
    }

    public static List J0(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listP0 = P0(iterable);
            q.o0(listP0, comparator);
            return listP0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return N0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        kotlin.jvm.internal.p.e(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return l.S(array);
    }

    public static List K0(int i8, List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested element count ", " is less than zero.").toString());
        }
        if (i8 == 0) {
            return s.f1092a;
        }
        if (i8 >= list.size()) {
            return N0(list);
        }
        if (i8 == 1) {
            return a.a.S(u0(list));
        }
        ArrayList arrayList = new ArrayList(i8);
        Iterator it = list.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i9++;
            if (i9 == i8) {
                break;
            }
        }
        return n.l0(arrayList);
    }

    public static byte[] L0(ArrayList arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            bArr[i8] = ((Number) obj).byteValue();
            i8++;
        }
        return bArr;
    }

    public static final void M0(Iterable iterable, AbstractCollection abstractCollection) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List N0(Iterable iterable) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n.l0(P0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return s.f1092a;
        }
        if (size != 1) {
            return O0(collection);
        }
        return a.a.S(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList O0(Collection collection) {
        kotlin.jvm.internal.p.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List P0(Iterable iterable) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return O0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        M0(iterable, arrayList);
        return arrayList;
    }

    public static Set Q0(Iterable iterable) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        M0(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set R0(Collection collection) {
        kotlin.jvm.internal.p.e(collection, "<this>");
        int size = collection.size();
        if (size == 0) {
            return u.f1094a;
        }
        if (size == 1) {
            return a.a.a0(collection instanceof List ? ((List) collection).get(0) : collection.iterator().next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(z.T(collection.size()));
        M0(collection, linkedHashSet);
        return linkedHashSet;
    }

    public static void p0(Collection collection, Iterable elements) {
        kotlin.jvm.internal.p.e(collection, "<this>");
        kotlin.jvm.internal.p.e(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static k q0(Iterable iterable) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        return new k(1, iterable);
    }

    public static List r0(Iterable iterable, int i8) {
        ArrayList arrayList;
        Object objB0;
        kotlin.jvm.internal.p.e(iterable, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested element count ", " is less than zero.").toString());
        }
        if (i8 == 0) {
            return N0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i8;
            if (size <= 0) {
                return s.f1092a;
            }
            if (size == 1) {
                if (iterable instanceof List) {
                    objB0 = B0((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    objB0 = next;
                }
                return a.a.S(objB0);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i8 < size2) {
                        arrayList.add(list.get(i8));
                        i8++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i8);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i9 = 0;
        for (Object obj : iterable) {
            if (i9 >= i8) {
                arrayList.add(obj);
            } else {
                i9++;
            }
        }
        return n.l0(arrayList);
    }

    public static List s0(int i8, List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested element count ", " is less than zero.").toString());
        }
        int size = list.size() - i8;
        if (size < 0) {
            size = 0;
        }
        return K0(size, list);
    }

    public static ArrayList t0(Collection collection) {
        kotlin.jvm.internal.p.e(collection, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object u0(List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object v0(List list) {
        kotlin.jvm.internal.p.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object w0(int i8, List list) {
        if (i8 < 0 || i8 >= list.size()) {
            return null;
        }
        return list.get(i8);
    }

    public static LinkedHashSet x0(Set set, Set set2) {
        kotlin.jvm.internal.p.e(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (set2.contains(obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public static final void y0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, p5.l lVar) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        sb.append(charSequence2);
        int i8 = 0;
        for (Object obj : iterable) {
            i8++;
            if (i8 > 1) {
                sb.append(charSequence);
            }
            x.f.o(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static /* synthetic */ void z0(List list, StringBuilder sb, String str, com.stepos.stepclaw.gateway.d dVar, int i8) {
        if ((i8 & 64) != 0) {
            dVar = null;
        }
        y0(list, sb, str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "...", dVar);
    }
}
