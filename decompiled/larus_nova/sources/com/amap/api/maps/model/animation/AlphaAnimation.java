package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;

/* JADX INFO: loaded from: classes28.dex */
public class AlphaAnimation extends Animation {
    private float mFromAlpha;
    private float mToAlpha;

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "AlphaAnimation";
    }

    public AlphaAnimation(float r100, float r101) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(r100, r101);
        this.mFromAlpha = r100;
        this.mToAlpha = r101;
    }
}
