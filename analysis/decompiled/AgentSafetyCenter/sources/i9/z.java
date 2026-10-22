package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ y3.b f5930c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f5931f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(b0 b0Var, nb.c cVar) {
        super(3, cVar);
        this.f5931f = b0Var;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        z zVar = new z(this.f5931f, (nb.c) obj3);
        zVar.f5930c = (y3.b) obj;
        return zVar.invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        y3.b bVar = this.f5930c;
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        return this.f5931f.b(bVar);
    }
}
