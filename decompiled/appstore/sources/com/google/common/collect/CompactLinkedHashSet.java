package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @MonotonicNonNullDecl
    private transient int[] predecessor;

    @MonotonicNonNullDecl
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int r10) {
        return new CompactLinkedHashSet(r10);
    }

    private int getPredecessor(int r10) {
        return this.predecessor[r10];
    }

    private void setPredecessor(int r10, int r11) {
        this.predecessor[r10] = r11;
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
        this.successor[r10] = r11;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int r10, int r11) {
        if (r10 >= size()) goto L5;
        return r10;
    L5:
        return r11;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void allocArrays() {
        super.allocArrays();
        int r10 = this.elements.length;
        int[] r11 = new int[r10];
        this.predecessor = r11;
        this.successor = new int[r10];
        Arrays.fill(r11, -1);
        Arrays.fill(this.successor, -1);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, 0, size(), -1);
        Arrays.fill(this.successor, 0, size(), -1);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int r10) {
        return this.successor[r10];
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int r10) {
        super.init(r10);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int r10, E r11, int r12) {
        super.insertEntry(r10, r11, r12);
        setSucceeds(this.lastEntry, r10);
        setSucceeds(r10, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int r10) {
        int r11 = size() - 1;
        super.moveLastEntry(r10);
        setSucceeds(getPredecessor(r10), getSuccessor(r10));
        if (r10 >= r11) goto L5;
        setSucceeds(getPredecessor(r11), r10);
        setSucceeds(r10, getSuccessor(r11));
    L5:
        this.predecessor[r11] = -1;
        this.successor[r11] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int r10) {
        super.resizeEntries(r10);
        int[] r11 = this.predecessor;
        int r12 = r11.length;
        this.predecessor = Arrays.copyOf(r11, r10);
        this.successor = Arrays.copyOf(this.successor, r10);
        if (r12 >= r10) goto L6;
        Arrays.fill(this.predecessor, r12, r10, -1);
        Arrays.fill(this.successor, r12, r10, -1);
        return;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public CompactLinkedHashSet(int r10) {
        super(r10);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> r10) {
        CompactLinkedHashSet<E> r11 = createWithExpectedSize(r10.size());
        r11.addAll(r10);
        return r11;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r10) {
        return (T[]) ObjectArrays.toArrayImpl(this, r10);
    }

    public static <E> CompactLinkedHashSet<E> create(E... r10) {
        CompactLinkedHashSet<E> r11 = createWithExpectedSize(r10.length);
        Collections.addAll(r11, r10);
        return r11;
    }
}
