package f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.stepos.stepclaw.R;
import g.i1;
import g.j1;
import g.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends l implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: b, reason: collision with root package name */
    public final Context f2508b;

    /* renamed from: c, reason: collision with root package name */
    public final j f2509c;
    public final h d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2510e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2511f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2512g;

    /* renamed from: h, reason: collision with root package name */
    public final j1 f2513h;

    /* renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2516l;

    /* renamed from: m, reason: collision with root package name */
    public View f2517m;

    /* renamed from: n, reason: collision with root package name */
    public View f2518n;

    /* renamed from: o, reason: collision with root package name */
    public o f2519o;

    /* renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f2520p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2521q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2522r;

    /* renamed from: s, reason: collision with root package name */
    public int f2523s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2525u;

    /* renamed from: j, reason: collision with root package name */
    public final c f2514j = new c(this, 1);

    /* renamed from: k, reason: collision with root package name */
    public final d f2515k = new d(1, this);

    /* renamed from: t, reason: collision with root package name */
    public int f2524t = 0;

    public s(Context context, j jVar, View view, int i8, boolean z) {
        this.f2508b = context;
        this.f2509c = jVar;
        this.f2510e = z;
        this.d = new h(jVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.f2512g = i8;
        Resources resources = context.getResources();
        this.f2511f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2517m = view;
        this.f2513h = new j1(context, i8);
        jVar.b(this, context);
    }

    @Override // f.r
    public final void a() {
        View view;
        if (k()) {
            return;
        }
        if (this.f2521q || (view = this.f2517m) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f2518n = view;
        j1 j1Var = this.f2513h;
        x xVar = j1Var.f2757w;
        x xVar2 = j1Var.f2757w;
        xVar.setOnDismissListener(this);
        j1Var.f2748n = this;
        j1Var.f2756v = true;
        xVar2.setFocusable(true);
        View view2 = this.f2518n;
        boolean z = this.f2520p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f2520p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f2514j);
        }
        view2.addOnAttachStateChangeListener(this.f2515k);
        j1Var.f2747m = view2;
        j1Var.f2745k = this.f2524t;
        boolean z2 = this.f2522r;
        Context context = this.f2508b;
        h hVar = this.d;
        if (!z2) {
            this.f2523s = l.m(hVar, context, this.f2511f);
            this.f2522r = true;
        }
        int i8 = this.f2523s;
        Rect rect = j1Var.f2754t;
        Drawable background = xVar2.getBackground();
        if (background != null) {
            background.getPadding(rect);
            j1Var.d = rect.left + rect.right + i8;
        } else {
            j1Var.d = i8;
        }
        xVar2.setInputMethodMode(2);
        Rect rect2 = this.f2496a;
        j1Var.f2755u = rect2 != null ? new Rect(rect2) : null;
        j1Var.a();
        i1 i1Var = j1Var.f2739c;
        i1Var.setOnKeyListener(this);
        if (this.f2525u) {
            j jVar = this.f2509c;
            if (jVar.f2464l != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) i1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(jVar.f2464l);
                }
                frameLayout.setEnabled(false);
                i1Var.addHeaderView(frameLayout, null, false);
            }
        }
        j1Var.b(hVar);
        j1Var.a();
    }

    @Override // f.p
    public final void b(j jVar, boolean z) {
        if (jVar != this.f2509c) {
            return;
        }
        dismiss();
        o oVar = this.f2519o;
        if (oVar != null) {
            oVar.b(jVar, z);
        }
    }

    @Override // f.p
    public final void d(o oVar) {
        this.f2519o = oVar;
    }

    @Override // f.r
    public final void dismiss() {
        if (k()) {
            this.f2513h.dismiss();
        }
    }

    @Override // f.p
    public final void e() {
        this.f2522r = false;
        h hVar = this.d;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // f.r
    public final ListView g() {
        return this.f2513h.f2739c;
    }

    @Override // f.p
    public final boolean h() {
        return false;
    }

    @Override // f.p
    public final boolean j(t tVar) {
        boolean z;
        if (tVar.hasVisibleItems()) {
            n nVar = new n(this.f2508b, tVar, this.f2518n, this.f2510e, this.f2512g, 0);
            o oVar = this.f2519o;
            nVar.f2504h = oVar;
            l lVar = nVar.f2505i;
            if (lVar != null) {
                lVar.d(oVar);
            }
            int size = tVar.f2458f.size();
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    z = false;
                    break;
                }
                MenuItem item = tVar.getItem(i8);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i8++;
            }
            nVar.f2503g = z;
            l lVar2 = nVar.f2505i;
            if (lVar2 != null) {
                lVar2.o(z);
            }
            nVar.f2506j = this.f2516l;
            this.f2516l = null;
            this.f2509c.c(false);
            j1 j1Var = this.f2513h;
            int width = j1Var.f2740e;
            int i9 = !j1Var.f2742g ? 0 : j1Var.f2741f;
            if ((Gravity.getAbsoluteGravity(this.f2524t, this.f2517m.getLayoutDirection()) & 7) == 5) {
                width += this.f2517m.getWidth();
            }
            if (!nVar.b()) {
                if (nVar.f2501e != null) {
                    nVar.d(width, i9, true, true);
                }
            }
            o oVar2 = this.f2519o;
            if (oVar2 != null) {
                oVar2.g(tVar);
            }
            return true;
        }
        return false;
    }

    @Override // f.r
    public final boolean k() {
        return !this.f2521q && this.f2513h.f2757w.isShowing();
    }

    @Override // f.l
    public final void n(View view) {
        this.f2517m = view;
    }

    @Override // f.l
    public final void o(boolean z) {
        this.d.f2450c = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2521q = true;
        this.f2509c.c(true);
        ViewTreeObserver viewTreeObserver = this.f2520p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2520p = this.f2518n.getViewTreeObserver();
            }
            this.f2520p.removeGlobalOnLayoutListener(this.f2514j);
            this.f2520p = null;
        }
        this.f2518n.removeOnAttachStateChangeListener(this.f2515k);
        PopupWindow.OnDismissListener onDismissListener = this.f2516l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i8, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i8 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // f.l
    public final void p(int i8) {
        this.f2524t = i8;
    }

    @Override // f.l
    public final void q(int i8) {
        this.f2513h.f2740e = i8;
    }

    @Override // f.l
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f2516l = onDismissListener;
    }

    @Override // f.l
    public final void s(boolean z) {
        this.f2525u = z;
    }

    @Override // f.l
    public final void t(int i8) {
        j1 j1Var = this.f2513h;
        j1Var.f2741f = i8;
        j1Var.f2742g = true;
    }

    @Override // f.l
    public final void l(j jVar) {
    }
}
