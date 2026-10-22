package v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public int f14621c;

    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        return new e(1, cVar);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        e eVar = (e) create((nb.c) obj);
        jb.v vVar = jb.v.f6774a;
        eVar.invokeSuspend(vVar);
        return vVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f14621c;
        if (i == 0) {
            id.c.I(obj);
            this.f14621c = 1;
            throw null;
        }
        if (i == 1) {
            id.c.I(obj);
            return jb.v.f6774a;
        }
        od.f.e("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
