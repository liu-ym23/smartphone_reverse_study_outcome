package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f4830a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4831b;

    public y(int i8, BigInteger bigInteger) {
        if (i8 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        this.f4830a = bigInteger;
        this.f4831b = i8;
    }

    public final y a(y yVar) {
        int i8 = yVar.f4831b;
        int i9 = this.f4831b;
        if (i9 == i8) {
            return new y(i9, this.f4830a.add(yVar.f4830a));
        }
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public final int b(BigInteger bigInteger) {
        return this.f4830a.compareTo(bigInteger.shiftLeft(this.f4831b));
    }

    public final BigInteger c() {
        BigInteger bigInteger = a.f4758b;
        y yVar = new y(1, bigInteger);
        int i8 = this.f4831b;
        if (i8 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        if (i8 != 1) {
            yVar = new y(i8, bigInteger.shiftLeft(i8 - 1));
        }
        y yVarA = a(yVar);
        return yVarA.f4830a.shiftRight(yVarA.f4831b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f4830a.equals(yVar.f4830a) && this.f4831b == yVar.f4831b;
    }

    public final int hashCode() {
        return this.f4831b ^ this.f4830a.hashCode();
    }

    public final String toString() {
        BigInteger bigInteger = this.f4830a;
        int i8 = this.f4831b;
        if (i8 == 0) {
            return bigInteger.toString();
        }
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i8);
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(i8));
        if (bigInteger.signum() == -1) {
            bigIntegerSubtract = a.f4758b.shiftLeft(i8).subtract(bigIntegerSubtract);
        }
        if (bigIntegerShiftRight.signum() == -1 && !bigIntegerSubtract.equals(a.f4757a)) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(a.f4758b);
        }
        String string = bigIntegerShiftRight.toString();
        char[] cArr = new char[i8];
        String string2 = bigIntegerSubtract.toString(2);
        int length = string2.length();
        int i9 = i8 - length;
        for (int i10 = 0; i10 < i9; i10++) {
            cArr[i10] = '0';
        }
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i9 + i11] = string2.charAt(i11);
        }
        return m0.f.d(string, ".", new String(cArr));
    }
}
