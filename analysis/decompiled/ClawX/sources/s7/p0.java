package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class p0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5342k = {new o0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5343j;

    public p0() {
        super(239, 158, 0, 0);
        this.f5343j = new p7.p(this, null, null, 12);
        this.f4798b = new o0(BigInteger.valueOf(0L));
        this.f4799c = new o0(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, Hex.decodeStrict("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.f4800e = BigInteger.valueOf(4L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new p0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 8];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.r(i9, ((o0) rVar.f4818b).f5339g, jArr);
            x.e.r(i9 + 4, ((o0) rVar.f4819c).f5339g, jArr);
            i9 += 8;
        }
        return new q7.a(this, i8, jArr, 25);
    }

    @Override // p7.h
    public final p7.n c() {
        return new p7.s(2);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 12);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 12);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new o0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 239;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5343j;
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
