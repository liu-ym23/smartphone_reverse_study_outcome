package y3;

/* loaded from: classes2.dex */
public final class g extends t3.g {

    /* renamed from: e, reason: collision with root package name */
    public boolean f16361e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t3.e f16362f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t3.g f16363g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f16364h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, t3.g gVar, t3.e eVar, t3.g gVar2) {
        super(gVar, true);
        this.f16364h = hVar;
        this.f16362f = eVar;
        this.f16363g = gVar2;
    }

    @Override // t3.g
    public final void e() {
        e eVar = new e(this);
        h hVar = this.f16364h;
        this.f16362f.d(eVar, hVar.f16365a, hVar.f16366b);
    }

    @Override // t3.g
    public final void f(Throwable th) {
        this.f16362f.b(new f(this, th, 0));
    }

    @Override // t3.g
    public final void g(Object obj) {
        f fVar = new f(this, obj, 1);
        h hVar = this.f16364h;
        this.f16362f.d(fVar, hVar.f16365a, hVar.f16366b);
    }
}
