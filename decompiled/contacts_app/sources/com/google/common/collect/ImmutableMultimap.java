package com.google.common.collect;

import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class Builder<K, V> {
        Multimap<K, V> builderMultimap;
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;

        public Builder() {
            this.builderMultimap = new BuilderMultimap();
        }

        public Builder<K, V> put(K r2, V r3) {
            CollectPreconditions.checkEntryNotNull(r2, r3);
            this.builderMultimap.put(r2, r3);
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r2) {
            return put(r2.getKey(), r2.getValue());
        }

        public Builder<K, V> putAll(K r3, Iterable<? extends V> r4) {
            if (r3 == null) goto L9;
            Collection<V> r0 = this.builderMultimap.get(r3);
            Iterator<? extends V> r5 = r4.iterator();
        L5:
            if (r5.hasNext() == false) goto L7;
            V r1 = r5.next();
            CollectPreconditions.checkEntryNotNull(r3, r1);
            r0.add(r1);
            goto L5
        L7:
            return this;
        L9:
            throw new NullPointerException("null key in entry: null=" + Iterables.toString(r4));
        }

        public Builder<K, V> putAll(K r1, V... r2) {
            return putAll(r1, Arrays.asList(r2));
        }

        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> r3) {
            Iterator<Map.Entry<? extends K, Collection<? extends V>>> r4 = r3.asMap().entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            Map.Entry<? extends K, Collection<? extends V>> r0 = r4.next();
            putAll(r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        public Builder<K, V> orderKeysBy(Comparator<? super K> r1) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder<K, V> orderValuesBy(Comparator<? super V> r1) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImmutableMultimap<K, V> build() {
            if (this.valueComparator == null) goto L9;
            Iterator<Collection<V>> r0 = this.builderMultimap.asMap().values().iterator();
        L6:
            if (r0.hasNext() == false) goto L9;
            Collections.sort((List) r0.next(), this.valueComparator);
        L9:
            if (this.keyComparator == null) goto L16;
            BuilderMultimap r1 = new BuilderMultimap();
            ArrayList r2 = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
            Collections.sort(r2, Ordering.from(this.keyComparator).onKeys());
            Iterator r3 = r2.iterator();
        L12:
            if (r3.hasNext() == false) goto L14;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1.putAll(r4.getKey(), (Iterable) r4.getValue());
            goto L12
        L14:
            this.builderMultimap = r1;
        L16:
            return ImmutableMultimap.copyOf(this.builderMultimap);
        }
    }

    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> createCollection() {
            return Lists.newArrayList();
        }
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        EntryCollection(ImmutableMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return this.multimap.containsEntry(r3.getKey(), r3.getValue());
        L6:
            return false;
        }
    }

    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = null;
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = null;
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = null;

        FieldSettersHolder() {
        }

        static {
            MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
            SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, PerfConsts.PERF_DISK_FILE_SIZE);
            EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
        }
    }

    private abstract class Itr<T> extends UnmodifiableIterator<T> {
        K key;
        final Iterator<Map.Entry<K, Collection<V>>> mapIterator;
        final /* synthetic */ ImmutableMultimap this$0;
        Iterator<V> valueIterator;

        abstract T output(K r1, V r2);

        private Itr(ImmutableMultimap r1) {
            this.this$0 = r1;
            this.mapIterator = r1.asMap().entrySet().iterator();
            this.key = null;
            this.valueIterator = Iterators.emptyIterator();
        }

        /* synthetic */ Itr(ImmutableMultimap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mapIterator.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.valueIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.valueIterator.hasNext() == true) goto L6;
            Map.Entry<K, Collection<V>> r0 = this.mapIterator.next();
            this.key = r0.getKey();
            this.valueIterator = r0.getValue().iterator();
        L6:
            return output(this.key, this.valueIterator.next());
        }
    }

    class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        Keys(ImmutableMultimap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@Nullable Object r1) {
            ImmutableCollection<V> r0 = this.this$0.map.get(r1);
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // com.google.common.collect.Multiset
        public Set<K> elementSet() {
            return this.this$0.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        Multiset.Entry<K> getEntry(int r1) {
            Map.Entry<K, ? extends ImmutableCollection<V>> r0 = this.this$0.map.entrySet().asList().get(r1);
            return Multisets.immutableEntry(r0.getKey(), r0.getValue().size());
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        Values(ImmutableMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r1) {
            return this.multimap.containsValue(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] r2, int r3) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> r1 = this.multimap.map.values().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r3 = r1.next().copyIntoArray(r2, r3);
            goto L4
        L6:
            return r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public abstract ImmutableCollection<V> get(K r1);

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@Nullable Object r1, @Nullable Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Multiset createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return keys();
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap
    /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1) {
        return ImmutableListMultimap.of(r0, r1);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3) {
        return ImmutableListMultimap.of(r0, r1, r2, r3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r0, V r1, K r2, V r3, K r4, V r5, K r6, V r7, K r8, V r9) {
        return ImmutableListMultimap.of(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableMultimap) == false) goto L8;
        ImmutableMultimap<K, V> r0 = (ImmutableMultimap) r2;
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        return ImmutableListMultimap.copyOf(r2);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r1, int r2) {
        this.map = r1;
        this.size = r2;
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public ImmutableCollection<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public ImmutableCollection<V> replaceValues(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public boolean put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public boolean putAll(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@Nullable Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractMultimap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    UnmodifiableIterator<V> valueIterator() {
        return new AnonymousClass2(this);
    }
}
