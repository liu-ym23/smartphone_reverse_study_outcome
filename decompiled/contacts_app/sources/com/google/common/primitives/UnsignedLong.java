package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = null;
    public static final UnsignedLong ONE = null;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = null;
    private final long value;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedLong r1) {
        return compareTo2(r1);
    }

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    private UnsignedLong(long r1) {
        this.value = r1;
    }

    public static UnsignedLong fromLongBits(long r1) {
        return new UnsignedLong(r1);
    }

    public static UnsignedLong valueOf(long r4) {
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "value (%s) is outside the range for an unsigned long value", new Object[]{Long.valueOf(r4)});
        return fromLongBits(r4);
    L5:
        r0 = false;
        goto L6
    }

    public static UnsignedLong valueOf(BigInteger r4) {
        Preconditions.checkNotNull(r4);
        if (r4.signum() >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "value (%s) is outside the range for an unsigned long value", new Object[]{r4});
        return fromLongBits(r4.longValue());
    L5:
        if (r4.bitLength() > 64) goto L7;
        r0 = true;
        goto L8
    }

    public static UnsignedLong valueOf(String r1) {
        return valueOf(r1, 10);
    }

    public static UnsignedLong valueOf(String r0, int r1) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(r0, r1));
    }

    public UnsignedLong plus(UnsignedLong r3) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(r3)).value);
    }

    public UnsignedLong minus(UnsignedLong r3) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(r3)).value);
    }

    @CheckReturnValue
    public UnsignedLong times(UnsignedLong r3) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(r3)).value);
    }

    @CheckReturnValue
    public UnsignedLong dividedBy(UnsignedLong r3) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(r3)).value));
    }

    @CheckReturnValue
    public UnsignedLong mod(UnsignedLong r3) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(r3)).value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long r0 = this.value;
        float r4 = Long.MAX_VALUE & r0;
        if (r0 < 0) goto L5;
        return r4;
    L5:
        return r4 + 9.223372E18f;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long r0 = this.value;
        double r2 = Long.MAX_VALUE & r0;
        if (r0 < 0) goto L5;
        return r2;
    L5:
        return r2 + 9.223372036854776E18d;
    }

    public BigInteger bigIntegerValue() {
        BigInteger r0 = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) goto L5;
        return r0;
    L5:
        return r0.setBit(63);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedLong r3) {
        Preconditions.checkNotNull(r3);
        return UnsignedLongs.compare(this.value, r3.value);
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public boolean equals(@Nullable Object r5) {
        if ((r5 instanceof UnsignedLong) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedLong) r5).value) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int r3) {
        return UnsignedLongs.toString(this.value, r3);
    }
}
