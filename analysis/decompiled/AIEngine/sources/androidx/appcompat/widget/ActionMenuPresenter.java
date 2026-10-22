package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActionMenuPresenter extends androidx.appcompat.view.menu.a {

    /* renamed from: l, reason: collision with root package name */
    public d f596l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f597m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f598n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f599o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f600p;

    /* renamed from: q, reason: collision with root package name */
    public int f601q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f602s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f603t;

    /* renamed from: u, reason: collision with root package name */
    public final SparseBooleanArray f604u;

    /* renamed from: v, reason: collision with root package name */
    public e f605v;

    /* renamed from: w, reason: collision with root package name */
    public a f606w;

    /* renamed from: x, reason: collision with root package name */
    public c f607x;

    /* renamed from: y, reason: collision with root package name */
    public b f608y;
    public final f z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, R.attr.actionOverflowMenuStyle, 0);
            if ((mVar.E.A & 32) != 32) {
                View view2 = ActionMenuPresenter.this.f596l;
                this.f526e = view2 == null ? (View) ActionMenuPresenter.this.f436k : view2;
            }
            f fVar = ActionMenuPresenter.this.z;
            this.h = fVar;
            l.d dVar = this.f529i;
            if (dVar != null) {
                dVar.d(fVar);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f606w = null;
            actionMenuPresenter.getClass();
            super.c();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final e f611a;

        public c(e eVar) {
            this.f611a = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a aVar;
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f432c;
            if (fVar != null && (aVar = fVar.f482e) != null) {
                aVar.b(fVar);
            }
            View view = (View) actionMenuPresenter.f436k;
            if (view != null && view.getWindowToken() != null) {
                e eVar = this.f611a;
                if (eVar.b()) {
                    actionMenuPresenter.f605v = eVar;
                } else if (eVar.f526e != null) {
                    eVar.d(0, 0, false, false);
                    actionMenuPresenter.f605v = eVar;
                }
            }
            actionMenuPresenter.f607x = null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends p implements ActionMenuView.a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends i0 {
            public a(d dVar) {
                super(dVar);
            }

            @Override // androidx.appcompat.widget.i0
            public final l.f b() {
                e eVar = ActionMenuPresenter.this.f605v;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // androidx.appcompat.widget.i0
            public final boolean c() {
                ActionMenuPresenter.this.l();
                return true;
            }

            @Override // androidx.appcompat.widget.i0
            public final boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f607x != null) {
                    return false;
                }
                actionMenuPresenter.j();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            c1.a(this, getContentDescription());
            setOnTouchListener(new a(this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean b() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.l();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.f fVar, View view) {
            super(context, fVar, view, true, R.attr.actionOverflowMenuStyle, 0);
            this.f527f = 8388613;
            f fVar2 = ActionMenuPresenter.this.z;
            this.h = fVar2;
            l.d dVar = this.f529i;
            if (dVar != null) {
                dVar.d(fVar2);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f432c;
            if (fVar != null) {
                fVar.c(true);
            }
            actionMenuPresenter.f605v = null;
            super.c();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f implements j.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
            if (fVar instanceof androidx.appcompat.view.menu.m) {
                ((androidx.appcompat.view.menu.m) fVar).D.k().c(false);
            }
            j.a aVar = ActionMenuPresenter.this.f434e;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            if (fVar == actionMenuPresenter.f432c) {
                return false;
            }
            ((androidx.appcompat.view.menu.m) fVar).E.getClass();
            actionMenuPresenter.getClass();
            j.a aVar = actionMenuPresenter.f434e;
            if (aVar != null) {
                return aVar.b(fVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        this.f430a = context;
        this.f433d = LayoutInflater.from(context);
        this.h = R.layout.abc_action_menu_layout;
        this.f435j = R.layout.abc_action_menu_item_layout;
        this.f604u = new SparseBooleanArray();
        this.z = new f();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
        j();
        a aVar = this.f606w;
        if (aVar != null && aVar.b()) {
            aVar.f529i.dismiss();
        }
        j.a aVar2 = this.f434e;
        if (aVar2 != null) {
            aVar2.a(fVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final void b() {
        int i10;
        ViewGroup viewGroup = (ViewGroup) this.f436k;
        ArrayList<androidx.appcompat.view.menu.h> arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            androidx.appcompat.view.menu.f fVar = this.f432c;
            if (fVar != null) {
                fVar.i();
                ArrayList<androidx.appcompat.view.menu.h> arrayListL = this.f432c.l();
                int size = arrayListL.size();
                i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    androidx.appcompat.view.menu.h hVar = arrayListL.get(i11);
                    if ((hVar.A & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i10);
                        androidx.appcompat.view.menu.h itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View viewI = i(hVar, childAt, viewGroup);
                        if (hVar != itemData) {
                            viewI.setPressed(false);
                            viewI.jumpDrawablesToCurrentState();
                        }
                        if (viewI != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewI.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewI);
                            }
                            ((ViewGroup) this.f436k).addView(viewI, i10);
                        }
                        i10++;
                    }
                }
            } else {
                i10 = 0;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i10) == this.f596l) {
                    i10++;
                } else {
                    viewGroup.removeViewAt(i10);
                }
            }
        }
        ((View) this.f436k).requestLayout();
        androidx.appcompat.view.menu.f fVar2 = this.f432c;
        if (fVar2 != null) {
            fVar2.i();
            ArrayList<androidx.appcompat.view.menu.h> arrayList2 = fVar2.f485l;
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                v0.b bVar = arrayList2.get(i12).D;
            }
        }
        androidx.appcompat.view.menu.f fVar3 = this.f432c;
        if (fVar3 != null) {
            fVar3.i();
            arrayList = fVar3.f486m;
        }
        if (this.f599o && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !arrayList.get(0).F;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.f596l == null) {
                this.f596l = new d(this.f430a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f596l.getParent();
            if (viewGroup3 != this.f436k) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f596l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f436k;
                d dVar = this.f596l;
                actionMenuView.getClass();
                ActionMenuView.c cVarL = ActionMenuView.l();
                cVarL.f624a = true;
                actionMenuView.addView(dVar, cVarL);
            }
        } else {
            d dVar2 = this.f596l;
            if (dVar2 != null) {
                Object parent = dVar2.getParent();
                Object obj = this.f436k;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f596l);
                }
            }
        }
        ((ActionMenuView) this.f436k).setOverflowReserved(this.f599o);
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c() {
        ArrayList<androidx.appcompat.view.menu.h> arrayListL;
        int size;
        boolean z;
        boolean z3;
        boolean z10;
        boolean z11;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.f fVar = actionMenuPresenter.f432c;
        View view = null;
        boolean z12 = false;
        if (fVar != null) {
            arrayListL = fVar.l();
            size = arrayListL.size();
        } else {
            arrayListL = null;
            size = 0;
        }
        int i10 = actionMenuPresenter.f602s;
        int i11 = actionMenuPresenter.r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f436k;
        int i12 = 0;
        boolean z13 = false;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            z = true;
            if (i12 >= size) {
                break;
            }
            androidx.appcompat.view.menu.h hVar = arrayListL.get(i12);
            if (hVar.requiresActionButton()) {
                i13++;
                z11 = z13;
            } else if ((hVar.B & 1) == 1) {
                i14++;
                z11 = z13;
            } else {
                z11 = true;
            }
            if (actionMenuPresenter.f603t && hVar.F) {
                i10 = 0;
            }
            i12++;
            z13 = z11;
        }
        if (actionMenuPresenter.f599o && (z13 || i14 + i13 > i10)) {
            i10--;
        }
        int i15 = i10 - i13;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f604u;
        sparseBooleanArray.clear();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size) {
            androidx.appcompat.view.menu.h hVar2 = arrayListL.get(i16);
            boolean zRequiresActionButton = hVar2.requiresActionButton();
            int i18 = hVar2.f502b;
            if (zRequiresActionButton) {
                View viewI = actionMenuPresenter.i(hVar2, view, viewGroup);
                viewI.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewI.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                if (i18 != 0) {
                    sparseBooleanArray.put(i18, z);
                }
                hVar2.f(z);
                z3 = z12;
                z10 = z ? 1 : 0;
            } else if ((hVar2.B & (z ? 1 : 0)) == z) {
                boolean z14 = sparseBooleanArray.get(i18);
                boolean z15 = ((i15 > 0 || z14) && i11 > 0) ? z ? 1 : 0 : z12;
                if (z15) {
                    View viewI2 = actionMenuPresenter.i(hVar2, view, viewGroup);
                    viewI2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewI2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z15 &= i11 + i17 > 0 ? z ? 1 : 0 : false;
                }
                boolean z16 = z15;
                if (z16 && i18 != 0) {
                    sparseBooleanArray.put(i18, z);
                } else if (z14) {
                    sparseBooleanArray.put(i18, false);
                    int i19 = 0;
                    while (i19 < i16) {
                        androidx.appcompat.view.menu.h hVar3 = arrayListL.get(i19);
                        boolean z17 = z ? 1 : 0;
                        if (hVar3.f502b == i18) {
                            if ((hVar3.A & 32) == 32) {
                                i15++;
                            }
                            hVar3.f(false);
                        }
                        i19++;
                        z = z17;
                    }
                }
                z10 = z;
                if (z16) {
                    i15--;
                }
                hVar2.f(z16);
                z3 = false;
            } else {
                z3 = z12;
                z10 = z ? 1 : 0;
                hVar2.f(z3);
            }
            i16++;
            z12 = z3;
            z = z10;
            view = null;
            actionMenuPresenter = this;
        }
        return z ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public final boolean f(androidx.appcompat.view.menu.m mVar) {
        boolean z;
        if (mVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.m mVar2 = mVar;
            while (true) {
                androidx.appcompat.view.menu.f fVar = mVar2.D;
                if (fVar == this.f432c) {
                    break;
                }
                mVar2 = (androidx.appcompat.view.menu.m) fVar;
            }
            androidx.appcompat.view.menu.h hVar = mVar2.E;
            ViewGroup viewGroup = (ViewGroup) this.f436k;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i10 = 0;
                while (true) {
                    if (i10 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i10);
                    if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == hVar) {
                        view = childAt;
                        break;
                    }
                    i10++;
                }
            }
            if (view != null) {
                mVar.E.getClass();
                int size = mVar.h.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = mVar.getItem(i11);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i11++;
                }
                a aVar = new a(this.f431b, mVar, view);
                this.f606w = aVar;
                aVar.f528g = z;
                l.d dVar = aVar.f529i;
                if (dVar != null) {
                    dVar.l(z);
                }
                a aVar2 = this.f606w;
                if (!aVar2.b()) {
                    if (aVar2.f526e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    aVar2.d(0, 0, false, false);
                }
                j.a aVar3 = this.f434e;
                if (aVar3 != null) {
                    aVar3.b(mVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void h(Context context, androidx.appcompat.view.menu.f fVar) {
        this.f431b = context;
        LayoutInflater.from(context);
        this.f432c = fVar;
        Resources resources = context.getResources();
        if (!this.f600p) {
            this.f599o = true;
        }
        int i10 = 2;
        this.f601q = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i11 > 600 || ((i11 > 960 && i12 > 720) || (i11 > 720 && i12 > 960))) {
            i10 = 5;
        } else if (i11 >= 500 || ((i11 > 640 && i12 > 480) || (i11 > 480 && i12 > 640))) {
            i10 = 4;
        } else if (i11 >= 360) {
            i10 = 3;
        }
        this.f602s = i10;
        int measuredWidth = this.f601q;
        if (this.f599o) {
            if (this.f596l == null) {
                d dVar = new d(this.f430a);
                this.f596l = dVar;
                if (this.f598n) {
                    dVar.setImageDrawable(this.f597m);
                    this.f597m = null;
                    this.f598n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f596l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f596l.getMeasuredWidth();
        } else {
            this.f596l = null;
        }
        this.r = measuredWidth;
        float f8 = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.appcompat.view.menu.k$a] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final View i(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof k.a ? (k.a) view : (k.a) this.f433d.inflate(this.f435j, viewGroup, false);
            actionMenuItemView.d(hVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f436k);
            if (this.f608y == null) {
                this.f608y = new b();
            }
            actionMenuItemView2.setPopupCallback(this.f608y);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(hVar.F ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.c)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
        }
        return actionView;
    }

    public final boolean j() {
        Object obj;
        c cVar = this.f607x;
        if (cVar != null && (obj = this.f436k) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f607x = null;
            return true;
        }
        e eVar = this.f605v;
        if (eVar == null) {
            return false;
        }
        if (eVar.b()) {
            eVar.f529i.dismiss();
        }
        return true;
    }

    public final boolean k() {
        e eVar = this.f605v;
        return eVar != null && eVar.b();
    }

    public final boolean l() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.f599o || k() || (fVar = this.f432c) == null || this.f436k == null || this.f607x != null) {
            return false;
        }
        fVar.i();
        if (fVar.f486m.isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f431b, this.f432c, this.f596l));
        this.f607x = cVar;
        ((View) this.f436k).post(cVar);
        return true;
    }
}
