package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* JADX INFO: loaded from: classes39.dex */
public class MapProjection {
    public MapProjection() {
    }

    public static void geo2LonLat(int r100, int r101, DPoint r102) {
        DPoint r103 = VirtualEarthProjection.pixelsToLatLong(r100, r101, 20);
        r102.f30021x = r103.f30021x;
        r102.f30022y = r103.f30022y;
        r103.recycle();
    }

    public static void lonlat2Geo(double r100, double r101, IPoint r102) {
        Point r103 = VirtualEarthProjection.latLongToPixels(r101, r100, 20);
        ((Point) r102).x = r103.x;
        ((Point) r102).y = r103.y;
    }
}
