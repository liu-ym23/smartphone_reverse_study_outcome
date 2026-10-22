package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* JADX INFO: loaded from: classes39.dex */
public interface IAnimation {
    void setAnimation(GLAnimation r100);

    void setAnimationListener(Animation.AnimationListener r100);

    boolean startAnimation();
}
