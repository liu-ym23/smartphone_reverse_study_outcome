package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public class GLEmergeAnimation extends GLAnimation {
    public LatLng mStartPoint;

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float r100, GLTransformation r101) {
    }

    public GLEmergeAnimation(LatLng r100) {
        this.mStartPoint = r100;
    }
}
