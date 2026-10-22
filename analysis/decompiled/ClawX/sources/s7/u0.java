package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class u0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5363k = {new t0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5364j;

    public u0() {
        super(409, 87, 0, 0);
        this.f5364j = new p7.p(this, null, null, 15);
        this.f4798b = new t0(BigInteger.valueOf(0L));
        this.f4799c = new t0(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, Hex.decodeStrict("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.f4800e = BigInteger.valueOf(4L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new u0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 14];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.f.z(i9, ((t0) rVar.f4818b).f5359g, jArr);
            x.f.z(i9 + 7, ((t0) rVar.f4819c).f5359g, jArr);
            i9 += 14;
        }
        return new q7.a(this, i8, jArr, 28);
    }

    @Override // p7.h
    public final p7.n c() {
        return new p7.s(2);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 15);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 15);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new t0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 409;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5364j;
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 6;
    }

    @Override // p7.c
    public final boolean u() {
        return true;
    }
}
