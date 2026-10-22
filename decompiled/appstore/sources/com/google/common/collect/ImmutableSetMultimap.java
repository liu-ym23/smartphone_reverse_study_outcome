package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;

    @MonotonicNonNullDecl
    private transient ImmutableSet<Map.Entry<K, V>> entries;

    @RetainedWith
    @LazyInit
    @MonotonicNonNullDecl
    private transient ImmutableSetMultimap<V, K> inverse;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Collection<V> newMutableValueCollection() {
            return Platform.preservesInsertionOrderOnAddsSet();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderKeysBy(Comparator r10) {
            return orderKeysBy(r10);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderValuesBy(Comparator r10) {
            return orderValuesBy(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Object r10, Object r11) {
            return put(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Multimap r10) {
            return putAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            Collection r10 = this.builderMap.entrySet();
            Comparator<? super K> r11 = this.keyComparator;
            if (r11 == null) goto L6;
            r10 = Ordering.from(r11).onKeys().immutableSortedCopy(r10);
        L6:
            return ImmutableSetMultimap.fromMapEntries(r10, this.valueComparator);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> r10) {
            super.orderKeysBy(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> r10) {
            super.orderValuesBy(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Map.Entry r10) {
            return put(r10);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        @Beta
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Iterable r10) {
            return putAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K r10, V r11) {
            super.put(r10, r11);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r10, Iterable r11) {
            return putAll(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r10) {
            super.put(r10);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r10, Object[] r11) {
            return putAll(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
            super.putAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K r10, Iterable<? extends V> r11) {
            super.putAll(r10, r11);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K r10, V... r11) {
            return putAll(r10, Arrays.asList(r11));
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
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

    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        @Weak
        private final transient ImmutableSetMultimap<K, V> multimap;

        public EntrySet(ImmutableSetMultimap<K, V> r10) {
            this.multimap = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L6;
            Map.Entry r11 = (Map.Entry) r10;
            return this.multimap.containsEntry(r11.getKey(), r11.getValue());
        L6:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @GwtIncompatible
    public static final class SetFieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = null;

        static {
            EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
        }

        private SetFieldSettersHolder() {
        }
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r10, int r11, @NullableDecl Comparator<? super V> r12) {
        super(r10, r11);
        this.emptySet = emptySet(r12);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r10) {
        return copyOf(r10, null);
    }

    private static <V> ImmutableSet<V> emptySet(@NullableDecl Comparator<? super V> r10) {
        if (r10 != null) goto L5;
        return ImmutableSet.of();
    L5:
        return ImmutableSortedSet.emptySet(r10);
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r10, @NullableDecl Comparator<? super V> r11) {
        if (r10.isEmpty() == true) goto L5;
        ImmutableMap.Builder r12 = new ImmutableMap.Builder(r10.size());
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r13 = r10.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r15 = r13.next();
        K r16 = r15.getKey();
        ImmutableSet r17 = valueSet(r11, r15.getValue());
        if (r17.isEmpty() == true) goto L8;
        r12.put(r16, r17);
        r14 = r14 + r17.size();
        goto L8
    L13:
        return new ImmutableSetMultimap(r12.build(), r14, r11);
    L5:
        return of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        Builder r10 = builder();
        UnmodifiableIterator r11 = entries().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getValue(), r12.getKey());
        goto L4
    L6:
        ImmutableSetMultimap<V, K> r13 = r10.build();
        r13.inverse = this;
        return r13;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream r12) throws IOException, ClassNotFoundException {
        r12.defaultReadObject();
        Comparator r10 = (Comparator) r12.readObject();
        int r11 = r12.readInt();
        if (r11 < 0) goto L25;
        ImmutableMap.Builder r13 = ImmutableMap.builder();
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r14 >= r11) goto L26;
        Object r16 = r12.readObject();
        int r17 = r12.readInt();
        if (r17 <= 0) goto L17;
        ImmutableSet.Builder r18 = valuesBuilder(r10);
        int r19 = 0;
    L9:
        if (r19 >= r17) goto L11;
        r18.add(r12.readObject());
        r19 = r19 + 1;
        goto L9
    L11:
        ImmutableSet r20 = r18.build();
        if (r20.size() != r17) goto L15;
        r13.put(r16, r20);
        r15 = r15 + r17;
        r14 = r14 + 1;
        goto L5
    L15:
        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + r16);
    L17:
        throw new InvalidObjectException("Invalid value count " + r17);
    L26:
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, r13.build());
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, r15);
        SetFieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(r10));
        return;
    L21:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L25:
        throw new InvalidObjectException("Invalid key count " + r11);
    }

    private static <V> ImmutableSet<V> valueSet(@NullableDecl Comparator<? super V> r10, Collection<? extends V> r11) {
        if (r10 != null) goto L5;
        return ImmutableSet.copyOf(r11);
    L5:
        return ImmutableSortedSet.copyOf(r10, r11);
    }

    private static <V> ImmutableSet.Builder<V> valuesBuilder(@NullableDecl Comparator<? super V> r10) {
        if (r10 != null) goto L5;
        return new ImmutableSet.Builder();
    L5:
        return new ImmutableSortedSet.Builder(r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeObject(valueComparator());
        Serialization.writeMultimap(this, r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @NullableDecl
    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> r10 = this.emptySet;
        if ((r10 instanceof ImmutableSortedSet) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) r10).comparator();
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r10, Comparator<? super V> r11) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == false) goto L8;
        if (r11 != null) goto L8;
        return of();
    L8:
        if ((r10 instanceof ImmutableSetMultimap) == false) goto L13;
        ImmutableSetMultimap<K, V> r12 = (ImmutableSetMultimap) r10;
        if (r12.isPartialView() == true) goto L13;
        return r12;
    L13:
        return fromMapEntries(r10.asMap().entrySet(), r11);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r10, V r11) {
        Builder r12 = builder();
        r12.put(r10, r11);
        return r12.build();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r10 = this.inverse;
        if (r10 != null) goto L6;
        ImmutableSetMultimap<V, K> r11 = invert();
        this.inverse = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Set removeAll(Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r10 = this.entries;
        if (r10 != null) goto L6;
        EntrySet r11 = new EntrySet(this);
        this.entries = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<V> get(@NullableDecl K r10) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.map.get(r10), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> removeAll(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K r10, Iterable<? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r10, V r11, K r12, V r13) {
        Builder r14 = builder();
        r14.put(r10, r11);
        r14.put(r12, r13);
        return r14.build();
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        return new Builder().putAll(r10).build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15) {
        Builder r16 = builder();
        r16.put(r10, r11);
        r16.put(r12, r13);
        r16.put(r14, r15);
        return r16.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        Builder r18 = builder();
        r18.put(r10, r11);
        r18.put(r12, r13);
        r18.put(r14, r15);
        r18.put(r16, r17);
        return r18.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19) {
        Builder r20 = builder();
        r20.put(r10, r11);
        r20.put(r12, r13);
        r20.put(r14, r15);
        r20.put(r16, r17);
        r20.put(r18, r19);
        return r20.build();
    }
}
