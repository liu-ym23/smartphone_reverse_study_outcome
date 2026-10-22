package s4;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f5986a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;

    public /* synthetic */ g(int i, String str, String str2) {
        this(str, (i & 2) != 0 ? null : str2, null, null, null, false, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.b(this.f5986a, gVar.f5986a) && k.b(this.b, gVar.b) && k.b(this.c, gVar.c) && k.b(this.d, gVar.d) && k.b(this.e, gVar.e) && this.f == gVar.f && this.g == gVar.g;
    }

    public final int hashCode() {
        int iHashCode = this.f5986a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        return Boolean.hashCode(this.g) + androidx.appfunctions.metadata.a.d((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31, 31, this.f);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("PolicyDetail(function=", this.f5986a, ", scope=", this.b, ", groupId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.c, ", mode=", this.d, ", dataLevel=");
        sbW.append(this.e);
        sbW.append(", redline=");
        sbW.append(this.f);
        sbW.append(", allowed=");
        return B7.a.s(sbW, this.g, ")");
    }

    public g(String function, String str, String str2, String str3, String str4, boolean z10, boolean z11) {
        k.f(function, "function");
        this.f5986a = function;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z10;
        this.g = z11;
    }
}
