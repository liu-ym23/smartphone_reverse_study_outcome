package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class v0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5367k = {new t0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5368j;

    public v0() {
        super(409, 87, 0, 0);
        this.f5368j = new p7.p(this, null, null, 16);
        this.f4798b = new t0(BigInteger.valueOf(1L));
        this.f4799c = new t0(new BigInteger(1, Hex.decodeStrict("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.d = new BigInteger(1, Hex.decodeStrict("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new v0();
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
        return new q7.a(this, i8, jArr, 29);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 16);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 16);
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
        return this.f5368j;
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
