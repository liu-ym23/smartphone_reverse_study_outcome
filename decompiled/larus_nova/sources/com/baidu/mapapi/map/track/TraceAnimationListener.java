package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: classes39.dex */
public interface TraceAnimationListener {
    void onTraceAnimationFinish();

    void onTraceAnimationUpdate(float r100);

    void onTraceUpdatePosition(LatLng r100);
}
