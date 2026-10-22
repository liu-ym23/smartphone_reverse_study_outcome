package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;

    @RetainedWith
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;

    @RetainedWith
    @LazyInit
    private transient ImmutableSet<K> keySet;

    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;

    @RetainedWith
    @LazyInit
    private transient ImmutableCollection<V> values;

    public static class Builder<K, V> {
        Object[] alternatingKeysAndValues;
        boolean entriesUsed;
        int size;

        @MonotonicNonNullDecl
        Comparator<? super V> valueComparator;

        public Builder() {
            this(4);
        }

        private void ensureCapacity(int r10) {
            int r11 = r10 * 2;
            Object[] r12 = this.alternatingKeysAndValues;
            if (r11 <= r12.length) goto L6;
            this.alternatingKeysAndValues = Arrays.copyOf(r12, ImmutableCollection.Builder.expandedCapacity(r12.length, r11));
            this.entriesUsed = false;
            return;
        }

        public ImmutableMap<K, V> build() {
            sortEntries();
            this.entriesUsed = true;
            return RegularImmutableMap.create(this.size, this.alternatingKeysAndValues);
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> r10) {
            if (this.valueComparator != null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11, "valueComparator was already set");
            this.valueComparator = (Comparator) Preconditions.checkNotNull(r10, "valueComparator");
            return this;
        L5:
            r11 = false;
            goto L6
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K r10, V r11) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(r10, r11);
            Object[] r12 = this.alternatingKeysAndValues;
            int r13 = this.size;
            r12[r13 * 2] = r10;
            r12[(r13 * 2) + 1] = r11;
            this.size = r13 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r10) {
            return putAll(r10.entrySet());
        }

        public void sortEntries() {
            if (this.valueComparator != null) goto L5;
            return;
        L5:
            if (this.entriesUsed == false) goto L7;
            this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, this.size * 2);
        L7:
            Map.Entry[] r10 = new Map.Entry[this.size];
            int r11 = 0;
            int r12 = 0;
        L8:
            int r13 = this.size;
            if (r12 >= r13) goto L11;
            Object[] r14 = this.alternatingKeysAndValues;
            int r15 = r12 * 2;
            r10[r12] = new AbstractMap.SimpleImmutableEntry(r14[r15], r14[r15 + 1]);
            r12 = r12 + 1;
            goto L8
        L11:
            Arrays.sort(r10, 0, r13, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
        L13:
            if (r11 >= this.size) goto L18;
            int r16 = r11 * 2;
            this.alternatingKeysAndValues[r16] = r10[r11].getKey();
            this.alternatingKeysAndValues[r16 + 1] = r10[r11].getValue();
            r11 = r11 + 1;
            goto L13
        }

        public Builder(int r10) {
            this.alternatingKeysAndValues = new Object[r10 * 2];
            this.size = 0;
            this.entriesUsed = false;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
            if ((r10 instanceof Collection) == false) goto L5;
            ensureCapacity(this.size + ((Collection) r10).size());
        L5:
            Iterator<? extends Map.Entry<? extends K, ? extends V>> r11 = r10.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            put(r11.next());
            goto L7
        L9:
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r10) {
            return put(r10.getKey(), r10.getValue());
        }
    }

    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        public IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new C1EntrySetImpl(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        public abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        final /* synthetic */ ImmutableMap this$0;

        private MapViewOfValuesAsSingletonSets(ImmutableMap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return this.this$0.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            final UnmodifiableIterator<Map.Entry<K, V>> r10 = this.this$0.entrySet().iterator();
            return new AnonymousClass1(this, r10);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return this.this$0.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return this.this$0.size();
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@NullableDecl Object r10) {
            Object r11 = this.this$0.get(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return ImmutableSet.of(r11);
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> r10) {
            this.keys = new Object[r10.size()];
            this.values = new Object[r10.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> r11 = r10.entrySet().iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<?, ?> r13 = r11.next();
            this.keys[r12] = r13.getKey();
            this.values[r12] = r13.getValue();
            r12 = r12 + 1;
            goto L4
        }

        public Object createMap(Builder<Object, Object> r10) {
            int r11 = 0;
        L3:
            Object[] r12 = this.keys;
            if (r11 >= r12.length) goto L7;
            r10.put(r12[r11], this.values[r11]);
            r11 = r11 + 1;
            goto L3
        L7:
            return r10.build();
        }

        public Object readResolve() {
            return createMap(new Builder(this.keys.length));
        }
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    public ImmutableMap() {
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        return new Builder(r10);
    }

    public static void checkNoConflict(boolean r10, String r11, Map.Entry<?, ?> r12, Map.Entry<?, ?> r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw conflictException(r11, r12, r13);
    }

    public static IllegalArgumentException conflictException(String r10, Object r11, Object r12) {
        return new IllegalArgumentException("Multiple entries with same " + r10 + ": " + r11 + " and " + r12);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> r10) {
        if ((r10 instanceof ImmutableMap) == false) goto L10;
        if ((r10 instanceof SortedMap) == true) goto L10;
        ImmutableMap<K, V> r11 = (ImmutableMap) r10;
        if (r11.isPartialView() == true) goto L10;
        return r11;
    L10:
        return copyOf(r10.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K r10, V r11) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        return new AbstractMap.SimpleImmutableEntry(r10, r11);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty() == true) goto L5;
        ImmutableSetMultimap<K, V> r10 = this.multimapView;
        if (r10 != null) goto L10;
        ImmutableSetMultimap<K, V> r11 = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = r11;
        return r11;
    L10:
        return r10;
    L5:
        return ImmutableSetMultimap.of();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        if (get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object r10) {
        return values().contains(r10);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object r10) {
        return Maps.equalsImpl(this, r10);
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object r10);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object r10, @NullableDecl V r11) {
        V r12 = get(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r12;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public UnmodifiableIterator<K> keyIterator() {
        final UnmodifiableIterator<Map.Entry<K, V>> r10 = entrySet().iterator();
        return new AnonymousClass1(this, r10);
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object r10) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K r10, V r11) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        return RegularImmutableMap.create(1, new Object[]{r10, r11});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> r10 = this.entrySet;
        if (r10 != null) goto L6;
        ImmutableSet<Map.Entry<K, V>> r11 = createEntrySet();
        this.entrySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> r10 = this.keySet;
        if (r10 != null) goto L6;
        ImmutableSet<K> r11 = createKeySet();
        this.keySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> r10 = this.values;
        if (r10 != null) goto L6;
        ImmutableCollection<V> r11 = createValues();
        this.values = r11;
        return r11;
    L6:
        return r10;
    }

    public static <K, V> ImmutableMap<K, V> of(K r10, V r11, K r12, V r13) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        return RegularImmutableMap.create(2, new Object[]{r10, r11, r12, r13});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        int r11 = ((Collection) r10).size();
    L6:
        Builder r12 = new Builder(r11);
        r12.putAll(r10);
        return r12.build();
    L5:
        r11 = 4;
        goto L6
    }

    public static <K, V> ImmutableMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        return RegularImmutableMap.create(3, new Object[]{r10, r11, r12, r13, r14, r15});
    }

    public static <K, V> ImmutableMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        CollectPreconditions.checkEntryNotNull(r16, r17);
        return RegularImmutableMap.create(4, new Object[]{r10, r11, r12, r13, r14, r15, r16, r17});
    }

    public static <K, V> ImmutableMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        CollectPreconditions.checkEntryNotNull(r16, r17);
        CollectPreconditions.checkEntryNotNull(r18, r19);
        return RegularImmutableMap.create(5, new Object[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19});
    }
}
