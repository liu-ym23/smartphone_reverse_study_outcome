package Ia;

import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a {
    public static final <T> void a(Collection<T> collection, T t10) {
        p.i(collection, "<this>");
        if (t10 != null) {
            collection.add(t10);
        }
    }

    public static final int b(int i10) {
        if (i10 < 3) {
            return 3;
        }
        return i10 + (i10 / 3) + 1;
    }

    public static final <T> List<T> c(ArrayList<T> arrayList) {
        p.i(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return C1173v.m();
        }
        if (size == 1) {
            return C1172u.e(F.q0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final <K> Map<K, Integer> d(Iterable<? extends K> iterable) {
        p.i(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i10));
            i10++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> e(int i10) {
        return new HashMap<>(b(i10));
    }

    public static final <E> HashSet<E> f(int i10) {
        return new HashSet<>(b(i10));
    }

    public static final <E> LinkedHashSet<E> g(int i10) {
        return new LinkedHashSet<>(b(i10));
    }
}
