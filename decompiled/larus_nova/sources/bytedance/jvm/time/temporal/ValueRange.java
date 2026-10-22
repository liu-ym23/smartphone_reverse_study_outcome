package bytedance.jvm.time.temporal;

import androidx.collection.SieveCacheKt;
import bytedance.jvm.time.DateTimeException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    public int hashCode() {
        long r100 = this.minSmallest;
        long r101 = this.minLargest;
        long r102 = (r100 + (r101 << 16)) + (r101 >> 48);
        long r103 = this.maxSmallest;
        long r104 = (r102 + (r103 << 32)) + (r103 >> 32);
        long r105 = this.maxLargest;
        long r106 = (r104 + (r105 << 48)) + (r105 >> 16);
        return (int) (r106 ^ (r106 >>> 32));
    }

    public boolean isFixed() {
        if (this.minSmallest == this.minLargest) goto L5;
    L7:
        return false;
    L5:
        if (this.maxSmallest != this.maxLargest) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.minSmallest);
        if (this.minSmallest == this.minLargest) goto L5;
        r100.append('/');
        r100.append(this.minLargest);
    L5:
        r100.append(" - ");
        r100.append(this.maxSmallest);
        if (this.maxSmallest == this.maxLargest) goto L9;
        r100.append('/');
        r100.append(this.maxLargest);
    L9:
        return r100.toString();
    }

    public boolean isIntValue() {
        if (getMinimum() >= SieveCacheKt.NodeMetaAndPreviousMask) goto L5;
    L7:
        return false;
    L5:
        if (getMaximum() > SieveCacheKt.NodeLinkMask) goto L7;
        return true;
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

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException, InvalidObjectException {
        r100.defaultReadObject();
        long r101 = this.minSmallest;
        long r102 = this.minLargest;
        if (r101 > r102) goto L14;
        long r103 = this.maxSmallest;
        long r104 = this.maxLargest;
        if (r103 > r104) goto L12;
        if (r102 > r104) goto L10;
        return;
    L10:
        throw new InvalidObjectException("Minimum value must be less than maximum value");
    L12:
        throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
    L14:
        throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ValueRange) == false) goto L18;
        ValueRange r101 = (ValueRange) r100;
        if (this.minSmallest == r101.minSmallest) goto L10;
    L16:
        return false;
    L10:
        if (this.minLargest != r101.minLargest) goto L16;
        if (this.maxSmallest != r101.maxSmallest) goto L16;
        if (this.maxLargest != r101.maxLargest) goto L16;
        return true;
    L18:
        return false;
    }

    public boolean isValidIntValue(long r100) {
        if (isIntValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidValue(r100) == false) goto L7;
        return true;
    }

    public boolean isValidValue(long r100) {
        if (r100 >= getMinimum()) goto L5;
    L7:
        return false;
    L5:
        if (r100 > getMaximum()) goto L7;
        return true;
    }

    public static ValueRange of(long r110, long r111) {
        if (r110 > r111) goto L7;
        return new ValueRange(r110, r110, r111, r111);
    L7:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public final String a(j r100, long r101) {
        if (r100 == null) goto L7;
        return "Invalid value for " + r100 + " (valid values " + this + "): " + r101;
    L7:
        return "Invalid value (valid values " + this + "): " + r101;
    }

    public int checkValidIntValue(long r100, j r101) {
        if (isValidIntValue(r100) == false) goto L7;
        return (int) r100;
    L7:
        throw new DateTimeException(a(r101, r100));
    }

    public long checkValidValue(long r100, j r101) {
        if (isValidValue(r100) == false) goto L6;
        return r100;
    L6:
        throw new DateTimeException(a(r101, r100));
    }

    public static ValueRange of(long r100, long r110, long r111) {
        return of(r100, r100, r110, r111);
    }

    public ValueRange(long r100, long r101, long r102, long r103) {
        this.minSmallest = r100;
        this.minLargest = r101;
        this.maxSmallest = r102;
        this.maxLargest = r103;
    }

    public static ValueRange of(long r110, long r111, long r112, long r113) {
        if (r110 > r111) goto L15;
        if (r112 > r113) goto L13;
        if (r111 > r113) goto L11;
        return new ValueRange(r110, r111, r112, r113);
    L11:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    L13:
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    L15:
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }
}
