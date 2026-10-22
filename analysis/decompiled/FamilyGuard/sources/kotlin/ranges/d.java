package kotlin.ranges;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final double f17957a;

    /* renamed from: b, reason: collision with root package name */
    private final double f17958b;

    public boolean a() {
        return this.f17957a > this.f17958b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (a() && ((d) obj).a()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f17957a == dVar.f17957a && this.f17958b == dVar.f17958b;
    }

    public int hashCode() {
        if (a()) {
            return -1;
        }
        return (Double.hashCode(this.f17957a) * 31) + Double.hashCode(this.f17958b);
    }

    public String toString() {
        return this.f17957a + ".." + this.f17958b;
    }
}
