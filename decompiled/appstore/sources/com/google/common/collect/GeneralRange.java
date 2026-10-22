package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @NullableDecl
    private final T lowerEndpoint;

    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @NullableDecl
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> r10, boolean r11, @NullableDecl T r12, BoundType r13, boolean r14, @NullableDecl T r15, BoundType r16) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r10);
        this.hasLowerBound = r11;
        this.hasUpperBound = r14;
        this.lowerEndpoint = r12;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(r13);
        this.upperEndpoint = r15;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(r16);
        if (r11 == false) goto L5;
        r10.compare(r12, r12);
    L5:
        if (r14 == false) goto L7;
        r10.compare(r15, r15);
    L7:
        if (r11 == false) goto L23;
        if (r14 == false) goto L24;
        int r17 = r10.compare(r12, r15);
        boolean r18 = false;
        if (r17 > 0) goto L12;
        boolean r19 = true;
    L13:
        Preconditions.checkArgument(r19, "lowerEndpoint (%s) > upperEndpoint (%s)", r12, r15);
        if (r17 != 0) goto L25;
        BoundType r20 = BoundType.OPEN;
        if (r13 == r20) goto L18;
        boolean r21 = true;
    L19:
        if (r16 == r20) goto L21;
        r18 = true;
    L21:
        Preconditions.checkArgument(r21 | r18);
        return;
    L18:
        r21 = false;
        goto L19
    L25:
        return;
    L12:
        r19 = false;
        goto L13
    L24:
        return;
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> r10) {
        BoundType r11 = BoundType.OPEN;
        return new GeneralRange(r10, false, null, r11, false, null, r11);
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> r10, @NullableDecl T r11, BoundType r12) {
        return new GeneralRange(r10, true, r11, r12, false, null, BoundType.OPEN);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> r10) {
        Comparable r11 = null;
        if (r10.hasLowerBound() == false) goto L5;
        Comparable r12 = r10.lowerEndpoint();
    L7:
        if (r10.hasLowerBound() == false) goto L10;
        BoundType r13 = r10.lowerBoundType();
    L9:
        BoundType r14 = r13;
        if (r10.hasUpperBound() == false) goto L14;
        r11 = r10.upperEndpoint();
    L14:
        Comparable r15 = r11;
        if (r10.hasUpperBound() == false) goto L18;
        BoundType r16 = r10.upperBoundType();
    L20:
        return new GeneralRange(Ordering.natural(), r10.hasLowerBound(), r12, r14, r10.hasUpperBound(), r15, r16);
    L18:
        r16 = BoundType.OPEN;
        goto L20
    L10:
        r13 = BoundType.OPEN;
        goto L9
    L5:
        r12 = null;
        goto L7
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> r10, @NullableDecl T r11, BoundType r12, @NullableDecl T r13, BoundType r14) {
        return new GeneralRange(r10, true, r11, r12, true, r13, r14);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> r10, @NullableDecl T r11, BoundType r12) {
        return new GeneralRange(r10, false, null, BoundType.OPEN, true, r11, r12);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@NullableDecl T r10) {
        if (tooLow(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (tooHigh(r10) == true) goto L7;
        return true;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof GeneralRange) == false) goto L20;
        GeneralRange r11 = (GeneralRange) r10;
        if (this.comparator.equals(r11.comparator) == true) goto L7;
        return false;
    L7:
        if (this.hasLowerBound == r11.hasLowerBound) goto L9;
        return false;
    L9:
        if (this.hasUpperBound == r11.hasUpperBound) goto L11;
        return false;
    L11:
        if (getLowerBoundType().equals(r11.getLowerBoundType()) == true) goto L13;
        return false;
    L13:
        if (getUpperBoundType().equals(r11.getUpperBoundType()) == true) goto L15;
        return false;
    L15:
        if (Objects.equal(getLowerEndpoint(), r11.getLowerEndpoint()) == true) goto L17;
        return false;
    L17:
        if (Objects.equal(getUpperEndpoint(), r11.getUpperEndpoint()) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    public GeneralRange<T> intersect(GeneralRange<T> r12) {
        Preconditions.checkNotNull(r12);
        Preconditions.checkArgument(this.comparator.equals(r12.comparator));
        boolean r10 = this.hasLowerBound;
        T r11 = getLowerEndpoint();
        BoundType r13 = getLowerBoundType();
        if (hasLowerBound() == true) goto L7;
        r10 = r12.hasLowerBound;
        r11 = r12.getLowerEndpoint();
        r13 = r12.getLowerBoundType();
    L5:
        boolean r14 = r10;
        boolean r15 = this.hasUpperBound;
        T r16 = getUpperEndpoint();
        BoundType r17 = getUpperBoundType();
        if (hasUpperBound() == true) goto L19;
        r15 = r12.hasUpperBound;
        r16 = r12.getUpperEndpoint();
        r17 = r12.getUpperBoundType();
    L17:
        boolean r18 = r15;
        T r19 = r16;
        if (r14 == false) goto L35;
        if (r18 == false) goto L35;
        int r110 = this.comparator.compare(r11, r19);
        if (r110 > 0) goto L34;
        if (r110 != 0) goto L35;
        BoundType r111 = BoundType.OPEN;
        if (r13 != r111) goto L35;
        if (r17 != r111) goto L35;
    L34:
        BoundType r112 = BoundType.OPEN;
        BoundType r20 = r112;
        BoundType r113 = BoundType.CLOSED;
        T r21 = r19;
    L37:
        return new GeneralRange(this.comparator, r14, r21, r20, r18, r19, r113);
    L35:
        r21 = r11;
        r20 = r13;
        r113 = r17;
        goto L37
    L19:
        if (r12.hasUpperBound() == false) goto L17;
        int r22 = this.comparator.compare(getUpperEndpoint(), r12.getUpperEndpoint());
        if (r22 > 0) goto L25;
        if (r22 != 0) goto L17;
        if (r12.getUpperBoundType() != BoundType.OPEN) goto L17;
    L25:
        r16 = r12.getUpperEndpoint();
        r17 = r12.getUpperBoundType();
        goto L17
    L7:
        if (r12.hasLowerBound() == false) goto L5;
        int r23 = this.comparator.compare(getLowerEndpoint(), r12.getLowerEndpoint());
        if (r23 < 0) goto L13;
        if (r23 != 0) goto L5;
        if (r12.getLowerBoundType() != BoundType.OPEN) goto L5;
    L13:
        r11 = r12.getLowerEndpoint();
        r13 = r12.getLowerBoundType();
        goto L5
    }

    public boolean isEmpty() {
        if (hasUpperBound() == false) goto L7;
        if (tooLow(getUpperEndpoint()) == false) goto L7;
    L10:
        return true;
    L7:
        if (hasLowerBound() == true) goto L9;
    L11:
        return false;
    L9:
        if (tooHigh(getLowerEndpoint()) == false) goto L11;
        goto L10
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> r10 = this.reverse;
        if (r10 != null) goto L6;
        GeneralRange<T> r11 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        r11.reverse = this;
        this.reverse = r11;
        return r11;
    L6:
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.comparator);
        r10.append(":");
        BoundType r11 = this.lowerBoundType;
        BoundType r12 = BoundType.CLOSED;
        if (r11 != r12) goto L5;
        char r13 = '[';
    L6:
        r10.append(r13);
        if (this.hasLowerBound == false) goto L9;
        Object r14 = this.lowerEndpoint;
    L10:
        r10.append(r14);
        r10.append(',');
        if (this.hasUpperBound == false) goto L13;
        Object r15 = this.upperEndpoint;
    L14:
        r10.append(r15);
        if (this.upperBoundType != r12) goto L17;
        char r16 = ']';
    L18:
        r10.append(r16);
        return r10.toString();
    L17:
        r16 = ')';
        goto L18
    L13:
        r15 = "∞";
        goto L14
    L9:
        r14 = "-∞";
        goto L10
    L5:
        r13 = '(';
        goto L6
    }

    public boolean tooHigh(@NullableDecl T r10) {
        boolean r11 = false;
        if (hasUpperBound() == true) goto L5;
        return false;
    L5:
        int r12 = this.comparator.compare(r10, getUpperEndpoint());
        if (r12 <= 0) goto L8;
        boolean r13 = true;
    L9:
        if (r12 != 0) goto L11;
        boolean r14 = true;
    L13:
        if (getUpperBoundType() != BoundType.OPEN) goto L16;
        r11 = true;
    L16:
        return (r14 & r11) | r13;
    L11:
        r14 = false;
        goto L13
    L8:
        r13 = false;
        goto L9
    }

    public boolean tooLow(@NullableDecl T r10) {
        boolean r11 = false;
        if (hasLowerBound() == true) goto L5;
        return false;
    L5:
        int r12 = this.comparator.compare(r10, getLowerEndpoint());
        if (r12 >= 0) goto L8;
        boolean r13 = true;
    L9:
        if (r12 != 0) goto L11;
        boolean r14 = true;
    L13:
        if (getLowerBoundType() != BoundType.OPEN) goto L16;
        r11 = true;
    L16:
        return (r14 & r11) | r13;
    L11:
        r14 = false;
        goto L13
    L8:
        r13 = false;
        goto L9
    }
}
