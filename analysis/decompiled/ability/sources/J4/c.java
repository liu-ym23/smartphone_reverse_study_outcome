package J4;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.ability.voicewakeup.ui.TrainingPhraseCarousel;
import com.stepos.common.widget.CircularProgressButton;
import com.stepos.common.widget.StepOSRatingBar;
import kotlin.jvm.internal.k;
import w0.C2086g;

/* loaded from: classes3.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f871a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f871a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator a3) {
        switch (this.f871a) {
            case 0:
                k.f(a3, "a");
                float animatedFraction = a3.getAnimatedFraction();
                TrainingPhraseCarousel trainingPhraseCarousel = (TrainingPhraseCarousel) this.b;
                int size = trainingPhraseCarousel.f.size();
                for (int i = 0; i < size; i++) {
                    TextView textView = (TextView) trainingPhraseCarousel.f.get(i);
                    int i6 = trainingPhraseCarousel.g[i];
                    textView.setTranslationY(((((i6 - 1) * r4) - r5) * animatedFraction) + (i6 * trainingPhraseCarousel.f3429a));
                    textView.setAlpha(i6 != 0 ? i6 != 3 ? 1.0f : animatedFraction : 1.0f - animatedFraction);
                    trainingPhraseCarousel.b(textView, i6 != 1 ? i6 != 2 ? 0.0f : animatedFraction : 1.0f - animatedFraction);
                }
                break;
            case 1:
                int iIntValue = ((Integer) a3.getAnimatedValue()).intValue();
                Sa.c cVar = (Sa.c) this.b;
                cVar.d = iIntValue;
                if (cVar.g <= iIntValue) {
                    cVar.f = false;
                    if (!cVar.n && cVar.f1190q) {
                        cVar.b();
                    }
                }
                cVar.invalidateSelf();
                break;
            case 2:
                float fFloatValue = ((Float) a3.getAnimatedValue()).floatValue();
                e3.k kVar = ((BottomSheetBehavior) this.b).i;
                if (kVar != null) {
                    kVar.r(fFloatValue);
                    break;
                }
                break;
            case 3:
                ((TextInputLayout) this.b).f2604A0.m(((Float) a3.getAnimatedValue()).floatValue());
                break;
            case 4:
                CircularProgressButton circularProgressButton = (CircularProgressButton) this.b;
                circularProgressButton.f3645d0 = ((Integer) a3.getAnimatedValue()).intValue();
                circularProgressButton.invalidate();
                break;
            case 5:
                StepOSRatingBar stepOSRatingBar = (StepOSRatingBar) this.b;
                float fIntValue = ((Integer) a3.getAnimatedValue()).intValue();
                for (int i10 = 0; i10 < stepOSRatingBar.getNumStars(); i10++) {
                    stepOSRatingBar.l[i10] = Math.min(Math.max(0.0f, (stepOSRatingBar.m[i10] + fIntValue) - (i10 * 16.0f)), stepOSRatingBar.n + stepOSRatingBar.o);
                }
                stepOSRatingBar.invalidate();
                break;
            default:
                M0.k kVar2 = (M0.k) this.b;
                ((com.stepos.textinputlayout.TextInputLayout) ((C2086g) kVar2.b).f6811a).o.e(((Float) ((ValueAnimator) ((Q.a) ((A0.b) kVar2.c).b).b).getAnimatedValue()).floatValue());
                break;
        }
    }
}
