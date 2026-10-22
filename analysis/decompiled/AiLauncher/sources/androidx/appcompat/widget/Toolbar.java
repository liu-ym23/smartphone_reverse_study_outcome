package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.C1321i;
import androidx.core.view.C1328p;
import androidx.core.view.InterfaceC1325m;
import androidx.customview.view.AbsSavedState;
import f.C4027a;
import i.InterfaceC4157c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC1325m {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f9079A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f9080B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f9081C;

    /* renamed from: D, reason: collision with root package name */
    public final ArrayList<View> f9082D;

    /* renamed from: E, reason: collision with root package name */
    public final ArrayList<View> f9083E;

    /* renamed from: F, reason: collision with root package name */
    public final int[] f9084F;

    /* renamed from: G, reason: collision with root package name */
    public final C1328p f9085G;

    /* renamed from: H, reason: collision with root package name */
    public ArrayList<MenuItem> f9086H;

    /* renamed from: I, reason: collision with root package name */
    public h f9087I;

    /* renamed from: J, reason: collision with root package name */
    public final ActionMenuView.e f9088J;

    /* renamed from: K, reason: collision with root package name */
    public Y f9089K;

    /* renamed from: L, reason: collision with root package name */
    public ActionMenuPresenter f9090L;

    /* renamed from: M, reason: collision with root package name */
    public f f9091M;

    /* renamed from: N, reason: collision with root package name */
    public i.a f9092N;

    /* renamed from: O, reason: collision with root package name */
    public e.a f9093O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f9094P;

    /* renamed from: Q, reason: collision with root package name */
    public OnBackInvokedCallback f9095Q;

    /* renamed from: R, reason: collision with root package name */
    public OnBackInvokedDispatcher f9096R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f9097S;

    /* renamed from: T, reason: collision with root package name */
    public final Runnable f9098T;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f9099a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f9100b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f9101c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f9102d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f9103e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f9104f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f9105g;

    /* renamed from: h, reason: collision with root package name */
    public ImageButton f9106h;

    /* renamed from: i, reason: collision with root package name */
    public View f9107i;

    /* renamed from: j, reason: collision with root package name */
    public Context f9108j;

    /* renamed from: k, reason: collision with root package name */
    public int f9109k;

    /* renamed from: l, reason: collision with root package name */
    public int f9110l;

    /* renamed from: m, reason: collision with root package name */
    public int f9111m;

    /* renamed from: n, reason: collision with root package name */
    public int f9112n;

    /* renamed from: o, reason: collision with root package name */
    public int f9113o;

    /* renamed from: p, reason: collision with root package name */
    public int f9114p;

    /* renamed from: q, reason: collision with root package name */
    public int f9115q;

    /* renamed from: r, reason: collision with root package name */
    public int f9116r;

    /* renamed from: s, reason: collision with root package name */
    public int f9117s;

    /* renamed from: t, reason: collision with root package name */
    public L f9118t;

    /* renamed from: u, reason: collision with root package name */
    public int f9119u;

    /* renamed from: v, reason: collision with root package name */
    public int f9120v;

    /* renamed from: w, reason: collision with root package name */
    public int f9121w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f9122x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f9123y;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f9124z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f9085G.h(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.f9087I;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.Q();
        }
    }

    public class c implements e.a {
        public c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.f9093O;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f9099a.o()) {
                Toolbar.this.f9085G.i(eVar);
            }
            e.a aVar = Toolbar.this.f9093O;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.X
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class f implements androidx.appcompat.view.menu.i {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f9129a;

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f9130b;

        public f() {
        }

        @Override // androidx.appcompat.view.menu.i
        public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.i
        public void b(boolean z10) {
            if (this.f9130b != null) {
                androidx.appcompat.view.menu.e eVar = this.f9129a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f9129a.getItem(i10) == this.f9130b) {
                            return;
                        }
                    }
                }
                i(this.f9129a, this.f9130b);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean d(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f9106h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f9106h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f9106h);
            }
            Toolbar.this.f9107i = gVar.getActionView();
            this.f9130b = gVar;
            ViewParent parent2 = Toolbar.this.f9107i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f9107i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f8416a = (toolbar4.f9112n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f9132b = 2;
                toolbar4.f9107i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f9107i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f9107i;
            if (callback instanceof InterfaceC4157c) {
                ((InterfaceC4157c) callback).onActionViewExpanded();
            }
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.i
        public void f(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean g(androidx.appcompat.view.menu.l lVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.i
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.i
        public Parcelable h() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.i
        public boolean i(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f9107i;
            if (callback instanceof InterfaceC4157c) {
                ((InterfaceC4157c) callback).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f9107i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f9106h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f9107i = null;
            toolbar3.a();
            this.f9130b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.i
        public void j(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f9129a;
            if (eVar2 != null && (gVar = this.f9130b) != null) {
                eVar2.f(gVar);
            }
            this.f9129a = eVar;
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i.g(getContext());
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f9099a;
        return actionMenuView != null && actionMenuView.n();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f9099a;
        return actionMenuView != null && actionMenuView.o();
    }

    public final int C(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int iQ = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    public final int D(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int iQ = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public final int E(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + iMax + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void F(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f9085G.f(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f9086H = currentMenuItems2;
    }

    public final void H() {
        removeCallbacks(this.f9098T);
        post(this.f9098T);
    }

    public void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f9132b != 2 && childAt != this.f9099a) {
                removeViewAt(childCount);
                this.f9083E.add(childAt);
            }
        }
    }

    public void J(int i10, int i11) {
        h();
        this.f9118t.g(i10, i11);
    }

    public void K(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar == null && this.f9099a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarS = this.f9099a.s();
        if (eVarS == eVar) {
            return;
        }
        if (eVarS != null) {
            eVarS.R(this.f9090L);
            eVarS.R(this.f9091M);
        }
        if (this.f9091M == null) {
            this.f9091M = new f();
        }
        actionMenuPresenter.I(true);
        if (eVar != null) {
            eVar.c(actionMenuPresenter, this.f9108j);
            eVar.c(this.f9091M, this.f9108j);
        } else {
            actionMenuPresenter.j(this.f9108j, null);
            this.f9091M.j(this.f9108j, null);
            actionMenuPresenter.b(true);
            this.f9091M.b(true);
        }
        this.f9099a.setPopupTheme(this.f9109k);
        this.f9099a.setPresenter(actionMenuPresenter);
        this.f9090L = actionMenuPresenter;
        R();
    }

    public void L(i.a aVar, e.a aVar2) {
        this.f9092N = aVar;
        this.f9093O = aVar2;
        ActionMenuView actionMenuView = this.f9099a;
        if (actionMenuView != null) {
            actionMenuView.t(aVar, aVar2);
        }
    }

    public void M(Context context, int i10) {
        this.f9111m = i10;
        TextView textView = this.f9101c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void N(Context context, int i10) {
        this.f9110l = i10;
        TextView textView = this.f9100b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public final boolean O() {
        if (!this.f9094P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f9099a;
        return actionMenuView != null && actionMenuView.u();
    }

    public void R() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
        boolean z10 = v() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f9097S;
        if (z10 && this.f9096R == null) {
            if (this.f9095Q == null) {
                this.f9095Q = e.b(new Runnable() { // from class: androidx.appcompat.widget.V
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9136a.e();
                    }
                });
            }
            e.c(onBackInvokedDispatcherA, this.f9095Q);
            this.f9096R = onBackInvokedDispatcherA;
            return;
        }
        if (z10 || (onBackInvokedDispatcher = this.f9096R) == null) {
            return;
        }
        e.d(onBackInvokedDispatcher, this.f9095Q);
        this.f9096R = null;
    }

    public void a() {
        for (int size = this.f9083E.size() - 1; size >= 0; size--) {
            addView(this.f9083E.get(size));
        }
        this.f9083E.clear();
    }

    @Override // androidx.core.view.InterfaceC1325m
    public void addMenuProvider(androidx.core.view.r rVar) {
        this.f9085G.c(rVar);
    }

    public final void b(List<View> list, int i10) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = C1321i.b(i10, getLayoutDirection());
        list.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f9132b == 0 && P(childAt) && p(gVar.f8416a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f9132b == 0 && P(childAt2) && p(gVar2.f8416a) == iB) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f9132b = 1;
        if (!z10 || this.f9107i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f9083E.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f9099a) != null && actionMenuView.p();
    }

    public void e() {
        f fVar = this.f9091M;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f9130b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f9099a;
        if (actionMenuView != null) {
            actionMenuView.g();
        }
    }

    public void g() {
        if (this.f9106h == null) {
            C1299l c1299l = new C1299l(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f9106h = c1299l;
            c1299l.setImageDrawable(this.f9104f);
            this.f9106h.setContentDescription(this.f9105g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f8416a = (this.f9112n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f9132b = 2;
            this.f9106h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f9106h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f9106h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f9106h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        L l10 = this.f9118t;
        if (l10 != null) {
            return l10.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f9120v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        L l10 = this.f9118t;
        if (l10 != null) {
            return l10.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        L l10 = this.f9118t;
        if (l10 != null) {
            return l10.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        L l10 = this.f9118t;
        if (l10 != null) {
            return l10.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f9119u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarS;
        ActionMenuView actionMenuView = this.f9099a;
        return (actionMenuView == null || (eVarS = actionMenuView.s()) == null || !eVarS.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f9120v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f9119u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f9103e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f9103e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f9099a.getMenu();
    }

    public View getNavButtonView() {
        return this.f9102d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f9102d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f9102d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f9090L;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f9099a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f9108j;
    }

    public int getPopupTheme() {
        return this.f9109k;
    }

    public CharSequence getSubtitle() {
        return this.f9123y;
    }

    public final TextView getSubtitleTextView() {
        return this.f9101c;
    }

    public CharSequence getTitle() {
        return this.f9122x;
    }

    public int getTitleMarginBottom() {
        return this.f9117s;
    }

    public int getTitleMarginEnd() {
        return this.f9115q;
    }

    public int getTitleMarginStart() {
        return this.f9114p;
    }

    public int getTitleMarginTop() {
        return this.f9116r;
    }

    public final TextView getTitleTextView() {
        return this.f9100b;
    }

    public A getWrapper() {
        if (this.f9089K == null) {
            this.f9089K = new Y(this, true);
        }
        return this.f9089K;
    }

    public final void h() {
        if (this.f9118t == null) {
            this.f9118t = new L();
        }
    }

    public final void i() {
        if (this.f9103e == null) {
            this.f9103e = new AppCompatImageView(getContext());
        }
    }

    public final void j() {
        k();
        if (this.f9099a.s() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f9099a.getMenu();
            if (this.f9091M == null) {
                this.f9091M = new f();
            }
            this.f9099a.setExpandedActionViewsExclusive(true);
            eVar.c(this.f9091M, this.f9108j);
            R();
        }
    }

    public final void k() {
        if (this.f9099a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f9099a = actionMenuView;
            actionMenuView.setPopupTheme(this.f9109k);
            this.f9099a.setOnMenuItemClickListener(this.f9088J);
            this.f9099a.t(this.f9092N, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f8416a = (this.f9112n & 112) | 8388613;
            this.f9099a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f9099a, false);
        }
    }

    public final void l() {
        if (this.f9102d == null) {
            this.f9102d = new C1299l(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f8416a = (this.f9112n & 112) | 8388611;
            this.f9102d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof a.C0127a ? new g((a.C0127a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f9098T);
        R();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f9081C = false;
        }
        if (!this.f9081C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f9081C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f9081C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0297 A[LOOP:0: B:104:0x0295->B:105:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b5 A[LOOP:1: B:107:0x02b3->B:108:0x02b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ec A[LOOP:2: B:116:0x02ea->B:117:0x02ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.f9084F;
        boolean zB = b0.b(this);
        int i12 = !zB ? 1 : 0;
        if (P(this.f9102d)) {
            F(this.f9102d, i10, 0, i11, 0, this.f9113o);
            measuredWidth = this.f9102d.getMeasuredWidth() + s(this.f9102d);
            iMax = Math.max(0, this.f9102d.getMeasuredHeight() + t(this.f9102d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f9102d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (P(this.f9106h)) {
            F(this.f9106h, i10, 0, i11, 0, this.f9113o);
            measuredWidth = this.f9106h.getMeasuredWidth() + s(this.f9106h);
            iMax = Math.max(iMax, this.f9106h.getMeasuredHeight() + t(this.f9106h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f9106h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (P(this.f9099a)) {
            F(this.f9099a, i10, iMax3, i11, 0, this.f9113o);
            measuredWidth2 = this.f9099a.getMeasuredWidth() + s(this.f9099a);
            iMax = Math.max(iMax, this.f9099a.getMeasuredHeight() + t(this.f9099a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f9099a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i12] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (P(this.f9107i)) {
            iArr = iArr2;
            iMax4 += E(this.f9107i, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f9107i.getMeasuredHeight() + t(this.f9107i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f9107i.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (P(this.f9103e)) {
            iMax4 += E(this.f9103e, i10, iMax4, i11, 0, iArr);
            iMax = Math.max(iMax, this.f9103e.getMeasuredHeight() + t(this.f9103e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f9103e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((g) childAt.getLayoutParams()).f9132b == 0 && P(childAt)) {
                iMax4 += E(childAt, i10, iMax4, i11, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i14 = iMax4;
        int i15 = this.f9116r + this.f9117s;
        int i16 = this.f9114p + this.f9115q;
        if (P(this.f9100b)) {
            E(this.f9100b, i10, i14 + i16, i11, i15, iArr);
            int measuredWidth3 = this.f9100b.getMeasuredWidth() + s(this.f9100b);
            int measuredHeight2 = this.f9100b.getMeasuredHeight() + t(this.f9100b);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f9100b.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (P(this.f9101c)) {
            iMax2 = Math.max(iMax2, E(this.f9101c, i10, i14 + i16, i11, i15 + measuredHeight, iArr));
            measuredHeight += this.f9101c.getMeasuredHeight() + t(this.f9101c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f9101c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i14 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, (-16777216) & iCombineMeasuredStates2), O() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f9099a;
        androidx.appcompat.view.menu.e eVarS = actionMenuView != null ? actionMenuView.s() : null;
        int i10 = savedState.expandedMenuItemId;
        if (i10 != 0 && this.f9091M != null && eVarS != null && (menuItemFindItem = eVarS.findItem(i10)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        h();
        this.f9118t.f(i10 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.f9091M;
        if (fVar != null && (gVar = fVar.f9130b) != null) {
            savedState.expandedMenuItemId = gVar.getItemId();
        }
        savedState.isOverflowOpen = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f9080B = false;
        }
        if (!this.f9080B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f9080B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f9080B = false;
        }
        return true;
    }

    public final int p(int i10) {
        int layoutDirection = getLayoutDirection();
        int iB = C1321i.b(i10, layoutDirection) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : layoutDirection == 1 ? 5 : 3;
    }

    public final int q(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int iR = r(gVar.f8416a);
        if (iR == 48) {
            return getPaddingTop() - i11;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public final int r(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f9121w & 112;
    }

    @Override // androidx.core.view.InterfaceC1325m
    public void removeMenuProvider(androidx.core.view.r rVar) {
        this.f9085G.j(rVar);
    }

    public final int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f9097S != z10) {
            this.f9097S = z10;
            R();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(C4027a.b(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.f9094P = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f9120v) {
            this.f9120v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f9119u) {
            this.f9119u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(C4027a.b(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(C4027a.b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f9102d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.f9087I = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f9099a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f9109k != i10) {
            this.f9109k = i10;
            if (i10 == 0) {
                this.f9108j = getContext();
            } else {
                this.f9108j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f9117s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f9115q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f9114p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f9116r = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public final int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int u(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int measuredWidth = 0;
        while (i12 < size) {
            View view = list.get(i12);
            g gVar = (g) view.getLayoutParams();
            int i13 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i10;
            int i14 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i11;
            int iMax = Math.max(0, i13);
            int iMax2 = Math.max(0, i14);
            int iMax3 = Math.max(0, -i13);
            int iMax4 = Math.max(0, -i14);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i12++;
            i11 = iMax4;
            i10 = iMax3;
        }
        return measuredWidth;
    }

    public boolean v() {
        f fVar = this.f9091M;
        return (fVar == null || fVar.f9130b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f9099a;
        return actionMenuView != null && actionMenuView.m();
    }

    public void x(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public void y() {
        Iterator<MenuItem> it = this.f9086H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    public final boolean z(View view) {
        return view.getParent() == this || this.f9083E.contains(view);
    }

    public static class g extends a.C0127a {

        /* renamed from: b, reason: collision with root package name */
        public int f9132b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9132b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i10, int i11) {
            super(i10, i11);
            this.f9132b = 0;
            this.f8416a = 8388627;
        }

        public g(g gVar) {
            super((a.C0127a) gVar);
            this.f9132b = 0;
            this.f9132b = gVar.f9132b;
        }

        public g(a.C0127a c0127a) {
            super(c0127a);
            this.f9132b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9132b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9132b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9121w = 8388627;
        this.f9082D = new ArrayList<>();
        this.f9083E = new ArrayList<>();
        this.f9084F = new int[2];
        this.f9085G = new C1328p(new Runnable() { // from class: androidx.appcompat.widget.W
            @Override // java.lang.Runnable
            public final void run() {
                this.f9141a.y();
            }
        });
        this.f9086H = new ArrayList<>();
        this.f9088J = new a();
        this.f9098T = new b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        U uV = U.v(context2, attributeSet, iArr, i10, 0);
        androidx.core.view.N.g0(this, context, iArr, attributeSet, uV.r(), i10, 0);
        this.f9110l = uV.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f9111m = uV.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f9121w = uV.l(R$styleable.Toolbar_android_gravity, this.f9121w);
        this.f9112n = uV.l(R$styleable.Toolbar_buttonGravity, 48);
        int iE = uV.e(R$styleable.Toolbar_titleMargin, 0);
        int i11 = R$styleable.Toolbar_titleMargins;
        iE = uV.s(i11) ? uV.e(i11, iE) : iE;
        this.f9117s = iE;
        this.f9116r = iE;
        this.f9115q = iE;
        this.f9114p = iE;
        int iE2 = uV.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.f9114p = iE2;
        }
        int iE3 = uV.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.f9115q = iE3;
        }
        int iE4 = uV.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.f9116r = iE4;
        }
        int iE5 = uV.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.f9117s = iE5;
        }
        this.f9113o = uV.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int iE6 = uV.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = uV.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iF = uV.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int iF2 = uV.f(R$styleable.Toolbar_contentInsetRight, 0);
        h();
        this.f9118t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.f9118t.g(iE6, iE7);
        }
        this.f9119u = uV.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f9120v = uV.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f9104f = uV.g(R$styleable.Toolbar_collapseIcon);
        this.f9105g = uV.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = uV.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = uV.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.f9108j = getContext();
        setPopupTheme(uV.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableG = uV.g(R$styleable.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = uV.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = uV.g(R$styleable.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = uV.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i12 = R$styleable.Toolbar_titleTextColor;
        if (uV.s(i12)) {
            setTitleTextColor(uV.c(i12));
        }
        int i13 = R$styleable.Toolbar_subtitleTextColor;
        if (uV.s(i13)) {
            setSubtitleTextColor(uV.c(i13));
        }
        int i14 = R$styleable.Toolbar_menu;
        if (uV.s(i14)) {
            x(uV.n(i14, 0));
        }
        uV.x();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f9106h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f9106h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f9106h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f9104f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f9103e)) {
                c(this.f9103e, true);
            }
        } else {
            ImageView imageView = this.f9103e;
            if (imageView != null && z(imageView)) {
                removeView(this.f9103e);
                this.f9083E.remove(this.f9103e);
            }
        }
        ImageView imageView2 = this.f9103e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f9103e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f9102d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            Z.a(this.f9102d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f9102d)) {
                c(this.f9102d, true);
            }
        } else {
            ImageButton imageButton = this.f9102d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f9102d);
                this.f9083E.remove(this.f9102d);
            }
        }
        ImageButton imageButton2 = this.f9102d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f9101c;
            if (textView != null && z(textView)) {
                removeView(this.f9101c);
                this.f9083E.remove(this.f9101c);
            }
        } else {
            if (this.f9101c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f9101c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f9101c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f9111m;
                if (i10 != 0) {
                    this.f9101c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f9079A;
                if (colorStateList != null) {
                    this.f9101c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f9101c)) {
                c(this.f9101c, true);
            }
        }
        TextView textView2 = this.f9101c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f9123y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f9079A = colorStateList;
        TextView textView = this.f9101c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f9100b;
            if (textView != null && z(textView)) {
                removeView(this.f9100b);
                this.f9083E.remove(this.f9100b);
            }
        } else {
            if (this.f9100b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f9100b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f9100b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f9110l;
                if (i10 != 0) {
                    this.f9100b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f9124z;
                if (colorStateList != null) {
                    this.f9100b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f9100b)) {
                c(this.f9100b, true);
            }
        }
        TextView textView2 = this.f9100b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f9122x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f9124z = colorStateList;
        TextView textView = this.f9100b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
