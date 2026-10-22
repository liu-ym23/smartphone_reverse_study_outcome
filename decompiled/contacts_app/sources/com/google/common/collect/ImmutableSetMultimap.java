package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderKeysBy(Comparator r1) {
            return orderKeysBy(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder orderValuesBy(Comparator r1) {
            return orderValuesBy(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Object r1, Object r2) {
            return put(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder put(Map.Entry r1) {
            return put(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Multimap r1) {
            return putAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r1, Iterable r2) {
            return putAll(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap.Builder putAll(Object r1, Object[] r2) {
            return putAll(r1, r2);
        }

        public Builder() {
            this.builderMultimap = new BuilderMultimap();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(K r2, V r3) {
            Multimap<K, V> r0 = this.builderMultimap;
            Object r4 = Preconditions.checkNotNull(r2);
            r0.put((K) r4, (V) Preconditions.checkNotNull(r3));
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r3) {
            Multimap<K, V> r0 = this.builderMultimap;
            Object r1 = Preconditions.checkNotNull(r3.getKey());
            r0.put((K) r1, (V) Preconditions.checkNotNull(r3.getValue()));
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r2, Iterable<? extends V> r3) {
            Collection<V> r4 = this.builderMultimap.get((K) Preconditions.checkNotNull(r2));
            Iterator<? extends V> r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r4.add(Preconditions.checkNotNull(r5.next()));
            goto L4
        L6:
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r1, V... r2) {
            return putAll(r1, Arrays.asList(r2));
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
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

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderKeysBy(Comparator<? super K> r1) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderValuesBy(Comparator<? super V> r1) {
            super.orderValuesBy(r1);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            if (this.keyComparator == null) goto L10;
            BuilderMultimap r0 = new BuilderMultimap();
            ArrayList r1 = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
            Collections.sort(r1, Ordering.from(this.keyComparator).onKeys());
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            Map.Entry r3 = (Map.Entry) r2.next();
            r0.putAll(r3.getKey(), (Iterable) r3.getValue());
            goto L6
        L8:
            this.builderMultimap = r0;
        L10:
            return ImmutableSetMultimap.access$000(this.builderMultimap, this.valueComparator);
        }
    }

    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection<V> createCollection() {
            return Sets.newLinkedHashSet();
        }
    }

    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        EntrySet(ImmutableSetMultimap<K, V> r1) {
            this.multimap = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r2) {
            if ((r2 instanceof Map.Entry) == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2;
            return this.multimap.containsEntry(r3.getKey(), r3.getValue());
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set entries() {
        return entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(@Nullable Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@Nullable Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set get(@Nullable Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    static /* synthetic */ ImmutableSetMultimap access$000(Multimap r0, Comparator r1) {
        return copyOf(r0, r1);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2) {
        Builder r0 = builder();
        r0.put(r1, r2);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        return r0.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        r0.put(r9, r10);
        return r0.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r1) {
        return copyOf(r1, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r5, Comparator<? super V> r6) {
        Preconditions.checkNotNull(r5);
        if (r5.isEmpty() == false) goto L8;
        if (r6 != null) goto L8;
        return of();
    L8:
        if ((r5 instanceof ImmutableSetMultimap) == false) goto L12;
        ImmutableSetMultimap<K, V> r0 = (ImmutableSetMultimap) r5;
        if (r0.isPartialView() == true) goto L12;
        return r0;
    L12:
        ImmutableMap.Builder r1 = ImmutableMap.builder();
        Iterator<Map.Entry<? extends K, Collection<? extends V>>> r7 = r5.asMap().entrySet().iterator();
        int r2 = 0;
    L14:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<? extends K, Collection<? extends V>> r3 = r7.next();
        K r4 = r3.getKey();
        ImmutableSet r8 = valueSet(r6, r3.getValue());
        if (r8.isEmpty() == true) goto L14;
        r1.put(r4, r8);
        r2 = r2 + r8.size();
        goto L14
    L19:
        return new ImmutableSetMultimap(r1.build(), r2, r6);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> r1, int r2, @Nullable Comparator<? super V> r3) {
        super(r1, r2);
        this.emptySet = emptySet(r3);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableSet<V> get(@Nullable K r2) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.map.get(r2), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        ImmutableSetMultimap<V, K> r1 = invert();
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        Builder r0 = builder();
        UnmodifiableIterator r1 = entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.put(r2.getValue(), r2.getKey());
        goto L4
    L6:
        ImmutableSetMultimap<V, K> r3 = r0.build();
        r3.inverse = this;
        return r3;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @Deprecated
    public ImmutableSet<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public ImmutableSet<V> replaceValues(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> r0 = this.entries;
        if (r0 != null) goto L6;
        EntrySet r1 = new EntrySet(this);
        this.entries = r1;
        return r1;
    L6:
        return r0;
    }

    private static <V> ImmutableSet<V> valueSet(@Nullable Comparator<? super V> r0, Collection<? extends V> r1) {
        if (r0 != null) goto L5;
        return ImmutableSet.copyOf(r1);
    L5:
        return ImmutableSortedSet.copyOf(r0, r1);
    }

    private static <V> ImmutableSet<V> emptySet(@Nullable Comparator<? super V> r0) {
        if (r0 != null) goto L5;
        return ImmutableSet.of();
    L5:
        return ImmutableSortedSet.emptySet(r0);
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeObject(valueComparator());
        Serialization.writeMultimap(this, r2);
    }

    @Nullable
    Comparator<? super V> valueComparator() {
        ImmutableSet<V> r1 = this.emptySet;
        if ((r1 instanceof ImmutableSortedSet) == true) goto L7;
        return null;
    L7:
        return ((ImmutableSortedSet) r1).comparator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r12) throws IOException, ClassNotFoundException {
        r12.defaultReadObject();
        Comparator r0 = (Comparator) r12.readObject();
        int r1 = r12.readInt();
        if (r1 < 0) goto L25;
        ImmutableMap.Builder r2 = ImmutableMap.builder();
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r4 >= r1) goto L26;
        Object r6 = r12.readObject();
        int r7 = r12.readInt();
        if (r7 <= 0) goto L17;
        Object[] r8 = new Object[r7];
        int r9 = 0;
    L9:
        if (r9 >= r7) goto L11;
        r8[r9] = r12.readObject();
        r9 = r9 + 1;
        goto L9
    L11:
        ImmutableSet r10 = valueSet(r0, Arrays.asList(r8));
        if (r10.size() != r7) goto L15;
        r2.put(r6, r10);
        r5 = r5 + r7;
        r4 = r4 + 1;
        goto L5
    L15:
        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + r6);
    L17:
        throw new InvalidObjectException("Invalid value count " + r7);
    L26:
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, r2.build());
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, r5);
        ImmutableMultimap.FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(r0));
        return;
    L21:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L25:
        throw new InvalidObjectException("Invalid key count " + r1);
    }
}
