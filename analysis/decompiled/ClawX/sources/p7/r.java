package p7;

import java.math.BigInteger;
import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: f, reason: collision with root package name */
    public static final m[] f4816f = new m[0];

    /* renamed from: a, reason: collision with root package name */
    public final h f4817a;

    /* renamed from: b, reason: collision with root package name */
    public final m f4818b;

    /* renamed from: c, reason: collision with root package name */
    public final m f4819c;
    public final m[] d;

    /* renamed from: e, reason: collision with root package name */
    public Hashtable f4820e;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(h hVar, m mVar, m mVar2) {
        m[] mVarArr;
        int i8 = hVar == null ? 0 : hVar.f4801f;
        if (i8 == 0 || i8 == 5) {
            mVarArr = f4816f;
        } else {
            m mVarJ = hVar.j(a.f4758b);
            if (i8 == 1 || i8 == 2) {
                mVarArr = new m[]{mVarJ};
            } else if (i8 == 3) {
                mVarArr = new m[]{mVarJ, mVarJ, mVarJ};
            } else if (i8 != 4) {
                if (i8 != 6) {
                    throw new IllegalArgumentException("unknown coordinate system");
                }
                mVarArr = new m[]{mVarJ};
            } else {
                mVarArr = new m[]{mVarJ, hVar.f4798b};
            }
        }
        this(hVar, mVar, mVar2, mVarArr);
    }

    public abstract r a(r rVar);

    public final void b() {
        if (!l()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(p7.r r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L5
            goto L77
        L5:
            p7.h r1 = r10.f4817a
            r2 = 1
            p7.h r3 = r9.f4817a
            if (r3 != 0) goto Le
            r4 = r2
            goto Lf
        Le:
            r4 = r0
        Lf:
            if (r1 != 0) goto L13
            r5 = r2
            goto L14
        L13:
            r5 = r0
        L14:
            boolean r6 = r9.k()
            boolean r7 = r10.k()
            if (r6 != 0) goto L68
            if (r7 == 0) goto L21
            goto L68
        L21:
            if (r4 == 0) goto L26
            if (r5 == 0) goto L26
            goto L4f
        L26:
            if (r4 == 0) goto L2d
            p7.r r10 = r10.o()
            goto L4f
        L2d:
            if (r5 == 0) goto L34
            p7.r r9 = r9.o()
            goto L4f
        L34:
            boolean r1 = r3.i(r1)
            if (r1 != 0) goto L3b
            goto L77
        L3b:
            p7.r r10 = r3.n(r10)
            p7.r[] r9 = new p7.r[]{r9, r10}
            r10 = 0
            r1 = 2
            r3.p(r9, r0, r1, r10)
            r10 = r9[r0]
            r9 = r9[r2]
            r8 = r10
            r10 = r9
            r9 = r8
        L4f:
            p7.m r1 = r9.f4818b
            p7.m r3 = r10.f4818b
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L77
            p7.m r9 = r9.h()
            p7.m r10 = r10.h()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L77
            goto L76
        L68:
            if (r6 == 0) goto L77
            if (r7 == 0) goto L77
            if (r4 != 0) goto L76
            if (r5 != 0) goto L76
            boolean r9 = r3.i(r1)
            if (r9 == 0) goto L77
        L76:
            return r2
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.r.c(p7.r):boolean");
    }

    public final m d() {
        b();
        return h();
    }

    public abstract boolean e();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            return c((r) obj);
        }
        return false;
    }

    public final int f() {
        h hVar = this.f4817a;
        if (hVar == null) {
            return 0;
        }
        return hVar.f4801f;
    }

    public final byte[] g(boolean z) {
        if (k()) {
            return new byte[1];
        }
        r rVarO = o();
        byte[] bArrE = rVarO.f4818b.e();
        if (z) {
            byte[] bArr = new byte[bArrE.length + 1];
            bArr[0] = (byte) (rVarO.e() ? 3 : 2);
            System.arraycopy(bArrE, 0, bArr, 1, bArrE.length);
            return bArr;
        }
        byte[] bArrE2 = rVarO.h().e();
        byte[] bArr2 = new byte[bArrE.length + bArrE2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(bArrE, 0, bArr2, 1, bArrE.length);
        System.arraycopy(bArrE2, 0, bArr2, bArrE.length + 1, bArrE2.length);
        return bArr2;
    }

    public m h() {
        return this.f4819c;
    }

    public final int hashCode() {
        h hVar = this.f4817a;
        int i8 = hVar == null ? 0 : ~hVar.hashCode();
        if (k()) {
            return i8;
        }
        r rVarO = o();
        return (rVarO.h().hashCode() * 257) ^ (i8 ^ (rVarO.f4818b.hashCode() * 17));
    }

    public m i() {
        m[] mVarArr = this.d;
        if (mVarArr.length <= 0) {
            return null;
        }
        return mVarArr[0];
    }

    public final boolean j(boolean z, boolean z2) {
        if (k()) {
            return true;
        }
        return !((a0) this.f4817a.q(this, "bc_validity", new o(this, z, z2))).f4762a;
    }

    public final boolean k() {
        if (this.f4818b == null || this.f4819c == null) {
            return true;
        }
        m[] mVarArr = this.d;
        return mVarArr.length > 0 && mVarArr[0].i();
    }

    public final boolean l() {
        int iF = f();
        return iF == 0 || iF == 5 || k() || this.d[0].h();
    }

    public final r m(BigInteger bigInteger) {
        h hVar = this.f4817a;
        if (hVar.f4803h == null) {
            hVar.f4803h = hVar.c();
        }
        return ((d0) hVar.f4803h).m(this, bigInteger);
    }

    public abstract r n();

    public final r o() {
        int iF;
        if (!k() && (iF = f()) != 0 && iF != 5) {
            m mVarI = i();
            if (!mVarI.h()) {
                h hVar = this.f4817a;
                if (hVar == null) {
                    throw new IllegalStateException("Detached points must be in affine coordinates");
                }
                m mVarR = hVar.r(CryptoServicesRegistrar.getSecureRandom());
                return p(mVarI.j(mVarR).g().j(mVarR));
            }
        }
        return this;
    }

    public final r p(m mVar) {
        m mVarJ;
        int iF = f();
        m mVar2 = this.f4819c;
        m mVar3 = this.f4818b;
        h hVar = this.f4817a;
        if (iF == 1) {
            mVarJ = mVar3.j(mVar);
        } else if (iF == 2 || iF == 3 || iF == 4) {
            m mVarO = mVar.o();
            mVar = mVarO.j(mVar);
            mVarJ = mVar3.j(mVarO);
        } else {
            if (iF != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
            mVarJ = mVar3.j(mVar);
        }
        return hVar.e(mVarJ, mVar2.j(mVar));
    }

    public abstract boolean q();

    public boolean r() {
        BigInteger bigInteger;
        BigInteger bigInteger2 = a.f4758b;
        h hVar = this.f4817a;
        return bigInteger2.equals(hVar.f4800e) || (bigInteger = hVar.d) == null || d0.p(this, bigInteger).k();
    }

    public r s(m mVar) {
        if (k()) {
            return this;
        }
        return this.f4817a.f(this.f4818b.j(mVar), this.f4819c, this.d);
    }

    public r t(m mVar) {
        if (k()) {
            return this;
        }
        return this.f4817a.f(this.f4818b, this.f4819c.j(mVar), this.d);
    }

    public final String toString() {
        if (k()) {
            return "INF";
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.f4818b);
        sb.append(AbstractJsonLexerKt.COMMA);
        sb.append(this.f4819c);
        int i8 = 0;
        while (true) {
            m[] mVarArr = this.d;
            if (i8 >= mVarArr.length) {
                sb.append(')');
                return sb.toString();
            }
            sb.append(AbstractJsonLexerKt.COMMA);
            sb.append(mVarArr[i8]);
            i8++;
        }
    }

    public abstract r u(r rVar);

    public r v() {
        return y(this);
    }

    public r w(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        while (true) {
            i8--;
            if (i8 < 0) {
                return this;
            }
            this = this.x();
        }
    }

    public abstract r x();

    public abstract r y(r rVar);

    public r(h hVar, m mVar, m mVar2, m[] mVarArr) {
        this.f4820e = null;
        this.f4817a = hVar;
        this.f4818b = mVar;
        this.f4819c = mVar2;
        this.d = mVarArr;
    }
}
