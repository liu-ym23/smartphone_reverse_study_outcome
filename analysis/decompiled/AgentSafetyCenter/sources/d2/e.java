package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3077a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3078b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3079c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3080d;

    public e(int i, int i3, Object obj, String str) {
        this.f3077a = obj;
        this.f3078b = i;
        this.f3079c = i3;
        this.f3080d = str;
        if (i <= i3) {
            return;
        }
        i2.a.a("Reversed range is not supported");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return yb.k.a(this.f3077a, eVar.f3077a) && this.f3078b == eVar.f3078b && this.f3079c == eVar.f3079c && yb.k.a(this.f3080d, eVar.f3080d);
    }

    public final int hashCode() {
        Object obj = this.f3077a;
        return this.f3080d.hashCode() + s.f.b(this.f3079c, s.f.b(this.f3078b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Range(item=");
        sb2.append(this.f3077a);
        sb2.append(", start=");
        sb2.append(this.f3078b);
        sb2.append(", end=");
        sb2.append(this.f3079c);
        sb2.append(", tag=");
        return k0.a.s(sb2, this.f3080d, ')');
    }

    public e(int i, int i3, Object obj) {
        this(i, i3, obj, "");
    }
}
