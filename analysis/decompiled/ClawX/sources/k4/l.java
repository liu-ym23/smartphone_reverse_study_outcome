package k4;

import java.util.Locale;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f3628a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3629b;

    public l(String name, String value) {
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(value, "value");
        this.f3628a = name;
        this.f3629b = value;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return x5.u.W0(lVar.f3628a, this.f3628a) && x5.u.W0(lVar.f3629b, this.f3629b);
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.f3628a.toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f3629b.toLowerCase(locale);
        kotlin.jvm.internal.p.d(lowerCase2, "toLowerCase(...)");
        return lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderValueParam(name=");
        sb.append(this.f3628a);
        sb.append(", value=");
        return m0.f.f(sb, this.f3629b, ", escapeValue=false)");
    }
}
