package z7;

/* loaded from: classes.dex */
public final class n0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11918g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0 f11919h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(s0 s0Var, int i2) {
        super(0);
        this.f11918g = i2;
        this.f11919h = s0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11918g) {
            case 0:
                return w7.e0.m(this.f11919h.f11952g);
            default:
                return new q0(this.f11919h);
        }
    }
}
