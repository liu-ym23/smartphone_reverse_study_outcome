package Q9;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5464a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5465b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String name, String descriptor) {
        super(null);
        p.i(name, "name");
        p.i(descriptor, "descriptor");
        this.f5464a = name;
        this.f5465b = descriptor;
    }

    public String a() {
        return this.f5465b;
    }

    public String b() {
        return this.f5464a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return p.d(this.f5464a, aVar.f5464a) && p.d(this.f5465b, aVar.f5465b);
    }

    public int hashCode() {
        return (this.f5464a.hashCode() * 31) + this.f5465b.hashCode();
    }

    public String toString() {
        return b() + ':' + a();
    }
}
