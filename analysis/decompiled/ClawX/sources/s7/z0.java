package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class z0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5384k = {new w0(p7.a.f4758b)};

    /* renamed from: l, reason: collision with root package name */
    public static final w0 f5385l;

    /* renamed from: m, reason: collision with root package name */
    public static final w0 f5386m;

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5387j;

    static {
        w0 w0Var = new w0(new BigInteger(1, Hex.decodeStrict("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        f5385l = w0Var;
        f5386m = (w0) w0Var.n();
    }

    public z0() {
        super(571, 2, 5, 10);
        this.f5387j = new p7.p(this, null, null, 18);
        this.f4798b = new w0(BigInteger.valueOf(1L));
        this.f4799c = f5385l;
        this.d = new BigInteger(1, Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new z0();
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
        return new x0(this, i8, jArr, 1);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 18);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 18);
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
        return this.f5387j;
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
