package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int r10) {
        return new CompactLinkedHashMap(r10);
    }

    private int getPredecessor(int r10) {
        return (int) (this.links[r10] >>> 32);
    }

    private void setPredecessor(int r10, int r11) {
        long[] r12 = this.links;
        r12[r10] = (r12[r10] & 4294967295L) | (((long) r11) << 32);
    }

    private void setSucceeds(int r10, int r11) {
        if (r10 != (-2)) goto L5;
        this.firstEntry = r11;
    L6:
        if (r11 != (-2)) goto L8;
        this.lastEntry = r10;
        return;
    L8:
        setPredecessor(r11, r10);
        return;
    L5:
        setSuccessor(r10, r11);
        goto L6
    }

    private void setSuccessor(int r10, int r11) {
        long[] r12 = this.links;
        r12[r10] = (r12[r10] & (-4294967296L)) | (((long) r11) & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int r10) {
        if (this.accessOrder == false) goto L6;
        setSucceeds(getPredecessor(r10), getSuccessor(r10));
        setSucceeds(this.lastEntry, r10);
        setSucceeds(r10, -2);
        this.modCount++;
        return;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int r10, int r11) {
        if (r10 >= size()) goto L5;
        return r10;
    L5:
        return r11;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void allocArrays() {
        super.allocArrays();
        long[] r10 = new long[this.keys.length];
        this.links = r10;
        Arrays.fill(r10, -1);
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.links, 0, size(), -1);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int r10) {
        return (int) this.links[r10];
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int r10) {
        super.init(r10);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int r10, K r11, V r12, int r13) {
        super.insertEntry(r10, r11, r12, r13);
        setSucceeds(this.lastEntry, r10);
        setSucceeds(r10, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        super.moveLastEntry(r10);
        setSucceeds(getPredecessor(r10), getSuccessor(r10));
        if (r10 >= r11) goto L5;
        setSucceeds(getPredecessor(r11), r10);
        setSucceeds(r10, getSuccessor(r11));
    L5:
        this.links[r11] = -1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int r10) {
        super.resizeEntries(r10);
        long[] r11 = this.links;
        int r12 = r11.length;
        long[] r13 = Arrays.copyOf(r11, r10);
        this.links = r13;
        if (r12 >= r10) goto L6;
        Arrays.fill(r13, r12, r10, -1);
        return;
    }

    public CompactLinkedHashMap(int r10) {
        this(r10, false);
    }

    public CompactLinkedHashMap(int r10, boolean r11) {
        super(r10);
        this.accessOrder = r11;
    }
}
