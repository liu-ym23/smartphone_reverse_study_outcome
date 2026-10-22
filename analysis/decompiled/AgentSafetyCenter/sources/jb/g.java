package jb;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Object f6759c;

    /* renamed from: f, reason: collision with root package name */
    public final Object f6760f;

    public g(Object obj, Object obj2) {
        this.f6759c = obj;
        this.f6760f = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return yb.k.a(this.f6759c, gVar.f6759c) && yb.k.a(this.f6760f, gVar.f6760f);
    }

    public final int hashCode() {
        Object obj = this.f6759c;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f6760f;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f6759c + ", " + this.f6760f + ')';
    }
}
