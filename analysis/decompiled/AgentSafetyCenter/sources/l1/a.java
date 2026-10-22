package l1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f7713a;

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f7713a == ((a) obj).f7713a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f7713a);
    }

    public final String toString() {
        int i = this.f7713a;
        return i == 1 ? "Touch" : i == 2 ? "Keyboard" : "Error";
    }
}
