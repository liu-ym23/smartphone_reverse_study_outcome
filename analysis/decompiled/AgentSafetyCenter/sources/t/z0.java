package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public long f13104a;

    /* renamed from: b, reason: collision with root package name */
    public w.l0 f13105b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!z0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        z0 z0Var = (z0) obj;
        return d1.p.d(this.f13104a, z0Var.f13104a) && this.f13105b.equals(z0Var.f13105b);
    }

    public final int hashCode() {
        long j10 = this.f13104a;
        int i = d1.p.f3025h;
        return this.f13105b.hashCode() + (Long.hashCode(j10) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("OverscrollConfiguration(glowColor=");
        k0.a.z(this.f13104a, sb2, ", drawPadding=");
        sb2.append(this.f13105b);
        sb2.append(')');
        return sb2.toString();
    }
}
