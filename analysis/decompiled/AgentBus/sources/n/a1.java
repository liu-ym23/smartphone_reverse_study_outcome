package n;

/* loaded from: classes.dex */
public final class a1 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b1 f6536g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Boolean f6537h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6538i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(b1 b1Var, Boolean bool, int i2) {
        super(2);
        this.f6536g = b1Var;
        this.f6537h = bool;
        this.f6538i = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        int iS = b0.b.s(this.f6538i | 1);
        this.f6536g.a(this.f6537h, (b0.p) obj, iS);
        return c7.r.f1986a;
    }
}
