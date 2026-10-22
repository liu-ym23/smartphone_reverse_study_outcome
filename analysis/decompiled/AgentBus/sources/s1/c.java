package s1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9229a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9230b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9231c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9232d;

    public c(Object obj, int i2, int i10, String str) {
        this.f9229a = obj;
        this.f9230b = i2;
        this.f9231c = i10;
        this.f9232d = str;
        if (i2 <= i10) {
            return;
        }
        x1.a.a("Reversed range is not supported");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q7.k.a(this.f9229a, cVar.f9229a) && this.f9230b == cVar.f9230b && this.f9231c == cVar.f9231c && q7.k.a(this.f9232d, cVar.f9232d);
    }

    public final int hashCode() {
        Object obj = this.f9229a;
        return this.f9232d.hashCode() + n.f.b(this.f9231c, n.f.b(this.f9230b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Range(item=");
        sb2.append(this.f9229a);
        sb2.append(", start=");
        sb2.append(this.f9230b);
        sb2.append(", end=");
        sb2.append(this.f9231c);
        sb2.append(", tag=");
        return a1.a.l(sb2, this.f9232d, ')');
    }

    public c(int i2, int i10, Object obj) {
        this(obj, i2, i10, "");
    }
}
