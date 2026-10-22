package z7;

/* loaded from: classes.dex */
public final class c1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11856g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d1 f11857h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(d1 d1Var, int i2) {
        super(0);
        this.f11856g = i2;
        this.f11857h = d1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11856g) {
            case 0:
                return new b1(this.f11857h);
            default:
                return this.f11857h.E();
        }
    }
}
