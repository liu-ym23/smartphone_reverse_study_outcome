package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {

    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> comparator;
        private int[] counts;

        @VisibleForTesting
        E[] elements;
        private boolean forceCopyElements;
        private int length;

        public Builder(Comparator<? super E> r10) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(r10);
            this.elements = (E[]) new Object[4];
            this.counts = new int[4];
        }

        private void dedupAndCoalesce(boolean r10) {
            int r11 = this.length;
            if (r11 != 0) goto L5;
            return;
        L5:
            Object[] r12 = (E[]) Arrays.copyOf(this.elements, r11);
            Arrays.sort(r12, this.comparator);
            int r13 = 1;
            int r14 = 1;
        L7:
            if (r13 >= r12.length) goto L12;
            if (this.comparator.compare((Object) r12[r14 - 1], (Object) r12[r13]) >= 0) goto L11;
            r12[r14] = r12[r13];
            r14 = r14 + 1;
        L11:
            r13 = r13 + 1;
            goto L7
        L12:
            Arrays.fill(r12, r14, this.length, null);
            if (r10 == false) goto L17;
            int r15 = r14 * 4;
            int r16 = this.length;
            if (r15 <= (r16 * 3)) goto L17;
            r12 = (E[]) Arrays.copyOf(r12, IntMath.saturatedAdd(r16, (r16 / 2) + 1));
        L17:
            int[] r17 = new int[r12.length];
            int r18 = 0;
        L19:
            if (r18 >= this.length) goto L25;
            int r19 = Arrays.binarySearch(r12, 0, r14, this.elements[r18], this.comparator);
            int r20 = this.counts[r18];
            if (r20 < 0) goto L23;
            r17[r19] = r17[r19] + r20;
        L24:
            r18 = r18 + 1;
            goto L19
        L23:
            r17[r19] = ~r20;
            goto L24
        L25:
            this.elements = (E[]) r12;
            this.counts = r17;
            this.length = r14;
        }

        private void dedupAndCoalesceAndDeleteEmpty() {
            dedupAndCoalesce(false);
            int r10 = 0;
            int r11 = 0;
        L3:
            int r12 = this.length;
            if (r10 >= r12) goto L9;
            int[] r13 = this.counts;
            int r14 = r13[r10];
            if (r14 <= 0) goto L8;
            E[] r15 = this.elements;
            r15[r11] = r15[r10];
            r13[r11] = r14;
            r11 = r11 + 1;
        L8:
            r10 = r10 + 1;
            goto L3
        L9:
            Arrays.fill(this.elements, r11, r12, null);
            Arrays.fill(this.counts, r11, this.length, 0);
            this.length = r11;
        }

        private void maintenance() {
            int r10 = this.length;
            E[] r11 = this.elements;
            if (r10 != r11.length) goto L6;
            dedupAndCoalesce(true);
        L8:
            this.forceCopyElements = false;
            return;
        L6:
            if (this.forceCopyElements == false) goto L8;
            this.elements = (E[]) Arrays.copyOf(r11, r11.length);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addCopies(Object r10, int r11) {
            return addCopies(r10, r11);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder setCount(Object r10, int r11) {
            return setCount(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> addCopies(E r10, int r11) {
            Preconditions.checkNotNull(r10);
            CollectPreconditions.checkNonnegative(r11, "occurrences");
            if (r11 != 0) goto L5;
            return this;
        L5:
            maintenance();
            E[] r12 = this.elements;
            int r13 = this.length;
            r12[r13] = r10;
            this.counts[r13] = r11;
            this.length = r13 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @CanIgnoreReturnValue
        public Builder<E> setCount(E r10, int r11) {
            Preconditions.checkNotNull(r10);
            CollectPreconditions.checkNonnegative(r11, "count");
            maintenance();
            E[] r12 = this.elements;
            int r13 = this.length;
            r12[r13] = r10;
            this.counts[r13] = ~r11;
            this.length = r13 + 1;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedMultiset<E> build() {
            dedupAndCoalesceAndDeleteEmpty();
            int r10 = this.length;
            if (r10 == 0) goto L5;
            RegularImmutableSortedSet r11 = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.comparator, r10, this.elements);
            long[] r12 = new long[this.length + 1];
            int r13 = 0;
        L8:
            if (r13 >= this.length) goto L10;
            int r14 = r13 + 1;
            r12[r14] = r12[r13] + ((long) this.counts[r13]);
            r13 = r14;
            goto L8
        L10:
            this.forceCopyElements = true;
            return new RegularImmutableSortedMultiset(r11, r12, 0, this.length);
        L5:
            return ImmutableSortedMultiset.emptyMultiset(this.comparator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E r10) {
            return addCopies(r10, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            if ((r10 instanceof Multiset) == false) goto L8;
            Iterator<Multiset.Entry<E>> r11 = ((Multiset) r10).entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L12;
            Multiset.Entry<E> r12 = r11.next();
            addCopies(r12.getElement(), r12.getCount());
        L12:
            return this;
        L8:
            Iterator<? extends E> r13 = r10.iterator();
        L10:
            if (r13.hasNext() == false) goto L12;
            add(r13.next());
            goto L10
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            add(r10[r12]);
            r12 = r12 + 1;
            goto L3
        L5:
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
        L3:
            if (r10.hasNext() == false) goto L5;
            add(r10.next());
            goto L3
        L5:
            return this;
        }
    }

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(SortedMultiset<E> r10) {
            this.comparator = r10.comparator();
            int r11 = r10.entrySet().size();
            this.elements = (E[]) new Object[r11];
            this.counts = new int[r11];
            Iterator<Multiset.Entry<E>> r12 = r10.entrySet().iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L6;
            Multiset.Entry<E> r14 = r12.next();
            this.elements[r13] = r14.getElement();
            this.counts[r13] = r14.getCount();
            r13 = r13 + 1;
            goto L4
        }

        public Object readResolve() {
            int r10 = this.elements.length;
            Builder r11 = new Builder(this.comparator);
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L6;
            r11.addCopies(this.elements[r12], this.counts[r12]);
            r12 = r12 + 1;
            goto L3
        L6:
            return r11.build();
        }
    }

    public ImmutableSortedMultiset() {
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] r10) {
        return copyOf(Ordering.natural(), Arrays.asList(r10));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> r10) {
        return copyOfSortedEntries(r10.comparator(), Lists.newArrayList(r10.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> r10, Collection<Multiset.Entry<E>> r11) {
        if (r11.isEmpty() == true) goto L5;
        ImmutableList.Builder r12 = new ImmutableList.Builder(r11.size());
        long[] r13 = new long[r11.size() + 1];
        Iterator<Multiset.Entry<E>> r14 = r11.iterator();
        int r15 = 0;
    L8:
        if (r14.hasNext() == false) goto L11;
        Multiset.Entry<E> r16 = r14.next();
        r12.add(r16.getElement());
        int r17 = r15 + 1;
        r13[r17] = r13[r15] + ((long) r16.getCount());
        r15 = r17;
        goto L8
    L11:
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(r12.build(), r10), r13, 0, r11.size());
    L5:
        return emptyMultiset(r10);
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> r10) {
        if (Ordering.natural().equals(r10) == false) goto L7;
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    L7:
        return new RegularImmutableSortedMultiset(r10);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> r10) {
        return new Builder(r10);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E r10, BoundType r11);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object r10, BoundType r11) {
        return headMultiset(r10, r11);
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object r10, BoundType r11, Object r12, BoundType r13) {
        return subMultiset(r10, r11, r12, r13);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E r10, BoundType r11);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object r10, BoundType r11) {
        return tailMultiset(r10, r11);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> r10) {
        return copyOf(Ordering.natural(), r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(r10), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> r10 = this.descendingMultiset;
        if (r10 == null) goto L5;
    L9:
        return r10;
    L5:
        if (isEmpty() == false) goto L7;
        r10 = emptyMultiset(Ordering.from(comparator()).reverse());
    L8:
        this.descendingMultiset = r10;
        goto L9
    L7:
        r10 = new DescendingImmutableSortedMultiset(this);
        goto L8
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E r10, BoundType r11, E r12, BoundType r13) {
        if (comparator().compare(r10, r12) > 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "Expected lowerBound <= upperBound but %s > %s", r10, r12);
        return tailMultiset(r10, r11).headMultiset(r12, r13);
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> r10) {
        return copyOf(Ordering.natural(), r10);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10, Comparable r11) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r10, r11}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r10, Iterator<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        return new Builder(r10).addAll(r11).build();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10, Comparable r11, Comparable r12) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r10, r11, r12}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10, Comparable r11, Comparable r12, Comparable r13) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r10, r11, r12, r13}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r10, Iterable<? extends E> r11) {
        if ((r11 instanceof ImmutableSortedMultiset) == false) goto L12;
        ImmutableSortedMultiset<E> r12 = (ImmutableSortedMultiset) r11;
        if (r10.equals(r12.comparator()) == false) goto L12;
        if (r12.isPartialView() == true) goto L9;
        return r12;
    L9:
        return copyOfSortedEntries(r10, r12.entrySet().asList());
    L12:
        return new Builder(r10).addAll(r11).build();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r10, r11, r12, r13, r14}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14, Comparable r15, Comparable... r16) {
        ArrayList r17 = Lists.newArrayListWithCapacity(r16.length + 6);
        Collections.addAll(r17, new Comparable[]{r10, r11, r12, r13, r14, r15});
        Collections.addAll(r17, r16);
        return copyOf(Ordering.natural(), r17);
    }
}
