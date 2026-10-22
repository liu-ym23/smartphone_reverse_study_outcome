package s8;

import java.time.LocalDate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public final LocalDate f11461a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11462b;

    /* renamed from: c, reason: collision with root package name */
    public final LocalDate f11463c;

    public b2(LocalDate localDate, int i, LocalDate localDate2) {
        this.f11461a = localDate;
        this.f11462b = i;
        this.f11463c = localDate2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f11461a.equals(b2Var.f11461a) && this.f11462b == b2Var.f11462b && this.f11463c.equals(b2Var.f11463c);
    }

    public final int hashCode() {
        return this.f11463c.hashCode() + s.f.b(this.f11462b, this.f11461a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "HomeSecurityReport(sinceDay=" + this.f11461a + ", guardedDays=" + this.f11462b + ", untilDay=" + this.f11463c + ")";
    }
}
