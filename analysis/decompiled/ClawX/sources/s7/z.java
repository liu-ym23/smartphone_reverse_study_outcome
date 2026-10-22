package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class z extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5382k = {new y(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5383j;

    public z() {
        super(113, 9, 0, 0);
        this.f5383j = new p7.p(this, null, null, 1);
        this.f4798b = new y(new BigInteger(1, Hex.decodeStrict("003088250CA6E7C7FE649CE85820F7")));
        this.f4799c = new y(new BigInteger(1, Hex.decodeStrict("00E8BEE4D3E2260744188BE0E9C723")));
        this.d = new BigInteger(1, Hex.decodeStrict("0100000000000000D9CCEC8A39E56F"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new z();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 4];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.o(i9, ((y) rVar.f4818b).f5379g, jArr);
            x.e.o(i9 + 2, ((y) rVar.f4819c).f5379g, jArr);
            i9 += 4;
        }
        return new q7.a(this, i8, jArr, 14);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 1);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 1);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new y(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 113;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5383j;
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
