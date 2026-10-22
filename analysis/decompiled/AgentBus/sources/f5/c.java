package f5;

import java.io.File;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f3439a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3440b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3441c;

    public c(File file, int i2, String str) {
        this.f3439a = file;
        this.f3440b = i2;
        this.f3441c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a(this.f3439a, cVar.f3439a) && this.f3440b == cVar.f3440b && k.a(this.f3441c, cVar.f3441c);
    }

    public final int hashCode() {
        return this.f3441c.hashCode() + n.f.b(this.f3440b, this.f3439a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BlobMeta(file=");
        sb2.append(this.f3439a);
        sb2.append(", size=");
        sb2.append(this.f3440b);
        sb2.append(", mime=");
        return a1.a.m(sb2, this.f3441c, ")");
    }
}
