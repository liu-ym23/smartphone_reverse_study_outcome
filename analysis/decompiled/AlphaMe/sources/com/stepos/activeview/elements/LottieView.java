package com.stepos.activeview.elements;

import android.content.Context;
import com.airbnb.lottie.AbstractC0402g;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes.dex */
public class LottieView extends AbstractC0402g implements ActiveAnimation {
    private LottieComposition mComposition;

    public LottieView(Context context) {
        super(context);
    }

    @Override // com.airbnb.lottie.AbstractC0402g, com.stepos.activeview.elements.ActiveAnimation
    public void pauseAnimation() {
        if (isAnimating()) {
            super.pauseAnimation();
        }
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void resumeAnimation() {
        LottieComposition lottieComposition;
        if (isAnimating() || (lottieComposition = this.mComposition) == null) {
            return;
        }
        setComposition(lottieComposition);
        super.playAnimation();
    }

    public void setContentComposition(LottieComposition lottieComposition) {
        this.mComposition = lottieComposition;
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void startAnimation() {
        LottieComposition lottieComposition;
        if (isAnimating() || (lottieComposition = this.mComposition) == null) {
            return;
        }
        setComposition(lottieComposition);
        super.playAnimation();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void stopAnimation() {
        if (isAnimating()) {
            super.pauseAnimation();
        }
    }
}
