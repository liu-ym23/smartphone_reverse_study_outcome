package z7;

/* loaded from: classes.dex */
public final class z0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11994g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a1 f11995h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(a1 a1Var, int i2) {
        super(0);
        this.f11994g = i2;
        this.f11995h = a1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11994g) {
            case 0:
                return new y0(this.f11995h);
            default:
                return this.f11995h.E();
        }
    }
}
