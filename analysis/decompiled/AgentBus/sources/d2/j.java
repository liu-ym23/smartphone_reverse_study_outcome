package d2;

import m.x;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f2787e = new j(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2788a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2789b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2790c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2791d;

    public j(int i2, int i10, int i11, int i12) {
        this.f2788a = i2;
        this.f2789b = i10;
        this.f2790c = i11;
        this.f2791d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f2788a == jVar.f2788a && this.f2789b == jVar.f2789b && this.f2790c == jVar.f2790c && this.f2791d == jVar.f2791d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f2791d) + n.f.b(this.f2790c, n.f.b(this.f2789b, Integer.hashCode(this.f2788a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("IntRect.fromLTRB(");
        sb2.append(this.f2788a);
        sb2.append(", ");
        sb2.append(this.f2789b);
        sb2.append(", ");
        sb2.append(this.f2790c);
        sb2.append(", ");
        return x.m(sb2, this.f2791d, ')');
    }
}
