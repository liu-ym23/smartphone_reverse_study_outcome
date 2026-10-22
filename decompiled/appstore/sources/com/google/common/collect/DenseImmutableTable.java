package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"R", "C", "V"})
@GwtCompatible
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    /* JADX INFO: renamed from: com.google.common.collect.DenseImmutableTable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        public Column(DenseImmutableTable r10, int r11) {
            this.this$0 = r10;
            super(DenseImmutableTable.access$500(r10)[r11]);
            this.columnIndex = r11;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int r10) {
            return (V) DenseImmutableTable.access$400(this.this$0)[r10][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }
    }

    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        public /* synthetic */ ColumnMap(DenseImmutableTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r10) {
            return getValue(r10);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        private ColumnMap(DenseImmutableTable r10) {
            this.this$0 = r10;
            super(DenseImmutableTable.access$500(r10).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int r10) {
            return new Column(this.this$0, r10);
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        public ImmutableArrayMap(int r10) {
            this.size = r10;
        }

        private boolean isFull() {
            if (this.size != keyToIndex().size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            if (isFull() == false) goto L6;
            return keyToIndex().keySet();
        L6:
            return super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(@NullableDecl Object r10) {
            Integer r11 = keyToIndex().get(r10);
            if (r11 != null) goto L6;
            return null;
        L6:
            return getValue(r11.intValue());
        }

        public K getKey(int r10) {
            return keyToIndex().keySet().asList().get(r10);
        }

        @NullableDecl
        public abstract V getValue(int r10);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    public final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        public Row(DenseImmutableTable r10, int r11) {
            this.this$0 = r10;
            super(DenseImmutableTable.access$200(r10)[r11]);
            this.rowIndex = r11;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int r10) {
            return (V) DenseImmutableTable.access$400(this.this$0)[this.rowIndex][r10];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }
    }

    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        public /* synthetic */ RowMap(DenseImmutableTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r10) {
            return getValue(r10);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        private RowMap(DenseImmutableTable r10) {
            this.this$0 = r10;
            super(DenseImmutableTable.access$200(r10).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int r10) {
            return new Row(this.this$0, r10);
        }
    }

    public DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        int r13 = 0;
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r11.size(), r12.size()}));
        ImmutableMap<R, Integer> r14 = Maps.indexMap(r11);
        this.rowKeyToIndex = r14;
        ImmutableMap<C, Integer> r15 = Maps.indexMap(r12);
        this.columnKeyToIndex = r15;
        this.rowCounts = new int[r14.size()];
        this.columnCounts = new int[r15.size()];
        int[] r16 = new int[r10.size()];
        int[] r17 = new int[r10.size()];
    L4:
        if (r13 >= r10.size()) goto L6;
        Table.Cell<R, C, V> r18 = r10.get(r13);
        R r19 = r18.getRowKey();
        C r20 = r18.getColumnKey();
        int r21 = this.rowKeyToIndex.get(r19).intValue();
        int r22 = this.columnKeyToIndex.get(r20).intValue();
        checkNoDuplicate(r19, r20, this.values[r21][r22], r18.getValue());
        this.values[r21][r22] = r18.getValue();
        int[] r23 = this.rowCounts;
        r23[r21] = r23[r21] + 1;
        int[] r24 = this.columnCounts;
        r24[r22] = r24[r22] + 1;
        r16[r13] = r21;
        r17[r13] = r22;
        r13 = r13 + 1;
        goto L4
    L6:
        this.cellRowIndices = r16;
        this.cellColumnIndices = r17;
        AnonymousClass1 r110 = null;
        this.rowMap = new RowMap(this, r110);
        this.columnMap = new ColumnMap(this, r110);
    }

    public static /* synthetic */ int[] access$200(DenseImmutableTable r10) {
        return r10.rowCounts;
    }

    public static /* synthetic */ ImmutableMap access$300(DenseImmutableTable r10) {
        return r10.columnKeyToIndex;
    }

    public static /* synthetic */ Object[][] access$400(DenseImmutableTable r10) {
        return r10.values;
    }

    public static /* synthetic */ int[] access$500(DenseImmutableTable r10) {
        return r10.columnCounts;
    }

    public static /* synthetic */ ImmutableMap access$600(DenseImmutableTable r10) {
        return r10.rowKeyToIndex;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
        Integer r12 = this.rowKeyToIndex.get(r10);
        Integer r13 = this.columnKeyToIndex.get(r11);
        if (r12 == null) goto L7;
        if (r13 == null) goto L7;
        return this.values[r12.intValue()][r13.intValue()];
    L7:
        return null;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public Table.Cell<R, C, V> getCell(int r10) {
        int r11 = this.cellRowIndices[r10];
        int r12 = this.cellColumnIndices[r10];
        return ImmutableTable.cellOf(rowKeySet().asList().get(r11), columnKeySet().asList().get(r12), this.values[r11][r12]);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r10) {
        return this.values[this.cellRowIndices[r10]][this.cellColumnIndices[r10]];
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }
}
