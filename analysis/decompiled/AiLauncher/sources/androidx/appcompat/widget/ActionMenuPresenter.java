package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC1314b;
import i.C4155a;
import j.InterfaceC4741f;
import java.util.ArrayList;
import u0.C5566a;

/* loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements AbstractC1314b.a {

    /* renamed from: A, reason: collision with root package name */
    public c f8778A;

    /* renamed from: B, reason: collision with root package name */
    public b f8779B;

    /* renamed from: C, reason: collision with root package name */
    public final f f8780C;

    /* renamed from: D, reason: collision with root package name */
    public int f8781D;

    /* renamed from: k, reason: collision with root package name */
    public d f8782k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f8783l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8784m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8785n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8786o;

    /* renamed from: p, reason: collision with root package name */
    public int f8787p;

    /* renamed from: q, reason: collision with root package name */
    public int f8788q;

    /* renamed from: r, reason: collision with root package name */
    public int f8789r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8790s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8791t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8792u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8793v;

    /* renamed from: w, reason: collision with root package name */
    public int f8794w;

    /* renamed from: x, reason: collision with root package name */
    public final SparseBooleanArray f8795x;

    /* renamed from: y, reason: collision with root package name */
    public e f8796y;

    /* renamed from: z, reason: collision with root package name */
    public a f8797z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public class a extends androidx.appcompat.view.menu.h {
        public a(Context context, androidx.appcompat.view.menu.l lVar, View view) {
            super(context, lVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) lVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f8782k;
                f(view2 == null ? (View) ActionMenuPresenter.this.f8558i : view2);
            }
            j(ActionMenuPresenter.this.f8780C);
        }

        @Override // androidx.appcompat.view.menu.h
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f8797z = null;
            actionMenuPresenter.f8781D = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC4741f a() {
            a aVar = ActionMenuPresenter.this.f8797z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public e f8800a;

        public c(e eVar) {
            this.f8800a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f8552c != null) {
                ActionMenuPresenter.this.f8552c.d();
            }
            View view = (View) ActionMenuPresenter.this.f8558i;
            if (view != null && view.getWindowToken() != null && this.f8800a.m()) {
                ActionMenuPresenter.this.f8796y = this.f8800a;
            }
            ActionMenuPresenter.this.f8778A = null;
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        public class a extends E {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f8803j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f8803j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.E
            public InterfaceC4741f b() {
                e eVar = ActionMenuPresenter.this.f8796y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.E
            public boolean c() {
                ActionMenuPresenter.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.E
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f8778A != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            Z.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.M();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C5566a.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.h {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z10) {
            super(context, eVar, view, z10, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.f8780C);
        }

        @Override // androidx.appcompat.view.menu.h
        public void e() {
            if (ActionMenuPresenter.this.f8552c != null) {
                ActionMenuPresenter.this.f8552c.close();
            }
            ActionMenuPresenter.this.f8796y = null;
            super.e();
        }
    }

    public class f implements i.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (eVar instanceof androidx.appcompat.view.menu.l) {
                eVar.F().e(false);
            }
            i.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                aVarO.a(eVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ActionMenuPresenter.this.f8552c) {
                return false;
            }
            ActionMenuPresenter.this.f8781D = ((androidx.appcompat.view.menu.l) eVar).getItem().getItemId();
            i.a aVarO = ActionMenuPresenter.this.o();
            if (aVarO != null) {
                return aVarO.b(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f8795x = new SparseBooleanArray();
        this.f8780C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f8558i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof j.a) && ((j.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return E() | D();
    }

    public Drawable C() {
        d dVar = this.f8782k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f8784m) {
            return this.f8783l;
        }
        return null;
    }

    public boolean D() {
        Object obj;
        c cVar = this.f8778A;
        if (cVar != null && (obj = this.f8558i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f8778A = null;
            return true;
        }
        e eVar = this.f8796y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.f8797z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.f8778A != null || G();
    }

    public boolean G() {
        e eVar = this.f8796y;
        return eVar != null && eVar.d();
    }

    public void H(Configuration configuration) {
        if (!this.f8790s) {
            this.f8789r = C4155a.b(this.f8551b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f8552c;
        if (eVar != null) {
            eVar.N(true);
        }
    }

    public void I(boolean z10) {
        this.f8793v = z10;
    }

    public void J(ActionMenuView actionMenuView) {
        this.f8558i = actionMenuView;
        actionMenuView.d(this.f8552c);
    }

    public void K(Drawable drawable) {
        d dVar = this.f8782k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f8784m = true;
            this.f8783l = drawable;
        }
    }

    public void L(boolean z10) {
        this.f8785n = z10;
        this.f8786o = true;
    }

    public boolean M() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f8785n || G() || (eVar = this.f8552c) == null || this.f8558i == null || this.f8778A != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f8551b, this.f8552c, this.f8782k, true));
        this.f8778A = cVar;
        ((View) this.f8558i).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
        A();
        super.a(eVar, z10);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        super.b(z10);
        ((View) this.f8558i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f8552c;
        boolean z11 = false;
        if (eVar != null) {
            ArrayList<androidx.appcompat.view.menu.g> arrayListU = eVar.u();
            int size = arrayListU.size();
            for (int i10 = 0; i10 < size; i10++) {
                AbstractC1314b abstractC1314bA = arrayListU.get(i10).a();
                if (abstractC1314bA != null) {
                    abstractC1314bA.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f8552c;
        ArrayList<androidx.appcompat.view.menu.g> arrayListB = eVar2 != null ? eVar2.B() : null;
        if (this.f8785n && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z11 = !arrayListB.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f8782k == null) {
                this.f8782k = new d(this.f8550a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f8782k.getParent();
            if (viewGroup != this.f8558i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f8782k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f8558i;
                actionMenuView.addView(this.f8782k, actionMenuView.k());
            }
        } else {
            d dVar = this.f8782k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f8558i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f8782k);
                }
            }
        }
        ((ActionMenuView) this.f8558i).setOverflowReserved(this.f8785n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.i
    public boolean c() {
        ArrayList<androidx.appcompat.view.menu.g> arrayListG;
        int size;
        int i10;
        int iQ;
        boolean z10;
        int i11;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.f8552c;
        View view = null;
        ?? r32 = 0;
        if (eVar != null) {
            arrayListG = eVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i12 = actionMenuPresenter.f8789r;
        int i13 = actionMenuPresenter.f8788q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f8558i;
        boolean z11 = false;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            androidx.appcompat.view.menu.g gVar = arrayListG.get(i16);
            if (gVar.o()) {
                i14++;
            } else if (gVar.n()) {
                i15++;
            } else {
                z11 = true;
            }
            if (actionMenuPresenter.f8793v && gVar.isActionViewExpanded()) {
                i12 = 0;
            }
        }
        if (actionMenuPresenter.f8785n && (z11 || i15 + i14 > i12)) {
            i12--;
        }
        int i17 = i12 - i14;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f8795x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f8791t) {
            int i18 = actionMenuPresenter.f8794w;
            iQ = i13 / i18;
            i10 = i18 + ((i13 % i18) / iQ);
        } else {
            i10 = 0;
            iQ = 0;
        }
        int i19 = 0;
        int i20 = 0;
        while (i19 < size) {
            androidx.appcompat.view.menu.g gVar2 = arrayListG.get(i19);
            if (gVar2.o()) {
                View viewP = actionMenuPresenter.p(gVar2, view, viewGroup);
                if (actionMenuPresenter.f8791t) {
                    iQ -= ActionMenuView.q(viewP, i10, iQ, iMakeMeasureSpec, r32);
                } else {
                    viewP.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewP.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i20 == 0) {
                    i20 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z10 = r32;
                i11 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z12 = sparseBooleanArray.get(groupId2);
                boolean z13 = (i17 > 0 || z12) && i13 > 0 && (!actionMenuPresenter.f8791t || iQ > 0);
                boolean z14 = z13;
                i11 = size;
                if (z13) {
                    View viewP2 = actionMenuPresenter.p(gVar2, null, viewGroup);
                    if (actionMenuPresenter.f8791t) {
                        int iQ2 = ActionMenuView.q(viewP2, i10, iQ, iMakeMeasureSpec, 0);
                        iQ -= iQ2;
                        if (iQ2 == 0) {
                            z14 = false;
                        }
                    } else {
                        viewP2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z15 = z14;
                    int measuredWidth2 = viewP2.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i20 == 0) {
                        i20 = measuredWidth2;
                    }
                    z13 = z15 & (!actionMenuPresenter.f8791t ? i13 + i20 <= 0 : i13 < 0);
                }
                if (z13 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z12) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i21 = 0; i21 < i19; i21++) {
                        androidx.appcompat.view.menu.g gVar3 = arrayListG.get(i21);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i17++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z13) {
                    i17--;
                }
                gVar2.u(z13);
                z10 = false;
            } else {
                z10 = r32;
                i11 = size;
                gVar2.u(z10);
            }
            i19++;
            r32 = z10;
            size = i11;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public void f(Parcelable parcelable) {
        int i10;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).openSubMenuId) > 0 && (menuItemFindItem = this.f8552c.findItem(i10)) != null) {
            g((androidx.appcompat.view.menu.l) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public boolean g(androidx.appcompat.view.menu.l lVar) {
        boolean z10 = false;
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.l lVar2 = lVar;
        while (lVar2.j0() != this.f8552c) {
            lVar2 = (androidx.appcompat.view.menu.l) lVar2.j0();
        }
        View viewB = B(lVar2.getItem());
        if (viewB == null) {
            return false;
        }
        this.f8781D = lVar.getItem().getItemId();
        int size = lVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = lVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f8551b, lVar, viewB);
        this.f8797z = aVar;
        aVar.g(z10);
        this.f8797z.k();
        super.g(lVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable h() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.f8781D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.i
    public void j(Context context, androidx.appcompat.view.menu.e eVar) {
        super.j(context, eVar);
        Resources resources = context.getResources();
        C4155a c4155aB = C4155a.b(context);
        if (!this.f8786o) {
            this.f8785n = c4155aB.h();
        }
        if (!this.f8792u) {
            this.f8787p = c4155aB.c();
        }
        if (!this.f8790s) {
            this.f8789r = c4155aB.d();
        }
        int measuredWidth = this.f8787p;
        if (this.f8785n) {
            if (this.f8782k == null) {
                d dVar = new d(this.f8550a);
                this.f8782k = dVar;
                if (this.f8784m) {
                    dVar.setImageDrawable(this.f8783l);
                    this.f8783l = null;
                    this.f8784m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f8782k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f8782k.getMeasuredWidth();
        } else {
            this.f8782k = null;
        }
        this.f8788q = measuredWidth;
        this.f8794w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void l(androidx.appcompat.view.menu.g gVar, j.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f8558i);
        if (this.f8779B == null) {
            this.f8779B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f8779B);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean n(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f8782k) {
            return false;
        }
        return super.n(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.a
    public View p(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.p(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.j q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.j jVar = this.f8558i;
        androidx.appcompat.view.menu.j jVarQ = super.q(viewGroup);
        if (jVar != jVarQ) {
            ((ActionMenuView) jVarQ).setPresenter(this);
        }
        return jVarQ;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean s(int i10, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }
}
