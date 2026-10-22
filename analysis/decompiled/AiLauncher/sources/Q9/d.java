package Q9;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5466a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5467b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String name, String descriptor) {
        super(null);
        p.i(name, "name");
        p.i(descriptor, "descriptor");
        this.f5466a = name;
        this.f5467b = descriptor;
    }

    public String a() {
        return this.f5467b;
    }

    public String b() {
        return this.f5466a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return p.d(this.f5466a, dVar.f5466a) && p.d(this.f5467b, dVar.f5467b);
    }

    public int hashCode() {
        return (this.f5466a.hashCode() * 31) + this.f5467b.hashCode();
    }

    public String toString() {
        return b() + a();
    }
}
