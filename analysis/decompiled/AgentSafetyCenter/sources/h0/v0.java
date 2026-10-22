package h0;

import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5205c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f1.g f5206f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r2 f5207g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r2 f5208h;
    public final /* synthetic */ r2 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r2 f5209j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ float f5210k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5211l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(long j10, f1.g gVar, s.c0 c0Var, s.c0 c0Var2, s.c0 c0Var3, s.c0 c0Var4, float f5, long j11) {
        super(1);
        this.f5205c = j10;
        this.f5206f = gVar;
        this.f5207g = c0Var;
        this.f5208h = c0Var2;
        this.i = c0Var3;
        this.f5209j = c0Var4;
        this.f5210k = f5;
        this.f5211l = j11;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        float f5;
        f1.d dVar = (f1.d) obj;
        long j10 = this.f5205c;
        f1.g gVar = this.f5206f;
        z0.b(dVar, 0.0f, 360.0f, j10, gVar);
        float fFloatValue = (((Number) this.f5207g.getValue()).floatValue() * 216.0f) % 360.0f;
        float fFloatValue2 = ((Number) this.f5208h.getValue()).floatValue();
        r2 r2Var = this.i;
        float fAbs = Math.abs(fFloatValue2 - ((Number) r2Var.getValue()).floatValue());
        float fFloatValue3 = ((Number) r2Var.getValue()).floatValue() + ((Number) this.f5209j.getValue()).floatValue() + (fFloatValue - 90.0f);
        if (gVar.f3867g == 0) {
            f5 = 0.0f;
        } else {
            f5 = ((this.f5210k / (z0.f5270b / 2)) * 57.29578f) / 2.0f;
        }
        z0.b(dVar, fFloatValue3 + f5, Math.max(fAbs, 0.1f), this.f5211l, gVar);
        return jb.v.f6774a;
    }
}
