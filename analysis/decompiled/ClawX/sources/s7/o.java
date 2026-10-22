package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class o extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5336j = p.f5340h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5337k = {new p(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5338i;

    public o() {
        super(f5336j);
        p7.m mVar = null;
        this.f5338i = new p7.q(this, mVar, mVar, 10);
        this.f4798b = new p(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f4799c = new p(new BigInteger(1, Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new o();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 14];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.f.x(i9, ((p) rVar.f4818b).f5341g, iArr);
            x.f.x(i9 + 7, ((p) rVar.f4819c).f5341g, iArr);
            i9 += 14;
        }
        return new q7.a(this, i8, iArr, 9);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 10);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 10);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new p(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5336j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5338i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[7];
        do {
            byte[] bArr = new byte[28];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 7);
            } while (x.f.n0(7, iArr, b.f5277s) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 7; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new p(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5336j;
    }
}
