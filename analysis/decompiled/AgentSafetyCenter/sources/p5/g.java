package p5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f9726a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9727b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9728c;

    public g(String str, int i, int i3) {
        str.getClass();
        this.f9726a = str;
        this.f9727b = i;
        this.f9728c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return yb.k.a(this.f9726a, gVar.f9726a) && this.f9727b == gVar.f9727b && this.f9728c == gVar.f9728c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9728c) + s.f.b(this.f9727b, this.f9726a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SystemIdInfo(workSpecId=");
        sb2.append(this.f9726a);
        sb2.append(", generation=");
        sb2.append(this.f9727b);
        sb2.append(", systemId=");
        return androidx.activity.b.l(sb2, this.f9728c, ')');
    }
}
