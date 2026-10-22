package l0;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5769f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p7.k f5770g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p7.k f5771h;

    public /* synthetic */ l(p7.k kVar, p7.k kVar2, int i2) {
        this.f5769f = i2;
        this.f5770g = kVar;
        this.f5771h = kVar2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f5769f) {
            case 0:
                this.f5770g.invoke(obj);
                this.f5771h.invoke(obj);
                break;
            default:
                this.f5770g.invoke(obj);
                this.f5771h.invoke(obj);
                break;
        }
        return c7.r.f1986a;
    }
}
