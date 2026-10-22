package V3;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class m<A, B> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final A f5529a;

    /* renamed from: b, reason: collision with root package name */
    private final B f5530b;

    public m(A a6, B b6) {
        this.f5529a = a6;
        this.f5530b = b6;
    }

    public final A a() {
        return this.f5529a;
    }

    public final B b() {
        return this.f5530b;
    }

    public final A c() {
        return this.f5529a;
    }

    public final B d() {
        return this.f5530b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return j4.k.b(this.f5529a, mVar.f5529a) && j4.k.b(this.f5530b, mVar.f5530b);
    }

    public int hashCode() {
        A a6 = this.f5529a;
        int iHashCode = (a6 == null ? 0 : a6.hashCode()) * 31;
        B b6 = this.f5530b;
        return iHashCode + (b6 != null ? b6.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f5529a + ", " + this.f5530b + ')';
    }
}
