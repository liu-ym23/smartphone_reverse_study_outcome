package d5;

/* loaded from: classes3.dex */
public final class e extends l {

    /* renamed from: a, reason: collision with root package name */
    public final double f4295a;

    public e(double d) {
        this.f4295a = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && Double.compare(this.f4295a, ((e) obj).f4295a) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f4295a);
    }

    public final String toString() {
        return "DoubleValue(value=" + this.f4295a + ")";
    }
}
