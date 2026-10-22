package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged;
        private final View mView;

        FadeAnimatorListener(View r2) {
            this.mLayerTypeChanged = false;
            this.mView = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            if (ViewCompat.z(this.mView) == true) goto L5;
            return;
        L5:
            if (this.mView.getLayerType() != 0) goto L9;
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            af.a(this.mView, 1.0f);
            if (this.mLayerTypeChanged == false) goto L6;
            this.mView.setLayerType(0, null);
            return;
        }
    }

    public Fade(int r1) {
        a(r1);
    }

    public Fade() {
    }

    @Override // androidx.transition.Visibility, androidx.transition.s
    public void a(w r2) {
        super.a(r2);
        r2.f2869a.put("android:fade:transitionAlpha", Float.valueOf(af.c(r2.f2870b)));
    }

    private Animator a(final View r3, float r4, float r5) {
        if (r4 != r5) goto L6;
        return null;
    L6:
        af.a(r3, r4);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, af.f2791a, new float[]{r5});
        r6.addListener(new FadeAnimatorListener(r3));
        a(new AnonymousClass1(this, r3));
        return r6;
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup r2, View r3, w r4, w r5) {
        float r6 = 0.0f;
        float r7 = a(r4, 0.0f);
        if (r7 == 1.0f) goto L7;
        r6 = r7;
    L7:
        return a(r3, r6, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup r1, View r2, w r3, w r4) {
        af.d(r2);
        return a(r2, a(r3, 1.0f), 0.0f);
    }

    private static float a(w r2, float r3) {
        if (r2 == null) goto L7;
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(r2.f2869a.get("android:fade:transitionAlpha"), Float.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return r3;
    L6:
        return r4.floatValue();
    L7:
        return r3;
    }
}
