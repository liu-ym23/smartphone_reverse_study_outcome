package p7;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Properties;

/* loaded from: classes.dex */
public abstract class c extends h {

    /* renamed from: i, reason: collision with root package name */
    public BigInteger[] f4774i;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(int i8, int i9, int i10, int i11) {
        if (i8 > Properties.asInteger("org.bouncycastle.ec.max_f2m_field_size", 1142)) {
            throw new IllegalArgumentException(a8.b.j(i8, "field size out of range: "));
        }
        int[] iArr = (i10 | i11) == 0 ? new int[]{0, i9, i8} : new int[]{0, i9, i10, i11, i8};
        w7.e eVar = w7.b.f6224a;
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i12 = 1; i12 < iArr.length; i12++) {
            if (iArr[i12] <= iArr[i12 - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        super(new w7.d(w7.b.f6224a, new w7.c(iArr)));
        this.f4774i = null;
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable")) {
            throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable\"");
        }
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable_f2m")) {
            throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable_f2m\"");
        }
    }

    @Override // p7.h
    public final r d(BigInteger bigInteger, BigInteger bigInteger2) {
        m mVarJ = j(bigInteger);
        m mVarJ2 = j(bigInteger2);
        int i8 = this.f4801f;
        if (i8 == 5 || i8 == 6) {
            if (!mVarJ.i()) {
                mVarJ2 = mVarJ2.d(mVarJ).a(mVarJ);
            } else if (!mVarJ2.o().equals(this.f4799c)) {
                throw new IllegalArgumentException();
            }
        }
        return e(mVarJ, mVarJ2);
    }

    @Override // p7.h
    public final r h(int i8, BigInteger bigInteger) {
        m mVarA;
        m mVarJ = j(bigInteger);
        if (mVarJ.i()) {
            mVarA = this.f4799c.n();
        } else {
            m mVarV = v(mVarJ.o().g().j(this.f4799c).a(this.f4798b).a(mVarJ));
            if (mVarV != null) {
                if (mVarV.s() != (i8 == 1)) {
                    mVarV = mVarV.b();
                }
                int i9 = this.f4801f;
                mVarA = (i9 == 5 || i9 == 6) ? mVarV.a(mVarJ) : mVarV.j(mVarJ);
            } else {
                mVarA = null;
            }
        }
        if (mVarA != null) {
            return e(mVarJ, mVarA);
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    @Override // p7.h
    public final boolean o(BigInteger bigInteger) {
        return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= l();
    }

    @Override // p7.h
    public final m r(SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomBigInteger;
        BigInteger bigIntegerCreateRandomBigInteger2;
        int iL = l();
        do {
            bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iL, secureRandom);
        } while (bigIntegerCreateRandomBigInteger.signum() <= 0);
        m mVarJ = j(bigIntegerCreateRandomBigInteger);
        do {
            bigIntegerCreateRandomBigInteger2 = BigIntegers.createRandomBigInteger(iL, secureRandom);
        } while (bigIntegerCreateRandomBigInteger2.signum() <= 0);
        return mVarJ.j(j(bigIntegerCreateRandomBigInteger2));
    }

    public boolean u() {
        if (this.d == null || this.f4800e == null || !this.f4799c.h()) {
            return false;
        }
        return this.f4798b.i() || this.f4798b.h();
    }

    public final m v(m mVar) {
        m mVarA;
        i iVar = (i) mVar;
        boolean zV = iVar.v();
        if (zV && iVar.w() != 0) {
            return null;
        }
        int iL = l();
        if ((iL & 1) != 0) {
            m mVarU = iVar.u();
            if (zV || mVarU.o().a(mVarU).a(mVar).i()) {
                return mVarU;
            }
            return null;
        }
        if (mVar.i()) {
            return mVar;
        }
        m mVarJ = j(a.f4757a);
        Random random = new Random();
        do {
            m mVarJ2 = j(new BigInteger(iL, random));
            m mVarA2 = mVar;
            mVarA = mVarJ;
            for (int i8 = 1; i8 < iL; i8++) {
                m mVarO = mVarA2.o();
                mVarA = mVarA.o().a(mVarO.j(mVarJ2));
                mVarA2 = mVarO.a(mVar);
            }
            if (!mVarA2.i()) {
                return null;
            }
        } while (mVarA.o().a(mVarA).i());
        return mVarA;
    }
}
