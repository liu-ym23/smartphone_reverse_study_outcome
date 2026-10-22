package k4;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f4797a;
    public final String b;

    public c(String str, String str2) {
        this.f4797a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.k.b(this.f4797a, cVar.f4797a) && kotlin.jvm.internal.k.b(this.b, cVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f4797a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.m("AppIdentity(packageName=", this.f4797a, ", signatureMd5=", this.b, ")");
    }
}
