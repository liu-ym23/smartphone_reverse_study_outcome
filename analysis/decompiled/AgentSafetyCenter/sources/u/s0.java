package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f13578c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t0 f13579f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float f13580g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f13581h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(t0 t0Var, float f5, float f10, nb.c cVar) {
        super(2, cVar);
        this.f13579f = t0Var;
        this.f13580g = f5;
        this.f13581h = f10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new s0(this.f13579f, this.f13580g, this.f13581h, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.f13578c;
        if (i == 0) {
            id.c.I(obj);
            z0 z0Var = this.f13579f.H;
            long jD = id.k.d(this.f13580g, this.f13581h);
            this.f13578c = 1;
            if (androidx.compose.foundation.gestures.a.a(z0Var, jD, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return jb.v.f6774a;
    }
}
