package stepos.support.v7.widget;

import Va.C0263a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import stepos.support.v7.app.C1973w;

/* loaded from: classes4.dex */
public final class G0 implements I {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f6462a;
    public int b;
    public final View c;
    public Drawable d;
    public Drawable e;
    public Drawable f;
    public boolean g;
    public CharSequence h;
    public final CharSequence i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f6463j;
    public Window.Callback k;
    public boolean l;
    public C2005u m;
    public final AppCompatDrawableManager n;
    public final int o;
    public final Drawable p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6464q;

    /* renamed from: r, reason: collision with root package name */
    public F f6465r;

    /* renamed from: s, reason: collision with root package name */
    public G f6466s;

    /* renamed from: t, reason: collision with root package name */
    public C1973w f6467t;
    public C2005u u;

    public G0(Toolbar toolbar, boolean z10) {
        int i = R.string.abc_action_bar_up_description;
        this.o = 0;
        this.f6462a = toolbar;
        this.h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar.getNavigationIcon();
        if (z10) {
            TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R.styleable.ActionBar, com.stepos.ability.R.attr.steposActionBarStyleFullScreen, 0);
            CharSequence text = tintTypedArrayObtainStyledAttributes.getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawable = tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_logo);
            if (drawable != null) {
                this.e = drawable;
                q();
            }
            Drawable drawable2 = tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_icon);
            if (this.f == null && drawable2 != null) {
                setIcon(drawable2);
            }
            Drawable drawable3 = tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
            if (drawable3 != null) {
                setNavigationIcon(drawable3);
            }
            setDisplayOptions(tintTypedArrayObtainStyledAttributes.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.c;
                if (view != null && (this.b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.c = viewInflate;
                if (viewInflate != null && (this.b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                setDisplayOptions(this.b | 16);
            }
            int layoutDimension = tintTypedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.f6592x.a(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.m = resourceId2;
                TextView textView = toolbar.c;
                if (textView != null) {
                    textView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.o = resourceId3;
                TextView textView2 = toolbar.d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = tintTypedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
            tintTypedArrayObtainStyledAttributes.recycle();
        } else {
            this.b = toolbar.getNavigationIcon() != null ? 15 : 11;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        this.n = appCompatDrawableManager;
        if (i != this.o) {
            this.o = i;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                setNavigationContentDescription(this.o);
            }
        }
        this.f6463j = toolbar.getNavigationContentDescription();
        Drawable drawable4 = appCompatDrawableManager.getDrawable(toolbar.getContext(), com.stepos.ability.R.drawable.stepos_titlebar_ic_back_dark);
        if (this.p != drawable4) {
            this.p = drawable4;
            p();
        }
        toolbar.setNavigationOnClickListener(new E0(this));
    }

    @Override // stepos.support.v7.widget.I
    public final void a(Menu menu, Va.A a3) {
        C2005u c2005u = this.m;
        Toolbar toolbar = this.f6462a;
        if (c2005u == null) {
            C2005u c2005u2 = new C2005u(toolbar.getContext());
            this.m = c2005u2;
            if (this.f6464q) {
                c2005u2.u = true;
                this.m.l(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (Ua.a.a(toolbar.getContext()).b() * 2), true);
                this.m.k(Integer.MAX_VALUE);
                this.m.j(true);
            }
        }
        C2005u c2005u3 = this.m;
        c2005u3.e = a3;
        Va.n nVar = (Va.n) menu;
        if (nVar == null && toolbar.f6579a == null) {
            return;
        }
        toolbar.d();
        Va.n nVar2 = toolbar.f6579a.f6443a;
        if (nVar2 == nVar) {
            return;
        }
        if (nVar2 != null) {
            nVar2.q(toolbar.f6571P);
            nVar2.q(toolbar.f6572Q);
        }
        if (toolbar.f6572Q == null) {
            toolbar.f6572Q = new A0(toolbar);
        }
        c2005u3.u = true;
        if (nVar != null) {
            nVar.b(c2005u3, toolbar.k);
            nVar.b(toolbar.f6572Q, toolbar.k);
        } else {
            c2005u3.b(toolbar.k, null);
            toolbar.f6572Q.b(toolbar.k, null);
            c2005u3.updateMenuView(true);
            toolbar.f6572Q.updateMenuView(true);
        }
        toolbar.f6579a.setPopupTheme(toolbar.l);
        toolbar.f6579a.setPresenter(c2005u3);
        toolbar.f6571P = c2005u3;
    }

    @Override // stepos.support.v7.widget.I
    public final boolean b() {
        return this.f6462a.f6580a0;
    }

    @Override // stepos.support.v7.widget.I
    public final void c(boolean z10) {
        if (this.f6464q != z10) {
            this.f6464q = z10;
            Toolbar toolbar = this.f6462a;
            toolbar.setSplitToolbar(z10);
            C2005u c2005u = this.m;
            if (c2005u != null) {
                if (z10) {
                    c2005u.u = true;
                    this.m.l(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (Ua.a.a(toolbar.getContext()).b() * 2), true);
                    this.m.k(Integer.MAX_VALUE);
                } else {
                    c2005u.u = false;
                }
                this.m.j(z10);
            }
        }
    }

    @Override // stepos.support.v7.widget.I
    public final boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f6462a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f6579a) != null && actionMenuView.d;
    }

    @Override // stepos.support.v7.widget.I
    public final void collapseActionView() {
        A0 a02 = this.f6462a.f6572Q;
        Va.q qVar = a02 == null ? null : a02.b;
        if (qVar != null) {
            qVar.collapseActionView();
        }
    }

    @Override // stepos.support.v7.widget.I
    public final void d(boolean z10) {
    }

    @Override // stepos.support.v7.widget.I
    public final void dismissPopupMenus() {
        C2005u c2005u;
        ActionMenuView actionMenuView = this.f6462a.f6579a;
        if (actionMenuView == null || (c2005u = actionMenuView.e) == null) {
            return;
        }
        c2005u.h();
        C1999n c1999n = c2005u.f6632B;
        if (c1999n != null) {
            c1999n.e();
        }
    }

    @Override // stepos.support.v7.widget.I
    public final boolean e() {
        return this.f6464q;
    }

    @Override // stepos.support.v7.widget.I
    public final void f(ViewGroup viewGroup) {
        Toolbar toolbar = this.f6462a;
        ViewGroup viewGroup2 = toolbar.f6581c0;
        if (viewGroup2 == null || viewGroup == null || !Toolbar.k(viewGroup2)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = toolbar.f6581c0.getLayoutParams();
        layoutParams.height = viewGroup.getPaddingBottom() + ((int) a5.l.c(80.0f, toolbar.getContext()));
        toolbar.f6581c0.setLayoutParams(layoutParams);
    }

    @Override // stepos.support.v7.widget.I
    public final void g(Menu menu, Va.A a3) {
        C2005u c2005u = this.u;
        Toolbar toolbar = this.f6462a;
        if (c2005u == null) {
            C2005u c2005u2 = new C2005u(toolbar.getContext());
            this.u = c2005u2;
            c2005u2.u = true;
            this.u.l(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (Ua.a.a(toolbar.getContext()).b() * 2), true);
            this.u.k(Integer.MAX_VALUE);
            this.u.j(true);
        }
        C2005u c2005u3 = this.u;
        c2005u3.e = a3;
        Va.n nVar = (Va.n) menu;
        if (toolbar.f6578W == null) {
            ActionMenuView actionMenuView = new ActionMenuView(toolbar.getContext(), null);
            toolbar.f6578W = actionMenuView;
            actionMenuView.setPopupTheme(toolbar.l);
            toolbar.f6578W.setOnMenuItemClickListener(toolbar.f6569N);
            B0 b0F = Toolbar.f();
            b0F.f6291a = (toolbar.p & 112) | GravityCompat.END;
            toolbar.f6578W.setLayoutParams(b0F);
            toolbar.f6578W.setId(com.stepos.ability.R.id.stepos_action_bottom_menu_view);
            ViewGroup viewGroup = toolbar.f6581c0;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) b0F).width = -1;
                viewGroup.addView(toolbar.f6578W, 0, b0F);
            }
        }
        Va.n nVar2 = toolbar.f6578W.f6443a;
        if (nVar2 == nVar) {
            return;
        }
        if (nVar2 != null) {
            nVar2.q(toolbar.f6571P);
        }
        c2005u3.u = true;
        if (nVar != null) {
            nVar.b(c2005u3, toolbar.k);
        }
        toolbar.f6578W.setPopupTheme(toolbar.l);
        toolbar.f6578W.setPresenter(c2005u3);
    }

    @Override // stepos.support.v7.widget.I
    public final Context getContext() {
        return this.f6462a.getContext();
    }

    @Override // stepos.support.v7.widget.I
    public final int getDisplayOptions() {
        return this.b;
    }

    @Override // stepos.support.v7.widget.I
    public final CharSequence getTitle() {
        return this.f6462a.getTitle();
    }

    @Override // stepos.support.v7.widget.I
    public final ViewGroup getViewGroup() {
        return this.f6462a;
    }

    @Override // stepos.support.v7.widget.I
    public final void h(ViewGroup viewGroup) {
        this.f6462a.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean hasExpandedActionView() {
        A0 a02 = this.f6462a.f6572Q;
        return (a02 == null || a02.b == null) ? false : true;
    }

    @Override // stepos.support.v7.widget.I
    public final boolean hideOverflowMenu() {
        C2005u c2005u;
        ActionMenuView actionMenuView = this.f6462a.f6579a;
        return (actionMenuView == null || (c2005u = actionMenuView.e) == null || !c2005u.h()) ? false : true;
    }

    @Override // stepos.support.v7.widget.I
    public final void i() {
    }

    @Override // stepos.support.v7.widget.I
    public final void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.I
    public final void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.I
    public final boolean isOverflowMenuShowPending() {
        C2005u c2005u;
        ActionMenuView actionMenuView = this.f6462a.f6579a;
        if (actionMenuView == null || (c2005u = actionMenuView.e) == null) {
            return false;
        }
        return c2005u.f6633C != null || c2005u.i();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean isOverflowMenuShowing() {
        return this.f6462a.m();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean j() {
        return this.f6462a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.I
    public final void k(C1973w c1973w) {
        this.f6467t = c1973w;
    }

    @Override // stepos.support.v7.widget.I
    public final boolean l() {
        return true;
    }

    @Override // stepos.support.v7.widget.I
    public final void m(boolean z10) {
        this.f6462a.setShowBottomMenu(z10);
    }

    public final void n() {
        if (this.f6465r == null) {
            G g = new G();
            g.f = false;
            this.f6466s = g;
            Toolbar toolbar = this.f6462a;
            Context context = toolbar.getContext();
            if (g.f6461a == null) {
                g.f6461a = new F(context, 0);
            }
            this.f6465r = g.f6461a;
            G g10 = this.f6466s;
            CharSequence charSequence = this.h;
            g10.g = charSequence;
            F f = g10.f6461a;
            if (f != null) {
                f.setTitle(charSequence);
            }
            String string = toolbar.getContext().getString(android.R.string.ok);
            String string2 = toolbar.getContext().getString(android.R.string.cancel);
            G g11 = this.f6466s;
            U.f fVar = new U.f(g11);
            U.f fVar2 = new U.f(g11);
            if (!g11.f) {
                g11.f = true;
            }
            C1973w c1973w = this.f6467t;
            if (c1973w != null) {
                c1973w.a(1, fVar);
                this.f6467t.a(0, fVar2);
            } else {
                if (fVar.f1245a != string) {
                    fVar.f1245a = string;
                    if (g11 != null) {
                        g11.a();
                    }
                }
                if (fVar2.f1245a != string2) {
                    fVar2.f1245a = string2;
                    G g12 = (G) fVar2.d;
                    if (g12 != null) {
                        g12.a();
                    }
                }
            }
            if (fVar.b == -1) {
                fVar.b = com.stepos.ability.R.id.stepos_control_title_bar_btn_ok;
            }
            if (fVar2.b == -1) {
                fVar2.b = com.stepos.ability.R.id.stepos_control_title_bar_btn_cancel;
            }
            C0263a c0263a = new C0263a(toolbar.getContext(), fVar2);
            C0263a c0263a2 = new C0263a(toolbar.getContext(), fVar);
            G g13 = this.f6466s;
            E0 e02 = new E0(this, c0263a, 1);
            g13.getClass();
            fVar2.d = g13;
            g13.e = fVar2;
            g13.c = e02;
            G g14 = this.f6466s;
            E0 e03 = new E0(this, c0263a2, 2);
            g14.getClass();
            fVar.d = g14;
            g14.d = fVar;
            g14.b = e03;
            G g15 = this.f6466s;
            g15.f = false;
            g15.a();
        }
    }

    public final void o() {
        if ((this.b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f6463j);
            Toolbar toolbar = this.f6462a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.o);
            } else {
                toolbar.setNavigationContentDescription(this.f6463j);
            }
        }
    }

    public final void p() {
        if ((this.b & 4) != 0) {
            Drawable drawable = this.f;
            if (drawable == null) {
                drawable = this.p;
            }
            this.f6462a.setNavigationIcon(drawable);
        }
    }

    public final void q() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.e) == null) {
            drawable = this.d;
        }
        this.f6462a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.I
    public final void setCollapsible(boolean z10) {
        this.f6462a.setCollapsible(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final void setDisplayOptions(int i) {
        View view;
        Toolbar toolbar = this.f6462a;
        X x10 = toolbar.f6592x;
        int i6 = this.b ^ i;
        this.b = i;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i & 4) != 0) {
                    p();
                    o();
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i6 & 3) != 0) {
                q();
            }
            if ((i6 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.h);
                    toolbar.setSubtitle(this.i);
                    x10.a(toolbar.getContext().getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_toolbar_content_inset_start), toolbar.getContentInsetEnd());
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) != 0 && (view = this.c) != null) {
                if ((i & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
            if ((i6 & 64) != 0) {
                n();
                if ((i & 64) != 0) {
                    toolbar.addView(this.f6465r);
                    x10.a(0, 0);
                } else {
                    toolbar.removeView(this.f6465r);
                    this.f6465r = null;
                }
            }
        }
        if ((i & 64) == 0) {
            toolbar.removeView(this.f6465r);
            this.f6465r = null;
        } else if (toolbar.indexOfChild(this.f6465r) < 0) {
            n();
            toolbar.addView(this.f6465r);
            x10.a(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.I
    public final void setHomeButtonEnabled(boolean z10) {
    }

    @Override // stepos.support.v7.widget.I
    public final void setIcon(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = this.n.getDrawable(this.f6462a.getContext(), i);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    @Override // stepos.support.v7.widget.I
    public final void setLogo(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = this.n.getDrawable(this.f6462a.getContext(), i);
        } else {
            drawable = null;
        }
        this.e = drawable;
        q();
    }

    @Override // stepos.support.v7.widget.I
    public final void setMenuPrepared() {
        this.l = true;
    }

    @Override // stepos.support.v7.widget.I
    public final void setNavigationContentDescription(int i) {
        this.f6463j = i == 0 ? null : this.f6462a.getContext().getString(i);
        o();
    }

    @Override // stepos.support.v7.widget.I
    public final void setNavigationIcon(Drawable drawable) {
        this.f = drawable;
        p();
    }

    @Override // stepos.support.v7.widget.I
    public final void setTitle(CharSequence charSequence) {
        this.g = true;
        this.h = charSequence;
        if ((this.b & 8) != 0) {
            this.f6462a.setTitle(charSequence);
        }
        G g = this.f6466s;
        if (g != null) {
            CharSequence charSequence2 = this.h;
            g.g = charSequence2;
            F f = g.f6461a;
            if (f != null) {
                f.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.I
    public final void setWindowCallback(Window.Callback callback) {
        this.k = callback;
    }

    @Override // stepos.support.v7.widget.I
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.g) {
            return;
        }
        this.h = charSequence;
        if ((this.b & 8) != 0) {
            this.f6462a.setTitle(charSequence);
        }
        G g = this.f6466s;
        if (g != null) {
            CharSequence charSequence2 = this.h;
            g.g = charSequence2;
            F f = g.f6461a;
            if (f != null) {
                f.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.I
    public final ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j5) {
        Toolbar toolbar = this.f6462a;
        C1977a c1977a = toolbar.f6584f0;
        if ((toolbar.f6582d0 && toolbar.f6579a != null) || toolbar.f6578W != null || toolbar.f6583e0 == null) {
            View view = toolbar.f6583e0;
            if (view == null && (view = toolbar.f6578W) == null) {
                view = toolbar.f6579a;
            }
            if (i == 0) {
                ViewCompat.setAlpha(view, 0.0f);
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(view).alpha(1.0f);
                viewPropertyAnimatorCompatAlpha.setDuration(j5);
                c1977a.c = i;
                viewPropertyAnimatorCompatAlpha.setListener(c1977a);
                viewPropertyAnimatorCompatAlpha.start();
            } else {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha2 = ViewCompat.animate(view).alpha(0.0f);
                viewPropertyAnimatorCompatAlpha2.setDuration(j5);
                c1977a.c = i;
                viewPropertyAnimatorCompatAlpha2.setListener(c1977a);
                viewPropertyAnimatorCompatAlpha2.start();
            }
        }
        return ViewCompat.animate(toolbar).alpha(i != 0 ? 0.0f : 1.0f).setDuration(j5).setListener(new F0(this, i));
    }

    @Override // stepos.support.v7.widget.I
    public final boolean showOverflowMenu() {
        C2005u c2005u;
        ActionMenuView actionMenuView = this.f6462a.f6579a;
        return (actionMenuView == null || (c2005u = actionMenuView.e) == null || !c2005u.m()) ? false : true;
    }

    @Override // stepos.support.v7.widget.I
    public final void setIcon(Drawable drawable) {
        this.d = drawable;
        q();
    }
}
