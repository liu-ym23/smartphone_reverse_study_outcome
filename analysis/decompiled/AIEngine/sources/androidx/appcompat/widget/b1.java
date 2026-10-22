package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b1 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f761a;

    /* renamed from: b, reason: collision with root package name */
    public int f762b;

    /* renamed from: c, reason: collision with root package name */
    public View f763c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f764d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f765e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f766f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f767g;
    public CharSequence h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f768i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f769j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f770k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f771l;

    /* renamed from: m, reason: collision with root package name */
    public ActionMenuPresenter f772m;

    /* renamed from: n, reason: collision with root package name */
    public int f773n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f774o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends mb.y {

        /* renamed from: a, reason: collision with root package name */
        public boolean f775a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f776b;

        public a(int i10) {
            this.f776b = i10;
        }

        @Override // mb.y, v0.i0
        public final void c() {
            this.f775a = true;
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            if (this.f775a) {
                return;
            }
            b1.this.f761a.setVisibility(this.f776b);
        }

        @Override // mb.y, v0.i0
        public final void e(View view) {
            b1.this.f761a.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean a() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f761a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f705a) != null && actionMenuView.f620v;
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean b() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f761a.f705a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null || !actionMenuPresenter.j()) ? false : true;
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean c() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f761a.f705a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null || !actionMenuPresenter.l()) ? false : true;
    }

    @Override // androidx.appcompat.widget.e0
    public final void collapseActionView() {
        Toolbar.f fVar = this.f761a.O;
        androidx.appcompat.view.menu.h hVar = fVar == null ? null : fVar.f730b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean d() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f761a.f705a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null || !actionMenuPresenter.k()) ? false : true;
    }

    @Override // androidx.appcompat.widget.e0
    public final void e() {
        this.f771l = true;
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean f() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f761a.f705a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null) {
            return false;
        }
        return actionMenuPresenter.f607x != null || actionMenuPresenter.k();
    }

    @Override // androidx.appcompat.widget.e0
    public final boolean g() {
        Toolbar.f fVar = this.f761a.O;
        return (fVar == null || fVar.f730b == null) ? false : true;
    }

    @Override // androidx.appcompat.widget.e0
    public final Context getContext() {
        return this.f761a.getContext();
    }

    @Override // androidx.appcompat.widget.e0
    public final CharSequence getTitle() {
        return this.f761a.getTitle();
    }

    @Override // androidx.appcompat.widget.e0
    public final void h(int i10) throws Resources.NotFoundException {
        View view;
        Toolbar toolbar = this.f761a;
        int i11 = this.f762b ^ i10;
        this.f762b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    s();
                }
                if ((this.f762b & 4) != 0) {
                    Drawable drawable = this.f766f;
                    if (drawable == null) {
                        drawable = this.f774o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i11 & 3) != 0) {
                t();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    toolbar.setTitle(this.h);
                    toolbar.setSubtitle(this.f768i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f763c) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public final v0.h0 i(int i10, long j10) {
        v0.h0 h0VarA = v0.e0.a(this.f761a);
        h0VarA.a(i10 == 0 ? 1.0f : 0.0f);
        h0VarA.c(j10);
        h0VarA.e(new a(i10));
        return h0VarA;
    }

    @Override // androidx.appcompat.widget.e0
    public final void j() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.e0
    public final void k(boolean z) {
        this.f761a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.e0
    public final void l() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f761a.f705a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f621w) == null) {
            return;
        }
        actionMenuPresenter.j();
        ActionMenuPresenter.a aVar = actionMenuPresenter.f606w;
        if (aVar == null || !aVar.b()) {
            return;
        }
        aVar.f529i.dismiss();
    }

    @Override // androidx.appcompat.widget.e0
    public final void m(Menu menu, j.a aVar) {
        Toolbar toolbar = this.f761a;
        if (this.f772m == null) {
            this.f772m = new ActionMenuPresenter(toolbar.getContext());
        }
        ActionMenuPresenter actionMenuPresenter = this.f772m;
        actionMenuPresenter.f434e = aVar;
        androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) menu;
        if (fVar == null && toolbar.f705a == null) {
            return;
        }
        toolbar.f();
        androidx.appcompat.view.menu.f fVar2 = toolbar.f705a.f617s;
        if (fVar2 == fVar) {
            return;
        }
        if (fVar2 != null) {
            fVar2.r(toolbar.N);
            fVar2.r(toolbar.O);
        }
        if (toolbar.O == null) {
            toolbar.O = toolbar.new f();
        }
        actionMenuPresenter.f603t = true;
        if (fVar != null) {
            fVar.b(actionMenuPresenter, toolbar.f713m);
            fVar.b(toolbar.O, toolbar.f713m);
        } else {
            actionMenuPresenter.h(toolbar.f713m, null);
            toolbar.O.h(toolbar.f713m, null);
            actionMenuPresenter.b();
            toolbar.O.b();
        }
        toolbar.f705a.setPopupTheme(toolbar.f714n);
        toolbar.f705a.setPresenter(actionMenuPresenter);
        toolbar.N = actionMenuPresenter;
        toolbar.u();
    }

    @Override // androidx.appcompat.widget.e0
    public final void o(int i10) {
        this.f765e = i10 != 0 ? androidx.datastore.preferences.protobuf.b1.L(i10, this.f761a.getContext()) : null;
        t();
    }

    @Override // androidx.appcompat.widget.e0
    public final int p() {
        return this.f762b;
    }

    @Override // androidx.appcompat.widget.e0
    public final void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.e0
    public final void r(int i10) {
        this.f761a.setVisibility(i10);
    }

    public final void s() {
        Toolbar toolbar = this.f761a;
        if ((this.f762b & 4) != 0) {
            if (TextUtils.isEmpty(this.f769j)) {
                toolbar.setNavigationContentDescription(this.f773n);
            } else {
                toolbar.setNavigationContentDescription(this.f769j);
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public final void setIcon(int i10) {
        setIcon(i10 != 0 ? androidx.datastore.preferences.protobuf.b1.L(i10, this.f761a.getContext()) : null);
    }

    @Override // androidx.appcompat.widget.e0
    public final void setWindowCallback(Window.Callback callback) {
        this.f770k = callback;
    }

    @Override // androidx.appcompat.widget.e0
    public final void setWindowTitle(CharSequence charSequence) throws Resources.NotFoundException {
        if (this.f767g) {
            return;
        }
        Toolbar toolbar = this.f761a;
        this.h = charSequence;
        if ((this.f762b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (this.f767g) {
                v0.e0.k(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final void t() {
        Drawable drawable;
        int i10 = this.f762b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f765e) == null) {
            drawable = this.f764d;
        }
        this.f761a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.e0
    public final void setIcon(Drawable drawable) {
        this.f764d = drawable;
        t();
    }

    @Override // androidx.appcompat.widget.e0
    public final void n() {
    }
}
