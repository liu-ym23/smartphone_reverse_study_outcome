package h4;

import java.util.LinkedHashMap;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5290a = new LinkedHashMap();

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return k.a(this.f5290a, ((b) obj).f5290a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5290a.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.f5290a + ')';
    }
}
