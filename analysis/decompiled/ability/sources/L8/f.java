package L8;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final G8.b f938a;
    public final int b;

    public f(G8.b bVar, int i) {
        this.f938a = bVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.k.b(this.f938a, fVar.f938a) && this.b == fVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f938a.hashCode() * 31);
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        while (true) {
            i = this.b;
            if (i6 >= i) {
                break;
            }
            sb.append("kotlin/Array<");
            i6++;
        }
        sb.append(this.f938a);
        for (int i10 = 0; i10 < i; i10++) {
            sb.append(">");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }
}
