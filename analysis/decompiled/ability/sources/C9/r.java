package C9;

/* loaded from: classes4.dex */
public final class r extends B {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f332a;
    public final z9.g b;
    public final String c;

    public r(Object body, boolean z10, z9.g gVar) {
        kotlin.jvm.internal.k.f(body, "body");
        this.f332a = z10;
        this.b = gVar;
        this.c = body.toString();
        if (gVar != null && !gVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override // C9.B
    public final String b() {
        return this.c;
    }

    @Override // C9.B
    public final boolean e() {
        return this.f332a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f332a == rVar.f332a && kotlin.jvm.internal.k.b(this.c, rVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (Boolean.hashCode(this.f332a) * 31);
    }

    @Override // C9.B
    public final String toString() {
        boolean z10 = this.f332a;
        String str = this.c;
        if (!z10) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        D9.u.a(sb, str);
        return sb.toString();
    }
}
