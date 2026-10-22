package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: collections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CollectionsKt {
    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<? extends K> r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        int r2 = r1 + 1;
        LinkedHashMap r4 = r0;
        r4.put(r6.next(), Integer.valueOf(r1));
        r1 = r2;
        goto L4
    L7:
        return r0;
    }

    public static final <T> void addIfNotNull(Collection<T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == null) goto L6;
        r1.add(r2);
        return;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int r1) {
        return new HashMap(capacity(r1));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int r1) {
        return new HashSet(capacity(r1));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r1) {
        return new LinkedHashSet(capacity(r1));
    }

    private static final int capacity(int r1) {
        if (r1 >= 3) goto L6;
        return 3;
    L6:
        return (r1 + (r1 / 3)) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        r2.trimToSize();
        return r2;
    L11:
        return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first(r2));
    L9:
        return kotlin.collections.CollectionsKt.emptyList();
    }
}
