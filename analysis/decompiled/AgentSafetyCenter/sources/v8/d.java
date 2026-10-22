package v8;

import s.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14861b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14862c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14863d;

    public d(String str, int i, int i3, boolean z10) {
        this.f14860a = z10;
        this.f14861b = i;
        this.f14862c = i3;
        this.f14863d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14860a == dVar.f14860a && this.f14861b == dVar.f14861b && this.f14862c == dVar.f14862c && k.a(this.f14863d, dVar.f14863d);
    }

    public final int hashCode() {
        int iB = f.b(this.f14862c, f.b(this.f14861b, Boolean.hashCode(this.f14860a) * 31, 31), 31);
        String str = this.f14863d;
        return iB + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "RestoreByTruthIdResult(success=" + this.f14860a + ", restoredCount=" + this.f14861b + ", failedCount=" + this.f14862c + ", errorMessage=" + this.f14863d + ")";
    }
}
