package Q4;

import java.util.List;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f1115a;
    public final String b;
    public final String c;
    public final boolean d;
    public final List e;

    public l(String str, String str2, String str3, boolean z10, List list) {
        this.f1115a = str;
        this.b = str2;
        this.c = str3;
        this.d = z10;
        this.e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.k.b(this.f1115a, lVar.f1115a) && kotlin.jvm.internal.k.b(this.b, lVar.b) && kotlin.jvm.internal.k.b(this.c, lVar.c) && this.d == lVar.d && kotlin.jvm.internal.k.b(this.e, lVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + androidx.appfunctions.metadata.a.d(B7.a.c(B7.a.c(this.f1115a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("AsrResult(language=", this.f1115a, ", emotion=", this.b, ", event=");
        sbW.append(this.c);
        sbW.append(", withItn=");
        sbW.append(this.d);
        sbW.append(", segments=");
        return androidx.appfunctions.metadata.a.q(sbW, this.e, ")");
    }
}
