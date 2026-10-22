package f5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3435a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3436b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3437c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3438d;

    public a(String str, String str2, int i2, String str3) {
        k.e(str, "uri");
        k.e(str2, "sha256");
        this.f3435a = str;
        this.f3436b = str2;
        this.f3437c = i2;
        this.f3438d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f3435a, aVar.f3435a) && k.a(this.f3436b, aVar.f3436b) && this.f3437c == aVar.f3437c && k.a(this.f3438d, aVar.f3438d);
    }

    public final int hashCode() {
        return this.f3438d.hashCode() + n.f.b(this.f3437c, x.g(this.f3436b, this.f3435a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("BlobRef(uri=", this.f3435a, ", sha256=", this.f3436b, ", size=");
        sbP.append(this.f3437c);
        sbP.append(", mime=");
        sbP.append(this.f3438d);
        sbP.append(")");
        return sbP.toString();
    }
}
