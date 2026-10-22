package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.crypto.hpke.HPKE;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public class RadixConverter {
    private static final int DEFAULT_POWERS_TO_CACHE = 10;
    private static final double LOG_LONG_MAX_VALUE = Math.log(9.223372036854776E18d);
    private final int digitsGroupLength;
    private final BigInteger[] digitsGroupSpacePowers;
    private final BigInteger digitsGroupSpaceSize;
    private final int radix;

    public RadixConverter(int i8) {
        this(i8, 10);
    }

    private long fromEncoding(int i8, int i9, short[] sArr) {
        long j4 = 0;
        while (i8 < i9) {
            j4 = (j4 * this.radix) + (sArr[i8] & HPKE.aead_EXPORT_ONLY);
            i8++;
        }
        return j4;
    }

    private BigInteger[] precomputeDigitsGroupPowers(int i8, BigInteger bigInteger) {
        BigInteger[] bigIntegerArr = new BigInteger[i8];
        BigInteger bigIntegerMultiply = bigInteger;
        for (int i9 = 0; i9 < i8; i9++) {
            bigIntegerArr[i9] = bigIntegerMultiply;
            bigIntegerMultiply = bigIntegerMultiply.multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    private int toEncoding(long j4, int i8, short[] sArr) {
        int i9;
        for (int i10 = 0; i10 < this.digitsGroupLength && i8 >= 0; i10++) {
            if (j4 == 0) {
                i9 = i8 - 1;
                sArr[i8] = 0;
            } else {
                i9 = i8 - 1;
                int i11 = this.radix;
                sArr[i8] = (short) (j4 % i11);
                j4 /= i11;
            }
            i8 = i9;
        }
        if (j4 == 0) {
            return i8;
        }
        throw new IllegalStateException("Failed to convert decimal number");
    }

    public int getDigitsGroupLength() {
        return this.digitsGroupLength;
    }

    public int getRadix() {
        return this.radix;
    }

    public RadixConverter(int i8, int i9) {
        this.radix = i8;
        int iFloor = (int) Math.floor(LOG_LONG_MAX_VALUE / Math.log(i8));
        this.digitsGroupLength = iFloor;
        BigInteger bigIntegerPow = BigInteger.valueOf(i8).pow(iFloor);
        this.digitsGroupSpaceSize = bigIntegerPow;
        this.digitsGroupSpacePowers = precomputeDigitsGroupPowers(i9, bigIntegerPow);
    }

    public BigInteger fromEncoding(short[] sArr) {
        BigInteger bigIntegerMultiply = BigIntegers.ONE;
        int length = sArr.length;
        int i8 = length - this.digitsGroupLength;
        BigInteger bigIntegerAdd = null;
        int i9 = 0;
        while (true) {
            int i10 = this.digitsGroupLength;
            if (i8 <= (-i10)) {
                return bigIntegerAdd;
            }
            if (i8 < 0) {
                i10 += i8;
                i8 = 0;
            }
            BigInteger bigIntegerValueOf = BigInteger.valueOf(fromEncoding(i8, Math.min(i10 + i8, length), sArr));
            if (i9 == 0) {
                bigIntegerAdd = bigIntegerValueOf;
            } else {
                BigInteger[] bigIntegerArr = this.digitsGroupSpacePowers;
                bigIntegerMultiply = i9 <= bigIntegerArr.length ? bigIntegerArr[i9 - 1] : bigIntegerMultiply.multiply(this.digitsGroupSpaceSize);
                bigIntegerAdd = bigIntegerAdd.add(bigIntegerValueOf.multiply(bigIntegerMultiply));
            }
            i9++;
            i8 -= this.digitsGroupLength;
        }
    }

    public void toEncoding(BigInteger bigInteger, int i8, short[] sArr) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException();
        }
        int encoding = i8 - 1;
        do {
            if (bigInteger.equals(BigInteger.ZERO)) {
                sArr[encoding] = 0;
                encoding--;
            } else {
                BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger.divideAndRemainder(this.digitsGroupSpaceSize);
                BigInteger bigInteger2 = bigIntegerArrDivideAndRemainder[0];
                encoding = toEncoding(bigIntegerArrDivideAndRemainder[1].longValue(), encoding, sArr);
                bigInteger = bigInteger2;
            }
        } while (encoding >= 0);
        if (bigInteger.signum() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
