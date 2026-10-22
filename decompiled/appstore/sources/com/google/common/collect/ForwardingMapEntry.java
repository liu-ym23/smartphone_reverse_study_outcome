package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    public ForwardingMapEntry() {
    }

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Map.Entry<K, V> delegate();

    @Override // java.util.Map.Entry
    public boolean equals(@NullableDecl Object r10) {
        return delegate().equals(r10);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return delegate().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return delegate().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return delegate().hashCode();
    }

    public V setValue(V r10) {
        return delegate().setValue(r10);
    }

    public boolean standardEquals(@NullableDecl Object r10) {
        if ((r10 instanceof Map.Entry) == false) goto L10;
        Map.Entry r11 = (Map.Entry) r10;
        if (Objects.equal(getKey(), r11.getKey()) == true) goto L7;
        return false;
    L7:
        if (Objects.equal(getValue(), r11.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int standardHashCode() {
        K r10 = getKey();
        V r11 = getValue();
        int r12 = 0;
        if (r10 != null) goto L5;
        int r13 = 0;
    L6:
        if (r11 == null) goto L10;
        r12 = r11.hashCode();
    L10:
        return r13 ^ r12;
    L5:
        r13 = r10.hashCode();
        goto L6
    }

    @Beta
    public String standardToString() {
        return getKey() + "=" + getValue();
    }
}
