package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public int f14976a;

    /* renamed from: b, reason: collision with root package name */
    public int f14977b;

    /* renamed from: c, reason: collision with root package name */
    public int f14978c;

    /* renamed from: d, reason: collision with root package name */
    public int f14979d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f14976a == g0Var.f14976a && this.f14977b == g0Var.f14977b && this.f14978c == g0Var.f14978c && this.f14979d == g0Var.f14979d;
    }

    public final int hashCode() {
        return (((((this.f14976a * 31) + this.f14977b) * 31) + this.f14978c) * 31) + this.f14979d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("InsetsValues(left=");
        sb2.append(this.f14976a);
        sb2.append(", top=");
        sb2.append(this.f14977b);
        sb2.append(", right=");
        sb2.append(this.f14978c);
        sb2.append(", bottom=");
        return androidx.activity.b.l(sb2, this.f14979d, ')');
    }
}
