package g5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends s {

    /* renamed from: a, reason: collision with root package name */
    public h f4337a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        return this.f4337a.equals(((r) obj).f4337a);
    }

    public final int hashCode() {
        return this.f4337a.hashCode() + (r.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.f4337a + '}';
    }
}
