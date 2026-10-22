package com.google.android.material.appbar;

import D7.N;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import c3.AbstractC0873c;
import com.stepos.ability.R;
import g1.AbstractC1451a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import k2.C1621a;
import stepos.support.v7.widget.A;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C;
import stepos.support.v7.widget.C1987f;
import stepos.support.v7.widget.D;
import stepos.support.v7.widget.H0;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;

/* loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ int f2271B = 0;

    /* renamed from: A, reason: collision with root package name */
    public Behavior f2272A;

    /* renamed from: a, reason: collision with root package name */
    public int f2273a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public WindowInsetsCompat g;
    public ArrayList h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2274j;
    public boolean k;
    public boolean l;
    public ColorStateList m;
    public int n;
    public WeakReference o;
    public ValueAnimator p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f2275q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f2276r;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f2277s;

    /* renamed from: t, reason: collision with root package name */
    public final long f2278t;
    public final TimeInterpolator u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f2279v;

    /* renamed from: w, reason: collision with root package name */
    public int f2280w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f2281x;
    public Integer y;

    /* renamed from: z, reason: collision with root package name */
    public final float f2282z;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends h {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.h
        @Nullable
        public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.h
        public float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
                int iC = behavior instanceof BaseBehavior ? ((BaseBehavior) behavior).c() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iC > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iC / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.h
        public int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (getVerticalLayoutGap() + ((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).h)) - getOverlapPixelsForOffset(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.l) {
                return false;
            }
            appBarLayout.i(appBarLayout.j(view));
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.k, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            super.onLayoutChild(coordinatorLayout, view, i);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z10) {
            AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (appBarLayoutFindFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutFindFirstDependency.h(false, !z10, true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z10) {
            super.setHorizontalOffsetEnabled(z10);
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z10) {
            super.setVerticalOffsetEnabled(z10);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.f1064C);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.h
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(i3.a.a(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        this.f2276r = new ArrayList();
        this.f2277s = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = com.google.android.material.internal.k.d(context3, attributeSet, m.f2296a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = com.google.android.material.internal.k.d(context2, attributeSet, P2.a.f1074a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.m = AbstractC0873c.a(context2, typedArrayD2, 6);
            this.f2278t = N.N(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.u = N.O(context2, R.attr.motionEasingStandardInterpolator, Q2.a.f1097a);
            if (typedArrayD2.hasValue(4)) {
                h(typedArrayD2.getBoolean(4, false), false, false);
            }
            if (typedArrayD2.hasValue(3)) {
                m.a(this, typedArrayD2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayD2.getDrawable(0));
            if (typedArrayD2.hasValue(2)) {
                setKeyboardNavigationCluster(typedArrayD2.getBoolean(2, false));
            }
            if (typedArrayD2.hasValue(1)) {
                setTouchscreenBlocksFocus(typedArrayD2.getBoolean(1, false));
            }
            this.f2282z = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.l = typedArrayD2.getBoolean(5, false);
            this.n = typedArrayD2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(8));
            typedArrayD2.recycle();
            ViewCompat.setOnApplyWindowInsetsListener(this, new B1.c(this));
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    public static f e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            f fVar = new f((LinearLayout.LayoutParams) layoutParams);
            fVar.f2291a = 1;
            return fVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            f fVar2 = new f((ViewGroup.MarginLayoutParams) layoutParams);
            fVar2.f2291a = 1;
            return fVar2;
        }
        f fVar3 = new f(layoutParams);
        fVar3.f2291a = 1;
        return fVar3;
    }

    public final void c(C1987f c1987f) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        if (c1987f == null || this.h.contains(c1987f)) {
            return;
        }
        this.h.add(c1987f);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final f generateLayoutParams(AttributeSet attributeSet) {
        C1621a c1621a;
        Context context = getContext();
        f fVar = new f(context, attributeSet);
        fVar.f2291a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.b);
        fVar.f2291a = typedArrayObtainStyledAttributes.getInt(1, 0);
        if (typedArrayObtainStyledAttributes.getInt(0, 0) != 1) {
            c1621a = null;
        } else {
            c1621a = new C1621a();
            c1621a.f4793a = new Rect();
            c1621a.b = new Rect();
        }
        fVar.b = c1621a;
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            fVar.c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return fVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2281x == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f2273a);
        this.f2281x.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2281x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void f() {
        Behavior behavior = this.f2272A;
        BaseBehavior.SavedState savedStateK = (behavior == null || this.b == -1 || this.f != 0) ? null : behavior.k(AbsSavedState.EMPTY_STATE, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if (savedStateK != null) {
            Behavior behavior2 = this.f2272A;
            if (behavior2.k != null) {
                return;
            }
            behavior2.k = savedStateK;
        }
    }

    public final void g(int i) {
        int iRound;
        this.f2273a = i;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1987f c1987f = (C1987f) this.h.get(i6);
                if (c1987f != null) {
                    switch (c1987f.f6610a) {
                        case 0:
                            ((ActionBarCoordinatorLayout) c1987f.b).l = i == 0;
                            break;
                        case 1:
                            D d = (D) c1987f.b;
                            d.f6453v = i;
                            int iA = d.a();
                            int childCount = d.getChildCount();
                            for (int i10 = 0; i10 < childCount; i10++) {
                                View childAt = d.getChildAt(i10);
                                C c = (C) childAt.getLayoutParams();
                                H0 h0D = D.d(childAt);
                                int i11 = c.f6446a;
                                if (i11 == 1) {
                                    int iClamp = MathUtils.clamp(-i, 0, d.c(childAt));
                                    if (h0D.d != iClamp) {
                                        h0D.d = iClamp;
                                        h0D.a();
                                    }
                                } else if (i11 == 2 && h0D.d != (iRound = Math.round((-i) * c.b))) {
                                    h0D.d = iRound;
                                    h0D.a();
                                }
                            }
                            d.f();
                            if (d.o != null && iA > 0) {
                                ViewCompat.postInvalidateOnAnimation(d);
                            }
                            int height = (d.getHeight() - ViewCompat.getMinimumHeight(d)) - iA;
                            A a3 = d.k;
                            a3.getClass();
                            float fClamp = MathUtils.clamp(Math.abs(i) / height, 0.0f, 1.0f);
                            if (fClamp != a3.c) {
                                a3.c = fClamp;
                                TextPaint textPaint = a3.f6383D;
                                RectF rectF = a3.f;
                                float f = a3.d.left;
                                Rect rect = a3.e;
                                rectF.left = A.g(f, rect.left, fClamp, null);
                                rectF.top = A.g(a3.m, a3.n, fClamp, null);
                                rectF.right = A.g(r7.right, rect.right, fClamp, null);
                                rectF.bottom = A.g(r7.bottom, rect.bottom, fClamp, null);
                                a3.f6394q = A.g(a3.o, a3.p, fClamp, null);
                                a3.f6395r = A.g(a3.m, a3.n, fClamp, null);
                                a3.m(A.g(a3.i, a3.f6393j, fClamp, a3.E));
                                ColorStateList colorStateList = a3.l;
                                ColorStateList colorStateList2 = a3.k;
                                if (colorStateList != colorStateList2) {
                                    int[] iArr = a3.f6381B;
                                    int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
                                    int[] iArr2 = a3.f6381B;
                                    textPaint.setColor(A.d(fClamp, colorForState, iArr2 != null ? a3.l.getColorForState(iArr2, 0) : a3.l.getDefaultColor()));
                                } else {
                                    int[] iArr3 = a3.f6381B;
                                    textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
                                }
                                textPaint.setShadowLayer(A.g(a3.f6388J, a3.f6384F, fClamp, null), A.g(a3.f6389K, a3.f6385G, fClamp, null), A.g(a3.f6390L, a3.f6386H, fClamp, null), A.d(fClamp, a3.f6391M, a3.f6387I));
                                ViewCompat.postInvalidateOnAnimation(a3.f6392a);
                                break;
                            } else {
                                break;
                            }
                            break;
                        default:
                            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) c1987f.b;
                            float fAbs = Math.abs(i) / stepOSCollapsingToolbarLayout.getExpandRange();
                            stepOSCollapsingToolbarLayout.f6508D = fAbs;
                            stepOSCollapsingToolbarLayout.g(fAbs);
                            break;
                    }
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        f fVar = new f(-1, -2);
        fVar.f2291a = 1;
        return fVar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f2272A = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = fVar.f2291a;
                if ((i10 & 5) != 5) {
                    if (i6 > 0) {
                        break;
                    }
                } else {
                    int i11 = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                    if ((i10 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i10 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i11 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i6 += iMin;
                    }
                    iMin = minimumHeight + i11;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i6 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i6);
        this.c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + childAt.getMeasuredHeight();
                int i10 = fVar.f2291a;
                if ((i10 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i10 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.d = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.n;
    }

    @Nullable
    public e3.k getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof e3.k) {
            return (e3.k) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i = (minimumHeight * 2) + topInset;
            return i < getHeight() ? i : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i6 = (minimumHeight2 * 2) + topInset;
        return i6 < getHeight() ? i6 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f2281x;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = fVar.f2291a;
                if ((i10 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + minimumHeight;
                if (i6 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i10 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h(boolean z10, boolean z11, boolean z12) {
        this.f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    public final boolean i(boolean z10) {
        if (this.i || this.k == z10) {
            return false;
        }
        this.k = z10;
        refreshDrawableState();
        if (!(getBackground() instanceof e3.k)) {
            return true;
        }
        if (this.m != null) {
            k(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.l) {
            return true;
        }
        float f = this.f2282z;
        k(z10 ? 0.0f : f, z10 ? f : 0.0f);
        return true;
    }

    public final boolean j(View view) {
        int i;
        if (this.o == null && (i = this.n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.n);
            }
            if (viewFindViewById != null) {
                this.o = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.o;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void k(float f, float f7) {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f7);
        this.p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f2278t);
        this.p.setInterpolator(this.u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f2275q;
        if (animatorUpdateListener != null) {
            this.p.addUpdateListener(animatorUpdateListener);
        }
        this.p.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof e3.k) {
            AbstractC1451a.T(this, (e3.k) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.f2279v == null) {
            this.f2279v = new int[4];
        }
        int[] iArr = this.f2279v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z10 = this.f2274j;
        iArr[0] = z10 ? R.attr.state_liftable : -2130970257;
        iArr[1] = (z10 && this.k) ? R.attr.state_lifted : -2130970258;
        iArr[2] = z10 ? R.attr.state_collapsible : -2130970253;
        iArr[3] = (z10 && this.k) ? R.attr.state_collapsed : -2130970252;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        boolean z11 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
                }
            }
        }
        f();
        this.e = false;
        int childCount2 = getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 >= childCount2) {
                break;
            }
            if (((f) getChildAt(i12).getLayoutParams()).c != null) {
                this.e = true;
                break;
            }
            i12++;
        }
        Drawable drawable = this.f2281x;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.i) {
            return;
        }
        if (!this.l) {
            int childCount3 = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount3) {
                    z11 = false;
                    break;
                }
                int i14 = ((f) getChildAt(i13).getLayoutParams()).f2291a;
                if ((i14 & 1) == 1 && (i14 & 10) != 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        if (this.f2274j != z11) {
            this.f2274j = z11;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i6));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        f();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final e3.k kVar;
        ColorStateList colorStateList;
        Context context = getContext();
        if (drawable instanceof e3.k) {
            kVar = (e3.k) drawable;
        } else {
            ColorStateList colorStateListA = Y2.b.a(drawable);
            if (colorStateListA == null) {
                kVar = null;
            } else {
                e3.k kVar2 = new e3.k();
                kVar2.q(colorStateListA);
                kVar = kVar2;
            }
        }
        if (kVar != null && (colorStateList = kVar.b.d) != null) {
            this.f2280w = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.m;
            if (colorStateList2 != null) {
                final Integer numB = W2.a.b(R.attr.colorSurface, getContext());
                this.f2275q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        AppBarLayout appBarLayout = this.f2287a;
                        LinkedHashSet linkedHashSet = appBarLayout.f2277s;
                        ArrayList arrayList = appBarLayout.f2276r;
                        int iC = W2.a.c(((Float) valueAnimator.getAnimatedValue()).floatValue(), appBarLayout.f2280w, colorStateList2.getDefaultColor());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iC);
                        e3.k kVar3 = kVar;
                        kVar3.q(colorStateListValueOf);
                        if (appBarLayout.f2281x != null && (num = appBarLayout.y) != null && num.equals(numB)) {
                            appBarLayout.f2281x.setTint(iC);
                        }
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next() != null) {
                                    throw new ClassCastException();
                                }
                                if (kVar3.b.d != null) {
                                    throw null;
                                }
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        if (it2.hasNext()) {
                            throw B7.a.f(it2);
                        }
                    }
                };
            } else {
                kVar.m(context);
                this.f2275q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i = AppBarLayout.f2271B;
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        kVar.p(fFloatValue);
                        AppBarLayout appBarLayout = this.f2288a;
                        Drawable drawable2 = appBarLayout.f2281x;
                        if (drawable2 instanceof e3.k) {
                            ((e3.k) drawable2).p(fFloatValue);
                        }
                        Iterator it = appBarLayout.f2276r.iterator();
                        if (it.hasNext()) {
                            throw B7.a.f(it);
                        }
                        Iterator it2 = appBarLayout.f2277s.iterator();
                        if (it2.hasNext()) {
                            throw B7.a.f(it2);
                        }
                    }
                };
            }
            drawable = kVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof e3.k) {
            ((e3.k) background).p(f);
        }
    }

    public void setExpanded(boolean z10) {
        h(z10, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z10) {
        this.l = z10;
    }

    public void setLiftOnScrollColor(@Nullable ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.n = -1;
        if (view != null) {
            this.o = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i) {
        this.n = i;
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setPendingAction(int i) {
        this.f = i;
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f2281x;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f2281x = drawableMutate;
            if (drawableMutate instanceof e3.k) {
                numValueOf = Integer.valueOf(((e3.k) drawableMutate).f4362v);
            } else {
                ColorStateList colorStateListA = Y2.b.a(drawableMutate);
                if (colorStateListA != null) {
                    numValueOf = Integer.valueOf(colorStateListA.getDefaultColor());
                }
            }
            this.y = numValueOf;
            Drawable drawable3 = this.f2281x;
            boolean z10 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2281x.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f2281x, getLayoutDirection());
                this.f2281x.setVisible(getVisibility() == 0, false);
                this.f2281x.setCallback(this);
            }
            if (this.f2281x != null && getTopInset() > 0) {
                z10 = true;
            }
            setWillNotDraw(!z10);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        m.a(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.f2281x;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2281x;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }

    public static class BaseBehavior<T extends AppBarLayout> extends g {
        public int h;
        public int i;

        /* renamed from: j, reason: collision with root package name */
        public ValueAnimator f2283j;
        public SavedState k;
        public WeakReference l;

        public BaseBehavior() {
            this.d = -1;
            this.f = -1;
        }

        public static View f(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View h(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                int r0 = java.lang.Math.abs(r8)
                int r1 = r7.getChildCount()
                r2 = 0
                r3 = r2
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r7.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                if (r4 == 0) goto L5a
                android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
                com.google.android.material.appbar.f r0 = (com.google.android.material.appbar.f) r0
                int r0 = r0.f2291a
                r1 = r0 & 1
                if (r1 == 0) goto L5a
                int r1 = r4.getMinimumHeight()
                r3 = 1
                if (r9 <= 0) goto L48
                r9 = r0 & 12
                if (r9 == 0) goto L48
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L48:
                r9 = r0 & 2
                if (r9 == 0) goto L5a
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L5a:
                r3 = r2
            L5b:
                boolean r8 = r7.l
                if (r8 == 0) goto L67
                android.view.View r8 = h(r6)
                boolean r3 = r7.j(r8)
            L67:
                boolean r8 = r7.i(r3)
                if (r10 != 0) goto L99
                if (r8 == 0) goto Lc0
                java.util.List r6 = r6.getDependents(r7)
                int r8 = r6.size()
            L77:
                if (r2 >= r8) goto Lc0
                java.lang.Object r9 = r6.get(r2)
                android.view.View r9 = (android.view.View) r9
                android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r9
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r9 = r9.getBehavior()
                boolean r10 = r9 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r10 == 0) goto L96
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r9 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r9
                int r6 = r9.getOverlayTop()
                if (r6 == 0) goto Lc0
                goto L99
            L96:
                int r2 = r2 + 1
                goto L77
            L99:
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                if (r6 == 0) goto La6
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                r6.jumpToCurrentState()
            La6:
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                if (r6 == 0) goto Lb3
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                r6.jumpToCurrentState()
            Lb3:
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                if (r6 == 0) goto Lc0
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                r6.jumpToCurrentState()
            Lc0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.m(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // com.google.android.material.appbar.g
        public final int c() {
            return getTopAndBottomOffset() + this.h;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0146  */
        @Override // com.google.android.material.appbar.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int d(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instructions count: 349
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.d(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void g(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(c() - i);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iC = c();
            if (iC == i) {
                ValueAnimator valueAnimator = this.f2283j;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f2283j.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f2283j;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f2283j = valueAnimator3;
                valueAnimator3.setInterpolator(Q2.a.e);
                this.f2283j.addUpdateListener(new c(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f2283j.setDuration(Math.min(iRound, 600));
            this.f2283j.setIntValues(iC, i);
            this.f2283j.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void i(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.c()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r8 = r2.d(r3, r4, r5, r6, r7)
                r9 = 1
                r13[r9] = r8
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r8 = r4.l
                if (r8 == 0) goto L37
                boolean r8 = r4.j(r11)
                r4.i(r8)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.i(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i6) {
            ValueAnimator valueAnimator;
            boolean z10 = (i & 2) != 0 && (appBarLayout.l || appBarLayout.k || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight()));
            if (z10 && (valueAnimator = this.f2283j) != null) {
                valueAnimator.cancel();
            }
            this.l = null;
            this.i = i6;
            return z10;
        }

        public final SavedState k(Parcelable parcelable, AppBarLayout appBarLayout) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z10 = topAndBottomOffset == 0;
                    savedState.fullyExpanded = z10;
                    savedState.fullyScrolled = !z10 && (-topAndBottomOffset) >= appBarLayout.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public final void l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iC = c() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                f fVar = (f) childAt.getLayoutParams();
                if ((fVar.f2291a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) fVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
                }
                int i6 = -iC;
                if (top <= i6 && bottom >= i6) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                f fVar2 = (f) childAt2.getLayoutParams();
                int i10 = fVar2.f2291a;
                if ((i10 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if ((i10 & 2) == 2) {
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i10 & 5) == 5) {
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iC < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i10 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) fVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) fVar2).bottomMargin;
                    }
                    if (iC < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    g(coordinatorLayout, appBarLayout, MathUtils.clamp(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // com.google.android.material.appbar.k, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.k;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i6 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z10) {
                            g(coordinatorLayout, appBarLayout, i6);
                        } else {
                            e(coordinatorLayout, appBarLayout, i6);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            g(coordinatorLayout, appBarLayout, 0);
                        } else {
                            e(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                e(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                e(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.firstVisibleChildIndex);
                int i10 = -childAt.getBottom();
                e(coordinatorLayout, appBarLayout, this.k.firstVisibleChildAtMinimumHeight ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i10 : Math.round(childAt.getHeight() * this.k.firstVisibleChildPercentageShown) + i10);
            }
            appBarLayout.f = 0;
            this.k = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            m(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.g(getTopAndBottomOffset());
            if (!ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, new d(coordinatorLayout, this, appBarLayout));
            }
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i6, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i6, i10, i11);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i, i6, View.MeasureSpec.makeMeasureSpec(0, 0), i11);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int[] iArr, int i10) {
            i(coordinatorLayout, (AppBarLayout) view, view2, i6, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i6, int i10, int i11, int i12, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                iArr[1] = d(coordinatorLayout, appBarLayout, c() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i11 != 0 || ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new d(coordinatorLayout, this, appBarLayout));
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
                this.k = null;
            } else {
                SavedState savedState = (SavedState) parcelable;
                this.k = savedState;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            SavedState savedStateK = k(parcelableOnSaveInstanceState, appBarLayout);
            return savedStateK == null ? parcelableOnSaveInstanceState : savedStateK;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.i == 0 || i == 1) {
                l(coordinatorLayout, appBarLayout);
                if (appBarLayout.l) {
                    appBarLayout.i(appBarLayout.j(view2));
                }
            }
            this.l = new WeakReference(view2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.d = -1;
            this.f = -1;
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new e();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        f fVar = new f(-1, -2);
        fVar.f2291a = 1;
        return fVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }
}
