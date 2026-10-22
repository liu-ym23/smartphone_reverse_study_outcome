package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5863a;

    /* renamed from: b, reason: collision with root package name */
    public String f5864b;

    /* renamed from: c, reason: collision with root package name */
    public Long f5865c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f5863a == hVar.f5863a && this.f5864b.equals(hVar.f5864b) && yb.k.a(this.f5865c, hVar.f5865c);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(Boolean.hashCode(this.f5863a) * 31, 31, this.f5864b);
        Long l2 = this.f5865c;
        return iD + (l2 == null ? 0 : l2.hashCode());
    }

    public final String toString() {
        return "PublicSurface(screenPerceptionEnabled=" + this.f5863a + ", authorizationScope=" + this.f5864b + ", authorizationSwitchDeadlineEpochMs=" + this.f5865c + ")";
    }
}
