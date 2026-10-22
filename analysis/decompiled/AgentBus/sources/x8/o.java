package x8;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f11273a;

    public o(String str) {
        this.f11273a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && q7.k.a(this.f11273a, ((o) obj).f11273a);
    }

    public final int hashCode() {
        return this.f11273a.hashCode();
    }

    public final String toString() {
        return a1.a.l(new StringBuilder("MemberSignature(signature="), this.f11273a, ')');
    }
}
