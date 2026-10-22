package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = null;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap build() {
            return build();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object r1, Object r2) {
            return put(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Map.Entry r1) {
            return put(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Map r1) {
            return putAll(r1);
        }

        public Builder(Comparator<? super K> r1) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K r1, V r2) {
            super.put(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r1) {
            super.put(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            return ImmutableSortedMap.fromEntries(this.comparator, false, this.size, this.entries);
        }
    }

    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> r1) {
            super(r1);
            this.comparator = r1.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new Builder(this.comparator));
        }
    }

    abstract ImmutableSortedMap<K, V> createDescendingMap();

    public abstract ImmutableSortedMap<K, V> headMap(K r1, boolean r2);

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public abstract ImmutableSortedSet<K> keySet();

    public abstract ImmutableSortedMap<K, V> tailMap(K r1, boolean r2);

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public abstract ImmutableCollection<V> values();

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet descendingKeySet() {
        return descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        return descendingMap();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
        return headMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object r1) {
        return headMap(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableSet keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableSet navigableKeySet() {
        return navigableKeySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
        return subMap(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap subMap(Object r1, Object r2) {
        return subMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
        return tailMap(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object r1) {
        return tailMap(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    static {
        Ordering r0 = Ordering.natural();
        NATURAL_ORDER = r0;
        NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap(r0);
    }

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> r1) {
        if (Ordering.natural().equals(r1) == false) goto L7;
        return of();
    L7:
        return new EmptyImmutableSortedMap(r1);
    }

    static <K, V> ImmutableSortedMap<K, V> fromSortedEntries(Comparator<? super K> r5, int r6, Map.Entry<K, V>[] r7) {
        if (r6 == 0) goto L4;
        ImmutableList.Builder r0 = ImmutableList.builder();
        ImmutableList.Builder r1 = ImmutableList.builder();
        int r2 = 0;
    L6:
        if (r2 >= r6) goto L9;
        Map.Entry<K, V> r3 = r7[r2];
        r0.add(r3.getKey());
        r1.add(r3.getValue());
        r2 = r2 + 1;
        goto L6
    L9:
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet(r0.build(), r5), r1.build());
    L4:
        return emptyMap(r5);
    }

    static <K, V> ImmutableSortedMap<K, V> from(ImmutableSortedSet<K> r1, ImmutableList<V> r2) {
        if (r1.isEmpty() == false) goto L7;
        return emptyMap(r1.comparator());
    L7:
        return new RegularImmutableSortedMap((RegularImmutableSortedSet) r1, r2);
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r0, Object r1) {
        return from(ImmutableSortedSet.of(r0), ImmutableList.of(r1));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6) {
        return fromEntries(Ordering.natural(), false, 2, new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8) {
        return fromEntries(Ordering.natural(), false, 3, new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8, Comparable r9, Object r10) {
        return fromEntries(Ordering.natural(), false, 4, new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10)});
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable r3, Object r4, Comparable r5, Object r6, Comparable r7, Object r8, Comparable r9, Object r10, Comparable r11, Object r12) {
        return fromEntries(Ordering.natural(), false, 5, new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12)});
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r1) {
        return copyOfInternal(r1, Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> r0, Comparator<? super K> r1) {
        return copyOfInternal(r0, (Comparator) Preconditions.checkNotNull(r1));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> r1) {
        Comparator<? super K> r0 = r1.comparator();
        if (r0 != null) goto L6;
        r0 = NATURAL_ORDER;
    L6:
        return copyOfInternal(r1, r0);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> r4, Comparator<? super K> r5) {
        if ((r4 instanceof SortedMap) == false) goto L10;
        Comparator<? super K> r0 = ((SortedMap) r4).comparator();
        if (r0 == null) goto L7;
        boolean r1 = r5.equals(r0);
    L11:
        if (r1 == true) goto L13;
    L17:
        Map.Entry[] r6 = (Map.Entry[]) r4.entrySet().toArray(new Map.Entry[0]);
        return fromEntries(r5, r1, r6.length, r6);
    L13:
        if ((r4 instanceof ImmutableSortedMap) == false) goto L17;
        ImmutableSortedMap<K, V> r2 = (ImmutableSortedMap) r4;
        if (r2.isPartialView() == true) goto L17;
        return r2;
    L7:
        if (r5 != NATURAL_ORDER) goto L10;
        r1 = true;
    L10:
        r1 = false;
        goto L11
    }

    static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> r3, boolean r4, int r5, Map.Entry<K, V>... r6) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        Map.Entry<K, V> r1 = r6[r0];
        r6[r0] = entryOf(r1.getKey(), r1.getValue());
        r0 = r0 + 1;
        goto L3
    L5:
        if (r4 == true) goto L8;
        sortEntries(r3, r5, r6);
        validateEntries(r5, r6, r3);
    L8:
        return fromSortedEntries(r3, r5, r6);
    }

    private static <K, V> void sortEntries(Comparator<? super K> r1, int r2, Map.Entry<K, V>[] r3) {
        Arrays.sort(r3, 0, r2, Ordering.from(r1).onKeys());
    }

    private static <K, V> void validateEntries(int r6, Map.Entry<K, V>[] r7, Comparator<? super K> r8) {
        int r1 = 1;
    L3:
        if (r1 >= r6) goto L9;
        int r2 = r1 - 1;
        if (r8.compare(r7[r2].getKey(), r7[r1].getKey()) == 0) goto L7;
        boolean r3 = true;
    L8:
        checkNoConflict(r3, "key", r7[r2], r7[r1]);
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = false;
        goto L8
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> r1) {
        return new Builder(r1);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap() {
    }

    ImmutableSortedMap(ImmutableSortedMap<K, V> r1) {
        this.descendingMap = r1;
    }

    @Override // java.util.Map
    public int size() {
        return values().size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object r1) {
        return values().contains(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        if (keySet().isPartialView() == false) goto L5;
    L8:
        return true;
    L5:
        if (values().isPartialView() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K r2) {
        return headMap(r2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K r3, K r4) {
        return subMap(r3, true, r4, false);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K r5, boolean r6, K r7, boolean r8) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r7);
        if (comparator().compare(r5, r7) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "expected fromKey <= toKey but %s > %s", new Object[]{r5, r7});
        return headMap(r7, r8).tailMap(r5, r6);
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K r2) {
        return tailMap(r2, true);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K r2) {
        return headMap(r2, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K r1) {
        return (K) Maps.keyOrNull(lowerEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K r2) {
        return headMap(r2, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K r1) {
        return (K) Maps.keyOrNull(floorEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K r2) {
        return tailMap(r2, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K r1) {
        return (K) Maps.keyOrNull(ceilingEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K r2) {
        return tailMap(r2, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K r1) {
        return (K) Maps.keyOrNull(higherEntry(r1));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(0);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> r0 = this.descendingMap;
        if (r0 != null) goto L6;
        ImmutableSortedMap<K, V> r1 = createDescendingMap();
        this.descendingMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return keySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return keySet().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
