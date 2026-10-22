package b9;

import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public List f2046a;

    /* renamed from: b, reason: collision with root package name */
    public Map f2047b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2046a.equals(bVar.f2046a) && this.f2047b.equals(bVar.f2047b);
    }

    public final int hashCode() {
        return this.f2047b.hashCode() + k0.a.h(this.f2046a.hashCode() * 31, 961, false);
    }

    public final String toString() {
        return "CallToolResult(content=" + this.f2046a + ", isError=false, structuredContent=null, meta=" + this.f2047b + ")";
    }
}
