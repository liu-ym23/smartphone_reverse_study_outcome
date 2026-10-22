package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = null;
    public static final UnsignedLong ONE = null;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = null;
    private final long value;

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    private UnsignedLong(long r10) {
        this.value = r10;
    }

    public static UnsignedLong fromLongBits(long r10) {
        return new UnsignedLong(r10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long r10) {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "value (%s) is outside the range for an unsigned long value", r10);
        return fromLongBits(r10);
    L5:
        r11 = false;
        goto L6
    }

    public BigInteger bigIntegerValue() {
        BigInteger r10 = BigInteger.valueOf(this.value & UNSIGNED_MASK);
        if (this.value < 0) goto L5;
        return r10;
    L5:
        return r10.setBit(63);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedLong r10) {
        return compareTo2(r10);
    }

    public UnsignedLong dividedBy(UnsignedLong r10) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(r10)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long r10 = this.value;
        double r11 = UNSIGNED_MASK & r10;
        if (r10 < 0) goto L5;
        return r11;
    L5:
        return r11 + 9.223372036854776E18d;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof UnsignedLong) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedLong) r10).value) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long r10 = this.value;
        float r11 = UNSIGNED_MASK & r10;
        if (r10 < 0) goto L5;
        return r11;
    L5:
        return r11 + 9.223372E18f;
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong r10) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(r10)).value);
    }

    public UnsignedLong mod(UnsignedLong r10) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(r10)).value));
    }

    public UnsignedLong plus(UnsignedLong r10) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(r10)).value);
    }

    public UnsignedLong times(UnsignedLong r10) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(r10)).value);
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedLong r10) {
        Preconditions.checkNotNull(r10);
        return UnsignedLongs.compare(this.value, r10.value);
    }

    public String toString(int r10) {
        return UnsignedLongs.toString(this.value, r10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger r10) {
        Preconditions.checkNotNull(r10);
        if (r10.signum() >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Preconditions.checkArgument(r11, "value (%s) is outside the range for an unsigned long value", r10);
        return fromLongBits(r10.longValue());
    L5:
        if (r10.bitLength() > 64) goto L7;
        r11 = true;
        goto L8
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String r10) {
        return valueOf(r10, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String r10, int r11) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(r10, r11));
    }
}
