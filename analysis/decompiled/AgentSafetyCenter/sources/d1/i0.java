package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: d, reason: collision with root package name */
    public static final i0 f2997d = new i0(f0.c(4278190080L), 0, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final long f2998a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2999b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3000c;

    public i0(long j10, long j11, float f5) {
        this.f2998a = j10;
        this.f2999b = j11;
        this.f3000c = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return p.d(this.f2998a, i0Var.f2998a) && c1.b.c(this.f2999b, i0Var.f2999b) && this.f3000c == i0Var.f3000c;
    }

    public final int hashCode() {
        int i = p.f3025h;
        return Float.hashCode(this.f3000c) + k0.a.i(this.f2999b, Long.hashCode(this.f2998a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Shadow(color=");
        k0.a.z(this.f2998a, sb2, ", offset=");
        sb2.append((Object) c1.b.j(this.f2999b));
        sb2.append(", blurRadius=");
        return k0.a.q(sb2, this.f3000c, ')');
    }
}
