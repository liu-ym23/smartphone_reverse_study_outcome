package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class u extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5360j = v.f5365h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5361k = {new v(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5362i;

    public u() {
        super(f5360j);
        p7.m mVar = null;
        this.f5362i = new p7.q(this, mVar, mVar, 13);
        this.f4798b = new v(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f4799c = new v(new BigInteger(1, Hex.decodeStrict("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new u();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 24];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            System.arraycopy(((v) rVar.f4818b).f5366g, 0, iArr, i9, 12);
            System.arraycopy(((v) rVar.f4819c).f5366g, 0, iArr, i9 + 12, 12);
            i9 += 24;
        }
        return new q7.a(this, i8, iArr, 12);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 13);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 13);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new v(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5360j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5362i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[12];
        do {
            byte[] bArr = new byte[48];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 12);
            } while (x.f.n0(12, iArr, b.A) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 12; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new v(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5360j;
    }
}
