package com.google.android.material.appbar;

import K.J;
import K.S;
import K.c0;
import K.z0;
import Z2.I;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.common.api.internal.p;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m1.AbstractC0769a;
import n1.AbstractC0775a;
import stepos.support.v7.widget.AbstractC0904y;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C0884d;
import stepos.support.v7.widget.C0902w;
import stepos.support.v7.widget.C0903x;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.x0;

/* loaded from: classes.dex */
public abstract class h extends LinearLayout implements A.a {

    /* renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ int f10293B = 0;

    /* renamed from: A, reason: collision with root package name */
    public AppBarLayout$Behavior f10294A;

    /* renamed from: a, reason: collision with root package name */
    public int f10295a;

    /* renamed from: b, reason: collision with root package name */
    public int f10296b;

    /* renamed from: c, reason: collision with root package name */
    public int f10297c;

    /* renamed from: d, reason: collision with root package name */
    public int f10298d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10299e;

    /* renamed from: f, reason: collision with root package name */
    public int f10300f;

    /* renamed from: g, reason: collision with root package name */
    public z0 f10301g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f10302h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10303i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10304j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10305k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10306l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f10307m;

    /* renamed from: n, reason: collision with root package name */
    public int f10308n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference f10309o;

    /* renamed from: p, reason: collision with root package name */
    public ValueAnimator f10310p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f10311q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f10312r;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f10313s;

    /* renamed from: t, reason: collision with root package name */
    public final long f10314t;

    /* renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f10315u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f10316v;

    /* renamed from: w, reason: collision with root package name */
    public int f10317w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f10318x;

    /* renamed from: y, reason: collision with root package name */
    public Integer f10319y;

    /* renamed from: z, reason: collision with root package name */
    public final float f10320z;

    /* JADX WARN: Finally extract failed */
    public h(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(C1.a.b(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        this.f10296b = -1;
        this.f10297c = -1;
        this.f10298d = -1;
        this.f10300f = 0;
        this.f10312r = new ArrayList();
        this.f10313s = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayE = com.google.android.material.internal.l.e(context3, attributeSet, o.f10340a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayE.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayE.getResourceId(0, 0)));
            }
            typedArrayE.recycle();
            TypedArray typedArrayE2 = com.google.android.material.internal.l.e(context2, attributeSet, AbstractC0769a.f13535a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.f10307m = B0.f.y(context2, typedArrayE2, 6);
            this.f10314t = com.stepos.statsrpk.c.L(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.f10315u = com.stepos.statsrpk.c.M(context2, R.attr.motionEasingStandardInterpolator, AbstractC0775a.f13650a);
            if (typedArrayE2.hasValue(4)) {
                h(typedArrayE2.getBoolean(4, false), false, false);
            }
            if (typedArrayE2.hasValue(3)) {
                o.a(this, typedArrayE2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayE2.getDrawable(0));
            if (typedArrayE2.hasValue(2)) {
                setKeyboardNavigationCluster(typedArrayE2.getBoolean(2, false));
            }
            if (typedArrayE2.hasValue(1)) {
                setTouchscreenBlocksFocus(typedArrayE2.getBoolean(1, false));
            }
            this.f10320z = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f10306l = typedArrayE2.getBoolean(5, false);
            this.f10308n = typedArrayE2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayE2.getDrawable(8));
            typedArrayE2.recycle();
            p pVar = new p(5, this);
            WeakHashMap weakHashMap = S.f939a;
            J.u(this, pVar);
        } catch (Throwable th) {
            typedArrayE.recycle();
            throw th;
        }
    }

    public static f e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            f fVar = new f((LinearLayout.LayoutParams) layoutParams);
            fVar.f10290a = 1;
            return fVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            f fVar2 = new f((ViewGroup.MarginLayoutParams) layoutParams);
            fVar2.f10290a = 1;
            return fVar2;
        }
        f fVar3 = new f(layoutParams);
        fVar3.f10290a = 1;
        return fVar3;
    }

    public final void c(g gVar) {
        if (this.f10302h == null) {
            this.f10302h = new ArrayList();
        }
        if (gVar == null || this.f10302h.contains(gVar)) {
            return;
        }
        this.f10302h.add(gVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final f generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        f fVar = new f(context, attributeSet);
        fVar.f10290a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13536b);
        fVar.f10290a = typedArrayObtainStyledAttributes.getInt(1, 0);
        fVar.f10291b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new B0.c(7);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            fVar.f10292c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return fVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f10318x == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(Property.DEFAULT_FLOAT_VALUE, -this.f10295a);
        this.f10318x.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f10318x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void f() {
        AppBarLayout$Behavior appBarLayout$Behavior = this.f10294A;
        AppBarLayout$BaseBehavior.SavedState savedStateK = (appBarLayout$Behavior == null || this.f10296b == -1 || this.f10300f != 0) ? null : appBarLayout$Behavior.k(AbsSavedState.EMPTY_STATE, this);
        this.f10296b = -1;
        this.f10297c = -1;
        this.f10298d = -1;
        if (savedStateK != null) {
            AppBarLayout$Behavior appBarLayout$Behavior2 = this.f10294A;
            if (appBarLayout$Behavior2.f10262k != null) {
                return;
            }
            appBarLayout$Behavior2.f10262k = savedStateK;
        }
    }

    public final void g(int i4) {
        int iRound;
        this.f10295a = i4;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.f10302h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                e eVar = (e) this.f10302h.get(i5);
                if (eVar != null) {
                    C0884d c0884d = (C0884d) eVar;
                    int i6 = c0884d.f15077a;
                    ViewGroup viewGroup = c0884d.f15078b;
                    switch (i6) {
                        case 0:
                            ((ActionBarCoordinatorLayout) viewGroup).f14740K = i4 == 0;
                            break;
                        case 1:
                            AbstractC0904y abstractC0904y = (AbstractC0904y) viewGroup;
                            abstractC0904y.f15249v = i4;
                            int iA = abstractC0904y.a();
                            int childCount = abstractC0904y.getChildCount();
                            for (int i7 = 0; i7 < childCount; i7++) {
                                View childAt = abstractC0904y.getChildAt(i7);
                                C0903x c0903x = (C0903x) childAt.getLayoutParams();
                                x0 x0VarD = AbstractC0904y.d(childAt);
                                int i8 = c0903x.f15222a;
                                if (i8 == 1) {
                                    int iO = AbstractC0557a.o(-i4, 0, abstractC0904y.c(childAt));
                                    if (x0VarD.f15227d != iO) {
                                        x0VarD.f15227d = iO;
                                        x0VarD.a();
                                    }
                                } else if (i8 == 2 && x0VarD.f15227d != (iRound = Math.round((-i4) * c0903x.f15223b))) {
                                    x0VarD.f15227d = iRound;
                                    x0VarD.a();
                                }
                            }
                            abstractC0904y.f();
                            if (abstractC0904y.f15242o != null && iA > 0) {
                                WeakHashMap weakHashMap = S.f939a;
                                abstractC0904y.postInvalidateOnAnimation();
                            }
                            int height = abstractC0904y.getHeight();
                            WeakHashMap weakHashMap2 = S.f939a;
                            float fN = AbstractC0557a.n(Math.abs(i4) / ((height - abstractC0904y.getMinimumHeight()) - iA), Property.DEFAULT_FLOAT_VALUE, 1.0f);
                            C0902w c0902w = abstractC0904y.f15238k;
                            if (fN != c0902w.f15177c) {
                                c0902w.f15177c = fN;
                                RectF rectF = c0902w.f15180f;
                                float f4 = c0902w.f15178d.left;
                                Rect rect = c0902w.f15179e;
                                rectF.left = C0902w.g(f4, rect.left, fN, null);
                                rectF.top = C0902w.g(c0902w.f15187m, c0902w.f15188n, fN, null);
                                rectF.right = C0902w.g(r6.right, rect.right, fN, null);
                                rectF.bottom = C0902w.g(r6.bottom, rect.bottom, fN, null);
                                c0902w.f15191q = C0902w.g(c0902w.f15189o, c0902w.f15190p, fN, null);
                                c0902w.f15192r = C0902w.g(c0902w.f15187m, c0902w.f15188n, fN, null);
                                c0902w.m(C0902w.g(c0902w.f15183i, c0902w.f15184j, fN, c0902w.f15165E));
                                ColorStateList colorStateList = c0902w.f15186l;
                                ColorStateList colorStateList2 = c0902w.f15185k;
                                TextPaint textPaint = c0902w.f15164D;
                                if (colorStateList != colorStateList2) {
                                    int[] iArr = c0902w.f15162B;
                                    int colorForState = iArr != null ? colorStateList2.getColorForState(iArr, 0) : colorStateList2.getDefaultColor();
                                    int[] iArr2 = c0902w.f15162B;
                                    textPaint.setColor(C0902w.d(fN, colorForState, iArr2 != null ? c0902w.f15186l.getColorForState(iArr2, 0) : c0902w.f15186l.getDefaultColor()));
                                } else {
                                    int[] iArr3 = c0902w.f15162B;
                                    textPaint.setColor(iArr3 != null ? colorStateList.getColorForState(iArr3, 0) : colorStateList.getDefaultColor());
                                }
                                textPaint.setShadowLayer(C0902w.g(c0902w.f15170J, c0902w.f15166F, fN, null), C0902w.g(c0902w.f15171K, c0902w.f15167G, fN, null), C0902w.g(c0902w.f15172L, c0902w.f15168H, fN, null), C0902w.d(fN, c0902w.f15173M, c0902w.f15169I));
                                c0902w.f15175a.postInvalidateOnAnimation();
                                break;
                            } else {
                                break;
                            }
                            break;
                        default:
                            StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) viewGroup;
                            float fAbs = Math.abs(i4) / stepOSCollapsingToolbarLayout.getExpandRange();
                            stepOSCollapsingToolbarLayout.f14905D = fAbs;
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
        fVar.f10290a = 1;
        return fVar;
    }

    @Override // A.a
    @NonNull
    public A.b getBehavior() {
        AppBarLayout$Behavior appBarLayout$Behavior = new AppBarLayout$Behavior();
        this.f10294A = appBarLayout$Behavior;
        return appBarLayout$Behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i4 = this.f10297c;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = fVar.f10290a;
                if ((i6 & 5) != 5) {
                    if (i5 > 0) {
                        break;
                    }
                } else {
                    int i7 = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                    if ((i6 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i6 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i7 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i5 += iMin;
                    }
                    iMin = minimumHeight + i7;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i5 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i5);
        this.f10297c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i4 = this.f10298d;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + childAt.getMeasuredHeight();
                int i6 = fVar.f10290a;
                if ((i6 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i6 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i5++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f10298d = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f10308n;
    }

    @Nullable
    public y1.j getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof y1.j) {
            return (y1.j) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i4 = (minimumHeight * 2) + topInset;
            return i4 < getHeight() ? i4 : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i5 = (minimumHeight2 * 2) + topInset;
        return i5 < getHeight() ? i5 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f10300f;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f10318x;
    }

    @Deprecated
    public float getTargetElevation() {
        return Property.DEFAULT_FLOAT_VALUE;
    }

    @VisibleForTesting
    public final int getTopInset() {
        z0 z0Var = this.f10301g;
        if (z0Var != null) {
            return z0Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i4 = this.f10296b;
        if (i4 != -1) {
            return i4;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = fVar.f10290a;
                if ((i6 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + minimumHeight;
                if (i5 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i6 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i5++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f10296b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h(boolean z4, boolean z5, boolean z6) {
        this.f10300f = (z4 ? 1 : 2) | (z5 ? 4 : 0) | (z6 ? 8 : 0);
        requestLayout();
    }

    public final boolean i(boolean z4) {
        if (!(!this.f10303i) || this.f10305k == z4) {
            return false;
        }
        this.f10305k = z4;
        refreshDrawableState();
        if (!(getBackground() instanceof y1.j)) {
            return true;
        }
        ColorStateList colorStateList = this.f10307m;
        float f4 = Property.DEFAULT_FLOAT_VALUE;
        if (colorStateList != null) {
            float f5 = z4 ? 0.0f : 1.0f;
            if (z4) {
                f4 = 1.0f;
            }
            k(f5, f4);
            return true;
        }
        if (!this.f10306l) {
            return true;
        }
        float f6 = this.f10320z;
        float f7 = z4 ? 0.0f : f6;
        if (z4) {
            f4 = f6;
        }
        k(f7, f4);
        return true;
    }

    public final boolean j(View view) {
        int i4;
        if (this.f10309o == null && (i4 = this.f10308n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i4) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f10308n);
            }
            if (viewFindViewById != null) {
                this.f10309o = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f10309o;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final void k(float f4, float f5) {
        ValueAnimator valueAnimator = this.f10310p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f4, f5);
        this.f10310p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f10314t);
        this.f10310p.setInterpolator(this.f10315u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f10311q;
        if (animatorUpdateListener != null) {
            this.f10310p.addUpdateListener(animatorUpdateListener);
        }
        this.f10310p.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof y1.j) {
            B0.f.x0(this, (y1.j) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        if (this.f10316v == null) {
            this.f10316v = new int[4];
        }
        int[] iArr = this.f10316v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + iArr.length);
        boolean z4 = this.f10304j;
        iArr[0] = z4 ? R.attr.state_liftable : -2130970282;
        iArr[1] = (z4 && this.f10305k) ? R.attr.state_lifted : -2130970283;
        iArr[2] = z4 ? R.attr.state_collapsible : -2130970278;
        iArr[3] = (z4 && this.f10305k) ? R.attr.state_collapsed : -2130970277;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f10309o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10309o = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        boolean z5 = false;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap weakHashMap = S.f939a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        f();
        this.f10299e = false;
        int childCount2 = getChildCount();
        int i8 = 0;
        while (true) {
            if (i8 >= childCount2) {
                break;
            }
            if (((f) getChildAt(i8).getLayoutParams()).f10292c != null) {
                this.f10299e = true;
                break;
            }
            i8++;
        }
        Drawable drawable = this.f10318x;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f10303i) {
            return;
        }
        if (this.f10306l) {
            z5 = true;
            break;
        }
        int childCount3 = getChildCount();
        for (int i9 = 0; i9 < childCount3; i9++) {
            int i10 = ((f) getChildAt(i9).getLayoutParams()).f10290a;
            if ((i10 & 1) == 1 && (i10 & 10) != 0) {
                z5 = true;
                break;
            }
        }
        if (this.f10304j != z5) {
            this.f10304j = z5;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = AbstractC0557a.o(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i5));
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
        final y1.j jVar;
        ColorStateList colorStateList;
        Context context = getContext();
        if (drawable instanceof y1.j) {
            jVar = (y1.j) drawable;
        } else {
            ColorStateList colorStateListW = t0.J.w(drawable);
            if (colorStateListW == null) {
                jVar = null;
            } else {
                y1.j jVar2 = new y1.j();
                jVar2.o(colorStateListW);
                jVar = jVar2;
            }
        }
        if (jVar != null && (colorStateList = jVar.f16234b.f16206d) != null) {
            this.f10317w = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.f10307m;
            if (colorStateList2 != null) {
                final Integer numY = AbstractC0557a.y(R.attr.colorSurface, getContext());
                this.f10311q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        h hVar = this.f10280a;
                        hVar.getClass();
                        int iL = AbstractC0557a.L(((Float) valueAnimator.getAnimatedValue()).floatValue(), hVar.f10317w, colorStateList2.getDefaultColor());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iL);
                        y1.j jVar3 = jVar;
                        jVar3.o(colorStateListValueOf);
                        if (hVar.f10318x != null && (num = hVar.f10319y) != null && num.equals(numY)) {
                            hVar.f10318x.setTint(iL);
                        }
                        ArrayList arrayList = hVar.f10312r;
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                B0.g.y(it.next());
                                if (jVar3.f16234b.f16206d != null) {
                                    throw null;
                                }
                            }
                        }
                        LinkedHashSet linkedHashSet = hVar.f10313s;
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        if (it2.hasNext()) {
                            B0.g.y(it2.next());
                            throw null;
                        }
                    }
                };
            } else {
                jVar.l(context);
                this.f10311q = new c0(1, this, jVar);
            }
            drawable = jVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        Drawable background = getBackground();
        if (background instanceof y1.j) {
            ((y1.j) background).n(f4);
        }
    }

    public void setExpanded(boolean z4) {
        h(z4, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z4) {
        this.f10306l = z4;
    }

    public void setLiftOnScrollColor(@Nullable ColorStateList colorStateList) {
        if (this.f10307m != colorStateList) {
            this.f10307m = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.f10308n = -1;
        if (view != null) {
            this.f10309o = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f10309o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10309o = null;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i4) {
        this.f10308n = i4;
        WeakReference weakReference = this.f10309o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10309o = null;
    }

    public void setLiftableOverrideEnabled(boolean z4) {
        this.f10303i = z4;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i4) {
        if (i4 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i4);
    }

    public void setPendingAction(int i4) {
        this.f10300f = i4;
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f10318x;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f10318x = drawableMutate;
            if (drawableMutate instanceof y1.j) {
                numValueOf = Integer.valueOf(((y1.j) drawableMutate).f16254v);
            } else {
                ColorStateList colorStateListW = t0.J.w(drawableMutate);
                if (colorStateListW != null) {
                    numValueOf = Integer.valueOf(colorStateListW.getDefaultColor());
                }
            }
            this.f10319y = numValueOf;
            Drawable drawable3 = this.f10318x;
            boolean z4 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f10318x.setState(getDrawableState());
                }
                E.b.b(this.f10318x, getLayoutDirection());
                this.f10318x.setVisible(getVisibility() == 0, false);
                this.f10318x.setCallback(this);
            }
            if (this.f10318x != null && getTopInset() > 0) {
                z4 = true;
            }
            setWillNotDraw(!z4);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i4) {
        setStatusBarForeground(new ColorDrawable(i4));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i4) {
        setStatusBarForeground(I.o(getContext(), i4));
    }

    @Deprecated
    public void setTargetElevation(float f4) throws Resources.NotFoundException {
        o.a(this, f4);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f10318x;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10318x;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        f fVar = new f(-1, -2);
        fVar.f10290a = 1;
        return fVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }
}
