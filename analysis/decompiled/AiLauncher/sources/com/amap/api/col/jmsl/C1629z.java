package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1629z {

    /* renamed from: a, reason: collision with root package name */
    public static final List<LatLng> f17067a = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: b, reason: collision with root package name */
    public static double f17068b = 6378245.0d;

    /* renamed from: c, reason: collision with root package name */
    public static double f17069c = 0.006693421622965943d;

    public static double a(double d10, int i10) {
        return new BigDecimal(d10).setScale(i10, 4).doubleValue();
    }

    public static LatLng b(double d10, double d11) {
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double d14 = d12 * 2.0d;
        double d15 = d12 * 0.1d;
        double d16 = d15 * d13;
        double dSqrt = (-100.0d) + d14 + (d13 * 3.0d) + (d13 * 0.2d * d13) + d16 + (Math.sqrt(Math.abs(d12)) * 0.2d);
        double d17 = 6.0d * d12 * 3.141592653589793d;
        double d18 = d14 * 3.141592653589793d;
        double d19 = d13 * 3.141592653589793d;
        double dSin = dSqrt + ((((Math.sin(d17) * 20.0d) + (Math.sin(d18) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d19) * 20.0d) + (Math.sin((d13 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d13 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d19 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
        double dSqrt2 = d12 + 300.0d + (d13 * 2.0d) + (d15 * d12) + d16 + (Math.sqrt(Math.abs(d12)) * 0.1d) + ((((Math.sin(d17) * 20.0d) + (Math.sin(d18) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d12 * 3.141592653589793d) * 20.0d) + (Math.sin((d12 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d12 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d12 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double d20 = (d10 / 180.0d) * 3.141592653589793d;
        double dSin2 = Math.sin(d20);
        double d21 = 1.0d - ((f17069c * dSin2) * dSin2);
        double dSqrt3 = Math.sqrt(d21);
        double d22 = f17068b;
        LatLng latLng = new LatLng(d10 + ((dSin * 180.0d) / ((((1.0d - f17069c) * d22) / (d21 * dSqrt3)) * 3.141592653589793d)), d11 + ((dSqrt2 * 180.0d) / (((d22 / dSqrt3) * Math.cos(d20)) * 3.141592653589793d)));
        return new LatLng((d10 * 2.0d) - latLng.latitude, (d11 * 2.0d) - latLng.longitude);
    }

    public static LatLng c(Context context, LatLng latLng) {
        try {
            if (!M2.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            double d10 = ((long) (latLng.longitude * 100000.0d)) % 36000000;
            double d11 = ((long) (latLng.latitude * 100000.0d)) % 36000000;
            DPoint dPointObtain = DPoint.obtain(((int) (((-f((int) ((-f(d10, d11)) + d10), (int) ((-h(d10, d11)) + d11))) + d10) + (d10 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-h(r2, r11)) + d11) + (d11 > 0.0d ? 1 : -1))) / 100000.0d);
            LatLng latLngG = g(context, new LatLng(dPointObtain.f18179y, dPointObtain.f18178x, false));
            dPointObtain.recycle();
            return latLngG;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    public static LatLng d(LatLng latLng) {
        if (latLng != null) {
            try {
                if (M2.a(latLng.latitude, latLng.longitude)) {
                    DPoint dPointE = e(latLng.longitude, latLng.latitude, 2);
                    LatLng latLng2 = new LatLng(dPointE.f18179y, dPointE.f18178x, false);
                    dPointE.recycle();
                    return latLng2;
                }
                if (!C1570k.n(new LatLng(latLng.latitude, latLng.longitude), f17067a)) {
                    return latLng;
                }
                DPoint dPointE2 = e(latLng.longitude, latLng.latitude, 2);
                return b(dPointE2.f18179y, dPointE2.f18178x);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    public static DPoint e(double d10, double d11, int i10) {
        double d12 = 0.006401062d;
        double d13 = 0.0060424805d;
        DPoint dPointObtain = null;
        int i11 = 0;
        while (i11 < i10) {
            dPointObtain = DPoint.obtain();
            double d14 = d10 - d12;
            double d15 = d11 - d13;
            DPoint dPointObtain2 = DPoint.obtain();
            double d16 = d14 * 3000.0d * 0.017453292519943295d;
            double d17 = 3000.0d * d15 * 0.017453292519943295d;
            double d18 = (d14 * d14) + (d15 * d15);
            double dCos = (Math.cos((Math.cos(d16) * 3.0E-6d) + Math.atan2(d15, d14)) * ((Math.sin(d17) * 2.0E-5d) + Math.sqrt(d18))) + 0.0065d;
            double dSin = (Math.sin((Math.cos(d16) * 3.0E-6d) + Math.atan2(d15, d14)) * ((Math.sin(d17) * 2.0E-5d) + Math.sqrt(d18))) + 0.006d;
            dPointObtain2.f18178x = a(dCos, 8);
            dPointObtain2.f18179y = a(dSin, 8);
            dPointObtain.f18178x = a((d10 + d14) - dPointObtain2.f18178x, 8);
            double dA = a((d11 + d15) - dPointObtain2.f18179y, 8);
            dPointObtain.f18179y = dA;
            i11++;
            d13 = d11 - dA;
            d12 = d10 - dPointObtain.f18178x;
        }
        return dPointObtain;
    }

    public static double f(double d10, double d11) {
        return (Math.cos(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.sin(d10 / 100000.0d) * (d11 / 9000.0d));
    }

    public static LatLng g(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!M2.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint dPointObtain = DPoint.obtain(latLng.longitude, latLng.latitude);
        try {
            if (M2.a(dPointObtain.f18179y, dPointObtain.f18178x)) {
                if (C1623x1.f17030a) {
                    r.h("OffsetUtil", "use default offset", 111);
                }
                double[] dArrB = D2.b(dPointObtain.f18178x, dPointObtain.f18179y);
                dPointObtain.recycle();
                dPointObtain = DPoint.obtain(dArrB[0], dArrB[1]);
            }
        } catch (Throwable unused) {
        }
        LatLng latLng2 = new LatLng(dPointObtain.f18179y, dPointObtain.f18178x, false);
        dPointObtain.recycle();
        return latLng2;
    }

    public static double h(double d10, double d11) {
        return (Math.sin(d11 / 100000.0d) * (d10 / 18000.0d)) + (Math.cos(d10 / 100000.0d) * (d11 / 9000.0d));
    }
}
