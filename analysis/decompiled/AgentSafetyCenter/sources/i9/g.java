package i9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public List f5861a;

    /* renamed from: b, reason: collision with root package name */
    public long f5862b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f5861a.equals(gVar.f5861a) && this.f5862b == gVar.f5862b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5862b) + s.f.b(2, this.f5861a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "ScreenPerceptionBlacklistProviderRow(blacklistPackageNames=" + this.f5861a + ", schemaVersion=2, updatedAtEpochMs=" + this.f5862b + ")";
    }
}
