package com.baidu.mapapi.utils;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class SpatialRelationUtil {
    public SpatialRelationUtil() {
    }

    private static Point a(List<Point> r210, Point r211) {
        Point r100 = null;
        if (r210 == null) goto L22;
        if (r211 == null) goto L22;
        if (r210.size() == 0) goto L22;
        if (r210.size() >= 2) goto L10;
        return null;
    L10:
        Point r101 = (Point) ListProtector.get(r210, 0);
        int r102 = r210.size();
        int r103 = 1;
    L11:
        int r104 = r102 - 1;
        if (r103 > r104) goto L22;
        Point r105 = (Point) ListProtector.get(r210, r103);
        if (r103 != r104) goto L19;
        if (r105.equals(r211) == false) goto L19;
        return r211;
    L19:
        if (r101.equals(r211) == true) goto L20;
        Point r106 = a(r211.doubleX, r211.doubleY, r101.doubleX, r101.doubleY, r105.doubleX, r105.doubleY);
        r103 = r103 + 1;
        r102 = r102;
        r101 = r105;
        r100 = r106;
        goto L11
    L20:
        return r211;
    L22:
        return r100;
    }

    public static LatLng getNearestDistancePointFromLine(List<LatLng> r100, LatLng r101) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (r100.size() == 0) goto L19;
        if (r101 == null) goto L19;
        ArrayList r102 = new ArrayList();
        Iterator<LatLng> r103 = r100.iterator();
    L9:
        if (r103 == null) goto L15;
        if (r103.hasNext() == false) goto L15;
        LatLng r104 = r103.next();
        r102.add(new Point(r104.longitude, r104.latitude));
        if (r104.equals(r101) == false) goto L9;
        return r104;
    L15:
        Point r105 = a(r102, new Point(r101.longitude, r101.latitude));
        if (r105 == null) goto L19;
        return new LatLng(r105.doubleY, r105.doubleX);
    }

    public static LatLng getNearestPointFromLine(List<LatLng> r110, LatLng r111) {
        LatLng r100 = null;
        if (r110 != null) goto L5;
    L26:
        return r100;
    L5:
        if (r110.size() == 0) goto L26;
        if (r111 == null) goto L26;
        int r101 = 0;
    L10:
        if (r101 >= (r110.size() - 1)) goto L26;
        int r102 = r101 + 1;
        LatLng r103 = a((LatLng) ListProtector.get(r110, r101), (LatLng) ListProtector.get(r110, r102), r111);
        if (((r103.latitude - ((LatLng) ListProtector.get(r110, r101)).latitude) * (r103.latitude - ((LatLng) ListProtector.get(r110, r102)).latitude)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
        if (((r103.longitude - ((LatLng) ListProtector.get(r110, r101)).longitude) * (r103.longitude - ((LatLng) ListProtector.get(r110, r102)).longitude)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
    L21:
        if (r100 != null) goto L23;
    L24:
        r100 = r103;
    L25:
        r101 = r102;
        goto L10
    L23:
        if (DistanceUtil.getDistance(r111, r103) >= DistanceUtil.getDistance(r111, r100)) goto L25;
    L17:
        if (DistanceUtil.getDistance(r111, (LatLng) ListProtector.get(r110, r101)) >= DistanceUtil.getDistance(r111, (LatLng) ListProtector.get(r110, r102))) goto L19;
        Object r104 = ListProtector.get(r110, r101);
    L20:
        r103 = (LatLng) r104;
        goto L21
    L19:
        r104 = ListProtector.get(r110, r102);
        goto L20
    }

    public static boolean isPolygonContainsPoint(List<LatLng> r110, LatLng r111) {
        if (r110 != null) goto L5;
        return false;
    L5:
        if (r110.size() == 0) goto L52;
        if (r111 == null) goto L53;
        int r100 = 0;
    L10:
        if (r100 >= r110.size()) goto L17;
        if (r111.longitude != ((LatLng) ListProtector.get(r110, r100)).longitude) goto L16;
        if (r111.latitude != ((LatLng) ListProtector.get(r110, r100)).latitude) goto L16;
        return true;
    L16:
        r100 = r100 + 1;
        goto L10
    L17:
        int r101 = r110.size();
        int r102 = 0;
        int r103 = 0;
    L18:
        if (r102 >= r101) goto L36;
        LatLng r104 = (LatLng) ListProtector.get(r110, r102);
        r102 = r102 + 1;
        LatLng r105 = (LatLng) ListProtector.get(r110, r102 % r101);
        double r106 = r104.latitude;
        double r112 = r105.latitude;
        if (r106 != r112) goto L23;
    L21:
        int r113 = r101;
    L34:
        r101 = r113;
        goto L18
    L23:
        if (r111.latitude < Math.min(r106, r112)) goto L21;
        if (r111.latitude >= Math.max(r104.latitude, r105.latitude)) goto L21;
        double r107 = r111.latitude;
        double r114 = r104.latitude;
        double r115 = r105.longitude;
        r113 = r101;
        double r108 = r104.longitude;
        double r109 = (((r107 - r114) * (r115 - r108)) / (r105.latitude - r114)) + r108;
        double r116 = r111.longitude;
        if (r109 == r116) goto L30;
        if (r109 >= r116) goto L34;
        r103 = r103 + 1;
        goto L34
    L30:
        return true;
    L36:
        if ((r103 % 2) != 1) goto L38;
        return true;
    L38:
        return false;
    L53:
        return false;
    L52:
        return false;
    }

    private static LatLng a(LatLng r110, LatLng r111, LatLng r112) {
        GeoPoint r113 = CoordUtil.ll2mc(r110);
        GeoPoint r114 = CoordUtil.ll2mc(r111);
        GeoPoint r115 = CoordUtil.ll2mc(r112);
        double r100 = Math.sqrt(((r114.getLongitudeE6() - r113.getLongitudeE6()) * (r114.getLongitudeE6() - r113.getLongitudeE6())) + ((r114.getLatitudeE6() - r113.getLatitudeE6()) * (r114.getLatitudeE6() - r113.getLatitudeE6())));
        double r101 = (((r114.getLongitudeE6() - r113.getLongitudeE6()) * (r115.getLongitudeE6() - r113.getLongitudeE6())) + ((r114.getLatitudeE6() - r113.getLatitudeE6()) * (r115.getLatitudeE6() - r113.getLatitudeE6()))) / (r100 * r100);
        double r102 = r113.getLongitudeE6() + ((r114.getLongitudeE6() - r113.getLongitudeE6()) * r101);
        return CoordUtil.mc2ll(new GeoPoint(r113.getLatitudeE6() + ((r114.getLatitudeE6() - r113.getLatitudeE6()) * r101), r102));
    }

    public static boolean isCircleContainsPoint(LatLng r100, int r101, LatLng r102) {
        if (r100 == null) goto L12;
        if (r101 == 0) goto L12;
        if (r102 == null) goto L12;
        if (DistanceUtil.getDistance(r100, r102) <= r101) goto L10;
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private static Point a(double r110, double r210, double r211, double r212, double r213, double r214) {
        double r100 = r213 - r211;
        double r111 = r214 - r212;
        double r112 = ((r110 - r211) * r100) + ((r210 - r212) * r111);
        if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r113 = (r100 * r100) + (r111 * r111);
        if (r112 >= r113) goto L9;
        double r114 = r112 / r113;
        return new Point(r211 + (r100 * r114), r212 + (r111 * r114));
    L9:
        return new Point(r213, r214);
    L5:
        return new Point(r211, r212);
    }
}
