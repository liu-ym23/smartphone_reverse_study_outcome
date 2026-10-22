package com.google.common.cache;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class RemovalNotification<K, V> implements Map.Entry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    @Nullable
    private final K key;

    @Nullable
    private final V value;

    RemovalNotification(@Nullable K r1, @Nullable V r2, RemovalCause r3) {
        this.key = r1;
        this.value = r2;
        this.cause = (RemovalCause) Preconditions.checkNotNull(r3);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    @Override // java.util.Map.Entry
    @Nullable
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    @Nullable
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object r4) {
        if ((r4 instanceof Map.Entry) == false) goto L10;
        Map.Entry r5 = (Map.Entry) r4;
        if (Objects.equal(getKey(), r5.getKey()) == true) goto L7;
        return false;
    L7:
        if (Objects.equal(getValue(), r5.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K r0 = getKey();
        V r2 = getValue();
        int r1 = 0;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 == null) goto L10;
        r1 = r2.hashCode();
    L10:
        return r3 ^ r1;
    L5:
        r3 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
