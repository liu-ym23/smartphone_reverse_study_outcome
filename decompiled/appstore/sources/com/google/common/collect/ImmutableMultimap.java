package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class Builder<K, V> {
        Map<K, Collection<V>> builderMap;

        @MonotonicNonNullDecl
        Comparator<? super K> keyComparator;

        @MonotonicNonNullDecl
        Comparator<? super V> valueComparator;

        public Builder() {
            this.builderMap = Platform.preservesInsertionOrderOnPutsMap();
        }

        public ImmutableMultimap<K, V> build() {
            Collection r10 = this.builderMap.entrySet();
            Comparator<? super K> r11 = this.keyComparator;
            if (r11 == null) goto L6;
            r10 = Ordering.from(r11).onKeys().immutableSortedCopy(r10);
        L6:
            return ImmutableListMultimap.fromMapEntries(r10, this.valueComparator);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> r10) {
            Iterator<Map.Entry<K, Collection<V>>> r11 = r10.builderMap.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<K, Collection<V>> r12 = r11.next();
            putAll(r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }

        public Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> r10) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(r10);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> r10) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(r10);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K r10, V r11) {
            CollectPreconditions.checkEntryNotNull(r10, r11);
            Collection<V> r12 = this.builderMap.get(r10);
            if (r12 != null) goto L5;
            Map<K, Collection<V>> r13 = this.builderMap;
            Collection<V> r14 = newMutableValueCollection();
            r13.put(r10, r14);
            r12 = r14;
        L5:
            r12.add(r11);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            put(r11.next());
            goto L4
        L6:
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K r10, Iterable<? extends V> r11) {
            if (r10 == null) goto L20;
            Collection<V> r12 = this.builderMap.get(r10);
            if (r12 == null) goto L10;
            Iterator<? extends V> r13 = r11.iterator();
        L7:
            if (r13.hasNext() == false) goto L9;
            V r14 = r13.next();
            CollectPreconditions.checkEntryNotNull(r10, r14);
            r12.add(r14);
            goto L7
        L9:
            return this;
        L10:
            Iterator<? extends V> r15 = r11.iterator();
            if (r15.hasNext() == true) goto L13;
            return this;
        L13:
            Collection<V> r16 = newMutableValueCollection();
        L15:
            if (r15.hasNext() == false) goto L17;
            V r17 = r15.next();
            CollectPreconditions.checkEntryNotNull(r10, r17);
            r16.add(r17);
            goto L15
        L17:
            this.builderMap.put(r10, r16);
            return this;
        L20:
            throw new NullPointerException("null key in entry: null=" + Iterables.toString(r11));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r10) {
            return put(r10.getKey(), r10.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K r10, V... r11) {
            return putAll(r10, Arrays.asList(r11));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> r10) {
            Iterator<Map.Entry<? extends K, Collection<? extends V>>> r11 = r10.asMap().entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<? extends K, Collection<? extends V>> r12 = r11.next();
            putAll(r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }
    }

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @Weak
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> r10) {
            this.multimap = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L6;
            Map.Entry r11 = (Map.Entry) r10;
            return this.multimap.containsEntry(r11.getKey(), r11.getValue());
        L6:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @GwtIncompatible
    public static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = null;
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = null;

        static {
            MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
            SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
        }

        public FieldSettersHolder() {
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        final /* synthetic */ ImmutableMultimap this$0;

        public Keys(ImmutableMultimap r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.this$0.containsKey(r10);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object r10) {
            ImmutableCollection<V> r11 = this.this$0.map.get(r10);
            if (r11 != null) goto L6;
            return 0;
        L6:
            return r11.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public /* bridge */ /* synthetic */ Set elementSet() {
            return elementSet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public Multiset.Entry<K> getEntry(int r10) {
            Map.Entry<K, ? extends ImmutableCollection<V>> r11 = this.this$0.map.entrySet().asList().get(r10);
            return Multisets.immutableEntry(r11.getKey(), r11.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public Object writeReplace() {
            return new KeysSerializedForm(this.this$0);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public ImmutableSet<K> elementSet() {
            return this.this$0.keySet();
        }
    }

    @GwtIncompatible
    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> r10) {
            this.multimap = r10;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        @Weak
        private final transient ImmutableMultimap<K, V> multimap;

        public Values(ImmutableMultimap<K, V> r10) {
            this.multimap = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.multimap.containsValue(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public int copyIntoArray(Object[] r10, int r11) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> r12 = this.multimap.map.values().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11 = r12.next().copyIntoArray(r10, r11);
            goto L4
        L6:
            return r11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> r10, int r11) {
        this.map = r10;
        this.size = r11;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r10) {
        if ((r10 instanceof ImmutableMultimap) == false) goto L8;
        ImmutableMultimap<K, V> r11 = (ImmutableMultimap) r10;
        if (r11.isPartialView() == true) goto L8;
        return r11;
    L8:
        return ImmutableListMultimap.copyOf(r10);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.containsEntry(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object r10) {
        return this.map.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r10) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Collection createEntries() {
        return createEntries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Multiset createKeys() {
        return createKeys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Iterator entryIterator() {
        return entryIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @Override // com.google.common.collect.Multimap
    public abstract ImmutableCollection<V> get(K r10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K r10, Iterable<? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object r10, Object r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ Iterator valueIterator() {
        return valueIterator();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r10, V r11) {
        return ImmutableListMultimap.of(r10, r11);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> removeAll(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(K r10, Iterable<? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public UnmodifiableIterator<V> valueIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r10, V r11, K r12, V r13) {
        return ImmutableListMultimap.of(r10, r11, r12, r13);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15) {
        return ImmutableListMultimap.of(r10, r11, r12, r13, r14, r15);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        return ImmutableListMultimap.copyOf(r10);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        return ImmutableListMultimap.of(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19) {
        return ImmutableListMultimap.of(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }
}
