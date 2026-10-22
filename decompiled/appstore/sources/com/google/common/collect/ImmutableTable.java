package com.google.common.collect;

import com.bytedance.apm.constant.CommonKey;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {

    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells;

        @MonotonicNonNullDecl
        private Comparator<? super C> columnComparator;

        @MonotonicNonNullDecl
        private Comparator<? super R> rowComparator;

        public Builder() {
            this.cells = Lists.newArrayList();
        }

        public ImmutableTable<R, C, V> build() {
            int r10 = this.cells.size();
            if (r10 == 0) goto L11;
            if (r10 == 1) goto L9;
            return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        L9:
            return new SingletonImmutableTable((Table.Cell) Iterables.getOnlyElement(this.cells));
        L11:
            return ImmutableTable.of();
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> r10) {
            this.columnComparator = (Comparator) Preconditions.checkNotNull(r10, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> orderRowsBy(Comparator<? super R> r10) {
            this.rowComparator = (Comparator) Preconditions.checkNotNull(r10, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> put(R r10, C r11, V r12) {
            this.cells.add(ImmutableTable.cellOf(r10, r11, r12));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> r10) {
            Iterator<Table.Cell<? extends R, ? extends C, ? extends V>> r11 = r10.cellSet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            put(r11.next());
            goto L4
        L6:
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> r10) {
            if ((r10 instanceof Tables.ImmutableCell) == false) goto L5;
            Preconditions.checkNotNull(r10.getRowKey(), "row");
            Preconditions.checkNotNull(r10.getColumnKey(), "column");
            Preconditions.checkNotNull(r10.getValue(), CommonKey.KEY_VALUE);
            this.cells.add(r10);
        L6:
            return this;
        L5:
            put(r10.getRowKey(), r10.getColumnKey(), r10.getValue());
            goto L6
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] r10, Object[] r11, Object[] r12, int[] r13, int[] r14) {
            this.rowKeys = r10;
            this.columnKeys = r11;
            this.cellValues = r12;
            this.cellRowIndices = r13;
            this.cellColumnIndices = r14;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> r10, int[] r11, int[] r12) {
            return new SerializedForm(r10.rowKeySet().toArray(), r10.columnKeySet().toArray(), r10.values().toArray(), r11, r12);
        }

        public Object readResolve() {
            Object[] r10 = this.cellValues;
            if (r10.length == 0) goto L5;
            int r11 = 0;
            if (r10.length == 1) goto L9;
            ImmutableList.Builder r12 = new ImmutableList.Builder(r10.length);
        L11:
            Object[] r13 = this.cellValues;
            if (r11 >= r13.length) goto L15;
            r12.add(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[r11]], this.columnKeys[this.cellColumnIndices[r11]], r13[r11]));
            r11 = r11 + 1;
            goto L11
        L15:
            return RegularImmutableTable.forOrderedComponents(r12.build(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
        L9:
            return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], r10[0]);
        L5:
            return ImmutableTable.of();
        }
    }

    public ImmutableTable() {
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder();
    }

    public static <R, C, V> Table.Cell<R, C, V> cellOf(R r10, C r11, V r12) {
        return Tables.immutableCell(Preconditions.checkNotNull(r10, "rowKey"), Preconditions.checkNotNull(r11, "columnKey"), Preconditions.checkNotNull(r12, CommonKey.KEY_VALUE));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> r10) {
        if ((r10 instanceof ImmutableTable) == false) goto L7;
        return (ImmutableTable) r10;
    L7:
        return copyOf(r10.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Iterator cellIterator() {
        return cellIterator();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object r10) {
        return column(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (get(r10, r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object r10) {
        return super.containsColumn(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object r10) {
        return super.containsRow(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object r10) {
        return values().contains(r10);
    }

    @Override // com.google.common.collect.AbstractTable
    public abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    public abstract SerializedForm createSerializedForm();

    @Override // com.google.common.collect.AbstractTable
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.get(r10, r11);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(R r10, C r11, V r12) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object r10, Object r11) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object r10) {
        return row(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

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

    @Override // com.google.common.collect.AbstractTable
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r10, C r11, V r12) {
        return new SingletonImmutableTable(r10, r11, r12);
    }

    @Override // com.google.common.collect.AbstractTable
    public final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C r10) {
        Preconditions.checkNotNull(r10, "columnKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(r10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r10) {
        Preconditions.checkNotNull(r10, "rowKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) rowMap().get(r10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    private static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends Table.Cell<? extends R, ? extends C, ? extends V>> r10) {
        Builder r11 = builder();
        Iterator<? extends Table.Cell<? extends R, ? extends C, ? extends V>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.put(r12.next());
        goto L4
    L7:
        return r11.build();
    }
}
