package p7;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: l, reason: collision with root package name */
    public static final Set f4792l = Collections.synchronizedSet(new HashSet());

    /* renamed from: m, reason: collision with root package name */
    public static final BigIntegers.Cache f4793m = new BigIntegers.Cache();

    /* renamed from: i, reason: collision with root package name */
    public BigInteger f4794i;

    /* renamed from: j, reason: collision with root package name */
    public BigInteger f4795j;

    /* renamed from: k, reason: collision with root package name */
    public q f4796k;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(java.math.BigInteger r9, java.math.BigInteger r10, java.math.BigInteger r11, java.math.BigInteger r12, java.math.BigInteger r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.g.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, boolean):void");
    }

    @Override // p7.h
    public final h a() {
        BigInteger bigInteger = this.f4794i;
        BigInteger bigInteger2 = this.f4795j;
        m mVar = this.f4798b;
        m mVar2 = this.f4799c;
        BigInteger bigInteger3 = this.d;
        BigInteger bigInteger4 = this.f4800e;
        g gVar = new g(bigInteger);
        gVar.f4794i = bigInteger;
        gVar.f4795j = bigInteger2;
        m mVar3 = null;
        gVar.f4796k = new q(gVar, mVar3, mVar3, 0);
        gVar.f4798b = mVar;
        gVar.f4799c = mVar2;
        gVar.d = bigInteger3;
        gVar.f4800e = bigInteger4;
        gVar.f4801f = 4;
        return gVar;
    }

    @Override // p7.h
    public final r e(m mVar, m mVar2) {
        return new q(this, mVar, mVar2, 0);
    }

    @Override // p7.h
    public final r f(m mVar, m mVar2, m[] mVarArr) {
        return new q(this, mVar, mVar2, mVarArr, 0);
    }

    @Override // p7.h
    public final m j(BigInteger bigInteger) {
        BigInteger bigInteger2 = this.f4794i;
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(bigInteger2) >= 0) {
            throw new IllegalArgumentException("x value invalid for Fp field element");
        }
        return new l(bigInteger2, this.f4795j, bigInteger);
    }

    @Override // p7.h
    public final int l() {
        return this.f4794i.bitLength();
    }

    @Override // p7.h
    public final r m() {
        return this.f4796k;
    }

    @Override // p7.h
    public final r n(r rVar) {
        int i8;
        return (this == rVar.f4817a || this.f4801f != 2 || rVar.k() || !((i8 = rVar.f4817a.f4801f) == 2 || i8 == 3 || i8 == 4)) ? super.n(rVar) : new q(this, j(rVar.f4818b.t()), j(rVar.f4819c.t()), new m[]{j(rVar.d[0].t())}, 0);
    }

    @Override // p7.h
    public final boolean s(int i8) {
        return i8 == 0 || i8 == 1 || i8 == 2 || i8 == 4;
    }

    @Override // p7.d
    public final BigInteger u() {
        return this.f4794i;
    }
}
