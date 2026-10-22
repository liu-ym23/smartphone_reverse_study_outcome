package stepos.support.v7.widget;

import Va.AbstractC0268f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import com.stepos.ability.R;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ActionMenuItemView;

/* renamed from: stepos.support.v7.widget.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2005u extends AbstractC0268f implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: A, reason: collision with root package name */
    public r f6631A;

    /* renamed from: B, reason: collision with root package name */
    public C1999n f6632B;

    /* renamed from: C, reason: collision with root package name */
    public A.a f6633C;

    /* renamed from: D, reason: collision with root package name */
    public C2000o f6634D;
    public final C2003s E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f6635F;
    public C2002q i;

    /* renamed from: j, reason: collision with root package name */
    public TouchDelegate f6636j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f6637q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6638r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6639s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6640t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public int f6641v;

    /* renamed from: w, reason: collision with root package name */
    public int f6642w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f6643x;
    public final SparseBooleanArray y;

    /* renamed from: z, reason: collision with root package name */
    public View f6644z;

    public C2005u(Context context) {
        this.f1438a = context;
        this.d = LayoutInflater.from(context);
        this.f = R.layout.stepos_abc_action_menu_layout;
        this.g = R.layout.stepos_action_menu_item_layout;
        this.y = new SparseBooleanArray();
        this.E = new C2003s(this);
    }

    @Override // Va.B
    public final void b(Context context, Va.n nVar) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = nVar;
        Resources resources = context.getResources();
        Context context2 = Ua.a.a(context).f1279a;
        if (!this.n) {
            this.m = true;
        }
        if (!this.f6640t) {
            this.o = context2.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.f6638r) {
            this.f6637q = context2.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        int measuredWidth = this.o;
        if (this.m) {
            if (this.i == null) {
                C2002q c2002q = new C2002q(this, this.f1438a);
                this.i = c2002q;
                if (this.l) {
                    c2002q.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.p = measuredWidth;
        this.f6641v = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f6644z = null;
        this.f6642w = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    @Override // Va.B
    public final boolean c(Va.F f) {
        if (f.hasVisibleItems()) {
            Va.F f7 = f;
            while (true) {
                Va.n nVar = f7.f1429w;
                if (nVar == this.c) {
                    break;
                }
                f7 = (Va.F) nVar;
            }
            Va.q qVar = f7.f1430x;
            ViewGroup viewGroup = (ViewGroup) this.h;
            C2002q c2002q = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    ?? childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof Va.C) && ((Va.C) childAt).getItemData() == qVar) {
                        c2002q = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (c2002q != null || (c2002q = this.i) != null) {
                f.f1430x.getClass();
                C1999n c1999n = new C1999n(this, this.b, f);
                this.f6632B = c1999n;
                c1999n.p = GravityCompat.END;
                c1999n.f1469r = 4;
                c1999n.h = c2002q;
                if (!c1999n.h()) {
                    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                }
                c2002q.post(new A.a(20, this, c2002q));
                this.f6632B.i.setOnDismissListener(new C1998m(c2002q));
                Va.A a3 = this.e;
                if (a3 != null) {
                    a3.n(f);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [Va.C] */
    /* JADX WARN: Type inference failed for: r5v5, types: [Va.C] */
    public final View e(Va.q qVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        ActionMenuItemView actionView = qVar.getActionView();
        if (actionView == null || qVar.b()) {
            if (view instanceof Va.C) {
                actionMenuItemView = (Va.C) view;
            } else {
                ?? r5 = (Va.C) this.d.inflate(this.g, viewGroup, false);
                boolean z10 = r5 instanceof View;
                actionMenuItemView = r5;
                if (z10) {
                    actionMenuItemView = r5;
                }
            }
            actionMenuItemView.setIsInSplit(this.f6635F);
            actionMenuItemView.a(qVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.h);
            if (this.f6634D == null) {
                this.f6634D = new C2000o(this);
            }
            actionMenuItemView2.setPopupCallback(this.f6634D);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(qVar.f1452C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
            return actionView;
        }
        if ((layoutParams instanceof C2008x) && (actionView instanceof ActionMenuItemView)) {
            ((C2008x) layoutParams).f6645a = ((ActionMenuItemView) actionView).o;
        }
        return actionView;
    }

    @Override // Va.B
    public final void f(Va.n nVar, boolean z10) {
        h();
        C1999n c1999n = this.f6632B;
        if (c1999n != null) {
            c1999n.e();
        }
        Va.A a3 = this.e;
        if (a3 != null) {
            a3.f(nVar, z10);
        }
    }

    @Override // Va.B
    public final boolean flagActionItems() {
        int iMeasureChildForCells;
        int i;
        ArrayList arrayList;
        int i6;
        ArrayList arrayList2;
        C2005u c2005u = this;
        boolean z10 = c2005u.f6635F;
        SparseBooleanArray sparseBooleanArray = c2005u.y;
        boolean z11 = true;
        if (z10) {
            ArrayList arrayListL = c2005u.c.l();
            int size = arrayListL.size();
            int i10 = c2005u.o;
            boolean z12 = false;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                Va.q qVar = (Va.q) arrayListL.get(i13);
                if (qVar.requiresActionButton()) {
                    i11++;
                } else if ((qVar.y & 1) == 1) {
                    i12++;
                } else {
                    z12 = true;
                }
            }
            boolean z13 = c2005u.m && z12;
            sparseBooleanArray.clear();
            int i14 = c2005u.f6639s ? i10 / c2005u.f6642w : 0;
            int i15 = i11 + i12;
            if ((i15 > i14) | z13) {
                i14--;
            }
            if (i15 >= i14) {
                i15 = i14;
            }
            int i16 = 0;
            while (i16 < size && i15 > 0) {
                Va.q qVar2 = (Va.q) arrayListL.get(i16);
                if (qVar2.requiresActionButton() || (qVar2.y & 1) == 1) {
                    i15--;
                    qVar2.c(true);
                    int i17 = qVar2.b;
                    if (i17 != 0) {
                        sparseBooleanArray.put(i17, true);
                    }
                } else {
                    qVar2.c(false);
                }
                i16++;
            }
            for (int i18 = i16; i18 < size; i18++) {
                ((Va.q) arrayListL.get(i16)).c(false);
            }
        } else {
            ArrayList arrayListL2 = c2005u.c.l();
            int size2 = arrayListL2.size();
            int i19 = c2005u.f6637q;
            int i20 = c2005u.p;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            ViewGroup viewGroup = (ViewGroup) c2005u.h;
            boolean z14 = false;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = 0; i23 < size2; i23++) {
                Va.q qVar3 = (Va.q) arrayListL2.get(i23);
                if (qVar3.requiresActionButton()) {
                    i21++;
                } else if ((qVar3.y & 1) == 1) {
                    i22++;
                } else {
                    z14 = true;
                }
                if (c2005u.u && qVar3.f1452C) {
                    i19 = 0;
                }
            }
            if (c2005u.m && (z14 || i22 + i21 > i19)) {
                i19--;
            }
            int i24 = i19 - i21;
            sparseBooleanArray.clear();
            if (c2005u.f6639s) {
                int i25 = c2005u.f6641v;
                iMeasureChildForCells = i20 / i25;
                i = ((i20 % i25) / iMeasureChildForCells) + i25;
            } else {
                iMeasureChildForCells = 0;
                i = 0;
            }
            int i26 = 0;
            int i27 = 0;
            while (i26 < size2) {
                Va.q qVar4 = (Va.q) arrayListL2.get(i26);
                boolean zRequiresActionButton = qVar4.requiresActionButton();
                int i28 = qVar4.b;
                if (zRequiresActionButton) {
                    View viewE = c2005u.e(qVar4, c2005u.f6644z, viewGroup);
                    if (c2005u.f6644z == null) {
                        c2005u.f6644z = viewE;
                    }
                    if (c2005u.f6639s) {
                        iMeasureChildForCells -= ActionMenuView.measureChildForCells(viewE, i, iMeasureChildForCells, iMakeMeasureSpec, 0);
                    } else {
                        viewE.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth = viewE.getMeasuredWidth();
                    i20 -= measuredWidth;
                    if (i27 == 0) {
                        i27 = measuredWidth;
                    }
                    if (i28 != 0) {
                        sparseBooleanArray.put(i28, true);
                    }
                    qVar4.c(true);
                    arrayList = arrayListL2;
                    i6 = size2;
                } else if ((qVar4.y & 1) == 1) {
                    boolean z15 = sparseBooleanArray.get(i28);
                    boolean z16 = (i24 > 0 || z15) && i20 > 0 && (!c2005u.f6639s || iMeasureChildForCells > 0);
                    if (z16) {
                        View viewE2 = c2005u.e(qVar4, c2005u.f6644z, viewGroup);
                        i6 = size2;
                        if (c2005u.f6644z == null) {
                            c2005u.f6644z = viewE2;
                        }
                        if (c2005u.f6639s) {
                            int iMeasureChildForCells2 = ActionMenuView.measureChildForCells(viewE2, i, iMeasureChildForCells, iMakeMeasureSpec, 0);
                            iMeasureChildForCells -= iMeasureChildForCells2;
                            if (iMeasureChildForCells2 == 0) {
                                z16 = false;
                            }
                        } else {
                            viewE2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        int measuredWidth2 = viewE2.getMeasuredWidth();
                        i20 -= measuredWidth2;
                        if (i27 == 0) {
                            i27 = measuredWidth2;
                        }
                        z16 &= !c2005u.f6639s ? i26 != 0 ? i20 < 0 : i20 + i27 <= 0 : i20 < 0;
                    } else {
                        i6 = size2;
                    }
                    if (z16 && i28 != 0) {
                        sparseBooleanArray.put(i28, true);
                    } else if (z15) {
                        sparseBooleanArray.put(i28, false);
                        int i29 = 0;
                        while (i29 < i26) {
                            Va.q qVar5 = (Va.q) arrayListL2.get(i29);
                            if (qVar5.b == i28) {
                                arrayList2 = arrayListL2;
                                if ((qVar5.f1461x & 32) == 32) {
                                    i24++;
                                }
                                qVar5.c(false);
                            } else {
                                arrayList2 = arrayListL2;
                            }
                            i29++;
                            arrayListL2 = arrayList2;
                        }
                    }
                    arrayList = arrayListL2;
                    if (z16) {
                        i24--;
                    }
                    qVar4.c(z16);
                } else {
                    arrayList = arrayListL2;
                    i6 = size2;
                    qVar4.c(false);
                    i26++;
                    c2005u = this;
                    size2 = i6;
                    arrayListL2 = arrayList;
                    z11 = true;
                }
                i26++;
                c2005u = this;
                size2 = i6;
                arrayListL2 = arrayList;
                z11 = true;
            }
        }
        return z11;
    }

    public final Va.D g(ViewGroup viewGroup) {
        if (this.h == null) {
            Va.D d = (Va.D) this.d.inflate(this.f, viewGroup, false);
            this.h = d;
            d.a(this.c);
            updateMenuView(true);
        }
        Va.D d6 = this.h;
        ((ActionMenuView) d6).setPresenter(this);
        return d6;
    }

    public final boolean h() {
        Object obj;
        A.a aVar = this.f6633C;
        if (aVar != null && (obj = this.h) != null) {
            ((View) obj).removeCallbacks(aVar);
            this.f6633C = null;
            return true;
        }
        r rVar = this.f6631A;
        if (rVar == null) {
            return false;
        }
        rVar.e();
        return true;
    }

    public final boolean i() {
        r rVar = this.f6631A;
        return rVar != null && rVar.g();
    }

    public final void j(boolean z10) {
        if (this.f6635F != z10) {
            this.f6635F = z10;
            this.g = z10 ? R.layout.stepos_action_menu_item_split_layout : R.layout.stepos_action_menu_item_layout;
            Object obj = this.h;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z10) {
                return;
            }
            this.n = false;
            this.f6640t = false;
            this.f6638r = false;
            b(this.b, this.c);
        }
    }

    public final void k(int i) {
        this.f6637q = Integer.MAX_VALUE;
        this.f6638r = true;
    }

    public final void l(int i, boolean z10) {
        this.o = i;
        this.f6639s = true;
        this.f6640t = true;
    }

    public final boolean m() {
        Va.n nVar;
        if (!this.m || i() || (nVar = this.c) == null || this.h == null || this.f6633C != null) {
            return false;
        }
        nVar.i();
        if (nVar.i.isEmpty()) {
            return false;
        }
        A.a aVar = new A.a(21, this, new r(this, this.b, this.c, this.i));
        this.f6633C = aVar;
        ((View) this.h).post(aVar);
        Va.A a3 = this.e;
        if (a3 == null) {
            return true;
        }
        a3.n(null);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public final void onSubUiVisibilityChanged(boolean z10) {
        if (!z10) {
            this.c.c(false);
            return;
        }
        Va.A a3 = this.e;
        if (a3 != null) {
            a3.n(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
    @Override // Va.B
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateMenuView(boolean r11) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.C2005u.updateMenuView(boolean):void");
    }
}
