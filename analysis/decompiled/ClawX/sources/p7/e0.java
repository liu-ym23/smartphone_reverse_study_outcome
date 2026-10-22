package p7;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class e0 implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f4784a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte f4785b;

    public e0(p pVar, byte b9) {
        this.f4784a = pVar;
        this.f4785b = b9;
    }

    @Override // p7.w
    public final x e(x xVar) {
        if (xVar instanceof f0) {
            return xVar;
        }
        f0 f0Var = new f0();
        f0Var.f4791a = null;
        BigInteger bigInteger = z.f4832a;
        p pVar = this.f4784a;
        r rVarN = pVar.n();
        h hVar = pVar.f4817a;
        p pVar2 = (p) rVarN;
        byte[][] bArr = this.f4785b == 0 ? z.d : z.f4836f;
        int length = (bArr.length + 1) >>> 1;
        p[] pVarArr = new p[length];
        pVarArr[0] = pVar;
        int length2 = bArr.length;
        for (int i8 = 3; i8 < length2; i8 += 2) {
            int i9 = i8 >>> 1;
            byte[] bArr2 = bArr[i8];
            p pVarE = (p) hVar.m();
            int i10 = 0;
            for (int length3 = bArr2.length - 1; length3 >= 0; length3--) {
                i10++;
                byte b9 = bArr2[length3];
                if (b9 != 0) {
                    pVarE = (p) pVarE.E(i10).a(b9 > 0 ? pVar : pVar2);
                    i10 = 0;
                }
            }
            if (i10 > 0) {
                pVarE = pVarE.E(i10);
            }
            pVarArr[i9] = pVarE;
        }
        hVar.getClass();
        hVar.p(pVarArr, 0, length, null);
        f0Var.f4791a = pVarArr;
        return f0Var;
    }
}
