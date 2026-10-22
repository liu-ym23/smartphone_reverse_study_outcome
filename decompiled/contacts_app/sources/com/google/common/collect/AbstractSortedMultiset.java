package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {

    @GwtTransient
    final Comparator<? super E> comparator;
    private transient SortedMultiset<E> descendingMultiset;

    abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    @Override // com.google.common.collect.AbstractMultiset
    /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    AbstractSortedMultiset() {
        this(Ordering.natural());
    }

    AbstractSortedMultiset(Comparator<? super E> r1) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r1);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    NavigableSet<E> createElementSet() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> r1 = entryIterator();
        if (r1.hasNext() == true) goto L7;
        return null;
    L7:
        return r1.next();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> r1 = descendingEntryIterator();
        if (r1.hasNext() == true) goto L7;
        return null;
    L7:
        return r1.next();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> r2 = entryIterator();
        if (r2.hasNext() == false) goto L6;
        Multiset.Entry<E> r0 = r2.next();
        Multiset.Entry<E> r1 = Multisets.immutableEntry(r0.getElement(), r0.getCount());
        r2.remove();
        return r1;
    L6:
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> r2 = descendingEntryIterator();
        if (r2.hasNext() == false) goto L6;
        Multiset.Entry<E> r0 = r2.next();
        Multiset.Entry<E> r1 = Multisets.immutableEntry(r0.getElement(), r0.getCount());
        r2.remove();
        return r1;
    L6:
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(@Nullable E r1, BoundType r2, @Nullable E r3, BoundType r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r4);
        return tailMultiset(r1, r2).headMultiset(r3, r4);
    }

    Iterator<E> descendingIterator() {
        return Multisets.iteratorImpl(descendingMultiset());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> r0 = this.descendingMultiset;
        if (r0 != null) goto L6;
        SortedMultiset<E> r1 = createDescendingMultiset();
        this.descendingMultiset = r1;
        return r1;
    L6:
        return r0;
    }

    SortedMultiset<E> createDescendingMultiset() {
        return new AnonymousClass1(this);
    }
}
