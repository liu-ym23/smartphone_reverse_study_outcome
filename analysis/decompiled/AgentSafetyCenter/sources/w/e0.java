package w;

import android.view.View;
import android.view.WindowInsetsAnimation;
import java.util.List;
import n3.j1;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends n3.r0 implements Runnable, n3.s, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public z0 f14967f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14968g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14969h;
    public m1 i;

    @Override // n3.r0
    public final void e(n3.t0 t0Var) {
        z0 z0Var = this.f14967f;
        this.f14968g = false;
        this.f14969h = false;
        m1 m1Var = this.i;
        if (((WindowInsetsAnimation) t0Var.f8753a.f49f).getDurationMillis() != 0 && m1Var != null) {
            j1 j1Var = m1Var.f8737a;
            z0Var.f15084q.f(t.n.l(j1Var.i(8)));
            z0Var.f15083p.f(t.n.l(j1Var.i(8)));
            z0.a(z0Var, m1Var);
        }
        this.i = null;
    }

    @Override // n3.r0
    public final void g() {
        this.f14968g = true;
        this.f14969h = true;
    }

    @Override // n3.r0
    public final m1 h(m1 m1Var, List list) {
        z0 z0Var = this.f14967f;
        z0.a(z0Var, m1Var);
        return z0Var.f15085r ? m1.f8736b : m1Var;
    }

    @Override // n3.r0
    public final p5.u i(n3.t0 t0Var, p5.u uVar) {
        this.f14968g = false;
        return uVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // n3.s
    public final m1 p(View view, m1 m1Var) {
        this.i = m1Var;
        z0 z0Var = this.f14967f;
        x0 x0Var = z0Var.f15083p;
        j1 j1Var = m1Var.f8737a;
        x0Var.f(t.n.l(j1Var.i(8)));
        if (!this.f14968g && !this.f14969h) {
            z0Var.f15084q.f(t.n.l(j1Var.i(8)));
            z0.a(z0Var, m1Var);
        }
        return z0Var.f15085r ? m1.f8736b : m1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z0 z0Var = this.f14967f;
        if (this.f14968g) {
            this.f14968g = false;
            this.f14969h = false;
            m1 m1Var = this.i;
            if (m1Var != null) {
                z0Var.f15084q.f(t.n.l(m1Var.f8737a.i(8)));
                z0.a(z0Var, m1Var);
                this.i = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
