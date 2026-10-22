package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class c0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5286k = {new b0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5287j;

    public c0() {
        super(131, 2, 3, 8);
        this.f5287j = new p7.p(this, null, null, 3);
        this.f4798b = new b0(new BigInteger(1, Hex.decodeStrict("07A11B09A76B562144418FF3FF8C2570B8")));
        this.f4799c = new b0(new BigInteger(1, Hex.decodeStrict("0217C05610884B63B9C6C7291678F9D341")));
        this.d = new BigInteger(1, Hex.decodeStrict("0400000000000000023123953A9464B54D"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new c0();
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
        return new q7.a(this, i8, jArr, 16);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 3);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 3);
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
        return this.f5287j;
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
