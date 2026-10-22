package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class a0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5258k = {new y(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5259j;

    public a0() {
        super(113, 9, 0, 0);
        this.f5259j = new p7.p(this, null, null, 2);
        this.f4798b = new y(new BigInteger(1, Hex.decodeStrict("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.f4799c = new y(new BigInteger(1, Hex.decodeStrict("0095E9A9EC9B297BD4BF36E059184F")));
        this.d = new BigInteger(1, Hex.decodeStrict("010000000000000108789B2496AF93"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new a0();
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
        return new q7.a(this, i8, jArr, 15);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 2);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 2);
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
        return this.f5259j;
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
