package com.google.common.collect;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Collections2 {
    static final Joiner STANDARD_JOINER = null;

    static class FilteredCollection<E> extends AbstractCollection<E> {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;

        FilteredCollection(Collection<E> r1, Predicate<? super E> r2) {
            this.unfiltered = r1;
            this.predicate = r2;
        }

        FilteredCollection<E> createCombined(Predicate<? super E> r3) {
            return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, r3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E r2) {
            Preconditions.checkArgument(this.predicate.apply(r2));
            return this.unfiltered.add(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r4) {
            Iterator<? extends E> r0 = r4.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            E r1 = r0.next();
            Preconditions.checkArgument(this.predicate.apply(r1));
            goto L4
        L7:
            return this.unfiltered.addAll(r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object r2) {
            if (Collections2.safeContains(this.unfiltered, r2) == true) goto L5;
            return false;
        L5:
            return this.predicate.apply(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r1) {
            return Collections2.containsAllImpl(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            if (contains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.unfiltered.remove(r2) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r2) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(r2)));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r2) {
            return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(r2))));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Iterators.size(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) Lists.newArrayList(iterator()).toArray(r1);
        }
    }

    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final Comparator<? super E> comparator;
        final ImmutableList<E> inputList;
        final int size;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        OrderedPermutationCollection(Iterable<E> r2, Comparator<? super E> r3) {
            ImmutableList<E> r4 = Ordering.from(r3).immutableSortedCopy(r2);
            this.inputList = r4;
            this.comparator = r3;
            this.size = calculateSize(r4, r3);
        }

        private static <E> int calculateSize(List<E> r8, Comparator<? super E> r9) {
            long r0 = 1;
            int r3 = 1;
            int r4 = 1;
        L4:
            if (r3 >= r8.size()) goto L12;
            if (r9.compare(r8.get(r3 - 1), r8.get(r3)) >= 0) goto L11;
            r0 = r0 * LongMath.binomial(r3, r4);
            if (Collections2.access$000(r0) == false) goto L9;
            r4 = 0;
            goto L11
        L9:
            return Integer.MAX_VALUE;
        L11:
            r3 = r3 + 1;
            r4 = r4 + 1;
            goto L4
        L12:
            long r1 = r0 * LongMath.binomial(r3, r4);
            if (Collections2.access$000(r1) == true) goto L16;
            return Integer.MAX_VALUE;
        L16:
            return (int) r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object r2) {
            if ((r2 instanceof List) == false) goto L6;
            ImmutableList<E> r1 = this.inputList;
            return Collections2.access$100(r1, (List) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        final Comparator<? super E> comparator;
        List<E> nextPermutation;

        @Override // com.google.common.collect.AbstractIterator
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        OrderedPermutationIterator(List<E> r1, Comparator<? super E> r2) {
            this.nextPermutation = Lists.newArrayList(r1);
            this.comparator = r2;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected List<E> computeNext() {
            List<E> r0 = this.nextPermutation;
            if (r0 == null) goto L5;
            ImmutableList r1 = ImmutableList.copyOf(r0);
            calculateNextPermutation();
            return r1;
        L5:
            return endOfData();
        }

        void calculateNextPermutation() {
            int r0 = findNextJ();
            if (r0 != (-1)) goto L6;
            this.nextPermutation = null;
            return;
        L6:
            int r1 = findNextL(r0);
            Collections.swap(this.nextPermutation, r0, r1);
            int r2 = this.nextPermutation.size();
            Collections.reverse(this.nextPermutation.subList(r0 + 1, r2));
        }

        int findNextJ() {
            int r0 = this.nextPermutation.size() - 2;
        L3:
            if (r0 < 0) goto L8;
            if (this.comparator.compare(this.nextPermutation.get(r0), this.nextPermutation.get(r0 + 1)) < 0) goto L6;
            r0 = r0 - 1;
            goto L3
        L6:
            return r0;
        L8:
            return -1;
        }

        int findNextL(int r5) {
            E r0 = this.nextPermutation.get(r5);
            int r1 = this.nextPermutation.size() - 1;
        L3:
            if (r1 <= r5) goto L9;
            if (this.comparator.compare(r0, this.nextPermutation.get(r1)) < 0) goto L6;
            r1 = r1 - 1;
            goto L3
        L6:
            return r1;
        L9:
            throw new AssertionError("this statement should be unreachable");
        }
    }

    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        PermutationCollection(ImmutableList<E> r1) {
            this.inputList = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object r2) {
            if ((r2 instanceof List) == false) goto L6;
            ImmutableList<E> r1 = this.inputList;
            return Collections2.access$100(r1, (List) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final int[] c;
        int j;
        final List<E> list;
        final int[] o;

        @Override // com.google.common.collect.AbstractIterator
        protected /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        PermutationIterator(List<E> r3) {
            this.list = new ArrayList(r3);
            int r4 = r3.size();
            int[] r0 = new int[r4];
            this.c = r0;
            int[] r5 = new int[r4];
            this.o = r5;
            Arrays.fill(r0, 0);
            Arrays.fill(r5, 1);
            this.j = Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.AbstractIterator
        protected List<E> computeNext() {
            if (this.j <= 0) goto L5;
            ImmutableList r0 = ImmutableList.copyOf(this.list);
            calculateNextPermutation();
            return r0;
        L5:
            return endOfData();
        }

        void calculateNextPermutation() {
            int r0 = this.list.size() - 1;
            this.j = r0;
            if (r0 != (-1)) goto L5;
            return;
        L5:
            int r1 = 0;
        L6:
            int[] r2 = this.c;
            int r3 = this.j;
            int r4 = r2[r3];
            int r5 = this.o[r3] + r4;
            if (r5 < 0) goto L8;
            if (r5 != (r3 + 1)) goto L14;
            if (r3 == 0) goto L23;
            r1 = r1 + 1;
            switchDirection();
            goto L6
        L23:
            return;
        L14:
            Collections.swap(this.list, (r3 - r4) + r1, (r3 - r5) + r1);
            this.c[this.j] = r5;
            return;
        L8:
            switchDirection();
            goto L6
        }

        void switchDirection() {
            int[] r0 = this.o;
            int r1 = this.j;
            r0[r1] = -r0[r1];
            this.j = r1 - 1;
        }
    }

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> r1, Function<? super F, ? extends T> r2) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(r1);
            this.function = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.fromCollection.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.fromCollection.size();
        }
    }

    private static boolean isPositiveInt(long r2) {
        if (r2 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 2147483647L) goto L7;
        return true;
    }

    static /* synthetic */ boolean access$000(long r0) {
        return isPositiveInt(r0);
    }

    static /* synthetic */ boolean access$100(List r0, List r1) {
        return isPermutation(r0, r1);
    }

    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredCollection) == false) goto L7;
        return ((FilteredCollection) r1).createCombined(r2);
    L7:
        return new FilteredCollection((Collection) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    static boolean safeContains(Collection<?> r1, @Nullable Object r2) {
        Preconditions.checkNotNull(r1);
        return r1.contains(r2);
    L5:
        return false;
    }

    static boolean safeRemove(Collection<?> r1, @Nullable Object r2) {
        Preconditions.checkNotNull(r1);
        return r1.remove(r2);
    L5:
        return false;
    }

    public static <F, T> Collection<T> transform(Collection<F> r1, Function<? super F, T> r2) {
        return new TransformedCollection(r1, r2);
    }

    static boolean containsAllImpl(Collection<?> r0, Collection<?> r1) {
        return Iterables.all(r1, Predicates.in(r0));
    }

    static String toStringImpl(final Collection<?> r3) {
        StringBuilder r0 = newStringBuilderForCollection(r3.size()).append(DefaultContactListAdapter.SNIPPET_START_MATCH);
        STANDARD_JOINER.appendTo(r0, Iterables.transform(r3, new AnonymousClass1(r3)));
        return r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
    }

    static StringBuilder newStringBuilderForCollection(int r5) {
        CollectPreconditions.checkNonnegative(r5, PerfConsts.PERF_DISK_FILE_SIZE);
        return new StringBuilder((int) Math.min(((long) r5) * 8, 1073741824));
    }

    static <T> Collection<T> cast(Iterable<T> r0) {
        return (Collection) r0;
    }

    static {
        STANDARD_JOINER = Joiner.on(", ").useForNull("null");
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> r1) {
        return orderedPermutations(r1, Ordering.natural());
    }

    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> r1, Comparator<? super E> r2) {
        return new OrderedPermutationCollection(r1, r2);
    }

    public static <E> Collection<List<E>> permutations(Collection<E> r1) {
        return new PermutationCollection(ImmutableList.copyOf(r1));
    }

    private static boolean isPermutation(List<?> r2, List<?> r3) {
        if (r2.size() == r3.size()) goto L7;
        return false;
    L7:
        return HashMultiset.create(r2).equals(HashMultiset.create(r3));
    }
}
