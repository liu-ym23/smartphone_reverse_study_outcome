package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible(emulated = true)
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    public abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        final /* synthetic */ ForwardingSortedMultiset this$0;

        public StandardDescendingMultiset(ForwardingSortedMultiset r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.DescendingMultiset
        public SortedMultiset<E> forwardMultiset() {
            return this.this$0;
        }
    }

    public class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        final /* synthetic */ ForwardingSortedMultiset this$0;

        public StandardElementSet(ForwardingSortedMultiset r10) {
            this.this$0 = r10;
            super(r10);
        }
    }

    public ForwardingSortedMultiset() {
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Multiset delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedMultiset<E> delegate();

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E r10, BoundType r11) {
        return delegate().headMultiset(r10, r11);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Multiset.Entry<E> standardFirstEntry() {
        Iterator<Multiset.Entry<E>> r10 = entrySet().iterator();
        if (r10.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r11 = r10.next();
        return Multisets.immutableEntry(r11.getElement(), r11.getCount());
    }

    public Multiset.Entry<E> standardLastEntry() {
        Iterator<Multiset.Entry<E>> r10 = descendingMultiset().entrySet().iterator();
        if (r10.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r11 = r10.next();
        return Multisets.immutableEntry(r11.getElement(), r11.getCount());
    }

    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator<Multiset.Entry<E>> r10 = entrySet().iterator();
        if (r10.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r11 = r10.next();
        Multiset.Entry<E> r12 = Multisets.immutableEntry(r11.getElement(), r11.getCount());
        r10.remove();
        return r12;
    }

    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator<Multiset.Entry<E>> r10 = descendingMultiset().entrySet().iterator();
        if (r10.hasNext() == true) goto L6;
        return null;
    L6:
        Multiset.Entry<E> r11 = r10.next();
        Multiset.Entry<E> r12 = Multisets.immutableEntry(r11.getElement(), r11.getCount());
        r10.remove();
        return r12;
    }

    public SortedMultiset<E> standardSubMultiset(E r10, BoundType r11, E r12, BoundType r13) {
        return tailMultiset(r10, r11).headMultiset(r12, r13);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E r10, BoundType r11, E r12, BoundType r13) {
        return delegate().subMultiset(r10, r11, r12, r13);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E r10, BoundType r11) {
        return delegate().tailMultiset(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }
}
