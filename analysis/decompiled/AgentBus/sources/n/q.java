package n;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public double f6704a;

    /* renamed from: b, reason: collision with root package name */
    public double f6705b;

    public q(double d6, double d10) {
        this.f6704a = d6;
        this.f6705b = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Double.compare(this.f6704a, qVar.f6704a) == 0 && Double.compare(this.f6705b, qVar.f6705b) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f6705b) + (Double.hashCode(this.f6704a) * 31);
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f6704a + ", _imaginary=" + this.f6705b + ')';
    }
}
