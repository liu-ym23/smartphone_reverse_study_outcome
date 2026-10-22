package c8;

/* loaded from: classes.dex */
public final class i extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2004g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f2005h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(j jVar, int i2) {
        super(0);
        this.f2004g = i2;
        this.f2005h = jVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f2004g) {
            case 0:
                return n.f2066k.c(this.f2005h.f2017g);
            default:
                return n.f2066k.c(this.f2005h.f2016f);
        }
    }
}
