package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends nb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final w0 f7477f = new w0();

    /* renamed from: c, reason: collision with root package name */
    public String f7478c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && yb.k.a(this.f7478c, ((s) obj).f7478c);
    }

    public final int hashCode() {
        return this.f7478c.hashCode();
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("CoroutineName("), this.f7478c, ')');
    }
}
