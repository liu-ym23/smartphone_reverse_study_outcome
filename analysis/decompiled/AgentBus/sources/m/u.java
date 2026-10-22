package m;

import i1.h0;

/* loaded from: classes.dex */
public final class u extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6101g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f6102h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f6103i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6104j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6105k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Object obj, long j2, long j4, Object obj2, int i2) {
        super(1);
        this.f6101g = i2;
        this.f6104j = obj;
        this.f6102h = j2;
        this.f6103i = j4;
        this.f6105k = obj2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f6101g) {
            case 0:
                g1.r rVar = (g1.r) obj;
                g1.s sVar = (g1.s) this.f6104j;
                long j2 = this.f6102h;
                long j4 = this.f6103i;
                q qVar = (q) this.f6105k;
                rVar.getClass();
                g1.r.a(rVar, sVar);
                sVar.M(d2.i.c(((((int) (j2 >> 32)) + ((int) (j4 >> 32))) << 32) | ((((int) (j2 & 4294967295L)) + ((int) (j4 & 4294967295L))) & 4294967295L), sVar.f3760j), 0.0f, qVar);
                break;
            default:
                h0 h0Var = (h0) obj;
                h0Var.a();
                u0.z zVar = (u0.z) this.f6104j;
                w0.c cVar = (w0.c) this.f6105k;
                long j10 = (104 & 2) != 0 ? 0L : this.f6102h;
                long jY = (104 & 4) != 0 ? w0.d.Y(h0Var.f4489f.d(), j10) : this.f6103i;
                float f10 = (104 & 8) != 0 ? 1.0f : 0.0f;
                if ((104 & 16) != 0) {
                    cVar = w0.f.f10635b;
                }
                w0.b bVar = h0Var.f4489f;
                int i2 = (int) (j10 >> 32);
                int i10 = (int) (j10 & 4294967295L);
                bVar.f10629f.f10627c.l(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (jY >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (jY & 4294967295L)) + Float.intBitsToFloat(i10), bVar.b(zVar, cVar, f10, null, 3));
                break;
        }
        return c7.r.f1986a;
    }
}
