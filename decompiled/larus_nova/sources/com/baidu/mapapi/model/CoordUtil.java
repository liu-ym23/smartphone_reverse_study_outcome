package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mapsdkplatform.comapi.util.b;
import com.baidu.mapsdkplatform.comjni.tools.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CoordUtil {
    public CoordUtil() {
    }

    public static LatLng decodeLocation(String r100) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return CoordTrans.baiduToGcj(b.a(r100));
    L7:
        return b.a(r100);
    }

    public static List<LatLng> decodeLocationList(String r100) {
        return b.b(r100);
    }

    public static List<List<LatLng>> decodeLocationList2D(String r100) {
        return b.c(r100);
    }

    public static LatLng decodeNodeLocation(String r100) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return CoordTrans.baiduToGcj(b.d(r100));
    L7:
        return b.d(r100);
    }

    public static GeoPoint ll2mc(LatLng r100) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return b.a(CoordTrans.gcjToBaidu(r100));
    L7:
        return b.a(r100);
    }

    public static GeoPoint ll2mcDirect(LatLng r100) {
        return b.a(r100);
    }

    public static Point ll2point(LatLng r100) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return b.b(CoordTrans.gcjToBaidu(r100));
    L7:
        return b.b(r100);
    }

    public static LatLng mc2ll(GeoPoint r100) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return CoordTrans.baiduToGcj(b.a(r100));
    L7:
        return b.a(r100);
    }

    public static LatLng mc2llDirect(GeoPoint r100) {
        return b.a(r100);
    }

    public static double getDistance(Point r100, Point r101) {
        return a.a(r100, r101);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng r100, int r101) {
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L7;
        return b.a(CoordTrans.gcjToBaidu(r100), r101);
    L7:
        return b.a(r100, r101);
    }

    public static LatLng Coordinate_encryptEx(float r100, float r101, String r102) {
        return b.a(r100, r101, r102);
    }
}
