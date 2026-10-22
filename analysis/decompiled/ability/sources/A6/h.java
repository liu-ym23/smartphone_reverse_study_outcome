package A6;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import com.stepos.ability.R;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f147a;
    public final /* synthetic */ StepOSAlertDialogLayout b;

    public /* synthetic */ h(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i) {
        this.f147a = i;
        this.b = stepOSAlertDialogLayout;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        int i = this.f147a;
        StepOSAlertDialogLayout stepOSAlertDialogLayout = this.b;
        switch (i) {
            case 0:
                stepOSAlertDialogLayout.d = null;
                D6.f fVar = stepOSAlertDialogLayout.f4103a;
                if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.isGlassEnabled && stepOSAlertDialogLayout.getWidth() > 0 && stepOSAlertDialogLayout.getHeight() > 0) {
                    Pair pair = new Pair(Integer.valueOf(stepOSAlertDialogLayout.getWidth()), Integer.valueOf(stepOSAlertDialogLayout.getHeight()));
                    if (!pair.equals(stepOSAlertDialogLayout.c)) {
                        if (fVar.b == null) {
                            float dimension = stepOSAlertDialogLayout.getResources().getDimension(R.dimen.stepos_dialog_corner_radius);
                            GlassEffect light_medium = stepOSAlertDialogLayout.glassEffect;
                            if (light_medium == null) {
                                light_medium = stepOSAlertDialogLayout.getResources().getBoolean(R.bool.stepos_dialog_glass_light) ? GlassEffect.INSTANCE.getLIGHT_MEDIUM() : GlassEffect.INSTANCE.getDARK_MEDIUM();
                            }
                            fVar.a(dimension, 1, light_medium);
                            if (fVar.d && stepOSAlertDialogLayout.isHardwareAccelerated()) {
                                l lVar = new l(new WeakReference(stepOSAlertDialogLayout), 0);
                                stepOSAlertDialogLayout.g = lVar;
                                ViewTreeObserver viewTreeObserver = stepOSAlertDialogLayout.getViewTreeObserver();
                                viewTreeObserver.registerFrameCommitCallback(lVar);
                                stepOSAlertDialogLayout.h = viewTreeObserver;
                            }
                        }
                        stepOSAlertDialogLayout.c = pair;
                        stepOSAlertDialogLayout.invalidate();
                        break;
                    }
                }
                break;
            default:
                int i6 = StepOSAlertDialogLayout.p;
                if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.isGlassEnabled && stepOSAlertDialogLayout.f4103a.d) {
                    ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
                    valueAnimatorOfInt.setDuration(stepOSAlertDialogLayout.getResources().getInteger(android.R.integer.config_shortAnimTime));
                    valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                    valueAnimatorOfInt.addUpdateListener(new j(stepOSAlertDialogLayout, 0));
                    valueAnimatorOfInt.addListener(new m(stepOSAlertDialogLayout, 0));
                    stepOSAlertDialogLayout.f = valueAnimatorOfInt;
                    valueAnimatorOfInt.start();
                    break;
                }
                break;
        }
    }
}
