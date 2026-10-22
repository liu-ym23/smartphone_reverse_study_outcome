package com.google.common.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final ImmutableMap<C, Map<R, V>> columnMap;
    private final int[] iterationOrderColumn;
    private final int[] iterationOrderRow;
    private final ImmutableMap<R, Map<C, V>> rowMap;

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return columnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map rowMap() {
        return rowMap();
    }

    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> r10, ImmutableSet<R> r11, ImmutableSet<C> r12) {
        HashMap r0 = Maps.newHashMap();
        LinkedHashMap r1 = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        R r2 = r13.next();
        r0.put(r2, Integer.valueOf(r1.size()));
        r1.put(r2, new LinkedHashMap());
        goto L4
    L6:
        LinkedHashMap r14 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> r15 = r12.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.put(r15.next(), new LinkedHashMap());
        goto L8
    L10:
        int[] r16 = new int[r10.size()];
        int[] r3 = new int[r10.size()];
        int r4 = 0;
    L12:
        if (r4 >= r10.size()) goto L18;
        Table.Cell<R, C, V> r5 = r10.get(r4);
        R r6 = r5.getRowKey();
        C r7 = r5.getColumnKey();
        V r8 = r5.getValue();
        r16[r4] = ((Integer) r0.get(r6)).intValue();
        Map r9 = (Map) r1.get(r6);
        r3[r4] = r9.size();
        Object r17 = r9.put(r7, r8);
        if (r17 != null) goto L17;
        ((Map) r14.get(r7)).put(r6, r8);
        r4 = r4 + 1;
        goto L12
    L17:
        throw new IllegalArgumentException("Duplicate value for row=" + r6 + ", column=" + r7 + ": " + r8 + ", " + r17);
    L18:
        this.iterationOrderRow = r16;
        this.iterationOrderColumn = r3;
        ImmutableMap.Builder r18 = ImmutableMap.builder();
        Iterator r19 = r1.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r19.next();
        r18.put(r20.getKey(), ImmutableMap.copyOf((Map) r20.getValue()));
        goto L20
    L22:
        this.rowMap = r18.build();
        ImmutableMap.Builder r110 = ImmutableMap.builder();
        Iterator r111 = r14.entrySet().iterator();
    L24:
        if (r111.hasNext() == false) goto L26;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.put(r112.getKey(), ImmutableMap.copyOf((Map) r112.getValue()));
        goto L24
    L26:
        this.columnMap = r110.build();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return this.columnMap;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return this.rowMap;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell<R, C, V> getCell(int r3) {
        int r0 = this.iterationOrderRow[r3];
        Map.Entry<R, Map<C, V>> r1 = this.rowMap.entrySet().asList().get(r0);
        ImmutableMap r2 = (ImmutableMap) r1.getValue();
        int r4 = this.iterationOrderColumn[r3];
        Map.Entry r5 = (Map.Entry) r2.entrySet().asList().get(r4);
        return cellOf(r1.getKey(), r5.getKey(), r5.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int r3) {
        int r0 = this.iterationOrderRow[r3];
        ImmutableMap r1 = (ImmutableMap) this.rowMap.values().asList().get(r0);
        int r2 = this.iterationOrderColumn[r3];
        return r1.values().asList().get(r2);
    }
}
