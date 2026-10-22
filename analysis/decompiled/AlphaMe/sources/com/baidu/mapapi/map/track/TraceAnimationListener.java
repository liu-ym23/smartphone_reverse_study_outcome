package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public interface TraceAnimationListener {
    void onTraceAnimationFinish();

    void onTraceAnimationUpdate(float f4);

    void onTraceUpdatePosition(LatLng latLng);
}
