package Ea;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f2493a;

    /* renamed from: b, reason: collision with root package name */
    public final T f2494b;

    public a(T t10, T t11) {
        this.f2493a = t10;
        this.f2494b = t11;
    }

    public final T a() {
        return this.f2493a;
    }

    public final T b() {
        return this.f2494b;
    }

    public final T c() {
        return this.f2493a;
    }

    public final T d() {
        return this.f2494b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return p.d(this.f2493a, aVar.f2493a) && p.d(this.f2494b, aVar.f2494b);
    }

    public int hashCode() {
        T t10 = this.f2493a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f2494b;
        return iHashCode + (t11 != null ? t11.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f2493a + ", upper=" + this.f2494b + ')';
    }
}
