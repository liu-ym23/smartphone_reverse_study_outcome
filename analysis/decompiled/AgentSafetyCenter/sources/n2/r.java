package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public int f8674a;

    public final boolean equals(Object obj) {
        return (obj instanceof r) && this.f8674a == ((r) obj).f8674a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8674a);
    }

    public final String toString() {
        int i = this.f8674a;
        return i == 1 ? "Linearity.Linear" : i == 2 ? "Linearity.FontHinting" : i == 3 ? "Linearity.None" : "Invalid";
    }
}
