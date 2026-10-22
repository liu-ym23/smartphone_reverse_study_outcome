package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        public EnumSerializedForm(EnumMap<K, V> r10) {
            this.delegate = r10;
        }

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }

    public /* synthetic */ ImmutableEnumMap(EnumMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r10) {
        int r11 = r10.size();
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L7;
        Map.Entry r12 = (Map.Entry) Iterables.getOnlyElement(r10.entrySet());
        return ImmutableMap.of(r12.getKey(), r12.getValue());
    L7:
        return new ImmutableEnumMap(r10);
    L11:
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@NullableDecl Object r10) {
        return this.delegate.containsKey(r10);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableEnumMap) == false) goto L9;
        r10 = ((ImmutableEnumMap) r10).delegate;
    L9:
        return this.delegate.equals(r10);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object r10) {
        return this.delegate.get(r10);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public UnmodifiableIterator<K> keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    private ImmutableEnumMap(EnumMap<K, V> r10) {
        this.delegate = r10;
        Preconditions.checkArgument(!r10.isEmpty());
    }
}
