package v0;

import u0.z;

/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: e, reason: collision with root package name */
    public final q f10297e;

    /* renamed from: f, reason: collision with root package name */
    public final q f10298f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f10299g;

    public f(q qVar, q qVar2) {
        float[] fArrG;
        super(qVar2, qVar, qVar2, null);
        this.f10297e = qVar;
        this.f10298f = qVar2;
        float[] fArr = a.f10262b.f10263a;
        s sVar = qVar.f10324d;
        float[] fArr2 = qVar.f10329i;
        s sVar2 = qVar2.f10324d;
        float[] fArr3 = qVar2.f10330j;
        if (j.d(sVar, sVar2)) {
            fArrG = j.g(fArr3, fArr2);
        } else {
            float[] fArrA = sVar.a();
            float[] fArrA2 = sVar2.a();
            s sVar3 = j.f10306b;
            fArrG = j.g(j.d(sVar2, sVar3) ? fArr3 : j.f(j.g(j.c(fArr, fArrA2, new float[]{0.964212f, 1.0f, 0.825188f}), qVar2.f10329i)), j.d(sVar, sVar3) ? fArr2 : j.g(j.c(fArr, fArrA, new float[]{0.964212f, 1.0f, 0.825188f}), fArr2));
        }
        this.f10299g = fArrG;
    }

    @Override // v0.g
    public final long a(long j2) {
        float fH = u0.m.h(j2);
        float fG = u0.m.g(j2);
        float fE = u0.m.e(j2);
        float fD = u0.m.d(j2);
        m mVar = this.f10297e.f10336p;
        float fB = (float) mVar.b(fH);
        float fB2 = (float) mVar.b(fG);
        float fB3 = (float) mVar.b(fE);
        float[] fArr = this.f10299g;
        float f10 = (fArr[6] * fB3) + (fArr[3] * fB2) + (fArr[0] * fB);
        float f11 = (fArr[7] * fB3) + (fArr[4] * fB2) + (fArr[1] * fB);
        float f12 = (fArr[8] * fB3) + (fArr[5] * fB2) + (fArr[2] * fB);
        q qVar = this.f10298f;
        float fB4 = (float) qVar.f10333m.b(f10);
        m mVar2 = qVar.f10333m;
        return z.a(fB4, (float) mVar2.b(f11), (float) mVar2.b(f12), fD, qVar);
    }
}
