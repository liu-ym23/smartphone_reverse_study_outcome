package m9;

/* renamed from: m9.M, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1695M implements InterfaceC1706Y {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5317a;

    public C1695M(boolean z10) {
        this.f5317a = z10;
    }

    @Override // m9.InterfaceC1706Y
    public final l0 b() {
        return null;
    }

    @Override // m9.InterfaceC1706Y
    public final boolean isActive() {
        return this.f5317a;
    }

    public final String toString() {
        return B7.a.g('}', this.f5317a ? "Active" : "New", new StringBuilder("Empty{"));
    }
}
