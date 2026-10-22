package k4;

/* loaded from: classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f4818a;
    public final String b;

    public x(int i, String str) {
        this.f4818a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f4818a == xVar.f4818a && kotlin.jvm.internal.k.b(this.b, xVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f4818a) * 31);
    }

    public final String toString() {
        return "Response(code=" + this.f4818a + ", body=" + this.b + ")";
    }
}
