package s4;

/* loaded from: classes.dex */
final class Z implements InterfaceC1077i0 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f20328a;

    public Z(boolean z5) {
        this.f20328a = z5;
    }

    @Override // s4.InterfaceC1077i0
    public boolean c() {
        return this.f20328a;
    }

    @Override // s4.InterfaceC1077i0
    public y0 d() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(c() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
