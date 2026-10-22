package s1;

import java.util.List;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final e f9235a;

    /* renamed from: b, reason: collision with root package name */
    public final h0 f9236b;

    /* renamed from: c, reason: collision with root package name */
    public final List f9237c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9238d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9239e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9240f;

    /* renamed from: g, reason: collision with root package name */
    public final d2.c f9241g;

    /* renamed from: h, reason: collision with root package name */
    public final d2.l f9242h;

    /* renamed from: i, reason: collision with root package name */
    public final v1.d f9243i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9244j;

    public d0(e eVar, h0 h0Var, List list, int i2, boolean z4, int i10, d2.c cVar, d2.l lVar, v1.d dVar, long j2) {
        this.f9235a = eVar;
        this.f9236b = h0Var;
        this.f9237c = list;
        this.f9238d = i2;
        this.f9239e = z4;
        this.f9240f = i10;
        this.f9241g = cVar;
        this.f9242h = lVar;
        this.f9243i = dVar;
        this.f9244j = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return q7.k.a(this.f9235a, d0Var.f9235a) && q7.k.a(this.f9236b, d0Var.f9236b) && this.f9237c.equals(d0Var.f9237c) && this.f9238d == d0Var.f9238d && this.f9239e == d0Var.f9239e && this.f9240f == d0Var.f9240f && q7.k.a(this.f9241g, d0Var.f9241g) && this.f9242h == d0Var.f9242h && q7.k.a(this.f9243i, d0Var.f9243i) && d2.a.b(this.f9244j, d0Var.f9244j);
    }

    public final int hashCode() {
        return Long.hashCode(this.f9244j) + ((this.f9243i.hashCode() + ((this.f9242h.hashCode() + ((this.f9241g.hashCode() + n.f.b(this.f9240f, m.x.e((m.x.h(this.f9237c, (this.f9236b.hashCode() + (this.f9235a.hashCode() * 31)) * 31, 31) + this.f9238d) * 31, 31, this.f9239e), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextLayoutInput(text=");
        sb2.append((Object) this.f9235a);
        sb2.append(", style=");
        sb2.append(this.f9236b);
        sb2.append(", placeholders=");
        sb2.append(this.f9237c);
        sb2.append(", maxLines=");
        sb2.append(this.f9238d);
        sb2.append(", softWrap=");
        sb2.append(this.f9239e);
        sb2.append(", overflow=");
        int i2 = this.f9240f;
        sb2.append((Object) (i2 == 1 ? "Clip" : i2 == 2 ? "Ellipsis" : i2 == 5 ? "MiddleEllipsis" : i2 == 3 ? "Visible" : i2 == 4 ? "StartEllipsis" : "Invalid"));
        sb2.append(", density=");
        sb2.append(this.f9241g);
        sb2.append(", layoutDirection=");
        sb2.append(this.f9242h);
        sb2.append(", fontFamilyResolver=");
        sb2.append(this.f9243i);
        sb2.append(", constraints=");
        sb2.append((Object) d2.a.k(this.f9244j));
        sb2.append(')');
        return sb2.toString();
    }
}
