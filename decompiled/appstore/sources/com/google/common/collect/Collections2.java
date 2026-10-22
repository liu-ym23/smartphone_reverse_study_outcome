package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Collections2 {

    public static class FilteredCollection<E> extends AbstractCollection<E> {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;

        public FilteredCollection(Collection<E> r10, Predicate<? super E> r11) {
            this.unfiltered = r10;
            this.predicate = r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E r10) {
            Preconditions.checkArgument(this.predicate.apply(r10));
            return this.unfiltered.add(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r10) {
            Iterator<? extends E> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            E r12 = r11.next();
            Preconditions.checkArgument(this.predicate.apply(r12));
            goto L4
        L7:
            return this.unfiltered.addAll(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            if (Collections2.safeContains(this.unfiltered, r10) == true) goto L5;
            return false;
        L5:
            return this.predicate.apply(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r10) {
            return Collections2.containsAllImpl(this, r10);
        }

        public FilteredCollection<E> createCombined(Predicate<? super E> r10) {
            return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, r10));
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
        public boolean remove(Object r10) {
            if (contains(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.unfiltered.remove(r10) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            Iterator<E> r11 = this.unfiltered.iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L10;
            E r13 = r11.next();
            if (this.predicate.apply(r13) == false) goto L4;
            if (r10.contains(r13) == false) goto L4;
            r11.remove();
            r12 = true;
            goto L4
        L10:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            Iterator<E> r11 = this.unfiltered.iterator();
            boolean r12 = false;
        L4:
            if (r11.hasNext() == false) goto L10;
            E r13 = r11.next();
            if (this.predicate.apply(r13) == false) goto L4;
            if (r10.contains(r13) == true) goto L4;
            r11.remove();
            r12 = true;
            goto L4
        L10:
            return r12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> r10 = this.unfiltered.iterator();
            int r11 = 0;
        L4:
            if (r10.hasNext() == false) goto L8;
            E r12 = r10.next();
            if (this.predicate.apply(r12) == false) goto L4;
            r11 = r11 + 1;
            goto L4
        L8:
            return r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r10) {
            return (T[]) Lists.newArrayList(iterator()).toArray(r10);
        }
    }

    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final Comparator<? super E> comparator;
        final ImmutableList<E> inputList;
        final int size;

        public OrderedPermutationCollection(Iterable<E> r10, Comparator<? super E> r11) {
            ImmutableList<E> r12 = ImmutableList.sortedCopyOf(r11, r10);
            this.inputList = r12;
            this.comparator = r11;
            this.size = calculateSize(r12, r11);
        }

        private static <E> int calculateSize(List<E> r10, Comparator<? super E> r11) {
            int r12 = 1;
            int r13 = 1;
            int r14 = 1;
        L4:
            if (r12 >= r10.size()) goto L13;
            if (r11.compare(r10.get(r12 - 1), r10.get(r12)) >= 0) goto L11;
            r13 = IntMath.saturatedMultiply(r13, IntMath.binomial(r12, r14));
            if (r13 == Integer.MAX_VALUE) goto L9;
            r14 = 0;
            goto L11
        L9:
            return Channel.UNLIMITED;
        L11:
            r12 = r12 + 1;
            r14 = r14 + 1;
            goto L4
        L13:
            return IntMath.saturatedMultiply(r13, IntMath.binomial(r12, r14));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof List) == false) goto L6;
            ImmutableList<E> r11 = this.inputList;
            return Collections2.access$000(r11, (List) r10);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    public static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        final Comparator<? super E> comparator;

        @NullableDecl
        List<E> nextPermutation;

        public OrderedPermutationIterator(List<E> r10, Comparator<? super E> r11) {
            this.nextPermutation = Lists.newArrayList(r10);
            this.comparator = r11;
        }

        public void calculateNextPermutation() {
            int r10 = findNextJ();
            if (r10 != (-1)) goto L6;
            this.nextPermutation = null;
            return;
        L6:
            int r11 = findNextL(r10);
            Collections.swap(this.nextPermutation, r10, r11);
            int r12 = this.nextPermutation.size();
            Collections.reverse(this.nextPermutation.subList(r10 + 1, r12));
        }

        @Override // com.google.common.collect.AbstractIterator
        public /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        public int findNextJ() {
            int r10 = this.nextPermutation.size() - 2;
        L3:
            if (r10 < 0) goto L8;
            if (this.comparator.compare(this.nextPermutation.get(r10), this.nextPermutation.get(r10 + 1)) < 0) goto L6;
            r10 = r10 - 1;
            goto L3
        L6:
            return r10;
        L8:
            return -1;
        }

        public int findNextL(int r10) {
            E r11 = this.nextPermutation.get(r10);
            int r12 = this.nextPermutation.size() - 1;
        L3:
            if (r12 <= r10) goto L9;
            if (this.comparator.compare(r11, this.nextPermutation.get(r12)) < 0) goto L6;
            r12 = r12 - 1;
            goto L3
        L6:
            return r12;
        L9:
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            List<E> r10 = this.nextPermutation;
            if (r10 == null) goto L5;
            ImmutableList r11 = ImmutableList.copyOf(r10);
            calculateNextPermutation();
            return r11;
        L5:
            return endOfData();
        }
    }

    public static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        public PermutationCollection(ImmutableList<E> r10) {
            this.inputList = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof List) == false) goto L6;
            ImmutableList<E> r11 = this.inputList;
            return Collections2.access$000(r11, (List) r10);
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    public static class PermutationIterator<E> extends AbstractIterator<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f10350c;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f10351j;
        final List<E> list;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final int[] f10352o;

        public PermutationIterator(List<E> r10) {
            this.list = new ArrayList(r10);
            int r11 = r10.size();
            int[] r12 = new int[r11];
            this.f10350c = r12;
            int[] r13 = new int[r11];
            this.f10352o = r13;
            Arrays.fill(r12, 0);
            Arrays.fill(r13, 1);
            this.f10351j = Channel.UNLIMITED;
        }

        public void calculateNextPermutation() {
            int r10 = this.list.size() - 1;
            this.f10351j = r10;
            if (r10 != (-1)) goto L5;
            return;
        L5:
            int r11 = 0;
        L6:
            int[] r12 = this.f10350c;
            int r13 = this.f10351j;
            int r14 = r12[r13];
            int r15 = this.f10352o[r13] + r14;
            if (r15 < 0) goto L8;
            if (r15 != (r13 + 1)) goto L14;
            if (r13 == 0) goto L23;
            r11 = r11 + 1;
            switchDirection();
            goto L6
        L23:
            return;
        L14:
            Collections.swap(this.list, (r13 - r14) + r11, (r13 - r15) + r11);
            this.f10350c[this.f10351j] = r15;
            return;
        L8:
            switchDirection();
            goto L6
        }

        @Override // com.google.common.collect.AbstractIterator
        public /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        public void switchDirection() {
            int[] r10 = this.f10352o;
            int r11 = this.f10351j;
            r10[r11] = -r10[r11];
            this.f10351j = r11 - 1;
        }

        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            if (this.f10351j <= 0) goto L5;
            ImmutableList r10 = ImmutableList.copyOf(this.list);
            calculateNextPermutation();
            return r10;
        L5:
            return endOfData();
        }
    }

    public static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        public TransformedCollection(Collection<F> r10, Function<? super F, ? extends T> r11) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(r10);
            this.function = (Function) Preconditions.checkNotNull(r11);
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

    private Collections2() {
    }

    public static /* synthetic */ boolean access$000(List r10, List r11) {
        return isPermutation(r10, r11);
    }

    public static <T> Collection<T> cast(Iterable<T> r10) {
        return (Collection) r10;
    }

    public static boolean containsAllImpl(Collection<?> r10, Collection<?> r11) {
        Iterator<?> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r10.contains(r12.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    private static <E> ObjectCountHashMap<E> counts(Collection<E> r10) {
        ObjectCountHashMap<E> r11 = new ObjectCountHashMap();
        Iterator<E> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        E r13 = r12.next();
        r11.put(r13, r11.get(r13) + 1);
        goto L4
    L6:
        return r11;
    }

    public static <E> Collection<E> filter(Collection<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof FilteredCollection) == false) goto L7;
        return ((FilteredCollection) r10).createCombined(r11);
    L7:
        return new FilteredCollection((Collection) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11));
    }

    private static boolean isPermutation(List<?> r10, List<?> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        ObjectCountHashMap r12 = counts(r10);
        ObjectCountHashMap r13 = counts(r11);
        if (r10.size() == r11.size()) goto L8;
        return false;
    L8:
        int r14 = 0;
    L10:
        if (r14 >= r10.size()) goto L15;
        if (r12.getValue(r14) != r13.get(r12.getKey(r14))) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static StringBuilder newStringBuilderForCollection(int r10) {
        CollectPreconditions.checkNonnegative(r10, "size");
        return new StringBuilder((int) Math.min(((long) r10) * 8, 1073741824));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> r10) {
        return orderedPermutations(r10, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> r10) {
        return new PermutationCollection(ImmutableList.copyOf(r10));
    }

    public static boolean safeContains(Collection<?> r10, @NullableDecl Object r11) {
        Preconditions.checkNotNull(r10);
        return r10.contains(r11);
    L5:
        return false;
    }

    public static boolean safeRemove(Collection<?> r10, @NullableDecl Object r11) {
        Preconditions.checkNotNull(r10);
        return r10.remove(r11);
    L5:
        return false;
    }

    public static String toStringImpl(Collection<?> r10) {
        StringBuilder r11 = newStringBuilderForCollection(r10.size());
        r11.append('[');
        Iterator<?> r12 = r10.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r14 = r12.next();
        if (r13 == true) goto L8;
        r11.append(", ");
    L8:
        if (r14 != r10) goto L10;
        r11.append("(this Collection)");
    L11:
        r13 = false;
        goto L4
    L10:
        r11.append(r14);
        goto L11
    L12:
        r11.append(']');
        return r11.toString();
    }

    public static <F, T> Collection<T> transform(Collection<F> r10, Function<? super F, T> r11) {
        return new TransformedCollection(r10, r11);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> r10, Comparator<? super E> r11) {
        return new OrderedPermutationCollection(r10, r11);
    }
}
