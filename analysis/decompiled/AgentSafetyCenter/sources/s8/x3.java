package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x3 {

    /* renamed from: a, reason: collision with root package name */
    public String f12109a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x3) && this.f12109a.equals(((x3) obj).f12109a);
    }

    public final int hashCode() {
        return this.f12109a.hashCode();
    }

    public final String toString() {
        return k0.a.C("Drop(reason=", this.f12109a, ")");
    }
}
