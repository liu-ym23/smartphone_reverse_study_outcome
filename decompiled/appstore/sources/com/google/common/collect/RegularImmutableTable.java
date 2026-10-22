package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    public final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        final /* synthetic */ RegularImmutableTable this$0;

        private CellSet(RegularImmutableTable r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Table.Cell) == false) goto L10;
            Table.Cell r11 = (Table.Cell) r10;
            Object r12 = this.this$0.get(r11.getRowKey(), r11.getColumnKey());
            if (r12 != null) goto L7;
            return false;
        L7:
            if (r12.equals(r11.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        public /* synthetic */ CellSet(RegularImmutableTable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public Table.Cell<R, C, V> get(int r10) {
            return this.this$0.getCell(r10);
        }
    }

    public final class Values extends ImmutableList<V> {
        final /* synthetic */ RegularImmutableTable this$0;

        private Values(RegularImmutableTable r10) {
            this.this$0 = r10;
        }

        @Override // java.util.List
        public V get(int r10) {
            return (V) this.this$0.getValue(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.this$0.size();
        }

        public /* synthetic */ Values(RegularImmutableTable r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public RegularImmutableTable() {
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> r10, @NullableDecl final Comparator<? super R> r11, @NullableDecl final Comparator<? super C> r12) {
        Preconditions.checkNotNull(r10);
        if (r11 != null) goto L5;
        if (r12 != null) goto L5;
    L7:
        return forCellsInternal(r10, r11, r12);
    L5:
        Collections.sort(r10, new AnonymousClass1(r11, r12));
        goto L7
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> r10, @NullableDecl Comparator<? super R> r11, @NullableDecl Comparator<? super C> r12) {
        LinkedHashSet r13 = new LinkedHashSet();
        LinkedHashSet r14 = new LinkedHashSet();
        ImmutableList r15 = ImmutableList.copyOf(r10);
        Iterator<Table.Cell<R, C, V>> r16 = r10.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Table.Cell<R, C, V> r17 = r16.next();
        r13.add(r17.getRowKey());
        r14.add(r17.getColumnKey());
        goto L4
    L6:
        if (r11 != null) goto L8;
        ImmutableSet r18 = ImmutableSet.copyOf(r13);
    L9:
        if (r12 != null) goto L11;
        ImmutableSet r19 = ImmutableSet.copyOf(r14);
    L13:
        return forOrderedComponents(r15, r18, r19);
    L11:
        r19 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r12, r14));
        goto L13
    L8:
        r18 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(r11, r13));
        goto L9
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        if (r10.size() <= ((((long) r11.size()) * ((long) r12.size())) / 2)) goto L6;
        return new DenseImmutableTable(r10, r11, r12);
    L6:
        return new SparseImmutableTable(r10, r11, r12);
    }

    public final void checkNoDuplicate(R r10, C r11, V r12, V r13) {
        if (r12 != null) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r10, r11, r13, r12);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Set createCellSet() {
        return createCellSet();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Collection createValues() {
        return createValues();
    }

    public abstract Table.Cell<R, C, V> getCell(int r10);

    public abstract V getValue(int r10);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new CellSet(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final ImmutableCollection<V> createValues() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return new Values(this, null);
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> r10) {
        return forCellsInternal(r10, null, null);
    }
}
