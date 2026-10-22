package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* JADX INFO: loaded from: classes28.dex */
public class InfoWindowAnimationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IInfoWindowManager f28623a;

    public void startAnimation() {
        this.f28623a.startAnimation();
    }

    public InfoWindowAnimationManager(IInfoWindowManager r100) {
        this.f28623a = r100;
    }

    public void setInfoWindowAppearAnimation(Animation r100) {
        this.f28623a.setInfoWindowAppearAnimation(r100);
    }

    public void setInfoWindowBackColor(int r100) {
        this.f28623a.setInfoWindowBackColor(r100);
    }

    public void setInfoWindowBackEnable(boolean r100) {
        this.f28623a.setInfoWindowBackEnable(r100);
    }

    public void setInfoWindowDisappearAnimation(Animation r100) {
        this.f28623a.setInfoWindowDisappearAnimation(r100);
    }

    public void setInfoWindowMovingAnimation(Animation r100) {
        this.f28623a.setInfoWindowMovingAnimation(r100);
    }

    public void setInfoWindowAnimation(Animation r100, Animation.AnimationListener r101) {
        this.f28623a.setInfoWindowAnimation(r100, r101);
    }

    public void setInfoWindowBackScale(float r100, float r101) {
        this.f28623a.setInfoWindowBackScale(r100, r101);
    }
}
