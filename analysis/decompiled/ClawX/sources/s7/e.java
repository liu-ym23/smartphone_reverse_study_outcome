package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class e extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5293j = f.f5297h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5294k = {new f(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5295i;

    public e() {
        super(f5293j);
        p7.m mVar = null;
        this.f5295i = new p7.q(this, mVar, mVar, 5);
        this.f4798b = new f(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f4799c = new f(new BigInteger(1, Hex.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.d = new BigInteger(1, Hex.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new e();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 10];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.f.v(i9, ((f) rVar.f4818b).f5298g, iArr);
            x.f.v(i9 + 5, ((f) rVar.f4819c).f5298g, iArr);
            i9 += 10;
        }
        return new q7.a(this, i8, iArr, 4);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 5);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 5);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new f(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5293j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5295i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[5];
        do {
            byte[] bArr = new byte[20];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 5);
            } while (x.f.n0(5, iArr, b.d) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 5; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new f(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5293j;
    }
}
