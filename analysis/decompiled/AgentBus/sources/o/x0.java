package o;

/* loaded from: classes.dex */
public final class x0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7145g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y0 f7146h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x0(y0 y0Var, int i2) {
        super(0);
        this.f7145g = i2;
        this.f7146h = y0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f7145g) {
            case 0:
                return Boolean.valueOf(this.f7146h.f7159f.e() > 0);
            default:
                y0 y0Var = this.f7146h;
                return Boolean.valueOf(y0Var.f7159f.e() < y0Var.f7162i.e());
        }
    }
}
