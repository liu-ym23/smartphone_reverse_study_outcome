package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final double MAX_LOAD_FACTOR = 1.2d;
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] valueTable;

    private final class Inverse extends ImmutableBiMap<V, K> {
        final /* synthetic */ RegularImmutableBiMap this$0;

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            final /* synthetic */ Inverse this$1;

            @Override // com.google.common.collect.ImmutableSet
            boolean isHashCodeFast() {
                return true;
            }

            InverseEntrySet(Inverse r1) {
                this.this$1 = r1;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return iterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<V, K> map() {
                return this.this$1;
            }

            @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.access$100(this.this$1.this$0);
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }

            @Override // com.google.common.collect.ImmutableCollection
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new AnonymousClass1(this);
            }
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        private Inverse(RegularImmutableBiMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Inverse(RegularImmutableBiMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ BiMap inverse() {
            return inverse();
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
        public ImmutableBiMap<K, V> inverse() {
            return this.this$0;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(@Nullable Object r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            int r1 = Hashing.smear(r4.hashCode()) & RegularImmutableBiMap.access$300(this.this$0);
            ImmutableMapEntry r3 = RegularImmutableBiMap.access$400(this.this$0)[r1];
        L6:
            if (r3 == null) goto L12;
            if (r4.equals(r3.getValue()) == true) goto L10;
            r3 = r3.getNextInValueBucket();
            goto L6
        L10:
            return r3.getKey();
        L12:
            return null;
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet(this);
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return new InverseSerializedForm(this.this$0);
        }
    }

    private static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        InverseSerializedForm(ImmutableBiMap<K, V> r1) {
            this.forward = r1;
        }

        Object readResolve() {
            return this.forward.inverse();
        }
    }

    private static final class NonTerminalBiMapEntry<K, V> extends ImmutableMapEntry<K, V> {

        @Nullable
        private final ImmutableMapEntry<K, V> nextInKeyBucket;

        @Nullable
        private final ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalBiMapEntry(K r1, V r2, @Nullable ImmutableMapEntry<K, V> r3, @Nullable ImmutableMapEntry<K, V> r4) {
            super(r1, r2);
            this.nextInKeyBucket = r3;
            this.nextInValueBucket = r4;
        }

        NonTerminalBiMapEntry(ImmutableMapEntry<K, V> r1, @Nullable ImmutableMapEntry<K, V> r2, @Nullable ImmutableMapEntry<K, V> r3) {
            super(r1);
            this.nextInKeyBucket = r2;
            this.nextInValueBucket = r3;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        @Nullable
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    static /* synthetic */ ImmutableMapEntry[] access$000(RegularImmutableBiMap r0) {
        return r0.entries;
    }

    static /* synthetic */ int access$100(RegularImmutableBiMap r0) {
        return r0.hashCode;
    }

    static /* synthetic */ int access$300(RegularImmutableBiMap r0) {
        return r0.mask;
    }

    static /* synthetic */ ImmutableMapEntry[] access$400(RegularImmutableBiMap r0) {
        return r0.valueTable;
    }

    RegularImmutableBiMap(ImmutableMapEntry.TerminalEntry<?, ?>... r2) {
        this(r2.length, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.google.common.collect.ImmutableMapEntry, java.util.Map$Entry] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.common.collect.ImmutableMapEntry<K, V>[], com.google.common.collect.ImmutableMapEntry[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.common.collect.ImmutableMapEntry<K, V>[], com.google.common.collect.ImmutableMapEntry[]] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.collect.ImmutableMapEntry<K, V>[], com.google.common.collect.ImmutableMapEntry[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.common.collect.ImmutableMapEntry, com.google.common.collect.ImmutableMapEntry$TerminalEntry, java.util.Map$Entry] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.google.common.collect.ImmutableMapEntry, java.util.Map$Entry] */
    /* JADX WARN: Type inference failed for: r8v8 */
    RegularImmutableBiMap(int r18, ImmutableMapEntry.TerminalEntry<?, ?>[] r19) {
        int r1 = r18;
        int r2 = Hashing.closedTableSize(r1, MAX_LOAD_FACTOR);
        this.mask = r2 - 1;
        ?? r3 = (ImmutableMapEntry<K, V>[]) createEntryArray(r2);
        ?? r4 = (ImmutableMapEntry<K, V>[]) createEntryArray(r2);
        ?? r5 = (ImmutableMapEntry<K, V>[]) createEntryArray(r18);
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r6 >= r1) goto L15;
        ?? r8 = r19[r6];
        Object r9 = r8.getKey();
        Object r10 = r8.getValue();
        int r11 = r9.hashCode();
        int r12 = r10.hashCode();
        int r13 = Hashing.smear(r11) & this.mask;
        int r14 = Hashing.smear(r12) & this.mask;
        ?? r15 = r3[r13];
        ?? r16 = r15;
    L5:
        if (r16 == 0) goto L7;
        checkNoConflict(!r9.equals(r16.getKey()), "key", r8, r16);
        r9 = r9;
        r16 = r16.getNextInKeyBucket();
        goto L5
    L7:
        ?? r17 = r4[r14];
        ?? r20 = r17;
    L8:
        if (r20 == 0) goto L10;
        checkNoConflict(!r10.equals(r20.getValue()), "value", r8, r20);
        r10 = r10;
        r20 = r20.getNextInValueBucket();
        goto L8
    L10:
        if (r15 != 0) goto L13;
        if (r17 != 0) goto L13;
    L14:
        r3[r13] = r8;
        r4[r14] = r8;
        r5[r6] = r8;
        r7 = r7 + (r11 ^ r12);
        r6 = r6 + 1;
        r1 = r18;
    L13:
        r8 = new NonTerminalBiMapEntry(r8, r15, r17);
        goto L14
    L15:
        this.keyTable = r3;
        this.valueTable = r4;
        this.entries = r5;
        this.hashCode = r7;
    }

    RegularImmutableBiMap(Map.Entry<?, ?>[] r19) {
        RegularImmutableBiMap<K, V> r0 = this;
        Map.Entry<?, ?>[] r1 = r19;
        int r2 = r1.length;
        int r3 = Hashing.closedTableSize(r2, MAX_LOAD_FACTOR);
        r0.mask = r3 - 1;
        ImmutableMapEntry<K, V>[] r4 = createEntryArray(r3);
        ImmutableMapEntry<K, V>[] r5 = createEntryArray(r3);
        ImmutableMapEntry<K, V>[] r6 = createEntryArray(r2);
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r7 >= r2) goto L16;
        Map.Entry<?, ?> r9 = r1[r7];
        Object r10 = r9.getKey();
        Object r11 = r9.getValue();
        CollectPreconditions.checkEntryNotNull(r10, r11);
        int r12 = r10.hashCode();
        int r13 = r11.hashCode();
        int r14 = Hashing.smear(r12) & r0.mask;
        int r15 = Hashing.smear(r13) & r0.mask;
        ImmutableMapEntry<K, V> r16 = r4[r14];
        ImmutableMapEntry<K, V> r17 = r16;
    L5:
        if (r17 == null) goto L7;
        checkNoConflict(!r10.equals(r17.getKey()), "key", r9, r17);
        r17 = r17.getNextInKeyBucket();
        r2 = r2;
        goto L5
    L7:
        int r18 = r2;
        ImmutableMapEntry<K, V> r20 = r5[r15];
        ImmutableMapEntry<K, V> r21 = r20;
    L8:
        if (r21 == null) goto L10;
        checkNoConflict(!r11.equals(r21.getValue()), "value", r9, r21);
        r21 = r21.getNextInValueBucket();
        r8 = r8;
        goto L8
    L10:
        int r110 = r8;
        if (r16 != null) goto L14;
        if (r20 != null) goto L14;
        ImmutableMapEntry<K, V> r22 = new ImmutableMapEntry.TerminalEntry(r10, r11);
    L15:
        r4[r14] = r22;
        r5[r15] = r22;
        r6[r7] = r22;
        r8 = r110 + (r12 ^ r13);
        r7 = r7 + 1;
        r0 = this;
        r1 = r19;
        r2 = r18;
    L14:
        r22 = new NonTerminalBiMapEntry(r10, r11, r16, r20);
        goto L15
    L16:
        r0.keyTable = r4;
        r0.valueTable = r5;
        r0.entries = r6;
        r0.hashCode = r8;
    }

    private static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int r0) {
        return new ImmutableMapEntry[r0];
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @Nullable
    public V get(@Nullable Object r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = Hashing.smear(r4.hashCode()) & this.mask;
        ImmutableMapEntry<K, V> r3 = this.keyTable[r1];
    L6:
        if (r3 == null) goto L12;
        if (r4.equals(r3.getKey()) == true) goto L10;
        r3 = r3.getNextInKeyBucket();
        goto L6
    L10:
        return r3.getValue();
    L12:
        return null;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        Inverse r1 = new Inverse(this, null);
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }
}
