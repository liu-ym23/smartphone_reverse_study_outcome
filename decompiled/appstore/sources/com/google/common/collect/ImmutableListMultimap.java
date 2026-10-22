package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @RetainedWith
    @LazyInit
    private transient ImmutableListMultimap<V, K> inverse;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public /* bridge */ /* synthetic */ ImmutableMultimap build() {
            return build();
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
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap) super.build();
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
            super.putAll(r10, r11);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> r10) {
            super.putAll(r10);
            return this;
        }
    }

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> r10, int r11) {
        super(r10, r11);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> r10) {
        if (r10.isEmpty() == false) goto L7;
        return of();
    L7:
        if ((r10 instanceof ImmutableListMultimap) == false) goto L12;
        ImmutableListMultimap<K, V> r11 = (ImmutableListMultimap) r10;
        if (r11.isPartialView() == true) goto L12;
        return r11;
    L12:
        return fromMapEntries(r10.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r10, @NullableDecl Comparator<? super V> r11) {
        if (r10.isEmpty() == true) goto L5;
        ImmutableMap.Builder r12 = new ImmutableMap.Builder(r10.size());
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r13 = r10.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L17;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r15 = r13.next();
        K r16 = r15.getKey();
        Collection<? extends V> r17 = r15.getValue();
        if (r11 != null) goto L12;
        ImmutableList r18 = ImmutableList.copyOf(r17);
    L14:
        if (r18.isEmpty() == true) goto L8;
        r12.put(r16, r18);
        r14 = r14 + r18.size();
        goto L8
    L12:
        r18 = ImmutableList.sortedCopyOf(r11, r17);
        goto L14
    L17:
        return new ImmutableListMultimap(r12.build(), r14);
    L5:
        return of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        Builder r10 = builder();
        UnmodifiableIterator r11 = entries().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.put(r12.getValue(), r12.getKey());
        goto L4
    L6:
        ImmutableListMultimap<V, K> r13 = r10.build();
        r13.inverse = this;
        return r13;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream r11) throws IOException, ClassNotFoundException {
        r11.defaultReadObject();
        int r10 = r11.readInt();
        if (r10 < 0) goto L21;
        ImmutableMap.Builder r12 = ImmutableMap.builder();
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r13 >= r10) goto L22;
        Object r15 = r11.readObject();
        int r16 = r11.readInt();
        if (r16 <= 0) goto L13;
        ImmutableList.Builder r17 = ImmutableList.builder();
        int r18 = 0;
    L9:
        if (r18 >= r16) goto L11;
        r17.add(r11.readObject());
        r18 = r18 + 1;
        goto L9
    L11:
        r12.put(r15, r17.build());
        r14 = r14 + r16;
        r13 = r13 + 1;
        goto L5
    L13:
        throw new InvalidObjectException("Invalid value count " + r16);
    L22:
        ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, r12.build());
        ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, r14);
        return;
    L17:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L21:
        throw new InvalidObjectException("Invalid key count " + r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        Serialization.writeMultimap(this, r10);
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

    public static <K, V> ImmutableListMultimap<K, V> of(K r10, V r11) {
        Builder r12 = builder();
        r12.put(r10, r11);
        return r12.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Collection get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> r10 = this.inverse;
        if (r10 != null) goto L6;
        ImmutableListMultimap<V, K> r11 = invert();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ List get(@NullableDecl Object r10) {
        return get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ List removeAll(Object r10) {
        return removeAll(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ List replaceValues(Object r10, Iterable r11) {
        return replaceValues(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    public ImmutableList<V> get(@NullableDecl K r10) {
        ImmutableList<V> r11 = (ImmutableList) this.map.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> removeAll(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K r10, Iterable<? extends V> r11) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r10, V r11, K r12, V r13) {
        Builder r14 = builder();
        r14.put(r10, r11);
        r14.put(r12, r13);
        return r14.build();
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        return new Builder().putAll(r10).build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15) {
        Builder r16 = builder();
        r16.put(r10, r11);
        r16.put(r12, r13);
        r16.put(r14, r15);
        return r16.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        Builder r18 = builder();
        r18.put(r10, r11);
        r18.put(r12, r13);
        r18.put(r14, r15);
        r18.put(r16, r17);
        return r18.build();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19) {
        Builder r20 = builder();
        r20.put(r10, r11);
        r20.put(r12, r13);
        r20.put(r14, r15);
        r20.put(r16, r17);
        r20.put(r18, r19);
        return r20.build();
    }
}
