package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11968c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11969f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11970g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11971h;
    public final /* synthetic */ k0.c1 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11972j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(k0.c1 c1Var, k0.c1 c1Var2, k0.c1 c1Var3, k0.c1 c1Var4, k0.c1 c1Var5, k0.c1 c1Var6, nb.c cVar) {
        super(2, cVar);
        this.f11968c = c1Var;
        this.f11969f = c1Var2;
        this.f11970g = c1Var3;
        this.f11971h = c1Var4;
        this.i = c1Var5;
        this.f11972j = c1Var6;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new t0(this.f11968c, this.f11969f, this.f11970g, this.f11971h, this.i, this.f11972j, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t0 t0Var = (t0) create((kc.t) obj, (nb.c) obj2);
        jb.v vVar = jb.v.f6774a;
        t0Var.invokeSuspend(vVar);
        return vVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        float f5 = w0.f12043g;
        if (((Integer) this.f11968c.getValue()) != null) {
            k0.c1 c1Var = this.f11970g;
            k0.c1 c1Var2 = this.f11971h;
            k0.c1 c1Var3 = this.f11969f;
            w0.q(c1Var3, c1Var, c1Var2);
            w0.r(c1Var3, this.i, this.f11972j);
        }
        return jb.v.f6774a;
    }
}
