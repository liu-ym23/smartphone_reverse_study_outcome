package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public int f13477f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f13478g;

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        h1 h1Var = new h1(cVar);
        h1Var.f13478g = obj;
        return h1Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h1) create((o1.h0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f13477f;
        if (i != 0) {
            if (i == 1) {
                id.c.I(obj);
                return obj;
            }
            od.f.e("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        id.c.I(obj);
        o1.h0 h0Var = (o1.h0) this.f13478g;
        this.f13477f = 1;
        b0 b0Var = l1.f13522a;
        Object objD = l1.d(h0Var, o1.k.f9060f, this);
        return objD == aVar ? aVar : objD;
    }
}
