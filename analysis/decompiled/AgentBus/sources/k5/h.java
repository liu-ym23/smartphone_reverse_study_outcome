package k5;

import java.util.List;
import m.x;

/* loaded from: classes.dex */
public final class h implements r {

    /* renamed from: a, reason: collision with root package name */
    public final String f5625a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5626b;

    /* renamed from: c, reason: collision with root package name */
    public final List f5627c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5628d;

    public h(String str, List list, List list2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        q7.k.e(str, "nodeId");
        this.f5625a = str;
        this.f5626b = list;
        this.f5627c = list2;
        this.f5628d = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return q7.k.a(this.f5625a, hVar.f5625a) && q7.k.a(this.f5626b, hVar.f5626b) && q7.k.a(this.f5627c, hVar.f5627c) && this.f5628d == hVar.f5628d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5628d) + x.h(this.f5627c, (this.f5626b.hashCode() + (this.f5625a.hashCode() * 31)) * 31, 31);
    }

    public final String toString() {
        return "CapabilityChanged(nodeId=" + this.f5625a + ", added=" + this.f5626b + ", removed=" + this.f5627c + ", timestamp=" + this.f5628d + ")";
    }
}
