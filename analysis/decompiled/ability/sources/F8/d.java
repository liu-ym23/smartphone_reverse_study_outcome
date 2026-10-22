package F8;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class d extends S0.b {

    /* renamed from: q, reason: collision with root package name */
    public final String f591q;

    /* renamed from: r, reason: collision with root package name */
    public final String f592r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String name, String desc) {
        super(3);
        k.f(name, "name");
        k.f(desc, "desc");
        this.f591q = name;
        this.f592r = desc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.b(this.f591q, dVar.f591q) && k.b(this.f592r, dVar.f592r);
    }

    @Override // S0.b
    public final String g0() {
        return this.f591q + ':' + this.f592r;
    }

    public final int hashCode() {
        return this.f592r.hashCode() + (this.f591q.hashCode() * 31);
    }
}
