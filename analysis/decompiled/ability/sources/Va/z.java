package Va;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.widget.P;

/* loaded from: classes4.dex */
public class z implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, B {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1466a;
    public final LayoutInflater b;
    public final n c;
    public final y d;
    public final boolean e;
    public final int f;
    public final int g;
    public View h;
    public P i;

    /* renamed from: j, reason: collision with root package name */
    public ViewTreeObserver f1467j;
    public A k;
    public boolean l;
    public FrameLayout m;
    public boolean n;
    public int o;
    public int p = 0;

    /* renamed from: q, reason: collision with root package name */
    public final int f1468q = -1;

    /* renamed from: r, reason: collision with root package name */
    public int f1469r = -1;

    public z(Context context, n nVar, View view, boolean z10, int i) {
        this.f1466a = context;
        this.b = LayoutInflater.from(context);
        this.c = nVar;
        this.d = new y(this, nVar);
        this.e = z10;
        this.g = i;
        this.f = context.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_width_max);
        this.h = view;
        nVar.b(this, context);
    }

    @Override // Va.B
    public final boolean a(q qVar) {
        return false;
    }

    @Override // Va.B
    public final void b(Context context, n nVar) {
    }

    @Override // Va.B
    public final boolean c(F f) {
        boolean z10;
        if (f.hasVisibleItems()) {
            z zVar = new z(this.f1466a, f, this.h, false, androidx.appcompat.R.attr.popupMenuStyle);
            zVar.k = this.k;
            int size = f.e.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = f.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i++;
            }
            zVar.l = z10;
            if (zVar.h()) {
                A a3 = this.k;
                if (a3 != null) {
                    a3.n(f);
                }
                return true;
            }
        }
        return false;
    }

    @Override // Va.B
    public final boolean d(q qVar) {
        return false;
    }

    public final void e() {
        if (g()) {
            this.i.dismiss();
        }
    }

    @Override // Va.B
    public final void f(n nVar, boolean z10) {
        if (nVar != this.c) {
            return;
        }
        e();
        A a3 = this.k;
        if (a3 != null) {
            a3.f(nVar, z10);
        }
    }

    @Override // Va.B
    public final boolean flagActionItems() {
        return false;
    }

    public final boolean g() {
        P p = this.i;
        return p != null && p.isShowing();
    }

    public final boolean h() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = this.g;
        Context context = this.f1466a;
        P p = new P(context, null, i, 0);
        try {
            p.f6475a = (PopupWindow) P.b.get(p);
        } catch (Exception unused) {
        }
        this.i = p;
        p.setOnDismissListener(this);
        this.i.setOnItemClickListener(this);
        P p3 = this.i;
        y yVar = this.d;
        p3.setAdapter(yVar);
        this.i.setModal(true);
        if (this.p == 0) {
            P p5 = this.i;
            int i6 = this.f1469r;
            if (i6 == -1) {
                i6 = 0;
            }
            p5.a(i6);
        } else {
            int i10 = this.f1469r;
            if (i10 != -1) {
                this.i.a(i10);
            }
        }
        View view = this.h;
        if (view == null) {
            return false;
        }
        boolean z10 = this.f1467j == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f1467j = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.i.setAnchorView(view);
        this.i.setDropDownGravity(this.p);
        if (!this.n) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = yVar.getCount();
            View view2 = null;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i11 >= count) {
                    break;
                }
                int itemViewType = yVar.getItemViewType(i11);
                if (itemViewType != i13) {
                    view2 = null;
                    i13 = itemViewType;
                }
                if (this.m == null) {
                    this.m = new FrameLayout(context);
                }
                view2 = yVar.getView(i11, view2, this.m);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view2.getMeasuredWidth();
                int i14 = this.f;
                if (measuredWidth >= i14) {
                    i12 = i14;
                    break;
                }
                if (measuredWidth > i12) {
                    i12 = measuredWidth;
                }
                i11++;
            }
            this.o = i12;
            this.n = true;
        }
        this.i.setContentWidth(this.o);
        this.i.setInputMethodMode(2);
        PopupWindow popupWindow = this.i.f6475a;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(false);
        }
        this.i.show();
        this.i.getListView().setOnKeyListener(this);
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.i = null;
        this.c.c(true);
        ViewTreeObserver viewTreeObserver = this.f1467j;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1467j = this.h.getViewTreeObserver();
            }
            this.f1467j.removeGlobalOnLayoutListener(this);
            this.f1467j = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (g()) {
            View view = this.h;
            if (view == null || !view.isShown()) {
                e();
            } else if (g()) {
                this.i.show();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        y yVar = this.d;
        yVar.f1465a.p(yVar.getItem(i), null, 0);
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        e();
        return true;
    }

    @Override // Va.B
    public final void updateMenuView(boolean z10) {
        this.n = false;
        y yVar = this.d;
        if (yVar != null) {
            yVar.notifyDataSetChanged();
        }
    }
}
