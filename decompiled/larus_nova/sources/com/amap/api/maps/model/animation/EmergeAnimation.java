package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* JADX INFO: loaded from: classes28.dex */
public class EmergeAnimation extends Animation {
    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "EmergeAnimation";
    }

    public EmergeAnimation(LatLng r100) {
        this.glAnimation = new GLEmergeAnimation(r100);
    }
}
