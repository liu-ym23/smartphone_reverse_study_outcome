package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, Map<C, V>> rowMap;
    private final V[][] values;

    /* JADX INFO: renamed from: com.google.common.collect.DenseImmutableTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return true;
        }

        Column(DenseImmutableTable r1, int r2) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$500(r1)[r2]);
            this.columnIndex = r2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        V getValue(int r2) {
            return (V) DenseImmutableTable.access$400(this.this$0)[r2][this.columnIndex];
        }
    }

    private final class ColumnMap extends ImmutableArrayMap<C, Map<R, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        /* synthetic */ ColumnMap(DenseImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        private ColumnMap(DenseImmutableTable r1) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$500(r1).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        Map<R, V> getValue(int r2) {
            return new Column(this.this$0, r2);
        }
    }

    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap<K, V> {
        private final int size;

        @Nullable
        abstract V getValue(int r1);

        abstract ImmutableMap<K, Integer> keyToIndex();

        ImmutableArrayMap(int r1) {
            this.size = r1;
        }

        private boolean isFull() {
            if (this.size != keyToIndex().size()) goto L5;
            return true;
        L5:
            return false;
        }

        K getKey(int r1) {
            return keyToIndex().keySet().asList().get(r1);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<K> createKeySet() {
            if (isFull() == false) goto L6;
            return keyToIndex().keySet();
        L6:
            return super.createKeySet();
        }

        @Override // java.util.Map
        public int size() {
            return this.size;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(@Nullable Object r2) {
            Integer r3 = keyToIndex().get(r2);
            if (r3 != null) goto L6;
            return null;
        L6:
            return getValue(r3.intValue());
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new AnonymousClass1(this);
        }
    }

    private final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return true;
        }

        Row(DenseImmutableTable r1, int r2) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$200(r1)[r2]);
            this.rowIndex = r2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.access$300(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        V getValue(int r2) {
            return (V) DenseImmutableTable.access$400(this.this$0)[this.rowIndex][r2];
        }
    }

    private final class RowMap extends ImmutableArrayMap<R, Map<C, V>> {
        final /* synthetic */ DenseImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        /* synthetic */ RowMap(DenseImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* bridge */ /* synthetic */ Object getValue(int r1) {
            return getValue(r1);
        }

        private RowMap(DenseImmutableTable r1) {
            this.this$0 = r1;
            super(DenseImmutableTable.access$200(r1).length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.access$600(this.this$0);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        Map<C, V> getValue(int r2) {
            return new Row(this.this$0, r2);
        }
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    static /* synthetic */ int[] access$200(DenseImmutableTable r0) {
        return r0.rowCounts;
    }

    static /* synthetic */ ImmutableMap access$300(DenseImmutableTable r0) {
        return r0.columnKeyToIndex;
    }

    static /* synthetic */ Object[][] access$400(DenseImmutableTable r0) {
        return r0.values;
    }

    static /* synthetic */ int[] access$500(DenseImmutableTable r0) {
        return r0.columnCounts;
    }

    static /* synthetic */ ImmutableMap access$600(DenseImmutableTable r0) {
        return r0.rowKeyToIndex;
    }

    private static <E> ImmutableMap<E, Integer> makeIndex(ImmutableSet<E> r4) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        UnmodifiableIterator<E> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.put(r5.next(), Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.build();
    }

    DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> r12, ImmutableSet<R> r13, ImmutableSet<C> r14) {
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r13.size(), r14.size()}));
        ImmutableMap<R, Integer> r15 = makeIndex(r13);
        this.rowKeyToIndex = r15;
        ImmutableMap<C, Integer> r16 = makeIndex(r14);
        this.columnKeyToIndex = r16;
        this.rowCounts = new int[r15.size()];
        this.columnCounts = new int[r16.size()];
        int[] r17 = new int[r12.size()];
        int[] r18 = new int[r12.size()];
        int r0 = 0;
    L4:
        if (r0 >= r12.size()) goto L10;
        Table.Cell<R, C, V> r3 = r12.get(r0);
        R r5 = r3.getRowKey();
        C r6 = r3.getColumnKey();
        int r7 = this.rowKeyToIndex.get(r5).intValue();
        int r8 = this.columnKeyToIndex.get(r6).intValue();
        if (this.values[r7][r8] != null) goto L8;
        boolean r9 = true;
    L9:
        Preconditions.checkArgument(r9, "duplicate key: (%s, %s)", new Object[]{r5, r6});
        this.values[r7][r8] = r3.getValue();
        int[] r4 = this.rowCounts;
        r4[r7] = r4[r7] + 1;
        int[] r10 = this.columnCounts;
        r10[r8] = r10[r8] + 1;
        r17[r0] = r7;
        r18[r0] = r8;
        r0 = r0 + 1;
        goto L4
    L8:
        r9 = false;
        goto L9
    L10:
        this.iterationOrderRow = r17;
        this.iterationOrderColumn = r18;
        AnonymousClass1 r19 = null;
        this.rowMap = new RowMap(this, r19);
        this.columnMap = new ColumnMap(this, r19);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@Nullable Object r2, @Nullable Object r3) {
        Integer r4 = this.rowKeyToIndex.get(r2);
        Integer r5 = this.columnKeyToIndex.get(r3);
        if (r4 == null) goto L7;
        if (r5 == null) goto L7;
        return this.values[r4.intValue()][r5.intValue()];
    L7:
        return null;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell<R, C, V> getCell(int r4) {
        int r0 = this.iterationOrderRow[r4];
        int r5 = this.iterationOrderColumn[r4];
        return cellOf(rowKeySet().asList().get(r0), columnKeySet().asList().get(r5), this.values[r0][r5]);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int r3) {
        return this.values[this.iterationOrderRow[r3]][this.iterationOrderColumn[r3]];
    }
}
