package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    @Override // com.google.common.collect.ForwardingObject
    protected abstract Table<R, C, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingTable() {
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
    public Map<R, V> column(C r1) {
        return delegate().column(r1);
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
    public boolean contains(Object r1, Object r2) {
        return delegate().contains(r1, r2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object r1) {
        return delegate().containsColumn(r1);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object r1) {
        return delegate().containsRow(r1);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // com.google.common.collect.Table
    public V get(Object r1, Object r2) {
        return delegate().get(r1, r2);
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    public V put(R r1, C r2, V r3) {
        return delegate().put(r1, r2, r3);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r1) {
        delegate().putAll(r1);
    }

    @Override // com.google.common.collect.Table
    public V remove(Object r1, Object r2) {
        return delegate().remove(r1, r2);
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r1) {
        return delegate().row(r1);
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

    @Override // com.google.common.collect.Table
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }
}
