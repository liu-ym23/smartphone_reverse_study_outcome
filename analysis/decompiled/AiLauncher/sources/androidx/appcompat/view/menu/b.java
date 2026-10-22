package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.G;
import androidx.appcompat.widget.H;
import androidx.core.view.C1321i;
import j.AbstractC4739d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends AbstractC4739d implements i, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B, reason: collision with root package name */
    public static final int f8560B = R$layout.abc_cascading_menu_item_layout;

    /* renamed from: A, reason: collision with root package name */
    public boolean f8561A;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8562b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8563c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8564d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8565e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8566f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f8567g;

    /* renamed from: o, reason: collision with root package name */
    public View f8575o;

    /* renamed from: p, reason: collision with root package name */
    public View f8576p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8578r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8579s;

    /* renamed from: t, reason: collision with root package name */
    public int f8580t;

    /* renamed from: u, reason: collision with root package name */
    public int f8581u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8583w;

    /* renamed from: x, reason: collision with root package name */
    public i.a f8584x;

    /* renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f8585y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8586z;

    /* renamed from: h, reason: collision with root package name */
    public final List<e> f8568h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List<d> f8569i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f8570j = new a();

    /* renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f8571k = new ViewOnAttachStateChangeListenerC0128b();

    /* renamed from: l, reason: collision with root package name */
    public final G f8572l = new c();

    /* renamed from: m, reason: collision with root package name */
    public int f8573m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f8574n = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8582v = false;

    /* renamed from: q, reason: collision with root package name */
    public int f8577q = D();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.isShowing() || b.this.f8569i.size() <= 0 || b.this.f8569i.get(0).f8594a.z()) {
                return;
            }
            View view = b.this.f8576p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator<d> it = b.this.f8569i.iterator();
            while (it.hasNext()) {
                it.next().f8594a.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0128b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0128b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f8585y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f8585y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f8585y.removeGlobalOnLayoutListener(bVar.f8570j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements G {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f8590a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f8591b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f8592c;

            public a(d dVar, MenuItem menuItem, e eVar) {
                this.f8590a = dVar;
                this.f8591b = menuItem;
                this.f8592c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f8590a;
                if (dVar != null) {
                    b.this.f8561A = true;
                    dVar.f8595b.e(false);
                    b.this.f8561A = false;
                }
                if (this.f8591b.isEnabled() && this.f8591b.hasSubMenu()) {
                    this.f8592c.O(this.f8591b, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.G
        public void c(e eVar, MenuItem menuItem) {
            b.this.f8567g.removeCallbacksAndMessages(null);
            int size = b.this.f8569i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (eVar == b.this.f8569i.get(i10).f8595b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            b.this.f8567g.postAtTime(new a(i11 < b.this.f8569i.size() ? b.this.f8569i.get(i11) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.G
        public void m(e eVar, MenuItem menuItem) {
            b.this.f8567g.removeCallbacksAndMessages(eVar);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final H f8594a;

        /* renamed from: b, reason: collision with root package name */
        public final e f8595b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8596c;

        public d(H h10, e eVar, int i10) {
            this.f8594a = h10;
            this.f8595b = eVar;
            this.f8596c = i10;
        }

        public ListView a() {
            return this.f8594a.n();
        }
    }

    public b(Context context, View view, int i10, int i11, boolean z10) {
        this.f8562b = context;
        this.f8575o = view;
        this.f8564d = i10;
        this.f8565e = i11;
        this.f8566f = z10;
        Resources resources = context.getResources();
        this.f8563c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f8567g = new Handler();
    }

    public final int A(e eVar) {
        int size = this.f8569i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (eVar == this.f8569i.get(i10).f8595b) {
                return i10;
            }
        }
        return -1;
    }

    public final MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f8595b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i10 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i10 >= count) {
                i10 = -1;
                break;
            }
            if (menuItemB == dVar2.getItem(i10)) {
                break;
            }
            i10++;
        }
        if (i10 != -1 && (firstVisiblePosition = (i10 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public final int D() {
        return this.f8575o.getLayoutDirection() == 1 ? 0 : 1;
    }

    public final int E(int i10) {
        List<d> list = this.f8569i;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f8576p.getWindowVisibleDisplayFrame(rect);
        return this.f8577q == 1 ? (iArr[0] + listViewA.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    public final void F(e eVar) {
        d dVar;
        View viewC;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f8562b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f8566f, f8560B);
        if (!isShowing() && this.f8582v) {
            dVar2.d(true);
        } else if (isShowing()) {
            dVar2.d(AbstractC4739d.x(eVar));
        }
        int iO = AbstractC4739d.o(dVar2, null, this.f8562b, this.f8563c);
        H hZ = z();
        hZ.l(dVar2);
        hZ.D(iO);
        hZ.E(this.f8574n);
        if (this.f8569i.size() > 0) {
            List<d> list = this.f8569i;
            dVar = list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            hZ.T(false);
            hZ.Q(null);
            int iE = E(iO);
            boolean z10 = iE == 1;
            this.f8577q = iE;
            hZ.B(viewC);
            if ((this.f8574n & 5) != 5) {
                iO = z10 ? viewC.getWidth() : 0 - iO;
            } else if (!z10) {
                iO = 0 - viewC.getWidth();
            }
            hZ.d(iO);
            hZ.L(true);
            hZ.h(0);
        } else {
            if (this.f8578r) {
                hZ.d(this.f8580t);
            }
            if (this.f8579s) {
                hZ.h(this.f8581u);
            }
            hZ.F(m());
        }
        this.f8569i.add(new d(hZ, eVar, this.f8577q));
        hZ.show();
        ListView listViewN = hZ.n();
        listViewN.setOnKeyListener(this);
        if (dVar == null && this.f8583w && eVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewN, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.z());
            listViewN.addHeaderView(frameLayout, null, false);
            hZ.show();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(e eVar, boolean z10) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i10 = iA + 1;
        if (i10 < this.f8569i.size()) {
            this.f8569i.get(i10).f8595b.e(false);
        }
        d dVarRemove = this.f8569i.remove(iA);
        dVarRemove.f8595b.R(this);
        if (this.f8561A) {
            dVarRemove.f8594a.R(null);
            dVarRemove.f8594a.C(0);
        }
        dVarRemove.f8594a.dismiss();
        int size = this.f8569i.size();
        if (size > 0) {
            this.f8577q = this.f8569i.get(size - 1).f8596c;
        } else {
            this.f8577q = D();
        }
        if (size != 0) {
            if (z10) {
                this.f8569i.get(0).f8595b.e(false);
                return;
            }
            return;
        }
        dismiss();
        i.a aVar = this.f8584x;
        if (aVar != null) {
            aVar.a(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f8585y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f8585y.removeGlobalOnLayoutListener(this.f8570j);
            }
            this.f8585y = null;
        }
        this.f8576p.removeOnAttachStateChangeListener(this.f8571k);
        this.f8586z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        Iterator<d> it = this.f8569i.iterator();
        while (it.hasNext()) {
            AbstractC4739d.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    @Override // j.InterfaceC4741f
    public void dismiss() {
        int size = this.f8569i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f8569i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f8594a.isShowing()) {
                    dVar.f8594a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(i.a aVar) {
        this.f8584x = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void f(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean g(l lVar) {
        for (d dVar : this.f8569i) {
            if (lVar == dVar.f8595b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        k(lVar);
        i.a aVar = this.f8584x;
        if (aVar != null) {
            aVar.b(lVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable h() {
        return null;
    }

    @Override // j.InterfaceC4741f
    public boolean isShowing() {
        return this.f8569i.size() > 0 && this.f8569i.get(0).f8594a.isShowing();
    }

    @Override // j.AbstractC4739d
    public void k(e eVar) {
        eVar.c(this, this.f8562b);
        if (isShowing()) {
            F(eVar);
        } else {
            this.f8568h.add(eVar);
        }
    }

    @Override // j.AbstractC4739d
    public boolean l() {
        return false;
    }

    @Override // j.InterfaceC4741f
    public ListView n() {
        if (this.f8569i.isEmpty()) {
            return null;
        }
        return this.f8569i.get(r1.size() - 1).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f8569i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f8569i.get(i10);
            if (!dVar.f8594a.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f8595b.e(false);
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
        if (this.f8575o != view) {
            this.f8575o = view;
            this.f8574n = C1321i.b(this.f8573m, view.getLayoutDirection());
        }
    }

    @Override // j.AbstractC4739d
    public void r(boolean z10) {
        this.f8582v = z10;
    }

    @Override // j.AbstractC4739d
    public void s(int i10) {
        if (this.f8573m != i10) {
            this.f8573m = i10;
            this.f8574n = C1321i.b(i10, this.f8575o.getLayoutDirection());
        }
    }

    @Override // j.InterfaceC4741f
    public void show() {
        if (isShowing()) {
            return;
        }
        Iterator<e> it = this.f8568h.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f8568h.clear();
        View view = this.f8575o;
        this.f8576p = view;
        if (view != null) {
            boolean z10 = this.f8585y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f8585y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f8570j);
            }
            this.f8576p.addOnAttachStateChangeListener(this.f8571k);
        }
    }

    @Override // j.AbstractC4739d
    public void t(int i10) {
        this.f8578r = true;
        this.f8580t = i10;
    }

    @Override // j.AbstractC4739d
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f8586z = onDismissListener;
    }

    @Override // j.AbstractC4739d
    public void v(boolean z10) {
        this.f8583w = z10;
    }

    @Override // j.AbstractC4739d
    public void w(int i10) {
        this.f8579s = true;
        this.f8581u = i10;
    }

    public final H z() {
        H h10 = new H(this.f8562b, null, this.f8564d, this.f8565e);
        h10.S(this.f8572l);
        h10.J(this);
        h10.I(this);
        h10.B(this.f8575o);
        h10.E(this.f8574n);
        h10.H(true);
        h10.G(2);
        return h10;
    }
}
