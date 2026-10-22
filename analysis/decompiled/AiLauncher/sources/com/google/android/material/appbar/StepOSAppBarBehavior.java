package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.e;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.common.R$bool;
import java.lang.reflect.Field;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.n;

/* loaded from: classes2.dex */
public class StepOSAppBarBehavior extends AppBarLayout.Behavior implements n {

    /* renamed from: m, reason: collision with root package name */
    public final String f20253m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f20254n;

    /* renamed from: o, reason: collision with root package name */
    public CoordinatorLayout f20255o;

    /* renamed from: p, reason: collision with root package name */
    public AppBarLayout f20256p;

    /* renamed from: q, reason: collision with root package name */
    public n f20257q;

    /* renamed from: r, reason: collision with root package name */
    public Fc.a f20258r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20259s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20260t;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StepOSAppBarLayout.a f20261a;

        public a(StepOSAppBarLayout.a aVar) {
            this.f20261a = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (StepOSAppBarBehavior.this.f20255o == null || StepOSAppBarBehavior.this.f20256p == null) {
                return;
            }
            StepOSAppBarBehavior stepOSAppBarBehavior = StepOSAppBarBehavior.this;
            stepOSAppBarBehavior.o(stepOSAppBarBehavior.f20255o, StepOSAppBarBehavior.this.f20256p, ((Integer) this.f20261a.getAnimatedValue()).intValue());
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            StepOSAppBarBehavior.this.f20260t = false;
            if (StepOSAppBarBehavior.this.f20258r != null) {
                Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                StepOSAppBarBehavior.this.f20258r.b();
                StepOSAppBarBehavior.this.c();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            StepOSAppBarBehavior.this.f20260t = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            super.onAnimationPause(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            super.onAnimationResume(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            StepOSAppBarBehavior.this.f20260t = true;
        }
    }

    public class c implements e.q {
        public c() {
        }

        @Override // androidx.dynamicanimation.animation.e.q
        public void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
            StepOSAppBarBehavior.this.f20259s = false;
            StepOSAppBarBehavior.this.d0();
        }
    }

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f20253m = " [StepOSAppBarBehavior] ";
        this.f20258r = null;
        this.f20259s = false;
        this.f20260t = false;
        h0();
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: P */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        g0(coordinatorLayout, appBarLayout);
        if (coordinatorLayout.getContext().getResources().getBoolean(R$bool.is_mini_square)) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i10, i11);
    }

    @Override // stepos.support.v7.widget.n
    public void a(float f10) {
        n nVar = this.f20257q;
        if (nVar != null) {
            nVar.a(f10);
        }
    }

    @Override // stepos.support.v7.widget.n
    public void c() {
        n nVar = this.f20257q;
        if (nVar != null) {
            nVar.c();
        }
    }

    public final void d0() {
        if (this.f20259s || this.f20260t) {
            return;
        }
        c();
    }

    public final ValueAnimator e0() {
        StepOSAppBarLayout.a aVar = new StepOSAppBarLayout.a();
        aVar.setInterpolator(stepos.support.v7.widget.d.f41540i);
        aVar.addUpdateListener(new a(aVar));
        aVar.addListener(new b());
        return aVar;
    }

    public final Fc.a f0(Context context) {
        return new Fc.a(new TextView(context), 0.92f, 300.0f, new c(), true);
    }

    public void g0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        stepos.support.v7.widget.f fVar;
        if (this.f20255o == null) {
            this.f20255o = coordinatorLayout;
            this.f20256p = appBarLayout;
            this.f20258r = f0(appBarLayout.getContext());
            int childCount = appBarLayout.getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    fVar = null;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i10);
                if (childAt instanceof stepos.support.v7.widget.f) {
                    fVar = (stepos.support.v7.widget.f) childAt;
                    break;
                }
                i10++;
            }
            if (fVar != null) {
                this.f20257q = fVar.getTitleScaleControl();
            }
        }
    }

    public final void h0() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            ValueAnimator valueAnimator = this.f20254n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorE0 = e0();
            this.f20254n = valueAnimatorE0;
            declaredField.set(this, valueAnimatorE0);
        } catch (Exception e10) {
            Log.e(" [StepOSAppBarBehavior] ", "initSnapAnimator: " + e10);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.getContext().getResources().getBoolean(R$bool.is_mini_square)) {
            return true;
        }
        return super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f20253m = " [StepOSAppBarBehavior] ";
        this.f20258r = null;
        this.f20259s = false;
        this.f20260t = false;
        h0();
    }
}
