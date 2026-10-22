package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {
    private static double a(double d4) {
        return (d4 / 3.141592653589793d) * 180.0d;
    }

    private static double b(double d4) {
        return (d4 * 3.141592653589793d) / 180.0d;
    }

    public static double c(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            Point pointLl2point = CoordUtil.ll2point(latLng);
            Point pointLl2point2 = CoordUtil.ll2point(latLng2);
            if (pointLl2point != null && pointLl2point2 != null) {
                return CoordUtil.getDistance(pointLl2point, pointLl2point2);
            }
        }
        return -1.0d;
    }

    private static double a(LatLng latLng, LatLng latLng2) {
        double dB = b(latLng.latitude);
        double dB2 = b(latLng2.latitude);
        double dB3 = b(latLng.longitude);
        double dB4 = b(latLng2.longitude);
        return Math.acos((Math.cos(Math.abs(dB4 - dB3)) * Math.cos(dB2) * Math.cos(dB)) + (Math.sin(dB2) * Math.sin(dB)));
    }

    public static List<LatLng> b(LatLng latLng, LatLng latLng2) {
        double dC = c(latLng, latLng2);
        ArrayList arrayList = new ArrayList();
        if (150000.0d > dC || dC < 250000.0d) {
            arrayList.add(latLng);
            arrayList.add(latLng2);
            return arrayList;
        }
        double dRound = Math.round(dC / 150000.0d);
        double dA = a(latLng, latLng2);
        arrayList.add(latLng);
        for (double d4 = 0.0d; d4 < dRound; d4 += 1.0d) {
            arrayList.add(a(latLng, latLng2, d4 / dRound, dA));
        }
        arrayList.add(latLng2);
        return arrayList;
    }

    private static LatLng a(LatLng latLng, LatLng latLng2, double d4, double d5) {
        double d6 = latLng.latitude;
        double d7 = latLng2.latitude;
        double d8 = latLng.longitude;
        double d9 = latLng2.longitude;
        double dSin = Math.sin((1.0d - d4) * d5) / Math.sin(d5);
        double dSin2 = Math.sin(d4 * d5) / Math.sin(d5);
        double dB = b(d6);
        double dB2 = b(d7);
        double dB3 = b(d8);
        double dB4 = b(d9);
        double dCos = (Math.cos(dB4) * Math.cos(dB2) * dSin2) + (Math.cos(dB3) * Math.cos(dB) * dSin);
        double dSin3 = (Math.sin(dB4) * Math.cos(dB2) * dSin2) + (Math.sin(dB3) * Math.cos(dB) * dSin);
        return new LatLng(a(Math.atan2((Math.sin(dB2) * dSin2) + (Math.sin(dB) * dSin), Math.sqrt(Math.pow(dSin3, 2.0d) + Math.pow(dCos, 2.0d)))), a(Math.atan2(dSin3, dCos)));
    }
}
