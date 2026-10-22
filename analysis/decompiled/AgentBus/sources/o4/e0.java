package o4;

/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7335f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t1 f7336g;

    public /* synthetic */ e0(t1 t1Var, int i2) {
        this.f7335f = i2;
        this.f7336g = t1Var;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f7335f;
        t1 t1Var = this.f7336g;
        switch (i2) {
            case 0:
                return Boolean.valueOf(t1Var.F);
            default:
                return Boolean.valueOf(t1Var.f7596x.f7345b.getValue() == h1.ONLINE);
        }
    }
}
