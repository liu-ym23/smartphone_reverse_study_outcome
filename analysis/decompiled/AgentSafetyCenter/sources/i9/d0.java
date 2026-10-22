package i9;

import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5850a;

    /* renamed from: b, reason: collision with root package name */
    public final b f5851b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f5852c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f5853d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5854e;

    public d0(boolean z10, b bVar, Long l2, Set set, long j10) {
        bVar.getClass();
        this.f5850a = z10;
        this.f5851b = bVar;
        this.f5852c = l2;
        this.f5853d = set;
        this.f5854e = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f5850a == d0Var.f5850a && this.f5851b == d0Var.f5851b && yb.k.a(this.f5852c, d0Var.f5852c) && this.f5853d.equals(d0Var.f5853d) && this.f5854e == d0Var.f5854e;
    }

    public final int hashCode() {
        int iHashCode = (this.f5851b.hashCode() + (Boolean.hashCode(this.f5850a) * 31)) * 31;
        Long l2 = this.f5852c;
        return Long.hashCode(this.f5854e) + ((this.f5853d.hashCode() + ((iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31)) * 31);
    }

    public final String toString() {
        return "ScreenPerceptionState(enabled=" + this.f5850a + ", scope=" + this.f5851b + ", authorizationSwitchDeadlineEpochMs=" + this.f5852c + ", blacklistPackageNames=" + this.f5853d + ", updatedAtEpochMs=" + this.f5854e + ")";
    }
}
