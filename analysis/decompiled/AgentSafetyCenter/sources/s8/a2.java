package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f11448a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11449b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11450c;

    public a2(int i, int i3, int i10) {
        float f5 = z1.f12164a;
        this.f11448a = i;
        this.f11449b = i3;
        this.f11450c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        if (this.f11448a != a2Var.f11448a || this.f11449b != a2Var.f11449b || this.f11450c != a2Var.f11450c) {
            return false;
        }
        float f5 = z1.f12164a;
        return o2.f.b(f5, f5);
    }

    public final int hashCode() {
        return Float.hashCode(z1.f12164a) + s.f.b(this.f11450c, s.f.b(this.f11449b, Integer.hashCode(this.f11448a) * 31, 31), 31);
    }

    public final String toString() {
        String strC = o2.f.c(z1.f12164a);
        StringBuilder sbU = k0.a.u("HomeHeroVisuals(titleRes=", this.f11448a, ", bodyRes=", ", iconRes=", this.f11449b);
        sbU.append(this.f11450c);
        sbU.append(", iconSize=");
        sbU.append(strC);
        sbU.append(")");
        return sbU.toString();
    }
}
