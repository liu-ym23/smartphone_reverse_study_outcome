package com.amap.api.mapcore.util;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<LatLng> f27700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static double f27701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static double f27702c;

    static {
        f27700a = new ArrayList(Arrays.asList(new LatLng[]{new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)}));
        f27701b = 6378245.0d;
        f27702c = 0.006693421622965943d;
    }

    public static LatLng a(LatLng r100) {
        if (r100 != null) goto L14;
    L13:
        return r100;
    L14:
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L4:
        if (t3.b(r100.latitude, r100.longitude) == false) goto L8;
        DPoint r101 = a(r100.longitude, r100.latitude, 2);     // Catch: Throwable -> L11
        LatLng r102 = new LatLng(r101.f30022y, r101.f30021x, false);     // Catch: Throwable -> L11
        r101.recycle();     // Catch: Throwable -> L11
        return r102;
    L8:
        if (w3.a(new LatLng(r100.latitude, r100.longitude), f27700a) == false) goto L15;
        DPoint r103 = a(r100.longitude, r100.latitude, 2);     // Catch: Throwable -> L11
        return a(r103.f30022y, r103.f30021x);
    L15:
        return r100;
    }

    private static LatLng a(double r310, double r311) {
        double r100 = r311 - 105.0d;
        double r101 = r310 - 35.0d;
        double r102 = r100 * 2.0d;
        double r110 = r100 * 0.1d;
        double r111 = r110 * r101;
        double r103 = (((((-100.0d) + r102) + (r101 * 3.0d)) + ((r101 * 0.2d) * r101)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.2d);
        double r112 = (6.0d * r100) * 3.141592653589793d;
        double r104 = r102 * 3.141592653589793d;
        double r105 = r103 + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d);
        double r210 = r101 * 3.141592653589793d;
        double r106 = (r105 + ((((Math.sin(r210) * 20.0d) + (Math.sin((r101 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r101 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(r210 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
        double r211 = (((((((r100 + 300.0d) + (r101 * 2.0d)) + (r110 * r100)) + r111) + (Math.sqrt(Math.abs(r100)) * 0.1d)) + ((((Math.sin(r112) * 20.0d) + (Math.sin(r104) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r100 * 3.141592653589793d) * 20.0d) + (Math.sin((r100 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r100 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r100 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
        double r107 = (r310 / 180.0d) * 3.141592653589793d;
        double r108 = Math.sin(r107);
        double r113 = 1.0d - ((f27702c * r108) * r108);
        double r114 = Math.sqrt(r113);
        double r115 = f27701b;
        double r109 = (r106 * 180.0d) / ((((1.0d - f27702c) * r115) / (r113 * r114)) * 3.141592653589793d);
        double r212 = (r211 * 180.0d) / (((r115 / r114) * Math.cos(r107)) * 3.141592653589793d);
        LatLng r116 = new LatLng(r310 + r109, r311 + r212);
        double r117 = (r311 * 2.0d) - r116.longitude;
        return new LatLng((r310 * 2.0d) - r116.latitude, r117);
    }

    public static LatLng b(Context r100, LatLng r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (b(r101.latitude, r101.longitude) == true) goto L8;
        return r101;
    L8:
        DPoint r102 = DPoint.obtain(r101.longitude, r101.latitude);
        if (b(r102.f30022y, r102.f30021x) == false) goto L12;
        double[] r103 = com.autonavi.util.a.a(r102.f30021x, r102.f30022y);     // Catch: Throwable -> L14
        r102.recycle();     // Catch: Throwable -> L14
        r102 = DPoint.obtain(r103[0], r103[1]);     // Catch: Throwable -> L14
    L12:
        LatLng r104 = new LatLng(r102.f30022y, r102.f30021x, false);
        r102.recycle();
        return r104;
    }

    public static double c(double r100, double r101) {
        return (Math.cos(r101 / 100000.0d) * (r100 / 18000.0d)) + (Math.sin(r100 / 100000.0d) * (r101 / 9000.0d));
    }

    public static double d(double r100, double r101) {
        return (Math.sin(r101 / 100000.0d) * (r100 / 18000.0d)) + (Math.cos(r100 / 100000.0d) * (r101 / 9000.0d));
    }

    public static LatLng a(Context r110, LatLng r111) {
    L16:
        th = move-exception;
        th.printStackTrace();
        return r111;
    L4:
        if (t3.b(r111.latitude, r111.longitude) == true) goto L6;
        return r111;
    L6:
        double r100 = ((long) (r111.longitude * 100000.0d)) % 36000000;     // Catch: Throwable -> L16
        double r101 = ((long) (r111.latitude * 100000.0d)) % 36000000;     // Catch: Throwable -> L16
        int r102 = (int) ((-c(r100, r101)) + r100);     // Catch: Throwable -> L16
        double r112 = (int) ((-d(r100, r101)) + r101);     // Catch: Throwable -> L16
        double r103 = (-c(r102, r112)) + r100;     // Catch: Throwable -> L16
        int r104 = 1;
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        int r105 = 1;
    L10:
        double r106 = (int) (r103 + ((double) r105));     // Catch: Throwable -> L16
        double r107 = (-d(r106, r112)) + r101;     // Catch: Throwable -> L16
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        r104 = -1;
    L14:
        DPoint r108 = DPoint.obtain(r106 / 100000.0d, ((double) ((int) (r107 + ((double) r104)))) / 100000.0d);     // Catch: Throwable -> L16
        LatLng r109 = b(r110, new LatLng(r108.f30022y, r108.f30021x, false));     // Catch: Throwable -> L16
        r108.recycle();     // Catch: Throwable -> L16
        return r109;
    L9:
        r105 = -1;
        goto L10
    }

    private static boolean b(double r100, double r101) {
        if (t3.b(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (w3.a(new LatLng(r100, r101), f27700a) == true) goto L8;
        return false;
    }

    private static double a(double r100, int r101) {
        return new BigDecimal(r100).setScale(r101, 4).doubleValue();
    }

    private static DPoint a(double r210, double r211, int r310) {
        double r100 = 0.006401062d;
        double r101 = 0.0060424805d;
        DPoint r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r310) goto L5;
        r102 = DPoint.obtain();
        double r104 = r210 - r100;
        double r105 = r211 - r101;
        DPoint r106 = DPoint.obtain();
        double r110 = (r104 * 3000.0d) * 0.017453292519943295d;
        double r107 = (3000.0d * r105) * 0.017453292519943295d;
        double r212 = (r104 * r104) + (r105 * r105);
        double r111 = (Math.cos((Math.cos(r110) * 3.0E-6d) + Math.atan2(r105, r104)) * ((Math.sin(r107) * 2.0E-5d) + Math.sqrt(r212))) + 0.0065d;
        double r112 = (Math.sin((Math.cos(r110) * 3.0E-6d) + Math.atan2(r105, r104)) * ((Math.sin(r107) * 2.0E-5d) + Math.sqrt(r212))) + 0.006d;
        r106.f30021x = a(r111, 8);
        r106.f30022y = a(r112, 8);
        r102.f30021x = a((r210 + r104) - r106.f30021x, 8);
        double r108 = a((r211 + r105) - r106.f30022y, 8);
        r102.f30022y = r108;
        double r109 = r211 - r108;
        r103 = r103 + 1;
        r100 = r210 - r102.f30021x;
        r101 = r109;
        goto L3
    L5:
        return r102;
    }
}
