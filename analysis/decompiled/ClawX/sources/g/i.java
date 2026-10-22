package g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.stepos.stepclaw.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements f.p {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2712a;

    /* renamed from: b, reason: collision with root package name */
    public Context f2713b;

    /* renamed from: c, reason: collision with root package name */
    public f.j f2714c;
    public final LayoutInflater d;

    /* renamed from: e, reason: collision with root package name */
    public f.o f2715e;

    /* renamed from: g, reason: collision with root package name */
    public ActionMenuView f2717g;

    /* renamed from: h, reason: collision with root package name */
    public h f2718h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f2719j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2720k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2721l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2722m;

    /* renamed from: n, reason: collision with root package name */
    public int f2723n;

    /* renamed from: o, reason: collision with root package name */
    public int f2724o;

    /* renamed from: p, reason: collision with root package name */
    public int f2725p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2726q;

    /* renamed from: s, reason: collision with root package name */
    public f f2728s;

    /* renamed from: t, reason: collision with root package name */
    public f f2729t;

    /* renamed from: u, reason: collision with root package name */
    public b0.a f2730u;

    /* renamed from: v, reason: collision with root package name */
    public g f2731v;

    /* renamed from: f, reason: collision with root package name */
    public final int f2716f = R.layout.abc_action_menu_item_layout;

    /* renamed from: r, reason: collision with root package name */
    public final SparseBooleanArray f2727r = new SparseBooleanArray();

    /* renamed from: w, reason: collision with root package name */
    public final androidx.emoji2.text.m f2732w = new androidx.emoji2.text.m(this);

    public i(Context context) {
        this.f2712a = context;
        this.d = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v4, types: [f.q] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final View a(f.k kVar, View view, ActionMenuView actionMenuView) {
        View view2 = kVar.z;
        View view3 = view2 != null ? view2 : null;
        if (view3 == null || ((kVar.y & 8) != 0 && view2 != null)) {
            ActionMenuItemView actionMenuItemView = view instanceof f.q ? (f.q) view : (f.q) this.d.inflate(this.f2716f, (ViewGroup) actionMenuView, false);
            actionMenuItemView.b(kVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker(this.f2717g);
            if (this.f2731v == null) {
                this.f2731v = new g(this);
            }
            actionMenuItemView2.setPopupCallback(this.f2731v);
            view3 = actionMenuItemView;
        }
        view3.setVisibility(kVar.B ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        actionMenuView.getClass();
        if (!(layoutParams instanceof k)) {
            view3.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return view3;
    }

    @Override // f.p
    public final void b(f.j jVar, boolean z) {
        g();
        f fVar = this.f2729t;
        if (fVar != null && fVar.b()) {
            fVar.f2505i.dismiss();
        }
        f.o oVar = this.f2715e;
        if (oVar != null) {
            oVar.b(jVar, z);
        }
    }

    @Override // f.p
    public final boolean c(f.k kVar) {
        return false;
    }

    @Override // f.p
    public final void d(f.o oVar) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.p
    public final void e() {
        int i8;
        ActionMenuView actionMenuView = this.f2717g;
        ArrayList arrayList = null;
        boolean z = false;
        if (actionMenuView != null) {
            f.j jVar = this.f2714c;
            if (jVar != null) {
                jVar.i();
                ArrayList arrayListK = this.f2714c.k();
                int size = arrayListK.size();
                i8 = 0;
                for (int i9 = 0; i9 < size; i9++) {
                    f.k kVar = (f.k) arrayListK.get(i9);
                    if ((kVar.f2495x & 32) == 32) {
                        View childAt = actionMenuView.getChildAt(i8);
                        f.k itemData = childAt instanceof f.q ? ((f.q) childAt).getItemData() : null;
                        View viewA = a(kVar, childAt, actionMenuView);
                        if (kVar != itemData) {
                            viewA.setPressed(false);
                            viewA.jumpDrawablesToCurrentState();
                        }
                        if (viewA != childAt) {
                            ViewGroup viewGroup = (ViewGroup) viewA.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(viewA);
                            }
                            this.f2717g.addView(viewA, i8);
                        }
                        i8++;
                    }
                }
            } else {
                i8 = 0;
            }
            while (i8 < actionMenuView.getChildCount()) {
                if (actionMenuView.getChildAt(i8) == this.f2718h) {
                    i8++;
                } else {
                    actionMenuView.removeViewAt(i8);
                }
            }
        }
        this.f2717g.requestLayout();
        f.j jVar2 = this.f2714c;
        if (jVar2 != null) {
            jVar2.i();
            ArrayList arrayList2 = jVar2.f2461i;
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((f.k) arrayList2.get(i10)).getClass();
            }
        }
        f.j jVar3 = this.f2714c;
        if (jVar3 != null) {
            jVar3.i();
            arrayList = jVar3.f2462j;
        }
        if (this.f2721l && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((f.k) arrayList.get(0)).B;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.f2718h == null) {
                this.f2718h = new h(this, this.f2712a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f2718h.getParent();
            if (viewGroup2 != this.f2717g) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f2718h);
                }
                ActionMenuView actionMenuView2 = this.f2717g;
                h hVar = this.f2718h;
                actionMenuView2.getClass();
                k kVarI = ActionMenuView.i();
                kVarI.f2759a = true;
                actionMenuView2.addView(hVar, kVarI);
            }
        } else {
            h hVar2 = this.f2718h;
            if (hVar2 != null) {
                ViewParent parent = hVar2.getParent();
                ActionMenuView actionMenuView3 = this.f2717g;
                if (parent == actionMenuView3) {
                    actionMenuView3.removeView(this.f2718h);
                }
            }
        }
        this.f2717g.setOverflowReserved(this.f2721l);
    }

    @Override // f.p
    public final boolean f(f.k kVar) {
        return false;
    }

    public final boolean g() {
        ActionMenuView actionMenuView;
        b0.a aVar = this.f2730u;
        if (aVar != null && (actionMenuView = this.f2717g) != null) {
            actionMenuView.removeCallbacks(aVar);
            this.f2730u = null;
            return true;
        }
        f fVar = this.f2728s;
        if (fVar == null) {
            return false;
        }
        if (fVar.b()) {
            fVar.f2505i.dismiss();
        }
        return true;
    }

    @Override // f.p
    public final boolean h() {
        int size;
        ArrayList arrayListK;
        int i8;
        boolean z;
        i iVar = this;
        f.j jVar = iVar.f2714c;
        if (jVar != null) {
            arrayListK = jVar.k();
            size = arrayListK.size();
        } else {
            size = 0;
            arrayListK = null;
        }
        int i9 = iVar.f2725p;
        int i10 = iVar.f2724o;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ActionMenuView actionMenuView = iVar.f2717g;
        int i11 = 0;
        boolean z2 = false;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i8 = 2;
            z = true;
            if (i11 >= size) {
                break;
            }
            f.k kVar = (f.k) arrayListK.get(i11);
            int i14 = kVar.y;
            if ((i14 & 2) == 2) {
                i12++;
            } else if ((i14 & 1) == 1) {
                i13++;
            } else {
                z2 = true;
            }
            if (iVar.f2726q && kVar.B) {
                i9 = 0;
            }
            i11++;
        }
        if (iVar.f2721l && (z2 || i13 + i12 > i9)) {
            i9--;
        }
        int i15 = i9 - i12;
        SparseBooleanArray sparseBooleanArray = iVar.f2727r;
        sparseBooleanArray.clear();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            f.k kVar2 = (f.k) arrayListK.get(i16);
            int i18 = kVar2.y;
            boolean z8 = (i18 & 2) == i8 ? z : false;
            int i19 = kVar2.f2474b;
            if (z8) {
                View viewA = iVar.a(kVar2, null, actionMenuView);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                if (i19 != 0) {
                    sparseBooleanArray.put(i19, z);
                }
                kVar2.d(z);
            } else if ((i18 & 1) == z) {
                boolean z9 = sparseBooleanArray.get(i19);
                boolean z10 = ((i15 > 0 || z9) && i10 > 0) ? z : false;
                if (z10) {
                    View viewA2 = iVar.a(kVar2, null, actionMenuView);
                    viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z10 &= i10 + i17 > 0;
                }
                if (z10 && i19 != 0) {
                    sparseBooleanArray.put(i19, true);
                } else if (z9) {
                    sparseBooleanArray.put(i19, false);
                    for (int i20 = 0; i20 < i16; i20++) {
                        f.k kVar3 = (f.k) arrayListK.get(i20);
                        if (kVar3.f2474b == i19) {
                            if ((kVar3.f2495x & 32) == 32) {
                                i15++;
                            }
                            kVar3.d(false);
                        }
                    }
                }
                if (z10) {
                    i15--;
                }
                kVar2.d(z10);
            } else {
                kVar2.d(false);
                i16++;
                i8 = 2;
                iVar = this;
                z = true;
            }
            i16++;
            i8 = 2;
            iVar = this;
            z = true;
        }
        return z;
    }

    @Override // f.p
    public final void i(Context context, f.j jVar) {
        this.f2713b = context;
        LayoutInflater.from(context);
        this.f2714c = jVar;
        Resources resources = context.getResources();
        if (!this.f2722m) {
            this.f2721l = true;
        }
        int i8 = 2;
        this.f2723n = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i9 = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i9 > 600 || ((i9 > 960 && i10 > 720) || (i9 > 720 && i10 > 960))) {
            i8 = 5;
        } else if (i9 >= 500 || ((i9 > 640 && i10 > 480) || (i9 > 480 && i10 > 640))) {
            i8 = 4;
        } else if (i9 >= 360) {
            i8 = 3;
        }
        this.f2725p = i8;
        int measuredWidth = this.f2723n;
        if (this.f2721l) {
            if (this.f2718h == null) {
                h hVar = new h(this, this.f2712a);
                this.f2718h = hVar;
                if (this.f2720k) {
                    hVar.setImageDrawable(this.f2719j);
                    this.f2719j = null;
                    this.f2720k = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2718h.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f2718h.getMeasuredWidth();
        } else {
            this.f2718h = null;
        }
        this.f2724o = measuredWidth;
        float f3 = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.p
    public final boolean j(f.t tVar) {
        boolean z;
        if (tVar.hasVisibleItems()) {
            f.t tVar2 = tVar;
            while (true) {
                f.j jVar = tVar2.f2526v;
                if (jVar == this.f2714c) {
                    break;
                }
                tVar2 = (f.t) jVar;
            }
            f.k kVar = tVar2.f2527w;
            ActionMenuView actionMenuView = this.f2717g;
            View view = null;
            if (actionMenuView != null) {
                int childCount = actionMenuView.getChildCount();
                int i8 = 0;
                while (true) {
                    if (i8 >= childCount) {
                        break;
                    }
                    View childAt = actionMenuView.getChildAt(i8);
                    if ((childAt instanceof f.q) && ((f.q) childAt).getItemData() == kVar) {
                        view = childAt;
                        break;
                    }
                    i8++;
                }
            }
            if (view != null) {
                tVar.f2527w.getClass();
                int size = tVar.f2458f.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = tVar.getItem(i9);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i9++;
                }
                f fVar = new f(this, this.f2713b, tVar, view);
                this.f2729t = fVar;
                fVar.f2503g = z;
                f.l lVar = fVar.f2505i;
                if (lVar != null) {
                    lVar.o(z);
                }
                f fVar2 = this.f2729t;
                if (!fVar2.b()) {
                    if (fVar2.f2501e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    fVar2.d(0, 0, false, false);
                }
                f.o oVar = this.f2715e;
                if (oVar != null) {
                    oVar.g(tVar);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean k() {
        f.j jVar;
        if (!this.f2721l) {
            return false;
        }
        f fVar = this.f2728s;
        if ((fVar != null && fVar.b()) || (jVar = this.f2714c) == null || this.f2717g == null || this.f2730u != null) {
            return false;
        }
        jVar.i();
        if (jVar.f2462j.isEmpty()) {
            return false;
        }
        b0.a aVar = new b0.a(this, new f(this, this.f2713b, this.f2714c, this.f2718h), 3, false);
        this.f2730u = aVar;
        this.f2717g.post(aVar);
        return true;
    }
}
