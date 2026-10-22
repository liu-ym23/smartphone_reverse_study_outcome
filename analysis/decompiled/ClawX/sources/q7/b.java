package q7;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;
import p7.d0;
import p7.h;
import p7.m;
import p7.q;
import p7.r;
import x.e;
import x.f;

/* loaded from: classes.dex */
public final class b extends p7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f4893j = d.f4900h;

    /* renamed from: k, reason: collision with root package name */
    public static final BigInteger f4894k;

    /* renamed from: l, reason: collision with root package name */
    public static final BigInteger f4895l;

    /* renamed from: m, reason: collision with root package name */
    public static final m[] f4896m;

    /* renamed from: i, reason: collision with root package name */
    public final q f4897i;

    static {
        BigInteger bigInteger = new BigInteger(1, Hex.decodeStrict("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        f4894k = bigInteger;
        f4895l = new BigInteger(1, Hex.decodeStrict("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        f4896m = new m[]{new d(p7.a.f4758b), new d(bigInteger)};
    }

    public b() {
        super(f4893j);
        m mVar = null;
        this.f4897i = new q(this, mVar, mVar, 1);
        this.f4798b = new d(f4894k);
        this.f4799c = new d(f4895l);
        this.d = new BigInteger(1, Hex.decodeStrict("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.f4800e = BigInteger.valueOf(8L);
        this.f4801f = 4;
    }

    @Override // p7.h
    public final h a() {
        return new b();
    }

    @Override // p7.h
    public final d0 b(r[] rVarArr, int i8) {
        int[] iArr = new int[i8 * 16];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            r rVar = rVarArr[i10];
            e.n(i9, ((d) rVar.f4818b).f4902g, iArr);
            e.n(i9 + 8, ((d) rVar.f4819c).f4902g, iArr);
            i9 += 16;
        }
        return new a(this, i8, iArr, 0);
    }

    @Override // p7.h
    public final r e(m mVar, m mVar2) {
        return new q(this, mVar, mVar2, 1);
    }

    @Override // p7.h
    public final r f(m mVar, m mVar2, m[] mVarArr) {
        return new q(this, mVar, mVar2, mVarArr, 1);
    }

    @Override // p7.h
    public final m j(BigInteger bigInteger) {
        return new d(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return f4893j.bitLength();
    }

    @Override // p7.h
    public final r m() {
        return this.f4897i;
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
                iArr[7] = iArr[7] & Integer.MAX_VALUE;
            } while (f.n0(8, iArr, c.f4898a) == 0);
            i9 = 0;
            for (i8 = 0; i8 < 8; i8++) {
                i9 |= iArr[i8];
            }
        } while (((((i9 & 1) | (i9 >>> 1)) - 1) >> 31) != 0);
        return new d(iArr);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 4;
    }

    @Override // p7.d
    public final BigInteger u() {
        return f4893j;
    }
}
