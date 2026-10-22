package k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.C0229u0;
import androidx.appcompat.widget.L0;
import com.stepos.alphame.R;

/* renamed from: k.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0645F extends AbstractC0669w implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: b, reason: collision with root package name */
    public final Context f13141b;

    /* renamed from: c, reason: collision with root package name */
    public final C0661o f13142c;

    /* renamed from: d, reason: collision with root package name */
    public final C0658l f13143d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f13144e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13145f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13146g;

    /* renamed from: h, reason: collision with root package name */
    public final int f13147h;

    /* renamed from: i, reason: collision with root package name */
    public final L0 f13148i;

    /* renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f13151l;

    /* renamed from: m, reason: collision with root package name */
    public View f13152m;

    /* renamed from: n, reason: collision with root package name */
    public View f13153n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC0672z f13154o;

    /* renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f13155p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13156q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13157r;

    /* renamed from: s, reason: collision with root package name */
    public int f13158s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13160u;

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0651e f13149j = new ViewTreeObserverOnGlobalLayoutListenerC0651e(1, this);

    /* renamed from: k, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0652f f13150k = new ViewOnAttachStateChangeListenerC0652f(1, this);

    /* renamed from: t, reason: collision with root package name */
    public int f13159t = 0;

    public ViewOnKeyListenerC0645F(int i4, int i5, Context context, View view, C0661o c0661o, boolean z4) {
        this.f13141b = context;
        this.f13142c = c0661o;
        this.f13144e = z4;
        this.f13143d = new C0658l(c0661o, LayoutInflater.from(context), z4, R.layout.abc_popup_menu_item_layout);
        this.f13146g = i4;
        this.f13147h = i5;
        Resources resources = context.getResources();
        this.f13145f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f13152m = view;
        this.f13148i = new L0(context, null, i4, i5);
        c0661o.b(this, context);
    }

    @Override // k.InterfaceC0640A
    public final void a() {
        this.f13157r = false;
        C0658l c0658l = this.f13143d;
        if (c0658l != null) {
            c0658l.notifyDataSetChanged();
        }
    }

    @Override // k.InterfaceC0640A
    public final void b(C0661o c0661o, boolean z4) {
        if (c0661o != this.f13142c) {
            return;
        }
        dismiss();
        InterfaceC0672z interfaceC0672z = this.f13154o;
        if (interfaceC0672z != null) {
            interfaceC0672z.b(c0661o, z4);
        }
    }

    @Override // k.InterfaceC0640A
    public final boolean c() {
        return false;
    }

    @Override // k.InterfaceC0644E
    public final void dismiss() {
        if (e()) {
            this.f13148i.dismiss();
        }
    }

    @Override // k.InterfaceC0644E
    public final boolean e() {
        return !this.f13156q && this.f13148i.f2846z.isShowing();
    }

    @Override // k.InterfaceC0640A
    public final boolean f(SubMenuC0646G subMenuC0646G) {
        if (subMenuC0646G.hasVisibleItems()) {
            View view = this.f13153n;
            C0671y c0671y = new C0671y(this.f13146g, this.f13147h, this.f13141b, view, subMenuC0646G, this.f13144e);
            InterfaceC0672z interfaceC0672z = this.f13154o;
            c0671y.f13315i = interfaceC0672z;
            AbstractC0669w abstractC0669w = c0671y.f13316j;
            if (abstractC0669w != null) {
                abstractC0669w.j(interfaceC0672z);
            }
            boolean zU = AbstractC0669w.u(subMenuC0646G);
            c0671y.f13314h = zU;
            AbstractC0669w abstractC0669w2 = c0671y.f13316j;
            if (abstractC0669w2 != null) {
                abstractC0669w2.o(zU);
            }
            c0671y.f13317k = this.f13151l;
            this.f13151l = null;
            this.f13142c.c(false);
            L0 l02 = this.f13148i;
            int width = l02.f2826f;
            int iO = l02.o();
            if ((Gravity.getAbsoluteGravity(this.f13159t, this.f13152m.getLayoutDirection()) & 7) == 5) {
                width += this.f13152m.getWidth();
            }
            if (!c0671y.b()) {
                if (c0671y.f13312f != null) {
                    c0671y.d(width, iO, true, true);
                }
            }
            InterfaceC0672z interfaceC0672z2 = this.f13154o;
            if (interfaceC0672z2 != null) {
                interfaceC0672z2.f(subMenuC0646G);
            }
            return true;
        }
        return false;
    }

    @Override // k.InterfaceC0644E
    public final void g() {
        View view;
        if (e()) {
            return;
        }
        if (this.f13156q || (view = this.f13152m) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f13153n = view;
        L0 l02 = this.f13148i;
        l02.f2846z.setOnDismissListener(this);
        l02.f2836p = this;
        l02.f2845y = true;
        l02.f2846z.setFocusable(true);
        View view2 = this.f13153n;
        boolean z4 = this.f13155p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f13155p = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f13149j);
        }
        view2.addOnAttachStateChangeListener(this.f13150k);
        l02.f2835o = view2;
        l02.f2832l = this.f13159t;
        boolean z5 = this.f13157r;
        Context context = this.f13141b;
        C0658l c0658l = this.f13143d;
        if (!z5) {
            this.f13158s = AbstractC0669w.m(c0658l, context, this.f13145f);
            this.f13157r = true;
        }
        l02.r(this.f13158s);
        l02.f2846z.setInputMethodMode(2);
        Rect rect = this.f13305a;
        l02.f2844x = rect != null ? new Rect(rect) : null;
        l02.g();
        C0229u0 c0229u0 = l02.f2823c;
        c0229u0.setOnKeyListener(this);
        if (this.f13160u) {
            C0661o c0661o = this.f13142c;
            if (c0661o.f13250m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0229u0, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(c0661o.f13250m);
                }
                frameLayout.setEnabled(false);
                c0229u0.addHeaderView(frameLayout, null, false);
            }
        }
        l02.q(c0658l);
        l02.g();
    }

    @Override // k.InterfaceC0644E
    public final C0229u0 i() {
        return this.f13148i.f2823c;
    }

    @Override // k.InterfaceC0640A
    public final void j(InterfaceC0672z interfaceC0672z) {
        this.f13154o = interfaceC0672z;
    }

    @Override // k.AbstractC0669w
    public final void l(C0661o c0661o) {
    }

    @Override // k.AbstractC0669w
    public final void n(View view) {
        this.f13152m = view;
    }

    @Override // k.AbstractC0669w
    public final void o(boolean z4) {
        this.f13143d.f13233c = z4;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f13156q = true;
        this.f13142c.c(true);
        ViewTreeObserver viewTreeObserver = this.f13155p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f13155p = this.f13153n.getViewTreeObserver();
            }
            this.f13155p.removeGlobalOnLayoutListener(this.f13149j);
            this.f13155p = null;
        }
        this.f13153n.removeOnAttachStateChangeListener(this.f13150k);
        PopupWindow.OnDismissListener onDismissListener = this.f13151l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i4 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // k.AbstractC0669w
    public final void p(int i4) {
        this.f13159t = i4;
    }

    @Override // k.AbstractC0669w
    public final void q(int i4) {
        this.f13148i.f2826f = i4;
    }

    @Override // k.AbstractC0669w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f13151l = onDismissListener;
    }

    @Override // k.AbstractC0669w
    public final void s(boolean z4) {
        this.f13160u = z4;
    }

    @Override // k.AbstractC0669w
    public final void t(int i4) {
        this.f13148i.k(i4);
    }
}
