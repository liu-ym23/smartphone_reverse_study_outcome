package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;
    private final transient ImmutableMapEntry<K, V>[] entries;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] table;

    /* JADX INFO: renamed from: com.google.common.collect.RegularImmutableMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EntrySet extends ImmutableMapEntrySet<K, V> {
        final /* synthetic */ RegularImmutableMap this$0;

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        private EntrySet(RegularImmutableMap r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(RegularImmutableMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        ImmutableMap<K, V> map() {
            return this.this$0;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new RegularImmutableAsList(this, RegularImmutableMap.access$100(this.this$0));
        }
    }

    private static final class NonTerminalMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final ImmutableMapEntry<K, V> nextInKeyBucket;

        @Override // com.google.common.collect.ImmutableMapEntry
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }

        NonTerminalMapEntry(K r1, V r2, ImmutableMapEntry<K, V> r3) {
            super(r1, r2);
            this.nextInKeyBucket = r3;
        }

        NonTerminalMapEntry(ImmutableMapEntry<K, V> r1, ImmutableMapEntry<K, V> r2) {
            super(r1);
            this.nextInKeyBucket = r2;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    static /* synthetic */ ImmutableMapEntry[] access$100(RegularImmutableMap r0) {
        return r0.entries;
    }

    RegularImmutableMap(ImmutableMapEntry.TerminalEntry<?, ?>... r2) {
        this(r2.length, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.collect.ImmutableMapEntry, com.google.common.collect.ImmutableMapEntry$TerminalEntry] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.collect.ImmutableMapEntry] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.common.collect.ImmutableMapEntry<K, V>[]] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.common.collect.ImmutableMapEntry<K, V>[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.common.collect.RegularImmutableMap, com.google.common.collect.RegularImmutableMap<K, V>] */
    RegularImmutableMap(int r7, ImmutableMapEntry.TerminalEntry<?, ?>[] r8) {
        this.entries = createEntryArray(r7);
        int r0 = Hashing.closedTableSize(r7, MAX_LOAD_FACTOR);
        this.table = createEntryArray(r0);
        this.mask = r0 - 1;
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        ?? r2 = r8[r1];
        Object r3 = r2.getKey();
        int r4 = Hashing.smear(r3.hashCode()) & this.mask;
        ImmutableMapEntry<K, V> r5 = this.table[r4];
        if (r5 == null) goto L8;
        r2 = new NonTerminalMapEntry(r2, r5);
    L8:
        this.table[r4] = r2;
        this.entries[r1] = r2;
        checkNoConflictInBucket(r3, r2, r5);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    RegularImmutableMap(Map.Entry<?, ?>[] r8) {
        int r0 = r8.length;
        this.entries = createEntryArray(r0);
        int r1 = Hashing.closedTableSize(r0, MAX_LOAD_FACTOR);
        this.table = createEntryArray(r1);
        this.mask = r1 - 1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Map.Entry<?, ?> r3 = r8[r2];
        Object r4 = r3.getKey();
        Object r5 = r3.getValue();
        CollectPreconditions.checkEntryNotNull(r4, r5);
        int r6 = Hashing.smear(r4.hashCode()) & this.mask;
        ImmutableMapEntry<K, V> r7 = this.table[r6];
        if (r7 != null) goto L7;
        ImmutableMapEntry<K, V> r9 = new ImmutableMapEntry.TerminalEntry(r4, r5);
    L8:
        this.table[r6] = r9;
        this.entries[r2] = r9;
        checkNoConflictInBucket(r4, r9, r7);
        r2 = r2 + 1;
        goto L3
    L7:
        r9 = new NonTerminalMapEntry(r4, r5, r7);
        goto L8
    }

    private void checkNoConflictInBucket(K r2, ImmutableMapEntry<K, V> r3, ImmutableMapEntry<K, V> r4) {
    L2:
        if (r4 == null) goto L4;
        checkNoConflict(!r2.equals(r4.getKey()), "key", r3, r4);
        r4 = r4.getNextInKeyBucket();
        goto L2
    }

    private ImmutableMapEntry<K, V>[] createEntryArray(int r1) {
        return new ImmutableMapEntry[r1];
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = Hashing.smear(r4.hashCode()) & this.mask;
        ImmutableMapEntry<K, V> r3 = this.table[r1];
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

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, null);
    }
}
