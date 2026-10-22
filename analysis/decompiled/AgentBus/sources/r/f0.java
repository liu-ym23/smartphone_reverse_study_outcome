package r;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public float f8858a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8859b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Float.compare(this.f8858a, f0Var.f8858a) == 0 && this.f8859b == f0Var.f8859b;
    }

    public final int hashCode() {
        return m.x.e(Float.hashCode(this.f8858a) * 31, 961, this.f8859b);
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.f8858a + ", fill=" + this.f8859b + ", crossAxisAlignment=null, flowLayoutData=null)";
    }
}
