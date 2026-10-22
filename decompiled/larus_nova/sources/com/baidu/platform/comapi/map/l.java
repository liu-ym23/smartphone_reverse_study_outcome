package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

/* JADX INFO: loaded from: classes39.dex */
public class l {
    public static GeoPoint a(GeoPoint r100) {
        Point r101 = CoordinateUtil.bd09llTobd09mc(r100.getLongitude(), r100.getLatitude());
        if (r101 != null) goto L5;
        return null;
    L5:
        return new GeoPoint(r101.getDoubleY(), r101.getDoubleX());
    }
}
