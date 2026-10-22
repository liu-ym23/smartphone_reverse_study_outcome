package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: classes39.dex */
public interface Projection {
    GeoPoint fromPixels(int r100, int r101);

    float metersToEquatorPixels(float r100);

    Point toPixels(GeoPoint r100, int r101, Point r102);

    Point toPixels(GeoPoint r100, Point r101);

    Point world2Screen(float r100, float r101, float r102);
}
