package com.google.common.collect;

import a3.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    final transient Comparator<? super E> comparator;

    @GwtIncompatible
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> r10) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableSet build() {
            return build();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableSet.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSortedSet<E> build() {
            Object[] r10 = this.contents;
            ImmutableSortedSet<E> r11 = ImmutableSortedSet.construct(this.comparator, this.size, r10);
            this.size = r11.size();
            this.forceCopy = true;
            return r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableSet.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableSet.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            super.addAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E r10) {
            super.add(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
            super.addAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            super.add(r10);
            return this;
        }
    }

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> r10, Object[] r11) {
            this.comparator = r10;
            this.elements = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    public ImmutableSortedSet(Comparator<? super E> r10) {
        this.comparator = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> r10, int r11, E... r12) {
        if (r11 == 0) goto L4;
        ObjectArrays.checkElementsNotNull(r12, r11);
        Arrays.sort(r12, 0, r11, r10);
        int r13 = 1;
        int r14 = 1;
    L6:
        if (r13 >= r11) goto L11;
        a r15 = (Object) r12[r13];
        if (r10.compare(r15, (Object) r12[r14 - 1]) == 0) goto L10;
        r12[r14] = r15;
        r14 = r14 + 1;
    L10:
        r13 = r13 + 1;
        goto L6
    L11:
        Arrays.fill(r12, r14, r11, null);
        if (r14 >= (r12.length / 2)) goto L15;
        r12 = (E[]) Arrays.copyOf(r12, r14);
    L15:
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(r12, r14), r10);
    L4:
        return emptySet(r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] r10) {
        return construct(Ordering.natural(), r10.length, (Object[]) r10.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> r10) {
        Comparator r11 = SortedIterables.comparator(r10);
        ImmutableList r12 = ImmutableList.copyOf(r10);
        if (r12.isEmpty() == false) goto L7;
        return emptySet(r11);
    L7:
        return new RegularImmutableSortedSet(r12, r11);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> r10) {
        if (Ordering.natural().equals(r10) == false) goto L7;
        return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    L7:
        return new RegularImmutableSortedSet(ImmutableList.of(), r10);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> r10) {
        return new Builder(r10);
    }

    private void readObject(ObjectInputStream r10) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder(Collections.reverseOrder());
    }

    @GwtIncompatible
    public E ceiling(E r10) {
        return (E) Iterables.getFirst(tailSet(r10, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @GwtIncompatible
    public abstract ImmutableSortedSet<E> createDescendingSet();

    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    @GwtIncompatible
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        return descendingSet();
    }

    public E first() {
        return iterator().next();
    }

    @GwtIncompatible
    public E floor(E r10) {
        return (E) Iterators.getNext(headSet(r10, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object r10, boolean r11) {
        return headSet(r10, r11);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E r10, boolean r11);

    @GwtIncompatible
    public E higher(E r10) {
        return (E) Iterables.getFirst(tailSet(r10, false), null);
    }

    public abstract int indexOf(@NullableDecl Object r10);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public E last() {
        return descendingIterator().next();
    }

    @GwtIncompatible
    public E lower(E r10) {
        return (E) Iterators.getNext(headSet(r10, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object r10, boolean r11, Object r12, boolean r13) {
        return subSet(r10, r11, r12, r13);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E r10, boolean r11, E r12, boolean r13);

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object r10, boolean r11) {
        return tailSet(r10, r11);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E r10, boolean r11);

    public int unsafeCompare(Object r10, Object r11) {
        return unsafeCompare(this.comparator, r10, r11);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> r10) {
        return copyOf(Ordering.natural(), r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10) {
        return new RegularImmutableSortedSet(ImmutableList.of(r10), Ordering.natural());
    }

    public static int unsafeCompare(Comparator<?> r10, Object r11, Object r12) {
        return r10.compare(r11, r12);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> r10 = this.descendingSet;
        if (r10 != null) goto L6;
        ImmutableSortedSet<E> r11 = createDescendingSet();
        this.descendingSet = r11;
        r11.descendingSet = this;
        return r11;
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object r10) {
        return headSet(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet subSet(Object r10, Object r11) {
        return subSet(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object r10) {
        return tailSet(r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10, Comparable r11) {
        return construct(Ordering.natural(), 2, new Comparable[]{r10, r11});
    }

    public ImmutableSortedSet<E> headSet(E r10) {
        return headSet(r10, false);
    }

    public ImmutableSortedSet<E> subSet(E r10, E r11) {
        return subSet(r10, true, r11, false);
    }

    public ImmutableSortedSet<E> tailSet(E r10) {
        return tailSet(r10, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> r10) {
        return copyOf(Ordering.natural(), r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10, Comparable r11, Comparable r12) {
        return construct(Ordering.natural(), 3, new Comparable[]{r10, r11, r12});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E r10, boolean r11) {
        return headSetImpl(Preconditions.checkNotNull(r10), r11);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        if (this.comparator.compare(r10, r12) > 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14);
        return subSetImpl(r10, r11, r12, r13);
    L5:
        r14 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E r10, boolean r11) {
        return tailSetImpl(Preconditions.checkNotNull(r10), r11);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10, Comparable r11, Comparable r12, Comparable r13) {
        return construct(Ordering.natural(), 4, new Comparable[]{r10, r11, r12, r13});
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> r10) {
        return copyOf(Ordering.natural(), r10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14) {
        return construct(Ordering.natural(), 5, new Comparable[]{r10, r11, r12, r13, r14});
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable r10, Comparable r11, Comparable r12, Comparable r13, Comparable r14, Comparable r15, Comparable... r16) {
        int r17 = r16.length + 6;
        Comparable[] r18 = new Comparable[r17];
        r18[0] = r10;
        r18[1] = r11;
        r18[2] = r12;
        r18[3] = r13;
        r18[4] = r14;
        r18[5] = r15;
        System.arraycopy(r16, 0, r18, 6, r16.length);
        return construct(Ordering.natural(), r17, r18);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r10, Iterator<? extends E> r11) {
        return new Builder(r10).addAll(r11).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r10, Iterable<? extends E> r11) {
        Preconditions.checkNotNull(r10);
        if (SortedIterables.hasSameComparator(r10, r11) == true) goto L5;
    L9:
        Object[] r12 = Iterables.toArray(r11);
        return construct(r10, r12.length, r12);
    L5:
        if ((r11 instanceof ImmutableSortedSet) == false) goto L9;
        ImmutableSortedSet<E> r13 = (ImmutableSortedSet) r11;
        if (r13.isPartialView() == true) goto L9;
        return r13;
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> r10, Collection<? extends E> r11) {
        return copyOf(r10, r11);
    }
}
