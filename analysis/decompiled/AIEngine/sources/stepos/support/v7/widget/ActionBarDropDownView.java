package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.stepos.aiengine.R;
import stepos.support.v7.app.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ActionBarDropDownView extends FrameLayout {
    public static final PathInterpolator h = new PathInterpolator(0.12f, 0.31f, 0.1f, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final PathInterpolator f12465j = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final int f12466a;

    /* renamed from: b, reason: collision with root package name */
    public int f12467b;

    /* renamed from: c, reason: collision with root package name */
    public final View f12468c;

    /* renamed from: d, reason: collision with root package name */
    public AnimatorSet f12469d;

    /* renamed from: e, reason: collision with root package name */
    public final b f12470e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12471a;

        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f12471a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f12471a) {
                return;
            }
            ActionBarDropDownView.this.f12467b = 3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView actionBarDropDownView = ActionBarDropDownView.this;
            actionBarDropDownView.f12467b = 2;
            actionBarDropDownView.setVisibility(0);
            this.f12471a = false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12473a;

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f12473a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f12473a) {
                return;
            }
            ActionBarDropDownView actionBarDropDownView = ActionBarDropDownView.this;
            actionBarDropDownView.f12467b = 1;
            actionBarDropDownView.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ActionBarDropDownView.this.f12467b = 0;
            this.f12473a = false;
        }
    }

    public ActionBarDropDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12466a = -1;
        this.f12467b = 1;
        new a();
        this.f12470e = new b();
        View view = new View(context);
        this.f12468c = view;
        view.setBackgroundColor(context.getResources().getColor(R.color.stepos_action_bar_drop_down_view_background));
        addView(view, -1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        getVisibility();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1 && (i10 = this.f12467b) != 1 && i10 != 0) {
            AnimatorSet animatorSet = this.f12469d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, "translationY", -this.f12466a);
            objectAnimatorOfFloat.setInterpolator(h);
            AnimatorSet.Builder builderPlay = animatorSet2.play(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12468c, "alpha", 0.0f);
            objectAnimatorOfFloat2.setInterpolator(f12465j);
            builderPlay.with(objectAnimatorOfFloat2);
            animatorSet2.setDuration(350L);
            animatorSet2.addListener(this.f12470e);
            animatorSet2.start();
            this.f12469d = animatorSet2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void setCallback(a.b bVar) {
    }
}
