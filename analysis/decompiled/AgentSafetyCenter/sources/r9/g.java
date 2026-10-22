package r9;

import android.animation.ValueAnimator;
import com.stepos.common.animator.StepOSPressAnimationDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10503a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ StepOSPressAnimationDrawable f10504b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10503a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f10504b;
                stepOSPressAnimationDrawable.f2518j = (int) (fFloatValue * 255.0f);
                stepOSPressAnimationDrawable.invalidateSelf();
                break;
            default:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable2 = this.f10504b;
                stepOSPressAnimationDrawable2.f2518j = (int) (fFloatValue2 * 255.0f);
                stepOSPressAnimationDrawable2.invalidateSelf();
                break;
        }
    }
}
