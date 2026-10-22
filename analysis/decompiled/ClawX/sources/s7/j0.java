package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class j0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5316k = {new i0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5317j;

    public j0() {
        super(193, 15, 0, 0);
        this.f5317j = new p7.p(this, null, null, 8);
        this.f4798b = new i0(new BigInteger(1, Hex.decodeStrict("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f4799c = new i0(new BigInteger(1, Hex.decodeStrict("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.d = new BigInteger(1, Hex.decodeStrict("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new j0();
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
        return new q7.a(this, i8, jArr, 21);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 8);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 8);
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
        return this.f5317j;
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
