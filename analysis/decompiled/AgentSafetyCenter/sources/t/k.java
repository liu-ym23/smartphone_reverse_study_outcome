package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c1.c f13022c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ yb.u f13023f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f13024g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d1.l f13025h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c1.c cVar, yb.u uVar, long j10, d1.l lVar) {
        super(1);
        this.f13022c = cVar;
        this.f13023f = uVar;
        this.f13024g = j10;
        this.f13025h = lVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        u1.i0 i0Var = (u1.i0) obj;
        i0Var.b();
        c1.c cVar = this.f13022c;
        float f5 = cVar.f2167a;
        float f10 = cVar.f2168b;
        yb.u uVar = this.f13023f;
        long j10 = this.f13024g;
        d1.l lVar = this.f13025h;
        f1.b bVar = i0Var.f13838c;
        ((a1.g) bVar.f3859f.f9741f).z(f5, f10);
        try {
            f1.d.r(i0Var, (d1.e) uVar.f16098c, j10, 0L, 0.0f, lVar, 0, 890);
            ((a1.g) bVar.f3859f.f9741f).z(-f5, -f10);
            return jb.v.f6774a;
        } catch (Throwable th) {
            ((a1.g) bVar.f3859f.f9741f).z(-f5, -f10);
            throw th;
        }
    }
}
