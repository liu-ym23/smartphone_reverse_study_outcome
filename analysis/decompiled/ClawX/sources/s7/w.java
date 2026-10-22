package s7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class w extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5369j = x.f5373h;

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5370k = {new x(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final p7.q f5371i;

    public w() {
        super(f5369j);
        p7.m mVar = null;
        this.f5371i = new p7.q(this, mVar, mVar, 14);
        this.f4798b = new x(new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f4799c = new x(new BigInteger(1, Hex.decodeStrict("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.d = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final p7.h a() {
        return new w();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 34];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            System.arraycopy(((x) rVar.f4818b).f5374g, 0, iArr, i9, 17);
            System.arraycopy(((x) rVar.f4819c).f5374g, 0, iArr, i9 + 17, 17);
            i9 += 34;
        }
        return new q7.a(this, i8, iArr, 13);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.q(this, mVar, mVar2, 14);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.q(this, mVar, mVar2, mVarArr, 14);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new x(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5369j.bitLength();
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5371i;
    }

    @Override // p7.d, p7.h
    public final p7.m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[17];
        do {
            byte[] bArr = new byte[68];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 17);
                iArr[16] = iArr[16] & 511;
            } while (x.f.n0(17, iArr, b.D) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 17; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new x(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 2;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f5369j;
    }
}
