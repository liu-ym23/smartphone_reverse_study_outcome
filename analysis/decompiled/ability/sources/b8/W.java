package b8;

/* loaded from: classes4.dex */
public final class W implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2031a;
    public final Y b;

    public /* synthetic */ W(Y y, int i) {
        this.f2031a = i;
        this.b = y;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f2031a) {
            case 0:
                return new X(this.b);
            default:
                return this.b.o();
        }
    }
}
