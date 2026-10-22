package r7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;
import p7.d;
import p7.d0;
import p7.h;
import p7.m;
import p7.q;
import p7.r;
import x.e;
import x.f;

/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f5221j = c.f5226h;

    /* renamed from: k, reason: collision with root package name */
    public static final m[] f5222k = {new c(p7.a.f4758b)};

    /* renamed from: i, reason: collision with root package name */
    public final q f5223i;

    public a() {
        super(f5221j);
        m mVar = null;
        this.f5223i = new q(this, mVar, mVar, 2);
        this.f4798b = new c(new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f4799c = new c(new BigInteger(1, Hex.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.d = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f4800e = BigInteger.valueOf(1L);
        this.f4801f = 2;
    }

    @Override // p7.h
    public final h a() {
        return new a();
    }

    @Override // p7.h
    public final d0 b(r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 16];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            r rVar = rVarArr[i10];
            e.n(i9, ((c) rVar.f4818b).f5227g, iArr);
            e.n(i9 + 8, ((c) rVar.f4819c).f5227g, iArr);
            i9 += 16;
        }
        return new q7.a(this, i8, iArr, 1);
    }

    @Override // p7.h
    public final r e(m mVar, m mVar2) {
        return new q(this, mVar, mVar2, 2);
    }

    @Override // p7.h
    public final r f(m mVar, m mVar2, m[] mVarArr) {
        return new q(this, mVar, mVar2, mVarArr, 2);
    }

    @Override // p7.h
    public final m j(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f5221j.bitLength();
    }

    @Override // p7.h
    public final r m() {
        return this.f5223i;
    }

    @Override // p7.d, p7.h
    public final m r(SecureRandom secureRandom) {
        int i8;
        int i9;
        int[] iArr = new int[8];
        do {
            byte[] bArr = new byte[32];
            do {
                secureRandom.nextBytes(bArr);
                Pack.littleEndianToInt(bArr, 0, iArr, 0, 8);
            } while (f.n0(8, iArr, b.f5224a) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 8; i8++) {
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
        return f5221j;
    }
}
