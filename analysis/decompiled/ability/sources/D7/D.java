package D7;

/* loaded from: classes3.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final int f393a;
    public final Object b;

    public D(int i, Object obj) {
        this.f393a = i;
        this.b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d = (D) obj;
        return this.f393a == d.f393a && kotlin.jvm.internal.k.b(this.b, d.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f393a) * 31;
        Object obj = this.b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IndexedValue(index=");
        sb.append(this.f393a);
        sb.append(", value=");
        return androidx.compose.foundation.b.t(sb, this.b, ')');
    }
}
