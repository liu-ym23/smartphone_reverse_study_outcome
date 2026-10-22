package c6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1139a;

    public h(Throwable th) {
        this.f1139a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.p.a(this.f1139a, ((h) obj).f1139a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f1139a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // c6.i
    public final String toString() {
        return "Closed(" + this.f1139a + ')';
    }
}
