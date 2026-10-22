package T2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b.C1423c;
import com.google.android.material.R$dimen;

/* loaded from: classes2.dex */
public class e extends T2.a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f5857g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5858h;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f5845b.setTranslationY(0.0f);
            e.this.k(0.0f);
        }
    }

    public e(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f5857g = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f5858h = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.f5848e);
        animatorG.start();
    }

    public final Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f5845b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f5845b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f5845b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new T0.b());
        return animatorSet;
    }

    public void h(C1423c c1423c, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f5845b, (Property<V, Float>) View.TRANSLATION_Y, this.f5845b.getHeight() * this.f5845b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new T0.b());
        objectAnimatorOfFloat.setDuration(E2.a.c(this.f5846c, this.f5847d, c1423c.getProgress()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(C1423c c1423c, Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(E2.a.c(this.f5846c, this.f5847d, c1423c.getProgress()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(C1423c c1423c) {
        super.d(c1423c);
    }

    public void k(float f10) {
        float fA = a(f10);
        float width = this.f5845b.getWidth();
        float height = this.f5845b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f11 = this.f5857g / width;
        float f12 = this.f5858h / height;
        float fA2 = 1.0f - E2.a.a(0.0f, f11, fA);
        float fA3 = 1.0f - E2.a.a(0.0f, f12, fA);
        if (Float.isNaN(fA2) || Float.isNaN(fA3)) {
            return;
        }
        this.f5845b.setScaleX(fA2);
        this.f5845b.setPivotY(height);
        this.f5845b.setScaleY(fA3);
        V v10 = this.f5845b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View childAt = viewGroup.getChildAt(i10);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(C1423c c1423c) {
        if (super.e(c1423c) == null) {
            return;
        }
        k(c1423c.getProgress());
    }
}
