package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Sets {

    private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient ImmutableList<ImmutableSet<E>> axes;
        private final transient CartesianList<E> delegate;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        static <E> Set<List<E>> create(List<? extends Set<? extends E>> r3) {
            ImmutableList.Builder r0 = new ImmutableList.Builder(r3.size());
            Iterator<? extends Set<? extends E>> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L10;
            ImmutableSet r1 = ImmutableSet.copyOf(r4.next());
            if (r1.isEmpty() == true) goto L8;
            r0.add(r1);
            goto L4
        L8:
            return ImmutableSet.of();
        L10:
            final ImmutableList<E> r5 = r0.build();
            return new CartesianSet(r5, new CartesianList(new AnonymousClass1(r5)));
        }

        private CartesianSet(ImmutableList<ImmutableSet<E>> r1, CartesianList<E> r2) {
            this.axes = r1;
            this.delegate = r2;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<List<E>> delegate() {
            return this.delegate;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof CartesianSet) == false) goto L7;
            return this.axes.equals(((CartesianSet) r2).axes);
        L7:
            return super.equals(r2);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int r1 = 1;
            int r0 = size() - 1;
            int r2 = 0;
        L4:
            if (r2 >= this.axes.size()) goto L6;
            r0 = ~(~(r0 * 31));
            r2 = r2 + 1;
            goto L4
        L6:
            UnmodifiableIterator<ImmutableSet<E>> r3 = this.axes.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            ImmutableSet<E> r4 = r3.next();
            r1 = ~(~((r1 * 31) + ((size() / r4.size()) * r4.hashCode())));
            goto L8
        L11:
            return ~(~(r1 + r0));
        }
    }

    static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> forward;

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        DescendingSet(NavigableSet<E> r1) {
            this.forward = r1;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected NavigableSet<E> delegate() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E lower(E r1) {
            return this.forward.higher(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E floor(E r1) {
            return this.forward.ceiling(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E ceiling(E r1) {
            return this.forward.floor(r1);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public E higher(E r1) {
            return this.forward.lower(r1);
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
        public NavigableSet<E> descendingSet() {
            return this.forward;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.forward.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E r1, boolean r2, E r3, boolean r4) {
            return this.forward.subSet(r3, r4, r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E r1, boolean r2) {
            return this.forward.tailSet(r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E r1, boolean r2) {
            return this.forward.headSet(r1, r2).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> r0 = this.forward.comparator();
            if (r0 != null) goto L7;
            return Ordering.natural().reverse();
        L7:
            return reverse(r0);
        }

        private static <T> Ordering<T> reverse(Comparator<T> r0) {
            return Ordering.from(r0).reverse();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E first() {
            return this.forward.last();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(E r1) {
            return standardHeadSet(r1);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public E last() {
            return this.forward.first();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(E r1, E r2) {
            return standardSubSet(r1, r2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(E r1) {
            return standardTailSet(r1);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.forward.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }
    }

    private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        NavigableSet<E> unfiltered() {
            return (NavigableSet) this.unfiltered;
        }

        @Override // java.util.NavigableSet
        @Nullable
        public E lower(E r2) {
            return (E) Iterators.getNext(headSet(r2, false).descendingIterator(), null);
        }

        @Override // java.util.NavigableSet
        @Nullable
        public E floor(E r2) {
            return (E) Iterators.getNext(headSet(r2, true).descendingIterator(), null);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r2) {
            return (E) Iterables.getFirst(tailSet(r2, true), null);
        }

        @Override // java.util.NavigableSet
        public E higher(E r2) {
            return (E) Iterables.getFirst(tailSet(r2, false), null);
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
        public NavigableSet<E> descendingSet() {
            return Sets.filter(unfiltered().descendingSet(), this.predicate);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
        }

        @Override // com.google.common.collect.Sets.FilteredSortedSet, java.util.SortedSet
        public E last() {
            return descendingIterator().next();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r2, boolean r3, E r4, boolean r5) {
            return Sets.filter(unfiltered().subSet(r2, r3, r4, r5), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r2, boolean r3) {
            return Sets.filter(unfiltered().headSet(r2, r3), this.predicate);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r2, boolean r3) {
            return Sets.filter(unfiltered().tailSet(r2, r3), this.predicate);
        }
    }

    private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r1) {
            return Sets.equalsImpl(this, r1);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> r1, Predicate<? super E> r2) {
            super(r1, r2);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E r3, E r4) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(r3, r4), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E r3) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(r3), this.predicate);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E r3) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(r3), this.predicate);
        }

        @Override // java.util.SortedSet
        public E first() {
            return iterator().next();
        }

        public E last() {
            SortedSet r0 = (SortedSet) this.unfiltered;
        L3:
            E r1 = (Object) r0.last();
            if (this.predicate.apply(r1) == true) goto L5;
            r0 = r0.headSet(r1);
            goto L3
        L5:
            return r1;
        }
    }

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r1) {
            return Sets.removeAllImpl(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r1) {
            return super.retainAll((Collection) Preconditions.checkNotNull(r1));
        }
    }

    private static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> inputSet;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        PowerSet(Set<E> r6) {
            ImmutableMap.Builder r0 = ImmutableMap.builder();
            Iterator<E> r7 = ((Set) Preconditions.checkNotNull(r6)).iterator();
            int r2 = 0;
        L4:
            if (r7.hasNext() == false) goto L6;
            r0.put(r7.next(), Integer.valueOf(r2));
            r2 = r2 + 1;
            goto L4
        L6:
            ImmutableMap<E, Integer> r8 = r0.build();
            this.inputSet = r8;
            if (r8.size() > 30) goto L9;
            boolean r5 = true;
        L10:
            Preconditions.checkArgument(r5, "Too many elements to create power set: %s > 30", new Object[]{Integer.valueOf(r8.size())});
            return;
        L9:
            r5 = false;
            goto L10
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.inputSet.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            final int r1 = size();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r2) {
            if ((r2 instanceof Set) == false) goto L6;
            ImmutableSet<E> r1 = this.inputSet.keySet();
            return r1.containsAll((Set) r2);
        L6:
            return false;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof PowerSet) == false) goto L7;
            return this.inputSet.equals(((PowerSet) r2).inputSet);
        L7:
            return super.equals(r2);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.inputSet.keySet().hashCode() << (this.inputSet.size() - 1);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        /* synthetic */ SetView(AnonymousClass1 r1) {
            this();
        }

        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf(this);
        }

        public <S extends Set<E>> S copyInto(S r1) {
            r1.addAll(this);
            return r1;
        }
    }

    private static final class SubSet<E> extends AbstractSet<E> {
        private final ImmutableMap<E, Integer> inputSet;
        private final int mask;

        static /* synthetic */ ImmutableMap access$100(SubSet r0) {
            return r0.inputSet;
        }

        static /* synthetic */ int access$200(SubSet r0) {
            return r0.mask;
        }

        SubSet(ImmutableMap<E, Integer> r1, int r2) {
            this.inputSet = r1;
            this.mask = r2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.mask);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object r2) {
            Integer r3 = this.inputSet.get(r2);
            if (r3 != null) goto L5;
        L7:
            return false;
        L5:
            if ((this.mask & (1 << r3.intValue())) == 0) goto L7;
            return true;
        }
    }

    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        UnmodifiableNavigableSet(NavigableSet<E> r1) {
            this.delegate = (NavigableSet) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected SortedSet<E> delegate() {
            return Collections.unmodifiableSortedSet(this.delegate);
        }

        @Override // java.util.NavigableSet
        public E lower(E r1) {
            return this.delegate.lower(r1);
        }

        @Override // java.util.NavigableSet
        public E floor(E r1) {
            return this.delegate.floor(r1);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r1) {
            return this.delegate.ceiling(r1);
        }

        @Override // java.util.NavigableSet
        public E higher(E r1) {
            return this.delegate.higher(r1);
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
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> r0 = this.descendingSet;
            if (r0 != null) goto L6;
            UnmodifiableNavigableSet<E> r1 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.descendingSet = r1;
            r1.descendingSet = this;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r1, boolean r2, E r3, boolean r4) {
            return Sets.unmodifiableNavigableSet(this.delegate.subSet(r1, r2, r3, r4));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r1, boolean r2) {
            return Sets.unmodifiableNavigableSet(this.delegate.headSet(r1, r2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r1, boolean r2) {
            return Sets.unmodifiableNavigableSet(this.delegate.tailSet(r1, r2));
        }
    }

    private Sets() {
    }

    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E r0, E... r1) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(r0, r1));
    }

    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> r1) {
        if ((r1 instanceof ImmutableEnumSet) == false) goto L7;
        return (ImmutableEnumSet) r1;
    L7:
        if ((r1 instanceof Collection) == false) goto L14;
        Collection r2 = (Collection) r1;
        if (r2.isEmpty() == false) goto L13;
        return ImmutableSet.of();
    L13:
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(r2));
    L14:
        Iterator<E> r3 = r1.iterator();
        if (r3.hasNext() == false) goto L19;
        EnumSet r0 = EnumSet.of(r3.next());
        Iterators.addAll(r0, r3);
        return ImmutableEnumSet.asImmutable(r0);
    L19:
        return ImmutableSet.of();
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> r0, Class<E> r1) {
        EnumSet<E> r2 = EnumSet.noneOf(r1);
        Iterables.addAll(r2, r0);
        return r2;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> HashSet<E> newHashSet(E... r1) {
        HashSet<E> r0 = newHashSetWithExpectedSize(r1.length);
        Collections.addAll(r0, r1);
        return r0;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int r1) {
        return new HashSet(Maps.capacity(r1));
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L6;
        return new HashSet(Collections2.cast(r1));
    L6:
        return newHashSet(r1.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> r1) {
        HashSet<E> r0 = newHashSet();
        Iterators.addAll(r0, r1);
        return r0;
    }

    public static <E> Set<E> newConcurrentHashSet() {
        return newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> r1) {
        Set<E> r0 = newConcurrentHashSet();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int r1) {
        return new LinkedHashSet(Maps.capacity(r1));
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == true) goto L5;
        LinkedHashSet<E> r0 = newLinkedHashSet();
        Iterables.addAll(r0, r1);
        return r0;
    L5:
        return new LinkedHashSet(Collections2.cast(r1));
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> r1) {
        TreeSet<E> r0 = newTreeSet();
        Iterables.addAll(r0, r1);
        return r0;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> r1) {
        return new TreeSet((Comparator) Preconditions.checkNotNull(r1));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> r1) {
        if ((r1 instanceof Collection) == false) goto L5;
        Collection r2 = Collections2.cast(r1);
    L7:
        return new CopyOnWriteArraySet(r2);
    L5:
        r2 = Lists.newArrayList(r1);
        goto L7
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r2) {
        if ((r2 instanceof EnumSet) == true) goto L5;
        Preconditions.checkArgument(!r2.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(r2, r2.iterator().next().getDeclaringClass());
    L5:
        return EnumSet.complementOf((EnumSet) r2);
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> r1, Class<E> r2) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof EnumSet) == false) goto L6;
        return EnumSet.complementOf((EnumSet) r1);
    L6:
        return makeComplementByHand(r1, r2);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> r0, Class<E> r1) {
        EnumSet<E> r2 = EnumSet.allOf(r1);
        r2.removeAll(r0);
        return r2;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> r0) {
        return Platform.newSetFromMap(r0);
    }

    public static <E> SetView<E> union(final Set<? extends E> r2, final Set<? extends E> r3) {
        Preconditions.checkNotNull(r2, "set1");
        Preconditions.checkNotNull(r3, "set2");
        final SetView r0 = difference(r3, r2);
        return new AnonymousClass1(r2, r0, r3);
    }

    public static <E> SetView<E> intersection(final Set<E> r2, final Set<?> r3) {
        Preconditions.checkNotNull(r2, "set1");
        Preconditions.checkNotNull(r3, "set2");
        final Predicate r0 = Predicates.in(r3);
        return new AnonymousClass2(r2, r0, r3);
    }

    public static <E> SetView<E> difference(final Set<E> r2, final Set<?> r3) {
        Preconditions.checkNotNull(r2, "set1");
        Preconditions.checkNotNull(r3, "set2");
        final Predicate r0 = Predicates.not(Predicates.in(r3));
        return new AnonymousClass3(r2, r0, r3);
    }

    public static <E> SetView<E> symmetricDifference(Set<? extends E> r1, Set<? extends E> r2) {
        Preconditions.checkNotNull(r1, "set1");
        Preconditions.checkNotNull(r2, "set2");
        return difference(union(r1, r2), intersection(r1, r2));
    }

    public static <E> Set<E> filter(Set<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof SortedSet) == false) goto L7;
        return filter((SortedSet) r1, r2);
    L7:
        if ((r1 instanceof FilteredSet) == false) goto L11;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredSet((Set) r3.unfiltered, r4);
    L11:
        return new FilteredSet((Set) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    public static <E> SortedSet<E> filter(SortedSet<E> r0, Predicate<? super E> r1) {
        return Platform.setsFilterSortedSet(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> SortedSet<E> filterSortedIgnoreNavigable(SortedSet<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredSet) == false) goto L7;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredSortedSet((SortedSet) r3.unfiltered, r4);
    L7:
        return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> NavigableSet<E> filter(NavigableSet<E> r1, Predicate<? super E> r2) {
        if ((r1 instanceof FilteredSet) == false) goto L7;
        FilteredSet r3 = (FilteredSet) r1;
        Predicate r4 = Predicates.and(r3.predicate, r2);
        return new FilteredNavigableSet((NavigableSet) r3.unfiltered, r4);
    L7:
        return new FilteredNavigableSet((NavigableSet) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2));
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> r0) {
        return CartesianSet.create(r0);
    }

    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... r0) {
        return cartesianProduct(Arrays.asList(r0));
    }

    public static <E> Set<Set<E>> powerSet(Set<E> r1) {
        return new PowerSet(r1);
    }

    static int hashCodeImpl(Set<?> r3) {
        Iterator<?> r4 = r3.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r2 = r4.next();
        if (r2 == null) goto L8;
        int r5 = r2.hashCode();
    L9:
        r1 = ~(~(r1 + r5));
        goto L4
    L8:
        r5 = 0;
        goto L9
    L10:
        return r1;
    }

    static boolean equalsImpl(Set<?> r4, @Nullable Object r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Set) == false) goto L15;
        Set r6 = (Set) r5;
        if (r4.size() != r6.size()) goto L14;
        if (r4.containsAll(r6) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> r1) {
        if ((r1 instanceof ImmutableSortedSet) == false) goto L5;
    L9:
        return r1;
    L5:
        if ((r1 instanceof UnmodifiableNavigableSet) == true) goto L9;
        return new UnmodifiableNavigableSet(r1);
    }

    public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> r0) {
        return Synchronized.navigableSet(r0);
    }

    static boolean removeAllImpl(Set<?> r2, Iterator<?> r3) {
        boolean r0 = false;
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 | r2.remove(r3.next());
        goto L4
    L6:
        return r0;
    }

    static boolean removeAllImpl(Set<?> r2, Collection<?> r3) {
        Preconditions.checkNotNull(r3);
        if ((r3 instanceof Multiset) == false) goto L6;
        r3 = ((Multiset) r3).elementSet();
    L6:
        if ((r3 instanceof Set) == false) goto L12;
        if (r3.size() <= r2.size()) goto L12;
        return Iterators.removeAll(r2.iterator(), r3);
    L12:
        return removeAllImpl(r2, r3.iterator());
    }
}
