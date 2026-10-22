package F8;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class e extends S0.b {

    /* renamed from: q, reason: collision with root package name */
    public final String f593q;

    /* renamed from: r, reason: collision with root package name */
    public final String f594r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String name, String desc) {
        super(3);
        k.f(name, "name");
        k.f(desc, "desc");
        this.f593q = name;
        this.f594r = desc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.b(this.f593q, eVar.f593q) && k.b(this.f594r, eVar.f594r);
    }

    @Override // S0.b
    public final String g0() {
        return this.f593q + this.f594r;
    }

    public final int hashCode() {
        return this.f594r.hashCode() + (this.f593q.hashCode() * 31);
    }
}
