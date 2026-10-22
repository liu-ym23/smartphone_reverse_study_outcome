package stepos.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import g.C0728a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.view.menu.i;
import stepos.support.v7.widget.q;

/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, h {

    /* renamed from: v, reason: collision with root package name */
    static final int f21340v = X4.h.f6050v;

    /* renamed from: a, reason: collision with root package name */
    private final Context f21341a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutInflater f21342b;

    /* renamed from: c, reason: collision with root package name */
    private final d f21343c;

    /* renamed from: d, reason: collision with root package name */
    private final b f21344d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f21345e;

    /* renamed from: f, reason: collision with root package name */
    private final int f21346f;

    /* renamed from: g, reason: collision with root package name */
    private final int f21347g;

    /* renamed from: h, reason: collision with root package name */
    private final int f21348h;

    /* renamed from: i, reason: collision with root package name */
    private View f21349i;

    /* renamed from: j, reason: collision with root package name */
    private q f21350j;

    /* renamed from: k, reason: collision with root package name */
    private ViewTreeObserver f21351k;

    /* renamed from: l, reason: collision with root package name */
    private h.a f21352l;

    /* renamed from: m, reason: collision with root package name */
    boolean f21353m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f21354n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21355o;

    /* renamed from: p, reason: collision with root package name */
    private int f21356p;

    /* renamed from: q, reason: collision with root package name */
    private int f21357q;

    /* renamed from: r, reason: collision with root package name */
    private int f21358r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f21359s;

    /* renamed from: t, reason: collision with root package name */
    private View.OnClickListener f21360t;

    /* renamed from: u, reason: collision with root package name */
    private int f21361u;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.r()) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                ListView listViewM = g.this.f21350j.m();
                g.this.onItemClick(listViewM, listViewM.getChildAt(iIntValue - listViewM.getFirstVisiblePosition()), iIntValue, listViewM.getAdapter().getItemId(iIntValue));
            }
        }
    }

    private class b extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private d f21363a;

        /* renamed from: b, reason: collision with root package name */
        private int f21364b = -1;

        public b(d dVar) {
            this.f21363a = dVar;
            b();
        }

        void b() {
            f fVarV = g.this.f21343c.v();
            if (fVarV != null) {
                ArrayList<f> arrayListZ = g.this.f21343c.z();
                int size = arrayListZ.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (arrayListZ.get(i5) == fVarV) {
                        this.f21364b = i5;
                        return;
                    }
                }
            }
            this.f21364b = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public f getItem(int i5) {
            ArrayList<f> arrayListZ = g.this.f21345e ? this.f21363a.z() : this.f21363a.E();
            int i6 = this.f21364b;
            if (i6 >= 0 && i5 >= i6) {
                i5++;
            }
            return arrayListZ.get(i5);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f21364b < 0 ? (g.this.f21345e ? this.f21363a.z() : this.f21363a.E()).size() : r0.size() - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
            if (view == null) {
                view = g.this.f21342b.inflate(g.f21340v, viewGroup, false);
            }
            view.setTag(Integer.valueOf(i5));
            i.a aVar = (i.a) view.findViewById(X4.f.f5953A);
            if (g.this.f21358r > 0) {
                aVar.setTitleMaxLines(g.this.f21358r);
            }
            if (g.this.f21353m) {
                ((ListMenuItemView) aVar).setForceShowIcon(true);
            }
            aVar.d(getItem(i5), 0);
            int count = getCount();
            int dimensionPixelSize = g.this.f21341a.getResources().getDimensionPixelSize(X4.d.f5888Y);
            if (count == 1) {
                view.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                return view;
            }
            if (i5 == 0) {
                view.setPadding(0, dimensionPixelSize, 0, 0);
                return view;
            }
            if (i5 == count - 1) {
                view.setPadding(0, 0, 0, dimensionPixelSize);
                return view;
            }
            view.setPadding(0, 0, 0, 0);
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i5) {
            f item = getItem(i5);
            return item == null ? super.isEnabled(i5) : item.isEnabled();
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public g(Context context, d dVar, View view) {
        this(context, dVar, view, false, C0728a.f16814K);
    }

    private int q() {
        WindowManager windowManager = (WindowManager) this.f21341a.getSystemService("window");
        if (windowManager == null) {
            return this.f21341a.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int s() {
        b bVar = this.f21344d;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = bVar.getCount();
        int i5 = 0;
        int i6 = 0;
        View view = null;
        for (int i7 = 0; i7 < count; i7++) {
            int itemViewType = bVar.getItemViewType(i7);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            if (this.f21354n == null) {
                this.f21354n = new FrameLayout(this.f21341a);
            }
            view = bVar.getView(i7, view, this.f21354n);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int i8 = this.f21346f;
            if (measuredWidth >= i8) {
                return i8;
            }
            if (measuredWidth > i5) {
                i5 = measuredWidth;
            }
        }
        return i5;
    }

    @Override // stepos.support.v7.view.menu.h
    public void a(d dVar, boolean z5) {
        if (dVar != this.f21343c) {
            return;
        }
        o();
        h.a aVar = this.f21352l;
        if (aVar != null) {
            aVar.a(dVar, z5);
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public void b(boolean z5) {
        this.f21355o = false;
        b bVar = this.f21344d;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean d(d dVar, f fVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean e(j jVar) {
        boolean z5;
        if (jVar.hasVisibleItems()) {
            g gVar = new g(this.f21341a, jVar, this.f21349i);
            gVar.u(this.f21352l);
            int size = jVar.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    z5 = false;
                    break;
                }
                MenuItem item = jVar.getItem(i5);
                if (item.isVisible() && item.getIcon() != null) {
                    z5 = true;
                    break;
                }
                i5++;
            }
            gVar.v(z5);
            if (gVar.y()) {
                h.a aVar = this.f21352l;
                if (aVar != null) {
                    aVar.b(jVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public void f(Context context, d dVar) {
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean g(d dVar, f fVar) {
        return false;
    }

    public void n(int i5) {
        this.f21361u = i5;
    }

    public void o() {
        if (r()) {
            this.f21350j.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f21350j = null;
        this.f21343c.close();
        ViewTreeObserver viewTreeObserver = this.f21351k;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f21351k = this.f21349i.getViewTreeObserver();
            }
            this.f21351k.removeGlobalOnLayoutListener(this);
            this.f21351k = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (r()) {
            View view = this.f21349i;
            if (view == null || !view.isShown()) {
                o();
            } else if (r()) {
                this.f21350j.a();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
        b bVar = this.f21344d;
        bVar.f21363a.K(bVar.getItem(i5), 0);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i5 != 82) {
            return false;
        }
        o();
        return true;
    }

    public q p() {
        return this.f21350j;
    }

    public boolean r() {
        q qVar = this.f21350j;
        return qVar != null && qVar.h();
    }

    public void t(View view) {
        this.f21349i = view;
    }

    public void u(h.a aVar) {
        this.f21352l = aVar;
    }

    public void v(boolean z5) {
        this.f21353m = z5;
    }

    public void w(int i5) {
        this.f21357q = i5;
    }

    public void x() {
        if (!y()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean y() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        q qVar = new q(this.f21341a, null, this.f21347g, this.f21348h);
        this.f21350j = qVar;
        qVar.K(this);
        this.f21350j.L(this);
        this.f21350j.s(this.f21344d);
        this.f21350j.J(true);
        if (this.f21357q == 0) {
            q qVar2 = this.f21350j;
            int i5 = this.f21361u;
            if (i5 == -1) {
                i5 = 0;
            }
            qVar2.S(i5);
        } else {
            int i6 = this.f21361u;
            if (i6 != -1) {
                this.f21350j.S(i6);
            }
        }
        View view = this.f21349i;
        if (view == null) {
            return false;
        }
        boolean z5 = this.f21351k == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f21351k = viewTreeObserver;
        if (z5) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.f21350j.D(view);
        this.f21350j.G(this.f21357q);
        if (!this.f21355o) {
            this.f21356p = s();
            this.f21355o = true;
        }
        if (this.f21359s && this.f21341a.getResources().getBoolean(H1.d.f2072a)) {
            this.f21350j.G(8388613);
            int iQ = q() / 2;
            int i7 = this.f21356p;
            this.f21350j.j(-((iQ - i7) + (i7 / 2)));
        }
        this.f21350j.F(this.f21356p);
        this.f21350j.I(2);
        this.f21350j.T(false);
        this.f21350j.a();
        this.f21350j.m().setOnKeyListener(this);
        return true;
    }

    public g(Context context, d dVar, View view, boolean z5, int i5) {
        this(context, dVar, view, z5, i5, 0);
    }

    public g(Context context, d dVar, View view, boolean z5, int i5, int i6) {
        this.f21357q = 0;
        this.f21358r = -1;
        this.f21360t = new a();
        this.f21361u = -1;
        this.f21341a = context;
        this.f21342b = LayoutInflater.from(context);
        this.f21343c = dVar;
        this.f21344d = new b(dVar);
        this.f21345e = z5;
        this.f21347g = i5;
        this.f21348h = i6;
        this.f21346f = context.getResources().getDimensionPixelSize(H1.f.f2129Y);
        this.f21349i = view;
        dVar.c(this, context);
    }
}
