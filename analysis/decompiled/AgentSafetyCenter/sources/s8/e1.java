package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final float f11566a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11567b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11568c;

    public e1(float f5, float f10, float f11) {
        this.f11566a = f5;
        this.f11567b = f10;
        this.f11568c = f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return Float.compare(this.f11566a, e1Var.f11566a) == 0 && Float.compare(this.f11567b, e1Var.f11567b) == 0 && Float.compare(this.f11568c, e1Var.f11568c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11568c) + k0.a.g(Float.hashCode(this.f11566a) * 31, this.f11567b, 31);
    }

    public final String toString() {
        return "ChartPlotGuide(plotLeft=" + this.f11566a + ", plotRight=" + this.f11567b + ", plotTop=" + this.f11568c + ")";
    }

    public /* synthetic */ e1() {
        this(0.0f, 0.0f, 0.0f);
    }
}
