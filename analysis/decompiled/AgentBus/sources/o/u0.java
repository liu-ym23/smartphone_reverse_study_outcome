package o;

/* loaded from: classes.dex */
public final class u0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7131g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v0 f7132h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(v0 v0Var, int i2) {
        super(0);
        this.f7131g = i2;
        this.f7132h = v0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f7131g) {
            case 0:
                return Float.valueOf(this.f7132h.f7137t.f7159f.e());
            default:
                return Float.valueOf(this.f7132h.f7137t.f7162i.e());
        }
    }
}
