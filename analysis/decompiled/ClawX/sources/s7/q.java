package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class q extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5344j = r.f5348h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5345k = {new r(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5346i;

    public q() {
        super(f5344j);
        p7.m mVar = null;
        this.f5346i = new p7.q(this, mVar, mVar, 11);
        this.f4798b = new r(p7.a.f4757a);
        this.f4799c = new r(BigInteger.valueOf(7L));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new q();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 16];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.n(i9, ((r) rVar.f4818b).f5349g, iArr);
            x.e.n(i9 + 8, ((r) rVar.f4819c).f5349g, iArr);
            i9 += 16;
        }
        return new q7.a(this, i8, iArr, 10);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 11);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 11);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new r(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5344j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5346i;
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
            } while (x.f.n0(8, iArr, b.f5280v) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 8; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new r(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5344j;
    }
}
