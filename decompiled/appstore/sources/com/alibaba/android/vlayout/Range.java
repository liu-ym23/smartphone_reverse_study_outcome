package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import java.lang.Comparable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Range<T extends Comparable<? super T>> {
    private final T mLower;
    private final T mUpper;

    public Range(@NonNull T r10, @NonNull T r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L11;
        this.mLower = r10;
        this.mUpper = r11;
        if (r10.compareTo(r11) > 0) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("lower must be less than or equal to upper");
    L11:
        throw new IllegalArgumentException("upper must not be null");
    L13:
        throw new IllegalArgumentException("lower must not be null");
    }

    public static <T extends Comparable<? super T>> Range<T> create(T r10, T r11) {
        return new Range(r10, r11);
    }

    public T clamp(T r10) {
        if (r10 == null) goto L13;
        if (r10.compareTo(this.mLower) >= 0) goto L8;
        return this.mLower;
    L8:
        if (r10.compareTo(this.mUpper) > 0) goto L10;
        return r10;
    L10:
        return this.mUpper;
    L13:
        throw new IllegalArgumentException("value must not be null");
    }

    public boolean contains(@NonNull T r10) {
        if (r10 == null) goto L16;
        if (r10.compareTo(this.mLower) < 0) goto L6;
        boolean r11 = true;
    L8:
        if (r10.compareTo(this.mUpper) > 0) goto L10;
        boolean r12 = true;
    L11:
        if (r11 == false) goto L17;
        if (r12 == true) goto L14;
        return false;
    L14:
        return true;
    L17:
        return false;
    L10:
        r12 = false;
        goto L11
    L6:
        r11 = false;
        goto L8
    L16:
        throw new IllegalArgumentException("value must not be null");
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this != r10) goto L9;
        return true;
    L9:
        if ((r10 instanceof Range) == false) goto L16;
        Range r11 = (Range) r10;
        if (this.mLower.equals(r11.mLower) == true) goto L13;
        return false;
    L13:
        if (this.mUpper.equals(r11.mUpper) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public Range<T> extend(Range<T> r10) {
        if (r10 == null) goto L19;
        int r11 = r10.mLower.compareTo(this.mLower);
        int r12 = r10.mUpper.compareTo(this.mUpper);
        if (r11 > 0) goto L7;
        if (r12 < 0) goto L7;
        return r10;
    L7:
        if (r11 < 0) goto L10;
        if (r12 > 0) goto L10;
        return this;
    L10:
        if (r11 < 0) goto L12;
        T r13 = this.mLower;
    L13:
        if (r12 > 0) goto L15;
        T r14 = this.mUpper;
    L17:
        return create(r13, r14);
    L15:
        r14 = r10.mUpper;
        goto L17
    L12:
        r13 = r10.mLower;
        goto L13
    L19:
        throw new IllegalArgumentException("range must not be null");
    }

    public T getLower() {
        return this.mLower;
    }

    public T getUpper() {
        return this.mUpper;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mLower, this.mUpper});
    }

    public Range<T> intersect(Range<T> r10) {
        if (r10 == null) goto L19;
        int r11 = r10.mLower.compareTo(this.mLower);
        int r12 = r10.mUpper.compareTo(this.mUpper);
        if (r11 > 0) goto L7;
        if (r12 < 0) goto L7;
        return this;
    L7:
        if (r11 < 0) goto L10;
        if (r12 > 0) goto L10;
        return r10;
    L10:
        if (r11 > 0) goto L12;
        T r13 = this.mLower;
    L13:
        if (r12 < 0) goto L15;
        T r14 = this.mUpper;
    L17:
        return create(r13, r14);
    L15:
        r14 = r10.mUpper;
        goto L17
    L12:
        r13 = r10.mLower;
        goto L13
    L19:
        throw new IllegalArgumentException("range must not be null");
    }

    public String toString() {
        return String.format("[%s, %s]", new Object[]{this.mLower, this.mUpper});
    }

    public boolean contains(@NonNull Range<T> r10) {
        if (r10 == null) goto L16;
        if (r10.mLower.compareTo(this.mLower) < 0) goto L6;
        boolean r11 = true;
    L8:
        if (r10.mUpper.compareTo(this.mUpper) > 0) goto L10;
        boolean r12 = true;
    L11:
        if (r11 == false) goto L17;
        if (r12 == true) goto L14;
        return false;
    L14:
        return true;
    L17:
        return false;
    L10:
        r12 = false;
        goto L11
    L6:
        r11 = false;
        goto L8
    L16:
        throw new IllegalArgumentException("value must not be null");
    }

    public Range<T> extend(T r10, T r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        int r12 = r10.compareTo(this.mLower);
        int r13 = r11.compareTo(this.mUpper);
        if (r12 < 0) goto L8;
        if (r13 > 0) goto L8;
        return this;
    L8:
        if (r12 < 0) goto L10;
        r10 = this.mLower;
    L10:
        if (r13 > 0) goto L13;
        r11 = this.mUpper;
    L13:
        return create(r10, r11);
    L15:
        throw new IllegalArgumentException("upper must not be null");
    L17:
        throw new IllegalArgumentException("lower must not be null");
    }

    public Range<T> intersect(T r10, T r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        int r12 = r10.compareTo(this.mLower);
        int r13 = r11.compareTo(this.mUpper);
        if (r12 > 0) goto L8;
        if (r13 < 0) goto L8;
        return this;
    L8:
        if (r12 > 0) goto L10;
        r10 = this.mLower;
    L10:
        if (r13 < 0) goto L13;
        r11 = this.mUpper;
    L13:
        return create(r10, r11);
    L15:
        throw new IllegalArgumentException("upper must not be null");
    L17:
        throw new IllegalArgumentException("lower must not be null");
    }

    public Range<T> extend(T r10) {
        if (r10 == null) goto L6;
        return extend(r10, r10);
    L6:
        throw new IllegalArgumentException("value must not be null");
    }
}
