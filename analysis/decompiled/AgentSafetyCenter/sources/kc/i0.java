package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 implements t0 {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7442c;

    public i0(boolean z10) {
        this.f7442c = z10;
    }

    @Override // kc.t0
    public final boolean d() {
        return this.f7442c;
    }

    @Override // kc.t0
    public final g1 e() {
        return null;
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("Empty{"), this.f7442c ? "Active" : "New", '}');
    }
}
