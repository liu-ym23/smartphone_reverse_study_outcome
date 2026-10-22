package u0;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f9923a;

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f9923a == ((r) obj).f9923a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9923a);
    }

    public final String toString() {
        int i2 = this.f9923a;
        return i2 == 0 ? "Argb8888" : i2 == 1 ? "Alpha8" : i2 == 2 ? "Rgb565" : i2 == 3 ? "F16" : i2 == 4 ? "Gpu" : "Unknown";
    }
}
