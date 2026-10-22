package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Multisets {
    private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING = null;

    static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        AbstractEntry() {
        }

        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof Multiset.Entry) == false) goto L10;
            Multiset.Entry r5 = (Multiset.Entry) r4;
            if (getCount() == r5.getCount()) goto L7;
            return false;
        L7:
            if (Objects.equal(getElement(), r5.getElement()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E r0 = getElement();
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return getCount() ^ r1;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String r0 = String.valueOf(getElement());
            int r2 = getCount();
            if (r2 != 1) goto L6;
            return r0;
        L6:
            return r0 + " x " + r2;
        }
    }

    static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        abstract Multiset<E> multiset();

        ElementSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return multiset().contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r1) {
            return multiset().containsAll(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            final Iterator<Multiset.Entry<E>> r1 = multiset().entrySet().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            int r0 = multiset().count(r2);
            if (r0 <= 0) goto L6;
            multiset().remove(r2, r0);
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return multiset().entrySet().size();
        }
    }

    static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        abstract Multiset<E> multiset();

        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r3) {
            if ((r3 instanceof Multiset.Entry) == false) goto L11;
            Multiset.Entry r4 = (Multiset.Entry) r3;
            if (r4.getCount() > 0) goto L8;
            return false;
        L8:
            if (multiset().count(r4.getElement()) != r4.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if ((r3 instanceof Multiset.Entry) == false) goto L8;
            Multiset.Entry r4 = (Multiset.Entry) r3;
            Object r0 = r4.getElement();
            int r5 = r4.getCount();
            if (r5 == 0) goto L8;
            return multiset().setCount(r0, r5, 0);
        L8:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }
    }

    private static final class FilteredMultiset<E> extends AbstractMultiset<E> {
        final Predicate<? super E> predicate;
        final Multiset<E> unfiltered;

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        FilteredMultiset(Multiset<E> r1, Predicate<? super E> r2) {
            this.unfiltered = (Multiset) Preconditions.checkNotNull(r1);
            this.predicate = (Predicate) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new AnonymousClass1(this));
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        int distinctElements() {
            return elementSet().size();
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int count(@Nullable Object r3) {
            int r0 = this.unfiltered.count(r3);
            if (r0 > 0) goto L5;
            return 0;
        L5:
            if (this.predicate.apply(r3) == false) goto L8;
            return r0;
        L8:
            return 0;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(@Nullable E r5, int r6) {
            Preconditions.checkArgument(this.predicate.apply(r5), "Element %s does not match predicate %s", new Object[]{r5, this.predicate});
            return this.unfiltered.add(r5, r6);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@Nullable Object r2, int r3) {
            CollectPreconditions.checkNonnegative(r3, "occurrences");
            if (r3 != 0) goto L7;
            return count(r2);
        L7:
            if (contains(r2) == true) goto L11;
            return 0;
        L11:
            return this.unfiltered.remove(r2, r3);
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }
    }

    static final class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final int count;

        @Nullable
        final E element;

        ImmutableEntry(@Nullable E r1, int r2) {
            this.element = r1;
            this.count = r2;
            CollectPreconditions.checkNonnegative(r2, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        @Nullable
        public E getElement() {
            return this.element;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            return this.count;
        }
    }

    static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private boolean canRemove;
        private Multiset.Entry<E> currentEntry;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;

        MultisetIteratorImpl(Multiset<E> r1, Iterator<Multiset.Entry<E>> r2) {
            this.multiset = r1;
            this.entryIterator = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.laterCount <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.entryIterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L10;
            if (this.laterCount != 0) goto L7;
            Multiset.Entry<E> r0 = this.entryIterator.next();
            this.currentEntry = r0;
            int r1 = r0.getCount();
            this.laterCount = r1;
            this.totalCount = r1;
        L7:
            this.laterCount--;
            this.canRemove = true;
            return this.currentEntry.getElement();
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.totalCount != 1) goto L5;
            this.entryIterator.remove();
        L6:
            this.totalCount--;
            this.canRemove = false;
            return;
        L5:
            this.multiset.remove(this.currentEntry.getElement());
            goto L6
        }
    }

    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        UnmodifiableMultiset(Multiset<? extends E> r1) {
            this.delegate = r1;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Multiset<E> delegate() {
            return this.delegate;
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> r0 = this.elementSet;
            if (r0 != null) goto L6;
            Set<E> r1 = createElementSet();
            this.elementSet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> r0 = this.entrySet;
            if (r0 != null) goto L6;
            Set<Multiset.Entry<E>> r1 = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean add(E r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(E r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(Object r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(E r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(E r1, int r2, int r3) {
            throw new UnsupportedOperationException();
        }
    }

    private Multisets() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> r1) {
        if ((r1 instanceof UnmodifiableMultiset) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof ImmutableMultiset) == true) goto L9;
        return new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(r1));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> r0) {
        return (Multiset) Preconditions.checkNotNull(r0);
    }

    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> r1) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.checkNotNull(r1));
    }

    public static <E> Multiset.Entry<E> immutableEntry(@Nullable E r1, int r2) {
        return new ImmutableEntry(r1, r2);
    }

    public static <E> Multiset<E> filter(Multiset<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredMultiset) == false) goto L7;
        FilteredMultiset r3 = (FilteredMultiset) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredMultiset(r3.unfiltered, r4);
    L7:
        return new FilteredMultiset(r1, r2);
    }

    static int inferDistinctElements(Iterable<?> r1) {
        if ((r1 instanceof Multiset) == true) goto L5;
        return 11;
    L5:
        return ((Multiset) r1).elementSet().size();
    }

    public static <E> Multiset<E> union(final Multiset<? extends E> r1, final Multiset<? extends E> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(r1, r2);
    }

    public static <E> Multiset<E> intersection(final Multiset<E> r1, final Multiset<?> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(r1, r2);
    }

    public static <E> Multiset<E> sum(final Multiset<? extends E> r1, final Multiset<? extends E> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass3(r1, r2);
    }

    public static <E> Multiset<E> difference(final Multiset<E> r1, final Multiset<?> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass4(r1, r2);
    }

    public static boolean containsOccurrences(Multiset<?> r2, Multiset<?> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Iterator<Multiset.Entry<?>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Multiset.Entry<?> r0 = r4.next();
        if (r2.count(r0.getElement()) >= r0.getCount()) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean retainOccurrences(Multiset<?> r0, Multiset<?> r1) {
        return retainOccurrencesImpl(r0, r1);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> r6, Multiset<?> r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        Iterator<Multiset.Entry<E>> r0 = r6.entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L12;
        Multiset.Entry<E> r2 = r0.next();
        int r3 = r7.count(r2.getElement());
        if (r3 == 0) goto L7;
        if (r3 >= r2.getCount()) goto L4;
        r6.setCount(r2.getElement(), r3);
    L8:
        r1 = true;
        goto L4
    L7:
        r0.remove();
        goto L8
    L12:
        return r1;
    }

    public static boolean removeOccurrences(Multiset<?> r1, Iterable<?> r2) {
        if ((r2 instanceof Multiset) == false) goto L7;
        return removeOccurrencesImpl(r1, (Multiset) r2);
    L7:
        return removeOccurrencesImpl(r1, r2);
    }

    private static boolean removeOccurrencesImpl(Multiset<?> r2, Iterable<?> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        Iterator<?> r4 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 | r2.remove(r4.next());
        goto L4
    L6:
        return r0;
    }

    private static <E> boolean removeOccurrencesImpl(Multiset<E> r6, Multiset<?> r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        Iterator<Multiset.Entry<E>> r0 = r6.entrySet().iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        Multiset.Entry<E> r2 = r0.next();
        int r3 = r7.count(r2.getElement());
        if (r3 >= r2.getCount()) goto L7;
        if (r3 <= 0) goto L4;
        r6.remove(r2.getElement(), r3);
    L8:
        r1 = true;
        goto L4
    L7:
        r0.remove();
        goto L8
    L11:
        return r1;
    }

    static boolean equalsImpl(Multiset<?> r4, @Nullable Object r5) {
        if (r5 != r4) goto L6;
        return true;
    L6:
        if ((r5 instanceof Multiset) == false) goto L19;
        Multiset r6 = (Multiset) r5;
        if (r4.size() != r6.size()) goto L19;
        if (r4.entrySet().size() != r6.entrySet().size()) goto L19;
        Iterator r7 = r6.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        Multiset.Entry r1 = (Multiset.Entry) r7.next();
        if (r4.count(r1.getElement()) == r1.getCount()) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    static <E> boolean addAllImpl(Multiset<E> r2, Collection<? extends E> r3) {
        if (r3.isEmpty() == false) goto L7;
        return false;
    L7:
        if ((r3 instanceof Multiset) == false) goto L12;
        Iterator<Multiset.Entry<E>> r4 = cast(r3).entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        Multiset.Entry<E> r0 = r4.next();
        r2.add(r0.getElement(), r0.getCount());
        goto L10
    L16:
        return true;
    L12:
        Iterators.addAll(r2, r3.iterator());
        return true;
    }

    static boolean removeAllImpl(Multiset<?> r1, Collection<?> r2) {
        if ((r2 instanceof Multiset) == false) goto L6;
        r2 = ((Multiset) r2).elementSet();
    L6:
        return r1.elementSet().removeAll(r2);
    }

    static boolean retainAllImpl(Multiset<?> r1, Collection<?> r2) {
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof Multiset) == false) goto L6;
        r2 = ((Multiset) r2).elementSet();
    L6:
        return r1.elementSet().retainAll(r2);
    }

    static <E> int setCountImpl(Multiset<E> r1, E r2, int r3) {
        CollectPreconditions.checkNonnegative(r3, "count");
        int r0 = r1.count(r2);
        int r4 = r3 - r0;
        if (r4 <= 0) goto L5;
        r1.add(r2, r4);
    L7:
        return r0;
    L5:
        if (r4 >= 0) goto L7;
        r1.remove(r2, -r4);
        goto L7
    }

    static <E> boolean setCountImpl(Multiset<E> r1, E r2, int r3, int r4) {
        CollectPreconditions.checkNonnegative(r3, "oldCount");
        CollectPreconditions.checkNonnegative(r4, "newCount");
        if (r1.count(r2) != r3) goto L6;
        r1.setCount(r2, r4);
        return true;
    L6:
        return false;
    }

    static <E> Iterator<E> iteratorImpl(Multiset<E> r2) {
        return new MultisetIteratorImpl(r2, r2.entrySet().iterator());
    }

    static int sizeImpl(Multiset<?> r4) {
        Iterator<Multiset.Entry<?>> r5 = r4.entrySet().iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r0 = r0 + ((long) r5.next().getCount());
        goto L4
    L7:
        return Ints.saturatedCast(r0);
    }

    static <T> Multiset<T> cast(Iterable<T> r0) {
        return (Multiset) r0;
    }

    static {
        DECREASING_COUNT_ORDERING = new AnonymousClass5();
    }

    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> r1) {
        return ImmutableMultiset.copyFromEntries(DECREASING_COUNT_ORDERING.immutableSortedCopy(r1.entrySet()));
    }
}
