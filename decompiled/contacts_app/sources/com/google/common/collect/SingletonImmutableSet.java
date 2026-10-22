package com.google.common.collect;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    private transient int cachedHashCode;
    final transient E element;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    SingletonImmutableSet(E r1) {
        this.element = (E) Preconditions.checkNotNull(r1);
    }

    SingletonImmutableSet(E r1, int r2) {
        this.element = r1;
        this.cachedHashCode = r2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return this.element.equals(r1);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r1, int r2) {
        r1[r2] = this.element;
        return r2 + 1;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof Set) == false) goto L14;
        Set r5 = (Set) r4;
        if (r5.size() != 1) goto L13;
        if (this.element.equals(r5.iterator().next()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int r0 = this.cachedHashCode;
        if (r0 != 0) goto L6;
        int r1 = this.element.hashCode();
        this.cachedHashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        if (this.cachedHashCode == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String r2 = this.element.toString();
        return new StringBuilder(r2.length() + 2).append(DefaultContactListAdapter.SNIPPET_START_MATCH).append(r2).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
    }
}
