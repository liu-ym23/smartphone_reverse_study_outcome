package A6;

import C7.r;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.appbar.StepOSAppBarBehavior;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.stepos.ability.voicewakeup.ui.TrainingPhraseCarousel;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.widget.SwimmingAnimationView;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import java.util.Iterator;
import m9.C1718k;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.r0;

/* loaded from: classes3.dex */
public final class m extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f152a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m(Object obj, int i) {
        this.f152a = i;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f152a) {
            case 5:
                super.onAnimationCancel(animator);
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.b;
                stepOSAppBarBehavior.f2286r = false;
                if (stepOSAppBarBehavior.f2285q != null) {
                    Log.i(" [StepOSAppBarBehavior] ", "releaseTitleScale stop by offsetAnimator cancle");
                    SpringAnimation springAnimation = stepOSAppBarBehavior.f2285q.f1131a;
                    if (springAnimation != null && springAnimation.isRunning()) {
                        springAnimation.cancel();
                    }
                    stepOSAppBarBehavior.a();
                    break;
                }
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        int i = this.f152a;
        Object obj = this.b;
        switch (i) {
            case 0:
                kotlin.jvm.internal.k.f(animation, "animation");
                ((StepOSAlertDialogLayout) obj).f = null;
                return;
            case 1:
                kotlin.jvm.internal.k.f(animation, "animation");
                E6.g gVar = (E6.g) obj;
                gVar.l = 0.0f;
                gVar.g.setAlpha(0);
                gVar.invalidateSelf();
                return;
            case 2:
                kotlin.jvm.internal.k.f(animation, "animation");
                TrainingPhraseCarousel trainingPhraseCarousel = (TrainingPhraseCarousel) obj;
                if (trainingPhraseCarousel.h != animation) {
                    return;
                }
                trainingPhraseCarousel.h = null;
                int[] iArr = trainingPhraseCarousel.g;
                int length = iArr.length;
                for (int i6 = 0; i6 < length; i6++) {
                    int i10 = iArr[i6];
                    iArr[i6] = i10 == 0 ? 3 : i10 - 1;
                }
                int i11 = trainingPhraseCarousel.l;
                if (i11 < trainingPhraseCarousel.k - 1) {
                    trainingPhraseCarousel.l = i11 + 1;
                }
                trainingPhraseCarousel.a();
                C1718k c1718k = trainingPhraseCarousel.i;
                if (c1718k != null) {
                    trainingPhraseCarousel.i = null;
                    if (c1718k.isActive()) {
                        c1718k.resumeWith(r.f317a);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                ((HideBottomViewOnScrollBehavior) obj).k = null;
                return;
            case 4:
                ((HideViewOnScrollBehavior) obj).l = null;
                return;
            case 5:
                super.onAnimationEnd(animation);
                ((StepOSAppBarBehavior) obj).f2286r = false;
                return;
            case 6:
                com.google.android.material.textfield.j jVar = (com.google.android.material.textfield.j) obj;
                jVar.q();
                jVar.f2672r.start();
                return;
            case 7:
            default:
                super.onAnimationEnd(animation);
                return;
            case 8:
                StepOSPressAnimationDrawable stepOSPressAnimationDrawable = (StepOSPressAnimationDrawable) obj;
                if (stepOSPressAnimationDrawable.f3555v) {
                    stepOSPressAnimationDrawable.f3555v = false;
                    stepOSPressAnimationDrawable.c();
                    return;
                }
                return;
            case 9:
                SwimmingAnimationView swimmingAnimationView = (SwimmingAnimationView) obj;
                if (Settings.Global.getFloat(swimmingAnimationView.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                    swimmingAnimationView.post(new l(this, 24));
                    return;
                } else {
                    Log.d("SwimmingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                    swimmingAnimationView.a();
                    return;
                }
            case 10:
                super.onAnimationEnd(animation);
                ((ActionBarOverlayLayout) obj).e.setVisibility(4);
                return;
            case 11:
                super.onAnimationEnd(animation);
                r0 r0Var = (r0) obj;
                r0Var.g = true;
                Iterator it = r0Var.f6628a.values().iterator();
                if (it.hasNext()) {
                    throw B7.a.f(it);
                }
                boolean z10 = r0Var.g;
                if (z10) {
                    r0Var.e = 3;
                }
                if (z10) {
                    boolean z11 = StepOSRecyclerView.f6512u0;
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f152a) {
            case 5:
                super.onAnimationStart(animator);
                ((StepOSAppBarBehavior) this.b).f2286r = true;
                break;
            case 6:
            default:
                super.onAnimationStart(animator);
                break;
            case 7:
                super.onAnimationStart(animator);
                ((com.stepos.common.animator.d) this.b).b = SystemClock.uptimeMillis();
                break;
        }
    }
}
