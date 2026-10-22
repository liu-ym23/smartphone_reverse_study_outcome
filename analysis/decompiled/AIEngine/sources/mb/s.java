package mb;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f10562a;

    /* renamed from: b, reason: collision with root package name */
    public final T f10563b;

    public s(int i10, T t8) {
        this.f10562a = i10;
        this.f10563b = t8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f10562a == sVar.f10562a && kotlin.jvm.internal.g.b(this.f10563b, sVar.f10563b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f10562a) * 31;
        T t8 = this.f10563b;
        return iHashCode + (t8 == null ? 0 : t8.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f10562a + ", value=" + this.f10563b + ')';
    }
}
