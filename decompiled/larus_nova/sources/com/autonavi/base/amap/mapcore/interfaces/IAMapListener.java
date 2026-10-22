package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* JADX INFO: loaded from: classes39.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawBuilding(int r100, GLMapState r101);

    void afterDrawFrame(int r100, GLMapState r101);

    void afterDrawLabel(int r100, GLMapState r101);

    void afterRendererOver(int r100, GLMapState r101);

    void beforeDrawBuilding(int r100, GLMapState r101);

    void beforeDrawLabel(int r100, GLMapState r101);

    void onMapBlankClick(double r100, double r101);

    void onMapPOIClick(MapPoi r100);
}
