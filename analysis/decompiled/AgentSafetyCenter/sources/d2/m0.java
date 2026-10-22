package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 implements b {

    /* renamed from: a, reason: collision with root package name */
    public String f3143a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && this.f3143a.equals(((m0) obj).f3143a);
    }

    public final int hashCode() {
        return this.f3143a.hashCode();
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("UrlAnnotation(url="), this.f3143a, ')');
    }
}
