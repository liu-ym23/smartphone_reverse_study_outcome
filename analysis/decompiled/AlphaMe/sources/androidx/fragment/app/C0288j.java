package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.stepos.alphame.R;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0288j extends AbstractC0289k {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3771c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3772d;

    /* renamed from: e, reason: collision with root package name */
    public H f3773e;

    public final H c(Context context) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        H h4;
        if (this.f3772d) {
            return this.f3773e;
        }
        q0 q0Var = this.f3775a;
        D d4 = q0Var.f3803c;
        boolean z4 = q0Var.f3801a == 2;
        int nextTransition = d4.getNextTransition();
        int popEnterAnim = this.f3771c ? z4 ? d4.getPopEnterAnim() : d4.getPopExitAnim() : z4 ? d4.getEnterAnim() : d4.getExitAnim();
        d4.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = d4.mContainer;
        H h5 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            d4.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = d4.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation animationOnCreateAnimation = d4.onCreateAnimation(nextTransition, z4, popEnterAnim);
            if (animationOnCreateAnimation != null) {
                h5 = new H(animationOnCreateAnimation);
            } else {
                Animator animatorOnCreateAnimator = d4.onCreateAnimator(nextTransition, z4, popEnterAnim);
                if (animatorOnCreateAnimator != null) {
                    h5 = new H(animatorOnCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z4 ? com.airbnb.lottie.h.J(android.R.attr.activityOpenEnterAnimation, context) : com.airbnb.lottie.h.J(android.R.attr.activityOpenExitAnimation, context) : z4 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z4 ? com.airbnb.lottie.h.J(android.R.attr.activityCloseEnterAnimation, context) : com.airbnb.lottie.h.J(android.R.attr.activityCloseExitAnimation, context) : z4 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z4 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        if (zEquals) {
                            try {
                                animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                            } catch (Resources.NotFoundException e4) {
                                throw e4;
                            } catch (RuntimeException unused) {
                            }
                            if (animationLoadAnimation != null) {
                                h4 = new H(animationLoadAnimation);
                                h5 = h4;
                            }
                        } else {
                            try {
                                Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                if (animatorLoadAnimator != null) {
                                    h4 = new H(animatorLoadAnimator);
                                    h5 = h4;
                                }
                            } catch (RuntimeException e5) {
                                if (zEquals) {
                                    throw e5;
                                }
                                Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                if (animationLoadAnimation2 != null) {
                                    h5 = new H(animationLoadAnimation2);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f3773e = h5;
        this.f3772d = true;
        return h5;
    }
}
