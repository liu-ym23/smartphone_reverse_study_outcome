package b8;

/* loaded from: classes4.dex */
public final class T implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2029a;
    public final V b;

    public /* synthetic */ T(V v10, int i) {
        this.f2029a = i;
        this.b = v10;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2029a) {
            case 0:
                return new U(this.b);
            default:
                V v10 = this.b;
                return v10.p(v10.o(), null);
        }
    }
}
