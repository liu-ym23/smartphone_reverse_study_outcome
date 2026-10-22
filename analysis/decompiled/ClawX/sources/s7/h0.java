package s7;

import java.math.BigInteger;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public final class h0 extends p7.c {

    /* renamed from: k, reason: collision with root package name */
    public static final p7.m[] f5308k = {new e0(p7.a.f4758b)};

    /* renamed from: j, reason: collision with root package name */
    public final p7.p f5309j;

    public h0() {
        super(163, 3, 6, 7);
        this.f5309j = new p7.p(this, null, null, 7);
        this.f4798b = new e0(BigInteger.valueOf(1L));
        this.f4799c = new e0(new BigInteger(1, Hex.decodeStrict("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.d = new BigInteger(1, Hex.decodeStrict("040000000000000000000292FE77E70C12A4234C33"));
        this.f4800e = BigInteger.valueOf(2L);
        this.f4801f = 6;
    }

    @Override // p7.h
    public final p7.h a() {
        return new h0();
    }

    @Override // p7.h
    public final p7.d0 b(p7.r[] rVarArr, int i8) {
        long[] jArr = new long[i8 * 6];
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            p7.r rVar = rVarArr[i10];
            x.e.q(i9, ((e0) rVar.f4818b).f5296g, jArr);
            x.e.q(i9 + 3, ((e0) rVar.f4819c).f5296g, jArr);
            i9 += 6;
        }
        return new q7.a(this, i8, jArr, 20);
    }

    @Override // p7.h
    public final p7.r e(p7.m mVar, p7.m mVar2) {
        return new p7.p(this, mVar, mVar2, 7);
    }

    @Override // p7.h
    public final p7.r f(p7.m mVar, p7.m mVar2, p7.m[] mVarArr) {
        return new p7.p(this, mVar, mVar2, mVarArr, 7);
    }

    @Override // p7.h
    public final p7.m j(BigInteger bigInteger) {
        return new e0(bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return 163;
    }

    @Override // p7.h
    public final p7.r m() {
        return this.f5309j;
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
