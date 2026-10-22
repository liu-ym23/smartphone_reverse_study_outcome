package g7;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4488a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public b(String str, String str2, String str3, String str4, boolean z10) {
        this.f4488a = z10;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4488a == bVar.f4488a && k.b(this.b, bVar.b) && k.b(this.c, bVar.c) && k.b(this.d, bVar.d) && k.b(this.e, bVar.e);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f4488a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbilityResult(success=");
        sb.append(this.f4488a);
        sb.append(", content=");
        sb.append(this.b);
        sb.append(", extra=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.c, ", errorCode=", this.d, ", errorMessage=");
        return B7.a.q(sb, this.e, ")");
    }
}
