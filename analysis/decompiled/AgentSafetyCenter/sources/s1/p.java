package s1;

import android.view.View;
import android.view.WindowInsetsAnimation;
import java.util.List;
import java.util.WeakHashMap;
import k0.h1;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends n3.r0 implements Runnable, n3.s, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public boolean f11281f;

    /* renamed from: g, reason: collision with root package name */
    public int f11282g;

    /* renamed from: h, reason: collision with root package name */
    public m1 f11283h;
    public p.f0 i;

    /* renamed from: j, reason: collision with root package name */
    public h1 f11284j;

    /* renamed from: k, reason: collision with root package name */
    public p.a0 f11285k;

    /* renamed from: l, reason: collision with root package name */
    public u0.q f11286l;

    @Override // n3.r0
    public final void e(n3.t0 t0Var) {
        boolean z10 = false;
        this.f11281f = false;
        int typeMask = ((WindowInsetsAnimation) t0Var.f8753a.f49f).getTypeMask();
        this.f11282g &= ~typeMask;
        this.f11283h = null;
        d1 d1Var = (d1) androidx.compose.ui.layout.b.f979c.b(typeMask);
        if (d1Var != null) {
            Object objG = this.i.g(d1Var);
            objG.getClass();
            f1 f1Var = (f1) objG;
            f1Var.f11243c.h(0.0f);
            f1Var.f11245e.h(1.0f);
            f1Var.f11244d.h(0L);
            f1Var.f11243c.h(0.0f);
            f1Var.f11242b.setValue(Boolean.FALSE);
            f1Var.f11249j = -1L;
            f1Var.f11250k = -1L;
            h1 h1Var = this.f11284j;
            h1Var.h(h1Var.g() + 1);
            synchronized (u0.m.f13676c) {
                p.g0 g0Var = u0.m.f13682j.f13641h;
                if (g0Var != null) {
                    if (g0Var.h()) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                u0.m.a();
            }
        }
    }

    @Override // n3.r0
    public final void g() {
        this.f11281f = true;
    }

    @Override // n3.r0
    public final m1 h(m1 m1Var, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            n3.t0 t0Var = (n3.t0) list.get(i);
            d1 d1Var = (d1) androidx.compose.ui.layout.b.f979c.b(((WindowInsetsAnimation) t0Var.f8753a.f49f).getTypeMask());
            if (d1Var != null) {
                Object objG = this.i.g(d1Var);
                objG.getClass();
                f1 f1Var = (f1) objG;
                if (((Boolean) f1Var.f11242b.getValue()).booleanValue()) {
                    a2.i iVar = t0Var.f8753a;
                    WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) iVar.f49f;
                    WindowInsetsAnimation windowInsetsAnimation2 = (WindowInsetsAnimation) iVar.f49f;
                    f1Var.f11243c.h(windowInsetsAnimation.getInterpolatedFraction());
                    f1Var.f11245e.h(windowInsetsAnimation2.getAlpha());
                    f1Var.f11244d.h(windowInsetsAnimation2.getDurationMillis());
                }
            }
        }
        k(m1Var);
        return m1Var;
    }

    @Override // n3.r0
    public final p5.u i(n3.t0 t0Var, p5.u uVar) {
        m1 m1Var = this.f11283h;
        boolean z10 = false;
        this.f11281f = false;
        this.f11283h = null;
        if (((WindowInsetsAnimation) t0Var.f8753a.f49f).getDurationMillis() > 0 && m1Var != null) {
            int typeMask = ((WindowInsetsAnimation) t0Var.f8753a.f49f).getTypeMask();
            this.f11282g |= typeMask;
            d1 d1Var = (d1) androidx.compose.ui.layout.b.f979c.b(typeMask);
            if (d1Var != null) {
                Object objG = this.i.g(d1Var);
                objG.getClass();
                f1 f1Var = (f1) objG;
                f3.b bVarI = m1Var.f8737a.i(typeMask);
                long j10 = (bVarI.f3900a << 48) | (bVarI.f3901b << 32) | (bVarI.f3902c << 16) | bVarI.f3903d;
                long j11 = f1Var.f11248h;
                if (!v0.h(j10, j11)) {
                    f1Var.f11249j = j11;
                    f1Var.f11250k = j10;
                    f1Var.f11242b.setValue(Boolean.TRUE);
                    a2.i iVar = t0Var.f8753a;
                    f1Var.f11243c.h(((WindowInsetsAnimation) iVar.f49f).getInterpolatedFraction());
                    f1Var.f11245e.h(((WindowInsetsAnimation) iVar.f49f).getAlpha());
                    f1Var.f11244d.h(((WindowInsetsAnimation) iVar.f49f).getDurationMillis());
                    h1 h1Var = this.f11284j;
                    h1Var.h(h1Var.g() + 1);
                    synchronized (u0.m.f13676c) {
                        p.g0 g0Var = u0.m.f13682j.f13641h;
                        if (g0Var != null) {
                            if (g0Var.h()) {
                                z10 = true;
                            }
                        }
                    }
                    if (z10) {
                        u0.m.a();
                        return uVar;
                    }
                }
            }
        }
        return uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x030d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(n3.m1 r34) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.p.k(n3.m1):void");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.e0.b(view, this);
        n3.k0.i(view, this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.e0.b(view, null);
        view.setWindowInsetsAnimationCallback(null);
    }

    @Override // n3.s
    public final m1 p(View view, m1 m1Var) {
        if (this.f11281f) {
            this.f11283h = m1Var;
            return m1Var;
        }
        if (this.f11282g == 0) {
            k(m1Var);
        }
        return m1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11281f) {
            this.f11282g = 0;
            this.f11281f = false;
            m1 m1Var = this.f11283h;
            if (m1Var != null) {
                k(m1Var);
                this.f11283h = null;
            }
        }
    }
}
