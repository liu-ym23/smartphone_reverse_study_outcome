package k4;

/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final String f4814a;
    public final u b;
    public final String c;

    public t(String str, u uVar, String rateLimitKey) {
        kotlin.jvm.internal.k.f(rateLimitKey, "rateLimitKey");
        this.f4814a = str;
        this.b = uVar;
        this.c = rateLimitKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.k.b(this.f4814a, tVar.f4814a) && kotlin.jvm.internal.k.b(this.b, tVar.b) && kotlin.jvm.internal.k.b(this.c, tVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f4814a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("McpPrincipal(credential=");
        sb.append(this.f4814a);
        sb.append(", scope=");
        sb.append(this.b);
        sb.append(", rateLimitKey=");
        return B7.a.q(sb, this.c, ")");
    }
}
