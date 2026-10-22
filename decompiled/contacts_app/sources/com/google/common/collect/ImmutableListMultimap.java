package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

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
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(K r1, V r2) {
            super.put(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r1) {
            super.put(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r1, Iterable<? extends V> r2) {
            super.putAll(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(K r1, V... r2) {
            super.putAll(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderKeysBy(Comparator<? super K> r1) {
            super.orderKeysBy(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Builder<K, V> orderValuesBy(Comparator<? super V> r1) {
            super.orderValuesBy(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap) super.build();
        }
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
    public /* bridge */ /* synthetic */ List get(@Nullable Object r1) {
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
    public /* bridge */ /* synthetic */ List removeAll(Object r1) {
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
    public /* bridge */ /* synthetic */ List replaceValues(Object r1, Iterable r2) {
        return replaceValues(r1, r2);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2) {
        Builder r0 = builder();
        r0.put(r1, r2);
        return r0.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        return r0.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        return r0.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        Builder r0 = builder();
        r0.put(r1, r2);
        r0.put(r3, r4);
        r0.put(r5, r6);
        r0.put(r7, r8);
        return r0.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
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

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r5) {
        if (r5.isEmpty() == false) goto L7;
        return of();
    L7:
        if ((r5 instanceof ImmutableListMultimap) == false) goto L11;
        ImmutableListMultimap<K, V> r0 = (ImmutableListMultimap) r5;
        if (r0.isPartialView() == true) goto L11;
        return r0;
    L11:
        ImmutableMap.Builder r1 = ImmutableMap.builder();
        Iterator<Map.Entry<? extends K, Collection<? extends V>>> r6 = r5.asMap().entrySet().iterator();
        int r2 = 0;
    L13:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<? extends K, Collection<? extends V>> r3 = r6.next();
        ImmutableList r4 = ImmutableList.copyOf(r3.getValue());
        if (r4.isEmpty() == true) goto L13;
        r1.put(r3.getKey(), r4);
        r2 = r2 + r4.size();
        goto L13
    L18:
        return new ImmutableListMultimap(r1.build(), r2);
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> r1, int r2) {
        super(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableList<V> get(@Nullable K r1) {
        ImmutableList<V> r0 = (ImmutableList) this.map.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        ImmutableListMultimap<V, K> r1 = invert();
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        Builder r0 = builder();
        UnmodifiableIterator r1 = entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.put(r2.getValue(), r2.getKey());
        goto L4
    L6:
        ImmutableListMultimap<V, K> r3 = r0.build();
        r3.inverse = this;
        return r3;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @Deprecated
    public ImmutableList<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @Deprecated
    public ImmutableList<V> replaceValues(K r1, Iterable<? extends V> r2) {
        throw new UnsupportedOperationException();
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        Serialization.writeMultimap(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r11) throws IOException, ClassNotFoundException {
        r11.defaultReadObject();
        int r0 = r11.readInt();
        if (r0 < 0) goto L21;
        ImmutableMap.Builder r1 = ImmutableMap.builder();
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r0) goto L22;
        Object r5 = r11.readObject();
        int r6 = r11.readInt();
        if (r6 <= 0) goto L13;
        Object[] r7 = new Object[r6];
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L11;
        r7[r8] = r11.readObject();
        r8 = r8 + 1;
        goto L9
    L11:
        r1.put(r5, ImmutableList.copyOf(r7));
        r4 = r4 + r6;
        r3 = r3 + 1;
        goto L5
    L13:
        throw new InvalidObjectException("Invalid value count " + r6);
    L22:
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, r1.build());
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, r4);
        return;
    L17:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L21:
        throw new InvalidObjectException("Invalid key count " + r0);
    }
}
