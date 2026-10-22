package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
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
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.H;
import j.AbstractC4739d;

/* loaded from: classes.dex */
public final class k extends AbstractC4739d implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, i, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    public static final int f8691v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8692b;

    /* renamed from: c, reason: collision with root package name */
    public final e f8693c;

    /* renamed from: d, reason: collision with root package name */
    public final d f8694d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8695e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8696f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8697g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8698h;

    /* renamed from: i, reason: collision with root package name */
    public final H f8699i;

    /* renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8702l;

    /* renamed from: m, reason: collision with root package name */
    public View f8703m;

    /* renamed from: n, reason: collision with root package name */
    public View f8704n;

    /* renamed from: o, reason: collision with root package name */
    public i.a f8705o;

    /* renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f8706p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8707q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8708r;

    /* renamed from: s, reason: collision with root package name */
    public int f8709s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8711u;

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f8700j = new a();

    /* renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f8701k = new b();

    /* renamed from: t, reason: collision with root package name */
    public int f8710t = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!k.this.isShowing() || k.this.f8699i.z()) {
                return;
            }
            View view = k.this.f8704n;
            if (view == null || !view.isShown()) {
                k.this.dismiss();
            } else {
                k.this.f8699i.show();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = k.this.f8706p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    k.this.f8706p = view.getViewTreeObserver();
                }
                k kVar = k.this;
                kVar.f8706p.removeGlobalOnLayoutListener(kVar.f8700j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public k(Context context, e eVar, View view, int i10, int i11, boolean z10) {
        this.f8692b = context;
        this.f8693c = eVar;
        this.f8695e = z10;
        this.f8694d = new d(eVar, LayoutInflater.from(context), z10, f8691v);
        this.f8697g = i10;
        this.f8698h = i11;
        Resources resources = context.getResources();
        this.f8696f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f8703m = view;
        this.f8699i = new H(context, null, i10, i11);
        eVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.f8707q || (view = this.f8703m) == null) {
            return false;
        }
        this.f8704n = view;
        this.f8699i.I(this);
        this.f8699i.J(this);
        this.f8699i.H(true);
        View view2 = this.f8704n;
        boolean z10 = this.f8706p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f8706p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f8700j);
        }
        view2.addOnAttachStateChangeListener(this.f8701k);
        this.f8699i.B(view2);
        this.f8699i.E(this.f8710t);
        if (!this.f8708r) {
            this.f8709s = AbstractC4739d.o(this.f8694d, null, this.f8692b, this.f8696f);
            this.f8708r = true;
        }
        this.f8699i.D(this.f8709s);
        this.f8699i.G(2);
        this.f8699i.F(m());
        this.f8699i.show();
        ListView listViewN = this.f8699i.n();
        listViewN.setOnKeyListener(this);
        if (this.f8711u && this.f8693c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f8692b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewN, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f8693c.z());
            }
            frameLayout.setEnabled(false);
            listViewN.addHeaderView(frameLayout, null, false);
        }
        this.f8699i.l(this.f8694d);
        this.f8699i.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(e eVar, boolean z10) {
        if (eVar != this.f8693c) {
            return;
        }
        dismiss();
        i.a aVar = this.f8705o;
        if (aVar != null) {
            aVar.a(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        this.f8708r = false;
        d dVar = this.f8694d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    @Override // j.InterfaceC4741f
    public void dismiss() {
        if (isShowing()) {
            this.f8699i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(i.a aVar) {
        this.f8705o = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void f(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean g(l lVar) {
        if (lVar.hasVisibleItems()) {
            h hVar = new h(this.f8692b, lVar, this.f8704n, this.f8695e, this.f8697g, this.f8698h);
            hVar.j(this.f8705o);
            hVar.g(AbstractC4739d.x(lVar));
            hVar.i(this.f8702l);
            this.f8702l = null;
            this.f8693c.e(false);
            int iA = this.f8699i.a();
            int iK = this.f8699i.k();
            if ((Gravity.getAbsoluteGravity(this.f8710t, this.f8703m.getLayoutDirection()) & 7) == 5) {
                iA += this.f8703m.getWidth();
            }
            if (hVar.n(iA, iK)) {
                i.a aVar = this.f8705o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(lVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable h() {
        return null;
    }

    @Override // j.InterfaceC4741f
    public boolean isShowing() {
        return !this.f8707q && this.f8699i.isShowing();
    }

    @Override // j.AbstractC4739d
    public void k(e eVar) {
    }

    @Override // j.InterfaceC4741f
    public ListView n() {
        return this.f8699i.n();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f8707q = true;
        this.f8693c.close();
        ViewTreeObserver viewTreeObserver = this.f8706p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f8706p = this.f8704n.getViewTreeObserver();
            }
            this.f8706p.removeGlobalOnLayoutListener(this.f8700j);
            this.f8706p = null;
        }
        this.f8704n.removeOnAttachStateChangeListener(this.f8701k);
        PopupWindow.OnDismissListener onDismissListener = this.f8702l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // j.AbstractC4739d
    public void p(View view) {
        this.f8703m = view;
    }

    @Override // j.AbstractC4739d
    public void r(boolean z10) {
        this.f8694d.d(z10);
    }

    @Override // j.AbstractC4739d
    public void s(int i10) {
        this.f8710t = i10;
    }

    @Override // j.InterfaceC4741f
    public void show() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // j.AbstractC4739d
    public void t(int i10) {
        this.f8699i.d(i10);
    }

    @Override // j.AbstractC4739d
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f8702l = onDismissListener;
    }

    @Override // j.AbstractC4739d
    public void v(boolean z10) {
        this.f8711u = z10;
    }

    @Override // j.AbstractC4739d
    public void w(int i10) {
        this.f8699i.h(i10);
    }
}
