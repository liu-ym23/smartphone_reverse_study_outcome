package o;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f7123a;

    /* renamed from: b, reason: collision with root package name */
    public final r.c0 f7124b;

    public r0() {
        long jC = u0.z.c(4284900966L);
        float f10 = 0;
        r.c0 c0Var = new r.c0(f10, f10, f10, f10);
        this.f7123a = jC;
        this.f7124b = c0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        q7.k.c(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        r0 r0Var = (r0) obj;
        return u0.m.c(this.f7123a, r0Var.f7123a) && q7.k.a(this.f7124b, r0Var.f7124b);
    }

    public final int hashCode() {
        int i2 = u0.m.f9917g;
        return this.f7124b.hashCode() + (Long.hashCode(this.f7123a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("OverscrollConfiguration(glowColor=");
        m.x.u(this.f7123a, sb2, ", drawPadding=");
        sb2.append(this.f7124b);
        sb2.append(')');
        return sb2.toString();
    }
}
