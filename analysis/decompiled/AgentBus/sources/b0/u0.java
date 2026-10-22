package b0;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f1376a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1377b;

    public u0(Integer num, Object obj) {
        this.f1376a = num;
        this.f1377b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f1376a.equals(u0Var.f1376a) && q7.k.a(this.f1377b, u0Var.f1377b);
    }

    public final int hashCode() {
        int iHashCode = this.f1376a.hashCode() * 31;
        Object obj = this.f1377b;
        return (obj instanceof Enum ? ((Enum) obj).ordinal() : obj != null ? obj.hashCode() : 0) + iHashCode;
    }

    public final String toString() {
        return "JoinedKey(left=" + this.f1376a + ", right=" + this.f1377b + ')';
    }
}
