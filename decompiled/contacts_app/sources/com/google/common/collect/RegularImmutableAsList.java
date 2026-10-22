package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r1) {
        return listIterator(r1);
    }

    RegularImmutableAsList(ImmutableCollection<E> r1, ImmutableList<? extends E> r2) {
        this.delegate = r1;
        this.delegateList = r2;
    }

    RegularImmutableAsList(ImmutableCollection<E> r1, Object[] r2) {
        this(r1, ImmutableList.asImmutableList(r2));
    }

    @Override // com.google.common.collect.ImmutableAsList
    ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int r1) {
        return this.delegateList.listIterator(r1);
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        return this.delegateList.copyIntoArray(r1, r2);
    }

    @Override // java.util.List
    public E get(int r1) {
        return this.delegateList.get(r1);
    }
}
