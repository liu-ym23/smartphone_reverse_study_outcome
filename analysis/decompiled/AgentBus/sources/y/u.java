package y;

import b0.b3;

/* loaded from: classes.dex */
public final class u extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f11521g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ w0.g f11522h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ b3 f11523i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b3 f11524j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b3 f11525k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b3 f11526l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ float f11527m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f11528n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(long j2, w0.g gVar, n.a0 a0Var, n.a0 a0Var2, n.a0 a0Var3, n.a0 a0Var4, float f10, long j4) {
        super(1);
        this.f11521g = j2;
        this.f11522h = gVar;
        this.f11523i = a0Var;
        this.f11524j = a0Var2;
        this.f11525k = a0Var3;
        this.f11526l = a0Var4;
        this.f11527m = f10;
        this.f11528n = j4;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        float f10;
        w0.d dVar = (w0.d) obj;
        long j2 = this.f11521g;
        w0.g gVar = this.f11522h;
        y.b(dVar, 0.0f, 360.0f, j2, gVar);
        float fFloatValue = (((Number) this.f11523i.getValue()).floatValue() * 216.0f) % 360.0f;
        float fFloatValue2 = ((Number) this.f11524j.getValue()).floatValue();
        b3 b3Var = this.f11525k;
        float fAbs = Math.abs(fFloatValue2 - ((Number) b3Var.getValue()).floatValue());
        float fFloatValue3 = ((Number) b3Var.getValue()).floatValue() + ((Number) this.f11526l.getValue()).floatValue() + (fFloatValue - 90.0f);
        if (gVar.f10637c == 0) {
            f10 = 0.0f;
        } else {
            f10 = ((this.f11527m / (y.f11538b / 2)) * 57.29578f) / 2.0f;
        }
        y.b(dVar, fFloatValue3 + f10, Math.max(fAbs, 0.1f), this.f11528n, gVar);
        return c7.r.f1986a;
    }
}
