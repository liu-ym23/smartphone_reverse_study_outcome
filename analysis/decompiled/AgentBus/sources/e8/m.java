package e8;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3160g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e9.f f3161h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(e9.f fVar, int i2) {
        super(1);
        this.f3160g = i2;
        this.f3161h = fVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f3160g) {
            case 0:
                o9.n nVar = (o9.n) obj;
                q7.k.e(nVar, "it");
                return nVar.f(this.f3161h, n8.c.f6877f);
            default:
                o9.n nVar2 = (o9.n) obj;
                q7.k.e(nVar2, "it");
                return nVar2.a(this.f3161h, n8.c.f6881j);
        }
    }
}
