package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class f {
    private static double a(double r100) {
        return (r100 / 3.141592653589793d) * 180.0d;
    }

    private static double b(double r100) {
        return (r100 * 3.141592653589793d) / 180.0d;
    }

    private static double a(LatLng r110, LatLng r111) {
        double r100 = b(r110.latitude);
        double r101 = b(r111.latitude);
        double r102 = b(r110.longitude);
        double r112 = b(r111.longitude);
        return Math.acos((Math.sin(r100) * Math.sin(r101)) + ((Math.cos(r100) * Math.cos(r101)) * Math.cos(Math.abs(r112 - r102))));
    }

    public static List<LatLng> b(LatLng r110, LatLng r111) {
        double r100 = c(r110, r111);
        ArrayList r101 = new ArrayList();
        if (150000.0d <= r100) goto L5;
    L13:
        r101.add(r110);
        r101.add(r111);
        return r101;
    L5:
        if (r100 < 250000.0d) goto L13;
        double r102 = Math.round(r100 / 150000.0d);
        double r103 = a(r110, r111);
        r101.add(r110);
        double r112 = 0.0d;
    L9:
        if (r112 >= r102) goto L11;
        r101.add(a(r110, r111, r112 / r102, r103));
        r112 = r112 + 1.0d;
        goto L9
    L11:
        r101.add(r111);
        return r101;
    }

    public static double c(LatLng r100, LatLng r101) {
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

    private static LatLng a(LatLng r110, LatLng r111, double r210, double r211) {
        double r100 = r110.latitude;
        double r101 = r111.latitude;
        double r102 = r110.longitude;
        double r103 = r111.longitude;
        double r104 = Math.sin((1.0d - r210) * r211) / Math.sin(r211);
        double r112 = Math.sin(r210 * r211) / Math.sin(r211);
        double r105 = b(r100);
        double r106 = b(r101);
        double r107 = b(r102);
        double r108 = b(r103);
        double r113 = ((Math.cos(r105) * r104) * Math.cos(r107)) + ((Math.cos(r106) * r112) * Math.cos(r108));
        double r114 = ((Math.cos(r105) * r104) * Math.sin(r107)) + ((Math.cos(r106) * r112) * Math.sin(r108));
        double r109 = Math.atan2((r104 * Math.sin(r105)) + (r112 * Math.sin(r106)), Math.sqrt(Math.pow(r113, 2.0d) + Math.pow(r114, 2.0d)));
        double r115 = Math.atan2(r114, r113);
        return new LatLng(a(r109), a(r115));
    }
}
