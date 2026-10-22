package n2;

import d1.f0;
import d1.h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f8645a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8646b;

    public b(h0 h0Var, float f5) {
        this.f8645a = h0Var;
        this.f8646b = f5;
    }

    @Override // n2.o
    public final long a() {
        int i = d1.p.f3025h;
        return d1.p.f3024g;
    }

    @Override // n2.o
    public final f0 b() {
        return this.f8645a;
    }

    @Override // n2.o
    public final float c() {
        return this.f8646b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return yb.k.a(this.f8645a, bVar.f8645a) && Float.compare(this.f8646b, bVar.f8646b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f8646b) + (this.f8645a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BrushStyle(value=");
        sb2.append(this.f8645a);
        sb2.append(", alpha=");
        return k0.a.q(sb2, this.f8646b, ')');
    }
}
