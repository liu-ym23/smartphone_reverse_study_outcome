package b8;

/* loaded from: classes4.dex */
public final class Z implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2033a;
    public final b0 b;

    public /* synthetic */ Z(b0 b0Var, int i) {
        this.f2033a = i;
        this.b = b0Var;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2033a) {
            case 0:
                return new a0(this.b);
            default:
                return this.b.o();
        }
    }
}
