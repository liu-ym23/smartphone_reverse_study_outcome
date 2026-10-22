package com.bytedanceos.common.ui.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class AlphaInAnimation extends AlphaAnimation {
    public AlphaInAnimation() {
        super(0.0f, 1.0f);
        setDuration(300);
        setInterpolator(new DecelerateInterpolator(2.5f));
    }
}
