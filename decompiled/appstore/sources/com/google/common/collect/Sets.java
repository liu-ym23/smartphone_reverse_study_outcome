package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Sets {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: com.google.common.collect.Sets$5, reason: invalid class name */
    public static class AnonymousClass5<E> extends AbstractSet<Set<E>> {
        final /* synthetic */ ImmutableMap val$index;
        final /* synthetic */ int val$size;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$5$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractIterator<Set<E>> {
            final BitSet bits;
            final /* synthetic */ AnonymousClass5 this$0;

            public AnonymousClass1(AnonymousClass5 r10) {
                this.this$0 = r10;
                this.bits = new BitSet(r10.val$index.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            public /* bridge */ /* synthetic */ Object computeNext() {
                return computeNext();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Set<E> computeNext() {
                if (this.bits.isEmpty() == false) goto L5;
                this.bits.set(0, this.this$0.val$size);
            L10:
                final BitSet r10 = (BitSet) this.bits.clone();
                return new C01531(this, r10);
            L5:
                int r11 = this.bits.nextSetBit(0);
                int r12 = this.bits.nextClearBit(r11);
                if (r12 == this.this$0.val$index.size()) goto L8;
                int r13 = (r12 - r11) - 1;
                this.bits.set(0, r13);
                this.bits.clear(r13, r12);
                this.bits.set(r12);
                goto L10
            L8:
                return endOfData();
            }
        }

        public AnonymousClass5(int r10, ImmutableMap r11) {
            this.val$size = r10;
            this.val$index = r11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Set) == false) goto L10;
            Set r11 = (Set) r10;
            if (r11.size() == this.val$size) goto L7;
            return false;
        L7:
            if (this.val$index.keySet().containsAll(r11) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.binomial(this.val$index.size(), this.val$size);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "Sets.combinations(" + this.val$index.keySet() + ", " + this.val$size + ")";
        }
    }

    public static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        private CartesianSet(ImmutableList<ImmutableSet<E>> r10, CartesianList<E> r11) {
            this.axes = r10;
            this.delegate = r11;
        }

        public static <E> Set<List<E>> create(List<? extends Set<? extends E>> r10) {
            ImmutableList.Builder r11 = new ImmutableList.Builder(r10.size());
            Iterator<? extends Set<? extends E>> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            ImmutableSet r13 = ImmutableSet.copyOf(r12.next());
            if (r13.isEmpty() == true) goto L8;
            r11.add(r13);
            goto L4
        L8:
            return ImmutableSet.of();
        L10:
            final ImmutableList<E> r14 = r11.build();
            return new CartesianSet(r14, new CartesianList(new AnonymousClass1(r14)));
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof CartesianSet) == false) goto L7;
            return this.axes.equals(((CartesianSet) r10).axes);
        L7:
            return super.equals(r10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int r10 = 1;
            int r11 = size() - 1;
            int r12 = 0;
        L4:
            if (r12 >= this.axes.size()) goto L6;
            r11 = ~(~(r11 * 31));
            r12 = r12 + 1;
            goto L4
        L6:
            UnmodifiableIterator<ImmutableSet<E>> r13 = this.axes.iterator();
        L8:
            if (r13.hasNext() == false) goto L11;
            ImmutableSet<E> r14 = r13.next();
            r10 = ~(~((r10 * 31) + ((size() / r14.size()) * r14.hashCode())));
            goto L8
        L11:
            return ~(~(r10 + r11));
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<List<E>> delegate() {
            return this.delegate;
        }
    }

    @GwtIncompatible
    public static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        public DescendingSet(NavigableSet<E> r10) {
            this.forward = r10;
        }

        private static <T> Ordering<T> reverse(Comparator<T> r10) {
            return Ordering.from(r10).reverse();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E ceiling(E r10) {
            return this.forward.floor(r10);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> r10 = this.forward.comparator();
            if (r10 != null) goto L7;
            return Ordering.natural().reverse();
        L7:
            return reverse(r10);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E first() {
            return this.forward.last();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E floor(E r10) {
            return this.forward.ceiling(r10);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E r10, boolean r11) {
            return this.forward.tailSet(r10, r11).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E higher(E r10) {
            return this.forward.lower(r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E last() {
            return this.forward.first();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E lower(E r10) {
            return this.forward.higher(r10);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollFirst() {
            return this.forward.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E pollLast() {
            return this.forward.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
            return this.forward.subSet(r12, r13, r10, r11).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E r10, boolean r11) {
            return this.forward.headSet(r10, r11).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(E r10) {
            return standardHeadSet(r10);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(E r10, E r11) {
            return standardSubSet(r10, r11);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(E r10) {
            return standardTailSet(r10);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r10) {
            return (T[]) standardToArray(r10);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public NavigableSet<E> delegate() {
            return this.forward;
        }
    }

    @GwtIncompatible
    public static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        public FilteredNavigableSet(NavigableSet<E> r10, Predicate<? super E> r11) {
            super(r10, r11);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r10) {
            return (E) Iterables.find(unfiltered().tailSet(r10, true), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.filter(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        @NullableDecl
        public E floor(E r10) {
            return (E) Iterators.find(unfiltered().headSet(r10, true).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r10, boolean r11) {
            return Sets.filter(unfiltered().headSet(r10, r11), this.predicate);
        }

        @Override // java.util.NavigableSet
        public E higher(E r10) {
            return (E) Iterables.find(unfiltered().tailSet(r10, false), this.predicate, null);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public E last() {
            return (E) Iterators.find(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // java.util.NavigableSet
        @NullableDecl
        public E lower(E r10) {
            return (E) Iterators.find(unfiltered().headSet(r10, false).descendingIterator(), this.predicate, null);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) Iterables.removeFirstMatching(unfiltered(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
            return Sets.filter(unfiltered().subSet(r10, r11, r12, r13), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r10, boolean r11) {
            return Sets.filter(unfiltered().tailSet(r10, r11), this.predicate);
        }

        public NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }
    }

    public static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        public FilteredSet(Set<E> r10, Predicate<? super E> r11) {
            super(r10, r11);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            return Sets.equalsImpl(this, r10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        public FilteredSortedSet(SortedSet<E> r10, Predicate<? super E> r11) {
            super(r10, r11);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) Iterators.find(this.unfiltered.iterator(), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E r10) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(r10), this.predicate);
        }

        public E last() {
            SortedSet r10 = (SortedSet) this.unfiltered;
        L3:
            E r11 = (Object) r10.last();
            if (this.predicate.apply(r11) == true) goto L5;
            r10 = r10.headSet(r11);
            goto L3
        L5:
            return r11;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E r10, E r11) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(r10, r11), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E r10) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(r10), this.predicate);
        }
    }

    public static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        public ImprovedAbstractSet() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r10) {
            return Sets.removeAllImpl(this, r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r10) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r10));
        }
    }

    public static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        public PowerSet(Set<E> r10) {
            if (r10.size() > 30) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Too many elements to create power set: %s > 30", r10.size());
            this.inputSet = Maps.indexMap(r10);
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Set) == false) goto L6;
            ImmutableSet<E> r11 = this.inputSet.keySet();
            return r11.containsAll((Set) r10);
        L6:
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof PowerSet) == false) goto L7;
            return this.inputSet.equals(((PowerSet) r10).inputSet);
        L7:
            return super.equals(r10);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            final int r10 = size();
            return new AnonymousClass1(this, r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.inputSet.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        public /* synthetic */ SetView(AnonymousClass1 r10) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean add(E r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean addAll(Collection<? extends E> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S copyInto(S r10) {
            r10.addAll(this);
            return r10;
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract UnmodifiableIterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean remove(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean retainAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        private SetView() {
        }
    }

    public static final class SubSet<E> extends AbstractSet<E> {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;

        public SubSet(ImmutableMap<E, Integer> r10, int r11) {
            this.inputSet = r10;
            this.mask = r11;
        }

        public static /* synthetic */ ImmutableMap access$100(SubSet r10) {
            return r10.inputSet;
        }

        public static /* synthetic */ int access$200(SubSet r10) {
            return r10.mask;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            Integer r11 = this.inputSet.get(r10);
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if ((this.mask & (1 << r11.intValue())) == 0) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.mask);
        }
    }

    public static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;

        @MonotonicNonNullDecl
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> r10) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(r10);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r10);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r10) {
            return this.delegate.ceiling(r10);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> r10 = this.descendingSet;
            if (r10 != null) goto L6;
            UnmodifiableNavigableSet<E> r11 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.descendingSet = r11;
            r11.descendingSet = this;
            return r11;
        L6:
            return r10;
        }

        @Override // java.util.NavigableSet
        public E floor(E r10) {
            return this.delegate.floor(r10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r10, boolean r11) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(r10, r11));
        }

        @Override // java.util.NavigableSet
        public E higher(E r10) {
            return this.delegate.higher(r10);
        }

        @Override // java.util.NavigableSet
        public E lower(E r10) {
            return this.delegate.lower(r10);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r10, boolean r11, E r12, boolean r13) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(r10, r11, r12, r13));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r10, boolean r11) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(r10, r11));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }

    private Sets() {
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> r10) {
        return CartesianSet.create(r10);
    }

    @Beta
    public static <E> Set<Set<E>> combinations(Set<E> r10, int r11) {
        ImmutableMap r12 = Maps.indexMap(r10);
        CollectPreconditions.checkNonnegative(r11, "size");
        if (r11 > r12.size()) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "size (%s) must be <= set.size() (%s)", r11, r12.size());
        if (r11 != 0) goto L11;
        return ImmutableSet.of(ImmutableSet.of());
    L11:
        if (r11 != r12.size()) goto L15;
        return ImmutableSet.of(r12.keySet());
    L15:
        return new AnonymousClass5(r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r10) {
        if ((r10 instanceof EnumSet) == true) goto L5;
        Preconditions.checkArgument(!r10.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(r10, r10.iterator().next().getDeclaringClass());
    L5:
        return EnumSet.complementOf((EnumSet) r10);
    }

    public static <E> SetView<E> difference(final Set<E> r10, final Set<?> r11) {
        Preconditions.checkNotNull(r10, "set1");
        Preconditions.checkNotNull(r11, "set2");
        return new AnonymousClass3(r10, r11);
    }

    public static boolean equalsImpl(Set<?> r10, @NullableDecl Object r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r11 instanceof Set) == false) goto L15;
        Set r12 = (Set) r11;
        if (r10.size() != r12.size()) goto L14;
        if (r10.containsAll(r12) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <E> Set<E> filter(Set<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof SortedSet) == false) goto L7;
        return filter((SortedSet) r10, r11);
    L7:
        if ((r10 instanceof FilteredSet) == false) goto L11;
        FilteredSet r12 = (FilteredSet) r10;
        Predicate r13 = Predicates.and(r12.predicate, r11);
        return new FilteredSet((Set) r12.unfiltered, r13);
    L11:
        return new FilteredSet((Set) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11));
    }

    public static int hashCodeImpl(Set<?> r10) {
        Iterator<?> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r13 = r11.next();
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L9:
        r12 = ~(~(r12 + r14));
        goto L4
    L8:
        r14 = 0;
        goto L9
    L10:
        return r12;
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E r10, E... r11) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(r10, r11));
    }

    public static <E> SetView<E> intersection(final Set<E> r10, final Set<?> r11) {
        Preconditions.checkNotNull(r10, "set1");
        Preconditions.checkNotNull(r11, "set2");
        return new AnonymousClass2(r10, r11);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> r10, Class<E> r11) {
        EnumSet<E> r12 = EnumSet.allOf(r11);
        r12.removeAll(r10);
        return r12;
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> r10, Class<E> r11) {
        EnumSet<E> r12 = EnumSet.noneOf(r11);
        Iterables.addAll(r12, r10);
        return r12;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int r10) {
        return new HashSet(Maps.capacity(r10));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r10) {
        return new LinkedHashSet(Maps.capacity(r10));
    }

    @Deprecated
    public static <E> Set<E> newSetFromMap(Map<E, Boolean> r10) {
        return Collections.newSetFromMap(r10);
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet();
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> r10) {
        return new PowerSet(r10);
    }

    public static boolean removeAllImpl(Set<?> r10, Iterator<?> r11) {
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | r10.remove(r11.next());
        goto L4
    L6:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> r10, Range<K> r11) {
        boolean r12 = false;
        if (r10.comparator() == null) goto L16;
        if (r10.comparator() == Ordering.natural()) goto L16;
        if (r11.hasLowerBound() == false) goto L16;
        if (r11.hasUpperBound() == false) goto L16;
        if (r10.comparator().compare(r11.lowerEndpoint(), r11.upperEndpoint()) > 0) goto L13;
        boolean r13 = true;
    L14:
        Preconditions.checkArgument(r13, "set is using a custom comparator which is inconsistent with the natural ordering.");
        goto L16
    L13:
        r13 = false;
    L16:
        if (r11.hasLowerBound() == false) goto L29;
        if (r11.hasUpperBound() == false) goto L29;
        Comparable r14 = r11.lowerEndpoint();
        BoundType r15 = r11.lowerBoundType();
        BoundType r16 = BoundType.CLOSED;
        if (r15 != r16) goto L22;
        boolean r17 = true;
    L23:
        Comparable r18 = r11.upperEndpoint();
        if (r11.upperBoundType() != r16) goto L27;
        r12 = true;
    L27:
        return r10.subSet(r14, r17, r18, r12);
    L22:
        r17 = false;
    L29:
        if (r11.hasLowerBound() == false) goto L36;
        Comparable r19 = r11.lowerEndpoint();
        if (r11.lowerBoundType() != BoundType.CLOSED) goto L34;
        r12 = true;
    L34:
        return r10.tailSet(r19, r12);
    L36:
        if (r11.hasUpperBound() == false) goto L43;
        Comparable r20 = r11.upperEndpoint();
        if (r11.upperBoundType() != BoundType.CLOSED) goto L41;
        r12 = true;
    L41:
        return r10.headSet(r20, r12);
    L43:
        return (NavigableSet) Preconditions.checkNotNull(r10);
    }

    public static <E> SetView<E> symmetricDifference(final Set<? extends E> r10, final Set<? extends E> r11) {
        Preconditions.checkNotNull(r10, "set1");
        Preconditions.checkNotNull(r11, "set2");
        return new AnonymousClass4(r10, r11);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> r10) {
        return Synchronized.navigableSet(r10);
    }

    public static <E> SetView<E> union(final Set<? extends E> r10, final Set<? extends E> r11) {
        Preconditions.checkNotNull(r10, "set1");
        Preconditions.checkNotNull(r11, "set2");
        return new AnonymousClass1(r10, r11);
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> r10) {
        if ((r10 instanceof ImmutableCollection) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof UnmodifiableNavigableSet) == true) goto L9;
        return new UnmodifiableNavigableSet(r10);
    }

    @SafeVarargs
    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... r10) {
        return cartesianProduct(Arrays.asList(r10));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> r10) {
        if ((r10 instanceof ImmutableEnumSet) == false) goto L7;
        return (ImmutableEnumSet) r10;
    L7:
        if ((r10 instanceof Collection) == false) goto L14;
        Collection r11 = (Collection) r10;
        if (r11.isEmpty() == false) goto L13;
        return ImmutableSet.of();
    L13:
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r11));
    L14:
        Iterator<E> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L19;
        EnumSet r13 = EnumSet.of(r12.next());
        Iterators.addAll(r13, r12);
        return ImmutableEnumSet.asImmutable(r13);
    L19:
        return ImmutableSet.of();
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> r10) {
        Set<E> r11 = newConcurrentHashSet();
        Iterables.addAll(r11, r10);
        return r11;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == false) goto L5;
        Collection r11 = Collections2.cast(r10);
    L7:
        return new CopyOnWriteArraySet(r11);
    L5:
        r11 = Lists.newArrayList(r10);
        goto L7
    }

    public static <E> HashSet<E> newHashSet(E... r10) {
        HashSet<E> r11 = newHashSetWithExpectedSize(r10.length);
        Collections.addAll(r11, r10);
        return r11;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        LinkedHashSet<E> r11 = newLinkedHashSet();
        Iterables.addAll(r11, r10);
        return r11;
    L5:
        return new LinkedHashSet(Collections2.cast(r10));
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> r10) {
        TreeSet<E> r11 = newTreeSet();
        Iterables.addAll(r11, r10);
        return r11;
    }

    public static boolean removeAllImpl(Set<?> r10, Collection<?> r11) {
        Preconditions.checkNotNull(r11);
        if ((r11 instanceof Multiset) == false) goto L6;
        r11 = ((Multiset) r11).elementSet();
    L6:
        if ((r11 instanceof Set) == false) goto L12;
        if (r11.size() <= r10.size()) goto L12;
        return Iterators.removeAll(r10.iterator(), r11);
    L12:
        return removeAllImpl(r10, r11.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> r10) {
        if ((r10 instanceof Collection) == false) goto L6;
        return new HashSet(Collections2.cast(r10));
    L6:
        return newHashSet(r10.iterator());
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> r10) {
        return new TreeSet((Comparator) Preconditions.checkNotNull(r10));
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r10, Class<E> r11) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof EnumSet) == false) goto L6;
        return EnumSet.complementOf((EnumSet) r10);
    L6:
        return makeComplementByHand(r10, r11);
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> r10) {
        HashSet<E> r11 = newHashSet();
        Iterators.addAll(r11, r10);
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> filter(SortedSet<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof FilteredSet) == false) goto L7;
        FilteredSet r12 = (FilteredSet) r10;
        Predicate r13 = Predicates.and(r12.predicate, r11);
        return new FilteredSortedSet((SortedSet) r12.unfiltered, r13);
    L7:
        return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <E> NavigableSet<E> filter(NavigableSet<E> r10, Predicate<? super E> r11) {
        if ((r10 instanceof FilteredSet) == false) goto L7;
        FilteredSet r12 = (FilteredSet) r10;
        Predicate r13 = Predicates.and(r12.predicate, r11);
        return new FilteredNavigableSet((NavigableSet) r12.unfiltered, r13);
    L7:
        return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11));
    }
}
