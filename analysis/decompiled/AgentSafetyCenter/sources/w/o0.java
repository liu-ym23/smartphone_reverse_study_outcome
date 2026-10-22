package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public float f15017a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15018b = true;

    /* renamed from: c, reason: collision with root package name */
    public t.c1 f15019c = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return Float.compare(this.f15017a, o0Var.f15017a) == 0 && this.f15018b == o0Var.f15018b && yb.k.a(this.f15019c, o0Var.f15019c);
    }

    public final int hashCode() {
        int iH = k0.a.h(Float.hashCode(this.f15017a) * 31, 31, this.f15018b);
        t.c1 c1Var = this.f15019c;
        return (iH + (c1Var == null ? 0 : c1Var.hashCode())) * 31;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.f15017a + ", fill=" + this.f15018b + ", crossAxisAlignment=" + this.f15019c + ", flowLayoutData=null)";
    }
}
