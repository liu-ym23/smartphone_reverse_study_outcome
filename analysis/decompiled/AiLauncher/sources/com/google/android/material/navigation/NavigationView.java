package com.google.android.material.navigation;

import G2.a;
import T2.g;
import Z2.h;
import Z2.i;
import Z2.l;
import Z2.p;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.U;
import androidx.core.view.a0;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import b.C1423c;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.internal.r;
import com.google.android.material.internal.w;
import d3.C3953a;
import f.C4027a;
import java.util.Objects;

/* loaded from: classes2.dex */
public class NavigationView extends n implements T2.b {

    /* renamed from: h, reason: collision with root package name */
    public final k f21162h;

    /* renamed from: i, reason: collision with root package name */
    public final l f21163i;

    /* renamed from: j, reason: collision with root package name */
    public final int f21164j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f21165k;

    /* renamed from: l, reason: collision with root package name */
    public MenuInflater f21166l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f21167m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21168n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21169o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21170p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21171q;

    /* renamed from: r, reason: collision with root package name */
    public int f21172r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f21173s;

    /* renamed from: t, reason: collision with root package name */
    public final int f21174t;

    /* renamed from: u, reason: collision with root package name */
    public final p f21175u;

    /* renamed from: v, reason: collision with root package name */
    public final g f21176v;

    /* renamed from: w, reason: collision with root package name */
    public final T2.c f21177w;

    /* renamed from: x, reason: collision with root package name */
    public final DrawerLayout.e f21178x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f21160y = {R.attr.state_checked};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f21161z = {-16842910};

    /* renamed from: A, reason: collision with root package name */
    public static final int f21159A = R$style.Widget_Design_NavigationView;

    public class a extends DrawerLayout.g {
        public a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.g, androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final T2.c cVar = navigationView.f21177w;
                Objects.requireNonNull(cVar);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f21177w.f();
                NavigationView.this.u();
            }
        }
    }

    public class b implements e.a {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f21165k);
            boolean z10 = true;
            boolean z11 = NavigationView.this.f21165k[1] == 0;
            NavigationView.this.f21163i.D(z11);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z11 && navigationView2.t());
            boolean z12 = NavigationView.this.getLayoutDirection() == 1;
            boolean z13 = NavigationView.this.f21165k[0] == 0 || NavigationView.this.f21165k[0] + NavigationView.this.getWidth() == 0;
            NavigationView navigationView3 = NavigationView.this;
            navigationView3.setDrawLeftInsetForeground(z13 && (!z12 ? !navigationView3.s() : !navigationView3.r()));
            Activity activityA = com.google.android.material.internal.b.a(NavigationView.this.getContext());
            if (activityA != null) {
                Rect rectA = w.a(activityA);
                boolean z14 = rectA.height() - NavigationView.this.getHeight() == NavigationView.this.f21165k[1];
                boolean z15 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView4 = NavigationView.this;
                navigationView4.setDrawBottomInsetForeground(z14 && z15 && navigationView4.q());
                boolean z16 = rectA.width() == NavigationView.this.f21165k[0] || rectA.width() - NavigationView.this.getWidth() == NavigationView.this.f21165k[0];
                NavigationView navigationView5 = NavigationView.this;
                if (!z16 || (!z12 ? !navigationView5.r() : !navigationView5.s())) {
                    z10 = false;
                }
                navigationView5.setDrawRightInsetForeground(z10);
            }
        }
    }

    public interface d {
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    private MenuInflater getMenuInflater() {
        if (this.f21166l == null) {
            this.f21166l = new i.g(getContext());
        }
        return this.f21166l;
    }

    @Override // com.google.android.material.internal.n
    public void a(a0 a0Var) {
        this.f21163i.m(a0Var);
    }

    @Override // T2.b
    public void b(C1423c c1423c) {
        w();
        this.f21176v.j(c1423c);
    }

    @Override // T2.b
    public void d() {
        w();
        this.f21176v.f();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f21175u.d(canvas, new a.InterfaceC0037a() { // from class: com.google.android.material.navigation.c
            @Override // G2.a.InterfaceC0037a
            public final void a(Canvas canvas2) {
                super/*android.view.View*/.dispatchDraw(canvas2);
            }
        });
    }

    @Override // T2.b
    public void e(C1423c c1423c) {
        this.f21176v.l(c1423c, ((DrawerLayout.f) w().second).f13662a);
        if (this.f21173s) {
            this.f21172r = E2.a.c(0, this.f21174t, this.f21176v.a(c1423c.getProgress()));
            v(getWidth(), getHeight());
        }
    }

    @Override // T2.b
    public void f() {
        Pair<DrawerLayout, DrawerLayout.f> pairW = w();
        DrawerLayout drawerLayout = (DrawerLayout) pairW.first;
        C1423c c1423cC = this.f21176v.c();
        if (c1423cC == null) {
            drawerLayout.f(this);
            return;
        }
        this.f21176v.h(c1423cC, ((DrawerLayout.f) pairW.second).f13662a, com.google.android.material.navigation.b.b(drawerLayout, this), com.google.android.material.navigation.b.c(drawerLayout));
    }

    public g getBackHelper() {
        return this.f21176v;
    }

    public MenuItem getCheckedItem() {
        return this.f21163i.n();
    }

    public int getDividerInsetEnd() {
        return this.f21163i.o();
    }

    public int getDividerInsetStart() {
        return this.f21163i.p();
    }

    public int getHeaderCount() {
        return this.f21163i.q();
    }

    public Drawable getItemBackground() {
        return this.f21163i.r();
    }

    public int getItemHorizontalPadding() {
        return this.f21163i.s();
    }

    public int getItemIconPadding() {
        return this.f21163i.t();
    }

    public ColorStateList getItemIconTintList() {
        return this.f21163i.w();
    }

    public int getItemMaxLines() {
        return this.f21163i.u();
    }

    public ColorStateList getItemTextColor() {
        return this.f21163i.v();
    }

    public int getItemVerticalPadding() {
        return this.f21163i.x();
    }

    public Menu getMenu() {
        return this.f21162h;
    }

    public int getSubheaderInsetEnd() {
        return this.f21163i.z();
    }

    public int getSubheaderInsetStart() {
        return this.f21163i.A();
    }

    public final ColorStateList k(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = C4027a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f21161z;
        return new ColorStateList(new int[][]{iArr, f21160y, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    public final Drawable l(U u10) {
        return m(u10, W2.c.b(getContext(), u10, R$styleable.NavigationView_itemShapeFillColor));
    }

    public final Drawable m(U u10, ColorStateList colorStateList) {
        h hVar = new h(Z2.l.b(getContext(), u10.n(R$styleable.NavigationView_itemShapeAppearance, 0), u10.n(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        hVar.g0(colorStateList);
        return new InsetDrawable((Drawable) hVar, u10.f(R$styleable.NavigationView_itemShapeInsetStart, 0), u10.f(R$styleable.NavigationView_itemShapeInsetTop, 0), u10.f(R$styleable.NavigationView_itemShapeInsetEnd, 0), u10.f(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    public final boolean n(U u10) {
        return u10.s(R$styleable.NavigationView_itemShapeAppearance) || u10.s(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public View o(int i10) {
        return this.f21163i.C(i10);
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f21177w.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.O(this.f21178x);
            drawerLayout.a(this.f21178x);
            if (drawerLayout.D(this)) {
                this.f21177w.e();
            }
        }
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f21167m);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).O(this.f21178x);
        }
        this.f21177w.f();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.f21164j), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.f21164j, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f21162h.T(savedState.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f21162h.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        v(i10, i11);
    }

    public void p(int i10) {
        this.f21163i.Y(true);
        getMenuInflater().inflate(i10, this.f21162h);
        this.f21163i.Y(false);
        this.f21163i.b(false);
    }

    public boolean q() {
        return this.f21169o;
    }

    public boolean r() {
        return this.f21171q;
    }

    public boolean s() {
        return this.f21170p;
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f21169o = z10;
    }

    public void setCheckedItem(int i10) {
        MenuItem menuItemFindItem = this.f21162h.findItem(i10);
        if (menuItemFindItem != null) {
            this.f21163i.E((androidx.appcompat.view.menu.g) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i10) {
        this.f21163i.F(i10);
    }

    public void setDividerInsetStart(int i10) {
        this.f21163i.G(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        i.d(this, f10);
    }

    public void setEndInsetScrimEnabled(boolean z10) {
        this.f21171q = z10;
    }

    public void setForceCompatClippingEnabled(boolean z10) {
        this.f21175u.g(this, z10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f21163i.I(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(getContext().getDrawable(i10));
    }

    public void setItemHorizontalPadding(int i10) {
        this.f21163i.K(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) {
        this.f21163i.K(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(int i10) {
        this.f21163i.L(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.f21163i.L(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(int i10) {
        this.f21163i.M(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f21163i.N(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f21163i.O(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.f21163i.P(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f21163i.Q(z10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f21163i.R(colorStateList);
    }

    public void setItemVerticalPadding(int i10) {
        this.f21163i.S(i10);
    }

    public void setItemVerticalPaddingResource(int i10) {
        this.f21163i.S(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(d dVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        l lVar = this.f21163i;
        if (lVar != null) {
            lVar.T(i10);
        }
    }

    public void setStartInsetScrimEnabled(boolean z10) {
        this.f21170p = z10;
    }

    public void setSubheaderInsetEnd(int i10) {
        this.f21163i.V(i10);
    }

    public void setSubheaderInsetStart(int i10) {
        this.f21163i.W(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f21168n = z10;
    }

    public boolean t() {
        return this.f21168n;
    }

    public final void u() {
        if (!this.f21173s || this.f21172r == 0) {
            return;
        }
        this.f21172r = 0;
        v(getWidth(), getHeight());
    }

    public final void v(int i10, int i11) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.f21172r > 0 || this.f21173s) && (getBackground() instanceof h)) {
                boolean z10 = Gravity.getAbsoluteGravity(((DrawerLayout.f) getLayoutParams()).f13662a, getLayoutDirection()) == 3;
                h hVar = (h) getBackground();
                l.b bVarO = hVar.I().w().o(this.f21172r);
                if (z10) {
                    bVarO.C(0.0f);
                    bVarO.u(0.0f);
                } else {
                    bVarO.G(0.0f);
                    bVarO.y(0.0f);
                }
                Z2.l lVarM = bVarO.m();
                hVar.setShapeAppearanceModel(lVarM);
                this.f21175u.f(this, lVarM);
                this.f21175u.e(this, new RectF(0.0f, 0.0f, i10, i11));
                this.f21175u.h(this, true);
            }
        }
    }

    public final Pair<DrawerLayout, DrawerLayout.f> w() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public final void x() {
        this.f21167m = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f21167m);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Bundle menuState;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        int i12 = f21159A;
        super(C3953a.d(context, attributeSet, i10, i12), attributeSet, i10);
        com.google.android.material.internal.l lVar = new com.google.android.material.internal.l();
        this.f21163i = lVar;
        this.f21165k = new int[2];
        this.f21168n = true;
        this.f21169o = true;
        this.f21170p = true;
        this.f21171q = true;
        this.f21172r = 0;
        this.f21175u = p.a(this);
        this.f21176v = new g(this);
        this.f21177w = new T2.c(this);
        this.f21178x = new a();
        Context context2 = getContext();
        k kVar = new k(context2);
        this.f21162h = kVar;
        U uJ = r.j(context2, attributeSet, R$styleable.NavigationView, i10, i12, new int[0]);
        int i13 = R$styleable.NavigationView_android_background;
        if (uJ.s(i13)) {
            setBackground(uJ.g(i13));
        }
        int iF = uJ.f(R$styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.f21172r = iF;
        this.f21173s = iF == 0;
        this.f21174t = getResources().getDimensionPixelSize(R$dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListF = O2.a.f(background);
        if (background == null || colorStateListF != null) {
            h hVar = new h(Z2.l.e(context2, attributeSet, i10, i12).m());
            if (colorStateListF != null) {
                hVar.g0(colorStateListF);
            }
            hVar.U(context2);
            setBackground(hVar);
        }
        if (uJ.s(R$styleable.NavigationView_elevation)) {
            setElevation(uJ.f(r2, 0));
        }
        setFitsSystemWindows(uJ.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.f21164j = uJ.f(R$styleable.NavigationView_android_maxWidth, 0);
        int i14 = R$styleable.NavigationView_subheaderColor;
        ColorStateList colorStateListC = uJ.s(i14) ? uJ.c(i14) : null;
        int i15 = R$styleable.NavigationView_subheaderTextAppearance;
        int iN = uJ.s(i15) ? uJ.n(i15, 0) : 0;
        if (iN == 0 && colorStateListC == null) {
            colorStateListC = k(R.attr.textColorSecondary);
        }
        int i16 = R$styleable.NavigationView_itemIconTint;
        ColorStateList colorStateListC2 = uJ.s(i16) ? uJ.c(i16) : k(R.attr.textColorSecondary);
        int i17 = R$styleable.NavigationView_itemTextAppearance;
        int iN2 = uJ.s(i17) ? uJ.n(i17, 0) : 0;
        boolean zA = uJ.a(R$styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        int i18 = R$styleable.NavigationView_itemIconSize;
        if (uJ.s(i18)) {
            setItemIconSize(uJ.f(i18, 0));
        }
        int i19 = R$styleable.NavigationView_itemTextColor;
        ColorStateList colorStateListC3 = uJ.s(i19) ? uJ.c(i19) : null;
        if (iN2 == 0 && colorStateListC3 == null) {
            colorStateListC3 = k(R.attr.textColorPrimary);
        }
        Drawable drawableG = uJ.g(R$styleable.NavigationView_itemBackground);
        if (drawableG == null && n(uJ)) {
            drawableG = l(uJ);
            ColorStateList colorStateListB = W2.c.b(context2, uJ, R$styleable.NavigationView_itemRippleColor);
            if (colorStateListB != null) {
                lVar.J(new RippleDrawable(X2.a.d(colorStateListB), null, m(uJ, null)));
            }
        }
        int i20 = R$styleable.NavigationView_itemHorizontalPadding;
        if (uJ.s(i20)) {
            i11 = 0;
            setItemHorizontalPadding(uJ.f(i20, 0));
        } else {
            i11 = 0;
        }
        int i21 = R$styleable.NavigationView_itemVerticalPadding;
        if (uJ.s(i21)) {
            setItemVerticalPadding(uJ.f(i21, i11));
        }
        setDividerInsetStart(uJ.f(R$styleable.NavigationView_dividerInsetStart, i11));
        setDividerInsetEnd(uJ.f(R$styleable.NavigationView_dividerInsetEnd, i11));
        setSubheaderInsetStart(uJ.f(R$styleable.NavigationView_subheaderInsetStart, i11));
        setSubheaderInsetEnd(uJ.f(R$styleable.NavigationView_subheaderInsetEnd, i11));
        setTopInsetScrimEnabled(uJ.a(R$styleable.NavigationView_topInsetScrimEnabled, this.f21168n));
        setBottomInsetScrimEnabled(uJ.a(R$styleable.NavigationView_bottomInsetScrimEnabled, this.f21169o));
        setStartInsetScrimEnabled(uJ.a(R$styleable.NavigationView_startInsetScrimEnabled, this.f21170p));
        setEndInsetScrimEnabled(uJ.a(R$styleable.NavigationView_endInsetScrimEnabled, this.f21171q));
        int iF2 = uJ.f(R$styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(uJ.k(R$styleable.NavigationView_itemMaxLines, 1));
        kVar.W(new b());
        lVar.H(1);
        lVar.j(context2, kVar);
        if (iN != 0) {
            lVar.X(iN);
        }
        lVar.U(colorStateListC);
        lVar.N(colorStateListC2);
        lVar.T(getOverScrollMode());
        if (iN2 != 0) {
            lVar.P(iN2);
        }
        lVar.Q(zA);
        lVar.R(colorStateListC3);
        lVar.I(drawableG);
        lVar.L(iF2);
        kVar.b(lVar);
        addView((View) lVar.y(this));
        int i22 = R$styleable.NavigationView_menu;
        if (uJ.s(i22)) {
            p(uJ.n(i22, 0));
        }
        int i23 = R$styleable.NavigationView_headerLayout;
        if (uJ.s(i23)) {
            o(uJ.n(i23, 0));
        }
        uJ.x();
        x();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f21162h.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f21163i.E((androidx.appcompat.view.menu.g) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
