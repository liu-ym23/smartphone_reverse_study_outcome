package o4;

import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f7387a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7388b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7389c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7390d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7391e;

    public i(String str, String str2, String str3, String str4, boolean z4) {
        q7.k.e(str, "role");
        this.f7387a = str;
        this.f7388b = str2;
        this.f7389c = str3;
        this.f7390d = str4;
        this.f7391e = z4;
    }

    public final boolean a() {
        if (this.f7391e) {
            return true;
        }
        String str = this.f7390d;
        if (str == null) {
            return false;
        }
        Set set = u.D;
        String upperCase = str.toUpperCase(Locale.ROOT);
        q7.k.d(upperCase, "toUpperCase(...)");
        return set.contains(upperCase);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f7387a, iVar.f7387a) && q7.k.a(this.f7388b, iVar.f7388b) && q7.k.a(this.f7389c, iVar.f7389c) && q7.k.a(this.f7390d, iVar.f7390d) && this.f7391e == iVar.f7391e;
    }

    public final int hashCode() {
        int iG = m.x.g(this.f7388b, this.f7387a.hashCode() * 31, 31);
        String str = this.f7389c;
        int iHashCode = (iG + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7390d;
        return Boolean.hashCode(this.f7391e) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("HistoryMessage(role=", this.f7387a, ", text=", this.f7388b, ", runId=");
        m.x.w(sbP, this.f7389c, ", stopReason=", this.f7390d, ", hasPendingToolCall=");
        sbP.append(this.f7391e);
        sbP.append(")");
        return sbP.toString();
    }
}
