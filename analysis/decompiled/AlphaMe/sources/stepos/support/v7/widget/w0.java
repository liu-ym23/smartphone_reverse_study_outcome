package stepos.support.v7.widget;

import L3.C0094a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.C0189a;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import j.C0622a;
import java.util.WeakHashMap;
import stepos.support.v7.app.C0877w;
import stepos.support.v7.app.InterfaceC0856a;

/* loaded from: classes2.dex */
public final class w0 implements D {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f15201a;

    /* renamed from: b, reason: collision with root package name */
    public int f15202b;

    /* renamed from: c, reason: collision with root package name */
    public final View f15203c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f15204d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f15205e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f15206f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15207g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f15208h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f15209i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f15210j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f15211k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15212l;

    /* renamed from: m, reason: collision with root package name */
    public C0897q f15213m;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.appcompat.widget.A f15214n;

    /* renamed from: o, reason: collision with root package name */
    public final int f15215o;

    /* renamed from: p, reason: collision with root package name */
    public final Drawable f15216p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15217q;

    /* renamed from: r, reason: collision with root package name */
    public A f15218r;

    /* renamed from: s, reason: collision with root package name */
    public B f15219s;

    /* renamed from: t, reason: collision with root package name */
    public InterfaceC0856a f15220t;

    /* renamed from: u, reason: collision with root package name */
    public C0897q f15221u;

    public w0(Toolbar toolbar, boolean z4) {
        this.f15215o = 0;
        this.f15201a = toolbar;
        this.f15208h = toolbar.getTitle();
        this.f15209i = toolbar.getSubtitle();
        this.f15207g = this.f15208h != null;
        this.f15206f = toolbar.getNavigationIcon();
        if (z4) {
            android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(R.attr.steposActionBarStyleFullScreen, 0, toolbar.getContext(), null, AbstractC0560a.f12588a);
            CharSequence charSequenceU = cVarY.u(27);
            if (!TextUtils.isEmpty(charSequenceU)) {
                setTitle(charSequenceU);
            }
            CharSequence charSequenceU2 = cVarY.u(25);
            if (!TextUtils.isEmpty(charSequenceU2)) {
                this.f15209i = charSequenceU2;
                if ((this.f15202b & 8) != 0) {
                    toolbar.setSubtitle(charSequenceU2);
                }
            }
            Drawable drawableL = cVarY.l(20);
            if (drawableL != null) {
                this.f15205e = drawableL;
                K();
            }
            Drawable drawableL2 = cVarY.l(17);
            if (this.f15206f == null && drawableL2 != null) {
                setIcon(drawableL2);
            }
            Drawable drawableL3 = cVarY.l(15);
            if (drawableL3 != null) {
                this.f15206f = drawableL3;
                J();
            }
            t(cVarY.p(10, 0));
            int iR = cVarY.r(9, 0);
            if (iR != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(iR, (ViewGroup) toolbar, false);
                View view = this.f15203c;
                if (view != null && (this.f15202b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f15203c = viewInflate;
                if (viewInflate != null && (this.f15202b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                t(this.f15202b | 16);
            }
            int layoutDimension = ((TypedArray) cVarY.f2365c).getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int i4 = cVarY.i(7, -1);
            int i5 = cVarY.i(3, -1);
            if (i4 >= 0 || i5 >= 0) {
                toolbar.f15038x.c(Math.max(i4, 0), Math.max(i5, 0));
            }
            int iR2 = cVarY.r(28, 0);
            if (iR2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f15027m = iR2;
                TextView textView = toolbar.f15015c;
                if (textView != null) {
                    textView.setTextAppearance(context, iR2);
                }
            }
            int iR3 = cVarY.r(26, 0);
            if (iR3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f15029o = iR3;
                TextView textView2 = toolbar.f15016d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, iR3);
                }
            }
            int iR4 = cVarY.r(22, 0);
            if (iR4 != 0) {
                toolbar.setPopupTheme(iR4);
            }
            cVarY.A();
        } else {
            this.f15202b = toolbar.getNavigationIcon() == null ? 11 : 15;
        }
        androidx.appcompat.widget.A a4 = androidx.appcompat.widget.A.a();
        this.f15214n = a4;
        if (R.string.abc_action_bar_up_description != this.f15215o) {
            this.f15215o = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i6 = this.f15215o;
                this.f15210j = i6 != 0 ? toolbar.getContext().getString(i6) : null;
                I();
            }
        }
        this.f15210j = toolbar.getNavigationContentDescription();
        Drawable drawableB = a4.b(toolbar.getContext(), R.drawable.stepos_titlebar_ic_back_dark);
        if (this.f15216p != drawableB) {
            this.f15216p = drawableB;
            J();
        }
        toolbar.setNavigationOnClickListener(new v0(this));
    }

    @Override // stepos.support.v7.widget.D
    public final void A(ActionBarContainer actionBarContainer) {
        this.f15201a.setSplitView(actionBarContainer);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean B() {
        return true;
    }

    @Override // stepos.support.v7.widget.D
    public final void C() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.D
    public final void D(ActionBarContainer actionBarContainer) {
        Toolbar toolbar = this.f15201a;
        ViewGroup viewGroup = toolbar.f15011V;
        if (viewGroup == null || actionBarContainer == null || !Toolbar.l(viewGroup)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = toolbar.f15011V.getLayoutParams();
        layoutParams.height = actionBarContainer.getPaddingBottom() + ((int) m2.o.c(toolbar.getContext(), 80.0f));
        toolbar.f15011V.setLayoutParams(layoutParams);
    }

    @Override // stepos.support.v7.widget.D
    public final void E() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.D
    public final void F(boolean z4) {
        this.f15201a.setCollapsible(z4);
    }

    public final void G() {
        if (this.f15218r == null) {
            B b4 = new B();
            b4.f14814f = false;
            this.f15219s = b4;
            Toolbar toolbar = this.f15201a;
            Context context = toolbar.getContext();
            if (b4.f14809a == null) {
                b4.f14809a = new A(context);
            }
            this.f15218r = b4.f14809a;
            B b5 = this.f15219s;
            CharSequence charSequence = this.f15208h;
            b5.f14815g = charSequence;
            A a4 = b5.f14809a;
            if (a4 != null) {
                a4.setTitle(charSequence);
            }
            String string = toolbar.getContext().getString(android.R.string.ok);
            String string2 = toolbar.getContext().getString(android.R.string.cancel);
            B b6 = this.f15219s;
            y.g gVar = new y.g(this, b6);
            y.g gVar2 = new y.g(this, b6);
            int i4 = 1;
            if (!b6.f14814f) {
                b6.f14814f = true;
            }
            InterfaceC0856a interfaceC0856a = this.f15220t;
            if (interfaceC0856a != null) {
                interfaceC0856a.a(1, gVar);
                this.f15220t.a(0, gVar2);
            } else {
                gVar.b(string);
                gVar2.b(string2);
            }
            if (gVar.f16025a == -1) {
                gVar.f16025a = R.id.stepos_control_title_bar_btn_ok;
            }
            if (gVar2.f16025a == -1) {
                gVar2.f16025a = R.id.stepos_control_title_bar_btn_cancel;
            }
            C0094a c0094a = new C0094a(toolbar.getContext(), gVar2);
            C0094a c0094a2 = new C0094a(toolbar.getContext(), gVar);
            B b7 = this.f15219s;
            v0 v0Var = new v0(this, c0094a, i4);
            b7.getClass();
            gVar2.f16029e = b7;
            b7.f14813e = gVar2;
            b7.f14811c = v0Var;
            B b8 = this.f15219s;
            v0 v0Var2 = new v0(this, c0094a2, 2);
            b8.getClass();
            gVar.f16029e = b8;
            b8.f14812d = gVar;
            b8.f14810b = v0Var2;
            B b9 = this.f15219s;
            b9.f14814f = false;
            b9.a();
        }
    }

    public final void H(L3.v vVar, L3.i iVar) {
        Toolbar toolbar = this.f15201a;
        toolbar.f15004N = vVar;
        toolbar.f15005O = iVar;
        ActionMenuView actionMenuView = toolbar.f15013a;
        if (actionMenuView != null) {
            actionMenuView.f14803u = vVar;
            actionMenuView.f14804v = iVar;
        }
    }

    public final void I() {
        if ((this.f15202b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f15210j);
            Toolbar toolbar = this.f15201a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f15215o);
            } else {
                toolbar.setNavigationContentDescription(this.f15210j);
            }
        }
    }

    public final void J() {
        if ((this.f15202b & 4) != 0) {
            Drawable drawable = this.f15206f;
            if (drawable == null) {
                drawable = this.f15216p;
            }
            this.f15201a.setNavigationIcon(drawable);
        }
    }

    public final void K() {
        Drawable drawable;
        int i4 = this.f15202b;
        if ((i4 & 2) == 0) {
            drawable = null;
        } else if ((i4 & 1) == 0 || (drawable = this.f15205e) == null) {
            drawable = this.f15204d;
        }
        this.f15201a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.D
    public final void a(L3.k kVar, C0877w c0877w) {
        C0897q c0897q = this.f15213m;
        Toolbar toolbar = this.f15201a;
        if (c0897q == null) {
            C0897q c0897q2 = new C0897q(toolbar.getContext());
            this.f15213m = c0897q2;
            if (this.f15217q) {
                c0897q2.f15136u = true;
                this.f15213m.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (C0622a.c(toolbar.getContext()).f() * 2));
                this.f15213m.m();
                this.f15213m.l(true);
            }
        }
        C0897q c0897q3 = this.f15213m;
        c0897q3.f15120e = c0877w;
        if (kVar == null && toolbar.f15013a == null) {
            return;
        }
        toolbar.d();
        L3.k kVar2 = toolbar.f15013a.f14798p;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.q(toolbar.f15002L);
            kVar2.q(toolbar.f15003M);
        }
        if (toolbar.f15003M == null) {
            toolbar.f15003M = new r0(toolbar);
        }
        c0897q3.f15136u = true;
        if (kVar != null) {
            kVar.b(c0897q3, toolbar.f15023k);
            kVar.b(toolbar.f15003M, toolbar.f15023k);
        } else {
            c0897q3.g(toolbar.f15023k, null);
            toolbar.f15003M.g(toolbar.f15023k, null);
            c0897q3.a();
            toolbar.f15003M.a();
        }
        toolbar.f15013a.setPopupTheme(toolbar.f15025l);
        toolbar.f15013a.setPresenter(c0897q3);
        toolbar.f15002L = c0897q3;
    }

    @Override // stepos.support.v7.widget.D
    public final boolean b() {
        return this.f15201a.n();
    }

    @Override // stepos.support.v7.widget.D
    public final void c() {
        this.f15212l = true;
    }

    @Override // stepos.support.v7.widget.D
    public final void collapseActionView() {
        r0 r0Var = this.f15201a.f15003M;
        L3.l lVar = r0Var == null ? null : r0Var.f15144b;
        if (lVar != null) {
            lVar.collapseActionView();
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void d(Drawable drawable) {
        this.f15201a.setBackgroundDrawable(drawable);
    }

    @Override // stepos.support.v7.widget.D
    public final boolean e() {
        C0897q c0897q;
        ActionMenuView actionMenuView = this.f15201a.f15013a;
        return (actionMenuView == null || (c0897q = actionMenuView.f14802t) == null || (c0897q.f15112C == null && !c0897q.k())) ? false : true;
    }

    @Override // stepos.support.v7.widget.D
    public final boolean f() {
        C0897q c0897q;
        ActionMenuView actionMenuView = this.f15201a.f15013a;
        return (actionMenuView == null || (c0897q = actionMenuView.f14802t) == null || !c0897q.j()) ? false : true;
    }

    @Override // stepos.support.v7.widget.D
    public final boolean g() {
        C0897q c0897q;
        ActionMenuView actionMenuView = this.f15201a.f15013a;
        return (actionMenuView == null || (c0897q = actionMenuView.f14802t) == null || !c0897q.o()) ? false : true;
    }

    @Override // stepos.support.v7.widget.D
    public final Context getContext() {
        return this.f15201a.getContext();
    }

    @Override // stepos.support.v7.widget.D
    public final CharSequence getTitle() {
        return this.f15201a.getTitle();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean h() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f15201a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f15013a) != null && actionMenuView.f14801s;
    }

    @Override // stepos.support.v7.widget.D
    public final void i() {
        C0897q c0897q;
        ActionMenuView actionMenuView = this.f15201a.f15013a;
        if (actionMenuView == null || (c0897q = actionMenuView.f14802t) == null) {
            return;
        }
        c0897q.j();
        C0891k c0891k = c0897q.f15111B;
        if (c0891k != null) {
            c0891k.b();
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void j(boolean z4) {
    }

    @Override // stepos.support.v7.widget.D
    public final boolean k() {
        return this.f15217q;
    }

    @Override // stepos.support.v7.widget.D
    public final boolean l() {
        return this.f15201a.T;
    }

    @Override // stepos.support.v7.widget.D
    public final void m() {
        this.f15206f = androidx.appcompat.widget.A.a().b(this.f15201a.getContext(), R.drawable.stepos_titlebar_ic_back_dark);
        J();
    }

    @Override // stepos.support.v7.widget.D
    public final ViewGroup n() {
        return this.f15201a;
    }

    @Override // stepos.support.v7.widget.D
    public final void o(boolean z4) {
    }

    @Override // stepos.support.v7.widget.D
    public final void p(boolean z4) {
        this.f15201a.setShowBottomMenu(z4);
    }

    @Override // stepos.support.v7.widget.D
    public final void q(boolean z4) {
        if (this.f15217q != z4) {
            this.f15217q = z4;
            Toolbar toolbar = this.f15201a;
            toolbar.setSplitToolbar(z4);
            C0897q c0897q = this.f15213m;
            if (c0897q != null) {
                if (z4) {
                    c0897q.f15136u = true;
                    this.f15213m.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (C0622a.c(toolbar.getContext()).f() * 2));
                    this.f15213m.m();
                } else {
                    c0897q.f15136u = false;
                }
                this.f15213m.l(z4);
            }
        }
    }

    @Override // stepos.support.v7.widget.D
    public final boolean r() {
        r0 r0Var = this.f15201a.f15003M;
        return (r0Var == null || r0Var.f15144b == null) ? false : true;
    }

    @Override // stepos.support.v7.widget.D
    public final void s(InterfaceC0856a interfaceC0856a) {
        this.f15220t = interfaceC0856a;
    }

    @Override // stepos.support.v7.widget.D
    public final void setIcon(int i4) {
        Drawable drawableB;
        if (i4 != 0) {
            drawableB = this.f15214n.b(this.f15201a.getContext(), i4);
        } else {
            drawableB = null;
        }
        setIcon(drawableB);
    }

    @Override // stepos.support.v7.widget.D
    public final void setTitle(CharSequence charSequence) {
        this.f15207g = true;
        this.f15208h = charSequence;
        if ((this.f15202b & 8) != 0) {
            this.f15201a.setTitle(charSequence);
        }
        B b4 = this.f15219s;
        if (b4 != null) {
            CharSequence charSequence2 = this.f15208h;
            b4.f14815g = charSequence2;
            A a4 = b4.f14809a;
            if (a4 != null) {
                a4.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void setWindowCallback(Window.Callback callback) {
        this.f15211k = callback;
    }

    @Override // stepos.support.v7.widget.D
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.f15207g) {
            return;
        }
        this.f15208h = charSequence;
        if ((this.f15202b & 8) != 0) {
            this.f15201a.setTitle(charSequence);
        }
        B b4 = this.f15219s;
        if (b4 != null) {
            CharSequence charSequence2 = this.f15208h;
            b4.f14815g = charSequence2;
            A a4 = b4.f14809a;
            if (a4 != null) {
                a4.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void t(int i4) {
        View view;
        int i5 = this.f15202b ^ i4;
        this.f15202b = i4;
        Toolbar toolbar = this.f15201a;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    J();
                    I();
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i5 & 3) != 0) {
                K();
            }
            if ((i5 & 8) != 0) {
                if ((i4 & 8) != 0) {
                    toolbar.setTitle(this.f15208h);
                    toolbar.setSubtitle(this.f15209i);
                    toolbar.f15038x.c(toolbar.getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_content_inset_start), toolbar.getContentInsetEnd());
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) != 0 && (view = this.f15203c) != null) {
                if ((i4 & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
            if ((i5 & 64) != 0) {
                G();
                if ((i4 & 64) != 0) {
                    toolbar.addView(this.f15218r);
                    toolbar.f15038x.c(0, 0);
                } else {
                    toolbar.removeView(this.f15218r);
                    this.f15218r = null;
                }
            }
        }
        if ((i4 & 64) == 0) {
            toolbar.removeView(this.f15218r);
            this.f15218r = null;
        } else if (toolbar.indexOfChild(this.f15218r) < 0) {
            G();
            toolbar.addView(this.f15218r);
            toolbar.f15038x.c(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.D
    public final void u(L3.k kVar, C0877w c0877w) {
        C0897q c0897q = this.f15221u;
        Toolbar toolbar = this.f15201a;
        if (c0897q == null) {
            C0897q c0897q2 = new C0897q(toolbar.getContext());
            this.f15221u = c0897q2;
            c0897q2.f15136u = true;
            this.f15221u.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (C0622a.c(toolbar.getContext()).f() * 2));
            this.f15221u.m();
            this.f15221u.l(true);
        }
        C0897q c0897q3 = this.f15221u;
        c0897q3.f15120e = c0877w;
        if (toolbar.f15009S == null) {
            ActionMenuView actionMenuView = new ActionMenuView(toolbar.getContext(), null);
            toolbar.f15009S = actionMenuView;
            actionMenuView.setPopupTheme(toolbar.f15025l);
            toolbar.f15009S.setOnMenuItemClickListener(toolbar.f15000J);
            s0 s0VarF = Toolbar.f();
            s0VarF.f14437a = (toolbar.f15030p & 112) | 8388613;
            toolbar.f15009S.setLayoutParams(s0VarF);
            toolbar.f15009S.setId(R.id.stepos_action_bottom_menu_view);
            ViewGroup viewGroup = toolbar.f15011V;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) s0VarF).width = -1;
                viewGroup.addView(toolbar.f15009S, 0, s0VarF);
            }
        }
        L3.k kVar2 = toolbar.f15009S.f14798p;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.q(toolbar.f15002L);
        }
        c0897q3.f15136u = true;
        if (kVar != null) {
            kVar.b(c0897q3, toolbar.f15023k);
        }
        toolbar.f15009S.setPopupTheme(toolbar.f15025l);
        toolbar.f15009S.setPresenter(c0897q3);
    }

    @Override // stepos.support.v7.widget.D
    public final void v() {
    }

    @Override // stepos.support.v7.widget.D
    public final int w() {
        return this.f15202b;
    }

    @Override // stepos.support.v7.widget.D
    public final void x(int i4) {
        Drawable drawableB;
        if (i4 != 0) {
            drawableB = this.f15214n.b(this.f15201a.getContext(), i4);
        } else {
            drawableB = null;
        }
        this.f15205e = drawableB;
        K();
    }

    @Override // stepos.support.v7.widget.D
    public final boolean y() {
        return this.f15201a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.D
    public final K.e0 z(int i4, long j4) {
        Toolbar toolbar = this.f15201a;
        if (toolbar != null && ((toolbar.f15012W && toolbar.f15013a != null) || toolbar.f15009S != null || toolbar.f15024k0 == null)) {
            View view = toolbar.f15024k0;
            if (view == null && (view = toolbar.f15009S) == null) {
                view = toolbar.f15013a;
            }
            C0189a c0189a = toolbar.f15026l0;
            if (i4 == 0) {
                WeakHashMap weakHashMap = K.S.f939a;
                view.setAlpha(Property.DEFAULT_FLOAT_VALUE);
                K.e0 e0VarA = K.S.a(view);
                e0VarA.a(1.0f);
                e0VarA.c(j4);
                ((Toolbar) c0189a.f3051d).getClass();
                c0189a.f3050c = i4;
                e0VarA.e(c0189a);
                e0VarA.g();
            } else {
                K.e0 e0VarA2 = K.S.a(view);
                e0VarA2.a(Property.DEFAULT_FLOAT_VALUE);
                e0VarA2.c(j4);
                ((Toolbar) c0189a.f3051d).getClass();
                c0189a.f3050c = i4;
                e0VarA2.e(c0189a);
                e0VarA2.g();
            }
        }
        K.e0 e0VarA3 = K.S.a(toolbar);
        e0VarA3.a(i4 != 0 ? 0.0f : 1.0f);
        e0VarA3.c(j4);
        e0VarA3.e(new j.l(i4, 2, this));
        return e0VarA3;
    }

    @Override // stepos.support.v7.widget.D
    public final void setIcon(Drawable drawable) {
        this.f15204d = drawable;
        K();
    }
}
