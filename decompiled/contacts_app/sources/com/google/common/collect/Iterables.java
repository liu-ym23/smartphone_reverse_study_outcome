package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Iterables {

    private static class ConsumingQueueIterator<T> extends AbstractIterator<T> {
        private final Queue<T> queue;

        /* synthetic */ ConsumingQueueIterator(Queue r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ConsumingQueueIterator(Queue<T> r1) {
            this.queue = r1;
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
            return this.queue.remove();
        L5:
            return endOfData();
        }
    }

    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<T> iterable;

        /* synthetic */ UnmodifiableIterable(Iterable r1, AnonymousClass1 r2) {
            this(r1);
        }

        private UnmodifiableIterable(Iterable<T> r1) {
            this.iterable = r1;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }
    }

    static /* synthetic */ Iterator access$100(Iterable r0) {
        return iterators(r0);
    }

    static /* synthetic */ Function access$300() {
        return toIterator();
    }

    private Iterables() {
    }

    public static <T> Iterable<T> unmodifiableIterable(Iterable<T> r2) {
        Preconditions.checkNotNull(r2);
        if ((r2 instanceof UnmodifiableIterable) == false) goto L5;
    L9:
        return r2;
    L5:
        if ((r2 instanceof ImmutableCollection) == true) goto L9;
        return new UnmodifiableIterable(r2, null);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> r0) {
        return (Iterable) Preconditions.checkNotNull(r0);
    }

    public static int size(Iterable<?> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).size();
    L6:
        return Iterators.size(r1.iterator());
    }

    public static boolean contains(Iterable<?> r1, @Nullable Object r2) {
        if ((r1 instanceof Collection) == false) goto L7;
        return Collections2.safeContains((Collection) r1, r2);
    L7:
        return Iterators.contains(r1.iterator(), r2);
    }

    public static boolean removeAll(Iterable<?> r1, Collection<?> r2) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).removeAll((Collection) Preconditions.checkNotNull(r2));
    L6:
        return Iterators.removeAll(r1.iterator(), r2);
    }

    public static boolean retainAll(Iterable<?> r1, Collection<?> r2) {
        if ((r1 instanceof Collection) == false) goto L6;
        return ((Collection) r1).retainAll((Collection) Preconditions.checkNotNull(r2));
    L6:
        return Iterators.retainAll(r1.iterator(), r2);
    }

    public static <T> boolean removeIf(Iterable<T> r1, Predicate<? super T> r2) {
        if ((r1 instanceof RandomAccess) == false) goto L9;
        if ((r1 instanceof List) == false) goto L9;
        return removeIfFromRandomAccessList((List) r1, (Predicate) Preconditions.checkNotNull(r2));
    L9:
        return Iterators.removeIf(r1.iterator(), r2);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> r6, Predicate<? super T> r7) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r6.size()) goto L14;
        T r3 = r6.get(r1);
        if (r7.apply(r3) == true) goto L13;
        if (r1 > r2) goto L18;
    L12:
        r2 = r2 + 1;
        goto L13
    L18:
        r6.set(r2, r3);     // Catch: UnsupportedOperationException -> L10
    L10:
        slowRemoveIfForRemainingElements(r6, r7, r2, r1);
        return true;
    L13:
        r1 = r1 + 1;
        goto L4
    L14:
        r6.subList(r2, r6.size()).clear();
        if (r1 != r2) goto L17;
        return false;
    L17:
        return true;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> r2, Predicate<? super T> r3, int r4, int r5) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 <= r5) goto L8;
        if (r3.apply(r2.get(r0)) == false) goto L7;
        r2.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    L8:
        int r6 = r5 - 1;
    L9:
        if (r6 < r4) goto L11;
        r2.remove(r6);
        r6 = r6 - 1;
        goto L9
    }

    @Nullable
    static <T> T removeFirstMatching(Iterable<T> r2, Predicate<? super T> r3) {
        Preconditions.checkNotNull(r3);
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        T r0 = r4.next();
        if (r3.apply(r0) == false) goto L4;
        r4.remove();
        return r0;
    L9:
        return null;
    }

    public static boolean elementsEqual(Iterable<?> r2, Iterable<?> r3) {
        if ((r2 instanceof Collection) == false) goto L11;
        if ((r3 instanceof Collection) == false) goto L11;
        if (((Collection) r2).size() == ((Collection) r3).size()) goto L11;
        return false;
    L11:
        return Iterators.elementsEqual(r2.iterator(), r3.iterator());
    }

    public static String toString(Iterable<?> r0) {
        return Iterators.toString(r0.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> r0) {
        return (T) Iterators.getOnlyElement(r0.iterator());
    }

    @Nullable
    public static <T> T getOnlyElement(Iterable<? extends T> r0, @Nullable T r1) {
        return (T) Iterators.getOnlyElement(r0.iterator(), r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] toArray(Iterable<? extends T> r1, Class<T> r2) {
        Collection r3 = toCollection(r1);
        return (T[]) r3.toArray(ObjectArrays.newArray(r2, r3.size()));
    }

    static Object[] toArray(Iterable<?> r0) {
        return toCollection(r0).toArray();
    }

    private static <E> Collection<E> toCollection(Iterable<E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return (Collection) r1;
    L6:
        return Lists.newArrayList(r1.iterator());
    }

    public static <T> boolean addAll(Collection<T> r1, Iterable<? extends T> r2) {
        if ((r2 instanceof Collection) == false) goto L7;
        return r1.addAll(Collections2.cast(r2));
    L7:
        return Iterators.addAll(r1, ((Iterable) Preconditions.checkNotNull(r2)).iterator());
    }

    public static int frequency(Iterable<?> r1, @Nullable Object r2) {
        if ((r1 instanceof Multiset) == false) goto L7;
        return ((Multiset) r1).count(r2);
    L7:
        if ((r1 instanceof Set) == false) goto L11;
        return ((Set) r1).contains(r2) ? 1 : 0;
    L11:
        return Iterators.frequency(r1.iterator(), r2);
    }

    public static <T> Iterable<T> cycle(final Iterable<T> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }

    public static <T> Iterable<T> cycle(T... r0) {
        return cycle(Lists.newArrayList(r0));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1) {
        return concat(ImmutableList.of(r0, r1));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1, Iterable<? extends T> r2) {
        return concat(ImmutableList.of(r0, r1, r2));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r0, Iterable<? extends T> r1, Iterable<? extends T> r2, Iterable<? extends T> r3) {
        return concat(ImmutableList.of(r0, r1, r2, r3));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T>... r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static <T> Iterable<T> concat(final Iterable<? extends Iterable<? extends T>> r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass2(r1);
    }

    private static <T> Iterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> r1) {
        final Iterator<? extends Iterable<? extends T>> r2 = r1.iterator();
        return new AnonymousClass3(r2);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> r1, final int r2) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass4(r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> r1, final int r2) {
        Preconditions.checkNotNull(r1);
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        return new AnonymousClass5(r1, r2);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> filter(final Iterable<T> r1, final Predicate<? super T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass6(r1, r2);
    }

    public static <T> Iterable<T> filter(final Iterable<?> r1, final Class<T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass7(r1, r2);
    }

    public static <T> boolean any(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.any(r0.iterator(), r1);
    }

    public static <T> boolean all(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.all(r0.iterator(), r1);
    }

    public static <T> T find(Iterable<T> r0, Predicate<? super T> r1) {
        return (T) Iterators.find(r0.iterator(), r1);
    }

    @Nullable
    public static <T> T find(Iterable<? extends T> r0, Predicate<? super T> r1, @Nullable T r2) {
        return (T) Iterators.find(r0.iterator(), r1, r2);
    }

    public static <T> Optional<T> tryFind(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.tryFind(r0.iterator(), r1);
    }

    public static <T> int indexOf(Iterable<T> r0, Predicate<? super T> r1) {
        return Iterators.indexOf(r0.iterator(), r1);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> r1, final Function<? super F, ? extends T> r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        return new AnonymousClass8(r1, r2);
    }

    public static <T> T get(Iterable<T> r1, int r2) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof List) == false) goto L6;
        return (T) ((List) r1).get(r2);
    L6:
        return (T) Iterators.get(r1.iterator(), r2);
    }

    @Nullable
    public static <T> T get(Iterable<? extends T> r1, int r2, @Nullable T r3) {
        Preconditions.checkNotNull(r1);
        Iterators.checkNonnegative(r2);
        if ((r1 instanceof List) == false) goto L8;
        List r4 = Lists.cast(r1);
        if (r2 < r4.size()) goto L7;
        return r3;
    L7:
        return (T) r4.get(r2);
    L8:
        Iterator<? extends T> r5 = r1.iterator();
        Iterators.advance(r5, r2);
        return (T) Iterators.getNext(r5, r3);
    }

    @Nullable
    public static <T> T getFirst(Iterable<? extends T> r0, @Nullable T r1) {
        return (T) Iterators.getNext(r0.iterator(), r1);
    }

    public static <T> T getLast(Iterable<T> r1) {
        if ((r1 instanceof List) == false) goto L11;
        List r2 = (List) r1;
        if (r2.isEmpty() == true) goto L9;
        return (T) getLastInNonemptyList(r2);
    L9:
        throw new NoSuchElementException();
    L11:
        return (T) Iterators.getLast(r1.iterator());
    }

    @Nullable
    public static <T> T getLast(Iterable<? extends T> r1, @Nullable T r2) {
        if ((r1 instanceof Collection) == false) goto L12;
        if (Collections2.cast(r1).isEmpty() == false) goto L8;
        return r2;
    L8:
        if ((r1 instanceof List) == false) goto L12;
        return (T) getLastInNonemptyList(Lists.cast(r1));
    L12:
        return (T) Iterators.getLast(r1.iterator(), r2);
    }

    private static <T> T getLastInNonemptyList(List<T> r1) {
        return r1.get(r1.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "number to skip cannot be negative");
        if ((r2 instanceof List) == false) goto L11;
        final List r4 = (List) r2;
        return new AnonymousClass9(r4, r3);
    L11:
        return new AnonymousClass10(r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> limit(final Iterable<T> r2, final int r3) {
        Preconditions.checkNotNull(r2);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "limit is negative");
        return new AnonymousClass11(r2, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> r1) {
        if ((r1 instanceof Queue) == true) goto L5;
        Preconditions.checkNotNull(r1);
        return new AnonymousClass13(r1);
    L5:
        return new AnonymousClass12(r1);
    }

    public static boolean isEmpty(Iterable<?> r1) {
        if ((r1 instanceof Collection) == false) goto L7;
        return ((Collection) r1).isEmpty();
    L7:
        return !r1.iterator().hasNext();
    }

    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> r1, final Comparator<? super T> r2) {
        Preconditions.checkNotNull(r1, "iterables");
        Preconditions.checkNotNull(r2, "comparator");
        return new UnmodifiableIterable(new AnonymousClass14(r1, r2), null);
    }

    private static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new AnonymousClass15();
    }
}
