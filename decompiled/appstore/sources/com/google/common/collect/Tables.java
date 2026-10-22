package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = null;

    public static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        public AbstractCell() {
        }

        @Override // com.google.common.collect.Table.Cell
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Table.Cell) == false) goto L16;
            Table.Cell r11 = (Table.Cell) r10;
            if (Objects.equal(getRowKey(), r11.getRowKey()) == false) goto L15;
            if (Objects.equal(getColumnKey(), r11.getColumnKey()) == false) goto L15;
            if (Objects.equal(getValue(), r11.getValue()) == false) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return Objects.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        private final C columnKey;

        @NullableDecl
        private final R rowKey;

        @NullableDecl
        private final V value;

        public ImmutableCell(@NullableDecl R r10, @NullableDecl C r11, @NullableDecl V r12) {
            this.rowKey = r10;
            this.columnKey = r11;
            this.value = r12;
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return this.value;
        }
    }

    public static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
        final Table<R, C, V1> fromTable;
        final Function<? super V1, V2> function;

        public TransformedTable(Table<R, C, V1> r10, Function<? super V1, V2> r11) {
            this.fromTable = (Table) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
        }

        public Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.AbstractTable
        public Iterator<Table.Cell<R, C, V2>> cellIterator() {
            return Iterators.transform(this.fromTable.cellSet().iterator(), cellFunction());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.fromTable.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<R, V2> column(C r10) {
            return Maps.transformValues(this.fromTable.column(r10), this.function);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return this.fromTable.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V2>> columnMap() {
            Function<Map<R, V1>, Map<R, V2>> r10 = new AnonymousClass3(this);
            return Maps.transformValues(this.fromTable.columnMap(), r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(Object r10, Object r11) {
            return this.fromTable.contains(r10, r11);
        }

        @Override // com.google.common.collect.AbstractTable
        public Collection<V2> createValues() {
            return Collections2.transform(this.fromTable.values(), this.function);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 get(Object r10, Object r11) {
            if (contains(r10, r11) == true) goto L7;
            return null;
        L7:
            return this.function.apply(this.fromTable.get(r10, r11));
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 put(R r10, C r11, V2 r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V2> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V2 remove(Object r10, Object r11) {
            if (contains(r10, r11) == true) goto L7;
            return null;
        L7:
            return this.function.apply(this.fromTable.remove(r10, r11));
        }

        @Override // com.google.common.collect.Table
        public Map<C, V2> row(R r10) {
            return Maps.transformValues(this.fromTable.row(r10), this.function);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return this.fromTable.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V2>> rowMap() {
            Function<Map<C, V1>, Map<C, V2>> r10 = new AnonymousClass2(this);
            return Maps.transformValues(this.fromTable.rowMap(), r10);
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.fromTable.size();
        }
    }

    public static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
        private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = null;
        final Table<R, C, V> original;

        static {
            TRANSPOSE_CELL = new AnonymousClass1();
        }

        public TransposeTable(Table<R, C, V> r10) {
            this.original = (Table) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.collect.AbstractTable
        public Iterator<Table.Cell<C, R, V>> cellIterator() {
            return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.original.clear();
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> column(R r10) {
            return this.original.row(r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<R> columnKeySet() {
            return this.original.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> columnMap() {
            return this.original.rowMap();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
            return this.original.contains(r11, r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object r10) {
            return this.original.containsRow(r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object r10) {
            return this.original.containsColumn(r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object r10) {
            return this.original.containsValue(r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
            return this.original.get(r11, r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V put(C r10, R r11, V r12) {
            return this.original.put(r11, r10, r12);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void putAll(Table<? extends C, ? extends R, ? extends V> r10) {
            this.original.putAll(Tables.transpose(r10));
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public V remove(@NullableDecl Object r10, @NullableDecl Object r11) {
            return this.original.remove(r11, r10);
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> row(C r10) {
            return this.original.column(r10);
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Set<C> rowKeySet() {
            return this.original.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> rowMap() {
            return this.original.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.original.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Collection<V> values() {
            return this.original.values();
        }
    }

    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> r10) {
            super(r10);
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Table delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public /* bridge */ /* synthetic */ Set rowKeySet() {
            return rowKeySet();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public /* bridge */ /* synthetic */ Map rowMap() {
            return rowMap();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedMap<R, Map<C, V>> rowMap() {
            Function r10 = Tables.access$000();
            return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), r10));
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }
    }

    public static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> r10) {
            this.delegate = (Table) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C r10) {
            return Collections.unmodifiableMap(super.column(r10));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Function r10 = Tables.access$000();
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), r10));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V put(@NullableDecl R r10, @NullableDecl C r11, @NullableDecl V r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public V remove(@NullableDecl Object r10, @NullableDecl Object r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r10) {
            return Collections.unmodifiableMap(super.row(r10));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Function r10 = Tables.access$000();
            return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), r10));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public Table<R, C, V> delegate() {
            return this.delegate;
        }
    }

    static {
        UNMODIFIABLE_WRAPPER = new AnonymousClass1();
    }

    private Tables() {
    }

    public static /* synthetic */ Function access$000() {
        return unmodifiableWrapper();
    }

    public static boolean equalsImpl(Table<?, ?, ?> r10, @NullableDecl Object r11) {
        if (r11 != r10) goto L6;
        return true;
    L6:
        if ((r11 instanceof Table) == true) goto L8;
        return false;
    L8:
        return r10.cellSet().equals(((Table) r11).cellSet());
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(@NullableDecl R r10, @NullableDecl C r11, @NullableDecl V r12) {
        return new ImmutableCell(r10, r11, r12);
    }

    @Beta
    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> r10, Supplier<? extends Map<C, V>> r11) {
        Preconditions.checkArgument(r10.isEmpty());
        Preconditions.checkNotNull(r11);
        return new StandardTable(r10, r11);
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> r10) {
        return Synchronized.table(r10, null);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> r10, Function<? super V1, V2> r11) {
        return new TransformedTable(r10, r11);
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> r10) {
        if ((r10 instanceof TransposeTable) == false) goto L6;
        return ((TransposeTable) r10).original;
    L6:
        return new TransposeTable(r10);
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> r10) {
        return new UnmodifiableRowSortedMap(r10);
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> r10) {
        return new UnmodifiableTable(r10);
    }

    private static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
        return (Function<Map<K, V>, Map<K, V>>) UNMODIFIABLE_WRAPPER;
    }
}
