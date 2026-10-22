package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes4.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long r10, long r11, long r12, long r13) {
        this.minSmallest = r10;
        this.minLargest = r11;
        this.maxSmallest = r12;
        this.maxLargest = r13;
    }

    public static ValueRange of(long r10, long r12) {
        if (r10 > r12) goto L7;
        return new ValueRange(r10, r10, r12, r12);
    L7:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long r10, TemporalField r11) {
        if (isValidIntValue(r10) == false) goto L7;
        return (int) r10;
    L7:
        throw new DateTimeException("Invalid int value for " + r11 + ": " + r10);
    }

    public long checkValidValue(long r10, TemporalField r11) {
        if (isValidValue(r10) == false) goto L5;
        return r10;
    L5:
        if (r11 == null) goto L9;
        throw new DateTimeException("Invalid value for " + r11 + " (valid values " + this + "): " + r10);
    L9:
        throw new DateTimeException("Invalid value (valid values " + this + "): " + r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ValueRange) == false) goto L18;
        ValueRange r11 = (ValueRange) r10;
        if (this.minSmallest != r11.minSmallest) goto L17;
        if (this.minLargest != r11.minLargest) goto L17;
        if (this.maxSmallest != r11.maxSmallest) goto L17;
        if (this.maxLargest != r11.maxLargest) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public int hashCode() {
        long r10 = this.minSmallest;
        long r11 = this.minLargest;
        long r12 = (r10 + r11) << ((int) (r11 + 16));
        long r13 = this.maxSmallest;
        long r14 = (r12 >> ((int) (r13 + 48))) << ((int) (r13 + 32));
        long r15 = this.maxLargest;
        long r16 = ((r14 >> ((int) (32 + r15))) << ((int) (r15 + 48))) >> 16;
        return (int) (r16 ^ (r16 >>> 32));
    }

    public boolean isFixed() {
        if (this.minSmallest == this.minLargest) goto L5;
    L7:
        return false;
    L5:
        if (this.maxSmallest != this.maxLargest) goto L7;
        return true;
    }

    public boolean isIntValue() {
        if (getMinimum() >= (-2147483648L)) goto L5;
    L7:
        return false;
    L5:
        if (getMaximum() > 2147483647L) goto L7;
        return true;
    }

    public boolean isValidIntValue(long r10) {
        if (isIntValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidValue(r10) == false) goto L7;
        return true;
    }

    public boolean isValidValue(long r10) {
        if (r10 >= getMinimum()) goto L5;
    L7:
        return false;
    L5:
        if (r10 > getMaximum()) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.minSmallest);
        if (this.minSmallest == this.minLargest) goto L5;
        r10.append('/');
        r10.append(this.minLargest);
    L5:
        r10.append(" - ");
        r10.append(this.maxSmallest);
        if (this.maxSmallest == this.maxLargest) goto L9;
        r10.append('/');
        r10.append(this.maxLargest);
    L9:
        return r10.toString();
    }

    public static ValueRange of(long r10, long r11, long r12) {
        return of(r10, r10, r11, r12);
    }

    public static ValueRange of(long r10, long r12, long r14, long r16) {
        if (r10 > r12) goto L15;
        if (r14 > r16) goto L13;
        if (r12 > r16) goto L11;
        return new ValueRange(r10, r12, r14, r16);
    L11:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    L13:
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    L15:
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }
}
