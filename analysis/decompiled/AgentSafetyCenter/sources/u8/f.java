package u8;

import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Set f14204a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f14205b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14206c;

    public f(Set set, Set set2, String str) {
        this.f14204a = set;
        this.f14205b = set2;
        this.f14206c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return yb.k.a(this.f14204a, fVar.f14204a) && yb.k.a(this.f14205b, fVar.f14205b) && yb.k.a(this.f14206c, fVar.f14206c);
    }

    public final int hashCode() {
        int iHashCode = (this.f14205b.hashCode() + (this.f14204a.hashCode() * 31)) * 31;
        String str = this.f14206c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DomainRestoreResult(successIds=");
        sb2.append(this.f14204a);
        sb2.append(", failedIds=");
        sb2.append(this.f14205b);
        sb2.append(", errorMessage=");
        return androidx.activity.b.n(sb2, this.f14206c, ")");
    }
}
