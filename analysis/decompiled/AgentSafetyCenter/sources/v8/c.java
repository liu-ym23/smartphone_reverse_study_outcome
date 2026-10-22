package v8;

import java.util.List;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14857a;

    /* renamed from: b, reason: collision with root package name */
    public final List f14858b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14859c;

    public c(String str, List list, boolean z10) {
        list.getClass();
        this.f14857a = z10;
        this.f14858b = list;
        this.f14859c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14857a == cVar.f14857a && k.a(this.f14858b, cVar.f14858b) && k.a(this.f14859c, cVar.f14859c);
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f14858b, Boolean.hashCode(this.f14857a) * 31, 31);
        String str = this.f14859c;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("QueryBackupResult(success=");
        sb2.append(this.f14857a);
        sb2.append(", contacts=");
        sb2.append(this.f14858b);
        sb2.append(", errorMessage=");
        return androidx.activity.b.n(sb2, this.f14859c, ")");
    }
}
