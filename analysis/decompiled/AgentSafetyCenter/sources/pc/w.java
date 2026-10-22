package pc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements nb.f {

    /* renamed from: c, reason: collision with root package name */
    public ThreadLocal f9990c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && yb.k.a(this.f9990c, ((w) obj).f9990c);
    }

    public final int hashCode() {
        return this.f9990c.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f9990c + ')';
    }
}
