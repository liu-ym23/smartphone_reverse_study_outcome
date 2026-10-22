package aa;

import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f480a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f481b;

    public a(Object obj, Object obj2) {
        this.f480a = obj;
        this.f481b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f480a, aVar.f480a) && k.a(this.f481b, aVar.f481b);
    }

    public final int hashCode() {
        Object obj = this.f480a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f481b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "ApproximationBounds(lower=" + this.f480a + ", upper=" + this.f481b + ')';
    }
}
