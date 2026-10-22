package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Iterators {

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> EMPTY = null;
        private final T[] array;
        private final int offset;

        static {
            EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        }

        public ArrayItr(T[] r10, int r11, int r12, int r13) {
            super(r12, r13);
            this.array = r10;
            this.offset = r11;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public T get(int r10) {
            return this.array[this.offset + r10];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator;

        @NullableDecl
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;

        @NullableDecl
        private Iterator<? extends T> toRemove;
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> r10) {
            this.iterator = Iterators.emptyIterator();
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(r10);
        }

        @NullableDecl
        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
        L2:
            Iterator<? extends Iterator<? extends T>> r10 = this.topMetaIterator;
            if (r10 != null) goto L5;
        L9:
            Deque<Iterator<? extends Iterator<? extends T>>> r11 = this.metaIterators;
            if (r11 == null) goto L14;
            if (r11.isEmpty() == true) goto L19;
            this.topMetaIterator = this.metaIterators.removeFirst();
            goto L2
        L19:
            return null;
        L14:
            return null;
        L5:
            if (r10.hasNext() == false) goto L9;
            return this.topMetaIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext() == true) goto L19;
            Iterator<? extends Iterator<? extends T>> r10 = getTopMetaIterator();
            this.topMetaIterator = r10;
            if (r10 == null) goto L6;
            Iterator<? extends T> r11 = r10.next();
            this.iterator = r11;
            if ((r11 instanceof ConcatenatedIterator) == false) goto L3;
            ConcatenatedIterator r12 = (ConcatenatedIterator) r11;
            this.iterator = r12.iterator;
            if (this.metaIterators != null) goto L13;
            this.metaIterators = new ArrayDeque();
        L13:
            this.metaIterators.addFirst(this.topMetaIterator);
            if (r12.metaIterators != null) goto L16;
        L18:
            this.topMetaIterator = r12.topMetaIterator;
        L16:
            if (r12.metaIterators.isEmpty() == true) goto L18;
            this.metaIterators.addFirst(r12.metaIterators.removeLast());
            goto L16
        L6:
            return false;
        L19:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            Iterator<? extends T> r10 = this.iterator;
            this.toRemove = r10;
            return r10.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.toRemove == null) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            this.toRemove.remove();
            this.toRemove = null;
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    public static final enum EmptyModifiableIterator extends Enum<EmptyModifiableIterator> implements Iterator<Object> {
        private static final /* synthetic */ EmptyModifiableIterator[] $VALUES = null;
        public static final EmptyModifiableIterator INSTANCE = null;

        static {
            EmptyModifiableIterator r10 = new EmptyModifiableIterator("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new EmptyModifiableIterator[]{r10};
        }

        private EmptyModifiableIterator(String r10, int r11) {
            super(r10, r11);
        }

        public static EmptyModifiableIterator valueOf(String r10) {
            return (EmptyModifiableIterator) Enum.valueOf(EmptyModifiableIterator.class, r10);
        }

        public static EmptyModifiableIterator[] values() {
            return (EmptyModifiableIterator[]) $VALUES.clone();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> r10, final Comparator<? super T> r11) {
            this.queue = new PriorityQueue(2, new AnonymousClass1(this, r11));
            Iterator<? extends Iterator<? extends T>> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            Iterator<? extends T> r13 = r12.next();
            if (r13.hasNext() == false) goto L4;
            this.queue.add(Iterators.peekingIterator(r13));
            goto L4
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> r10 = this.queue.remove();
            T r11 = r10.next();
            if (r10.hasNext() == false) goto L5;
            this.queue.add(r10);
        L5:
            return r11;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;

        @NullableDecl
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> r10) {
            this.iterator = (Iterator) Preconditions.checkNotNull(r10);
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

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (this.hasPeeked == false) goto L5;
            E r10 = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return r10;
        L5:
            return this.iterator.next();
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (this.hasPeeked == true) goto L6;
            this.peekedElement = this.iterator.next();
            this.hasPeeked = true;
        L6:
            return this.peekedElement;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }
    }

    private Iterators() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> r10, Iterator<? extends T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | r10.add(r11.next());
        goto L4
    L6:
        return r12;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> r10, int r11) {
        Preconditions.checkNotNull(r10);
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "numberToAdvance must be nonnegative");
    L7:
        if (r12 >= r11) goto L11;
        if (r10.hasNext() == false) goto L11;
        r10.next();
        r12 = r12 + 1;
    L11:
        return r12;
    L5:
        r13 = false;
        goto L6
    }

    public static <T> boolean all(Iterator<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r11);
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r11.apply(r10.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static <T> boolean any(Iterator<T> r10, Predicate<? super T> r11) {
        if (indexOf(r10, r11) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass11(r10);
    }

    public static <T> ListIterator<T> cast(Iterator<T> r10) {
        return (ListIterator) r10;
    }

    public static void checkNonnegative(int r10) {
        if (r10 < 0) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("position (" + r10 + ") must not be negative");
    }

    public static void clear(Iterator<?> r10) {
        Preconditions.checkNotNull(r10);
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next();
        r10.remove();
        goto L4
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r10, Iterator<? extends T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return concat(consumingForArray(new Iterator[]{r10, r11}));
    }

    public static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... r10) {
        Iterator[] r11 = (Iterator[]) Preconditions.checkNotNull(r10);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        Preconditions.checkNotNull(r11[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        return concat(consumingForArray(r10));
    }

    private static <T> Iterator<T> consumingForArray(final T... r10) {
        return new AnonymousClass3(r10);
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass8(r10);
    }

    public static boolean contains(Iterator<?> r10, @NullableDecl Object r11) {
        if (r11 != null) goto L10;
    L5:
        if (r10.hasNext() == false) goto L14;
        if (r10.next() != null) goto L5;
        return true;
    L14:
        return false;
    L10:
        if (r10.hasNext() == false) goto L22;
        if (r11.equals(r10.next()) == false) goto L10;
        return true;
    L22:
        return false;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass2(r10);
    }

    public static boolean elementsEqual(Iterator<?> r10, Iterator<?> r11) {
    L3:
        if (r10.hasNext() == false) goto L11;
        if (r11.hasNext() == false) goto L6;
        if (Objects.equal(r10.next(), r11.next()) == true) goto L3;
        return false;
    L6:
        return false;
    L11:
        return !r11.hasNext();
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    public static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return (UnmodifiableListIterator<T>) ArrayItr.EMPTY;
    }

    public static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> r10, final Predicate<? super T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass5(r10, r11);
    }

    public static <T> T find(Iterator<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
    L4:
        if (r10.hasNext() == false) goto L9;
        T r12 = r10.next();
        if (r11.apply(r12) == false) goto L4;
        return r12;
    L9:
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... r10) {
        return forArray(r10, 0, r10.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass10(r10);
    }

    public static int frequency(Iterator<?> r10, @NullableDecl Object r11) {
        int r12 = 0;
    L4:
        if (contains(r10, r11) == false) goto L6;
        r12 = r12 + 1;
        goto L4
    L6:
        return r12;
    }

    public static <T> T get(Iterator<T> r10, int r11) {
        checkNonnegative(r11);
        int r12 = advance(r10, r11);
        if (r10.hasNext() == false) goto L7;
        return r10.next();
    L7:
        throw new IndexOutOfBoundsException("position (" + r11 + ") must be less than the number of elements that remained (" + r12 + ")");
    }

    public static <T> T getLast(Iterator<T> r10) {
    L2:
        T r11 = r10.next();
        if (r10.hasNext() == true) goto L2;
        return r11;
    }

    @NullableDecl
    public static <T> T getNext(Iterator<? extends T> r10, @NullableDecl T r11) {
        if (r10.hasNext() == true) goto L5;
        return r11;
    L5:
        return r10.next();
    }

    public static <T> T getOnlyElement(Iterator<T> r10) {
        T r11 = r10.next();
        if (r10.hasNext() == true) goto L5;
        return r11;
    L5:
        StringBuilder r12 = new StringBuilder();
        r12.append("expected one element but was: <");
        r12.append(r11);
        int r13 = 0;
    L7:
        if (r13 >= 4) goto L12;
        if (r10.hasNext() == false) goto L12;
        r12.append(", ");
        r12.append(r10.next());
        r13 = r13 + 1;
    L12:
        if (r10.hasNext() == false) goto L14;
        r12.append(", ...");
    L14:
        r12.append('>');
        throw new IllegalArgumentException(r12.toString());
    }

    public static <T> int indexOf(Iterator<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r11, "predicate");
        int r12 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r11.apply(r10.next()) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r12;
    L9:
        return -1;
    }

    public static <T> Iterator<T> limit(final Iterator<T> r10, final int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "limit is negative");
        return new AnonymousClass7(r11, r10);
    L5:
        r12 = false;
        goto L6
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> r10, Comparator<? super T> r11) {
        Preconditions.checkNotNull(r10, "iterators");
        Preconditions.checkNotNull(r11, "comparator");
        return new MergingIterator(r10, r11);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> r10, int r11) {
        return partitionImpl(r10, r11, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> r10, int r11) {
        return partitionImpl(r10, r11, false);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> r10, final int r11, final boolean r12) {
        Preconditions.checkNotNull(r10);
        if (r11 <= 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        return new AnonymousClass4(r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> r10) {
        if ((r10 instanceof PeekingImpl) == false) goto L7;
        return (PeekingImpl) r10;
    L7:
        return new PeekingImpl(r10);
    }

    @NullableDecl
    public static <T> T pollNext(Iterator<T> r10) {
        if (r10.hasNext() == false) goto L6;
        T r11 = r10.next();
        r10.remove();
        return r11;
    L6:
        return null;
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> r10, Collection<?> r11) {
        Preconditions.checkNotNull(r11);
        boolean r12 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r11.contains(r10.next()) == false) goto L4;
        r10.remove();
        r12 = true;
        goto L4
    L8:
        return r12;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r11);
        boolean r12 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r11.apply(r10.next()) == false) goto L4;
        r10.remove();
        r12 = true;
        goto L4
    L8:
        return r12;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> r10, Collection<?> r11) {
        Preconditions.checkNotNull(r11);
        boolean r12 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r11.contains(r10.next()) == true) goto L4;
        r10.remove();
        r12 = true;
        goto L4
    L8:
        return r12;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@NullableDecl final T r10) {
        return new AnonymousClass9(r10);
    }

    public static int size(Iterator<?> r10) {
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L7;
        r10.next();
        r11 = r11 + 1;
        goto L4
    L7:
        return Ints.saturatedCast(r11);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> r10, Class<T> r11) {
        return (T[]) Iterables.toArray(Lists.newArrayList(r10), r11);
    }

    public static String toString(Iterator<?> r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append('[');
        boolean r12 = true;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r12 == true) goto L7;
        r11.append(", ");
    L7:
        r11.append(r10.next());
        r12 = false;
        goto L4
    L8:
        r11.append(']');
        return r11.toString();
    }

    public static <F, T> Iterator<T> transform(final Iterator<F> r10, final Function<? super F, ? extends T> r11) {
        Preconditions.checkNotNull(r11);
        return new AnonymousClass6(r10, r11);
    }

    public static <T> Optional<T> tryFind(Iterator<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
    L4:
        if (r10.hasNext() == false) goto L10;
        T r12 = r10.next();
        if (r11.apply(r12) == false) goto L4;
        return Optional.of(r12);
    L10:
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof UnmodifiableIterator) == false) goto L7;
        return (UnmodifiableIterator) r10;
    L7:
        return new AnonymousClass1(r10);
    }

    public static <T> UnmodifiableListIterator<T> forArray(T[] r10, int r11, int r12, int r13) {
        if (r12 < 0) goto L4;
        boolean r14 = true;
    L5:
        Preconditions.checkArgument(r14);
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        Preconditions.checkPositionIndex(r13, r12);
        if (r12 != 0) goto L10;
        return emptyListIterator();
    L10:
        return new ArrayItr(r10, r11, r12, r13);
    L4:
        r14 = false;
        goto L5
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... r10) {
        return cycle(Lists.newArrayList(r10));
    }

    @NullableDecl
    public static <T> T getLast(Iterator<? extends T> r10, @NullableDecl T r11) {
        if (r10.hasNext() == true) goto L5;
        return r11;
    L5:
        return (T) getLast(r10);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r10, Iterator<? extends T> r11, Iterator<? extends T> r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        return concat(consumingForArray(new Iterator[]{r10, r11, r12}));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> r10, Class<T> r11) {
        return filter(r10, Predicates.instanceOf(r11));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> r10) {
        return (PeekingIterator) Preconditions.checkNotNull(r10);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> r10) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(r10);
    }

    @NullableDecl
    public static <T> T get(Iterator<? extends T> r10, int r11, @NullableDecl T r12) {
        checkNonnegative(r11);
        advance(r10, r11);
        return (T) getNext(r10, r12);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @NullableDecl
    public static <T> T find(Iterator<? extends T> r10, Predicate<? super T> r11, @NullableDecl T r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
    L4:
        if (r10.hasNext() == false) goto L8;
        T r13 = r10.next();
        if (r11.apply(r13) == false) goto L4;
        return r13;
    L8:
        return r12;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> r10, Iterator<? extends T> r11, Iterator<? extends T> r12, Iterator<? extends T> r13) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        Preconditions.checkNotNull(r13);
        return concat(consumingForArray(new Iterator[]{r10, r11, r12, r13}));
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterator<? extends T> r10, @NullableDecl T r11) {
        if (r10.hasNext() == true) goto L5;
        return r11;
    L5:
        return (T) getOnlyElement(r10);
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... r10) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(r10, r10.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> r10) {
        return new ConcatenatedIterator(r10);
    }
}
