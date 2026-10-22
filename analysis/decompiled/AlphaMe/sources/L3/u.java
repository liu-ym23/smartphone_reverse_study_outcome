package L3;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.stepos.alphame.R;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.widget.K;

/* loaded from: classes2.dex */
public class u implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, w {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1341a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f1342b;

    /* renamed from: c, reason: collision with root package name */
    public final k f1343c;

    /* renamed from: d, reason: collision with root package name */
    public final t f1344d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1345e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1346f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1347g;

    /* renamed from: i, reason: collision with root package name */
    public View f1349i;

    /* renamed from: j, reason: collision with root package name */
    public K f1350j;

    /* renamed from: k, reason: collision with root package name */
    public ViewTreeObserver f1351k;

    /* renamed from: l, reason: collision with root package name */
    public v f1352l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1353m;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f1354n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1355o;

    /* renamed from: p, reason: collision with root package name */
    public int f1356p;

    /* renamed from: q, reason: collision with root package name */
    public int f1357q = 0;

    /* renamed from: r, reason: collision with root package name */
    public final int f1358r = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f1359s = -1;

    /* renamed from: h, reason: collision with root package name */
    public final int f1348h = 0;

    public u(Context context, k kVar, View view, boolean z4, int i4) {
        this.f1341a = context;
        this.f1342b = LayoutInflater.from(context);
        this.f1343c = kVar;
        this.f1344d = new t(this, kVar);
        this.f1345e = z4;
        this.f1347g = i4;
        this.f1346f = context.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_width_max);
        this.f1349i = view;
        kVar.b(this, context);
    }

    @Override // L3.w
    public final void a() {
        this.f1355o = false;
        t tVar = this.f1344d;
        if (tVar != null) {
            tVar.notifyDataSetChanged();
        }
    }

    public final void b() {
        if (i()) {
            this.f1350j.dismiss();
        }
    }

    @Override // L3.w
    public final boolean c() {
        return false;
    }

    @Override // L3.w
    public final void d(k kVar, boolean z4) {
        if (kVar != this.f1343c) {
            return;
        }
        b();
        v vVar = this.f1352l;
        if (vVar != null) {
            vVar.d(kVar, z4);
        }
    }

    @Override // L3.w
    public final boolean e(A a4) {
        boolean z4;
        if (a4.hasVisibleItems()) {
            u uVar = new u(this.f1341a, a4, this.f1349i, false, R.attr.popupMenuStyle);
            uVar.f1352l = this.f1352l;
            int size = a4.f1285e.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    z4 = false;
                    break;
                }
                MenuItem item = a4.getItem(i4);
                if (item.isVisible() && item.getIcon() != null) {
                    z4 = true;
                    break;
                }
                i4++;
            }
            uVar.f1353m = z4;
            if (uVar.j()) {
                v vVar = this.f1352l;
                if (vVar != null) {
                    vVar.g(a4);
                }
                return true;
            }
        }
        return false;
    }

    @Override // L3.w
    public final boolean f(l lVar) {
        return false;
    }

    @Override // L3.w
    public final void g(Context context, k kVar) {
    }

    @Override // L3.w
    public final boolean h(l lVar) {
        return false;
    }

    public final boolean i() {
        K k4 = this.f1350j;
        return k4 != null && k4.f2846z.isShowing();
    }

    public final boolean j() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i4 = this.f1347g;
        int i5 = this.f1348h;
        Context context = this.f1341a;
        K k4 = new K(context, null, i4, i5);
        try {
            k4.f14833A = (PopupWindow) K.f14831B.get(k4);
        } catch (Exception unused) {
        }
        this.f1350j = k4;
        k4.f2846z.setOnDismissListener(this);
        K k5 = this.f1350j;
        k5.f2836p = this;
        t tVar = this.f1344d;
        k5.q(tVar);
        K k6 = this.f1350j;
        k6.f2845y = true;
        k6.f2846z.setFocusable(true);
        if (this.f1357q == 0) {
            K k7 = this.f1350j;
            int i6 = this.f1359s;
            if (i6 == -1) {
                i6 = 0;
            }
            k7.s(i6);
        } else {
            int i7 = this.f1359s;
            if (i7 != -1) {
                this.f1350j.s(i7);
            }
        }
        View view = this.f1349i;
        if (view == null) {
            return false;
        }
        boolean z4 = this.f1351k == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f1351k = viewTreeObserver;
        if (z4) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        K k8 = this.f1350j;
        k8.f2835o = view;
        k8.f2832l = this.f1357q;
        if (!this.f1355o) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = tVar.getCount();
            View view2 = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i8 >= count) {
                    break;
                }
                int itemViewType = tVar.getItemViewType(i8);
                if (itemViewType != i10) {
                    view2 = null;
                    i10 = itemViewType;
                }
                if (this.f1354n == null) {
                    this.f1354n = new FrameLayout(context);
                }
                view2 = tVar.getView(i8, view2, this.f1354n);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view2.getMeasuredWidth();
                int i11 = this.f1346f;
                if (measuredWidth >= i11) {
                    i9 = i11;
                    break;
                }
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                i8++;
            }
            this.f1356p = i9;
            this.f1355o = true;
        }
        this.f1350j.r(this.f1356p);
        this.f1350j.f2846z.setInputMethodMode(2);
        PopupWindow popupWindow = this.f1350j.f14833A;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(false);
        }
        this.f1350j.g();
        this.f1350j.f2823c.setOnKeyListener(this);
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1350j = null;
        this.f1343c.c(true);
        ViewTreeObserver viewTreeObserver = this.f1351k;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1351k = this.f1349i.getViewTreeObserver();
            }
            this.f1351k.removeGlobalOnLayoutListener(this);
            this.f1351k = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (i()) {
            View view = this.f1349i;
            if (view == null || !view.isShown()) {
                b();
            } else if (i()) {
                this.f1350j.g();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        t tVar = this.f1344d;
        tVar.f1338a.p(tVar.getItem(i4), null, 0);
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i4 != 82) {
            return false;
        }
        b();
        return true;
    }
}
