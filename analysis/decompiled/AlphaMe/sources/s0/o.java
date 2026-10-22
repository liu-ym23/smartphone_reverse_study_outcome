package s0;

/* loaded from: classes.dex */
public final class o extends r {

    /* renamed from: a, reason: collision with root package name */
    public final C0850h f14209a = C0850h.f14200c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.f14209a.equals(((o) obj).f14209a);
    }

    public final int hashCode() {
        return this.f14209a.hashCode() + (o.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.f14209a + '}';
    }
}
