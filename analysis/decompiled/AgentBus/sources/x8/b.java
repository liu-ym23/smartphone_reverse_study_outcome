package x8;

/* loaded from: classes.dex */
public final class b extends q7.m implements p7.n {

    /* renamed from: h, reason: collision with root package name */
    public static final b f11246h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f11247i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11248g;

    static {
        int i2 = 2;
        f11246h = new b(i2, 0);
        f11247i = new b(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, int i10) {
        super(i2);
        this.f11248g = i10;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11248g) {
            case 0:
                a aVar = (a) obj;
                o oVar = (o) obj2;
                q7.k.e(aVar, "$this$loadConstantFromProperty");
                q7.k.e(oVar, "it");
                return aVar.f11245c.get(oVar);
            default:
                a aVar2 = (a) obj;
                o oVar2 = (o) obj2;
                q7.k.e(aVar2, "$this$loadConstantFromProperty");
                q7.k.e(oVar2, "it");
                return aVar2.f11244b.get(oVar2);
        }
    }
}
