package z8;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String f6988a;

    public r(String str) {
        this.f6988a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && kotlin.jvm.internal.k.b(this.f6988a, ((r) obj).f6988a);
    }

    public final int hashCode() {
        return this.f6988a.hashCode();
    }

    public final String toString() {
        return B7.a.g(')', this.f6988a, new StringBuilder("MemberSignature(signature="));
    }
}
