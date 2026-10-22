package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class n0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5334k = {new l0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5335j;

    public n0() {
        super(233, 74, 0, 0);
        this.f5335j = new p7.p(this, null, null, 11);
        this.f4798b = new l0(BigInteger.valueOf(1L));
        this.f4799c = new l0(new BigInteger(1, Hex.decodeStrict("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.d = new BigInteger(1, Hex.decodeStrict("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new n0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 8];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.r(i9, ((l0) rVar.f4818b).f5325g, jArr);
            x.e.r(i9 + 4, ((l0) rVar.f4819c).f5325g, jArr);
            i9 += 8;
        }
        return new q7.a(this, i8, jArr, 24);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 11);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 11);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new l0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 233;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5335j;
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
