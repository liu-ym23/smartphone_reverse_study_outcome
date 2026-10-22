package ia;

/* loaded from: classes.dex */
public final class r0 implements c1 {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4997f;

    public r0(boolean z4) {
        this.f4997f = z4;
    }

    @Override // ia.c1
    public final boolean b() {
        return this.f4997f;
    }

    @Override // ia.c1
    public final q1 d() {
        return null;
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("Empty{"), this.f4997f ? "Active" : "New", '}');
    }
}
