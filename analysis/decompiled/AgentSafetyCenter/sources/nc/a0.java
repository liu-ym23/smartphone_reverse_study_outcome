package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f8818c;

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        a0 a0Var = new a0(2, cVar);
        a0Var.f8818c = ((Number) obj).intValue();
        return a0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a0) create(Integer.valueOf(((Number) obj).intValue()), (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        return Boolean.valueOf(this.f8818c > 0);
    }
}
