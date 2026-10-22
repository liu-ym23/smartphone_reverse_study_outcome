package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible(emulated = true)
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        public /* synthetic */ ArrayMap(ImmutableMap r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object r10) {
            return this.keyIndex.containsKey(r10);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<K, V>> entryIterator() {
            final int r10 = size();
            return new AnonymousClass2(this, r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object r10) {
            Integer r11 = this.keyIndex.get(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return getValue(r11.intValue());
        }

        public Map.Entry<K, V> getEntry(final int r10) {
            Preconditions.checkElementIndex(r10, size());
            return new AnonymousClass1(this, r10);
        }

        public K getKey(int r10) {
            return this.keyIndex.keySet().asList().get(r10);
        }

        public abstract String getKeyRole();

        @NullableDecl
        public abstract V getValue(int r10);

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r10, V r11) {
            Integer r12 = this.keyIndex.get(r10);
            if (r12 == null) goto L7;
            return setValue(r12.intValue(), r11);
        L7:
            throw new IllegalArgumentException(getKeyRole() + " " + r10 + " not in " + this.keyIndex.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r10) {
            throw new UnsupportedOperationException();
        }

        @NullableDecl
        public abstract V setValue(int r10, V r11);

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.keyIndex.size();
        }

        private ArrayMap(ImmutableMap<K, Integer> r10) {
            this.keyIndex = r10;
        }
    }

    public class Column extends ArrayMap<R, V> {
        final int columnIndex;
        final /* synthetic */ ArrayTable this$0;

        public Column(ArrayTable r10, int r11) {
            this.this$0 = r10;
            super(ArrayTable.access$300(r10), null);
            this.columnIndex = r11;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V getValue(int r10) {
            return (V) this.this$0.at(r10, this.columnIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V setValue(int r10, V r11) {
            return (V) this.this$0.set(r10, this.columnIndex, r11);
        }
    }

    public class ColumnMap extends ArrayMap<C, Map<R, V>> {
        final /* synthetic */ ArrayTable this$0;

        public /* synthetic */ ColumnMap(ArrayTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r10) {
            return getValue(r10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
            return put(r10, (Map) r11);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public /* bridge */ /* synthetic */ Object setValue(int r10, Object r11) {
            return setValue(r10, (Map) r11);
        }

        private ColumnMap(ArrayTable r10) {
            this.this$0 = r10;
            super(ArrayTable.access$600(r10), null);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<R, V> getValue(int r10) {
            return new Column(this.this$0, r10);
        }

        public Map<R, V> put(C r10, Map<R, V> r11) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> setValue(int r10, Map<R, V> r11) {
            throw new UnsupportedOperationException();
        }
    }

    public class Row extends ArrayMap<C, V> {
        final int rowIndex;
        final /* synthetic */ ArrayTable this$0;

        public Row(ArrayTable r10, int r11) {
            this.this$0 = r10;
            super(ArrayTable.access$600(r10), null);
            this.rowIndex = r11;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V getValue(int r10) {
            return (V) this.this$0.at(this.rowIndex, r10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public V setValue(int r10, V r11) {
            return (V) this.this$0.set(this.rowIndex, r10, r11);
        }
    }

    public class RowMap extends ArrayMap<R, Map<C, V>> {
        final /* synthetic */ ArrayTable this$0;

        public /* synthetic */ RowMap(ArrayTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public String getKeyRole() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public /* bridge */ /* synthetic */ Object getValue(int r10) {
            return getValue(r10);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
            return put(r10, (Map) r11);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public /* bridge */ /* synthetic */ Object setValue(int r10, Object r11) {
            return setValue(r10, (Map) r11);
        }

        private RowMap(ArrayTable r10) {
            this.this$0 = r10;
            super(ArrayTable.access$300(r10), null);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<C, V> getValue(int r10) {
            return new Row(this.this$0, r10);
        }

        public Map<C, V> put(R r10, Map<C, V> r11) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> setValue(int r10, Map<C, V> r11) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(Iterable<? extends R> r10, Iterable<? extends C> r11) {
        ImmutableList<R> r12 = ImmutableList.copyOf(r10);
        this.rowList = r12;
        ImmutableList<C> r13 = ImmutableList.copyOf(r11);
        this.columnList = r13;
        if (r12.isEmpty() != r13.isEmpty()) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14);
        this.rowKeyToIndex = Maps.indexMap(r12);
        this.columnKeyToIndex = Maps.indexMap(r13);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r12.size(), r13.size()}));
        eraseAll();
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static /* synthetic */ Table.Cell access$000(ArrayTable r10, int r11) {
        return r10.getCell(r11);
    }

    public static /* synthetic */ ImmutableList access$100(ArrayTable r10) {
        return r10.columnList;
    }

    public static /* synthetic */ ImmutableList access$200(ArrayTable r10) {
        return r10.rowList;
    }

    public static /* synthetic */ ImmutableMap access$300(ArrayTable r10) {
        return r10.rowKeyToIndex;
    }

    public static /* synthetic */ ImmutableMap access$600(ArrayTable r10) {
        return r10.columnKeyToIndex;
    }

    public static /* synthetic */ Object access$800(ArrayTable r10, int r11) {
        return r10.getValue(r11);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> r10, Iterable<? extends C> r11) {
        return new ArrayTable(r10, r11);
    }

    private Table.Cell<R, C, V> getCell(final int r10) {
        return new AnonymousClass2(this, r10);
    }

    private V getValue(int r10) {
        return at(r10 / this.columnList.size(), r10 % this.columnList.size());
    }

    public V at(int r10, int r11) {
        Preconditions.checkElementIndex(r10, this.rowList.size());
        Preconditions.checkElementIndex(r11, this.columnList.size());
        return this.array[r10][r11];
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        final int r10 = size();
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C r10) {
        Preconditions.checkNotNull(r10);
        Integer r11 = this.columnKeyToIndex.get(r10);
        if (r11 != null) goto L6;
        return ImmutableMap.of();
    L6:
        return new Column(this, r11.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap r10 = this.columnMap;
        if (r10 != null) goto L6;
        ArrayTable<R, C, V>.ColumnMap r11 = new ColumnMap(this, null);
        this.columnMap = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (containsRow(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (containsColumn(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object r10) {
        return this.columnKeyToIndex.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object r10) {
        return this.rowKeyToIndex.containsKey(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object r10) {
        V[][] r11 = this.array;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        V[] r14 = r11[r13];
        int r15 = r14.length;
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L11;
        if (Objects.equal(r10, r14[r16]) == true) goto L8;
        r16 = r16 + 1;
        goto L5
    L8:
        return true;
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object r10, @NullableDecl Object r11) {
        Integer r12 = this.rowKeyToIndex.get(r10);
        Integer r13 = this.columnKeyToIndex.get(r11);
        if (r12 == null) goto L8;
        if (r13 == null) goto L8;
        return set(r12.intValue(), r13.intValue(), null);
    L8:
        return null;
    }

    public void eraseAll() {
        V[][] r10 = this.array;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Arrays.fill(r10[r12], null);
        r12 = r12 + 1;
        goto L3
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
        Integer r12 = this.rowKeyToIndex.get(r10);
        Integer r13 = this.columnKeyToIndex.get(r11);
        if (r12 == null) goto L7;
        if (r13 == null) goto L7;
        return at(r12.intValue(), r13.intValue());
    L7:
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        if (this.rowList.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.columnList.isEmpty() == true) goto L8;
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r10, C r11, @NullableDecl V r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Integer r13 = this.rowKeyToIndex.get(r10);
        boolean r14 = false;
        if (r13 == null) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15, "Row %s not in %s", r10, this.rowList);
        Integer r16 = this.columnKeyToIndex.get(r11);
        if (r16 == null) goto L9;
        r14 = true;
    L9:
        Preconditions.checkArgument(r14, "Column %s not in %s", r11, this.columnList);
        return set(r13.intValue(), r16.intValue(), r12);
    L5:
        r15 = false;
        goto L6
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> r10) {
        super.putAll(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object r10, Object r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r10) {
        Preconditions.checkNotNull(r10);
        Integer r11 = this.rowKeyToIndex.get(r10);
        if (r11 != null) goto L6;
        return ImmutableMap.of();
    L6:
        return new Row(this, r11.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap r10 = this.rowMap;
        if (r10 != null) goto L6;
        ArrayTable<R, C, V>.RowMap r11 = new RowMap(this, null);
        this.rowMap = r11;
        return r11;
    L6:
        return r10;
    }

    @CanIgnoreReturnValue
    public V set(int r10, int r11, @NullableDecl V r12) {
        Preconditions.checkElementIndex(r10, this.rowList.size());
        Preconditions.checkElementIndex(r11, this.columnList.size());
        V[] r13 = this.array[r10];
        V r14 = r13[r11];
        r13[r11] = r12;
        return r14;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> r10) {
        V[][] r11 = (V[][]) ((Object[][]) Array.newInstance(r10, new int[]{this.rowList.size(), this.columnList.size()}));
        int r12 = 0;
    L4:
        if (r12 >= this.rowList.size()) goto L6;
        V[] r13 = this.array[r12];
        System.arraycopy(r13, 0, r11[r12], 0, r13.length);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<V> valuesIterator() {
        final int r10 = size();
        return new AnonymousClass3(this, r10);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> r10) {
        if ((r10 instanceof ArrayTable) == false) goto L6;
        return new ArrayTable((ArrayTable) r10);
    L6:
        return new ArrayTable(r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, V> r10) {
        this(r10.rowKeySet(), r10.columnKeySet());
        putAll(r10);
    }

    private ArrayTable(ArrayTable<R, C, V> r10) {
        ImmutableList<R> r11 = r10.rowList;
        this.rowList = r11;
        ImmutableList<C> r12 = r10.columnList;
        this.columnList = r12;
        this.rowKeyToIndex = r10.rowKeyToIndex;
        this.columnKeyToIndex = r10.columnKeyToIndex;
        V[][] r13 = (V[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{r11.size(), r12.size()}));
        this.array = r13;
        int r14 = 0;
    L4:
        if (r14 >= this.rowList.size()) goto L6;
        V[] r15 = r10.array[r14];
        System.arraycopy(r15, 0, r13[r14], 0, r15.length);
        r14 = r14 + 1;
        goto L4
    }
}
