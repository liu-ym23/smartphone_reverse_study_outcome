package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: com.google.common.collect.StandardRowSortedTable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class RowSortedMap extends StandardTable<R, C, V>.RowMap implements SortedMap<R, Map<C, V>> {
        final /* synthetic */ StandardRowSortedTable this$0;

        private RowSortedMap(StandardRowSortedTable r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.access$100(this.this$0).comparator();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public /* bridge */ /* synthetic */ Set createKeySet() {
            return createKeySet();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.access$100(this.this$0).firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r10) {
            Preconditions.checkNotNull(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).headMap(r10), this.this$0.factory).rowMap();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return keySet();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.access$100(this.this$0).lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r10, R r11) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).subMap(r10, r11), this.this$0.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r10) {
            Preconditions.checkNotNull(r10);
            return new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).tailMap(r10), this.this$0.factory).rowMap();
        }

        public /* synthetic */ RowSortedMap(StandardRowSortedTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<R> createKeySet() {
            return new Maps.SortedKeySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }
    }

    public StandardRowSortedTable(SortedMap<R, Map<C, V>> r10, Supplier<? extends Map<C, V>> r11) {
        super(r10, r11);
    }

    public static /* synthetic */ SortedMap access$100(StandardRowSortedTable r10) {
        return r10.sortedBackingMap();
    }

    private SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map createRowMap() {
        return createRowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    @Override // com.google.common.collect.StandardTable
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new RowSortedMap(this, null);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
