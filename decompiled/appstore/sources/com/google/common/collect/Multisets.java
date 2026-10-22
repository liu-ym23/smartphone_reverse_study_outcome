package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Multisets {

    public static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        public AbstractEntry() {
        }

        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof Multiset.Entry) == false) goto L10;
            Multiset.Entry r11 = (Multiset.Entry) r10;
            if (getCount() == r11.getCount()) goto L7;
            return false;
        L7:
            if (Objects.equal(getElement(), r11.getElement()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E r10 = getElement();
            if (r10 != null) goto L5;
            int r11 = 0;
        L7:
            return getCount() ^ r11;
        L5:
            r11 = r10.hashCode();
            goto L7
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String r10 = String.valueOf(getElement());
            int r11 = getCount();
            if (r11 != 1) goto L6;
            return r10;
        L6:
            return r10 + " x " + r11;
        }
    }

    public static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        static final DecreasingCount INSTANCE = null;

        static {
            INSTANCE = new DecreasingCount();
        }

        private DecreasingCount() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Multiset.Entry<?> r10, Multiset.Entry<?> r11) {
            return compare2(r10, r11);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Multiset.Entry<?> r10, Multiset.Entry<?> r11) {
            return r11.getCount() - r10.getCount();
        }
    }

    public static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        public ElementSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            return multiset().contains(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r10) {
            return multiset().containsAll(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        public abstract Multiset<E> multiset();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if (multiset().remove(r10, Channel.UNLIMITED) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return multiset().entrySet().size();
        }
    }

    public static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Multiset.Entry) == false) goto L11;
            Multiset.Entry r11 = (Multiset.Entry) r10;
            if (r11.getCount() > 0) goto L8;
            return false;
        L8:
            if (multiset().count(r11.getElement()) != r11.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        public abstract Multiset<E> multiset();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            if ((r10 instanceof Multiset.Entry) == false) goto L8;
            Multiset.Entry r11 = (Multiset.Entry) r10;
            Object r12 = r11.getElement();
            int r13 = r11.getCount();
            if (r13 == 0) goto L8;
            return multiset().setCount(r12, r13, 0);
        L8:
            return false;
        }
    }

    public static final class FilteredMultiset<E> extends ViewMultiset<E> {
        final Predicate<? super E> predicate;
        final Multiset<E> unfiltered;

        public FilteredMultiset(Multiset<E> r10, Predicate<? super E> r11) {
            super(null);
            this.unfiltered = (Multiset) Preconditions.checkNotNull(r10);
            this.predicate = (Predicate) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int add(@NullableDecl E r10, int r11) {
            Preconditions.checkArgument(this.predicate.apply(r10), "Element %s does not match predicate %s", r10, this.predicate);
            return this.unfiltered.add(r10, r11);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object r10) {
            int r11 = this.unfiltered.count(r10);
            if (r11 > 0) goto L5;
            return 0;
        L5:
            if (this.predicate.apply(r10) == false) goto L8;
            return r11;
        L8:
            return 0;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<E> createElementSet() {
            return Sets.filter(this.unfiltered.elementSet(), this.predicate);
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Set<Multiset.Entry<E>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), new AnonymousClass1(this));
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<E> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public Iterator<Multiset.Entry<E>> entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object r10, int r11) {
            CollectPreconditions.checkNonnegative(r11, "occurrences");
            if (r11 != 0) goto L7;
            return count(r10);
        L7:
            if (contains(r10) == true) goto L11;
            return 0;
        L11:
            return this.unfiltered.remove(r10, r11);
        }

        @Override // com.google.common.collect.Multisets.ViewMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public UnmodifiableIterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }
    }

    public static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @NullableDecl
        private final E element;

        public ImmutableEntry(@NullableDecl E r10, int r11) {
            this.element = r10;
            this.count = r11;
            CollectPreconditions.checkNonnegative(r11, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @NullableDecl
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private boolean canRemove;

        @MonotonicNonNullDecl
        private Multiset.Entry<E> currentEntry;
        private final Iterator<Multiset.Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;

        public MultisetIteratorImpl(Multiset<E> r10, Iterator<Multiset.Entry<E>> r11) {
            this.multiset = r10;
            this.entryIterator = r11;
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
            Multiset.Entry<E> r10 = this.entryIterator.next();
            this.currentEntry = r10;
            int r11 = r10.getCount();
            this.laterCount = r11;
            this.totalCount = r11;
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

    public static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;

        @MonotonicNonNullDecl
        transient Set<E> elementSet;

        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        public UnmodifiableMultiset(Multiset<? extends E> r10) {
            this.delegate = r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(E r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> r10 = this.elementSet;
            if (r10 != null) goto L6;
            Set<E> r11 = createElementSet();
            this.elementSet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> r10 = this.entrySet;
            if (r10 != null) goto L6;
            Set<Multiset.Entry<E>> r11 = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = r11;
            return r11;
        L6:
            return r10;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(E r10, int r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(E r10, int r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(Object r10, int r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(E r10, int r11, int r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Multiset<E> delegate() {
            return this.delegate;
        }
    }

    public static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.AbstractMultiset
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<E> iterator() {
            return Multisets.iteratorImpl(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.linearTimeSizeImpl(this);
        }

        public /* synthetic */ ViewMultiset(AnonymousClass1 r10) {
            this();
        }
    }

    private Multisets() {
    }

    public static <E> boolean addAllImpl(Multiset<E> r10, Collection<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if ((r11 instanceof Multiset) == false) goto L7;
        return addAllImpl(r10, cast(r11));
    L7:
        if (r11.isEmpty() == false) goto L11;
        return false;
    L11:
        return Iterators.addAll(r10, r11.iterator());
    }

    public static <T> Multiset<T> cast(Iterable<T> r10) {
        return (Multiset) r10;
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> r10, Multiset<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Iterator<Multiset.Entry<?>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Multiset.Entry<?> r13 = r12.next();
        if (r10.count(r13.getElement()) >= r13.getCount()) goto L4;
        return false;
    L9:
        return true;
    }

    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> r10) {
        Multiset.Entry[] r11 = (Multiset.Entry[]) r10.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(r11, DecreasingCount.INSTANCE);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(r11));
    }

    @Beta
    public static <E> Multiset<E> difference(final Multiset<E> r10, final Multiset<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass4(r10, r11);
    }

    public static <E> Iterator<E> elementIterator(final Iterator<Multiset.Entry<E>> r10) {
        return new AnonymousClass5(r10);
    }

    public static boolean equalsImpl(Multiset<?> r10, @NullableDecl Object r11) {
        if (r11 != r10) goto L6;
        return true;
    L6:
        if ((r11 instanceof Multiset) == false) goto L19;
        Multiset r12 = (Multiset) r11;
        if (r10.size() != r12.size()) goto L19;
        if (r10.entrySet().size() != r12.entrySet().size()) goto L19;
        Iterator r13 = r12.entrySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        Multiset.Entry r14 = (Multiset.Entry) r13.next();
        if (r10.count(r14.getElement()) == r14.getCount()) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof FilteredMultiset) == false) goto L7;
        FilteredMultiset r12 = (FilteredMultiset) r10;
        Predicate r13 = Predicates.and(r12.predicate, r11);
        return new FilteredMultiset(r12.unfiltered, r13);
    L7:
        return new FilteredMultiset(r10, r11);
    }

    public static <E> Multiset.Entry<E> immutableEntry(@NullableDecl E r10, int r11) {
        return new ImmutableEntry(r10, r11);
    }

    public static int inferDistinctElements(Iterable<?> r10) {
        if ((r10 instanceof Multiset) == true) goto L5;
        return 11;
    L5:
        return ((Multiset) r10).elementSet().size();
    }

    public static <E> Multiset<E> intersection(final Multiset<E> r10, final Multiset<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass2(r10, r11);
    }

    public static <E> Iterator<E> iteratorImpl(Multiset<E> r10) {
        return new MultisetIteratorImpl(r10, r10.entrySet().iterator());
    }

    public static int linearTimeSizeImpl(Multiset<?> r10) {
        Iterator<Multiset.Entry<?>> r11 = r10.entrySet().iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L7;
        r12 = r12 + ((long) r11.next().getCount());
        goto L4
    L7:
        return Ints.saturatedCast(r12);
    }

    public static boolean removeAllImpl(Multiset<?> r10, Collection<?> r11) {
        if ((r11 instanceof Multiset) == false) goto L6;
        r11 = ((Multiset) r11).elementSet();
    L6:
        return r10.elementSet().removeAll(r11);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> r10, Iterable<?> r11) {
        if ((r11 instanceof Multiset) == true) goto L5;
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Iterator<?> r12 = r11.iterator();
        boolean r13 = false;
    L8:
        if (r12.hasNext() == false) goto L10;
        r13 = r13 | r10.remove(r12.next());
        goto L8
    L10:
        return r13;
    L5:
        return removeOccurrences(r10, (Multiset) r11);
    }

    public static boolean retainAllImpl(Multiset<?> r10, Collection<?> r11) {
        Preconditions.checkNotNull(r11);
        if ((r11 instanceof Multiset) == false) goto L6;
        r11 = ((Multiset) r11).elementSet();
    L6:
        return r10.elementSet().retainAll(r11);
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> r10, Multiset<?> r11) {
        return retainOccurrencesImpl(r10, r11);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> r10, Multiset<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Iterator<Multiset.Entry<E>> r12 = r10.entrySet().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L12;
        Multiset.Entry<E> r14 = r12.next();
        int r15 = r11.count(r14.getElement());
        if (r15 == 0) goto L7;
        if (r15 >= r14.getCount()) goto L4;
        r10.setCount(r14.getElement(), r15);
    L8:
        r13 = true;
        goto L4
    L7:
        r12.remove();
        goto L8
    L12:
        return r13;
    }

    public static <E> int setCountImpl(Multiset<E> r10, E r11, int r12) {
        CollectPreconditions.checkNonnegative(r12, "count");
        int r13 = r10.count(r11);
        int r14 = r12 - r13;
        if (r14 <= 0) goto L5;
        r10.add(r11, r14);
    L7:
        return r13;
    L5:
        if (r14 >= 0) goto L7;
        r10.remove(r11, -r14);
        goto L7
    }

    @Beta
    public static <E> Multiset<E> sum(final Multiset<? extends E> r10, final Multiset<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass3(r10, r11);
    }

    @Beta
    public static <E> Multiset<E> union(final Multiset<? extends E> r10, final Multiset<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass1(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> r10) {
        if ((r10 instanceof UnmodifiableMultiset) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableMultiset) == true) goto L9;
        return new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(r10));
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> r10) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.checkNotNull(r10));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> r10) {
        return (Multiset) Preconditions.checkNotNull(r10);
    }

    public static <E> boolean setCountImpl(Multiset<E> r10, E r11, int r12, int r13) {
        CollectPreconditions.checkNonnegative(r12, "oldCount");
        CollectPreconditions.checkNonnegative(r13, "newCount");
        if (r10.count(r11) != r12) goto L6;
        r10.setCount(r11, r13);
        return true;
    L6:
        return false;
    }

    private static <E> boolean addAllImpl(Multiset<E> r10, Multiset<? extends E> r11) {
        if ((r11 instanceof AbstractMapBasedMultiset) == false) goto L7;
        return addAllImpl(r10, (AbstractMapBasedMultiset) r11);
    L7:
        if (r11.isEmpty() == false) goto L10;
        return false;
    L10:
        Iterator<Multiset.Entry<? extends E>> r12 = r11.entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        Multiset.Entry<? extends E> r13 = r12.next();
        r10.add(r13.getElement(), r13.getCount());
        goto L12
    L14:
        return true;
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> r10, Multiset<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Iterator<Multiset.Entry<?>> r12 = r10.entrySet().iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L11;
        Multiset.Entry<?> r14 = r12.next();
        int r15 = r11.count(r14.getElement());
        if (r15 >= r14.getCount()) goto L7;
        if (r15 <= 0) goto L4;
        r10.remove(r14.getElement(), r15);
    L8:
        r13 = true;
        goto L4
    L7:
        r12.remove();
        goto L8
    L11:
        return r13;
    }

    private static <E> boolean addAllImpl(Multiset<E> r10, AbstractMapBasedMultiset<? extends E> r11) {
        if (r11.isEmpty() == false) goto L6;
        return false;
    L6:
        r11.addTo(r10);
        return true;
    }
}
