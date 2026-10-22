package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        final /* synthetic */ ForwardingSortedMultiset this$0;

        public StandardDescendingMultiset(ForwardingSortedMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.DescendingMultiset
        SortedMultiset<E> forwardMultiset() {
            return this.this$0;
        }
    }

    protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        final /* synthetic */ ForwardingSortedMultiset this$0;

        public StandardElementSet(ForwardingSortedMultiset r1) {
            this.this$0 = r1;
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract SortedMultiset<E> delegate();

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Multiset delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    protected ForwardingSortedMultiset() {
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    protected Multiset.Entry<E> standardFirstEntry() {
        Iterator<Multiset.Entry<E>> r1 = entrySet().iterator();
        if (r1.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r2 = r1.next();
        return Multisets.immutableEntry(r2.getElement(), r2.getCount());
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    protected Multiset.Entry<E> standardLastEntry() {
        Iterator<Multiset.Entry<E>> r1 = descendingMultiset().entrySet().iterator();
        if (r1.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r2 = r1.next();
        return Multisets.immutableEntry(r2.getElement(), r2.getCount());
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    protected Multiset.Entry<E> standardPollFirstEntry() {
        Iterator<Multiset.Entry<E>> r2 = entrySet().iterator();
        if (r2.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r0 = r2.next();
        Multiset.Entry<E> r1 = Multisets.immutableEntry(r0.getElement(), r0.getCount());
        r2.remove();
        return r1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    protected Multiset.Entry<E> standardPollLastEntry() {
        Iterator<Multiset.Entry<E>> r2 = descendingMultiset().entrySet().iterator();
        if (r2.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r0 = r2.next();
        Multiset.Entry<E> r1 = Multisets.immutableEntry(r0.getElement(), r0.getCount());
        r2.remove();
        return r1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E r1, BoundType r2) {
        return delegate().headMultiset(r1, r2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E r1, BoundType r2, E r3, BoundType r4) {
        return delegate().subMultiset(r1, r2, r3, r4);
    }

    protected SortedMultiset<E> standardSubMultiset(E r1, BoundType r2, E r3, BoundType r4) {
        return tailMultiset(r1, r2).headMultiset(r3, r4);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E r1, BoundType r2) {
        return delegate().tailMultiset(r1, r2);
    }
}
