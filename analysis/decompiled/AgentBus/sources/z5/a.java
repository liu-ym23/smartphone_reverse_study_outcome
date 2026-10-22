package z5;

import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final i f11804a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11805b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11806c;

    public a(String str, String str2, i iVar) {
        this.f11804a = iVar;
        this.f11805b = str;
        this.f11806c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f11804a, aVar.f11804a) && k.a(this.f11805b, aVar.f11805b) && k.a(this.f11806c, aVar.f11806c);
    }

    public final int hashCode() {
        return this.f11806c.hashCode() + x.g(this.f11805b, this.f11804a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PendingUplink(context=");
        sb2.append(this.f11804a);
        sb2.append(", inputText=");
        sb2.append(this.f11805b);
        sb2.append(", frameId=");
        return a1.a.m(sb2, this.f11806c, ")");
    }
}
