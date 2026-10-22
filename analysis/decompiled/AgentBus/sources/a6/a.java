package a6;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f269a;

    /* renamed from: b, reason: collision with root package name */
    public final long f270b;

    /* renamed from: c, reason: collision with root package name */
    public final String f271c;

    public a(String str, String str2, long j2) {
        q7.k.e(str, "blobRef");
        this.f269a = str;
        this.f270b = j2;
        this.f271c = str2;
    }

    public final String a() {
        return this.f269a;
    }

    public final String b() {
        return this.f271c;
    }

    public final long c() {
        return this.f270b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q7.k.a(this.f269a, aVar.f269a) && this.f270b == aVar.f270b && q7.k.a(this.f271c, aVar.f271c);
    }

    public final int hashCode() {
        return this.f271c.hashCode() + m.x.f(this.f270b, this.f269a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackupBlob(blobRef=");
        sb2.append(this.f269a);
        sb2.append(", sizeBytes=");
        sb2.append(this.f270b);
        return m.x.n(sb2, ", mime=", this.f271c, ")");
    }
}
