package f8;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final j f4446a;
    public final int b;

    public k(j jVar, int i) {
        this.f4446a = jVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.k.b(this.f4446a, kVar.f4446a) && this.b == kVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f4446a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KindWithArity(kind=");
        sb.append(this.f4446a);
        sb.append(", arity=");
        return B7.a.o(sb, this.b, ')');
    }
}
