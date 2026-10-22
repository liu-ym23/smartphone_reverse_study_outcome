package w8;

import java.util.List;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15382a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15383b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15384c;

    public g(String str, List list, boolean z10) {
        this.f15382a = z10;
        this.f15383b = list;
        this.f15384c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f15382a == gVar.f15382a && this.f15383b.equals(gVar.f15383b) && k.a(this.f15384c, gVar.f15384c);
    }

    public final int hashCode() {
        int iHashCode = (this.f15383b.hashCode() + (Boolean.hashCode(this.f15382a) * 31)) * 31;
        String str = this.f15384c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("QueryHiddenNotesResult(success=");
        sb2.append(this.f15382a);
        sb2.append(", notes=");
        sb2.append(this.f15383b);
        sb2.append(", errorMessage=");
        return androidx.activity.b.n(sb2, this.f15384c, ")");
    }
}
