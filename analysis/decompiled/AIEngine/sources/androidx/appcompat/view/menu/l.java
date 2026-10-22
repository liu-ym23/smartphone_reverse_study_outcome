package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
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
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.m0;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends l.d implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: b, reason: collision with root package name */
    public final Context f533b;

    /* renamed from: c, reason: collision with root package name */
    public final f f534c;

    /* renamed from: d, reason: collision with root package name */
    public final e f535d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f536e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public final int f537j;

    /* renamed from: k, reason: collision with root package name */
    public final m0 f538k;

    /* renamed from: n, reason: collision with root package name */
    public PopupWindow.OnDismissListener f541n;

    /* renamed from: o, reason: collision with root package name */
    public View f542o;

    /* renamed from: p, reason: collision with root package name */
    public View f543p;

    /* renamed from: q, reason: collision with root package name */
    public j.a f544q;
    public ViewTreeObserver r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f545s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f546t;

    /* renamed from: u, reason: collision with root package name */
    public int f547u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f549w;

    /* renamed from: l, reason: collision with root package name */
    public final a f539l = new a();

    /* renamed from: m, reason: collision with root package name */
    public final b f540m = new b();

    /* renamed from: v, reason: collision with root package name */
    public int f548v = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            l lVar = l.this;
            m0 m0Var = lVar.f538k;
            if (!lVar.isShowing() || m0Var.B) {
                return;
            }
            View view = lVar.f543p;
            if (view == null || !view.isShown()) {
                lVar.dismiss();
            } else {
                m0Var.show();
            }
        }
    }

    public l(Context context, f fVar, View view, int i10, boolean z) {
        this.f533b = context;
        this.f534c = fVar;
        this.f536e = z;
        this.f535d = new e(fVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.f537j = i10;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f542o = view;
        this.f538k = new m0(context, null, i10, 0);
        fVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z) {
        if (fVar != this.f534c) {
            return;
        }
        dismiss();
        j.a aVar = this.f544q;
        if (aVar != null) {
            aVar.a(fVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b() {
        this.f546t = false;
        e eVar = this.f535d;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d(j.a aVar) {
        this.f544q = aVar;
    }

    @Override // l.f
    public final void dismiss() {
        if (isShowing()) {
            this.f538k.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(m mVar) {
        boolean z;
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f533b, mVar, this.f543p, this.f536e, this.f537j, 0);
            j.a aVar = this.f544q;
            iVar.h = aVar;
            l.d dVar = iVar.f529i;
            if (dVar != null) {
                dVar.d(aVar);
            }
            int size = mVar.h.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    z = false;
                    break;
                }
                MenuItem item = mVar.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i10++;
            }
            iVar.f528g = z;
            l.d dVar2 = iVar.f529i;
            if (dVar2 != null) {
                dVar2.l(z);
            }
            iVar.f530j = this.f541n;
            this.f541n = null;
            this.f534c.c(false);
            m0 m0Var = this.f538k;
            int width = m0Var.h;
            int verticalOffset = m0Var.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.f548v, this.f542o.getLayoutDirection()) & 7) == 5) {
                width += this.f542o.getWidth();
            }
            if (!iVar.b()) {
                if (iVar.f526e != null) {
                    iVar.d(width, verticalOffset, true, true);
                }
            }
            j.a aVar2 = this.f544q;
            if (aVar2 != null) {
                aVar2.b(mVar);
            }
            return true;
        }
        return false;
    }

    @Override // l.f
    public final g0 getListView() {
        return this.f538k.f864c;
    }

    @Override // l.f
    public final boolean isShowing() {
        return !this.f545s && this.f538k.C.isShowing();
    }

    @Override // l.d
    public final void k(View view) {
        this.f542o = view;
    }

    @Override // l.d
    public final void l(boolean z) {
        this.f535d.f475c = z;
    }

    @Override // l.d
    public final void m(int i10) {
        this.f548v = i10;
    }

    @Override // l.d
    public final void n(int i10) {
        this.f538k.h = i10;
    }

    @Override // l.d
    public final void o(PopupWindow.OnDismissListener onDismissListener) {
        this.f541n = onDismissListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f545s = true;
        this.f534c.c(true);
        ViewTreeObserver viewTreeObserver = this.r;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.r = this.f543p.getViewTreeObserver();
            }
            this.r.removeGlobalOnLayoutListener(this.f539l);
            this.r = null;
        }
        this.f543p.removeOnAttachStateChangeListener(this.f540m);
        PopupWindow.OnDismissListener onDismissListener = this.f541n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.d
    public final void p(boolean z) {
        this.f549w = z;
    }

    @Override // l.d
    public final void q(int i10) {
        this.f538k.setVerticalOffset(i10);
    }

    @Override // l.f
    public final void show() {
        View view;
        if (isShowing()) {
            return;
        }
        if (this.f545s || (view = this.f542o) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f543p = view;
        m0 m0Var = this.f538k;
        m0Var.C.setOnDismissListener(this);
        m0Var.f875s = this;
        m0Var.B = true;
        m0Var.C.setFocusable(true);
        View view2 = this.f543p;
        boolean z = this.r == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.r = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f539l);
        }
        view2.addOnAttachStateChangeListener(this.f540m);
        m0Var.r = view2;
        m0Var.f872o = this.f548v;
        boolean z3 = this.f546t;
        Context context = this.f533b;
        e eVar = this.f535d;
        if (!z3) {
            this.f547u = l.d.j(eVar, context, this.h);
            this.f546t = true;
        }
        m0Var.e(this.f547u);
        m0Var.C.setInputMethodMode(2);
        Rect rect = this.f10179a;
        m0Var.A = rect != null ? new Rect(rect) : null;
        m0Var.show();
        g0 g0Var = m0Var.f864c;
        g0Var.setOnKeyListener(this);
        if (this.f549w) {
            f fVar = this.f534c;
            if (fVar.f489p != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) g0Var, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(fVar.f489p);
                }
                frameLayout.setEnabled(false);
                g0Var.addHeaderView(frameLayout, null, false);
            }
        }
        m0Var.setAdapter(eVar);
        m0Var.show();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            l lVar = l.this;
            ViewTreeObserver viewTreeObserver = lVar.r;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    lVar.r = view.getViewTreeObserver();
                }
                lVar.r.removeGlobalOnLayoutListener(lVar.f539l);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }

    @Override // l.d
    public final void i(f fVar) {
    }
}
