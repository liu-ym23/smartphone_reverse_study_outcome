package o6;

import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import c1.e;
import d1.l;
import d1.o;
import jb.k;
import k0.a2;
import k0.k1;
import p5.f;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends h1.b implements a2 {
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public k1 f9232j;

    /* renamed from: k, reason: collision with root package name */
    public k1 f9233k;

    /* renamed from: l, reason: collision with root package name */
    public k f9234l;

    @Override // k0.a2
    public final void a() {
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.a2
    public final void b() {
        Drawable drawable = this.i;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        drawable.setVisible(false, false);
        drawable.setCallback(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.a2
    public final void c() {
        Drawable drawable = this.i;
        drawable.setCallback((Drawable.Callback) this.f9234l.getValue());
        drawable.setVisible(true, true);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    @Override // h1.b
    public final void d(float f5) {
        this.i.setAlpha(f.q(ac.a.Q(f5 * 255), 0, 255));
    }

    @Override // h1.b
    public final void e(l lVar) {
        this.i.setColorFilter(lVar != null ? lVar.f3010a : null);
    }

    @Override // h1.b
    public final void f(o2.l lVar) {
        int i;
        lVar.getClass();
        Drawable drawable = this.i;
        int iOrdinal = lVar.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                g5.f.a();
                return;
            }
        } else {
            i = 0;
        }
        drawable.setLayoutDirection(i);
    }

    @Override // h1.b
    public final long h() {
        return ((e) this.f9233k.getValue()).f2179a;
    }

    @Override // h1.b
    public final void i(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        o oVarY = bVar.f3859f.y();
        ((Number) this.f9232j.getValue()).intValue();
        Drawable drawable = this.i;
        drawable.setBounds(0, 0, ac.a.Q(e.e(bVar.e())), ac.a.Q(e.c(bVar.e())));
        try {
            oVarY.i();
            Canvas canvas = d1.b.f2958a;
            drawable.draw(((d1.a) oVarY).f2954a);
        } finally {
            oVarY.o();
        }
    }
}
