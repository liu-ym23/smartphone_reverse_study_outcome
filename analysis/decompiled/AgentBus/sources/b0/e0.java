package b0;

/* loaded from: classes.dex */
public final class e0 extends w1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1135b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1136c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(p7.a aVar) {
        super(aVar);
        b1 b1Var = b1.f1111k;
        this.f1136c = b1Var;
    }

    @Override // b0.w1
    public final x1 a(Object obj) {
        switch (this.f1135b) {
            case 0:
                return new x1(this, obj, obj == null, null, true);
            default:
                return new x1(this, obj, obj == null, (x2) this.f1136c, true);
        }
    }

    @Override // b0.w1
    public e3 b() {
        switch (this.f1135b) {
            case 0:
                return (f0) this.f1136c;
            default:
                return super.b();
        }
    }

    public e0(p7.k kVar) {
        super(new d0(0));
        this.f1136c = new f0(kVar);
    }
}
