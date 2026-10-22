package m0;

import q7.k;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f6128a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f6129b;

    public h(int i2, Integer num) {
        this.f6128a = i2;
        this.f6129b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f6128a == hVar.f6128a && k.a(this.f6129b, hVar.f6129b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f6128a) * 31;
        Integer num = this.f6129b;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "ObjectLocation(group=" + this.f6128a + ", dataOffset=" + this.f6129b + ')';
    }
}
