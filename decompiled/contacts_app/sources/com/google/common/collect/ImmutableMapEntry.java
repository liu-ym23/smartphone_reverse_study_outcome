package com.google.common.collect;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    static final class TerminalEntry<K, V> extends ImmutableMapEntry<K, V> {
        @Override // com.google.common.collect.ImmutableMapEntry
        @Nullable
        ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return null;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        @Nullable
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return null;
        }

        TerminalEntry(ImmutableMapEntry<K, V> r1) {
            super(r1);
        }

        TerminalEntry(K r1, V r2) {
            super(r1, r2);
        }
    }

    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInKeyBucket();

    @Nullable
    abstract ImmutableMapEntry<K, V> getNextInValueBucket();

    ImmutableMapEntry(K r1, V r2) {
        super(r1, r2);
        CollectPreconditions.checkEntryNotNull(r1, r2);
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> r2) {
        super(r2.getKey(), r2.getValue());
    }
}
