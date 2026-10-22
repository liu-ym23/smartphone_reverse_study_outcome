package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import m.f2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v1 implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f12871a;

    /* renamed from: b, reason: collision with root package name */
    public int f12872b;

    /* renamed from: c, reason: collision with root package name */
    public final View f12873c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f12874d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f12875e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f12876f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12877g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f12878h;
    public final CharSequence i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f12879j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f12880k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12881l;

    /* renamed from: m, reason: collision with root package name */
    public q f12882m;

    /* renamed from: n, reason: collision with root package name */
    public final m.s f12883n;

    /* renamed from: o, reason: collision with root package name */
    public final int f12884o;

    /* renamed from: p, reason: collision with root package name */
    public final Drawable f12885p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12886q;

    /* renamed from: r, reason: collision with root package name */
    public a0 f12887r;

    /* renamed from: s, reason: collision with root package name */
    public m4.b f12888s;

    /* renamed from: t, reason: collision with root package name */
    public r2.i f12889t;

    /* renamed from: u, reason: collision with root package name */
    public q f12890u;

    public v1(Toolbar toolbar, boolean z10) {
        this.f12884o = 0;
        this.f12871a = toolbar;
        this.f12878h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.f12877g = this.f12878h != null;
        this.f12876f = toolbar.getNavigationIcon();
        if (z10) {
            p5.m mVarJ = p5.m.J(toolbar.getContext(), null, g.a.f4098a, R.attr.steposActionBarStyleFullScreen);
            TypedArray typedArray = (TypedArray) mVarJ.f9742g;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.f12872b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableA = mVarJ.A(20);
            if (drawableA != null) {
                this.f12875e = drawableA;
                H();
            }
            Drawable drawableA2 = mVarJ.A(17);
            if (this.f12876f == null && drawableA2 != null) {
                setIcon(drawableA2);
            }
            Drawable drawableA3 = mVarJ.A(15);
            if (drawableA3 != null) {
                this.f12876f = drawableA3;
                G();
            }
            q(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f12873c;
                if (view != null && (this.f12872b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f12873c = viewInflate;
                if (viewInflate != null && (this.f12872b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                q(this.f12872b | 16);
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
                toolbar.B.a(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f12694q = resourceId2;
                TextView textView = toolbar.f12685g;
                if (textView != null) {
                    textView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f12696s = resourceId3;
                TextView textView2 = toolbar.f12686h;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
            mVarJ.M();
        } else {
            this.f12872b = toolbar.getNavigationIcon() == null ? 11 : 15;
        }
        m.s sVarA = m.s.a();
        this.f12883n = sVarA;
        if (R.string.abc_action_bar_up_description != this.f12884o) {
            this.f12884o = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i = this.f12884o;
                this.f12879j = i == 0 ? null : toolbar.getContext().getString(i);
                F();
            }
        }
        this.f12879j = toolbar.getNavigationContentDescription();
        Drawable drawableB = sVarA.b(R.drawable.stepos_titlebar_ic_back_dark, toolbar.getContext());
        if (this.f12885p != drawableB) {
            this.f12885p = drawableB;
            G();
        }
        u1 u1Var = new u1(0);
        u1Var.f12843g = this;
        Context context3 = toolbar.getContext();
        CharSequence charSequence = this.f12878h;
        te.a aVar = new te.a();
        aVar.f13316f = 4096;
        aVar.f13318h = 4096;
        aVar.f13322m = null;
        aVar.f13323n = null;
        aVar.f13324o = false;
        aVar.f13325p = false;
        aVar.f13326q = 16;
        aVar.f13327r = null;
        aVar.f13319j = context3;
        aVar.f13311a = android.R.id.home;
        aVar.f13312b = charSequence;
        VarHandle.storeStoreFence();
        u1Var.f12842f = aVar;
        VarHandle.storeStoreFence();
        toolbar.setNavigationOnClickListener(u1Var);
    }

    @Override // stepos.support.v7.widget.c0
    public final int A() {
        return this.f12872b;
    }

    @Override // stepos.support.v7.widget.c0
    public final void B() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.c0
    public final void C() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.c0
    public final void D(boolean z10) {
        this.f12871a.setCollapsible(z10);
    }

    public final void E() {
        if (this.f12887r == null) {
            m4.b bVar = new m4.b();
            bVar.f8201a = false;
            this.f12888s = bVar;
            Toolbar toolbar = this.f12871a;
            Context context = toolbar.getContext();
            if (((a0) bVar.f8202b) == null) {
                a0 a0Var = new a0(context, null, R.attr.steposControlTitleBarStyle);
                a0Var.A = 17;
                r9.l lVar = new r9.l();
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, oe.a.f9503e, R.attr.steposControlTitleBarStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(0, R.layout.stepos_control_title_bar_negative_item);
                int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(1, R.layout.stepos_control_title_bar_positive_item);
                typedArrayObtainStyledAttributes.recycle();
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
                a0Var.B = a0Var.getResources().getDimensionPixelSize(R.dimen.stepos_action_bar_control_title_bar_min_title_width);
                View viewInflate = layoutInflaterFrom.inflate(resourceId3, (ViewGroup) a0Var, false);
                a0Var.f12720v = viewInflate;
                a0Var.addView(viewInflate);
                View viewInflate2 = layoutInflaterFrom.inflate(resourceId4, (ViewGroup) a0Var, false);
                a0Var.f12721w = viewInflate2;
                a0Var.addView(viewInflate2);
                lVar.b(5, viewInflate);
                lVar.b(5, viewInflate2);
                View viewInflate3 = layoutInflaterFrom.inflate(R.layout.stepos_action_bar_title_item, (ViewGroup) a0Var, false);
                a0Var.f12722x = viewInflate3;
                a0Var.addView(viewInflate3);
                TextView textView = (TextView) viewInflate3.findViewById(R.id.action_bar_title);
                a0Var.f12718t = textView;
                TextView textView2 = (TextView) viewInflate3.findViewById(R.id.action_bar_subtitle);
                a0Var.f12719u = textView2;
                if (resourceId != 0) {
                    textView.setTextAppearance(a0Var.getContext(), resourceId);
                }
                if (resourceId2 != 0) {
                    textView2.setTextAppearance(a0Var.getContext(), resourceId2);
                }
                float f5 = a0Var.getResources().getDisplayMetrics().density;
                VarHandle.storeStoreFence();
                bVar.f8202b = a0Var;
            }
            this.f12887r = (a0) bVar.f8202b;
            m4.b bVar2 = this.f12888s;
            CharSequence charSequence = this.f12878h;
            bVar2.f8207g = charSequence;
            a0 a0Var2 = (a0) bVar2.f8202b;
            if (a0Var2 != null) {
                a0Var2.setTitle(charSequence);
            }
            String string = toolbar.getContext().getString(android.R.string.ok);
            String string2 = toolbar.getContext().getString(android.R.string.cancel);
            m4.b bVar3 = this.f12888s;
            f7.x xVar = new f7.x(bVar3);
            f7.x xVar2 = new f7.x(bVar3);
            if (!bVar3.f8201a) {
                bVar3.f8201a = true;
            }
            r2.i iVar = this.f12889t;
            if (iVar != null) {
                iVar.o(1, xVar);
                this.f12889t.o(0, xVar2);
            } else {
                if (((String) xVar.f4030b) != string) {
                    xVar.f4030b = string;
                    if (bVar3 != null) {
                        bVar3.a();
                    }
                }
                if (((String) xVar2.f4030b) != string2) {
                    xVar2.f4030b = string2;
                    m4.b bVar4 = (m4.b) xVar2.f4032d;
                    if (bVar4 != null) {
                        bVar4.a();
                    }
                }
            }
            if (xVar.f4029a == -1) {
                xVar.f4029a = R.id.stepos_control_title_bar_btn_ok;
            }
            if (xVar2.f4029a == -1) {
                xVar2.f4029a = R.id.stepos_control_title_bar_btn_cancel;
            }
            te.a aVar = new te.a(toolbar.getContext(), xVar2);
            te.a aVar2 = new te.a(toolbar.getContext(), xVar);
            m4.b bVar5 = this.f12888s;
            u1 u1Var = new u1(1);
            u1Var.f12843g = this;
            u1Var.f12842f = aVar;
            VarHandle.storeStoreFence();
            bVar5.getClass();
            xVar2.f4032d = bVar5;
            bVar5.f8206f = xVar2;
            bVar5.f8204d = u1Var;
            m4.b bVar6 = this.f12888s;
            u1 u1Var2 = new u1(2);
            u1Var2.f12843g = this;
            u1Var2.f12842f = aVar2;
            VarHandle.storeStoreFence();
            bVar6.getClass();
            xVar.f4032d = bVar6;
            bVar6.f8205e = xVar;
            bVar6.f8203c = u1Var2;
            m4.b bVar7 = this.f12888s;
            bVar7.f8201a = false;
            bVar7.a();
        }
    }

    public final void F() {
        if ((this.f12872b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f12879j);
            Toolbar toolbar = this.f12871a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f12884o);
            } else {
                toolbar.setNavigationContentDescription(this.f12879j);
            }
        }
    }

    public final void G() {
        if ((this.f12872b & 4) != 0) {
            Drawable drawable = this.f12876f;
            if (drawable == null) {
                drawable = this.f12885p;
            }
            this.f12871a.setNavigationIcon(drawable);
        }
    }

    public final void H() {
        Drawable drawable;
        int i = this.f12872b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f12875e) == null) {
            drawable = this.f12874d;
        }
        this.f12871a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean a() {
        return this.f12871a.m();
    }

    @Override // stepos.support.v7.widget.c0
    public final void b() {
        this.f12881l = true;
    }

    @Override // stepos.support.v7.widget.c0
    public final void c(Menu menu, te.u uVar) {
        q qVar = this.f12882m;
        Toolbar toolbar = this.f12871a;
        if (qVar == null) {
            q qVar2 = new q(toolbar.getContext());
            this.f12882m = qVar2;
            if (this.f12886q) {
                qVar2.f12820y = true;
                this.f12882m.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (a4.n.c(toolbar.getContext()).d() * 2));
                this.f12882m.m();
                this.f12882m.l(true);
            }
        }
        q qVar3 = this.f12882m;
        qVar3.i = uVar;
        te.l lVar = (te.l) menu;
        if (lVar == null && toolbar.f12681c == null) {
            return;
        }
        toolbar.d();
        te.l lVar2 = toolbar.f12681c.f12602t;
        if (lVar2 == lVar) {
            return;
        }
        if (lVar2 != null) {
            lVar2.q(toolbar.P);
            lVar2.q(toolbar.Q);
        }
        if (toolbar.Q == null) {
            toolbar.Q = new q1(toolbar);
        }
        qVar3.f12820y = true;
        Context context = toolbar.f12692o;
        if (lVar != null) {
            lVar.b(qVar3, context);
            lVar.b(toolbar.Q, toolbar.f12692o);
        } else {
            qVar3.f(context, null);
            toolbar.Q.f(toolbar.f12692o, null);
            qVar3.c();
            toolbar.Q.c();
        }
        toolbar.f12681c.setPopupTheme(toolbar.f12693p);
        toolbar.f12681c.setPresenter(qVar3);
        toolbar.P = qVar3;
    }

    @Override // stepos.support.v7.widget.c0
    public final void collapseActionView() {
        q1 q1Var = this.f12871a.Q;
        te.m mVar = q1Var == null ? null : q1Var.f12823f;
        if (mVar != null) {
            mVar.collapseActionView();
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean d() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f12871a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f12681c) != null && actionMenuView.f12605w;
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean e() {
        q qVar;
        ActionMenuView actionMenuView = this.f12871a.f12681c;
        if (actionMenuView == null || (qVar = actionMenuView.f12606x) == null) {
            return false;
        }
        return qVar.G != null || qVar.k();
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean f() {
        q qVar;
        ActionMenuView actionMenuView = this.f12871a.f12681c;
        return (actionMenuView == null || (qVar = actionMenuView.f12606x) == null || !qVar.j()) ? false : true;
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean g() {
        q qVar;
        ActionMenuView actionMenuView = this.f12871a.f12681c;
        return (actionMenuView == null || (qVar = actionMenuView.f12606x) == null || !qVar.o()) ? false : true;
    }

    @Override // stepos.support.v7.widget.c0
    public final Context getContext() {
        return this.f12871a.getContext();
    }

    @Override // stepos.support.v7.widget.c0
    public final CharSequence getTitle() {
        return this.f12871a.getTitle();
    }

    @Override // stepos.support.v7.widget.c0
    public final void h(Menu menu, te.u uVar) {
        q qVar = this.f12890u;
        Toolbar toolbar = this.f12871a;
        if (qVar == null) {
            q qVar2 = new q(toolbar.getContext());
            this.f12890u = qVar2;
            qVar2.f12820y = true;
            this.f12890u.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (a4.n.c(toolbar.getContext()).d() * 2));
            this.f12890u.m();
            this.f12890u.l(true);
        }
        q qVar3 = this.f12890u;
        qVar3.i = uVar;
        te.l lVar = (te.l) menu;
        if (toolbar.W == null) {
            ActionMenuView actionMenuView = new ActionMenuView(toolbar.getContext());
            toolbar.W = actionMenuView;
            actionMenuView.setPopupTheme(toolbar.f12693p);
            toolbar.W.setOnMenuItemClickListener(toolbar.N);
            r1 r1VarF = Toolbar.f();
            r1VarF.f12825a = (toolbar.f12697t & 112) | 8388613;
            toolbar.W.setLayoutParams(r1VarF);
            toolbar.W.setId(R.id.stepos_action_bottom_menu_view);
            ViewGroup viewGroup = toolbar.f12682c0;
            if (viewGroup != null) {
                ((ViewGroup.MarginLayoutParams) r1VarF).width = -1;
                viewGroup.addView(toolbar.W, 0, r1VarF);
            }
        }
        te.l lVar2 = toolbar.W.f12602t;
        if (lVar2 == lVar) {
            return;
        }
        if (lVar2 != null) {
            lVar2.q(toolbar.P);
        }
        qVar3.f12820y = true;
        if (lVar != null) {
            lVar.b(qVar3, toolbar.f12692o);
        }
        toolbar.W.setPopupTheme(toolbar.f12693p);
        toolbar.W.setPresenter(qVar3);
    }

    @Override // stepos.support.v7.widget.c0
    public final void i() {
        q qVar;
        ActionMenuView actionMenuView = this.f12871a.f12681c;
        if (actionMenuView == null || (qVar = actionMenuView.f12606x) == null) {
            return;
        }
        qVar.j();
        l lVar = qVar.F;
        if (lVar != null) {
            lVar.h();
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean k() {
        return this.f12886q;
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean l() {
        return this.f12871a.f12679a0;
    }

    @Override // stepos.support.v7.widget.c0
    public final void m(ViewGroup viewGroup) {
        Toolbar toolbar = this.f12871a;
        ViewGroup viewGroup2 = toolbar.f12682c0;
        if (viewGroup2 == null || viewGroup == null || !Toolbar.k(viewGroup2)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = toolbar.f12682c0.getLayoutParams();
        layoutParams.height = viewGroup.getPaddingBottom() + ((int) t1.e.e(80.0f, toolbar.getContext()));
        toolbar.f12682c0.setLayoutParams(layoutParams);
    }

    @Override // stepos.support.v7.widget.c0
    public final void n(boolean z10) {
        if (this.f12886q != z10) {
            this.f12886q = z10;
            Toolbar toolbar = this.f12871a;
            toolbar.setSplitToolbar(z10);
            q qVar = this.f12882m;
            if (qVar != null) {
                if (z10) {
                    qVar.f12820y = true;
                    this.f12882m.n(toolbar.getContext().getResources().getDisplayMetrics().widthPixels - (a4.n.c(toolbar.getContext()).d() * 2));
                    this.f12882m.m();
                } else {
                    qVar.f12820y = false;
                }
                this.f12882m.l(z10);
            }
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean o() {
        q1 q1Var = this.f12871a.Q;
        return (q1Var == null || q1Var.f12823f == null) ? false : true;
    }

    @Override // stepos.support.v7.widget.c0
    public final void p(ViewGroup viewGroup) {
        this.f12871a.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.c0
    public final void q(int i) {
        View view;
        Toolbar toolbar = this.f12871a;
        f2 f2Var = toolbar.B;
        int i3 = this.f12872b ^ i;
        this.f12872b = i;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i & 4) != 0) {
                    G();
                    F();
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                H();
            }
            if ((i3 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.f12878h);
                    toolbar.setSubtitle(this.i);
                    f2Var.a(toolbar.getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_content_inset_start), toolbar.getContentInsetEnd());
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f12873c) != null) {
                if ((i & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
            if ((i3 & 64) != 0) {
                E();
                int i10 = i & 64;
                a0 a0Var = this.f12887r;
                if (i10 != 0) {
                    toolbar.addView(a0Var);
                    f2Var.a(0, 0);
                } else {
                    toolbar.removeView(a0Var);
                    this.f12887r = null;
                }
            }
        }
        int i11 = i & 64;
        a0 a0Var2 = this.f12887r;
        if (i11 == 0) {
            toolbar.removeView(a0Var2);
            this.f12887r = null;
        } else if (toolbar.indexOfChild(a0Var2) < 0) {
            E();
            toolbar.addView(this.f12887r);
            f2Var.a(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final void s(int i) {
        Drawable drawableB;
        if (i != 0) {
            drawableB = this.f12883n.b(i, this.f12871a.getContext());
        } else {
            drawableB = null;
        }
        this.f12875e = drawableB;
        H();
    }

    @Override // stepos.support.v7.widget.c0
    public final void setIcon(int i) {
        Drawable drawableB;
        if (i != 0) {
            drawableB = this.f12883n.b(i, this.f12871a.getContext());
        } else {
            drawableB = null;
        }
        setIcon(drawableB);
    }

    @Override // stepos.support.v7.widget.c0
    public final void setTitle(CharSequence charSequence) {
        this.f12877g = true;
        this.f12878h = charSequence;
        if ((this.f12872b & 8) != 0) {
            this.f12871a.setTitle(charSequence);
        }
        m4.b bVar = this.f12888s;
        if (bVar != null) {
            CharSequence charSequence2 = this.f12878h;
            bVar.f8207g = charSequence2;
            a0 a0Var = (a0) bVar.f8202b;
            if (a0Var != null) {
                a0Var.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final void setWindowCallback(Window.Callback callback) {
        this.f12880k = callback;
    }

    @Override // stepos.support.v7.widget.c0
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.f12877g) {
            return;
        }
        this.f12878h = charSequence;
        if ((this.f12872b & 8) != 0) {
            this.f12871a.setTitle(charSequence);
        }
        m4.b bVar = this.f12888s;
        if (bVar != null) {
            CharSequence charSequence2 = this.f12878h;
            bVar.f8207g = charSequence2;
            a0 a0Var = (a0) bVar.f8202b;
            if (a0Var != null) {
                a0Var.setTitle(charSequence2);
            }
        }
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean t() {
        return this.f12871a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.c0
    public final n3.o0 u(int i, long j10) {
        Toolbar toolbar = this.f12871a;
        m.a aVar = toolbar.f0;
        if ((toolbar.f12683d0 && toolbar.f12681c != null) || toolbar.W != null || toolbar.e0 == null) {
            View view = toolbar.e0;
            if (view == null && (view = toolbar.W) == null) {
                view = toolbar.f12681c;
            }
            if (i == 0) {
                WeakHashMap weakHashMap = n3.k0.f8724a;
                view.setAlpha(0.0f);
                n3.o0 o0VarA = n3.k0.a(view);
                o0VarA.a(1.0f);
                o0VarA.c(j10);
                aVar.f7865g = i;
                o0VarA.e(aVar);
                o0VarA.g();
            } else {
                n3.o0 o0VarA2 = n3.k0.a(view);
                o0VarA2.a(0.0f);
                o0VarA2.c(j10);
                aVar.f7865g = i;
                o0VarA2.e(aVar);
                o0VarA2.g();
            }
        }
        n3.o0 o0VarA3 = n3.k0.a(toolbar);
        o0VarA3.a(i != 0 ? 0.0f : 1.0f);
        o0VarA3.c(j10);
        k.j jVar = new k.j(2);
        jVar.f6852j = this;
        jVar.i = i;
        jVar.f6851h = false;
        VarHandle.storeStoreFence();
        o0VarA3.e(jVar);
        return o0VarA3;
    }

    @Override // stepos.support.v7.widget.c0
    public final boolean v() {
        return true;
    }

    @Override // stepos.support.v7.widget.c0
    public final ViewGroup w() {
        return this.f12871a;
    }

    @Override // stepos.support.v7.widget.c0
    public final void y(boolean z10) {
        this.f12871a.setShowBottomMenu(z10);
    }

    @Override // stepos.support.v7.widget.c0
    public final void z(r2.i iVar) {
        this.f12889t = iVar;
    }

    @Override // stepos.support.v7.widget.c0
    public final void setIcon(Drawable drawable) {
        this.f12874d = drawable;
        H();
    }

    @Override // stepos.support.v7.widget.c0
    public final void j(boolean z10) {
    }

    @Override // stepos.support.v7.widget.c0
    public final void x(boolean z10) {
    }

    @Override // stepos.support.v7.widget.c0
    public final void r() {
    }
}
