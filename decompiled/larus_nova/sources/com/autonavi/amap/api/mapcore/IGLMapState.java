package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* JADX INFO: loaded from: classes39.dex */
public interface IGLMapState {
    float calculateMapZoomer(int r100, int r101, int r102, int r103, int r104);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint r100);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int r100, int r101, Point r102);

    void setCameraDegree(float r100);

    void setMapAngle(float r100);

    void setMapCenterByLonLat(double r100, double r101);

    void setMapGeoCenter(double r100, double r101);

    void setMapZoomer(float r100);
}
