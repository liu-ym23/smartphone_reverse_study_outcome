package com.google.android.material.bottomappbar;

import Z2.h;
import Z2.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
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
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.u;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u0.C5566a;

/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: B0, reason: collision with root package name */
    public static final int f20370B0 = R$style.Widget_MaterialComponents_BottomAppBar;

    /* renamed from: C0, reason: collision with root package name */
    public static final int f20371C0 = R$attr.motionDurationLong2;

    /* renamed from: D0, reason: collision with root package name */
    public static final int f20372D0 = R$attr.motionEasingEmphasizedInterpolator;

    /* renamed from: A0, reason: collision with root package name */
    public AnimatorListenerAdapter f20373A0;

    /* renamed from: U, reason: collision with root package name */
    public Integer f20374U;

    /* renamed from: V, reason: collision with root package name */
    public final h f20375V;

    /* renamed from: W, reason: collision with root package name */
    public Animator f20376W;

    /* renamed from: a0, reason: collision with root package name */
    public Animator f20377a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f20378b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f20379c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f20380d0;

    /* renamed from: e0, reason: collision with root package name */
    public final int f20381e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f20382f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f20383g0;

    /* renamed from: h0, reason: collision with root package name */
    public final boolean f20384h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f20385i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f20386j0;

    /* renamed from: k0, reason: collision with root package name */
    public ArrayList<g> f20387k0;

    /* renamed from: t0, reason: collision with root package name */
    public int f20388t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f20389u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f20390v0;

    /* renamed from: w0, reason: collision with root package name */
    public Behavior f20391w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f20392x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f20393y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f20394z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int fabAlignmentMode;
        boolean fabAttached;

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

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.f20376W = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    public class b extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20401a;

        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.s0();
            }
        }

        public b(int i10) {
            this.f20401a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.x0(this.f20401a));
            floatingActionButton.q(new a());
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.s0();
            BottomAppBar.this.f20389u0 = false;
            BottomAppBar.this.f20377a0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t0();
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20405a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f20406b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20407c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f20408d;

        public d(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f20406b = actionMenuView;
            this.f20407c = i10;
            this.f20408d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f20405a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f20405a) {
                return;
            }
            boolean z10 = BottomAppBar.this.f20388t0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.C0(bottomAppBar.f20388t0);
            BottomAppBar.this.I0(this.f20406b, this.f20407c, this.f20408d, z10);
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f20410a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20411b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f20412c;

        public e(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f20410a = actionMenuView;
            this.f20411b = i10;
            this.f20412c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20410a.setTranslationX(BottomAppBar.this.w0(r0, this.f20411b, this.f20412c));
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f20373A0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonU0 = BottomAppBar.this.u0();
            if (floatingActionButtonU0 != null) {
                floatingActionButtonU0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public static void J0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f12910d = 17;
        int i10 = bottomAppBar.f20380d0;
        if (i10 == 1) {
            fVar.f12910d = 17 | 48;
        }
        if (i10 == 0) {
            fVar.f12910d |= 80;
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
        return this.f20392x0;
    }

    private int getFabAlignmentAnimationDuration() {
        return T2.h.f(getContext(), f20371C0, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return x0(this.f20378b0);
    }

    private float getFabTranslationY() {
        if (this.f20380d0 == 1) {
            return -getTopEdgeTreatment().f();
        }
        return v0() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f20394z0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f20393y0;
    }

    private com.google.android.material.bottomappbar.b getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.b) this.f20375V.I().p();
    }

    public final void A0(int i10) {
        if (this.f20378b0 == i10 || !isLaidOut()) {
            return;
        }
        Animator animator = this.f20376W;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f20379c0 == 1) {
            q0(i10, arrayList);
        } else {
            p0(i10, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(T2.h.g(getContext(), f20372D0, E2.a.f2339a));
        this.f20376W = animatorSet;
        animatorSet.addListener(new a());
        this.f20376W.start();
    }

    public final Drawable B0(Drawable drawable) {
        if (drawable == null || this.f20374U == null) {
            return drawable;
        }
        Drawable drawableR = C5566a.r(drawable.mutate());
        drawableR.setTint(this.f20374U.intValue());
        return drawableR;
    }

    public void C0(int i10) {
        if (i10 != 0) {
            this.f20388t0 = 0;
            getMenu().clear();
            x(i10);
        }
    }

    public final void D0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f20377a0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (y0()) {
            H0(actionMenuView, this.f20378b0, this.f20390v0);
        } else {
            H0(actionMenuView, 0, false);
        }
    }

    public final void E0() {
        getTopEdgeTreatment().r(getFabTranslationX());
        this.f20375V.h0((this.f20390v0 && y0() && this.f20380d0 == 1) ? 1.0f : 0.0f);
        View viewV0 = v0();
        if (viewV0 != null) {
            viewV0.setTranslationY(getFabTranslationY());
            viewV0.setTranslationX(getFabTranslationX());
        }
    }

    public void F0(int i10, int i11) {
        this.f20388t0 = i11;
        this.f20389u0 = true;
        z0(i10, this.f20390v0);
        A0(i10);
        this.f20378b0 = i10;
    }

    public boolean G0(int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().j()) {
            return false;
        }
        getTopEdgeTreatment().q(f10);
        this.f20375V.invalidateSelf();
        return true;
    }

    public final void H0(ActionMenuView actionMenuView, int i10, boolean z10) {
        I0(actionMenuView, i10, z10, false);
    }

    public final void I0(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        e eVar = new e(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.f20375V.M();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f();
    }

    public int getFabAlignmentMode() {
        return this.f20378b0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f20382f0;
    }

    public int getFabAnchorMode() {
        return this.f20380d0;
    }

    public int getFabAnimationMode() {
        return this.f20379c0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().h();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().i();
    }

    public boolean getHideOnScroll() {
        return this.f20385i0;
    }

    public int getMenuAlignmentMode() {
        return this.f20383g0;
    }

    public final void n0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f20373A0);
        floatingActionButton.f(new f());
        floatingActionButton.g(null);
    }

    public final void o0() {
        Animator animator = this.f20377a0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f20376W;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.f(this, this.f20375V);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            o0();
            E0();
            final View viewV0 = v0();
            if (viewV0 != null && viewV0.isLaidOut()) {
                viewV0.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewV0.requestLayout();
                    }
                });
            }
        }
        D0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f20378b0 = savedState.fabAlignmentMode;
        this.f20390v0 = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.f20378b0;
        savedState.fabAttached = this.f20390v0;
        return savedState;
    }

    public void p0(int i10, List<Animator> list) {
        FloatingActionButton floatingActionButtonU0 = u0();
        if (floatingActionButtonU0 == null || floatingActionButtonU0.m()) {
            return;
        }
        t0();
        floatingActionButtonU0.k(new b(i10));
    }

    public final void q0(int i10, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(u0(), "translationX", x0(i10));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    public final void r0(int i10, boolean z10, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 1.0f);
        animatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - w0(actionMenuView, i10, z10)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0.0f);
            objectAnimatorOfFloat.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat.addListener(new d(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    public final void s0() {
        ArrayList<g> arrayList;
        int i10 = this.f20386j0 - 1;
        this.f20386j0 = i10;
        if (i10 != 0 || (arrayList = this.f20387k0) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.f20375V.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().k(f10);
            this.f20375V.invalidateSelf();
            E0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.f20375V.f0(f10);
        getBehavior().p(this, this.f20375V.H() - this.f20375V.G());
    }

    public void setFabAlignmentMode(int i10) {
        F0(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f20382f0 != i10) {
            this.f20382f0 = i10;
            E0();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.f20380d0 = i10;
        E0();
        View viewV0 = v0();
        if (viewV0 != null) {
            J0(this, viewV0);
            viewV0.requestLayout();
            this.f20375V.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.f20379c0 = i10;
    }

    public void setFabCornerSize(float f10) {
        if (f10 != getTopEdgeTreatment().g()) {
            getTopEdgeTreatment().n(f10);
            this.f20375V.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().o(f10);
            this.f20375V.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().p(f10);
            this.f20375V.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f20385i0 = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f20383g0 != i10) {
            this.f20383g0 = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                H0(actionMenuView, this.f20378b0, y0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(B0(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f20374U = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final void t0() {
        ArrayList<g> arrayList;
        int i10 = this.f20386j0;
        this.f20386j0 = i10 + 1;
        if (i10 != 0 || (arrayList = this.f20387k0) == null) {
            return;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public final FloatingActionButton u0() {
        View viewV0 = v0();
        if (viewV0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewV0;
        }
        return null;
    }

    public final View v0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).z(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int w0(ActionMenuView actionMenuView, int i10, boolean z10) throws Resources.NotFoundException {
        int i11 = 0;
        if (this.f20383g0 != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean zH = u.h(this);
        int measuredWidth = zH ? getMeasuredWidth() : 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f8416a & 8388615) == 8388611) {
                measuredWidth = zH ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zH ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i13 = zH ? this.f20393y0 : -this.f20394z0;
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_bottomappbar_horizontal_padding);
            if (!zH) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
            i11 = dimensionPixelOffset;
        }
        return measuredWidth - ((right + i13) + i11);
    }

    public final float x0(int i10) {
        boolean zH = u.h(this);
        if (i10 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((zH ? this.f20394z0 : this.f20393y0) + ((this.f20382f0 == -1 || v0() == null) ? this.f20381e0 : (r6.getMeasuredWidth() / 2) + this.f20382f0))) * (zH ? -1 : 1);
    }

    public final boolean y0() {
        FloatingActionButton floatingActionButtonU0 = u0();
        return floatingActionButtonU0 != null && floatingActionButtonU0.n();
    }

    public final void z0(int i10, boolean z10) {
        if (!isLaidOut()) {
            this.f20389u0 = false;
            C0(this.f20388t0);
            return;
        }
        Animator animator = this.f20377a0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!y0()) {
            i10 = 0;
            z10 = false;
        }
        r0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f20377a0 = animatorSet;
        animatorSet.addListener(new c());
        this.f20377a0.start();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f20391w0 == null) {
            this.f20391w0 = new Behavior();
        }
        return this.f20391w0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: p, reason: collision with root package name */
        public final Rect f20395p;

        /* renamed from: q, reason: collision with root package name */
        public WeakReference<BottomAppBar> f20396q;

        /* renamed from: r, reason: collision with root package name */
        public int f20397r;

        /* renamed from: s, reason: collision with root package name */
        public final View.OnLayoutChangeListener f20398s;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f20396q.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.h(Behavior.this.f20395p);
                    int iHeight = Behavior.this.f20395p.height();
                    bottomAppBar.G0(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f20395p)));
                    height = iHeight;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f20397r == 0) {
                    if (bottomAppBar.f20380d0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (u.h(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.f20381e0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.f20381e0;
                    }
                }
                bottomAppBar.E0();
            }
        }

        public Behavior() {
            this.f20398s = new a();
            this.f20395p = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f20396q = new WeakReference<>(bottomAppBar);
            View viewV0 = bottomAppBar.v0();
            if (viewV0 != null && !viewV0.isLaidOut()) {
                BottomAppBar.J0(bottomAppBar, viewV0);
                this.f20397r = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewV0.getLayoutParams())).bottomMargin;
                if (viewV0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewV0;
                    if (bottomAppBar.f20380d0 == 0 && bottomAppBar.f20384h0) {
                        floatingActionButton.setElevation(0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.n0(floatingActionButton);
                }
                viewV0.addOnLayoutChangeListener(this.f20398s);
                bottomAppBar.E0();
            }
            coordinatorLayout.Q(bottomAppBar, i10);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f20398s = new a();
            this.f20395p = new Rect();
        }
    }
}
