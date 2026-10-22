package com.google.android.material.appbar;

import P.e;
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
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.p;

/* loaded from: classes.dex */
public class StepOSAppBarBehavior extends AppBarLayout.Behavior implements p {

    /* renamed from: m, reason: collision with root package name */
    private final String f12156m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f12157n;

    /* renamed from: o, reason: collision with root package name */
    private CoordinatorLayout f12158o;

    /* renamed from: p, reason: collision with root package name */
    private AppBarLayout f12159p;

    /* renamed from: q, reason: collision with root package name */
    private p f12160q;

    /* renamed from: r, reason: collision with root package name */
    private W4.a f12161r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12162s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12163t;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StepOSAppBarLayout.a f12164a;

        a(StepOSAppBarLayout.a aVar) {
            this.f12164a = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (StepOSAppBarBehavior.this.f12158o == null || StepOSAppBarBehavior.this.f12159p == null) {
                return;
            }
            StepOSAppBarBehavior stepOSAppBarBehavior = StepOSAppBarBehavior.this;
            stepOSAppBarBehavior.k(stepOSAppBarBehavior.f12158o, StepOSAppBarBehavior.this.f12159p, ((Integer) this.f12164a.getAnimatedValue()).intValue());
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            StepOSAppBarBehavior.this.f12163t = false;
            if (StepOSAppBarBehavior.this.f12161r != null) {
                Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                StepOSAppBarBehavior.this.f12161r.b();
                StepOSAppBarBehavior.this.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            StepOSAppBarBehavior.this.f12163t = false;
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
            StepOSAppBarBehavior.this.f12163t = true;
        }
    }

    class c implements e.q {
        c() {
        }

        @Override // P.e.q
        public void a(P.e eVar, boolean z5, float f5, float f6) {
            StepOSAppBarBehavior.this.f12162s = false;
            StepOSAppBarBehavior.this.Z();
        }
    }

    public StepOSAppBarBehavior() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.f12156m = " [StepOSAppBarBehavior] ";
        this.f12161r = null;
        this.f12162s = false;
        this.f12163t = false;
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.f12162s || this.f12163t) {
            return;
        }
        b();
    }

    private ValueAnimator a0() {
        StepOSAppBarLayout.a aVar = new StepOSAppBarLayout.a();
        aVar.setInterpolator(stepos.support.v7.widget.e.f21971i);
        aVar.addUpdateListener(new a(aVar));
        aVar.addListener(new b());
        return aVar;
    }

    private W4.a b0(Context context) {
        return new W4.a(new TextView(context), 0.92f, 300.0f, new c(), true);
    }

    private void d0() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getSuperclass().getDeclaredField("offsetAnimator");
            declaredField.setAccessible(true);
            ValueAnimator valueAnimator = this.f12157n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorA0 = a0();
            this.f12157n = valueAnimatorA0;
            declaredField.set(this, valueAnimatorA0);
        } catch (Exception e6) {
            Log.e(" [StepOSAppBarBehavior] ", "initSnapAnimator: " + e6);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: L */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i5, int i6) {
        c0(coordinatorLayout, appBarLayout);
        if (coordinatorLayout.getContext().getResources().getBoolean(H1.d.f2072a)) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i5, i6);
    }

    @Override // stepos.support.v7.widget.p
    public void a(float f5) {
        p pVar = this.f12160q;
        if (pVar != null) {
            pVar.a(f5);
        }
    }

    @Override // stepos.support.v7.widget.p
    public void b() {
        p pVar = this.f12160q;
        if (pVar != null) {
            pVar.b();
        }
    }

    public void c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        stepos.support.v7.widget.g gVar;
        if (this.f12158o == null) {
            this.f12158o = coordinatorLayout;
            this.f12159p = appBarLayout;
            this.f12161r = b0(appBarLayout.getContext());
            int childCount = appBarLayout.getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    gVar = null;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i5);
                if (childAt instanceof stepos.support.v7.widget.g) {
                    gVar = (stepos.support.v7.widget.g) childAt;
                    break;
                }
                i5++;
            }
            if (gVar != null) {
                this.f12160q = gVar.getTitleScaleControl();
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.getContext().getResources().getBoolean(H1.d.f2072a)) {
            return true;
        }
        return super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public StepOSAppBarBehavior(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        this.f12156m = " [StepOSAppBarBehavior] ";
        this.f12161r = null;
        this.f12162s = false;
        this.f12163t = false;
        d0();
    }
}
