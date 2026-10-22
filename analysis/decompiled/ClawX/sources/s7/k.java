package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class k extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5318j = l.f5323h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5319k = {new l(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5320i;

    public k() {
        super(f5318j);
        p7.m mVar = null;
        this.f5320i = new p7.q(this, mVar, mVar, 8);
        this.f4798b = new l(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f4799c = new l(new BigInteger(1, Hex.decodeStrict("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new k();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 12];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.m(i9, ((l) rVar.f4818b).f5324g, iArr);
            x.e.m(i9 + 6, ((l) rVar.f4819c).f5324g, iArr);
            i9 += 12;
        }
        return new q7.a(this, i8, iArr, 7);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 8);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 8);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new l(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5318j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5320i;
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
            } while (x.f.n0(6, iArr, b.f5271m) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 6; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new l(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5318j;
    }
}
