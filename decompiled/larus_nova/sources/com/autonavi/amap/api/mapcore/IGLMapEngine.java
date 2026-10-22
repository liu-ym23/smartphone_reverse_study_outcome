package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* JADX INFO: loaded from: classes39.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int r100, int r101, float r102, int r103, int r104, int r105, int r106, AMap.CancelableCallback r107);

    IGLMapState getNewMapState(int r100);
}
