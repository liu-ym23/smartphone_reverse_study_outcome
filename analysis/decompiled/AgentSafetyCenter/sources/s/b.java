package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f10941c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10942f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Object obj, nb.c cVar2) {
        super(1, cVar2);
        this.f10941c = cVar;
        this.f10942f = obj;
    }

    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        return new b(this.f10941c, this.f10942f, cVar);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        b bVar = (b) create((nb.c) obj);
        jb.v vVar = jb.v.f6774a;
        bVar.invokeSuspend(vVar);
        return vVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        c cVar = this.f10941c;
        c.b(cVar);
        Object objA = c.a(cVar, this.f10942f);
        cVar.f10959c.f11021f.setValue(objA);
        cVar.f10961e.setValue(objA);
        return jb.v.f6774a;
    }
}
