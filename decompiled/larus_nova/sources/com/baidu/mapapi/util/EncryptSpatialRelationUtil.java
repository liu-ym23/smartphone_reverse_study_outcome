package com.baidu.mapapi.util;

import android.text.TextUtils;
import com.baidu.mapapi.map.EncodePointType;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class EncryptSpatialRelationUtil {
    public EncryptSpatialRelationUtil() {
    }

    private static boolean a(LatLng r110, String r111, EncodePointType r112) {
        if (r112 != null) goto L5;
        return false;
    L5:
        int r100 = r112.ordinal();
        ArrayList<LatLng> r101 = g.a().a(r111, r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.size() == 0) goto L55;
        if (r110 == null) goto L56;
        int r102 = 0;
    L13:
        if (r102 >= r101.size()) goto L20;
        if (r110.longitude != ((LatLng) ListProtector.get(r101, r102)).longitude) goto L19;
        if (r110.latitude != ((LatLng) ListProtector.get(r101, r102)).latitude) goto L19;
        return true;
    L19:
        r102 = r102 + 1;
        goto L13
    L20:
        int r103 = r101.size();
        int r104 = 0;
        int r105 = 0;
    L21:
        if (r104 >= r103) goto L39;
        LatLng r106 = (LatLng) ListProtector.get(r101, r104);
        r104 = r104 + 1;
        LatLng r107 = (LatLng) ListProtector.get(r101, r104 % r103);
        double r108 = r106.latitude;
        double r113 = r107.latitude;
        if (r108 != r113) goto L26;
    L24:
        ArrayList<LatLng> r114 = r101;
    L37:
        r101 = r114;
        goto L21
    L26:
        if (r110.latitude < Math.min(r108, r113)) goto L24;
        if (r110.latitude >= Math.max(r106.latitude, r107.latitude)) goto L24;
        double r109 = r110.latitude;
        double r115 = r106.latitude;
        double r116 = r107.longitude;
        r114 = r101;
        double r117 = r106.longitude;
        double r118 = (((r109 - r115) * (r116 - r117)) / (r107.latitude - r115)) + r117;
        double r119 = r110.longitude;
        if (r118 == r119) goto L33;
        if (r118 >= r119) goto L37;
        r105 = r105 + 1;
        goto L37
    L33:
        return true;
    L39:
        if ((r105 % 2) != 1) goto L41;
        return true;
    L41:
        return false;
    L56:
        return false;
    L55:
        return false;
    }

    public static boolean isEncodedGeoPointsContainsPoint(LatLng r100, String r101, EncodePointType r102) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r102 != null) goto L8;
        return false;
    L8:
        return a(r100, r101, r102);
    L11:
        return false;
    }
}
