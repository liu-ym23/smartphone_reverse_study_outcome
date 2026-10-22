package com.google.android.material.bottomappbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p.o;
import u4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: i0, reason: collision with root package name */
    public static final /* synthetic */ int f4643i0 = 0;
    public Integer U;
    public AnimatorSet V;
    public AnimatorSet W;

    /* renamed from: a0, reason: collision with root package name */
    public int f4644a0;
    public int b0;
    public int c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f4645d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f4646e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f4647f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f4648g0;

    /* renamed from: h0, reason: collision with root package name */
    public Behavior f4649h0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int fabAlignmentMode;
        boolean fabAttached;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f4654a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4655b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f4656c;

        public a(ActionMenuView actionMenuView, int i10, boolean z) {
            this.f4654a = actionMenuView;
            this.f4655b = i10;
            this.f4656c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10 = this.f4655b;
            boolean z = this.f4656c;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            this.f4654a.setTranslationX(bottomAppBar.z(r3, i10, z));
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return 0;
    }

    private int getFabAlignmentAnimationDuration() {
        return j.c(getContext(), R.attr.motionDurationLong2, 300);
    }

    private float getFabTranslationX() {
        return A(this.f4644a0);
    }

    private float getFabTranslationY() {
        if (this.c0 == 1) {
            return -getTopEdgeTreatment().f4671c;
        }
        return y() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return 0;
    }

    private e getTopEdgeTreatment() {
        throw null;
    }

    public final float A(int i10) {
        int measuredWidth = 0;
        boolean z = getLayoutDirection() == 1;
        if (i10 != 1) {
            return 0.0f;
        }
        View viewY = y();
        if (this.f4645d0 != -1 && viewY != null) {
            measuredWidth = this.f4645d0 + (viewY.getMeasuredWidth() / 2);
        }
        return ((getMeasuredWidth() / 2) - measuredWidth) * (z ? -1 : 1);
    }

    public final boolean B() {
        View viewY = y();
        FloatingActionButton floatingActionButton = viewY instanceof FloatingActionButton ? (FloatingActionButton) viewY : null;
        return floatingActionButton != null && floatingActionButton.h();
    }

    public final void C() {
        e topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        if (this.f4648g0 && B()) {
            int i10 = this.c0;
        }
        throw null;
    }

    public final void D(ActionMenuView actionMenuView, int i10, boolean z, boolean z3) {
        a aVar = new a(actionMenuView, i10, z);
        if (z3) {
            actionMenuView.post(aVar);
        } else {
            aVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f4671c;
    }

    public int getFabAlignmentMode() {
        return this.f4644a0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f4645d0;
    }

    public int getFabAnchorMode() {
        return this.c0;
    }

    public int getFabAnimationMode() {
        return this.b0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f4670b;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f4669a;
    }

    public boolean getHideOnScroll() {
        return this.f4647f0;
    }

    public int getMenuAlignmentMode() {
        return this.f4646e0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        xb.a.g(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (z) {
            AnimatorSet animatorSet = this.W;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.V;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            C();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.W != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (B()) {
            D(actionMenuView, this.f4644a0, this.f4648g0, false);
        } else {
            D(actionMenuView, 0, false, false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4644a0 = savedState.fabAlignmentMode;
        this.f4648g0 = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.f4644a0;
        savedState.fabAttached = this.f4648g0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f8) {
        if (f8 != getCradleVerticalOffset()) {
            e topEdgeTreatment = getTopEdgeTreatment();
            if (f8 >= 0.0f) {
                topEdgeTreatment.f4671c = f8;
                throw null;
            }
            topEdgeTreatment.getClass();
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        throw null;
    }

    public void setFabAlignmentMode(int i10) {
        int i11;
        boolean z = this.f4648g0;
        int i12 = 0;
        if (isLaidOut()) {
            AnimatorSet animatorSet = this.W;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (B()) {
                i11 = i10;
            } else {
                z = false;
                i11 = 0;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
                if (Math.abs(actionMenuView.getTranslationX() - z(actionMenuView, i11, z)) > 1.0f) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                    objectAnimatorOfFloat2.addListener(new d(this, actionMenuView, i11, z));
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                    arrayList.add(animatorSet2);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(objectAnimatorOfFloat);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList);
            this.W = animatorSet3;
            animatorSet3.addListener(new c(this, 0));
            this.W.start();
        }
        if (this.f4644a0 != i10 && isLaidOut()) {
            AnimatorSet animatorSet4 = this.V;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.b0 == 1) {
                View viewY = y();
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewY instanceof FloatingActionButton ? (FloatingActionButton) viewY : null, "translationX", A(i10));
                objectAnimatorOfFloat3.setDuration(getFabAlignmentAnimationDuration());
                arrayList2.add(objectAnimatorOfFloat3);
            } else {
                View viewY2 = y();
                FloatingActionButton floatingActionButton = viewY2 instanceof FloatingActionButton ? (FloatingActionButton) viewY2 : null;
                if (floatingActionButton != null && !floatingActionButton.g()) {
                    floatingActionButton.f(new b(this, i10), true);
                }
            }
            AnimatorSet animatorSet5 = new AnimatorSet();
            animatorSet5.playTogether(arrayList2);
            animatorSet5.setInterpolator(j.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10220a));
            this.V = animatorSet5;
            animatorSet5.addListener(new com.google.android.material.bottomappbar.a(this, i12));
            this.V.start();
        }
        this.f4644a0 = i10;
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f4645d0 == i10) {
            return;
        }
        this.f4645d0 = i10;
        C();
        throw null;
    }

    public void setFabAnchorMode(int i10) {
        this.c0 = i10;
        C();
        throw null;
    }

    public void setFabAnimationMode(int i10) {
        this.b0 = i10;
    }

    public void setFabCornerSize(float f8) {
        if (f8 == getTopEdgeTreatment().f4672d) {
            return;
        }
        getTopEdgeTreatment().f4672d = f8;
        throw null;
    }

    public void setFabCradleMargin(float f8) {
        if (f8 == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().f4670b = f8;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f8) {
        if (f8 == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().f4669a = f8;
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.f4647f0 = z;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f4646e0 != i10) {
            this.f4646e0 = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                D(actionMenuView, this.f4644a0, B(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.U.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i10) {
        this.U = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public final View y() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
        List list = (List) ((o) coordinatorLayout.f1437b.f1475c).get(this);
        ArrayList arrayList = coordinatorLayout.f1439d;
        arrayList.clear();
        if (list != null) {
            arrayList.addAll(list);
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            View view = (View) obj;
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public final int z(ActionMenuView actionMenuView, int i10, boolean z) throws Resources.NotFoundException {
        int i11 = 0;
        if (this.f4646e0 != 1 && (i10 != 1 || !z)) {
            return 0;
        }
        boolean z3 = getLayoutDirection() == 1;
        int measuredWidth = z3 ? getMeasuredWidth() : 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f315a & 8388615) == 8388611) {
                measuredWidth = z3 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = z3 ? actionMenuView.getRight() : actionMenuView.getLeft();
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            if (!z3) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
            i11 = dimensionPixelOffset;
        }
        return measuredWidth - (right + i11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f4649h0 == null) {
            this.f4649h0 = new Behavior();
        }
        return this.f4649h0;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: o, reason: collision with root package name */
        public final Rect f4650o;

        /* renamed from: p, reason: collision with root package name */
        public WeakReference<BottomAppBar> f4651p;

        /* renamed from: q, reason: collision with root package name */
        public int f4652q;
        public final a r;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                Behavior behavior = Behavior.this;
                BottomAppBar bottomAppBar = behavior.f4651p.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    behavior.f4650o.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                    throw null;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (behavior.f4652q == 0) {
                    if (bottomAppBar.c0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (view.getLayoutDirection() == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
                    }
                }
                int i18 = BottomAppBar.f4643i0;
                bottomAppBar.C();
                throw null;
            }
        }

        public Behavior() {
            this.r = new a();
            this.f4650o = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f4651p = new WeakReference<>(bottomAppBar);
            int i11 = BottomAppBar.f4643i0;
            View viewY = bottomAppBar.y();
            if (viewY == null || viewY.isLaidOut()) {
                coordinatorLayout.B(i10, bottomAppBar);
                return super.onLayoutChild(coordinatorLayout, bottomAppBar, i10);
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) viewY.getLayoutParams();
            fVar.f1459d = 17;
            int i12 = bottomAppBar.c0;
            if (i12 == 1) {
                fVar.f1459d = 49;
            }
            if (i12 == 0) {
                fVar.f1459d |= 80;
            }
            this.f4652q = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewY.getLayoutParams())).bottomMargin;
            if (viewY instanceof FloatingActionButton) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) viewY;
                if (floatingActionButton.getShowMotionSpec() == null) {
                    floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                }
                if (floatingActionButton.getHideMotionSpec() == null) {
                    floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                }
                floatingActionButton.b();
                floatingActionButton.c(new c(bottomAppBar, 1));
                floatingActionButton.d();
            }
            viewY.addOnLayoutChangeListener(this.r);
            bottomAppBar.C();
            throw null;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.r = new a();
            this.f4650o = new Rect();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
