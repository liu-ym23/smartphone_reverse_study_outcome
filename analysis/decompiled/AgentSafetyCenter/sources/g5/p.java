package g5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends s {

    /* renamed from: a, reason: collision with root package name */
    public final h f4336a = h.f4318b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        return this.f4336a.equals(((p) obj).f4336a);
    }

    public final int hashCode() {
        return this.f4336a.hashCode() + (p.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.f4336a + '}';
    }
}
