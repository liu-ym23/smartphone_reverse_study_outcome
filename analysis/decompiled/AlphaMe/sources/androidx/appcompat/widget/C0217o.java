package androidx.appcompat.widget;

import K.AbstractC0072d;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.stepos.alphame.R;
import d.C0527a;
import j.C0622a;
import java.util.ArrayList;
import k.AbstractC0669w;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0640A;
import k.InterfaceC0641B;
import k.InterfaceC0642C;
import k.InterfaceC0672z;
import k.SubMenuC0646G;

/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0217o implements InterfaceC0640A {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3126a;

    /* renamed from: b, reason: collision with root package name */
    public Context f3127b;

    /* renamed from: c, reason: collision with root package name */
    public C0661o f3128c;

    /* renamed from: d, reason: collision with root package name */
    public final LayoutInflater f3129d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0672z f3130e;

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0642C f3133h;

    /* renamed from: i, reason: collision with root package name */
    public C0213m f3134i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f3135j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3136k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3137l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3138m;

    /* renamed from: n, reason: collision with root package name */
    public int f3139n;

    /* renamed from: o, reason: collision with root package name */
    public int f3140o;

    /* renamed from: p, reason: collision with root package name */
    public int f3141p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3142q;

    /* renamed from: s, reason: collision with root package name */
    public C0205i f3144s;

    /* renamed from: t, reason: collision with root package name */
    public C0205i f3145t;

    /* renamed from: u, reason: collision with root package name */
    public RunnableC0209k f3146u;

    /* renamed from: v, reason: collision with root package name */
    public C0207j f3147v;

    /* renamed from: f, reason: collision with root package name */
    public final int f3131f = R.layout.abc_action_menu_layout;

    /* renamed from: g, reason: collision with root package name */
    public final int f3132g = R.layout.abc_action_menu_item_layout;

    /* renamed from: r, reason: collision with root package name */
    public final SparseBooleanArray f3143r = new SparseBooleanArray();

    /* renamed from: w, reason: collision with root package name */
    public final C0527a f3148w = new C0527a(5, this);

    public C0217o(Context context) {
        this.f3126a = context;
        this.f3129d = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k.InterfaceC0640A
    public final void a() {
        int size;
        int i4;
        ViewGroup viewGroup = (ViewGroup) this.f3133h;
        ArrayList arrayList = null;
        if (viewGroup != null) {
            C0661o c0661o = this.f3128c;
            if (c0661o != null) {
                c0661o.i();
                ArrayList arrayListL = this.f3128c.l();
                int size2 = arrayListL.size();
                i4 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    C0663q c0663q = (C0663q) arrayListL.get(i5);
                    if (c0663q.f()) {
                        View childAt = viewGroup.getChildAt(i4);
                        C0663q itemData = childAt instanceof InterfaceC0641B ? ((InterfaceC0641B) childAt).getItemData() : null;
                        View viewE = e(c0663q, childAt, viewGroup);
                        if (c0663q != itemData) {
                            viewE.setPressed(false);
                            viewE.jumpDrawablesToCurrentState();
                        }
                        if (viewE != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewE.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewE);
                            }
                            ((ViewGroup) this.f3133h).addView(viewE, i4);
                        }
                        i4++;
                    }
                }
            } else {
                i4 = 0;
            }
            while (i4 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i4) == this.f3134i) {
                    i4++;
                } else {
                    viewGroup.removeViewAt(i4);
                }
            }
        }
        ((View) this.f3133h).requestLayout();
        C0661o c0661o2 = this.f3128c;
        if (c0661o2 != null) {
            c0661o2.i();
            ArrayList arrayList2 = c0661o2.f13246i;
            int size3 = arrayList2.size();
            for (int i6 = 0; i6 < size3; i6++) {
                AbstractC0072d abstractC0072d = ((C0663q) arrayList2.get(i6)).f13266A;
            }
        }
        C0661o c0661o3 = this.f3128c;
        if (c0661o3 != null) {
            c0661o3.i();
            arrayList = c0661o3.f13247j;
        }
        if (!this.f3137l || arrayList == null || ((size = arrayList.size()) != 1 ? size <= 0 : !(!((C0663q) arrayList.get(0)).f13268C))) {
            C0213m c0213m = this.f3134i;
            if (c0213m != null) {
                Object parent = c0213m.getParent();
                Object obj = this.f3133h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f3134i);
                }
            }
        } else {
            if (this.f3134i == null) {
                this.f3134i = new C0213m(this, this.f3126a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f3134i.getParent();
            if (viewGroup3 != this.f3133h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f3134i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f3133h;
                C0213m c0213m2 = this.f3134i;
                actionMenuView.getClass();
                r rVarN = ActionMenuView.n();
                rVarN.f3150a = true;
                actionMenuView.addView(c0213m2, rVarN);
            }
        }
        ((ActionMenuView) this.f3133h).setOverflowReserved(this.f3137l);
    }

    @Override // k.InterfaceC0640A
    public final void b(C0661o c0661o, boolean z4) {
        g();
        C0205i c0205i = this.f3145t;
        if (c0205i != null && c0205i.b()) {
            c0205i.f13316j.dismiss();
        }
        InterfaceC0672z interfaceC0672z = this.f3130e;
        if (interfaceC0672z != null) {
            interfaceC0672z.b(c0661o, z4);
        }
    }

    @Override // k.InterfaceC0640A
    public final boolean c() {
        int size;
        ArrayList arrayListL;
        int i4;
        boolean z4;
        C0661o c0661o = this.f3128c;
        if (c0661o != null) {
            arrayListL = c0661o.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i5 = this.f3141p;
        int i6 = this.f3140o;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f3133h;
        int i7 = 0;
        boolean z5 = false;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i4 = 2;
            z4 = true;
            if (i7 >= size) {
                break;
            }
            C0663q c0663q = (C0663q) arrayListL.get(i7);
            int i10 = c0663q.f13293y;
            if ((i10 & 2) == 2) {
                i8++;
            } else if ((i10 & 1) == 1) {
                i9++;
            } else {
                z5 = true;
            }
            if (this.f3142q && c0663q.f13268C) {
                i5 = 0;
            }
            i7++;
        }
        if (this.f3137l && (z5 || i9 + i8 > i5)) {
            i5--;
        }
        int i11 = i5 - i8;
        SparseBooleanArray sparseBooleanArray = this.f3143r;
        sparseBooleanArray.clear();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            C0663q c0663q2 = (C0663q) arrayListL.get(i12);
            int i14 = c0663q2.f13293y;
            boolean z6 = (i14 & 2) == i4 ? z4 : false;
            int i15 = c0663q2.f13270b;
            if (z6) {
                View viewE = e(c0663q2, null, viewGroup);
                viewE.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewE.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                if (i15 != 0) {
                    sparseBooleanArray.put(i15, z4);
                }
                c0663q2.g(z4);
            } else if ((i14 & 1) == z4) {
                boolean z7 = sparseBooleanArray.get(i15);
                boolean z8 = ((i11 > 0 || z7) && i6 > 0) ? z4 : false;
                if (z8) {
                    View viewE2 = e(c0663q2, null, viewGroup);
                    viewE2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewE2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z8 &= i6 + i13 > 0;
                }
                if (z8 && i15 != 0) {
                    sparseBooleanArray.put(i15, true);
                } else if (z7) {
                    sparseBooleanArray.put(i15, false);
                    for (int i16 = 0; i16 < i12; i16++) {
                        C0663q c0663q3 = (C0663q) arrayListL.get(i16);
                        if (c0663q3.f13270b == i15) {
                            if (c0663q3.f()) {
                                i11++;
                            }
                            c0663q3.g(false);
                        }
                    }
                }
                if (z8) {
                    i11--;
                }
                c0663q2.g(z8);
            } else {
                c0663q2.g(false);
                i12++;
                i4 = 2;
                z4 = true;
            }
            i12++;
            i4 = 2;
            z4 = true;
        }
        return z4;
    }

    @Override // k.InterfaceC0640A
    public final /* bridge */ /* synthetic */ boolean d(C0663q c0663q) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [k.B] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final View e(C0663q c0663q, View view, ViewGroup viewGroup) {
        View actionView = c0663q.getActionView();
        if (actionView == null || c0663q.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof InterfaceC0641B ? (InterfaceC0641B) view : (InterfaceC0641B) this.f3129d.inflate(this.f3132g, viewGroup, false);
            actionMenuItemView.c(c0663q);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f3133h);
            if (this.f3147v == null) {
                this.f3147v = new C0207j(this);
            }
            actionMenuItemView2.setPopupCallback(this.f3147v);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(c0663q.f13268C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof r)) {
            actionView.setLayoutParams(ActionMenuView.o(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k.InterfaceC0640A
    public final boolean f(SubMenuC0646G subMenuC0646G) {
        boolean z4;
        if (!subMenuC0646G.hasVisibleItems()) {
            return false;
        }
        SubMenuC0646G subMenuC0646G2 = subMenuC0646G;
        while (true) {
            C0661o c0661o = subMenuC0646G2.f13162z;
            if (c0661o == this.f3128c) {
                break;
            }
            subMenuC0646G2 = (SubMenuC0646G) c0661o;
        }
        ViewGroup viewGroup = (ViewGroup) this.f3133h;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i4);
                if ((childAt instanceof InterfaceC0641B) && ((InterfaceC0641B) childAt).getItemData() == subMenuC0646G2.f13161A) {
                    view = childAt;
                    break;
                }
                i4++;
            }
        }
        if (view == null) {
            return false;
        }
        subMenuC0646G.f13161A.getClass();
        int size = subMenuC0646G.f13243f.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                z4 = false;
                break;
            }
            MenuItem item = subMenuC0646G.getItem(i5);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i5++;
        }
        C0205i c0205i = new C0205i(this, this.f3127b, subMenuC0646G, view);
        this.f3145t = c0205i;
        c0205i.f13314h = z4;
        AbstractC0669w abstractC0669w = c0205i.f13316j;
        if (abstractC0669w != null) {
            abstractC0669w.o(z4);
        }
        C0205i c0205i2 = this.f3145t;
        if (!c0205i2.b()) {
            if (c0205i2.f13312f == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c0205i2.d(0, 0, false, false);
        }
        InterfaceC0672z interfaceC0672z = this.f3130e;
        if (interfaceC0672z != null) {
            interfaceC0672z.f(subMenuC0646G);
        }
        return true;
    }

    public final boolean g() {
        Object obj;
        RunnableC0209k runnableC0209k = this.f3146u;
        if (runnableC0209k != null && (obj = this.f3133h) != null) {
            ((View) obj).removeCallbacks(runnableC0209k);
            this.f3146u = null;
            return true;
        }
        C0205i c0205i = this.f3144s;
        if (c0205i == null) {
            return false;
        }
        if (c0205i.b()) {
            c0205i.f13316j.dismiss();
        }
        return true;
    }

    @Override // k.InterfaceC0640A
    public final /* bridge */ /* synthetic */ boolean h(C0663q c0663q) {
        return false;
    }

    public final boolean i() {
        C0205i c0205i = this.f3144s;
        return c0205i != null && c0205i.b();
    }

    @Override // k.InterfaceC0640A
    public final void j(InterfaceC0672z interfaceC0672z) {
        this.f3130e = interfaceC0672z;
    }

    @Override // k.InterfaceC0640A
    public final void k(Context context, C0661o c0661o) {
        this.f3127b = context;
        LayoutInflater.from(context);
        this.f3128c = c0661o;
        Resources resources = context.getResources();
        C0622a c0622a = new C0622a(context, 0);
        if (!this.f3138m) {
            this.f3137l = true;
        }
        this.f3139n = c0622a.d();
        this.f3141p = c0622a.e();
        int measuredWidth = this.f3139n;
        if (this.f3137l) {
            if (this.f3134i == null) {
                C0213m c0213m = new C0213m(this, this.f3126a);
                this.f3134i = c0213m;
                if (this.f3136k) {
                    c0213m.setImageDrawable(this.f3135j);
                    this.f3135j = null;
                    this.f3136k = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3134i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f3134i.getMeasuredWidth();
        } else {
            this.f3134i = null;
        }
        this.f3140o = measuredWidth;
        float f4 = resources.getDisplayMetrics().density;
    }

    public final boolean l() {
        C0661o c0661o;
        int i4 = 0;
        if (this.f3137l && !i() && (c0661o = this.f3128c) != null && this.f3133h != null && this.f3146u == null) {
            c0661o.i();
            if (!c0661o.f13247j.isEmpty()) {
                RunnableC0209k runnableC0209k = new RunnableC0209k(i4, this, new C0205i(this, this.f3127b, this.f3128c, this.f3134i));
                this.f3146u = runnableC0209k;
                ((View) this.f3133h).post(runnableC0209k);
                return true;
            }
        }
        return false;
    }
}
