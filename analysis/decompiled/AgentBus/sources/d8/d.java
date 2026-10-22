package d8;

import m.x;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f2991a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2992b;

    public d(e eVar, int i2) {
        this.f2991a = eVar;
        this.f2992b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2991a == dVar.f2991a && this.f2992b == dVar.f2992b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f2992b) + (this.f2991a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("KindWithArity(kind=");
        sb2.append(this.f2991a);
        sb2.append(", arity=");
        return x.m(sb2, this.f2992b, ')');
    }
}
