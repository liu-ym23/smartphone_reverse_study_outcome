package h1;

import a1.g;
import d1.f;
import d1.l;
import u1.i0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    public f f5277c;

    /* renamed from: f, reason: collision with root package name */
    public l f5278f;

    /* renamed from: g, reason: collision with root package name */
    public float f5279g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public o2.l f5280h = o2.l.f9123c;

    public abstract void d(float f5);

    public abstract void e(l lVar);

    public final void g(i0 i0Var, long j10, float f5, l lVar) {
        f1.b bVar = i0Var.f13838c;
        if (this.f5279g != f5) {
            d(f5);
            this.f5279g = f5;
        }
        if (!k.a(this.f5278f, lVar)) {
            e(lVar);
            this.f5278f = lVar;
        }
        o2.l layoutDirection = i0Var.getLayoutDirection();
        if (this.f5280h != layoutDirection) {
            f(layoutDirection);
            this.f5280h = layoutDirection;
        }
        int i = (int) (j10 >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (bVar.e() >> 32)) - Float.intBitsToFloat(i);
        int i3 = (int) (j10 & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (bVar.e() & 4294967295L)) - Float.intBitsToFloat(i3);
        ((g) bVar.f3859f.f9741f).s(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f5 > 0.0f) {
            try {
                if (Float.intBitsToFloat(i) > 0.0f && Float.intBitsToFloat(i3) > 0.0f) {
                    i(i0Var);
                }
            } finally {
                ((g) bVar.f3859f.f9741f).s(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
            }
        }
    }

    public abstract long h();

    public abstract void i(i0 i0Var);

    public void f(o2.l lVar) {
    }
}
