package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = null;
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* JADX INFO: renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = null;

        static {
            int[] r10 = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = r10;
            r10[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn INSTANCE = null;

        static {
            INSTANCE = new LowerBoundFn();
        }

        public LowerBoundFn() {
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Cut apply(Range r10) {
            return apply2(r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Cut apply2(Range r10) {
            return r10.lowerBound;
        }
    }

    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new RangeLexOrdering();
        }

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return compare((Range) r10, (Range) r11);
        }

        public int compare(Range<?> r10, Range<?> r11) {
            return ComparisonChain.start().compare(r10.lowerBound, r11.lowerBound).compare(r10.upperBound, r11.upperBound).result();
        }
    }

    public static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn INSTANCE = null;

        static {
            INSTANCE = new UpperBoundFn();
        }

        public UpperBoundFn() {
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Cut apply(Range r10) {
            return apply2(r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Cut apply2(Range r10) {
            return r10.upperBound;
        }
    }

    static {
        ALL = new Range(Cut.belowAll(), Cut.aboveAll());
    }

    private Range(Cut<C> r10, Cut<C> r11) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(r10);
        this.upperBound = (Cut) Preconditions.checkNotNull(r11);
        if (r10.compareTo(r11) > 0) goto L10;
        if (r10 == Cut.aboveAll()) goto L10;
        if (r11 == Cut.belowAll()) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Invalid range: " + toString(r10, r11));
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C r10) {
        return create(Cut.belowValue(r10), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C r10) {
        return create(Cut.belowAll(), Cut.aboveValue(r10));
    }

    private static <T> SortedSet<T> cast(Iterable<T> r10) {
        return (SortedSet) r10;
    }

    public static <C extends Comparable<?>> Range<C> closed(C r10, C r11) {
        return create(Cut.belowValue(r10), Cut.aboveValue(r11));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C r10, C r11) {
        return create(Cut.belowValue(r10), Cut.belowValue(r11));
    }

    public static int compareOrThrow(Comparable r10, Comparable r11) {
        return r10.compareTo(r11);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> r10, Cut<C> r11) {
        return new Range(r10, r11);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C r10, BoundType r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r11.ordinal()];
        if (r12 == 1) goto L11;
        if (r12 != 2) goto L9;
        return atLeast(r10);
    L9:
        throw new AssertionError();
    L11:
        return greaterThan(r10);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof SortedSet) == false) goto L9;
        SortedSet r11 = cast(r10);
        Comparator r12 = r11.comparator();
        if (Ordering.natural().equals(r12) == true) goto L8;
        if (r12 != null) goto L9;
    L8:
        return closed((Comparable) r11.first(), (Comparable) r11.last());
    L9:
        Iterator<C> r13 = r10.iterator();
        Comparable r14 = (Comparable) Preconditions.checkNotNull(r13.next());
        Comparable r15 = r14;
    L11:
        if (r13.hasNext() == false) goto L14;
        Comparable r16 = (Comparable) Preconditions.checkNotNull(r13.next());
        r14 = (Comparable) Ordering.natural().min(r14, r16);
        r15 = (Comparable) Ordering.natural().max(r15, r16);
        goto L11
    L14:
        return closed(r14, r15);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C r10) {
        return create(Cut.aboveValue(r10), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C r10) {
        return create(Cut.belowAll(), Cut.belowValue(r10));
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return LowerBoundFn.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> open(C r10, C r11) {
        return create(Cut.aboveValue(r10), Cut.belowValue(r11));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C r10, C r11) {
        return create(Cut.aboveValue(r10), Cut.aboveValue(r11));
    }

    public static <C extends Comparable<?>> Range<C> range(C r10, BoundType r11, C r12, BoundType r13) {
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r13);
        BoundType r14 = BoundType.OPEN;
        if (r11 != r14) goto L5;
        Cut r15 = Cut.aboveValue(r10);
    L6:
        if (r13 != r14) goto L8;
        Cut r16 = Cut.belowValue(r12);
    L10:
        return create(r15, r16);
    L8:
        r16 = Cut.aboveValue(r12);
        goto L10
    L5:
        r15 = Cut.belowValue(r10);
        goto L6
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C r10) {
        return closed(r10, r10);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C r10, BoundType r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r11.ordinal()];
        if (r12 == 1) goto L11;
        if (r12 != 2) goto L9;
        return atMost(r10);
    L9:
        throw new AssertionError();
    L11:
        return lessThan(r10);
    }

    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return UpperBoundFn.INSTANCE;
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object r10) {
        return apply((Comparable) r10);
    }

    public Range<C> canonical(DiscreteDomain<C> r10) {
        Preconditions.checkNotNull(r10);
        Cut<C> r11 = this.lowerBound.canonical(r10);
        Cut<C> r12 = this.upperBound.canonical(r10);
        if (r11 != this.lowerBound) goto L8;
        if (r12 != this.upperBound) goto L8;
        return this;
    L8:
        return create(r11, r12);
    }

    public boolean contains(C r10) {
        Preconditions.checkNotNull(r10);
        if (this.lowerBound.isLessThan(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.isLessThan(r10) == true) goto L7;
        return true;
    }

    public boolean containsAll(Iterable<? extends C> r10) {
        if (Iterables.isEmpty(r10) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof SortedSet) == false) goto L17;
        SortedSet r11 = cast(r10);
        Comparator r12 = r11.comparator();
        if (Ordering.natural().equals(r12) == true) goto L11;
        if (r12 != null) goto L17;
    L11:
        if (contains((Comparable) r11.first()) == false) goto L16;
        if (contains((Comparable) r11.last()) == false) goto L16;
        return true;
    L16:
        return false;
    L17:
        Iterator<? extends C> r13 = r10.iterator();
    L19:
        if (r13.hasNext() == false) goto L23;
        if (contains(r13.next()) == true) goto L19;
        return false;
    L23:
        return true;
    }

    public boolean encloses(Range<C> r10) {
        if (this.lowerBound.compareTo(r10.lowerBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.compareTo(r10.upperBound) < 0) goto L7;
        return true;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof Range) == false) goto L10;
        Range r11 = (Range) r10;
        if (this.lowerBound.equals(r11.lowerBound) == true) goto L7;
        return false;
    L7:
        if (this.upperBound.equals(r11.upperBound) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Range<C> gap(Range<C> r10) {
        if (this.lowerBound.compareTo(r10.lowerBound) >= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        Range<C> r12 = this;
    L9:
        if (r11 == false) goto L12;
        Range<C> this = r10;
    L12:
        return create(r12.upperBound, this.lowerBound);
    L8:
        r12 = r10;
        goto L9
    L5:
        r11 = false;
        goto L6
    }

    public boolean hasLowerBound() {
        if (this.lowerBound == Cut.belowAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUpperBound() {
        if (this.upperBound == Cut.aboveAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> r10) {
        int r11 = this.lowerBound.compareTo(r10.lowerBound);
        int r12 = this.upperBound.compareTo(r10.upperBound);
        if (r11 < 0) goto L6;
        if (r12 > 0) goto L6;
        return this;
    L6:
        if (r11 > 0) goto L9;
        if (r12 < 0) goto L9;
        return r10;
    L9:
        if (r11 < 0) goto L11;
        Cut<C> r13 = this.lowerBound;
    L12:
        if (r12 > 0) goto L14;
        Cut<C> r14 = this.upperBound;
    L16:
        return create(r13, r14);
    L14:
        r14 = r10.upperBound;
        goto L16
    L11:
        r13 = r10.lowerBound;
        goto L12
    }

    public boolean isConnected(Range<C> r10) {
        if (this.lowerBound.compareTo(r10.upperBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (r10.lowerBound.compareTo(this.upperBound) > 0) goto L7;
        return true;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    public Object readResolve() {
        if (equals(ALL) == true) goto L5;
        return this;
    L5:
        return all();
    }

    public Range<C> span(Range<C> r10) {
        int r11 = this.lowerBound.compareTo(r10.lowerBound);
        int r12 = this.upperBound.compareTo(r10.upperBound);
        if (r11 > 0) goto L6;
        if (r12 < 0) goto L6;
        return this;
    L6:
        if (r11 < 0) goto L9;
        if (r12 > 0) goto L9;
        return r10;
    L9:
        if (r11 > 0) goto L11;
        Cut<C> r13 = this.lowerBound;
    L12:
        if (r12 < 0) goto L14;
        Cut<C> r14 = this.upperBound;
    L16:
        return create(r13, r14);
    L14:
        r14 = r10.upperBound;
        goto L16
    L11:
        r13 = r10.lowerBound;
        goto L12
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }

    private static String toString(Cut<?> r10, Cut<?> r11) {
        StringBuilder r12 = new StringBuilder(16);
        r10.describeAsLowerBound(r12);
        r12.append("..");
        r11.describeAsUpperBound(r12);
        return r12.toString();
    }

    @Deprecated
    public boolean apply(C r10) {
        return contains(r10);
    }
}
