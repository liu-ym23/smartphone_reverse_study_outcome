package com.bytedanceos.common.ui.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class AlphaOutAnimation extends AlphaAnimation {
    public AlphaOutAnimation() {
        super(1.0f, 0.0f);
        setDuration(300);
        setInterpolator(new DecelerateInterpolator(1.5f));
    }
}
