package o;

/* loaded from: classes.dex */
public final class l extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t0.c f7077g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q7.v f7078h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f7079i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u0.i f7080j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(t0.c cVar, q7.v vVar, long j2, u0.i iVar) {
        super(1);
        this.f7077g = cVar;
        this.f7078h = vVar;
        this.f7079i = j2;
        this.f7080j = iVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) throws Throwable {
        w0.b bVar;
        i1.h0 h0Var = (i1.h0) obj;
        h0Var.a();
        t0.c cVar = this.f7077g;
        float f10 = cVar.f9656a;
        float f11 = cVar.f9657b;
        q7.v vVar = this.f7078h;
        long j2 = this.f7079i;
        u0.i iVar = this.f7080j;
        w0.b bVar2 = h0Var.f4489f;
        ((o4.d0) bVar2.f10630g.f10129a).S(f10, f11);
        try {
            bVar = bVar2;
            try {
                bVar2.f10629f.f10627c.n((u0.d) vVar.f8820f, j2, j2, bVar2.b(null, w0.f.f10635b, 1.0f, iVar, 3));
                ((o4.d0) bVar.f10630g.f10129a).S(-f10, -f11);
                return c7.r.f1986a;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                ((o4.d0) bVar.f10630g.f10129a).S(-f10, -f11);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bVar = bVar2;
        }
    }
}
