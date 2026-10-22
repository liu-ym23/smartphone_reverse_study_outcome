package d2;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final g f3106a;

    /* renamed from: b, reason: collision with root package name */
    public final l0 f3107b;

    /* renamed from: c, reason: collision with root package name */
    public final List f3108c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3109d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3110e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3111f;

    /* renamed from: g, reason: collision with root package name */
    public final o2.c f3112g;

    /* renamed from: h, reason: collision with root package name */
    public final o2.l f3113h;
    public final g2.d i;

    /* renamed from: j, reason: collision with root package name */
    public final long f3114j;

    public h0(g gVar, l0 l0Var, List list, int i, boolean z10, int i3, o2.c cVar, o2.l lVar, g2.d dVar, long j10) {
        this.f3106a = gVar;
        this.f3107b = l0Var;
        this.f3108c = list;
        this.f3109d = i;
        this.f3110e = z10;
        this.f3111f = i3;
        this.f3112g = cVar;
        this.f3113h = lVar;
        this.i = dVar;
        this.f3114j = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return yb.k.a(this.f3106a, h0Var.f3106a) && yb.k.a(this.f3107b, h0Var.f3107b) && this.f3108c.equals(h0Var.f3108c) && this.f3109d == h0Var.f3109d && this.f3110e == h0Var.f3110e && this.f3111f == h0Var.f3111f && yb.k.a(this.f3112g, h0Var.f3112g) && this.f3113h == h0Var.f3113h && yb.k.a(this.i, h0Var.i) && o2.a.c(this.f3114j, h0Var.f3114j);
    }

    public final int hashCode() {
        return Long.hashCode(this.f3114j) + ((this.i.hashCode() + ((this.f3113h.hashCode() + ((this.f3112g.hashCode() + s.f.b(this.f3111f, k0.a.h((androidx.activity.b.e(this.f3108c, (this.f3107b.hashCode() + (this.f3106a.hashCode() * 31)) * 31, 31) + this.f3109d) * 31, 31, this.f3110e), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextLayoutInput(text=");
        sb2.append((Object) this.f3106a);
        sb2.append(", style=");
        sb2.append(this.f3107b);
        sb2.append(", placeholders=");
        sb2.append(this.f3108c);
        sb2.append(", maxLines=");
        sb2.append(this.f3109d);
        sb2.append(", softWrap=");
        sb2.append(this.f3110e);
        sb2.append(", overflow=");
        int i = this.f3111f;
        sb2.append((Object) (i == 1 ? "Clip" : i == 2 ? "Ellipsis" : i == 5 ? "MiddleEllipsis" : i == 3 ? "Visible" : i == 4 ? "StartEllipsis" : "Invalid"));
        sb2.append(", density=");
        sb2.append(this.f3112g);
        sb2.append(", layoutDirection=");
        sb2.append(this.f3113h);
        sb2.append(", fontFamilyResolver=");
        sb2.append(this.i);
        sb2.append(", constraints=");
        sb2.append((Object) o2.a.m(this.f3114j));
        sb2.append(')');
        return sb2.toString();
    }
}
