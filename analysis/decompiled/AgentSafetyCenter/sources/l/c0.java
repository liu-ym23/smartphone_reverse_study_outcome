package l;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import m.b2;
import m.j1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends t implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: f, reason: collision with root package name */
    public Context f7524f;

    /* renamed from: g, reason: collision with root package name */
    public l f7525g;

    /* renamed from: h, reason: collision with root package name */
    public i f7526h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f7527j;

    /* renamed from: k, reason: collision with root package name */
    public int f7528k;

    /* renamed from: l, reason: collision with root package name */
    public b2 f7529l;

    /* renamed from: m, reason: collision with root package name */
    public d f7530m;

    /* renamed from: n, reason: collision with root package name */
    public ab.b f7531n;

    /* renamed from: o, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7532o;

    /* renamed from: p, reason: collision with root package name */
    public View f7533p;

    /* renamed from: q, reason: collision with root package name */
    public View f7534q;

    /* renamed from: r, reason: collision with root package name */
    public w f7535r;

    /* renamed from: s, reason: collision with root package name */
    public ViewTreeObserver f7536s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7537t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7538u;

    /* renamed from: v, reason: collision with root package name */
    public int f7539v;

    /* renamed from: w, reason: collision with root package name */
    public int f7540w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7541x;

    @Override // l.x
    public final boolean a() {
        return false;
    }

    @Override // l.b0
    public final boolean b() {
        return !this.f7537t && this.f7529l.D.isShowing();
    }

    @Override // l.x
    public final void c() {
        this.f7538u = false;
        i iVar = this.f7526h;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final void d(l lVar, boolean z10) {
        if (lVar != this.f7525g) {
            return;
        }
        dismiss();
        w wVar = this.f7535r;
        if (wVar != null) {
            wVar.d(lVar, z10);
        }
    }

    @Override // l.b0
    public final void dismiss() {
        if (b()) {
            this.f7529l.dismiss();
        }
    }

    @Override // l.b0
    public final void f() {
        View view;
        l lVar = this.f7525g;
        Context context = this.f7524f;
        i iVar = this.f7526h;
        b2 b2Var = this.f7529l;
        if (b()) {
            return;
        }
        if (this.f7537t || (view = this.f7533p) == null) {
            od.f.e("StandardMenuPopup cannot be used without an anchor");
            return;
        }
        this.f7534q = view;
        b2Var.D.setOnDismissListener(this);
        b2Var.f8128t = this;
        b2Var.C = true;
        b2Var.D.setFocusable(true);
        View view2 = this.f7534q;
        boolean z10 = this.f7536s == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f7536s = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f7530m);
        }
        view2.addOnAttachStateChangeListener(this.f7531n);
        b2Var.f8127s = view2;
        b2Var.f8124p = this.f7540w;
        if (!this.f7538u) {
            this.f7539v = t.m(iVar, context, this.f7527j);
            this.f7538u = true;
        }
        b2Var.r(this.f7539v);
        b2Var.D.setInputMethodMode(2);
        Rect rect = this.f7644c;
        b2Var.B = rect != null ? new Rect(rect) : null;
        b2Var.f();
        j1 j1Var = b2Var.f8116g;
        j1Var.setOnKeyListener(this);
        if (this.f7541x && lVar.f7594m != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) j1Var, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(lVar.f7594m);
            }
            frameLayout.setEnabled(false);
            j1Var.addHeaderView(frameLayout, null, false);
        }
        b2Var.p(iVar);
        b2Var.f();
    }

    @Override // l.x
    public final void g(w wVar) {
        this.f7535r = wVar;
    }

    @Override // l.b0
    public final j1 h() {
        return this.f7529l.f8116g;
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        boolean z10;
        if (d0Var.hasVisibleItems()) {
            v vVar = new v(this.f7524f, d0Var, this.f7534q, this.i, this.f7528k, 0);
            w wVar = this.f7535r;
            vVar.f7653h = wVar;
            t tVar = vVar.i;
            if (tVar != null) {
                tVar.g(wVar);
            }
            int size = d0Var.f7588f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = d0Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i++;
            }
            vVar.f7652g = z10;
            t tVar2 = vVar.i;
            if (tVar2 != null) {
                tVar2.o(z10);
            }
            vVar.f7654j = this.f7532o;
            this.f7532o = null;
            this.f7525g.c(false);
            b2 b2Var = this.f7529l;
            int width = b2Var.f8118j;
            int iO = b2Var.o();
            if ((Gravity.getAbsoluteGravity(this.f7540w, this.f7533p.getLayoutDirection()) & 7) == 5) {
                width += this.f7533p.getWidth();
            }
            if (!vVar.b()) {
                if (vVar.f7650e != null) {
                    vVar.d(width, iO, true, true);
                }
            }
            w wVar2 = this.f7535r;
            if (wVar2 != null) {
                wVar2.f(d0Var);
            }
            return true;
        }
        return false;
    }

    @Override // l.t
    public final void n(View view) {
        this.f7533p = view;
    }

    @Override // l.t
    public final void o(boolean z10) {
        this.f7526h.f7578c = z10;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f7537t = true;
        this.f7525g.c(true);
        ViewTreeObserver viewTreeObserver = this.f7536s;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f7536s = this.f7534q.getViewTreeObserver();
            }
            this.f7536s.removeGlobalOnLayoutListener(this.f7530m);
            this.f7536s = null;
        }
        this.f7534q.removeOnAttachStateChangeListener(this.f7531n);
        PopupWindow.OnDismissListener onDismissListener = this.f7532o;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.t
    public final void p(int i) {
        this.f7540w = i;
    }

    @Override // l.t
    public final void q(int i) {
        this.f7529l.f8118j = i;
    }

    @Override // l.t
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f7532o = onDismissListener;
    }

    @Override // l.t
    public final void s(boolean z10) {
        this.f7541x = z10;
    }

    @Override // l.t
    public final void t(int i) {
        this.f7529l.k(i);
    }

    @Override // l.t
    public final void l(l lVar) {
    }
}
