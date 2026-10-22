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
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import g.C0728a;
import h.C0744a;
import l.C0816a;

/* loaded from: classes.dex */
public class e0 implements H {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f8524a;

    /* renamed from: b, reason: collision with root package name */
    private int f8525b;

    /* renamed from: c, reason: collision with root package name */
    private View f8526c;

    /* renamed from: d, reason: collision with root package name */
    private View f8527d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f8528e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f8529f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f8530g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8531h;

    /* renamed from: i, reason: collision with root package name */
    CharSequence f8532i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f8533j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f8534k;

    /* renamed from: l, reason: collision with root package name */
    Window.Callback f8535l;

    /* renamed from: m, reason: collision with root package name */
    boolean f8536m;

    /* renamed from: n, reason: collision with root package name */
    private C0433c f8537n;

    /* renamed from: o, reason: collision with root package name */
    private int f8538o;

    /* renamed from: p, reason: collision with root package name */
    private int f8539p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f8540q;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final C0816a f8541a;

        a() {
            this.f8541a = new C0816a(e0.this.f8524a.getContext(), 0, R.id.home, 0, 0, e0.this.f8532i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e0 e0Var = e0.this;
            Window.Callback callback = e0Var.f8535l;
            if (callback == null || !e0Var.f8536m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f8541a);
        }
    }

    class b extends androidx.core.view.U {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8543a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8544b;

        b(int i5) {
            this.f8544b = i5;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void c(View view) {
            this.f8543a = true;
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            if (this.f8543a) {
                return;
            }
            e0.this.f8524a.setVisibility(this.f8544b);
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            e0.this.f8524a.setVisibility(0);
        }
    }

    public e0(Toolbar toolbar, boolean z5) {
        this(toolbar, z5, g.h.f16962a, g.e.f16900n);
    }

    private void D(CharSequence charSequence) {
        this.f8532i = charSequence;
        if ((this.f8525b & 8) != 0) {
            this.f8524a.setTitle(charSequence);
            if (this.f8531h) {
                androidx.core.view.H.m0(this.f8524a.getRootView(), charSequence);
            }
        }
    }

    private void E() {
        if ((this.f8525b & 4) != 0) {
            if (TextUtils.isEmpty(this.f8534k)) {
                this.f8524a.setNavigationContentDescription(this.f8539p);
            } else {
                this.f8524a.setNavigationContentDescription(this.f8534k);
            }
        }
    }

    private void F() {
        if ((this.f8525b & 4) == 0) {
            this.f8524a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f8524a;
        Drawable drawable = this.f8530g;
        if (drawable == null) {
            drawable = this.f8540q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void G() {
        Drawable drawable;
        int i5 = this.f8525b;
        if ((i5 & 2) == 0) {
            drawable = null;
        } else if ((i5 & 1) == 0 || (drawable = this.f8529f) == null) {
            drawable = this.f8528e;
        }
        this.f8524a.setLogo(drawable);
    }

    private int r() {
        if (this.f8524a.getNavigationIcon() == null) {
            return 11;
        }
        this.f8540q = this.f8524a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f8530g = drawable;
        F();
    }

    public void B(CharSequence charSequence) {
        this.f8533j = charSequence;
        if ((this.f8525b & 8) != 0) {
            this.f8524a.setSubtitle(charSequence);
        }
    }

    public void C(CharSequence charSequence) {
        this.f8531h = true;
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.H
    public boolean a() {
        return this.f8524a.B();
    }

    @Override // androidx.appcompat.widget.H
    public void b() {
        this.f8536m = true;
    }

    @Override // androidx.appcompat.widget.H
    public boolean c() {
        return this.f8524a.d();
    }

    @Override // androidx.appcompat.widget.H
    public void collapseActionView() {
        this.f8524a.e();
    }

    @Override // androidx.appcompat.widget.H
    public boolean d() {
        return this.f8524a.A();
    }

    @Override // androidx.appcompat.widget.H
    public boolean e() {
        return this.f8524a.w();
    }

    @Override // androidx.appcompat.widget.H
    public boolean f() {
        return this.f8524a.P();
    }

    @Override // androidx.appcompat.widget.H
    public void g(Menu menu, j.a aVar) {
        if (this.f8537n == null) {
            C0433c c0433c = new C0433c(this.f8524a.getContext());
            this.f8537n = c0433c;
            c0433c.p(g.f.f16925g);
        }
        this.f8537n.g(aVar);
        this.f8524a.K((androidx.appcompat.view.menu.e) menu, this.f8537n);
    }

    @Override // androidx.appcompat.widget.H
    public Context getContext() {
        return this.f8524a.getContext();
    }

    @Override // androidx.appcompat.widget.H
    public CharSequence getTitle() {
        return this.f8524a.getTitle();
    }

    @Override // androidx.appcompat.widget.H
    public void h() {
        this.f8524a.f();
    }

    @Override // androidx.appcompat.widget.H
    public boolean i() {
        return this.f8524a.v();
    }

    @Override // androidx.appcompat.widget.H
    public void j(int i5) {
        View view;
        int i6 = this.f8525b ^ i5;
        this.f8525b = i5;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i5 & 4) != 0) {
                    E();
                }
                F();
            }
            if ((i6 & 3) != 0) {
                G();
            }
            if ((i6 & 8) != 0) {
                if ((i5 & 8) != 0) {
                    this.f8524a.setTitle(this.f8532i);
                    this.f8524a.setSubtitle(this.f8533j);
                } else {
                    this.f8524a.setTitle((CharSequence) null);
                    this.f8524a.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) == 0 || (view = this.f8527d) == null) {
                return;
            }
            if ((i5 & 16) != 0) {
                this.f8524a.addView(view);
            } else {
                this.f8524a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.H
    public void k(int i5) {
        x(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    @Override // androidx.appcompat.widget.H
    public int l() {
        return this.f8538o;
    }

    @Override // androidx.appcompat.widget.H
    public androidx.core.view.S m(int i5, long j5) {
        return androidx.core.view.H.d(this.f8524a).b(i5 == 0 ? 1.0f : 0.0f).h(j5).j(new b(i5));
    }

    @Override // androidx.appcompat.widget.H
    public void n(int i5) {
        this.f8524a.setVisibility(i5);
    }

    @Override // androidx.appcompat.widget.H
    public void o(boolean z5) {
    }

    @Override // androidx.appcompat.widget.H
    public int p() {
        return this.f8525b;
    }

    @Override // androidx.appcompat.widget.H
    public void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.H
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.H
    public void setIcon(int i5) {
        setIcon(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    @Override // androidx.appcompat.widget.H
    public void setWindowCallback(Window.Callback callback) {
        this.f8535l = callback;
    }

    @Override // androidx.appcompat.widget.H
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f8531h) {
            return;
        }
        D(charSequence);
    }

    @Override // androidx.appcompat.widget.H
    public void t(boolean z5) {
        this.f8524a.setCollapsible(z5);
    }

    @Override // androidx.appcompat.widget.H
    public void u(T t5) {
        View view = this.f8526c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f8524a;
            if (parent == toolbar) {
                toolbar.removeView(this.f8526c);
            }
        }
        this.f8526c = t5;
        if (t5 == null || this.f8538o != 2) {
            return;
        }
        this.f8524a.addView(t5, 0);
        Toolbar.g gVar = (Toolbar.g) this.f8526c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) gVar).width = -2;
        ((ViewGroup.MarginLayoutParams) gVar).height = -2;
        gVar.f7517a = 8388691;
        t5.setAllowCollapse(true);
    }

    public void v(View view) {
        View view2 = this.f8527d;
        if (view2 != null && (this.f8525b & 16) != 0) {
            this.f8524a.removeView(view2);
        }
        this.f8527d = view;
        if (view == null || (this.f8525b & 16) == 0) {
            return;
        }
        this.f8524a.addView(view);
    }

    public void w(int i5) {
        if (i5 == this.f8539p) {
            return;
        }
        this.f8539p = i5;
        if (TextUtils.isEmpty(this.f8524a.getNavigationContentDescription())) {
            y(this.f8539p);
        }
    }

    public void x(Drawable drawable) {
        this.f8529f = drawable;
        G();
    }

    public void y(int i5) {
        z(i5 == 0 ? null : getContext().getString(i5));
    }

    public void z(CharSequence charSequence) {
        this.f8534k = charSequence;
        E();
    }

    public e0(Toolbar toolbar, boolean z5, int i5, int i6) {
        Drawable drawable;
        this.f8538o = 0;
        this.f8539p = 0;
        this.f8524a = toolbar;
        this.f8532i = toolbar.getTitle();
        this.f8533j = toolbar.getSubtitle();
        this.f8531h = this.f8532i != null;
        this.f8530g = toolbar.getNavigationIcon();
        a0 a0VarV = a0.v(toolbar.getContext(), null, g.j.f17094a, C0728a.f16826c, 0);
        this.f8540q = a0VarV.g(g.j.f17149l);
        if (z5) {
            CharSequence charSequenceP = a0VarV.p(g.j.f17179r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                C(charSequenceP);
            }
            CharSequence charSequenceP2 = a0VarV.p(g.j.f17169p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                B(charSequenceP2);
            }
            Drawable drawableG = a0VarV.g(g.j.f17159n);
            if (drawableG != null) {
                x(drawableG);
            }
            Drawable drawableG2 = a0VarV.g(g.j.f17154m);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f8530g == null && (drawable = this.f8540q) != null) {
                A(drawable);
            }
            j(a0VarV.k(g.j.f17129h, 0));
            int iN = a0VarV.n(g.j.f17124g, 0);
            if (iN != 0) {
                v(LayoutInflater.from(this.f8524a.getContext()).inflate(iN, (ViewGroup) this.f8524a, false));
                j(this.f8525b | 16);
            }
            int iM = a0VarV.m(g.j.f17139j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.f8524a.getLayoutParams();
                layoutParams.height = iM;
                this.f8524a.setLayoutParams(layoutParams);
            }
            int iE = a0VarV.e(g.j.f17119f, -1);
            int iE2 = a0VarV.e(g.j.f17114e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f8524a.J(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = a0VarV.n(g.j.f17184s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.f8524a;
                toolbar2.M(toolbar2.getContext(), iN2);
            }
            int iN3 = a0VarV.n(g.j.f17174q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.f8524a;
                toolbar3.L(toolbar3.getContext(), iN3);
            }
            int iN4 = a0VarV.n(g.j.f17164o, 0);
            if (iN4 != 0) {
                this.f8524a.setPopupTheme(iN4);
            }
        } else {
            this.f8525b = r();
        }
        a0VarV.x();
        w(i5);
        this.f8534k = this.f8524a.getNavigationContentDescription();
        this.f8524a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.H
    public void setIcon(Drawable drawable) {
        this.f8528e = drawable;
        G();
    }
}
