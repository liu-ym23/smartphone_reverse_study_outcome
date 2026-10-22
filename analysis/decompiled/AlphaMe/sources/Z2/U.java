package Z2;

/* loaded from: classes2.dex */
public final class U implements InterfaceC0131i0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2192a;

    public U(boolean z4) {
        this.f2192a = z4;
    }

    @Override // Z2.InterfaceC0131i0
    public final boolean a() {
        return this.f2192a;
    }

    @Override // Z2.InterfaceC0131i0
    public final z0 c() {
        return null;
    }

    public final String toString() {
        return B0.g.q(new StringBuilder("Empty{"), this.f2192a ? "Active" : "New", '}');
    }
}
