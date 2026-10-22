package c7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class p implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Object f1982f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1983g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1984h;

    public p(Object obj, Object obj2, Object obj3) {
        this.f1982f = obj;
        this.f1983g = obj2;
        this.f1984h = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return q7.k.a(this.f1982f, pVar.f1982f) && q7.k.a(this.f1983g, pVar.f1983g) && q7.k.a(this.f1984h, pVar.f1984h);
    }

    public final int hashCode() {
        Object obj = this.f1982f;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1983g;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f1984h;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f1982f + ", " + this.f1983g + ", " + this.f1984h + ')';
    }
}
