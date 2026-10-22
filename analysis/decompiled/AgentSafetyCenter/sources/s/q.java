package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public double f11097a;

    /* renamed from: b, reason: collision with root package name */
    public double f11098b;

    public q(double d7, double d10) {
        this.f11097a = d7;
        this.f11098b = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Double.compare(this.f11097a, qVar.f11097a) == 0 && Double.compare(this.f11098b, qVar.f11098b) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f11098b) + (Double.hashCode(this.f11097a) * 31);
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f11097a + ", _imaginary=" + this.f11098b + ')';
    }
}
