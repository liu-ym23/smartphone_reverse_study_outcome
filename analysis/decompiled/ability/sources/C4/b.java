package C4;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f291a;
    public final int b;
    public final int c;
    public final int d;

    public b(int i, int i6, int i10, int i11) {
        this.f291a = i;
        this.b = i6;
        this.c = i10;
        this.d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f291a == bVar.f291a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + androidx.constraintlayout.core.dsl.a.a(this.c, androidx.constraintlayout.core.dsl.a.a(this.b, Integer.hashCode(this.f291a) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.f291a, "ConfLevels(firstKwLevel=", this.b, ", firstUserLevel=", ", secondKwLevel=");
        sbS.append(this.c);
        sbS.append(", secondUserLevel=");
        sbS.append(this.d);
        sbS.append(")");
        return sbS.toString();
    }
}
