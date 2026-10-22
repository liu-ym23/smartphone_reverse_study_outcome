package c7;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Object f1973f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1974g;

    public j(Object obj, Object obj2) {
        this.f1973f = obj;
        this.f1974g = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q7.k.a(this.f1973f, jVar.f1973f) && q7.k.a(this.f1974g, jVar.f1974g);
    }

    public final int hashCode() {
        Object obj = this.f1973f;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1974g;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f1973f + ", " + this.f1974g + ')';
    }
}
