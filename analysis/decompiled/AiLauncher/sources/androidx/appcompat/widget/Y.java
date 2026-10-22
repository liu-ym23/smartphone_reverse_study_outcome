package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import f.C4027a;
import j.C4736a;

/* loaded from: classes.dex */
public class Y implements A {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f9143a;

    /* renamed from: b, reason: collision with root package name */
    public int f9144b;

    /* renamed from: c, reason: collision with root package name */
    public View f9145c;

    /* renamed from: d, reason: collision with root package name */
    public View f9146d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f9147e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f9148f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f9149g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9150h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f9151i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f9152j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f9153k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f9154l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9155m;

    /* renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f9156n;

    /* renamed from: o, reason: collision with root package name */
    public int f9157o;

    /* renamed from: p, reason: collision with root package name */
    public int f9158p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f9159q;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final C4736a f9160a;

        public a() {
            this.f9160a = new C4736a(Y.this.f9143a.getContext(), 0, R.id.home, 0, 0, Y.this.f9151i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Y y10 = Y.this;
            Window.Callback callback = y10.f9154l;
            if (callback == null || !y10.f9155m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f9160a);
        }
    }

    public class b extends androidx.core.view.W {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9162a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f9163b;

        public b(int i10) {
            this.f9163b = i10;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void c(View view) {
            this.f9162a = true;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (this.f9162a) {
                return;
            }
            Y.this.f9143a.setVisibility(this.f9163b);
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            Y.this.f9143a.setVisibility(0);
        }
    }

    public Y(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public void A(Drawable drawable) {
        this.f9148f = drawable;
        J();
    }

    public void B(int i10) {
        C(i10 == 0 ? null : getContext().getString(i10));
    }

    public void C(CharSequence charSequence) {
        this.f9153k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.f9149g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.f9152j = charSequence;
        if ((this.f9144b & 8) != 0) {
            this.f9143a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.f9150h = true;
        G(charSequence);
    }

    public final void G(CharSequence charSequence) {
        this.f9151i = charSequence;
        if ((this.f9144b & 8) != 0) {
            this.f9143a.setTitle(charSequence);
            if (this.f9150h) {
                androidx.core.view.N.k0(this.f9143a.getRootView(), charSequence);
            }
        }
    }

    public final void H() {
        if ((this.f9144b & 4) != 0) {
            if (TextUtils.isEmpty(this.f9153k)) {
                this.f9143a.setNavigationContentDescription(this.f9158p);
            } else {
                this.f9143a.setNavigationContentDescription(this.f9153k);
            }
        }
    }

    public final void I() {
        if ((this.f9144b & 4) == 0) {
            this.f9143a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f9143a;
        Drawable drawable = this.f9149g;
        if (drawable == null) {
            drawable = this.f9159q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void J() {
        Drawable drawable;
        int i10 = this.f9144b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f9148f) == null) {
            drawable = this.f9147e;
        }
        this.f9143a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.A
    public boolean a() {
        return this.f9143a.d();
    }

    @Override // androidx.appcompat.widget.A
    public boolean b() {
        return this.f9143a.w();
    }

    @Override // androidx.appcompat.widget.A
    public boolean c() {
        return this.f9143a.Q();
    }

    @Override // androidx.appcompat.widget.A
    public void collapseActionView() {
        this.f9143a.e();
    }

    @Override // androidx.appcompat.widget.A
    public boolean d() {
        return this.f9143a.B();
    }

    @Override // androidx.appcompat.widget.A
    public void e() {
        this.f9155m = true;
    }

    @Override // androidx.appcompat.widget.A
    public boolean f() {
        return this.f9143a.A();
    }

    @Override // androidx.appcompat.widget.A
    public boolean g() {
        return this.f9143a.v();
    }

    @Override // androidx.appcompat.widget.A
    public Context getContext() {
        return this.f9143a.getContext();
    }

    @Override // androidx.appcompat.widget.A
    public CharSequence getTitle() {
        return this.f9143a.getTitle();
    }

    @Override // androidx.appcompat.widget.A
    public void h(int i10) {
        View view;
        int i11 = this.f9144b ^ i10;
        this.f9144b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f9143a.setTitle(this.f9151i);
                    this.f9143a.setSubtitle(this.f9152j);
                } else {
                    this.f9143a.setTitle((CharSequence) null);
                    this.f9143a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f9146d) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f9143a.addView(view);
            } else {
                this.f9143a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.A
    public Menu i() {
        return this.f9143a.getMenu();
    }

    @Override // androidx.appcompat.widget.A
    public int j() {
        return this.f9157o;
    }

    @Override // androidx.appcompat.widget.A
    public androidx.core.view.U k(int i10, long j10) {
        return androidx.core.view.N.d(this.f9143a).b(i10 == 0 ? 1.0f : 0.0f).f(j10).h(new b(i10));
    }

    @Override // androidx.appcompat.widget.A
    public ViewGroup l() {
        return this.f9143a;
    }

    @Override // androidx.appcompat.widget.A
    public void m(boolean z10) {
    }

    @Override // androidx.appcompat.widget.A
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.A
    public void o(boolean z10) {
        this.f9143a.setCollapsible(z10);
    }

    @Override // androidx.appcompat.widget.A
    public void p() {
        this.f9143a.f();
    }

    @Override // androidx.appcompat.widget.A
    public void q(Menu menu, i.a aVar) {
        if (this.f9156n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f9143a.getContext());
            this.f9156n = actionMenuPresenter;
            actionMenuPresenter.r(R$id.action_menu_presenter);
        }
        this.f9156n.e(aVar);
        this.f9143a.K((androidx.appcompat.view.menu.e) menu, this.f9156n);
    }

    @Override // androidx.appcompat.widget.A
    public void r(int i10) {
        A(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.A
    public int s() {
        return this.f9144b;
    }

    @Override // androidx.appcompat.widget.A
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.A
    public void setWindowCallback(Window.Callback callback) {
        this.f9154l = callback;
    }

    @Override // androidx.appcompat.widget.A
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f9150h) {
            return;
        }
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.A
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.A
    public void u(M m10) {
        View view = this.f9145c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f9143a;
            if (parent == toolbar) {
                toolbar.removeView(this.f9145c);
            }
        }
        this.f9145c = m10;
        if (m10 == null || this.f9157o != 2) {
            return;
        }
        this.f9143a.addView(m10, 0);
        Toolbar.g gVar = (Toolbar.g) this.f9145c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) gVar).width = -2;
        ((ViewGroup.MarginLayoutParams) gVar).height = -2;
        gVar.f8416a = 8388691;
        m10.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.A
    public void v(i.a aVar, e.a aVar2) {
        this.f9143a.L(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.A
    public void w(int i10) {
        this.f9143a.setVisibility(i10);
    }

    public final int x() {
        if (this.f9143a.getNavigationIcon() == null) {
            return 11;
        }
        this.f9159q = this.f9143a.getNavigationIcon();
        return 15;
    }

    public void y(View view) {
        View view2 = this.f9146d;
        if (view2 != null && (this.f9144b & 16) != 0) {
            this.f9143a.removeView(view2);
        }
        this.f9146d = view;
        if (view == null || (this.f9144b & 16) == 0) {
            return;
        }
        this.f9143a.addView(view);
    }

    public void z(int i10) {
        if (i10 == this.f9158p) {
            return;
        }
        this.f9158p = i10;
        if (TextUtils.isEmpty(this.f9143a.getNavigationContentDescription())) {
            B(this.f9158p);
        }
    }

    public Y(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f9157o = 0;
        this.f9158p = 0;
        this.f9143a = toolbar;
        this.f9151i = toolbar.getTitle();
        this.f9152j = toolbar.getSubtitle();
        this.f9150h = this.f9151i != null;
        this.f9149g = toolbar.getNavigationIcon();
        U uV = U.v(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f9159q = uV.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence charSequenceP = uV.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                F(charSequenceP);
            }
            CharSequence charSequenceP2 = uV.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                E(charSequenceP2);
            }
            Drawable drawableG = uV.g(R$styleable.ActionBar_logo);
            if (drawableG != null) {
                A(drawableG);
            }
            Drawable drawableG2 = uV.g(R$styleable.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f9149g == null && (drawable = this.f9159q) != null) {
                D(drawable);
            }
            h(uV.k(R$styleable.ActionBar_displayOptions, 0));
            int iN = uV.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                y(LayoutInflater.from(this.f9143a.getContext()).inflate(iN, (ViewGroup) this.f9143a, false));
                h(this.f9144b | 16);
            }
            int iM = uV.m(R$styleable.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f9143a.getLayoutParams();
                layoutParams.height = iM;
                this.f9143a.setLayoutParams(layoutParams);
            }
            int iE = uV.e(R$styleable.ActionBar_contentInsetStart, -1);
            int iE2 = uV.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f9143a.J(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = uV.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f9143a;
                toolbar2.N(toolbar2.getContext(), iN2);
            }
            int iN3 = uV.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f9143a;
                toolbar3.M(toolbar3.getContext(), iN3);
            }
            int iN4 = uV.n(R$styleable.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.f9143a.setPopupTheme(iN4);
            }
        } else {
            this.f9144b = x();
        }
        uV.x();
        z(i10);
        this.f9153k = this.f9143a.getNavigationContentDescription();
        this.f9143a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.A
    public void setIcon(Drawable drawable) {
        this.f9147e = drawable;
        J();
    }
}
