package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ float f10984c;

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        d0 d0Var = new d0(2, cVar);
        d0Var.f10984c = ((Number) obj).floatValue();
        return d0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d0) create(Float.valueOf(((Number) obj).floatValue()), (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        return Boolean.valueOf(this.f10984c > 0.0f);
    }
}
