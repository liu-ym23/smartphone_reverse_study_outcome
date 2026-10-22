package A6;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import com.stepos.motionkit.fx.backend.sf.SfDrawableChannel;
import com.stepos.taskrobot.llmapi.stepfun.view.blur.BlurCardView;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import j3.C1595a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f149a;
    public final /* synthetic */ Object b;

    public /* synthetic */ j(Object obj, int i) {
        this.f149a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator it) {
        int i = this.f149a;
        Object obj = this.b;
        switch (i) {
            case 0:
                StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) obj;
                int i6 = StepOSAlertDialogLayout.p;
                kotlin.jvm.internal.k.f(it, "it");
                Object animatedValue = it.getAnimatedValue();
                kotlin.jvm.internal.k.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                stepOSAlertDialogLayout.e = ((Integer) animatedValue).intValue();
                stepOSAlertDialogLayout.invalidate();
                break;
            case 1:
                E6.g gVar = (E6.g) obj;
                kotlin.jvm.internal.k.f(it, "animation");
                Object animatedValue2 = it.getAnimatedValue();
                kotlin.jvm.internal.k.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                gVar.l = ((Float) animatedValue2).floatValue();
                gVar.invalidateSelf();
                break;
            case 2:
                T2.c cVar = (T2.c) obj;
                cVar.getClass();
                float fFloatValue = ((Float) it.getAnimatedValue()).floatValue();
                cVar.f1196j.setAlpha((int) (255.0f * fFloatValue));
                cVar.f1203x = fFloatValue;
                break;
            case 3:
                com.google.android.material.slider.f fVar = (com.google.android.material.slider.f) obj;
                float fFloatValue2 = ((Float) it.getAnimatedValue()).floatValue();
                Iterator it2 = fVar.l.iterator();
                while (it2.hasNext()) {
                    C1595a c1595a = (C1595a) it2.next();
                    c1595a.f4768Y = fFloatValue2;
                    c1595a.f4769Z = fFloatValue2;
                    c1595a.f4771c0 = Q2.a.b(0.0f, 1.0f, 0.19f, 1.0f, fFloatValue2);
                    c1595a.invalidateSelf();
                }
                fVar.postInvalidateOnAnimation();
                break;
            case 4:
                com.google.android.material.textfield.j jVar = (com.google.android.material.textfield.j) obj;
                jVar.getClass();
                jVar.d.setAlpha(((Float) it.getAnimatedValue()).floatValue());
                break;
            case 5:
                SfDrawableChannel.stopEffect$lambda$1$lambda$0((SfDrawableChannel) obj, it);
                break;
            default:
                BlurCardView.createBlurFadeOutAnimator$lambda$0$0((Drawable) obj, it);
                break;
        }
    }
}
