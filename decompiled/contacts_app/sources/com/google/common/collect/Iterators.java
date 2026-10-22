package com.google.common.collect;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Iterators {
    static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = null;
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = null;

    private static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> r3, final Comparator<? super T> r4) {
            this.queue = new PriorityQueue(2, new AnonymousClass1(this, r4));
            Iterator<? extends Iterator<? extends T>> r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Iterator<? extends T> r6 = r5.next();
            if (r6.hasNext() == false) goto L4;
            this.queue.add(Iterators.peekingIterator(r6));
            goto L4
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> r0 = this.queue.remove();
            T r1 = r0.next();
            if (r0.hasNext() == false) goto L5;
            this.queue.add(r0);
        L5:
            return r1;
        }
    }

    private static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> r1) {
            this.iterator = (Iterator) Preconditions.checkNotNull(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasPeeked == false) goto L5;
        L8:
            return true;
        L5:
            if (this.iterator.hasNext() == true) goto L8;
            return false;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E next() {
            if (this.hasPeeked == false) goto L5;
            E r0 = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return r0;
        L5:
            return this.iterator.next();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (this.hasPeeked == true) goto L6;
            this.peekedElement = this.iterator.next();
            this.hasPeeked = true;
        L6:
            return this.peekedElement;
        }
    }

    private Iterators() {
    }

    static {
        EMPTY_LIST_ITERATOR = new AnonymousClass1();
        EMPTY_MODIFIABLE_ITERATOR = new AnonymousClass2();
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return (UnmodifiableListIterator<T>) EMPTY_LIST_ITERATOR;
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return (Iterator<T>) EMPTY_MODIFIABLE_ITERATOR;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<T> r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof UnmodifiableIterator) == false) goto L7;
        return (UnmodifiableIterator) r1;
    L7:
        return new AnonymousClass3(r1);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> r0) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(r0);
    }

    public static int size(Iterator<?> r2) {
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next();
        r0 = r0 + 1;
        goto L4
    L6:
        return r0;
    }

    public static boolean contains(Iterator<?> r0, @Nullable Object r1) {
        return any(r0, Predicates.equalTo(r1));
    }

    public static boolean removeAll(Iterator<?> r0, Collection<?> r1) {
        return removeIf(r0, Predicates.in(r1));
    }

    public static <T> boolean removeIf(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r3.apply(r2.next()) == false) goto L4;
        r2.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean retainAll(Iterator<?> r0, Collection<?> r1) {
        return removeIf(r0, Predicates.not(Predicates.in(r1)));
    }

    public static boolean elementsEqual(Iterator<?> r3, Iterator<?> r4) {
    L3:
        if (r3.hasNext() == false) goto L11;
        if (r4.hasNext() == false) goto L6;
        if (Objects.equal(r3.next(), r4.next()) == true) goto L3;
        return false;
    L6:
        return false;
    L11:
        return !r4.hasNext();
    }

    public static String toString(Iterator<?> r3) {
        return Collections2.STANDARD_JOINER.appendTo(new StringBuilder().append(DefaultContactListAdapter.SNIPPET_START_MATCH), r3).append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
    }

    public static <T> T getOnlyElement(Iterator<T> r4) {
        T r0 = r4.next();
        if (r4.hasNext() == true) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder();
        r1.append("expected one element but was: <" + r0);
        int r2 = 0;
    L7:
        if (r2 >= 4) goto L12;
        if (r4.hasNext() == false) goto L12;
        r1.append(", " + r4.next());
        r2 = r2 + 1;
    L12:
        if (r4.hasNext() == false) goto L14;
        r1.append(", ...");
    L14:
        r1.append('>');
        throw new IllegalArgumentException(r1.toString());
    }

    @Nullable
    public static <T> T getOnlyElement(Iterator<? extends T> r1, @Nullable T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return (T) getOnlyElement(r1);
    }

    public static <T> T[] toArray(Iterator<? extends T> r0, Class<T> r1) {
        return (T[]) Iterables.toArray(Lists.newArrayList(r0), r1);
    }

    public static <T> boolean addAll(Collection<T> r2, Iterator<? extends T> r3) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 | r2.add(r3.next());
        goto L4
    L6:
        return r0;
    }

    public static int frequency(Iterator<?> r0, @Nullable Object r1) {
        return size(filter(r0, Predicates.equalTo(r1)));
    }

    public static <T> Iterator<T> cycle(final Iterable<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass4(r1);
    }

    public static <T> Iterator<T> cycle(T... r0) {
        return cycle(Lists.newArrayList(r0));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r0, Iterator<? extends T> r1) {
        return concat(ImmutableList.of(r0, r1).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r0, Iterator<? extends T> r1, Iterator<? extends T> r2) {
        return concat(ImmutableList.of(r0, r1, r2).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r0, Iterator<? extends T> r1, Iterator<? extends T> r2, Iterator<? extends T> r3) {
        return concat(ImmutableList.of(r0, r1, r2, r3).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... r0) {
        return concat(ImmutableList.copyOf(r0).iterator());
    }

    public static <T> Iterator<T> concat(final Iterator<? extends Iterator<? extends T>> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass5(r1);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> r1, int r2) {
        return partitionImpl(r1, r2, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> r1, int r2) {
        return partitionImpl(r1, r2, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> r1, final int r2, final boolean r3) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass6(r1, r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> r1, final Predicate<? super T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass7(r1, r2);
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<?> r0, Class<T> r1) {
        return filter(r0, Predicates.instanceOf(r1));
    }

    public static <T> boolean any(Iterator<T> r0, Predicate<? super T> r1) {
        if (indexOf(r0, r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> boolean all(Iterator<T> r1, Predicate<? super T> r2) {
        Preconditions.checkNotNull(r2);
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r2.apply(r1.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static <T> T find(Iterator<T> r0, Predicate<? super T> r1) {
        return (T) filter(r0, r1).next();
    }

    @Nullable
    public static <T> T find(Iterator<? extends T> r0, Predicate<? super T> r1, @Nullable T r2) {
        return (T) getNext(filter(r0, r1), r2);
    }

    public static <T> Optional<T> tryFind(Iterator<T> r0, Predicate<? super T> r1) {
        UnmodifiableIterator r2 = filter(r0, r1);
        if (r2.hasNext() == false) goto L6;
        return Optional.of(r2.next());
    L6:
        return Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3, "predicate");
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r3.apply(r2.next()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public static <F, T> Iterator<T> transform(final Iterator<F> r1, final Function<? super F, ? extends T> r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass8(r1, r2);
    }

    public static <T> T get(Iterator<T> r3, int r4) {
        checkNonnegative(r4);
        int r0 = advance(r3, r4);
        if (r3.hasNext() == false) goto L7;
        return r3.next();
    L7:
        throw new IndexOutOfBoundsException("position (" + r4 + ") must be less than the number of elements that remained (" + r0 + ")");
    }

    static void checkNonnegative(int r3) {
        if (r3 < 0) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("position (" + r3 + ") must not be negative");
    }

    @Nullable
    public static <T> T get(Iterator<? extends T> r0, int r1, @Nullable T r2) {
        checkNonnegative(r1);
        advance(r0, r1);
        return (T) getNext(r0, r2);
    }

    @Nullable
    public static <T> T getNext(Iterator<? extends T> r1, @Nullable T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return r1.next();
    }

    public static <T> T getLast(Iterator<T> r2) {
    L2:
        T r0 = r2.next();
        if (r2.hasNext() == true) goto L2;
        return r0;
    }

    @Nullable
    public static <T> T getLast(Iterator<? extends T> r1, @Nullable T r2) {
        if (r1.hasNext() == true) goto L5;
        return r2;
    L5:
        return (T) getLast(r1);
    }

    public static int advance(Iterator<?> r3, int r4) {
        Preconditions.checkNotNull(r3);
        int r0 = 0;
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "numberToAdvance must be nonnegative");
    L7:
        if (r0 >= r4) goto L11;
        if (r3.hasNext() == false) goto L11;
        r3.next();
        r0 = r0 + 1;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static <T> Iterator<T> limit(final Iterator<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "limit is negative");
        return new AnonymousClass9(r3, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass10(r1);
    }

    @Nullable
    static <T> T pollNext(Iterator<T> r1) {
        if (r1.hasNext() == false) goto L6;
        T r0 = r1.next();
        r1.remove();
        return r0;
    L6:
        return null;
    }

    static void clear(Iterator<?> r1) {
        Preconditions.checkNotNull(r1);
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next();
        r1.remove();
        goto L4
    }

    public static <T> UnmodifiableIterator<T> forArray(T... r2) {
        return forArray(r2, 0, r2.length, 0);
    }

    static <T> UnmodifiableListIterator<T> forArray(final T[] r2, final int r3, final int r4, final int r5) {
        if (r4 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0);
        Preconditions.checkPositionIndexes(r3, r3 + r4, r2.length);
        Preconditions.checkPositionIndex(r5, r4);
        if (r4 != 0) goto L10;
        return emptyListIterator();
    L10:
        return new AnonymousClass11(r4, r5, r2, r3);
    L4:
        r0 = false;
        goto L5
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable final T r1) {
        return new AnonymousClass12(r1);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass13(r1);
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass14(r1);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> r1) {
        if ((r1 instanceof PeekingImpl) == false) goto L7;
        return (PeekingImpl) r1;
    L7:
        return new PeekingImpl(r1);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> r0) {
        return (PeekingIterator) Preconditions.checkNotNull(r0);
    }

    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> r1, Comparator<? super T> r2) {
        Preconditions.checkNotNull(r1, "iterators");
        Preconditions.checkNotNull(r2, "comparator");
        return new MergingIterator(r1, r2);
    }

    static <T> ListIterator<T> cast(Iterator<T> r0) {
        return (ListIterator) r0;
    }
}
