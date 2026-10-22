package a9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public String f290a;

    /* renamed from: b, reason: collision with root package name */
    public String f291b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f290a.equals(mVar.f290a) && this.f291b.equals(mVar.f291b);
    }

    public final int hashCode() {
        return this.f291b.hashCode() + (this.f290a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.activity.b.k("Store(baseDirPath=", this.f290a, ", dbPath=", this.f291b, ")");
    }
}
