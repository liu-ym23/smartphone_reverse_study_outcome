package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements t1.c {

    /* renamed from: c, reason: collision with root package name */
    public xb.l f15062c;

    /* renamed from: f, reason: collision with root package name */
    public y0 f15063f;

    @Override // t1.c
    public final void e(t1.h hVar) {
        y0 y0Var = (y0) hVar.d(b1.f14958a);
        if (yb.k.a(y0Var, this.f15063f)) {
            return;
        }
        this.f15063f = y0Var;
        this.f15062c.invoke(y0Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && ((x) obj).f15062c == this.f15062c;
    }

    public final int hashCode() {
        return this.f15062c.hashCode();
    }
}
