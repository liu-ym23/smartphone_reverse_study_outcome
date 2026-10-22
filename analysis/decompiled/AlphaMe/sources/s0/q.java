package s0;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: a, reason: collision with root package name */
    public final C0850h f14210a;

    public q(C0850h c0850h) {
        this.f14210a = c0850h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return this.f14210a.equals(((q) obj).f14210a);
    }

    public final int hashCode() {
        return this.f14210a.hashCode() + (q.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.f14210a + '}';
    }
}
