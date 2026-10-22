package stepos.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.stepos.aiengine.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12418a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f12419b;

    /* renamed from: c, reason: collision with root package name */
    public final c f12420c;

    /* renamed from: d, reason: collision with root package name */
    public final a f12421d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12422e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public final int f12423j;

    /* renamed from: k, reason: collision with root package name */
    public View f12424k;

    /* renamed from: l, reason: collision with root package name */
    public p f12425l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver f12426m;

    /* renamed from: n, reason: collision with root package name */
    public g.a f12427n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12428o;

    /* renamed from: p, reason: collision with root package name */
    public FrameLayout f12429p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12430q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f12431s = 0;

    /* renamed from: t, reason: collision with root package name */
    public final int f12432t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f12433u = -1;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final c f12434a;

        /* renamed from: b, reason: collision with root package name */
        public int f12435b = -1;

        public a(c cVar) {
            this.f12434a = cVar;
            b();
        }

        public final void b() {
            c cVar = f.this.f12420c;
            e eVar = cVar.f12392x;
            if (eVar != null) {
                cVar.i();
                ArrayList<e> arrayList = cVar.f12381l;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayList.get(i10) == eVar) {
                        this.f12435b = i10;
                        return;
                    }
                }
            }
            this.f12435b = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e getItem(int i10) {
            ArrayList<e> arrayListL;
            boolean z = f.this.f12422e;
            c cVar = this.f12434a;
            if (z) {
                cVar.i();
                arrayListL = cVar.f12381l;
            } else {
                arrayListL = cVar.l();
            }
            int i11 = this.f12435b;
            if (i11 >= 0 && i10 >= i11) {
                i10++;
            }
            return arrayListL.get(i10);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            ArrayList<e> arrayListL;
            boolean z = f.this.f12422e;
            c cVar = this.f12434a;
            if (z) {
                cVar.i();
                arrayListL = cVar.f12381l;
            } else {
                arrayListL = cVar.l();
            }
            return this.f12435b < 0 ? arrayListL.size() : arrayListL.size() - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
            f fVar = f.this;
            if (view == null) {
                view = fVar.f12419b.inflate(R.layout.stepos_popup_menu_item_layout, viewGroup, false);
            }
            view.setTag(Integer.valueOf(i10));
            h.a aVar = (h.a) view.findViewById(R.id.lmiv_container);
            int i11 = fVar.f12432t;
            if (i11 > 0) {
                aVar.setTitleMaxLines(i11);
            }
            if (fVar.f12428o) {
                ((ListMenuItemView) aVar).setForceShowIcon(true);
            }
            aVar.c(getItem(i10));
            int count = getCount();
            int dimensionPixelSize = fVar.f12418a.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_item_padding_ext);
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
        public final boolean isEnabled(int i10) {
            e item = getItem(i10);
            return item == null ? super.isEnabled(i10) : item.isEnabled();
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public f(Context context, c cVar, View view, boolean z, int i10) {
        this.f12418a = context;
        this.f12419b = LayoutInflater.from(context);
        this.f12420c = cVar;
        this.f12421d = new a(cVar);
        this.f12422e = z;
        this.f12423j = i10;
        this.h = context.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_width_max);
        this.f12424k = view;
        cVar.b(this, context);
    }

    @Override // stepos.support.v7.view.menu.g
    public final void a(c cVar, boolean z) {
        if (cVar != this.f12420c) {
            return;
        }
        h();
        g.a aVar = this.f12427n;
        if (aVar != null) {
            aVar.a(cVar, z);
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public final void b() {
        this.f12430q = false;
        a aVar = this.f12421d;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean d(e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean e(i iVar) {
        boolean z;
        if (iVar.hasVisibleItems()) {
            f fVar = new f(this.f12418a, iVar, this.f12424k, false, R.attr.popupMenuStyle);
            fVar.f12427n = this.f12427n;
            int size = iVar.f12378e.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    z = false;
                    break;
                }
                MenuItem item = iVar.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i10++;
            }
            fVar.f12428o = z;
            if (fVar.j()) {
                g.a aVar = this.f12427n;
                if (aVar != null) {
                    aVar.b(iVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean f(e eVar) {
        return false;
    }

    public final void h() {
        if (i()) {
            this.f12425l.dismiss();
        }
    }

    public final boolean i() {
        p pVar = this.f12425l;
        return pVar != null && pVar.C.isShowing();
    }

    public final boolean j() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        int i10 = this.f12423j;
        Context context = this.f12418a;
        p pVar = new p(context, null, i10, 0);
        try {
            pVar.D = (PopupWindow) p.E.get(pVar);
        } catch (Exception unused) {
        }
        this.f12425l = pVar;
        pVar.C.setOnDismissListener(this);
        p pVar2 = this.f12425l;
        pVar2.f875s = this;
        a aVar = this.f12421d;
        pVar2.setAdapter(aVar);
        p pVar3 = this.f12425l;
        pVar3.B = true;
        pVar3.C.setFocusable(true);
        if (this.f12431s == 0) {
            p pVar4 = this.f12425l;
            int i11 = this.f12433u;
            if (i11 == -1) {
                i11 = 0;
            }
            pVar4.f(i11);
        } else {
            int i12 = this.f12433u;
            if (i12 != -1) {
                this.f12425l.f(i12);
            }
        }
        View view = this.f12424k;
        if (view == null) {
            return false;
        }
        boolean z = this.f12426m == null;
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.f12426m = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        p pVar5 = this.f12425l;
        pVar5.r = view;
        pVar5.f872o = this.f12431s;
        if (!this.f12430q) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = aVar.getCount();
            View view2 = null;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (i13 >= count) {
                    break;
                }
                int itemViewType = aVar.getItemViewType(i13);
                if (itemViewType != i15) {
                    view2 = null;
                    i15 = itemViewType;
                }
                if (this.f12429p == null) {
                    this.f12429p = new FrameLayout(context);
                }
                view2 = aVar.getView(i13, view2, this.f12429p);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view2.getMeasuredWidth();
                int i16 = this.h;
                if (measuredWidth >= i16) {
                    i14 = i16;
                    break;
                }
                if (measuredWidth > i14) {
                    i14 = measuredWidth;
                }
                i13++;
            }
            this.r = i14;
            this.f12430q = true;
        }
        this.f12425l.e(this.r);
        this.f12425l.C.setInputMethodMode(2);
        PopupWindow popupWindow = this.f12425l.D;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(false);
        }
        this.f12425l.show();
        this.f12425l.f864c.setOnKeyListener(this);
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f12425l = null;
        this.f12420c.c(true);
        ViewTreeObserver viewTreeObserver = this.f12426m;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f12426m = this.f12424k.getViewTreeObserver();
            }
            this.f12426m.removeGlobalOnLayoutListener(this);
            this.f12426m = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (i()) {
            View view = this.f12424k;
            if (view == null || !view.isShown()) {
                h();
            } else if (i()) {
                this.f12425l.show();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        a aVar = this.f12421d;
        aVar.f12434a.p(aVar.getItem(i10), null, 0);
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        h();
        return true;
    }

    @Override // stepos.support.v7.view.menu.g
    public final void g(Context context, c cVar) {
    }
}
