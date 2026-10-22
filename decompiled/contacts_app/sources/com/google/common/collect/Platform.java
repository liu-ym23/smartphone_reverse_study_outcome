package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class Platform {
    static <T> T[] newArray(T[] r0, int r1) {
        return (T[]) ((Object[]) Array.newInstance(r0.getClass().getComponentType(), r1));
    }

    static <E> Set<E> newSetFromMap(Map<E, Boolean> r0) {
        return Collections.newSetFromMap(r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.collect.MapMaker] */
    static MapMaker tryWeakKeys(MapMaker r0) {
        return r0.weakKeys2();
    }

    static <K, V1, V2> SortedMap<K, V2> mapsTransformEntriesSortedMap(SortedMap<K, V1> r1, Maps.EntryTransformer<? super K, ? super V1, V2> r2) {
        if ((r1 instanceof NavigableMap) == false) goto L6;
        return Maps.transformEntries((NavigableMap) r1, r2);
    L6:
        return Maps.transformEntriesIgnoreNavigable(r1, r2);
    }

    static <K, V> SortedMap<K, V> mapsAsMapSortedSet(SortedSet<K> r1, Function<? super K, V> r2) {
        if ((r1 instanceof NavigableSet) == false) goto L6;
        return Maps.asMap((NavigableSet) r1, r2);
    L6:
        return Maps.asMapSortedIgnoreNavigable(r1, r2);
    }

    static <E> SortedSet<E> setsFilterSortedSet(SortedSet<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof NavigableSet) == false) goto L6;
        return Sets.filter((NavigableSet) r1, r2);
    L6:
        return Sets.filterSortedIgnoreNavigable(r1, r2);
    }

    static <K, V> SortedMap<K, V> mapsFilterSortedMap(SortedMap<K, V> r1, Predicate<? super Map.Entry<K, V>> r2) {
        if ((r1 instanceof NavigableMap) == false) goto L6;
        return Maps.filterEntries((NavigableMap) r1, r2);
    L6:
        return Maps.filterSortedIgnoreNavigable(r1, r2);
    }

    private Platform() {
    }
}
