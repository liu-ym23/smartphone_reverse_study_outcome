package uc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends t {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13214a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13215b;

    public m(String body, boolean z) {
        kotlin.jvm.internal.g.f(body, "body");
        this.f13214a = z;
        this.f13215b = body.toString();
    }

    @Override // uc.t
    public final String a() {
        return this.f13215b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f13214a == mVar.f13214a && kotlin.jvm.internal.g.b(this.f13215b, mVar.f13215b);
    }

    public final int hashCode() {
        return this.f13215b.hashCode() + (Boolean.hashCode(this.f13214a) * 31);
    }

    @Override // uc.t
    public final String toString() {
        boolean z = this.f13214a;
        String str = this.f13215b;
        if (!z) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        vc.n.a(sb2, str);
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
