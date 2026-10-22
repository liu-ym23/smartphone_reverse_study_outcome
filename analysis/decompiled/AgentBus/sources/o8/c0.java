package o8;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final e9.f f7796a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7797b;

    public c0(e9.f fVar, String str) {
        q7.k.e(str, "signature");
        this.f7796a = fVar;
        this.f7797b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return q7.k.a(this.f7796a, c0Var.f7796a) && q7.k.a(this.f7797b, c0Var.f7797b);
    }

    public final int hashCode() {
        return this.f7797b.hashCode() + (this.f7796a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("NameAndSignature(name=");
        sb2.append(this.f7796a);
        sb2.append(", signature=");
        return a1.a.l(sb2, this.f7797b, ')');
    }
}
