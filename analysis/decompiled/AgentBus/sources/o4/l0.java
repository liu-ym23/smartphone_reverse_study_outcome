package o4;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7434a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7435b;

    /* renamed from: c, reason: collision with root package name */
    public final j0 f7436c;

    public l0(boolean z4, String str, j0 j0Var) {
        this.f7434a = z4;
        this.f7435b = str;
        this.f7436c = j0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f7434a == l0Var.f7434a && q7.k.a(this.f7435b, l0Var.f7435b) && q7.k.a(this.f7436c, l0Var.f7436c);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f7434a) * 31;
        String str = this.f7435b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        j0 j0Var = this.f7436c;
        return iHashCode2 + (j0Var != null ? j0Var.hashCode() : 0);
    }

    public final String toString() {
        return "InvokeResult(ok=" + this.f7434a + ", payloadJson=" + this.f7435b + ", error=" + this.f7436c + ")";
    }
}
