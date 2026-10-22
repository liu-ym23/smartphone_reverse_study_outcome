package stepos.support.v7.widget;

import android.R;
import android.annotation.SuppressLint;
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
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.C1295h;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.W;
import com.stepos.common.R$drawable;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.Toolbar;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class w implements k {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f41739a;

    /* renamed from: b, reason: collision with root package name */
    public int f41740b;

    /* renamed from: c, reason: collision with root package name */
    public s f41741c;

    /* renamed from: d, reason: collision with root package name */
    public View f41742d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f41743e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f41744f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f41745g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41746h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f41747i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f41748j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f41749k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f41750l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41751m;

    /* renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f41752n;

    /* renamed from: o, reason: collision with root package name */
    public int f41753o;

    /* renamed from: p, reason: collision with root package name */
    public final C1295h f41754p;

    /* renamed from: q, reason: collision with root package name */
    public int f41755q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f41756r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f41757s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f41758t;

    /* renamed from: u, reason: collision with root package name */
    public h f41759u;

    /* renamed from: v, reason: collision with root package name */
    public i f41760v;

    /* renamed from: w, reason: collision with root package name */
    public a.b f41761w;

    /* renamed from: x, reason: collision with root package name */
    public ActionMenuPresenter f41762x;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Jc.b f41763a;

        public a() {
            this.f41763a = new Jc.b(w.this.f41739a.getContext(), 0, R.id.home, 0, 0, w.this.f41747i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w.this.f41750l == null || !w.this.f41751m) {
                return;
            }
            w.this.f41750l.onMenuItemSelected(0, this.f41763a);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Jc.b f41765a;

        public b(Jc.b bVar) {
            this.f41765a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w.this.f41750l == null || !w.this.f41751m) {
                return;
            }
            w.this.f41750l.onMenuItemSelected(0, this.f41765a);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Jc.b f41767a;

        public c(Jc.b bVar) {
            this.f41767a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (w.this.f41750l == null || !w.this.f41751m) {
                return;
            }
            w.this.f41750l.onMenuItemSelected(0, this.f41767a);
        }
    }

    public class d extends W {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41769a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f41770b;

        public d(int i10) {
            this.f41770b = i10;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void c(View view) {
            this.f41769a = true;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            if (this.f41769a) {
                return;
            }
            w.this.f41739a.setVisibility(this.f41770b);
            w.this.f41739a.setMenuVisibility(this.f41770b);
            if (this.f41770b == 4) {
                w.this.f41739a.requestLayout();
            }
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            w.this.f41739a.setVisibility(0);
        }
    }

    public class e implements a.InterfaceC0522a {

        /* renamed from: a, reason: collision with root package name */
        public String f41772a;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f41774c;

        /* renamed from: e, reason: collision with root package name */
        public i f41776e;

        /* renamed from: b, reason: collision with root package name */
        public int f41773b = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f41775d = 16;

        public e(i iVar) {
            this.f41776e = iVar;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0522a
        public void a(String str) {
            if (this.f41772a != str) {
                this.f41772a = str;
                i iVar = this.f41776e;
                if (iVar != null) {
                    iVar.c();
                }
            }
        }

        public boolean b() {
            return (this.f41775d & 16) != 0;
        }

        public boolean c() {
            return (this.f41775d & 8) == 0;
        }

        public void d(i iVar) {
            this.f41776e = iVar;
        }

        public void e(int i10) {
            this.f41773b = i10;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0522a
        public Drawable getIcon() {
            return this.f41774c;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0522a
        public int getId() {
            return this.f41773b;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0522a
        public String getTitle() {
            return this.f41772a;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0522a
        public void setIcon(Drawable drawable) {
            if (this.f41774c != drawable) {
                this.f41774c = drawable;
                i iVar = this.f41776e;
                if (iVar != null) {
                    iVar.c();
                }
            }
        }
    }

    public w(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.stepos_titlebar_ic_back_dark);
    }

    @Override // stepos.support.v7.widget.k
    public void A(ViewGroup viewGroup) {
        this.f41739a.P(viewGroup);
    }

    @Override // stepos.support.v7.widget.k
    public void B(ViewGroup viewGroup) {
        this.f41739a.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.k
    public void C(Menu menu, g.a aVar) {
        if (this.f41762x == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f41739a.getContext());
            this.f41762x = actionMenuPresenter;
            actionMenuPresenter.p(R$id.bottom_action_menu_presenter);
            this.f41762x.S(true);
            this.f41762x.Z(getContext().getResources().getDisplayMetrics().widthPixels - (Ic.a.b(getContext()).f() * 2), true);
            this.f41762x.U(Integer.MAX_VALUE);
            this.f41762x.T(true);
        }
        this.f41762x.o(aVar);
        this.f41739a.R((stepos.support.v7.view.menu.c) menu, this.f41762x);
    }

    @Override // stepos.support.v7.widget.k
    public boolean D() {
        return this.f41739a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.k
    public boolean E() {
        return true;
    }

    @Override // stepos.support.v7.widget.k
    public void F(boolean z10) {
        this.f41739a.setShowBottomMenu(z10);
    }

    @Override // stepos.support.v7.widget.k
    public s G() {
        return this.f41741c;
    }

    @Override // stepos.support.v7.widget.k
    public void H(r rVar) {
        s sVar = this.f41741c;
        if (sVar != null) {
            ViewParent parent = sVar.getParent();
            Toolbar toolbar = this.f41739a;
            if (parent == toolbar) {
                toolbar.removeView(this.f41741c);
            }
        }
        if (this.f41741c == null && rVar != null) {
            this.f41741c = new s(getContext());
        }
        if (rVar == null) {
            s sVar2 = this.f41741c;
            if (sVar2 != null) {
                sVar2.setTabView(null);
                this.f41741c = null;
                return;
            }
            return;
        }
        this.f41741c.setTabView(rVar);
        this.f41741c.f(true);
        if (this.f41753o == 2) {
            this.f41739a.addView(this.f41741c);
            this.f41739a.S(getContext().getResources().getDimensionPixelSize(R$dimen.stepos_toolbar_content_inset_start_with_tab), this.f41739a.getContentInsetEnd());
            Toolbar.f fVar = (Toolbar.f) this.f41741c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) fVar).width = -2;
            ((ViewGroup.MarginLayoutParams) fVar).height = -2;
            fVar.f40399a = 8388627;
        }
    }

    public final int M() {
        return this.f41739a.getNavigationIcon() != null ? 15 : 11;
    }

    public final void N() {
        if (this.f41759u == null) {
            i iVar = new i();
            this.f41760v = iVar;
            this.f41759u = iVar.b(getContext());
            this.f41760v.d(this.f41747i);
            int i10 = R$id.stepos_control_title_bar_btn_ok;
            int i11 = R$id.stepos_control_title_bar_btn_cancel;
            String string = getContext().getString(R.string.ok);
            String string2 = getContext().getString(R.string.cancel);
            e eVar = new e(this.f41760v);
            e eVar2 = new e(this.f41760v);
            this.f41760v.f();
            a.b bVar = this.f41761w;
            if (bVar != null) {
                bVar.a(1, eVar);
                this.f41761w.a(0, eVar2);
            } else {
                eVar.a(string);
                eVar2.a(string2);
            }
            if (eVar.getId() == -1) {
                eVar.e(i10);
            }
            if (eVar2.getId() == -1) {
                eVar2.e(i11);
            }
            Jc.b bVar2 = new Jc.b(this.f41739a.getContext(), eVar2);
            Jc.b bVar3 = new Jc.b(this.f41739a.getContext(), eVar);
            this.f41760v.a(0, eVar2, new b(bVar2));
            this.f41760v.a(1, eVar, new c(bVar3));
            this.f41760v.e();
        }
    }

    public void O(View view) {
        View view2 = this.f41742d;
        if (view2 != null && (this.f41740b & 16) != 0) {
            this.f41739a.removeView(view2);
        }
        this.f41742d = view;
        if (view == null || (this.f41740b & 16) == 0) {
            return;
        }
        this.f41739a.addView(view);
    }

    public void P(int i10) {
        if (i10 == this.f41755q) {
            return;
        }
        this.f41755q = i10;
        if (TextUtils.isEmpty(this.f41739a.getNavigationContentDescription())) {
            S(this.f41755q);
        }
    }

    public void Q(Drawable drawable) {
        if (this.f41756r != drawable) {
            this.f41756r = drawable;
            Y();
        }
    }

    public void R(Drawable drawable) {
        this.f41744f = drawable;
        Z();
    }

    public void S(int i10) {
        T(i10 == 0 ? null : getContext().getString(i10));
    }

    public void T(CharSequence charSequence) {
        this.f41749k = charSequence;
        X();
    }

    public void U(Drawable drawable) {
        this.f41745g = drawable;
        Y();
    }

    public void V(CharSequence charSequence) {
        this.f41748j = charSequence;
        if ((this.f41740b & 8) != 0) {
            this.f41739a.setSubtitle(charSequence);
        }
    }

    public final void W(CharSequence charSequence) {
        this.f41747i = charSequence;
        if ((this.f41740b & 8) != 0) {
            this.f41739a.setTitle(charSequence);
        }
        i iVar = this.f41760v;
        if (iVar != null) {
            iVar.d(this.f41747i);
        }
    }

    public final void X() {
        if ((this.f41740b & 4) != 0) {
            if (TextUtils.isEmpty(this.f41749k)) {
                this.f41739a.setNavigationContentDescription(this.f41755q);
            } else {
                this.f41739a.setNavigationContentDescription(this.f41749k);
            }
        }
    }

    public final void Y() {
        if ((this.f41740b & 4) != 0) {
            Toolbar toolbar = this.f41739a;
            Drawable drawable = this.f41745g;
            if (drawable == null) {
                drawable = this.f41756r;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    public final void Z() {
        Drawable drawable;
        int i10 = this.f41740b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f41744f) == null) {
            drawable = this.f41743e;
        }
        this.f41739a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.k
    public boolean a() {
        return this.f41739a.i();
    }

    @Override // stepos.support.v7.widget.k
    public boolean b() {
        return this.f41739a.B();
    }

    @Override // stepos.support.v7.widget.k
    public boolean c() {
        return this.f41739a.a0();
    }

    @Override // stepos.support.v7.widget.k
    public void collapseActionView() {
        this.f41739a.j();
    }

    @Override // stepos.support.v7.widget.k
    public boolean d() {
        return this.f41739a.F();
    }

    @Override // stepos.support.v7.widget.k
    public void e() {
        this.f41751m = true;
    }

    @Override // stepos.support.v7.widget.k
    public boolean f() {
        return this.f41739a.E();
    }

    @Override // stepos.support.v7.widget.k
    public boolean g() {
        return this.f41739a.A();
    }

    @Override // stepos.support.v7.widget.k
    public Context getContext() {
        return this.f41739a.getContext();
    }

    @Override // stepos.support.v7.widget.k
    public CharSequence getTitle() {
        return this.f41739a.getTitle();
    }

    @Override // stepos.support.v7.widget.k
    public void h(int i10) {
        s sVar;
        View view;
        int i11 = this.f41740b ^ i10;
        this.f41740b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    Y();
                    X();
                } else {
                    this.f41739a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i11 & 3) != 0) {
                Z();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f41739a.setTitle(this.f41747i);
                    this.f41739a.setSubtitle(this.f41748j);
                    this.f41739a.S(getContext().getResources().getDimensionPixelSize(R$dimen.stepos_toolbar_content_inset_start), this.f41739a.getContentInsetEnd());
                } else {
                    this.f41739a.setTitle((CharSequence) null);
                    this.f41739a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f41742d) != null) {
                if ((i10 & 16) != 0) {
                    this.f41739a.addView(view);
                } else {
                    this.f41739a.removeView(view);
                }
            }
            if ((i11 & 32) != 0 && (sVar = this.f41741c) != null) {
                if ((i10 & 32) != 0) {
                    if (sVar != null && this.f41753o == 2) {
                        this.f41739a.addView(sVar, 0);
                        Toolbar.f fVar = (Toolbar.f) this.f41741c.getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) fVar).width = -2;
                        ((ViewGroup.MarginLayoutParams) fVar).height = -2;
                        fVar.f40399a = 8388627;
                        this.f41741c.f(true);
                    }
                } else if (sVar != null) {
                    ViewParent parent = sVar.getParent();
                    Toolbar toolbar = this.f41739a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f41741c);
                    }
                }
            }
            if ((i11 & 64) != 0) {
                N();
                if ((i10 & 64) != 0) {
                    this.f41739a.addView(this.f41759u);
                    this.f41739a.S(0, 0);
                } else {
                    this.f41739a.removeView(this.f41759u);
                    this.f41759u = null;
                }
            }
        }
        if ((i10 & 64) == 0) {
            this.f41739a.removeView(this.f41759u);
            this.f41759u = null;
        } else if (this.f41739a.indexOfChild(this.f41759u) < 0) {
            N();
            this.f41739a.addView(this.f41759u);
            this.f41739a.S(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.k
    public Menu i() {
        return this.f41739a.getMenu();
    }

    @Override // stepos.support.v7.widget.k
    public int j() {
        return this.f41753o;
    }

    @Override // stepos.support.v7.widget.k
    public U k(int i10, long j10) {
        Toolbar toolbar = this.f41739a;
        if (toolbar != null) {
            toolbar.V(i10, j10);
        }
        return N.d(this.f41739a).b(i10 == 0 ? 1.0f : 0.0f).f(j10).h(new d(i10));
    }

    @Override // stepos.support.v7.widget.k
    public ViewGroup l() {
        return this.f41739a;
    }

    @Override // stepos.support.v7.widget.k
    public void m(boolean z10) {
    }

    @Override // stepos.support.v7.widget.k
    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.k
    public void o(boolean z10) {
        this.f41739a.setCollapsible(z10);
    }

    @Override // stepos.support.v7.widget.k
    public void p() {
        this.f41739a.k();
    }

    @Override // stepos.support.v7.widget.k
    public void q(Menu menu, g.a aVar) {
        if (this.f41752n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f41739a.getContext());
            this.f41752n = actionMenuPresenter;
            actionMenuPresenter.p(androidx.appcompat.R$id.action_menu_presenter);
            if (this.f41757s) {
                this.f41752n.S(true);
                this.f41752n.Z(getContext().getResources().getDisplayMetrics().widthPixels - (Ic.a.b(getContext()).f() * 2), true);
                this.f41752n.U(Integer.MAX_VALUE);
                this.f41752n.T(true);
            }
        }
        this.f41752n.o(aVar);
        this.f41739a.T((stepos.support.v7.view.menu.c) menu, this.f41752n);
    }

    @Override // stepos.support.v7.widget.k
    public void r(int i10) {
        R(i10 != 0 ? this.f41754p.c(getContext(), i10) : null);
    }

    @Override // stepos.support.v7.widget.k
    public int s() {
        return this.f41740b;
    }

    @Override // stepos.support.v7.widget.k
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? this.f41754p.c(getContext(), i10) : null);
    }

    @Override // stepos.support.v7.widget.k
    public void setTitle(CharSequence charSequence) {
        this.f41746h = true;
        W(charSequence);
    }

    @Override // stepos.support.v7.widget.k
    public void setWindowCallback(Window.Callback callback) {
        this.f41750l = callback;
    }

    @Override // stepos.support.v7.widget.k
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f41746h) {
            return;
        }
        W(charSequence);
    }

    @Override // stepos.support.v7.widget.k
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.k
    public void u(g.a aVar, c.a aVar2) {
        this.f41739a.U(aVar, aVar2);
    }

    @Override // stepos.support.v7.widget.k
    public boolean v() {
        return this.f41739a.G();
    }

    @Override // stepos.support.v7.widget.k
    public void w(boolean z10) {
        if (this.f41757s != z10) {
            this.f41757s = z10;
            this.f41739a.setSplitToolbar(z10);
            ActionMenuPresenter actionMenuPresenter = this.f41752n;
            if (actionMenuPresenter != null) {
                if (z10) {
                    actionMenuPresenter.S(true);
                    this.f41752n.Z(getContext().getResources().getDisplayMetrics().widthPixels - (Ic.a.b(getContext()).f() * 2), true);
                    this.f41752n.U(Integer.MAX_VALUE);
                } else {
                    actionMenuPresenter.S(false);
                }
                this.f41752n.T(z10);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public void x(a.b bVar) {
        this.f41761w = bVar;
    }

    @Override // stepos.support.v7.widget.k
    public void y(boolean z10) {
        this.f41758t = z10;
    }

    @Override // stepos.support.v7.widget.k
    public boolean z() {
        return this.f41757s;
    }

    public w(Toolbar toolbar, boolean z10, int i10, int i11) {
        this.f41753o = 0;
        this.f41755q = 0;
        this.f41739a = toolbar;
        this.f41747i = toolbar.getTitle();
        this.f41748j = toolbar.getSubtitle();
        this.f41746h = this.f41747i != null;
        this.f41745g = toolbar.getNavigationIcon();
        if (z10) {
            androidx.appcompat.widget.U uV = androidx.appcompat.widget.U.v(toolbar.getContext(), null, R$styleable.ActionBar, O6.c.c() ? R$attr.steposActionBarStyleFullScreen : androidx.appcompat.R$attr.actionBarStyle, 0);
            CharSequence charSequenceP = uV.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = uV.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                V(charSequenceP2);
            }
            Drawable drawableG = uV.g(R$styleable.ActionBar_logo);
            if (drawableG != null) {
                R(drawableG);
            }
            Drawable drawableG2 = uV.g(R$styleable.ActionBar_icon);
            if (this.f41745g == null && drawableG2 != null) {
                setIcon(drawableG2);
            }
            Drawable drawableG3 = uV.g(R$styleable.ActionBar_homeAsUpIndicator);
            if (drawableG3 != null) {
                U(drawableG3);
            }
            h(uV.k(R$styleable.ActionBar_displayOptions, 0));
            int iN = uV.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                O(LayoutInflater.from(this.f41739a.getContext()).inflate(iN, (ViewGroup) this.f41739a, false));
                h(this.f41740b | 16);
            }
            int iM = uV.m(R$styleable.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f41739a.getLayoutParams();
                layoutParams.height = iM;
                this.f41739a.setLayoutParams(layoutParams);
            }
            int iE = uV.e(R$styleable.ActionBar_contentInsetStart, -1);
            int iE2 = uV.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f41739a.S(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = uV.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f41739a;
                toolbar2.X(toolbar2.getContext(), iN2);
            }
            int iN3 = uV.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f41739a;
                toolbar3.W(toolbar3.getContext(), iN3);
            }
            int iN4 = uV.n(R$styleable.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.f41739a.setPopupTheme(iN4);
            }
            uV.x();
        } else {
            this.f41740b = M();
        }
        C1295h c1295hB = C1295h.b();
        this.f41754p = c1295hB;
        P(i10);
        this.f41749k = this.f41739a.getNavigationContentDescription();
        Q(c1295hB.c(getContext(), i11));
        this.f41739a.setNavigationOnClickListener(new a());
    }

    @Override // stepos.support.v7.widget.k
    public void setIcon(Drawable drawable) {
        this.f41743e = drawable;
        Z();
    }
}
