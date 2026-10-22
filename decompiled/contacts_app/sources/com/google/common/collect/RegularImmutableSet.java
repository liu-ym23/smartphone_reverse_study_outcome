package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    private final Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    final transient Object[] table;

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    RegularImmutableSet(Object[] r1, int r2, Object[] r3, int r4) {
        this.elements = r1;
        this.table = r3;
        this.mask = r4;
        this.hashCode = r2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = Hashing.smear(r5.hashCode());
    L6:
        Object r2 = this.table[this.mask & r1];
        if (r2 == null) goto L8;
        if (r2.equals(r5) == true) goto L11;
        r1 = r1 + 1;
        goto L6
    L11:
        return true;
    L8:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.forArray(this.elements);
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        Object[] r0 = this.elements;
        System.arraycopy(r0, 0, r4, r5, r0.length);
        return r5 + this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return new RegularImmutableAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }
}
