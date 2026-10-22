package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* JADX INFO: loaded from: classes39.dex */
public final class MapStatusUpdateFactory {
    public static MapStatusUpdate zoomIn() {
        MapStatusUpdate r100 = new MapStatusUpdate(6);
        r100.f31051k = 1.0f;
        return r100;
    }

    public static MapStatusUpdate zoomOut() {
        MapStatusUpdate r100 = new MapStatusUpdate(6);
        r100.f31051k = -1.0f;
        return r100;
    }

    public MapStatusUpdateFactory() {
    }

    public static MapStatusUpdate newLatLng(LatLng r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r101 = new MapStatusUpdate(2);
        r101.f31044d = r100;
        return r101;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r101 = new MapStatusUpdate(3);
        r101.f31045e = r100;
        return r101;
    }

    public static MapStatusUpdate newMapStatus(MapStatus r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r101 = new MapStatusUpdate(1);
        r101.f31043c = r100;
        return r101;
    }

    public static MapStatusUpdate zoomBy(float r100) {
        MapStatusUpdate r101 = new MapStatusUpdate(6);
        r101.f31051k = r100;
        return r101;
    }

    public static MapStatusUpdate zoomTo(float r100) {
        MapStatusUpdate r101 = new MapStatusUpdate(8);
        r101.f31048h = r100;
        return r101;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng r100, float r101) {
        MapStatusUpdate r102 = new MapStatusUpdate(4);
        if (r100 != null) goto L6;
        return null;
    L6:
        r102.f31044d = r100;
        r102.f31048h = r101;
        return r102;
    }

    public static MapStatusUpdate scrollBy(int r100, int r101) {
        MapStatusUpdate r102 = new MapStatusUpdate(5);
        r102.f31049i = r100;
        r102.f31050j = r101;
        return r102;
    }

    public static MapStatusUpdate zoomBy(float r100, Point r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r102 = new MapStatusUpdate(7);
        r102.f31051k = r100;
        r102.f31052l = r101;
        return r102;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds r100, int r101, int r102) {
        if (r100 == null) goto L8;
        if (r101 <= 0) goto L10;
        if (r102 <= 0) goto L11;
        MapStatusUpdate r103 = new MapStatusUpdate(9);
        r103.f31045e = r100;
        r103.f31046f = r101;
        r103.f31047g = r102;
        return r103;
    L11:
        return null;
    L10:
        return null;
    L8:
        return null;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds r100, int r101, int r102, int r103, int r104) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r105 = new MapStatusUpdate(10);
        r105.f31045e = r100;
        r105.f31053m = r101;
        r105.f31054n = r102;
        r105.f31055o = r103;
        r105.f31056p = r104;
        return r105;
    }

    public static MapStatusUpdate newLatLngZoom(LatLngBounds r100, int r101, int r102, int r103, int r104) {
        if (r100 != null) goto L5;
        return null;
    L5:
        MapStatusUpdate r105 = new MapStatusUpdate(11);
        r105.f31045e = r100;
        r105.f31053m = r101;
        r105.f31054n = r102;
        r105.f31055o = r103;
        r105.f31056p = r104;
        return r105;
    }
}
