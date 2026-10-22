package g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final float f4142a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4143b;

    /* renamed from: c, reason: collision with root package name */
    public final float f4144c;

    /* renamed from: d, reason: collision with root package name */
    public final float f4145d;

    public g(float f5, float f10, float f11, float f12) {
        this.f4142a = f5;
        this.f4143b = f10;
        this.f4144c = f11;
        this.f4145d = f12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f4142a == gVar.f4142a && this.f4143b == gVar.f4143b && this.f4144c == gVar.f4144c && this.f4145d == gVar.f4145d;
    }

    public final int hashCode() {
        return Float.hashCode(this.f4145d) + k0.a.g(k0.a.g(Float.hashCode(this.f4142a) * 31, this.f4143b, 31), this.f4144c, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RippleAlpha(draggedAlpha=");
        sb2.append(this.f4142a);
        sb2.append(", focusedAlpha=");
        sb2.append(this.f4143b);
        sb2.append(", hoveredAlpha=");
        sb2.append(this.f4144c);
        sb2.append(", pressedAlpha=");
        return k0.a.q(sb2, this.f4145d, ')');
    }
}
