package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class k0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5321k = {new i0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5322j;

    public k0() {
        super(193, 15, 0, 0);
        this.f5322j = new p7.p(this, null, null, 9);
        this.f4798b = new i0(new BigInteger(1, Hex.decodeStrict("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f4799c = new i0(new BigInteger(1, Hex.decodeStrict("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.d = new BigInteger(1, Hex.decodeStrict("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new k0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 8];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.r(i9, ((i0) rVar.f4818b).f5313g, jArr);
            x.e.r(i9 + 4, ((i0) rVar.f4819c).f5313g, jArr);
            i9 += 8;
        }
        return new q7.a(this, i8, jArr, 22);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 9);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 9);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new i0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 193;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5322j;
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
