package a6;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f303a;

    /* renamed from: b, reason: collision with root package name */
    public final String f304b;

    public d0(String str, String str2) {
        this.f303a = str;
        this.f304b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return q7.k.a(this.f303a, d0Var.f303a) && q7.k.a(this.f304b, d0Var.f304b);
    }

    public final int hashCode() {
        return this.f304b.hashCode() + (this.f303a.hashCode() * 31);
    }

    public final String toString() {
        return m.x.x("UpdateRequest(id=", this.f303a, ", blobRef=", this.f304b, ")");
    }
}
