package ay3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static AnimatorSet a(XToast r110, int r111) {
        Context r100 = r110.f193806c.getContext();
        if (r111 == 1) goto L13;
        if (r111 != 2) goto L6;
        AnimatorSet r112 = new AnimatorSet();
        r112.setDuration(160);
        r112.playTogether(new Animator[]{ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f})});
        return r112;
    L6:
        if (r111 == 3) goto L9;
        AnimatorSet r113 = new AnimatorSet();
        r113.setDuration(160);
        r113.play(ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{1.0f, 0.0f}));
        return r113;
    L9:
        AnimatorSet r114 = new AnimatorSet();
        r114.setDuration(160);
        View r101 = r110.f193806c;
        r114.playTogether(new Animator[]{ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r101.getMeasuredHeight()}), ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{1.0f, 0.0f})});
        return r114;
    L13:
        AnimatorSet r115 = new AnimatorSet();
        r115.setDuration(160);
        r115.setInterpolator(new AccelerateInterpolator());
        r115.playTogether(new Animator[]{ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -n0.a(r100, 16.0f)}), ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{1.0f, 0.0f})});
        return r115;
    }

    public static AnimatorSet b(XToast r110, int r111) {
        Context r100 = r110.f193806c.getContext();
        if (r111 == 1) goto L13;
        if (r111 != 2) goto L6;
        AnimatorSet r112 = new AnimatorSet();
        r112.setDuration(260);
        r112.playTogether(new Animator[]{ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f})});
        return r112;
    L6:
        if (r111 == 3) goto L9;
        AnimatorSet r113 = new AnimatorSet();
        r113.setDuration(260);
        r113.play(ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{0.0f, 1.0f}));
        return r113;
    L9:
        AnimatorSet r114 = new AnimatorSet();
        r114.setDuration(260);
        View r101 = r110.f193806c;
        r114.playTogether(new Animator[]{ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getMeasuredHeight(), 0.0f}), ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{0.0f, 1.0f})});
        return r114;
    L13:
        AnimatorSet r115 = new AnimatorSet();
        r115.playTogether(new Animator[]{ObjectAnimator.ofFloat(r110.f193806c, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-n0.a(r100, 16.0f), 0.0f}), ObjectAnimator.ofFloat(r110.f193806c, "alpha", new float[]{0.0f, 1.0f})});
        r115.setDuration(260);
        r115.setInterpolator(new DecelerateInterpolator());
        return r115;
    }
}
