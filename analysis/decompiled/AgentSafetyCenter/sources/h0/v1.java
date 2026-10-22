package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    public final d2.l0 f5212a;

    /* renamed from: b, reason: collision with root package name */
    public final d2.l0 f5213b;

    /* renamed from: c, reason: collision with root package name */
    public final d2.l0 f5214c;

    /* renamed from: d, reason: collision with root package name */
    public final d2.l0 f5215d;

    /* renamed from: e, reason: collision with root package name */
    public final d2.l0 f5216e;

    /* renamed from: f, reason: collision with root package name */
    public final d2.l0 f5217f;

    /* renamed from: g, reason: collision with root package name */
    public final d2.l0 f5218g;

    /* renamed from: h, reason: collision with root package name */
    public final d2.l0 f5219h;
    public final d2.l0 i;

    /* renamed from: j, reason: collision with root package name */
    public final d2.l0 f5220j;

    /* renamed from: k, reason: collision with root package name */
    public final d2.l0 f5221k;

    /* renamed from: l, reason: collision with root package name */
    public final d2.l0 f5222l;

    /* renamed from: m, reason: collision with root package name */
    public final d2.l0 f5223m;

    /* renamed from: n, reason: collision with root package name */
    public final d2.l0 f5224n;

    /* renamed from: o, reason: collision with root package name */
    public final d2.l0 f5225o;

    public v1(d2.l0 l0Var, int i) {
        d2.l0 l0Var2 = j0.o.f6524d;
        d2.l0 l0Var3 = j0.o.f6525e;
        d2.l0 l0Var4 = j0.o.f6526f;
        d2.l0 l0Var5 = j0.o.f6527g;
        d2.l0 l0Var6 = j0.o.f6528h;
        d2.l0 l0Var7 = j0.o.i;
        d2.l0 l0Var8 = j0.o.f6532m;
        d2.l0 l0Var9 = j0.o.f6533n;
        d2.l0 l0Var10 = j0.o.f6534o;
        l0Var = (i & 512) != 0 ? j0.o.f6521a : l0Var;
        d2.l0 l0Var11 = j0.o.f6522b;
        d2.l0 l0Var12 = j0.o.f6523c;
        d2.l0 l0Var13 = j0.o.f6529j;
        d2.l0 l0Var14 = j0.o.f6530k;
        d2.l0 l0Var15 = j0.o.f6531l;
        this.f5212a = l0Var2;
        this.f5213b = l0Var3;
        this.f5214c = l0Var4;
        this.f5215d = l0Var5;
        this.f5216e = l0Var6;
        this.f5217f = l0Var7;
        this.f5218g = l0Var8;
        this.f5219h = l0Var9;
        this.i = l0Var10;
        this.f5220j = l0Var;
        this.f5221k = l0Var11;
        this.f5222l = l0Var12;
        this.f5223m = l0Var13;
        this.f5224n = l0Var14;
        this.f5225o = l0Var15;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return yb.k.a(this.f5212a, v1Var.f5212a) && yb.k.a(this.f5213b, v1Var.f5213b) && yb.k.a(this.f5214c, v1Var.f5214c) && yb.k.a(this.f5215d, v1Var.f5215d) && yb.k.a(this.f5216e, v1Var.f5216e) && yb.k.a(this.f5217f, v1Var.f5217f) && yb.k.a(this.f5218g, v1Var.f5218g) && yb.k.a(this.f5219h, v1Var.f5219h) && yb.k.a(this.i, v1Var.i) && yb.k.a(this.f5220j, v1Var.f5220j) && yb.k.a(this.f5221k, v1Var.f5221k) && yb.k.a(this.f5222l, v1Var.f5222l) && yb.k.a(this.f5223m, v1Var.f5223m) && yb.k.a(this.f5224n, v1Var.f5224n) && yb.k.a(this.f5225o, v1Var.f5225o);
    }

    public final int hashCode() {
        return this.f5225o.hashCode() + ((this.f5224n.hashCode() + ((this.f5223m.hashCode() + ((this.f5222l.hashCode() + ((this.f5221k.hashCode() + ((this.f5220j.hashCode() + ((this.i.hashCode() + ((this.f5219h.hashCode() + ((this.f5218g.hashCode() + ((this.f5217f.hashCode() + ((this.f5216e.hashCode() + ((this.f5215d.hashCode() + ((this.f5214c.hashCode() + ((this.f5213b.hashCode() + (this.f5212a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Typography(displayLarge=" + this.f5212a + ", displayMedium=" + this.f5213b + ",displaySmall=" + this.f5214c + ", headlineLarge=" + this.f5215d + ", headlineMedium=" + this.f5216e + ", headlineSmall=" + this.f5217f + ", titleLarge=" + this.f5218g + ", titleMedium=" + this.f5219h + ", titleSmall=" + this.i + ", bodyLarge=" + this.f5220j + ", bodyMedium=" + this.f5221k + ", bodySmall=" + this.f5222l + ", labelLarge=" + this.f5223m + ", labelMedium=" + this.f5224n + ", labelSmall=" + this.f5225o + ')';
    }
}
