package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class s extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5352j = t.f5357h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5353k = {new t(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5354i;

    public s() {
        super(f5352j);
        p7.m mVar = null;
        this.f5354i = new p7.q(this, mVar, mVar, 12);
        this.f4798b = new t(new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f4799c = new t(new BigInteger(1, Hex.decodeStrict("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new s();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 16];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.n(i9, ((t) rVar.f4818b).f5358g, iArr);
            x.e.n(i9 + 8, ((t) rVar.f4819c).f5358g, iArr);
            i9 += 16;
        }
        return new q7.a(this, i8, iArr, 11);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 12);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 12);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new t(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5352j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5354i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[8];
        do {
            byte[] bArr = new byte[32];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
            } while (x.f.n0(8, iArr, b.y) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 8; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new t(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5352j;
    }
}
