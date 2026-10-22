package y;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f11512g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f11513h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(float f10, long j2) {
        super(1);
        this.f11512g = f10;
        this.f11513h = j2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        w0.d dVar = (w0.d) obj;
        float f10 = this.f11512g;
        float f11 = 2;
        dVar.L(this.f11513h, n7.b.b(0.0f, dVar.o(f10) / f11), n7.b.b(t0.e.d(dVar.d()), dVar.o(f10) / f11), dVar.o(f10));
        return c7.r.f1986a;
    }
}
