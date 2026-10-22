package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> {
    private static final ImmutableTable<Object, Object, Object> EMPTY = null;

    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells;
        private Comparator<? super C> columnComparator;
        private Comparator<? super R> rowComparator;

        public Builder() {
            this.cells = Lists.newArrayList();
        }

        public Builder<R, C, V> orderRowsBy(Comparator<? super R> r1) {
            this.rowComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> r1) {
            this.columnComparator = (Comparator) Preconditions.checkNotNull(r1);
            return this;
        }

        public Builder<R, C, V> put(R r2, C r3, V r4) {
            this.cells.add(ImmutableTable.cellOf(r2, r3, r4));
            return this;
        }

        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> r3) {
            if ((r3 instanceof Tables.ImmutableCell) == false) goto L5;
            Preconditions.checkNotNull(r3.getRowKey());
            Preconditions.checkNotNull(r3.getColumnKey());
            Preconditions.checkNotNull(r3.getValue());
            this.cells.add(r3);
        L6:
            return this;
        L5:
            put(r3.getRowKey(), r3.getColumnKey(), r3.getValue());
            goto L6
        }

        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> r2) {
            Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r3 = r2.cellSet().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            put(r3.next());
            goto L4
        L6:
            return this;
        }

        public ImmutableTable<R, C, V> build() {
            int r0 = this.cells.size();
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        L9:
            return new SingletonImmutableTable((Table.Cell) Iterables.getOnlyElement(this.cells));
        L11:
            return ImmutableTable.of();
        }
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.AbstractTable
    abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    @Override // com.google.common.collect.AbstractTable
    abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return column(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@Nullable Object r1) {
        return super.containsColumn(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@Nullable Object r1) {
        return super.containsRow(r1);
    }

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@Nullable Object r1, @Nullable Object r2) {
        return super.get(r1, r2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object r1) {
        return row(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r1, C r2, V r3) {
        return new SingletonImmutableTable(r1, r2, r3);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> r4) {
        if ((r4 instanceof ImmutableTable) == true) goto L5;
        int r0 = r4.size();
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L16;
        ImmutableSet.Builder r1 = ImmutableSet.builder();
        Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r5 = r4.cellSet().iterator();
    L12:
        if (r5.hasNext() == false) goto L15;
        Table.Cell<? extends R, ? extends C, ? extends V> r2 = r5.next();
        r1.add(cellOf(r2.getRowKey(), r2.getColumnKey(), r2.getValue()));
        goto L12
    L15:
        return RegularImmutableTable.forCells(r1.build());
    L16:
        Table.Cell r6 = (Table.Cell) Iterables.getOnlyElement(r4.cellSet());
        return of(r6.getRowKey(), r6.getColumnKey(), r6.getValue());
    L19:
        return of();
    L5:
        return (ImmutableTable) r4;
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R r0, C r1, V r2) {
        return Tables.immutableCell(Preconditions.checkNotNull(r0), Preconditions.checkNotNull(r1), Preconditions.checkNotNull(r2));
    }

    ImmutableTable() {
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C r1) {
        Preconditions.checkNotNull(r1);
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(r1), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r1) {
        Preconditions.checkNotNull(r1);
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) rowMap().get(r1), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@Nullable Object r1, @Nullable Object r2) {
        if (get(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@Nullable Object r1) {
        return values().contains(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final V put(R r1, C r2, V r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final V remove(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }
}
