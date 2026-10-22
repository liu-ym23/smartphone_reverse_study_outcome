package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class y0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5380k = {new w0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5381j;

    public y0() {
        super(571, 2, 5, 10);
        this.f5381j = new p7.p(this, null, null, 17);
        this.f4798b = new w0(BigInteger.valueOf(0L));
        this.f4799c = new w0(BigInteger.valueOf(1L));
        this.d = new BigInteger(1, Hex.decodeStrict("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.f4800e = BigInteger.valueOf(4L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new y0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 18];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.s(i9, ((w0) rVar.f4818b).f5372g, jArr);
            x.e.s(i9 + 9, ((w0) rVar.f4819c).f5372g, jArr);
            i9 += 18;
        }
        return new x0(this, i8, jArr, 0);
    }

    @Override // p7.h
    public final p7.n c() {
        return new p7.s(2);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 17);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 17);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new w0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 571;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5381j;
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
