package p;

/* loaded from: classes.dex */
public final class f1 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1 f8096g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f8097h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p7.k f8098i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(g1 g1Var, float f10, p7.k kVar) {
        super(1);
        this.f8096g = g1Var;
        this.f8097h = f10;
        this.f8098i = kVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        g1 g1Var = this.f8096g;
        if (g1Var.f8107b == Long.MIN_VALUE) {
            g1Var.f8107b = jLongValue;
        }
        float f10 = g1Var.f8110e;
        n.j jVar = new n.j(f10);
        float f11 = this.f8097h;
        n.j jVar2 = g1.f8105f;
        long jC = f11 == 0.0f ? g1Var.f8106a.c(new n.j(f10), jVar2, g1Var.f8108c) : s7.a.V((jLongValue - g1Var.f8107b) / f11);
        float f12 = ((n.j) g1Var.f8106a.s(jC, jVar, jVar2, g1Var.f8108c)).f6639a;
        g1Var.f8108c = (n.j) g1Var.f8106a.r(jC, jVar, jVar2, g1Var.f8108c);
        g1Var.f8107b = jLongValue;
        float f13 = g1Var.f8110e - f12;
        g1Var.f8110e = f12;
        this.f8098i.invoke(Float.valueOf(f13));
        return c7.r.f1986a;
    }
}
