package i1;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public String f5720c;

    /* renamed from: f, reason: collision with root package name */
    public List f5721f;

    /* renamed from: g, reason: collision with root package name */
    public int f5722g;

    /* renamed from: h, reason: collision with root package name */
    public d1.f0 f5723h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public d1.f0 f5724j;

    /* renamed from: k, reason: collision with root package name */
    public float f5725k;

    /* renamed from: l, reason: collision with root package name */
    public float f5726l;

    /* renamed from: m, reason: collision with root package name */
    public int f5727m;

    /* renamed from: n, reason: collision with root package name */
    public int f5728n;

    /* renamed from: o, reason: collision with root package name */
    public float f5729o;

    /* renamed from: p, reason: collision with root package name */
    public float f5730p;

    /* renamed from: q, reason: collision with root package name */
    public float f5731q;

    /* renamed from: r, reason: collision with root package name */
    public float f5732r;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f5720c.equals(k0Var.f5720c) && yb.k.a(this.f5723h, k0Var.f5723h) && this.i == k0Var.i && yb.k.a(this.f5724j, k0Var.f5724j) && this.f5725k == k0Var.f5725k && this.f5726l == k0Var.f5726l && this.f5727m == k0Var.f5727m && this.f5728n == k0Var.f5728n && this.f5729o == k0Var.f5729o && this.f5730p == k0Var.f5730p && this.f5731q == k0Var.f5731q && this.f5732r == k0Var.f5732r && this.f5722g == k0Var.f5722g && yb.k.a(this.f5721f, k0Var.f5721f);
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f5721f, this.f5720c.hashCode() * 31, 31);
        d1.f0 f0Var = this.f5723h;
        int iG = k0.a.g((iE + (f0Var != null ? f0Var.hashCode() : 0)) * 31, this.i, 31);
        d1.f0 f0Var2 = this.f5724j;
        return Integer.hashCode(this.f5722g) + k0.a.g(k0.a.g(k0.a.g(k0.a.g(s.f.b(this.f5728n, s.f.b(this.f5727m, k0.a.g(k0.a.g((iG + (f0Var2 != null ? f0Var2.hashCode() : 0)) * 31, this.f5725k, 31), this.f5726l, 31), 31), 31), this.f5729o, 31), this.f5730p, 31), this.f5731q, 31), this.f5732r, 31);
    }
}
