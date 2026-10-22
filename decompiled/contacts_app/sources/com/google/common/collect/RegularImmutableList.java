package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ListIterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    private final transient Object[] array;
    private final transient int offset;
    private final transient int size;

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
        return listIterator(r1);
    }

    RegularImmutableList(Object[] r1, int r2, int r3) {
        this.offset = r2;
        this.size = r3;
        this.array = r1;
    }

    RegularImmutableList(Object[] r3) {
        this(r3, 0, r3.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        if (this.size == this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        System.arraycopy(this.array, this.offset, r4, r5, this.size);
        return r5 + this.size;
    }

    @Override // java.util.List
    public E get(int r2) {
        Preconditions.checkElementIndex(r2, this.size);
        return (E) this.array[r2 + this.offset];
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@Nullable Object r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.size) goto L12;
        if (this.array[this.offset + r1].equals(r5) == true) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return r1;
    L12:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@Nullable Object r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        int r1 = this.size - 1;
    L6:
        if (r1 < 0) goto L11;
        if (this.array[this.offset + r1].equals(r5) == true) goto L9;
        r1 = r1 - 1;
        goto L6
    L9:
        return r1;
    L11:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int r3, int r4) {
        return new RegularImmutableList(this.array, this.offset + r3, r4 - r3);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int r3) {
        return Iterators.forArray(this.array, this.offset, this.size, r3);
    }
}
