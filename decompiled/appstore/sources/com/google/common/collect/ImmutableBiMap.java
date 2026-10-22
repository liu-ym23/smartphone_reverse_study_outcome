package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public /* bridge */ /* synthetic */ ImmutableMap.Builder orderEntriesByValue(Comparator r10) {
            return orderEntriesByValue(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object r10, Object r11) {
            return put(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Iterable r10) {
            return putAll(r10);
        }

        public Builder(int r10) {
            super(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            if (this.size == 0) goto L5;
            sortEntries();
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        L5:
            return ImmutableBiMap.of();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> r10) {
            super.orderEntriesByValue(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Map.Entry r10) {
            return put(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Map r10) {
            return putAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K r10, V r11) {
            super.put(r10, r11);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r10) {
            super.putAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> r10) {
            super.put(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
            super.putAll(r10);
            return this;
        }
    }

    public static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<?, ?> r10) {
            super(r10);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new Builder());
        }
    }

    public ImmutableBiMap() {
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedSize");
        return new Builder(r10);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r10) {
        if ((r10 instanceof ImmutableBiMap) == false) goto L8;
        ImmutableBiMap<K, V> r11 = (ImmutableBiMap) r10;
        if (r11.isPartialView() == true) goto L8;
        return r11;
    L8:
        return copyOf(r10.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableMap
    public /* bridge */ /* synthetic */ ImmutableCollection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r10, V r11) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        return new RegularImmutableBiMap(new Object[]{r10, r11}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r10, V r11, K r12, V r13) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        return new RegularImmutableBiMap(new Object[]{r10, r11, r12, r13}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        int r11 = ((Collection) r10).size();
    L7:
        return new Builder(r11).putAll(r10).build();
    L5:
        r11 = 4;
        goto L7
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        return new RegularImmutableBiMap(new Object[]{r10, r11, r12, r13, r14, r15}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        CollectPreconditions.checkEntryNotNull(r16, r17);
        return new RegularImmutableBiMap(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r10, V r11, K r12, V r13, K r14, V r15, K r16, V r17, K r18, V r19) {
        CollectPreconditions.checkEntryNotNull(r10, r11);
        CollectPreconditions.checkEntryNotNull(r12, r13);
        CollectPreconditions.checkEntryNotNull(r14, r15);
        CollectPreconditions.checkEntryNotNull(r16, r17);
        CollectPreconditions.checkEntryNotNull(r18, r19);
        return new RegularImmutableBiMap(new Object[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19}, 5);
    }
}
