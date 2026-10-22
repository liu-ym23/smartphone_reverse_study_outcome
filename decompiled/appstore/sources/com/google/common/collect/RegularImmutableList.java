package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = null;

    @VisibleForTesting
    final transient Object[] array;
    private final transient int size;

    static {
        EMPTY = new RegularImmutableList(new Object[0], 0);
    }

    public RegularImmutableList(Object[] r10, int r11) {
        this.array = r10;
        this.size = r11;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r10, int r11) {
        System.arraycopy(this.array, 0, r10, r11, this.size);
        return r11 + this.size;
    }

    @Override // java.util.List
    public E get(int r10) {
        Preconditions.checkElementIndex(r10, this.size);
        return (E) this.array[r10];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
