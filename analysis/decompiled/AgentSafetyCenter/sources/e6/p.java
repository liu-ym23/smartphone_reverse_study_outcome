package e6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kb.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements Iterable, zb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final p f3590f = new p(t.f7405c);

    /* renamed from: c, reason: collision with root package name */
    public final Map f3591c;

    public p(Map map) {
        this.f3591c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return yb.k.a(this.f3591c, ((p) obj).f3591c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3591c.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Map map = this.f3591c;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new jb.g((String) entry.getKey(), (o) entry.getValue()));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.f3591c + ')';
    }
}
