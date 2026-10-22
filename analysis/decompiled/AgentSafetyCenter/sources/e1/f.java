package e1;

import d1.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends g {

    /* renamed from: e, reason: collision with root package name */
    public q f3366e;

    /* renamed from: f, reason: collision with root package name */
    public q f3367f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f3368g;

    @Override // e1.g
    public final long a(long j10) {
        float fI = d1.p.i(j10);
        float fH = d1.p.h(j10);
        float f5 = d1.p.f(j10);
        float fE = d1.p.e(j10);
        q qVar = this.f3366e;
        float fB = (float) qVar.f3404p.b(fI);
        m mVar = qVar.f3404p;
        float fB2 = (float) mVar.b(fH);
        float fB3 = (float) mVar.b(f5);
        float[] fArr = this.f3368g;
        float f10 = (fArr[6] * fB3) + (fArr[3] * fB2) + (fArr[0] * fB);
        float f11 = (fArr[7] * fB3) + (fArr[4] * fB2) + (fArr[1] * fB);
        float f12 = (fArr[8] * fB3) + (fArr[5] * fB2) + (fArr[2] * fB);
        q qVar2 = this.f3367f;
        float fB4 = (float) qVar2.f3401m.b(f10);
        m mVar2 = qVar2.f3401m;
        return f0.a(fB4, (float) mVar2.b(f11), (float) mVar2.b(f12), fE, qVar2);
    }
}
