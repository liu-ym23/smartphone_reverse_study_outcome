package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11869a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11870b;

    public p1(String str, String str2) {
        str.getClass();
        this.f11869a = str;
        this.f11870b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return yb.k.a(this.f11869a, p1Var.f11869a) && yb.k.a(this.f11870b, p1Var.f11870b);
    }

    public final int hashCode() {
        int iHashCode = this.f11869a.hashCode() * 31;
        String str = this.f11870b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return androidx.activity.b.k("HomeCompactCount(numberText=", this.f11869a, ", unit=", this.f11870b, ")");
    }
}
