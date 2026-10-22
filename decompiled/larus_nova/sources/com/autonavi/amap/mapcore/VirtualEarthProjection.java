package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* JADX INFO: loaded from: classes39.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    private static double degToRad(double r100) {
        return r100 * 0.017453292519943295d;
    }

    private static double radToDeg(double r100) {
        return r100 * 57.29577951308232d;
    }

    public VirtualEarthProjection() {
    }

    public static double clip(double r100, double r101, double r102) {
        return Math.min(Math.max(r100, r101), r102);
    }

    public static Point latLongToPixels(int r100, int r101, int r102) {
        return latLongToPixels(((double) r101) / 3600000.0d, ((double) r100) / 3600000.0d, r102);
    }

    public static DPoint latLongToPixelsDouble(double r100, double r101, int r110) {
        DPoint r111 = new DPoint();
        double r102 = clip(r100, -85.0511287798d, 85.0511287798d);
        double r103 = degToRad(clip(r101, -360.0d, 360.0d)) * 6378137.0d;
        double r104 = Math.sin(degToRad(r102));
        double r105 = (Math.log((r104 + 1.0d) / (1.0d - r104)) * 6378137.0d) / 2.0d;
        double r106 = (r103 + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double r107 = (K_EARTH_CIRCLE_2 - r105) / 0.14929106831550598d;
        r111.f30021x = r106;
        r111.f30022y = r107;
        return r111;
    }

    public static DPoint pixelsToLatLong(long r100, long r101, int r102) {
        DPoint r103 = DPoint.obtain();
        double r104 = (r100 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double r105 = K_EARTH_CIRCLE_2 - (r101 * 0.14929106831550598d);
        r103.f30021x = radToDeg(r104 / 6378137.0d);
        double r106 = Math.exp((r105 / 6378137.0d) * 2.0d);
        r103.f30022y = radToDeg(Math.asin((r106 - 1.0d) / (r106 + 1.0d)));
        return r103;
    }

    public static Point latLongToPixels(double r100, double r101, int r110) {
        Point r102 = new Point();
        latLongToPixels(r100, r101, r110, r102);
        return r102;
    }

    public static DPoint pixelsToLatLong(double r100, double r101, int r102) {
        DPoint r103 = DPoint.obtain();
        double r104 = (r100 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double r105 = K_EARTH_CIRCLE_2 - (r101 * 0.14929106831550598d);
        r103.f30021x = radToDeg(r104 / 6378137.0d);
        double r106 = Math.exp((r105 / 6378137.0d) * 2.0d);
        r103.f30022y = radToDeg(Math.asin((r106 - 1.0d) / (r106 + 1.0d)));
        return r103;
    }

    public static void latLongToPixels(double r100, double r101, int r110, Point r111) {
        double r102 = clip(r100, -85.0511287798d, 85.0511287798d);
        double r103 = degToRad(clip(r101, -360.0d, 360.0d)) * 6378137.0d;
        double r104 = Math.sin(degToRad(r102));
        double r105 = (Math.log((r104 + 1.0d) / (1.0d - r104)) * 6378137.0d) / 2.0d;
        double r106 = (r103 + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double r107 = (K_EARTH_CIRCLE_2 - r105) / 0.14929106831550598d;
        r111.x = (int) r106;
        r111.y = (int) r107;
    }
}
