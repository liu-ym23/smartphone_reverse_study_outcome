package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @GwtTransient
    final Map<R, Map<C, V>> backingMap;

    @MonotonicNonNullDecl
    private transient Set<C> columnKeySet;

    @MonotonicNonNullDecl
    private transient StandardTable<R, C, V>.ColumnMap columnMap;

    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;

    @MonotonicNonNullDecl
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: renamed from: com.google.common.collect.StandardTable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CellIterator implements Iterator<Table.Cell<R, C, V>> {
        Iterator<Map.Entry<C, V>> columnIterator;

        @NullableDecl
        Map.Entry<R, Map<C, V>> rowEntry;
        final Iterator<Map.Entry<R, Map<C, V>>> rowIterator;
        final /* synthetic */ StandardTable this$0;

        private CellIterator(StandardTable r10) {
            this.this$0 = r10;
            this.rowIterator = r10.backingMap.entrySet().iterator();
            this.columnIterator = Iterators.emptyModifiableIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.rowIterator.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.columnIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.columnIterator.remove();
            if (this.rowEntry.getValue().isEmpty() == false) goto L6;
            this.rowIterator.remove();
            this.rowEntry = null;
            return;
        }

        @Override // java.util.Iterator
        public Table.Cell<R, C, V> next() {
            if (this.columnIterator.hasNext() == true) goto L5;
            Map.Entry<R, Map<C, V>> r10 = this.rowIterator.next();
            this.rowEntry = r10;
            this.columnIterator = r10.getValue().entrySet().iterator();
        L5:
            Map.Entry<C, V> r11 = this.columnIterator.next();
            return Tables.immutableCell(this.rowEntry.getKey(), r11.getKey(), r11.getValue());
        }

        public /* synthetic */ CellIterator(StandardTable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class Column extends Maps.ViewCachingAbstractMap<R, V> {
        final C columnKey;
        final /* synthetic */ StandardTable this$0;

        public class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            final /* synthetic */ Column this$1;

            private EntrySet(Column r10) {
                this.this$1 = r10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                this.this$1.removeFromColumnIf(Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r10) {
                if ((r10 instanceof Map.Entry) == false) goto L6;
                Map.Entry r11 = (Map.Entry) r10;
                return StandardTable.access$300(this.this$1.this$0, r11.getKey(), this.this$1.columnKey, r11.getValue());
            L6:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                Column r10 = this.this$1;
                return !r10.this$0.containsColumn(r10.columnKey);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator(this.this$1, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if ((r10 instanceof Map.Entry) == false) goto L6;
                Map.Entry r11 = (Map.Entry) r10;
                return StandardTable.access$400(this.this$1.this$0, r11.getKey(), this.this$1.columnKey, r11.getValue());
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r10) {
                return this.this$1.removeFromColumnIf(Predicates.not(Predicates.in(r10)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> r10 = this.this$1.this$0.backingMap.values().iterator();
                int r11 = 0;
            L4:
                if (r10.hasNext() == false) goto L8;
                if (r10.next().containsKey(this.this$1.columnKey) == false) goto L4;
                r11 = r11 + 1;
                goto L4
            L8:
                return r11;
            }

            public /* synthetic */ EntrySet(Column r10, AnonymousClass1 r11) {
                this(r10);
            }
        }

        public class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> iterator;
            final /* synthetic */ Column this$1;

            private EntrySetIterator(Column r10) {
                this.this$1 = r10;
                this.iterator = r10.this$0.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            public /* bridge */ /* synthetic */ Object computeNext() {
                return computeNext();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Map.Entry<R, V> computeNext() {
            L3:
                if (this.iterator.hasNext() == false) goto L9;
                final Map.Entry<R, Map<C, V>> r10 = this.iterator.next();
                if (r10.getValue().containsKey(this.this$1.columnKey) == false) goto L3;
                return new C1EntryImpl(this, r10);
            L9:
                return endOfData();
            }

            public /* synthetic */ EntrySetIterator(Column r10, AnonymousClass1 r11) {
                this(r10);
            }
        }

        public class KeySet extends Maps.KeySet<R, V> {
            final /* synthetic */ Column this$1;

            public KeySet(Column r10) {
                this.this$1 = r10;
                super(r10);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r10) {
                Column r11 = this.this$1;
                return r11.this$0.contains(r10, r11.columnKey);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                Column r11 = this.this$1;
                if (r11.this$0.remove(r10, r11.columnKey) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r10) {
                return this.this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(r10))));
            }
        }

        public class Values extends Maps.Values<R, V> {
            final /* synthetic */ Column this$1;

            public Values(Column r10) {
                this.this$1 = r10;
                super(r10);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object r10) {
                if (r10 != null) goto L4;
            L6:
                return false;
            L4:
                if (this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(r10))) == false) goto L6;
                return true;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r10) {
                return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(r10)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r10) {
                return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(r10))));
            }
        }

        public Column(StandardTable r10, C r11) {
            this.this$0 = r10;
            this.columnKey = (C) Preconditions.checkNotNull(r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return this.this$0.contains(r10, this.columnKey);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<R, V>> createEntrySet() {
            return new EntrySet(this, null);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<R> createKeySet() {
            return new KeySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<V> createValues() {
            return new Values(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r10) {
            return (V) this.this$0.get(r10, this.columnKey);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r10, V r11) {
            return (V) this.this$0.put(r10, this.columnKey, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r10) {
            return (V) this.this$0.remove(r10, this.columnKey);
        }

        @CanIgnoreReturnValue
        public boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> r10) {
            Iterator<Map.Entry<R, Map<C, V>>> r11 = this.this$0.backingMap.entrySet().iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L13;
            Map.Entry<R, Map<C, V>> r13 = r11.next();
            Map<C, V> r14 = r13.getValue();
            V r15 = r14.get(this.columnKey);
            if (r15 == null) goto L4;
            if (r10.apply(Maps.immutableEntry(r13.getKey(), r15)) == false) goto L4;
            r14.remove(this.columnKey);
            if (r14.isEmpty() == false) goto L12;
            r11.remove();
        L12:
            r12 = true;
            goto L4
        L13:
            return r12;
        }
    }

    public class ColumnKeyIterator extends AbstractIterator<C> {
        Iterator<Map.Entry<C, V>> entryIterator;
        final Iterator<Map<C, V>> mapIterator;
        final Map<C, V> seen;
        final /* synthetic */ StandardTable this$0;

        private ColumnKeyIterator(StandardTable r10) {
            this.this$0 = r10;
            this.seen = r10.factory.get();
            this.mapIterator = r10.backingMap.values().iterator();
            this.entryIterator = Iterators.emptyIterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C computeNext() {
        L3:
            if (this.entryIterator.hasNext() == true) goto L4;
            if (this.mapIterator.hasNext() == false) goto L12;
            this.entryIterator = this.mapIterator.next().entrySet().iterator();
            goto L3
        L12:
            return endOfData();
        L4:
            Map.Entry<C, V> r10 = this.entryIterator.next();
            if (this.seen.containsKey(r10.getKey()) == true) goto L3;
            this.seen.put(r10.getKey(), r10.getValue());
            return r10.getKey();
        }

        public /* synthetic */ ColumnKeyIterator(StandardTable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        final /* synthetic */ StandardTable this$0;

        private ColumnKeySet(StandardTable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return this.this$0.containsColumn(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return this.this$0.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            boolean r11 = false;
            if (r10 != null) goto L5;
            return false;
        L5:
            Iterator<Map<C, V>> r12 = this.this$0.backingMap.values().iterator();
        L7:
            if (r12.hasNext() == false) goto L14;
            Map<C, V> r13 = r12.next();
            if (r13.keySet().remove(r10) == false) goto L7;
            if (r13.isEmpty() == false) goto L13;
            r12.remove();
        L13:
            r11 = true;
            goto L7
        L14:
            return r11;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            Preconditions.checkNotNull(r10);
            Iterator<Map<C, V>> r11 = this.this$0.backingMap.values().iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L11;
            Map<C, V> r13 = r11.next();
            if (Iterators.removeAll(r13.keySet().iterator(), r10) == false) goto L4;
            if (r13.isEmpty() == false) goto L10;
            r11.remove();
        L10:
            r12 = true;
            goto L4
        L11:
            return r12;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            Preconditions.checkNotNull(r10);
            Iterator<Map<C, V>> r11 = this.this$0.backingMap.values().iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L11;
            Map<C, V> r13 = r11.next();
            if (r13.keySet().retainAll(r10) == false) goto L4;
            if (r13.isEmpty() == false) goto L10;
            r11.remove();
        L10:
            r12 = true;
            goto L4
        L11:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.size(iterator());
        }

        public /* synthetic */ ColumnKeySet(StandardTable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {
        final /* synthetic */ StandardTable this$0;

        public class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            final /* synthetic */ ColumnMap this$1;

            public ColumnMapEntrySet(ColumnMap r10) {
                this.this$1 = r10;
                super(r10.this$0, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r10) {
                if ((r10 instanceof Map.Entry) == false) goto L8;
                Map.Entry r11 = (Map.Entry) r10;
                if (this.this$1.this$0.containsColumn(r11.getKey()) == false) goto L10;
                Object r12 = r11.getKey();
                return this.this$1.get(r12).equals(r11.getValue());
            L10:
                return false;
            L8:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.asMapEntryIterator(this.this$1.this$0.columnKeySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if (contains(r10) == false) goto L6;
                StandardTable.access$900(this.this$1.this$0, ((Map.Entry) r10).getKey());
                return true;
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> r10) {
                Preconditions.checkNotNull(r10);
                return Sets.removeAllImpl(this, r10.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r10) {
                Preconditions.checkNotNull(r10);
                Iterator r11 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r12 = false;
            L4:
                if (r11.hasNext() == false) goto L8;
                Object r13 = r11.next();
                if (r10.contains(Maps.immutableEntry(r13, this.this$1.this$0.column(r13))) == true) goto L4;
                StandardTable.access$900(this.this$1.this$0, r13);
                r12 = true;
                goto L4
            L8:
                return r12;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.this$1.this$0.columnKeySet().size();
            }
        }

        public class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            final /* synthetic */ ColumnMap this$1;

            public ColumnMapValues(ColumnMap r10) {
                this.this$1 = r10;
                super(r10);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object r10) {
                Iterator<Map.Entry<C, Map<R, V>>> r11 = this.this$1.entrySet().iterator();
            L4:
                if (r11.hasNext() == false) goto L9;
                Map.Entry<C, Map<R, V>> r12 = r11.next();
                if (r12.getValue().equals(r10) == false) goto L4;
                StandardTable.access$900(this.this$1.this$0, r12.getKey());
                return true;
            L9:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r10) {
                Preconditions.checkNotNull(r10);
                Iterator r11 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r12 = false;
            L4:
                if (r11.hasNext() == false) goto L8;
                Object r13 = r11.next();
                if (r10.contains(this.this$1.this$0.column(r13)) == false) goto L4;
                StandardTable.access$900(this.this$1.this$0, r13);
                r12 = true;
                goto L4
            L8:
                return r12;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r10) {
                Preconditions.checkNotNull(r10);
                Iterator r11 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
                boolean r12 = false;
            L4:
                if (r11.hasNext() == false) goto L8;
                Object r13 = r11.next();
                if (r10.contains(this.this$1.this$0.column(r13)) == true) goto L4;
                StandardTable.access$900(this.this$1.this$0, r13);
                r12 = true;
                goto L4
            L8:
                return r12;
            }
        }

        private ColumnMap(StandardTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return this.this$0.containsColumn(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new ColumnMapEntrySet(this);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Collection<Map<R, V>> createValues() {
            return new ColumnMapValues(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return this.this$0.columnKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r10) {
            return remove(r10);
        }

        public /* synthetic */ ColumnMap(StandardTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<R, V> get(Object r10) {
            if (this.this$0.containsColumn(r10) == true) goto L7;
            return null;
        L7:
            return this.this$0.column(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<R, V> remove(Object r10) {
            if (this.this$0.containsColumn(r10) == true) goto L7;
            return null;
        L7:
            return StandardTable.access$900(this.this$0, r10);
        }
    }

    public class Row extends Maps.IteratorBasedAbstractMap<C, V> {

        @NullableDecl
        Map<C, V> backingRowMap;
        final R rowKey;
        final /* synthetic */ StandardTable this$0;

        public Row(StandardTable r10, R r11) {
            this.this$0 = r10;
            this.rowKey = (R) Preconditions.checkNotNull(r11);
        }

        public Map<C, V> backingRowMap() {
            Map<C, V> r10 = this.backingRowMap;
            if (r10 != null) goto L5;
        L10:
            Map<C, V> r11 = computeBackingRowMap();
            this.backingRowMap = r11;
            return r11;
        L5:
            if (r10.isEmpty() == false) goto L12;
            if (this.this$0.backingMap.containsKey(this.rowKey) == true) goto L10;
        L12:
            return this.backingRowMap;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> r10 = backingRowMap();
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            maintainEmptyInvariant();
        }

        public Map<C, V> computeBackingRowMap() {
            return this.this$0.backingMap.get(this.rowKey);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            Map<C, V> r11 = backingRowMap();
            if (r10 == null) goto L8;
            if (r11 == null) goto L8;
            if (Maps.safeContainsKey(r11, r10) == false) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<C, V>> entryIterator() {
            Map<C, V> r10 = backingRowMap();
            if (r10 == null) goto L5;
            final Iterator<Map.Entry<C, V>> r11 = r10.entrySet().iterator();
            return new AnonymousClass1(this, r11);
        L5:
            return Iterators.emptyModifiableIterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r10) {
            Map<C, V> r11 = backingRowMap();
            if (r10 == null) goto L6;
            if (r11 == null) goto L6;
            return (V) Maps.safeGet(r11, r10);
        L6:
            return null;
        }

        public void maintainEmptyInvariant() {
            if (backingRowMap() != null) goto L5;
            return;
        L5:
            if (this.backingRowMap.isEmpty() == false) goto L9;
            this.this$0.backingMap.remove(this.rowKey);
            this.backingRowMap = null;
            return;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C r10, V r11) {
            Preconditions.checkNotNull(r10);
            Preconditions.checkNotNull(r11);
            Map<C, V> r12 = this.backingRowMap;
            if (r12 == null) goto L9;
            if (r12.isEmpty() == true) goto L9;
            return this.backingRowMap.put(r10, r11);
        L9:
            return (V) this.this$0.put(this.rowKey, r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r10) {
            Map<C, V> r11 = backingRowMap();
            if (r11 != null) goto L6;
            return null;
        L6:
            V r12 = (V) Maps.safeRemove(r11, r10);
            maintainEmptyInvariant();
            return r12;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> r10 = backingRowMap();
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.size();
        }

        public Map.Entry<C, V> wrapEntry(final Map.Entry<C, V> r10) {
            return new AnonymousClass2(this, r10);
        }
    }

    public class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {
        final /* synthetic */ StandardTable this$0;

        public class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            final /* synthetic */ RowMap this$1;

            public EntrySet(RowMap r10) {
                this.this$1 = r10;
                super(r10.this$0, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r10) {
                if ((r10 instanceof Map.Entry) == false) goto L12;
                Map.Entry r11 = (Map.Entry) r10;
                if (r11.getKey() != null) goto L7;
                return false;
            L7:
                if ((r11.getValue() instanceof Map) == true) goto L9;
                return false;
            L9:
                if (Collections2.safeContains(this.this$1.this$0.backingMap.entrySet(), r11) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.asMapEntryIterator(this.this$1.this$0.backingMap.keySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r10) {
                if ((r10 instanceof Map.Entry) == false) goto L12;
                Map.Entry r11 = (Map.Entry) r10;
                if (r11.getKey() != null) goto L7;
                return false;
            L7:
                if ((r11.getValue() instanceof Map) == true) goto L9;
                return false;
            L9:
                if (this.this$1.this$0.backingMap.entrySet().remove(r11) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.this$1.this$0.backingMap.size();
            }
        }

        public RowMap(StandardTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r10) {
            return this.this$0.containsRow(r10);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new EntrySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return get(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object remove(Object r10) {
            return remove(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<C, V> get(Object r10) {
            if (this.this$0.containsRow(r10) == true) goto L7;
            return null;
        L7:
            return this.this$0.row(r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<C, V> remove(Object r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            return this.this$0.backingMap.remove(r10);
        }
    }

    public abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        final /* synthetic */ StandardTable this$0;

        private TableSet(StandardTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.this$0.backingMap.isEmpty();
        }

        public /* synthetic */ TableSet(StandardTable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public StandardTable(Map<R, Map<C, V>> r10, Supplier<? extends Map<C, V>> r11) {
        this.backingMap = r10;
        this.factory = r11;
    }

    public static /* synthetic */ boolean access$300(StandardTable r10, Object r11, Object r12, Object r13) {
        return r10.containsMapping(r11, r12, r13);
    }

    public static /* synthetic */ boolean access$400(StandardTable r10, Object r11, Object r12, Object r13) {
        return r10.removeMapping(r11, r12, r13);
    }

    public static /* synthetic */ Map access$900(StandardTable r10, Object r11) {
        return r10.removeColumn(r11);
    }

    private boolean containsMapping(Object r10, Object r11, Object r12) {
        if (r12 != null) goto L4;
    L6:
        return false;
    L4:
        if (r12.equals(get(r10, r11)) == false) goto L6;
        return true;
    }

    private Map<C, V> getOrCreate(R r10) {
        Map<C, V> r11 = this.backingMap.get(r10);
        if (r11 != null) goto L6;
        Map<C, V> r12 = this.factory.get();
        this.backingMap.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    @CanIgnoreReturnValue
    private Map<R, V> removeColumn(Object r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> r12 = this.backingMap.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<R, Map<C, V>> r13 = r12.next();
        V r14 = r13.getValue().remove(r10);
        if (r14 == null) goto L4;
        r11.put(r13.getKey(), r14);
        if (r13.getValue().isEmpty() == false) goto L4;
        r12.remove();
        goto L4
    L10:
        return r11;
    }

    private boolean removeMapping(Object r10, Object r11, Object r12) {
        if (containsMapping(r10, r11, r12) == false) goto L6;
        remove(r10, r11);
        return true;
    L6:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new CellIterator(this, null);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C r10) {
        return new Column(this, r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> r10 = this.columnKeySet;
        if (r10 != null) goto L6;
        ColumnKeySet r11 = new ColumnKeySet(this, null);
        this.columnKeySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.ColumnMap r10 = this.columnMap;
        if (r10 != null) goto L6;
        StandardTable<R, C, V>.ColumnMap r11 = new ColumnMap(this, null);
        this.columnMap = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        if (super.contains(r10, r11) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator<Map<C, V>> r11 = this.backingMap.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (Maps.safeContainsKey(r11.next(), r10) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (Maps.safeContainsKey(this.backingMap, r10) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r10) == false) goto L6;
        return true;
    }

    public Iterator<C> createColumnKeyIterator() {
        return new ColumnKeyIterator(this, null);
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new RowMap(this);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L6;
        return (V) super.get(r10, r11);
    L6:
        return null;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r10, C r11, V r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        return getOrCreate(r10).put(r11, r12);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object r10, @NullableDecl Object r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L13;
        Map r12 = (Map) Maps.safeGet(this.backingMap, r10);
        if (r12 != null) goto L9;
        return null;
    L9:
        V r13 = (V) r12.remove(r11);
        if (r12.isEmpty() == false) goto L12;
        this.backingMap.remove(r10);
    L12:
        return r13;
    L13:
        return null;
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r10) {
        return new Row(this, r10);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> r10 = this.rowMap;
        if (r10 != null) goto L6;
        Map<R, Map<C, V>> r11 = createRowMap();
        this.rowMap = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<Map<C, V>> r10 = this.backingMap.values().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().size();
        goto L4
    L6:
        return r11;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }
}
