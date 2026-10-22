package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import stepos.support.v7.app.a;

/* loaded from: classes.dex */
public class ActionBarDropDownView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final Interpolator f21471h = androidx.core.view.animation.a.a(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    private static final Interpolator f21472i = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    private View f21473a;

    /* renamed from: b, reason: collision with root package name */
    private int f21474b;

    /* renamed from: c, reason: collision with root package name */
    private int f21475c;

    /* renamed from: d, reason: collision with root package name */
    private View f21476d;

    /* renamed from: e, reason: collision with root package name */
    private AnimatorSet f21477e;

    /* renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f21478f;

    /* renamed from: g, reason: collision with root package name */
    private Animator.AnimatorListener f21479g;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21480a;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f21480a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f21480a) {
                return;
            }
            ActionBarDropDownView.this.f21475c = 3;
            ActionBarDropDownView.b(ActionBarDropDownView.this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView.this.f21475c = 2;
            ActionBarDropDownView.this.setVisibility(0);
            this.f21480a = false;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21482a;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f21482a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f21482a) {
                return;
            }
            ActionBarDropDownView.this.f21475c = 1;
            ActionBarDropDownView.this.setVisibility(4);
            ActionBarDropDownView.b(ActionBarDropDownView.this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView.this.f21475c = 0;
            this.f21482a = false;
        }
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ a.d b(ActionBarDropDownView actionBarDropDownView) {
        actionBarDropDownView.getClass();
        return null;
    }

    private void d() {
        AnimatorSet animatorSet = this.f21477e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f21473a.setTranslationY(-this.f21474b);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21473a, "translationY", 0.0f);
        objectAnimatorOfFloat.setInterpolator(f21471h);
        AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
        this.f21476d.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21476d, "alpha", 1.0f);
        objectAnimatorOfFloat2.setInterpolator(f21472i);
        builderPlay.with(objectAnimatorOfFloat2);
        animatorSet2.setDuration(350L);
        animatorSet2.addListener(this.f21478f);
        animatorSet2.start();
        this.f21477e = animatorSet2;
    }

    public void c() {
        int i5 = this.f21475c;
        if (i5 == 1 || i5 == 0) {
            return;
        }
        AnimatorSet animatorSet = this.f21477e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21473a, "translationY", -this.f21474b);
        objectAnimatorOfFloat.setInterpolator(f21471h);
        AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21476d, "alpha", 0.0f);
        objectAnimatorOfFloat2.setInterpolator(f21472i);
        builderPlay.with(objectAnimatorOfFloat2);
        animatorSet2.setDuration(350L);
        animatorSet2.addListener(this.f21479g);
        animatorSet2.start();
        this.f21477e = animatorSet2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        View view;
        super.onMeasure(i5, i6);
        if (getVisibility() == 0 && (view = this.f21473a) != null) {
            int measuredHeight = view.getMeasuredHeight();
            this.f21474b = measuredHeight;
            if (this.f21475c != 1 || measuredHeight <= 0) {
                return;
            }
            d();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCallback(a.d dVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21474b = -1;
        this.f21475c = 1;
        this.f21478f = new a();
        this.f21479g = new b();
        View view = new View(context);
        this.f21476d = view;
        view.setBackgroundColor(context.getResources().getColor(X4.c.f5855a));
        addView(this.f21476d, -1, -1);
    }
}
