package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class i extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5310j = j.f5314h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5311k = {new j(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5312i;

    public i() {
        super(f5310j);
        p7.m mVar = null;
        this.f5312i = new p7.q(this, mVar, mVar, 7);
        this.f4798b = new j(p7.a.f4757a);
        this.f4799c = new j(BigInteger.valueOf(3L));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new i();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 12];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.m(i9, ((j) rVar.f4818b).f5315g, iArr);
            x.e.m(i9 + 6, ((j) rVar.f4819c).f5315g, iArr);
            i9 += 12;
        }
        return new q7.a(this, i8, iArr, 6);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 7);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 7);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new j(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5310j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5312i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[6];
        do {
            byte[] bArr = new byte[24];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 6);
            } while (x.f.n0(6, iArr, b.f5268j) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 6; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new j(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5310j;
    }
}
