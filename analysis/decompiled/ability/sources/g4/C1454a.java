package g4;

import kotlin.jvm.internal.k;

/* renamed from: g4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1454a {

    /* renamed from: a, reason: collision with root package name */
    public final int f4478a;
    public final String b;

    public C1454a(int i, String str) {
        this.f4478a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1454a)) {
            return false;
        }
        C1454a c1454a = (C1454a) obj;
        return this.f4478a == c1454a.f4478a && k.b(this.b, c1454a.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f4478a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "Inspected(errorCode=" + this.f4478a + ", businessContent=" + this.b + ")";
    }
}
