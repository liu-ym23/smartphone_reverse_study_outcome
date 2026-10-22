package p7;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final w7.a f4797a;

    /* renamed from: b, reason: collision with root package name */
    public m f4798b;

    /* renamed from: c, reason: collision with root package name */
    public m f4799c;
    public BigInteger d;

    /* renamed from: e, reason: collision with root package name */
    public BigInteger f4800e;

    /* renamed from: f, reason: collision with root package name */
    public int f4801f = 0;

    /* renamed from: g, reason: collision with root package name */
    public t7.b f4802g = null;

    /* renamed from: h, reason: collision with root package name */
    public n f4803h = null;

    public h(w7.a aVar) {
        this.f4797a = aVar;
    }

    public abstract h a();

    public d0 b(r[] rVarArr, int i8) {
        int iK = k();
        byte[] bArr = new byte[i8 * iK * 2];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            r rVar = rVarArr[i10];
            m mVar = rVar.f4818b;
            BigIntegers.asUnsignedByteArray(mVar.t(), bArr, i9, (mVar.f() + 7) / 8);
            int i11 = i9 + iK;
            m mVar2 = rVar.f4819c;
            BigIntegers.asUnsignedByteArray(mVar2.t(), bArr, i11, (mVar2.f() + 7) / 8);
            i9 = i11 + iK;
        }
        return new b(this, i8, iK, bArr);
    }

    public n c() {
        t7.b bVar = this.f4802g;
        return bVar instanceof t7.b ? new u(this, bVar) : new s(1);
    }

    public r d(BigInteger bigInteger, BigInteger bigInteger2) {
        return e(j(bigInteger), j(bigInteger2));
    }

    public abstract r e(m mVar, m mVar2);

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof h) && i((h) obj);
        }
        return true;
    }

    public abstract r f(m mVar, m mVar2, m[] mVarArr);

    public final r g(byte[] bArr) {
        r rVarM;
        int iK = k();
        byte b9 = bArr[0];
        if (b9 != 0) {
            if (b9 == 2 || b9 == 3) {
                if (bArr.length != iK + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                rVarM = h(b9 & 1, BigIntegers.fromUnsignedByteArray(bArr, 1, iK));
                if (!rVarM.j(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b9 != 4) {
                if (b9 != 6 && b9 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b9, 16));
                }
                if (bArr.length != (iK * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 1, iK);
                BigInteger bigIntegerFromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(bArr, iK + 1, iK);
                if (bigIntegerFromUnsignedByteArray2.testBit(0) != (b9 == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                rVarM = t(bigIntegerFromUnsignedByteArray, bigIntegerFromUnsignedByteArray2);
            } else {
                if (bArr.length != (iK * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                rVarM = t(BigIntegers.fromUnsignedByteArray(bArr, 1, iK), BigIntegers.fromUnsignedByteArray(bArr, iK + 1, iK));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            rVarM = m();
        }
        if (b9 == 0 || !rVarM.k()) {
            return rVarM;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract r h(int i8, BigInteger bigInteger);

    public final int hashCode() {
        return Integers.rotateLeft(this.f4799c.t().hashCode(), 16) ^ (this.f4797a.hashCode() ^ Integers.rotateLeft(this.f4798b.t().hashCode(), 8));
    }

    public final boolean i(h hVar) {
        if (this != hVar) {
            return hVar != null && this.f4797a.equals(hVar.f4797a) && this.f4798b.t().equals(hVar.f4798b.t()) && this.f4799c.t().equals(hVar.f4799c.t());
        }
        return true;
    }

    public abstract m j(BigInteger bigInteger);

    public final int k() {
        return (l() + 7) / 8;
    }

    public abstract int l();

    public abstract r m();

    public r n(r rVar) {
        if (this == rVar.f4817a) {
            return rVar;
        }
        if (rVar.k()) {
            return m();
        }
        r rVarO = rVar.o();
        return d(rVarO.f4818b.t(), rVarO.h().t());
    }

    public abstract boolean o(BigInteger bigInteger);

    public final void p(r[] rVarArr, int i8, int i9, m mVar) {
        if (i8 < 0 || i9 < 0 || i8 > rVarArr.length - i9) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i10 = 0; i10 < i9; i10++) {
            r rVar = rVarArr[i8 + i10];
            if (rVar != null && this != rVar.f4817a) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
        int i11 = this.f4801f;
        if (i11 == 0 || i11 == 5) {
            if (mVar != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        m[] mVarArr = new m[i9];
        int[] iArr = new int[i9];
        int i12 = 0;
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = i8 + i13;
            r rVar2 = rVarArr[i14];
            if (rVar2 != null && (mVar != null || !rVar2.l())) {
                mVarArr[i12] = rVar2.i();
                iArr[i12] = i14;
                i12++;
            }
        }
        if (i12 == 0) {
            return;
        }
        m[] mVarArr2 = new m[i12];
        mVarArr2[0] = mVarArr[0];
        int i15 = 0;
        while (true) {
            int i16 = i15 + 1;
            if (i16 >= i12) {
                break;
            }
            mVarArr2[i16] = mVarArr2[i15].j(mVarArr[i16]);
            i15 = i16;
        }
        if (mVar != null) {
            mVarArr2[i15] = mVarArr2[i15].j(mVar);
        }
        m mVarG = mVarArr2[i15].g();
        while (i15 > 0) {
            int i17 = i15 - 1;
            m mVar2 = mVarArr[i15];
            mVarArr[i15] = mVarArr2[i17].j(mVarG);
            mVarG = mVarG.j(mVar2);
            i15 = i17;
        }
        mVarArr[0] = mVarG;
        for (int i18 = 0; i18 < i12; i18++) {
            int i19 = iArr[i18];
            rVarArr[i19] = rVarArr[i19].p(mVarArr[i18]);
        }
    }

    public final x q(r rVar, String str, w wVar) {
        Hashtable hashtable;
        x xVarE;
        if (rVar == null || this != rVar.f4817a) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
        synchronized (rVar) {
            try {
                hashtable = rVar.f4820e;
                if (hashtable == null) {
                    hashtable = new Hashtable(4);
                    rVar.f4820e = hashtable;
                }
            } finally {
            }
        }
        synchronized (hashtable) {
            try {
                x xVar = (x) hashtable.get(str);
                xVarE = wVar.e(xVar);
                if (xVarE != xVar) {
                    hashtable.put(str, xVarE);
                }
            } finally {
            }
        }
        return xVarE;
    }

    public abstract m r(SecureRandom secureRandom);

    public abstract boolean s(int i8);

    public final r t(BigInteger bigInteger, BigInteger bigInteger2) {
        r rVarD = d(bigInteger, bigInteger2);
        if (rVarD.j(false, true)) {
            return rVarD;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
