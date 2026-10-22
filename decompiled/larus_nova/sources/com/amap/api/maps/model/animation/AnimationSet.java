package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class AnimationSet extends Animation {
    private List<Animation> mAnimations;
    private boolean shareInterpolator;

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "AnimationSet";
    }

    public void cleanAnimation() {
        ((GLAnimationSet) this.glAnimation).cleanAnimation();
        this.mAnimations.clear();
    }

    public AnimationSet(boolean r100) {
        this.mAnimations = new ArrayList();
        this.shareInterpolator = false;
        this.glAnimation = new GLAnimationSet(r100);
        this.shareInterpolator = r100;
    }

    public void addAnimation(Animation r100) {
        ((GLAnimationSet) this.glAnimation).addAnimation(r100);
        this.mAnimations.add(r100);
    }
}
