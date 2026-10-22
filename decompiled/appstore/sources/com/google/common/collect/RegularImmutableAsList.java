package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(ImmutableCollection<E> r10, ImmutableList<? extends E> r11) {
        this.delegate = r10;
        this.delegateList = r11;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] r10, int r11) {
        return this.delegateList.copyIntoArray(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // java.util.List
    public E get(int r10) {
        return this.delegateList.get(r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r10) {
        return listIterator(r10);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int r10) {
        return this.delegateList.listIterator(r10);
    }

    public RegularImmutableAsList(ImmutableCollection<E> r10, Object[] r11) {
        this(r10, ImmutableList.asImmutableList(r11));
    }

    public RegularImmutableAsList(ImmutableCollection<E> r10, Object[] r11, int r12) {
        this(r10, ImmutableList.asImmutableList(r11, r12));
    }
}
