package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3045a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3046b;

    /* renamed from: c, reason: collision with root package name */
    public int f3047c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3048d;

    public /* synthetic */ c(b bVar, int i, int i3, int i10) {
        this(i, (i10 & 4) != 0 ? Integer.MIN_VALUE : i3, bVar, (i10 & 8) != 0 ? "" : "ai_operate_phone_terms");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return yb.k.a(this.f3045a, cVar.f3045a) && this.f3046b == cVar.f3046b && this.f3047c == cVar.f3047c && yb.k.a(this.f3048d, cVar.f3048d);
    }

    public final int hashCode() {
        Object obj = this.f3045a;
        return this.f3048d.hashCode() + s.f.b(this.f3047c, s.f.b(this.f3046b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MutableRange(item=");
        sb2.append(this.f3045a);
        sb2.append(", start=");
        sb2.append(this.f3046b);
        sb2.append(", end=");
        sb2.append(this.f3047c);
        sb2.append(", tag=");
        return k0.a.s(sb2, this.f3048d, ')');
    }

    public c(int i, int i3, Object obj, String str) {
        this.f3045a = obj;
        this.f3046b = i;
        this.f3047c = i3;
        this.f3048d = str;
    }
}
