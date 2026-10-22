package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class d0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5291k = {new b0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5292j;

    public d0() {
        super(131, 2, 3, 8);
        this.f5292j = new p7.p(this, null, null, 4);
        this.f4798b = new b0(new BigInteger(1, Hex.decodeStrict("03E5A88919D7CAFCBF415F07C2176573B2")));
        this.f4799c = new b0(new BigInteger(1, Hex.decodeStrict("04B8266A46C55657AC734CE38F018F2192")));
        this.d = new BigInteger(1, Hex.decodeStrict("0400000000000000016954A233049BA98F"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new d0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 6];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.q(i9, ((b0) rVar.f4818b).f5283g, jArr);
            x.e.q(i9 + 3, ((b0) rVar.f4819c).f5283g, jArr);
            i9 += 6;
        }
        return new q7.a(this, i8, jArr, 17);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 4);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 4);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new b0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 131;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5292j;
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 6;
    }

    @Override // p7.c
    public final boolean u() {
        return false;
    }
}
