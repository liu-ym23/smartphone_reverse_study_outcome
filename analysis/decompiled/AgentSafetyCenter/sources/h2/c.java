package h2;

import com.stepos.statsrpk.h;
import d2.g;
import d2.k0;
import d2.x;
import d2.y;
import t0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final g f5283a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5284b;

    /* renamed from: c, reason: collision with root package name */
    public final k0 f5285c;

    static {
        l.a(new x(26), new y(14));
    }

    public c(g gVar, long j10) {
        this.f5283a = gVar;
        int length = gVar.f3101f.length();
        int i = k0.f3135c;
        int i3 = (int) (j10 >> 32);
        int i10 = i3 < 0 ? 0 : i3;
        i10 = i10 > length ? length : i10;
        int i11 = (int) (4294967295L & j10);
        int i12 = i11 >= 0 ? i11 : 0;
        length = i12 <= length ? i12 : length;
        this.f5284b = (i10 == i3 && length == i11) ? j10 : h.a(i10, length);
        this.f5285c = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j10 = cVar.f5284b;
        int i = k0.f3135c;
        return this.f5284b == j10 && k.a(this.f5285c, cVar.f5285c) && this.f5283a.equals(cVar.f5283a);
    }

    public final int hashCode() {
        int iHashCode = this.f5283a.hashCode() * 31;
        int i = k0.f3135c;
        int i3 = k0.a.i(this.f5284b, iHashCode, 31);
        k0 k0Var = this.f5285c;
        return i3 + (k0Var != null ? Long.hashCode(k0Var.f3136a) : 0);
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.f5283a) + "', selection=" + ((Object) k0.b(this.f5284b)) + ", composition=" + this.f5285c + ')';
    }
}
