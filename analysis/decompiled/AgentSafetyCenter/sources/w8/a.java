package w8;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f15367a;

    /* renamed from: b, reason: collision with root package name */
    public String f15368b;

    /* renamed from: c, reason: collision with root package name */
    public String f15369c;

    /* renamed from: d, reason: collision with root package name */
    public String f15370d;

    /* renamed from: e, reason: collision with root package name */
    public long f15371e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f15367a, aVar.f15367a) && k.a(this.f15368b, aVar.f15368b) && k.a(this.f15369c, aVar.f15369c) && k.a(this.f15370d, aVar.f15370d) && this.f15371e == aVar.f15371e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f15371e) + androidx.activity.b.d(androidx.activity.b.d(androidx.activity.b.d(this.f15367a.hashCode() * 31, 31, this.f15368b), 31, this.f15369c), 31, this.f15370d);
    }

    public final String toString() {
        String str = this.f15367a;
        String str2 = this.f15368b;
        String str3 = this.f15369c;
        String str4 = this.f15370d;
        long j10 = this.f15371e;
        StringBuilder sbP = androidx.activity.b.p("HiddenNote(reservedId=", str, ", uuid=", str2, ", title=");
        androidx.activity.b.u(sbP, str3, ", content=", str4, ", modifiedMillis=");
        sbP.append(j10);
        sbP.append(")");
        return sbP.toString();
    }
}
