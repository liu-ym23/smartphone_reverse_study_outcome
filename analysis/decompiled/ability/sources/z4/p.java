package z4;

import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f6971a;
    public final String b;
    public final String c;
    public final LinkedHashMap d;

    public p(int i, String str, String str2, LinkedHashMap linkedHashMap) {
        this.f6971a = i;
        this.b = str;
        this.c = str2;
        this.d = linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f6971a == pVar.f6971a && kotlin.jvm.internal.k.b(this.b, pVar.b) && kotlin.jvm.internal.k.b(this.c, pVar.c) && this.d.equals(pVar.d);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f6971a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return this.d.hashCode() + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(this.f6971a, "PermissionAuthSession(errorCode=", ", businessContent=", this.b, ", appName=");
        sbK.append(this.c);
        sbK.append(", executionGrant=");
        sbK.append(this.d);
        sbK.append(")");
        return sbK.toString();
    }
}
