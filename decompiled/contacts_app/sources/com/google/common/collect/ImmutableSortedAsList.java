package com.google.common.collect;

import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    /* bridge */ /* synthetic */ ImmutableCollection delegateCollection() {
        return delegateCollection();
    }

    ImmutableSortedAsList(ImmutableSortedSet<E> r1, ImmutableList<E> r2) {
        super(r1, r2);
    }

    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }

    @Override // com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@Nullable Object r2) {
        int r0 = delegateCollection().indexOf(r2);
        if (r0 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (get(r0).equals(r2) == false) goto L7;
        return r0;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@Nullable Object r1) {
        return indexOf(r1);
    }

    @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int r2, int r3) {
        return new RegularImmutableSortedSet(super.subListUnchecked(r2, r3), comparator()).asList();
    }
}
