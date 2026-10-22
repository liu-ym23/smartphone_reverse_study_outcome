package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class Constraints {

    static class ConstrainedCollection<E> extends ForwardingCollection<E> {
        private final Constraint<? super E> constraint;
        private final Collection<E> delegate;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        public ConstrainedCollection(Collection<E> r1, Constraint<? super E> r2) {
            this.delegate = (Collection) Preconditions.checkNotNull(r1);
            this.constraint = (Constraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(E r2) {
            this.constraint.checkElement(r2);
            return this.delegate.add(r2);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            return this.delegate.addAll(Constraints.access$000(r2, this.constraint));
        }
    }

    private static class ConstrainedList<E> extends ForwardingList<E> {
        final Constraint<? super E> constraint;
        final List<E> delegate;

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        ConstrainedList(List<E> r1, Constraint<? super E> r2) {
            this.delegate = (List) Preconditions.checkNotNull(r1);
            this.constraint = (Constraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected List<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(E r2) {
            this.constraint.checkElement(r2);
            return this.delegate.add(r2);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int r2, E r3) {
            this.constraint.checkElement(r3);
            this.delegate.add(r2, r3);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            return this.delegate.addAll(Constraints.access$000(r2, this.constraint));
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public boolean addAll(int r2, Collection<? extends E> r3) {
            return this.delegate.addAll(r2, Constraints.access$000(r3, this.constraint));
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public ListIterator<E> listIterator() {
            return Constraints.access$100(this.delegate.listIterator(), this.constraint);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public ListIterator<E> listIterator(int r2) {
            return Constraints.access$100(this.delegate.listIterator(r2), this.constraint);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public E set(int r2, E r3) {
            this.constraint.checkElement(r3);
            return this.delegate.set(r2, r3);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public List<E> subList(int r2, int r3) {
            return Constraints.constrainedList(this.delegate.subList(r2, r3), this.constraint);
        }
    }

    static class ConstrainedListIterator<E> extends ForwardingListIterator<E> {
        private final Constraint<? super E> constraint;
        private final ListIterator<E> delegate;

        @Override // com.google.common.collect.ForwardingListIterator, com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingListIterator, com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Iterator delegate() {
            return delegate();
        }

        public ConstrainedListIterator(ListIterator<E> r1, Constraint<? super E> r2) {
            this.delegate = r1;
            this.constraint = r2;
        }

        @Override // com.google.common.collect.ForwardingListIterator, com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        protected ListIterator<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingListIterator, java.util.ListIterator
        public void add(E r2) {
            this.constraint.checkElement(r2);
            this.delegate.add(r2);
        }

        @Override // com.google.common.collect.ForwardingListIterator, java.util.ListIterator
        public void set(E r2) {
            this.constraint.checkElement(r2);
            this.delegate.set(r2);
        }
    }

    static class ConstrainedRandomAccessList<E> extends ConstrainedList<E> implements RandomAccess {
        ConstrainedRandomAccessList(List<E> r1, Constraint<? super E> r2) {
            super(r1, r2);
        }
    }

    static class ConstrainedSet<E> extends ForwardingSet<E> {
        private final Constraint<? super E> constraint;
        private final Set<E> delegate;

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public ConstrainedSet(Set<E> r1, Constraint<? super E> r2) {
            this.delegate = (Set) Preconditions.checkNotNull(r1);
            this.constraint = (Constraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Set<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(E r2) {
            this.constraint.checkElement(r2);
            return this.delegate.add(r2);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            return this.delegate.addAll(Constraints.access$000(r2, this.constraint));
        }
    }

    private static class ConstrainedSortedSet<E> extends ForwardingSortedSet<E> {
        final Constraint<? super E> constraint;
        final SortedSet<E> delegate;

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        ConstrainedSortedSet(SortedSet<E> r1, Constraint<? super E> r2) {
            this.delegate = (SortedSet) Preconditions.checkNotNull(r1);
            this.constraint = (Constraint) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected SortedSet<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(E r2) {
            return Constraints.constrainedSortedSet(this.delegate.headSet(r2), this.constraint);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(E r2, E r3) {
            return Constraints.constrainedSortedSet(this.delegate.subSet(r2, r3), this.constraint);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(E r2) {
            return Constraints.constrainedSortedSet(this.delegate.tailSet(r2), this.constraint);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(E r2) {
            this.constraint.checkElement(r2);
            return this.delegate.add(r2);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            return this.delegate.addAll(Constraints.access$000(r2, this.constraint));
        }
    }

    static /* synthetic */ Collection access$000(Collection r0, Constraint r1) {
        return checkElements(r0, r1);
    }

    static /* synthetic */ ListIterator access$100(ListIterator r0, Constraint r1) {
        return constrainedListIterator(r0, r1);
    }

    private Constraints() {
    }

    public static <E> Collection<E> constrainedCollection(Collection<E> r1, Constraint<? super E> r2) {
        return new ConstrainedCollection(r1, r2);
    }

    public static <E> Set<E> constrainedSet(Set<E> r1, Constraint<? super E> r2) {
        return new ConstrainedSet(r1, r2);
    }

    public static <E> SortedSet<E> constrainedSortedSet(SortedSet<E> r1, Constraint<? super E> r2) {
        return new ConstrainedSortedSet(r1, r2);
    }

    public static <E> List<E> constrainedList(List<E> r1, Constraint<? super E> r2) {
        if ((r1 instanceof RandomAccess) == false) goto L6;
        return new ConstrainedRandomAccessList(r1, r2);
    L6:
        return new ConstrainedList(r1, r2);
    }

    private static <E> ListIterator<E> constrainedListIterator(ListIterator<E> r1, Constraint<? super E> r2) {
        return new ConstrainedListIterator(r1, r2);
    }

    static <E> Collection<E> constrainedTypePreservingCollection(Collection<E> r1, Constraint<E> r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return constrainedSortedSet((SortedSet) r1, r2);
    L7:
        if ((r1 instanceof Set) == false) goto L11;
        return constrainedSet((Set) r1, r2);
    L11:
        if ((r1 instanceof List) == false) goto L15;
        return constrainedList((List) r1, r2);
    L15:
        return constrainedCollection(r1, r2);
    }

    private static <E> Collection<E> checkElements(Collection<E> r2, Constraint<? super E> r3) {
        ArrayList r4 = Lists.newArrayList(r2);
        Iterator<E> r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.checkElement(r0.next());
        goto L4
    L6:
        return r4;
    }
}
