package mc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f8594a;

    public final boolean equals(Object obj) {
        return (obj instanceof j) && yb.k.a(this.f8594a, ((j) obj).f8594a);
    }

    public final int hashCode() {
        Throwable th = this.f8594a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // mc.k
    public final String toString() {
        return "Closed(" + this.f8594a + ')';
    }
}
