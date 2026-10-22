package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {

    @GwtTransient
    final Comparator<? super E> comparator;

    @MonotonicNonNullDecl
    private transient SortedMultiset<E> descendingMultiset;

    public AbstractSortedMultiset() {
        this(Ordering.natural());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public SortedMultiset<E> createDescendingMultiset() {
        return new C1DescendingMultisetImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    public abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return Multisets.iteratorImpl(descendingMultiset());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> r10 = this.descendingMultiset;
        if (r10 != null) goto L6;
        SortedMultiset<E> r11 = createDescendingMultiset();
        this.descendingMultiset = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> r10 = entryIterator();
        if (r10.hasNext() == true) goto L7;
        return null;
    L7:
        return r10.next();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> r10 = descendingEntryIterator();
        if (r10.hasNext() == true) goto L7;
        return null;
    L7:
        return r10.next();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> r10 = entryIterator();
        if (r10.hasNext() == false) goto L6;
        Multiset.Entry<E> r11 = r10.next();
        Multiset.Entry<E> r12 = Multisets.immutableEntry(r11.getElement(), r11.getCount());
        r10.remove();
        return r12;
    L6:
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> r10 = descendingEntryIterator();
        if (r10.hasNext() == false) goto L6;
        Multiset.Entry<E> r11 = r10.next();
        Multiset.Entry<E> r12 = Multisets.immutableEntry(r11.getElement(), r11.getCount());
        r10.remove();
        return r12;
    L6:
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(@NullableDecl E r10, BoundType r11, @NullableDecl E r12, BoundType r13) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r13);
        return tailMultiset(r10, r11).headMultiset(r12, r13);
    }

    public AbstractSortedMultiset(Comparator<? super E> r10) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public NavigableSet<E> createElementSet() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
