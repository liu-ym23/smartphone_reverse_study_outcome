package h8;

/* renamed from: h8.L, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1504L implements R8.d, InterfaceC1503K {
    public static final C1504L b = new C1504L(0);
    public static final C1504L c = new C1504L(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4578a;

    public /* synthetic */ C1504L(int i) {
        this.f4578a = i;
    }

    @Override // R8.d
    public X8.w getType() {
        switch (this.f4578a) {
            case 2:
                throw new IllegalStateException("This method should not be called");
            case 3:
                throw new IllegalStateException("This method should not be called");
            default:
                throw new IllegalStateException("This method should not be called");
        }
    }

    public String toString() {
        switch (this.f4578a) {
            case 7:
                return "NO_SOURCE";
            default:
                return super.toString();
        }
    }
}
