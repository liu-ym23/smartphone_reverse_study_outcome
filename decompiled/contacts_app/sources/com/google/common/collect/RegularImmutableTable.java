package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    private final class CellSet extends ImmutableSet<Table.Cell<R, C, V>> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        private CellSet(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CellSet(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Table.Cell<R, C, V>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Table.Cell<R, C, V>> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r4) {
            if ((r4 instanceof Table.Cell) == false) goto L10;
            Table.Cell r5 = (Table.Cell) r4;
            Object r3 = this.this$0.get(r5.getRowKey(), r5.getColumnKey());
            if (r3 != null) goto L7;
            return false;
        L7:
            if (r3.equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    private final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        private Values(RegularImmutableTable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Values(RegularImmutableTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.List
        public V get(int r1) {
            return (V) this.this$0.getValue(r1);
        }
    }

    abstract Table.Cell<R, C, V> getCell(int r1);

    abstract V getValue(int r1);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    RegularImmutableTable() {
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> r1, @Nullable final Comparator<? super R> r2, @Nullable final Comparator<? super C> r3) {
        Preconditions.checkNotNull(r1);
        if (r2 != null) goto L5;
        if (r3 != null) goto L5;
    L7:
        return forCellsInternal(r1, r2, r3);
    L5:
        Collections.sort(r1, new AnonymousClass1(r2, r3));
        goto L7
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> r1) {
        return forCellsInternal(r1, null, null);
    }

    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> r7, @Nullable Comparator<? super R> r8, @Nullable Comparator<? super C> r9) {
        ImmutableSet.Builder r0 = ImmutableSet.builder();
        ImmutableSet.Builder r1 = ImmutableSet.builder();
        ImmutableList r10 = ImmutableList.copyOf(r7);
        UnmodifiableIterator r2 = r10.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Table.Cell r3 = (Table.Cell) r2.next();
        r0.add(r3.getRowKey());
        r1.add(r3.getColumnKey());
        goto L4
    L6:
        ImmutableSet r4 = r0.build();
        if (r8 == null) goto L9;
        ArrayList r5 = Lists.newArrayList(r4);
        Collections.sort(r5, r8);
        r4 = ImmutableSet.copyOf(r5);
    L9:
        ImmutableSet r11 = r1.build();
        if (r9 == null) goto L13;
        ArrayList r12 = Lists.newArrayList(r11);
        Collections.sort(r12, r9);
        r11 = ImmutableSet.copyOf(r12);
    L13:
        if (r10.size() <= ((((long) r4.size()) * ((long) r11.size())) / 2)) goto L16;
        return new DenseImmutableTable(r10, r4, r11);
    L16:
        return new SparseImmutableTable(r10, r4, r11);
    }
}
