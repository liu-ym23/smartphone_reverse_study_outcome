package com.bytedanceos.common.ui.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

/* JADX INFO: loaded from: classes2.dex */
public class AlphaOutThenSqueeze extends AnimationSet {
    public AlphaOutThenSqueeze(View r10, int r11) {
        super(false);
        AlphaOutAnimation r12 = new AlphaOutAnimation();
        r12.setDuration(150);
        Animation r13 = new SqueezeAnimation(r10, r11);
        r13.setDuration(150);
        addAnimation(r12);
        addAnimation(r13);
        setStartOffset(150);
    }
}
