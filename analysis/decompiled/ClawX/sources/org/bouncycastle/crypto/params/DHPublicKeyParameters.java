package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;
import x.f;

/* loaded from: classes.dex */
public class DHPublicKeyParameters extends DHKeyParameters {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private BigInteger y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.y = validate(bigInteger, dHParameters);
    }

    private static int legendre(BigInteger bigInteger, BigInteger bigInteger2) {
        int iBitLength = bigInteger2.bitLength();
        int[] iArrO = f.O(iBitLength, bigInteger);
        int[] iArrO2 = f.O(iBitLength, bigInteger2);
        int length = iArrO2.length;
        int i8 = 0;
        while (true) {
            int i9 = iArrO[0];
            char c3 = 65535;
            if (i9 == 0) {
                int i10 = length;
                int i11 = 0;
                while (true) {
                    i10--;
                    if (i10 >= 0) {
                        int i12 = iArrO[i10];
                        iArrO[i10] = i11;
                        i11 = i12;
                    }
                }
            } else {
                int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(i9);
                if (iNumberOfTrailingZeros > 0) {
                    int i13 = length;
                    int i14 = 0;
                    while (true) {
                        i13--;
                        if (i13 < 0) {
                            break;
                        }
                        int i15 = iArrO[i13];
                        iArrO[i13] = (i14 << (-iNumberOfTrailingZeros)) | (i15 >>> iNumberOfTrailingZeros);
                        i14 = i15;
                    }
                    int i16 = iArrO2[0];
                    i8 ^= (iNumberOfTrailingZeros << 1) & (i16 ^ (i16 >>> 1));
                }
                int i17 = length - 1;
                while (true) {
                    if (i17 < 0) {
                        c3 = 0;
                        break;
                    }
                    int i18 = iArrO[i17] ^ Integer.MIN_VALUE;
                    int i19 = Integer.MIN_VALUE ^ iArrO2[i17];
                    if (i18 < i19) {
                        break;
                    }
                    if (i18 > i19) {
                        c3 = 1;
                        break;
                    }
                    i17--;
                }
                if (c3 == 0) {
                    break;
                }
                if (c3 < 0) {
                    i8 ^= iArrO[0] & iArrO2[0];
                    int[] iArr = iArrO2;
                    iArrO2 = iArrO;
                    iArrO = iArr;
                }
                while (true) {
                    int i20 = length - 1;
                    if (iArrO[i20] != 0) {
                        break;
                    }
                    length = i20;
                }
                f.C0(iArrO, iArrO2, length, iArrO);
            }
        }
        if (f.g0(length, iArrO2)) {
            return 1 - (i8 & 2);
        }
        return 0;
    }

    private BigInteger validate(BigInteger bigInteger, DHParameters dHParameters) {
        if (bigInteger == null) {
            throw new NullPointerException("y value cannot be null");
        }
        BigInteger p3 = dHParameters.getP();
        BigInteger bigInteger2 = TWO;
        if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(p3.subtract(bigInteger2)) > 0) {
            throw new IllegalArgumentException("invalid DH public key");
        }
        BigInteger q8 = dHParameters.getQ();
        if (q8 != null && (!(p3.testBit(0) && p3.bitLength() - 1 == q8.bitLength() && p3.shiftRight(1).equals(q8)) ? ONE.equals(bigInteger.modPow(q8, p3)) : 1 == legendre(bigInteger, p3))) {
            throw new IllegalArgumentException("Y value does not appear to be in correct group");
        }
        return bigInteger;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        return (obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.y;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return super.hashCode() ^ this.y.hashCode();
    }
}
