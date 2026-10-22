package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
    private transient Set<Table.Cell<R, C, V>> cellSet;
    private transient Collection<V> values;

    class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        final /* synthetic */ AbstractTable this$0;

        CellSet(AbstractTable r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r3) {
            if ((r3 instanceof Table.Cell) == false) goto L10;
            Table.Cell r4 = (Table.Cell) r3;
            Map r2 = (Map) Maps.safeGet(this.this$0.rowMap(), r4.getRowKey());
            if (r2 != null) goto L7;
            return false;
        L7:
            if (Collections2.safeContains(r2.entrySet(), Maps.immutableEntry(r4.getColumnKey(), r4.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object r3) {
            if ((r3 instanceof Table.Cell) == false) goto L10;
            Table.Cell r4 = (Table.Cell) r3;
            Map r2 = (Map) Maps.safeGet(this.this$0.rowMap(), r4.getRowKey());
            if (r2 != null) goto L7;
            return false;
        L7:
            if (Collections2.safeRemove(r2.entrySet(), Maps.immutableEntry(r4.getColumnKey(), r4.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return this.this$0.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractTable this$0;

        Values(AbstractTable r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    AbstractTable() {
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@Nullable Object r1) {
        return Maps.safeContainsKey(rowMap(), r1);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@Nullable Object r1) {
        return Maps.safeContainsKey(columnMap(), r1);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@Nullable Object r2) {
        Iterator<Map<C, V>> r1 = rowMap().values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().containsValue(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@Nullable Object r1, @Nullable Object r2) {
        Map r0 = (Map) Maps.safeGet(rowMap(), r1);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Maps.safeContainsKey(r0, r2) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Table
    public V get(@Nullable Object r1, @Nullable Object r2) {
        Map r0 = (Map) Maps.safeGet(rowMap(), r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return (V) Maps.safeGet(r0, r2);
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        Iterators.clear(cellSet().iterator());
    }

    @Override // com.google.common.collect.Table
    public V remove(@Nullable Object r1, @Nullable Object r2) {
        Map r0 = (Map) Maps.safeGet(rowMap(), r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return (V) Maps.safeRemove(r0, r2);
    }

    @Override // com.google.common.collect.Table
    public V put(R r1, C r2, V r3) {
        return row(r1).put(r2, r3);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r4) {
        Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r5 = r4.cellSet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Table.Cell<? extends R, ? extends C, ? extends V> r0 = r5.next();
        put(r0.getRowKey(), r0.getColumnKey(), r0.getValue());
        goto L4
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> r0 = this.cellSet;
        if (r0 != null) goto L6;
        Set<Table.Cell<R, C, V>> r1 = createCellSet();
        this.cellSet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<Table.Cell<R, C, V>> createCellSet() {
        return new CellSet(this);
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> r0 = this.values;
        if (r0 != null) goto L6;
        Collection<V> r1 = createValues();
        this.values = r1;
        return r1;
    L6:
        return r0;
    }

    Collection<V> createValues() {
        return new Values(this);
    }

    Iterator<V> valuesIterator() {
        final Iterator<Table.Cell<R, C, V>> r1 = cellSet().iterator();
        return new AnonymousClass1(this, r1);
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@Nullable Object r1) {
        return Tables.equalsImpl(this, r1);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    public String toString() {
        return rowMap().toString();
    }
}
