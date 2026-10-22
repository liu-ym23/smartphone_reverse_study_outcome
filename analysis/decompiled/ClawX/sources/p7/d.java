package p7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public abstract class d extends h {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(java.math.BigInteger r4) {
        /*
            r3 = this;
            w7.e r0 = w7.b.f6224a
            int r0 = r4.bitLength()
            int r1 = r4.signum()
            if (r1 <= 0) goto L2b
            r1 = 2
            if (r0 < r1) goto L2b
            r2 = 3
            if (r0 >= r2) goto L21
            int r0 = org.bouncycastle.util.BigIntegers.intValueExact(r4)
            if (r0 == r1) goto L1e
            if (r0 == r2) goto L1b
            goto L21
        L1b:
            w7.e r4 = w7.b.f6225b
            goto L27
        L1e:
            w7.e r4 = w7.b.f6224a
            goto L27
        L21:
            w7.e r0 = new w7.e
            r0.<init>(r4)
            r4 = r0
        L27:
            r3.<init>(r4)
            return
        L2b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "'characteristic' must be >= 2"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.d.<init>(java.math.BigInteger):void");
    }

    @Override // p7.h
    public final r h(int i8, BigInteger bigInteger) {
        m mVarJ = j(bigInteger);
        m mVarN = mVarJ.o().a(this.f4798b).j(mVarJ).a(this.f4799c).n();
        if (mVarN == null) {
            throw new IllegalArgumentException("Invalid point compression");
        }
        if (mVarN.s() != (i8 == 1)) {
            mVarN = mVarN.m();
        }
        return e(mVarJ, mVarN);
    }

    @Override // p7.h
    public final boolean o(BigInteger bigInteger) {
        return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(u()) < 0;
    }

    @Override // p7.h
    public m r(SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomBigInteger;
        BigInteger bigIntegerU = u();
        while (true) {
            bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(bigIntegerU.bitLength(), secureRandom);
            if (bigIntegerCreateRandomBigInteger.signum() > 0 && bigIntegerCreateRandomBigInteger.compareTo(bigIntegerU) < 0) {
                break;
            }
        }
        m mVarJ = j(bigIntegerCreateRandomBigInteger);
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger2 = BigIntegers.createRandomBigInteger(bigIntegerU.bitLength(), secureRandom);
            if (bigIntegerCreateRandomBigInteger2.signum() > 0 && bigIntegerCreateRandomBigInteger2.compareTo(bigIntegerU) < 0) {
                return mVarJ.j(j(bigIntegerCreateRandomBigInteger2));
            }
        }
    }

    public abstract BigInteger u();
}
