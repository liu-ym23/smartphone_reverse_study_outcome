package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public float f11495a;

    /* renamed from: b, reason: collision with root package name */
    public float f11496b;

    /* renamed from: c, reason: collision with root package name */
    public float f11497c;

    /* renamed from: d, reason: collision with root package name */
    public float f11498d;

    /* renamed from: e, reason: collision with root package name */
    public float f11499e;

    /* renamed from: f, reason: collision with root package name */
    public float f11500f;

    /* renamed from: g, reason: collision with root package name */
    public int f11501g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Float.compare(this.f11495a, c1Var.f11495a) == 0 && Float.compare(this.f11496b, c1Var.f11496b) == 0 && Float.compare(this.f11497c, c1Var.f11497c) == 0 && Float.compare(this.f11498d, c1Var.f11498d) == 0 && Float.compare(this.f11499e, c1Var.f11499e) == 0 && Float.compare(this.f11500f, c1Var.f11500f) == 0 && this.f11501g == c1Var.f11501g;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11501g) + k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f11495a) * 31, this.f11496b, 31), this.f11497c, 31), this.f11498d, 31), this.f11499e, 31), this.f11500f, 31);
    }

    public final String toString() {
        float f5 = this.f11495a;
        float f10 = this.f11496b;
        float f11 = this.f11497c;
        float f12 = this.f11498d;
        float f13 = this.f11499e;
        float f14 = this.f11500f;
        int i = this.f11501g;
        StringBuilder sb2 = new StringBuilder("ChartBarLayoutMetrics(padStartPx=");
        sb2.append(f5);
        sb2.append(", yAxisWPx=");
        sb2.append(f10);
        sb2.append(", yAxisGapPx=");
        sb2.append(f11);
        sb2.append(", innerForBarsPx=");
        sb2.append(f12);
        sb2.append(", slotWPx=");
        sb2.append(f13);
        sb2.append(", barWidthPx=");
        sb2.append(f14);
        sb2.append(", barCount=");
        return k0.a.r(sb2, i, ")");
    }
}
