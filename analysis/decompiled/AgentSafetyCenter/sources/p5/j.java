package p5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f9734a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9735b;

    public j(String str, int i) {
        str.getClass();
        this.f9734a = str;
        this.f9735b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return yb.k.a(this.f9734a, jVar.f9734a) && this.f9735b == jVar.f9735b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9735b) + (this.f9734a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb2.append(this.f9734a);
        sb2.append(", generation=");
        return androidx.activity.b.l(sb2, this.f9735b, ')');
    }
}
