package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {

    @MonotonicNonNullDecl
    private transient Set<Table.Cell<R, C, V>> cellSet;

    @MonotonicNonNullDecl
    private transient Collection<V> values;

    public class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        final /* synthetic */ AbstractTable this$0;

        public CellSet(AbstractTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Table.Cell) == false) goto L10;
            Table.Cell r11 = (Table.Cell) r10;
            Map r12 = (Map) Maps.safeGet(this.this$0.rowMap(), r11.getRowKey());
            if (r12 != null) goto L7;
            return false;
        L7:
            if (Collections2.safeContains(r12.entrySet(), Maps.immutableEntry(r11.getColumnKey(), r11.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return this.this$0.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object r10) {
            if ((r10 instanceof Table.Cell) == false) goto L10;
            Table.Cell r11 = (Table.Cell) r10;
            Map r12 = (Map) Maps.safeGet(this.this$0.rowMap(), r11.getRowKey());
            if (r12 != null) goto L7;
            return false;
        L7:
            if (Collections2.safeRemove(r12.entrySet(), Maps.immutableEntry(r11.getColumnKey(), r11.getValue())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    public class Values extends AbstractCollection<V> {
        final /* synthetic */ AbstractTable this$0;

        public Values(AbstractTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r10) {
            return this.this$0.containsValue(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.this$0.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.this$0.size();
        }
    }

    public AbstractTable() {
    }

    public abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> r10 = this.cellSet;
        if (r10 != null) goto L6;
        Set<Table.Cell<R, C, V>> r11 = createCellSet();
        this.cellSet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        Iterators.clear(cellSet().iterator());
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
        Map r12 = (Map) Maps.safeGet(rowMap(), r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (Maps.safeContainsKey(r12, r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object r10) {
        return Maps.safeContainsKey(columnMap(), r10);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object r10) {
        return Maps.safeContainsKey(rowMap(), r10);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object r10) {
        Iterator<Map<C, V>> r11 = rowMap().values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r11.next().containsValue(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public Set<Table.Cell<R, C, V>> createCellSet() {
        return new CellSet(this);
    }

    public Collection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@NullableDecl Object r10) {
        return Tables.equalsImpl(this, r10);
    }

    @Override // com.google.common.collect.Table
    public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
        Map r12 = (Map) Maps.safeGet(rowMap(), r10);
        if (r12 != null) goto L6;
        return null;
    L6:
        return (V) Maps.safeGet(r12, r11);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r10, C r11, V r12) {
        return row(r10).put(r11, r12);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
        Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r11 = r10.cellSet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Table.Cell<? extends R, ? extends C, ? extends V> r12 = r11.next();
        put(r12.getRowKey(), r12.getColumnKey(), r12.getValue());
        goto L4
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        Map r12 = (Map) Maps.safeGet(rowMap(), r10);
        if (r12 != null) goto L6;
        return null;
    L6:
        return (V) Maps.safeRemove(r12, r11);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> r10 = this.values;
        if (r10 != null) goto L6;
        Collection<V> r11 = createValues();
        this.values = r11;
        return r11;
    L6:
        return r10;
    }

    public Iterator<V> valuesIterator() {
        final Iterator<Table.Cell<R, C, V>> r10 = cellSet().iterator();
        return new AnonymousClass1(this, r10);
    }
}
