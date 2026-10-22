package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f8648a;

    public static String a(int i) {
        return i == 1 ? "Hyphens.None" : i == 2 ? "Hyphens.Auto" : i == Integer.MIN_VALUE ? "Hyphens.Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && this.f8648a == ((d) obj).f8648a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8648a);
    }

    public final String toString() {
        return a(this.f8648a);
    }
}
