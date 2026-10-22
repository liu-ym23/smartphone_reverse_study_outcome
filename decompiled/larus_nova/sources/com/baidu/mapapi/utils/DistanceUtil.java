package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: classes39.dex */
public class DistanceUtil {
    public DistanceUtil() {
    }

    public static double getDistance(LatLng r100, LatLng r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        Point r102 = CoordUtil.ll2point(r100);
        Point r103 = CoordUtil.ll2point(r101);
        if (r102 == null) goto L12;
        if (r103 == null) goto L12;
        return CoordUtil.getDistance(r102, r103);
    L12:
        return -1.0d;
    }
}
