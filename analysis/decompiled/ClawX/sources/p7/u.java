package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class u extends d0 {

    /* renamed from: e, reason: collision with root package name */
    public final h f4825e;

    /* renamed from: f, reason: collision with root package name */
    public final t7.b f4826f;

    public u(h hVar, t7.b bVar) {
        if (hVar.d == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.f4825e = hVar;
        this.f4826f = bVar;
    }

    @Override // p7.d0
    public final r n(r rVar, BigInteger bigInteger) {
        h hVar = rVar.f4817a;
        h hVar2 = rVar.f4817a;
        if (!this.f4825e.i(hVar)) {
            throw new IllegalStateException();
        }
        BigInteger bigIntegerMod = bigInteger.mod(hVar2.d);
        t7.b bVar = this.f4826f;
        BigInteger[] bigIntegerArrA = bVar.a(bigIntegerMod);
        BigInteger bigInteger2 = bigIntegerArrA[0];
        BigInteger bigInteger3 = bigIntegerArrA[1];
        boolean z = bigInteger2.signum() < 0;
        boolean z2 = bigInteger3.signum() < 0;
        BigInteger bigIntegerAbs = bigInteger2.abs();
        BigInteger bigIntegerAbs2 = bigInteger3.abs();
        b0 b0VarO = d0.o(d0.g(Math.max(bigIntegerAbs.bitLength(), bigIntegerAbs2.bitLength()), 8, d0.f4776a), rVar);
        r rVar2 = ((t7.a) hVar2.q(rVar, "bc_endo", new androidx.emoji2.text.p(bVar, 19, rVar))).f5601b;
        b0 b0Var = (b0) rVar2.f4817a.q(rVar2, "bc_wnaf", new androidx.emoji2.text.p(b0VarO, 16, bVar.f5603b));
        int iMin = Math.min(8, b0VarO.f4773f);
        int iMin2 = Math.min(8, b0Var.f4773f);
        return d0.i(z ? b0VarO.d : b0VarO.f4771c, z ? b0VarO.f4771c : b0VarO.d, d0.c(iMin, bigIntegerAbs), z2 ? b0Var.d : b0Var.f4771c, z2 ? b0Var.f4771c : b0Var.d, d0.c(iMin2, bigIntegerAbs2));
    }
}
