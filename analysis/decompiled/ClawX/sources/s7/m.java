package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class m extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5326j = n.f5331h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5327k = {new n(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5328i;

    public m() {
        super(f5326j);
        p7.m mVar = null;
        this.f5328i = new p7.q(this, mVar, mVar, 9);
        this.f4798b = new n(p7.a.f4757a);
        this.f4799c = new n(BigInteger.valueOf(5L));
        this.d = new BigInteger(1, Hex.decodeStrict("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new m();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 14];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.f.x(i9, ((n) rVar.f4818b).f5333g, iArr);
            x.f.x(i9 + 7, ((n) rVar.f4819c).f5333g, iArr);
            i9 += 14;
        }
        return new q7.a(this, i8, iArr, 8);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 9);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 9);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new n(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5326j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5328i;
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
            } while (x.f.n0(7, iArr, b.f5274p) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 7; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new n(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5326j;
    }
}
