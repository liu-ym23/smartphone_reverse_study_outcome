package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CoordinateUtilEx {
    public CoordinateUtilEx() {
    }

    public static ComplexPt getGeoComplexPointFromString(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == false) goto L7;
        return null;
    L7:
        return CoordinateUtil.geoStringToComplexPt(r100);
    }

    public static ComplexPt getGeoComplexPtBoundFromString(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == false) goto L7;
        return null;
    L7:
        return CoordinateUtil.geoStringToComplexPtBound(r100);
    }

    public static Point getGeoPointFromString(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == false) goto L7;
        return null;
    L7:
        return CoordinateUtil.geoStringToPoint(r100);
    }

    public static String getStringFromGeoPoint(Point r100) {
        return CoordinateUtil.pointToGeoString(r100);
    }

    public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> r110, String r111) {
        String r100 = r111;
        Point r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.equals("") == false) goto L9;
        r100 = CoordinateType.BD09LL;
    L9:
        if (r100.equals(CoordinateType.BD09LL) == false) goto L11;
    L17:
        int r102 = r110.size();
        float[] r103 = new float[r102];
        float[] r104 = new float[r110.size()];
        int r112 = 0;
    L19:
        if (r112 >= r110.size()) goto L21;
        r103[r112] = ((Point) ListProtector.get(r110, r112)).getIntX() / 100000.0f;
        r104[r112] = ((Point) ListProtector.get(r110, r112)).getIntY() / 100000.0f;
        r112 = r112 + 1;
        goto L19
    L21:
        ArrayList<Point> r105 = new ArrayList();
        int r113 = 0;
    L22:
        if (r113 >= r102) goto L52;
        byte r114 = -1;
        switch(r100.hashCode()) {
            case -1395470197: goto L39;
            case -1395470175: goto L35;
            case 98175376: goto L31;
            case 113079775: goto L27;
            default: goto L42;
        };
    L42:
        switch(r114) {
            case 0: goto L48;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L44;
            default: goto L43;
        };
    L43:
        Point r115 = r101;
    L49:
        if (r115 == null) goto L51;
        r105.add(r115);
    L51:
        r113 = r113 + 1;
        r102 = r102;
        r101 = null;
        goto L22
    L44:
        r115 = CoordinateUtil.wgs84Tobd09mc(r103[r113], r104[r113]);
        goto L49
    L45:
        r115 = CoordinateUtil.gcj02Tobd09mc(r103[r113], r104[r113]);
        goto L49
    L47:
        r115 = new Point(r103[r113], r104[r113]);
        goto L49
    L48:
        r115 = CoordinateUtil.bd09llTobd09mc(r103[r113], r104[r113]);
        goto L49
    L27:
        if (r100.equals("wgs84") == false) goto L42;
        r114 = 3;
        goto L42
    L31:
        if (r100.equals("gcj02") == false) goto L42;
        r114 = 2;
        goto L42
    L35:
        if (r100.equals(CoordinateType.BD09MC) == false) goto L42;
        r114 = 1;
        goto L42
    L39:
        if (r100.equals(CoordinateType.BD09LL) == false) goto L42;
        r114 = 0;
        goto L42
    L52:
        return r105;
    L11:
        if (r100.equals(CoordinateType.BD09MC) == true) goto L17;
        if (r100.equals("gcj02") == true) goto L17;
        if (r100.equals("wgs84") == true) goto L17;
        return null;
    }

    public static double getDistanceByMc(GeoPoint r100, GeoPoint r101) {
        return CoordinateUtil.getDistanceByMc(r100.getLongitude(), r100.getLatitude(), r101.getLongitude(), r101.getLatitude());
    }

    public static double getDistanceByMc(Point r100, Point r101) {
        return CoordinateUtil.getDistanceByMc(r100.getDoubleX(), r100.getDoubleY(), r101.getDoubleX(), r101.getDoubleY());
    }

    public static Point Coordinate_encryptEx(float r100, float r101, String r102) {
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.equals("") == false) goto L8;
        r102 = CoordinateType.BD09LL;
    L8:
        byte r103 = -1;
        switch(r102.hashCode()) {
            case -1395470197: goto L24;
            case -1395470175: goto L20;
            case 98175376: goto L16;
            case 113079775: goto L12;
            default: goto L27;
        };
    L27:
        switch(r103) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            default: goto L28;
        };
    L28:
        return null;
    L30:
        return CoordinateUtil.wgs84Tobd09mc(r100, r101);
    L32:
        return CoordinateUtil.gcj02Tobd09mc(r100, r101);
    L34:
        return new Point(r100, r101);
    L36:
        return CoordinateUtil.bd09llTobd09mc(r100, r101);
    L12:
        if (r102.equals("wgs84") == false) goto L27;
        r103 = 3;
        goto L27
    L16:
        if (r102.equals("gcj02") == false) goto L27;
        r103 = 2;
        goto L27
    L20:
        if (r102.equals(CoordinateType.BD09MC) == false) goto L27;
        r103 = 1;
        goto L27
    L24:
        if (r102.equals(CoordinateType.BD09LL) == false) goto L27;
        r103 = 0;
        goto L27
    }

    public static Point getIntermediatePointByMC(GeoPoint r110, GeoPoint r111, double r112) {
        return CoordinateUtil.getIntermediatePointByMC(r110.getLongitude(), r110.getLatitude(), r111.getLongitude(), r111.getLatitude(), r112);
    }

    public static Point getIntermediatePointByMC(Point r110, Point r111, double r112) {
        return CoordinateUtil.getIntermediatePointByMC(r110.getDoubleX(), r110.getDoubleY(), r111.getDoubleX(), r111.getDoubleY(), r112);
    }
}
