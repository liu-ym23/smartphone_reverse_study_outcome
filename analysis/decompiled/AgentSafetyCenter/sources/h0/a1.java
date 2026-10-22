package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public long f4916a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a1) && d1.p.d(this.f4916a, ((a1) obj).f4916a);
    }

    public final int hashCode() {
        long j10 = this.f4916a;
        int i = d1.p.f3025h;
        return Long.hashCode(j10) * 31;
    }

    public final String toString() {
        return "RippleConfiguration(color=" + ((Object) d1.p.j(this.f4916a)) + ", rippleAlpha=null)";
    }
}
