package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: classes43.dex */
public class ECLottieAnimationView extends LottieAnimationView {
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    public ECLottieAnimationView(Context r100) {
        super(r100);
        setImageFolder("images");
    }

    private void setImageFolder(String r100) {
        setImageAssetsFolder(r100);
    }

    public ECLottieAnimationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setImageFolder("images");
    }

    public ECLottieAnimationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setImageFolder("images");
    }
}
