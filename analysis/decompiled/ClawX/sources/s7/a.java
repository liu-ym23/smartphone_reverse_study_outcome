package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class a extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5255j = c.f5284h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5256k = {new c(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5257i;

    public a() {
        super(f5255j);
        p7.m mVar = null;
        this.f5257i = new p7.q(this, mVar, mVar, 3);
        this.f4798b = new c(new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f4799c = new c(new BigInteger(1, Hex.decodeStrict("E87579C11079F43DD824993C2CEE5ED3")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFE0000000075A30D1B9038A115"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new a();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 8];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.l(i9, ((c) rVar.f4818b).f5285g, iArr);
            x.e.l(i9 + 4, ((c) rVar.f4819c).f5285g, iArr);
            i9 += 8;
        }
        return new q7.a(this, i8, iArr, 2);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 3);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 3);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5255j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5257i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[4];
        do {
            byte[] bArr = new byte[16];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 4);
            } while (x.f.n0(4, iArr, b.f5260a) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 4; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new c(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5255j;
    }
}
