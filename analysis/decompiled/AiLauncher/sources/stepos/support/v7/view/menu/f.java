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
import androidx.appcompat.R$attr;
import com.stepos.common.R$bool;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.o;

/* loaded from: classes5.dex */
public class f implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, g {

    /* renamed from: v, reason: collision with root package name */
    public static final int f40998v = R$layout.stepos_popup_menu_item_layout;

    /* renamed from: a, reason: collision with root package name */
    public final Context f40999a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f41000b;

    /* renamed from: c, reason: collision with root package name */
    public final c f41001c;

    /* renamed from: d, reason: collision with root package name */
    public final b f41002d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f41003e;

    /* renamed from: f, reason: collision with root package name */
    public final int f41004f;

    /* renamed from: g, reason: collision with root package name */
    public final int f41005g;

    /* renamed from: h, reason: collision with root package name */
    public final int f41006h;

    /* renamed from: i, reason: collision with root package name */
    public View f41007i;

    /* renamed from: j, reason: collision with root package name */
    public o f41008j;

    /* renamed from: k, reason: collision with root package name */
    public ViewTreeObserver f41009k;

    /* renamed from: l, reason: collision with root package name */
    public g.a f41010l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41011m;

    /* renamed from: n, reason: collision with root package name */
    public ViewGroup f41012n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f41013o;

    /* renamed from: p, reason: collision with root package name */
    public int f41014p;

    /* renamed from: q, reason: collision with root package name */
    public int f41015q;

    /* renamed from: r, reason: collision with root package name */
    public int f41016r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f41017s;

    /* renamed from: t, reason: collision with root package name */
    public View.OnClickListener f41018t;

    /* renamed from: u, reason: collision with root package name */
    public int f41019u;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.r()) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                ListView listViewN = f.this.f41008j.n();
                f.this.onItemClick(listViewN, listViewN.getChildAt(iIntValue - listViewN.getFirstVisiblePosition()), iIntValue, listViewN.getAdapter().getItemId(iIntValue));
            }
        }
    }

    public class b extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public c f41021a;

        /* renamed from: b, reason: collision with root package name */
        public int f41022b = -1;

        public b(c cVar) {
            this.f41021a = cVar;
            b();
        }

        public void b() {
            e eVarV = f.this.f41001c.v();
            if (eVarV != null) {
                ArrayList<e> arrayListZ = f.this.f41001c.z();
                int size = arrayListZ.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayListZ.get(i10) == eVarV) {
                        this.f41022b = i10;
                        return;
                    }
                }
            }
            this.f41022b = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e getItem(int i10) {
            ArrayList<e> arrayListZ = f.this.f41003e ? this.f41021a.z() : this.f41021a.E();
            int i11 = this.f41022b;
            if (i11 >= 0 && i10 >= i11) {
                i10++;
            }
            return arrayListZ.get(i10);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f41022b < 0 ? (f.this.f41003e ? this.f41021a.z() : this.f41021a.E()).size() : r0.size() - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
            if (view == null) {
                view = f.this.f41000b.inflate(f.f40998v, viewGroup, false);
            }
            view.setTag(Integer.valueOf(i10));
            h.a aVar = (h.a) view.findViewById(R$id.lmiv_container);
            if (f.this.f41016r > 0) {
                aVar.setTitleMaxLines(f.this.f41016r);
            }
            if (f.this.f41011m) {
                ((ListMenuItemView) aVar).setForceShowIcon(true);
            }
            aVar.d(getItem(i10), 0);
            int count = getCount();
            int dimensionPixelSize = f.this.f40999a.getResources().getDimensionPixelSize(R$dimen.stepos_popup_menu_item_padding_ext);
            if (count == 1) {
                view.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                return view;
            }
            if (i10 == 0) {
                view.setPadding(0, dimensionPixelSize, 0, 0);
                return view;
            }
            if (i10 == count - 1) {
                view.setPadding(0, 0, 0, dimensionPixelSize);
                return view;
            }
            view.setPadding(0, 0, 0, 0);
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            e item = getItem(i10);
            return item == null ? super.isEnabled(i10) : item.isEnabled();
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public f(Context context, c cVar, View view) {
        this(context, cVar, view, false, R$attr.popupMenuStyle);
    }

    @Override // stepos.support.v7.view.menu.g
    public void a(c cVar, boolean z10) {
        if (cVar != this.f41001c) {
            return;
        }
        o();
        g.a aVar = this.f41010l;
        if (aVar != null) {
            aVar.a(cVar, z10);
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public void b(boolean z10) {
        this.f41013o = false;
        b bVar = this.f41002d;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean d(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean e(i iVar) {
        boolean z10;
        if (iVar.hasVisibleItems()) {
            f fVar = new f(this.f40999a, iVar, this.f41007i);
            fVar.u(this.f41010l);
            int size = iVar.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = iVar.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            fVar.v(z10);
            if (fVar.y()) {
                g.a aVar = this.f41010l;
                if (aVar != null) {
                    aVar.b(iVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean f(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public void g(Context context, c cVar) {
    }

    public void n(int i10) {
        this.f41019u = i10;
    }

    public void o() {
        if (r()) {
            this.f41008j.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f41008j = null;
        this.f41001c.close();
        ViewTreeObserver viewTreeObserver = this.f41009k;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f41009k = this.f41007i.getViewTreeObserver();
            }
            this.f41009k.removeGlobalOnLayoutListener(this);
            this.f41009k = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (r()) {
            View view = this.f41007i;
            if (view == null || !view.isShown()) {
                o();
            } else if (r()) {
                this.f41008j.show();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        b bVar = this.f41002d;
        bVar.f41021a.K(bVar.getItem(i10), 0);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        o();
        return true;
    }

    public o p() {
        return this.f41008j;
    }

    public final int q() {
        WindowManager windowManager = (WindowManager) this.f40999a.getSystemService("window");
        if (windowManager == null) {
            return this.f40999a.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public boolean r() {
        o oVar = this.f41008j;
        return oVar != null && oVar.isShowing();
    }

    public final int s() {
        b bVar = this.f41002d;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = bVar.getCount();
        int i10 = 0;
        int i11 = 0;
        View view = null;
        for (int i12 = 0; i12 < count; i12++) {
            int itemViewType = bVar.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            if (this.f41012n == null) {
                this.f41012n = new FrameLayout(this.f40999a);
            }
            view = bVar.getView(i12, view, this.f41012n);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            int i13 = this.f41004f;
            if (measuredWidth >= i13) {
                return i13;
            }
            if (measuredWidth > i10) {
                i10 = measuredWidth;
            }
        }
        return i10;
    }

    public void t(View view) {
        this.f41007i = view;
    }

    public void u(g.a aVar) {
        this.f41010l = aVar;
    }

    public void v(boolean z10) {
        this.f41011m = z10;
    }

    public void w(int i10) {
        this.f41015q = i10;
    }

    public void x() {
        if (!y()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean y() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        o oVar = new o(this.f40999a, null, this.f41005g, this.f41006h);
        this.f41008j = oVar;
        oVar.I(this);
        this.f41008j.J(this);
        this.f41008j.l(this.f41002d);
        this.f41008j.H(true);
        if (this.f41015q == 0) {
            o oVar2 = this.f41008j;
            int i10 = this.f41019u;
            if (i10 == -1) {
                i10 = 0;
            }
            oVar2.Q(i10);
        } else {
            int i11 = this.f41019u;
            if (i11 != -1) {
                this.f41008j.Q(i11);
            }
        }
        View view = this.f41007i;
        if (view == null) {
            return false;
        }
        boolean z10 = this.f41009k == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f41009k = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.f41008j.B(view);
        this.f41008j.E(this.f41015q);
        if (!this.f41013o) {
            this.f41014p = s();
            this.f41013o = true;
        }
        if (this.f41017s && this.f40999a.getResources().getBoolean(R$bool.is_mini_square)) {
            this.f41008j.E(8388613);
            int iQ = q() / 2;
            int i12 = this.f41014p;
            this.f41008j.d(-((iQ - i12) + (i12 / 2)));
        }
        this.f41008j.D(this.f41014p);
        this.f41008j.G(2);
        this.f41008j.R(false);
        this.f41008j.show();
        this.f41008j.n().setOnKeyListener(this);
        return true;
    }

    public f(Context context, c cVar, View view, boolean z10, int i10) {
        this(context, cVar, view, z10, i10, 0);
    }

    public f(Context context, c cVar, View view, boolean z10, int i10, int i11) {
        this.f41015q = 0;
        this.f41016r = -1;
        this.f41018t = new a();
        this.f41019u = -1;
        this.f40999a = context;
        this.f41000b = LayoutInflater.from(context);
        this.f41001c = cVar;
        this.f41002d = new b(cVar);
        this.f41003e = z10;
        this.f41005g = i10;
        this.f41006h = i11;
        this.f41004f = context.getResources().getDimensionPixelSize(com.stepos.common.R$dimen.stepos_popup_menu_width_max);
        this.f41007i = view;
        cVar.c(this, context);
    }
}
