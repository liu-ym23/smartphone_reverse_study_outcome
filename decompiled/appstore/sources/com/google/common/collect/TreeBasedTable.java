package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> r10) {
            this.comparator = r10;
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }

    public class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {

        @NullableDecl
        final C lowerBound;
        final /* synthetic */ TreeBasedTable this$0;

        @NullableDecl
        final C upperBound;

        @NullableDecl
        transient SortedMap<C, V> wholeRow;

        public TreeRow(TreeBasedTable r10, R r11) {
            this(r10, r11, null, null);
        }

        @Override // com.google.common.collect.StandardTable.Row
        public /* bridge */ /* synthetic */ Map backingRowMap() {
            return backingRowMap();
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return this.this$0.columnComparator();
        }

        public int compare(Object r10, Object r11) {
            return comparator().compare(r10, r11);
        }

        @Override // com.google.common.collect.StandardTable.Row
        public /* bridge */ /* synthetic */ Map computeBackingRowMap() {
            return computeBackingRowMap();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            if (rangeContains(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (super.containsKey(r10) == false) goto L7;
            return true;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (backingRowMap() == null) goto L7;
            return backingRowMap().firstKey();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C r10) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r10)));
            return new TreeRow(this.this$0, this.rowKey, this.lowerBound, r10);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (backingRowMap() == null) goto L7;
            return backingRowMap().lastKey();
        L7:
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row
        public void maintainEmptyInvariant() {
            if (wholeRow() != null) goto L5;
            return;
        L5:
            if (this.wholeRow.isEmpty() == false) goto L9;
            this.this$0.backingMap.remove(this.rowKey);
            this.wholeRow = null;
            this.backingRowMap = null;
            return;
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public V put(C r10, V r11) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r10)));
            return (V) super.put(r10, r11);
        }

        public boolean rangeContains(@NullableDecl Object r10) {
            if (r10 == null) goto L12;
            C r11 = this.lowerBound;
            if (r11 != null) goto L6;
        L7:
            C r12 = this.upperBound;
            if (r12 != null) goto L10;
        L11:
            return true;
        L10:
            if (compare(r12, r10) <= 0) goto L12;
        L6:
            if (compare(r11, r10) <= 0) goto L7;
        L12:
            return false;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C r10, C r11) {
            if (rangeContains(Preconditions.checkNotNull(r10)) == true) goto L5;
        L7:
            boolean r12 = false;
        L8:
            Preconditions.checkArgument(r12);
            return new TreeRow(this.this$0, this.rowKey, r10, r11);
        L5:
            if (rangeContains(Preconditions.checkNotNull(r11)) == false) goto L7;
            r12 = true;
            goto L8
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C r10) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r10)));
            return new TreeRow(this.this$0, this.rowKey, r10, this.upperBound);
        }

        public SortedMap<C, V> wholeRow() {
            SortedMap<C, V> r10 = this.wholeRow;
            if (r10 != null) goto L5;
        L8:
            this.wholeRow = (SortedMap) this.this$0.backingMap.get(this.rowKey);
        L10:
            return this.wholeRow;
        L5:
            if (r10.isEmpty() == false) goto L10;
            if (this.this$0.backingMap.containsKey(this.rowKey) == false) goto L10;
            goto L8
        }

        public TreeRow(TreeBasedTable r10, @NullableDecl R r11, @NullableDecl C r12, C r13) {
            this.this$0 = r10;
            super(r10, r11);
            this.lowerBound = r12;
            this.upperBound = r13;
            if (r12 == null) goto L9;
            if (r13 == null) goto L9;
            if (compare(r12, r13) <= 0) goto L9;
            boolean r14 = false;
        L10:
            Preconditions.checkArgument(r14);
            return;
        L9:
            r14 = true;
            goto L10
        }

        @Override // com.google.common.collect.StandardTable.Row
        public SortedMap<C, V> backingRowMap() {
            return (SortedMap) super.backingRowMap();
        }

        @Override // com.google.common.collect.StandardTable.Row
        public SortedMap<C, V> computeBackingRowMap() {
            SortedMap<C, V> r10 = wholeRow();
            if (r10 == null) goto L11;
            C r11 = this.lowerBound;
            if (r11 == null) goto L7;
            r10 = r10.tailMap(r11);
        L7:
            C r12 = this.upperBound;
            if (r12 != null) goto L10;
            return r10;
        L10:
            return r10.headMap(r12);
        L11:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }
    }

    public TreeBasedTable(Comparator<? super R> r10, Comparator<? super C> r11) {
        super(new TreeMap(r10), new Factory(r11));
        this.columnComparator = r11;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object r10) {
        return super.column(r10);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.contains(r10, r11);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object r10) {
        return super.containsColumn(r10);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object r10) {
        return super.containsRow(r10);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object r10) {
        return super.containsValue(r10);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        final Comparator<? super C> r10 = columnComparator();
        final UnmodifiableIterator r11 = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new AnonymousClass1(this)), r10);
        return new AnonymousClass2(this, r11, r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.get(r10, r11);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11, Object r12) {
        return super.put(r10, r11, r12);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table r10) {
        super.putAll(r10);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        return super.remove(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object r10) {
        return row(r10);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> r10, Comparator<? super C> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new TreeBasedTable(r10, r11);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<C, V> row(R r10) {
        return new TreeRow(this, r10);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> r10) {
        TreeBasedTable<R, C, V> r11 = new TreeBasedTable(r10.rowComparator(), r10.columnComparator());
        r11.putAll(r10);
        return r11;
    }
}
