package ec;

import java.time.LocalDate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: c, reason: collision with root package name */
    public LocalDate f3756c;

    /* renamed from: f, reason: collision with root package name */
    public LocalDate f3757f;

    @Override // ec.d
    public final Comparable a() {
        return this.f3756c;
    }

    @Override // ec.d
    public final Comparable b() {
        return this.f3757f;
    }

    public final boolean equals(Object obj) {
        LocalDate localDate = this.f3757f;
        LocalDate localDate2 = this.f3756c;
        if (!(obj instanceof e)) {
            return false;
        }
        if (localDate2.compareTo((Object) localDate) > 0) {
            e eVar = (e) obj;
            if (eVar.f3756c.compareTo((Object) eVar.f3757f) > 0) {
                return true;
            }
        }
        e eVar2 = (e) obj;
        return localDate2.equals(eVar2.f3756c) && localDate.equals(eVar2.f3757f);
    }

    public final int hashCode() {
        LocalDate localDate = this.f3756c;
        LocalDate localDate2 = this.f3757f;
        if (localDate.compareTo((Object) localDate2) > 0) {
            return -1;
        }
        return localDate2.hashCode() + (localDate.hashCode() * 31);
    }

    public final String toString() {
        return this.f3756c + ".." + this.f3757f;
    }
}
