package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n3.k0;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g extends LinearLayout {
    public int A;
    public Drawable B;
    public Integer C;
    public float D;
    public AppBarLayout$Behavior E;

    /* renamed from: c, reason: collision with root package name */
    public int f2345c;

    /* renamed from: f, reason: collision with root package name */
    public int f2346f;

    /* renamed from: g, reason: collision with root package name */
    public int f2347g;

    /* renamed from: h, reason: collision with root package name */
    public int f2348h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f2349j;

    /* renamed from: k, reason: collision with root package name */
    public m1 f2350k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2351l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2352m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2353n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2354o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2355p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f2356q;

    /* renamed from: r, reason: collision with root package name */
    public int f2357r;

    /* renamed from: s, reason: collision with root package name */
    public WeakReference f2358s;

    /* renamed from: t, reason: collision with root package name */
    public ValueAnimator f2359t;

    /* renamed from: u, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f2360u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f2361v;

    /* renamed from: w, reason: collision with root package name */
    public LinkedHashSet f2362w;

    /* renamed from: x, reason: collision with root package name */
    public long f2363x;

    /* renamed from: y, reason: collision with root package name */
    public TimeInterpolator f2364y;

    /* renamed from: z, reason: collision with root package name */
    public int[] f2365z;

    public static f e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            f fVar = new f((LinearLayout.LayoutParams) layoutParams);
            fVar.f2342a = 1;
            return fVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            f fVar2 = new f((ViewGroup.MarginLayoutParams) layoutParams);
            fVar2.f2342a = 1;
            return fVar2;
        }
        f fVar3 = new f(layoutParams);
        fVar3.f2342a = 1;
        return fVar3;
    }

    public final void c(stepos.support.v7.widget.d dVar) {
        if (this.f2351l == null) {
            this.f2351l = new ArrayList();
        }
        if (dVar == null || this.f2351l.contains(dVar)) {
            return;
        }
        this.f2351l.add(dVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final f generateLayoutParams(AttributeSet attributeSet) {
        p5.l lVar;
        Context context = getContext();
        f fVar = new f(context, attributeSet);
        fVar.f2342a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9810b);
        fVar.f2342a = typedArrayObtainStyledAttributes.getInt(1, 0);
        if (typedArrayObtainStyledAttributes.getInt(0, 0) != 1) {
            lVar = null;
        } else {
            lVar = new p5.l();
            lVar.f9738c = new Rect();
            lVar.f9739f = new Rect();
            VarHandle.storeStoreFence();
        }
        fVar.f2343b = lVar;
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            fVar.f2344c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return fVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.B == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f2345c);
        this.B.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.B;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void f() {
        AppBarLayout$Behavior appBarLayout$Behavior = this.E;
        e eVarI = (appBarLayout$Behavior == null || this.f2346f == -1 || this.f2349j != 0) ? null : appBarLayout$Behavior.i(t3.b.EMPTY_STATE, this);
        this.f2346f = -1;
        this.f2347g = -1;
        this.f2348h = -1;
        if (eVarI != null) {
            AppBarLayout$Behavior appBarLayout$Behavior2 = this.E;
            if (appBarLayout$Behavior2.f2317k != null) {
                return;
            }
            appBarLayout$Behavior2.f2317k = eVarI;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[PHI: r5
      0x00b4: PHI (r5v29 float) = (r5v8 float), (r5v9 float) binds: [B:33:0x00b2, B:36:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0188 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.g.g(int):void");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        f fVar = new f(-1, -2);
        fVar.f2342a = 1;
        return fVar;
    }

    public b3.a getBehavior() {
        AppBarLayout$Behavior appBarLayout$Behavior = new AppBarLayout$Behavior();
        this.E = appBarLayout$Behavior;
        return appBarLayout$Behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.f2347g;
        if (i != -1) {
            return i;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = fVar.f2342a;
                if ((i10 & 5) != 5) {
                    if (i3 > 0) {
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
                        i3 += iMin;
                    }
                    iMin = minimumHeight + i11;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i3 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i3);
        this.f2347g = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.f2348h;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + childAt.getMeasuredHeight();
                int i10 = fVar.f2342a;
                if ((i10 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i10 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f2348h = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f2357r;
    }

    public f7.i getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof f7.i) {
            return (f7.i) background;
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
        int i3 = (minimumHeight2 * 2) + topInset;
        return i3 < getHeight() ? i3 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f2349j;
    }

    public Drawable getStatusBarForeground() {
        return this.B;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        m1 m1Var = this.f2350k;
        if (m1Var != null) {
            return m1Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f2346f;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = fVar.f2342a;
                if ((i10 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + minimumHeight;
                if (i3 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i10 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f2346f = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h(boolean z10, boolean z11, boolean z12) {
        this.f2349j = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    public final boolean i(boolean z10) {
        boolean z11 = this.f2352m;
        float f5 = this.D;
        if (z11 || this.f2354o == z10) {
            return false;
        }
        this.f2354o = z10;
        refreshDrawableState();
        if (!(getBackground() instanceof f7.i)) {
            return true;
        }
        if (this.f2356q != null) {
            k(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f2355p) {
            return true;
        }
        float f10 = z10 ? 0.0f : f5;
        if (!z10) {
            f5 = 0.0f;
        }
        k(f10, f5);
        return true;
    }

    public final boolean j(View view) {
        int i;
        if (this.f2358s == null && (i = this.f2357r) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f2357r);
            }
            if (viewFindViewById != null) {
                this.f2358s = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.f2358s;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void k(float f5, float f10) {
        ValueAnimator valueAnimator = this.f2359t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f5, f10);
        this.f2359t = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f2363x);
        this.f2359t.setInterpolator(this.f2364y);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f2360u;
        if (animatorUpdateListener != null) {
            this.f2359t.addUpdateListener(animatorUpdateListener);
        }
        this.f2359t.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof f7.i) {
            a.a.V(this, (f7.i) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.f2365z == null) {
            this.f2365z = new int[4];
        }
        int[] iArr = this.f2365z;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z10 = this.f2353n;
        int i3 = R.attr.state_liftable;
        if (!z10) {
            i3 = -R.attr.state_liftable;
        }
        iArr[0] = i3;
        int i10 = R.attr.state_lifted;
        if (!z10 || !this.f2354o) {
            i10 = -R.attr.state_lifted;
        }
        iArr[1] = i10;
        int i11 = R.attr.state_collapsible;
        if (!z10) {
            i11 = -R.attr.state_collapsible;
        }
        iArr[2] = i11;
        int i12 = R.attr.state_collapsed;
        if (!z10 || !this.f2354o) {
            i12 = -R.attr.state_collapsed;
        }
        iArr[3] = i12;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f2358s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2358s = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        boolean z11 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap weakHashMap = k0.f8724a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        f();
        this.i = false;
        int childCount2 = getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 >= childCount2) {
                break;
            }
            if (((f) getChildAt(i12).getLayoutParams()).f2344c != null) {
                this.i = true;
                break;
            }
            i12++;
        }
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f2352m) {
            return;
        }
        if (!this.f2355p) {
            int childCount3 = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount3) {
                    z11 = false;
                    break;
                }
                int i14 = ((f) getChildAt(i13).getLayoutParams()).f2342a;
                if ((i14 & 1) == 1 && (i14 & 10) != 0) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        if (this.f2353n != z11) {
            this.f2353n = z11;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = td.h.j(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i3));
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
        f7.i iVar;
        ColorStateList colorStateList;
        Context context = getContext();
        Integer numValueOf = null;
        if (drawable instanceof f7.i) {
            iVar = (f7.i) drawable;
        } else {
            ColorStateList colorStateListValueOf = drawable instanceof ColorDrawable ? ColorStateList.valueOf(((ColorDrawable) drawable).getColor()) : drawable instanceof ColorStateListDrawable ? ((ColorStateListDrawable) drawable).getColorStateList() : null;
            if (colorStateListValueOf == null) {
                iVar = null;
            } else {
                f7.i iVar2 = new f7.i(new f7.m());
                iVar2.j(colorStateListValueOf);
                iVar = iVar2;
            }
        }
        if (iVar != null && (colorStateList = iVar.f3954f.f3939d) != null) {
            this.A = colorStateList.getDefaultColor();
            ColorStateList colorStateList2 = this.f2356q;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue typedValueE = p5.f.E(R.attr.colorSurface, context2);
                if (typedValueE != null) {
                    int i = typedValueE.resourceId;
                    numValueOf = Integer.valueOf(i != 0 ? context2.getColor(i) : typedValueE.data);
                }
                a aVar = new a();
                aVar.f2325a = this;
                aVar.f2326b = colorStateList2;
                aVar.f2327c = iVar;
                aVar.f2328d = numValueOf;
                VarHandle.storeStoreFence();
                this.f2360u = aVar;
            } else {
                iVar.g(context);
                b bVar = new b();
                bVar.f2329a = this;
                bVar.f2330b = iVar;
                VarHandle.storeStoreFence();
                this.f2360u = bVar;
            }
            drawable = iVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        Drawable background = getBackground();
        if (background instanceof f7.i) {
            ((f7.i) background).i(f5);
        }
    }

    public void setExpanded(boolean z10) {
        h(z10, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z10) {
        this.f2355p = z10;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f2356q != colorStateList) {
            this.f2356q = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f2357r = -1;
        if (view != null) {
            this.f2358s = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f2358s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2358s = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.f2357r = i;
        WeakReference weakReference = this.f2358s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2358s = null;
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f2352m = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
        } else {
            g5.f.s("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    public void setPendingAction(int i) {
        this.f2349j = i;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.B;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.B = drawableMutate;
            if (drawableMutate instanceof f7.i) {
                numValueOf = Integer.valueOf(((f7.i) drawableMutate).f3972y);
            } else {
                ColorStateList colorStateListValueOf = drawableMutate instanceof ColorDrawable ? ColorStateList.valueOf(((ColorDrawable) drawableMutate).getColor()) : drawableMutate instanceof ColorStateListDrawable ? ((ColorStateListDrawable) drawableMutate).getColorStateList() : null;
                if (colorStateListValueOf != null) {
                    numValueOf = Integer.valueOf(colorStateListValueOf.getDefaultColor());
                }
            }
            this.C = numValueOf;
            Drawable drawable3 = this.B;
            boolean z10 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.B.setState(getDrawableState());
                }
                this.B.setLayoutDirection(getLayoutDirection());
                this.B.setVisible(getVisibility() == 0, false);
                this.B.setCallback(this);
            }
            if (this.B != null && getTopInset() > 0) {
                z10 = true;
            }
            setWillNotDraw(!z10);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(id.k.v(i, getContext()));
    }

    @Deprecated
    public void setTargetElevation(float f5) {
        n.a(this, f5);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        f fVar = new f(-1, -2);
        fVar.f2342a = 1;
        return fVar;
    }
}
