package i1;

import k0.h1;
import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends h1.b {
    public k1 i;

    /* renamed from: j, reason: collision with root package name */
    public k1 f5708j;

    /* renamed from: k, reason: collision with root package name */
    public e0 f5709k;

    /* renamed from: l, reason: collision with root package name */
    public h1 f5710l;

    /* renamed from: m, reason: collision with root package name */
    public float f5711m;

    /* renamed from: n, reason: collision with root package name */
    public d1.l f5712n;

    /* renamed from: o, reason: collision with root package name */
    public int f5713o;

    @Override // h1.b
    public final void d(float f5) {
        this.f5711m = f5;
    }

    @Override // h1.b
    public final void e(d1.l lVar) {
        this.f5712n = lVar;
    }

    @Override // h1.b
    public final long h() {
        return ((c1.e) this.i.getValue()).f2179a;
    }

    @Override // h1.b
    public final void i(u1.i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        e0 e0Var = this.f5709k;
        d1.l lVar = this.f5712n;
        if (lVar == null) {
            lVar = (d1.l) e0Var.f5651g.getValue();
        }
        if (((Boolean) this.f5708j.getValue()).booleanValue() && i0Var.getLayoutDirection() == o2.l.f9124f) {
            long jG0 = bVar.g0();
            p5.m mVar = bVar.f3859f;
            long jD = mVar.D();
            mVar.y().i();
            try {
                ((a1.g) mVar.f9741f).y(-1.0f, 1.0f, jG0);
                e0Var.e(i0Var, this.f5711m, lVar);
            } finally {
                mVar.y().o();
                mVar.R(jD);
            }
        } else {
            e0Var.e(i0Var, this.f5711m, lVar);
        }
        this.f5713o = this.f5710l.g();
    }
}
