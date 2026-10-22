package stepos.support.v7.widget;

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
import android.widget.Spinner;
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.a0;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.U;
import g.C0728a;
import stepos.support.v7.app.a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public class A implements m {

    /* renamed from: a, reason: collision with root package name */
    private Toolbar f21368a;

    /* renamed from: b, reason: collision with root package name */
    private int f21369b;

    /* renamed from: c, reason: collision with root package name */
    private w f21370c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f21371d;

    /* renamed from: e, reason: collision with root package name */
    private View f21372e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f21373f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f21374g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f21375h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f21376i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f21377j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f21378k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f21379l;

    /* renamed from: m, reason: collision with root package name */
    private Window.Callback f21380m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21381n;

    /* renamed from: o, reason: collision with root package name */
    private stepos.support.v7.widget.d f21382o;

    /* renamed from: p, reason: collision with root package name */
    private int f21383p;

    /* renamed from: q, reason: collision with root package name */
    private final C0441k f21384q;

    /* renamed from: r, reason: collision with root package name */
    private int f21385r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f21386s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f21387t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f21388u;

    /* renamed from: v, reason: collision with root package name */
    private i f21389v;

    /* renamed from: w, reason: collision with root package name */
    private j f21390w;

    /* renamed from: x, reason: collision with root package name */
    a.c f21391x;

    /* renamed from: y, reason: collision with root package name */
    private stepos.support.v7.widget.d f21392y;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final c5.b f21393a;

        a() {
            this.f21393a = new c5.b(A.this.f21368a.getContext(), 0, R.id.home, 0, 0, A.this.f21377j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (A.this.f21380m == null || !A.this.f21381n) {
                return;
            }
            A.this.f21380m.onMenuItemSelected(0, this.f21393a);
        }
    }

    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c5.b f21395a;

        b(c5.b bVar) {
            this.f21395a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (A.this.f21380m == null || !A.this.f21381n) {
                return;
            }
            A.this.f21380m.onMenuItemSelected(0, this.f21395a);
        }
    }

    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c5.b f21397a;

        c(c5.b bVar) {
            this.f21397a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (A.this.f21380m == null || !A.this.f21381n) {
                return;
            }
            A.this.f21380m.onMenuItemSelected(0, this.f21397a);
        }
    }

    class d extends U {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21399a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21400b;

        d(int i5) {
            this.f21400b = i5;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void c(View view) {
            this.f21399a = true;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (this.f21399a) {
                return;
            }
            A.this.f21368a.setVisibility(this.f21400b);
            A.this.f21368a.setMenuVisibility(this.f21400b);
            if (this.f21400b == 4) {
                A.this.f21368a.requestLayout();
            }
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            A.this.f21368a.setVisibility(0);
        }
    }

    class e implements a.InterfaceC0240a {

        /* renamed from: a, reason: collision with root package name */
        private String f21402a;

        /* renamed from: c, reason: collision with root package name */
        private Drawable f21404c;

        /* renamed from: e, reason: collision with root package name */
        private j f21406e;

        /* renamed from: b, reason: collision with root package name */
        private int f21403b = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f21405d = 16;

        public e(j jVar) {
            this.f21406e = jVar;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public void a(int i5) {
            this.f21403b = i5;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public void b(String str) {
            if (this.f21402a != str) {
                this.f21402a = str;
                j jVar = this.f21406e;
                if (jVar != null) {
                    jVar.c();
                }
            }
        }

        public boolean c() {
            return (this.f21405d & 16) != 0;
        }

        public boolean d() {
            return (this.f21405d & 8) == 0;
        }

        public void e(j jVar) {
            this.f21406e = jVar;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public Drawable getIcon() {
            return this.f21404c;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public int getId() {
            return this.f21403b;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public String getTitle() {
            return this.f21402a;
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public void setEnabled(boolean z5) {
            if (c() != z5) {
                this.f21405d = (z5 ? 16 : 0) | (this.f21405d & (-17));
                j jVar = this.f21406e;
                if (jVar != null) {
                    jVar.c();
                }
            }
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public void setIcon(Drawable drawable) {
            if (this.f21404c != drawable) {
                this.f21404c = drawable;
                j jVar = this.f21406e;
                if (jVar != null) {
                    jVar.c();
                }
            }
        }

        @Override // stepos.support.v7.app.a.InterfaceC0240a
        public void setVisible(boolean z5) {
            if (d() != z5) {
                this.f21405d = (z5 ? 0 : 8) | (this.f21405d & (-9));
                j jVar = this.f21406e;
                if (jVar != null) {
                    jVar.c();
                }
            }
        }
    }

    public A(Toolbar toolbar, boolean z5) {
        this(toolbar, z5, g.h.f16962a, H1.g.f2182R);
    }

    private int U() {
        return this.f21368a.getNavigationIcon() != null ? 15 : 11;
    }

    private void V() {
        if (this.f21389v == null) {
            j jVar = new j();
            this.f21390w = jVar;
            this.f21389v = jVar.b(getContext());
            this.f21390w.d(this.f21377j);
            int i5 = X4.f.f5973U;
            int i6 = X4.f.f5972T;
            String string = getContext().getString(R.string.ok);
            String string2 = getContext().getString(R.string.cancel);
            e eVar = new e(this.f21390w);
            e eVar2 = new e(this.f21390w);
            this.f21390w.f();
            a.c cVar = this.f21391x;
            if (cVar != null) {
                cVar.a(1, eVar);
                this.f21391x.a(0, eVar2);
            } else {
                eVar.b(string);
                eVar2.b(string2);
            }
            if (eVar.getId() == -1) {
                eVar.a(i5);
            }
            if (eVar2.getId() == -1) {
                eVar2.a(i6);
            }
            c5.b bVar = new c5.b(this.f21368a.getContext(), eVar2);
            c5.b bVar2 = new c5.b(this.f21368a.getContext(), eVar);
            this.f21390w.a(0, eVar2, new b(bVar));
            this.f21390w.a(1, eVar, new c(bVar2));
            this.f21390w.e();
        }
    }

    private void W() {
        if (this.f21371d == null) {
            this.f21371d = new androidx.appcompat.widget.A(getContext(), null, C0728a.f16832i);
            this.f21371d.setLayoutParams(new Toolbar.f(-2, -2, 8388627));
        }
    }

    private void e0(CharSequence charSequence) {
        this.f21377j = charSequence;
        if ((this.f21369b & 8) != 0) {
            this.f21368a.setTitle(charSequence);
        }
        j jVar = this.f21390w;
        if (jVar != null) {
            jVar.d(this.f21377j);
        }
    }

    private void f0() {
        if ((this.f21369b & 4) != 0) {
            if (TextUtils.isEmpty(this.f21379l)) {
                this.f21368a.setNavigationContentDescription(this.f21385r);
            } else {
                this.f21368a.setNavigationContentDescription(this.f21379l);
            }
        }
    }

    private void g0() {
        if ((this.f21369b & 4) != 0) {
            Toolbar toolbar = this.f21368a;
            Drawable drawable = this.f21375h;
            if (drawable == null) {
                drawable = this.f21386s;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    private void h0() {
        Drawable drawable;
        int i5 = this.f21369b;
        if ((i5 & 2) == 0) {
            drawable = null;
        } else if ((i5 & 1) == 0 || (drawable = this.f21374g) == null) {
            drawable = this.f21373f;
        }
        this.f21368a.setLogo(drawable);
    }

    @Override // stepos.support.v7.widget.m
    public int A() {
        return this.f21368a.getVisibility();
    }

    @Override // stepos.support.v7.widget.m
    public void B(boolean z5) {
        if (this.f21387t != z5) {
            this.f21387t = z5;
            this.f21368a.setSplitToolbar(z5);
            stepos.support.v7.widget.d dVar = this.f21382o;
            if (dVar != null) {
                if (z5) {
                    dVar.S(true);
                    this.f21382o.Z(getContext().getResources().getDisplayMetrics().widthPixels - (b5.a.b(getContext()).f() * 2), true);
                    this.f21382o.U(Integer.MAX_VALUE);
                } else {
                    dVar.S(false);
                }
                this.f21382o.T(z5);
            }
        }
    }

    @Override // stepos.support.v7.widget.m
    public void C(ViewGroup viewGroup) {
        this.f21368a.setSplitView(viewGroup);
    }

    @Override // stepos.support.v7.widget.m
    public void D(a.c cVar) {
        this.f21391x = cVar;
    }

    @Override // stepos.support.v7.widget.m
    public void E(Menu menu, h.a aVar) {
        if (this.f21392y == null) {
            stepos.support.v7.widget.d dVar = new stepos.support.v7.widget.d(this.f21368a.getContext());
            this.f21392y = dVar;
            dVar.p(X4.f.f6005n);
            this.f21392y.S(true);
            this.f21392y.Z(getContext().getResources().getDisplayMetrics().widthPixels - (b5.a.b(getContext()).f() * 2), true);
            this.f21392y.U(Integer.MAX_VALUE);
            this.f21392y.T(true);
        }
        this.f21392y.o(aVar);
        this.f21368a.R((stepos.support.v7.view.menu.d) menu, this.f21392y);
    }

    @Override // stepos.support.v7.widget.m
    public void F(int i5) {
        Spinner spinner = this.f21371d;
        if (spinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        spinner.setSelection(i5);
    }

    @Override // stepos.support.v7.widget.m
    public Menu G() {
        return this.f21368a.getMenu();
    }

    @Override // stepos.support.v7.widget.m
    public boolean H() {
        return this.f21368a.getSplitBarCustomView() != null;
    }

    @Override // stepos.support.v7.widget.m
    public boolean I() {
        return true;
    }

    @Override // stepos.support.v7.widget.m
    public void J(int i5) {
        w wVar;
        int i6 = this.f21383p;
        if (i5 != i6) {
            if (i6 == 1) {
                Spinner spinner = this.f21371d;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f21368a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f21371d);
                    }
                }
            } else if (i6 == 2 && (wVar = this.f21370c) != null) {
                ViewParent parent2 = wVar.getParent();
                Toolbar toolbar2 = this.f21368a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f21370c);
                }
            }
            this.f21383p = i5;
            if (i5 != 0) {
                if (i5 == 1) {
                    W();
                    this.f21368a.addView(this.f21371d, 0);
                    return;
                }
                if (i5 != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i5);
                }
                w wVar2 = this.f21370c;
                if (wVar2 != null) {
                    this.f21368a.addView(wVar2, 0);
                    Toolbar.f fVar = (Toolbar.f) this.f21370c.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) fVar).width = -2;
                    ((ViewGroup.MarginLayoutParams) fVar).height = -2;
                    fVar.f20663a = 8388691;
                }
            }
        }
    }

    @Override // stepos.support.v7.widget.m
    public ViewGroup K() {
        return this.f21368a;
    }

    @Override // stepos.support.v7.widget.m
    public void L(boolean z5) {
        this.f21368a.setShowBottomMenu(z5);
    }

    @Override // stepos.support.v7.widget.m
    public w M() {
        return this.f21370c;
    }

    @Override // stepos.support.v7.widget.m
    public int N() {
        Spinner spinner = this.f21371d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.m
    public void O(View view) {
        View view2 = this.f21372e;
        if (view2 != null && (this.f21369b & 16) != 0) {
            this.f21368a.removeView(view2);
        }
        this.f21372e = view;
        if (view == null || (this.f21369b & 16) == 0) {
            return;
        }
        this.f21368a.addView(view);
    }

    @Override // stepos.support.v7.widget.m
    public void P(v vVar) {
        w wVar = this.f21370c;
        if (wVar != null) {
            ViewParent parent = wVar.getParent();
            Toolbar toolbar = this.f21368a;
            if (parent == toolbar) {
                toolbar.removeView(this.f21370c);
            }
        }
        if (this.f21370c == null && vVar != null) {
            this.f21370c = new w(getContext());
        }
        if (vVar == null) {
            w wVar2 = this.f21370c;
            if (wVar2 != null) {
                wVar2.setTabView(null);
                this.f21370c = null;
                return;
            }
            return;
        }
        this.f21370c.setTabView(vVar);
        this.f21370c.f(true);
        if (this.f21383p == 2) {
            this.f21368a.addView(this.f21370c);
            this.f21368a.S(getContext().getResources().getDimensionPixelSize(X4.d.f5905h0), this.f21368a.getContentInsetEnd());
            Toolbar.f fVar = (Toolbar.f) this.f21370c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) fVar).width = -2;
            ((ViewGroup.MarginLayoutParams) fVar).height = -2;
            fVar.f20663a = 8388627;
        }
    }

    public void X(int i5) {
        if (i5 == this.f21385r) {
            return;
        }
        this.f21385r = i5;
        if (TextUtils.isEmpty(this.f21368a.getNavigationContentDescription())) {
            a0(this.f21385r);
        }
    }

    public void Y(Drawable drawable) {
        if (this.f21386s != drawable) {
            this.f21386s = drawable;
            g0();
        }
    }

    public void Z(Drawable drawable) {
        this.f21374g = drawable;
        h0();
    }

    @Override // stepos.support.v7.widget.m
    public boolean a() {
        return this.f21368a.F();
    }

    public void a0(int i5) {
        b0(i5 == 0 ? null : getContext().getString(i5));
    }

    @Override // stepos.support.v7.widget.m
    public void b() {
        this.f21381n = true;
    }

    public void b0(CharSequence charSequence) {
        this.f21379l = charSequence;
        f0();
    }

    @Override // stepos.support.v7.widget.m
    public boolean c() {
        return this.f21368a.i();
    }

    public void c0(Drawable drawable) {
        this.f21375h = drawable;
        g0();
    }

    @Override // stepos.support.v7.widget.m
    public void collapseActionView() {
        this.f21368a.j();
    }

    @Override // stepos.support.v7.widget.m
    public boolean d() {
        return this.f21368a.E();
    }

    public void d0(CharSequence charSequence) {
        this.f21378k = charSequence;
        if ((this.f21369b & 8) != 0) {
            this.f21368a.setSubtitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.m
    public boolean e() {
        return this.f21368a.B();
    }

    @Override // stepos.support.v7.widget.m
    public boolean f() {
        return this.f21368a.a0();
    }

    @Override // stepos.support.v7.widget.m
    public void g(Drawable drawable) {
        this.f21368a.setBackgroundDrawable(drawable);
    }

    @Override // stepos.support.v7.widget.m
    public Context getContext() {
        return this.f21368a.getContext();
    }

    @Override // stepos.support.v7.widget.m
    public CharSequence getTitle() {
        return this.f21368a.getTitle();
    }

    @Override // stepos.support.v7.widget.m
    public void h() {
        this.f21368a.k();
    }

    @Override // stepos.support.v7.widget.m
    public boolean i() {
        return this.f21368a.A();
    }

    @Override // stepos.support.v7.widget.m
    public void j(int i5) {
        w wVar;
        View view;
        int i6 = this.f21369b ^ i5;
        this.f21369b = i5;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i5 & 4) != 0) {
                    g0();
                    f0();
                } else {
                    this.f21368a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i6 & 3) != 0) {
                h0();
            }
            if ((i6 & 8) != 0) {
                if ((i5 & 8) != 0) {
                    this.f21368a.setTitle(this.f21377j);
                    this.f21368a.setSubtitle(this.f21378k);
                    this.f21368a.S(getContext().getResources().getDimensionPixelSize(X4.d.f5903g0), this.f21368a.getContentInsetEnd());
                } else {
                    this.f21368a.setTitle((CharSequence) null);
                    this.f21368a.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) != 0 && (view = this.f21372e) != null) {
                if ((i5 & 16) != 0) {
                    this.f21368a.addView(view);
                } else {
                    this.f21368a.removeView(view);
                }
            }
            if ((i6 & 32) != 0 && (wVar = this.f21370c) != null) {
                if ((i5 & 32) != 0) {
                    if (wVar != null && this.f21383p == 2) {
                        this.f21368a.addView(wVar, 0);
                        Toolbar.f fVar = (Toolbar.f) this.f21370c.getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) fVar).width = -2;
                        ((ViewGroup.MarginLayoutParams) fVar).height = -2;
                        fVar.f20663a = 8388627;
                        this.f21370c.f(true);
                    }
                } else if (wVar != null) {
                    ViewParent parent = wVar.getParent();
                    Toolbar toolbar = this.f21368a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f21370c);
                    }
                }
            }
            if ((i6 & 64) != 0) {
                V();
                if ((i5 & 64) != 0) {
                    this.f21368a.addView(this.f21389v);
                    this.f21368a.S(0, 0);
                } else {
                    this.f21368a.removeView(this.f21389v);
                    this.f21389v = null;
                }
            }
        }
        if ((i5 & 64) == 0) {
            this.f21368a.removeView(this.f21389v);
            this.f21389v = null;
        } else if (this.f21368a.indexOfChild(this.f21389v) < 0) {
            V();
            this.f21368a.addView(this.f21389v);
            this.f21368a.S(0, 0);
        }
    }

    @Override // stepos.support.v7.widget.m
    public void k(int i5) {
        Z(i5 != 0 ? this.f21384q.c(getContext(), i5) : null);
    }

    @Override // stepos.support.v7.widget.m
    public int l() {
        return this.f21383p;
    }

    @Override // stepos.support.v7.widget.m
    public S m(int i5, long j5) {
        Toolbar toolbar = this.f21368a;
        if (toolbar != null) {
            toolbar.V(i5, j5);
        }
        return H.d(this.f21368a).b(i5 == 0 ? 1.0f : 0.0f).h(j5).j(new d(i5));
    }

    @Override // stepos.support.v7.widget.m
    public void n(int i5) {
        this.f21368a.setVisibility(i5);
    }

    @Override // stepos.support.v7.widget.m
    public void o(boolean z5) {
    }

    @Override // stepos.support.v7.widget.m
    public int p() {
        return this.f21369b;
    }

    @Override // stepos.support.v7.widget.m
    public void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.m
    public void r(Menu menu, h.a aVar) {
        if (this.f21382o == null) {
            stepos.support.v7.widget.d dVar = new stepos.support.v7.widget.d(this.f21368a.getContext());
            this.f21382o = dVar;
            dVar.p(g.f.f16925g);
            if (this.f21387t) {
                this.f21382o.S(true);
                this.f21382o.Z(getContext().getResources().getDisplayMetrics().widthPixels - (b5.a.b(getContext()).f() * 2), true);
                this.f21382o.U(Integer.MAX_VALUE);
                this.f21382o.T(true);
            }
        }
        this.f21382o.o(aVar);
        this.f21368a.T((stepos.support.v7.view.menu.d) menu, this.f21382o);
    }

    @Override // stepos.support.v7.widget.m
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // stepos.support.v7.widget.m
    public void setIcon(int i5) {
        setIcon(i5 != 0 ? this.f21384q.c(getContext(), i5) : null);
    }

    @Override // stepos.support.v7.widget.m
    public void setTitle(CharSequence charSequence) {
        this.f21376i = true;
        e0(charSequence);
    }

    @Override // stepos.support.v7.widget.m
    public void setWindowCallback(Window.Callback callback) {
        this.f21380m = callback;
    }

    @Override // stepos.support.v7.widget.m
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f21376i) {
            return;
        }
        e0(charSequence);
    }

    @Override // stepos.support.v7.widget.m
    public void t(boolean z5) {
        this.f21368a.setCollapsible(z5);
    }

    @Override // stepos.support.v7.widget.m
    public void u(boolean z5) {
        this.f21388u = z5;
    }

    @Override // stepos.support.v7.widget.m
    public boolean v() {
        return this.f21387t;
    }

    @Override // stepos.support.v7.widget.m
    public View w() {
        return this.f21372e;
    }

    @Override // stepos.support.v7.widget.m
    public void x(h.a aVar, d.a aVar2) {
        this.f21368a.U(aVar, aVar2);
    }

    @Override // stepos.support.v7.widget.m
    public boolean y() {
        return this.f21368a.G();
    }

    @Override // stepos.support.v7.widget.m
    public void z(ViewGroup viewGroup) {
        this.f21368a.P(viewGroup);
    }

    public A(Toolbar toolbar, boolean z5, int i5, int i6) {
        this.f21383p = 0;
        this.f21385r = 0;
        this.f21368a = toolbar;
        this.f21377j = toolbar.getTitle();
        this.f21378k = toolbar.getSubtitle();
        this.f21376i = this.f21377j != null;
        this.f21375h = toolbar.getNavigationIcon();
        if (z5) {
            a0 a0VarV = a0.v(toolbar.getContext(), null, g.j.f17094a, N1.a.c() ? X4.a.f5832h : C0728a.f16826c, 0);
            CharSequence charSequenceP = a0VarV.p(g.j.f17179r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = a0VarV.p(g.j.f17169p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                d0(charSequenceP2);
            }
            Drawable drawableG = a0VarV.g(g.j.f17159n);
            if (drawableG != null) {
                Z(drawableG);
            }
            Drawable drawableG2 = a0VarV.g(g.j.f17154m);
            if (this.f21375h == null && drawableG2 != null) {
                setIcon(drawableG2);
            }
            Drawable drawableG3 = a0VarV.g(g.j.f17149l);
            if (drawableG3 != null) {
                c0(drawableG3);
            }
            j(a0VarV.k(g.j.f17129h, 0));
            int iN = a0VarV.n(g.j.f17124g, 0);
            if (iN != 0) {
                O(LayoutInflater.from(this.f21368a.getContext()).inflate(iN, (ViewGroup) this.f21368a, false));
                j(this.f21369b | 16);
            }
            int iM = a0VarV.m(g.j.f17139j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f21368a.getLayoutParams();
                layoutParams.height = iM;
                this.f21368a.setLayoutParams(layoutParams);
            }
            int iE = a0VarV.e(g.j.f17119f, -1);
            int iE2 = a0VarV.e(g.j.f17114e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f21368a.S(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = a0VarV.n(g.j.f17184s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f21368a;
                toolbar2.X(toolbar2.getContext(), iN2);
            }
            int iN3 = a0VarV.n(g.j.f17174q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f21368a;
                toolbar3.W(toolbar3.getContext(), iN3);
            }
            int iN4 = a0VarV.n(g.j.f17164o, 0);
            if (iN4 != 0) {
                this.f21368a.setPopupTheme(iN4);
            }
            a0VarV.x();
        } else {
            this.f21369b = U();
        }
        C0441k c0441kB = C0441k.b();
        this.f21384q = c0441kB;
        X(i5);
        this.f21379l = this.f21368a.getNavigationContentDescription();
        Y(c0441kB.c(getContext(), i6));
        this.f21368a.setNavigationOnClickListener(new a());
    }

    @Override // stepos.support.v7.widget.m
    public void setIcon(Drawable drawable) {
        this.f21373f = drawable;
        h0();
    }
}
