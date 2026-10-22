package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

/* loaded from: classes.dex */
public interface Projection {
    GeoPoint fromPixels(int i4, int i5);

    float metersToEquatorPixels(float f4);

    Point toPixels(GeoPoint geoPoint, int i4, Point point);

    Point toPixels(GeoPoint geoPoint, Point point);

    Point world2Screen(float f4, float f5, float f6);
}
