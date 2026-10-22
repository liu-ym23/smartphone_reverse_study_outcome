package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static void a() {
        JNITools.initClass(new Bundle(), 0);
    }

    public static String b() {
        return JNITools.GetToken();
    }

    public static ComplexPt a(String r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.equals("") == true) goto L41;
        Bundle r100 = new Bundle();
        r100.putString("strkey", r110);
        JNITools.TransGeoStr2ComplexPt(r100);
        ComplexPt r111 = new ComplexPt();
        Bundle r101 = r100.getBundle("map_bound");
        if (r101 == null) goto L14;
        Bundle r102 = r101.getBundle("ll");
        if (r102 == null) goto L11;
        r111.mLL = new Point((int) r102.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r102.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L11:
        Bundle r103 = r101.getBundle("ru");
        if (r103 == null) goto L14;
        r111.mRu = new Point((int) r103.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r103.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
    L14:
        ParcelItem[] r104 = (ParcelItem[]) r100.getParcelableArray("poly_line");
        int r105 = 0;
    L16:
        if (r105 >= r104.length) goto L31;
        if (r111.mGeoPt != null) goto L20;
        r111.mGeoPt = new ArrayList();
    L20:
        Bundle r106 = r104[r105].getBundle();
        if (r106 == null) goto L30;
        ParcelItem[] r107 = (ParcelItem[]) r106.getParcelableArray("point_array");
        ArrayList<Point> r108 = new ArrayList();
        int r109 = 0;
    L24:
        if (r109 >= r107.length) goto L29;
        Bundle r112 = r107[r109].getBundle();
        if (r112 == null) goto L28;
        r108.add(new Point((int) r112.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) r112.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY)));
    L28:
        r109 = r109 + 1;
        goto L24
    L29:
        r108.trimToSize();
        r111.mGeoPt.add(r108);
    L30:
        r105 = r105 + 1;
        goto L16
    L31:
        r111.mGeoPt.trimToSize();
        r111.eType = (int) r100.getDouble("type");
        return r111;
    L41:
        return null;
    }

    public static double a(Point r100, Point r101) {
        Bundle r102 = new Bundle();
        r102.putDouble("x1", r100.doubleX);
        r102.putDouble("y1", r100.doubleY);
        r102.putDouble("x2", r101.doubleX);
        r102.putDouble("y2", r101.doubleY);
        JNITools.GetDistanceByMC(r102);
        return r102.getDouble("distance");
    }

    public static void a(boolean r100, int r101) {
        JNITools.openLogEnable(r100, r101);
    }
}
