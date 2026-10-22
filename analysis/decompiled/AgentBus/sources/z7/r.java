package z7;

/* loaded from: classes.dex */
public final class r extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f8.c f11943g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f11944h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(f8.c cVar, int i2) {
        super(0);
        this.f11943g = cVar;
        this.f11944h = i2;
    }

    @Override // p7.a
    public final Object c() {
        Object obj = this.f11943g.x0().get(this.f11944h);
        q7.k.d(obj, "descriptor.valueParameters[i]");
        return (f8.j0) obj;
    }
}
