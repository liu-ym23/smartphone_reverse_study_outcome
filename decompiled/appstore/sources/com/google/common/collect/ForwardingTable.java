package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    public ForwardingTable() {
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C r10) {
        return delegate().column(r10);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(Object r10, Object r11) {
        return delegate().contains(r10, r11);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object r10) {
        return delegate().containsColumn(r10);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object r10) {
        return delegate().containsRow(r10);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object r10) {
        return delegate().containsValue(r10);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Table<R, C, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r10) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.Table
    public V get(Object r10, Object r11) {
        return delegate().get(r10, r11);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r10, C r11, V r12) {
        return delegate().put(r10, r11, r12);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
        delegate().putAll(r10);
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(Object r10, Object r11) {
        return delegate().remove(r10, r11);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r10) {
        return delegate().row(r10);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return delegate().values();
    }
}
