package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public j3 f12163a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z0) && this.f12163a.equals(((z0) obj).f12163a);
    }

    public final int hashCode() {
        return this.f12163a.hashCode();
    }

    public final String toString() {
        return "TaskCard(group=" + this.f12163a + ")";
    }
}
