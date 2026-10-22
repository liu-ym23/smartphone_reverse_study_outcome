package com.baidu.platform.comapi.location;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CoordinateUtil {
    public static native Point bd09llTobd09mc(double r100, double r101);

    public static native Point bd09llTogcj02ll(double r100, double r101);

    public static native Point bd09mcTobd09ll(double r100, double r101);

    public static native Point gcj02Tobd09ll(double r100, double r101);

    public static native double getDistanceByMc(double r100, double r101, double r102, double r103);

    public static native Point getIntermediatePointByMC(double r100, double r101, double r102, double r103, double r104);

    private static native Point nativeComplexPtToPoint(String r100);

    private static native boolean nativeGeoStringToComplexPt(String r100, Bundle r101);

    private static native boolean nativeGeoStringToComplexPtBound(String r100, Bundle r101);

    private static native Point nativeGeoStringToPoint(String r100);

    private static native String nativePointToGeoString(double r100, double r101);

    public static native Point wgs84Togcj02(double r100, double r101);

    public CoordinateUtil() {
    }

    public static Point complexPtToPoint(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == false) goto L7;
        return null;
    L7:
        return nativeComplexPtToPoint(r100);
    }

    public static ComplexPt geoStringToComplexPt(String r110) {
        if (r110 != null) goto L5;
    L35:
        return null;
    L5:
        if (r110.equals("") == true) goto L35;
        Bundle r100 = new Bundle();
        if (nativeGeoStringToComplexPt(r110, r100) == false) goto L35;
        ComplexPt r111 = new ComplexPt();
        Bundle r101 = r100.getBundle("map_bound");
        if (r101 == null) goto L17;
        Bundle r102 = r101.getBundle("ll");
        if (r102 == null) goto L14;
        r111.mLL = new Point((int) r102.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r102.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L14:
        Bundle r103 = r101.getBundle("ru");
        if (r103 == null) goto L17;
        r111.mRu = new Point((int) r103.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r103.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L17:
        ParcelItem[] r104 = (ParcelItem[]) r100.getParcelableArray("poly_line");
        int r105 = r104.length;
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L33;
        ParcelItem r107 = r104[r106];
        if (r111.mGeoPt != null) goto L22;
        r111.mGeoPt = new ArrayList();
    L22:
        Bundle r108 = r107.getBundle();
        if (r108 == null) goto L32;
        ParcelItem[] r109 = (ParcelItem[]) r108.getParcelableArray("point_array");
        ArrayList<Point> r112 = new ArrayList();
        int r113 = 0;
    L26:
        if (r113 >= r109.length) goto L31;
        Bundle r114 = r109[r113].getBundle();
        if (r114 == null) goto L30;
        r112.add(new Point((int) r114.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r114.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY)));
    L30:
        r113 = r113 + 1;
        goto L26
    L31:
        r112.trimToSize();
        r111.mGeoPt.add(r112);
    L32:
        r106 = r106 + 1;
        goto L18
    L33:
        r111.mGeoPt.trimToSize();
        r111.eType = (int) r100.getDouble("type");
        return r111;
    }

    public static ComplexPt geoStringToComplexPtBound(String r100) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (r100.equals("") == true) goto L19;
        Bundle r101 = new Bundle();
        if (nativeGeoStringToComplexPtBound(r100, r101) == false) goto L19;
        ComplexPt r102 = new ComplexPt();
        Bundle r103 = r101.getBundle("map_bound");
        if (r103 == null) goto L17;
        Bundle r104 = r103.getBundle("ll");
        if (r104 == null) goto L14;
        r102.mLL = new Point((int) r104.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r104.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L14:
        Bundle r105 = r103.getBundle("ru");
        if (r105 == null) goto L17;
        r102.mRu = new Point((int) r105.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r105.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L17:
        r102.eType = (int) r101.getDouble("type");
        return r102;
    }

    public static Point geoStringToPoint(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.equals("") == false) goto L7;
        return null;
    L7:
        return nativeGeoStringToPoint(r100);
    }

    public static String pointToGeoString(Point r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return nativePointToGeoString(r100.getDoubleX(), r100.getDoubleY());
    }

    public static Point bd09mcTogcj02ll(double r100, double r101) {
        Point r102 = bd09mcTobd09ll(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return bd09llTogcj02ll(r102.getDoubleX(), r102.getDoubleY());
    }

    public static Point gcj02Tobd09mc(double r100, double r101) {
        Point r102 = gcj02Tobd09ll(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return bd09llTobd09mc(r102.getDoubleX(), r102.getDoubleY());
    }

    public static Point wgs84Tobd09ll(double r100, double r101) {
        Point r102 = wgs84Togcj02(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return gcj02Tobd09ll(r102.getDoubleX(), r102.getDoubleY());
    }

    public static Point wgs84Tobd09mc(double r100, double r101) {
        Point r102 = wgs84Togcj02(r100, r101);
        if (r102 == null) goto L8;
        Point r103 = gcj02Tobd09ll(r102.getDoubleX(), r102.getDoubleY());
        if (r103 != null) goto L7;
        return null;
    L7:
        return bd09llTobd09mc(r103.getDoubleX(), r103.getDoubleY());
    L8:
        return null;
    }
}
