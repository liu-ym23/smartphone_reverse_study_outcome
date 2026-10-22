package s8;

import java.time.format.DateTimeFormatter;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public String f11817a;

    /* renamed from: b, reason: collision with root package name */
    public String f11818b;

    /* renamed from: c, reason: collision with root package name */
    public DateTimeFormatter f11819c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return this.f11817a.equals(n1Var.f11817a) && this.f11818b.equals(n1Var.f11818b) && this.f11819c.equals(n1Var.f11819c);
    }

    public final int hashCode() {
        return this.f11819c.hashCode() + androidx.activity.b.d(this.f11817a.hashCode() * 31, 31, this.f11818b);
    }

    public final String toString() {
        String str = this.f11817a;
        String str2 = this.f11818b;
        DateTimeFormatter dateTimeFormatter = this.f11819c;
        StringBuilder sbP = androidx.activity.b.p("DaySectionLabels(today=", str, ", yesterday=", str2, ", monthDayFormatter=");
        sbP.append(dateTimeFormatter);
        sbP.append(")");
        return sbP.toString();
    }
}
