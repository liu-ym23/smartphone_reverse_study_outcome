package com.google.common.collect;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final C endpoint;

    /* JADX INFO: renamed from: com.google.common.collect.Cut$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = null;

        static {
            int[] r10 = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = r10;
            r10[BoundType.CLOSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new AboveAll();
        }

        private AboveAll() {
            super(null);
        }

        public static /* synthetic */ AboveAll access$100() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r10) {
            if (r10 != this) goto L4;
            return 0;
        L4:
            return 1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r10) {
            r10.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r10) {
            return r10.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r10) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r10) {
            throw new AssertionError();
        }

        public String toString() {
            return "+∞";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r10, DiscreteDomain<Comparable<?>> r11) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r10, DiscreteDomain<Comparable<?>> r11) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((Cut) r10);
        }
    }

    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public AboveValue(C r10) {
            super((Comparable) Preconditions.checkNotNull(r10));
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> canonical(DiscreteDomain<C> r10) {
            Comparable r11 = leastValueAbove(r10);
            if (r11 == null) goto L6;
            return Cut.belowValue(r11);
        L6:
            return Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return super.compareTo((Cut) r10);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r10) {
            r10.append('(');
            r10.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r10) {
            r10.append(this.endpoint);
            r10.append(']');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> r10) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r10) {
            if (Range.compareOrThrow(this.endpoint, r10) >= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> r10) {
            return (C) r10.next(this.endpoint);
        }

        public String toString() {
            return LibrarianImpl.Constants.SEPARATOR + this.endpoint + "\\";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r10, DiscreteDomain<C> r11) {
            int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r10.ordinal()];
            if (r12 != 1) goto L5;
            Comparable r13 = r11.next(this.endpoint);
            if (r13 != null) goto L13;
            return Cut.belowAll();
        L13:
            return Cut.belowValue(r13);
        L5:
            if (r12 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r10, DiscreteDomain<C> r11) {
            int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r10.ordinal()];
            if (r12 != 1) goto L5;
            return this;
        L5:
            if (r12 != 2) goto L12;
            Comparable r13 = r11.next(this.endpoint);
            if (r13 != null) goto L10;
            return Cut.aboveAll();
        L10:
            return Cut.belowValue(r13);
        L12:
            throw new AssertionError();
        }
    }

    public static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new BelowAll();
        }

        private BelowAll() {
            super(null);
        }

        public static /* synthetic */ BelowAll access$000() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> r10) {
            return Cut.belowValue(r10.minValue());
        L7:
            return this;
        }

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r10) {
            if (r10 != this) goto L4;
            return 0;
        L4:
            return -1;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r10) {
            r10.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r10) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r10) {
            return r10.minValue();
        }

        public String toString() {
            return "-∞";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r10, DiscreteDomain<Comparable<?>> r11) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r10, DiscreteDomain<Comparable<?>> r11) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return compareTo((Cut) r10);
        }
    }

    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public BelowValue(C r10) {
            super((Comparable) Preconditions.checkNotNull(r10));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return super.compareTo((Cut) r10);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r10) {
            r10.append('[');
            r10.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r10) {
            r10.append(this.endpoint);
            r10.append(')');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> r10) {
            return (C) r10.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r10) {
            if (Range.compareOrThrow(this.endpoint, r10) > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> r10) {
            return this.endpoint;
        }

        public String toString() {
            return "\\" + this.endpoint + LibrarianImpl.Constants.SEPARATOR;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r10, DiscreteDomain<C> r11) {
            int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r10.ordinal()];
            if (r12 != 1) goto L5;
            return this;
        L5:
            if (r12 != 2) goto L12;
            Comparable r13 = r11.previous(this.endpoint);
            if (r13 != null) goto L10;
            return Cut.belowAll();
        L10:
            return new AboveValue(r13);
        L12:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r10, DiscreteDomain<C> r11) {
            int r12 = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[r10.ordinal()];
            if (r12 != 1) goto L5;
            Comparable r13 = r11.previous(this.endpoint);
            if (r13 != null) goto L13;
            return Cut.aboveAll();
        L13:
            return new AboveValue(r13);
        L5:
            if (r12 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }
    }

    public Cut(@NullableDecl C r10) {
        this.endpoint = r10;
    }

    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.access$100();
    }

    public static <C extends Comparable> Cut<C> aboveValue(C r10) {
        return new AboveValue(r10);
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.access$000();
    }

    public static <C extends Comparable> Cut<C> belowValue(C r10) {
        return new BelowValue(r10);
    }

    public Cut<C> canonical(DiscreteDomain<C> r10) {
        return this;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((Cut) r10);
    }

    public abstract void describeAsLowerBound(StringBuilder r10);

    public abstract void describeAsUpperBound(StringBuilder r10);

    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Cut) == true) goto L10;
        return false;
    L10:
        if (compareTo((Cut) r10) != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public abstract C greatestValueBelow(DiscreteDomain<C> r10);

    public abstract int hashCode();

    public abstract boolean isLessThan(C r10);

    public abstract C leastValueAbove(DiscreteDomain<C> r10);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut<C> withLowerBoundType(BoundType r10, DiscreteDomain<C> r11);

    public abstract Cut<C> withUpperBoundType(BoundType r10, DiscreteDomain<C> r11);

    public int compareTo(Cut<C> r10) {
        if (r10 != belowAll()) goto L7;
        return 1;
    L7:
        if (r10 != aboveAll()) goto L10;
        return -1;
    L10:
        int r11 = Range.compareOrThrow(this.endpoint, r10.endpoint);
        if (r11 == 0) goto L14;
        return r11;
    L14:
        return Booleans.compare(this instanceof AboveValue, r10 instanceof AboveValue);
    }
}
