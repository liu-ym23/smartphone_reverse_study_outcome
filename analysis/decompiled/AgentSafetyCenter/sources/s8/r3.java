package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r3 implements s3 {

    /* renamed from: a, reason: collision with root package name */
    public j3 f11930a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r3) && this.f11930a.equals(((r3) obj).f11930a);
    }

    public final int hashCode() {
        return this.f11930a.hashCode();
    }

    public final String toString() {
        return "TaskCard(group=" + this.f11930a + ")";
    }
}
