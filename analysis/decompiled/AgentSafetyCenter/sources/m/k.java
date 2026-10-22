package m;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements l.x {
    public final a1.g A;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7944c;

    /* renamed from: f, reason: collision with root package name */
    public Context f7945f;

    /* renamed from: g, reason: collision with root package name */
    public l.l f7946g;

    /* renamed from: h, reason: collision with root package name */
    public final LayoutInflater f7947h;
    public l.w i;

    /* renamed from: l, reason: collision with root package name */
    public l.z f7950l;

    /* renamed from: m, reason: collision with root package name */
    public j f7951m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f7952n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7953o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7954p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7955q;

    /* renamed from: r, reason: collision with root package name */
    public int f7956r;

    /* renamed from: s, reason: collision with root package name */
    public int f7957s;

    /* renamed from: t, reason: collision with root package name */
    public int f7958t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7959u;

    /* renamed from: w, reason: collision with root package name */
    public g f7961w;

    /* renamed from: x, reason: collision with root package name */
    public g f7962x;

    /* renamed from: y, reason: collision with root package name */
    public i f7963y;

    /* renamed from: z, reason: collision with root package name */
    public h f7964z;

    /* renamed from: j, reason: collision with root package name */
    public final int f7948j = R.layout.abc_action_menu_layout;

    /* renamed from: k, reason: collision with root package name */
    public final int f7949k = R.layout.abc_action_menu_item_layout;

    /* renamed from: v, reason: collision with root package name */
    public final SparseBooleanArray f7960v = new SparseBooleanArray();

    public k(Context context) {
        this.f7944c = context;
        this.f7947h = LayoutInflater.from(context);
        a1.g gVar = new a1.g(19, false);
        gVar.f19f = this;
        VarHandle.storeStoreFence();
        this.A = gVar;
    }

    @Override // l.x
    public final boolean a() {
        int size;
        ArrayList arrayListL;
        int i;
        boolean z10;
        k kVar = this;
        l.l lVar = kVar.f7946g;
        if (lVar != null) {
            arrayListL = lVar.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i3 = kVar.f7958t;
        int i10 = kVar.f7957s;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) kVar.f7950l;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i = 2;
            z10 = true;
            if (i11 >= size) {
                break;
            }
            l.n nVar = (l.n) arrayListL.get(i11);
            int i14 = nVar.f7633y;
            if ((i14 & 2) == 2) {
                i12++;
            } else if ((i14 & 1) == 1) {
                i13++;
            } else {
                z11 = true;
            }
            if (kVar.f7959u && nVar.C) {
                i3 = 0;
            }
            i11++;
        }
        if (kVar.f7954p && (z11 || i13 + i12 > i3)) {
            i3--;
        }
        int i15 = i3 - i12;
        SparseBooleanArray sparseBooleanArray = kVar.f7960v;
        sparseBooleanArray.clear();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            l.n nVar2 = (l.n) arrayListL.get(i16);
            int i18 = nVar2.f7633y;
            boolean z12 = (i18 & 2) == i ? z10 : false;
            int i19 = nVar2.f7611b;
            if (z12) {
                View viewB = kVar.b(nVar2, null, viewGroup);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                if (i19 != 0) {
                    sparseBooleanArray.put(i19, z10);
                }
                nVar2.f(z10);
            } else if ((i18 & 1) == z10) {
                boolean z13 = sparseBooleanArray.get(i19);
                boolean z14 = ((i15 > 0 || z13) && i10 > 0) ? z10 : false;
                if (z14) {
                    View viewB2 = kVar.b(nVar2, null, viewGroup);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z14 &= i10 + i17 > 0;
                }
                if (z14 && i19 != 0) {
                    sparseBooleanArray.put(i19, true);
                } else if (z13) {
                    sparseBooleanArray.put(i19, false);
                    for (int i20 = 0; i20 < i16; i20++) {
                        l.n nVar3 = (l.n) arrayListL.get(i20);
                        if (nVar3.f7611b == i19) {
                            if ((nVar3.f7632x & 32) == 32) {
                                i15++;
                            }
                            nVar3.f(false);
                        }
                    }
                }
                if (z14) {
                    i15--;
                }
                nVar2.f(z14);
            } else {
                nVar2.f(false);
                i16++;
                i = 2;
                kVar = this;
                z10 = true;
            }
            i16++;
            i = 2;
            kVar = this;
            z10 = true;
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [l.y] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final View b(l.n nVar, View view, ViewGroup viewGroup) {
        View actionView = nVar.getActionView();
        if (actionView == null || nVar.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof l.y ? (l.y) view : (l.y) this.f7947h.inflate(this.f7949k, viewGroup, false);
            actionMenuItemView.c(nVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f7950l);
            if (this.f7964z == null) {
                h hVar = new h();
                hVar.f7918a = this;
                VarHandle.storeStoreFence();
                this.f7964z = hVar;
            }
            actionMenuItemView2.setPopupCallback(this.f7964z);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(nVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof m)) {
            actionView.setLayoutParams(ActionMenuView.l(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.x
    public final void c() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.f7950l;
        ArrayList arrayList = null;
        boolean z10 = false;
        if (viewGroup != null) {
            l.l lVar = this.f7946g;
            if (lVar != null) {
                lVar.i();
                ArrayList arrayListL = this.f7946g.l();
                int size = arrayListL.size();
                i = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    l.n nVar = (l.n) arrayListL.get(i3);
                    if ((nVar.f7632x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        l.n itemData = childAt instanceof l.y ? ((l.y) childAt).getItemData() : null;
                        View viewB = b(nVar, childAt, viewGroup);
                        if (nVar != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewB);
                            }
                            ((ViewGroup) this.f7950l).addView(viewB, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.f7951m) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.f7950l).requestLayout();
        l.l lVar2 = this.f7946g;
        if (lVar2 != null) {
            lVar2.i();
            ArrayList arrayList2 = lVar2.i;
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                n3.d dVar = ((l.n) arrayList2.get(i10)).A;
            }
        }
        l.l lVar3 = this.f7946g;
        if (lVar3 != null) {
            lVar3.i();
            arrayList = lVar3.f7591j;
        }
        if (this.f7954p && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z10 = !((l.n) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z10 = true;
            }
        }
        j jVar = this.f7951m;
        if (z10) {
            if (jVar == null) {
                this.f7951m = new j(this, this.f7944c);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f7951m.getParent();
            if (viewGroup3 != this.f7950l) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f7951m);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f7950l;
                j jVar2 = this.f7951m;
                actionMenuView.getClass();
                m mVarK = ActionMenuView.k();
                mVarK.f7996a = true;
                actionMenuView.addView(jVar2, mVarK);
            }
        } else if (jVar != null) {
            Object parent = jVar.getParent();
            Object obj = this.f7950l;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f7951m);
            }
        }
        ((ActionMenuView) this.f7950l).setOverflowReserved(this.f7954p);
    }

    @Override // l.x
    public final void d(l.l lVar, boolean z10) {
        f();
        g gVar = this.f7962x;
        if (gVar != null && gVar.b()) {
            gVar.i.dismiss();
        }
        l.w wVar = this.i;
        if (wVar != null) {
            wVar.d(lVar, z10);
        }
    }

    @Override // l.x
    public final boolean e(l.n nVar) {
        return false;
    }

    public final boolean f() {
        Object obj;
        i iVar = this.f7963y;
        if (iVar != null && (obj = this.f7950l) != null) {
            ((View) obj).removeCallbacks(iVar);
            this.f7963y = null;
            return true;
        }
        g gVar = this.f7961w;
        if (gVar == null) {
            return false;
        }
        if (gVar.b()) {
            gVar.i.dismiss();
        }
        return true;
    }

    @Override // l.x
    public final void g(l.w wVar) {
        throw null;
    }

    public final boolean h() {
        g gVar = this.f7961w;
        return gVar != null && gVar.b();
    }

    @Override // l.x
    public final void i(Context context, l.l lVar) {
        this.f7945f = context;
        LayoutInflater.from(context);
        this.f7946g = lVar;
        Resources resources = context.getResources();
        if (!this.f7955q) {
            this.f7954p = true;
        }
        int i = 2;
        this.f7956r = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i10 > 720) || (i3 > 720 && i10 > 960))) {
            i = 5;
        } else if (i3 >= 500 || ((i3 > 640 && i10 > 480) || (i3 > 480 && i10 > 640))) {
            i = 4;
        } else if (i3 >= 360) {
            i = 3;
        }
        this.f7958t = i;
        int measuredWidth = this.f7956r;
        if (this.f7954p) {
            if (this.f7951m == null) {
                j jVar = new j(this, this.f7944c);
                this.f7951m = jVar;
                if (this.f7953o) {
                    jVar.setImageDrawable(this.f7952n);
                    this.f7952n = null;
                    this.f7953o = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f7951m.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f7951m.getMeasuredWidth();
        } else {
            this.f7951m = null;
        }
        this.f7957s = measuredWidth;
        float f5 = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.x
    public final boolean j(l.d0 d0Var) {
        boolean z10;
        if (d0Var.hasVisibleItems()) {
            l.d0 d0Var2 = d0Var;
            while (true) {
                l.l lVar = d0Var2.f7544z;
                if (lVar == this.f7946g) {
                    break;
                }
                d0Var2 = (l.d0) lVar;
            }
            l.n nVar = d0Var2.A;
            ViewGroup viewGroup = (ViewGroup) this.f7950l;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof l.y) && ((l.y) childAt).getItemData() == nVar) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                d0Var.A.getClass();
                int size = d0Var.f7588f.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z10 = false;
                        break;
                    }
                    MenuItem item = d0Var.getItem(i3);
                    if (item.isVisible() && item.getIcon() != null) {
                        z10 = true;
                        break;
                    }
                    i3++;
                }
                g gVar = new g(this, this.f7945f, d0Var, view);
                this.f7962x = gVar;
                gVar.f7652g = z10;
                l.t tVar = gVar.i;
                if (tVar != null) {
                    tVar.o(z10);
                }
                g gVar2 = this.f7962x;
                if (!gVar2.b()) {
                    if (gVar2.f7650e == null) {
                        od.f.e("MenuPopupHelper cannot be used without an anchor");
                        return false;
                    }
                    gVar2.d(0, 0, false, false);
                }
                l.w wVar = this.i;
                if (wVar != null) {
                    wVar.f(d0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // l.x
    public final boolean k(l.n nVar) {
        return false;
    }

    public final boolean l() {
        l.l lVar;
        if (!this.f7954p || h() || (lVar = this.f7946g) == null || this.f7950l == null || this.f7963y != null) {
            return false;
        }
        lVar.i();
        if (lVar.f7591j.isEmpty()) {
            return false;
        }
        g gVar = new g(this, this.f7945f, this.f7946g, this.f7951m);
        i iVar = new i();
        iVar.f7924f = this;
        iVar.f7923c = gVar;
        VarHandle.storeStoreFence();
        this.f7963y = iVar;
        ((View) this.f7950l).post(iVar);
        return true;
    }
}
