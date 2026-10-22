package u0;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    public static final b0 f9889d = new b0(z.c(4278190080L), 0, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    public final long f9890a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9891b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9892c;

    public b0(long j2, long j4, float f10) {
        this.f9890a = j2;
        this.f9891b = j4;
        this.f9892c = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return m.c(this.f9890a, b0Var.f9890a) && t0.b.b(this.f9891b, b0Var.f9891b) && this.f9892c == b0Var.f9892c;
    }

    public final int hashCode() {
        int i2 = m.f9917g;
        return Float.hashCode(this.f9892c) + m.x.f(this.f9891b, Long.hashCode(this.f9890a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Shadow(color=");
        m.x.u(this.f9890a, sb2, ", offset=");
        sb2.append((Object) t0.b.i(this.f9891b));
        sb2.append(", blurRadius=");
        sb2.append(this.f9892c);
        sb2.append(')');
        return sb2.toString();
    }
}
