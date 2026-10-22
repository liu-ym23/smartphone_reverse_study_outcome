package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = null;
    public static final UnsignedInteger ONE = null;
    public static final UnsignedInteger ZERO = null;
    private final int value;

    static {
        ZERO = fromIntBits(0);
        ONE = fromIntBits(1);
        MAX_VALUE = fromIntBits(-1);
    }

    private UnsignedInteger(int r10) {
        this.value = r10;
    }

    public static UnsignedInteger fromIntBits(int r10) {
        return new UnsignedInteger(r10);
    }

    public static UnsignedInteger valueOf(long r10) {
        if ((4294967295L & r10) != r10) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "value (%s) is outside the range for an unsigned integer value", r10);
        return fromIntBits((int) r10);
    L5:
        r11 = false;
        goto L6
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedInteger r10) {
        return compareTo2(r10);
    }

    public UnsignedInteger dividedBy(UnsignedInteger r10) {
        return fromIntBits(UnsignedInts.divide(this.value, ((UnsignedInteger) Preconditions.checkNotNull(r10)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof UnsignedInteger) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedInteger) r10).value) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger r10) {
        return fromIntBits(this.value - ((UnsignedInteger) Preconditions.checkNotNull(r10)).value);
    }

    public UnsignedInteger mod(UnsignedInteger r10) {
        return fromIntBits(UnsignedInts.remainder(this.value, ((UnsignedInteger) Preconditions.checkNotNull(r10)).value));
    }

    public UnsignedInteger plus(UnsignedInteger r10) {
        return fromIntBits(this.value + ((UnsignedInteger) Preconditions.checkNotNull(r10)).value);
    }

    @GwtIncompatible
    public UnsignedInteger times(UnsignedInteger r10) {
        return fromIntBits(this.value * ((UnsignedInteger) Preconditions.checkNotNull(r10)).value);
    }

    public String toString() {
        return toString(10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedInteger r10) {
        Preconditions.checkNotNull(r10);
        return UnsignedInts.compare(this.value, r10.value);
    }

    public String toString(int r10) {
        return UnsignedInts.toString(this.value, r10);
    }

    public static UnsignedInteger valueOf(BigInteger r10) {
        Preconditions.checkNotNull(r10);
        if (r10.signum() >= 0) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Preconditions.checkArgument(r11, "value (%s) is outside the range for an unsigned integer value", r10);
        return fromIntBits(r10.intValue());
    L5:
        if (r10.bitLength() > 32) goto L7;
        r11 = true;
        goto L8
    }

    public static UnsignedInteger valueOf(String r10) {
        return valueOf(r10, 10);
    }

    public static UnsignedInteger valueOf(String r10, int r11) {
        return fromIntBits(UnsignedInts.parseUnsignedInt(r10, r11));
    }
}
