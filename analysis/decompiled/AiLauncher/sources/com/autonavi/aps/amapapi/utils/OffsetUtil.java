package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.col.jmsl.D2;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class OffsetUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final double f18451a = 6378245.0d;

    /* renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f18452b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));
    public static final double ee = 0.006693421622965943d;

    private static double a(double d10, int i10) {
        return new BigDecimal(d10).setScale(i10, 4).doubleValue();
    }

    public static DPoint b2G(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return a(dPoint, 2);
                }
                if (!isInTaiWan(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                DPoint dPointA = a(dPoint, 2);
                double latitude = dPointA.getLatitude();
                double longitude = dPointA.getLongitude();
                double d10 = longitude - 105.0d;
                double d11 = latitude - 35.0d;
                double dTransformLat = transformLat(d10, d11);
                double dTransformLon = transformLon(d10, d11);
                double d12 = (latitude / 180.0d) * 3.141592653589793d;
                double dSin = Math.sin(d12);
                double d13 = 1.0d - ((0.006693421622965943d * dSin) * dSin);
                double dSqrt = Math.sqrt(d13);
                DPoint dPoint2 = new DPoint(((dTransformLat * 180.0d) / ((6335552.717000426d / (d13 * dSqrt)) * 3.141592653589793d)) + latitude, ((dTransformLon * 180.0d) / (((6378245.0d / dSqrt) * Math.cos(d12)) * 3.141592653589793d)) + longitude);
                return new DPoint((latitude * 2.0d) - dPoint2.getLatitude(), (longitude * 2.0d) - dPoint2.getLongitude());
            } catch (Throwable th) {
                CoreUtil.reportError(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    public static boolean isInTaiWan(double d10, double d11) {
        return CoreUtil.isInPolygon(new DPoint(d10, d11), f18452b);
    }

    public static DPoint marbar2G(Context context, DPoint dPoint) {
        try {
            if (!CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude = ((long) (dPoint.getLongitude() * 100000.0d)) % 36000000;
            double latitude = ((long) (dPoint.getLatitude() * 100000.0d)) % 36000000;
            return offset(context, new DPoint(((int) (((-yConvert(r8, r6)) + latitude) + (latitude > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-xConvert((int) ((-xConvert(longitude, latitude)) + longitude), (int) ((-yConvert(longitude, latitude)) + latitude))) + longitude) + (longitude > 0.0d ? 1 : -1))) / 100000.0d));
        } catch (Throwable th) {
            CoreUtil.reportError(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    public static DPoint offset(Context context, double d10, double d11) {
        if (context == null) {
            return null;
        }
        return offset(context, new DPoint(d11, d10));
    }

    public static double transformLat(double d10, double d11) {
        double d12 = d10 * 2.0d;
        double dSqrt = (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((6.0d * d10) * 3.141592653589793d) * 20.0d) + (Math.sin(d12 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d13 = d11 * 3.141592653589793d;
        return dSqrt + ((((Math.sin(d13) * 20.0d) + (Math.sin((d11 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d13 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static double transformLon(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * 3.141592653589793d) * 20.0d) + (Math.sin((d10 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d10 * 3.141592653589793d) * 20.0d) + (Math.sin((d10 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d10 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static double xConvert(double d10, double d11) {
        return (Math.cos(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.sin(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    public static double yConvert(double d10, double d11) {
        return (Math.sin(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.cos(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    private static DPoint a(DPoint dPoint, int i10) {
        double longitude = 0.006401062d;
        double latitude = 0.0060424805d;
        DPoint dPoint2 = null;
        for (int i11 = 0; i11 < i10; i11++) {
            double longitude2 = dPoint.getLongitude();
            double latitude2 = dPoint.getLatitude();
            dPoint2 = new DPoint();
            double d10 = longitude2 - longitude;
            double d11 = latitude2 - latitude;
            DPoint dPoint3 = new DPoint();
            double d12 = d10 * 3000.0d * 0.017453292519943295d;
            double d13 = 3000.0d * d11 * 0.017453292519943295d;
            double d14 = (d10 * d10) + (d11 * d11);
            double dCos = Math.cos((Math.cos(d12) * 3.0E-6d) + Math.atan2(d11, d10)) * ((Math.sin(d13) * 2.0E-5d) + Math.sqrt(d14));
            double dSin = (Math.sin((Math.cos(d12) * 3.0E-6d) + Math.atan2(d11, d10)) * ((Math.sin(d13) * 2.0E-5d) + Math.sqrt(d14))) + 0.006d;
            dPoint3.setLongitude(a(dCos + 0.0065d, 8));
            dPoint3.setLatitude(a(dSin, 8));
            dPoint2.setLongitude(a((longitude2 + d10) - dPoint3.getLongitude(), 8));
            dPoint2.setLatitude(a((latitude2 + d11) - dPoint3.getLatitude(), 8));
            longitude = dPoint.getLongitude() - dPoint2.getLongitude();
            latitude = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    public static DPoint offset(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        try {
            if (CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] dArrB = D2.b(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(dArrB[1], dArrB[0]);
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "OffsetUtil", "cover part2");
        }
        return dPoint;
    }
}
