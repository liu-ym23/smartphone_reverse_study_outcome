package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public int f3031a;

    public final boolean equals(Object obj) {
        return (obj instanceof w) && this.f3031a == ((w) obj).f3031a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3031a);
    }

    public final String toString() {
        int i = this.f3031a;
        return i == 0 ? "Argb8888" : i == 1 ? "Alpha8" : i == 2 ? "Rgb565" : i == 3 ? "F16" : i == 4 ? "Gpu" : "Unknown";
    }
}
