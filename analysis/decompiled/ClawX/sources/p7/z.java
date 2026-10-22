package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f4832a;

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f4833b;

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.p[] f4834c;
    public static final byte[][] d;

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.p[] f4835e;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[][] f4836f;

    static {
        BigInteger bigInteger = a.f4758b;
        BigInteger bigIntegerNegate = bigInteger.negate();
        f4832a = bigIntegerNegate;
        f4833b = a.f4759c.negate();
        BigInteger bigInteger2 = a.d;
        BigInteger bigIntegerNegate2 = bigInteger2.negate();
        BigInteger bigInteger3 = a.f4757a;
        int i8 = 17;
        f4834c = new androidx.emoji2.text.p[]{null, new androidx.emoji2.text.p(bigInteger, i8, bigInteger3), null, new androidx.emoji2.text.p(bigIntegerNegate2, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigInteger, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigInteger), null, new androidx.emoji2.text.p(bigInteger, i8, bigInteger), null, new androidx.emoji2.text.p(bigInteger2, i8, bigInteger), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigInteger3)};
        d = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        f4835e = new androidx.emoji2.text.p[]{null, new androidx.emoji2.text.p(bigInteger, i8, bigInteger3), null, new androidx.emoji2.text.p(bigIntegerNegate2, i8, bigInteger), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigInteger), null, new androidx.emoji2.text.p(bigInteger, i8, bigInteger), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigInteger, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigInteger2, i8, bigIntegerNegate), null, new androidx.emoji2.text.p(bigIntegerNegate, i8, bigInteger3)};
        f4836f = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static y a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b9, int i8) {
        int i9 = (i8 + 5) / 2;
        BigInteger bigIntegerMultiply = bigInteger2.multiply(bigInteger.shiftRight(((i8 - (i9 + 10)) - 2) + b9));
        BigInteger bigIntegerAdd = bigIntegerMultiply.add(bigInteger3.multiply(bigIntegerMultiply.shiftRight(i8)));
        BigInteger bigIntegerShiftRight = bigIntegerAdd.shiftRight(i9);
        if (bigIntegerAdd.testBit(i9 - 1)) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(a.f4758b);
        }
        return new y(10, bigIntegerShiftRight);
    }

    public static BigInteger[] b(boolean z, int i8, byte b9) {
        BigInteger bigInteger;
        BigInteger bigIntegerSubtract;
        if (b9 != 1 && b9 != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        if (z) {
            bigInteger = a.f4759c;
            bigIntegerSubtract = BigInteger.valueOf(b9);
        } else {
            bigInteger = a.f4757a;
            bigIntegerSubtract = a.f4758b;
        }
        int i9 = 1;
        while (i9 < i8) {
            i9++;
            BigInteger bigInteger2 = bigIntegerSubtract;
            bigIntegerSubtract = (b9 < 0 ? bigIntegerSubtract.negate() : bigIntegerSubtract).subtract(bigInteger.shiftLeft(1));
            bigInteger = bigInteger2;
        }
        return new BigInteger[]{bigInteger, bigIntegerSubtract};
    }

    public static BigInteger[] c(c cVar) {
        int i8;
        if (!cVar.u()) {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }
        int iL = cVar.l();
        int iIntValue = cVar.f4798b.t().intValue();
        BigInteger bigInteger = cVar.f4800e;
        byte b9 = (byte) (iIntValue == 0 ? -1 : 1);
        if (bigInteger != null) {
            if (bigInteger.equals(a.f4759c)) {
                i8 = 1;
            } else if (bigInteger.equals(a.f4760e)) {
                i8 = 2;
            }
            BigInteger[] bigIntegerArrB = b(false, (iL + 3) - iIntValue, b9);
            if (b9 == 1) {
                bigIntegerArrB[0] = bigIntegerArrB[0].negate();
                bigIntegerArrB[1] = bigIntegerArrB[1].negate();
            }
            BigInteger bigInteger2 = a.f4758b;
            return new BigInteger[]{bigInteger2.add(bigIntegerArrB[1]).shiftRight(i8), bigInteger2.add(bigIntegerArrB[0]).shiftRight(i8).negate()};
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }
}
