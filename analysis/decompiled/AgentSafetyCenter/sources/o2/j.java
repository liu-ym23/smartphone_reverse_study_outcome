package o2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f9117e = new j(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f9118a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9119b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9120c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9121d;

    public j(int i, int i3, int i10, int i11) {
        this.f9118a = i;
        this.f9119b = i3;
        this.f9120c = i10;
        this.f9121d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9118a == jVar.f9118a && this.f9119b == jVar.f9119b && this.f9120c == jVar.f9120c && this.f9121d == jVar.f9121d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9121d) + s.f.b(this.f9120c, s.f.b(this.f9119b, Integer.hashCode(this.f9118a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("IntRect.fromLTRB(");
        sb2.append(this.f9118a);
        sb2.append(", ");
        sb2.append(this.f9119b);
        sb2.append(", ");
        sb2.append(this.f9120c);
        sb2.append(", ");
        return androidx.activity.b.l(sb2, this.f9121d, ')');
    }
}
