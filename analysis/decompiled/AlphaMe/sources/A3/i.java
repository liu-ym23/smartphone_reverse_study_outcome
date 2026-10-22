package A3;

/* loaded from: classes2.dex */
public final class i implements x3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G3.d f96a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3.a f97b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t3.h f98c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f99d;

    public i(j jVar, G3.d dVar, x3.a aVar, G3.b bVar) {
        this.f99d = jVar;
        this.f96a = dVar;
        this.f97b = aVar;
        this.f98c = bVar;
    }

    @Override // x3.a
    public final void b() {
        G3.d dVar = this.f96a;
        if (dVar.a()) {
            return;
        }
        t3.h hVarB = this.f99d.b(this.f97b);
        dVar.b(hVarB);
        if (hVarB.getClass() == p.class) {
            ((p) hVarB).f125a.b(this.f98c);
        }
    }
}
