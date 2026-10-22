package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> r1) {
            this.delegate = r1;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    /* synthetic */ ImmutableEnumMap(EnumMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ EnumMap access$000(ImmutableEnumMap r0) {
        return r0.delegate;
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r3 = (Map.Entry) Iterables.getOnlyElement(r2.entrySet());
        return ImmutableMap.of(r3.getKey(), r3.getValue());
    L7:
        return new ImmutableEnumMap(r2);
    L11:
        return ImmutableMap.of();
    }

    private ImmutableEnumMap(EnumMap<K, V> r1) {
        this.delegate = r1;
        Preconditions.checkArgument(!r1.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return (ImmutableSet<K>) new AnonymousClass1(this);
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@Nullable Object r1) {
        return this.delegate.containsKey(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r1) {
        return this.delegate.get(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
