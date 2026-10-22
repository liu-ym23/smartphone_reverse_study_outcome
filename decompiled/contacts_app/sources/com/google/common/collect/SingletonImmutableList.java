package com.google.common.collect;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<E> reverse() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
        return subList(r1, r2);
    }

    SingletonImmutableList(E r1) {
        this.element = (E) Preconditions.checkNotNull(r1);
    }

    @Override // java.util.List
    public E get(int r2) {
        Preconditions.checkElementIndex(r2, 1);
        return this.element;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@Nullable Object r1) {
        if (this.element.equals(r1) == false) goto L5;
        return 0;
    L5:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@Nullable Object r1) {
        return indexOf(r1);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int r2, int r3) {
        Preconditions.checkPositionIndexes(r2, r3, 1);
        if (r2 == r3) goto L5;
        return this;
    L5:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r1) {
        return this.element.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof List) == false) goto L14;
        List r5 = (List) r4;
        if (r5.size() != 1) goto L13;
        if (this.element.equals(r5.get(0)) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.element.hashCode() + 31;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String r2 = this.element.toString();
        return new StringBuilder(r2.length() + 2).append(DefaultContactListAdapter.SNIPPET_START_MATCH).append(r2).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        r1[r2] = this.element;
        return r2 + 1;
    }
}
