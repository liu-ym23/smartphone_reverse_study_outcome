package n;

/* loaded from: classes.dex */
public final class b extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f6539f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d2.f f6540g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, d2.f fVar, g7.d dVar) {
        super(1, dVar);
        this.f6539f = cVar;
        this.f6540g = fVar;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        return new b(this.f6539f, this.f6540g, dVar);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        b bVar = (b) create((g7.d) obj);
        c7.r rVar = c7.r.f1986a;
        bVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        w7.e0.N(obj);
        c cVar = this.f6539f;
        i iVar = cVar.f6559c;
        iVar.f6633h.d();
        iVar.f6634i = Long.MIN_VALUE;
        cVar.f6560d.setValue(Boolean.FALSE);
        Object objA = c.a(cVar, this.f6540g);
        iVar.f6632g.setValue(objA);
        cVar.f6561e.setValue(objA);
        return c7.r.f1986a;
    }
}
