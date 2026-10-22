package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
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
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.N;
import androidx.appcompat.widget.O;
import androidx.core.view.C0464i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends h implements j, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B, reason: collision with root package name */
    private static final int f7821B = g.g.f16949e;

    /* renamed from: A, reason: collision with root package name */
    boolean f7822A;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7823b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7824c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7825d;

    /* renamed from: e, reason: collision with root package name */
    private final int f7826e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f7827f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f7828g;

    /* renamed from: o, reason: collision with root package name */
    private View f7836o;

    /* renamed from: p, reason: collision with root package name */
    View f7837p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7839r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7840s;

    /* renamed from: t, reason: collision with root package name */
    private int f7841t;

    /* renamed from: u, reason: collision with root package name */
    private int f7842u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7844w;

    /* renamed from: x, reason: collision with root package name */
    private j.a f7845x;

    /* renamed from: y, reason: collision with root package name */
    ViewTreeObserver f7846y;

    /* renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f7847z;

    /* renamed from: h, reason: collision with root package name */
    private final List<e> f7829h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final List<d> f7830i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f7831j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f7832k = new ViewOnAttachStateChangeListenerC0106b();

    /* renamed from: l, reason: collision with root package name */
    private final N f7833l = new c();

    /* renamed from: m, reason: collision with root package name */
    private int f7834m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f7835n = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7843v = false;

    /* renamed from: q, reason: collision with root package name */
    private int f7838q = D();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.h() || b.this.f7830i.size() <= 0 || b.this.f7830i.get(0).f7855a.B()) {
                return;
            }
            View view = b.this.f7837p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator<d> it = b.this.f7830i.iterator();
            while (it.hasNext()) {
                it.next().f7855a.a();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    class ViewOnAttachStateChangeListenerC0106b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0106b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f7846y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f7846y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f7846y.removeGlobalOnLayoutListener(bVar.f7831j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements N {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f7851a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f7852b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f7853c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f7851a = dVar;
                this.f7852b = menuItem;
                this.f7853c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f7851a;
                if (dVar != null) {
                    b.this.f7822A = true;
                    dVar.f7856b.e(false);
                    b.this.f7822A = false;
                }
                if (this.f7852b.isEnabled() && this.f7852b.hasSubMenu()) {
                    this.f7853c.M(this.f7852b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.N
        public void b(e eVar, MenuItem menuItem) {
            b.this.f7828g.removeCallbacksAndMessages(null);
            int size = b.this.f7830i.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                } else if (eVar == b.this.f7830i.get(i5).f7856b) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 == -1) {
                return;
            }
            int i6 = i5 + 1;
            b.this.f7828g.postAtTime(new a(i6 < b.this.f7830i.size() ? b.this.f7830i.get(i6) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.N
        public void c(e eVar, MenuItem menuItem) {
            b.this.f7828g.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final O f7855a;

        /* renamed from: b, reason: collision with root package name */
        public final e f7856b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7857c;

        public d(O o5, e eVar, int i5) {
            this.f7855a = o5;
            this.f7856b = eVar;
            this.f7857c = i5;
        }

        public ListView a() {
            return this.f7855a.m();
        }
    }

    public b(Context context, View view, int i5, int i6, boolean z5) {
        this.f7823b = context;
        this.f7836o = view;
        this.f7825d = i5;
        this.f7826e = i6;
        this.f7827f = z5;
        Resources resources = context.getResources();
        this.f7824c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.f16862d));
        this.f7828g = new Handler();
    }

    private int A(e eVar) {
        int size = this.f7830i.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (eVar == this.f7830i.get(i5).f7856b) {
                return i5;
            }
        }
        return -1;
    }

    private MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = eVar.getItem(i5);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f7856b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i5 = 0;
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
            if (i5 >= count) {
                i5 = -1;
                break;
            }
            if (menuItemB == dVar2.getItem(i5)) {
                break;
            }
            i5++;
        }
        if (i5 != -1 && (firstVisiblePosition = (i5 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return this.f7836o.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int E(int i5) {
        List<d> list = this.f7830i;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f7837p.getWindowVisibleDisplayFrame(rect);
        return this.f7838q == 1 ? (iArr[0] + listViewA.getWidth()) + i5 > rect.right ? 0 : 1 : iArr[0] - i5 < 0 ? 1 : 0;
    }

    private void F(e eVar) {
        d dVar;
        View viewC;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f7823b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f7827f, f7821B);
        if (!h() && this.f7843v) {
            dVar2.d(true);
        } else if (h()) {
            dVar2.d(h.x(eVar));
        }
        int iO = h.o(dVar2, null, this.f7823b, this.f7824c);
        O oZ = z();
        oZ.s(dVar2);
        oZ.F(iO);
        oZ.G(this.f7835n);
        if (this.f7830i.size() > 0) {
            List<d> list = this.f7830i;
            dVar = list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            oZ.V(false);
            oZ.S(null);
            int iE = E(iO);
            boolean z5 = iE == 1;
            this.f7838q = iE;
            oZ.D(viewC);
            if ((this.f7835n & 5) != 5) {
                iO = z5 ? viewC.getWidth() : 0 - iO;
            } else if (!z5) {
                iO = 0 - viewC.getWidth();
            }
            oZ.j(iO);
            oZ.N(true);
            oZ.o(0);
        } else {
            if (this.f7839r) {
                oZ.j(this.f7841t);
            }
            if (this.f7840s) {
                oZ.o(this.f7842u);
            }
            oZ.H(n());
        }
        this.f7830i.add(new d(oZ, eVar, this.f7838q));
        oZ.a();
        ListView listViewM = oZ.m();
        listViewM.setOnKeyListener(this);
        if (dVar == null && this.f7844w && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(g.g.f16956l, (ViewGroup) listViewM, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            listViewM.addHeaderView(frameLayout, null, false);
            oZ.a();
        }
    }

    private O z() {
        O o5 = new O(this.f7823b, null, this.f7825d, this.f7826e);
        o5.U(this.f7833l);
        o5.L(this);
        o5.K(this);
        o5.D(this.f7836o);
        o5.G(this.f7835n);
        o5.J(true);
        o5.I(2);
        return o5;
    }

    @Override // l.InterfaceC0820e
    public void a() {
        if (h()) {
            return;
        }
        Iterator<e> it = this.f7829h.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        this.f7829h.clear();
        View view = this.f7836o;
        this.f7837p = view;
        if (view != null) {
            boolean z5 = this.f7846y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f7846y = viewTreeObserver;
            if (z5) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f7831j);
            }
            this.f7837p.addOnAttachStateChangeListener(this.f7832k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(boolean z5) {
        Iterator<d> it = this.f7830i.iterator();
        while (it.hasNext()) {
            h.y(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(e eVar, boolean z5) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i5 = iA + 1;
        if (i5 < this.f7830i.size()) {
            this.f7830i.get(i5).f7856b.e(false);
        }
        d dVarRemove = this.f7830i.remove(iA);
        dVarRemove.f7856b.P(this);
        if (this.f7822A) {
            dVarRemove.f7855a.T(null);
            dVarRemove.f7855a.E(0);
        }
        dVarRemove.f7855a.dismiss();
        int size = this.f7830i.size();
        if (size > 0) {
            this.f7838q = this.f7830i.get(size - 1).f7857c;
        } else {
            this.f7838q = D();
        }
        if (size != 0) {
            if (z5) {
                this.f7830i.get(0).f7856b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f7845x;
        if (aVar != null) {
            aVar.d(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f7846y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f7846y.removeGlobalOnLayoutListener(this.f7831j);
            }
            this.f7846y = null;
        }
        this.f7837p.removeOnAttachStateChangeListener(this.f7832k);
        this.f7847z.onDismiss();
    }

    @Override // l.InterfaceC0820e
    public void dismiss() {
        int size = this.f7830i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f7830i.toArray(new d[size]);
            for (int i5 = size - 1; i5 >= 0; i5--) {
                d dVar = dVarArr[i5];
                if (dVar.f7855a.h()) {
                    dVar.f7855a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f7845x = aVar;
    }

    @Override // l.InterfaceC0820e
    public boolean h() {
        return this.f7830i.size() > 0 && this.f7830i.get(0).f7855a.h();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(m mVar) {
        for (d dVar : this.f7830i) {
            if (mVar == dVar.f7856b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        k(mVar);
        j.a aVar = this.f7845x;
        if (aVar != null) {
            aVar.e(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void k(e eVar) {
        eVar.c(this, this.f7823b);
        if (h()) {
            F(eVar);
        } else {
            this.f7829h.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean l() {
        return false;
    }

    @Override // l.InterfaceC0820e
    public ListView m() {
        if (this.f7830i.isEmpty()) {
            return null;
        }
        return this.f7830i.get(r1.size() - 1).a();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f7830i.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f7830i.get(i5);
            if (!dVar.f7855a.h()) {
                break;
            } else {
                i5++;
            }
        }
        if (dVar != null) {
            dVar.f7856b.e(false);
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
        if (this.f7836o != view) {
            this.f7836o = view;
            this.f7835n = C0464i.b(this.f7834m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z5) {
        this.f7843v = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i5) {
        if (this.f7834m != i5) {
            this.f7834m = i5;
            this.f7835n = C0464i.b(i5, this.f7836o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i5) {
        this.f7839r = true;
        this.f7841t = i5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f7847z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z5) {
        this.f7844w = z5;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i5) {
        this.f7840s = true;
        this.f7842u = i5;
    }
}
