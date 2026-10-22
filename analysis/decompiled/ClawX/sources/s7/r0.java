package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class r0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5350k = {new q0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5351j;

    public r0() {
        super(283, 5, 7, 12);
        this.f5351j = new p7.p(this, null, null, 13);
        this.f4798b = new q0(BigInteger.valueOf(0L));
        this.f4799c = new q0(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.f4800e = BigInteger.valueOf(4L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new r0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 10];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.f.y(i9, ((q0) rVar.f4818b).f5347g, jArr);
            x.f.y(i9 + 5, ((q0) rVar.f4819c).f5347g, jArr);
            i9 += 10;
        }
        return new q7.a(this, i8, jArr, 26);
    }

    @Override // p7.h
    public final p7.n c() {
        return new p7.s(2);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 13);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 13);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new q0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 283;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5351j;
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
