package stepos.support.v7.app;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class z extends se.b implements te.j {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f12521h = 0;
    public final Context i;

    /* renamed from: j, reason: collision with root package name */
    public final te.l f12522j;

    /* renamed from: k, reason: collision with root package name */
    public p5.c f12523k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f12524l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f12525m;

    public z(t0 t0Var, Context context, p5.c cVar) {
        this.f12525m = t0Var;
        r2.i iVar = new r2.i(10);
        this.i = context;
        this.f12523k = cVar;
        te.l lVar = new te.l(context);
        lVar.f13352k = 1;
        this.f12522j = lVar;
        lVar.f13346d = this;
        this.f12200g = iVar;
    }

    @Override // se.b
    public final void a() {
        switch (this.f12521h) {
            case 0:
                a0 a0Var = (a0) this.f12525m;
                if (a0Var.f12274j == this) {
                    this.f12523k.e(this);
                    this.f12523k = null;
                    a0Var.t(false, null);
                    ActionBarContextView actionBarContextView = a0Var.f12272g;
                    if (actionBarContextView.f12566r == null && !actionBarContextView.B) {
                        actionBarContextView.j();
                    }
                    StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = a0Var.f12271f;
                    stepos.support.v7.widget.v vVar = stepOSCollapsingToolbarLayout.f12913o;
                    vVar.n(stepOSCollapsingToolbarLayout.getTitle());
                    vVar.D.setAlpha((int) 255.0f);
                    stepos.support.v7.widget.a0 a0Var2 = stepOSCollapsingToolbarLayout.G;
                    if (a0Var2 != null) {
                        stepos.support.v7.widget.t0 t0Var = stepOSCollapsingToolbarLayout.I;
                        ArrayList arrayList = a0Var2.C;
                        if (arrayList != null) {
                            arrayList.remove(t0Var);
                        }
                    }
                    stepOSCollapsingToolbarLayout.G = null;
                    stepOSCollapsingToolbarLayout.F = null;
                    a0Var.f12269d.f12929b.w().sendAccessibilityEvent(32);
                    a0Var.f12274j = null;
                    break;
                }
                break;
            default:
                t0 t0Var2 = (t0) this.f12525m;
                if (t0Var2.f12487j == this) {
                    if (t0Var2.f12495r) {
                        t0Var2.f12488k = this;
                        t0Var2.f12489l = this.f12523k;
                    } else {
                        this.f12523k.e(this);
                    }
                    this.f12523k = null;
                    t0Var2.t(false, null);
                    ActionBarContextView actionBarContextView2 = t0Var2.f12484f;
                    if (actionBarContextView2.f12566r == null && !actionBarContextView2.B) {
                        actionBarContextView2.j();
                    }
                    t0Var2.f12483e.w().sendAccessibilityEvent(32);
                    t0Var2.f12481c.setHideOnContentScrollEnabled(t0Var2.f12500w);
                    t0Var2.f12487j = null;
                    break;
                }
                break;
        }
    }

    @Override // se.b
    public final View b() {
        switch (this.f12521h) {
            case 0:
                WeakReference weakReference = this.f12524l;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
                return null;
            default:
                WeakReference weakReference2 = this.f12524l;
                if (weakReference2 != null) {
                    return (View) weakReference2.get();
                }
                return null;
        }
    }

    @Override // te.j
    public final boolean c(te.l lVar, MenuItem menuItem) {
        switch (this.f12521h) {
            case 0:
                p5.c cVar = this.f12523k;
                if (cVar != null) {
                    return ((se.a) cVar.f9717f).d(this, menuItem);
                }
                return false;
            default:
                p5.c cVar2 = this.f12523k;
                if (cVar2 != null) {
                    return ((se.a) cVar2.f9717f).d(this, menuItem);
                }
                return false;
        }
    }

    @Override // te.j
    public final void d(te.l lVar) {
        switch (this.f12521h) {
            case 0:
                if (this.f12523k != null) {
                    i();
                    stepos.support.v7.widget.q qVar = ((a0) this.f12525m).f12272g.f12711h;
                    if (qVar != null) {
                        qVar.o();
                        break;
                    }
                }
                break;
            default:
                if (this.f12523k != null) {
                    i();
                    stepos.support.v7.widget.q qVar2 = ((t0) this.f12525m).f12484f.f12711h;
                    if (qVar2 != null) {
                        qVar2.o();
                        break;
                    }
                }
                break;
        }
    }

    @Override // se.b
    public final te.l e() {
        switch (this.f12521h) {
        }
        return this.f12522j;
    }

    @Override // se.b
    public final se.j f() {
        switch (this.f12521h) {
        }
        return new se.j(this.i);
    }

    @Override // se.b
    public final CharSequence g() {
        switch (this.f12521h) {
            case 0:
                return ((a0) this.f12525m).f12272g.getSubtitle();
            default:
                return ((t0) this.f12525m).f12484f.getSubtitle();
        }
    }

    @Override // se.b
    public final CharSequence h() {
        switch (this.f12521h) {
            case 0:
                return ((a0) this.f12525m).f12272g.getTitle();
            default:
                return ((t0) this.f12525m).f12484f.getTitle();
        }
    }

    @Override // se.b
    public final void i() {
        te.l lVar;
        switch (this.f12521h) {
            case 0:
                if (((a0) this.f12525m).f12274j != this) {
                    return;
                }
                lVar = this.f12522j;
                lVar.v();
                try {
                    this.f12523k.b(this, lVar);
                    return;
                } finally {
                }
            default:
                if (((t0) this.f12525m).f12487j != this) {
                    return;
                }
                lVar = this.f12522j;
                lVar.v();
                try {
                    this.f12523k.b(this, lVar);
                    return;
                } finally {
                }
        }
    }

    @Override // se.b
    public final boolean j() {
        switch (this.f12521h) {
            case 0:
                return ((a0) this.f12525m).f12272g.f12573y;
            default:
                return ((t0) this.f12525m).f12484f.f12573y;
        }
    }

    @Override // se.b
    public final void k(View view) {
        switch (this.f12521h) {
            case 0:
                ((a0) this.f12525m).f12272g.setCustomView(view);
                this.f12524l = new WeakReference(view);
                break;
            default:
                ((t0) this.f12525m).f12484f.setCustomView(view);
                this.f12524l = new WeakReference(view);
                break;
        }
    }

    @Override // se.b
    public final void l(int i) {
        switch (this.f12521h) {
            case 0:
                m(((a0) this.f12525m).f12266a.getResources().getString(i));
                break;
            default:
                m(((t0) this.f12525m).f12479a.getResources().getString(i));
                break;
        }
    }

    @Override // se.b
    public final void m(CharSequence charSequence) {
        switch (this.f12521h) {
            case 0:
                ((a0) this.f12525m).f12272g.setSubtitle(charSequence);
                break;
            default:
                ((t0) this.f12525m).f12484f.setSubtitle(charSequence);
                break;
        }
    }

    @Override // se.b
    public final void n(int i) {
        switch (this.f12521h) {
            case 0:
                o(((a0) this.f12525m).f12266a.getResources().getString(i));
                break;
            default:
                o(((t0) this.f12525m).f12479a.getResources().getString(i));
                break;
        }
    }

    @Override // se.b
    public final void o(CharSequence charSequence) {
        switch (this.f12521h) {
            case 0:
                ((a0) this.f12525m).f12272g.setTitle(charSequence);
                break;
            default:
                ((t0) this.f12525m).f12484f.setTitle(charSequence);
                break;
        }
    }

    @Override // se.b
    public final void p(boolean z10) {
        switch (this.f12521h) {
            case 0:
                this.f12199f = z10;
                ((a0) this.f12525m).f12272g.setTitleOptional(z10);
                break;
            default:
                this.f12199f = z10;
                ((t0) this.f12525m).f12484f.setTitleOptional(z10);
                break;
        }
    }

    public z(a0 a0Var, Context context, p5.c cVar) {
        this.f12525m = a0Var;
        r2.i iVar = new r2.i(6);
        this.i = context;
        this.f12523k = cVar;
        te.l lVar = new te.l(context);
        lVar.f13352k = 1;
        this.f12522j = lVar;
        lVar.f13346d = this;
        this.f12200g = iVar;
    }
}
