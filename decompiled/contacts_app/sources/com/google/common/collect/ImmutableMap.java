package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    public static class Builder<K, V> {
        ImmutableMapEntry.TerminalEntry<K, V>[] entries;
        int size;

        public Builder() {
            this(4);
        }

        Builder(int r1) {
            this.entries = new ImmutableMapEntry.TerminalEntry[r1];
            this.size = 0;
        }

        private void ensureCapacity(int r3) {
            ImmutableMapEntry.TerminalEntry<K, V>[] r0 = this.entries;
            if (r3 <= r0.length) goto L6;
            this.entries = (ImmutableMapEntry.TerminalEntry[]) ObjectArrays.arraysCopyOf(r0, ImmutableCollection.Builder.expandedCapacity(r0.length, r3));
            return;
        }

        public Builder<K, V> put(K r3, V r4) {
            ensureCapacity(this.size + 1);
            ImmutableMapEntry.TerminalEntry<K, V> r5 = ImmutableMap.entryOf(r3, r4);
            ImmutableMapEntry.TerminalEntry<K, V>[] r6 = this.entries;
            int r0 = this.size;
            this.size = r0 + 1;
            r6[r0] = r5;
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r2) {
            return put(r2.getKey(), r2.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> r3) {
            ensureCapacity(this.size + r3.size());
            Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            put(r4.next());
            goto L4
        L6:
            return this;
        }

        public ImmutableMap<K, V> build() {
            int r0 = this.size;
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return new RegularImmutableMap(this.size, this.entries);
        L9:
            return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
        L11:
            return ImmutableMap.of();
        }
    }

    private static final class MapViewOfValuesAsSingletonSets<K, V> extends ImmutableMap<K, ImmutableSet<V>> {
        private final ImmutableMap<K, V> delegate;

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        static /* synthetic */ ImmutableMap access$000(MapViewOfValuesAsSingletonSets r0) {
            return r0.delegate;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(@Nullable Object r1) {
            return get(r1);
        }

        MapViewOfValuesAsSingletonSets(ImmutableMap<K, V> r1) {
            this.delegate = (ImmutableMap) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            return this.delegate.containsKey(r1);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@Nullable Object r1) {
            V r0 = this.delegate.get(r1);
            if (r0 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r0);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, ImmutableSet<V>>> createEntrySet() {
            return new AnonymousClass1(this);
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> r5) {
            this.keys = new Object[r5.size()];
            this.values = new Object[r5.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> r6 = r5.entrySet().iterator();
            int r0 = 0;
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<?, ?> r1 = r6.next();
            this.keys[r0] = r1.getKey();
            this.values[r0] = r1.getValue();
            r0 = r0 + 1;
            goto L4
        }

        Object readResolve() {
            return createMap(new Builder());
        }

        Object createMap(Builder<Object, Object> r4) {
            int r0 = 0;
        L3:
            Object[] r1 = this.keys;
            if (r0 >= r1.length) goto L7;
            r4.put(r1[r0], this.values[r0]);
            r0 = r0 + 1;
            goto L3
        L7:
            return r4.build();
        }
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    @Override // java.util.Map
    public abstract V get(@Nullable Object r1);

    abstract boolean isPartialView();

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return ImmutableBiMap.of();
    }

    public static <K, V> ImmutableMap<K, V> of(K r0, V r1) {
        return ImmutableBiMap.of(r0, r1);
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6) {
        return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8) {
        return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10)});
    }

    public static <K, V> ImmutableMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12) {
        return new RegularImmutableMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12)});
    }

    static <K, V> ImmutableMapEntry.TerminalEntry<K, V> entryOf(K r1, V r2) {
        CollectPreconditions.checkEntryNotNull(r1, r2);
        return new ImmutableMapEntry.TerminalEntry(r1, r2);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    static void checkNoConflict(boolean r2, String r3, Map.Entry<?, ?> r4, Map.Entry<?, ?> r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Multiple entries with same " + r3 + ": " + r4 + " and " + r5);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableMap) == false) goto L10;
        if ((r2 instanceof ImmutableSortedMap) == true) goto L10;
        ImmutableMap<K, V> r0 = (ImmutableMap) r2;
        if (r0.isPartialView() == true) goto L13;
        return r0;
    L13:
        Map.Entry[] r3 = (Map.Entry[]) r2.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        int r1 = r3.length;
        if (r1 == 0) goto L22;
        if (r1 != 1) goto L18;
        Map.Entry r4 = r3[0];
        return of(r4.getKey(), r4.getValue());
    L18:
        return new RegularImmutableMap(r3);
    L22:
        return of();
    L10:
        if ((r2 instanceof EnumMap) == false) goto L13;
        return copyOfEnumMapUnsafe(r2);
    }

    private static <K, V> ImmutableMap<K, V> copyOfEnumMapUnsafe(Map<? extends K, ? extends V> r0) {
        return copyOfEnumMap((EnumMap) r0);
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(Map<K, ? extends V> r3) {
        EnumMap r0 = new EnumMap(r3);
        Iterator<Map.Entry<K, V>> r4 = r0.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<K, V> r1 = r4.next();
        CollectPreconditions.checkEntryNotNull(r1.getKey(), r1.getValue());
        goto L4
    L7:
        return ImmutableEnumMap.asImmutable(r0);
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    ImmutableMap() {
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object r1) {
        if (get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object r1) {
        return values().contains(r1);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r0 = this.keySet;
        if (r0 != null) goto L6;
        ImmutableSet<K> r1 = createKeySet();
        this.keySet = r1;
        return r1;
    L6:
        return r0;
    }

    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // java.util.Map, java.util.SortedMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r0 = this.values;
        if (r0 != null) goto L6;
        ImmutableMapValues r1 = new ImmutableMapValues(this);
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        ImmutableSetMultimap<K, V> r0 = this.multimapView;
        if (r0 != null) goto L6;
        ImmutableSetMultimap<K, V> r1 = createMultimapView();
        this.multimapView = r1;
        return r1;
    L6:
        return r0;
    }

    private ImmutableSetMultimap<K, V> createMultimapView() {
        ImmutableMap<K, ImmutableSet<V>> r3 = viewMapValuesAsSingletonSets();
        return new ImmutableSetMultimap(r3, r3.size(), null);
    }

    private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets() {
        return new MapViewOfValuesAsSingletonSets(this);
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object r1) {
        return Maps.equalsImpl(this, r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
