package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.x0;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionMenuPresenter;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.Toolbar.d;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class e0 implements k {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f12757a;

    /* renamed from: b, reason: collision with root package name */
    public int f12758b;

    /* renamed from: c, reason: collision with root package name */
    public t f12759c;

    /* renamed from: d, reason: collision with root package name */
    public final View f12760d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f12761e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f12762f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f12763g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f12764i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f12765j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f12766k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f12767l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12768m;

    /* renamed from: n, reason: collision with root package name */
    public ActionMenuPresenter f12769n;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.appcompat.widget.j f12770o;

    /* renamed from: p, reason: collision with root package name */
    public final int f12771p;

    /* renamed from: q, reason: collision with root package name */
    public final Drawable f12772q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public h f12773s;

    /* renamed from: t, reason: collision with root package name */
    public i f12774t;

    /* renamed from: u, reason: collision with root package name */
    public a.InterfaceC0141a f12775u;

    /* renamed from: v, reason: collision with root package name */
    public ActionMenuPresenter f12776v;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ge.b f12777a;

        public a(ge.b bVar) {
            this.f12777a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e0 e0Var = e0.this;
            Window.Callback callback = e0Var.f12767l;
            if (callback == null || !e0Var.f12768m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f12777a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ge.b f12779a;

        public b(ge.b bVar) {
            this.f12779a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e0 e0Var = e0.this;
            Window.Callback callback = e0Var.f12767l;
            if (callback == null || !e0Var.f12768m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f12779a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends mb.y {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12781a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12782b;

        public c(int i10) {
            this.f12782b = i10;
        }

        @Override // mb.y, v0.i0
        public final void c() {
            this.f12781a = true;
        }

        @Override // mb.y, v0.i0
        public final void d(View view) {
            Toolbar toolbar = e0.this.f12757a;
            if (this.f12781a) {
                return;
            }
            int i10 = this.f12782b;
            toolbar.setVisibility(i10);
            toolbar.setMenuVisibility(i10);
            if (i10 == 4) {
                toolbar.requestLayout();
            }
        }

        @Override // mb.y, v0.i0
        public final void e(View view) {
            e0.this.f12757a.setVisibility(0);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public String f12784a;

        /* renamed from: b, reason: collision with root package name */
        public int f12785b = -1;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f12786c;

        /* renamed from: d, reason: collision with root package name */
        public i f12787d;

        public d(i iVar) {
            this.f12787d = iVar;
        }
    }

    public e0(Toolbar toolbar, boolean z) {
        this.f12771p = 0;
        this.f12757a = toolbar;
        this.f12764i = toolbar.getTitle();
        this.f12765j = toolbar.getSubtitle();
        this.h = this.f12764i != null;
        this.f12763g = toolbar.getNavigationIcon();
        if (z) {
            x0 x0VarE = x0.e(toolbar.getContext(), null, g.a.f8921a, R.attr.steposActionBarStyleFullScreen);
            TypedArray typedArray = x0VarE.f948b;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.f12765j = text2;
                if ((this.f12758b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableB = x0VarE.b(20);
            if (drawableB != null) {
                this.f12762f = drawableB;
                I();
            }
            Drawable drawableB2 = x0VarE.b(17);
            if (this.f12763g == null && drawableB2 != null) {
                setIcon(drawableB2);
            }
            Drawable drawableB3 = x0VarE.b(15);
            if (drawableB3 != null) {
                this.f12763g = drawableB3;
                H();
            }
            h(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f12760d;
                if (view != null && (this.f12758b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f12760d = viewInflate;
                if (viewInflate != null && (this.f12758b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                h(this.f12758b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.A.a(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f12659p = resourceId2;
                TextView textView = toolbar.f12648c;
                if (textView != null) {
                    textView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.r = resourceId3;
                TextView textView2 = toolbar.f12649d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
            x0VarE.f();
        } else {
            this.f12758b = toolbar.getNavigationIcon() == null ? 11 : 15;
        }
        androidx.appcompat.widget.j jVarA = androidx.appcompat.widget.j.a();
        this.f12770o = jVarA;
        if (R.string.abc_action_bar_up_description != this.f12771p) {
            this.f12771p = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i10 = this.f12771p;
                this.f12766k = i10 != 0 ? toolbar.getContext().getString(i10) : null;
                G();
            }
        }
        this.f12766k = toolbar.getNavigationContentDescription();
        Drawable drawableB4 = jVarA.b(R.drawable.stepos_titlebar_ic_back_dark, toolbar.getContext());
        if (this.f12772q != drawableB4) {
            this.f12772q = drawableB4;
            H();
        }
        toolbar.setNavigationOnClickListener(new d0(this));
    }

    @Override // stepos.support.v7.widget.k
    public final void A(Menu menu, g.a aVar) {
        ActionMenuPresenter actionMenuPresenter = this.f12776v;
        Toolbar toolbar = this.f12757a;
        if (actionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(toolbar.getContext());
            this.f12776v = actionMenuPresenter2;
            actionMenuPresenter2.f12510x = true;
            this.f12776v.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (fe.a.a(toolbar.getContext()).b() * 2));
            this.f12776v.m();
            this.f12776v.l(true);
        }
        ActionMenuPresenter actionMenuPresenter3 = this.f12776v;
        actionMenuPresenter3.f12364e = aVar;
        stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) menu;
        if (toolbar.V == null) {
            ActionMenuView actionMenuView = new ActionMenuView(toolbar.getContext(), null);
            toolbar.V = actionMenuView;
            actionMenuView.setPopupTheme(toolbar.f12658o);
            toolbar.V.setOnMenuItemClickListener(toolbar.M);
            Toolbar.e eVarF = Toolbar.f();
            eVarF.f12071a = (toolbar.f12661s & 112) | 8388613;
            toolbar.V.setLayoutParams(eVarF);
            toolbar.V.setId(R.id.stepos_action_bottom_menu_view);
            ViewGroup viewGroup = toolbar.b0;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) eVarF).width = -1;
                viewGroup.addView(toolbar.V, 0, eVarF);
            }
        }
        stepos.support.v7.view.menu.c cVar2 = toolbar.V.f12523s;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 != null) {
            cVar2.q(toolbar.O);
        }
        actionMenuPresenter3.f12510x = true;
        if (cVar != null) {
            cVar.b(actionMenuPresenter3, toolbar.f12657n);
        }
        toolbar.V.setPopupTheme(toolbar.f12658o);
        toolbar.V.setPresenter(actionMenuPresenter3);
    }

    @Override // stepos.support.v7.widget.k
    public final boolean B() {
        return this.f12757a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean C() {
        return true;
    }

    @Override // stepos.support.v7.widget.k
    public final void D(boolean z) {
        this.f12757a.setShowBottomMenu(z);
    }

    @Override // stepos.support.v7.widget.k
    public final t E() {
        return this.f12759c;
    }

    public final void F() {
        if (this.f12773s == null) {
            i iVar = new i();
            iVar.f12811f = false;
            this.f12774t = iVar;
            Toolbar toolbar = this.f12757a;
            Context context = toolbar.getContext();
            if (iVar.f12806a == null) {
                iVar.f12806a = new h(context);
            }
            this.f12773s = iVar.f12806a;
            i iVar2 = this.f12774t;
            CharSequence charSequence = this.f12764i;
            iVar2.f12812g = charSequence;
            h hVar = iVar2.f12806a;
            if (hVar != null) {
                hVar.setTitle(charSequence);
            }
            String string = toolbar.getContext().getString(android.R.string.ok);
            String string2 = toolbar.getContext().getString(android.R.string.cancel);
            i iVar3 = this.f12774t;
            d dVar = new d(iVar3);
            d dVar2 = new d(iVar3);
            if (!iVar3.f12811f) {
                iVar3.f12811f = true;
            }
            a.InterfaceC0141a interfaceC0141a = this.f12775u;
            if (interfaceC0141a != null) {
                interfaceC0141a.a(1, dVar);
                this.f12775u.a(0, dVar2);
            } else {
                if (dVar.f12784a != string) {
                    dVar.f12784a = string;
                    if (iVar3 != null) {
                        iVar3.a();
                    }
                }
                if (dVar2.f12784a != string2) {
                    dVar2.f12784a = string2;
                    i iVar4 = dVar2.f12787d;
                    if (iVar4 != null) {
                        iVar4.a();
                    }
                }
            }
            if (dVar.f12785b == -1) {
                dVar.f12785b = R.id.stepos_control_title_bar_btn_ok;
            }
            if (dVar2.f12785b == -1) {
                dVar2.f12785b = R.id.stepos_control_title_bar_btn_cancel;
            }
            ge.b bVar = new ge.b(toolbar.getContext(), dVar2);
            ge.b bVar2 = new ge.b(toolbar.getContext(), dVar);
            i iVar5 = this.f12774t;
            a aVar = new a(bVar);
            iVar5.getClass();
            dVar2.f12787d = iVar5;
            iVar5.f12810e = dVar2;
            iVar5.f12808c = aVar;
            i iVar6 = this.f12774t;
            b bVar3 = new b(bVar2);
            iVar6.getClass();
            dVar.f12787d = iVar6;
            iVar6.f12809d = dVar;
            iVar6.f12807b = bVar3;
            i iVar7 = this.f12774t;
            iVar7.f12811f = false;
            iVar7.a();
        }
    }

    public final void G() {
        if ((this.f12758b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f12766k);
            Toolbar toolbar = this.f12757a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f12771p);
            } else {
                toolbar.setNavigationContentDescription(this.f12766k);
            }
        }
    }

    public final void H() {
        if ((this.f12758b & 4) != 0) {
            Drawable drawable = this.f12763g;
            if (drawable == null) {
                drawable = this.f12772q;
            }
            this.f12757a.setNavigationIcon(drawable);
        }
    }

    public final void I() {
        Drawable drawable;
        int i10 = this.f12758b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f12762f) == null) {
            drawable = this.f12761e;
        }
        this.f12757a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.k
    public final boolean a() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f12757a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f12645a) != null && actionMenuView.f12526v;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean b() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f12757a.f12645a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null || !actionMenuPresenter.j()) ? false : true;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean c() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f12757a.f12645a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null || !actionMenuPresenter.o()) ? false : true;
    }

    @Override // stepos.support.v7.widget.k
    public final void collapseActionView() {
        Toolbar.d dVar = this.f12757a.P;
        stepos.support.v7.view.menu.e eVar = dVar == null ? null : dVar.f12672b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }

    @Override // stepos.support.v7.widget.k
    public final boolean d() {
        return this.f12757a.m();
    }

    @Override // stepos.support.v7.widget.k
    public final void e() {
        this.f12768m = true;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean f() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f12757a.f12645a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null) {
            return false;
        }
        return actionMenuPresenter.F != null || actionMenuPresenter.k();
    }

    @Override // stepos.support.v7.widget.k
    public final boolean g() {
        Toolbar.d dVar = this.f12757a.P;
        return (dVar == null || dVar.f12672b == null) ? false : true;
    }

    @Override // stepos.support.v7.widget.k
    public final Context getContext() {
        return this.f12757a.getContext();
    }

    @Override // stepos.support.v7.widget.k
    public final CharSequence getTitle() {
        return this.f12757a.getTitle();
    }

    @Override // stepos.support.v7.widget.k
    public final void h(int i10) {
        t tVar;
        View view;
        Toolbar toolbar = this.f12757a;
        p0 p0Var = toolbar.A;
        int i11 = this.f12758b ^ i10;
        this.f12758b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                    G();
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i11 & 3) != 0) {
                I();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    toolbar.setTitle(this.f12764i);
                    toolbar.setSubtitle(this.f12765j);
                    p0Var.a(toolbar.getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_content_inset_start), toolbar.getContentInsetEnd());
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f12760d) != null) {
                if ((i10 & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
            if ((i11 & 32) != 0 && (tVar = this.f12759c) != null && (i10 & 32) == 0 && tVar.getParent() == toolbar) {
                toolbar.removeView(this.f12759c);
            }
            if ((i11 & 64) != 0) {
                F();
                if ((i10 & 64) != 0) {
                    toolbar.addView(this.f12773s);
                    p0Var.a(0, 0);
                } else {
                    toolbar.removeView(this.f12773s);
                    this.f12773s = null;
                }
            }
        }
        if ((i10 & 64) == 0) {
            toolbar.removeView(this.f12773s);
            this.f12773s = null;
        } else if (toolbar.indexOfChild(this.f12773s) < 0) {
            F();
            toolbar.addView(this.f12773s);
            p0Var.a(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.k
    public final h0 i(int i10, long j10) {
        Toolbar toolbar = this.f12757a;
        Toolbar.g gVar = toolbar.f12652e0;
        if ((toolbar.c0 && toolbar.f12645a != null) || toolbar.V != null || toolbar.f12650d0 == null) {
            View view = toolbar.f12650d0;
            if (view == null && (view = toolbar.V) == null) {
                view = toolbar.f12645a;
            }
            if (i10 == 0) {
                WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
                view.setAlpha(0.0f);
                h0 h0VarA = v0.e0.a(view);
                h0VarA.a(1.0f);
                h0VarA.c(j10);
                gVar.f12676b = i10;
                h0VarA.e(gVar);
                h0VarA.g();
            } else {
                h0 h0VarA2 = v0.e0.a(view);
                h0VarA2.a(0.0f);
                h0VarA2.c(j10);
                gVar.f12676b = i10;
                h0VarA2.e(gVar);
                h0VarA2.g();
            }
        }
        h0 h0VarA3 = v0.e0.a(toolbar);
        h0VarA3.a(i10 != 0 ? 0.0f : 1.0f);
        h0VarA3.c(j10);
        h0VarA3.e(new c(i10));
        return h0VarA3;
    }

    @Override // stepos.support.v7.widget.k
    public final void j() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.k
    public final void k(boolean z) {
        this.f12757a.setCollapsible(z);
    }

    @Override // stepos.support.v7.widget.k
    public final void l() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f12757a.f12645a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.f12527w) == null) {
            return;
        }
        actionMenuPresenter.j();
        ActionMenuPresenter.c cVar = actionMenuPresenter.E;
        if (cVar != null) {
            cVar.h();
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void m(Menu menu, g.a aVar) {
        ActionMenuPresenter actionMenuPresenter = this.f12769n;
        Toolbar toolbar = this.f12757a;
        if (actionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(toolbar.getContext());
            this.f12769n = actionMenuPresenter2;
            if (this.r) {
                actionMenuPresenter2.f12510x = true;
                this.f12769n.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (fe.a.a(toolbar.getContext()).b() * 2));
                this.f12769n.m();
                this.f12769n.l(true);
            }
        }
        ActionMenuPresenter actionMenuPresenter3 = this.f12769n;
        actionMenuPresenter3.f12364e = aVar;
        stepos.support.v7.view.menu.c cVar = (stepos.support.v7.view.menu.c) menu;
        if (cVar == null && toolbar.f12645a == null) {
            return;
        }
        toolbar.d();
        stepos.support.v7.view.menu.c cVar2 = toolbar.f12645a.f12523s;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 != null) {
            cVar2.q(toolbar.O);
            cVar2.q(toolbar.P);
        }
        if (toolbar.P == null) {
            toolbar.P = toolbar.new d();
        }
        actionMenuPresenter3.f12510x = true;
        if (cVar != null) {
            cVar.b(actionMenuPresenter3, toolbar.f12657n);
            cVar.b(toolbar.P, toolbar.f12657n);
        } else {
            actionMenuPresenter3.g(toolbar.f12657n, null);
            toolbar.P.g(toolbar.f12657n, null);
            actionMenuPresenter3.b();
            toolbar.P.b();
        }
        toolbar.f12645a.setPopupTheme(toolbar.f12658o);
        toolbar.f12645a.setPresenter(actionMenuPresenter3);
        toolbar.O = actionMenuPresenter3;
    }

    @Override // stepos.support.v7.widget.k
    public final void n() {
        t tVar = this.f12759c;
        if (tVar != null) {
            ViewParent parent = tVar.getParent();
            Toolbar toolbar = this.f12757a;
            if (parent == toolbar) {
                toolbar.removeView(this.f12759c);
            }
        }
        t tVar2 = this.f12759c;
        if (tVar2 != null) {
            tVar2.setTabView(null);
            this.f12759c = null;
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void o(int i10) {
        Drawable drawableB;
        if (i10 != 0) {
            drawableB = this.f12770o.b(i10, this.f12757a.getContext());
        } else {
            drawableB = null;
        }
        this.f12762f = drawableB;
        I();
    }

    @Override // stepos.support.v7.widget.k
    public final int p() {
        return this.f12758b;
    }

    @Override // stepos.support.v7.widget.k
    public final void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.k
    public final boolean r() {
        return this.f12757a.W;
    }

    @Override // stepos.support.v7.widget.k
    public final void s(boolean z) {
        if (this.r != z) {
            this.r = z;
            Toolbar toolbar = this.f12757a;
            toolbar.setSplitToolbar(z);
            ActionMenuPresenter actionMenuPresenter = this.f12769n;
            if (actionMenuPresenter != null) {
                if (z) {
                    actionMenuPresenter.f12510x = true;
                    this.f12769n.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (fe.a.a(toolbar.getContext()).b() * 2));
                    this.f12769n.m();
                } else {
                    actionMenuPresenter.f12510x = false;
                }
                this.f12769n.l(z);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void setIcon(int i10) {
        Drawable drawableB;
        if (i10 != 0) {
            drawableB = this.f12770o.b(i10, this.f12757a.getContext());
        } else {
            drawableB = null;
        }
        setIcon(drawableB);
    }

    @Override // stepos.support.v7.widget.k
    public final void setTitle(CharSequence charSequence) {
        this.h = true;
        this.f12764i = charSequence;
        if ((this.f12758b & 8) != 0) {
            this.f12757a.setTitle(charSequence);
        }
        i iVar = this.f12774t;
        if (iVar != null) {
            CharSequence charSequence2 = this.f12764i;
            iVar.f12812g = charSequence2;
            h hVar = iVar.f12806a;
            if (hVar != null) {
                hVar.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void setWindowCallback(Window.Callback callback) {
        this.f12767l = callback;
    }

    @Override // stepos.support.v7.widget.k
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        this.f12764i = charSequence;
        if ((this.f12758b & 8) != 0) {
            this.f12757a.setTitle(charSequence);
        }
        i iVar = this.f12774t;
        if (iVar != null) {
            CharSequence charSequence2 = this.f12764i;
            iVar.f12812g = charSequence2;
            h hVar = iVar.f12806a;
            if (hVar != null) {
                hVar.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.k
    public final void t(a.InterfaceC0141a interfaceC0141a) {
        this.f12775u = interfaceC0141a;
    }

    @Override // stepos.support.v7.widget.k
    public final ViewGroup u() {
        return this.f12757a;
    }

    @Override // stepos.support.v7.widget.k
    public final boolean x() {
        return this.r;
    }

    @Override // stepos.support.v7.widget.k
    public final void y(ViewGroup viewGroup) {
        Toolbar toolbar = this.f12757a;
        ViewGroup viewGroup2 = toolbar.b0;
        if (viewGroup2 == null || viewGroup == null || !Toolbar.k(viewGroup2)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = toolbar.b0.getLayoutParams();
        layoutParams.height = viewGroup.getPaddingBottom() + ((int) l8.f.a(80.0f, toolbar.getContext()));
        toolbar.b0.setLayoutParams(layoutParams);
    }

    @Override // stepos.support.v7.widget.k
    public final void z(ViewGroup viewGroup) {
        this.f12757a.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.k
    public final void setIcon(Drawable drawable) {
        this.f12761e = drawable;
        I();
    }

    @Override // stepos.support.v7.widget.k
    public final void v(boolean z) {
    }

    @Override // stepos.support.v7.widget.k
    public final void w(boolean z) {
    }
}
