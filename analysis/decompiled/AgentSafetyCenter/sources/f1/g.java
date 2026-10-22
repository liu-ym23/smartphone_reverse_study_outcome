package f1;

import d1.i;
import td.h;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: e, reason: collision with root package name */
    public final float f3865e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3866f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3867g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3868h;
    public final i i;

    public g(float f5, float f10, int i, int i3, i iVar, int i10) {
        f10 = (i10 & 2) != 0 ? 4.0f : f10;
        i = (i10 & 4) != 0 ? 0 : i;
        i3 = (i10 & 8) != 0 ? 0 : i3;
        iVar = (i10 & 16) != 0 ? null : iVar;
        this.f3865e = f5;
        this.f3866f = f10;
        this.f3867g = i;
        this.f3868h = i3;
        this.i = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3865e == gVar.f3865e && this.f3866f == gVar.f3866f && this.f3867g == gVar.f3867g && this.f3868h == gVar.f3868h && k.a(this.i, gVar.i);
    }

    public final int hashCode() {
        int iB = s.f.b(this.f3868h, s.f.b(this.f3867g, k0.a.g(Float.hashCode(this.f3865e) * 31, this.f3866f, 31), 31), 31);
        i iVar = this.i;
        return iB + (iVar != null ? iVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Stroke(width=");
        sb2.append(this.f3865e);
        sb2.append(", miter=");
        sb2.append(this.f3866f);
        sb2.append(", cap=");
        String str = "Unknown";
        int i = this.f3867g;
        sb2.append((Object) (i == 0 ? "Butt" : i == 1 ? "Round" : i == 2 ? "Square" : "Unknown"));
        sb2.append(", join=");
        int i3 = this.f3868h;
        if (i3 == 0) {
            str = "Miter";
        } else if (i3 == 1) {
            str = "Round";
        } else if (i3 == 2) {
            str = "Bevel";
        }
        sb2.append((Object) str);
        sb2.append(", pathEffect=");
        sb2.append(this.i);
        sb2.append(')');
        return sb2.toString();
    }
}
