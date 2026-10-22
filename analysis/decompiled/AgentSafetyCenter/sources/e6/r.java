package e6;

import java.util.Map;
import kb.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final r f3599b = new r(t.f7405c);

    /* renamed from: a, reason: collision with root package name */
    public final Map f3600a;

    public r(Map map) {
        this.f3600a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return yb.k.a(this.f3600a, ((r) obj).f3600a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3600a.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.f3600a + ')';
    }
}
