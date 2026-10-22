package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        Factory(Comparator<? super C> r1) {
            this.comparator = r1;
        }

        @Override // com.google.common.base.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap(this.comparator);
        }
    }

    private class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {

        @Nullable
        final C lowerBound;
        final /* synthetic */ TreeBasedTable this$0;

        @Nullable
        final C upperBound;
        transient SortedMap<C, V> wholeRow;

        @Override // com.google.common.collect.StandardTable.Row
        /* bridge */ /* synthetic */ Map backingRowMap() {
            return backingRowMap();
        }

        @Override // com.google.common.collect.StandardTable.Row
        /* bridge */ /* synthetic */ Map computeBackingRowMap() {
            return computeBackingRowMap();
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        TreeRow(TreeBasedTable r2, R r3) {
            this(r2, r3, null, null);
        }

        TreeRow(TreeBasedTable r1, @Nullable R r2, @Nullable C r3, C r4) {
            this.this$0 = r1;
            super(r1, r2);
            this.lowerBound = r3;
            this.upperBound = r4;
            if (r3 == null) goto L9;
            if (r4 == null) goto L9;
            if (compare(r3, r4) <= 0) goto L9;
            boolean r0 = false;
        L10:
            Preconditions.checkArgument(r0);
            return;
        L9:
            r0 = true;
            goto L10
        }

        @Override // com.google.common.collect.Maps.ImprovedAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return this.this$0.columnComparator();
        }

        int compare(Object r1, Object r2) {
            return comparator().compare(r1, r2);
        }

        boolean rangeContains(@Nullable Object r2) {
            if (r2 == null) goto L12;
            C r0 = this.lowerBound;
            if (r0 != null) goto L6;
        L7:
            C r1 = this.upperBound;
            if (r1 != null) goto L10;
        L11:
            return true;
        L10:
            if (compare(r1, r2) <= 0) goto L12;
        L6:
            if (compare(r0, r2) <= 0) goto L7;
        L12:
            return false;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C r3, C r4) {
            if (rangeContains(Preconditions.checkNotNull(r3)) == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0);
            return new TreeRow(this.this$0, this.rowKey, r3, r4);
        L5:
            if (rangeContains(Preconditions.checkNotNull(r4)) == false) goto L7;
            r0 = true;
            goto L8
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C r4) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r4)));
            return new TreeRow(this.this$0, this.rowKey, this.lowerBound, r4);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C r4) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r4)));
            return new TreeRow(this.this$0, this.rowKey, r4, this.upperBound);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (backingRowMap() == null) goto L7;
            return backingRowMap().firstKey();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (backingRowMap() == null) goto L7;
            return backingRowMap().lastKey();
        L7:
            throw new NoSuchElementException();
        }

        SortedMap<C, V> wholeRow() {
            SortedMap<C, V> r0 = this.wholeRow;
            if (r0 != null) goto L5;
        L8:
            this.wholeRow = (SortedMap) this.this$0.backingMap.get(this.rowKey);
        L10:
            return this.wholeRow;
        L5:
            if (r0.isEmpty() == false) goto L10;
            if (this.this$0.backingMap.containsKey(this.rowKey) == false) goto L10;
            goto L8
        }

        @Override // com.google.common.collect.StandardTable.Row
        SortedMap<C, V> backingRowMap() {
            return (SortedMap) super.backingRowMap();
        }

        @Override // com.google.common.collect.StandardTable.Row
        SortedMap<C, V> computeBackingRowMap() {
            SortedMap<C, V> r0 = wholeRow();
            if (r0 == null) goto L11;
            C r1 = this.lowerBound;
            if (r1 == null) goto L7;
            r0 = r0.tailMap(r1);
        L7:
            C r2 = this.upperBound;
            if (r2 != null) goto L10;
            return r0;
        L10:
            return r0.headMap(r2);
        L11:
            return null;
        }

        @Override // com.google.common.collect.StandardTable.Row
        void maintainEmptyInvariant() {
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
        public boolean containsKey(Object r2) {
            if (rangeContains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (super.containsKey(r2) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public V put(C r2, V r3) {
            Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(r2)));
            return (V) super.put(r2, r3);
        }
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
    public /* bridge */ /* synthetic */ Map column(Object r1) {
        return super.column(r1);
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
    public /* bridge */ /* synthetic */ boolean contains(@Nullable Object r1, @Nullable Object r2) {
        return super.contains(r1, r2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@Nullable Object r1) {
        return super.containsColumn(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@Nullable Object r1) {
        return super.containsRow(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@Nullable Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@Nullable Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@Nullable Object r1, @Nullable Object r2) {
        return super.get(r1, r2);
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
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2, Object r3) {
        return super.put(r1, r2, r3);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table r1) {
        super.putAll(r1);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object remove(@Nullable Object r1, @Nullable Object r2) {
        return super.remove(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object r1) {
        return row(r1);
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

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> r1, Comparator<? super C> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new TreeBasedTable(r1, r2);
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> r3) {
        TreeBasedTable<R, C, V> r0 = new TreeBasedTable(r3.rowComparator(), r3.columnComparator());
        r0.putAll(r3);
        return r0;
    }

    TreeBasedTable(Comparator<? super R> r2, Comparator<? super C> r3) {
        super(new TreeMap(r2), new Factory(r3));
        this.columnComparator = r3;
    }

    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<C, V> row(R r2) {
        return new TreeRow(this, r2);
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable
    Iterator<C> createColumnKeyIterator() {
        final Comparator<? super C> r0 = columnComparator();
        final UnmodifiableIterator r1 = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new AnonymousClass1(this)), r0);
        return new AnonymousClass2(this, r1, r0);
    }
}
