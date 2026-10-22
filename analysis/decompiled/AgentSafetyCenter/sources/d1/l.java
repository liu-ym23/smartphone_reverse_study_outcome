package d1;

import android.graphics.BlendModeColorFilter;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public BlendModeColorFilter f3010a;

    /* renamed from: b, reason: collision with root package name */
    public long f3011b;

    /* renamed from: c, reason: collision with root package name */
    public int f3012c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return p.d(this.f3011b, lVar.f3011b) && this.f3012c == lVar.f3012c;
    }

    public final int hashCode() {
        long j10 = this.f3011b;
        int i = p.f3025h;
        return Integer.hashCode(this.f3012c) + (Long.hashCode(j10) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BlendModeColorFilter(color=");
        k0.a.z(this.f3011b, sb2, ", blendMode=");
        sb2.append((Object) f0.u(this.f3012c));
        sb2.append(')');
        return sb2.toString();
    }
}
