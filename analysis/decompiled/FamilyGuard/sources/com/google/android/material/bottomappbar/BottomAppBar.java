package com.google.android.material.bottomappbar;

import a1.C0408a;
import a1.C0409b;
import a1.C0411d;
import a1.C0417j;
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
import b1.C0553a;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import t1.C1115h;
import t1.C1116i;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: v0, reason: collision with root package name */
    private static final int f12246v0 = C0417j.f6922m;

    /* renamed from: w0, reason: collision with root package name */
    private static final int f12247w0 = C0409b.f6736w;

    /* renamed from: x0, reason: collision with root package name */
    private static final int f12248x0 = C0409b.f6696F;

    /* renamed from: W, reason: collision with root package name */
    private Integer f12249W;

    /* renamed from: a0, reason: collision with root package name */
    private final C1115h f12250a0;

    /* renamed from: b0, reason: collision with root package name */
    private Animator f12251b0;

    /* renamed from: c0, reason: collision with root package name */
    private Animator f12252c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f12253d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f12254e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f12255f0;

    /* renamed from: g0, reason: collision with root package name */
    private final int f12256g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f12257h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f12258i0;

    /* renamed from: j0, reason: collision with root package name */
    private final boolean f12259j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f12260k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f12261l0;

    /* renamed from: m0, reason: collision with root package name */
    private ArrayList<g> f12262m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f12263n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f12264o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f12265p0;

    /* renamed from: q0, reason: collision with root package name */
    private Behavior f12266q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f12267r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f12268s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f12269t0;

    /* renamed from: u0, reason: collision with root package name */
    AnimatorListenerAdapter f12270u0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.r0();
            BottomAppBar.this.f12251b0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.s0();
        }
    }

    class b extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12277a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.r0();
            }
        }

        b(int i5) {
            this.f12277a = i5;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.w0(this.f12277a));
            floatingActionButton.q(new a());
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.r0();
            BottomAppBar.this.f12264o0 = false;
            BottomAppBar.this.f12252c0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.s0();
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f12282b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12283c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f12284d;

        d(ActionMenuView actionMenuView, int i5, boolean z5) {
            this.f12282b = actionMenuView;
            this.f12283c = i5;
            this.f12284d = z5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12281a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f12281a) {
                return;
            }
            boolean z5 = BottomAppBar.this.f12263n0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.B0(bottomAppBar.f12263n0);
            BottomAppBar.this.H0(this.f12282b, this.f12283c, this.f12284d, z5);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f12286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12287b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f12288c;

        e(ActionMenuView actionMenuView, int i5, boolean z5) {
            this.f12286a = actionMenuView;
            this.f12287b = i5;
            this.f12288c = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12286a.setTranslationX(BottomAppBar.this.v0(r0, this.f12287b, this.f12288c));
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f12270u0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonT0 = BottomAppBar.this.t0();
            if (floatingActionButtonT0 != null) {
                floatingActionButtonT0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    static class h extends androidx.customview.view.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f12291a;

        /* renamed from: b, reason: collision with root package name */
        boolean f12292b;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i5) {
                return new h[i5];
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f12291a);
            parcel.writeInt(this.f12292b ? 1 : 0);
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12291a = parcel.readInt();
            this.f12292b = parcel.readInt() != 0;
        }
    }

    private Drawable A0(Drawable drawable) {
        if (drawable == null || this.f12249W == null) {
            return drawable;
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
        drawableR.setTint(this.f12249W.intValue());
        return drawableR;
    }

    private void C0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f12252c0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (x0()) {
            G0(actionMenuView, this.f12253d0, this.f12265p0);
        } else {
            G0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        getTopEdgeTreatment().s(getFabTranslationX());
        this.f12250a0.h0((this.f12265p0 && x0() && this.f12255f0 == 1) ? 1.0f : 0.0f);
        View viewU0 = u0();
        if (viewU0 != null) {
            viewU0.setTranslationY(getFabTranslationY());
            viewU0.setTranslationX(getFabTranslationX());
        }
    }

    private void G0(ActionMenuView actionMenuView, int i5, boolean z5) {
        H0(actionMenuView, i5, z5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(ActionMenuView actionMenuView, int i5, boolean z5, boolean z6) {
        e eVar = new e(actionMenuView, i5, z5);
        if (z6) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f9428d = 17;
        int i5 = bottomAppBar.f12255f0;
        if (i5 == 1) {
            fVar.f9428d = 17 | 48;
        }
        if (i5 == 0) {
            fVar.f9428d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f12267r0;
    }

    private int getFabAlignmentAnimationDuration() {
        return o1.e.f(getContext(), f12247w0, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return w0(this.f12253d0);
    }

    private float getFabTranslationY() {
        if (this.f12255f0 == 1) {
            return -getTopEdgeTreatment().e();
        }
        return u0() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f12269t0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f12268s0;
    }

    private com.google.android.material.bottomappbar.b getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.b) this.f12250a0.I().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f12270u0);
        floatingActionButton.f(new f());
        floatingActionButton.g(null);
    }

    private void n0() {
        Animator animator = this.f12252c0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f12251b0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void p0(int i5, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(t0(), "translationX", w0(i5));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    private void q0(int i5, boolean z5, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        animatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - v0(actionMenuView, i5, z5)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat.addListener(new d(actionMenuView, i5, z5));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        ArrayList<g> arrayList;
        int i5 = this.f12261l0 - 1;
        this.f12261l0 = i5;
        if (i5 != 0 || (arrayList = this.f12262m0) == null) {
            return;
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            g gVar = arrayList.get(i6);
            i6++;
            gVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ArrayList<g> arrayList;
        int i5 = this.f12261l0;
        this.f12261l0 = i5 + 1;
        if (i5 != 0 || (arrayList = this.f12262m0) == null) {
            return;
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            g gVar = arrayList.get(i6);
            i6++;
            gVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton t0() {
        View viewU0 = u0();
        if (viewU0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewU0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View u0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).F(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float w0(int i5) {
        boolean zG = r.g(this);
        if (i5 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((zG ? this.f12269t0 : this.f12268s0) + ((this.f12257h0 == -1 || u0() == null) ? this.f12256g0 : (r6.getMeasuredWidth() / 2) + this.f12257h0))) * (zG ? -1 : 1);
    }

    private boolean x0() {
        FloatingActionButton floatingActionButtonT0 = t0();
        return floatingActionButtonT0 != null && floatingActionButtonT0.n();
    }

    private void y0(int i5, boolean z5) {
        if (!isLaidOut()) {
            this.f12264o0 = false;
            B0(this.f12263n0);
            return;
        }
        Animator animator = this.f12252c0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!x0()) {
            i5 = 0;
            z5 = false;
        }
        q0(i5, z5, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f12252c0 = animatorSet;
        animatorSet.addListener(new c());
        this.f12252c0.start();
    }

    private void z0(int i5) {
        if (this.f12253d0 == i5 || !isLaidOut()) {
            return;
        }
        Animator animator = this.f12251b0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f12254e0 == 1) {
            p0(i5, arrayList);
        } else {
            o0(i5, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(o1.e.g(getContext(), f12248x0, C0553a.f11783a));
        this.f12251b0 = animatorSet;
        animatorSet.addListener(new a());
        this.f12251b0.start();
    }

    public void B0(int i5) {
        if (i5 != 0) {
            this.f12263n0 = 0;
            getMenu().clear();
            x(i5);
        }
    }

    public void E0(int i5, int i6) {
        this.f12263n0 = i6;
        this.f12264o0 = true;
        y0(i5, this.f12265p0);
        z0(i5);
        this.f12253d0 = i5;
    }

    boolean F0(int i5) {
        float f5 = i5;
        if (f5 == getTopEdgeTreatment().j()) {
            return false;
        }
        getTopEdgeTreatment().q(f5);
        this.f12250a0.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.f12250a0.M();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().e();
    }

    public int getFabAlignmentMode() {
        return this.f12253d0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f12257h0;
    }

    public int getFabAnchorMode() {
        return this.f12255f0;
    }

    public int getFabAnimationMode() {
        return this.f12254e0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().h();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().i();
    }

    public boolean getHideOnScroll() {
        return this.f12260k0;
    }

    public int getMenuAlignmentMode() {
        return this.f12258i0;
    }

    protected void o0(int i5, List<Animator> list) {
        FloatingActionButton floatingActionButtonT0 = t0();
        if (floatingActionButtonT0 == null || floatingActionButtonT0.m()) {
            return;
        }
        s0();
        floatingActionButtonT0.k(new b(i5));
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1116i.f(this, this.f12250a0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (z5) {
            n0();
            D0();
            final View viewU0 = u0();
            if (viewU0 != null && viewU0.isLaidOut()) {
                viewU0.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewU0.requestLayout();
                    }
                });
            }
        }
        C0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        this.f12253d0 = hVar.f12291a;
        this.f12265p0 = hVar.f12292b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f12291a = this.f12253d0;
        hVar.f12292b = this.f12265p0;
        return hVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.f12250a0.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(float f5) {
        if (f5 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().k(f5);
            this.f12250a0.invalidateSelf();
            D0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        this.f12250a0.f0(f5);
        getBehavior().l(this, this.f12250a0.H() - this.f12250a0.G());
    }

    public void setFabAlignmentMode(int i5) {
        E0(i5, 0);
    }

    public void setFabAlignmentModeEndMargin(int i5) {
        if (this.f12257h0 != i5) {
            this.f12257h0 = i5;
            D0();
        }
    }

    public void setFabAnchorMode(int i5) {
        this.f12255f0 = i5;
        D0();
        View viewU0 = u0();
        if (viewU0 != null) {
            I0(this, viewU0);
            viewU0.requestLayout();
            this.f12250a0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i5) {
        this.f12254e0 = i5;
    }

    void setFabCornerSize(float f5) {
        if (f5 != getTopEdgeTreatment().g()) {
            getTopEdgeTreatment().l(f5);
            this.f12250a0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f5) {
        if (f5 != getFabCradleMargin()) {
            getTopEdgeTreatment().n(f5);
            this.f12250a0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f5) {
        if (f5 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().p(f5);
            this.f12250a0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z5) {
        this.f12260k0 = z5;
    }

    public void setMenuAlignmentMode(int i5) {
        if (this.f12258i0 != i5) {
            this.f12258i0 = i5;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                G0(actionMenuView, this.f12253d0, x0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(A0(drawable));
    }

    public void setNavigationIconTint(int i5) {
        this.f12249W = Integer.valueOf(i5);
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

    protected int v0(ActionMenuView actionMenuView, int i5, boolean z5) throws Resources.NotFoundException {
        int i6 = 0;
        if (this.f12258i0 != 1 && (i5 != 1 || !z5)) {
            return 0;
        }
        boolean zG = r.g(this);
        int measuredWidth = zG ? getMeasuredWidth() : 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f7517a & 8388615) == 8388611) {
                measuredWidth = zG ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zG ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i8 = zG ? this.f12268s0 : -this.f12269t0;
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(C0411d.f6794n);
            if (!zG) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
            i6 = dimensionPixelOffset;
        }
        return measuredWidth - ((right + i8) + i6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f12266q0 == null) {
            this.f12266q0 = new Behavior();
        }
        return this.f12266q0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: p, reason: collision with root package name */
        private final Rect f12271p;

        /* renamed from: q, reason: collision with root package name */
        private WeakReference<BottomAppBar> f12272q;

        /* renamed from: r, reason: collision with root package name */
        private int f12273r;

        /* renamed from: s, reason: collision with root package name */
        private final View.OnLayoutChangeListener f12274s;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f12272q.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.h(Behavior.this.f12271p);
                    int iHeight = Behavior.this.f12271p.height();
                    bottomAppBar.F0(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f12271p)));
                    height = iHeight;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f12273r == 0) {
                    if (bottomAppBar.f12255f0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(C0411d.f6760O) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (r.g(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.f12256g0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.f12256g0;
                    }
                }
                bottomAppBar.D0();
            }
        }

        public Behavior() {
            this.f12274s = new a();
            this.f12271p = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i5) {
            this.f12272q = new WeakReference<>(bottomAppBar);
            View viewU0 = bottomAppBar.u0();
            if (viewU0 != null && !viewU0.isLaidOut()) {
                BottomAppBar.I0(bottomAppBar, viewU0);
                this.f12273r = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewU0.getLayoutParams())).bottomMargin;
                if (viewU0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewU0;
                    if (bottomAppBar.f12255f0 == 0 && bottomAppBar.f12259j0) {
                        floatingActionButton.setElevation(0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(C0408a.f6688b);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(C0408a.f6687a);
                    }
                    bottomAppBar.m0(floatingActionButton);
                }
                viewU0.addOnLayoutChangeListener(this.f12274s);
                bottomAppBar.D0();
            }
            coordinatorLayout.W(bottomAppBar, i5);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i5);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i5, int i6) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i5, i6);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12274s = new a();
            this.f12271p = new Rect();
        }
    }
}
