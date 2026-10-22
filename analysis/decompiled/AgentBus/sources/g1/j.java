package g1;

import android.os.Build;
import android.view.View;
import android.view.WindowInsetsAnimation;
import b0.l1;
import java.util.List;
import o2.j0;

/* loaded from: classes.dex */
public final class j extends o2.o implements Runnable, o2.f, View.OnAttachStateChangeListener {

    /* renamed from: g, reason: collision with root package name */
    public boolean f3743g;

    /* renamed from: h, reason: collision with root package name */
    public int f3744h;

    /* renamed from: i, reason: collision with root package name */
    public j0 f3745i;

    /* renamed from: j, reason: collision with root package name */
    public final k.a0 f3746j;

    /* renamed from: k, reason: collision with root package name */
    public final l1 f3747k;

    /* renamed from: l, reason: collision with root package name */
    public final k.z f3748l;

    /* renamed from: m, reason: collision with root package name */
    public final l0.q f3749m;

    public j() {
        super(1);
        k.a0 a0Var = new k.a0(9);
        c0.f3713a.getClass();
        a0Var.l(b0.f3702b, new e0("caption bar"));
        a0Var.l(b0.f3703c, new e0("display cutout"));
        a0Var.l(b0.f3704d, new e0("ime"));
        a0Var.l(b0.f3705e, new e0("mandatory system gestures"));
        a0Var.l(b0.f3706f, new e0("navigation bars"));
        a0Var.l(b0.f3707g, new e0("status bars"));
        a0Var.l(b0.f3708h, new e0("system gestures"));
        a0Var.l(b0.f3709i, new e0("tappable element"));
        a0Var.l(b0.f3710j, new e0("waterfall"));
        this.f3746j = a0Var;
        this.f3747k = new l1(0);
        this.f3748l = new k.z(4);
        this.f3749m = new l0.q();
    }

    @Override // o2.f
    public final j0 a(View view, j0 j0Var) {
        if (this.f3743g) {
            this.f3745i = j0Var;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
                return j0Var;
            }
        } else if (this.f3744h == 0) {
            f(j0Var);
        }
        return j0Var;
    }

    @Override // o2.o
    public final void b(o2.q qVar) {
        boolean z4 = false;
        this.f3743g = false;
        int typeMask = ((WindowInsetsAnimation) qVar.f7244a.f411g).getTypeMask();
        this.f3744h &= ~typeMask;
        this.f3745i = null;
        c0 c0Var = (c0) androidx.compose.ui.layout.b.f772c.b(typeMask);
        if (c0Var != null) {
            Object objG = this.f3746j.g(c0Var);
            q7.k.b(objG);
            e0 e0Var = (e0) objG;
            e0Var.f3723c.e(0.0f);
            e0Var.f3725e.e(1.0f);
            e0Var.f3724d.e(0L);
            e0Var.f3723c.e(0.0f);
            e0Var.f3722b.setValue(Boolean.FALSE);
            e0Var.f3730j = -1L;
            e0Var.f3731k = -1L;
            l1 l1Var = this.f3747k;
            l1Var.g(l1Var.e() + 1);
            synchronized (l0.m.f5774c) {
                k.b0 b0Var = l0.m.f5781j.f5736h;
                if (b0Var != null) {
                    if (b0Var.h()) {
                        z4 = true;
                    }
                }
            }
            if (z4) {
                l0.m.a();
            }
        }
    }

    @Override // o2.o
    public final void c() {
        this.f3743g = true;
    }

    @Override // o2.o
    public final j0 d(j0 j0Var, List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            o2.q qVar = (o2.q) list.get(i2);
            c0 c0Var = (c0) androidx.compose.ui.layout.b.f772c.b(((WindowInsetsAnimation) qVar.f7244a.f411g).getTypeMask());
            if (c0Var != null) {
                Object objG = this.f3746j.g(c0Var);
                q7.k.b(objG);
                e0 e0Var = (e0) objG;
                if (((Boolean) e0Var.f3722b.getValue()).booleanValue()) {
                    a7.d dVar = qVar.f7244a;
                    WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) dVar.f411g;
                    WindowInsetsAnimation windowInsetsAnimation2 = (WindowInsetsAnimation) dVar.f411g;
                    e0Var.f3723c.e(windowInsetsAnimation.getInterpolatedFraction());
                    e0Var.f3725e.e(windowInsetsAnimation2.getAlpha());
                    e0Var.f3724d.e(windowInsetsAnimation2.getDurationMillis());
                }
            }
        }
        f(j0Var);
        return j0Var;
    }

    @Override // o2.o
    public final nb.f e(o2.q qVar, nb.f fVar) {
        j0 j0Var = this.f3745i;
        boolean z4 = false;
        this.f3743g = false;
        this.f3745i = null;
        if (((WindowInsetsAnimation) qVar.f7244a.f411g).getDurationMillis() > 0 && j0Var != null) {
            int typeMask = ((WindowInsetsAnimation) qVar.f7244a.f411g).getTypeMask();
            this.f3744h |= typeMask;
            c0 c0Var = (c0) androidx.compose.ui.layout.b.f772c.b(typeMask);
            if (c0Var != null) {
                Object objG = this.f3746j.g(c0Var);
                q7.k.b(objG);
                e0 e0Var = (e0) objG;
                k2.a aVarH = j0Var.f7236a.h(typeMask);
                long j2 = (aVarH.f5575a << 48) | (aVarH.f5576b << 32) | (aVarH.f5577c << 16) | aVarH.f5578d;
                long j4 = e0Var.f3728h;
                if (!a.a.K(j2, j4)) {
                    e0Var.f3730j = j4;
                    e0Var.f3731k = j2;
                    e0Var.f3722b.setValue(Boolean.TRUE);
                    a7.d dVar = qVar.f7244a;
                    e0Var.f3723c.e(((WindowInsetsAnimation) dVar.f411g).getInterpolatedFraction());
                    e0Var.f3725e.e(((WindowInsetsAnimation) dVar.f411g).getAlpha());
                    e0Var.f3724d.e(((WindowInsetsAnimation) dVar.f411g).getDurationMillis());
                    l1 l1Var = this.f3747k;
                    l1Var.g(l1Var.e() + 1);
                    synchronized (l0.m.f5774c) {
                        k.b0 b0Var = l0.m.f5781j.f5736h;
                        if (b0Var != null) {
                            if (b0Var.h()) {
                                z4 = true;
                            }
                        }
                    }
                    if (z4) {
                        l0.m.a();
                        return fVar;
                    }
                }
            }
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(o2.j0 r34) {
        /*
            Method dump skipped, instructions count: 795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.j.f(o2.j0):void");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        int i2 = o2.m.f7237a;
        o2.i.a(view, this);
        view.setWindowInsetsAnimationCallback(new o2.p(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        int i2 = o2.m.f7237a;
        o2.i.a(view, null);
        view.setWindowInsetsAnimationCallback(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3743g) {
            this.f3744h = 0;
            this.f3743g = false;
            j0 j0Var = this.f3745i;
            if (j0Var != null) {
                f(j0Var);
                this.f3745i = null;
            }
        }
    }
}
