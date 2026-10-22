package com.google.common.collect;

import com.google.common.base.Preconditions;
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

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    private static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = null;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder addCopies(Object r1, int r2) {
            return addCopies(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset build() {
            return build();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public /* bridge */ /* synthetic */ ImmutableMultiset.Builder setCount(Object r1, int r2) {
            return setCount(r1, r2);
        }

        public Builder(Comparator<? super E> r1) {
            super(TreeMultiset.create((Comparator) Preconditions.checkNotNull(r1)));
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public Builder<E> addCopies(E r1, int r2) {
            super.addCopies(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public Builder<E> setCount(E r1, int r2) {
            super.setCount(r1, r2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedMultiset<E> build() {
            return ImmutableSortedMultiset.copyOfSorted((SortedMultiset) this.contents);
        }
    }

    private static final class SerializedForm<E> implements Serializable {
        Comparator<? super E> comparator;
        int[] counts;
        E[] elements;

        SerializedForm(SortedMultiset<E> r5) {
            this.comparator = r5.comparator();
            int r0 = r5.entrySet().size();
            this.elements = (E[]) new Object[r0];
            this.counts = new int[r0];
            Iterator<Multiset.Entry<E>> r6 = r5.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r6.hasNext() == false) goto L6;
            Multiset.Entry<E> r2 = r6.next();
            this.elements[r1] = r2.getElement();
            this.counts[r1] = r2.getCount();
            r1 = r1 + 1;
            goto L4
        }

        Object readResolve() {
            int r0 = this.elements.length;
            Builder r1 = new Builder(this.comparator);
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L6;
            r1.addCopies(this.elements[r2], this.counts[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return r1.build();
        }
    }

    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E r1, BoundType r2);

    public abstract ImmutableSortedMultiset<E> tailMultiset(E r1, BoundType r2);

    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return descendingMultiset();
    }

    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object r1, BoundType r2, Object r3, BoundType r4) {
        return subMultiset(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }

    static {
        Ordering r0 = Ordering.natural();
        NATURAL_ORDER = r0;
        NATURAL_EMPTY_MULTISET = new EmptyImmutableSortedMultiset(r0);
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r6) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(r6), new int[]{1}, new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r3, r4}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r3, r4, r5}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r3, r4, r5, r6}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6, Comparable r7) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{r3, r4, r5, r6, r7}));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable r3, Comparable r4, Comparable r5, Comparable r6, Comparable r7, Comparable r8, Comparable... r9) {
        ArrayList r0 = Lists.newArrayListWithCapacity(r9.length + 6);
        Collections.addAll(r0, new Comparable[]{r3, r4, r5, r6, r7, r8});
        Collections.addAll(r0, r9);
        return copyOf(Ordering.natural(), r0);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] r1) {
        return copyOf(Ordering.natural(), Arrays.asList(r1));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> r1) {
        return copyOf(Ordering.natural(), r1);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> r1) {
        return copyOf(Ordering.natural(), r1);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r1, Iterator<? extends E> r2) {
        Preconditions.checkNotNull(r1);
        return new Builder(r1).addAll(r2).build();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> r2, Iterable<? extends E> r3) {
        if ((r3 instanceof ImmutableSortedMultiset) == false) goto L11;
        ImmutableSortedMultiset<E> r0 = (ImmutableSortedMultiset) r3;
        if (r2.equals(r0.comparator()) == false) goto L11;
        if (r0.isPartialView() == true) goto L9;
        return r0;
    L9:
        return copyOfSortedEntries(r2, r0.entrySet().asList());
    L11:
        ArrayList r4 = Lists.newArrayList(r3);
        TreeMultiset r1 = TreeMultiset.create((Comparator) Preconditions.checkNotNull(r2));
        Iterables.addAll(r1, r4);
        return copyOfSortedEntries(r2, r1.entrySet());
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> r1) {
        return copyOfSortedEntries(r1.comparator(), Lists.newArrayList(r1.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> r9, Collection<Multiset.Entry<E>> r10) {
        if (r10.isEmpty() == true) goto L5;
        ImmutableList.Builder r0 = new ImmutableList.Builder(r10.size());
        int[] r4 = new int[r10.size()];
        long[] r5 = new long[r10.size() + 1];
        Iterator<Multiset.Entry<E>> r1 = r10.iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L11;
        Multiset.Entry<E> r3 = r1.next();
        r0.add(r3.getElement());
        int r6 = r3.getCount();
        r4[r2] = r6;
        int r7 = r2 + 1;
        r5[r7] = r5[r2] + ((long) r6);
        r2 = r7;
        goto L8
    L11:
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(r0.build(), r9), r4, r5, 0, r10.size());
    L5:
        return emptyMultiset(r9);
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> r1) {
        if (NATURAL_ORDER.equals(r1) == false) goto L7;
        return (ImmutableSortedMultiset<E>) NATURAL_EMPTY_MULTISET;
    L7:
        return new EmptyImmutableSortedMultiset(r1);
    }

    ImmutableSortedMultiset() {
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> r0 = this.descendingMultiset;
        if (r0 != null) goto L6;
        DescendingImmutableSortedMultiset r1 = new DescendingImmutableSortedMultiset(this);
        this.descendingMultiset = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.SortedMultiset
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E r5, BoundType r6, E r7, BoundType r8) {
        if (comparator().compare(r5, r7) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expected lowerBound <= upperBound but %s > %s", new Object[]{r5, r7});
        return tailMultiset(r5, r6).headMultiset(r7, r8);
    L5:
        r0 = false;
        goto L6
    }

    public static <E> Builder<E> orderedBy(Comparator<E> r1) {
        return new Builder(r1);
    }

    public static <E extends Comparable<E>> Builder<E> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    public static <E extends Comparable<E>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
