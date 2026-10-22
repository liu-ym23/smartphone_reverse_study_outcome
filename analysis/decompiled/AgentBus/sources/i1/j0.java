package i1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class j0 implements d2.c {

    /* renamed from: f, reason: collision with root package name */
    public boolean f4509f;

    /* renamed from: g, reason: collision with root package name */
    public long f4510g = 9223372034707292159L;

    /* renamed from: h, reason: collision with root package name */
    public long f4511h = 0;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ m0 f4512i;

    public j0(m0 m0Var) {
        this.f4512i = m0Var;
    }

    public final void a(g1.h hVar, float f10) {
        m0 m0Var = this.f4512i;
        eb.p pVar = m0Var.f4534r;
        if (pVar == null) {
            pVar = new eb.p();
            m0Var.f4534r = pVar;
        }
        int iL0 = d7.n.l0((g1.h[]) pVar.f3319b, hVar);
        if (iL0 >= 0) {
            float[] fArr = (float[]) pVar.f3320c;
            if (fArr[iL0] != f10) {
                fArr[iL0] = f10;
                ((byte[]) pVar.f3321d)[iL0] = 1;
                return;
            } else {
                byte[] bArr = (byte[]) pVar.f3321d;
                if (bArr[iL0] == 2) {
                    bArr[iL0] = 0;
                    return;
                }
                return;
            }
        }
        int i2 = pVar.f3318a;
        g1.h[] hVarArr = (g1.h[]) pVar.f3319b;
        if (i2 == hVarArr.length) {
            int i10 = i2 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(hVarArr, i10);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            pVar.f3319b = (g1.h[]) objArrCopyOf;
            float[] fArrCopyOf = Arrays.copyOf((float[]) pVar.f3320c, i10);
            q7.k.d(fArrCopyOf, "copyOf(...)");
            pVar.f3320c = fArrCopyOf;
            byte[] bArrCopyOf = Arrays.copyOf((byte[]) pVar.f3321d, i10);
            q7.k.d(bArrCopyOf, "copyOf(...)");
            pVar.f3321d = bArrCopyOf;
        }
        ((g1.h[]) pVar.f3319b)[i2] = hVar;
        ((byte[]) pVar.f3321d)[i2] = 3;
        ((float[]) pVar.f3320c)[i2] = f10;
        pVar.f3318a++;
    }

    @Override // d2.c
    public final float c() {
        return this.f4512i.c();
    }

    @Override // d2.c
    public final float j() {
        return this.f4512i.j();
    }
}
