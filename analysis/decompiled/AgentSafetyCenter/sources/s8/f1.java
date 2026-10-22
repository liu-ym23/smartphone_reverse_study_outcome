package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public float f11593a;

    /* renamed from: b, reason: collision with root package name */
    public float f11594b;

    /* renamed from: c, reason: collision with root package name */
    public float f11595c;

    /* renamed from: d, reason: collision with root package name */
    public float f11596d;

    /* renamed from: e, reason: collision with root package name */
    public float f11597e;

    /* renamed from: f, reason: collision with root package name */
    public float f11598f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return Float.compare(this.f11593a, f1Var.f11593a) == 0 && Float.compare(this.f11594b, f1Var.f11594b) == 0 && Float.compare(this.f11595c, f1Var.f11595c) == 0 && Float.compare(this.f11596d, f1Var.f11596d) == 0 && Float.compare(this.f11597e, f1Var.f11597e) == 0 && Float.compare(this.f11598f, f1Var.f11598f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11598f) + k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f11593a) * 31, this.f11594b, 31), this.f11595c, 31), this.f11596d, 31), this.f11597e, 31);
    }

    public final String toString() {
        return "ChartTooltipAnchor(slotCenterX=" + this.f11593a + ", guideBarCenterX=" + this.f11594b + ", plotLeft=" + this.f11595c + ", plotRight=" + this.f11596d + ", plotTop=" + this.f11597e + ", barBottomY=" + this.f11598f + ")";
    }
}
