package y1;

import android.content.res.Resources;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public Resources.Theme f15877a;

    /* renamed from: b, reason: collision with root package name */
    public int f15878b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a(this.f15877a, bVar.f15877a) && this.f15878b == bVar.f15878b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15878b) + (this.f15877a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Key(theme=");
        sb2.append(this.f15877a);
        sb2.append(", id=");
        return androidx.activity.b.l(sb2, this.f15878b, ')');
    }
}
