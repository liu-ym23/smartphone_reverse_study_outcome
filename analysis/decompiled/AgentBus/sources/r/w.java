package r;

import android.os.Build;
import android.view.View;
import android.view.WindowInsetsAnimation;
import java.util.List;

/* loaded from: classes.dex */
public final class w extends o2.o implements Runnable, o2.f, View.OnAttachStateChangeListener {

    /* renamed from: g, reason: collision with root package name */
    public final p0 f8942g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8943h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8944i;

    /* renamed from: j, reason: collision with root package name */
    public o2.j0 f8945j;

    public w(p0 p0Var) {
        super(!p0Var.f8926r ? 1 : 0);
        this.f8942g = p0Var;
    }

    @Override // o2.f
    public final o2.j0 a(View view, o2.j0 j0Var) {
        this.f8945j = j0Var;
        p0 p0Var = this.f8942g;
        n0 n0Var = p0Var.f8924p;
        o2.g0 g0Var = j0Var.f7236a;
        n0Var.f(n7.o.C(g0Var.h(8)));
        if (this.f8943h) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.f8944i) {
            p0Var.f8925q.f(n7.o.C(g0Var.h(8)));
            p0.a(p0Var, j0Var);
        }
        return p0Var.f8926r ? o2.j0.f7235b : j0Var;
    }

    @Override // o2.o
    public final void b(o2.q qVar) {
        this.f8943h = false;
        this.f8944i = false;
        o2.j0 j0Var = this.f8945j;
        if (((WindowInsetsAnimation) qVar.f7244a.f411g).getDurationMillis() != 0 && j0Var != null) {
            o2.g0 g0Var = j0Var.f7236a;
            p0 p0Var = this.f8942g;
            p0Var.f8925q.f(n7.o.C(g0Var.h(8)));
            p0Var.f8924p.f(n7.o.C(g0Var.h(8)));
            p0.a(p0Var, j0Var);
        }
        this.f8945j = null;
    }

    @Override // o2.o
    public final void c() {
        this.f8943h = true;
        this.f8944i = true;
    }

    @Override // o2.o
    public final o2.j0 d(o2.j0 j0Var, List list) {
        p0 p0Var = this.f8942g;
        p0.a(p0Var, j0Var);
        return p0Var.f8926r ? o2.j0.f7235b : j0Var;
    }

    @Override // o2.o
    public final nb.f e(o2.q qVar, nb.f fVar) {
        this.f8943h = false;
        return fVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f8943h) {
            this.f8943h = false;
            this.f8944i = false;
            o2.j0 j0Var = this.f8945j;
            if (j0Var != null) {
                p0 p0Var = this.f8942g;
                p0Var.f8925q.f(n7.o.C(j0Var.f7236a.h(8)));
                p0.a(p0Var, j0Var);
                this.f8945j = null;
            }
        }
    }
}
