package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f892a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f893b;

    public g(Object obj, Object obj2) {
        this.f892a = obj;
        this.f893b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.p.a(this.f892a, gVar.f892a) && kotlin.jvm.internal.p.a(this.f893b, gVar.f893b);
    }

    public final int hashCode() {
        Object obj = this.f892a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f893b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f892a + ", " + this.f893b + ')';
    }
}
