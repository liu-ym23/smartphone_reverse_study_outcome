package o8;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: d, reason: collision with root package name */
    public static final r f7843d = new r(b0.STRICT, 6);

    /* renamed from: a, reason: collision with root package name */
    public final b0 f7844a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.e f7845b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f7846c;

    public r(b0 b0Var, c7.e eVar, b0 b0Var2) {
        this.f7844a = b0Var;
        this.f7845b = eVar;
        this.f7846c = b0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f7844a == rVar.f7844a && q7.k.a(this.f7845b, rVar.f7845b) && this.f7846c == rVar.f7846c;
    }

    public final int hashCode() {
        int iHashCode = this.f7844a.hashCode() * 31;
        c7.e eVar = this.f7845b;
        return this.f7846c.hashCode() + ((iHashCode + (eVar == null ? 0 : eVar.f1969i)) * 31);
    }

    public final String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f7844a + ", sinceVersion=" + this.f7845b + ", reportLevelAfter=" + this.f7846c + ')';
    }

    public r(b0 b0Var, int i2) {
        this(b0Var, (i2 & 2) != 0 ? new c7.e(1, 0, 0) : null, b0Var);
    }
}
