package s4;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5987a;
    public final int b;
    public final String c;
    public final String d;
    public final List e;

    public h(boolean z10, int i, String str, String str2, List details) {
        k.f(details, "details");
        this.f5987a = z10;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = details;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f5987a == hVar.f5987a && this.b == hVar.b && k.b(this.c, hVar.c) && k.b(this.d, hVar.d) && k.b(this.e, hVar.e);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, Boolean.hashCode(this.f5987a) * 31, 31);
        String str = this.c;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PolicyVerdict(canExecute=");
        sb.append(this.f5987a);
        sb.append(", denyReason=");
        sb.append(this.b);
        sb.append(", deniedFunction=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.c, ", reason=", this.d, ", details=");
        return androidx.appfunctions.metadata.a.q(sb, this.e, ")");
    }

    public h(boolean z10, int i, String str, String str2, ArrayList arrayList, int i6) {
        this(z10, i, (i6 & 4) != 0 ? null : str, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? EmptyList.f4893a : arrayList);
    }
}
