package z4;

import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6964a;
    public final int b;
    public final String c;
    public final String d;

    public i(int i, String str, String str2, LinkedHashMap linkedHashMap) {
        this.f6964a = linkedHashMap;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6964a.equals(iVar.f6964a) && this.b == iVar.b && kotlin.jvm.internal.k.b(this.c, iVar.c) && kotlin.jvm.internal.k.b(this.d, iVar.d);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, this.f6964a.hashCode() * 31, 31);
        String str = this.c;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PermissionAuthInspected(envelope=");
        sb.append(this.f6964a);
        sb.append(", errorCode=");
        sb.append(this.b);
        sb.append(", businessContent=");
        return androidx.appfunctions.metadata.a.p(sb, this.c, ", appName=", this.d, ")");
    }
}
