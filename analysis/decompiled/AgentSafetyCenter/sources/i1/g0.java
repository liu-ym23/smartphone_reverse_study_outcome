package i1;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends i0 implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public String f5673c;

    /* renamed from: f, reason: collision with root package name */
    public float f5674f;

    /* renamed from: g, reason: collision with root package name */
    public float f5675g;

    /* renamed from: h, reason: collision with root package name */
    public float f5676h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f5677j;

    /* renamed from: k, reason: collision with root package name */
    public float f5678k;

    /* renamed from: l, reason: collision with root package name */
    public float f5679l;

    /* renamed from: m, reason: collision with root package name */
    public List f5680m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f5681n;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return yb.k.a(this.f5673c, g0Var.f5673c) && this.f5674f == g0Var.f5674f && this.f5675g == g0Var.f5675g && this.f5676h == g0Var.f5676h && this.i == g0Var.i && this.f5677j == g0Var.f5677j && this.f5678k == g0Var.f5678k && this.f5679l == g0Var.f5679l && yb.k.a(this.f5680m, g0Var.f5680m) && yb.k.a(this.f5681n, g0Var.f5681n);
    }

    public final int hashCode() {
        return this.f5681n.hashCode() + androidx.activity.b.e(this.f5680m, k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(this.f5673c.hashCode() * 31, this.f5674f, 31), this.f5675g, 31), this.f5676h, 31), this.i, 31), this.f5677j, 31), this.f5678k, 31), this.f5679l, 31), 31);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        f0 f0Var = new f0(0);
        f0Var.f5669f = this.f5681n.iterator();
        VarHandle.storeStoreFence();
        return f0Var;
    }
}
