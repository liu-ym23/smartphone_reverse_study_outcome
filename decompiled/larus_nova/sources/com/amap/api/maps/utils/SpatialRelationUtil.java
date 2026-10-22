package com.amap.api.maps.utils;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.w3;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public SpatialRelationUtil() {
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> r100, LatLng r101) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L6:
        if (r100.size() == 0) goto L22;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<LatLng> r103 = r100.iterator();     // Catch: Throwable -> L20
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L16;
        LatLng r105 = r103.next();     // Catch: Throwable -> L20
        r102.add(DPoint.obtain(r105.latitude, r105.longitude));     // Catch: Throwable -> L20
        if (r105.equals(r101) == true) goto L14;
        r104 = r104 + 1;     // Catch: Throwable -> L20
        goto L10
    L14:
        return new Pair(Integer.valueOf(r104), r101);
    L16:
        Pair<Integer, DPoint> r106 = calShortestDistancePoint(r102, DPoint.obtain(r101.latitude, r101.longitude));     // Catch: Throwable -> L20
        if (r106 == null) goto L22;
        Object r107 = r106.first;     // Catch: Throwable -> L20
        Object r108 = r106.second;     // Catch: Throwable -> L20
        return new Pair(r107, new LatLng(((DPoint) r108).f30021x, ((DPoint) r108).f30022y));
    L22:
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> r100, DPoint r101) {
        return calShortestDistancePoint(r100, r101, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> r210, DPoint r211, float r212) {
        List<DPoint> r100 = r210;
        DPoint r101 = r211;
        Pair<Integer, DPoint> r102 = null;
        if (r100 == null) goto L36;
        if (r101 == null) goto L36;
        if (r210.size() == 0) goto L36;
        if (r210.size() >= 2) goto L11;
        return null;
    L11:
        DPoint r103 = (DPoint) ListProtector.get(r100, 0);
        int r104 = r210.size();
        int r105 = 1;
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r107 = 1;
    L12:
        int r108 = r104 - 1;
        if (r107 > r108) goto L36;
        DPoint r110 = (DPoint) ListProtector.get(r100, r107);
        if (r107 != r108) goto L21;
        if (r110.equals(r101) == false) goto L21;
        return new Pair(Integer.valueOf(r107), r101);
    L21:
        if (checkRotateIsMatch(r103, r110, r212) == true) goto L24;
        int r213 = r104;
        double r214 = r106;
        int r215 = r107;
    L34:
        r106 = r214;
    L35:
        r107 = r215 + 1;
        r100 = r210;
        r101 = r211;
        r103 = r110;
        r104 = r213;
        r105 = 1;
        goto L12
    L24:
        if (r103.equals(r101) == true) goto L26;
        r214 = r106;
        r215 = r107;
        r213 = r104;
        Pair<Double, DPoint> r109 = pointToSegDist(r101.f30021x, r101.f30022y, r103.f30021x, r103.f30022y, r110.f30021x, r110.f30022y);
        if (r102 != null) goto L32;
        double r111 = ((Double) r109.first).doubleValue();
        Pair<Integer, DPoint> r112 = new Pair(Integer.valueOf(r215 - 1), r109.second);
    L30:
        r106 = r111;
        r102 = r112;
        goto L35
    L32:
        if (r214 <= ((Double) r109.first).doubleValue()) goto L34;
        r111 = ((Double) r109.first).doubleValue();
        r112 = new Pair(Integer.valueOf(r215 - 1), r109.second);
        goto L30
    L26:
        return new Pair(Integer.valueOf(r107 - r105), r101);
    L36:
        return r102;
    }

    private static boolean checkRotateIsMatch(DPoint r100, DPoint r101, float r110) {
        if (r110 != (-1.0f)) goto L6;
        return true;
    L6:
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        int r102 = w3.f28280b;
        double r103 = r100.f30021x;
        double r104 = r101.f30021x;
        double r105 = r100.f30022y;
        float r106 = Math.abs((((float) ((Math.atan2(r101.f30022y - r105, r104 - r103) / 3.141592653589793d) * 180.0d)) + 360.0f) - r110) % 360.0f;
        if (r106 <= 180.0f) goto L13;
        r106 = 360.0f - r106;
    L13:
        if (r106 >= 50.0f) goto L15;
        return true;
    L15:
        return false;
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> r100, LatLng r101, float r110, double r111) {
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    L6:
        if (r100.size() == 0) goto L24;
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L22
        Iterator<LatLng> r103 = r100.iterator();     // Catch: Throwable -> L22
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L16;
        LatLng r105 = r103.next();     // Catch: Throwable -> L22
        r102.add(DPoint.obtain(r105.latitude, r105.longitude));     // Catch: Throwable -> L22
        if (r105.equals(r101) == true) goto L14;
        r104 = r104 + 1;     // Catch: Throwable -> L22
        goto L10
    L14:
        return new Pair(Integer.valueOf(r104), r101);
    L16:
        Pair<Integer, DPoint> r106 = calShortestDistancePoint(r102, DPoint.obtain(r101.latitude, r101.longitude), r110);     // Catch: Throwable -> L22
        if (r106 == null) goto L24;
        DPoint r112 = (DPoint) r106.second;     // Catch: Throwable -> L22
        if (AMapUtils.calculateLineDistance(new LatLng(r112.f30021x, r112.f30022y), r101) >= r111) goto L24;
        Object r113 = r106.first;     // Catch: Throwable -> L22
        Object r107 = r106.second;     // Catch: Throwable -> L22
        return new Pair(r113, new LatLng(((DPoint) r107).f30021x, ((DPoint) r107).f30022y));
    L24:
        return null;
    }

    private static Pair<Double, DPoint> pointToSegDist(double r210, double r211, double r212, double r213, double r214, double r310) {
        double r100 = r214 - r212;
        double r110 = r210 - r212;
        double r111 = r310 - r213;
        double r112 = r211 - r213;
        double r113 = (r100 * r110) + (r111 * r112);
        if (r113 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r114 = (r100 * r100) + (r111 * r111);
        if (r113 < r114) goto L10;
        double r101 = r210 - r214;
        double r102 = r211 - r310;
        return new Pair(Double.valueOf(Math.sqrt((r101 * r101) + (r102 * r102))), new DPoint(r214, r310));
    L10:
        double r115 = r113 / r114;
        double r103 = r212 + (r100 * r115);
        double r104 = r213 + (r111 * r115);
        double r105 = r210 - r103;
        double r106 = r104 - r211;
        return new Pair(Double.valueOf(Math.sqrt((r105 * r105) + (r106 * r106))), new DPoint(r103, r104));
    L5:
        return new Pair(Double.valueOf(Math.sqrt((r110 * r110) + (r112 * r112))), new DPoint(r212, r213));
    }
}
