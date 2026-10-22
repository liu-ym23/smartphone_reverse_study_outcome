package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MaskKeyframeAnimation {
    private final List<BaseKeyframeAnimation<ShapeData, Path>> maskAnimations;
    private final List<Mask> masks;
    private final List<BaseKeyframeAnimation<Integer, Integer>> opacityAnimations;

    public MaskKeyframeAnimation(List<Mask> r4) {
        this.masks = r4;
        this.maskAnimations = new ArrayList(r4.size());
        this.opacityAnimations = new ArrayList(r4.size());
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L6;
        this.maskAnimations.add(r4.get(r0).getMaskPath().createAnimation());
        AnimatableIntegerValue r1 = r4.get(r0).getOpacity();
        this.opacityAnimations.add(r1.createAnimation());
        r0 = r0 + 1;
        goto L4
    }

    public List<Mask> getMasks() {
        return this.masks;
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations() {
        return this.maskAnimations;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations() {
        return this.opacityAnimations;
    }
}
