package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> ALL = null;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = null;

    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;

    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;

        @MonotonicNonNullDecl
        private transient Integer size;
        final /* synthetic */ ImmutableRangeSet this$0;

        public AsSet(ImmutableRangeSet r10, DiscreteDomain<C> r11) {
            this.this$0 = r10;
            super(Ordering.natural());
            this.domain = r11;
        }

        public static /* synthetic */ DiscreteDomain access$100(AsSet r10) {
            return r10.domain;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            if (r10 != null) goto L8;
            return false;
        L8:
            ImmutableRangeSet r11 = this.this$0;     // Catch: ClassCastException -> L7
            return r11.contains((Comparable) r10);
        L7:
            return false;
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        public /* bridge */ /* synthetic */ Iterator descendingIterator() {
            return descendingIterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet headSetImpl(Object r10, boolean r11) {
            return headSetImpl((Comparable) r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object r10) {
            if (contains(r10) == false) goto L14;
            Comparable r11 = (Comparable) r10;
            UnmodifiableIterator r12 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r13 = 0;
        L6:
            if (r12.hasNext() == false) goto L13;
            Range r14 = (Range) r12.next();
            if (r14.contains(r11) == true) goto L10;
            r13 = r13 + ((long) ContiguousSet.create(r14, this.domain).size());
            goto L6
        L10:
            return Ints.saturatedCast(r13 + ((long) ContiguousSet.create(r14, this.domain).indexOf(r11)));
        L13:
            throw new AssertionError("impossible");
        L14:
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.access$000(this.this$0).isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer r10 = this.size;
            if (r10 != null) goto L11;
            UnmodifiableIterator r11 = ImmutableRangeSet.access$000(this.this$0).iterator();
            long r12 = 0;
        L6:
            if (r11.hasNext() == false) goto L9;
            r12 = r12 + ((long) ContiguousSet.create((Range) r11.next(), this.domain).size());
            if (r12 < 2147483647L) goto L6;
        L9:
            r10 = Integer.valueOf(Ints.saturatedCast(r12));
            this.size = r10;
        L11:
            return r10.intValue();
        }

        public ImmutableSortedSet<C> subSet(Range<C> r10) {
            return this.this$0.subRangeSet(r10).asSet(this.domain);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet subSetImpl(Object r10, boolean r11, Object r12, boolean r13) {
            return subSetImpl((Comparable) r10, r11, (Comparable) r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public /* bridge */ /* synthetic */ ImmutableSortedSet tailSetImpl(Object r10, boolean r11) {
            return tailSetImpl((Comparable) r10, r11);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.access$000(this.this$0).toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        public UnmodifiableIterator<C> descendingIterator() {
            return new AnonymousClass2(this);
        }

        public ImmutableSortedSet<C> headSetImpl(C r10, boolean r11) {
            return subSet(Range.upTo(r10, BoundType.forBoolean(r11)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<C> iterator() {
            return new AnonymousClass1(this);
        }

        public ImmutableSortedSet<C> subSetImpl(C r10, boolean r11, C r12, boolean r13) {
            if (r11 == true) goto L9;
            if (r13 == true) goto L9;
            if (Range.compareOrThrow(r10, r12) != 0) goto L9;
            return ImmutableSortedSet.of();
        L9:
            return subSet(Range.range(r10, BoundType.forBoolean(r11), r12, BoundType.forBoolean(r13)));
        }

        public ImmutableSortedSet<C> tailSetImpl(C r10, boolean r11) {
            return subSet(Range.downTo(r10, BoundType.forBoolean(r11)));
        }
    }

    public static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        public AsSetSerializedForm(ImmutableList<Range<C>> r10, DiscreteDomain<C> r11) {
            this.ranges = r10;
            this.domain = r11;
        }

        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    public static class Builder<C extends Comparable<?>> {
        private final List<Range<C>> ranges;

        public Builder() {
            this.ranges = Lists.newArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<C> add(Range<C> r10) {
            Preconditions.checkArgument(!r10.isEmpty(), "range must not be empty, but was %s", r10);
            this.ranges.add(r10);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(RangeSet<C> r10) {
            return addAll(r10.asRanges());
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder r10 = new ImmutableList.Builder(this.ranges.size());
            Collections.sort(this.ranges, Range.rangeLexOrdering());
            PeekingIterator r11 = Iterators.peekingIterator(this.ranges.iterator());
        L4:
            if (r11.hasNext() == false) goto L12;
            Range r12 = (Range) r11.next();
        L7:
            if (r11.hasNext() == false) goto L11;
            Range<C> r13 = (Range) r11.peek();
            if (r12.isConnected(r13) == false) goto L11;
            Preconditions.checkArgument(r12.intersection(r13).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", r12, r13);
            r12 = r12.span((Range) r11.next());
        L11:
            r10.add(r12);
            goto L4
        L12:
            ImmutableList r14 = r10.build();
            if (r14.isEmpty() == false) goto L17;
            return ImmutableRangeSet.of();
        L17:
            if (r14.size() != 1) goto L23;
            if (((Range) Iterables.getOnlyElement(r14)).equals(Range.all()) == false) goto L23;
            return ImmutableRangeSet.all();
        L23:
            return new ImmutableRangeSet(r14);
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(Iterable<Range<C>> r10) {
            Iterator<Range<C>> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            add(r11.next());
            goto L4
        L6:
            return this;
        }
    }

    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;
        final /* synthetic */ ImmutableRangeSet this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ComplementRanges(ImmutableRangeSet r10) {
            this.this$0 = r10;
            boolean r11 = ((Range) ImmutableRangeSet.access$000(r10).get(0)).hasLowerBound();
            this.positiveBoundedBelow = r11;
            boolean r12 = ((Range) Iterables.getLast(ImmutableRangeSet.access$000(r10))).hasUpperBound();
            this.positiveBoundedAbove = r12;
            int r13 = ImmutableRangeSet.access$000(r10).size();
            int r14 = r13 - 1;
            if (r11 == true) goto L6;
            r13 = r14;
        L6:
            if (r12 == false) goto L8;
            r13 = r13 + 1;
        L8:
            this.size = r13;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public Range<C> get(int r10) {
            Preconditions.checkElementIndex(r10, this.size);
            if (this.positiveBoundedBelow == false) goto L7;
            if (r10 != 0) goto L6;
            Cut<C> r11 = Cut.belowAll();
        L9:
            if (this.positiveBoundedAbove == true) goto L11;
        L13:
            Cut<C> r12 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r10 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
        L15:
            return Range.create(r11, r12);
        L11:
            if (r10 != (this.size - 1)) goto L13;
            r12 = Cut.aboveAll();
            goto L15
        L6:
            r11 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r10 - 1)).upperBound;
            goto L9
        L7:
            r11 = ((Range) ImmutableRangeSet.access$000(this.this$0).get(r10)).upperBound;
            goto L9
        }
    }

    public static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        public SerializedForm(ImmutableList<Range<C>> r10) {
            this.ranges = r10;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty() == false) goto L7;
            return ImmutableRangeSet.of();
        L7:
            if (this.ranges.equals(ImmutableList.of(Range.all())) == false) goto L11;
            return ImmutableRangeSet.all();
        L11:
            return new ImmutableRangeSet(this.ranges);
        }
    }

    static {
        EMPTY = new ImmutableRangeSet(ImmutableList.of());
        ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    }

    public ImmutableRangeSet(ImmutableList<Range<C>> r10) {
        this.ranges = r10;
    }

    public static /* synthetic */ ImmutableList access$000(ImmutableRangeSet r10) {
        return r10.ranges;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> r10) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r10.encloses(Range.all()) == false) goto L11;
        return all();
    L11:
        if ((r10 instanceof ImmutableRangeSet) == false) goto L16;
        ImmutableRangeSet<C> r11 = (ImmutableRangeSet) r10;
        if (r11.isPartialView() == true) goto L16;
        return r11;
    L16:
        return new ImmutableRangeSet(ImmutableList.copyOf(r10.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> r10) {
        if (this.ranges.isEmpty() == true) goto L26;
        if (r10.isEmpty() == true) goto L26;
        if (r10.encloses(span()) == false) goto L12;
        return this.ranges;
    L12:
        if (r10.hasLowerBound() == false) goto L14;
        final int r11 = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), r10.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L16:
        if (r10.hasUpperBound() == false) goto L18;
        int r12 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    L19:
        final int r13 = r12 - r11;
        if (r13 != 0) goto L24;
        return ImmutableList.of();
    L24:
        return (ImmutableList<Range<C>>) new AnonymousClass1(this, r13, r11, r10);
    L18:
        r12 = this.ranges.size();
        goto L19
    L14:
        r11 = 0;
    L26:
        return ImmutableList.of();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> r10) {
        return copyOf(TreeRangeSet.create(r10));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void add(Range<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(RangeSet<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ Set asDescendingSetOfRanges() {
        return asDescendingSetOfRanges();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ Set asRanges() {
        return asRanges();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> r10) {
        Preconditions.checkNotNull(r10);
        if (isEmpty() == true) goto L5;
        Range<C> r11 = span().canonical(r10);
        if (r11.hasLowerBound() == false) goto L17;
        if (r11.hasUpperBound() == true) goto L15;
        r10.maxValue();     // Catch: NoSuchElementException -> L12
    L13:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
    L15:
        return new AsSet(this, r10);
    L17:
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    L5:
        return ImmutableSortedSet.of();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ RangeSet complement() {
        return complement();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return super.contains(r10);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> r10) {
        TreeRangeSet r11 = TreeRangeSet.create(this);
        r11.removeAll(r10);
        return copyOf(r11);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> r10) {
        int r11 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r11 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.ranges.get(r11).encloses(r10) == false) goto L7;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet r10) {
        return super.enclosesAll(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> r10) {
        TreeRangeSet r11 = TreeRangeSet.create(this);
        r11.removeAll(r10.complement());
        return copyOf(r11);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r10) {
        int r11 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), r10.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (r11 < this.ranges.size()) goto L5;
    L9:
        if (r11 <= 0) goto L15;
        int r12 = r11 - 1;
        if (this.ranges.get(r12).isConnected(r10) == false) goto L15;
        if (this.ranges.get(r12).intersection(r10).isEmpty() == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (this.ranges.get(r11).isConnected(r10) == false) goto L9;
        if (this.ranges.get(r11).intersection(r10).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public Range<C> rangeContaining(C r10) {
        int r11 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(r10), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (r11 == (-1)) goto L8;
        Range<C> r12 = this.ranges.get(r11);
        if (r12.contains(r10) == true) goto L7;
        return null;
    L7:
        return r12;
    L8:
        return null;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void remove(Range<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(RangeSet<C> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (this.ranges.isEmpty() == true) goto L7;
        Cut<C> r10 = this.ranges.get(0).lowerBound;
        ImmutableList<Range<C>> r11 = this.ranges;
        return Range.create(r10, r11.get(r11.size() - 1).upperBound);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ RangeSet subRangeSet(Range r10) {
        return subRangeSet(r10);
    }

    public ImmutableRangeSet<C> union(RangeSet<C> r10) {
        return unionOf(Iterables.concat(asRanges(), r10.asRanges()));
    }

    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> r10) {
        Preconditions.checkNotNull(r10);
        if (r10.isEmpty() == false) goto L7;
        return of();
    L7:
        if (r10.equals(Range.all()) == false) goto L11;
        return all();
    L11:
        return new ImmutableRangeSet(ImmutableList.of(r10));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void addAll(Iterable<Range<C>> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty() == false) goto L7;
        return ImmutableSet.of();
    L7:
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> r10 = this.complement;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.ranges.isEmpty() == false) goto L10;
        ImmutableRangeSet<C> r11 = all();
        this.complement = r11;
        return r11;
    L10:
        if (this.ranges.size() == 1) goto L12;
    L15:
        ImmutableRangeSet<C> r12 = new ImmutableRangeSet(new ComplementRanges(this), this);
        this.complement = r12;
        return r12;
    L12:
        if (this.ranges.get(0).equals(Range.all()) == false) goto L15;
        ImmutableRangeSet<C> r13 = of();
        this.complement = r13;
        return r13;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable r10) {
        return super.enclosesAll(r10);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @Deprecated
    public void removeAll(Iterable<Range<C>> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> r10) {
        if (isEmpty() == true) goto L12;
        Range<C> r11 = span();
        if (r10.encloses(r11) == false) goto L8;
        return this;
    L8:
        if (r10.isConnected(r11) == false) goto L12;
        return new ImmutableRangeSet(intersectRanges(r10));
    L12:
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> r10, ImmutableRangeSet<C> r11) {
        this.ranges = r10;
        this.complement = r11;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> r10) {
        return new Builder().addAll(r10).build();
    }
}
