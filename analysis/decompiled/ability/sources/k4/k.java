package k4;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f4805a;
    public final String b;
    public final String c;

    public k(String str, String str2, String str3) {
        this.f4805a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.k.b(this.f4805a, kVar.f4805a) && kotlin.jvm.internal.k.b(this.b, kVar.b) && kotlin.jvm.internal.k.b(this.c, kVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + B7.a.c(this.f4805a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return B7.a.q(B7.a.w("CacheKey(key=", this.f4805a, ", packageName=", this.b, ", signatureMd5="), this.c, ")");
    }
}
