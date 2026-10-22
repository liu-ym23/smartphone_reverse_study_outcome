package com.autonavi.amap.mapcore.interfaces;

/* JADX INFO: loaded from: classes39.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean r100);

    void setAbroadState(int r100);

    void setTerrainEnable(boolean r100);
}
