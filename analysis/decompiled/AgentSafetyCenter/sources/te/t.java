package te;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.stepos.agentsafetycenter.R;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.widget.j0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class t implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, v {

    /* renamed from: c, reason: collision with root package name */
    public final Context f13397c;

    /* renamed from: f, reason: collision with root package name */
    public final LayoutInflater f13398f;

    /* renamed from: g, reason: collision with root package name */
    public final l f13399g;

    /* renamed from: h, reason: collision with root package name */
    public final s f13400h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final int f13401j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13402k;

    /* renamed from: l, reason: collision with root package name */
    public View f13403l;

    /* renamed from: m, reason: collision with root package name */
    public j0 f13404m;

    /* renamed from: n, reason: collision with root package name */
    public ViewTreeObserver f13405n;

    /* renamed from: o, reason: collision with root package name */
    public u f13406o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13407p;

    /* renamed from: q, reason: collision with root package name */
    public FrameLayout f13408q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13409r;

    /* renamed from: s, reason: collision with root package name */
    public int f13410s;

    /* renamed from: t, reason: collision with root package name */
    public int f13411t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final int f13412u = -1;

    /* renamed from: v, reason: collision with root package name */
    public int f13413v = -1;

    public t(Context context, l lVar, View view, boolean z10, int i) {
        this.f13397c = context;
        this.f13398f = LayoutInflater.from(context);
        this.f13399g = lVar;
        this.f13400h = new s(this, lVar);
        this.i = z10;
        this.f13402k = i;
        this.f13401j = context.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_width_max);
        this.f13403l = view;
        lVar.b(this, context);
    }

    @Override // te.v
    public final boolean a() {
        return false;
    }

    @Override // te.v
    public final void b(l lVar, boolean z10) {
        if (lVar != this.f13399g) {
            return;
        }
        h();
        u uVar = this.f13406o;
        if (uVar != null) {
            uVar.b(lVar, z10);
        }
    }

    @Override // te.v
    public final void c() {
        this.f13409r = false;
        s sVar = this.f13400h;
        if (sVar != null) {
            sVar.notifyDataSetChanged();
        }
    }

    @Override // te.v
    public final boolean d(m mVar) {
        return false;
    }

    @Override // te.v
    public final boolean e(m mVar) {
        return false;
    }

    @Override // te.v
    public final boolean g(z zVar) {
        boolean z10;
        if (zVar.hasVisibleItems()) {
            t tVar = new t(this.f13397c, zVar, this.f13403l, false, R.attr.popupMenuStyle);
            tVar.f13406o = this.f13406o;
            int size = zVar.f13347e.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = zVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i++;
            }
            tVar.f13407p = z10;
            if (tVar.j()) {
                u uVar = this.f13406o;
                if (uVar != null) {
                    uVar.e(zVar);
                }
                return true;
            }
        }
        return false;
    }

    public final void h() {
        if (i()) {
            this.f13404m.dismiss();
        }
    }

    public final boolean i() {
        j0 j0Var = this.f13404m;
        return j0Var != null && j0Var.D.isShowing();
    }

    public final boolean j() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = this.f13402k;
        Context context = this.f13397c;
        j0 j0Var = new j0(context, null, i, 0);
        try {
            j0Var.E = (PopupWindow) j0.F.get(j0Var);
        } catch (Exception unused) {
        }
        this.f13404m = j0Var;
        j0Var.D.setOnDismissListener(this);
        j0 j0Var2 = this.f13404m;
        j0Var2.f8128t = this;
        s sVar = this.f13400h;
        j0Var2.p(sVar);
        j0 j0Var3 = this.f13404m;
        j0Var3.C = true;
        j0Var3.D.setFocusable(true);
        if (this.f13411t == 0) {
            j0 j0Var4 = this.f13404m;
            int i3 = this.f13413v;
            if (i3 == -1) {
                i3 = 0;
            }
            j0Var4.s(i3);
        } else {
            int i10 = this.f13413v;
            if (i10 != -1) {
                this.f13404m.s(i10);
            }
        }
        View view = this.f13403l;
        if (view == null) {
            return false;
        }
        boolean z10 = this.f13405n == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f13405n = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        j0 j0Var5 = this.f13404m;
        j0Var5.f8127s = view;
        j0Var5.f8124p = this.f13411t;
        if (!this.f13409r) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = sVar.getCount();
            View view2 = null;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i11 >= count) {
                    break;
                }
                int itemViewType = sVar.getItemViewType(i11);
                if (itemViewType != i13) {
                    view2 = null;
                    i13 = itemViewType;
                }
                if (this.f13408q == null) {
                    this.f13408q = new FrameLayout(context);
                }
                view2 = sVar.getView(i11, view2, this.f13408q);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view2.getMeasuredWidth();
                int i14 = this.f13401j;
                if (measuredWidth >= i14) {
                    i12 = i14;
                    break;
                }
                if (measuredWidth > i12) {
                    i12 = measuredWidth;
                }
                i11++;
            }
            this.f13410s = i12;
            this.f13409r = true;
        }
        this.f13404m.r(this.f13410s);
        this.f13404m.D.setInputMethodMode(2);
        PopupWindow popupWindow = this.f13404m.E;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(false);
        }
        this.f13404m.f();
        this.f13404m.f8116g.setOnKeyListener(this);
        return true;
    }

    public void onDismiss() {
        this.f13404m = null;
        this.f13399g.c(true);
        ViewTreeObserver viewTreeObserver = this.f13405n;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f13405n = this.f13403l.getViewTreeObserver();
            }
            this.f13405n.removeGlobalOnLayoutListener(this);
            this.f13405n = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (i()) {
            View view = this.f13403l;
            if (view == null || !view.isShown()) {
                h();
            } else if (i()) {
                this.f13404m.f();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        s sVar = this.f13400h;
        sVar.f13394a.p(sVar.getItem(i), null, 0);
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        h();
        return true;
    }

    @Override // te.v
    public final void f(Context context, l lVar) {
    }
}
