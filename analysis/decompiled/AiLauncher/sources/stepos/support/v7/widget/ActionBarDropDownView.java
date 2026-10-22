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
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import stepos.support.v7.app.a;
import stepos.support.v7.appcompat.R$color;

/* loaded from: classes5.dex */
public class ActionBarDropDownView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f41089h = D0.a.a(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final Interpolator f41090i = D0.a.a(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public View f41091a;

    /* renamed from: b, reason: collision with root package name */
    public int f41092b;

    /* renamed from: c, reason: collision with root package name */
    public int f41093c;

    /* renamed from: d, reason: collision with root package name */
    public View f41094d;

    /* renamed from: e, reason: collision with root package name */
    public AnimatorSet f41095e;

    /* renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f41096f;

    /* renamed from: g, reason: collision with root package name */
    public Animator.AnimatorListener f41097g;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41098a;

        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f41098a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f41098a) {
                return;
            }
            ActionBarDropDownView.this.f41093c = 3;
            ActionBarDropDownView.b(ActionBarDropDownView.this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView.this.f41093c = 2;
            ActionBarDropDownView.this.setVisibility(0);
            this.f41098a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41100a;

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f41100a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f41100a) {
                return;
            }
            ActionBarDropDownView.this.f41093c = 1;
            ActionBarDropDownView.this.setVisibility(4);
            ActionBarDropDownView.b(ActionBarDropDownView.this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView.this.f41093c = 0;
            this.f41100a = false;
        }
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ a.c b(ActionBarDropDownView actionBarDropDownView) {
        actionBarDropDownView.getClass();
        return null;
    }

    public void c() {
        int i10 = this.f41093c;
        if (i10 == 1 || i10 == 0) {
            return;
        }
        AnimatorSet animatorSet = this.f41095e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f41091a, "translationY", -this.f41092b);
        objectAnimatorOfFloat.setInterpolator(f41089h);
        AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f41094d, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(f41090i);
        builderPlay.with(objectAnimatorOfFloat2);
        animatorSet2.setDuration(350L);
        animatorSet2.addListener(this.f41097g);
        animatorSet2.start();
        this.f41095e = animatorSet2;
    }

    public final void d() {
        AnimatorSet animatorSet = this.f41095e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f41091a.setTranslationY(-this.f41092b);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f41091a, "translationY", 0.0f);
        objectAnimatorOfFloat.setInterpolator(f41089h);
        AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
        this.f41094d.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f41094d, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 1.0f);
        objectAnimatorOfFloat2.setInterpolator(f41090i);
        builderPlay.with(objectAnimatorOfFloat2);
        animatorSet2.setDuration(350L);
        animatorSet2.addListener(this.f41096f);
        animatorSet2.start();
        this.f41095e = animatorSet2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        View view;
        super.onMeasure(i10, i11);
        if (getVisibility() == 0 && (view = this.f41091a) != null) {
            int measuredHeight = view.getMeasuredHeight();
            this.f41092b = measuredHeight;
            if (this.f41093c != 1 || measuredHeight <= 0) {
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

    public void setCallback(a.c cVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f41092b = -1;
        this.f41093c = 1;
        this.f41096f = new a();
        this.f41097g = new b();
        View view = new View(context);
        this.f41094d = view;
        view.setBackgroundColor(context.getResources().getColor(R$color.stepos_action_bar_drop_down_view_background));
        addView(this.f41094d, -1, -1);
    }
}
