package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.O;

/* loaded from: classes.dex */
final class l extends h implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, j, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f7952v = g.g.f16957m;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7953b;

    /* renamed from: c, reason: collision with root package name */
    private final e f7954c;

    /* renamed from: d, reason: collision with root package name */
    private final d f7955d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7956e;

    /* renamed from: f, reason: collision with root package name */
    private final int f7957f;

    /* renamed from: g, reason: collision with root package name */
    private final int f7958g;

    /* renamed from: h, reason: collision with root package name */
    private final int f7959h;

    /* renamed from: i, reason: collision with root package name */
    final O f7960i;

    /* renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f7963l;

    /* renamed from: m, reason: collision with root package name */
    private View f7964m;

    /* renamed from: n, reason: collision with root package name */
    View f7965n;

    /* renamed from: o, reason: collision with root package name */
    private j.a f7966o;

    /* renamed from: p, reason: collision with root package name */
    ViewTreeObserver f7967p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7968q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7969r;

    /* renamed from: s, reason: collision with root package name */
    private int f7970s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7972u;

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f7961j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f7962k = new b();

    /* renamed from: t, reason: collision with root package name */
    private int f7971t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.h() || l.this.f7960i.B()) {
                return;
            }
            View view = l.this.f7965n;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f7960i.a();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f7967p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f7967p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f7967p.removeGlobalOnLayoutListener(lVar.f7961j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i5, int i6, boolean z5) {
        this.f7953b = context;
        this.f7954c = eVar;
        this.f7956e = z5;
        this.f7955d = new d(eVar, LayoutInflater.from(context), z5, f7952v);
        this.f7958g = i5;
        this.f7959h = i6;
        Resources resources = context.getResources();
        this.f7957f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.f16862d));
        this.f7964m = view;
        this.f7960i = new O(context, null, i5, i6);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (h()) {
            return true;
        }
        if (this.f7968q || (view = this.f7964m) == null) {
            return false;
        }
        this.f7965n = view;
        this.f7960i.K(this);
        this.f7960i.L(this);
        this.f7960i.J(true);
        View view2 = this.f7965n;
        boolean z5 = this.f7967p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f7967p = viewTreeObserver;
        if (z5) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f7961j);
        }
        view2.addOnAttachStateChangeListener(this.f7962k);
        this.f7960i.D(view2);
        this.f7960i.G(this.f7971t);
        if (!this.f7969r) {
            this.f7970s = h.o(this.f7955d, null, this.f7953b, this.f7957f);
            this.f7969r = true;
        }
        this.f7960i.F(this.f7970s);
        this.f7960i.I(2);
        this.f7960i.H(n());
        this.f7960i.a();
        ListView listViewM = this.f7960i.m();
        listViewM.setOnKeyListener(this);
        if (this.f7972u && this.f7954c.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f7953b).inflate(g.g.f16956l, (ViewGroup) listViewM, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f7954c.x());
            }
            frameLayout.setEnabled(false);
            listViewM.addHeaderView(frameLayout, null, false);
        }
        this.f7960i.s(this.f7955d);
        this.f7960i.a();
        return true;
    }

    @Override // l.InterfaceC0820e
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(boolean z5) {
        this.f7969r = false;
        d dVar = this.f7955d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(e eVar, boolean z5) {
        if (eVar != this.f7954c) {
            return;
        }
        dismiss();
        j.a aVar = this.f7966o;
        if (aVar != null) {
            aVar.d(eVar, z5);
        }
    }

    @Override // l.InterfaceC0820e
    public void dismiss() {
        if (h()) {
            this.f7960i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f7966o = aVar;
    }

    @Override // l.InterfaceC0820e
    public boolean h() {
        return !this.f7968q && this.f7960i.h();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f7953b, mVar, this.f7965n, this.f7956e, this.f7958g, this.f7959h);
            iVar.j(this.f7966o);
            iVar.g(h.x(mVar));
            iVar.i(this.f7963l);
            this.f7963l = null;
            this.f7954c.e(false);
            int i5 = this.f7960i.i();
            int iR = this.f7960i.r();
            if ((Gravity.getAbsoluteGravity(this.f7971t, this.f7964m.getLayoutDirection()) & 7) == 5) {
                i5 += this.f7964m.getWidth();
            }
            if (iVar.n(i5, iR)) {
                j.a aVar = this.f7966o;
                if (aVar == null) {
                    return true;
                }
                aVar.e(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.h
    public void k(e eVar) {
    }

    @Override // l.InterfaceC0820e
    public ListView m() {
        return this.f7960i.m();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f7968q = true;
        this.f7954c.close();
        ViewTreeObserver viewTreeObserver = this.f7967p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f7967p = this.f7965n.getViewTreeObserver();
            }
            this.f7967p.removeGlobalOnLayoutListener(this.f7961j);
            this.f7967p = null;
        }
        this.f7965n.removeOnAttachStateChangeListener(this.f7962k);
        PopupWindow.OnDismissListener onDismissListener = this.f7963l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i5 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        this.f7964m = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z5) {
        this.f7955d.d(z5);
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i5) {
        this.f7971t = i5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i5) {
        this.f7960i.j(i5);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f7963l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z5) {
        this.f7972u = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i5) {
        this.f7960i.o(i5);
    }
}
