package u5;

import kotlin.jvm.internal.k;

/* renamed from: u5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2037a {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6707a;
    public final String b;

    public C2037a(Class cls, String str) {
        this.f6707a = cls;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2037a)) {
            return false;
        }
        C2037a c2037a = (C2037a) obj;
        return k.b(this.f6707a, c2037a.f6707a) && k.b(this.b, c2037a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f6707a.hashCode() * 31);
    }

    public final String toString() {
        return "ServiceKey(cls=" + this.f6707a + ", baseUrlKey=" + this.b + ")";
    }
}
