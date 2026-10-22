package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.stepos.ability.R;
import java.util.ArrayList;
import stepos.support.v7.app.AbstractC1953b;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f6561A;

    /* renamed from: B, reason: collision with root package name */
    public int f6562B;

    /* renamed from: C, reason: collision with root package name */
    public int f6563C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f6564D;
    public boolean E;

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList f6565F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList f6566G;

    /* renamed from: L, reason: collision with root package name */
    public final int[] f6567L;

    /* renamed from: M, reason: collision with root package name */
    public C0 f6568M;

    /* renamed from: N, reason: collision with root package name */
    public final C2003s f6569N;

    /* renamed from: O, reason: collision with root package name */
    public G0 f6570O;

    /* renamed from: P, reason: collision with root package name */
    public C2005u f6571P;

    /* renamed from: Q, reason: collision with root package name */
    public A0 f6572Q;

    /* renamed from: R, reason: collision with root package name */
    public C4.a f6573R;

    /* renamed from: S, reason: collision with root package name */
    public h2.d f6574S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f6575T;

    /* renamed from: U, reason: collision with root package name */
    public final RunnableC1986e0 f6576U;

    /* renamed from: V, reason: collision with root package name */
    public final AppCompatDrawableManager f6577V;

    /* renamed from: W, reason: collision with root package name */
    public ActionMenuView f6578W;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f6579a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f6580a0;
    public HorizontalScrollView b;
    public final com.stepos.common.animator.m b0;
    public TextView c;

    /* renamed from: c0, reason: collision with root package name */
    public ViewGroup f6581c0;
    public TextView d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f6582d0;
    public ImageButton e;

    /* renamed from: e0, reason: collision with root package name */
    public View f6583e0;
    public ImageView f;

    /* renamed from: f0, reason: collision with root package name */
    public final C1977a f6584f0;
    public final Drawable g;
    public final CharSequence h;
    public ImageButton i;

    /* renamed from: j, reason: collision with root package name */
    public View f6585j;
    public Context k;
    public int l;
    public int m;
    public final int n;
    public int o;
    public final int p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6586q;

    /* renamed from: r, reason: collision with root package name */
    public int f6587r;

    /* renamed from: s, reason: collision with root package name */
    public final int f6588s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6589t;
    public final int u;

    /* renamed from: v, reason: collision with root package name */
    public final int f6590v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6591w;

    /* renamed from: x, reason: collision with root package name */
    public final X f6592x;
    public final int y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f6593z;

    public Toolbar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.steposToolbarStyleFullScreen);
        X x10 = new X();
        x10.f6599a = 0;
        x10.b = 0;
        x10.c = Integer.MIN_VALUE;
        x10.d = Integer.MIN_VALUE;
        x10.e = 0;
        x10.f = 0;
        x10.g = false;
        x10.h = false;
        this.f6592x = x10;
        this.y = 8388627;
        this.f6565F = new ArrayList();
        this.f6566G = new ArrayList();
        this.f6567L = new int[2];
        this.f6569N = new C2003s(this);
        this.f6576U = new RunnableC1986e0(this, 2);
        this.b0 = new com.stepos.common.animator.m();
        this.f6584f0 = new C1977a(this, 1);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, androidx.appcompat.R.styleable.Toolbar, R.attr.steposToolbarStyleFullScreen, 0);
        this.m = tintTypedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_titleTextAppearance, 0);
        this.n = tintTypedArrayObtainStyledAttributes.getResourceId(20, 0);
        this.o = tintTypedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.y = tintTypedArrayObtainStyledAttributes.getInteger(androidx.appcompat.R.styleable.Toolbar_android_gravity, 8388627);
        this.p = tintTypedArrayObtainStyledAttributes.getInteger(18, 48);
        int dimensionPixelOffset = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMargins, 0);
        this.f6591w = dimensionPixelOffset;
        this.f6590v = dimensionPixelOffset;
        this.u = dimensionPixelOffset;
        this.f6588s = dimensionPixelOffset;
        int dimensionPixelOffset2 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f6588s = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.u = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f6590v = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f6591w = dimensionPixelOffset5;
        }
        this.f6586q = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.Toolbar_contentInsetRight, 0);
        x10.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            x10.e = dimensionPixelSize;
            x10.f6599a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            x10.f = dimensionPixelSize2;
            x10.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            x10.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.g = tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_collapseIcon);
        this.h = tintTypedArrayObtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = tintTypedArrayObtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.k = getContext();
        setPopupTheme(tintTypedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = tintTypedArrayObtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = tintTypedArrayObtainStyledAttributes.getText(androidx.appcompat.R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(tintTypedArrayObtainStyledAttributes.getColor(androidx.appcompat.R.styleable.Toolbar_titleTextColor, -1));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(tintTypedArrayObtainStyledAttributes.getColor(androidx.appcompat.R.styleable.Toolbar_subtitleTextColor, -1));
        }
        this.f6589t = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(19, this.f6587r);
        this.f6587r = this.f6588s;
        tintTypedArrayObtainStyledAttributes.recycle();
        this.f6577V = AppCompatDrawableManager.get();
    }

    public static B0 f() {
        B0 b0 = new B0(-2, -2);
        b0.b = 0;
        b0.f6291a = 8388627;
        return b0;
    }

    public static B0 g(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof B0) {
            B0 b0 = (B0) layoutParams;
            B0 b02 = new B0(b0);
            b02.b = 0;
            b02.b = b0.b;
            return b02;
        }
        if (layoutParams instanceof AbstractC1953b) {
            B0 b03 = new B0((AbstractC1953b) layoutParams);
            b03.b = 0;
            return b03;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            B0 b04 = new B0(layoutParams);
            b04.b = 0;
            return b04;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        B0 b05 = new B0(marginLayoutParams);
        b05.b = 0;
        ((ViewGroup.MarginLayoutParams) b05).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) b05).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) b05).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) b05).bottomMargin = marginLayoutParams.bottomMargin;
        return b05;
    }

    private MenuInflater getMenuInflater() {
        return new Ua.k(getContext());
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static boolean k(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void a(ArrayList arrayList, int i) {
        boolean z10 = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        arrayList.clear();
        if (!z10) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                B0 b0 = (B0) childAt.getLayoutParams();
                if (b0.b == 0 && r(childAt)) {
                    int i10 = b0.f6291a;
                    int layoutDirection = ViewCompat.getLayoutDirection(this);
                    int absoluteGravity2 = GravityCompat.getAbsoluteGravity(i10, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt2 = getChildAt(i11);
            B0 b02 = (B0) childAt2.getLayoutParams();
            if (b02.b == 0 && r(childAt2)) {
                int i12 = b02.f6291a;
                int layoutDirection2 = ViewCompat.getLayoutDirection(this);
                int absoluteGravity3 = GravityCompat.getAbsoluteGravity(i12, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        B0 b0F = layoutParams == null ? f() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (B0) layoutParams;
        b0F.b = 1;
        if (!z10 || this.f6585j == null) {
            addView(view, b0F);
        } else {
            view.setLayoutParams(b0F);
            this.f6566G.add(view);
        }
    }

    public final void c() {
        d();
        ActionMenuView actionMenuView = this.f6579a;
        if (actionMenuView.f6443a == null) {
            Va.n nVar = (Va.n) actionMenuView.getMenu();
            if (this.f6572Q == null) {
                this.f6572Q = new A0(this);
            }
            this.f6579a.setExpandedActionViewsExclusive(true);
            nVar.b(this.f6572Q, this.k);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof B0);
    }

    public final void d() {
        if (this.f6579a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f6579a = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.f6579a.setOnMenuItemClickListener(this.f6569N);
            ActionMenuView actionMenuView2 = this.f6579a;
            C4.a aVar = this.f6573R;
            h2.d dVar = this.f6574S;
            actionMenuView2.f = aVar;
            actionMenuView2.g = dVar;
            B0 b0F = f();
            b0F.f6291a = (this.p & 112) | GravityCompat.END;
            this.f6579a.setLayoutParams(b0F);
            this.f6579a.setId(R.id.stepos_action_menu_view);
            if (!this.f6582d0) {
                b(this.f6579a, false);
            } else {
                ((ViewGroup.MarginLayoutParams) b0F).width = -1;
                this.f6581c0.addView(this.f6579a, 0, b0F);
            }
        }
    }

    public final void e() {
        if (this.e == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, androidx.appcompat.R.attr.toolbarNavigationButtonStyle);
            this.e = imageButton;
            this.b0.b(imageButton, 5, false);
            B0 b0F = f();
            b0F.f6291a = (this.p & 112) | GravityCompat.START;
            this.e.setLayoutParams(b0F);
            this.e.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.stepos_titlebar_ic_back_dark, null));
            this.e.setLayoutDirection(3);
            this.e.setId(R.id.stepos_toolbar_nav_button);
            this.e.addOnLayoutChangeListener(new z0(this));
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return f();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    public int getContentInsetEnd() {
        X x10 = this.f6592x;
        return x10.g ? x10.f6599a : x10.b;
    }

    public int getContentInsetLeft() {
        return this.f6592x.f6599a;
    }

    public int getContentInsetRight() {
        return this.f6592x.b;
    }

    public int getContentInsetStart() {
        X x10 = this.f6592x;
        return x10.g ? x10.b : x10.f6599a;
    }

    public Drawable getLogo() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        c();
        return this.f6579a.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        c();
        return this.f6579a.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.l;
    }

    public View getSplitBarCustomView() {
        return this.f6583e0;
    }

    public CharSequence getSubtitle() {
        return this.f6561A;
    }

    public CharSequence getTitle() {
        return this.f6593z;
    }

    public int getTitleMarginBottom() {
        return this.f6591w;
    }

    public int getTitleMarginEnd() {
        return this.u;
    }

    public int getTitleMarginStart() {
        return this.f6587r;
    }

    public int getTitleMarginTop() {
        return this.f6590v;
    }

    public I getWrapper() {
        if (this.f6570O == null) {
            this.f6570O = new G0(this, true);
        }
        return this.f6570O;
    }

    public final int h(View view, int i) {
        B0 b0 = (B0) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i10 = b0.f6291a & 112;
        if (i10 != 16 && i10 != 48 && i10 != 80) {
            i10 = this.y & 112;
        }
        if (i10 == 48) {
            return getPaddingTop() - i6;
        }
        if (i10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) b0).bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i11 = ((ViewGroup.MarginLayoutParams) b0).topMargin;
        if (iMax < i11) {
            iMax = i11;
        } else {
            int i12 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i13 = ((ViewGroup.MarginLayoutParams) b0).bottomMargin;
            if (i12 < i13) {
                iMax = Math.max(0, iMax - (i13 - i12));
            }
        }
        return paddingTop + iMax;
    }

    public final boolean l(View view) {
        return view.getParent() == this || this.f6566G.contains(view);
    }

    public final boolean m() {
        C2005u c2005u;
        ActionMenuView actionMenuView = this.f6579a;
        return (actionMenuView == null || (c2005u = actionMenuView.e) == null || !c2005u.i()) ? false : true;
    }

    public final int n(View view, int i, int[] iArr, int i6) {
        B0 b0 = (B0) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) b0).leftMargin - iArr[0];
        int iMax = Math.max(0, i10) + i;
        iArr[0] = Math.max(0, -i10);
        int iH = h(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iH, iMax + measuredWidth, view.getMeasuredHeight() + iH);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) b0).rightMargin + iMax;
    }

    public final int o(View view, int i, int[] iArr, int i6) {
        B0 b0 = (B0) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) b0).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int iH = h(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iH, iMax, view.getMeasuredHeight() + iH);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) b0).leftMargin);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f6576U);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.E = false;
        }
        if (!this.E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.E = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.E = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02de A[LOOP:0: B:115:0x02dc->B:116:0x02de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f6 A[LOOP:1: B:118:0x02f4->B:119:0x02f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0315 A[LOOP:2: B:121:0x0313->B:122:0x0315, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0362 A[LOOP:3: B:130:0x0360->B:131:0x0362, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0221  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 883
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int i10;
        int i11;
        int iMax;
        int measuredState;
        int measuredState2;
        int iMax2;
        int i12;
        int iJ;
        int measuredState3;
        int iMax3;
        boolean zB = I0.b(this);
        int i13 = !zB ? 1 : 0;
        int i14 = 0;
        if (r(this.e)) {
            q(this.e, i, 0, i6, this.f6586q);
            i11 = i(this.e) + this.e.getMeasuredWidth();
            int iMax4 = Math.max(0, j(this.e) + this.e.getMeasuredHeight());
            int measuredState4 = ViewCompat.getMeasuredState(this.e);
            i10 = this.f6589t;
            iMax = iMax4;
            measuredState = measuredState4;
        } else {
            i10 = this.f6588s;
            i11 = 0;
            iMax = 0;
            measuredState = 0;
        }
        this.f6587r = i10;
        if (r(this.i)) {
            q(this.i, i, 0, i6, this.f6586q);
            i11 = i(this.i) + this.i.getMeasuredWidth();
            iMax = Math.max(iMax, j(this.i) + this.i.getMeasuredHeight());
            measuredState |= ViewCompat.getMeasuredState(this.i);
        }
        int contentInsetStart = getContentInsetStart();
        int iMax5 = Math.max(contentInsetStart, i11);
        int iMax6 = Math.max(0, contentInsetStart - i11);
        int[] iArr = this.f6567L;
        iArr[zB ? 1 : 0] = iMax6;
        if (r(this.f6579a)) {
            q(this.f6579a, i, iMax5, i6, this.f6586q);
            int i15 = i(this.f6579a) + this.f6579a.getMeasuredWidth();
            int iMax7 = Math.max(iMax, j(this.f6579a) + this.f6579a.getMeasuredHeight());
            measuredState2 = measuredState | ViewCompat.getMeasuredState(this.f6579a);
            iMax2 = iMax7;
            i12 = i15;
        } else {
            measuredState2 = measuredState;
            iMax2 = iMax;
            i12 = 0;
        }
        int contentInsetEnd = getContentInsetEnd();
        int iMax8 = iMax5 + Math.max(contentInsetEnd, i12);
        iArr[i13] = Math.max(0, contentInsetEnd - i12);
        if (r(this.f6585j)) {
            iMax8 += p(this.f6585j, i, iMax8, i6, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.f6585j) + this.f6585j.getMeasuredHeight());
            measuredState2 |= ViewCompat.getMeasuredState(this.f6585j);
        }
        if (r(this.f)) {
            iMax8 += p(this.f, i, iMax8, i6, 0, iArr, false);
            iMax2 = Math.max(iMax2, j(this.f) + this.f.getMeasuredHeight());
            measuredState2 |= ViewCompat.getMeasuredState(this.f);
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (((B0) childAt.getLayoutParams()).b == 0 && r(childAt)) {
                iMax8 += p(childAt, i, iMax8, i6, 0, iArr, false);
                int iMax9 = Math.max(iMax2, j(childAt) + childAt.getMeasuredHeight());
                measuredState2 = ViewCompat.getMeasuredState(childAt) | measuredState2;
                iMax2 = iMax9;
            } else {
                iMax8 = iMax8;
            }
        }
        int i17 = iMax8;
        int i18 = this.f6590v + this.f6591w;
        int i19 = this.f6587r + this.u;
        int i20 = (this.y & 7) != 1 ? i17 : i12 * 2;
        if (r(this.b)) {
            p(this.b, i, i20 + i19, i6, i18, iArr, true);
            int i21 = i(this.b) + this.b.getMeasuredWidth();
            iJ = j(this.b) + this.b.getMeasuredHeight();
            measuredState3 = measuredState2 | ViewCompat.getMeasuredState(this.b);
            iMax3 = i21;
        } else {
            iJ = 0;
            measuredState3 = measuredState2;
            iMax3 = 0;
        }
        if (r(this.d)) {
            iMax3 = Math.max(iMax3, p(this.d, i, i20 + i19, i6, i18 + iJ, iArr, false));
            iJ += j(this.d) + this.d.getMeasuredHeight();
            measuredState3 |= ViewCompat.getMeasuredState(this.d);
        }
        int iMax10 = Math.max(iMax2, iJ);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i17 + iMax3;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax10;
        int iResolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & measuredState3);
        int iResolveSizeAndState2 = ViewCompat.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i6, measuredState3 << 16);
        if (!this.f6575T) {
            i14 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i22 = 0; i22 < childCount2; i22++) {
            View childAt2 = getChildAt(i22);
            if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i14 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i14);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f6579a;
        Va.n nVar = actionMenuView != null ? actionMenuView.f6443a : null;
        int i = savedState.expandedMenuItemId;
        if (i != 0 && this.f6572Q != null && nVar != null && (menuItemFindItem = nVar.findItem(i)) != null) {
            MenuItemCompat.expandActionView(menuItemFindItem);
        }
        if (savedState.isOverflowOpen) {
            RunnableC1986e0 runnableC1986e0 = this.f6576U;
            removeCallbacks(runnableC1986e0);
            post(runnableC1986e0);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        X x10 = this.f6592x;
        if (x10 != null) {
            boolean z10 = i == 1;
            if (z10 == x10.g) {
                return;
            }
            x10.g = z10;
            if (!x10.h) {
                x10.f6599a = x10.e;
                x10.b = x10.f;
                return;
            }
            if (z10) {
                int i6 = x10.d;
                if (i6 == Integer.MIN_VALUE) {
                    i6 = x10.e;
                }
                x10.f6599a = i6;
                int i10 = x10.c;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = x10.f;
                }
                x10.b = i10;
                return;
            }
            int i11 = x10.c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = x10.e;
            }
            x10.f6599a = i11;
            int i12 = x10.d;
            if (i12 == Integer.MIN_VALUE) {
                i12 = x10.f;
            }
            x10.b = i12;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Va.q qVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        A0 a02 = this.f6572Q;
        if (a02 != null && (qVar = a02.b) != null) {
            savedState.expandedMenuItemId = qVar.f1453a;
        }
        savedState.isOverflowOpen = m();
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f6564D = false;
        }
        if (!this.f6564D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f6564D = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f6564D = false;
        return true;
    }

    public final int p(View view, int i, int i6, int i10, int i11, int[] iArr, boolean z10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i13) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height);
        if (z10 && view.getMinimumWidth() > View.MeasureSpec.getSize(childMeasureSpec)) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.getMode(childMeasureSpec));
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        return view.getMeasuredWidth() + iMax;
    }

    public final void q(View view, int i, int i6, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i11 >= 0) {
            if (mode != 0) {
                i11 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i11);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setCollapsible(boolean z10) {
        this.f6575T = z10;
        requestLayout();
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(this.f6577V.getDrawable(getContext(), i));
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setMenuVisibility(int i) {
        ActionMenuView actionMenuView = this.f6579a;
        if (actionMenuView == null || !this.f6582d0) {
            return;
        }
        actionMenuView.setVisibility(i);
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(this.f6577V.getDrawable(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        e();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0 c02) {
        this.f6568M = c02;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        c();
        this.f6579a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.l != i) {
            this.l = i;
            if (i == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setShowBottomMenu(boolean z10) {
        if (this.f6580a0 != z10) {
            this.f6580a0 = z10;
            ActionMenuView actionMenuView = this.f6578W;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f6578W);
                }
                if (this.f6580a0) {
                    ViewGroup viewGroup2 = this.f6581c0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f6578W);
                    }
                    this.f6578W.getLayoutParams().width = -1;
                }
                this.f6578W.requestLayout();
            }
        }
    }

    public void setSplitCustomView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f6581c0 == null) {
            return;
        }
        View view2 = this.f6583e0;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.f6583e0);
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f6583e0 = view;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2);
                if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                    layoutParams.gravity = 17;
                }
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
            }
            this.f6581c0.addView(view, layoutParams);
        }
    }

    public void setSplitToolbar(boolean z10) {
        if (this.f6582d0 != z10) {
            this.f6582d0 = z10;
            ActionMenuView actionMenuView = this.f6579a;
            if (actionMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) actionMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f6579a);
                }
                if (z10) {
                    ViewGroup viewGroup2 = this.f6581c0;
                    if (viewGroup2 != null) {
                        viewGroup2.addView(this.f6579a);
                    }
                    this.f6579a.getLayoutParams().width = -1;
                } else {
                    b(this.f6579a, false);
                    this.f6579a.getLayoutParams().width = -2;
                }
                this.f6579a.requestLayout();
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f6581c0 = viewGroup;
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        this.f6563C = i;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleTextColor(@ColorInt int i) {
        this.f6562B = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        B0 b0 = new B0(context, attributeSet);
        b0.f6291a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActionBarLayout);
        b0.f6291a = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActionBarLayout_android_layout_gravity, 0);
        typedArrayObtainStyledAttributes.recycle();
        b0.b = 0;
        return b0;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f == null) {
                this.f = new ImageView(getContext());
            }
            if (!l(this.f)) {
                b(this.f, true);
            }
        } else {
            ImageView imageView = this.f;
            if (imageView != null && l(imageView)) {
                removeView(this.f);
                this.f6566G.remove(this.f);
            }
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f == null) {
            this.f = new ImageView(getContext());
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        TextView textView;
        TextView textView2;
        if (drawable != null) {
            e();
            if (!l(this.e)) {
                b(this.e, true);
            }
            int i = this.n;
            if (i != 0 && (textView2 = this.c) != null) {
                textView2.setTextAppearance(getContext(), i);
            }
        } else {
            ImageButton imageButton = this.e;
            if (imageButton != null && l(imageButton)) {
                removeView(this.e);
                this.f6566G.remove(this.e);
                setTouchDelegate(null);
                if (this.m != 0 && (textView = this.c) != null) {
                    textView.setTextAppearance(getContext(), this.m);
                }
            }
        }
        ImageButton imageButton2 = this.e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.d;
            if (textView != null && l(textView)) {
                removeView(this.d);
                this.f6566G.remove(this.d);
            }
        } else {
            if (this.d == null) {
                Context context = getContext();
                TextView textView2 = new TextView(context);
                this.d = textView2;
                textView2.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.o;
                if (i != 0) {
                    this.d.setTextAppearance(context, i);
                }
                int i6 = this.f6563C;
                if (i6 != 0) {
                    this.d.setTextColor(i6);
                }
            }
            if (!l(this.d)) {
                b(this.d, true);
            }
        }
        TextView textView3 = this.d;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.f6561A = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        if (TextUtils.isEmpty(charSequence)) {
            HorizontalScrollView horizontalScrollView = this.b;
            if (horizontalScrollView != null && l(horizontalScrollView)) {
                removeView(this.b);
                this.f6566G.remove(this.b);
            }
        } else {
            if (this.b == null) {
                HorizontalScrollView horizontalScrollView2 = new HorizontalScrollView(getContext());
                this.b = horizontalScrollView2;
                horizontalScrollView2.setHorizontalFadingEdgeEnabled(true);
                this.b.setOverScrollMode(2);
                this.b.setHorizontalScrollBarEnabled(false);
                this.b.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.stepos_toolbar_title_min_width));
            }
            if (this.c == null) {
                TextView textView = new TextView(getContext());
                this.c = textView;
                textView.setSingleLine();
            }
            if (r(this.e) && (i = this.n) != 0) {
                this.c.setTextAppearance(getContext(), i);
            } else if (this.m != 0) {
                this.c.setTextAppearance(getContext(), this.m);
            }
            int i6 = this.f6562B;
            if (i6 != 0) {
                this.c.setTextColor(i6);
            }
            this.b.removeAllViews();
            this.b.addView(this.c);
            if (!l(this.b)) {
                b(this.b, true);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f6593z = charSequence;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new D0();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
