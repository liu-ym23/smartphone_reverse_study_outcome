package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class FragmentAnim {

    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animator r100) {
            this.animation = null;
            this.animator = r100;
            if (r100 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }

        public AnimationOrAnimator(Animation r100) {
            this.animation = r100;
            this.animator = null;
            if (r100 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        @Override // java.lang.Runnable
        public void run() {
            androidx_fragment_app_FragmentAnim$EndViewTransitionAnimation_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_fragment_app_FragmentAnim$EndViewTransitionAnimation__run$___twin___() {
            if (this.mEnded == false) goto L5;
        L7:
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        L5:
            if (this.mAnimating == false) goto L7;
            this.mAnimating = false;
            this.mParent.post(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_fragment_app_FragmentAnim$EndViewTransitionAnimation_com_larus_apm_impl_protector_RunnableLancet_run(EndViewTransitionAnimation r100) {
            r100.androidx_fragment_app_FragmentAnim$EndViewTransitionAnimation__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r100, Transformation r101) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r100, r101) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        public EndViewTransitionAnimation(Animation r100, ViewGroup r101, View r102) {
            super(false);
            this.mAnimating = true;
            this.mParent = r101;
            this.mChild = r102;
            addAnimation(r100);
            r101.post(this);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r100, Transformation r101, float r102) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r100, r101, r102) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }
    }

    private FragmentAnim() {
    }

    private static int toActivityTransitResId(Context r100, int r101) {
        TypedArray r102 = r100.obtainStyledAttributes(R.style.Animation.Activity, new int[]{r101});
        int r103 = r102.getResourceId(0, -1);
        r102.recycle();
        return r103;
    }

    private static int getNextAnim(Fragment r100, boolean r101, boolean r102) {
        if (r102 == false) goto L8;
        if (r101 == false) goto L7;
        return r100.getPopEnterAnim();
    L7:
        return r100.getPopExitAnim();
    L8:
        if (r101 == false) goto L12;
        return r100.getEnterAnim();
    L12:
        return r100.getExitAnim();
    }

    private static int transitToAnimResourceId(Context r100, int r101, boolean r102) {
        if (r101 != 4097) goto L5;
        if (r102 == false) goto L27;
        return com.larus.nova.R.animator.fragment_open_enter;
    L27:
        return com.larus.nova.R.animator.fragment_open_exit;
    L5:
        if (r101 != 8194) goto L7;
        if (r102 == false) goto L24;
        return com.larus.nova.R.animator.fragment_close_enter;
    L24:
        return com.larus.nova.R.animator.fragment_close_exit;
    L7:
        if (r101 != 8197) goto L9;
        if (r102 == false) goto L35;
        return toActivityTransitResId(r100, R.attr.activityCloseEnterAnimation);
    L35:
        return toActivityTransitResId(r100, R.attr.activityCloseExitAnimation);
    L9:
        if (r101 != 4099) goto L11;
        if (r102 == false) goto L18;
        return com.larus.nova.R.animator.fragment_fade_enter;
    L18:
        return com.larus.nova.R.animator.fragment_fade_exit;
    L11:
        if (r101 == 4100) goto L13;
        return -1;
    L13:
        if (r102 == false) goto L31;
        return toActivityTransitResId(r100, R.attr.activityOpenEnterAnimation);
    L31:
        return toActivityTransitResId(r100, R.attr.activityOpenExitAnimation);
    }

    public static AnimationOrAnimator loadAnimation(Context r100, Fragment r101, boolean r102, boolean r103) {
        int r104 = r101.getNextTransition();
        int r105 = getNextAnim(r101, r102, r103);
        boolean r106 = false;
        r101.setAnimations(0, 0, 0, 0);
        ViewGroup r107 = r101.mContainer;
        if (r107 != null) goto L5;
    L7:
        ViewGroup r108 = r101.mContainer;
        if (r108 != null) goto L10;
    L12:
        Animation r109 = r101.onCreateAnimation(r104, r102, r105);
        if (r109 != null) goto L15;
        Animator r110 = r101.onCreateAnimator(r104, r102, r105);
        if (r110 != null) goto L19;
        if (r105 != 0) goto L23;
        if (r104 == 0) goto L23;
        r105 = transitToAnimResourceId(r100, r104, r102);
    L23:
        if (r105 == 0) goto L46;
        boolean r111 = "anim".equals(r100.getResources().getResourceTypeName(r105));
        if (r111 == true) goto L49;
    L34:
        if (r106 == true) goto L46;
        Animator r112 = AnimatorInflater.loadAnimator(r100, r105);     // Catch: RuntimeException -> L39
        if (r112 == null) goto L46;
        return new AnimationOrAnimator(r112);
    L39:
        e = move-exception;
        if (r111 == true) goto L45;
        Animation r113 = AnimationUtils.loadAnimation(r100, r105);
        if (r113 == null) goto L46;
        return new AnimationOrAnimator(r113);
    L45:
        throw e;
    L49:
        Animation r114 = AnimationUtils.loadAnimation(r100, r105);     // Catch: RuntimeException -> L31 Resources.NotFoundException -> L32
        if (r114 == null) goto L30;
        return new AnimationOrAnimator(r114);
        goto L34
    L30:
        r106 = true;
    L32:
        e = move-exception;
        throw e;
    L46:
        return null;
    L19:
        return new AnimationOrAnimator(r110);
    L15:
        return new AnimationOrAnimator(r109);
    L10:
        if (r108.getLayoutTransition() == null) goto L12;
        return null;
    L5:
        if (r107.getTag(com.larus.nova.R.id.visible_removing_fragment_view_tag) == null) goto L7;
        r101.mContainer.setTag(com.larus.nova.R.id.visible_removing_fragment_view_tag, null);
        goto L7
    }
}
