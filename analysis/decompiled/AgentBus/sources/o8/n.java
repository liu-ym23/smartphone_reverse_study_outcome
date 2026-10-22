package o8;

import java.util.Collection;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final w8.i f7832a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f7833b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7834c;

    public n(w8.i iVar, Collection collection) {
        this(iVar, collection, iVar.f10902a == w8.h.f10900h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return q7.k.a(this.f7832a, nVar.f7832a) && q7.k.a(this.f7833b, nVar.f7833b) && this.f7834c == nVar.f7834c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (this.f7833b.hashCode() + (this.f7832a.hashCode() * 31)) * 31;
        boolean z4 = this.f7834c;
        int i2 = z4;
        if (z4 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public final String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f7832a + ", qualifierApplicabilityTypes=" + this.f7833b + ", definitelyNotNull=" + this.f7834c + ')';
    }

    public n(w8.i iVar, Collection collection, boolean z4) {
        q7.k.e(collection, "qualifierApplicabilityTypes");
        this.f7832a = iVar;
        this.f7833b = collection;
        this.f7834c = z4;
    }
}
