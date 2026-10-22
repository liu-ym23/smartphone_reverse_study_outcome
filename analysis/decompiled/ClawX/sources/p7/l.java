package p7;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public final class l extends j {

    /* renamed from: g, reason: collision with root package name */
    public final BigInteger f4808g;

    /* renamed from: h, reason: collision with root package name */
    public final BigInteger f4809h;

    /* renamed from: i, reason: collision with root package name */
    public final BigInteger f4810i;

    public l(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4808g = bigInteger;
        this.f4809h = bigInteger2;
        this.f4810i = bigInteger3;
    }

    @Override // p7.m
    public final m a(m mVar) {
        BigInteger bigIntegerAdd = this.f4810i.add(mVar.t());
        BigInteger bigInteger = this.f4808g;
        if (bigIntegerAdd.compareTo(bigInteger) >= 0) {
            bigIntegerAdd = bigIntegerAdd.subtract(bigInteger);
        }
        return new l(bigInteger, this.f4809h, bigIntegerAdd);
    }

    @Override // p7.m
    public final m b() {
        BigInteger bigIntegerAdd = this.f4810i.add(a.f4758b);
        BigInteger bigInteger = this.f4808g;
        if (bigIntegerAdd.compareTo(bigInteger) == 0) {
            bigIntegerAdd = a.f4757a;
        }
        return new l(bigInteger, this.f4809h, bigIntegerAdd);
    }

    @Override // p7.m
    public final m d(m mVar) {
        BigInteger bigIntegerT = mVar.t();
        BigInteger bigInteger = this.f4808g;
        return new l(bigInteger, this.f4809h, u(this.f4810i, BigIntegers.modOddInverse(bigInteger, bigIntegerT)));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f4808g.equals(lVar.f4808g) && this.f4810i.equals(lVar.f4810i);
    }

    @Override // p7.m
    public final int f() {
        return this.f4808g.bitLength();
    }

    @Override // p7.m
    public final m g() {
        BigInteger bigInteger = this.f4810i;
        BigInteger bigInteger2 = this.f4808g;
        return new l(bigInteger2, this.f4809h, BigIntegers.modOddInverse(bigInteger2, bigInteger));
    }

    public final int hashCode() {
        return this.f4810i.hashCode() ^ this.f4808g.hashCode();
    }

    @Override // p7.m
    public final m j(m mVar) {
        return new l(this.f4808g, this.f4809h, u(this.f4810i, mVar.t()));
    }

    @Override // p7.m
    public final m k(m mVar, m mVar2, m mVar3) {
        return new l(this.f4808g, this.f4809h, v(this.f4810i.multiply(mVar.t()).subtract(mVar2.t().multiply(mVar3.t()))));
    }

    @Override // p7.m
    public final m l(m mVar, m mVar2, m mVar3) {
        return new l(this.f4808g, this.f4809h, v(this.f4810i.multiply(mVar.t()).add(mVar2.t().multiply(mVar3.t()))));
    }

    @Override // p7.m
    public final m m() {
        BigInteger bigInteger = this.f4810i;
        if (bigInteger.signum() == 0) {
            return this;
        }
        BigInteger bigInteger2 = this.f4809h;
        BigInteger bigInteger3 = this.f4808g;
        return new l(bigInteger3, bigInteger2, bigInteger3.subtract(bigInteger));
    }

    @Override // p7.m
    public final m n() {
        BigInteger bigInteger;
        int i8;
        BigInteger bigInteger2;
        if (i() || h()) {
            return this;
        }
        BigInteger bigInteger3 = this.f4808g;
        int i9 = 0;
        if (!bigInteger3.testBit(0)) {
            throw new RuntimeException("not done yet");
        }
        int i10 = 1;
        boolean zTestBit = bigInteger3.testBit(1);
        m mVar = null;
        BigInteger bigInteger4 = this.f4809h;
        BigInteger bigInteger5 = this.f4810i;
        BigInteger bigInteger6 = a.f4758b;
        if (zTestBit) {
            l lVar = new l(bigInteger3, bigInteger4, bigInteger5.modPow(bigInteger3.shiftRight(2).add(bigInteger6), bigInteger3));
            if (lVar.o().equals(this)) {
                return lVar;
            }
            return null;
        }
        boolean zTestBit2 = bigInteger3.testBit(2);
        BigInteger bigIntegerV = a.f4759c;
        if (zTestBit2) {
            BigInteger bigIntegerModPow = bigInteger5.modPow(bigInteger3.shiftRight(3), bigInteger3);
            BigInteger bigIntegerU = u(bigIntegerModPow, bigInteger5);
            if (u(bigIntegerU, bigIntegerModPow).equals(bigInteger6)) {
                l lVar2 = new l(bigInteger3, bigInteger4, bigIntegerU);
                if (lVar2.o().equals(this)) {
                    return lVar2;
                }
                return null;
            }
            l lVar3 = new l(bigInteger3, bigInteger4, v(bigIntegerU.multiply(bigIntegerV.modPow(bigInteger3.shiftRight(2), bigInteger3))));
            if (lVar3.o().equals(this)) {
                return lVar3;
            }
            return null;
        }
        BigInteger bigIntegerShiftRight = bigInteger3.shiftRight(1);
        if (!bigInteger5.modPow(bigIntegerShiftRight, bigInteger3).equals(bigInteger6)) {
            return null;
        }
        BigInteger bigIntegerShiftLeft = bigInteger5.shiftLeft(1);
        if (bigIntegerShiftLeft.compareTo(bigInteger3) >= 0) {
            bigIntegerShiftLeft = bigIntegerShiftLeft.subtract(bigInteger3);
        }
        BigInteger bigIntegerShiftLeft2 = bigIntegerShiftLeft.shiftLeft(1);
        if (bigIntegerShiftLeft2.compareTo(bigInteger3) >= 0) {
            bigIntegerShiftLeft2 = bigIntegerShiftLeft2.subtract(bigInteger3);
        }
        BigInteger bigIntegerAdd = bigIntegerShiftRight.add(bigInteger6);
        BigInteger bigIntegerSubtract = bigInteger3.subtract(bigInteger6);
        Random random = new Random();
        while (true) {
            BigInteger bigInteger7 = new BigInteger(bigInteger3.bitLength(), random);
            if (bigInteger7.compareTo(bigInteger3) >= 0 || !v(bigInteger7.multiply(bigInteger7).subtract(bigIntegerShiftLeft2)).modPow(bigIntegerShiftRight, bigInteger3).equals(bigIntegerSubtract)) {
                bigInteger = bigIntegerShiftRight;
                i8 = i9;
                i9 = i8;
                bigIntegerShiftRight = bigInteger;
            } else {
                int iBitLength = bigIntegerAdd.bitLength();
                m mVar2 = mVar;
                int lowestSetBit = bigIntegerAdd.getLowestSetBit();
                int i11 = iBitLength - i10;
                int i12 = i9;
                bigInteger = bigIntegerShiftRight;
                BigInteger bigIntegerU2 = bigInteger6;
                BigInteger bigIntegerU3 = bigIntegerU2;
                BigInteger bigInteger8 = bigIntegerU3;
                BigInteger bigInteger9 = bigIntegerV;
                Random random2 = random;
                BigInteger bigIntegerV2 = bigInteger7;
                while (true) {
                    bigInteger2 = bigIntegerSubtract;
                    int i13 = lowestSetBit + 1;
                    bigIntegerU2 = u(bigIntegerU2, bigIntegerU3);
                    if (i11 < i13) {
                        break;
                    }
                    if (bigIntegerAdd.testBit(i11)) {
                        bigIntegerU3 = u(bigIntegerU2, bigInteger5);
                        BigInteger bigIntegerU4 = u(bigInteger8, bigIntegerV2);
                        bigIntegerV = v(bigIntegerV2.multiply(bigIntegerV).subtract(bigInteger7.multiply(bigIntegerU2)));
                        bigIntegerV2 = v(bigIntegerV2.multiply(bigIntegerV2).subtract(bigIntegerU3.shiftLeft(1)));
                        bigInteger8 = bigIntegerU4;
                    } else {
                        BigInteger bigIntegerV3 = v(bigInteger8.multiply(bigIntegerV).subtract(bigIntegerU2));
                        BigInteger bigIntegerV4 = v(bigIntegerV2.multiply(bigIntegerV).subtract(bigInteger7.multiply(bigIntegerU2)));
                        bigIntegerV = v(bigIntegerV.multiply(bigIntegerV).subtract(bigIntegerU2.shiftLeft(1)));
                        bigIntegerV2 = bigIntegerV4;
                        bigInteger8 = bigIntegerV3;
                        bigIntegerU3 = bigIntegerU2;
                    }
                    i11--;
                    bigIntegerSubtract = bigInteger2;
                }
                BigInteger bigIntegerU5 = u(bigIntegerU2, bigInteger5);
                BigInteger bigIntegerV5 = v(bigInteger8.multiply(bigIntegerV).subtract(bigIntegerU2));
                BigInteger bigIntegerV6 = v(bigIntegerV2.multiply(bigIntegerV).subtract(bigInteger7.multiply(bigIntegerU2)));
                BigInteger bigIntegerV7 = v(bigIntegerU2.multiply(bigIntegerU5));
                for (int i14 = 1; i14 <= lowestSetBit; i14++) {
                    bigIntegerV5 = u(bigIntegerV5, bigIntegerV6);
                    bigIntegerV6 = v(bigIntegerV6.multiply(bigIntegerV6).subtract(bigIntegerV7.shiftLeft(1)));
                    bigIntegerV7 = v(bigIntegerV7.multiply(bigIntegerV7));
                }
                BigInteger[] bigIntegerArr = {bigIntegerV5, bigIntegerV6};
                BigInteger bigInteger10 = bigIntegerArr[i12];
                BigInteger bigIntegerSubtract2 = bigIntegerArr[1];
                if (u(bigIntegerSubtract2, bigIntegerSubtract2).equals(bigIntegerShiftLeft2)) {
                    if (bigIntegerSubtract2.testBit(i12)) {
                        bigIntegerSubtract2 = bigInteger3.subtract(bigIntegerSubtract2);
                    }
                    return new l(bigInteger3, bigInteger4, bigIntegerSubtract2.shiftRight(1));
                }
                i8 = i12;
                if (bigInteger10.equals(bigInteger6)) {
                    i9 = i8;
                    i10 = 1;
                    mVar = mVar2;
                    bigIntegerShiftRight = bigInteger;
                    bigIntegerV = bigInteger9;
                    random = random2;
                    bigIntegerSubtract = bigInteger2;
                } else {
                    if (!bigInteger10.equals(bigInteger2)) {
                        return mVar2;
                    }
                    i10 = 1;
                    mVar = mVar2;
                    bigIntegerV = bigInteger9;
                    random = random2;
                    bigIntegerSubtract = bigInteger2;
                    i9 = i8;
                    bigIntegerShiftRight = bigInteger;
                }
            }
        }
    }

    @Override // p7.m
    public final m o() {
        BigInteger bigInteger = this.f4810i;
        return new l(this.f4808g, this.f4809h, u(bigInteger, bigInteger));
    }

    @Override // p7.m
    public final m p(m mVar, m mVar2) {
        BigInteger bigIntegerT = mVar.t();
        BigInteger bigIntegerT2 = mVar2.t();
        BigInteger bigInteger = this.f4810i;
        return new l(this.f4808g, this.f4809h, v(bigInteger.multiply(bigInteger).add(bigIntegerT.multiply(bigIntegerT2))));
    }

    @Override // p7.m
    public final m r(m mVar) {
        BigInteger bigIntegerSubtract = this.f4810i.subtract(mVar.t());
        int iSignum = bigIntegerSubtract.signum();
        BigInteger bigInteger = this.f4808g;
        if (iSignum < 0) {
            bigIntegerSubtract = bigIntegerSubtract.add(bigInteger);
        }
        return new l(bigInteger, this.f4809h, bigIntegerSubtract);
    }

    @Override // p7.m
    public final BigInteger t() {
        return this.f4810i;
    }

    public final BigInteger u(BigInteger bigInteger, BigInteger bigInteger2) {
        return v(bigInteger.multiply(bigInteger2));
    }

    public final BigInteger v(BigInteger bigInteger) {
        BigInteger bigInteger2 = this.f4808g;
        BigInteger bigInteger3 = this.f4809h;
        if (bigInteger3 == null) {
            return bigInteger.mod(bigInteger2);
        }
        boolean z = bigInteger.signum() < 0;
        if (z) {
            bigInteger = bigInteger.abs();
        }
        int iBitLength = bigInteger2.bitLength();
        boolean zEquals = bigInteger3.equals(a.f4758b);
        while (bigInteger.bitLength() > iBitLength + 1) {
            BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
            BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
            if (!zEquals) {
                bigIntegerShiftRight = bigIntegerShiftRight.multiply(bigInteger3);
            }
            bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
        }
        while (bigInteger.compareTo(bigInteger2) >= 0) {
            bigInteger = bigInteger.subtract(bigInteger2);
        }
        return (!z || bigInteger.signum() == 0) ? bigInteger : bigInteger2.subtract(bigInteger);
    }
}
