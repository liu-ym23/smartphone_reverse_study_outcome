package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    private static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = null;

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
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
        public /* bridge */ /* synthetic */ ImmutableMap.Builder putAll(Map r1) {
            return putAll(r1);
        }

        public Builder() {
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K r1, V r2) {
            super.put(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Map<? extends K, ? extends V> r1) {
            super.putAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            int r0 = this.size;
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return new RegularImmutableBiMap(this.size, this.entries);
        L9:
            return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
        L11:
            return ImmutableBiMap.of();
        }
    }

    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new Builder());
        }
    }

    public abstract ImmutableBiMap<V, K> inverse();

    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return EmptyImmutableBiMap.INSTANCE;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2) {
        return new SingletonImmutableBiMap(r1, r2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6) {
        return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8) {
        return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12) {
        return new RegularImmutableBiMap(new ImmutableMapEntry.TerminalEntry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12)});
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r2) {
        if ((r2 instanceof ImmutableBiMap) == false) goto L7;
        ImmutableBiMap<K, V> r0 = (ImmutableBiMap) r2;
        if (r0.isPartialView() == true) goto L7;
        return r0;
    L7:
        Map.Entry[] r3 = (Map.Entry[]) r2.entrySet().toArray(EMPTY_ENTRY_ARRAY);
        int r1 = r3.length;
        if (r1 == 0) goto L16;
        if (r1 != 1) goto L12;
        Map.Entry r4 = r3[0];
        return of(r4.getKey(), r4.getValue());
    L12:
        return new RegularImmutableBiMap(r3);
    L16:
        return of();
    }

    static {
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    ImmutableBiMap() {
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.util.SortedMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.BiMap
    @Deprecated
    public V forcePut(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
