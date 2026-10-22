package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* JADX INFO: loaded from: classes39.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation r100, Animation.AnimationListener r101);

    void setInfoWindowAppearAnimation(Animation r100);

    void setInfoWindowBackColor(int r100);

    void setInfoWindowBackEnable(boolean r100);

    void setInfoWindowBackScale(float r100, float r101);

    void setInfoWindowDisappearAnimation(Animation r100);

    void setInfoWindowMovingAnimation(Animation r100);

    void startAnimation();
}
