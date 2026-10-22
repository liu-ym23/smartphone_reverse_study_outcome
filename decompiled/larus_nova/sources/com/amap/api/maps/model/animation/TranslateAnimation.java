package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;

/* JADX INFO: loaded from: classes28.dex */
public class TranslateAnimation extends Animation {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f28674x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private double f28675y;

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "TranslateAnimation";
    }

    public TranslateAnimation(LatLng r100) {
        this.glAnimation = new GLTranslateAnimation(r100);
        this.f28674x = r100.latitude;
        this.f28675y = r100.longitude;
    }
}
