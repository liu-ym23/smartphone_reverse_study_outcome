package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"R", "C", "V"})
@GwtCompatible
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = null;
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    static {
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        ImmutableMap r13 = Maps.indexMap(r11);
        LinkedHashMap r14 = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> r15 = r11.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.put(r15.next(), new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r16 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> r17 = r12.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r16.put(r17.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r18 = new int[r10.size()];
        int[] r19 = new int[r10.size()];
        int r20 = 0;
    L12:
        if (r20 >= r10.size()) goto L14;
        Table.Cell<R, C, V> r21 = r10.get(r20);
        R r22 = r21.getRowKey();
        C r23 = r21.getColumnKey();
        V r24 = r21.getValue();
        r18[r20] = ((Integer) r13.get(r22)).intValue();
        Map r25 = (Map) r14.get(r22);
        r19[r20] = r25.size();
        checkNoDuplicate(r22, r23, r25.put(r23, r24), r24);
        ((Map) r16.get(r23)).put(r22, r24);
        r20 = r20 + 1;
        goto L12
    L14:
        this.cellRowIndices = r18;
        this.cellColumnInRowIndices = r19;
        ImmutableMap.Builder r110 = new ImmutableMap.Builder(r14.size());
        Iterator r111 = r14.entrySet().iterator();
    L16:
        if (r111.hasNext() == false) goto L18;
        Map.Entry r26 = (Map.Entry) r111.next();
        r110.put(r26.getKey(), ImmutableMap.copyOf((Map) r26.getValue()));
        goto L16
    L18:
        this.rowMap = r110.build();
        ImmutableMap.Builder r112 = new ImmutableMap.Builder(r16.size());
        Iterator r113 = r16.entrySet().iterator();
    L20:
        if (r113.hasNext() == false) goto L22;
        Map.Entry r114 = (Map.Entry) r113.next();
        r112.put(r114.getKey(), ImmutableMap.copyOf((Map) r114.getValue()));
        goto L20
    L22:
        this.columnMap = r112.build();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap r10 = Maps.indexMap(columnKeySet());
        int[] r11 = new int[cellSet().size()];
        UnmodifiableIterator<Table.Cell<R, C, V>> r12 = cellSet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L7;
        r11[r13] = ((Integer) r10.get(r12.next().getColumnKey())).intValue();
        r13 = r13 + 1;
        goto L4
    L7:
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, r11);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public Table.Cell<R, C, V> getCell(int r10) {
        int r11 = this.cellRowIndices[r10];
        Map.Entry<R, ImmutableMap<C, V>> r12 = this.rowMap.entrySet().asList().get(r11);
        ImmutableMap<C, V> r13 = r12.getValue();
        int r14 = this.cellColumnInRowIndices[r10];
        Map.Entry<C, V> r15 = r13.entrySet().asList().get(r14);
        return ImmutableTable.cellOf(r12.getKey(), r15.getKey(), r15.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int r10) {
        int r11 = this.cellRowIndices[r10];
        ImmutableMap<C, V> r12 = this.rowMap.values().asList().get(r11);
        int r13 = this.cellColumnInRowIndices[r10];
        return r12.values().asList().get(r13);
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
